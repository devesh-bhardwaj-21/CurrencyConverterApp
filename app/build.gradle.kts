plugins {
    id("com.android.application")

    kotlin("android")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    id("org.jlleitschuh.gradle.ktlint") version "9.4.1"
    /*
           kotlin("../detekt.gradle")*/
}

android {
    compileSdkVersion(Config.Android.compileSdkVersion)
    buildToolsVersion(Config.Android.buildToolsVersion)

    sourceSets["main"].java.srcDir("src/main/kotlin")

    defaultConfig {
        applicationId = Config.Android.applicationId
        minSdkVersion(Config.Android.minSdkVersion)
        targetSdkVersion(Config.Android.targetSdkVersion)
        versionCode = Config.Android.versionCode
        versionName = Config.Android.versionName

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    android {
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }
}

dependencies {
    implementation(Config.Libs.kotlin_std)
    implementation(Config.Libs.appcompat)
    implementation(Config.Libs.constraintLayout)
    implementation(Config.Libs.lifecycleExtentions)
    implementation(Config.Libs.coreKtx)
    implementation(Config.Libs.fragmentKtx)
    implementation(Config.Libs.liveData)
    implementation(Config.Libs.viewBindingPropertyDelegate)
    implementation(Config.Libs.retrofit)
    implementation(Config.Libs.gson)
    implementation(Config.Libs.ConverterGson)
    implementation(Config.Libs.okhttpInterceptor)
    implementation(Config.Libs.navigationFragmentVersion)
    implementation(Config.Libs.navigationUiVersion)
    implementation(Config.Libs.legacySupport)
    implementation(Config.Libs.coroutines)

    implementation(Config.Libs.glide)
    kapt(Config.Libs.glideKapt)

    implementation(Config.Libs.hilt)
    implementation(Config.Libs.hilt)
    implementation(Config.Libs.hiltKapt)
    kapt(Config.Libs.hiltKapt)

    implementation(Config.Libs.hiltJetpackIntegration)
    kapt(Config.Libs.hiltJetpackIntegrationKapt)

    testImplementation(Config.TestLibs.junit)
    androidTestImplementation(Config.TestLibs.junitAndroidTestImpl)
    androidTestImplementation(Config.TestLibs.espresso)
}
