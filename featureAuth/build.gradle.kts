plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 33
    namespace = "ru.sr.srmessanger.featureAuth"
    defaultConfig {
        minSdk = 24
    }
    buildFeatures {
        compose = true
    }

    compileOptions   {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility  = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {

    implementation(project(":storage"))

    implementation("androidx.navigation:navigation-compose:2.6.0")

    implementation ("io.insert-koin:koin-core:3.4.3")
    implementation ("io.insert-koin:koin-androidx-compose:3.4.3")
    implementation ("io.insert-koin:koin-android:3.4.3")

    implementation ("androidx.activity:activity-compose:1.7.2")
    implementation( platform("androidx.compose:compose-bom:2022.10.00"))
    implementation ("androidx.compose.ui:ui")
    implementation ("androidx.compose.ui:ui-graphics")
    implementation ("androidx.compose.ui:ui-tooling-preview")
    implementation ("androidx.compose.material3:material3")
}