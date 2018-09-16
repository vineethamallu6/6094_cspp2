import java.util.Scanner;
/**
 * Class for item.
 */
class Item {
    /**
     * itemName.
     */
    private String itemName;
    /**
     * itemQuantity.
     */
    private int itemQuantity;
    /**
     * itemPrice.
     */
    private float itemPrice;
    /**
     * Constructs the object.
     *
     * @param      i     { parameter_description }
     * @param      q     The quarter
     * @param      p     { parameter_description }
     */

    Item(final String i, final int q, final float p) {
        this.itemName = i;
        this.itemQuantity = q;
        this.itemPrice = p;
    }
    /**
     * Gets the item name.
     *
     * @return     The item name.
     */
    public String getItemName() {
        return this.itemName;
    }
    /**
     * Gets the item quantity.
     *
     * @return     The item quantity.
     */
    public int getItemQuantity() {
        return this.itemQuantity;
    }
    /**
     * Gets the item price.
     *
     * @return     The item price.
     */
    public float getItemPrice() {

        return this.itemPrice;
    }
    /**
     * Sets the quantity.
     *
     * @param      set   The set
     */
    public void  setQuantity(final int set) {
        this.itemQuantity = set;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.getItemName() + " " +
        this.getItemQuantity() + " " + this.getItemPrice();
    }
    /**
     * return true or false if both names are equal.
     *
     * @param      item  The item.
     *
     * @return     boolean.
     */
    @Override
    public boolean equals(final Object item) {
        Item myItem = (Item)item;
        return this.getItemName().equals(myItem.getItemName());
    }

}
/**
 * Class for shopping cartesian.
 */
class ShoppingCart {
    /**
     * catalogDetails.
     */
    private List<Item> catalogDetails;
    /**
     * cartDetails.
     */
    private List<Item> cartDetails;
    /**
     * couponCode.
     */
    private float couponCode;
    /**
     * isCouponApplied.
     */
    private boolean isCouponApplied;
    /**
     * disc.
     */
    private double disc;
    /**
     * Constructs the object.
     */
    ShoppingCart() {
        catalogDetails = new List<Item>();
        cartDetails = new List<Item>();
        isCouponApplied = false;
    }
    /**
     * Adds to catalog.
     *
     * @param      obj   The object
     */
    public void addToCatalog(Item obj) {
        catalogDetails.add(obj);
    }
    /**
     * Adds to cartesian.
     *
     * @param      itemObj  The item object
     */
    public void addToCart(Item itemObj) {
        for (int i = 0; i < catalogDetails.size(); i++) {
            if (itemObj.getItemName().equals(catalogDetails.get(i).getItemName())) {
                if(itemObj.getItemQuantity() <= (catalogDetails.get(i).getItemQuantity())) {
                    cartDetails.add(itemObj);
                    catalogDetails.get(i).setQuantity(itemObj.getItemQuantity());
                    return;
                }
            }
        }
    }
    /**
     * Removes a from cartesian.
     *
     * @param      obj   The object
     */
    public void removeFromCart(Item obj) {
        for (int i = 0; i < cartDetails.size(); i++) {
            if (obj.getItemName().equals(catalogDetails.get(i).getItemName())) {
                if (cartDetails.get(i).getItemQuantity() == obj.getItemQuantity()) {
                cartDetails.remove(i);
            } else {
                cartDetails.get(i).setQuantity(obj.getItemQuantity());
            }
        }
    }
}
    /**
     * Shows the catalog.
     */
    public void showCatalog() {
        for (int i = 0; i < catalogDetails.size(); i++) {
            System.out.println(catalogDetails.get(i).toString());
        }
    }
    /**
     * Shows the cartesian.
     */
    public void showCart() {
        for (int i = 0; i < cartDetails.size(); i++) {
            System.out.println(cartDetails.get(i).getItemName() + " " + cartDetails.get(i).getItemQuantity());
        }
    }
    /**
     * Gets the total amount.
     *
     * @return     The total amount.
     */
    public float getTotalAmount() {
        float totalAmount = 0.0f;
        for (int i = 0; i < cartDetails.size(); i++) {
            Item item = cartDetails.get(i);
            totalAmount = totalAmount + item.getItemQuantity() * item.getItemPrice();
        }
        return totalAmount;
    }
    /**
     * Gets the payable amount.
     *
     * @return     The payable amount.
     */
    public float getPayableAmount() {
        float totalAmount = getTotalAmount();
        float disc = totalAmount * couponCode;
        totalAmount = totalAmount - disc;
        float payableAmount = totalAmount + (totalAmount * 0.15f);
        return payableAmount;
    }
    /**
     * Gets the tax.
     *
     * @return     The tax.
     */

    /**
     * { function_description }
     *
     * @param      code  The code
     */

    public void applyCoupon(final String coupon) {
        if (isCouponApplied) {
            if (coupon.equals("IND10")) {
            couponCode = 0.1f;
            } else if (coupon.equals("IND20")) {
                couponCode = 0.2f;
            } else if (coupon.equals("IND30")) {
                couponCode = 0.3f;
            } else if (coupon.equals("IND50")) {
                couponCode = 0.5f;
            } else {
                System.out.println("Invalid coupon");
                return;
            }
            isCouponApplied = true;
        }
    }
    /**
     * Gets the discount.
     *
     * @return     The discount.
     */

    /**
     * { function_description }
     */
    public void printInvoice() {
        System.out.println("Name   quantity   Price");
        for (int i = 0; i < cartDetails.size(); i++) {
            System.out.println(cartDetails.get(i));
        }
        System.out.println("Total:" + getTotalAmount());
        if (!isCouponApplied) {
            float totalAmount = getTotalAmount();
            float disc = totalAmount * couponCode;
            System.out.println("Disc%:" + disc);
            totalAmount = totalAmount - disc;
            float tax = (totalAmount * 15) / 100;
            System.out.println("Tax:" + tax);
            totalAmount = totalAmount + tax;
            System.out.println("Payable amount: " + totalAmount);
        } else {
            float totalAmount = getTotalAmount();
            System.out.println("Disc%:" + 0.0);
            float tax = (totalAmount * 15) / 100;
            System.out.println("Tax:" + tax);
            totalAmount = totalAmount + tax;
            System.out.println("Payable amount: " + totalAmount);
        }
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    Solution() {

    }
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        ShoppingCart sc = new ShoppingCart();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "Item":
                String[] c1 = tokens[1].split(",");
                sc.addToCatalog(new Item(c1[0],
                    Integer.parseInt(c1[1]), Float.parseFloat(c1[2])));
                //sc.addToCatalog(it);
                break;

                case "catalog":
                    sc.showCatalog();
                break;

                case "add":
                    String[] c2 = tokens[1].split(",");
                    sc.addToCart(new Item(c2[0],
                        Integer.parseInt(c2[1]), 0.0f));
                    //sc.addToCart(it);
                break;

                case "remove":
                    String[] c3 = tokens[1].split(",");
                    sc.removeFromCart(new Item(c3[0],
                        Integer.parseInt(c3[1]), 0.0f));
                    //sc.remove(it);
                break;
                case "show":
                    sc.showCart();
                break;
                case "totalAmount":
                    System.out.println("totalAmount: " + sc.getTotalAmount());
                break;
                case "payableAmount":
                    System.out.println("Payable amount: " + sc.
                        getPayableAmount());
                break;
                case "print":
                    sc.printInvoice();
                break;
                case "coupon":
                    sc.applyCoupon(tokens[1]);
                break;
                default:
                break;
            }

        }
    }
}
