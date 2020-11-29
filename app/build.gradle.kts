plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("dagger.hilt.android.plugin")
    kotlin("kotlin-parcelize")
    /*       kotlin("../ktlint.gradle")
           kotlin("../detekt.gradle")*/
}

android {
    compileSdkVersion(Config.Android.compileSdkVersion)
    buildToolsVersion(Config.Android.buildToolsVersion)

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
            sourceCompatibility JavaVersion . VERSION_1_8
                targetCompatibility JavaVersion . VERSION_1_8
        }
    }
}

tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile).all {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

    kotlinOptions {
        jvmTarget = '1.8'
        freeCompilerArgs += ["-Xopt-in=kotlin.RequiresOptIn"]
    }
}

dependencies {
    implementation Config.Libs.kotlin_std
    implementation  Config.Libs.appcompat
    implementation Config.Libs.constraintLayout
    implementation Config.Libs.lifecycleExtentions
    implementation Config.Libs.coreKtx
    implementation Config.Libs.fragmentKtx
    implementation Config.Libs.liveData
    implementation Config.Libs.viewBindingPropertyDelegate
    implementation Config.Libs.retrofit
    implementation Config.Libs.gsonVersion
    implementation Config.Libs.ConverterGson
    implementation Config.Libs.okhttpInterceptor
    implementation Config.Libs.navigationFragmentVersion
    implementation Config.Libs.navigationUiVersion
    implementation Config.Libs.legacySupport
    implementation Config.Libs.coroutinesVersion
    implementation Config.Libs.glideVersion
    kapt Config.Libs.glideVersionKapt
    implementation Config.Libs.hiltVersion
    implementation Config.Libs.hiltVersionKapt
    implementation Config.Libs.hiltVersion
    kapt Config.Libs.hiltVersionKapt
    implementation Config.Libs.hiltJetpackIntegrationVersion
    kapt Config.Libs.hiltJetpackIntegrationVersionKapt

    testCompile(Config.TestLibs.junit)
    androidTestCompile(Config.TestLibs.junitAndroidTestImpl)
    androidTestCompile(Config.TestLibs.espresso)
}
