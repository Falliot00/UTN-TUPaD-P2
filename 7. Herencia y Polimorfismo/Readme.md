# INFORME - TRABAJO PRÁCTICO N° 7
## Herencia y Polimorfismo en Java

**Asignatura:** Programación 2  
**Período:** Segundo Cuatrimestre 2025  
**Fecha de Elaboración:** 20 de Noviembre de 2025

---

## ÍNDICE

1. [Introducción](#introducción)
2. [Objetivos del Trabajo Práctico](#objetivos-del-trabajo-práctico)
3. [Conceptos Teóricos Aplicados](#conceptos-teóricos-aplicados)
4. [Desarrollo de las Katas](#desarrollo-de-las-katas)
   - [Kata 1: Vehiculos - Herencia Básica](#kata-1-vehiculos---herencia-básica)
   - [Kata 2: Figuras - Clases Abstractas](#kata-2-figuras---clases-abstractas)
   - [Kata 3: Empleados - Polimorfismo y instanceof](#kata-3-empleados---polimorfismo-e-instanceof)
   - [Kata 4: Animales - Upcasting y Polimorfismo](#kata-4-animales---upcasting-y-polimorfismo)
5. [Conclusiones](#conclusiones)
6. [Anexos](#anexos)

---

## 1. INTRODUCCIÓN

El presente informe documenta el desarrollo completo del Trabajo Práctico N° 7, centrado en los conceptos fundamentales de **Herencia** y **Polimorfismo** en Java. El trabajo práctico se estructura en cuatro ejercicios incrementales (katas) que permiten explorar progresivamente estos conceptos de la Programación Orientada a Objetos.

La implementación se realizó utilizando Java con Maven como sistema de gestión de dependencias, organizando el código en paquetes separados para cada kata.

---

## 2. OBJETIVOS DEL TRABAJO PRÁCTICO

### Objetivos Generales
- Comprender e implementar el concepto de **herencia** en Java
- Aplicar **polimorfismo** para escribir código flexible y reutilizable
- Utilizar **clases abstractas** y **métodos abstractos**
- Dominar el uso de `super` y `@Override`
- Aplicar **upcasting** y verificación de tipos con `instanceof`

### Objetivos Específicos por Kata
- **Kata 1:** Implementar herencia básica y sobrescritura de métodos
- **Kata 2:** Utilizar clases abstractas y polimorfismo con arrays
- **Kata 3:** Aplicar polimorfismo en colecciones y uso de `instanceof`
- **Kata 4:** Demostrar upcasting y polimorfismo en listas heterogéneas

---

## 3. CONCEPTOS TEÓRICOS APLICADOS

### 3.1 Herencia
La herencia es un mecanismo que permite crear nuevas clases basadas en clases existentes, heredando sus atributos y métodos. En Java se utiliza la palabra clave `extends`.

**Ventajas:**
- Reutilización de código
- Creación de jerarquías de clases
- Facilita el mantenimiento y la extensibilidad

### 3.2 Polimorfismo
Capacidad de objetos de diferentes clases de responder al mismo mensaje de diferentes formas. En Java se implementa mediante:
- Sobrescritura de métodos (@Override)
- Referencias de tipo padre apuntando a objetos de tipo hijo

### 3.3 Clases Abstractas
Clases que no pueden ser instanciadas directamente y que pueden contener:
- Métodos abstractos (sin implementación)
- Métodos concretos (con implementación)
- Atributos

### 3.4 Modificadores de Acceso
- `protected`: Accesible desde la clase, subclases y el mismo paquete
- `public`: Accesible desde cualquier lugar
- `private`: Accesible solo dentro de la clase

### 3.5 Palabras Clave Importantes
- `super`: Referencia a la superclase
- `@Override`: Anotación que indica sobrescritura de método
- `instanceof`: Operador para verificar el tipo de un objeto
- `abstract`: Define clases o métodos abstractos

---

## 4. DESARROLLO DE LAS KATAS

---

### KATA 1: VEHICULOS - HERENCIA BÁSICA

#### 4.1.1 Objetivo
Implementar herencia básica entre una clase padre `Vehiculo` y una clase hija `Auto`, demostrando la sobrescritura de métodos y el uso de `super`.

#### 4.1.2 Requisitos del Ejercicio
✅ Crear clase base `Vehiculo` con atributos `marca` y `modelo`  
✅ Crear subclase `Auto` que extienda de `Vehiculo`  
✅ Añadir atributo adicional `cantidadPuertas` en `Auto`  
✅ Sobrescribir el método `mostrarInfo()`  
✅ Utilizar `super()` en el constructor de `Auto`  
✅ Demostrar el funcionamiento en la clase `Main`

#### 4.1.3 Implementación

**Clase Vehiculo (Superclase)**
```java
package kata1_vehiculos;

public class Vehiculo {
    protected String marca;
    protected String modelo;

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void mostrarInfo() {
        System.out.println("Vehículo:");
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
    }
}
```

**Clase Auto (Subclase)**
```java
package kata1_vehiculos;

public class Auto extends Vehiculo {
    private int cantidadPuertas;

    public Auto(String marca, String modelo, int cantidadPuertas) {
        super(marca, modelo); // Llamada al constructor del padre
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Auto:");
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Puertas: " + this.cantidadPuertas);
    }
}
```

**Clase Main**
```java
package kata1_vehiculos;

public class MainVehiculos {
    public static void main(String[] args) {
        Auto miAuto = new Auto("Toyota", "Corolla", 4);
        miAuto.mostrarInfo();
    }
}
```

#### 4.1.4 Conceptos Aplicados
- **Herencia simple:** `Auto extends Vehiculo`
- **Modificador `protected`:** Permite acceso a atributos desde la subclase
- **`super()`:** Invoca el constructor de la superclase (debe ser la primera línea)
- **`@Override`:** Indica sobrescritura del método `mostrarInfo()`
- **Polimorfismo:** Aunque no se demuestra explícitamente, Auto puede usarse como Vehiculo

#### 4.1.5 Salida Esperada
```
Auto:
Marca: Toyota
Modelo: Corolla
Puertas: 4
```

---

### KATA 2: FIGURAS - CLASES ABSTRACTAS

#### 4.2.1 Objetivo
Implementar una jerarquía de figuras geométricas utilizando clases abstractas y demostrar polimorfismo mediante un array de figuras.

#### 4.2.2 Requisitos del Ejercicio
✅ Crear clase abstracta `Figura` con atributo `nombre`  
✅ Definir método abstracto `calcularArea()`  
✅ Implementar subclases `Circulo` y `Rectangulo`  
✅ Cada subclase debe implementar `calcularArea()`  
✅ Crear array de tipo `Figura` con diferentes tipos de figuras  
✅ Calcular áreas usando polimorfismo

#### 4.2.3 Implementación

**Clase Abstracta Figura**
```java
package kata2_figuras;

public abstract class Figura {
    protected String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    // Método abstracto: las subclases DEBEN implementarlo
    public abstract double calcularArea();

    // Método concreto
    public String getNombre() {
        return this.nombre;
    }
}
```

**Clase Circulo**
```java
package kata2_figuras;

public class Circulo extends Figura {
    private double radio;

    public Circulo(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}
```

**Clase Rectangulo**
```java
package kata2_figuras;

public class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo(String nombre, double base, double altura) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }
}
```

**Clase Main**
```java
package kata2_figuras;

public class MainFiguras {
    public static void main(String[] args) {
        // Array de figuras con upcasting implícito
        Figura[] figuras = new Figura[2];
        figuras[0] = new Circulo("Círculo 1", 10.0);
        figuras[1] = new Rectangulo("Rectángulo 1", 5.0, 8.0);

        System.out.println("Calculando áreas usando polimorfismo:");
        
        for (Figura fig : figuras) {
            System.out.println("Área de " + fig.getNombre() + ": " + fig.calcularArea());
        }
    }
}
```

#### 4.2.4 Conceptos Aplicados
- **Clase abstracta:** `Figura` no puede ser instanciada directamente
- **Método abstracto:** `calcularArea()` obliga a las subclases a implementarlo
- **Polimorfismo:** El array de tipo `Figura` contiene objetos de diferentes tipos
- **Upcasting implícito:** `Circulo` y `Rectangulo` se convierten automáticamente a `Figura`
- **Late binding:** La JVM decide en tiempo de ejecución qué versión de `calcularArea()` invocar

#### 4.2.5 Salida Esperada
```
Calculando áreas usando polimorfismo:
Área de Círculo 1: 314.1592653589793
Área de Rectángulo 1: 40.0
```

#### 4.2.6 Ventajas del Diseño
- ✅ **Extensibilidad:** Fácil agregar nuevas figuras (Triángulo, Cuadrado, etc.)
- ✅ **Contrato obligatorio:** Todas las figuras deben calcular su área
- ✅ **Código genérico:** El método `main` funciona con cualquier tipo de figura
- ✅ **Mantenibilidad:** Los cambios en figuras específicas no afectan al código cliente

---

### KATA 3: EMPLEADOS - POLIMORFISMO E INSTANCEOF

#### 4.3.1 Objetivo
Implementar un sistema de gestión de empleados con diferentes tipos de cálculo de sueldo, demostrando polimorfismo con colecciones y verificación de tipos con `instanceof`.

#### 4.3.2 Requisitos del Ejercicio
✅ Crear clase abstracta `Empleado` con método abstracto `calcularSueldo()`  
✅ Implementar `EmpleadoPlanta` con sueldo base + bonos  
✅ Implementar `EmpleadoTemporal` con tarifa por hora  
✅ Usar `ArrayList` para almacenar empleados  
✅ Calcular sueldos polimórficamente  
✅ Utilizar `instanceof` para clasificar empleados

#### 4.3.3 Implementación

**Clase Abstracta Empleado**
```java
package kata3_empleados;

public abstract class Empleado {
    protected String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularSueldo();
}
```

**Clase EmpleadoPlanta**
```java
package kata3_empleados;

public class EmpleadoPlanta extends Empleado {
    private double sueldoBase;

    public EmpleadoPlanta(String nombre, double sueldoBase) {
        super(nombre);
        this.sueldoBase = sueldoBase;
    }

    @Override
    public double calcularSueldo() {
        return sueldoBase * 1.15; // Sueldo base + 15% de bonos
    }
}
```

**Clase EmpleadoTemporal**
```java
package kata3_empleados;

public class EmpleadoTemporal extends Empleado {
    private double tarifaPorHora;
    private int horasTrabajadas;

    public EmpleadoTemporal(String nombre, double tarifaPorHora, int horasTrabajadas) {
        super(nombre);
        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSueldo() {
        return tarifaPorHora * horasTrabajadas;
    }
}
```

**Clase Main**
```java
package kata3_empleados;

import java.util.ArrayList;
import java.util.List;

public class MainEmpleados {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new EmpleadoPlanta("Ana", 3000));
        empleados.add(new EmpleadoTemporal("Juan", 20, 80));
        empleados.add(new EmpleadoPlanta("Luis", 3200));

        System.out.println("--- Calculando Sueldos (Polimorfismo) ---");
        
        for (Empleado emp : empleados) {
            System.out.println("Empleado: " + emp.getNombre());
            System.out.println("Sueldo: " + emp.calcularSueldo());

            // Verificación de tipo con instanceof
            if (emp instanceof EmpleadoPlanta) {
                System.out.println("Tipo: Empleado de Planta");
            } else if (emp instanceof EmpleadoTemporal) {
                System.out.println("Tipo: Empleado Temporal");
            }
            System.out.println("--------------------");
        }
    }
}
```

#### 4.3.4 Conceptos Aplicados
- **ArrayList genérico:** `List<Empleado>` permite almacenar cualquier tipo de empleado
- **Polimorfismo en colecciones:** La lista contiene objetos de diferentes tipos
- **`instanceof`:** Verifica el tipo real del objeto en tiempo de ejecución
- **Encapsulación:** Cada tipo de empleado encapsula su lógica de cálculo
- **Principio Open/Closed:** Abierto a extensión (nuevos tipos de empleados), cerrado a modificación

#### 4.3.5 Salida Esperada
```
--- Calculando Sueldos (Polimorfismo) ---
Empleado: Ana
Sueldo: 3450.0
Tipo: Empleado de Planta
--------------------
Empleado: Juan
Sueldo: 1600.0
Tipo: Empleado Temporal
--------------------
Empleado: Luis
Sueldo: 3680.0
Tipo: Empleado de Planta
--------------------
```

#### 4.3.6 Análisis de instanceof
El operador `instanceof` permite:
- ✅ Verificar el tipo real de un objeto
- ✅ Tomar decisiones basadas en el tipo
- ⚠️ **Nota:** El uso excesivo puede indicar mal diseño; preferir polimorfismo cuando sea posible

---

### KATA 4: ANIMALES - UPCASTING Y POLIMORFISMO

#### 4.4.1 Objetivo
Demostrar el concepto de upcasting y polimorfismo mediante una jerarquía de animales con diferentes sonidos.

#### 4.4.2 Requisitos del Ejercicio
✅ Crear clase base `Animal` con método `hacerSonido()`  
✅ Implementar subclases: `Perro`, `Gato`, `Vaca`  
✅ Cada animal debe sobrescribir `hacerSonido()`  
✅ Utilizar upcasting para almacenar diferentes animales en una lista  
✅ Invocar métodos polimórficamente

#### 4.4.3 Implementación

**Clase Animal**
```java
package kata4_animales;

public class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void hacerSonido() {
        System.out.println("El animal hace un sonido genérico.");
    }

    public void describirAnimal() {
        System.out.println("Soy un animal llamado " + nombre);
    }
}
```

**Clase Perro**
```java
package kata4_animales;

public class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(this.nombre + " dice: ¡Guau! ¡Guau!");
    }
}
```

**Clase Gato**
```java
package kata4_animales;

public class Gato extends Animal {
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(this.nombre + " dice: ¡Miau!");
    }
}
```

**Clase Vaca**
```java
package kata4_animales;

public class Vaca extends Animal {
    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(this.nombre + " dice: ¡Muuuu!");
    }
}
```

**Clase Main**
```java
package kata4_animales;

import java.util.ArrayList;
import java.util.List;

public class MainAnimales {
    public static void main(String[] args) {
        List<Animal> granja = new ArrayList<>();
        
        // Upcasting: objetos específicos se tratan como Animal
        granja.add(new Perro("Fido"));
        granja.add(new Gato("Mishu"));
        granja.add(new Vaca("Lola"));
        granja.add(new Perro("Rex"));

        System.out.println("--- Sonidos de la Granja (Polimorfismo) ---");
        
        for (Animal animal : granja) {
            // Polimorfismo: se llama al método específico de cada subclase
            animal.hacerSonido(); 
        }
    }
}
```

#### 4.4.4 Conceptos Aplicados
- **Upcasting:** Conversión automática de subclase a superclase
- **Polimorfismo en tiempo de ejecución:** La JVM determina qué método ejecutar
- **Código genérico:** El bucle funciona con cualquier tipo de Animal
- **Sobrescritura:** Cada animal tiene su propia implementación de `hacerSonido()`

#### 4.4.5 Salida Esperada
```
--- Sonidos de la Granja (Polimorfismo) ---
Fido dice: ¡Guau! ¡Guau!
Mishu dice: ¡Miau!
Lola dice: ¡Muuuu!
Rex dice: ¡Guau! ¡Guau!
```

#### 4.4.6 Ventajas del Polimorfismo Demostradas
1. **Flexibilidad:** Agregar nuevos animales no requiere cambiar el código existente
2. **Mantenibilidad:** Cada animal encapsula su comportamiento
3. **Reusabilidad:** El código del `main` funciona con cualquier Animal
4. **Extensibilidad:** Fácil agregar nuevos tipos de animales

---

## 5. CONCLUSIONES

### 5.1 Logros Alcanzados
✅ **Implementación completa** de los cuatro ejercicios propuestos  
✅ **Aplicación práctica** de herencia simple en Java  
✅ **Uso correcto** de clases y métodos abstractos  
✅ **Demostración efectiva** del polimorfismo en diferentes contextos  
✅ **Comprensión** del uso de `super`, `@Override` e `instanceof`  
✅ **Organización del código** en paquetes separados para cada kata

### 5.2 Conceptos Clave Aprendidos

#### Herencia
- Permite reutilizar código mediante la relación "es-un"
- Los atributos `protected` son accesibles desde las subclases
- `super()` debe ser la primera línea en constructores de subclases

#### Polimorfismo
- Permite escribir código genérico que funciona con múltiples tipos
- Se implementa mediante sobrescritura de métodos
- El binding dinámico ocurre en tiempo de ejecución

#### Clases Abstractas
- No pueden ser instanciadas directamente
- Definen contratos que las subclases deben cumplir
- Pueden contener tanto métodos abstractos como concretos

#### Buenas Prácticas Aplicadas
- ✅ Uso de `@Override` para mayor seguridad
- ✅ Encapsulación de atributos con modificadores adecuados
- ✅ Nombres de clases y métodos descriptivos
- ✅ Comentarios explicativos en el código
- ✅ Organización en paquetes por funcionalidad

### 5.3 Aplicabilidad en Proyectos Reales

Los conceptos aplicados en este trabajo práctico son fundamentales para:
- **Frameworks empresariales:** Spring, Hibernate utilizan extensivamente herencia y polimorfismo
- **Patrones de diseño:** Template Method, Strategy, Factory dependen de estos conceptos
- **APIs y bibliotecas:** Diseño de interfaces extensibles
- **Sistemas escalables:** Facilitan la adición de nuevas funcionalidades sin modificar código existente

### 5.4 Dificultades Encontradas y Soluciones

| Dificultad | Solución Aplicada |
|------------|-------------------|
| Orden de llamada a `super()` | Colocar siempre como primera línea del constructor |
| Visibilidad de atributos | Usar `protected` para acceso desde subclases |
| Implementación de métodos abstractos | Asegurar `@Override` en todas las subclases |
| Organización del proyecto | Separar en paquetes por kata |

### 5.5 Reflexión Final

Este trabajo práctico ha permitido consolidar los conceptos fundamentales de la Programación Orientada a Objetos en Java. La progresión gradual de las katas facilitó la comprensión incremental de conceptos cada vez más complejos:

1. **Kata 1:** Fundamentos de herencia
2. **Kata 2:** Abstracción y contratos
3. **Kata 3:** Polimorfismo con colecciones
4. **Kata 4:** Integración completa de conceptos

La capacidad de escribir código flexible, extensible y mantenible mediante herencia y polimorfismo es esencial para cualquier desarrollador Java profesional.

---

## 6. ANEXOS

### 6.1 Estructura del Proyecto

```
TP7/
├── pom.xml
├── src/
│   └── main/
│       └── java/
│           ├── kata1_vehiculos/
│           │   ├── Vehiculo.java
│           │   ├── Auto.java
│           │   └── MainVehiculos.java
│           ├── kata2_figuras/
│           │   ├── Figura.java
│           │   ├── Circulo.java
│           │   ├── Rectangulo.java
│           │   └── MainFiguras.java
│           ├── kata3_empleados/
│           │   ├── Empleado.java
│           │   ├── EmpleadoPlanta.java
│           │   ├── EmpleadoTemporal.java
│           │   └── MainEmpleados.java
│           └── kata4_animales/
│               ├── Animal.java
│               ├── Perro.java
│               ├── Gato.java
│               ├── Vaca.java
│               └── MainAnimales.java
└── target/
    └── classes/
```

### 6.2 Comandos de Compilación y Ejecución

**Compilar el proyecto:**
```bash
mvn clean compile
```

**Ejecutar cada kata:**
```bash
# Kata 1
mvn exec:java -Dexec.mainClass="kata1_vehiculos.MainVehiculos"

# Kata 2
mvn exec:java -Dexec.mainClass="kata2_figuras.MainFiguras"

# Kata 3
mvn exec:java -Dexec.mainClass="kata3_empleados.MainEmpleados"

# Kata 4
mvn exec:java -Dexec.mainClass="kata4_animales.MainAnimales"
```

### 6.3 Diagrama de Clases por Kata

#### Kata 1 - Vehiculos
```
┌─────────────┐
│  Vehiculo   │
├─────────────┤
│ #marca      │
│ #modelo     │
├─────────────┤
│ +mostrarInfo()│
└─────────────┘
       ▲
       │ extends
       │
┌─────────────┐
│    Auto     │
├─────────────┤
│ -cantidadPuertas│
├─────────────┤
│ +mostrarInfo()│
└─────────────┘
```

#### Kata 2 - Figuras
```
┌─────────────────┐
│  <<abstract>>   │
│     Figura      │
├─────────────────┤
│ #nombre         │
├─────────────────┤
│ +calcularArea() │
│ +getNombre()    │
└─────────────────┘
       ▲
       │ extends
   ┌───┴───┐
   │       │
┌──────┐ ┌────────────┐
│Circulo│ │ Rectangulo │
├──────┤ ├────────────┤
│-radio│ │-base       │
│      │ │-altura     │
└──────┘ └────────────┘
```

#### Kata 3 - Empleados
```
┌──────────────────┐
│  <<abstract>>    │
│    Empleado      │
├──────────────────┤
│ #nombre          │
├──────────────────┤
│ +calcularSueldo()│
└──────────────────┘
       ▲
       │ extends
   ┌───┴──────────┐
   │              │
┌──────────────┐ ┌─────────────────┐
│EmpleadoPlanta│ │EmpleadoTemporal │
├──────────────┤ ├─────────────────┤
│-sueldoBase   │ │-tarifaPorHora   │
│              │ │-horasTrabajadas │
└──────────────┘ └─────────────────┘
```

#### Kata 4 - Animales
```
┌─────────────────┐
│     Animal      │
├─────────────────┤
│ #nombre         │
├─────────────────┤
│ +hacerSonido()  │
│ +describirAnimal()│
└─────────────────┘
       ▲
       │ extends
   ┌───┴────┬───────┐
   │        │       │
┌──────┐ ┌──────┐ ┌──────┐
│Perro │ │ Gato │ │ Vaca │
└──────┘ └──────┘ └──────┘
```

### 6.4 Glosario de Términos

- **Herencia:** Mecanismo mediante el cual una clase adquiere propiedades y comportamientos de otra clase
- **Polimorfismo:** Capacidad de objetos de diferentes clases de responder al mismo mensaje
- **Clase Abstracta:** Clase que no puede ser instanciada y puede contener métodos abstractos
- **Método Abstracto:** Método declarado sin implementación que debe ser implementado por subclases
- **Sobrescritura:** Redefinición de un método heredado en una subclase
- **Upcasting:** Conversión de un objeto de subclase a tipo de superclase
- **instanceof:** Operador que verifica si un objeto es instancia de una clase específica
- **super:** Referencia a la superclase
- **@Override:** Anotación que indica sobrescritura de método
- **protected:** Modificador de acceso que permite visibilidad en subclases

### 6.5 Referencias

- Oracle Java Documentation - Inheritance: https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html
- Oracle Java Documentation - Polymorphism: https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html
- Oracle Java Documentation - Abstract Methods and Classes: https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
- Effective Java (Third Edition) - Joshua Bloch
- Material del curso de Programación 2 - TUP 2025

---

**FIN DEL INFORME**

---

### Resumen Ejecutivo

| Aspecto | Detalle |
|---------|---------|
| **Katas Completadas** | 4 de 4 (100%) |
| **Clases Implementadas** | 16 clases Java |
| **Conceptos Aplicados** | Herencia, Polimorfismo, Clases Abstractas, Upcasting, instanceof |
| **Organización** | 4 paquetes independientes |
| **Estado** | ✅ Trabajo Práctico COMPLETO |

---

*Informe generado el 20 de Noviembre de 2025*  
*Trabajo Práctico N° 7 - Herencia y Polimorfismo*  
*Programación 2 - TUP - Segundo Cuatrimestre 2025*
