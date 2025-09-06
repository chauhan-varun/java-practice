# Java Practice Repository

## Overview
This repository contains a comprehensive collection of Java programming exercises and assignments demonstrating various concepts from basic programming fundamentals to advanced object-oriented programming (OOP) concepts. The files are organized to showcase my learning journey in Java development.

## Repository Structure

### 📁 Core Java Practice Files (Root Directory)
Basic Java programs demonstrating fundamental concepts:

#### Basic Programs
- `Hello.java` / `InputExample.java` - Basic input/output operations
- `Calculator.java` - Simple calculator with basic arithmetic operations
- `Temperature.java` - Temperature conversion (Celsius ↔ Fahrenheit)
- `Table.java` - Multiplication table generator
- `SumOfNatural.java` - Sum of first N natural numbers
- `Factorial.java` - Factorial calculation
- `Marks.java` - Grade calculation based on marks in DSA, OOP, and DBMS
- `Counter.java` - Even/odd number counter
- `Password.java` - Simple password guessing game
- `GuessTheGame.java` - Number guessing game with random number generation

#### Advanced Applications
- `SimpleInterestCalculator.java` - Multi-customer simple interest calculator
- `BusTicket.java` - Bus ticket booking system simulation
- `Atm.java` - Basic ATM withdrawal simulation
- `Bill.java` - Electricity bill calculator with tiered pricing

#### Object-Oriented Programming
- `Animal.java` - Basic class definition with constructor and methods
- `AnimalDemo.java` - Inheritance and polymorphism with Animal, Dog, and Cat classes
- `Shape.java` - Basic shape class with method definitions
- `Geeks.java` - Abstract classes and method overriding with geometric shapes
- `Person.java` - Base Person class for inheritance examples
- `SingleInheritanceDemo.java` - Student extends Person class demonstration
- `LibraryDemo.java` - Advanced inheritance with LibraryItem, Book, and Magazine classes
- `Bank.java` - Basic banking class structure

### 📁 Assignment Folder
Structured assignments demonstrating specific programming concepts:

#### Banking System (`assignment/`)
- `Account.java` - Complete banking account class with deposit, withdrawal, and contact management
- `UserInterface.java` - Console-based banking application with menu system

#### Assignment 2 (`assignment2/`)

**Folder 1: Library Management System**
- `Book.java` - Book class with encapsulation
- `Library.java` - Library management with ArrayList operations
- `Main.java` - Demonstration of library operations
- `README.md` - Detailed documentation

**Folder 2: Student Management System**
- `Student.java` - Student class with grades and GPA calculation
- `Course.java` - Course enrollment and management
- `Main.java` - Combined student and course management demo

**Folder 3: Employee Management System**
- `Employee.java` - Base employee class
- `Manager.java` - Manager class extending Employee with bonus
- `Developer.java` - Developer class extending Employee with overtime pay
- `Department.java` - Department management with salary calculations

### 📁 Additional Files
- `staticArray.cpp` - C++ example for comparison (dynamic vs static arrays)

## Key Programming Concepts Demonstrated

### 🔸 Basic Programming
- Variables, data types, and operators
- Control structures (if-else, loops, switch)
- Scanner for user input
- Random number generation
- Mathematical calculations

### 🔸 Object-Oriented Programming
- **Classes and Objects**: Creating and using custom classes
- **Encapsulation**: Private variables with public getter/setter methods
- **Inheritance**: Single and multilevel inheritance examples
- **Polymorphism**: Method overriding and dynamic method dispatch
- **Abstraction**: Abstract classes and methods
- **Constructors**: Default and parameterized constructors

### 🔸 Data Structures
- Arrays and ArrayList operations
- HashMap for key-value storage
- Collection iteration and manipulation

### 🔸 Design Patterns and Best Practices
- Proper class design and separation of concerns
- User interface separation from business logic
- Input validation and error handling
- Code documentation and commenting

## How to Run the Programs

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Terminal/Command prompt access

### Compilation and Execution
1. **Single File Programs:**
   ```bash
   javac ProgramName.java
   java ProgramName
   ```

2. **Multi-Class Programs:**
   ```bash
   javac *.java
   java MainClassName
   ```

3. **Assignment Folders:**
   ```bash
   cd assignment/
   javac *.java
   java UserInterface
   ```

### Example Usage
```bash
# Run the calculator
javac Calculator.java
java Calculator

# Run the banking system
cd assignment/
javac *.java
java UserInterface

# Run the library management system
cd assignment2/1/
javac *.java
java Main
```

## Learning Outcomes

Through these exercises, I have practiced and demonstrated:

- **Problem Solving**: Breaking down complex problems into manageable components
- **Code Organization**: Structuring code for readability and maintainability
- **User Experience**: Creating intuitive console-based applications
- **Error Handling**: Implementing proper input validation and error management
- **Documentation**: Writing clear, comprehensive documentation

## Technologies Used
- **Language**: Java (JDK 8+)
- **IDE/Editor**: VS Code
- **Version Control**: Git
- **Documentation**: Markdown

## Future Enhancements
- Add GUI interfaces using Swing or JavaFX
- Implement file I/O operations for data persistence
- Add unit testing with JUnit
- Integrate database connectivity with JDBC
- Implement more advanced design patterns

## Author
**Varun Chauhan**  
Java Programming Practice Repository  
*Demonstrating fundamental to advanced Java concepts*
