package SeleniumAutomation;

import org.openqa.selenium.WebElement;

import static SeleniumAutomation.CommonFunctions.*;

/**
 *
 * @author mpentakota
 */
public interface BusinessFunctions {

    public static void main(String[] args) {

    }

    public static boolean OPENCREW() throws Exception {
        String Crewpath = "id:=dropbtn_1357";
        String Newpath = "xpath:=//*[@id=\"btn-new\"]";
        String CrewDetails = "xpath:=//*[@id=\"multi-open-accordion\"]/h3[2]/a";
        WebElement Crew = Getlocator(driver, Crewpath);
        Crew.click();
        boolean status = true;
        Crew.click();
        WAITTIME("waittime->10");
        Crew.click();
        WAITTIME("waittime->10");
        Crew.click();
        WAITTIME("waittime->10");
        Crew.click();
        WAITTIME("waittime->10");
        driver.switchTo().frame(0);
        WebElement New = Getlocator(driver, "xpath:=//*[@id=\"btn-new\"]");
        New.click();
        ReportFunctions.LogRepoter("pass", "wait for the element", "element found NEW and clicked on it");
        return false;
    }

    public static boolean OpenAngularpage() throws Exception {
        boolean status = true;
        int count = 0;
        boolean flag = false;
        try {
            do {
                WAITTIME("waittime->25");
                driver.switchTo().defaultContent();
                driver.switchTo().frame(0);
             // WebElement locator = Getlocator(driver, "xpath:=//input[@type=\"search\"]");
             WebElement locator = Getlocator(driver, "xpath:=//input [(@id=\"searchtext\") or (@type=\"search\")]");
                if (locator != null) {
                    WebElement New = Getlocator(driver, "xpath:=//*[@id=\"btn-new\"]");
                    New.click();
                    ReportFunctions.LogRepoter("Pass", "Wait for angular js page", "Sucessfully angular js page loaded");
                    WAITTIME("waittime->4");
                    flag = true;
                    count = 5001;
                    status = true;
                    return status;
                } else {
                    count = count + 1;
                }
            } while (count < 5000);
            if (flag == false) {
                ReportFunctions.LogRepoter("Fail", "Wait for angular js page", "Failed to load angular js page");
            }
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            driver.switchTo().defaultContent();
            if (flag == false) {
                WAITTIME("waittime->10");
                count = count + 1;
                OpenAngularpage();
            }
        }
        return status;
    }
}
