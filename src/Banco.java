import java.util.ArrayList;

public class Banco implements IImprimivel{
    static ArrayList<ContaBancaria> contas = new ArrayList<>();

    public void inserir(ContaBancaria ob){
        contas.add(ob);
    }

    public void remover(ContaBancaria ob){
        contas.remove(ob);
    }

    public ContaBancaria procurarConta(int numConta){
        for (ContaBancaria conta:
             contas) {
            if(conta.getNumConta() == numConta){
                return conta;
            }
        }
        return null;
    }

    @Override
    public String mostarDados() {
        for (ContaBancaria conta:
             contas) {
            System.out.println(conta.mostarDados());
        }
        return null;
    }
}
