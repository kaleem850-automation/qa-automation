package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class HomePage extends PageObject {

    @Value("${aut.url}")
    private String url;

    @FindBy(className = "App-header")
    WebElement header;

    @FindBy(id = "name")
    WebElement txtName;

    @FindBy(id = "city")
    WebElement txtCity;

    @FindBy(css = "button[type='submit']")
    WebElement btnSubmit;

    @FindBy(xpath = "//button[contains(text(), 'Clear')]")
    WebElement btnClear;

    @FindBy(xpath = "//h2[contains(text(), 'Applied')]/ancestor::div[@class='App-column']")
    WebElement appliedCol;

    @FindBy(xpath = "//h2[contains(text(), 'Interviewing')]/ancestor::div[@class='App-column']")
    WebElement interviewingCol;

    @FindBy(xpath = "//h2[contains(text(), 'Hired')]/ancestor::div[@class='App-column']")
    WebElement hiredCol;

    public void openURL() {
        driver.get(url);
    }

    public void waitForPageLoad(){
        waitForElement(header);
    }

    public void searchForName(String name) {
        this.txtName.sendKeys(name);
        this.btnSubmit.click();
    }
    public void searchForLocation(String location) {
        this.txtName.clear();
        this.txtCity.sendKeys(location);
        this.btnSubmit.click();
    }

    public void moveCategory(String name, String fromcat, String tocat) {
        if ((fromcat.equalsIgnoreCase("applied") && tocat.equalsIgnoreCase("interviewing")) ||
                        (fromcat.equalsIgnoreCase("interviewing") && tocat.equalsIgnoreCase("hired")
        )){
            driver.findElement(By.xpath("//div[contains(text(), '"+name+"')]/ancestor::div[@class='CrewMember-container']//descendant::button[@class='CrewMember-up']")).click();
        }
    }

    public long filterCrew(String category) {
        if (category.equalsIgnoreCase("applied")) {
            return appliedCol.findElements(By.className("CrewMember-container")).size();
        } else if (category.equalsIgnoreCase("interviewing")) {
            return interviewingCol.findElements(By.className("CrewMember-container")).size();
        }
        return hiredCol.findElements(By.className("CrewMember-container")).size();
    }

}
