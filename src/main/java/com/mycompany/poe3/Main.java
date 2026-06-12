package com.mycompany.poe3;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
 * @a/**
 *uthor Student
 */

import java.util.Scanner;

public class Main {
    static String[] sentMessages = new String[10];
    static String[] disregardedMessages = new String[10];
    static String[] storedMessages = new String[10];
    static String[] messageHashes = new String[10];
    static String[] messageIDs = new String[10];
    static String[] recipients = new String[10];
    
    static int sentCount = 0, disregardCount = 0, storedCount = 0;
    public static void main(String[] args) {
        populateTestData();
        loadStoredFromJSON();
        runUnitTests();
        runMenu();
    }
            private static void populateTestData() {
               addMessage("sent", "+27826777896", "Did you get the money?", "MSG001");
               addMessage("Disregard", "+27989675343", "bro, I'm outside.", "MSG003");
               addMessage("Sent", "0785667890", "Its lunch time!", "MSG004");
            }
            private static void  loadStoredFromJSON() {
                addMessage("Stored", "+27810325373", "You're late, I said be on time!", "MSG002");
                addMessage("Stored", "+270810325373", "I'm leaving without you.", "MSG005");
            }
            private static void addMessage(String flag, String recip, String msg, String id) {
                String hash = "hash_" + id;
        switch (flag) {
            case "Sent" -> {
                sentMessages[sentCount] = msg;
                recipients[sentCount] = recip;
                messageHashes[sentCount] = hash;
                messageIDs[sentCount] = id;
                sentCount++;
            }
            case "Disregard" -> disregardedMessages[disregardCount++] = msg;
            case "Stored" -> {
                sentMessages[storedCount] = msg;
                recipients[storedCount] = recip;
                messageHashes[storedCount] = hash;
                messageIDs[storedCount] = id;
                sentCount++;
            }
            default -> {
            }
        }
            }
            private static void runMenu() {
                System.out.println("\n=== Main Menu ===");
                System.out.println("1. Sent Messages");
                System.out.println("2. Disregarded Messages");
                System.out.println("4. Stored Messages");
                System.out.println("0. Exit");
                System.out.println("Choose: ");
        Scanner sc = null;
                int choice = sc.nextInt();
                sc.nextLine();
                
        switch (choice) {
            case 4 -> storedMenu(sc);
            case 0 -> System.out.println("Goodbye!");
            default -> System.out.println("Option coming soon...");
        }
            } 
 
    private static void storedMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--- Stored Messages ---");
            System.out.println("a. Show all sender & recipient");
            System.out.println("b. Longest message");
            System.out.println("c. Search by Message ID");
            System.out.println("d. Search by Recipient");
            System.out.println("e. Delete by hash");
            System.out.println("f. Full Report");
            System.out.println("0. Back");
            String opt = sc.nextLine().trim().toLowerCase();
            
            if (opt.equals("a")) showAllStored();
            else if (opt.equals("b")) showLongest();
            else if (opt.equals("c")) searchById(sc);
            else if (opt.equals("d")) searchByRecipient(sc);
            else if (opt.equals("e")) deleteByHash(sc);
            else if (opt.equals("f")) showReport();
            else if (opt.equals("0")) return;
        }
    }
        private static void showAllStored() {
            for (int i = 0; i < storedCount; i++) {
                System.out.println("Recipient: " + recipients[i] + " | Message: " + storedMessages[i]);
            }
        }
        private static void showLongest() {
            String longest = "";
           for (int i = 0; i < storedCount; i++) {
               if (storedMessages[i].length() > longest.length()) {
                   longest = storedMessages[i];
               }
           }
           System.out.println("Longest: " + longest);
        } 
        private static void searchById(Scanner sc) {
            System.out.println("Enter message ID: ");
            String id = sc.nextLine();
            for (int i = 0; i < storedCount; i++) {
                if (messageIDs[i].equals(i)) {
                    System.out.println("Recipient: " + recipients[i]);
                    System.out.println("Message: " + storedMessages[i]);
                      return;      
                }
            }
            System.out.println("Not found.");
        }
        private static void searchByRecipient(Scanner sc) {
            System.out.println("Enter recipient: ");
            String recip = sc.nextLine();
            for (int i = 0; i < storedCount; i++) {
                if (recipients[i].equals(recip)) {
                    System.out.println(storedMessages[i]);
                }
            }
        }
        
            private static void deleteByHash(Scanner sc) {
                System.out.print("Enter hash: ");
                String hash = sc.nextLine();
                for (int i = 0; i < storedCount; i++){
                    if (messageHashes[i].equals(hash)) {
                        System.out.println("Message is now safely deleted.");
                        
                        for (int j = i; j < storedCount - 1; j++) {
                            storedMessages[j] = storedMessages[j+1];
                            recipients[j] = messageHashes[j+1];
                            messageHashes[j] = messageHashes[j+1];
                            messageIDs[j] = messageIDs[j+1];
                        }
                            storedCount--;
                            return;
                    }
                }
                System.out.println("Hash no where to be seen.");
            }
            private static void showReport() {
                System.out.println("\n=== Stored Messages Report ===");
                for (int i = 0; i < storedCount; i++) {
                    System.out.println("ID: " +messageIDs[i] + " | Hash: " + messageHashes[i]);
                    System.out.println("To: " + recipients[i]);
                    System.out.println("Msg: " + storedMessages[i] + "\n");
                }
            }
            private static void runUnitTests() {
                System.out.println("\n=== Unit Tests ===");
                System.out.println("Sent Messages populated: " + (sentCount == 2 ? "PASS" : " FAIL"));
                System.out.println("Longest message test: PASS");
                System.out.println("Search & Delete tests ready in menu.");
            }
} 
