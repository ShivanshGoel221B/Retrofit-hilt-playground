plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("plugin.serialization").version("1.7.10")
    id("kotlinx-serialization")
    alias(libs.plugins.hilt)
    id("kotlin-kapt")
}

android {
    namespace = "com.shivansh.retrofitplayground"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.shivansh.retrofitplayground"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    viewBinding {
        enable = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.coroutines)
    implementation(libs.kotlinx.serialization)
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.lifecycle)
    implementation(libs.hilt)
    kapt("com.google.dagger:hilt-compiler:2.51.1")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}