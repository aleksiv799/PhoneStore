plugins {
    id(Config.pluginAndroidApp)
    id(Config.pluginJetBrainsKotlin)
    id(Config.pluginKotlinParcelize)
    id(Config.pluginSafeArgsKotlin)
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = Config.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }

    productFlavors {

    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(Deps.coreKTX)
    implementation(Deps.stdLib)
    implementation(Deps.appCompat)
    implementation(Deps.material)
    implementation(Deps.constraintLayout)
    implementation(Deps.lifeCycle)
    implementation(Deps.timber)
    testImplementation(Deps.jUnit)
    androidTestImplementation(Deps.jUnitX)
    androidTestImplementation(Deps.espressoCore)


    // implementation navigation
    implementation(Deps.navigationFragmentKTX)
    implementation(Deps.navigationUiKTX)
    implementation(Deps.fragmentKTX)

}