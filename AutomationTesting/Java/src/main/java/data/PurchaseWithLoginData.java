package data;

public class PurchaseWithLoginData {
    private String id;
    private LoginData user;
    private ProductData product;
    private PaymentData payment;

    // Default constructor for Jackson
    public PurchaseWithLoginData() {
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LoginData getUser() {
        return user;
    }

    public void setUser(LoginData user) {
        this.user = user;
    }

    public ProductData getProduct() {
        return product;
    }

    public void setProduct(ProductData product) {
        this.product = product;
    }

    public PaymentData getPayment() {
        return payment;
    }

    public void setPayment(PaymentData payment) {
        this.payment = payment;
    }
}