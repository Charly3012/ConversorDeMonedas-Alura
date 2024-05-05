package src.vista;

public class Menu {

    public void monedas(){
        System.out.println("Monedas soportadas: \n");
        System.out.println("1 - Peso Mexicano [MXN]");
        System.out.println("2 - Dolar Estadounidense  [USD]");
        System.out.println("3 - Euro [EUR]");
        System.out.println("4 - Peso Argentino [ARS]");
        System.out.println("5 - Real Brasileño [BRL]");
        System.out.println("6 - Yen Japones [JPY]");
        System.out.println("7 - Salir");
    }

    public String imprimirSalida(int tOrigen, int tSalida, double cambio){


        return ("La cantidad de $" + stringMoneda(1) + " es equivalente a $" + cambio + stringMoneda(tSalida));
    }

    private String stringMoneda(int moneda){
        if(moneda == 1){
            return " MXN";
        } else if (moneda == 2) {
            return " USD";
        } else if (moneda == 3) {
            return " EUR";
        } else if (moneda == 4) {
            return " ARS";
        } else if (moneda == 5) {
            return " BRL";
        }else {
            return " JPY";
        }
    }
}
