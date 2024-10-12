# MediCare App

## Overview
MediCare is a simple MVVM project built using Kotlin and Jetpack Compose. The application demonstrates basic authentication and displays user information along with medicine details using a clean architecture approach.
ovides a clean and user-friendly interface to ensure a smooth task management experience.

## Key Features
- **Login :** Users can login to app.
- **Home Screen :** After logging in, users receive a greeting based on the time of day, displaying.
- **Medicine Details**: The application fetches and displays medicine information.


## Technical Requirements
- **Android SDK:** Targeting Android API level 24 and above.
- **Kotlin:** The app is written in Kotlin.
- **Jetpack Compose:** For building the UI components.
- **Kotlin Coroutines:** For asynchronous operations.
- **Hilt:** For dependency injection.
- **JUnit & MockK:** For unit testing.

## Multi-Module Architecture
The app is structured using a multi-module architecture to promote modularity and separation of concerns. The key modules are:

- **App Module:** The main application module that ties together all feature modules.
- **Feature Module:** Contains the core functionality of the TODO list, including screens and view models.
- **Core Module:** Contains common components shared across the application.
- **Data Module:** Manages data-related operations and data sources.
- **Database Module:** Handles local data storage and database interactions.
- **DesignSystem Module:** Includes design and UI components for consistent styling.
- **UI Module:** Contains the Composable functions and UI-related code.
- **Common Module:** Contains utility functions and shared resources.

## Implementation Details
- **UI Components:** Built using Jetpack Compose to ensure a modern and responsive user interface.
- **State Management:** Utilizes the MVVM pattern with ViewModels managing UI-related data.
- **Data Storage:** Tasks are stored using Room for local persistence.
- **Networking:** (If applicable) Uses Retrofit for network operations.

## Testing Strategy
- **Unit Testing:** Uses JUnit and MockK for testing ViewModels and other components in isolation.
- **UI Testing:** Employs Jetpack Compose testing tools to ensure the UI components work as expected.

## App Preview
