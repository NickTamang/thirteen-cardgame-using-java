import java.util.Scanner;

public class Main {
    static void menu() {
        System.out.println("  ________________________________________");
        System.out.println(" |     \uD83C\uDCA1 Welcome to Sharad's Game \uD83C\uDCA1       |");
        System.out.println(" |       ☺ THIRTEEN:Card Game ☺         | ");
        System.out.println(" |________________________________________|");
        System.out.println("1.\uD83D\uDE0D Start The Game ");
        System.out.println("2.\uD83D\uDD79 Play Demo ");
        System.out.println("3.\uD83D\uDE25 Exit ");
        System.out.print("Please enter your choice (1-4)\uD83D\uDC49: ");

    }


    public static void main(String[]args) {
        try {
            Scanner input = new Scanner(System.in);
            game thirteen = new game();
            int choice;
            while (true) {
                menu();
                choice = input.nextInt();
                if (choice == 1) {


                    thirteen.play_gameThirteen();
                }
                if (choice == 2) {
                    thirteen.play_demo();
                }

                if (choice == 3) {
                    System.out.print("\n Thank you for playing 'THIRTEEN:Card Game' ");

                    break;
                }




            }


        } catch (Exception e) {
            System.out.println("Something went wrong.Please Restart your Game again.");

        }
    }
}