# Litchi Web Chat

Chat em tempo real com servidores e canais de texto, inspirado no Discord.

## Stack

**Frontend**
- React + Vite
- Tailwind CSS + DaisyUI
- STOMP.js (WebSocket)

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
- Node 22

## Configuracao

Copie o arquivo de exemplo e preencha as variaveis:

```bash
cp .env.example .env
```

Variaveis necessarias no `.env`:

```
POSTGRES_USER=discord
POSTGRES_PASSWORD=
JWT_SECRET=
```

## Rodando localmente

Subir apenas a infraestrutura (recomendado durante o desenvolvimento):

```bash
docker compose up postgres redis rabbitmq
```

Rodar um servico Spring individualmente:

```bash
cd backend/auth-service
./mvnw spring-boot:run
```

Rodar o frontend:

```bash
cd frontend
npm install
npm run dev
```

## Subindo tudo junto

```bash
docker compose up --build
```

O frontend fica disponivel em `http://localhost` e o gateway em `http://localhost:8080`.

## Estrutura

```
litchi/
├── docker-compose.yml
├── nginx.conf
├── .env
├── .env.example
├── frontend/
│   ├── Dockerfile
│   └── src/
└── backend/
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
- [ ] api-gateway
- [ ] user-service
- [ ] server-service
- [ ] message-service
- [ ] ws-service
- [ ] Frontend