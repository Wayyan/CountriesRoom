plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("kapt")
  id("dagger.hilt.android.plugin")
  //id(KtLint.name)
  id("kotlin-android")
}

android {
  compileSdk = BuildConfig.compileSdk

  defaultConfig {
    applicationId = "com.devduo.countriesroom"
    minSdk = BuildConfig.minSdk
    targetSdk = BuildConfig.targetSdk
    versionCode = BuildConfig.vCode
    versionName = BuildConfig.vName

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    buildFeatures {
      viewBinding = true
    }

  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
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
  implementation(project(":base"))

  coreLibraryDesugaring(CommonLibs.desugar_lib)

  implementation(Kotlin.stdblib_jdk)

  //AndroidX
  implementation(AndroidXAppCompat.app_compat)
  implementation(AndroidXCore.core_ktx)
  implementation(AndroidXActivity.activity_ktx)
  implementation(AndroidXFragment.fragment_ktx)
  androidXArch()
  implementation(AndroidXRecyclerView.recycler_view)
  implementation(AndroidXPreference.preference_ktx)

  //Material
  implementation(Material.material)

  //Constraint Layout
  implementation(AndroidXConstraintLayout.constraint_layout)

  //Test
  testImplementation(CommonLibs.junit)
  mockito()
  mockitoAndroid()
  androidXTest()
  androidXEspresso()

  //dagger
  daggerJvm()
  daggerHilt()
  daggerHiltAndroidX()
  daggerAssistedInject()
}