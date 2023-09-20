abstract public class ContaBancaria implements IImprimivel{
    private int numConta = 0;
    private double saldo;

    public ContaBancaria(double saldo) {
        this.numConta = Banco.contas.size();
        this.saldo = saldo;
    }

    abstract public String sacar(double x);
    abstract public String depositar(double x);
    abstract public void transferir(double x, int id);

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numConta=" + numConta +
                ", saldo=" + saldo +
                '}';
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
