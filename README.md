Key Feature:
1. MVVM
2. Data binding
3. Live Data

plugins {
    id 'com.android.library'
    id 'org.jetbrains.kotlin.android'
}


 **Library Gradle**
android {
    namespace 'com.example.mylibrary'
    compileSdk 34

    defaultConfig {
        minSdk 24
        targetSdk 34

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles "consumer-rules.pro"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }
}

dependencies {

    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.11.0'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'

    implementation 'com.squareup.okhttp3:okhttp:4.9.1'
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"
    implementation "com.squareup.okhttp3:logging-interceptor:4.9.1"

}





plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
}

android {
    namespace 'com.example.devrevtest'
    compileSdk 34

    defaultConfig {
        applicationId "com.example.devrevtest"
        minSdk 24
        targetSdk 34
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }
    buildFeatures {
        dataBinding true
    }
}


 **Movie App  Gradle**      
dependencies {

    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.11.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'

    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.8.22")
    implementation ("androidx.core:core-ktx:1.12.0")
    implementation  ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation  ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
    implementation ("androidx.compose.material:material:1.0.5")

    implementation "androidx.recyclerview:recyclerview:1.3.2"
    implementation "androidx.databinding:databinding-runtime:7.0.0"
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.14.2'


    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.okhttp3:okhttp:4.9.1'
    implementation 'com.google.android.material:material:1.11.0'

    implementation project(':mylibrary')

}


**ScreenShots**
![Screenshot_1710056848](https://github.com/AnjaliSoni25/MovieApp/assets/31882434/1322d74a-88d2-4b75-ba00-90d270f73b31)
![Screenshot_1710056816](https://github.com/AnjaliSoni25/MovieApp/assets/31882434/8c48c8d3-fb6d-4b48-9779-3017cab93d59)
![Screenshot_1710056844](https://github.com/AnjaliSoni25/MovieApp/assets/31882434/342c862f-5c0a-40f8-9ffd-ffcda1c21bfc)




