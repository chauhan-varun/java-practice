# Banking Application

A simple console-based banking application written in Java that allows users to manage bank accounts with basic banking operations.

## Overview

This application consists of two main classes:
- **Account.java**: Represents a bank account with basic account operations
- **UserInterface.java**: Provides a console-based user interface for interacting with the banking system

## Features

The banking application supports the following operations:

1. **Create New Account**: Create a new bank account with account holder details
2. **Deposit Money**: Add funds to an existing account
3. **Withdraw Money**: Remove funds from an existing account (with balance validation)
4. **View Account Details**: Display complete account information
5. **Update Contact Details**: Modify email and phone number for an account
6. **Exit**: Close the application

## Class Structure

### Account Class
The `Account` class contains:
- **Private Fields**:
  - `accountNumber`: Unique identifier for the account
  - `accountHolderName`: Name of the account holder
  - `balance`: Current account balance
  - `email`: Email address of the account holder
  - `phoneNumber`: Phone number of the account holder

- **Methods**:
  - `deposit(double amount)`: Adds money to the account
  - `withdraw(double amount)`: Removes money from the account (with validation)
  - `displayAccountDetails()`: Shows all account information
  - `updateContactDetails(String email, String phoneNumber)`: Updates contact information
  - `getAccountNumber()`: Returns the account number

### UserInterface Class
The `UserInterface` class provides:
- **Static Fields**:
  - Array to store up to 100 accounts
  - Account counter and next account number generator
  - Scanner for user input

- **Methods**:
  - `main(String[] args)`: Entry point of the application
  - `mainMenu()`: Displays the main menu and handles user choices
  - `createAccount()`: Creates a new account with user input
  - `findAccount(int accNo)`: Searches for an account by account number
  - `performDeposit()`: Handles deposit operations
  - `performWithdrawal()`: Handles withdrawal operations
  - `showAccountDetails()`: Displays account information
  - `updateContact()`: Updates contact details

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher installed on your system
- Command line access (Terminal/Command Prompt)

### Compilation and Execution

1. **Navigate to the project directory**:
   ```bash
   cd /home/varun/java/assignment
   ```

2. **Compile the Java files**:
   ```bash
   javac *.java
   ```
   This will compile both `Account.java` and `UserInterface.java` files.

3. **Run the application**:
   ```bash
   java UserInterface
   ```

### Alternative Compilation (if needed)
If you encounter any issues, you can compile the files individually:
```bash
javac Account.java
javac UserInterface.java
java UserInterface
```

## Usage Example

1. **Start the application**: Run `java UserInterface`
2. **Create an account**: Select option 1 and provide:
   - Account holder name
   - Initial deposit amount
   - Email address
   - Phone number
3. **Note the account number** generated (starts from 1001)
4. **Perform operations** using the account number:
   - Deposit money (option 2)
   - Withdraw money (option 3)
   - View details (option 4)
   - Update contact info (option 5)
5. **Exit** when done (option 6)

## Sample Run

```
Welcome to the Banking Application!
1. Create a new account
2. Deposit money
3. Withdraw money
4. View account details
5. Update contact details
6. Exit
Enter your choice: 1

Enter account holder name: John Doe
Enter initial deposit amount: 1000.0
Enter email address: john.doe@email.com
Enter phone number: +1234567890
Account created successfully with Account Number: 1001
```

## Features and Validations

- **Deposit Validation**: Only positive amounts can be deposited
- **Withdrawal Validation**: 
  - Amount must be positive
  - Amount cannot exceed current balance
- **Account Limit**: Maximum of 100 accounts can be created
- **Account Search**: Efficient account lookup by account number
- **Contact Updates**: Email and phone number can be updated anytime

## File Structure

```
assignment/
├── Account.java          # Account class definition
├── UserInterface.java    # Main application and UI logic
├── Account.class         # Compiled Account class
├── UserInterface.class   # Compiled UserInterface class
└── README.md            # This documentation file
```

## Technical Details

- **Language**: Java
- **Architecture**: Object-Oriented Programming (OOP)
- **Data Storage**: In-memory array (data is lost when application closes)
- **Input/Output**: Console-based using Scanner class
- **Account Numbers**: Auto-generated starting from 1001

## Limitations

- Data is not persistent (accounts are lost when the application closes)
- Maximum of 100 accounts supported
- No authentication or security features
- Console-based interface only

## Future Enhancements

Potential improvements could include:
- File-based or database persistence
- Account authentication with PIN/password
- Transaction history tracking
- Interest calculation
- Account types (savings, checking, etc.)
- GUI interface
- Network/web-based access
