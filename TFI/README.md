# TFI Programación 2 — Producto → CodigoBarras (1→1 unidireccional)

## 1) Descripción del dominio
El sistema gestiona **Productos** y su **Código de Barras** asociado en una relación **1→1 unidireccional**:  
**Producto** referencia a **CodigoBarras** mediante `codigo_barras_id` (**UNIQUE**).  
Se implementa CRUD de ambas entidades, **búsqueda por valor de código** (EAN/UPC), **baja lógica**, y **transacciones** con *rollback* ante violaciones de unicidad.

---

## 2) Requisitos
- **Java 21** y **Maven 3.9+**  
- **MySQL 8.x** instalado y accesible desde consola (`mysql`)  
- Acceso a internet para bajar el conector JDBC la primera vez

---

## 3) Base de datos — crear con los `.sql` provistos
Scripts incluidos:
- `01_schema.sql` → crea BD `tfi_prog2`, tablas y restricciones  
- `02_seed.sql` → inserta datos de prueba  
- `03_verify.sql` → consultas de verificación (unicidades, 1→1, join, conteos)

### Opción A — Rápida (recomendada)
**Windows**
1. **Editar credenciales de MySQL** en ambos archivos:
   - `src\main\resources\database.properties` → ajustar `db.user`, `db.password`, etc.
   - `run_all.bat` → modificar las variables `DB_USER` y `DB_PASSWORD`

2. **Abrir CMD** en la carpeta raíz del proyecto (donde está `run_all.bat`):
   - Desde el explorador de Windows, hacer clic derecho dentro de la carpeta → **"Abrir en Terminal"** o **"Abrir ventana de comandos aquí"**
   - O bien navegar manualmente

3. **Ejecutar el script**:
   ```bat
   run_all.bat
   ```
   Este comando creará la BD, cargará datos de prueba y compilará el proyecto automáticamente.

### Opción B — Manual
1. **Abrir CMD** en la carpeta raíz del proyecto (donde están los archivos `.sql`):
   - Desde el explorador de Windows, hacer clic derecho dentro de la carpeta → **"Abrir en Terminal"** o **"Abrir ventana de comandos aquí"**

2. **Ejecutar los siguientes comandos** (te pedirá la contraseña de MySQL después de cada uno):
   ```bash
   # 1) Crear esquema y datos
   mysql -u root -p < 01_schema.sql
   mysql -u root -p < 02_seed.sql

   # 2) (Opcional) Verificar integridad
   mysql -u root -p tfi_prog2 < 03_verify.sql
   ```

> **Credenciales de BD de prueba (ejemplo):**  
> host: `localhost` · puerto: `3306` · usuario: `root` · contraseña: `tuContraseña`  
> Podés cambiarlas en `src/main/resources/database.properties`.

---

## 4) Compilar y ejecutar (con flujo de uso)
> **Nota:** Todos los comandos se ejecutan desde un **CMD abierto en la raíz del proyecto**.

### Compilar
```bash
mvn -q clean package
```

### Ejecutar AppMenu (CLI)
```bash
mvn -q exec:java -Dexec.mainClass="edu.utn.p2.tfi.main.AppMenu"
```

### Flujo de uso recomendado (demo completa)
1. **(1)** Alta de **CodigoBarras** válido (ej. `valor=7791234567890`, `tipo=EAN13`).  
2. **(2)** Alta de **Producto + CB NUEVO** (transacción).  
3. **(3)** Alta de **Producto con CB EXISTENTE** usando un `valor` previo.  
4. **(5)** **Buscar por valor** de código (campo clave: `CodigoBarras.valor`).  
5. **(6) / (8)** **Eliminación lógica** de Producto o Código.  
6. **(9)** **Demostración de rollback**: intenta crear Producto + CB **repetido** → se dispara la **violación UNIQUE** y la transacción hace **rollback** (no queda nada a medias).

> Tip: podés verificar el estado corriendo `03_verify.sql` luego de cada prueba.

---

## 5) Enlace al video
- 🎬 **Video**: *https://youtu.be/V0_Kd-HbTGg*

---

### Estructura del proyecto
```
config/   -> DatabaseConnection (JDBC)
entities/ -> Producto, CodigoBarras
dao/      -> GenericDao + DAO/impl con PreparedStatement
service/  -> validaciones + transacciones (commit/rollback)
main/     -> AppMenu (CLI) y DemoRollback
```
