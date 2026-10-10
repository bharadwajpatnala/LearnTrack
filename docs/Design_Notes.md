# Design Notes

## 1. Why you used ArrayList instead of array
In my LearnTrack project, I used ArrayList to store students, courses, and enrollments.

An array has a fixed size. For example, if i create an array that can store 10 students, it cannot grow automatically when I want to add more students.
An ArrayList can grow or shrink when needed. I can add new students, courses or enrollments without deciding the total number in advance.
Example: If I have 5 students initially and later add 10 more, the ArrayList can handle the additional students easily.

## 2. Where you used static members and why
The static keyword allows a variable or method to belong to the class itself instead of individual objects.

In LearnTrack, I used static members where shared information or functionality was needed such as a common counter for generating IDs or a utility method that does not depend on a particular object.

For example, a static counter can help generate unique IDs for students or courses without maintaining a separate counter in every object.

## 3. Where you used inheritance and what you gained from it
Inheritance allows one class to reuse the properties and methods of another class.

For example, if my project has a common base class for people, a Student class can extend that class and reuse common details such as a name or ID. The student class can then have its own additional properties and methods.

This avoids writing the same code in multiple classes and makes the project easier to maintain.

**Benefits of inheritance:**
- Reuse existing code.
- Avoid unnecessary duplication.
- Keep related classes organized.
- Make future changes easier.

