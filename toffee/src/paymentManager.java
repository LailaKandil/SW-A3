import java.util.ArrayList;
import java.util.Iterator;

public class paymentManager {

  private OrderStatus status = OrderStatus.OPEN;
  private float orderTotal;
  private String deliveryAddress;

  private Payment payment;
  private ArrayList<Order> orderDetails = new ArrayList<Order>();
  
  private float taxPercentage;
  
  private int orderID;

  public paymentManager(float taxPercentage, String deliveryAddress) {
    this.taxPercentage = taxPercentage;
    this.deliveryAddress = deliveryAddress;

  }

  public int getOrderID () {
    return orderID;
  }

  public OrderStatus getStatus () {
    return status;
  }

  public float calculateOrderTotal() {
    orderTotal = 0;
    Iterator<Order> i = orderDetails.iterator();
    while (i.hasNext()) 
      orderTotal += (i.next()).getTotal(taxPercentage);
    return orderTotal;
  }

  public boolean payOrder (Payment payment) {   
    if (status == OrderStatus.CLOSED) {
     System.out.println("Order is already paid for: Order Payment");
      return true;
    }
    else {
      boolean paidOrder = payment.settlePayment ();
      if (paidOrder == true) 
         status = OrderStatus.CLOSED;
      return paidOrder;
    }
  }

}
