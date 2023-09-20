public class Main {
    public static void main(String[] args) { }

    public static void menuLogado() {
        int escolha = 0;

        do{

            System.out.print(menuBanco());
            escolha = Executavel.sc.nextInt();
            operacoesMenu(escolha);

        } while(escolha != 5);
    }

    private static String menuBanco(){
        return """
           
           --- Bem vindo ao banco ---
               
               [1] Depositar
               [2] Sacar
               [3] Transferir
               [4] Gerar Relatorio
               [5] Retornar ao menu anterior
           --------------------------
           >\t""";
    }

    private static void operacoesMenu(int escolha){
        switch (escolha){
            case 1 -> {
                depositar();
            }
            case 2 -> {
                sacar();
            }
            case 3 -> {
                transferir();
            }
            case 4 -> {
                System.out.println(Executavel.logado.mostarDados());
            }
            case 5 -> {
                Executavel.main(null);
            }
        }
    }

    private static void transferir() {
        System.out.println("Numero da conta que deseja transferir: ");
        int conta = Executavel.sc.nextInt();
        System.out.println("Quantia que deseja mandar: ");
        double quantia = Executavel.sc.nextDouble();
        Executavel.logado.transferir(quantia, conta);
    }

    private static void sacar() {
        System.out.println("Quanto deseja sacar: ");
        double dinheiro = Executavel.sc.nextDouble();
        System.out.println(Executavel.logado.sacar(dinheiro));
    }

    private static void depositar() {
        System.out.println("Quanto deseja depositar: ");
        double dinheiro = Executavel.sc.nextDouble();
        System.out.println(Executavel.logado.depositar(dinheiro));
    }


}
