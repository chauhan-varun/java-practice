# Student Result Management System

A simple console-based Java application demonstrating robust exception handling using checked and unchecked exceptions, custom domain exceptions, `try-catch-finally`, `throw`, and `throws`.

## Features
- Add students (roll number, name, marks for 3 subjects).
- Validate marks with a checked custom exception (`InvalidMarksException`).
- Search and display a student's details (throws unchecked `StudentNotFoundException` if missing).
- Computes average and pass/fail (all subjects >= 40 and average >= 40).
- Handles common runtime issues: invalid marks, malformed input, null/empty name, capacity limits, search misses, `InputMismatchException`.
- Demonstrates releasing resources via `finally` / explicit `close()`.

## Compile & Run
```bash
# From repository root
javac src/*.java
java -cp src ResultManager
```

## Sample Interaction
```
===== Student Result Management System =====
1. Add Student
2. Show Student Details
3. Exit
Enter your choice: 1
Enter Roll Number: 101
Enter Student Name: Alice
Enter marks for subject 1: 85
Enter marks for subject 2: 92
Enter marks for subject 3: 88
Student added successfully.
Returning to main menu...

===== Student Result Management System =====
1. Add Student
2. Show Student Details
3. Exit
Enter your choice: 2
Enter Roll Number to search: 101
Roll Number: 101
Student Name: Alice
Marks: 85 92 88 
Average: 88.33333333333333
Result: Pass
Search completed.
Returning to main menu...

===== Student Result Management System =====
1. Add Student
2. Show Student Details
3. Exit
Enter your choice: 1
Enter Roll Number: 102
Enter Student Name: Bob
Enter marks for subject 1: -10
Error: Invalid marks for subject 1: -10 (allowed 0-100)
Returning to main menu...

===== Student Result Management System =====
1. Add Student
2. Show Student Details
3. Exit
Enter your choice: 3
Exiting program. Thank you!
```

### Clone the Repository
```sh
  git clone https://github.com/chauhan-varun/java-practice.git
  cd java-practice
```