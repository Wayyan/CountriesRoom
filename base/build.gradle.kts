plugins {
  id("com.android.library")
  id("kotlin-android")
  kotlin("android")
  kotlin("kapt")
}

android {
  compileSdk = BuildConfig.compileSdk

  defaultConfig {
    minSdk = BuildConfig.minSdk
    targetSdk = BuildConfig.targetSdk

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")

    buildFeatures {
      viewBinding = true
    }

    multiDexEnabled = true
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
    }
  }

  compileOptions {
    isCoreLibraryDesugaringEnabled = false
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {
  api(project(":data:cache"))
  api(project(":data:network"))
  api(project(":data:framework"))
  api(project(":domain"))

  implementation(Kotlin.stdblib_jdk)
  implementation(AndroidXCore.core_ktx)
  implementation(AndroidXAppCompat.app_compat)
  implementation(Material.material)

  testImplementation(CommonLibs.junit)
  androidTestImplementation(AndroidXTestExt.junit)
  androidTestImplementation(AndroidXEspresso.core)

  //dagger
  daggerJvm()
  daggerHilt()
}