# =========================
# ETAPA 1: BUILD
# =========================
#“Usa una imagen base que tenga Maven y Java 17, y llámala builder”.
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Variables para mejorar el caché de Maven
#Define la carpeta dentro del contenedor donde vas a trabajar.
#Si no existe, Docker la crea automáticamente.
#En este caso: /build.
WORKDIR /build

#Copia el pom.xml (archivo de configuración Maven) desde tu máquina al contenedor.
COPY pom.xml .

#Hace que Maven descargue todas las dependencias sin compilar el código aún.
#Esto acelera las futuras construcciones, porque las dependencias quedan en caché.
#💡 Truco de rendimiento muy útil.
RUN mvn dependency:go-offline

#Copia el código fuente (/src) a la carpeta /build/src del contenedor.
COPY src ./src

#Ejecuta el comando Maven que compila y empaqueta tu aplicación:
#clean: limpia cualquier build anterior
#package: crea el .jar final dentro de /build/target
#-DskipTests: salta los tests (para compilar más rápido)
#📦 Al terminar esta etapa, tenés tu archivo app.jar listo en /build/target.
RUN mvn clean package -DskipTests

# =========================
# ETAPA 2: RUNTIME
# =========================

#Crea una nueva imagen, esta vez mucho más liviana.
#Usás eclipse-temurin:17-jdk-alpine, que es Java 17 sobre Alpine Linux (una distro mini, pesa unos ~80 MB).
#👉 Esta segunda etapa no tiene Maven ni dependencias de compilación, solo lo necesario para correr Java.
FROM eclipse-temurin:17-jdk-slim

# Crear usuario no root por seguridad
#Crea un usuario y grupo dentro del contenedor (en vez de usar “root”).
#Esto es una buena práctica de seguridad, evita que tu app corra con privilegios.
RUN addgroup -S appgroup && adduser -S victor -G appgroup

#Indica que todo lo que viene después se ejecutará con ese usuario no root.
USER victor

#Define la carpeta de trabajo donde estará tu aplicación en esta etapa.
WORKDIR /app

# Copiamos solo el JAR generado
#Copiás el .jar desde la primera etapa (builder) hacia esta segunda imagen.
#Así, solo te traés el resultado final, sin arrastrar el código fuente ni Maven.
#💡 Esto hace tu imagen final mucho más pequeña y segura.
COPY --from=builder /build/target/*.jar app.jar

# Exponemos el puerto de Spring Boot
#“Esta aplicación escucha en el puerto 5050”.
#Es decir, solo informa a quien use tu contenedor (otros contenedores, Docker Compose, o la nube)
#qué puerto interno está usando tu app.
EXPOSE 5050

# Comando para ejecutar la app
#Es el comando que se ejecuta automáticamente cuando arranca el contenedor.
#Equivale a ejecutar esto dentro del contenedor:java -jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]