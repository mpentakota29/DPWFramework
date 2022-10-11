/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SeleniumAutomation;

import static SeleniumAutomation.CommonFunctions.driver;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 *
 * @author Innovacx-pc
 */
public class RunnerClass 
{
    public static class MultiThreading extends Thread 
    {
    
    //DriverScript Ds = new DriverScript();   
    public WebDriver driver;
    public String browserType;
    
    
    public MultiThreading(String name,String browserType) throws Exception
    {
          
        //super(name);
        //this.browserType = browserType;
    }
    
//    public void run() 
//    {
//        String threadName = Thread.currentThread().getName();
//        System.out.println("This is the thread name " + threadName);
//        try {
//            Thread.sleep(3000);
//            //setup(browserType);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public  void setup(String browserType) throws IOException
//    {
//        
//        if(browserType.equalsIgnoreCase("chrome")) 
//        {
//           String workingDirectory = new java.io.File(".").getCanonicalPath();
//            System.setProperty("webdriver.chrome.driver", workingDirectory + "/JavaJarfiles/chromedriver.exe");
//            driver = new ChromeDriver();
//            
//        } else if(browserType.equalsIgnoreCase("firefox")) 
//           {
//             String workingDirectory = new java.io.File(".").getCanonicalPath();
//                String dpath = workingDirectory;
//                File file = new File(dpath + "\\Savedoutput");
//                String[] myFiles;
//                if (file.isDirectory()) {
//                    myFiles = file.list();
//                    for (int i = 0; i < myFiles.length; i++) {
//                        File myFile = new File(file, myFiles[i]);
//                        myFile.delete();
//                    }
//                }
//                FirefoxProfile profile = new FirefoxProfile();
//                profile.setPreference("browser.download.dir", dpath + "\\Savedoutput");
//                profile.setPreference("browser.download.folderList", 2);
//                //profile.setPreference("browser.helperApps.alwaysAsk.force", "false");
//                profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/x-excel, application/x-msexcel, application/excel, application/vnd.ms-excel,application/xls;");
//                //profile.setPreference("browser.download.manager.showWhenStarting", "false");
//                profile.setPreference("pdfjs.disabled", "true");
//                driver = new FirefoxDriver((Capabilities) profile);
//        }
//       // driver.get("https://www.google.com/");
//       // driver.manage().window().maximize();
//    }
    
    public static void main(String[] args) throws Exception 
    {
        
        Thread t1 = new MultiThreading("Chrome Driver Thread","chrome");
        //DriverScript.ReadSuite("SuiteFile");
        Thread t2 = new MultiThreading("Firefox Driver Thread","chrome");
      
        
        t1.start();
        t2.start();
          DriverScript.ReadSuite("SuiteFile1");
    }
    }
}
