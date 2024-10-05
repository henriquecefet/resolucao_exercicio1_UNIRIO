
public class ContaBancaria {
    private double saldo;
    private static double taxa = 1.50;
    public ContaBancaria(double saldoInicial) {
        this.setSaldo(saldoInicial);
    }
    public void depositar(double valor) {
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
        }
    }
    public boolean sacar(double valor) {
        double novoSaldo = this.getSaldo() - valor - taxa;
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
    public boolean setSaldo(double saldo) {
        if(saldo >= 0) {
            this.saldo = saldo;
            return true;
        }
        else{
            return false;
        }
    }
}
