package com.mycompany.poe3;


import java.util.*;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class QiuckChat2 {
   private static final List<Message2> messages = new ArrayList<>();
   private static final Scanner scanner = new Scanner(System.in);
   
   public static void main(String[] args) {
       System.out.println("Welcome to QuickChat");
       
       if(!login()) {
           System.out.println("Loin Failed. Exiting.");
           return;
       }
      System.out.print("How many messages would you like to enter?");
       int numMessages = scanner.nextInt();
       scanner.nextInt();
       
       for (int i = 0; i < numMessages; i++) {
           System.out.println("\n--- Entering Message" +(i +  1) + " ---");
           createMessage();  
       }
        System.out.println("\nTotal messages processed; " + messages.size());
        printALLMessages();
     
       System.out.println("\nThank you for using QiuckChat!");
   }

    private static boolean login() {
       System.out.print("Enter usernme: ");
       String user = scanner.nextLine();
       System.out.print("Enter passord: ");
       String pass = scanner.nextLine();
       return !user.trim().isEmpty();
    }

    private static void createMessage() {
       System.out.print("Enter recipient number: ");
       String recipient = scanner.nextLine();
       
       System.out.print("Enter message (max 250 chars: ");
       String content = scanner.nextLine();
       
       if (content.length() > 250) {
           return;
       }
       for (Message2 m : messages){
       System.out.println("\nMessage Details");
       System.out.println("Message ID:" +m.getMessageID());
       System.out.println("Message Hash: " +m.getMessageHash());
       System.out.println("Rescipient:" +m.geRecipient() );
       System.out.println("Message: " +m.getcontent());
       }
       System.out.println("\nChoose action;");
       System.out.println("1) send Message");
       System.out.println("2) Disregard Message"); 
       System.out.println("3) Store Messsage to send later");
       int choice = scanner.nextInt();
       scanner.nextLine();
       
      }

    private static void printALLMessages() {
        System.out.println("\n== All Messsges ===");
        for (Message2 m : messages) {
       System.out.println("Message ID:" +m.getMessageID());
       System.out.println("Message Hash: " +m.getMessageHash());
       System.out.println("Rescipient:" +m.geRecipient() );
       System.out.println("Message: " +m.getcontent());
        }
   }
 }
   
   


