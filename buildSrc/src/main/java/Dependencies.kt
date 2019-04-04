object Versions {

    const val appCompat = "1.0.2"
    const val coreKtx = "1.0.1"
    const val constraintLayout = "1.1.3"

    const val junit = "4.12"
    const val androidxJunitExt = "1.1.0"
    const val espressoCore = "3.1.1"
}

object Dependencies {
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${ProjectProps.kotlin}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.androidxJunitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}

object ProjectProps {

    const val kotlin = "1.3.21"
    const val minSdk = 21
    const val compileSdk = 28
    const val targetSdk = 28
    const val applicationId = "com.kshitijchauhan.haroldadmin.unittests"
}