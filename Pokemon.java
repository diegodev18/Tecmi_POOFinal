public class Pokemon {
    String nombre;
    String tipo;
    String habilidad;

    public Pokemon(String nombre, String tipo, String habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.habilidad = habilidad;
        this.mostrarDatos();
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Habilidad: " + this.habilidad);
    }
}
