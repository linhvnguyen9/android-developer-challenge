# Android Developer Challenge

Attempt at Android Developer challenge

## Tech stack

- Language: Kotlin (avoiding NullPointerExceptions, more concise, maintainable code)
- Architecture: 
  - Clean Architecture (ensuring scalability, maintainability, ease of testing)
  - Multi-module project (reduce build time, ready to turn into dynamic feature module to help reduce the size of the app)
  - MVVM
- Libraries
  - Dependency Injection: Hilt (ensuring compile-time correctness and performance, also easier to implement than Dagger2)
  - Reactive programming: Kotlin Coroutines (solution native to Kotlin, )
  - Logging: Timber
  - Firebase: Crashlytics to help track bugs