/*
 * Plugins que habilitam as "ferramentas" do build: Kotlin, Spring Boot, etc.
 */
plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25" // Habilita o 'all-open' do Spring
    kotlin("plugin.jpa") version "1.9.25"     // Habilita o 'all-open' para @Entity (JPA)
    id("org.springframework.boot") version "3.5.7"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.asciidoctor.jvm.convert") version "3.3.2" // Para Spring REST Docs
}

/**
 * Versionamento das libraries utilizadas no projeto.
 */


// --- Metadados do Projeto ---
group = "io.github.douglasdreer"
version = "0.0.1-SNAPSHOT"
description = "drivers-hub"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

// --- Propriedades "extra" para o build (type-safe) ---
val snippetsDir by extra { file("build/generated-snippets") }
val springCloudVersion by extra { "2025.0.0" }

// Configura o 'annotationProcessor' para ser incluído no 'compileOnly'
configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

// Repositório de onde o Gradle baixa as dependências
repositories {
    mavenCentral()
}


/*
 * ===================================================================
 * DEPENDÊNCIAS (Agrupadas por responsabilidade, como o Sonar gosta)
 * ===================================================================
 */
dependencies {
    // --- 1. Spring Boot Starters ---
    // O núcleo da sua aplicação
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")

    // --- 2. Spring Cloud ---
    // Módulos do ecossistema Spring Cloud
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    // --- 3. Kotlin & Jackson ---
    // Suporte essencial para o Kotlin e serialização JSON
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // --- 4. Database & Migrations ---
    implementation("org.liquibase:liquibase-core")

    runtimeOnly("org.postgresql:postgresql") // <-- CORREÇÃO 1: Adicionado driver JDBC

    // --- 5. Observability ---
    // O conector para o Prometheus
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")

    // --- 6. Build Tools ---
    // Habilita o @ConfigurationProperties do Spring
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    // --- 7. Testes (Core & Helpers) ---
    // Dependências principais de teste
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // --- 8. Testes (Testcontainers) ---
    // O kit completo para testes de integração
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
}

/*
 * Gerenciamento de Versões
 * Define um "contrato" de versões (BOM) para as dependências do Spring Cloud.
 */
dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")
    }
}

// Configurações do compilador Kotlin
kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

/*
 * Configuração de Tarefas (Tasks)
 */
// Habilita o JUnit 5 para a tarefa 'test'
tasks.withType<Test> {
    useJUnitPlatform()
}

// Configura a tarefa 'test' para o Spring REST Docs
tasks.test {
    outputs.dir(snippetsDir)
}

// Configura a tarefa 'asciidoctor' (REST Docs) para rodar DEPOIS dos testes
tasks.asciidoctor {
    inputs.dir(snippetsDir)
    dependsOn(tasks.test)
}