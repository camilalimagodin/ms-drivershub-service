# Drivers Hub

![Kotlin](https://img.shields.io/badge/Kotlin-1.9.25-purple?logo=kotlin)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-green?logo=springboot)
![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![License](https://img.shields.io/badge/License-MIT-blue.svg)

Sistema de gerenciamento de motoristas desenvolvido com Kotlin e Spring Boot.

## 📋 Descrição

O **Drivers Hub** é uma aplicação de microsserviços para gerenciar motoristas, construída com tecnologias modernas e boas práticas de desenvolvimento. O projeto utiliza Spring Cloud, segurança com Keycloak, observabilidade com Prometheus e Grafana, e banco de dados PostgreSQL.

## 🚀 Tecnologias

- **Linguagem:** Kotlin 1.9.25
- **Framework:** Spring Boot 3.5.7
- **Java:** 21
- **Banco de Dados:** PostgreSQL 16
- **Autenticação:** Keycloak
- **Monitoramento:** Prometheus + Grafana
- **Build:** Gradle
- **Containerização:** Docker Compose

### Principais Dependências

- Spring Data JPA
- Spring Security
- Spring Cloud OpenFeign
- Spring Boot Actuator
- Spring REST Docs
- Flyway (Migrations)
- Testcontainers
- Micrometer (Prometheus)

## 📦 Pré-requisitos

- Java 21 ou superior
- Docker e Docker Compose
- Gradle (ou use o wrapper incluído)

## 🔧 Configuração

### Variáveis de Ambiente

Crie um arquivo `.env` na raiz do projeto com as seguintes variáveis:

```env
# Database
APPLICATION_DATABASE_NAME=drivershub
APPLICATION_DATABASE_USER=postgres
APPLICATION_DATABASE_PASSWORD=postgres

# Keycloak Database
KEYCLOAK_DATABASE_NAME=keycloak
KEYCLOAK_DATABASE_USER=keycloak
KEYCLOAK_DATABASE_PASSWORD=keycloak

# Keycloak Admin
KEYCLOAK_ADMIN_USER=admin
KEYCLOAK_ADMIN_PASSWORD=admin

# Grafana
GRAFANA_ADMIN_USER=admin
GRAFANA_ADMIN_PASSWORD=admin
```

## 🏃 Como Executar

### 1. Iniciar os serviços de infraestrutura

```bash
docker-compose up -d
```

Isso iniciará:
- PostgreSQL (porta 5432) - Banco principal
- PostgreSQL (porta 5433) - Banco do Keycloak
- Keycloak (porta 8081)
- Prometheus (porta 9091)
- Grafana (porta 3000)

### 2. Compilar o projeto

```bash
# No Windows
gradlew.bat build

# No Linux/Mac
./gradlew build
```

### 3. Executar a aplicação

```bash
# No Windows
gradlew.bat bootRun

# No Linux/Mac
./gradlew bootRun
```

A aplicação estará disponível em `http://localhost:8080`

## 🧪 Testes

Para executar os testes:

```bash
# No Windows
gradlew.bat test

# No Linux/Mac
./gradlew test
```

Os testes utilizam Testcontainers para garantir um ambiente isolado e consistente.

## 📊 Monitoramento

### Endpoints do Actuator

- Health: `http://localhost:8080/actuator/health`
- Info: `http://localhost:8080/actuator/info`
- Metrics: `http://localhost:8080/actuator/prometheus`

### Prometheus

Acesse o Prometheus em: `http://localhost:9091`

### Grafana

Acesse o Grafana em: `http://localhost:3000`
- Usuário: definido em `GRAFANA_ADMIN_USER`
- Senha: definido em `GRAFANA_ADMIN_PASSWORD`

## 🔐 Keycloak

Acesse o Keycloak em: `http://localhost:8081`
- Usuário: definido em `KEYCLOAK_ADMIN_USER`
- Senha: definido em `KEYCLOAK_ADMIN_PASSWORD`

## 📁 Estrutura do Projeto

```
drivers-hub/
├── src/
│   ├── main/
│   │   ├── kotlin/
│   │   │   └── io/github/douglasdreer/drivershub/
│   │   └── resources/
│   │       ├── application.yml
│   │       ├── application-dev.yml
│   │       └── db/changelog/
│   └── test/
│       └── kotlin/
├── build.gradle.kts
├── docker-compose.yml
├── prometheus.yml
└── README.md
```

## 🛠️ Scripts Gradle

- `./gradlew build` - Compila o projeto
- `./gradlew test` - Executa os testes
- `./gradlew bootRun` - Executa a aplicação
- `./gradlew clean` - Limpa os arquivos de build
- `./gradlew bootJar` - Gera o JAR executável

## 📝 Migrações de Banco de Dados

As migrações são gerenciadas pelo Flyway e ficam em:
```
src/main/resources/db/changelog/
```

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT.

## 👤 Autor

**Douglas Dreer**
- GitHub: [@douglasdreer](https://github.com/douglasdreer)

## 📞 Suporte

Para suporte, abra uma issue no repositório do GitHub.

---

Desenvolvido com ❤️ usando Kotlin e Spring Boot

