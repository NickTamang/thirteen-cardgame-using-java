import java.util.Scanner;
public class decks {
    private card [] cardsDeck= new card[52];  //this will store all 52 cards details
    private int endLocation; //this will help to know the last location to pick the cards for refill
    private char [] suite= {'♥', '♦', '♣', '♠'};  //these are suite data
    private String [] card_name= {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; //cardname data
    private int [] card_value= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}; //card value data
    private int loc1, loc2;
    public card [] cardsOnHand=new card[10]; //this will store 10 cards
    public String replay[]= new String [25]; //this will store the card eliminated
    public int lastReplayLocation;
    public decks() {
        for (int i = 0; i < 13; i++) { //assigning object class with values according to suites and ranks equally
            cardsDeck[i] = new card();
            cardsDeck[i].setSuiteName(suite[0]);
            cardsDeck[i].setCardRank(card_name[i]);
            cardsDeck[i].setCardValue(card_value[i]);
            //----------------------------------------------
            cardsDeck[i + 13] = new card();
            cardsDeck[i + 13].setSuiteName(suite[1]);
            cardsDeck[i + 13].setCardRank(card_name[i]);
            cardsDeck[i + 13].setCardValue(card_value[i]);
            //----------------------------------------------
            cardsDeck[i + 26] = new card();
            cardsDeck[i + 26].setSuiteName(suite[2]);
            cardsDeck[i + 26].setCardRank(card_name[i]);
            cardsDeck[i + 26].setCardValue(card_value[i]);
            //----------------------------------------------
            cardsDeck[i + 39] = new card();
            cardsDeck[i + 39].setSuiteName(suite[3]);
            cardsDeck[i + 39].setCardRank(card_name[i]);
            cardsDeck[i + 39].setCardValue(card_value[i]);
        }
        endLocation = 10;
        lastReplayLocation = 0;
    }
    public void playerName(){ //method to ask player name
        Scanner playerName = new Scanner(System.in);
        System.out.println("Enter your name to play:");

        String userName = playerName.nextLine();

        System.out.println("HEllO! Mr."+ userName);
    }

    public void shuffle() { //METHOD TO SUFFLE THE 52 CARDS USING MATH.RANDOM
        for (int i = 0; i < cardsDeck.length; i++) {
            int index = (int) (Math.random() * cardsDeck.length);
            card temp = cardsDeck[i]; //STORE CARDS DECK TEMPORARILY
            cardsDeck[i] = cardsDeck[index];
            cardsDeck[index] = temp;
        }
    }
    public void userHint() { //METHOD FOR HINT TO USER
        System.out.println("\nPossible hints are.....");

        for(int i=0; i<10; i++) //FOR LOOP STARTING FROM 0-9
        {
            if (cardsOnHand[i].getCardValue()==13) //IF SINGLE CARDVALE STORED==13
            //PRINT THE SINGLE CARD WITH LOCATION
            {System.out.println("you could select a King which is at a position "+(i+1));}
            //LOOP STARTS WITH 0, FOR CORRECTION POSITION +1 NEEDS TO BE DONE
        }

        for(int i=0; i<10; i++) //FOR LOOP FOR SCANNING FIRST CARD >13
        {
            //FOR LOOP TO SCAN SECOND CARD >13
            for(int j=i+1; j<10; j++)
                //IF CARDVALUE1+CARDVALUE2==13 //PRINTS THE BOTH CARD LOCATION AS HINT
                if ((cardsOnHand[i].getCardValue()+cardsOnHand[j].getCardValue())==13)
                    System.out.println("you could select 2 card of position "+(i+1)+" and "+(j+1));
            //LOOP STARTS WITH 0, FOR CORRECTION POSITION +1 HAS TO BE DONE
        }
    }
    public void initialSetup() { //METHOD FOR INITIAL CARD SETUP
        for (int i = 0; i < 10; i++) {
            cardsOnHand[i] = cardsDeck[i];
        }
    }
    public void display10() { //METHOD TO DISPLAY 10 CARDS
        System.out.println(" These are  position of your cards: ");
        for (int i = 0; i < 5; i++)
        {

            System.out.print("░ ");
            System.out.print(i +1); //+1 TO AVOID POSITION STATING FROM 0-9
            System.out.print(" ░     ");

        //TWO FOR LOOPS ARE USED FOR 0-5 && 5-10 FOR VISUALLY PLEASING MANNER

        }
        System.out.println();
        for (int i = 5; i < 10; i++)
        {
            System.out.print("░ ");
            System.out.print(i +1);
            System.out.print(" ░     ");
        }

        System.out.println("\n You can choose sets of card from here: ");

        for (int i = 0; i < 5; i++) {
            System.out.print("░");
            System.out.print(cardsOnHand[i].getSuiteName() + "" + cardsOnHand[i].getCardRank());
            System.out.print("░    ");
        }
        System.out.println();
        for (int i = 5; i < 10; i++) {
            System.out.print("░");
            System.out.print(cardsOnHand[i].getSuiteName() + "" + cardsOnHand[i].getCardRank());
            System.out.print("░    ");
        }
    }

    public boolean replace1(int loc1) {
        if (endLocation < 51) {
            cardsOnHand[loc1 - 1] = cardsDeck[endLocation];
            endLocation++;
            return true;
        } else
            return false;

    }

    public boolean replace2(int loc1, int loc2) {
        if (endLocation < 50) {
            cardsOnHand[loc1 - 1] = cardsDeck[endLocation];
            endLocation++;
            cardsOnHand[loc2 - 1] = cardsDeck[endLocation];
            endLocation++;
            return true;
        } else
            return false;
    }

    public boolean checkTotalOneCard(int loc1) {
        if (cardsOnHand[loc1-1].getCardValue() == 13)
            return true;
        else
            return false;
    }

    public boolean checkTotalTwoCard(int loc1, int loc2) {
        if (cardsOnHand[loc1-1].getCardValue() + cardsOnHand[loc2-1].getCardValue() == 13)
            return true;
        else
            return false;
    }

    public void addReplayOneCard(int loc1) {
        replay[lastReplayLocation] = cardsOnHand[loc1-1].getSuiteName() + ":" + cardsOnHand[loc1-1].getCardRank();
        lastReplayLocation++;

    }

    public void AddReplayTwoCard(int loc1, int loc2) {
        replay[lastReplayLocation] = cardsOnHand[loc1-1].getSuiteName() + ":" + cardsOnHand[loc1-1].getCardRank() + "and" + cardsOnHand[loc2-1].getSuiteName() + ":" + cardsOnHand[loc2-1].getCardRank();
        lastReplayLocation++;
    }

    public boolean gameOver() {
        boolean result = true;
        for (int i = 0; i < 10; i++) {
            if (cardsOnHand[i].getCardValue() == 13)
                result =false;
        }
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++)
                if ((cardsOnHand[i].getCardValue() + cardsOnHand[j].getCardValue()) == 13)
                    result = false;
        }
        return result;
    }
}