# 🎢 Fantasilandia

**Fantasilandia** es un sistema de información en consola que permite gestionar un parque de atracciones.  
El sistema permite registrar y listar clientes, administrar atracciones y organizar bloques de horario donde los clientes pueden inscribirse.

---

## Requisitos

- **JDK 11 o superior** (probado con JDK 17)  
- **IDE con soporte a Java** (IntelliJ IDEA, Eclipse o NetBeans)  

---

## Documentación

Toda la interacción del sistema se realiza por **consola**.  
Puede revisar las clases principales (`Cliente`, `Atraccion`, `BloqueDeAtraccion`, `DiasActivosAnuales`, `Fantasilandia`, etc.) dentro del código fuente.

---

## Instrucciones de ejecución

Una vez descargado y descomprimido el proyecto, debe abrir la carpeta **Fantasilandia** con un IDE que soporte Java (IntelliJ, Eclipse o NetBeans).  
Siga los pasos a continuación para compilar y ejecutar el sistema.

---

### IntelliJ IDEA

1. Abra el proyecto en IntelliJ.  
2. Compile todas las clases con **Build > Build Project**.  
3. Ejecute la clase `Main` con **Run > Run 'Main'**.  
4. Interactúe con el menú en la consola integrada.  

---

### Eclipse

1. Abra el proyecto en Eclipse.  
2. Haga clic derecho sobre la carpeta del proyecto y seleccione **Refresh**.  
3. Compile automáticamente (Eclipse lo hace por defecto).  
4. Ejecute la clase `Main.java` con **Run As > Java Application**.  

---

### NetBeans

1. Abra el proyecto en NetBeans.  
2. Compile el proyecto con **Build Project (F11)**.  
3. Ejecute la clase `Main` con **Run Project (F6)**.  

---

### Consola (opcional)

Si prefiere ejecutar sin IDE:

```bash
# Compilar todos los archivos .java
javac *.java

# Ejecutar el programa principal
java Main
