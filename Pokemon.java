import java.util.ArrayList;

public class Pokemon {
    int codigo;
    String nombre;
    String tipo;
    String habilidad;
    double precio;
    int cantidad;

    public Pokemon(int codigo, String nombre, String tipo, String habilidad, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.habilidad = habilidad;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + AnsiColors.YELLOW.TXT + this.nombre + AnsiColors.RESET);
        System.out.println("Tipo: " + AnsiColors.YELLOW.TXT + this.tipo + AnsiColors.RESET);
        System.out.println("Habilidad: " + AnsiColors.YELLOW.TXT + this.habilidad + AnsiColors.RESET);
        System.out.println("Precio: " + AnsiColors.YELLOW.TXT + "$" + this.precio + AnsiColors.RESET);
        System.out.println("Código: " + AnsiColors.YELLOW.TXT + this.codigo + AnsiColors.RESET);
    }

    public static Pokemon buscar(ArrayList<Pokemon> pokedex, int codigo) {
        for (Pokemon p : pokedex) {
            if (p.codigo == codigo) {
                return p;
            }
        }
        return null;
    }
}
