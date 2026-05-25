/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javamainclass;

import java.util.ArrayList;

/**
 *
 * @author tmafi
 */
public class Test {
  
    public static void main(String[] args) {

        ArrayList<Message> testMessages = new ArrayList<>();
        int numSentMessages = 0;

        // TEST 1 
        System.out.println("TEST CASE 1 - SEND MESSAGE");

        Message msg1 = new Message(
                1000000001L,
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight?",
                "10:1:HI TONIGHT",
                ++numSentMessages
        );

        testMessages.add(msg1);

        System.out.println("Message ID: " + msg1.uniqueMessage);
        System.out.println("Message Hash: " + msg1.hash);
        System.out.println("Recipient: " + msg1.receiver);

        System.out.println("Send Message: " + msg1.sentMessage("1"));
        System.out.println("Total messages sent: " + msg1.returnTotalMessages());


        // TEST 2 
        System.out.println("TEST CASE 2 - DISCARD MESSAGE");

        Message msg2 = new Message(
                1000000002L,
                "08575975889",
                "Hi Keegan, did you receive the payment?",
                "10:2:HI PAYMENT",
                ++numSentMessages
        );

        testMessages.add(msg2);

        System.out.println("Message ID: " + msg2.uniqueMessage);
        System.out.println("Message Hash: " + msg2.hash);
        System.out.println("Recipient: " + msg2.receiver);

        System.out.println("Send Message: " + msg2.sentMessage("2"));
        System.out.println("Total messages sent: " + msg2.returnTotalMessages());


        
        System.out.println("TOTAL TEST MESSAGES: " + testMessages.size());
    }
}
    

