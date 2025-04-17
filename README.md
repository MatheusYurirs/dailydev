# 📝 DailyDev - Registro Diário de Estudos para Devs

O **DailyDev** é um projeto backend desenvolvido em **Java com Spring Boot**, criado para registrar a rotina de um desenvolvedor, incluindo:

- Quantas horas estudou no dia
- Qual foi o humor do dia
- Quais tecnologias aprendeu
- Quais foram os desafios enfrentados
- E anotações livres

Tudo isso com persistência em banco de dados, documentação automática via Swagger e pronto para produção com Docker! 🐳

---

## 📚 Tecnologias Utilizadas

- ✅ **Java 17**
- ✅ **Spring Boot 3.x**
- ✅ **Spring Web**
- ✅ **Spring Validation**
- ✅ **Flyway** (Migração automática do banco)
- ✅ **PostgreSQL**
- ✅ **Swagger OpenAPI (Springdoc)**
- ✅ **Docker e Docker Compose**
- ✅ **Lombok (ou getters/setters manuais)**
- ✅ **Maven**

---

## 🧠 Funcionalidades

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/dailyentry` | Cria um novo registro |
| `GET` | `/dailyentry` | Retorna todos os registros |
| `GET` | `/dailyentry/{id}` | Retorna um registro específico |
| `PUT` | `/dailyentry/{id}` | Atualiza um registro |
| `DELETE` | `/dailyentry/{id}` | Remove um registro |

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

# #🔍 Acessar a Documentação Swagger
Após subir a aplicação, acesse:
```
http://localhost:8080/swagger-ui/index.html
```

# #✨ Autor
Desenvolvido por Matheus Yuri Silva 💙
Estudante de ADS e apaixonado por backend e código limpo.

