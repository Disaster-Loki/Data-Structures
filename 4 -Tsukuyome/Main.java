import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        System.out.println("\t\t\t Welcome to Tsukuyome Game!");

        while (true) {
            if (!menu.isLoggedIn()) {
                System.out.print("\nUsername: ");
                String username = scanner.nextLine();
                System.out.print("\nPassword: ");
                String password = scanner.nextLine();

                if (menu.login(username, password)) {
                    System.out.println("Login successful!\n");
                } else {
                    System.out.println("Invalid Username or Password!!");
                    continue;
                }
            }

            menu.showMenuMain();

            if (!menu.isLoggedIn()) {
                System.out.println("Session Terminated. See you later!!!\n");
                break;
            }
        }
    }
}