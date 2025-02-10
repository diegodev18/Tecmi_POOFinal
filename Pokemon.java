import java.util.ArrayList;

public class Pokemon {
    int codigo;
    String nombre;
    String tipo;
    String habilidad;
    double precio;

    public Pokemon(int codigo, String nombre, String tipo, String habilidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.habilidad = habilidad;
        this.precio = precio;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Habilidad: " + this.habilidad);
        System.out.println("Código: " + this.codigo);
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
