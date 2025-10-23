# AndroidJetpackMVVM

Build the foundations for a modern Android application by leveraging Jetpack Compose, MVVM architecture, Firebase services, Room Database, Dependency Injection with Hilt, and more.

The goal of this project is to learn how to create a reusable foundation for building Android applications using modern Android development practices with Firebase backend services. This project demonstrates clean architecture patterns and gives you a solid foundation for building your own Android apps with cloud capabilities.

## References

- [Firebase Console](https://console.firebase.google.com/)
- [Android Developer Documentation](https://developer.android.com)
- [Firebase Documentation](https://firebase.google.com/docs)

## Getting Started

### Prerequisites

- Android Studio Hedgehog | 2023.1.1 or later
- JDK 17 or higher
- Android SDK 34 (Android 14) or higher
- Google account for Firebase

### Clone

```bash
mkdir -p ~/dev/android-projects
cd ~/dev/android-projects
git clone https://github.com/your-username/AndroidJetpackMVVM.git
```

### Firebase Setup

#### 1. Create Firebase Project

1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Click "Add project" and follow the setup wizard
3. Enter your project name and enable Google Analytics (recommended)

#### 2. Add Android App to Firebase

1. In your Firebase project, click the Android icon to add an Android app
2. Enter your app's package name (check `app/build.gradle` for `applicationId`)
3. Download `google-services.json` file
4. Place the downloaded `google-services.json` file in your `app/` directory

#### 3. Configure Firebase Services

Enable the Firebase services you need:

- **Firebase Authentication** - User management
- **Firestore** - Cloud database
- **Firebase Storage** - File storage
- **Cloud Messaging** - Push notifications
- **Crashlytics** - Error reporting
- **Analytics** - User analytics

### Open in Android Studio

1. Launch Android Studio
2. Select "Open" or "Open Project"
3. Navigate to the cloned project directory
4. Click "OK"

### Configure Gradle

The project will automatically sync and download dependencies. If you encounter sync issues:

```bash
./gradlew clean
./gradlew build
```

### Configure Environment Variables

Copy the sample environment file:

```bash
cp app/env.sample.gradle app/env.gradle
```

Edit `app/env.gradle` and configure your Firebase-specific values:

```gradle
android {
    defaultConfig {
        buildConfigField "String", "FIREBASE_WEB_CLIENT_ID", "\"your-firebase-web-client-id\""
        buildConfigField "String", "FIREBASE_PROJECT_ID", "\"your-firebase-project-id\""
        buildConfigField "String", "FIREBASE_STORAGE_BUCKET", "\"your-app.appspot.com\""
    }
}
```

### Firebase Services Configuration

#### Authentication Setup
1. Go to Firebase Console → Authentication → Sign-in method
2. Enable authentication providers (Email/Password, Google, etc.)
3. Update `FirebaseAuthService` with your preferred providers

#### Firestore Setup
1. Go to Firebase Console → Firestore Database
2. Create database in test mode or production mode
3. Define your data models in the `data/models` package

#### Storage Setup
1. Go to Firebase Console → Storage
2. Start in test mode or set up security rules
3. Configure storage paths in `FirebaseStorageService`

### Build Variants

Configure build variants in Android Studio:

1. Open the Build Variants tool window (View → Tool Windows → Build Variants)
2. Select your desired build variant (debug/release)
3. Choose the target device

### Run the Application

#### Using Android Studio
1. Select your target device (emulator or physical device)
2. Click the "Run" button (green play icon)
3. Or use shortcut: `Ctrl + R` (Windows/Linux) or `Cmd + R` (Mac)

#### Using Command Line
```bash
./gradlew installDebug
# or for release
./gradlew installRelease
```

### Project Structure

```
app/
├── src/main/
│   ├── java/com/yourapp/
│   │   ├── data/           # Data layer (Room, Repositories, Firebase)
│   │   ├── domain/         # Business logic (Use Cases, Models)
│   │   ├── presentation/   # UI layer (Compose, ViewModels)
│   │   └── di/            # Dependency Injection (Hilt)
│   ├── res/               # Resources (themes, strings, drawables)
│   └── assets/           # Static files
├── google-services.json  # Firebase configuration
├── build.gradle          # App-level dependencies
└── env.gradle           # Environment configuration
```

### Key Dependencies

- **Jetpack Compose** - Modern UI toolkit
- **Firebase BOM** - Firebase platform
- **Firebase Auth** - Authentication
- **Firestore** - Cloud database
- **Firebase Storage** - File storage
- **Room** - Local database
- **Hilt** - Dependency injection
- **Retrofit** - HTTP client (for additional APIs)
- **Coroutines & Flow** - Asynchronous programming
- **Navigation Compose** - In-app navigation
- **Material 3** - Design system

### Firebase Architecture

This project integrates Firebase with MVVM architecture:

- **Data Layer**: Firebase services, Room database, Repositories
- **Domain Layer**: Use cases, business models, repository interfaces
- **Presentation Layer**: Compose UI, ViewModels, State management

### Firebase Security Rules

Update Firebase security rules for production:

#### Firestore Rules
```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    // Add your security rules here
    match /users/{userId} {
      allow read, write: if request.auth != null && request.auth.uid == userId;
    }
  }
}
```

#### Storage Rules
```javascript
rules_version = '2';
service firebase.storage {
  match /b/{bucket}/o {
    match /{allPaths=**} {
      allow read, write: if request.auth != null;
    }
  }
}
```

### Testing

Run tests using:

```bash
# Unit tests
./gradlew test

# Instrumentation tests (requires Firebase Test Lab or emulator)
./gradlew connectedAndroidTest
```

### Building for Release

1. Update signing configuration in `app/build.gradle`
2. Generate signed APK/Bundle:
   - Android Studio: Build → Generate Signed Bundle/APK
   - Command line: `./gradlew assembleRelease`
3. Deploy to Google Play Console

### Firebase Console Monitoring

After deployment, monitor your app in Firebase Console:

- **Analytics** - User engagement and behavior
- **Crashlytics** - App stability and errors
- **Performance** - App performance metrics
- **Authentication** - User management and security

Ready to develop with Firebase! 🚀
