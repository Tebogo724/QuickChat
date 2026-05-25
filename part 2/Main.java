/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javamainclass;

/**
 *
 * @author tmafi
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Message> storageForMessages = new ArrayList<>();
        String username;
        int numMessageSent = 0;

        // What the user will be seeing on the screen
        System.out.print("Enter username: ");
        username = input.nextLine();

        // Conditions
        boolean isLengthLongEnough = false;
        boolean hasSpecialCharacter = false;

        // The username specifications
        isLengthLongEnough = username.length() >= 5;

        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);

            if (c == '_') {
                hasSpecialCharacter = true;
            }
        }

        // Output the user will receive in response to the username they enter
        if (isLengthLongEnough && hasSpecialCharacter) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
        }

        // Password code
        System.out.println("Enter password: ");
        String password = input.nextLine();

        // Flags
        boolean isLengthEight = false;
        boolean hasDigit = false;
        boolean hasCapitalLetter = false;
        boolean hasUniqueSymbol = false;

        isLengthEight = password.length() >= 8;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isDigit(c)) {
                hasDigit = true;
            }

            if (Character.isUpperCase(c)) {
                hasCapitalLetter = true;
            }

            if (!Character.isLetterOrDigit(c)) {
                hasUniqueSymbol = true;
            }
        }

        // The final result once a password is entered
        if (isLengthEight && hasDigit && hasCapitalLetter && hasUniqueSymbol) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }

        // Cell phone code
        System.out.print("Enter cell phone number: +27");
        String number = input.nextLine();

        boolean isDigit = true;
        boolean isLengthAccurate = number.length() == 12;
        boolean hasSaCode = number.startsWith("+27");

        for (int i = 1; i < number.length(); i++) {
            char ch = number.charAt(i);

            if (!Character.isDigit(ch)) {
                isDigit = false;
            }
        }

        if (isDigit && isLengthAccurate && hasSaCode) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
        }

        // Login
        System.out.print("Enter your username: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter your password: ");
        String loginPassword = input.nextLine();

        // The message the user will get once they attempt to login confirming the status
        if (loginUsername.equals(username) && loginPassword.equals(password)) {

//_________________________________________________________________________________________________________________
//________________________________________________________________________________________________________________-
            // Part 2
             System.out.println("Welcome to QuickChat");
            System.out.println("How many messages would you like to send?");
            int numberOfMessages = input.nextInt();

            boolean working = true;
            
//_______________________________________________________________________________________________________            
//_______________________________________________________________________________________________________________
            // Using while loop so the prompts keep showing until user quits
            while (working) {

                System.out.println("\nMenu");
                System.out.println("1. Send messages");
                System.out.println("2. Show recently sent messages");
                System.out.println("3. Quit");

                int userOption = input.nextInt();
                input.nextLine();

                switch (userOption) {
//__________________________________________________________________________________________________________
//____________________________________________________________________________________________________________________________________
                    // CASE 1: SEND MESSAGE 
                    case 1 -> {
                        System.out.println("Send messages");

                        System.out.println("Enter recipient cell number: ");
                        String numberOfRecipient = input.nextLine();

                        if (!numberOfRecipient.startsWith("+") || numberOfRecipient.length() > 10) {
                            System.out.println("Invalid recipient cell number");
                        } else {

                            System.out.println("Enter message:");
                            String messageEntered = input.nextLine();

                            if (messageEntered.length() > 250) {
                                System.out.println("Please enter a message of less than 250 characters");
                            } else {

                                System.out.println("Message sent");

                                long uniqueMessage = (long) (Math.random() * 9000000000L) + 1000000000L;

                                numMessageSent++;
                                System.out.println("Message ID: " + uniqueMessage);
                                System.out.println("Total messages sent: " + numMessageSent);

                                String idString = String.valueOf(uniqueMessage);
                                String twoFirst = idString.substring(0, 2);

                                String[] words = messageEntered.trim().split(" ");

                                String hash = twoFirst + ":" + numMessageSent + ":"
                                        + words[0].toUpperCase()
                                        + words[words.length - 1].toUpperCase();

                                System.out.println("Message Hash: " + hash);

                                System.out.println("1. Send");
                                System.out.println("2. Discard");
                                System.out.println("3. Store");

                                int messageChoice = input.nextInt();
                                input.nextLine();
//________________________________________________________________________________________________________________________________                                
//_______________________________________________________________________________________________________________________________________________________
                                switch (messageChoice) {

                                    case 1 -> {
                                        Message msg = new Message(uniqueMessage, numberOfRecipient, messageEntered, hash, numMessageSent);
                                        storageForMessages.add(msg);
                                    }

                                    case 2 -> {
                                        System.out.println("Message discarded");
                                    }

                                    case 3 -> {
                                        Message msg = new Message(uniqueMessage, numberOfRecipient, messageEntered, hash, numMessageSent);
                                        storageForMessages.add(msg);
                                        saveMessagesToJSON(storageForMessages);
                                    }

                                    default -> System.out.println("Invalid option");
                                }
                            }
                        }
                    }
    //____________________________________________________________________________________________________                
//_______________________________________________________________________________________________________
                    //CASE 2: SHOW MESSAGES 
                    case 2 -> {
                        System.out.println("Coming soon....");

                        if (storageForMessages.isEmpty()) {
                            System.out.println("No messages have been sent yet");
                        } else {
                            for (Message msg : storageForMessages) {
                                System.out.println("Message ID: " + msg.uniqueMessage);
                                System.out.println("Hash: " + msg.hash);
                                System.out.println("Recipient: " + msg.receiver);
                                System.out.println("Message: " + msg.messageInput);
                            }
                        }
                    }
    //______________________________________________________________________________________________                
//__________________________________________________________________________________________________
                    // CASE 3: QUIT 
                    case 3 -> {
                        saveMessagesToJSON(storageForMessages);
                        System.out.println("Quit");
                        working = false;
                    }

                    default -> System.out.println("Invalid Option, choose 1, 2 or 3");
                }
            }

        } else {
            System.out.println("Username or password incorrect, please try again.");
        }
    }

    // ---------------- JSON FILE CODE ----------------
    public static void saveMessagesToJSON(ArrayList<Message> storageForMessages) {

        try (FileWriter file = new FileWriter("messages.json")) {

            file.write("[\n");

            for (int i = 0; i < storageForMessages.size(); i++) {

                Message msg = storageForMessages.get(i);

                file.write("  {\n");
                file.write("    \"messageID\": \"" + msg.uniqueMessage + "\",\n");
                file.write("    \"messageHash\": \"" + msg.hash + "\",\n");
                file.write("    \"recipient\": \"" + msg.receiver + "\",\n");
                file.write("    \"message\": \"" + msg.messageInput + "\"\n");
                file.write("  }");

                if (i < storageForMessages.size() - 1) {
                    file.write(",");
                }

                file.write("\n");
            }

            file.write("]");

        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }
}

