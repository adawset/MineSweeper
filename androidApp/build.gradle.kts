import com.android.build.api.dsl.ApplicationExtension
import org.gradle.kotlin.dsl.configure

plugins {
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    dependencies {
        implementation(projects.composeApp)
        implementation(libs.compose.ui.tooling.preview)
        implementation(libs.androidx.activity.compose)
        implementation(libs.kotlinx.coroutines.android)
        implementation(libs.sqldelight.android)
        implementation(libs.decompose)
        implementation(libs.decompose.extension)
    }

    compilerOptions {
        jvmToolchain(8)
    }
}

extensions.configure<ApplicationExtension> {
    namespace = "andy.zhu.minesweeper"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/AndroidManifest.xml")
    sourceSets["main"].res.directories.add("src/res")
    sourceSets["main"].resources.directories.add("src/resources")
    sourceSets["main"].kotlin.directories.add("src")

    defaultConfig {
        applicationId = "andy.zhu.minesweeper"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 2
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
dependencies {
    implementation(libs.androidx.core.ktx)
}
