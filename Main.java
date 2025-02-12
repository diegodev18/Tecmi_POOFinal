import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pokemon> pokedex = new ArrayList<>(); // Aquí se crea el ArrayList de Pokemones
        Pokedex.iniciarPokedex(pokedex);

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
                if (!encontrado.checkStock('d', 1)) {
                    continue;
                }
                
                System.out.println(AnsiColors.GREEN.TXT + "Tu carta es: " + AnsiColors.RESET);
                encontrado.mostrarDatos();
                
                while (true) { // aqui lo encerre en el bucle
                    System.out.print("Ingresa tu pago: ");
                    int pago_maquina = scanner.nextInt();
                    scanner.nextLine();
                
                    if (pago_maquina < encontrado.PRECIO) {
                        System.out.println(AnsiColors.RED.TXT + " *** Falta dinero! Ingresa el monto exacto ***");
                    } else if (pago_maquina > encontrado.PRECIO) {
                        System.out.println(AnsiColors.RED.TXT + "Pagado - Tu cambio");
                        System.out.println(pago_maquina - encontrado.PRECIO);
                        encontrado.disminuirCantidad(1);
                        break;
                    } else {
                        System.out.println(AnsiColors.YELLOW.TXT + "* Pago completado *");
                        System.out.print(AnsiColors.RESET);
                        encontrado.disminuirCantidad(1);
                        break;
                    }
                }
            } else {
                System.out.println(AnsiColors.CYAN.TXT + "¡No se encuentra: #" + codigo_buscado + "!");
                System.out.println("Presione [" + AnsiColors.RED.TXT + "0" + AnsiColors.RESET + "] para salir");
            }
        }
        
        scanner.close();
    }
}