/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.javamainclass;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestingMessage {


    // TEST 1: MESSAGE LENGTH 

    @Test
    public void long uniqueMessageSuccess() {

        Message msg = new Message();
        msg.messageInput = "Hi Mike, can you join us for dinner tonight?";

        assertTrue(msg.messageInput.length() <= 250);
    }

    @Test
    public void testnumOfMessagesFailure() {

        Message msg = new Message();
        msg.messageInput = new String(new char[300]).replace("\0", "A");

        int excess = msg.messageInput.length() - 250;

        assertTrue(excess > 0);
    }
    // TEST 2: RECIPIENT NUMBER 

    @Test
    public void testreceiverSuccess() {

        Message msg = new Message();
        msg.reciever = "+27123456789";

        assertTrue(msg.checkRecipientCell());
    }

    @Test
    public void testreceiverFailure() {

        Message msg = new Message();
        msg.reciever = "08575975889";

        assertFalse(msg.checkRecipientCell());
    }

    // TEST 3: MESSAGE HASH
 

    @Test
    public void testhash() {

        Message msg = new Message();
        msg.uniqueMessage = 1234567890L;
        msg.messageInput = "Hi Mike dinner tonight";
        msg.numOfMessage = 0;

        String expected = msg.createMessageHash();

        assertEquals(expected, msg.createMessageHash());
    }


    // TEST 4: MESSAGE ID VALIDATION

    @Test
    public void testMessageID() {

        Message msg = new Message();
        msg.uniqueMessage = 12345L;

        assertTrue(msg.checkMessageID());
    }
    // TEST 5:

    @Test
    public void testmessageInput() {

        Message msg = new Message();

        assertEquals("Message sent", msg.sentMessage("1"));
        assertEquals("Message discarded", msg.sentMessage("2"));
        assertEquals("Message stored", msg.sentMessage("3"));
        assertEquals("Invalid choice", msg.sentMessage("9"));
    }
}

/**
 *
 * @author tmafi
 
}
