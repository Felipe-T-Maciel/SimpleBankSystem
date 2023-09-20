import java.util.Scanner;

public class Executavel {

    static Banco banco = new Banco();
    static Scanner sc = new Scanner(System.in);
    static ContaBancaria logado = null;

    public static void main(String[] args) {
        int escolha = 0;
        do{

            System.out.print(menuBanco());
            escolha = sc.nextInt();
            operacoesMenu(escolha);

        } while(escolha != 5);
    }

    private static String menuBanco(){
        return """
           
           --- Bem vindo ao banco ---
               
               [1] Criar conta
               [2] Selecionar Conta
               [3] Remover Conta
               [4] Gerar Relatorio
               [5] Finalizar
           --------------------------
           >\t""";
    }

    private static void operacoesMenu(int escolha){
        switch (escolha){
            case 1 -> {
                criarConta();
            }
            case 2 -> {
                selecionarConta();
            }
            case 3 -> {
                removerConta();
            }
            case 4 -> {
                banco.mostarDados();
            }
            case 5 -> {
                System.out.println("Fechando as portas...");
                System.exit(0);
            }
        }
    }

    private static void removerConta() {
        System.out.println("o numero da sua conta: ");
        int num = sc.nextInt();
        if(banco.procurarConta(num) != null){
            banco.remover(banco.procurarConta(num));
        }
    }

    private static void selecionarConta() {
        System.out.println("o numero da sua conta: ");
        int num = sc.nextInt();
        if(banco.procurarConta(num) != null){
            logado = banco.procurarConta(num);
            Main.menuLogado();
        }else {
            System.out.println("A conta não existe");
        }
    }

    private static void criarConta() {
        double saldo = 0;
        System.out.print("""
                        
                        Tipo da conta que deseja:
                        [1] Conta Corrente
                        [2] Conta Poupança
                        >\t""");
        int escolhaConta = sc.nextInt();
        if(escolhaConta==1 || escolhaConta==2){
            System.out.println("Saldo da conta: ");
            saldo = sc.nextDouble();
            if(escolhaConta==1){
                System.out.println("Taxa de operação do banco: ");
                double taxa = sc.nextDouble();
                banco.inserir(new ContaCorrente(saldo, taxa));
            }else {
                System.out.println("Limite da conta: ");
                double limite = sc.nextDouble();
                banco.inserir(new ContaPoupanca(saldo, limite));
            }
            System.out.println("O numero da sua conta: "+Banco.contas.get(Banco.contas.size()-1).getNumConta());
        }
    }
}
