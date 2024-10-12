# MediCare App

## Overview
MediCare is a simple MVVM project built using Kotlin and Jetpack Compose. The application demonstrates basic authentication and displays user information along with medicine details.

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
<img width="280" alt="medicare_detail" src="https://github.com/user-attachments/assets/014b060b-a4b3-47c8-ab39-dde656bd7137">
<img width="286" alt="medicare_home" src="https://github.com/user-attachments/assets/2acaa815-fcc9-421c-87a9-ec6c0610119f">
<img width="291" alt="medicare_login" src="https://github.com/user-attachments/assets/2d3212af-4889-4332-b693-4fc0c3ca6654">
