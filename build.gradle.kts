plugins {
    id("java")
    application
}

group = "br.com.gui"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.mysql:mysql-connector-j:26.7.0")
    implementation("org.flywaydb:flyway-core:10.15.0")
    implementation("org.flywaydb:flyway-mysql:10.15.0")
    implementation("net.datafaker:datafaker:2.7.0")


    compileOnly("org.projectlombok:lombok:1.18.46")
    annotationProcessor("org.projectlombok:lombok:1.18.46")
    }

application {
    mainClass.set("br.com.gui.Main")
}