/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe3;

/**
 *
 * @author Student
 */
import java.util.Scanner;


public class LoginSytem3 {

    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
            Login3 login = new Login3();
        
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        
        System.out.print("Create username: ");
        login.setUsername(input.nextLine());
        
        System.out.print("Create password: ");
        login.setPassword(input.nextLine());
        
        System.out.print("Enter cell phone number (with +27): ");
        login.setCellPhoneNumber(input.nextLine());
        
        String registrationMessage = login.registeredUser();
        System.out.println("\n" + registrationMessage);
        
        if (registrationMessage.equals("User successfully registered!")){
            System.out.println("\n=== Login ===");
         
        System.out.print("Enter username: ");
        String enteredUsername = input.nextLine();
        
        System.out.print("Enter password: ");
        String enteredPassword = input.nextLine();
        
        String loginStatus = login.returnLoginStatus(enteredUsername, enteredPassword);
        System.out.print(loginStatus);
        
    } else {
            System.out.println("Registration failed. Cannot proceed to login.");
            }
        }
 }
