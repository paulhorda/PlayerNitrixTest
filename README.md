# Android Video Player

Kotlin Android sample with a Pexels video feed, a Room-backed metadata cache and Media3 playback. The repository keeps its original `PlayerNitrixTest` name.

## Implementation

- Retrofit and Moshi fetch video metadata from the Pexels API.
- Room stores video records; the repository exposes updates through Kotlin Flow.
- Domain use cases separate loading and cache refresh from the UI.
- Hilt wires dependencies; fragments use ViewModels and Android Navigation.
- Media3/ExoPlayer handles video playback; Glide and cache helpers support thumbnails.

Metadata caching does not imply that full videos are available offline.

## Project structure

| Directory under `app/src/main/java/com/example/playernitrixtest/` | Responsibility |
|---|---|
| `data/network/` | API, DTOs and authentication interceptor |
| `data/local/` | Room database, entities, DAO and image cache |
| `data/repository/` | Network-to-local synchronization |
| `domain/` | Models, repository contract and use cases |
| `ui/` | Video list and player screens |
| `di/` | Dependency wiring |

## Build configuration

The project targets Android SDK 34 with minimum SDK 24 and Android Gradle Plugin 8.5.2. Open it in an Android Studio setup compatible with that configuration.

Supply your own Pexels API key through the `PEXELS_API_KEY` environment variable **before Gradle runs**, then build:

```bash
./gradlew assembleDebug
```

If Android Studio is launched from a GUI, make sure its Gradle process receives the environment variable. A build without a key is allowed, but video API requests fail with a configuration error. Never commit a real key or paste it into issues.

## Credential handling

Current source reads the key from the build environment, redacts the authorization header and disables HTTP logging in release builds. A key embedded in an Android binary can still be extracted; use a server-side design when a credential must remain secret.

A provider key was present in earlier commits. Removing it from current source does not revoke it or remove it from Git history. The account owner must revoke/rotate the old key at the provider. No live key validation or rotation was performed in this update.

## Status

Source-level portfolio sample. Runtime behavior and a fresh Android build have not been verified in this update. This repository demonstrates Android engineering and local data flow; it is separate from the analytics and SOC labs on the profile.
