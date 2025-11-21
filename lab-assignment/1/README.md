# Student Record Management System

## Overview
A simple Java console application demonstrating object-oriented programming concepts. It manages student records (roll number, name, course, marks, grade) with functionality to add and display students. Grades are computed from marks automatically.

## Class Structure
- `Person`: Base class containing the `name` field.
- `Student` (extends `Person`): Adds `rollNo`, `course`, `marks`, `grade` and methods:
  - `inputDetails(Scanner)` – collect validated user input
  - `calculateGrade()` – derive grade from marks
  - `displayDetails()` – print student info
- `StudentRecordApp`: Menu-driven application managing a list of `Student` objects.

## Grade Logic
```
>= 90 : A
>= 80 : B
>= 70 : C
<  70 : D
```
(Adjust as desired.)

## Validation
- Marks must be between 0 and 100.
- Name and course cannot be empty.
- Roll number must be an integer.

## How to Compile & Run
From project root:
```bash
javac src/*.java
java src.StudentRecordApp
```

## Sample Interaction
```
===== Student Record Menu =====
1. Add Student
2. Display All Students
3. Exit
Enter your choice: 1
Enter Roll No: 101
Enter Name: Rahul
Enter Course: B.Tech
Enter Marks (0-100): 87
Student added successfully.

===== Student Record Menu =====
1. Add Student
2. Display All Students
3. Exit
Enter your choice: 2
Roll No: 101
Name: Rahul
Course: B.Tech
Marks: 87.0
Grade: B
```

## Possible Enhancements
- Use `HashMap<Integer, Student>` keyed by roll number.
- Persist data to a file (serialization or CSV).
- Add update/delete operations.
- Introduce input abstraction for testability.

## License
Created for academic lab assignment; no explicit license.
