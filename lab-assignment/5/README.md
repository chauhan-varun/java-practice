# Student Record Management System

A comprehensive Java application for managing student records with persistent storage, multithreading, and robust exception handling.

**Developer:** Dr. Manish Kumar

## Features

- **CRUD Operations**: Add, view, search, update, and delete student records
- **Persistent Storage**: Data saved to and loaded from `students.txt` using BufferedReader/BufferedWriter
- **Multithreading**: Simulated loading states for better user experience
- **Exception Handling**: Custom exceptions and comprehensive error handling
- **Sorting**: Sort students by marks in descending order using Comparator
- **Collections Framework**: Utilizes List and Map for efficient data management
- **OOP Principles**: Implements inheritance, abstraction, and interfaces

## Project Structure

```
src/
├── StudentRecordApp.java          # Main application with menu-driven interface
├── model/
│   ├── Person.java                # Abstract base class
│   └── Student.java               # Student class with grade calculation
├── service/
│   ├── RecordActions.java         # Interface defining CRUD operations
│   └── StudentManager.java        # Implementation of RecordActions
└── util/
    ├── StudentNotFoundException.java  # Custom exception
    └── Loader.java                    # Runnable class for loading simulation
```

## Class Hierarchy

1. **Person (Abstract Class)**
   - Fields: `name`, `email`
   - Abstract method: `displayInfo()`

2. **Student (extends Person)**
   - Additional fields: `rollNo`, `course`, `marks`, `grade`
   - Methods: `inputDetails()`, `displayDetails()`, `calculateGrade()`

3. **StudentManager (implements RecordActions)**
   - Uses `List<Student>` and `Map<Integer, Student>` for storage
   - Implements all CRUD operations with validation

4. **Loader (implements Runnable)**
   - Simulates loading delays for operations

## How to Compile and Run

```bash
mkdir -p bin
javac -d bin src/model/*.java src/service/*.java src/util/*.java src/StudentRecordApp.java
java -cp bin StudentRecordApp
```

## Usage Guide

### Menu Options

1. **Add Student**
   - Enter roll number, name, email, course, and marks
   - System validates input and prevents duplicate roll numbers
   - Grade is automatically calculated

2. **View All Students**
   - Displays all student records in the system
   - Shows complete information for each student

3. **Search by Name**
   - Enter student name to search
   - Displays complete student information if found
   - Throws exception if student not found

4. **Delete by Name**
   - Enter student name to delete
   - Removes student from both List and Map collections
   - Throws exception if student not found

5. **Sort by Marks**
   - Displays students sorted by marks in descending order
   - Uses Comparator for sorting
   - Uses Iterator for display

6. **Save and Exit**
   - Saves all records to `students.txt`
   - Gracefully exits the application

### Sample Interaction

```
===== Capstone Student Menu =====
1. Add Student
2. View All Students
3. Search by Name
4. Delete by Name
5. Sort by Marks
6. Save and Exit
Enter choice: 1

Enter Roll No: 101
Enter Name: Rahul
Enter Email: rahul@mail.com
Enter Course: B.Tech
Enter Marks: 85.0
Adding student ... Done!
Student added successfully!
```

## Data Persistence

- Student records are stored in `students.txt` in the project root directory
- File format: `rollNo|name|email|course|marks`
- Data is automatically loaded on application start
- Data is saved when selecting "Save and Exit"

## Grade Calculation

Grades are automatically calculated based on marks:
- **A+**: 90-100
- **A**: 80-89
- **B**: 70-79
- **C**: 60-69
- **D**: 50-59
- **F**: Below 50

## Exception Handling

The system handles various exceptions:
- `StudentNotFoundException`: When searching/deleting non-existent students
- `IllegalArgumentException`: For invalid input (empty fields, out-of-range marks, duplicate roll numbers)
- `InputMismatchException`: For incorrect input types
- `IOException`: For file read/write errors

## Technical Details

### Collections Used
- `ArrayList<Student>`: For maintaining ordered list of students
- `HashMap<Integer, Student>`: For quick lookup by roll number

### Multithreading
- `Loader` class implements `Runnable`
- Simulates loading delays for add, delete, update, and save operations
- Provides better user experience

### File I/O
- **Reading**: `BufferedReader` with `FileReader`
- **Writing**: `BufferedWriter` with `FileWriter`
- Proper resource management with try-catch-finally blocks

## Key Learning Outcomes

✅ Object-oriented design with inheritance and abstraction  
✅ Interface implementation for modular code  
✅ Custom exception handling  
✅ File persistence with BufferedReader/BufferedWriter  
✅ Java Collections Framework (List, Map)  
✅ Sorting with Comparator  
✅ Iteration using Iterator  
✅ Multithreading for responsive UI  
✅ Input validation and error handling  

## Notes

- The application creates `students.txt` automatically if it doesn't exist
- All data is loaded from file on startup
- Data must be saved explicitly using option 6 before exiting
- Roll numbers must be unique across all students
- Marks must be between 0 and 100

## Troubleshooting

**Issue**: `ClassNotFoundException` or classes not found  
**Solution**: Ensure all files are compiled correctly and you're running from the correct directory

**Issue**: File not saving  
**Solution**: Check file permissions in the project directory

**Issue**: Data not persisting  
**Solution**: Always use option 6 to save before exiting

## Author

**Varun Chauhan**

---

*This project demonstrates comprehensive Java programming concepts including OOP, collections, file handling, multithreading, and exception handling.*
