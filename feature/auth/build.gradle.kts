plugins {
    alias(libs.plugins.medicare.android.feature)
    alias(libs.plugins.medicare.android.compose)
}

android {
    namespace ="com.medicare.auth"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:model"))
    implementation(project(":core:database"))

    testImplementation ("io.mockk:mockk:1.12.0")
    testImplementation(libs.mockito)
    testImplementation(libs.androidx.core.testing)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.hiltTesting)
    androidTestImplementation(libs.hiltTesting)

    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.test.manifest)

}