package com.example.prak12;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class FileHasher {

    private final String inputFile = "C:/MIREA/JAVA/JAVA4sem/prak12/test1.txt";
    private final String outputFile = "C:/MIREA/JAVA/JAVA4sem/prak12/test2.txt";

    @PostConstruct
    public void init() {
        try {
            hashFile(inputFile, outputFile);
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void cleanup() {
        File file = new File(inputFile);
        if (file.exists()) {
            file.delete();
        }
    }

    private void hashFile(String inputFilePath, String outputFilePath) throws IOException, NoSuchAlgorithmException {
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);

        if (!inputFile.exists()) {
            // Если первый файл отсутствует, создаем второй файл и записываем строку null
            outputFile.createNewFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                writer.write("null");
            }
            return;
        }

        // Хешируем данные из первого файла и записываем во второй файл
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            while ((line = reader.readLine()) != null) {
                byte[] hashBytes = digest.digest(line.getBytes(StandardCharsets.UTF_8));
                StringBuilder hashHex = new StringBuilder();
                for (byte b : hashBytes) {
                    hashHex.append(String.format("%02x", b));
                }
                writer.write(hashHex.toString());
                writer.newLine();
            }
        }
    }
}
