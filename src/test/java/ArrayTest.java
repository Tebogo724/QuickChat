/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
package com.mycompany.javamainclass;
/**
 *
 * @author tmafi
 */
public class ArrayTest {
    
    public ArrayTest() {
    }

    @Test
    public void testMessageArray() {

        ArrayList<Message> messages = new ArrayList<>();
// t = text
        Message t1 = new Message(1, "+27834557896", "Did you get the cake?", "hash1", 1);
        Message t2 = new Message(2, "+27838884567", "Where are you? You are late! I have asked you to be on time.", "hash2", 2);
        Message t3 = new Message(3, "+27834484567", "Yohoooo, I am at your gate.", "hash3", 3);
        Message t4 = new Message(4, "0838884567", "It is dinner time!", "hash4", 4);

        messages.add(t1);
        messages.add(t2);
        messages.add(t3);
        messages.add(t4);

        assertEquals(4, messages.size());
    }
    @Test
    public void testMessageLonger() {

         ArrayList<Message> messages = new ArrayList<>();

    messages.add(new Message(1, "+1", "Did you get the cake?", "h1", 1));
    messages.add(new Message(2, "+2", "Where are you? You are late! I have asked you to be on time.", "h2", 2));
    messages.add(new Message(3, "+3", "Yohoooo, I am at your gate.", "h3", 3));
    messages.add(new Message(4, "0838884567", "It is dinner time!", "h4", 4));

    Message longest = messages.get(0);

    for (Message t: messages) {
        if (t.messageInput.length() > longest.messageInput.length()) {
            longest = t;
        }
    }

    assertEquals(
        "Where are you? You are late! I have asked you to be on time.",
        longest.messageInput );
}
    
@Test
public void testUsingMessageIdSearch() {

    ArrayList<Message> messages = new ArrayList<>();

    Message t4 = new Message(4, "0838884567", "It is dinner time!", "h4", 4);
    messages.add(t4);

    Message found = null;

    for (Message m : messages) {
        if (m.uniqueMessage == 4) {
            found = t;
        }
    }

    assertEquals("It is dinner time!", found.messageInput);
}
@Test
public void testUsingRecieverToSearch() {

    ArrayList<Message> messages = new ArrayList<>();

    messages.add(new Message(2, "+27838884567", "Where are you? You are late! I have asked you to be on time.", "h2", 2));
    messages.add(new Message(5, "+27838884567", "OK, I am leaving without you.", "h5", 5));

    ArrayList<String> results = new ArrayList<>();
// c = characters
    for (Message c : messages) {
        if (c.receiver.equals("+27838884567")) {
            results.add(c.messageInput);
        }
    }

    assertEquals(2, results.size());
}
@Test
public void testHashToDelete() {

    ArrayList<Message> messages = new ArrayList<>();

    Message c = new Message(2, "+27838884567",
            "Where are you? You are late! I have asked you to be on time.",
            "hash2", 2);

    messages.add(c);

    messages.removeIf(x -> x.hash.equals("hash2"));

    assertEquals(0, messages.size());
}
@Test
public void testReportOutcomes() {

    ArrayList<Message> messages = new ArrayList<>();

    Message c = new Message(1, "+27834557896", "Did you get the cake?", "h1", 1);
    messages.add(c);

    String report = "";

    for (Message msg: messages) {
        report += msg.hash + " " + msg.receiver + " " + msg.messageInput;
    }

    assertTrue(report.contains("Did you get the cake?"));
}
