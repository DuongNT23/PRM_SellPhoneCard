plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    //id("com.google.gms.google-services") version "4.4.1" apply false
   // id("com.android.application")
   // id("com.google.gms.google-services")
}

android {
    namespace = "com.example.prm392_project"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.prm392_project"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
// https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(files("D:\\PRM_ManhVu\\PRM392_Project\\app\\libs\\jtds-1.3.1.jar"))
    implementation("com.google.firebase:firebase-auth:22.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    implementation ("com.google.android.material:material:1.5.0")
    implementation("com.android.volley:volley:1.2.1")
    implementation(platform("com.google.firebase:firebase-bom:32.7.2"))
    implementation("com.google.firebase:firebase-analytics")
    implementation ("com.google.android.recaptcha:recaptcha:18.4.0")
    implementation ("androidx.recyclerview:recyclerview:1.1.0")
    implementation ("com.google.android.gms:play-services-safetynet:18.0.0")
    implementation ("com.facebook.android:facebook-android-sdk:latest.release")
    implementation ("com.google.android.gms:play-services-auth:21.0.0")
    implementation ("com.google.android.gms:play-services-maps:18.0.1")
    implementation ("com.google.android.gms:play-services-maps:18.1.0")
//    implementation("com.google.firebase:firebase-auth:19.3.2")
    //implementation fileTree(dir: 'libs', include: ['*.jar'])
    //implementation ("com.google.android.gms:play-services:18.2.0")
    //implementation ("com.amitshekhar.android:android-networking:1.0.2")

}