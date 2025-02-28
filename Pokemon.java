public class Pokemon {
    final int CODIGO;
    final String NOMBRE;
    final String TIPO;
    final String HABILIDAD;
    final double PRECIO;
    int cantidad;
    String propietario;

    public Pokemon(int codigo, String nombre, String tipo, String habilidad, double precio, int cantidad) {
        this.CODIGO = codigo;
        this.NOMBRE = nombre;
        this.TIPO = tipo;
        this.HABILIDAD = habilidad;
        this.PRECIO = precio;
        this.cantidad = cantidad;
        this.propietario = null;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + AnsiColors.YELLOW.TXT + this.NOMBRE + AnsiColors.RESET);
        System.out.println("Tipo: " + AnsiColors.YELLOW.TXT + this.TIPO + AnsiColors.RESET);
        System.out.println("Habilidad: " + AnsiColors.YELLOW.TXT + this.HABILIDAD + AnsiColors.RESET);
        System.out.println("Precio: " + AnsiColors.YELLOW.TXT + "$" + this.PRECIO + AnsiColors.RESET);
        System.out.println("Código: " + AnsiColors.YELLOW.TXT + this.CODIGO + AnsiColors.RESET);
    }

    public void disminuirCantidad(int cantidad) {
        this.cantidad -= cantidad;
    }

    public void aumentarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public boolean checkStock(int cantidad) {
        if (this.cantidad < cantidad) {
            System.out.println("No hay suficiente stock de " + this.NOMBRE + " para comprar " + cantidad);
            return false;
        }
        return true;
    }
}
