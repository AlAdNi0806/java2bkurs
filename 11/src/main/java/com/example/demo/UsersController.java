package com.example.demo;

import com.example.demo.model.Users;
import com.example.demo.repo.EventRepo;
import com.example.demo.repo.UsersRepo;
import com.example.demo.types.UserId;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    private UsersRepo usersRepo; // so that you don't have to do the contructon (UserRepo userRepo = new UserRepo())

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // so that you don't have to do the contructon (UserRepo userRepo = new UserRepo())

    @Autowired
    private EventRepo eventRepo; // so that you don't have to do the contructon (UserRepo userRepo = new UserRepo())

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
        // Validate input
        if (user.getFullName() == null || user.getUsername() == null || user.getPassword() == null) {
//            return new ResponseEntity<>("All fields are required", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>("All fields are required", HttpStatus.BAD_REQUEST);

        }

        // Check if user already exists
        if (usersRepo.findByUsername(user.getUsername()).isPresent()) {
            return new ResponseEntity<>("User with this username already exists", HttpStatus.BAD_REQUEST);
        }

        user.setRole("guest");

        // Hash the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user
        Users savedUser = usersRepo.save(user);

        // Generate JWT token
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Generate a secret key
        String jwtToken = Jwts.builder()
                .setSubject(String.valueOf(savedUser.getId())) // Set the subject to the user's ID
                .setIssuedAt(new Date()) // Set the issued at date
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // Set the expiration date (1 hour)
                .signWith(key) // Sign the token
                .compact(); // Generate the token

        try {
            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwtToken);

            Claims claims = jws.getBody();

            String subject = claims.getSubject();
            Date issuedAt = claims.getIssuedAt();
            Date expiration = claims.getExpiration();

            System.out.println("Subject: " + subject);
            System.out.println("Issued At: " + issuedAt);
            System.out.println("Expiration: " + expiration);

        } catch (Exception e) {
            System.err.println("Error decoding JWT token: " + e.getMessage());
        }

        return ResponseEntity.ok(jwtToken);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Users providedUser) {

        if (providedUser.getUsername() == null || providedUser.getPassword() == null) {
            return new ResponseEntity<>("Username and password are required", HttpStatus.BAD_REQUEST);
        }

        Optional<Users> userOptional = usersRepo.findByUsername(providedUser.getUsername());
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        Users user = userOptional.get();

        if (!passwordEncoder.matches(providedUser.getPassword(), user.getPassword())) {
            return new ResponseEntity<>("Invalid password", HttpStatus.UNAUTHORIZED);
        }

        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String jwtToken = Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(key)
                .compact();

        return ResponseEntity.ok(jwtToken);
    }

    @PostMapping("/user-info")
    public ResponseEntity<?> getUserInfo(@RequestBody UserId userId) {
        // Find the user by ID with events
        Optional<Users> userOptional = usersRepo.findById(userId.getId());
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        Users user = userOptional.get();

        // Create a response object to return the user's information
        Map<String, Object> response = new HashMap<>();
        response.put("id", user.getId());
        response.put("fullName", user.getFullName());
        response.put("username", user.getUsername());
        response.put("role", user.getRole());

        response.put("events", eventRepo.findByOwnerId(user.getId()));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/get-user-info")
    public ResponseEntity<?> getUserInformation(@RequestBody Users users) {
        Optional<Users> userOptional = usersRepo.findByUsername(users.getUsername());
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        Users user = userOptional.get();

        // Create a response object to return the user's information
        Map<String, Object> response = new HashMap<>();
        response.put("id", user.getId());
        response.put("fullName", user.getFullName());
        response.put("username", user.getUsername());
        response.put("role", user.getRole());

        response.put("events", eventRepo.findByOwnerId(user.getId()));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/update-user-role")
    public int updateUserRole(@RequestBody Users users) {
        Long id = users.getId();
        String role = users.getRole();
        return usersRepo.updateUserRole(role, id);
    }
}
