plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kapt)
    alias(libs.plugins.serialization)
}

android {
    namespace = "com.example.testarchitecture"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.testarchitecture"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(projects.core.di)
    implementation(projects.core.diCompose)
    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.core.navigation)
    implementation(projects.utils.utilsCompose)

    implementation(projects.feature.authorization.authorizationApi)
    implementation(projects.feature.authorization.authorizationImpl)

    implementation(projects.feature.tabFirst.tabFirstApi)
    implementation(projects.feature.tabFirst.tabFirstImpl)

    implementation(projects.feature.tabSecond.tabSecondApi)
    implementation(projects.feature.tabSecond.tabSecondImpl)

    implementation(projects.feature.test.testApi)
    implementation(projects.feature.test.testImpl)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    implementation(libs.androidx.navigation.compose)

    implementation(libs.serialization.json)
}
