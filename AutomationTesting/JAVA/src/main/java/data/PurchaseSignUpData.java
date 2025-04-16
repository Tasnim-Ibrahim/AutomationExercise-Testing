package data;

public class PurchaseSignUpData {
    private String id;
    private SignupData user;
    private ProductData product;
    private PaymentData payment;

    // Default constructor for Jackson
    public PurchaseSignUpData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SignupData getUser() {
        return user;
    }

    public void setUser(SignupData user) {
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
