import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for item.
 */
class Item {
    /**
     * name.
     */
    private String pname;
    /**
     * quantity.
     */
    private int quantity;
    /**
     * price.
     */
    private double price;
    /**
     * if catalog.
     *
     */
    private boolean catalog = false;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     * @param      q     The quarter
     * @param      p     { parameter_description }
     */
    Item(final String n, final int q, final double p) {
        this.pname = n;
        this.quantity = q;
        this.price = p;
        this.catalog = true;
    }
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     * @param      q     The quarter
     */
    Item(final String n, final int q) {
        this.pname = n;
        this.quantity = q;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String getpname() {
        return pname;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int getquantity() {
        return quantity;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    double getprice() {
        return price;
    }
    /**
     * { function_description }.
     *
     * @param      quant  The quant
     */
    void setquantity(final int quant) {
        this.quantity = quant;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (catalog) {
            return pname + " " + quantity + " " + price;
        }
        return pname + " " + quantity;
    }
}
/**
 * Class for shoppingcart.
 */
class Shoppingcart {
    /**
     * catalog.
     */
    private ArrayList<Item> catalog;
    /**
     * cart.
     */
    private ArrayList<Item> cart;
    /**
     * tax.
     */
    private double discount, tax;
    /**
     * coupons.
     */
    private String[] coupons = {"IND10", "IND20", "IND30", "IND50"};
    /**
     * flag.
     */
    private boolean flag = true;
    /**
     * total.
     */
    private double tot, pay;
    /**
     * Constructs the object.
     */
    Shoppingcart() {
        catalog = new ArrayList<>();
        cart = new ArrayList<>();
        discount = 0;
        tax = 0;
        tot = 0;
        pay = 0;
    }
    /**
     * Adds to catalog.
     *
     * @param      item  The item
     */
    void addToCatalog(final Item item) {
        catalog.add(item);
    }
    /**
     * Adds to cartesian.
     *
     * @param      item  The item
     */
    void addToCart(final Item item) {
        for (Item each : catalog) {
            if (each.getpname().equals(item.getpname())) {
                for (Item f : cart) {
                    if (f.getpname().equals(item.getpname())) {
                        f.setquantity(f.getquantity() + item.getquantity());
                        return;
                    }
                }
                cart.add(item);
                return;
            }
        }
    }
    /**
     * Removes a from cartesian.
     *
     * @param      item  The item
     */
    void removeFromCart(final Item item) {
        for (Item e : cart) {
            if (e.getpname().equals(item.getpname())) {
                if (e.getquantity() == item.getquantity()) {
                    cart.remove(e);
                    return;
                } else {
                    e.setquantity(e.getquantity() - item.getquantity());
                    return;
                }
            }
        }

    }
    /**
     * Shows the cartesian.
     */
    void showCart() {
        for (Item e : cart) {
            System.out.println(e);
        }
    }
    /**
     * Shows the catalog.
     */
    void showCatalog() {
        for (Item each : catalog) {
            System.out.println(each);
        }
    }
    /**
     * { function_description }.
     *
     * @param      name  The name
     *
     * @return     { description_of_the_return_value }
     */
    double getprice(final String name) {
        for (Item e : catalog) {
            if (e.getpname().equals(name)) {
                return e.getprice();
            }
        }
        return 0;
    }
    /**
     * Gets the total amount.
     *
     * @return     The total amount.
     */
    double getTotalAmount() {
        tot = 0;
        for (Item e : cart) {
            tot += e.getquantity() * this.getprice(e.getpname());
        }
        return (tot);
    }
    /**
     * Gets the payable amount.
     *
     * @return     The payable amount.
     */
    double getPayableAmount() {
        double amount = getTotalAmount();
        final int h = 100;
        final int f = 15;
        double total = (amount - ((amount * discount) / h));
        tax = (total  * f) / h;
        pay = total + tax;
        return (pay);
    }
    /**
     * { function_description }.
     *
     * @param      coupon  The coupon
     */
    void applyCoupon(final String coupon) {
        final int three = 3;
        if (flag) {
            for (String i : coupons) {
                if (i.equals(coupon)) {
                    discount = Double.parseDouble(coupon.substring(three));
                    flag = false;
                    return;
                }
            }
            System.out.println("Invalid coupon");
        }
    }
    /**
     * { function_description }.
     */
    void printInvoice() {
        final int h = 100;
        System.out.println("Name   " + "quantity   " + "Price");
        for (Item each : cart) {
            System.out.println(each + " " + Double.
                toString(this.getprice(each.getpname())));
        }
        System.out.println("Total:" + Double.toString(tot));
        System.out.println("Disc%:" + Double.toString((tot * discount) / h));
        System.out.println("Tax:" + Double.toString(tax));
        System.out.println("Payable amount: " + Double.toString(pay));

    }

}
/**
 * class.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //function.
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Shoppingcart s = new Shoppingcart();
        int n = sc.nextInt();
        for (int i = 0; i < n + 1; i++) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "Item":
                String[] item = tokens[1].split(",");
                s.addToCatalog(new Item(item[0], Integer.
                    parseInt(item[1]), Double.parseDouble(item[2])));
                break;
            case "catalog":
                s.showCatalog();
                break;
            case "add":
                item = tokens[1].split(",");
                s.addToCart(new Item(item[0], Integer.parseInt(item[1])));
                break;
            case "show":
                s.showCart();
                break;
            case "totalAmount":
                System.out.println("totalAmount: " + s.getTotalAmount());
                break;
            case "payableAmount":
                System.out.println("Payable amount: " + s.getPayableAmount());
                break;
            case "remove":
                item = tokens[1].split(",");
                s.removeFromCart(new Item(item[0], Integer.parseInt(item[1])));
                break;
            case "coupon":
                s.applyCoupon(tokens[1]);
                break;
            case "print":
                s.printInvoice();
                break;
            default:
                break;
            }
        }
    }
}
