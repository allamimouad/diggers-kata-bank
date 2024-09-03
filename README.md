# Simple Banking Application

This is a simple console banking application implemented in plain Java. 
The application provides basic functionalities such as deposit Money, withdraw Money
making transactions, and generating account statements.

## Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Installation](#installation)
- [Usage](#usage)
- [Running Tests](#running-tests)
- [Contact](#contact)

## Features

- **Deposit Money:** Deposit funds into an account.
- **Withdraw Money:** Withdraw funds from an account with sufficient balance.
- **Account Statement:** Generate a statement that shows all transactions for an account.

## Technology Stack

- **language used:**
    - Java (No frameworks)

- **Tools:**
    - JUnit for testing
    - Git for version control

## Installation

### Prerequisites

- Java JDK 17 or later
- Maven (for build automation)

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/allamimouad/diggers-kata-bank.git
   cd diggers-kata-bank
   ```
   
2. Build the project::
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   java -cp target/diggers-kata-1.0-SNAPSHOT.jar diggers.kata.App
   ```