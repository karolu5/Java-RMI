# Java RMI – Calculadora distribuida

Proyecto desarrollado en Java para demostrar la comunicación entre aplicaciones mediante **Remote Method Invocation (RMI)**.

Implementa una calculadora remota con arquitectura cliente-servidor. El cliente puede invocar métodos que se ejecutan en otro proceso mediante el registro RMI.

El repositorio también incluye un cliente HTTP de integración para consumir un servicio externo de cotizaciones.

## Tecnologías

- Java
- Java RMI
- Programación orientada a objetos
- Arquitectura cliente-servidor
- Java HTTP Client
- Shell scripting

## Funcionalidades

### Calculadora RMI

- Suma de dos números.
- Resta de dos números.
- Multiplicación de dos números.
- División con manejo de errores cuando el divisor es cero.
- Identificación del servidor remoto.
- Comunicación mediante el registro RMI en el puerto `1099`.

### Cliente de integración HTTP

El archivo `ClienteIntegrador.java` implementa un cliente para consumir un servicio HTTP de cotizaciones.

Incluye:

- Solicitudes HTTP GET.
- Tiempo límite de conexión y respuesta.
- Encabezado `Idempotency-Key`.
- Reintentos con espera exponencial ante errores de comunicación.
- Solicitudes de ejemplo para USD, EUR y MXN.

**Nota:** el servicio HTTP de cotizaciones no está implementado en este repositorio. Para ejecutar este cliente se necesita un servidor compatible disponible en el puerto `8080`.

## Estructura del proyecto

```text
Java-RMI/
├── src/
│   └── mx/ipn/esimecu/rpc/
│       ├── Calculadora.java
│       ├── CalculadoraImpl.java
│       ├── ServidorRMI.java
│       ├── ClienteRMI.java
│       └── ClienteIntegrador.java
├── compilar.sh
├── arrancar-servidor.sh
└── README.md
```

## Requisitos

- JDK 11 o superior.
- Terminal para ejecutar comandos Java.
- Bash para utilizar los scripts `.sh` incluidos.

## Instalación y ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/karolu5/Java-RMI.git
cd Java-RMI
```

### 2. Compilar los archivos Java

Desde la raíz del repositorio:

```bash
javac src/mx/ipn/esimecu/rpc/*.java
```

También puede utilizarse el script:

```bash
bash compilar.sh
```

### 3. Iniciar el servidor RMI

En una terminal:

```bash
cd src
java mx.ipn.esimecu.rpc.ServidorRMI
```

El servidor registra el servicio con el nombre `CalculadoraIPN` en el puerto `1099`.

### 4. Ejecutar el cliente

Abre otra terminal y, desde la raíz del proyecto, ejecuta:

```bash
cd src
java mx.ipn.esimecu.rpc.ClienteRMI
```

Para conectarse a un servidor en otra computadora:

```bash
java mx.ipn.esimecu.rpc.ClienteRMI DIRECCION_IP
```

En ese caso, ambas computadoras deben tener conectividad de red y una configuración RMI adecuada.

## Arquitectura

1. `Calculadora.java` define la interfaz remota.
2. `CalculadoraImpl.java` implementa las operaciones disponibles.
3. `ServidorRMI.java` crea el registro y publica el servicio.
4. `ClienteRMI.java` busca el servicio e invoca sus métodos.

La ejecución de las operaciones se realiza en el servidor, mientras que el cliente recibe los resultados mediante RMI.

## Conceptos aplicados

- Interfaces y clases en Java.
- Herencia e implementación de interfaces.
- Manejo de excepciones.
- Comunicación cliente-servidor.
- Invocación remota de métodos.
- Servicios distribuidos.
- Consumo de APIs HTTP.

## Autor

Desarrollado por [karolu5](https://github.com/karolu5).