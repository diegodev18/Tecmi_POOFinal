import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pokemon> pokedex = new ArrayList<>(); // Stock de Pokémon
        ArrayList<Pokemon> historialCompras = new ArrayList<>(); // Historial de compras

        // Agregar Pokémon al stock
        pokedex.add(new Pokemon(101, "Pikachu", "Eléctrico", "Electricidad Estática", 120.50, 5));
        pokedex.add(new Pokemon(102, "Charmander", "Fuego", "Mar de Llamas", 150.75, 5));
        pokedex.add(new Pokemon(103, "Bulbasaur", "Planta/Veneno", "Espesura", 130.00, 5));
        pokedex.add(new Pokemon(104, "Squirtle", "Agua", "Torrente", 140.25, 5));
        pokedex.add(new Pokemon(105, "Eevee", "Normal", "Fuga", 160.00, 5));
        pokedex.add(new Pokemon(106, "Gengar", "Fantasma/Veneno", "Levitación", 200.00, 5));

        while (true) {
            System.out.println("\n¿Qué desea hacer?");
            System.out.println("[C] Comprar una carta");
            System.out.println("[H] Ver historial de compras");
            System.out.println("[0] Salir");
            System.out.print("Ingrese su opción: ");
            String opcion = scanner.next().toUpperCase();

            if (opcion.equals("0")) {
                System.out.println("Saliendo del sistema...");
                break;
            } else if (opcion.equals("H")) {
                System.out.println("\nHistorial de compras:");
                if (historialCompras.isEmpty()) {
                    System.out.println("Aún no ha comprado ninguna carta.");
                } else {
                    for (Pokemon p : historialCompras) {
                        System.out.println(p.NOMBRE + " - " + p.CODIGO + " - $" + p.PRECIO);
                    }
                }
            } else if (opcion.equals("C")) {
                System.out.println("\nStock de Pokémon disponible:");
                for (Pokemon p : pokedex) {
                    System.out.println(p.NOMBRE + " - " + p.CODIGO + " - $" + p.PRECIO);
                }

                System.out.print("\nIngrese el código del Pokémon que desea comprar: ");
                int codigo_buscado = scanner.nextInt();

                Pokemon encontrado = Pokemon.buscar(pokedex, codigo_buscado);

                if (encontrado != null) {
                    System.out.println("\nTu carta es:");
                    encontrado.mostrarDatos();
                    System.out.print("\nIngresa tu pago: ");
                    double pago_maquina = scanner.nextDouble();

                    if (pago_maquina < encontrado.PRECIO) {
                        System.out.println("Falta dinero! Transacción cancelada.");
                    } else {
                        System.out.println("Pago completado! Entregando carta...");
                        pokedex.remove(encontrado); // Eliminar del stock
                        historialCompras.add(encontrado); // Agregar al historial
                    }
                } else {
                    System.out.println("¡No se encontró la carta con código " + codigo_buscado + "!");
                }
            } else {
                System.out.println("Opción no válida, intente nuevamente.");
            }
        }
        scanner.close();
    }
}
