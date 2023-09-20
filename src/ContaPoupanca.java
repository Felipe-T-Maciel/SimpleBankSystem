public class ContaPoupanca extends ContaBancaria{
    private double limite;

    public ContaPoupanca(double saldo, double limite) {
        super(saldo);
        this.limite = limite;
    }

    @Override
    public String sacar(double x) {
        if(x<this.getSaldo()){
            this.setSaldo((this.getSaldo()-x));
        }else if(x<(this.getSaldo() + limite)){
            this.limite = limite - (x-this.getSaldo());
            this.setSaldo(0);
        }else {
            return "Erro... Tente novamente mais tarde";
        }
        return "Operação bem sucedida!";
    }

    @Override
    public String depositar(double x) {
        if(x>0){
            this.setSaldo(this.getSaldo()+x);
            return "Operação bem sucedida!";
        }else {
            return "Erro... Tente novamente mais tarde";
        }
    }

    @Override
    public void transferir(double x, int id) {
        for (ContaBancaria conta:
             Banco.contas) {
            if(conta.getNumConta() == id){
                System.out.println("Fazendo tranferencia...");
                System.out.println(sacar(x));
                conta.depositar(x);
            }
        }
    }

    @Override
    public String mostarDados() {
        return "ContaPoupanca{" +
                "limite=" + limite +
                "} " + super.toString();
    }
}
