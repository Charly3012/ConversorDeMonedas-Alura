package src;

import src.vista.Menu;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Bienvenido al conversor de monedas ---");
        while (true) {
            menu.monedas();

        }
    }
}
