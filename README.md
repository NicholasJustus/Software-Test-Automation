# Software Test Automation  

This project includes my **Contact**, **Task**, and **Appointment** services, each built with their own set of **JUnit 5 tests**. These files represent my work building, testing, and validating small backend systems designed to run entirely in memory. This setup allowed me to focus on functionality, correctness, and clean code without relying on external databases or frameworks.  

The **Contact Service** portion highlights how I structured unit tests to verify that core operations like creating, updating, and deleting contacts worked as intended while maintaining data integrity. Each test helped uncover potential logic issues early in development and ensured the code performed reliably under different scenarios.  

---

## Reflection  

### How can I ensure that my code, program, or software is functional and secure?  
I ensure functionality and security by writing thorough **unit tests** that verify every feature behaves as expected. Using **JUnit 5**, I tested each method for valid and invalid inputs, which helped catch errors early. I also used validation logic within each class to prevent invalid data, such as overly long IDs or null fields. These practices help create reliable, secure code that doesn’t expose vulnerabilities through careless input handling.  

### How do I interpret user needs and incorporate them into a program?  
I interpret user needs by breaking down requirements into smaller, testable features. For example, the user needed a way to manage contacts efficiently, so I focused on making the `ContactService` easy to use, update, and maintain. I also think about how users would interact with the data — ensuring that each operation (create, update, delete) behaves in a predictable way and that error messages or restrictions make sense from a user perspective.  

### How do I approach designing software?  
My approach to software design starts with **planning and structure**. I like to define the purpose of each class, keep methods focused on one job, and write code that’s easy to test and maintain. In this project, I followed **object-oriented design principles** like encapsulation and separation of concerns. By combining this approach with automated testing, I was able to build a cleaner and more dependable backend system that could easily scale into a larger application later.  

---

## Summary  
This project taught me how to apply **software testing and automation techniques** in a real development environment. I learned the importance of validation, clean design, and test coverage. The skills from this course writing JUnit tests, debugging, and structuring reliable backend code has strengthened my confidence as a software engineer and prepared me for larger, more complex systems in future courses and professional work.  
