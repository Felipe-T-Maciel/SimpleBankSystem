public class ContaCorrente extends ContaBancaria{
    private final double taxaOperacao;

    public ContaCorrente(double saldo, double taxaOperacao) {
        super(saldo);
        this.taxaOperacao = taxaOperacao;
    }

    @Override
    public String sacar(double x) {
        if(x<(this.getSaldo()-taxaOperacao)){
            this.setSaldo((this.getSaldo()-x)-taxaOperacao);
            return "Operação bem sucedida!";
        } else {
            return "Erro... Tente novamente mais tarde";
        }
    }

    @Override
    public String depositar(double x) {
        if(x>0){
            this.setSaldo((this.getSaldo()+x)-taxaOperacao);
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
        return "ContaCorrente{" +
                "taxaOperacao=" + taxaOperacao +
                "} " + super.toString();
    }
}
