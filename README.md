# 📝 DailyDev - Registro Diário de Estudos para Devs

O **DailyDev** é um projeto backend desenvolvido em **Java com Spring Boot**, criado para registrar a rotina de um desenvolvedor, incluindo:

- Quantas horas estudou no dia
- Qual foi o humor do dia
- Quais tecnologias aprendeu
- Quais foram os desafios enfrentados
- E anotações livres

Agora com autenticação segura! 🔐

Tudo isso com persistência em banco de dados, documentação automática via Swagger e pronto para produção com Docker! 🐳

---

## 📌 Versão Atual

`v1.1.0` — Adicionadas as funcionalidades de autenticação com **Spring Security + JWT**, incluindo login, registro de usuários e proteção de endpoints.

---

## 📚 Tecnologias Utilizadas

- ✅ **Java 17**
- ✅ **Spring Boot 3.x**
- ✅ **Spring Web**
- ✅ **Spring Security**
- ✅ **JWT (JSON Web Token)**
- ✅ **Spring Validation**
- ✅ **Flyway (Migração automática do banco)**
- ✅ **PostgreSQL**
- ✅ **Swagger OpenAPI (Springdoc)**
- ✅ **Docker e Docker Compose**
- ✅ **Lombok (ou getters/setters manuais)**
- ✅ **Maven**

---

## 🔐 Autenticação

- Endpoint de cadastro: `POST /auth/register`
- Endpoint de login: `POST /auth/login`
- Token JWT gerado ao fazer login
- Uso do token com `Bearer` em headers para acessar endpoints protegidos
- Validação automática de token e autenticação com `SecurityFilter`

---

## 🧠 Funcionalidades

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/dailyentry` | Cria um novo registro |
| `GET` | `/dailyentry` | Retorna todos os registros |
| `GET` | `/dailyentry/{id}` | Retorna um registro específico |
| `PUT` | `/dailyentry/{id}` | Atualiza um registro |
| `DELETE` | `/dailyentry/{id}` | Remove um registro |

> ⚠️ Os endpoints estão protegidos. É necessário estar autenticado para utilizá-los.

Todos os endpoints estão **documentados via Swagger**!

---

## 📦 Como Rodar Localmente

### ✅ Pré-requisitos:

- Java 17
- Maven
- Docker

---

### 📥 Clonar o projeto

```bash
git clone https://github.com/SEU_USUARIO/dailydev.git
cd dailydev
```

# #🐳 Subir o banco com Docker Compose

```bash
docker-compose up -d
```

Isso sobe um container PostgreSQL acessível em localhost:5432

# #📜 Rodar as migrations com Flyway (automático)
As migrations já estão configuradas para criar a tabela daily_entry automaticamente ao subir o projeto.

# #🚀 Rodar a aplicação
```
./mvnw spring-boot:run
```

Isso inicia o backend local na porta 8080


# #✨ Autor
Desenvolvido por Matheus Yuri Silva 💙
Estudante de ADS e apaixonado por backend e código limpo.

