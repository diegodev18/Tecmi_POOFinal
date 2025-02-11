import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pokemon> pokedex = new ArrayList<>(); // Stock de Pokémon
        ArrayList<Pokemon> historialCompras = new ArrayList<>(); // Historial de compras

        // pokedex.add(new Pokemon(null, null, null)); // Aquí se crea un nuevo Pokemon (Cambiar null por los valores que quieras)
        pokedex.add(new Pokemon(101, "Pikachu", "Eléctrico", "Electricidad Estática", 120, 5));
        pokedex.add(new Pokemon(102, "Charmander", "Fuego", "Mar de Llamas", 150, 5));
        pokedex.add(new Pokemon(103, "Bulbasaur", "Planta/Veneno", "Espesura", 130, 5));
        pokedex.add(new Pokemon(104, "Squirtle", "Agua", "Torrente", 140, 5));
        pokedex.add(new Pokemon(105, "Eevee", "Normal", "Fuga", 160, 5));
        pokedex.add(new Pokemon(106, "Gengar", "Fantasma/Veneno", "Levitación", 200, 5));

        while (true) {
            System.out.println("Stock de Pokémon disponible:");
            System.out.println(AnsiColors.CYAN.TXT + "Nombre" + " ".repeat(10) + "Codigo" + " ".repeat(5) + "Precio" + " ".repeat(5) + "Cantidad" + AnsiColors.RESET);
            for (Pokemon p : pokedex) {
                System.out.print(p.NOMBRE);
                System.out.print(" ".repeat(16 - p.NOMBRE.length()));
                System.out.print("#" + p.CODIGO);
                System.out.print(" ".repeat(10 - String.valueOf(p.CODIGO).length()));
                System.out.print("$" + p.PRECIO);
                System.out.print(" ".repeat(10 - String.valueOf(p.PRECIO).length()));
                System.out.print(p.cantidad);
                System.out.println();
            }
            System.out.println("\nPresione [" + AnsiColors.RED.TXT + "0" + AnsiColors.RESET + "] para salir");
            System.out.print(AnsiColors.BLUE.TXT + "Ingrese el código: ");
            int codigo_buscado = scanner.nextInt();
            System.out.print(AnsiColors.RESET);
            
            if (codigo_buscado == 0) {
                System.out.println(AnsiColors.RED.TXT + "Compra terminada" + AnsiColors.RESET);
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
