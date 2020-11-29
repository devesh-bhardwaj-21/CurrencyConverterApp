private const val kotlinVersion = "1.4.20"
private const val androidGradleVersion = "4.0.2"

// Compile dependencies
private const val appCompatVersion = "1.2.0"
private const val constraintLayout = "2.0.4"
private const val lifecycleExtentions = "2.2.0"
private const val coreKtx = "1.3.2"
private const val fragmentKtx = "1.2.5"
private const val liveData = "2.2.0"
private const val viewBindingPropertyDelegate = "1.2.1"
private const val legacySupport = "1.0.0"
private const val navigationVersion = "2.3.1"
private const val retrofitVersion = '2.9.0'
private const val gsonVersion = '2.8.6'
private const val retrofitGsonVersion = '2.9.0'
private const val loggingInterceptor = '4.7.2'
private const val glideVersion = '4.11.0'
private const val coroutinesVersion = '1.3.9'
private const val hiltVersion = '2.28-alpha'
private const val hiltJetpackIntegrationVersion = '1.0.0-alpha02'


object Config {

    object BuildPlugins {
        val androidGradle = "com.android.tools.build:gradle:$androidGradleVersion"
        val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        val navigationBuildPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"
        val hiltBuildPlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
    }

    object Android {
        val buildToolsVersion = "29.0.3"
        val minSdkVersion = 21
        val targetSdkVersion = 29
        val compileSdkVersion = 29
        val applicationId = "com.devesh.currencyconverterapp"
        val versionCode = 1
        val versionName = "1.0"

    }

    object Libs {
        val kotlin_std = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
        val appcompat = "androidx.appcompat:appcompat:$appCompatVersion"
        val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayout"
        val lifecycleExtentions = "androidx.lifecycle:lifecycle-extensions:$lifecycleExtentions"
        val coreKtx = "androidx.core:core-ktx:$coreKtx"
        val fragmentKtx = "androidx.fragment:fragment-ktx:$fragmentKtx"
        val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$liveData"
        val viewBindingPropertyDelegate = "com.kirich1409.viewbindingpropertydelegate:viewbindingpropertydelegate:$viewBindingPropertyDelegate"

        // network & serialization
        val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        val gsonVersion = "com.google.code.gson:gson:$gsonVersion"
        val ConverterGson = "com.squareup.retrofit2:converter-gson:$retrofitGsonVersion"
        val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:$loggingInterceptor"

        //Navigation
        val navigationFragmentVersion = "androidx.navigation:navigation-fragment-ktx:$navigation_version"
        val navigationUiVersion = "androidx.navigation:navigation-ui-ktx:$navigation_version"

        val legacySupport = "androidx.legacy:legacy-support-v4:$legacySupport"

        //coroutines
        val coroutinesVersion = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"

        //Glide
        val glideVersion = "com.github.bumptech.glide:glide:$glideVersion"
        val glideVersionKapt = "com.github.bumptech.glide:compiler:$glideVersion"

        //Hilt
        val hiltVersion = "com.google.dagger:hilt-android:$hiltVersion"
        val hiltVersionKapt = "com.google.dagger:hilt-android-compiler:$hiltVersion"
        val hiltJetpackIntegrationVersion = "androidx.hilt:hilt-lifecycle-viewmodel:$hiltJetpackIntegrationVersion"
        val hiltJetpackIntegrationVersionKapt = "androidx.hilt:hilt-compiler:$hiltJetpackIntegrationVersion"
    }

    object TestLibs {
        val junit = "junit:junit:4.12"
        val junitAndroidTestImpl = "androidx.test.ext:junit:1.1.2"
        val espresso = "com.android.support.test.espresso:espresso-core:3.3.0"
    }
}
