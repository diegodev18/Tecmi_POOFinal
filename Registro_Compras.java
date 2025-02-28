import java.util.ArrayList;
import java.util.Scanner;

public class Registro_Compras {
    private static ArrayList<Registro_Compras> listaCompras = new ArrayList<>();
    private String nombreCliente;
    private String producto;

    public Registro_Compras(String nombreCliente, String producto) {
        this.nombreCliente = nombreCliente;
        this.producto = producto;
    }

    public static void registrarCompra(String nombre, String producto) {
        listaCompras.add(new Registro_Compras(nombre, producto));
    }

    public static void mostrarCompras() {
        System.out.println("\n=== Registro de Compras ===");
        if (listaCompras.isEmpty()) {
            System.out.println("No hay compras registradas.");
        } else {
            for (Registro_Compras compra : listaCompras) {
                System.out.println("Cliente: " + compra.nombreCliente + " | Producto: " + compra.producto);
            }
        }
    }

    public static void continuarConEnter(Scanner scanner) {
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }

    private static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
