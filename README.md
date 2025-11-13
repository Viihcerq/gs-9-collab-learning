# 🚀 GS-9: API da Plataforma Collab Learning

Este é o repositório da API de backend para a Global Solution de Engenharia de Software da FIAP. O projeto foca na criação dos serviços para uma plataforma de aprendizagem colaborativa e global.

![Status](https://img.shields.io/badge/status-em_desenvolvimento-yellow)
![Java](https://img.shields.io/badge/Java-17-blue)
![Spring](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen)
![Docker](https://img.shields.io/badge/Docker-blue)

## 👥 Grupo

| Nome Completo             | RM           |
|:--------------------------|:-------------|
| Vitoria Cerqueira Santos  | 552509       |
| Leonardo de Matos Queiroz | 552500       |

## 📖 Tema: Aprendizagem Colaborativa e Global

> **[Aqui você deve escrever a descrição do tema escolhido pelo grupo]**
>
> *"O tema explora a criação de uma plataforma digital onde estudantes de diferentes partes do mundo podem se conectar para aprender e construir projetos juntos, quebrando barreiras geográficas e promovendo a troca de conhecimento."*

## 🏁 Execução Local

Para rodar o projeto na sua máquina local, siga os passos abaixo.

### Pré-requisitos

* Git
* Java JDK 17 (ou superior)
* Apache Maven 3.x
* Docker Desktop (Opcional, para rodar via container)

### Passos para Rodar

1.  Clone o repositório:
    ```bash
    git clone https://github.com/Viihcerq/gs-9-collab-learning.git
    cd gs-9-collab-learning
    ```

2.  Compile o projeto e rode os testes (baseado no seu CI):
    ```bash
    mvn clean package
    ```

3.  Execute a aplicação usando o Spring Boot:
    ```bash
    mvn spring-boot:run
    ```

4.  A aplicação estará rodando. Você pode acessar o endpoint de informações em:
    `http://localhost:8081/info`

## 🐳 Imagem no Docker Hub

A imagem desta aplicação é construída e enviada para o Docker Hub automaticamente pelo nosso workflow de Continuous Delivery.

**URL da Imagem:**
[https://hub.docker.com/r/viihcerq/gs-9-collab-learning](https://hub.docker.com/r/viihcerq/gs-9-collab-learning)

### Como usar a imagem Docker

1.  Faça o pull da imagem mais recente:
    ```bash
    docker pull viihcerq/gs-9-collab-learning:latest
    ```

2.  Rode um container a partir da imagem, mapeando a porta `8081`:
    ```bash
    docker run -d -p 8081:8081 viihcerq/gs-9-collab-learning:latest
    ```

3.  Acesse a aplicação no seu navegador em `http://localhost:8081/info`.

## ⚙️ Workflows de CI/CD

O projeto utiliza GitHub Actions para automatizar os processos de integração, versionamento e entrega.

### 1. Continuous Integration (CI)
* **Arquivo:** `.github/workflows/continuous-integration.yml`
* **Trigger:** Disparado em todo `push` para branches `feature/**`, `release` ou `hotfix`.
* **Ações:**
    1.  **Checkout:** Baixa o código da branch.
    2.  **Build da Aplicação:** Roda `mvn clean package -DskipTests` para compilar o código e criar o `.jar` sem rodar os testes.
    3.  **Execução de Testes:** Roda `mvn test` para validar a integridade do código.
    4.  **Teste de Imagem Docker:** Roda `docker build` para garantir que o `Dockerfile` está correto e a imagem pode ser construída.

### 2. Continuous Delivery (CD)
* **Arquivo:** `.github/workflows/continuous-delivery.yml`
* **Trigger:** Disparado em toda `pull_request` enviada para a branch `develop`.
* **Ações:**
    1.  **Checkout:** Baixa o código.
    2.  **Login no Docker Hub:** Autentica no Docker Hub usando credenciais seguras.
    3.  **Build and Push:** Constrói a imagem Docker e a envia (`push`) para o repositório `viihcerq/gs-9-collab-learning:latest`.

### 3. Versionamento Automático
* **Arquivo:** `.github/workflows/versionamento.yml`
* **Trigger:** Disparado em todo `push` para a branch `develop` (ou seja, após um merge).
* **Ações:**
    1.  **Release Please:** Utiliza a action `release-please-action` para analisar os commits desde a última release.
    2.  Com base nos commits, ela automaticamente:
        * Define a nova versão do projeto (ex: 1.0.1, 1.1.0).
        * Cria um Pull Request para a branch `develop` contendo o `CHANGELOG.md` atualizado e as versões de pom.xml alteradas.
        * Quando esse PR é "mergeado", ele cria a tag de release no GitHub.