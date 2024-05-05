package src;

import src.controlador.HttpClient;
import src.modelo.Moneda;
import src.vista.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        HttpClient apiRequest = new HttpClient();
        Moneda monedaConsulta;
        int tOrigen, tSalida;
        double cOrigen, cSalida;

        System.out.println("--- Bienvenido al conversor de monedas ---");
        while (true) {
            menu.monedas();

            //Pedir moneda de entrada y la cantidad
            System.out.println("Ingrese la moneda origen: ");
            tOrigen = sc.nextInt();
            if(tOrigen == 7)
                break;

            System.out.println("Ingrese la cantidad que desea convertir: ");
            cOrigen = sc.nextDouble();

            monedaConsulta = new Moneda(apiRequest.consultarMoneda(tOrigen));

            System.out.println("Ingrese la moneda de destino: ");
            tSalida = sc.nextInt();
            if(tSalida == 7)
                break;

            //Imprimir la moneda de salida
            System.out.println(menu.imprimirSalida(tOrigen, tSalida, monedaConsulta.calcularCambio(cOrigen, tOrigen)));;

            System.out.println("\n\nCalcular otra moneda");
        }

        System.out.println("Gracias por usar el conversor de monedas");
    }
}
