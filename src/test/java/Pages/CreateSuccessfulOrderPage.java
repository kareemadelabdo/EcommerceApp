package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateSuccessfulOrderPage {
    WebDriver driver;

    public CreateSuccessfulOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "cart-label")
    WebElement cartLabelEle;

    @FindBy(id = "termsofservice")
    WebElement termOfService;

    @FindBy(id = "checkout")
    WebElement chekoutEle;

    public void ClickOnCartLable() {
        cartLabelEle.click();
    }

    public void AgreeOnTerms() {
        termOfService.click();
    }

    public void CheckOut() {
        chekoutEle.click();
    }


    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement firstNameEle;
    @FindBy(id = "BillingNewAddress_LastName")
    WebElement lastNameEle;
    @FindBy(id = "BillingNewAddress_Email")
    WebElement emailEle;
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement countryEle;
    @FindBy(id = "BillingNewAddress_City")
    WebElement cityEle;
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement addressEle;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipPostalCodeEle;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumberEle;
    @FindBy(css = "button[class=\"button-1 new-address-next-step-button\"]")
    WebElement continueBtnEle;

    public void SendData() {
        firstNameEle.sendKeys("kareem");
        lastNameEle.sendKeys("adel");
        emailEle.clear();
        emailEle.sendKeys("kareem@outlook.com");
        countryEle.sendKeys("Egypt");
        cityEle.sendKeys("cairo");
        addressEle.sendKeys("address test");
        zipPostalCodeEle.sendKeys("2022");
        phoneNumberEle.sendKeys("01098087393");
        continueBtnEle.click();

    }

    @FindBy(id = "shippingoption_1")
    WebElement shippingTypeEle;
    @FindBy(css = "button[class=\"button-1 shipping-method-next-step-button\"]")
    WebElement continueBtn2Ele;

    public void ChooseShipping(){
        shippingTypeEle.click();
        continueBtn2Ele.click();

    }


    @FindBy(id = "paymentmethod_0")
    WebElement paymentMethodEle;

    @FindBy(css = "button[class=\"button-1 payment-method-next-step-button\"]")
    WebElement continueBtn3Ele;

    public void ChoosePayment(){
        paymentMethodEle.click();
        continueBtn3Ele.click();

    }

    @FindBy(css = "button[class=\"button-1 payment-info-next-step-button\"]")
    WebElement continueBtn4Ele;

    public void PaymentInfo(){
        continueBtn4Ele.click();
    }

    @FindBy(css = "button[class=\"button-1 confirm-order-next-step-button\"]")
    WebElement continueBtn5Ele;
    public void ConfirmOrder(){
        continueBtn5Ele.click();
    }

    @FindBy(className = "title")
    WebElement successMsgEle;

    public WebElement getSuccessMsgEle() {
        return successMsgEle;
    }
}
