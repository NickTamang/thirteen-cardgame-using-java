import java.util.Scanner;
public class game {
    decks game= new decks();//NEW OBJECT OF CARD IS CREATED
    Scanner input =new Scanner(System.in);
    private int loc1,loc2;
    public void subChoice(){
        System.out.println(" \n  ________________________________________");
        System.out.println("\n |        \uD83C\uDCA1 THIRTEEN:Card Game \uD83C\uDCA1          | ");
        System.out.println(" _________________________________________");
        System.out.println("\n TIPS: 'Choose your Cards according to the Card Position respectively!'");
        System.out.println("1.☝Select one card of 13 :");
        System.out.println("2.✌Select two card of 13 :");
        System.out.println("3.\uD83D\uDC40Select this option for hint:");
        System.out.println("Enter your choice 1, 2 or 3 \uD83D\uDC49: ");
    }

    public void  play_gameThirteen()
    {
        game.playerName(); //METHOD FOR THE PLAYER NAME
        game.shuffle();    //METHOD FOR SUFFELING THE CARD
        game.initialSetup();
        while (true)
        {
            game.display10(); //display 10 cards on hand
            if (game.gameOver())  //METHOD FOR GAMEOVER
            {
                System.out.println("\n GAMEOVER...YOU LOOSE!!!");
                show_replay();
                  break;
            }

            subChoice();
            int ch = input.nextInt();
            if (ch == 1)
            {
                System.out.println("ENTER THE POSITION OF THE CARD TO ELIMINATE:");
                while(true)
                {
                    try{
                        loc1=input.nextInt();
                        if (loc1<11)
                        {break;}
                        else
                        {System.out.println("WRONG INPUT...Please! enter the position again: ");}
                        continue;
                    }
                    catch(Exception ex)
                    {
                        System.out.println("WRONG INPUT...Please! enter the position again: ");
                        input.next();
                    }
                }

                if (game.checkTotalOneCard(loc1))
                {   System.out.println("\nWOW...! YOU'RE MAKING NICE MOVES");
                    game.addReplayOneCard(loc1);
                    if (!game.replace1(loc1))
                    {
                        System.out.println("\n YOU WON!!!... WINNER WINNER CHICKEN DINNER...");
                        show_replay();
                        break;
                    }
                    else
                        System.out.println("\nYOUR NEW CARDS ARE REPLACED");
                }
                else
                {
                    System.out.println("TRY AGAIN...!!! YOUR CARD MOVE WAS WRONG ");
                }
            }



            if (ch == 2) {
                while(true)
                {
                    try {
                        System.out.println("SELECT THE POSITION OF FIRST CARD: ");
                        loc1=input.nextInt();
                        System.out.println("SELECT THE POSITION OF SECOND CARD: ");
                        loc2=input.nextInt();
                        if ((loc1<11) && (loc2<11))
                        {break;}
                        else
                        {System.out.println("TRY AGAIN...");}
                        continue;
                    }
                    catch(Exception ex)
                    {
                        System.out.println("WRONG INPUT...Please! enter the position again:");
                        input.next();
                    }
                }

                if (game.checkTotalTwoCard(loc1, loc2))
                {
                    game.AddReplayTwoCard(loc1, loc2);
                    System.out.println("\nEXCELLENT...! YOU'RE MAKING NICE MOVES");
                    if (!game.replace2(loc1, loc2))
                    {
                        System.out.println("\nYOU WON!!!... WINNER WINNER CHICKEN DINNER...");
                        show_replay();
                        break;
                    }
                    else
                        System.out.println("\nYOUR NEW CARDS ARE REPLACED");
                }
                else
                {

                    System.out.println("\nWRONG INPUT...Please! enter the position again WHICH MAKES 13 ");
                }
            }
            if (ch==3)
            {
                game.userHint();
            }
        }//end of while
    }//end of play_gameThirteen

    private void pressEnterToContinue()
    {
        System.out.println("\nPRESS ENTER TO continue...");
        try
        {
            System.in.read();
            input.nextLine();
        }
        catch(Exception e)
        {}
    }
    public void show_replay ()
    {
        System.out.println("\nYOUR MOVE FOR THE WHOLE GAME ARE LOADING...");
        for (int i=0; i<game.lastReplayLocation;i++)
        {
            System.out.print("\nYour move number "+(i+1)+" is: ");
            System.out.println(game.replay[i]);
            pressEnterToContinue();
        }
        System.out.println("\nOPPS! OUT OF MOVE....");


    }// END
    public void play_demo() {
        System.out.println("\nPLEASE WAIT...!!!");
        System.out.println("\nTUTORIAL: CHOOSE THE CARDS THAT SUMS 13... ");
        System.out.println("\n'OR' WATCH THE DEMO TO LEARN HOW THIS GAME IS PLAYED...!!!");
        System.out.println("\nDEMO VERSION IS LOADING...");
        game.shuffle();
        game.initialSetup();  //INITIAL SETUP OF CARDS
        boolean win = false;
        while (true) {
            game.display10();    //THIS WILL DISPLAY THE INITIAL 10 CARDS
            if (game.gameOver()) {
                System.out.println("\nGAMEOVER...THE COMPUTER LOOSE!!! BUT YOU LOOK SMART...!!!START THE GAME???");
                break;
            }

            pressEnterToContinue();
            boolean move = false;
            for (int i = 1; i <= 10; i++) {
                if (game.checkTotalOneCard(i)) {
                    System.out.println("\nCOMPUTER FOUND A KING CARD OF VALUE 13 AT POSITION " + (loc1 + i));
                    move = true;
                    if (!game.replace1(i)) {
                        System.out.println("\nCOMPUTER WON THE GAME...!!!");
                        win = true;
                        break;
                    } else {
                        System.out.println("\nNEW CARD IS REPLACED");
                        break;
                    }
                }

            }

            if (move == false) {
                boolean found2 = false;
                for (int i = 1; i <= 10; i++) {
                    for (int j = i + 1; j <= 10; j++) {
                        if (game.checkTotalTwoCard(i, j)) {
                            found2 = true;
                            System.out.println("\nCOMPUTER FOUND TWO CARDS THAT SUMS 13 AT LOCATION:" + (loc1 + i) + " and " + (loc2 + j));
                            if (!game.replace2(i, j)) {
                                System.out.println("\nCOMPUTER WON...NOW ITS YOUR TURN");
                                win = true;
                                break;
                            } else {
                                System.out.println("\nNEW CARDS ARE REPLACED");
                                break;
                            }
                        }

                    }
                    if (found2 == true)
                        break;

                }

            }
            if (win == true)
                break;

        }//END OF WHILE LOOP

    }// END OF DEMO MODE

}//END OF CLASS

