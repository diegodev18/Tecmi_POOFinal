import java.util.ArrayList;

public class Pokemon {
    final int CODIGO;
    final String NOMBRE;
    final String TIPO;
    final String HABILIDAD;
    final double PRECIO;
    int cantidad;

    public Pokemon(int codigo, String nombre, String tipo, String habilidad, double precio, int cantidad) {
        this.CODIGO = codigo;
        this.NOMBRE = nombre;
        this.TIPO = tipo;
        this.HABILIDAD = habilidad;
        this.PRECIO = precio;
        this.cantidad = cantidad;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + AnsiColors.YELLOW.TXT + this.NOMBRE + AnsiColors.RESET);
        System.out.println("Tipo: " + AnsiColors.YELLOW.TXT + this.TIPO + AnsiColors.RESET);
        System.out.println("Habilidad: " + AnsiColors.YELLOW.TXT + this.HABILIDAD + AnsiColors.RESET);
        System.out.println("Precio: " + AnsiColors.YELLOW.TXT + "$" + this.PRECIO + AnsiColors.RESET);
        System.out.println("Código: " + AnsiColors.YELLOW.TXT + this.CODIGO + AnsiColors.RESET);
    }

    public void disminuirCantidad(int cantidad) {
        if (this.cantidad - cantidad < 0) {
            System.out.println(AnsiColors.RED.TXT + "No hay suficiente stock" + AnsiColors.RESET);
            return;
        }
        this.cantidad -= cantidad;
    }

    public void aumentarCantidad(int cantidad) {
        if (cantidad < 0) {
            System.out.println(AnsiColors.RED.TXT + "No se puede agregar una cantidad negativa" + AnsiColors.RESET);
            return;
        }
        this.cantidad += cantidad;
    }

    public static Pokemon buscar(ArrayList<Pokemon> pokedex, int codigo) {
        for (Pokemon p : pokedex) {
            if (p.CODIGO == codigo) {
                return p;
            }
        }
        return null;
    }
}
