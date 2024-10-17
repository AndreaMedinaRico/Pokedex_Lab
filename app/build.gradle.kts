plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.kotlin.mypokedexapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kotlin.mypokedexapp"
        minSdk = 21
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.navigation.fragment)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Retrofit --> Conexiones API y HTTPS
    implementation(libs.retrofit)
    implementation(libs.converterGson)

    // Glide --> Cargar imágenes de internet
    implementation(libs.glide)  // Librería Glide para el código de producción
    annotationProcessor(libs.glideCompiler)  // Procesador de anotaciones para Glide
    implementation(libs.glideTransformations)  // Librería de transformaciones de Glide

    // Corrutinas --> Peticiones asíncronas
    implementation(libs.coroutines)

    // Encargados de mantener vivas versiones anteriores
    implementation(libs.fragmentKtx)
    implementation(libs.activityKtx)
    implementation(libs.dataBindingRuntime)

    // View Model
    implementation(libs.viewModel)
    // LiveData
    implementation(libs.liveData)
}