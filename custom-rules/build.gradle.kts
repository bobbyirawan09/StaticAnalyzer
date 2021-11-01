apply(plugin = "java-library")
apply(plugin = "kotlin")

repositories {
    google()
    mavenCentral()
}

dependencies {
    "compileOnly"("io.gitlab.arturbosch.detekt:detekt-api:1.18.1")
    "implementation"("io.gitlab.arturbosch.detekt:detekt-cli:1.18.1")

    "testImplementation"("junit:junit:4.13")
    "testImplementation"("io.gitlab.arturbosch.detekt:detekt-test:1.18.1")
    // Needed because of detekt-test
    "testImplementation"("org.assertj:assertj-core:3.20.2")
}