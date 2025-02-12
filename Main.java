import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pokemon> pokedex = new ArrayList<>(); // Aquí se crea el ArrayList de Pokemones

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
            }
            System.out.println();

            Pokemon encontrado = Pokemon.buscar(pokedex, codigo_buscado);

            if (encontrado != null) {
                System.out.println(AnsiColors.GREEN.TXT + "Tu carta es: " + AnsiColors.RESET);
                encontrado.mostrarDatos();
                System.out.print("\nIngresa tu pago: ");
                int pago_maquina = scanner.nextInt();
                scanner.nextLine();

                if (pago_maquina < encontrado.PRECIO) {
                    System.out.println(AnsiColors.RED.TXT + "Falta dinero!");
                } else {
                    System.out.println(AnsiColors.YELLOW.TXT + "Pago completado!");
                    pokedex.remove(encontrado);
                }
                System.out.print(AnsiColors.RESET);

            } else {
                System.out.println(AnsiColors.CYAN.TXT + "¡No se encuentra: " + codigo_buscado + "!");
                System.out.println("Presione [" + AnsiColors.RED.TXT + "0" + AnsiColors.RESET + "] para salir");
            }
        }
         
        scanner.close();
    }
}