
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
        double novoSaldo = saldo - valor - taxa;
        if (novoSaldo > 0) {
            this.setSaldo(novoSaldo);
            return true;
        } else {
            return false;
        }
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
