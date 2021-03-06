plugins {
    application
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
    id("com.bmuschko.docker-spring-boot-application")
}

application {
    mainClassName = "com.github.m_burst.alfabattle.task2.ApplicationKt"
}

docker {
    springBootApplication {
        baseImage.set("openjdk:11")
    }
}

dependencies {
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))

    implementation(Dependencies.SpringBoot.starterWeb)
    implementation(Dependencies.SpringBoot.starterJetty)
    implementation(Dependencies.Jackson.moduleKotlin)

    implementation(Dependencies.SpringKafka.core)

    testImplementation(Dependencies.SpringBoot.starterTest)
    testImplementation(Dependencies.SpringKafka.test)
}

configurations.all {
    resolutionStrategy {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")

        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}
