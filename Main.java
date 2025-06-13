import java.util.*;

public class Main {
      public static void main(String[] args) {
         
        Scanner sc=new Scanner(System.in);
        RetailStore store = new RetailStore("ABC Retail Store", "27ABCDE1234F1Z5");
        store.addProductToCatalog(new Product("P101", "Pen", 10.0));
        store.addProductToCatalog(new Product("P102", "Notebook", 50.0));
        store.addProductToCatalog(new Product("P103", "Pencil", 5.0));
        store.addProductToCatalog(new Product("P104", "USB Drive", 600.0));
        Cart cart=new Cart();

        while(true){
          System.out.println("1.Show Products \n2.Buy Products \n3.Checkout \n4.Exit \n");
          int option=sc.nextInt();
          switch (option) {
            case 1:
              store.showProducts();
              break;
            case 2:
              System.out.println("Enter the Product Name:");
              String product=sc.next();
              Product products=store.findProduct(product);
              if(products!=null){
                System.out.println("How many "+ product+" you want?:");
                int quantity=sc.nextInt();
                cart.addProduct(products, quantity);
                System.out.println(product+" is added to the cart!\n");
              }
              else{
                System.out.println("Sorry the "+product+" is not Available!");
              }
              break;
            case 3:
               System.out.println("Enter Your Name:");
               String name=sc.next();
               System.out.println("Enter your Phone Number:");
               String phoneno=sc.next();
               System.out.println("Enter your email address:");
               String emailid=sc.next();
               Customer customer=new Customer(name, phoneno, emailid);
               store.checkout(customer, cart);
            case 4:
               System.out.println("Thanks for coming!");
               sc.close();
               System.exit(0);
            default:
              break;
          }
        }
         
}
}