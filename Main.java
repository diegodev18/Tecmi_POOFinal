import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pokemon> pokedex = new ArrayList<>(); // Aquí se crea el ArrayList de Pokemones

        // pokedex.add(new Pokemon(null, null, null)); // Aquí se crea un nuevo Pokemon (Cambiar null por los valores que quieras)
        pokedex.add(new Pokemon(101, "Pikachu", "Eléctrico", "Electricidad Estática", 120.50));
        pokedex.add(new Pokemon(102, "Charmander", "Fuego", "Mar de Llamas", 150.75));
        pokedex.add(new Pokemon(103, "Bulbasaur", "Planta/Veneno", "Espesura", 130.00));
        pokedex.add(new Pokemon(104, "Squirtle", "Agua", "Torrente", 140.25));
        pokedex.add(new Pokemon(105, "Eevee", "Normal", "Fuga", 160.00));
        pokedex.add(new Pokemon(106, "Gengar", "Fantasma/Veneno", "Levitación", 200.00));

        while (true) {
            System.out.println("Stock de Pokémon disponible:");
            for (Pokemon p : pokedex) {
                System.out.println(p.nombre + " - " + p.codigo + " - " + p.precio);
            }
            System.out.println("\nPresione [0] para salir");
            System.out.print("Ingrese el código: ");
            int codigo_buscado = scanner.nextInt();
            
            if (codigo_buscado == 0) {
                System.out.println("Compra terminada");
                break;
            }
            System.out.println();

            Pokemon encontrado = Pokemon.buscar(pokedex, codigo_buscado);

            if (encontrado != null) {
                System.out.println("Tu carta es: ");
                encontrado.mostrarDatos();
                System.out.print("\nIngresa tu pago: ");
                int pago_maquina = scanner.nextInt();
                scanner.nextLine();

                if (pago_maquina < encontrado.precio) {
                    System.out.println("Falta dinero!");
                } else {
                    System.out.println("Pago completado!");
                }

                pokedex.remove(encontrado);
            } else {
                System.out.println("No se encuentra: " + codigo_buscado + " - presione 0 para salir");
            }
        }
        scanner.close();
    }
}