object ApplicationId {
    const val id = "com.linh.androiddeveloperchallenge"
}

object AndroidConfig {
    const val compileSdk = 32
    const val minSdk = 21
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "1.0"
}

object TestConfig {
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Dependencies {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val epoxy = "com.airbnb.android:epoxy:${Versions.epoxy}"
    const val epoxyAnnotation = "com.airbnb.android:epoxy-processor:${Versions.epoxy}"
    const val epoxyDatabinding = "com.airbnb.android:epoxy-databinding:${Versions.epoxy}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    // Debugging dependencies
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object TestDependencies {
    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

private object Versions {
    const val coreKtx = "1.7.0"
    const val appCompat = "1.4.1"
    const val material = "1.6.0"
    const val constraintLayout = "2.1.3"
    const val hilt = "2.41"
    const val navigation = "2.4.2"
    const val epoxy = "4.6.3"
    const val gson = "2.9.0"

    // Test dependencies
    const val junit = "4.13.2"
    const val junitExt = "1.1.3"
    const val espresso = "3.4.0"

    // Debugging dependencies
    const val timber = "5.0.1"
}

object Modules {
    const val app = ":app"
    const val common = ":common"
    const val navigation = ":navigation"

    const val featureRatesVolume = ":features:ratesvolume"
}
