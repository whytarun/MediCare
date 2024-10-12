 plugins {
     alias(libs.plugins.medicare.android.library)
     alias(libs.plugins.medicare.android.hilt)
     alias(libs.plugins.medicare.android.room)
 }

 android {
  namespace ="com.medicare.data"

 }

 dependencies {
     implementation(project(":core:model"))
     implementation(project(":core:database"))
 }