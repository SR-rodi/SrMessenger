plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace  = "ru.sr.srmessenger"
    compileSdk =  33

    defaultConfig {
        applicationId =  "ru.sr.srmessenger"
        minSdk =  26
        targetSdk =  33
        versionCode =  1
        versionName =  "1.0"

       
        vectorDrawables {
            useSupportLibrary  = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
           // proguardFiles getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
        }
    }
    compileOptions {
        sourceCompatibility =  JavaVersion.VERSION_1_8
        targetCompatibility =  JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion =  "1.5.1"
    }
}

dependencies {

    implementation(project(":coreUi"))
    implementation(project(":navigation"))
    implementation(project(":storage"))
    implementation(project(":navGraph"))
    implementation(project(":featureAuth"))


    implementation("androidx.navigation:navigation-compose:2.6.0")
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.30.1")

    implementation ("io.insert-koin:koin-core:3.4.3")
    implementation ("io.insert-koin:koin-androidx-compose:3.4.3")
    implementation ("io.insert-koin:koin-android:3.4.3")

    implementation(platform("com.google.firebase:firebase-bom:32.2.2"))
    implementation("com.google.firebase:firebase-analytics-ktx")

    implementation ("androidx.core:core-ktx:1.10.1")
    implementation (platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.30.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation ("androidx.activity:activity-compose:1.7.2")
    implementation (platform("androidx.compose:compose-bom:2022.10.00"))
    implementation ("androidx.compose.ui:ui")
    implementation ("androidx.compose.ui:ui-graphics")
    implementation ("androidx.compose.ui:ui-tooling-preview")
    implementation ("androidx.compose.material:material")

}