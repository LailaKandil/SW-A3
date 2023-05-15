public abstract class Payment {
  private float amount;

  public Payment (float amount) {
    this.amount = amount;
  }

  public float getAmount () {
    return amount;
  }

  public boolean settlePayment (){
    boolean successfulPayment = deductAmount();
    displayMessage ();
    return successfulPayment;
  }

  public abstract boolean deductAmount ();
  public abstract void displayMessage ();
}