# Student Management System (Java Lab Assignment 2)

## Overview
This project demonstrates key OOP principles in Java: inheritance, abstraction, interfaces, polymorphism (method overloading and overriding), encapsulation, package organization, and usage of collections (`Map`, `List`).

## Package Structure
- `model` : Domain entities (`Person` abstract class, `Student` concrete class).
- `service` : Operations interface (`RecordActions`) and its implementation (`StudentManager`).
- `app` : Application entry point (`Main`) and a `FinalMessage` final class.

## Core Components
### Person (abstract)
Defines common fields `name`, `email` and declares abstract method `displayInfo()`.

### Student
Extends `Person`. Adds `rollNo`, `course`, `marks`, `grade`. Implements:
- Method overriding: `displayInfo()`.
- Method overloading: `displayInfo(String instructor)` and `displayInfo(String researchArea, boolean research)`.
- Grade computation logic derived from marks.
- Demonstrative `finalize()` override (deprecated in modern Java, kept to match assignment expectation).

### RecordActions (interface)
Declares CRUD and sorting operations: `addStudent`, `deleteStudent`, `updateStudent`, `searchStudent`, `viewAllStudents`, `sortStudentsByMarks`, `sortStudentsByName`.

### StudentManager
Implements `RecordActions`. Maintains both a `Map<Integer,Student>` for fast lookup and a `List<Student>` for ordered operations and sorting. Prevents duplicate roll numbers.

### FinalMessage
`final` class with a `final` method `show()` to illustrate immutability of inheritance/overriding.

## Polymorphism Demonstrated
- Dynamic binding: `displayInfo()` overridden in `Student` (called via object reference).
- Static binding: Overloaded `displayInfo(...)` variants resolved at compile time.

## Running
From project root:
```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out app.Main
```

## Sample Output (Produced)
```
Student Info:
Roll No: 101
Name: Ankit
Email: ankit@mail.com
Course: B.Tech
Student Info:
Roll No: 102
Name: Riya
Email: riya@mail.com
Course: M.Tech
Research Area: AI
[Note] Overloaded display method:
Student Info:
Roll No: 101
Name: Ankit
Email: ankit@mail.com
Dr. Manish Kumar
Course: B.Tech
This is a final method in a final class.
Finalize method called before object is garbage collected.
```

## Notes on Finalization
`finalize()` and `System.runFinalization()` are deprecated and slated for removal. They are retained solely to meet assignment output requirements. For real applications prefer deterministic cleanup patterns:
- Implement `AutoCloseable` and use try-with-resources.
- Explicit lifecycle management methods (e.g., `close()`, `dispose()`).

## Possible Extensions
- Add persistence (file or database).
- Add validation (e.g., marks range checks).
- Introduce sorting by grade or course.
- Replace finalize logic with `AutoCloseable` resource cleanup demonstration.

## Compilation Target
Designed for standard Java (>= 17). Deprecation warnings for finalization are expected.

## Summary
This implementation fulfills all specified objectives: abstract base class, interface-driven service layer, inheritance, method overriding, method overloading, collection-backed record management, and modular package structure without inline source comments as requested.
