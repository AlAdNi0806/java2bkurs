package org.example.eight.b;

public class Main {
    public static void main(String[] args) {
        // Create the Receiver object
        Receiver client = new Client();

        // Create the ConcreteCommand object and pass the Receiver object to it
        Command command = new ConcreteCommand(client);

        // Create the Invoker object and set the ConcreteCommand object
        Invoker invoker = new Invoker();
        invoker.setCommand(command);

        // Execute the command using the Invoker object
        invoker.executeCommand();
    }
}