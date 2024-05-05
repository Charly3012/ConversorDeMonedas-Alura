package src.modelo;

public class Moneda {
    //private String monedaPrincipal;
    private Double usd; //Dolar americano
    private Double mxn; //Peso mexicano
    private Double eur; //Euro
    private Double ars; //Peso argentino
    private Double brl; //Real brasileño
    private Double jpy; //Yen


    public Moneda(MonedaRecord monedaRecord) {
        this.mxn = monedaRecord.mxn();
        this.ars = monedaRecord.ars();
        this.usd = monedaRecord.usd();
        this.brl = monedaRecord.brl();
        this.jpy = monedaRecord.jpy();
        this.eur = monedaRecord.eur();

    }

    /*
    public String getMonedaPrincipal() {
        return monedaPrincipal;
    }

    public void setMonedaPrincipal(String monedaPrincipal) {
        this.monedaPrincipal = monedaPrincipal;
    }
     */

    public double calcularCambio(double entrada, int tipoMoneda) {
        return (entrada * convertirTipo(tipoMoneda));
    }

    private double convertirTipo(int tipoMoneda){
        if(tipoMoneda == 1){
            return this.mxn;
        } else if (tipoMoneda == 2) {
            return this.usd;
        } else if (tipoMoneda == 3) {
            return this.eur;
        } else if (tipoMoneda == 4) {
            return this.ars;
        } else if (tipoMoneda == 5) {
            return this.brl;
        }else {
            return this.jpy;
        }
    }




    public Double getUsd() {
        return usd;
    }

    public void setUsd(Double usd) {
        this.usd = usd;
    }

    public Double getMxn() {
        return mxn;
    }

    public void setMxn(Double mxn) {
        this.mxn = mxn;
    }

    public Double getArs() {
        return ars;
    }

    public void setArs(Double ars) {
        this.ars = ars;
    }

    public Double getBrl() {
        return brl;
    }

    public void setBrl(Double brl) {
        this.brl = brl;
    }

    public Double getJpy() {
        return jpy;
    }

    public void setJpy(Double jpy) {
        this.jpy = jpy;
    }
}
