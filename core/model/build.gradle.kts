plugins {
    alias(libs.plugins.medicare.jvm)
    id("kotlinx-serialization")
}

dependencies {
    implementation(libs.kotlin.serialization.json)
}