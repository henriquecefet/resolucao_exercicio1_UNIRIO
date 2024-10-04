
public class ContaBancaria {
    private double saldo;
    private static double taxa = 1.50;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor + taxa > 0 && valor <= saldo) {
            saldo -= taxa;
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public double getSaldo() {
        return saldo;
    }

}
