package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TestDataProvider {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final String TEST_DATA_DIR = "src/test/resources/testData/";

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() throws IOException {
        LoginData[] data = mapper.readValue(
                new File(TEST_DATA_DIR + "login_data.json"),
                LoginData[].class);

        return Arrays.stream(data)
                .map(item -> new Object[]{item})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "logoutData")
    public static Object[][] getLogoutData() throws IOException {
        LogoutData[] data = mapper.readValue(
                new File(TEST_DATA_DIR + "logout_data.json"),
                LogoutData[].class);

        return Arrays.stream(data)
                .map(item -> new Object[]{item})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "signupData")
    public static Object[][] getSignupData() throws IOException {
        SignupData[] data = mapper.readValue(
                new File(TEST_DATA_DIR + "signup_data.json"),
                SignupData[].class);

        return Arrays.stream(data)
                .map(item -> new Object[]{item})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "paymentData")
    public static Object[][] getPaymentData() throws IOException {
        PaymentData[] data = mapper.readValue(
                new File(TEST_DATA_DIR + "payment_data.json"),
                PaymentData[].class);

        return Arrays.stream(data)
                .map(item -> new Object[]{item})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "productsData")
    public static Object[][] getProductsData() throws IOException {
        ProductData[] data = mapper.readValue(
                new File(TEST_DATA_DIR + "products_data.json"),
                ProductData[].class);

        return Arrays.stream(data)
                .map(item -> new Object[]{item})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "contactUsData")
    public static Object[][] getContactUsData() throws IOException {
        ContactUsData[] data = mapper.readValue(
                new File(TEST_DATA_DIR + "contactus_data.json"),
                ContactUsData[].class);

        return Arrays.stream(data)
                .map(item -> new Object[]{item})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "PurchaseSignUpData")
    public static Object[][] getPurchaseFlowData() throws IOException {
        PurchaseSignUpData[] data = mapper.readValue(
                new File(TEST_DATA_DIR + "purchase_signup_data.json"),
                PurchaseSignUpData[].class);

        return Arrays.stream(data)
                .map(item -> new Object[]{item})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "purchaseLoginData")
    public static Object[][] getPurchaseLoginData() throws IOException {
        PurchaseWithLoginData[] data = mapper.readValue(
                new File(TEST_DATA_DIR + "purchase_login_data.json"),
                PurchaseWithLoginData[].class);

        return Arrays.stream(data)
                .map(item -> new Object[]{item})
                .toArray(Object[][]::new);
    }
}