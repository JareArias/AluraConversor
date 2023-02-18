package divisas;

public class Dolar {
    private static final double SOL = 3.84;
    private static final double EURO = 0.93;

    private double dolar;

    public Dolar(double dolar) {
        this.dolar = dolar;
    }

    public Dolar() {
    }

    public double getDolar() {
        return dolar;
    }

    public void setDolar(double dolar) {
        this.dolar = dolar;
    }

    public double dolarSol(double dolar) {
        return dolar = Math.round((dolar * SOL) * 100.0) / 100.0;
    }

    public double dolarEuro(double dolar) {
        return dolar = Math.round((dolar * EURO) * 100.0) / 100.0;
    }

}
