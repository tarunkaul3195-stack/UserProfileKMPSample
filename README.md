UserProfileKMP

A Kotlin Multiplatform (KMP) project demonstrating a shared UI and business logic for a User Profile application using Compose Multiplatform.

Features
• Compose Multiplatform: Shared UI components built with Jetpack Compose, targeting both Android and potentially other platforms (iOS, Desktop, Web).
• Ktor Client: Used for fetching user data from a remote API (dummyjson.com).
•Kamel: A library for loading and caching asynchronous images in Compose Multiplatform.
•Shared ViewModel: Logic for managing UI state is kept in the commonMain source set.
•Platform-Specific Info: Demonstrates the expect/actual mechanism by displaying the device name (Android/iOS/etc.) on the user profile card.

Project Structure

•:androidApp: The entry point for the Android application.
•:shared: The core module containing all the shared code.
•commonMain: Shared logic, UI components, networking (Ktor), and image loading.
•androidMain: Android-specific implementations (e.g., getting the Android device model).
•iosMain: iOS-specific implementations (if applicable).

Tech Stack

•Kotlin (1.9.20)
•Compose Multiplatform (1.5.11)
•Ktor for networking
•Kotlinx Serialization for JSON parsing
•Kamel for image loading
•Coroutines for asynchronous tasks

Getting Started

Prerequisites
•Android Studio Hedgehog or later.
•JDK 17+.

Running the Application

1.Clone this repository.
2.Open the project in Android Studio.
3.Select the androidApp configuration and run it on an emulator or a physical device.
How it Works
The app fetches a user profile by ID using the UserRepository. The UserViewModel manages the state (Loading, Success, Error), which is then collected as a State in the App composable. The UserCard displays the user's details along with the device name retrieved through a platform-specific getPlatform() call.
