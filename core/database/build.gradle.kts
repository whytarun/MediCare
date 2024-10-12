plugins {
    alias(libs.plugins.medicare.android.library)
    alias(libs.plugins.medicare.android.room)
    alias(libs.plugins.medicare.android.hilt)
}

android {
    namespace = "com.medicare.database"
}

dependencies {
    implementation(project(":core:model"))
}