    package lv.acodemy.EbayPages;

    import lv.acodemy.utils.LocalDriverManager;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;

    import static org.openqa.selenium.support.How.ID;

    public class findPage {
        private final WebDriver driver= LocalDriverManager.getInstance();

        public findPage(){
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath ="//*[@id=\"gh-ac\"]")
        WebElement findField;
        @FindBy(how = ID,id="gh-btn")
        WebElement searchButton;




        public void enterThings(String product){
            findField.sendKeys(product);
            searchButton.click();


        }





    }
