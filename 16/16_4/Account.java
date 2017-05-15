public class Account extends Thread {
 private String name;
 
 public Account(String name) {
  super(name);
  this.name = name;
 }
 
 @Override
 public void run() {
  for(int i = 0; i < 50; i++ ){
   System.out.println(getName() + " " + i);
  }
 }
  
 public static void main(String[] args)
 {
  new Account("高级").start();
  new Account("低级").start();
 }

}

