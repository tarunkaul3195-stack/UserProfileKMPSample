# UserProfileKMP

A Kotlin Multiplatform (KMP) project demonstrating a shared UI and business logic for a User Profile application using Compose Multiplatform.

<img width="500" height="800" alt="Screenshot_20260615_014138" src="https://github.com/user-attachments/assets/b096168d-7012-45c2-ad92-5a35d77890b7" />

Video:
https://github.com/user-attachments/assets/2f2b6d9a-91cb-4353-902e-cf8fd4d80e34
---

## ✨ Features
- **Compose Multiplatform**: Shared UI components built with Jetpack Compose, targeting Android and potentially iOS, Desktop, and Web.
- **Ktor Client**: Fetches user data from a remote API (`dummyjson.com`).
- **Kamel**: Library for loading and caching asynchronous images in Compose Multiplatform.
- **Shared ViewModel**: Manages UI state in the `commonMain` source set.
- **Platform-Specific Info**: Uses `expect/actual` mechanism to display the device name (Android/iOS/etc.) on the user profile card.

---

## 📂 Project Structure
- **`:androidApp`** → Entry point for the Android application.
- **`:shared`** → Core module containing shared code.
  - **`commonMain`** → Shared logic, UI components, networking (Ktor), image loading.
  - **`androidMain`** → Android-specific implementations (e.g., device model).
  - **`iosMain`** → iOS-specific implementations (if applicable).

---

## 🛠 Tech Stack
- Kotlin `1.9.20`
- Compose Multiplatform `1.5.11`
- Ktor (networking)
- Kotlinx Serialization (JSON parsing)
- Kamel (image loading)
- Coroutines (async tasks)
- MVVM and Repository Pattern

---

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog or later
- JDK 17+

### Running the Application
1. Clone this repository:
   ```bash
   git clone https://github.com/tarunkaul3195-stack/UserProfileKMP.git
