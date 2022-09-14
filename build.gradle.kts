// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id (Config.pluginAndroidApp) version Versions.pluginAndroidVersion apply false
    id (Config.pluginAndroidLibrary) version Versions.pluginAndroidLibraryVersion apply false
    id (Config.pluginJetBrainsKotlin) version Versions.pluginJetBrainsVersions apply false
    id (Config.pluginSafeArgsKotlin) version Versions.pluginSafeArgsVersion apply false
}



tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}