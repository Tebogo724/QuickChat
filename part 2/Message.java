/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javamainclass;

/**
 *
 * @author tmafi
 */
public class Message {

    // Intialising variables
    long uniqueMessage;
    String receiver;
    String messageInput;
    String hash;
    int numOfMessage;

    
    public Message(long uniqueMessage, String receiver, String messageInput, String hash, int numOfMessage) {

        this.uniqueMessage = uniqueMessage;
        this.receiver = receiver;
        this.messageInput = messageInput;
        this.hash = hash;
        this.numOfMessage = numOfMessage;
    }

    // CHECK MESSAGE ID
    public boolean checkMessageID() {

        return String.valueOf(uniqueMessage).length() <= 10;
    }

    //  CHECK RECIPIENT CELL 
    public boolean checkRecipientCell() {

        return receiver != null
                && receiver.startsWith("+")
                && receiver.length() <= 10;
    }

    // CREATE MESSAGE HASH 
    public String createMessageHash() {

        String idString = String.valueOf(uniqueMessage);
        String firstTwo = idString.substring(0, 2);

        String[] words = messageInput.trim().split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return firstTwo + ":" + numOfMessage + ":"
                + firstWord.toUpperCase()
                + lastWord.toUpperCase();
    }

    //  SEND MESSAGE
    public String sentMessage(String choice) {

        if (choice.equals("1")) {
            return "Message sent";
        } else if (choice.equals("2")) {
            return "Message discarded";
        } else if (choice.equals("3")) {
            return "Message stored";
        } else {
            return "Invalid choice";
        }
    }

    // PRINT MESSAGE 
    public String printMessages() {

        return "Message ID: " + uniqueMessage + "\n"
                + "Hash: " + hash + "\n"
                + "Recipient: " + receiver + "\n"
                + "Message: " + messageInput;
    }

    //  TOTAL MESSAGES
    public int returnTotalMessages() {
        return numOfMessage;
    }
    public String savedMessageJSON() {
    return "{\n" +
            "  \"messageID\": \"" + uniqueMessage + "\",\n" +
            "  \"messageHash\": \"" + hash + "\",\n" +
            "  \"recipient\": \"" + receiver + "\",\n" +
            "  \"message\": \"" + messageInput + "\"\n" +
            "}";
    }
}
    

