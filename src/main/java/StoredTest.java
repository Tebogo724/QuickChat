/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tmafi
 */
import java.util.ArrayList;

public class StoredTest {

    public static void main(String[] args) {

        ArrayList<Message> storageForMessages = new ArrayList<>();
        ArrayList<Message> savedMessages = new ArrayList<>();
        ArrayList<Message> disregardedMessages = new ArrayList<>();

        int numMessageSent = 0;


        // MESSAGE 1 
        String text1 = "Did you get the cake?";
        String psn1 = "+27834557896";

        long id1 = (long) (Math.random() * 9000000000L) + 1000000000L;
        numMessageSent++;

        String hash1 = String.valueOf(id1).substring(0, 2) + ":" + numMessageSent + ":CAKE";

        Message m1 = new Message(id1, psn1, text1, hash1, numMessageSent);
        storageForMessages.add(m1);

        System.out.println("Message 1 SENT: " + m1.messageInput);

        
        // MESSAGE 2 (STORED)
        
        String text2 = "Where are you? You are late! I have asked you to be on time.";
        String psn2 = "+27838884567";

        long id2 = (long) (Math.random() * 9000000000L) + 1000000000L;
        numMessageSent++;

        String hash2 = String.valueOf(id2).substring(0, 2) + ":" + numMessageSent + ":TIME";

        Message m2 = new Message(id2, psn2, text2, hash2, numMessageSent);
        savedMessages.add(m2);

        System.out.println("Message 2 STORED: " + m2.messageInput);

        
        // MESSAGE 3 (DISREGARD)
        
        String text3 = "Yohoooo, I am at your gate.";
        String psn3 = "+27834484567";

        long id3 = (long) (Math.random() * 9000000000L) + 1000000000L;
        numMessageSent++;

        String hash3 = String.valueOf(id3).substring(0, 2) + ":" + numMessageSent + ":GATE";

        Message m3 = new Message(id3, psn3, text3, hash3, numMessageSent);
        disregardedMessages.add(m3);

        System.out.println("Message 3 DISREGARDED: " + m3.messageInput);

        // MESSAGE 4 (SENT)
     
        String text4 = "It is dinner time!";
        String psn4 = "0838884567";

        long id4 = (long) (Math.random() * 9000000000L) + 1000000000L;
        numMessageSent++;

        String hash4 = String.valueOf(id4).substring(0, 2) + ":" + numMessageSent + ":DINNER";

        Message m4 = new Message(id4, psn4, text4, hash4, numMessageSent);
        storageForMessages.add(m4);

        System.out.println("Message 4 SENT: " + m4.messageInput);

        // MESSAGE 5 (STORED)
        
        String msg5 = "OK, I am leaving without you.";
        String rec5 = "+27838884567";

        long id5 = (long) (Math.random() * 9000000000L) + 1000000000L;
        numMessageSent++;

 
    }
}