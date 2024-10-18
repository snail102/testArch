pluginManagement {
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

rootProject.name = "TestArchitecture"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":core:di")
include(":feature:authorization:authorization-api")
include(":feature:authorization:authorization-impl")
include(":core:di-compose")
include(":core:domain")
include(":core:data")
include(":utils:utils-compose")
include(":feature:tab-first:tab-first-api")
include(":feature:tab-first:tab-first-impl")
include(":feature:tab-second:tab-second-api")
include(":feature:tab-second:tab-second-impl")
include(":feature:test:test-api")
include(":feature:test:test-impl")
include(":core:navigation")
