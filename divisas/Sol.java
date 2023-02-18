package divisas;

public class Sol {
    private static final double DOLAR = 0.26;
    private static final double EURO = 0.24;

    private double sol;

    public Sol(double sol) {
        this.sol = sol;
    }

    public Sol() {
    }

    public double getSol() {
        return sol;
    }

    public void setSol(double sol) {
        this.sol = sol;
    }

    public double solDolar(double sol) {
        return sol = sol * DOLAR;
    }

    public double solEuro(double sol) {
        return sol = sol * EURO;
    }

}
