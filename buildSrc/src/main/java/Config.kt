private const val kotlinVersion = "1.4.20"
private const val androidGradleVersion = "4.0.2"

// Compile dependencies
private const val appCompatVersion = "1.2.0"
private const val constraintLayoutVersion = "2.0.4"
private const val lifecycleExtentionsVersion = "2.2.0"
private const val coreKtxVersion = "1.3.2"
private const val fragmentKtxVersion = "1.2.5"
private const val liveDataVersion = "2.2.0"
private const val viewBindingPropertyDelegateVersion = "1.3.1"
private const val legacySupportVersion = "1.0.0"
private const val navigationVersion = "2.3.1"
private const val retrofitVersion = "2.9.0"
private const val gsonVersion = "2.8.6"
private const val retrofitGsonVersion = "2.9.0"
private const val loggingInterceptor = "4.7.2"
private const val glideVersion = "4.11.0"
private const val coroutinesVersion = "1.3.9"
private const val hiltVersion = "2.28-alpha"
private const val hiltJetpackIntegrationVersion = "1.0.0-alpha02"
private const val timberVersion = "4.7.1"


object Config {

    object Repositories {
        val mavenUrl = "http://dl.bintray.com/kotlin/kotlin-eap"
    }

    object BuildPlugins {
        val androidGradle = "com.android.tools.build:gradle:${androidGradleVersion}"
        val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}"
        val navigationBuildPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${navigationVersion}"
        val hiltBuildPlugin = "com.google.dagger:hilt-android-gradle-plugin:${hiltVersion}"
    }

    object Android {
        val buildToolsVersion = "29.0.3"
        val minSdkVersion = 23
        val targetSdkVersion = 29
        val compileSdkVersion = 29
        val applicationId = "com.devesh.currencyconverterapp"
        val versionCode = 1
        val versionName = "1.0"

    }

    object Libs {
        val kotlin_std = "org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}"
        val appcompat = "androidx.appcompat:appcompat:${appCompatVersion}"
        val constraintLayout = "androidx.constraintlayout:constraintlayout:${constraintLayoutVersion}"
        val lifecycleExtentions = "androidx.lifecycle:lifecycle-extensions:${lifecycleExtentionsVersion}"
        val coreKtx = "androidx.core:core-ktx:${coreKtxVersion}"
        val fragmentKtx = "androidx.fragment:fragment-ktx:${fragmentKtxVersion}"
        val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${liveDataVersion}"
        val viewBindingPropertyDelegate = "com.kirich1409.viewbindingpropertydelegate:viewbindingpropertydelegate:${viewBindingPropertyDelegateVersion}"

        //Navigation
        val navigationFragmentVersion = "androidx.navigation:navigation-fragment-ktx:${navigationVersion}"
        val navigationUiVersion = "androidx.navigation:navigation-ui-ktx:${navigationVersion}"

        val legacySupport = "androidx.legacy:legacy-support-v4:${legacySupportVersion}"

        // network & serialization
        val retrofit = "com.squareup.retrofit2:retrofit:${retrofitVersion}"
        val gson = "com.google.code.gson:gson:${gsonVersion}"
        val ConverterGson = "com.squareup.retrofit2:converter-gson:${retrofitGsonVersion}"
        val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${loggingInterceptor}"

        //coroutines
        val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${coroutinesVersion}"

        //Glide
        val glide = "com.github.bumptech.glide:glide:${glideVersion}"
        val glideKapt = "com.github.bumptech.glide:compiler:${glideVersion}"

        //Hilt
        val hilt = "com.google.dagger:hilt-android:${hiltVersion}"
        val hiltKapt = "com.google.dagger:hilt-android-compiler:${hiltVersion}"
        val hiltJetpackIntegration = "androidx.hilt:hilt-lifecycle-viewmodel:${hiltJetpackIntegrationVersion}"
        val hiltJetpackIntegrationKapt = "androidx.hilt:hilt-compiler:${hiltJetpackIntegrationVersion}"

        val timber = "com.jakewharton.timber:timber:${timberVersion}"
    }

    object TestLibs {
        val junit = "junit:junit:4.12"
        val junitAndroidTestImpl = "androidx.test.ext:junit:1.1.2"
        val espresso = "com.android.support.test.espresso:espresso-core:3.3.0"
    }
}
