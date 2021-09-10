import org.gradle.api.artifacts.dsl.DependencyHandler

internal object Room {
  private const val version = "2.3.0"
  const val gradle_plugin = "androidx.room:room-runtime:$version"
  const val annotation = "androidx.room:room-compiler:$version"
  const val kapt = "androidx.room:room-compiler:$version"
  const val ksp = "androidx.room:room-compiler:$version"
  const val coroutine = "androidx.room:room-ktx:$version"
  const val rxjava2 = "androidx.room:room-rxjava2:$version"
  const val rxjava3 = "androidx.room:room-rxjava3:$version"
  const val guava = "androidx.room:room-guava:$version"
  const val testing = "androidx.room:room-testing:$version"
  const val paging3 = "androidx.room:room-paging:2.4.0-alpha04"
}

fun DependencyHandler.room() {
  implementation(Room.gradle_plugin)
  kapt(Room.kapt)
  implementation(Room.coroutine)
  androidTestImplementation(Room.testing)
}