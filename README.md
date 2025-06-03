# 📝 Note App – Jetpack Compose + ROOM + Hilt

A simple yet powerful note-taking app built using **Jetpack Compose**, **ROOM Database**, **Hilt (Dependency Injection)**, and **Navigation Component**.

> ⚡ Inspired by modern Android development best practices — ideal for both beginners and Flutter devs transitioning to native!

## 🚀 UI
![Note App UI - Made with Clipchamp 00_02_20_12 Still001](https://github.com/user-attachments/assets/7fabeaf2-76b8-4983-9048-ee99ed598441)

---

## 📂 Project Structure

```plaintext
NoteApp/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/yourpackage/noteapp/
│   │   │   │   ├── data/
│   │   │   │   │   ├── Note.kt                     // Entity
│   │   │   │   │   ├── NoteDao.kt                  // DAO
│   │   │   │   │   └── NoteDatabase.kt             // Room Database
│   │   │   │   ├── di/
│   │   │   │   │
│   │   │   │   ├── navigation/
│   │   │   │   │
│   │   │   │   ├── repository/
│   │   │   │   │   └── NoteRepository.kt           // Data repository
│   │   │   │   │
│   │   │   │   ├── ui/
│   │   │   │   │   ├── theme/
│   │   │   │   │   │   ├── Color.kt
│   │   │   │   │   │   ├── Theme.kt
│   │   │   │   │   │   └── Typography.kt
│   │   │   │   │   ├── screens/
│   │   │   │   │   │   ├── NoteListScreen.kt       // Home screen showing all notes
│   │   │   │   │   │   ├── AddEditNoteScreen.kt    // Add/Edit screen
│   │   │   │   │   │   └── NoteItem.kt             // Note item UI
│   │   │   │   │
│   │   │   │   ├── viewmodel/
│   │   │   │   │   └── NoteViewModel.kt            // ViewModel
│   │   │   │   │
│   │   │   │   └── MainActivity.kt                 // Entry point
│   │   │   ├── NoteApplication.kt
│   │   │   │
│   │   │   └── AndroidManifest.xml
│
├── build.gradle
├── settings.gradle
└── README.md
```

---

## 📱 Features

- 🧱 **Jetpack Compose UI**
- 🧭 **Navigation Component** for screen transitions
- 🧠 **ViewModel & State Management**
- 💾 **ROOM Database** integration
- 🔁 **Add/Delete Notes** with real-time updates
- ⚡ **Kotlin Coroutines & Flow**
- 🧩 **Dependency Injection** using Hilt
- 🎨 Expandable card UI with Coil image loading (if applicable)

---

## 🛠️ Tech Stack

| Layer | Tech |
|-------|------|
| UI | Jetpack Compose |
| Navigation | Navigation Component |
| State Management | ViewModel + MutableState |
| Database | ROOM |
| DI | Hilt |
| Async | Coroutines + Flow |
| Language | Kotlin |

---

## 💡 Why This App?

As someone with a background in **Flutter development**, I built this project to explore native Android development using Jetpack Compose. The experience felt very familiar — composables, declarative UI, state handling — and **if you're a Flutter dev looking to explore native**, this is the perfect place to start!

---

## 🧪 What I Learned

- How to structure a **Jetpack Compose** app using clean architecture
- Setting up and using the **Navigation Component** — including passing arguments and handling the back stack
- Integrating **ROOM** with coroutines and `Flow`
- Implementing **Dependency Injection** using Hilt
- Managing UI state and lifecycles with `ViewModel`
- Handling edge cases like expandable cards and dynamic content

---




 
