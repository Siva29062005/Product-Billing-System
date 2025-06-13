import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BillingSystem {
    private static final double TAX_RATE = 0.15;
    private static final double DISCOUNT_RATE = 0.05;
    private static final double DISCOUNT_THRESHOLD = 500.0;

    public static void generateBill(RetailStore store, Customer customer, Cart cart) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String border = "===============================================";
        System.out.println(border);
        System.out.printf("                 %s\n", store.getStoreName());
        System.out.printf("         GSTIN: %s, India\n", store.getGstNumber());
        System.out.println("            Date: " + dtf.format(now));
        System.out.println(border);
        System.out.printf("Customer: %-25s\n", customer.getName());
        System.out.printf("Phone   : %-25s\n", customer.getPhone());
        System.out.printf("Email   : %-25s\n", customer.getEmail());
        System.out.println(border);
        System.out.printf("%-20s %5s %10s\n", "Item", "Qty", "Total");
        System.out.println("-----------------------------------------------");

        for (CartItem item : cart.getItems()) {
            System.out.printf("%-20s %5d %10.2f\n",
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getTotalPrice());
        }

        System.out.println("-----------------------------------------------");

        double subtotal = cart.getTotalAmount();
        double discount = (subtotal > DISCOUNT_THRESHOLD) ? subtotal * DISCOUNT_RATE : 0;
        double discountedTotal = subtotal - discount;
        double tax = discountedTotal * TAX_RATE;
        double finalTotal = discountedTotal + tax;

        System.out.printf("%-26s : ₹ %.2f\n", "Subtotal", subtotal);
        if (discount > 0)
            System.out.printf("%-26s :  ₹ %.2f\n", "Discount (5%)", discount);
        System.out.printf("%-26s : ₹ %.2f\n", "Tax (15%)", tax);
        System.out.printf("%-26s : ₹ %.2f\n", "Total Payable", finalTotal);
        System.out.println(border);
        System.out.println("        Thank you for shopping with us!");
        System.out.println(border);
    }
}
