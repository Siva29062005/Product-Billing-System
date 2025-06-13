import java.util.*;

public class RetailStore {
        private String storeName, gstNumber;
        private List<Product> productCatalog = new ArrayList<>();

        public RetailStore(String storeName, String gstNumber) {
            this.storeName = storeName;
            this.gstNumber = gstNumber;
        }

        public void addProductToCatalog(Product product) {
            productCatalog.add(product);
        }

        public void showProducts(){
            System.out.println("\nProducts Available Here\n");
           for(Product p:productCatalog){
            System.out.println(p.getName()+"-"+p.getPrice());
           }
           System.out.println();
        }

        public Product findProduct(String name) {
            for (Product p : productCatalog) {
                if (p.getName().equalsIgnoreCase(name)) return p;
            }
            return null;
        }

        public String getStoreName() { return storeName; }
        public String getGstNumber() { return gstNumber; }

        public void checkout(Customer customer, Cart cart) {
            BillingSystem.generateBill(this, customer, cart);
        }
    }