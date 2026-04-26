# Litchi - Backend

## Stack

**Backend**
- Spring Boot 4 (Java 21)
- Spring Cloud Gateway
- Spring Security + JWT
- Spring Data JPA

**Infraestrutura**
- PostgreSQL
- Redis
- RabbitMQ
- Nginx

## Servicos

| Servico | Porta | Responsabilidade |
|---|---|---|
| api-gateway | 8080 | Roteamento e validacao JWT |
| auth-service | 8081 | Registro, login, tokens |
| user-service | 8082 | Perfil e presenca online |
| server-service | 8083 | Servidores e canais |
| message-service | 8084 | Historico de mensagens |
| ws-service | 8085 | WebSocket em tempo real |

## Requisitos

- Docker e Docker Compose
- Java 21

## Configuracao

Copie o arquivo de exemplo e preencha as variaveis:

```bash
cp .env.example .env
```

Variaveis necessarias no `.env`:

```
POSTGRES_USER=userexample
POSTGRES_PASSWORD=passwordexample
JWT_SECRET=hashexample
```

## Rodando localmente

Subir apenas a infraestrutura (recomendado durante o desenvolvimento):

```bash
docker compose -f docker-compose.infra.yml up
```

Rodar um servico Spring individualmente:

```bash
cd backend/auth-service
./mvnw spring-boot:run
```

## Subindo tudo junto

```bash
docker compose up --build
```

O gateway fica disponível em `http://localhost:8080`.

## Estrutura

```
litchi-backend/
├── docker-compose.yml
├── docker-compose.infra.yml
├── .env
├── init-db.sql
├── nginx.conf
├── api-gateway/
├── auth-service/
├── user-service/
├── server-service/
├── message-service/
└── ws-service/
```

## Status do projeto - EM ANDAMENTO

- [x] Infraestrutura Docker
- [x] auth-service
- [x] api-gateway
- [ ] user-service
- [ ] server-service
- [ ] message-service
- [ ] ws-service