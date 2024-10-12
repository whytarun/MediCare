import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
     `kotlin-dsl`
 }

 group = "com.medicare.buildlogic"

 java {
     sourceCompatibility = JavaVersion.VERSION_17
     targetCompatibility = JavaVersion.VERSION_17
 }

 tasks.withType<KotlinCompile>().configureEach {
     kotlinOptions{
         jvmTarget =JavaVersion.VERSION_17.toString()
     }
 }

tasks {
      validatePlugins {
          enableStricterValidation = true
          failOnWarning = true
      }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidLibrary"){
            id ="medicare.android.library"
            implementationClass ="AndroidLibraryConventionPlugin"
        }

        register("jvmLibrary"){
            id ="medicare.jvm.library"
            implementationClass ="JvmLibraryConventionPlugin"
        }

        register("androidHilt") {
            id = "medicare.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "medicare.android.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("androidFeature") {
            id = "medicare.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }

        register("androidRoom") {
            id = "medicare.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
    }
}