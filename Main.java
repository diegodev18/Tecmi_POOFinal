import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pokedex pokedex = new Pokedex(); 
        limpiarConsola();

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
            
            System.out.println("\nPresione [" + AnsiColors.RED.TXT + "S" + AnsiColors.RESET + "] para salir");
            System.out.println("Presione [" + AnsiColors.RED.TXT + "R" + AnsiColors.RESET + "] para ver el Registro de Compras");
            
            System.out.print(AnsiColors.BLUE.TXT + "Ingrese tu Nombre: ");
            String nombre = scanner.nextLine();

            if (nombre.toLowerCase().equals("r")) {
                Registro_Compras.mostrarCompras();
                continue;
            }
            if (nombre.toLowerCase().equals("s")) {
                System.out.println(AnsiColors.RED.TXT + "Compra terminada" + AnsiColors.RESET);
                break;
            }

            System.out.print(AnsiColors.BLUE.TXT + "Ingrese el código: ");
            int codigo_buscado = scanner.nextInt();
            
            scanner.nextLine(); 
            System.out.print(AnsiColors.RESET);

            System.out.println();

            Pokemon encontrado = pokedex.buscar(codigo_buscado);

            if (encontrado != null) {
                if (!encontrado.checkStock(1)) {
                    continue;
                }

                System.out.println(AnsiColors.GREEN.TXT + "Tu carta es: " + AnsiColors.RESET);
                encontrado.mostrarDatos();

                while (true) {
                    System.out.print("Ingresa tu pago: ");
                    int pago_maquina = scanner.nextInt();
                    scanner.nextLine();

                    if (pago_maquina < encontrado.PRECIO) {
                        System.out.println(AnsiColors.RED.TXT + " *** Falta dinero! Ingresa el monto exacto ***");
                    } else {
                        if (pago_maquina > encontrado.PRECIO) {
                            System.out.println(AnsiColors.RED.TXT + "Pagado - Tu cambio: $" + (pago_maquina - encontrado.PRECIO));
                        } else {
                            System.out.println(AnsiColors.YELLOW.TXT + "* Pago completado *");
                        }
                        System.out.print(AnsiColors.RESET);
                        encontrado.disminuirCantidad(1);

                        Registro_Compras.registrarCompra(nombre, encontrado.NOMBRE);
                        System.out.println("Compra exitosamente.");
                        break;
                    }
                }
            } else {
                System.out.println(AnsiColors.CYAN.TXT + "¡No se encuentra: #" + codigo_buscado + "!");
            }
            continuarConEnter(scanner);
            limpiarConsola();
        }
        
        scanner.close();
    }

    private static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void continuarConEnter(Scanner scanner) {
        System.out.println("Presione " + AnsiColors.RED.TXT + "Enter" + AnsiColors.RESET + " para continuar");
        scanner.nextLine();
    }
}
