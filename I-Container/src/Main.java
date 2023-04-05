import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Pilha pilha = new Pilha();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("========================");
            System.out.println("   1 - Carregamento");
            System.out.println("   2 - Descarregamento");
            System.out.println("   3 - Mostrar pilha");
            System.out.println("   0 - Sair");
            System.out.println("========================");
            System.out.print("\nEscolha uma opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    //Carregando
                    System.out.print("Quantos Contentores: ");
                    int n = scanner.nextInt();
                    for(int i=0;i<n;i++) {
                        System.out.print("\n=====================\n");
                        System.out.print("ID do "+(i+1)+" contentor: ");
                        int id = scanner.nextInt();
                        System.out.print("Peso: ");
                        double peso = scanner.nextDouble();
                        System.out.print("Comprimento: ");
                        double comprimento = scanner.nextDouble(); scanner.nextLine();
                        System.out.print("Tipo: ");
                        String tipo = scanner.nextLine();
                        System.out.print("Conteudo: ");
                        String conteudo = scanner.nextLine();
                        System.out.print("Origem: ");
                        String origem = scanner.nextLine();
                        //scanner.next();
                        System.out.print("Destino: ");
                        String destino = scanner.nextLine();
                        System.out.print("\n======================\n ");
                        Contentor contentor = new Contentor(id, peso, comprimento, tipo, conteudo, destino, origem);
                        pilha.adicionar(contentor);
                    }
                    System.out.println("Contentor carregado na pilha.");
                    break;
                case 2:
                    //Descarregar
                    int opt;
                    do{
                        if(pilha.vazia()){
                            System.out.println("Pilha vazia");
                            break;
                        }
                        System.out.println("============================");
                        System.out.println("   1 - Quantidade");
                        System.out.println("   2 - Todos");
                        System.out.println("   3 - Topo");
                        System.out.println("   0 - Voltar");
                        System.out.println("============================");
                        System.out.print("\nEscolha uma opcao: ");
                        opt = scanner.nextInt();
                        try{
                            System.out.print("\n");
                            switch(opt){
                                case 1:
                                    System.out.print("Quantidade: ");
                                    int aux = scanner.nextInt();
                                    if (pilha.vazia()) {
                                        System.out.println("Pilha vazia");
                                    }
                                    else if(aux > pilha.tamanho()){
                                        System.out.println("Quantidade acima da existente");
                                    }
                                    else if(aux == 0){
                                        System.out.println("Nenhum contentor descarregado");
                                    }
                                    else {
                                        for(int i=0; i < aux;i++){
                                            Contentor contentorDesc = pilha.pop();
                                            System.out.println("Contentor: " + contentorDesc.getId() + " Descarregado");
                                        }
                                    }
                                    break;
                                case 2:
                                    if (!pilha.vazia()) {
                                        pilha.remover();
                                        System.out.println("Removido\n");
                                    } else {
                                        System.out.println("Pilha vazia");
                                    }
                                    break;
                                case 3:
                                    if (!pilha.vazia()) {
                                        Contentor contentorDesc = pilha.pop();
                                        System.out.println("Descarregado Contentor: " + contentorDesc.getId());
                                    } else {
                                        System.out.println("Pilha vazia");
                                    }
                                    break;
                                case 0: break;
                                default: System.out.print("\n Escolha invalida");
                            }
                        }catch(Exception e){
                            System.out.print("ERRO!!");}
                    }while(opt != 0);

                    break;
                case 3:
                    //Listar
                    if(!pilha.vazia()){
                        pilha.iterate();
                    }else {
                        System.out.println("A pilha esta vazia.");
                    }
                    break;
                case 0:
                    System.out.println("\nTerminando o programa...");
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }
}
