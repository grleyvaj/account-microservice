# account-microservice
Microservice for manage accounts and movements

### Imagen de docker para rabbit
```bash
docker run -d --name rabbitmq \
  -p 5672:5672 -p 15672:15672 \
  -e RABBITMQ_DEFAULT_USER=guest \
  -e RABBITMQ_DEFAULT_PASS=guest \
  rabbitmq:3-management
```

### Comando útiles de docker para rabbit
Consola web de rabbit: http://localhost:15672

Detener rabbit: `docker stop rabbitmq`

Eliminar rabbit: `docker rm rabbitmq`

Obtener la IP:
```bash
docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' rabbitmq
```


### Documentación de la API
- http://localhost:8082/swagger-ui/index.html#/