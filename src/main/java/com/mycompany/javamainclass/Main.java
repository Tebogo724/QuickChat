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
        
      //Part 3
        ArrayList<Message> sentOutMessages = new ArrayList<>();
        ArrayList<Message> disregardedMessages = new ArrayList<>();
        ArrayList<Message> savedMessages = new ArrayList<>();
        ArrayList<Long> messageID = new ArrayList<>();
        ArrayList<String> messageListHash= new ArrayList<>();
        
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

            System.out.println("Welcome to QuickChat");

            // Part 2
            System.out.println("How many messages would you like to send?");
            int numberOfMessages = input.nextInt();

            boolean working = true;

            // Using while loop so the prompts keep showing until user quits
            while (working) {

                System.out.println("Menu");
                System.out.println("1. Send messages");
                System.out.println("2. Show recently sent messages");
                System.out.println("3. Quit");
                
//Allows the user to have the option access or see the saved messages on the menu
                System.out.println("4. Stored Messages");

                int userOption = input.nextInt();
                input.nextLine();

                switch (userOption) {

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
                                 
                                  switch (messageChoice) {

                                    case 1 -> {
                                        Message msg = new Message(uniqueMessage, numberOfRecipient, messageEntered, hash, numMessageSent);
                                        storageForMessages.add(msg);
                                        
 //Adding the different ways one can look for messages using either the Hash or message ID or in the sent messages
                                        messageID.add(uniqueMessage);
                                        messageListHash.add(hash);
                                    }
                                
                                    case 2 -> {
                                        System.out.println("Message discarded");
                                        
// To still find the discarded messages using the messageID or Hash, even if the message is discarded one can still get some sort of evidence that it was there before
                                        disregardedMessages.add(new Message(uniqueMessage, numberOfRecipient, messageEntered, hash, numMessageSent));
                                        messageID.add(uniqueMessage);
                                        messageListHash.add(hash);
                                    }
    
                                    case 3 -> {
                                        Message msg = new Message(uniqueMessage, numberOfRecipient, messageEntered, hash, numMessageSent);
                                        storageForMessages.add(msg);
                                        saveMessagesToJSON(storageForMessages);
                                        
 //Adds messages that are saved to JSON and one can look for it using the message ID and Hash
                                        savedMessages.add(msg);
                                        messageID.add(uniqueMessage);
                                        messageListHash.add(hash);
                                    }

                                    default -> System.out.println("Invalid option");
                                  
                                }
                            }
                        }
                        
                    }
                                 
//Contains options of what can be done within the saved messages 
                                    case 2 -> {
                                          System.out.println("Stored Messages");

                                     if (savedMessages.isEmpty()) {
                                         System.out.println("No messages");
                                    } else {

                                         System.out.println("a:Display sender and recipient of stored messages");
                                         System.out.println("b:Display longest stored message");
                                         System.out.println("c:Search by message ID");
                                         System.out.println("d:Search by recipient");
                                         System.out.println("e:Delete using message hash");
                                         System.out.println("f:Display report");

                                           int inputFromUser = input.nextInt();
                                         input.nextLine();
//Shows the user that sent the messages and whoever the message was sent to
                               switch (inputFromUser) {

                                    case 1 -> {
                                    for (Message m : savedMessages) {
                                         System.out.println("Sender: " + username);
                                         System.out.println("Recipient: " + m.receiver);
                                    }
                               }
                           // Allows for user to find the longest message in the conversations 
                                    case 2 -> {
                                          Message longest = savedMessages.get(0);

                                    for (Message t: savedMessages) {
                                     if (t.messageInput.length() > longest.messageInput.length()) {
                                         longest = t;
                                       }
                                   }
                                         System.out.println("Longest message: " + longest.messageInput);
                                        }
                                    
//Looks for the messageID the user wants (used variable t for texts)
                                    case 3 -> {
                                         System.out.print("Enter message ID: ");
                                         long id = input.nextLong();
                                         input.nextLine();

                                    for (Message t : savedMessages) {
                                     if (t.uniqueMessage == id) {
                                         System.out.println("Recipient: " + t.receiver);
                                         System.out.println("Message: " + t.messageInput);
                                        }
                                   }
                                }
//Looks for the message sent by the reciever one is looking for
                                    case 4 -> {
                                         System.out.print("Enter recipient: ");
                                         String rec = input.nextLine();

                                    for (Message t: savedMessages) {
                                     if (t.receiver.equals(rec)) {
                                         System.out.println(t.messageInput);
                                       }
                                    }
                                }
//Allows for a message to be deleted using the message hash entered
                                    case 5 -> {
                                         System.out.print("Enter message hash: ");
                                         String hash = input.nextLine();

                                         savedMessages.removeIf(m -> m.hash.equals(hash));
                                         System.out.println("Message deleted found");
                                        }
//We are getting a display of all the saved messages
                                    case 6 -> {
                                    for (Message m : savedMessages) {
                                        System.out.println(m.printMessages());
                                   }
                               }

                                        default -> System.out.println("Invalid option");
                               }
                                     }
                                    }
             
                               // CASE 3: QUIT 
                    case 3 -> {
                        saveMessagesToJSON(storageForMessages);
                        System.out.println("Quit");
                        working = false;
                    }

                    default -> System.out.println("Invalid Option, choose 1, 2 or 3");
                }
            }
        }
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








