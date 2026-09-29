# Student Grade Management System

A Java console-based application that manages the grades of 5 students across 3 subjects. The program allows users to enter student information, validates grade input, and provides various services for viewing and analyzing student performance.

---

## Features

- Enter names for 5 students.
- Enter grades for 3 subjects per student.
- Validate grade input (0–100 only).
- Display grades as both percentages and letter grades.
- Search for a student by name.
- Count the number of students who passed.
- Calculate subject averages.
- Find the highest grade in each subject.
- Interactive menu-driven interface.

---

## Menu Options

1. Show all student names.
2. Show all students' grades in each subject.
3. Search for a student by name and display their grades.
4. Show the number of passed students.
5. Show the average grade for each subject.
6. Show the highest grade in each subject.
7. Exit the program.

---

## Input Validation

The program validates all grades entered by the user to ensure they are within the valid range:
- Minimum grade: 0
- Maximum grade: 100

If an invalid grade is entered, the user is prompted to enter a valid value.

---

## Grade Representation

Grades are displayed as:
- Percentage score
- Corresponding letter grade

### Example Scale

| Percentage | Letter Grade |
| :--- | :--- |
| ≥ 85 | A |
| ≥ 75 | B |
| ≥ 65 | C |
| ≥ 50 | D |
| < 50 | F |

---

## Concepts Used

This project was developed using the following Java concepts:
- Variables and Data Types]
- Conditional Statements (`if`, `switch`)
- Loops (`for`, `do-while`)
- Arrays and 2D Arrays
- Methods
- User Input (`Scanner`)

---

## Example Usage

```text
===== Student Grade Management System =====
1. Show all student names
2. Show all students grades
3. Search for a student
4. Show passed students count
5. Show subject averages
6. Show highest grade in each subject
7. Exit

Enter your choice:
