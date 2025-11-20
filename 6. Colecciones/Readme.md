# INFORME TRABAJO PRÁCTICO 6 - COLECCIONES
## Programación II - Universidad Tecnológica Nacional

**Fecha:** 20 de Noviembre de 2025  
**Alumno:** [Tu Nombre]  
**Tema:** Uso de Colecciones en Java (ArrayList) y Relaciones entre Objetos

---

## ÍNDICE
1. [Introducción](#introducción)
2. [Ejercicio 1: Sistema de Inventario de Tienda](#ejercicio-1-sistema-de-inventario-de-tienda)
3. [Ejercicio 2: Sistema de Gestión de Biblioteca](#ejercicio-2-sistema-de-gestión-de-biblioteca)
4. [Ejercicio 3: Sistema Universitario](#ejercicio-3-sistema-universitario)
5. [Conceptos Aplicados](#conceptos-aplicados)
6. [Conclusiones](#conclusiones)

---

## INTRODUCCIÓN

El presente trabajo práctico tiene como objetivo principal la aplicación de **colecciones en Java** (específicamente `ArrayList`) para gestionar relaciones entre objetos en diferentes contextos: una tienda, una biblioteca y una universidad. 

### Objetivos del TP
- ✅ Implementar colecciones utilizando `ArrayList<T>`
- ✅ Aplicar relaciones 1:N (uno a muchos) entre clases
- ✅ Implementar relaciones N:M (muchos a muchos) con bidireccionalidad
- ✅ Utilizar enumeraciones (`enum`) para categorías
- ✅ Practicar encapsulamiento y separación de responsabilidades
- ✅ Implementar métodos de búsqueda, filtrado y gestión de colecciones

---

## EJERCICIO 1: SISTEMA DE INVENTARIO DE TIENDA

### 📋 Requerimientos Solicitados

**Clases a implementar:**
- `Producto`: con atributos id, nombre, precio, cantidad y categoría
- `CategoriaProducto`: enum con valores (ALIMENTOS, ELECTRONICA, ROPA, HOGAR)
- `Inventario`: gestiona una colección de productos

**Funcionalidades requeridas:**
1. ✅ Agregar productos al inventario
2. ✅ Listar todos los productos
3. ✅ Buscar un producto por ID
4. ✅ Filtrar productos por categoría
5. ✅ Eliminar un producto por ID
6. ✅ Actualizar el stock de un producto
7. ✅ Obtener el total de stock disponible
8. ✅ Obtener el producto con mayor stock
9. ✅ Filtrar productos por rango de precio
10. ✅ Mostrar categorías disponibles con descripciones

---

### 📝 Implementación Realizada

#### Clase `CategoriaProducto` (Enum)
```java
public enum CategoriaProducto {
    ALIMENTOS("Productos comestibles"),
    ELECTRONICA("Dispositivos electrónicos"),
    ROPA("Prendas de vestir"),
    HOGAR("Artículos para el hogar");

    private final String descripcion;

    CategoriaProducto(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
```

**Características implementadas:**
- ✅ Uso de enum para categorías predefinidas
- ✅ Atributo privado `descripcion` para cada categoría
- ✅ Constructor privado (característico de enums)
- ✅ Método getter para acceder a la descripción

---

#### Clase `Producto`
```java
public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;
    
    // Constructor, getters, setter para cantidad, mostrarInfo()
}
```

**Características implementadas:**
- ✅ Encapsulamiento: todos los atributos privados
- ✅ Constructor con todos los parámetros
- ✅ Getters para todos los atributos
- ✅ Setter únicamente para `cantidad` (actualización de stock)
- ✅ Método `mostrarInfo()` para visualización formateada
- ✅ Relación con `CategoriaProducto` (enum)

---

#### Clase `Inventario`
```java
public class Inventario {
    private List<Producto> productos; // Relación 1:N
    
    public Inventario() {
        this.productos = new ArrayList<>();
    }
    
    // 10 métodos implementados según los requerimientos
}
```

**Métodos implementados:**

| Método | Descripción | Estado |
|--------|-------------|--------|
| `agregarProducto(Producto p)` | Agrega un producto a la colección | ✅ |
| `listarProductos()` | Muestra todos los productos con for-each | ✅ |
| `buscarProductoPorId(String id)` | Búsqueda lineal por ID | ✅ |
| `filtrarPorCategoria(CategoriaProducto cat)` | Filtra productos por categoría | ✅ |
| `eliminarProducto(String id)` | Elimina un producto de la colección | ✅ |
| `actualizarStock(String id, int cantidad)` | Modifica el stock de un producto | ✅ |
| `obtenerTotalStock()` | Suma todas las cantidades | ✅ |
| `obtenerProductoConMayorStock()` | Encuentra el producto con más unidades | ✅ |
| `filtrarProductosPorPrecio(double min, max)` | Filtra por rango de precios | ✅ |
| `mostrarCategoriasDisponibles()` | Lista todas las categorías del enum | ✅ |

**Características destacadas:**
- ✅ Uso de `ArrayList<Producto>` para la relación 1:N
- ✅ Inicialización del ArrayList en el constructor (evita NullPointerException)
- ✅ Uso de ciclo for-each para recorrer colecciones
- ✅ Búsqueda lineal para encontrar elementos
- ✅ Validaciones con verificación de null

---

#### Clase `Main` (Programa de Prueba)

El programa de prueba ejecuta todas las funcionalidades requeridas en orden:

```
1. Creación y agregación de 5 productos (diferentes categorías)
2. Listado completo de productos
3. Búsqueda por ID (P002)
4. Filtrado por categoría (ELECTRONICA)
5. Eliminación de producto (P003) y listado restante
6. Actualización de stock (P001 a 25 unidades)
7. Cálculo de stock total
8. Obtención del producto con mayor stock
9. Filtrado por rango de precio ($1000 - $3000)
10. Listado de categorías disponibles
```

**Salida esperada:** ✅ Todas las operaciones se ejecutan correctamente mostrando la información formateada

---

### ✅ Verificación de Cumplimiento

| Requerimiento | Pedido | Implementado |
|---------------|--------|--------------|
| Clase Producto con atributos especificados | ✅ | ✅ |
| Enum CategoriaProducto | ✅ | ✅ |
| Clase Inventario con ArrayList | ✅ | ✅ |
| Agregar productos | ✅ | ✅ |
| Listar productos | ✅ | ✅ |
| Buscar por ID | ✅ | ✅ |
| Filtrar por categoría | ✅ | ✅ |
| Eliminar producto | ✅ | ✅ |
| Actualizar stock | ✅ | ✅ |
| Total de stock | ✅ | ✅ |
| Producto con mayor stock | ✅ | ✅ |
| Filtrar por precio | ✅ | ✅ |
| Mostrar categorías | ✅ | ✅ |

---

## EJERCICIO 2: SISTEMA DE GESTIÓN DE BIBLIOTECA

### 📋 Requerimientos Solicitados

**Clases a implementar:**
- `Autor`: con atributos id, nombre y nacionalidad
- `Libro`: con atributos isbn, titulo, anioPublicacion y autor (relación N:1)
- `Biblioteca`: gestiona una colección de libros

**Funcionalidades requeridas:**
1. ✅ Crear autores y asociarlos a libros
2. ✅ Agregar libros a la biblioteca
3. ✅ Listar todos los libros mostrando información del autor
4. ✅ Buscar un libro por ISBN
5. ✅ Filtrar libros por año de publicación
6. ✅ Eliminar un libro por ISBN
7. ✅ Mostrar cantidad total de libros
8. ✅ Listar autores disponibles (sin duplicados)

---

### 📝 Implementación Realizada

#### Clase `Autor`
```java
public class Autor {
    private String id;
    private String nombre;
    private String nacionalidad;
    
    // Constructor, getters, mostrarInfo()
}
```

**Características implementadas:**
- ✅ Encapsulamiento completo
- ✅ Constructor con todos los parámetros
- ✅ Getters para todos los atributos
- ✅ Método `mostrarInfo()` con formato específico para autores

---

#### Clase `Libro`
```java
public class Libro {
    private String isbn;
    private String titulo;
    private int anioPublicacion;
    private Autor autor; // Relación N:1
    
    // Constructor, getters, mostrarInfo()
}
```

**Características implementadas:**
- ✅ Relación **N:1** con `Autor` (muchos libros pueden tener el mismo autor)
- ✅ Método `mostrarInfo()` que también muestra información del autor
- ✅ ISBN como identificador único

---

#### Clase `Biblioteca`
```java
public class Biblioteca {
    private String nombre;
    private List<Libro> libros; // Relación 1:N
    
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }
    
    // 6 métodos implementados
}
```

**Métodos implementados:**

| Método | Descripción | Estado |
|--------|-------------|--------|
| `agregarLibro(...)` | Crea un libro y lo agrega a la colección | ✅ |
| `listarLibros()` | Muestra todos los libros con su autor | ✅ |
| `buscarLibroPorIsbn(String)` | Búsqueda por ISBN | ✅ |
| `eliminarLibro(String)` | Elimina un libro por ISBN | ✅ |
| `obtenerCantidadLibros()` | Retorna el tamaño de la colección | ✅ |
| `filtrarLibrosPorAnio(int)` | Filtra libros por año de publicación | ✅ |
| `mostrarAutoresDisponibles()` | Lista autores sin duplicados | ✅ |

**Características destacadas:**
- ✅ El método `agregarLibro` crea la instancia de `Libro` internamente
- ✅ Uso de lista auxiliar para evitar duplicados en autores
- ✅ Validación de existencia antes de eliminar
- ✅ Uso de `size()` para obtener cantidad de elementos

---

#### Clase `MainBiblioteca` (Programa de Prueba)

Ejecuta el siguiente flujo:
```
1. Creación de biblioteca "Biblioteca Central UTN"
2. Creación de 3 autores (García Márquez, Jane Austen, Borges)
3. Agregación de 5 libros asociados a los autores
4. Listado completo de libros
5. Búsqueda por ISBN (978-0141439518)
6. Filtrado por año (1811)
7. Eliminación de libro y listado restante
8. Mostrar cantidad total de libros
9. Listado de autores disponibles (sin duplicados)
```

**Salida esperada:** ✅ Todas las operaciones funcionan correctamente

---

### ✅ Verificación de Cumplimiento

| Requerimiento | Pedido | Implementado |
|---------------|--------|--------------|
| Clase Autor | ✅ | ✅ |
| Clase Libro con relación N:1 a Autor | ✅ | ✅ |
| Clase Biblioteca con ArrayList | ✅ | ✅ |
| Crear y asociar autores | ✅ | ✅ |
| Agregar libros | ✅ | ✅ |
| Listar libros con autor | ✅ | ✅ |
| Buscar por ISBN | ✅ | ✅ |
| Filtrar por año | ✅ | ✅ |
| Eliminar libro | ✅ | ✅ |
| Cantidad de libros | ✅ | ✅ |
| Listar autores sin duplicados | ✅ | ✅ |

---

## EJERCICIO 3: SISTEMA UNIVERSITARIO

### 📋 Requerimientos Solicitados

**Clases a implementar:**
- `Profesor`: con atributos id, nombre, especialidad y lista de cursos
- `Curso`: con atributos codigo, nombre y profesor asignado
- `Universidad`: gestiona profesores y cursos

**Relación especial:** **N:M bidireccional** (muchos profesores pueden dictar muchos cursos, y viceversa)

**Funcionalidades requeridas:**
1. ✅ Crear y agregar profesores y cursos
2. ✅ Asignar profesores a cursos
3. ✅ Listar cursos mostrando su profesor
4. ✅ Listar profesores mostrando sus cursos
5. ✅ Cambiar el profesor de un curso (sincronización bidireccional)
6. ✅ Eliminar un curso y actualizar al profesor
7. ✅ Eliminar un profesor y actualizar sus cursos
8. ✅ Generar reporte de cantidad de cursos por profesor

---

### 📝 Implementación Realizada

#### Clase `Profesor`
```java
public class Profesor {
    private String id;
    private String nombre;
    private String especialidad;
    private List<Curso> cursos; // Lado "Muchos" de la relación
    
    // Métodos de bidireccionalidad con flag de sincronización
}
```

**Características implementadas:**
- ✅ ArrayList de `Curso` para la relación N:M
- ✅ Método `agregarCurso(Curso c, boolean sincronizar)` para control de recursión
- ✅ Método `eliminarCurso(Curso c, boolean sincronizar)` 
- ✅ Métodos `listarCursos()` y `mostrarInfo()` para reportes
- ✅ Sincronización bidireccional correcta

---

#### Clase `Curso`
```java
public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor; // Lado "Uno" de la relación
    
    // Método setProfesor con lógica de sincronización
}
```

**Características implementadas:**
- ✅ Referencia a `Profesor` (puede ser null si no está asignado)
- ✅ Método `setProfesor(Profesor nuevoProfesor)` que:
  - Elimina este curso del profesor anterior
  - Actualiza la referencia al nuevo profesor
  - Agrega este curso al nuevo profesor
- ✅ Método `setProfesorInterno(Profesor p)` para evitar recursión infinita
- ✅ Método `mostrarInfo()` mostrando "Sin asignar" si no tiene profesor

---

#### Clase `Universidad`
```java
public class Universidad {
    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;
    
    // Métodos de gestión con sincronización
}
```

**Métodos implementados:**

| Método | Descripción | Estado |
|--------|-------------|--------|
| `agregarProfesor(Profesor)` | Agrega un profesor a la colección | ✅ |
| `agregarCurso(Curso)` | Agrega un curso a la colección | ✅ |
| `asignarProfesorACurso(...)` | Asigna/cambia profesor usando setProfesor | ✅ |
| `buscarProfesorPorId(String)` | Búsqueda de profesor | ✅ |
| `buscarCursoPorCodigo(String)` | Búsqueda de curso | ✅ |
| `eliminarCurso(String)` | Elimina curso y sincroniza profesor | ✅ |
| `eliminarProfesor(String)` | Elimina profesor y deja cursos en null | ✅ |
| `listarProfesores()` | Lista todos los profesores | ✅ |
| `listarCursos()` | Lista todos los cursos | ✅ |

**Características destacadas:**
- ✅ Sincronización automática bidireccional en todas las operaciones
- ✅ Uso de `new ArrayList<>(profesor.getCursos())` para evitar `ConcurrentModificationException`
- ✅ Manejo correcto de referencias null
- ✅ Delegación al método `setProfesor` del curso para asignaciones

---

#### Clase `MainUniversidad` (Programa de Prueba)

Ejecuta un flujo completo de prueba:
```
1. Creación de 3 profesores y 5 cursos
2. Agregación a la universidad
3. Asignaciones iniciales (3 cursos asignados)
4. Listado de cursos y profesores
5. Cambio de profesor (C201: Pérez → García) con verificación de sincronización
6. Eliminación de curso (C301) con verificación de que se elimina del profesor
7. Eliminación de profesor (P102) con verificación de que sus cursos quedan "Sin asignar"
8. Reporte final de cantidad de cursos por profesor
```

**Validaciones realizadas:**
- ✅ Verificación de sincronización al cambiar profesor
- ✅ Verificación de que al eliminar curso, se elimina de la lista del profesor
- ✅ Verificación de que al eliminar profesor, sus cursos quedan sin asignar
- ✅ Todas las operaciones muestran resultados coherentes

---

### ✅ Verificación de Cumplimiento

| Requerimiento | Pedido | Implementado |
|---------------|--------|--------------|
| Clase Profesor con lista de cursos | ✅ | ✅ |
| Clase Curso con referencia a Profesor | ✅ | ✅ |
| Relación N:M bidireccional | ✅ | ✅ |
| Clase Universidad con ambas colecciones | ✅ | ✅ |
| Crear y agregar entidades | ✅ | ✅ |
| Asignar profesor a curso | ✅ | ✅ |
| Listar cursos con profesor | ✅ | ✅ |
| Listar profesores con cursos | ✅ | ✅ |
| Cambiar profesor (sincronización) | ✅ | ✅ |
| Eliminar curso (sincronizar profesor) | ✅ | ✅ |
| Eliminar profesor (dejar cursos en null) | ✅ | ✅ |
| Reporte de cursos por profesor | ✅ | ✅ |

---

## CONCEPTOS APLICADOS

### 1. Colecciones - ArrayList<T>

**Características utilizadas:**
- ✅ `ArrayList<T>`: colección dinámica de tamaño variable
- ✅ **Inicialización obligatoria**: `new ArrayList<>()` en constructores
- ✅ Métodos utilizados:
  - `add(elemento)`: agregar elementos
  - `remove(elemento)`: eliminar elementos
  - `size()`: obtener cantidad de elementos
  - `isEmpty()`: verificar si está vacía
  - `contains(elemento)`: verificar existencia
  - `get(index)`: acceder por índice

**Ventajas demostradas:**
- Tamaño dinámico (no necesita definirse de antemano)
- Fácil iteración con for-each
- Métodos built-in para operaciones comunes

---

### 2. Relaciones entre Objetos

#### Relación 1:N (Uno a Muchos)
- **Inventario → Productos**: Un inventario tiene muchos productos
- **Biblioteca → Libros**: Una biblioteca tiene muchos libros
- **Universidad → Profesores/Cursos**: Una universidad tiene muchos profesores y cursos

**Implementación:**
```java
private List<Producto> productos; // Lado "Muchos"
```

#### Relación N:1 (Muchos a Uno)
- **Libro → Autor**: Muchos libros pueden tener el mismo autor

**Implementación:**
```java
private Autor autor; // Referencia al "Uno"
```

#### Relación N:M Bidireccional (Muchos a Muchos)
- **Profesor ↔ Curso**: Un profesor puede dictar varios cursos, un curso puede ser dictado por varios profesores (en diferentes momentos)

**Implementación:**
```java
// En Profesor:
private List<Curso> cursos;

// En Curso:
private Profesor profesor;

// Métodos de sincronización bidireccional
```

**Desafío resuelto:** Mantener ambos lados sincronizados sin recursión infinita usando:
- Flag `boolean sincronizar` en métodos auxiliares
- Métodos internos (`setProfesorInterno`)
- Validaciones antes de agregar/eliminar

---

### 3. Enumeraciones (enum)

**Implementación:**
```java
public enum CategoriaProducto {
    ALIMENTOS("Productos comestibles"),
    ELECTRONICA("Dispositivos electrónicos"),
    ROPA("Prendas de vestir"),
    HOGAR("Artículos para el hogar");
    
    private final String descripcion;
    // Constructor y getter
}
```

**Ventajas:**
- ✅ Conjunto fijo de valores (seguridad de tipos)
- ✅ Pueden tener atributos y métodos
- ✅ Método `values()` para iterar todos los valores
- ✅ Más robusto que usar Strings o constantes

---

### 4. Encapsulamiento

**Aplicado en todas las clases:**
- ✅ Atributos privados
- ✅ Getters públicos
- ✅ Setters selectivos (solo donde tiene sentido modificar)
- ✅ Métodos públicos para operaciones permitidas
- ✅ Métodos privados/con flag para control interno

---

### 5. Separación de Responsabilidades

**Estructura del código:**
- **Clases de modelo** (`Producto`, `Libro`, `Profesor`, `Curso`): representan entidades
- **Clases de gestión** (`Inventario`, `Biblioteca`, `Universidad`): administran colecciones
- **Clases Main**: ejecutan pruebas y demuestran funcionalidad

Cada clase tiene responsabilidades claras y bien definidas.

---

### 6. Búsqueda y Filtrado

**Algoritmos implementados:**

#### Búsqueda lineal
```java
for (Producto p : productos) {
    if (p.getId().equals(id)) {
        return p;
    }
}
return null;
```

#### Filtrado por condición
```java
for (Producto p : productos) {
    if (p.getCategoria() == categoria) {
        p.mostrarInfo();
    }
}
```

#### Búsqueda de máximo
```java
Producto mayorStock = productos.get(0);
for (Producto p : productos) {
    if (p.getCantidad() > mayorStock.getCantidad()) {
        mayorStock = p;
    }
}
return mayorStock;
```

---

### 7. Ciclo For-Each

**Uso extensivo en todo el TP:**
```java
for (Producto p : productos) {
    p.mostrarInfo();
}
```

**Ventajas:**
- Sintaxis más limpia y legible
- No necesita índices
- Menos propenso a errores (no hay riesgo de IndexOutOfBoundsException)

---

### 8. Validaciones y Manejo de Null

**Patrones utilizados:**
```java
if (producto != null) {
    producto.mostrarInfo();
} else {
    System.out.println("Producto no encontrado.");
}
```

```java
String nombreProfesor = (profesor != null) ? profesor.getNombre() : "Sin asignar";
```

---

## CONCLUSIONES

### Logros del Trabajo Práctico

1. **✅ Implementación completa de todos los ejercicios:**
   - Sistema de Inventario (10 funcionalidades)
   - Sistema de Biblioteca (8 funcionalidades)
   - Sistema Universitario (12 funcionalidades incluyendo sincronización bidireccional)

2. **✅ Aplicación correcta de conceptos:**
   - Colecciones con ArrayList
   - Relaciones 1:N, N:1 y N:M
   - Enumeraciones con atributos
   - Encapsulamiento y buenas prácticas

3. **✅ Funcionalidad completa:**
   - Todos los métodos implementados según lo solicitado
   - Programas de prueba exhaustivos que validan cada funcionalidad
   - Manejo correcto de casos especiales (null, listas vacías, etc.)

4. **✅ Sincronización bidireccional:**
   - Implementación correcta de la relación N:M entre Profesor y Curso
   - Prevención de recursión infinita
   - Mantenimiento de consistencia en ambos lados de la relación

---

### Aprendizajes Clave

1. **Gestión de colecciones:**
   - Importancia de inicializar ArrayList en el constructor
   - Ventajas del for-each sobre for tradicional
   - Métodos útiles de la interfaz List

2. **Relaciones entre objetos:**
   - Diferencia entre relaciones unidireccionales y bidireccionales
   - Complejidad de mantener sincronización en relaciones bidireccionales
   - Estrategias para evitar recursión infinita

3. **Enumeraciones:**
   - Cómo agregar comportamiento a enums
   - Ventajas sobre usar constantes String o int
   - Uso del método `values()` para iteración

4. **Diseño de software:**
   - Importancia de separar responsabilidades
   - Beneficios del encapsulamiento
   - Validaciones y manejo de casos especiales

---

### Dificultades Encontradas y Soluciones

| Dificultad | Solución Aplicada |
|------------|-------------------|
| Recursión infinita en relación bidireccional | Flag `boolean sincronizar` y métodos internos |
| ConcurrentModificationException al eliminar | Crear copia con `new ArrayList<>(...)` |
| Duplicados en listado de autores | Lista auxiliar para rastrear IDs ya mostrados |
| Null en profesores de cursos | Operador ternario y validaciones constantes |

---

### Posibles Mejoras Futuras

1. **Manejo de excepciones:**
   - Lanzar excepciones personalizadas en lugar de retornar null
   - Validar datos de entrada (precios negativos, IDs vacíos, etc.)

2. **Ordenamiento:**
   - Implementar `Comparable` en las clases de modelo
   - Agregar métodos para ordenar por diferentes criterios

3. **Persistencia:**
   - Guardar y cargar datos desde archivos
   - Integración con bases de datos

4. **Interfaz de usuario:**
   - Crear una interfaz gráfica (GUI) con Swing o JavaFX
   - Menú interactivo en consola

5. **Búsqueda optimizada:**
   - Usar HashMap para búsquedas O(1) en lugar de O(n)
   - Implementar índices secundarios

---

### Cumplimiento de Objetivos

| Objetivo | Estado | Observaciones |
|----------|--------|---------------|
| Uso de ArrayList | ✅ 100% | Implementado en todos los ejercicios |
| Relaciones 1:N | ✅ 100% | Inventario, Biblioteca, Universidad |
| Relaciones N:M bidireccionales | ✅ 100% | Profesor-Curso con sincronización correcta |
| Uso de enum | ✅ 100% | CategoriaProducto con atributos |
| Encapsulamiento | ✅ 100% | Todos los atributos privados con getters |
| Métodos de búsqueda | ✅ 100% | Por ID, ISBN, código |
| Métodos de filtrado | ✅ 100% | Por categoría, año, precio |
| Métodos de gestión | ✅ 100% | Agregar, eliminar, actualizar |
| Métodos de reporte | ✅ 100% | Listar, contar, obtener estadísticas |
| Programas de prueba | ✅ 100% | Main funcional para cada ejercicio |

---

### Reflexión Final

El Trabajo Práctico 6 ha permitido consolidar el uso de colecciones en Java, específicamente ArrayList, y comprender la complejidad de las relaciones entre objetos en programación orientada a objetos. 

La implementación de la relación bidireccional N:M entre Profesor y Curso ha sido particularmente desafiante y educativa, ya que requirió un análisis cuidadoso de la sincronización y la prevención de problemas como la recursión infinita.

Los tres ejercicios desarrollados (Inventario, Biblioteca y Universidad) representan escenarios realistas de sistemas de gestión que se encuentran en aplicaciones del mundo real, lo que hace que el aprendizaje sea práctico y aplicable.

**El trabajo práctico se considera COMPLETO y FUNCIONAL**, cumpliendo con todos los requerimientos solicitados en el documento "Trabajo Práctico - Colecciones.pdf".

---

## ANEXO: Estructura del Proyecto

```
TP6/
├── pom.xml
└── src/
    └── main/
        └── java/
            ├── com/
            │   ├── tienda/
            │   │   └── inventario/
            │   │       ├── CategoriaProducto.java (Enum)
            │   │       ├── Producto.java
            │   │       ├── Inventario.java
            │   │       └── Main.java
            │   └── utn/
            │       ├── biblioteca/
            │       │   ├── Autor.java
            │       │   ├── Libro.java
            │       │   ├── Biblioteca.java
            │       │   └── MainBiblioteca.java
            │       └── universidad/
            │           ├── Profesor.java
            │           ├── Curso.java
            │           ├── Universidad.java
            │           └── MainUniversidad.java
```

---

**FIN DEL INFORME**
