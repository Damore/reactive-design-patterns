# Design Patterns for Integration and Resilience in Reactive Systems

This project demonstrates the implementation of various design patterns focused on integration and resilience, specifically tailored for reactive scenarios using Spring WebFlux.

## Overview

The patterns showcased in this repository are designed to address common challenges in building robust, scalable, and maintainable reactive systems. The primary focus is on:

- **Integration Patterns:** Techniques for connecting and orchestrating different services and components.
- **Resilient Patterns:** Strategies to ensure system stability and graceful degradation in the face of failures.
- **Reactive Programming:** Leveraging Spring WebFlux for non-blocking, asynchronous processing.

## Use Case: Account API

All patterns are tested against a sample `account-api`, which simulates typical banking operations such as:

- Searching for branches
- Retrieving account balances
- Querying by account ID
- Other related account information

This practical scenario helps illustrate how each pattern can be applied to real-world integration and resilience challenges in a banking context.

## Getting Started

1. **Clone the repository**
2. **Build the project using Maven**
3. **Run the tests to see the patterns in action**

## Technologies Used

- Java
- Spring WebFlux
- Maven

## License

This project is licensed under the MIT License.