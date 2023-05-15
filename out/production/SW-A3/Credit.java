import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;


public class Credit extends Payment {
  private String cardNumber;
  private String cardType;
  private LocalDateTime expiryDate;
  
  private CardStatus cardStatus;
  
  private int randomNumber;

  public Credit (String cardNumber, String cardType, LocalDateTime expiryDate, float amount) {
    super (amount);
    this.cardNumber = cardNumber;
    this.cardType   = cardType;
    this.expiryDate = expiryDate;
    Random rand = new Random();
    randomNumber = rand.nextInt(100);
  }

  public boolean deductAmount() {
    if (randomNumber <= 10)
      cardStatus = CardStatus.INVALID;
    else if (randomNumber <= 20)
      cardStatus = CardStatus.INSUFFICIENT_FUND;
    else if (randomNumber <= 30)
      cardStatus = CardStatus.EXPIRED;
    else {
      System.out.println ("Connecting with the bank .....");
      System.out.println (getAmount() + " where successfully deducted from your card.");
      cardStatus = CardStatus.VALID_SUFFICIENT;
    }  
    return cardStatus == CardStatus.VALID_SUFFICIENT;
  }

  public void displayMessage () {
    String message;
    if (randomNumber <= 30)
      System.out.println("I could not process your card payment - " + cardStatus+
        "\nUnsuccessful Card Payment");
    else
        System.out.println("You paid: " + getAmount() + " by Credit Card"+
        "\nSuccessful Card Payment");
  }
}