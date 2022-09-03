package page_object;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BaseSettings {

    //Поле - Имя
    private final By nameField = By.xpath(".//input[@placeholder=\"* Имя\"]");
    //Поле - Фамилия
    private final By surnameField = By.xpath(".//input[@placeholder=\"* Фамилия\"]");
    //Поле - Адрес
    private final By addressField = By.xpath(".//input[@placeholder=\"* Адрес: куда привезти заказ\"]");
    //Поле - Станция Метро
    private final By subwayField = By.xpath(".//input[@placeholder=\"* Станция метро\"]");
    //Вариант метро - Бульвар Рокоссовского
    private final By firstElementSubwayInDropdown = By.xpath(".//li[@data-value = \"1\"]");
    //Поле - Номер телефона
    private final By phoneNumberField = By.xpath(".//input[@placeholder=\"* Телефон: на него позвонит курьер\"]");
    //Кнопка - Далее
    private final By continueOrderButton = By.className("Button_Middle__1CSJM");

    //Поле - Когда привезти самокат
    private final By calendar = By.xpath(".//div[@class = \"react-datepicker__input-container\"]/input");
    //Вариант даты, когда привезти самокат - 16 сентября
    private final By dateSeptember16 = By.xpath(".//div[@aria-label = \"Choose пятница, 23-е сентября 2022 г.\"]");
    //Выпадающий список - Срок аренды
    private final By lengthOfRentField = By.xpath(".//div/div[@class = \"Dropdown-placeholder\"]");
    //Варианты цветов самоката - черный и серый
    private final By colorOptionBlack = By.xpath(".//input[@id = \"black\"]");
    private final By colorOptionGrey = By.xpath(".//input[@id = \"grey\"]");
    //Кнопка "Заказать", находящаяся под полем "Комментарий для курьера"
    private final By lowerButtonMakeAnOrder = By.xpath(".//div[@class = \"Order_Buttons__1xGrp\"]/button[text() = \"Заказать\"]");

    //варианты в дропдауне - Срок аренды: от одних до семи суток
    private final By firstDropdownOption = By.xpath("//div[text()=\"сутки\"]");
    private final By secondDropdownOption = By.xpath("//div[text()=\"двое суток\"]");
    private final By thirdDropdownOption = By.xpath("//div[text()=\"трое суток\"]");
    private final By forthDropdownOption = By.xpath("//div[text()=\"четверо суток\"]");
    private final By fifthDropdownOption = By.xpath("//div[text()=\"пятеро суток\"]");
    private final By sixthDropdownOption = By.xpath("//div[text()=\"шестеро суток\"]");
    private final By seventhDropdownOption = By.xpath(".//div[text()=\"семеро суток\"]");

    //Поле - Комментарий для курьера
    private final By commentaryField = By. xpath(".//input[@placeholder = \"Комментарий для курьера\"]");
    //Кнопка на форме "Хотите оформить заказ?" - ДА
    private final By yesButton = By.xpath(".//button[text() = \"Да\"]");
    //Форма успешного оформления заказа
    private final By formOfSuccessfulOrder = By.xpath(".//div[text() = \"Заказ оформлен\"]");


    //ошибка при неправильном заполнении поля Имя
    private final By incorrectNameErrorMessage = By.xpath(".//div[text() = \"Введите корректное имя\"]");
    //ошибка при неправильном заполнении поля Фамилия
    private final By incorrectSurnameErrorMessage = By.xpath(".//div[text() = \"Введите корректную фамилию\"]");
    //ошибка при неправильном заполнении поля Адрес
    private final By incorrectAddressErrorMessage = By.xpath(".//div[text() = \"Введите корректный адрес\"]");
    //ошибка при неправильном заполнении поля Номер телефона
    private final By incorrectPhoneNumberErrorMessage = By.xpath(".//div[text() = \"Введите корректный номер\"]");

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    @Before
    public void setAddress(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void fillName (String name){
        driver.findElement(nameField).sendKeys(name);
    }

    public void fillSurname (String surname){
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void fillAddress (String address){
        driver.findElement(addressField).sendKeys(address);
    }

    public void fillSubway(){
        driver.findElement(subwayField).click();
        driver.findElement(subwayField).sendKeys("Бульвар Рокоссовского");
        driver.findElement(firstElementSubwayInDropdown).click();

    }

    public void fillPhoneNumberField(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickContinueButton (){
        driver.findElement(continueOrderButton).click();
    }

    public void fillInDateOfDelivery(){
        driver.findElement(calendar).click();
        driver.findElement(dateSeptember16).click();
    }

    public void fillInLengthOfRent(int number) {
        driver.findElement(lengthOfRentField).click();
        if (number == 1) {
            driver.findElement(firstDropdownOption).click();
        } else if (number == 2) {
            driver.findElement(secondDropdownOption).click();
        } else if (number == 3) {
            driver.findElement(thirdDropdownOption).click();
        } else if (number == 4) {
            driver.findElement(forthDropdownOption).click();
        } else if (number == 5) {
            driver.findElement(fifthDropdownOption).click();
        } else if (number == 6) {
            driver.findElement(sixthDropdownOption).click();
        } else if (number == 7) {
            driver.findElement(seventhDropdownOption).click();
        } else {
            System.out.println("Аренда доступна от 1 до 7 суток");
        }
    }

    public void markColorOfScooter(int number) {
        if(number == 1){
            driver.findElement(colorOptionBlack).click();
        }
        if(number == 2){
            driver.findElement(colorOptionGrey).click();
        }
    }

    public void clickMakeAnOrderButton (){
        driver.findElement(lowerButtonMakeAnOrder).click();
    }

    public void clickYes(){
        driver.findElement(yesButton).click();
    }

    public boolean isFormOfSuccessfulOrderAppeared(){
        return driver.findElement(formOfSuccessfulOrder).isDisplayed();
    }

    public void fillInCommentaryField(String text){
        driver.findElement(commentaryField).sendKeys(text);
    }

    public boolean isErrorMessageIsPresentName(){
        return driver.findElement(incorrectNameErrorMessage).isDisplayed() && driver.findElement(incorrectNameErrorMessage).getText().equals("Введите корректное имя");
    }

    public boolean isErrorMessageIsPresentSurname(){
        return driver.findElement(incorrectSurnameErrorMessage).isDisplayed() && driver.findElement(incorrectSurnameErrorMessage).getText().equals("Введите корректную фамилию");
    }

    public boolean isErrorMessageIsPresentAddress(){
        return driver.findElement(incorrectAddressErrorMessage).isDisplayed() && driver.findElement(incorrectAddressErrorMessage).getText().equals("Введите корректный адрес");
    }

    public boolean isErrorMessageIsPresentPhoneNumber(){
        return driver.findElement(incorrectPhoneNumberErrorMessage).isDisplayed() && driver.findElement(incorrectPhoneNumberErrorMessage).getText().equals("Введите корректный номер");
    }
}

