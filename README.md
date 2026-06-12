## Project Overview

This console application extends the messaging system developed in Parts 1 and 2. It focuses on **string manipulation**, **array handling**, **JSON file processing**, and **data management** without hard-coding values.

The program reads messages from a JSON file, populates multiple arrays, and provides a dedicated **"Stored Messages"** menu with advanced search, delete, and reporting functionalities.

## Key Requirements Implemented

### 1. Array Population (No Hard-Coding)
- **Sent Messages** array
- **Disregarded Messages** array
- **Stored Messages** array
- **Message Hashes** array
- **Message IDs** array

Data is loaded dynamically from `messages.json` using online resources and best practices for JSON deserialization.

### 2. Stored Messages Menu (Option 4)
Users can:
- Display sender and recipient of **all stored messages**
- Display the **longest stored message**
- **Search by Message ID** → shows recipient and full message
- **Search all messages for a specific recipient**
- **Delete a message** using its **Message Hash**
- **Display Full Report** with complete details of all stored messages

### 3. Test Data Used
| Message | Recipient          | Content                                      | Flag      |
|---------|--------------------|----------------------------------------------|-----------|
| 1       | +27834557896       | Did you get the cake?                        | Sent      |
| 2       | +27838884567       | Where are you? You are late! ...             | Stored    |
| 3       | +27834484567       | Yohoooo, I am at your gate.                  | Disregard |
| 4       | 0838884567         | It is dinner time !                          | Sent      |
| 5       | +27838884567       | Ok, I am leaving without you.                | Stored    |

### 4. Unit Tests
The following tests were implemented:
- Assert that **Sent Messages** array is correctly populated
- Display the **longest message**
- Search for a message by **Message ID**
- Search all messages for a **particular recipient**
- Delete a message using **Message Hash**
- Generate and validate the **full stored messages report**
