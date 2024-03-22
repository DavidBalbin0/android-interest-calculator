# Interest Calculator

The Interest Calculator project is part of my Android development journey, initiated during my college studies. Starting from the basics with a fundamental understanding of Kotlin, I embarked on creating this simple Android application to calculate simple interest and total amount based on the principal amount, interest rate, and time period in months.

## MVVM Architecture
The project follows the Model-View-ViewModel (MVVM) architecture pattern, which helps in separating concerns and maintaining a clean codebase. Here's a brief overview of each component in the MVVM pattern:

- **Model:** Represents the data and business logic of the application. In this project, the model consists of functions to calculate simple interest and total amount.

- **View:** Represents the UI components of the application. In Android development, views are implemented using Compose UI. The UI is responsible for displaying data to the user and capturing user input.

- **ViewModel:** Acts as a mediator between the View and the Model. It exposes data to the View and handles user interactions. The ViewModel in this project holds the business logic for interest calculation and interacts with the View via LiveData.

## Logic
The core logic of the application revolves around calculating simple interest and total amount based on user input. The calculateInterest function computes the simple interest using the formula:

```kotlin

Interest = Principal * Rate / 100 * Months

```

where Principal is the initial amount, Rate is the interest rate, and Months is the time period in months.
Similarly, the calculateAmount function calculates the total amount by adding the principal amount and the interest.

## Decoupling Logic and Interface
One of the key principles followed in this project is the decoupling of logic and interface. By adhering to the MVVM architecture, the business logic for interest calculation is separated from the UI components. This separation allows for better maintainability, testability, and scalability of the application.

The ViewModel serves as a bridge between the View and the Model, ensuring that the UI remains responsive while the calculations are performed in the background. LiveData is used to observe changes in data and update the UI accordingly, promoting a reactive programming approach.