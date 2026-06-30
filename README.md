# Sistema de Tarefas

Projeto desenvolvido com Spring Boot para gerenciamento de tarefas.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- Banco de dados H2
- Maven

---

## 📋 Funcionalidades

- Login de usuário
- Listagem de tarefas
- Criação de tarefas
- Edição de tarefas
- Exclusão de tarefas
- Banco de dados em memória (H2)

---

## ▶️ Como executar o projeto

### 1. Clonar o repositório
git clone https://github.com/Uelinton02S/sistematarefas.git

### 2. Rodar o spring boot
 Linux: ./mvnw spring-boot:run
 Windowns: mvnw.cmd spring-boot:run ou .\mvnw.cmd spring-boot:run

### 2. Cole no navegador

http://localhost:8080/login

H2 Console:
http://localhost:8080/h2-console

inserir no powershell para o h2: Invoke-RestMethod -Uri "http://localhost:8080/api/usuarios" `
  -Method POST `
  -Headers @{ "Content-Type" = "application/json" } `
  -Body '{"nome":"Seu Nome","email":"seu@email.com","senha":"123456"}'
