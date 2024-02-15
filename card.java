public class card{
    //ATTRIBUTES
    private char suiteName;  //it stores the card suite name
    private String cardRank;  //it stores the card rank
    private int cardValue; // it will store then card value
    public card() {} //CONSTRUCTOR

    public card(char suiteName, String cardRank, int cardValue) {
       this.suiteName= suiteName; //parameters=attributes
       this.cardRank= cardRank;
       this.cardValue= cardValue; }
    public char getSuiteName() {
        return suiteName;
    } //GETTERS
    public void setSuiteName(char suiteName) {
        this.suiteName = suiteName;
    }  //SETTERS
    public String getCardRank() {
        return cardRank;
    }
    public void setCardRank(String cardRank) {
        this.cardRank = cardRank;
    }

    public int getCardValue() {
        return cardValue;
    }
    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }
}



