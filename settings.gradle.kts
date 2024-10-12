gradle.startParameter.excludedTaskNames.addAll(listOf(":build-logic:convention:testClasses"))
pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MediCare"
include(":app")
include(":core")
include(":core:common")
include(":core:data")
include(":core:database")
include(":core:model")
include(":core:network")
include(":core:designsystem")
include(":core:ui")
include(":feature")
include(":feature:auth")
