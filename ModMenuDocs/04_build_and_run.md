# Step 4: Building & Running

## Building with Android Studio

1. Connect your device or start an emulator.
2. Click "Run" to build and launch the app.

## Building with CLI

If you're using NDK manually:

```bash
ndk-build NDK_PROJECT_PATH=. APP_BUILD_SCRIPT=Android.mk
```

> Output binaries will appear in `libs/` or `obj/local/`

## Debugging

Use `Logcat` in Android Studio. You can also insert:

```java
Log.d("ModMenu", "Button clicked");
```

to trace logic.

