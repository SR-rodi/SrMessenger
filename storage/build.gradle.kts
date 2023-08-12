plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 33
    namespace = "ru.sr.srmessanger.storage"
    defaultConfig {
        minSdk = 24
    }
    buildFeatures {
        compose = true
    }

    compileOptions   {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility  = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {

    implementation(platform("com.google.firebase:firebase-bom:32.2.2"))
    implementation("com.google.firebase:firebase-auth-ktx")

    implementation("com.google.android.gms:play-services-auth:20.6.0")

    implementation( "io.insert-koin:koin-core:3.4.3")

    implementation ("androidx.activity:activity-compose:1.7.2")
    implementation( platform("androidx.compose:compose-bom:2022.10.00"))
    implementation ("androidx.compose.ui:ui")
    implementation ("androidx.compose.ui:ui-graphics")
    implementation ("androidx.compose.ui:ui-tooling-preview")
    implementation ("androidx.compose.material3:material3")

}