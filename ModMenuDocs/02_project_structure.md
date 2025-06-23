# Step 2: Understanding Project Structure

## Java Side

- `/app/src/main/java/com/android/support/base/`
  - `FloatingWindowManager.java` — Handles floating view logic.
- `/app/src/main/java/com/android/support/interfaces/`
  - Modular interfaces for theme, builder, style, etc.
- `/app/src/main/java/com/android/support/ThemesData/`
  - Menu themes like `DZ` and `LGL`

## Native Side

- `/jni/KittyMemory/` — Memory patching libs
- `/jni/Menu/` — JNI bridge (`Jni.cpp`, `Menu.cpp`, `Setup.cpp`)
- `/jni/Includes/` — Utility files like `Utils.cpp`
