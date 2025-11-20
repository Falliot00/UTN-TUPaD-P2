
package kata2_figuras;

public class MainFiguras {

    public static void main(String[] args) {
        // Tarea: Crear un array de figuras 
        // Usamos Upcasting: guardamos un 'Circulo' en una variable 'Figura'
        Figura[] figuras = new Figura[2];
        figuras[0] = new Circulo("Círculo 1", 10.0);
        figuras[1] = new Rectangulo("Rectángulo 1", 5.0, 8.0);

        // Tarea: Mostrar el área de cada una usando polimorfismo 
        System.out.println("Calculando áreas usando polimorfismo:");
        
        for (Figura fig : figuras) {
            System.out.println("Área de " + fig.getNombre() + ": " + fig.calcularArea());
        }
    }
}