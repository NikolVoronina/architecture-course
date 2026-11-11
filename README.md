# Architecture Course

Assignments for a software architecture course.

| # | Topic | Contents | Stack | Status |
|---|---|---|---|---|
| 01 | [SOLID](01-Solid/App) | Refactoring a pension calculation service using the SOLID principles | Java 21, Maven, JUnit 5 | ✅ Done |
| 03 | [REST](03-Rest) | "Travellers Handbook" full-stack app: REST API, UI, database, Kubernetes | Java / Spring Boot, .NET, React, MySQL, Docker | ⏳ Upcoming |
| 07 | [Messaging](07-Messaging/employee-mq-app) | Messaging through a queue | Spring Boot, ActiveMQ, Docker | ⏳ Upcoming |

## Structure

```
.
├── 01-Solid/App              ← SOLID
├── 03-Rest
│   ├── api-java              ← REST API (Spring Boot)
│   ├── api-dotnet            ← REST API (.NET)
│   ├── ui                    ← React client
│   ├── db                    ← MySQL in Docker
│   └── namespace, ingress    ← Kubernetes manifests
└── 07-Messaging
    └── employee-mq-app       ← ActiveMQ app
```

## Pushing changes

```bash
git add -A
git commit -m "What was done"
git push
```
