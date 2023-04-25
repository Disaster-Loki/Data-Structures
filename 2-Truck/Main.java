/* 
 * Realizado por: Sebastião de Carvalho & Rafael Marcos
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Listadupla<Caminhao> list = new Listadupla<>();
        int op = 0;

            Caminhao c1 = new Caminhao();
            c1.setModelo("Volvo");
            c1.setAltura(8);
            c1.setAnoFabricacao(2000);
            c1.setLargura(3);
            c1.setTara(5000);
            c1.setComprimento(20);
            c1.setPesoBrutoTotal(15000);
            c1.setPotenciaMotor(74);
            list.adicionar(c1);
            
            Caminhao c2 = new Caminhao();
            c2.setModelo("FordF-150");
            c2.setAltura(10.4);
            c2.setAnoFabricacao(2300);
            c2.setLargura(3.5);
            c2.setTara(6000);
            c2.setComprimento(26.8);
            c2.setPesoBrutoTotal(17000);
            c2.setPotenciaMotor(79);
            list.adicionar(c2);
            
            CaminhaoEspecial c3 = new CaminhaoEspecial();
            c3.setModelo("Freightliner");
            c3.setAltura(11.2);
            c3.setAnoFabricacao(2500);
            c3.setLargura(3.9);
            c3.setTara(6980);
            c3.setComprimento(28.3);
            c3.setPesoBrutoTotal(18910);
            c3.setPotenciaMotor(82);
            c3.setTipoCarga("Corpos");
            list.adicionarEspecial(c3);
        do {
            System.out.println("\t\t\t=================== MENU ===================");
            System.out.println("\t\t\t|  1 - Adicionar caminhão                  |");
            System.out.println("\t\t\t|  2 - Adicionar caminhão especial         |");
            System.out.println("\t\t\t|  3 - Consultar caminhão                  |");
            System.out.println("\t\t\t|  4 - Remover caminhão                    |");
            System.out.println("\t\t\t|  5 - Remover caminhão antigo             |");
            System.out.println("\t\t\t|  6 - Quantidade de caminhões             |");
            System.out.println("\t\t\t|  0 -  Sair                               |");
            System.out.println("\t\t\t============================================\n");
            System.out.print("Escolha uma opção: ");
            op = scan.nextInt();
            scan.nextLine(); 
            
            switch(op){
                case 1:
                       System.out.print("\n======================================\n");
                       System.out.print("\n Modelo: ");
                       String modelo = scan.nextLine();
                       System.out.print(" Tara: ");
                       double tara = scan.nextDouble();
                       System.out.print(" Altura: ");
                       double altura = scan.nextDouble();
                       System.out.print(" Largura: ");
                       double largura = scan.nextDouble();
                       System.out.print(" Comprimento: ");
                       double comprimento = scan.nextDouble();
                       System.out.print(" Potência do Motor: ");
                       int potenciaMotor = scan.nextInt();
                       System.out.print(" Peso bruto total: ");
                       double pesoBrutoTotal = scan.nextDouble();
                       System.out.print(" Ano de fabricação: ");
                       int anoFabricacao = scan.nextInt();
                       System.out.print("===========================================\n\n");
                       Caminhao caminhao = new Caminhao(modelo, anoFabricacao, pesoBrutoTotal, tara, potenciaMotor, largura, comprimento, altura);
                       list.adicionar(caminhao);
                       System.out.println("Caminhão adicionado.....\n");
                       break;
                case 2:
                       System.out.print("\n======================================\n");
                       String esp = "Especial";
                       System.out.print("\n Caminhão "+ esp);
                       System.out.print("\n Modelo: ");
                       String mod = scan.nextLine();
                       System.out.print(" Tara: ");
                       double tar = scan.nextDouble();
                       System.out.print(" Altura: ");
                       double alt = scan.nextDouble();
                       System.out.print(" Largura: ");
                       double lar = scan.nextDouble();
                       System.out.print(" Comprimento: ");
                       double comp = scan.nextDouble();
                       System.out.print(" Potência do Motor: ");
                       int potMoto = scan.nextInt();
                       System.out.print(" Peso bruto total: ");
                       double pbt = scan.nextDouble();
                       System.out.print(" Ano de fabricação: ");
                       int anoFabric = scan.nextInt();
                       System.out.print(" Tipo de carga: ");
                       final String tipocarga = scan.next();
                       System.out.print("\n===========================================\n\n");
                       CaminhaoEspecial caminhaoEspecial = new CaminhaoEspecial(mod, anoFabric, pbt, tar, potMoto, lar, comp, alt, tipocarga, esp);
                       list.adicionarEspecial(caminhaoEspecial);
                       System.out.println("Caminhão Especial adicionado....\n");
                       break;
                case 3: 
                       if(list == null){
                        System.out.print("\nLista Vazia!!!\n");
                       }
                        System.out.print("\n Digite o modelo: ");

                        String model = scan.nextLine();
                        list.consultar(model);
                       break;
                case 4:
                       System.out.print("\n Digite o modelo: ");
                       String mode = scan.nextLine();
                       list.remover(mode);
                       break;
                case 5:
                       System.out.print("\n Digite o modelo: ");
                       String mol = scan.nextLine();
                       System.out.print("\n Digite o Ano: ");
                       int ano = scan.nextInt();
                       list.removerAntigo(mol, ano);
                      break;
                case 6:
                      System.out.println("========================");
                      int size = list.tamanho();
                      if(size <= 1)
                        System.out.println("Tamanho: " + size + " Caminhão");
                      else
                        System.out.println("Tamanho: " + size + " Caminhões");
                      System.out.println("========================"); 
                      break;
                case 0: break;
                default: System.out.println("\nESCOLHA INVALIDA");
            }
        }while(op != 0);
    }


}
