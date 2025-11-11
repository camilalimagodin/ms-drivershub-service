# 📋 Registro de Alterações

Todas as mudanças notáveis neste projeto serão documentadas neste arquivo.

O formato é baseado em [Keep a Changelog](https://keepachangelog.com/pt-BR/1.1.0/),
e este projeto adere ao [Versionamento Semântico](https://semver.org/lang/pt-BR/).

---

## [Não Lançado]

### 🚀 Planejado
- Implementação de endpoints REST para CRUD de motoristas
- Integração completa com Keycloak para autenticação OAuth2
- Dashboard personalizado no Grafana para monitoramento
- Documentação completa da API com Swagger/OpenAPI
- Testes de integração end-to-end
- CI/CD pipeline com GitHub Actions
- Containerização da aplicação

---

## [0.0.1-SNAPSHOT] - 2025-11-11

### ✨ Adicionado

#### 🏗️ Infraestrutura e Configuração
- Projeto inicial Spring Boot 3.5.7 com Kotlin 1.9.25
- Configuração do Java 21 como versão da JVM
- Gradle 8.x como ferramenta de build com Kotlin DSL
- Arquivo `.gitignore` configurado para projeto Kotlin/Spring
- Configuração de variáveis de ambiente (`.env`) para dados sensíveis
- Arquivo de exemplo `.env.example` para referência

#### 🐳 Docker e Containers
- Docker Compose completo com os seguintes serviços:
  - **PostgreSQL 16** (porta 5432) - Banco de dados da aplicação
  - **PostgreSQL 16** (porta 5433) - Banco de dados do Keycloak
  - **Keycloak** (porta 8081) - Servidor de autenticação e autorização
  - **Prometheus** (porta 9091) - Coleta de métricas
  - **Grafana** (porta 3000) - Visualização de métricas e dashboards
- Volumes persistentes para todos os serviços de banco de dados
- Rede isolada (`app-network`) para comunicação entre containers

#### 📊 Monitoramento e Observabilidade
- Spring Boot Actuator configurado com endpoints:
  - `/actuator/health` - Status de saúde da aplicação
  - `/actuator/info` - Informações da aplicação
  - `/actuator/prometheus` - Métricas no formato Prometheus
- Arquivo `prometheus.yml` configurado para scraping de métricas
- Micrometer com registro Prometheus habilitado
- Provisioning automático de datasources no Grafana
- Diretório `grafana_provisioning/datasources/` para configurações

#### 🗄️ Banco de Dados
- Spring Data JPA para persistência de dados
- ~~Flyway Migration~~ inicialmente configurado (descartado)
- **Liquibase** implementado para migrações de banco de dados
  - Arquivo `db.changelog.sql` criado para versionamento do schema
  - Suporte completo para PostgreSQL 16+
- Configuração de conexão com PostgreSQL via variáveis de ambiente

#### 🔐 Segurança
- Spring Security configurado
- Integração com Keycloak preparada
- Variáveis de ambiente para credenciais:
  - Banco de dados (usuário, senha, nome do banco)
  - Keycloak admin (usuário e senha)
  - Grafana admin (usuário e senha)

#### 🧩 Dependências e Bibliotecas
- **Spring Boot Starters:**
  - `spring-boot-starter-web` - REST APIs
  - `spring-boot-starter-data-jpa` - Persistência JPA
  - `spring-boot-starter-security` - Segurança
  - `spring-boot-starter-actuator` - Métricas e health checks
  - `spring-boot-starter-validation` - Validação de dados
  - `spring-boot-starter-data-rest` - REST Repositories
- **Spring Cloud:**
  - `spring-cloud-starter-openfeign` - Cliente HTTP declarativo
  - Spring Cloud Version: 2025.0.0
- **Banco de Dados:**
  - Liquibase Core - Migrações de banco de dados
  - PostgreSQL Driver
- **Monitoramento:**
  - Micrometer Registry Prometheus
- **Kotlin:**
  - `jackson-module-kotlin` - Serialização JSON
  - `kotlin-reflect` - Reflection
- **Testes:**
  - Spring Boot Testcontainers
  - Testcontainers PostgreSQL
  - Testcontainers JUnit Jupiter
  - Spring REST Docs MockMVC
  - Spring Security Test
  - JUnit 5 Platform Launcher

#### ⚙️ Configurações da Aplicação
- `application.yml` - Configuração principal
  - Nome da aplicação: `drivers-hub-services`
  - Endpoints Actuator expostos
  - Métricas Prometheus habilitadas
- `application-dev.yml` - Perfil de desenvolvimento
- Configuração de datasource externalizada

#### 📝 Plugins Gradle
- `kotlin("jvm")` - Compilador Kotlin
- `kotlin("plugin.spring")` - Spring support para Kotlin
- `kotlin("plugin.jpa")` - JPA support para Kotlin
- `org.springframework.boot` - Build de aplicações Spring Boot
- `io.spring.dependency-management` - Gerenciamento de dependências
- `org.asciidoctor.jvm.convert` - Geração de documentação

#### 🔧 Configurações Kotlin
- Anotações `all-open` para entidades JPA:
  - `@Entity`
  - `@MappedSuperclass`
  - `@Embeddable`
- Compiler flag: `-Xjsr305=strict` para null-safety

### 🔄 Modificado
- Extensão do arquivo de configuração alterada de `.properties` para `.yml`
- Correção no `docker-compose.yml`: `servicess` → `services`
- Nome das variáveis de ambiente do Grafana padronizadas:
  - `GRAFANA_ADMIN_USER`
  - `GRAFANA_ADMIN_PASSWORD`

### ❌ Removido
- Flyway Community Edition (não suporta PostgreSQL 16+)
- Credenciais hardcoded dos arquivos de configuração

### 🐛 Corrigido
- Correção de typo no `docker-compose.yml` (nome de serviço)
- Correção nas variáveis de ambiente do Grafana

### 🔒 Segurança
- Centralização de senhas e credenciais no arquivo `.env`
- Arquivo `.env` adicionado ao `.gitignore`
- Remoção de dados sensíveis versionados

---

## 📌 Tipos de Mudanças

- ✨ **Adicionado** - para novas funcionalidades
- 🔄 **Modificado** - para mudanças em funcionalidades existentes
- 🗑️ **Descontinuado** - para funcionalidades que serão removidas em breve
- ❌ **Removido** - para funcionalidades removidas
- 🐛 **Corrigido** - para correção de bugs
- 🔒 **Segurança** - para vulnerabilidades de segurança corrigidas

---

## 🔗 Links

- [Repositório](https://github.com/douglasdreer/drivers-hub)
- [Issues](https://github.com/douglasdreer/drivers-hub/issues)
- [Pull Requests](https://github.com/douglasdreer/drivers-hub/pulls)

---

**Legenda de Ícones:**
- 🚀 Planejado
- ✨ Novo recurso
- 🏗️ Infraestrutura
- 🐳 Docker/Containers
- 📊 Monitoramento
- 🗄️ Banco de dados
- 🔐 Segurança
- 🧩 Dependências
- ⚙️ Configuração
- 📝 Documentação
- 🔧 Ferramentas
- 🔄 Alteração
- ❌ Remoção
- 🐛 Correção
- 🔒 Segurança crítica

---

*Mantido por: Douglas Dreer ([@douglasdreer](https://github.com/douglasdreer))*

*Última atualização: 2025-11-11*

