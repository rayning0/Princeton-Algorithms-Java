public class Bank {
  int amount = 0;
  int balance = 0;
  
  public Bank(int balance) {
    this.balance = balance;
  }
  
  public int increase(int newval) {
    return newval;
  }
  
  public static void bark() {
    System.out.println("woof!");
  }
  
  public String toString() {
    return "CRAZY " + balance;
  }
  public static void main(String args[]) {
    Bank b = new Bank(200);
    b.balance = b.increase(1000);
    System.out.println(b.balance);
  }
}