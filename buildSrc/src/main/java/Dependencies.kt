object Versions {
    // Android
    const val androidMinSdk = 19
    const val androidTargetSdk = 29
    const val androidCompileSdk = 29
    const val androidVersionCode = 1
    const val androidVersionName = "1.0"

    // Google
    const val materialComponents = "1.0.0"
    const val androidx = "1.1.0"
    const val lifecycleComponents = "2.0.0"
    const val ktx = "1.0.1"
    const val ktxActivity = "1.0.0"
    const val multidex = "2.0.1"

    // Libraries
    const val dagger = "2.24"
    const val rxJava = "2.2.13"
    const val rxAndroid = "2.1.1"
    const val moshi = "1.9.2"
    const val retrofit = "2.6.2"
    const val okhttp = "4.2.2"
    const val timber = "4.7.1"

    // Plugins
    const val kotlin = "1.3.50"
    const val android = "3.5.1"

    // Glide
    const val glide = "4.10.0"

    // Groupie
    const val groupie = "2.7.0"
}

object Dependencies {
    const val okhttp = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"
    const val groupie = "com.xwray:groupie:${Versions.groupie}"
    const val groupieAndroidExt = "com.xwray:groupie-kotlin-android-extensions:${Versions.groupie}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    object Material {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.androidx}"
        const val materialComponents =
            "com.google.android.material:material:${Versions.materialComponents}"
        const val lifecycleComponents =
            "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleComponents}"
        const val prefs = "androidx.preference:preference:${Versions.materialComponents}"
    }

    object Ktx {
        const val activity = "androidx.activity:activity-ktx:${Versions.ktxActivity}"
        const val core = "androidx.core:core-ktx:${Versions.ktx}"
    }

    object Plugins {
        const val android = "com.android.tools.build:gradle:${Versions.android}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    object Stdlib {
        const val jdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    }

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
        const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
        const val adapterRxJava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    }

    object Dagger {
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
        const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    }

    object Rx {
        const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    }
}