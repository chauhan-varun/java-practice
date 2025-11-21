# Student Management System

A Java-based Student Management System demonstrating exception handling, multithreading, and wrapper classes for robust and responsive student data management.

## Features

- **Exception Handling**: Comprehensive validation with try-catch-finally blocks
- **Custom Exceptions**: `StudentNotFoundException` for missing student records
- **Multithreading**: Simulated loading process using `Thread` and `Runnable`
- **Wrapper Classes**: Autoboxing with `Integer` and `Double` for data conversion
- **Input Validation**: Validates marks range (0-100), email format, and empty fields

## Class Structure

### Core Classes

1. **`RecordActions`** (Interface)
   - Defines contract for student operations
   - Methods: `addStudent()`, `saveStudent()`, `findStudent()`, `displayStudent()`, `removeStudent()`

2. **`Student`**
   - Data model with wrapper types (`Integer` for roll number, `Double` for marks)
   - Auto-calculates grade based on marks (A: ≥85, B: ≥70, C: ≥50, D: <50)

3. **`StudentManager`**
   - Implements `RecordActions`
   - Thread-safe operations with synchronized methods
   - In-memory storage using `HashMap<Integer, Student>`

4. **`Loader`**
   - Implements `Runnable` for simulating loading delays
   - Configurable duration for different operations

5. **`StudentNotFoundException`**
   - Custom exception for missing student records

6. **`Main`**
   - Entry point with interactive console interface
   - Comprehensive exception handling for user input

## Compilation

```bash
javac -d out src/*.java
```

## Execution

```bash
java -cp out src.Main
```

## Sample Usage

```
Enter Roll No (Integer): 102
Enter Name: Karan
Enter Email: karan@mail.com
Enter Course: BCA
Enter Marks: 77.5
Loading.....
Roll No: 102
Name: Karan
Email: karan@mail.com
Course: BCA
Marks: 77.5
Grade: B
Program execution completed.
```

## Validation Rules

- **Roll Number**: Must be a valid integer, cannot be empty
- **Name**: Cannot be empty
- **Email**: Must contain '@' symbol
- **Course**: Cannot be empty
- **Marks**: Must be between 0 and 100 (inclusive)

## Exception Handling

The system handles multiple exception types:
- `NumberFormatException`: Invalid numeric input
- `StudentNotFoundException`: Student not found in records
- `IllegalArgumentException`: Validation failures
- `InterruptedException`: Thread interruption during loading
- `Exception`: General unexpected errors

All exceptions are caught and displayed with user-friendly error messages.

## Requirements

- Java Development Kit (JDK) 8 or higher
- No external dependencies required

## Learning Outcomes

This assignment demonstrates:
1. Implementation of try-catch-finally blocks for exception handling
2. Multithreading to simulate delays and ensure responsive UI
3. Working with wrapper classes (`Integer`, `Double`) for data conversions and autoboxing
4. Custom exception creation and handling
5. Interface implementation and method overriding
6. Thread-safe operations with synchronized methods

## Author

### varun chauhan