package divisas;

public class Euro {
    private static final double SOL = 4.09;
    private static final double DOLAR = 1.07;

    private double euro;

    public Euro() {
    }

    public Euro(double euro) {
        this.euro = euro;
    }

    public double getEuro() {
        return euro;
    }

    public void setEuro(double euro) {
        this.euro = euro;
    }

    public double euroDolar(double euro) {
        return euro = Math.round((euro * DOLAR) * 100.0) / 100.0;
    }

    public double euroSol(double euro) {
        return euro = Math.round((euro * SOL) * 100.0) / 100.0;
    }
}
