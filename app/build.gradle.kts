plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Versions.androidCompileSdk)

    defaultConfig {
        minSdkVersion(Versions.androidMinSdk)
        targetSdkVersion(Versions.androidTargetSdk)
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        versionCode = Versions.androidVersionCode
        versionName = Versions.androidVersionName

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {
    // Jdk
    api(Dependencies.Stdlib.jdk)

    // Support Libraries
    api(Dependencies.Material.lifecycleComponents)
    api(Dependencies.Material.materialComponents)
    api(Dependencies.Material.prefs)
    api(Dependencies.Ktx.core)
    api(Dependencies.multidex)

    api(Dependencies.Material.appcompat)
    api(Dependencies.Ktx.activity)

    // Dagger
    api(Dependencies.Dagger.dagger)
    kapt(Dependencies.Dagger.compiler)

    // Rx
    api(Dependencies.Rx.rxAndroid)
    api(Dependencies.Rx.rxJava)

    // Retrofit
    api(Dependencies.Retrofit.retrofit)
    api(Dependencies.Retrofit.converterMoshi)
    api(Dependencies.Retrofit.adapterRxJava)

    // Moshi
    api(Dependencies.Moshi.moshi)
    implementation(Dependencies.Moshi.moshiKotlin)
    kapt(Dependencies.Moshi.moshiCodegen)

    // OkHttp
    api(Dependencies.okhttp)

    // Timber
    api(Dependencies.timber)

    // Glide
    api(Dependencies.glide)

    // Groupie
    api(Dependencies.groupie)
    api(Dependencies.groupieAndroidExt)
}