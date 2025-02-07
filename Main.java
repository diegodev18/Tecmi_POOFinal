public class Main {
    public static void main(String[] args) {
        // Pockemon pockemon = new Pockemon("Pickachu", "Trueno", "Electrico");
    }

    public static class Pockemon {
        String nombre;
        String tipo;
        String habilidad;

        public Pockemon(String nombre, String tipo, String habilidad) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.habilidad = habilidad;
        }
    }
}