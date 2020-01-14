import java.net.URI

buildscript {
    repositories {
        google()
        jcenter()
        maven("https://maven.fabric.io/public")

    }
    dependencies {
        classpath(Dependencies.Plugins.android)
        classpath(Dependencies.Plugins.kotlin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = URI.create("https://jitpack.io") }
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}
