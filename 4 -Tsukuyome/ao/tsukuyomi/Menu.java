package ao.tsukuyomi;

import ao.tsukuyomi.datastructures.BinaryTree;
import ao.tsukuyomi.datastructures.CircularList;
import ao.tsukuyomi.datastructures.Queue;
import ao.tsukuyomi.datastructures.Stack;
import ao.tsukuyomi.game.mechanics.Action;
import ao.tsukuyomi.game.objects.Player;
import ao.tsukuyomi.game.objects.Skill;

import java.util.Scanner;

public class Menu {
    private Admin admin;
    private boolean isLoggedIn;
    private Scanner scan;
    private Queue queue;
    private Stack stack;
    private CircularList circularList;
    private BinaryTree binaryTree;

    public Menu() {
        this.admin = new Admin("admin", "admin123");
        this.isLoggedIn = false;
        this.scan = new Scanner(System.in);
        this.queue = new Queue();
        this.stack = new Stack(queue);
        this.circularList = new CircularList(queue);
        this.binaryTree = new BinaryTree();
        testPlayer();
        testSkills();
    }

    public boolean login(String username, String password) {
        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            isLoggedIn = true;
            return true;
        }
        return false;
    }

    public void logout() {
        isLoggedIn = false;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void showMenuMain() {
        while (true) {
            System.out.println("\t\t\t=========== Main Menu ===========");
            System.out.println("\t\t\t|        1 - Queue             |");
            System.out.println("\t\t\t|        2 - Stack             |");
            System.out.println("\t\t\t|        3 - Circular List     |");
            System.out.println("\t\t\t|        4 - Binary Tree       |");
            System.out.println("\t\t\t|        5 - Graphs            |");
            System.out.println("\t\t\t|        6 - Logout            |");
            System.out.println("\t\t\t================================\n\n");
            System.out.print("Choose Option: ");

            int option;
            try {
                option = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Try again.");
                continue;
            }

            switch (option) {
                case 1:
                    showQueueMenu(scan);
                    break;
                case 2:
                    showStackMenu(scan);
                    break;
                case 3:
                    showCircularListMenu(scan);
                    break;
                case 4:
                    showBinaryTreeMenu(scan);
                    break;
                case 5:
                    showGraphsMenu(scan);
                    break;
                case 6:
                    logout();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }

    public void testPlayer(){
     Player player = new Player();
        player.setNome("Nane tate bayo");
        player.setIdade(18);
        player.setGenero("Masculino");
        player.setEmail("nanetabebayo@narumail.com");
        player.setNick("naruto");
        player.setSenha("nanetate");
        queue.AddPlayer(player);

     Player player2 = new Player();
        player2.setNome("force hate");
        player2.setIdade(19);
        player2.setGenero("Masculino");
        player2.setEmail("forcehate@fohmail.com");
        player2.setNick("sasuke");
        player2.setSenha("sasuke");
        queue.AddPlayer(player2);
    }

    public void showQueueMenu(Scanner scanner) {
        int option;
        do{
        System.out.println("\n\t\t\t=========== Queue Menu ===========");
        System.out.println("\t\t\t|       1 - Create Player        |");
        System.out.println("\t\t\t|       2 - Read Player          |");
        System.out.println("\t\t\t|       3 - Edit Player          |");
        System.out.println("\t\t\t|       4 - List Player          |");
        System.out.println("\t\t\t|       5 - Remove Player        |");
        System.out.println("\t\t\t|       6 - Remove All Players   |");
        System.out.println("\t\t\t|       7 - Go Back              |");
        System.out.println("\t\t\t==================================\n\n");
        System.out.print("Choose Option: ");
        option = Integer.parseInt(scan.nextLine());

        switch (option) {
            case 1:
                System.out.print("Enter player name: ");
                String name = scanner.nextLine();
                System.out.print("Enter player age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter player gender: ");
                String gender = scanner.nextLine();
                System.out.print("Enter player email: ");
                String email = scanner.nextLine();
                System.out.print("Enter player nick: ");
                String nick = scanner.nextLine();
                System.out.print("Enter player password: ");
                String pass = scanner.nextLine();
                Player newPlayer = new Player(name, age, gender, email, nick, pass);
                queue.AddPlayer(newPlayer);
                System.out.println("\nao.tsukuyomi.game.objects.Player added successfully.");
                break;
            case 2:
                if (queue.ListPlayer().isEmpty()){
                     System.out.println("ao.tsukuyomi.datastructures.No players in the queue.");
                }else {
                     System.out.print("\n\tNick: ");
                     String consulta_nick = scan.nextLine();
                     queue.ConsultPlayer(consulta_nick);
                   }
                break;
            case 3:
                 if (queue.ListPlayer().isEmpty()){
                     System.out.println("ao.tsukuyomi.datastructures.No players in the queue.");
                }else {
                     System.out.print("\n\tNick: ");
                     String edit_nick = scan.nextLine();
                     queue.EditPlayer(edit_nick);
                   }
                break;
            case 4:
                 queue.PrintAllPlayers();
                 break;
            case 5:
                if (queue.ListPlayer().isEmpty()){
                     System.out.println("ao.tsukuyomi.datastructures.No players in the queue.");
                }else {
                     System.out.print("\n\tNick: ");
                     String remove_nick = scan.nextLine();
                     queue.RemovePlayer(remove_nick);
                   }
                break;
            case 6:
                queue.RemoverAllPlayer();
                break;
            case 7:
                return;
            default:
                System.out.print("Invalid option\n");
                break;
        }
      }while(option != 7);
    }

    public void showStackMenu(Scanner scanner) {
    int option;
    do {
        System.out.println("\n\t\t\t=========== ao.tsukuyomi.datastructures.Stack ao.tsukuyomi.Menu ===========");
        System.out.println("\t\t\t|       1 - Connect ao.tsukuyomi.game.mechanics.Action       |");
        System.out.println("\t\t\t|       2 - Read ao.tsukuyomi.game.mechanics.Action          |");
        System.out.println("\t\t\t|       3 - ao.tsukuyomi.game.mechanics.Action History       |");
        System.out.println("\t\t\t|       4 - Remove ao.tsukuyomi.game.mechanics.Action        |");
        System.out.println("\t\t\t|       5 - Delete All Actions   |");
        System.out.println("\t\t\t|       6 - Go Back              |");
        System.out.println("\t\t\t==================================\n\n");
        System.out.print("Choose Option: ");
        option = Integer.parseInt(scan.nextLine());

        switch (option) {
            case 1:
                Action action = new Action();
                if (queue.ListPlayer().isEmpty()) {
                    System.out.println("ao.tsukuyomi.datastructures.No players in the queue.");
                } else {
                    System.out.print("\nNick of the player: ");
                    String playerNick = scan.nextLine();
                    Player player = queue.FindPlayer(playerNick);
                    if (player != null) {
                        System.out.print("Enter the action: ");
                        String playerAction = scan.nextLine();
                        action.AddAction(player, playerAction);
                        stack.addAction(action);
                        System.out.println("ao.tsukuyomi.game.mechanics.Action connected successfully!");
                    } else {
                        System.out.println("ao.tsukuyomi.game.objects.Player not found in the queue.");
                    }
                }
                break;
            case 2:
                if (stack.getActions().isEmpty()) {
                    System.out.println("ao.tsukuyomi.datastructures.No actions in the stack.");
                } else {
                    System.out.print("\nNick: ");
                    String nick = scan.nextLine();
                    stack.ReadAction(nick);
                }
                break;
            case 3:
                if (stack.getActions().isEmpty()) {
                    System.out.println("ao.tsukuyomi.datastructures.No actions in the stack.");
                } else {
                    stack.ActionHistory();
                }
                break;
            case 4:
                if (stack.getActions().isEmpty()) {
                    System.out.println("ao.tsukuyomi.datastructures.No actions in the stack.");
                } else {
                    System.out.print("\nNick: ");
                    String nickname = scan.nextLine();
                    stack.removeTopAction(nickname);
                }
                break;
            case 5:
                if (stack.getActions().isEmpty()) {
                    System.out.println("ao.tsukuyomi.datastructures.No actions in the stack.");
                } else {
                    stack.removeAllActions();
                    System.out.println("All actions removed.");
                }
                break;
            case 6:
                return;
            default:
                System.out.print("Invalid option\n");
                break;
        }

    } while (option != 6);
}

    public void showCircularListMenu(Scanner scanner) {
        int option;
        do{
            System.out.println("\n\t\t\t========== ao.tsukuyomi.datastructures.CircularList ao.tsukuyomi.Menu ==========");
            System.out.println("\t\t\t|          1 - Connection ao.tsukuyomi.game.objects.Skill      |");
            System.out.println("\t\t\t|          2 - Start ao.tsukuyomi.game.mechanics.Battle          |");
            System.out.println("\t\t\t|          3 - Read ao.tsukuyomi.game.mechanics.Battle           |");
            System.out.println("\t\t\t|          4 - ao.tsukuyomi.game.mechanics.Battle History        |");
            System.out.println("\t\t\t|          5 - Remove ao.tsukuyomi.game.mechanics.Battle         |");
            System.out.println("\t\t\t|          6 - Remove History        |");
            System.out.println("\t\t\t|          7 - Go Back               |");
            System.out.println("\t\t\t=========================================\n\n");
            System.out.print("Choose Option: ");
            option = Integer.parseInt(scan.nextLine());
            switch(option){
                case 1: 
                      if(queue.ListPlayer().isEmpty()){
                        System.out.println("ao.tsukuyomi.datastructures.No players int the queue");
                      }else{
                        System.out.print("Nick ao.tsukuyomi.game.objects.Player: ");
                        String nick_player = scan.nextLine();
                        System.out.print("Name ao.tsukuyomi.game.objects.Skill: ");
                        String nameskill = scan.nextLine();
                        circularList.ConnectionPlayer(nick_player, nameskill);
                      }
                      break;
                case 2:
                      System.out.print("Nick ao.tsukuyomi.game.objects.Player 1: ");
                      String nickplayer = scan.nextLine();
                      System.out.print("Nick Palyer 2: ");
                      String nickplayer2 = scan.nextLine();
                      circularList.StartBattle(nickplayer, nickplayer2);
                      break;
                case 3:
                      System.out.println("Nick: ");
                      String nickname = scan.nextLine();
                      circularList.ReadBattle(nickname);
                      break;
                case 4:
                      circularList.BattleHistory();
                      break;
                case 5:
                      System.out.println("\n\tNickname: ");
                      String remove_nick = scan.nextLine(); 
                      circularList.RemoveBattle(remove_nick);
                      break;
                case 6:
                      circularList.RemoveHistory();
                      break;
                case 7:
                      return;
                default:
                       System.out.print("Invalid Option!!\n");
                       break;
            }

        }while(option != 6);
    }

    public void testSkills() {
           Skill skill1 = new Skill("God of Void Azathod", "Domain of void", 10);
           binaryTree.createSkill(skill1);

           Skill skill2 = new Skill("King of knowledge Rafael", "Being of knowledge", 6);
           binaryTree.createSkill(skill2);

           Skill skill3 = new Skill("King of Death Seba","Domain of", 10);
           binaryTree.createSkill(skill3);
         }

    public void showBinaryTreeMenu(Scanner scanner) {
        int option;
        do {
            System.out.println("\n\t\t\t=========== Binary Tree ao.tsukuyomi.Menu ============");
            System.out.println("\t\t\t|       1 - Create ao.tsukuyomi.game.objects.Skill                |");
            System.out.println("\t\t\t|       2 - Search ao.tsukuyomi.game.objects.Skill                |");
            System.out.println("\t\t\t|       3 - Show Full Tree              |");
            System.out.println("\t\t\t|       4 - List Skills                 |");
            System.out.println("\t\t\t|       5 - Show Levels                 |");
            System.out.println("\t\t\t|       6 - Remove ao.tsukuyomi.game.objects.Skill                |");
            System.out.println("\t\t\t|       7 - Remove All Skills           |");
            System.out.println("\t\t\t|       8 - Go Back                     |");
            System.out.println("\t\t\t=========================================\n\n");
            System.out.print("Choose Option: ");
            option = Integer.parseInt(scan.nextLine());

            switch (option) {
                case 1:
                    System.out.print("Enter skill name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter skill description: ");
                    String description = scan.nextLine();
                    System.out.print("Enter skill level: ");
                    int level = scan.nextInt();
                    scan.nextLine();
                    Skill skill = new Skill(name, description, level);
                    binaryTree.createSkill(skill);
                    System.out.println("\nao.tsukuyomi.game.objects.Skill created successfully.");
                    break;
                case 2:
                    System.out.print("Enter the skill level to remove: ");
                    int skillLevel = scan.nextInt();
                    scan.nextLine();
                    binaryTree.removerNode(skillLevel);
                    System.out.println("\nao.tsukuyomi.game.objects.Skill removed successfully.");
                    break;
                case 3:
                    binaryTree.showSkill();
                    break;
                case 4:
                    binaryTree.showFullTree();
                    break;
                case 5:
                    binaryTree.showLevels();
                    break;
                case 6:
                    System.out.print("Enter the skill name to search: ");
                    String skillName = scan.nextLine();
                    binaryTree.searchSkill(skillName);
                    break;
                case 7:
                    binaryTree.removeAllSkill();
                    System.out.println("\nAll skills removed.");
                    break;
                case 8:
                    return;
                default:
                    System.out.print("Invalid option\n");
                    break;
            }
        } while (option != 8);
    }

    public void showGraphsMenu(Scanner scanner) {
        int option;
        do {
            System.out.println("\t\t\t=========== Graphs Menu ===========");
            System.out.println("\t\t\t|        1 - Add Friends        |");
            System.out.println("\t\t\t|        2 - See Friends Of     |");
            System.out.println("\t\t\t|        3 - Remove Friend      |");
            System.out.println("\t\t\t|        4 - Go Back            |");
            System.out.println("\t\t\t================================\n");
            System.out.print("Choose Option: ");
            option = Integer.parseInt(scan.nextLine());

            switch (option){
                case 1:
                       break;
                case 2:
                       break;
                case 3:
                       break;
                case 4:
                       return;
                default:
                       System.out.print("Invalid Option");
                       break;
            }
        }while();
    }


}