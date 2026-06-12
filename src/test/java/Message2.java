


import com.mycompany.poe3.*;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class Message2 {
    private static int messageCounter = 0;
    private final String messageID;
    private final String recipient;
    private final String content;
    private final String messageHash;
    private final int messageNumber;
    
    public Message2(String recipient, String content){
        this.messageNumber = ++messageCounter;
        this.messageID = generateMessageID();
        this.recipient = checkRecipientCell(recipient);
        this.content = content.length() <= 250 ? content : null;
        this.messageHash = createMessageHash();
    }
    
    // Generate 10-digit Message ID (incremental with random component)
    private String generateMessageID() {
        Random rand = new Random();
        String base = String.format("%04d",messageNumber );
        String randomPart = String.format("%06d",rand.nextInt(1000000));
        String id = base + randomPart;
        return id.substring(0, 10);
    }
    public boolean checkMessageID() {
     return messageID != null && messageID.length() == 10;
    }
    public final String checkRecipientCell(String number) {
        if (number == null || number .length() > 10 || 
                (!number.startsWith("+") && !number.startsWith("0"))){
            return "INVALID";
        }
        return number;
    }
    public final String createMessageHash() {
        if (content == null || content.trim().isEmpty()) return "INVALID_HASH";
        
        String[] words = content.trim().split("\\s+");
        String firstWord = words [0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();
        
        String idPrefix = messageID.substring(0, 2);
        return idPrefix +":" + (messageNumber - 1) + firstWord + lastWord;
    }
    public String sendMessageOption(int choice){
        return switch (choice) {
            case 1 -> "Message successfully sent";
            case 2 -> "Press 0 to delete the message";
            case 3 -> "Message successfully stored";
            default -> "Invalid option";
        };
    }
    public String getMessageID() { return messageID; }
    public String geRecipient() { return recipient; }
    public String getcontent() { return content; }
    public String getMessageHash() { return messageHash; }
    public int getMessageNumber() { return messageNumber; }
  
}

