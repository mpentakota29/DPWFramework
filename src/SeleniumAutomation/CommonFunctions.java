package SeleniumAutomation;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.iharder.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.security.Key;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static SeleniumAutomation.BusinessFunctions.OPENCREW;
import static SeleniumAutomation.BusinessFunctions.OpenAngularpage;
import static SeleniumAutomation.ReportFunctions.xmlSavedLocation;

public class CommonFunctions {
    public static WebDriver driver2;

    public static WebDriver driver;

    public static Connection conn;
    public final static HashMap<String, String> hmap = new HashMap<String, String>();
    public final static HashMap<String, Integer> TChmap = new HashMap<String, Integer>();
    public final static HashMap<String, String> TCstatushmap = new HashMap<String, String>();
    public final static HashMap<Integer, String> sanitymap = new HashMap<Integer, String>();
    private static final String MSEC_SINCE_EPOCH = null;
    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue
            = new byte[]{'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};


    private static int flag;
    public static java.util.Date odate;
    public static String Tcase;
    public static int timer;
    static DriverScript ds;
    public static String user;
    public static String Tsuitename;
    public static String suitename;
    public static String Tcasename;
    public static String updstpstatus = null;
    public static String envfilepath = null;
    public static String savedlocation = null;
    public static String Tstep = "Tstep";
    public static String locator;
    public static Element prjElement = null;
    public static Element tsElement = null;
    public static Element tcElement = null;
    public static Element tstpElement = null;
    public static String SCellData;
    public static ChromeOptions options;
    public static String muldatastatus;
    public static String mulpledata;
    public static String url;
    public static Date date;
    public static DateFormat formatter;
    public static String today;
    public static String[] dateformat;
    public static String finaldate;
    public static String dat;
    public static int fcolval;
    public static String value;
    public static String data;
    public static String storedatavalue;
    public static Boolean storedataflag = null;
    public static boolean sendmail = false;
    public static int Tcasecount = 0;
    public static String TCasenames;
    public static String exsuitestatus = null;
    public static String exduration = null;
    public static String display;
    public static String exelcasefinalstatus;
    public static boolean blnResult = true;
    public static int casecount = 0;
    public static int sanitycnt = 1;
    public static int tempnum = 0;
    public static int sanitydash = 1000;
    public static int sanityVerifyFilterswithLOV = 2000;
    public static int sanityVerifyFilterswithText = 3000;
    public static int sanityVerifyOnPagePromptswithLOV = 4000;
    public static int sanityVerifyOnPagePromptswithText = 5000;
    public static int sanityVerifyFilterswithadaterange = 6000;
    public static int sanityVerifysavedFilterswithLOV = 7000;
    public static int sanityVerifysavedFilterswithText = 8000;
    public static int sanityVerifyNewformisloading = 9000;
    public static int sanityVerifySearch = 10000;
    public static int sanityVerifyFWDActions = 11000;
    public static int sanityVerifyDrills = 12000;
    public static int sanityVerifySortingfunctionality = 13000;
    public static int sanityVerifyangularpage = 14000;
    public static String casestatus;
    public static String Esuitename = null;
    public static String Esuiteduration;
    public static String ESuitestatus;
    public static int TCpasscount = 0;
    public static int TCfailcount = 0;
    public static String Stpname = null;
    public static String releasename;
    public static String environmentname;

    public enum ActionTypes {
        TAB, ENTER, F12, DOWN, LAUNCHBROWSER, LOGIN, ENTERVALUE, SELECTVALUEDROPDOWN,DROPDOWN_SCROLL, CLICK,HIGHLIGHTER,GENERATEPASSPORT_NUMBER, JAVACLICK,CLEARTEXTBOX, CLOSEPOPUP, CLOSECURRENTBROWSER, DOUBLECLICK, CLOSEALLBROWSERS,
        ALERTACTION, SELECTFRAME, CLICKTAB, SELECTIFRAMEBYINDEX, CHECKINGCHKBOX, UNCHECKINGCHKBOX, CHECKRADIOBTN, UNCHECKRADIOBTN, ISDISPLAYED, ISNUMERIC, ISENABLED,
        ISDISABLED, ISSELECTED, GETTEXT, GETATTRIBUTE, VERIFYVALUE, SELECTPARENTWINDOW, SWITCHWINDOW,SWITCHTOWINDOW_VERIFY,SWTCHANDVERIFYINCHILDWINDOW, WAITTIME, WAITFORELEMENT, VERIFYTABLEVALUE, GETREQUISITIONID, VERIFYREQUISITIONID,
        SENDKEYS, TLOGIN, ELOGIN, APPROVEALL, REJECTALL, CLOGIN, DOWNLOADEXCEL, CAPTUREANDAPPEND, OPENCREW, GENERATE_UNIQVALUE, CONNECT_MYSQL, CLOSE_MYSQL, QUERY_MYSQL,
        INVISIBLEOFLOAD, ENCRYPT, DECRYPT, STOREVALUE, OPENRESOURCE, CLICK_ENTER, SEARCH_ENTER, UPLOAD_FILE, STALEELEMENTCLICK, VERIFYDATA, SELECTVALUEBYINDEX, COMPAREVALUE,OPENANGULARPAGE,SWITCHDEFAULT,VALIDATEFILTER,VALIDATEDATE,
        SCROLLDOWN,VALIDATEPROMPT,STORESINGLEVALUE,VERIFYDASHBOARD,EXPORTEXCEL,VERIFYNEW,VERIFYSAVEDFILTERS,VERIFYSEARCH,VALIDATEPROMPTTEXT,VALIDATETEXTFILTER,VERIFYDRILL,VERIFYFWDACTION,VALIDATEDATETYPE,SANITY_OPENANGULARPAGE,
        PRESSTABKEY,ACTIONSCLICK,NAVIGATETO,VERIFYBASEDONLABEL,EMAILCONFIRMATION,GETNUMBERFROMTEXT,DJANGOFIN,getlocatorKeyValue
    }

    public static void main(String[] args) throws Exception {

    }
    static WebDriver GlobalDriver;
    static WebDriver driver4;
    public static boolean Invokekeyword(WebDriver driver,String funcname, String funcparameters) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, Exception, StaleElementReferenceException {
        DriverScript.ActionTypes actTypes = DriverScript.ActionTypes.valueOf(funcname.toUpperCase());
        switch (actTypes)
        {
//            case getlocatorKeyValue:
//                blnResult = LAUNCHBROWSER(WebDriver, funcparameters);
//                break;
            case LAUNCHBROWSER:
                GlobalDriver = LAUNCHBROWSER(driver, funcparameters);
                break;
            case LOGIN:
                blnResult = LOGIN(driver, funcparameters);
                break;
            case ENTERVALUE:
                blnResult = ENTERVALUE(funcparameters);
                break;
            case SELECTVALUEDROPDOWN:
                blnResult = SELECTVALUEDROPDOWN(driver, funcparameters);
                break;
            case CLICK:
                blnResult = CLICK( funcparameters);
                break;
            case JAVACLICK:
                blnResult = JAVACLICK(driver, funcparameters);
                break;
            case HIGHLIGHTER:
                blnResult = Highlighter(driver, funcparameters);
                break;
            case SWITCHTOWINDOW_VERIFY:
                blnResult = SWITCHTOWINDOW_Verify(driver, funcparameters);
                break;
            case CLEARTEXTBOX:
                blnResult = CLEARTEXTBOX(driver, funcparameters);
                break;
            case CLOSEPOPUP:
                blnResult = CLOSEPOPUP(driver);
                break;
            case CLOSECURRENTBROWSER:
                blnResult = CLOSECURRENTBROWSER(driver);
                break;
            case DOUBLECLICK:
                blnResult = DOUBLECLICK(driver, funcparameters);
                break;
            case CLOSEALLBROWSERS:
                blnResult = CLOSEALLBROWSERS(driver);
                break;
            case ALERTACTION:
                blnResult = ALERTACTION(driver, funcparameters);
                break;
            case CLICKTAB:
                blnResult = CLICKTAB(driver, funcparameters);
                break;
            case SELECTIFRAMEBYINDEX:
                blnResult = SELECTIFRAMEBYINDEX(driver, funcparameters);
                break;
            case SELECTFRAME:
                blnResult = SELECTFRAME(driver, funcparameters);
                break;
            case DROPDOWN_SCROLL:
                blnResult = DROPDOWN_SCROLL(driver, funcparameters);
                break;
            case UNCHECKINGCHKBOX:
                blnResult = UNCHECKINGCHKBOX(driver, funcparameters);
                break;
            case CHECKINGCHKBOX:
                blnResult = CHECKINGCHKBOX(driver, funcparameters);
                break;
            case CHECKRADIOBTN:
                blnResult = CHECKRADIOBTN(driver, funcparameters);
                break;
            case UNCHECKRADIOBTN:
                blnResult = UNCHECKRADIOBTN(driver, funcparameters);
                break;
            case ISDISPLAYED:
                blnResult = ISDISPLAYED(driver, funcparameters);
                break;
            case ISNUMERIC:
                blnResult = ISNUMERIC(funcparameters);
                break;
            case ISENABLED:
                blnResult = ISENABLED(driver, funcparameters);
                break;
            case ISDISABLED:
                blnResult = ISDISABLED(driver, funcparameters);
                break;
            case ISSELECTED:
                blnResult = ISSELECTED(driver, funcparameters);
                break;
            case GETTEXT:
                blnResult = GETTEXT(driver, funcparameters);
                break;
            case GETATTRIBUTE:
                blnResult = GETATTRIBUTE(driver, funcparameters);
                break;
            case VERIFYVALUE:
                blnResult = VERIFYVALUE(driver, funcparameters);
                break;
            case SELECTPARENTWINDOW:
                blnResult = SELECTPARENTWINDOW(driver);
                break;
            case SWTCHANDVERIFYINCHILDWINDOW:
                blnResult = SWTCHANDVERIFYINCHILDWINDOW(driver);
                break;
            case SWITCHWINDOW:
                blnResult = SWITCHWINDOW(driver, funcparameters);
                break;
            case WAITTIME:
                blnResult = WAITTIME(funcparameters);
                break;
            case WAITFORELEMENT:
                blnResult = WAITFORELEMENT(driver, funcparameters);
                break;
            case VERIFYTABLEVALUE:
                blnResult = VERIFYTABLEVALUE(driver, funcparameters);
                break;
            case GETREQUISITIONID:
                blnResult = GETREQUISITIONID(driver, funcparameters);
                break;
            case VERIFYREQUISITIONID:
                blnResult = VERIFYREQUISITIONID(driver, funcparameters);
                break;
            case SENDKEYS:
                blnResult = SENDKEYS(driver, funcparameters);
                break;
            case CAPTUREANDAPPEND:
                blnResult = CAPTUREANDAPPEND(driver, funcparameters);
                break;
            case ELOGIN:
                blnResult = ELOGIN(driver, funcparameters);
                break;
            case TLOGIN:
                blnResult = TLOGIN(driver, funcparameters);
                break;
            case APPROVEALL:
                blnResult = APPROVEALL(driver);
                break;
            case REJECTALL:
                blnResult = REJECTALL(driver);
                break;
            case CLOGIN:
                blnResult = CLOGIN(driver, funcparameters);
            case OPENCREW:
                blnResult = OPENCREW();
                break;
            case GENERATE_UNIQVALUE:
                blnResult = GENERATE_UNIQVALUE(funcparameters);
                break;
            case CONNECT_MYSQL:
                blnResult = Connect_MySQL(funcparameters);
                break;
            case CLOSE_MYSQL:
                blnResult = Close_MySQL();
            case QUERY_MYSQL:
                blnResult = Query_MySQL(funcparameters);
                break;
            case INVISIBLEOFLOAD:
                blnResult = INVISIBLEOFLOAD(driver);
                break;
            case ENCRYPT:
                blnResult = encrypt(funcparameters);
                break;
            case DECRYPT:
                blnResult = decrypt(funcparameters);
                break;
            case STOREVALUE:
                blnResult = Storevalue(funcparameters);
                break;
            case OPENANGULARPAGE:
                blnResult = OpenAngularpage();
                break;
            case CLICK_ENTER:
                blnResult = Click_Enter(funcparameters);
                break;
            case SEARCH_ENTER:
                blnResult = Search_Enter(funcparameters);
                break;
            case UPLOAD_FILE:
                blnResult = Upload_File(funcparameters);
                break;
            case STALEELEMENTCLICK:
                blnResult = StaleElementClick(driver, funcparameters);
                break;
            case VERIFYDATA:
                blnResult = VERIFYDATA(funcparameters);
                break;
            case SELECTVALUEBYINDEX:
                blnResult = SelectvalueByIndex(driver, funcparameters);
                break;
            case COMPAREVALUE:
                blnResult = COMPAREVALUE(driver, funcparameters);
                break;
            case SWITCHDEFAULT:
                blnResult = SwitchDefault(driver);
                break;
            case VALIDATEFILTER:
                blnResult = ValidateFilter(driver, funcparameters);
                break;
            case VALIDATEDATE:
                blnResult = Validatedate(driver, funcparameters);
                break;
            case VALIDATEPROMPT:
                blnResult = ValidatePrompt(driver, funcparameters);
                break;
            case STORESINGLEVALUE:
                blnResult = Storesinglevalue(funcparameters);
                break;
            case VERIFYDASHBOARD:
                blnResult = verifydashboard(driver,funcparameters);
                break;
            case EXPORTEXCEL:
                blnResult = ExportExcel(driver,funcparameters);
                break;
            case VERIFYNEW:
                blnResult = VerifyNew(driver,funcparameters);
                break;
            case VERIFYSAVEDFILTERS:
                blnResult = VerifySavedFilters(driver,funcparameters);
                break;
            case VERIFYSEARCH:
                blnResult = verifySearch(driver,funcparameters);
                break;
            case VALIDATEPROMPTTEXT:
                blnResult = ValidatePromptText(driver,funcparameters);
                break;
            case VALIDATETEXTFILTER:
                blnResult = ValidateTextFilter(driver,funcparameters);
                break;
            case VERIFYDRILL:
                blnResult = VerifyDrill(driver,funcparameters);
                break;
            case VERIFYFWDACTION:
                blnResult = VerifyFwdAction(driver,funcparameters);
                break;
            case VALIDATEDATETYPE:
                blnResult = ValidateDateType(driver,funcparameters);
                break;
            case SANITY_OPENANGULARPAGE:
                blnResult = sanity_OpenAngularpage(driver,funcparameters);
                break;
            case SCROLLDOWN:
                blnResult = SCROLLDOWN(driver,funcparameters);
                break;
            case PRESSTABKEY:
                blnResult = PRESSTABKEY(driver,funcparameters);
                break;
            case ACTIONSCLICK:
                blnResult = ACTIONSCLICK(driver,funcparameters);
                break;
            case NAVIGATETO:
                blnResult = NAVIGATETO(driver,funcparameters);
                break;
            case EMAILCONFIRMATION:
                blnResult=EMAILCONFIRMATION(driver,funcparameters);
                break;
            case VERIFYBASEDONLABEL:
                blnResult=VERIFYBASEDONLABEL(driver,funcparameters);
                break;
            case GETNUMBERFROMTEXT:
                blnResult=GETNUMBERFROMTEXT(driver,funcparameters);
                break;
            case DJANGOFIN:
                blnResult=DJANGOFIN(funcparameters);
                break;
            default:
                break;
        }
        return blnResult;
    }

    public static String readpath() throws IOException {
        // TODO Auto-generated method stub
        String workingDirectory = new java.io.File(".").getCanonicalPath();
        //System.out.println(workingDirectory);
        return workingDirectory;
    }
    
 // ************************************************************************************************************************
	/*
	 * Function Name:LaunchBrowser
	 * It will check the switch case whether which browser should launch with URL
	 * Author: Sahitya
	 */
 // *************************************************************************************************************************
 public static WebDriver init_driver(String browserName) throws IOException
 {
     String workingDirectory = new java.io.File(".").getCanonicalPath();

  System.out.println(WebDriverManager.chromedriver().getDriverVersions());
     Properties prop;
     System.out.println("Browser lanuch is : " + browserName);
     if (browserName.equalsIgnoreCase("chrome"))
     {
         WebDriverManager.chromedriver().setup();
       //  System.setProperty("webdriver.chrome.driver", workingDirectory + "/JavaJarfiles/chromedriver.exe");
         DriverScript.WebDriver = new ChromeDriver();
     }

     else if (browserName.equalsIgnoreCase("firefox")) {
       WebDriverManager.firefoxdriver().setup();
         DriverScript.WebDriver = new FirefoxDriver();
     } else if (browserName.equalsIgnoreCase("ieexplorer")) {
        WebDriverManager.edgedriver().setup();
       //  driver = new EdgeDriver();
     } else {
         System.out.println("Browser is not supported " + browserName);
     }

     DriverScript.WebDriver.manage().window().maximize();
     DriverScript.WebDriver.manage().deleteAllCookies();
     return DriverScript.WebDriver;
 }
    public static WebDriver LAUNCHBROWSER(WebDriver WebDriver, String parameters) throws IOException, InterruptedException {


      //  Thread.sleep(3000);

        String workingDirectory = new java.io.File(".").getCanonicalPath();
        String actualurl = null;

        String[] arguments = splitfunction(parameters, "->");

        String browser = null;
        if (hmap.containsKey(arguments[1])) {
            browser = hmap.get(arguments[1]);

        } else {
            browser = arguments[1];
        }
        if (hmap.containsKey(arguments[2])) {
            url = hmap.get(arguments[2]);
        } else {
            url = arguments[2];
        }

        switch (browser) {

            case "IE explorer":
                System.setProperty("webdriver.ie.driver", workingDirectory + "/JavaJarfiles/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                driver.get(url);
                driver.manage().window().maximize();
                actualurl = driver.getCurrentUrl();
                break;
            case "FireFox":
                workingDirectory = new java.io.File(".").getCanonicalPath();
                String dpath = workingDirectory;
                File file = new File(dpath + "\\Savedoutput");
                String[] myFiles;
                if (file.isDirectory()) {
                    myFiles = file.list();
                    for (int i = 0; i < myFiles.length; i++) {
                        File myFile = new File(file, myFiles[i]);
                        myFile.delete();
                    }
                }
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.download.dir", dpath + "\\Savedoutput");
                profile.setPreference("browser.download.folderList", 2);
                //profile.setPreference("browser.helperApps.alwaysAsk.force", "false");
                profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/x-excel, application/x-msexcel, application/excel, application/vnd.ms-excel,application/xls;");
                //profile.setPreference("browser.download.manager.showWhenStarting", "false");
                profile.setPreference("pdfjs.disabled", "true");
                driver = new FirefoxDriver((Capabilities) profile);
                driver.get(url);
                driver.manage().window().maximize();
                actualurl = driver.getCurrentUrl();
                break;
            case "Chrome":
                //System.out.println("Before chrome driver");
                System.setProperty("webdriver.chrome.driver", workingDirectory + "/JavaJarfiles/chromedriver.exe");
                options = new ChromeOptions();
		options.addArguments("disable-infobars");
	        DesiredCapabilities caps = DesiredCapabilities.chrome();
	        caps.setCapability(ChromeOptions.CAPABILITY, options);
	        caps.setCapability("acceptInsecureCerts", caps);
                System.out.println("URL: " + url);
                WebDriver = init_driver("chrome");
                //System.out.println("AFter new ChromeDriver()");
                WebDriver.get(url);
                WebDriver.manage().window().maximize();
                actualurl = WebDriver.getCurrentUrl();

                if (!(WebDriver instanceof WebStorage))
				{
					throw new IllegalArgumentException("This test expects the driver to implement WebStorage");
				}
				WebStorage webStorage = (WebStorage) WebDriver;
				webStorage.getSessionStorage().clear();
				webStorage.getLocalStorage().clear();

                break;
            case "HEADLESS" :
                System.setProperty("webdriver.chrome.driver", workingDirectory + "/JavaJarfiles/chromedriver.exe");
			options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.setHeadless(true);
			options.addArguments("--window-size=1920,1080");
		    options.addArguments("--allow-insecure-localhost");
		    options.addArguments("--disable-gpu");
		    options.addArguments("--no-sandbox");
		    caps = DesiredCapabilities.chrome();
		    caps.setCapability(ChromeOptions.CAPABILITY, options);
		    caps.setCapability("acceptInsecureCerts", caps);
			driver = new ChromeDriver(options);
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
			actualurl = driver.getCurrentUrl();
			if (!(driver instanceof WebStorage)) {
				throw new IllegalArgumentException("This test expects the driver to implement WebStorage");
			}
		    webStorage = (WebStorage) driver;
			webStorage.getSessionStorage().clear();
			webStorage.getLocalStorage().clear();
			break;
        }

        if (url.equals(url)) {
            ReportFunctions.LogRepoter("pass", "Entered URL to Launch Applicatioin", "Application launched succesfully");
            return WebDriver;

        } else {
            //System.out.println(driver.getCurrentUrl());
            ReportFunctions.LogRepoter("Fail", "Entered URL to Launch Applicatioin", "Failed to launch application");
            WAITTIME("waittime->2");
            CLOSEALLBROWSERS(driver);
            return WebDriver;
        }

    }
    
    // ************************************************************************************************************************
	/*
	 * Function Name:Spiltfunction
	 * It will split the parameter using particular symbol
	 * Author: Sahitya
	 */
    // *************************************************************************************************************************

    public static String[] splitfunction(String keyparameters, String symbol) 
    {
        if (symbol == "+") 
        {
            symbol = "\\+";
        } else if (symbol == "|") 
        {
            symbol = "\\|";
        } else if (symbol == "*") 
        {
            symbol = "\\*";
        }
        String[] parameters = keyparameters.split(symbol);
        return parameters;
    }

    public static boolean WLOGIN(WebDriver WebDriver, String parameters) throws Exception {
        boolean status;
        String[] arguments = splitfunction(parameters, "->");
        String[] arguments1 = splitfunction(arguments[1], "\\|");
        String username = "id:=sso_username";
        String password = "id:=ssopassword";
        String submit = "xpath:=.//*[@id='pageone']/div[2]/div[1]/div/form/ul/li[4]/a[1]";
        WebElement userid = Getlocator(driver, username);
        WebElement pwd = Getlocator(driver, password);
        WebElement submitbtn = Getlocator(driver, submit);
        userid.sendKeys(hmap.get(arguments1[0]));
        pwd.sendKeys(hmap.get(arguments1[1]));
        submitbtn.click();
        Thread.sleep(30000);
        WebElement locator1 = Getlocator(driver, "xpath:=.//*[@id='P502_ACCEPT']/span");
        try {
            if (locator1.isDisplayed()) {
                locator1.click();
            }
        } catch (Exception e) {
            System.out.println("unable to find the locator" + "Accept");
        }
        timer = 300;
        do {
            WebElement locator = Getlocator(driver, "xpath:=.//*[@id='uHeader']/div/div/span");
            if (locator == null) {
                timer = timer - 1;
            } else {
                user = locator.getText();
                timer = 301;
            }
        } while (timer < 300);

        if (user.equals(hmap.get(arguments1[0]))) {
            System.out.println("Successfully loged in with the user" + " " + hmap.get(arguments1[0]));
            ReportFunctions.LogRepoter("pass", "Login with user credentials", "Successfully loged in with the user" + " " + hmap.get(arguments1[0]));
            status = true;
        } else {
            System.out.println("login was not successful");
            ReportFunctions.LogRepoter("Fail", "Login with user credentials", "login was not successful");
            status = false;
        }
        return status;
    }
    
    public static boolean TLOGIN(WebDriver WebDriver, String parameters) throws Exception {
        boolean status = false;
        String[] arguments = splitfunction(parameters, "->");
        String[] arguments1 = splitfunction(arguments[1], "\\|");
        String username = "id:=txtUserName";
        String password = "id:=txtPassword";
        String submit = "id:=lBtnLogin";
        WebElement userid = Getlocator(driver, username);
        WebElement pwd = Getlocator(driver, password);
        WebElement submitbtn = Getlocator(driver, submit);
        userid.sendKeys(hmap.get(arguments1[0]));
        pwd.sendKeys(hmap.get(arguments1[1]));
        submitbtn.click();
        WebElement locator = Getlocator(driver, "xpath:=.//*[@id='Left1_SecuredHyperLink35']");
        try {
            user = locator.getText();

            if (user.equals("Logout")) {
                System.out.println("Successfully loged in with the user" + " " + hmap.get(arguments1[0]));
                ReportFunctions.LogRepoter("pass", "Login with user credentials", "Successfully loged in with the user" + " " + hmap.get(arguments1[0]));
                status = true;
            } else {
                System.out.println("login was not successful");
                ReportFunctions.LogRepoter("Fail", "Login with user credentials", "login was not successful");
                status = false;
            }
        } catch (Exception e) {
            status = false;
            //e.printStackTrace();
            ReportFunctions.LogRepoter("Fail", "Login with user credentials", "login was not successful");

        }
        return status;
    }

    public static boolean ELOGIN(WebDriver WebDriver, String parameters) throws Exception {
        boolean status = false;
        String[] arguments = splitfunction(parameters, "->");
        String[] arguments1 = splitfunction(arguments[1], "\\|");
        String username = "id:=txtUserId";
        String password = "id:=txtPassword";
        String submit = "id:=btnLogin";
        WebElement userid = Getlocator(driver, username);
        WebElement pwd = Getlocator(driver, password);
        WebElement submitbtn = Getlocator(driver, submit);
        userid.sendKeys(hmap.get(arguments1[0]));
        pwd.sendKeys(hmap.get(arguments1[1]));
        submitbtn.click();
        WebElement locator = Getlocator(driver, "id:=ctl00_lnk_btnLogout");
        try {
            user = locator.getText();

            if (user.equals("Logout")) {
                System.out.println("Successfully loged in with the user" + " " + hmap.get(arguments1[0]));
                ReportFunctions.LogRepoter("pass", "Login with user credentials", "Successfully loged in with the user" + " " + hmap.get(arguments1[0]));
                status = true;
            } else {
                System.out.println("login was not successful");
                ReportFunctions.LogRepoter("Fail", "Login with user credentials", "login was not successful");
                status = false;
            }
        } catch (Exception e) {

            //e.printStackTrace();
            ReportFunctions.LogRepoter("Fail", "Login with user credentials", "login was not successful");

        }
        return status;
    }
    
    public static boolean CLOGIN(WebDriver WebDriver, String parameters) throws Exception {
        boolean status = false;
        String[] arguments = splitfunction(parameters, "->");
        String[] arguments1 = splitfunction(arguments[1], "\\|");
        String username = "id:=userNameInput";
        String password = "id:=passwordInput";
        String submit = "id:=submitButton";
        WebElement userid = Getlocator(driver, username);
        WebElement pwd = Getlocator(driver, password);
        WebElement submitbtn = Getlocator(driver, submit);
        userid.sendKeys(hmap.get(arguments1[0]));
        pwd.sendKeys(hmap.get(arguments1[1]));
        submitbtn.click();

        ReportFunctions.LogRepoter("pass", "Login with user credentials", "Successfully loged in with the user" + " " + hmap.get(arguments1[0]));
        status = true;

        return status;
    }
    
// ************************************************************************************************************************
	/*
	 * Function Name: GetLocator
	 * It is used to loacate the element in webpage
	 * Author: Sahitya
	 */
// ************************************************************************************************************************
public static void startDockerGrid() throws IOException, InterruptedException
{
    Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");
    Thread.sleep(20000);
    Runtime.getRuntime().exec("cmd /c start start_chromeScale");


}

    public static void stopDockerGrid() throws IOException, InterruptedException
    {
        Thread.sleep(15000);
        Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
        Thread.sleep(5000);
        Runtime.getRuntime().exec("taskkill /f /im cmd.exe");

    }
    public static WebElement Getlocator(WebDriver WebDriver, String parameters)
            throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException,
            InstantiationException, IllegalAccessException, Exception, StaleElementReferenceException {
        //// RecoveryScenarios();
        WebElement locpath = null;
        try {

            String[] arguments = null;
            boolean b;
            b = parameters.matches(".*:.*");

            if (b) {
                if(parameters.contains("-=")) {
                    arguments = splitfunction(parameters, "-=");
                } else {
                    arguments = splitfunction(parameters, ":");
                }
            } else {
                arguments = splitfunction(parameters, "\\|");
            }

            String mode = arguments[0];
            arguments[0].trim();
            locator = arguments[1];

            switch (mode) {

                case "id":
                    locpath = WebDriver.findElement(By.id(locator));
                    break;
                case "name":
                    locpath = WebDriver.findElement(By.name(locator));
                    break;
                case "linkText":
                    locpath = WebDriver.findElement(By.linkText(locator));
                    break;
                case "xpath":
                    locpath = WebDriver.findElement(By.xpath(locator));
                   WebDriverWait wait = new WebDriverWait(WebDriver,20);
                   wait.until(ExpectedConditions.elementToBeClickable(locpath));


                    break;
                case "cssSelector":
                    locpath = WebDriver.findElement(By.cssSelector(locator));
                    break;
                case "partialLinkText":
                    locpath = WebDriver.findElement(By.partialLinkText(locator));
                    break;
                case "className":
                    locpath = WebDriver.findElement(By.className(locator));
                    break;
                case "tagName":
                    locpath = WebDriver.findElement(By.tagName(locator));
                    break;

            }

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("unable to find the locator" + " " +locator);
        }

        return locpath;

    }
// ************************************************************************************************************************
	/*
	 * Function Name: Highlighter
	 * It will highlight the particular element in webpage
	 * Author: Sahitya
	 */
// ************************************************************************************************************************
    public static boolean Highlighter(WebDriver WebDriver, String parameters)
    {
        try {

            String[] arguments = null;

            arguments = splitfunction(parameters, "\\->");
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(GlobalDriver, arguments[1]);
            }

            else
            {


                locator = getlocatorKeyValue(GlobalDriver, arguments[1]);


            }
            JavascriptExecutor js = (JavascriptExecutor)WebDriver;
           // js.executeScript("arguments[0].setAttribute('style', 'background : yellow;');",locator);
            try 
            {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    
// ************************************************************************************************************************
	/*
	 * Function Name: GeneratePAssport_Number
	 * It will generate the random number
	 * Author: Sahitya
	 */
// ************************************************************************************************************************
    
     public static String GeneratePASSPORT_Number()
  {
	   String Passport_Number = RandomStringUtils.randomAlphabetic(2)+RandomStringUtils.randomNumeric(5);
	   System.out.println(Passport_Number);
		  return Passport_Number;
  }
 
// ************************************************************************************************************************
	/*
	 * Function Name: DROPDOWN_SCROLL
	 * It will scroll down upto to last element in dropdown and select the particular element in dropdown 
	 * Author: Sahitya
	 */
// ************************************************************************************************************************ 
     
     public static boolean DROPDOWN_SCROLL(WebDriver driver, String parameters) 
     {
        
        try {

            String[] arguments = null;

            arguments = splitfunction(parameters,"\\->");
            WebElement locator = null;
            if (arguments[1].matches(".*:.*"))  
            {
                locator = Getlocator(driver, arguments[1]);
            } else 
            {

                locator = getlocatorKeyValue(driver, arguments[1]);
            }
                  
            //List<WebElement> Options = driver.findElements(By.xpath("//div[@class=\"oj-listview-cell-element\"]/span"));
                 // JavascriptExecutor je = (JavascriptExecutor) driver;
                 // je.executeScript("arguments[0].scrollIntoView(true);", Options.get(202) );
                 // Thread.sleep(250);    
                                            
                       Actions action = new Actions(driver);
                       for(int i=0;i<= 200;i++)
                       {
                          
                       action.sendKeys(Keys.ARROW_DOWN).build().perform();
                       }
                       String value =  locator.getText();
    
                        if(value.equalsIgnoreCase(arguments[3]))
                           {
                                System.out.println(" Successfully scrolled to the selected value " + value);
                           }
                          else
                           {
                               System.out.println(" Failed to scrolled to the selected value " + value);
                           }
                        
                  
        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        return true;
    }

// ************************************************************************************************************************
	/*
	 * Function Name: ENTERVALUE
	 * It is used to enter the values in the textbox on a webpage which are give in the sheet
	 * Author: Sahitya
	 */
// ************************************************************************************************************************     
    public static boolean ENTERVALUE( String parameters) throws Exception
    {
        String[] arguments = null;
        Boolean Status = true;
        arguments = splitfunction(parameters, "\\->");
        try {
            if (arguments[3].contains("+")) {
                String[] arg = splitfunction(arguments[3], "+");
                String newv = arg[1];
                if (hmap.containsKey(newv)) {
                    String revalue = hmap.get(newv);
                    arguments[3] = arguments[3].replace("+" + newv + "+", revalue);
                }
            }

            if (arguments[1].contains("+")) {
                String[] arguments1 = splitfunction(arguments[1], "+");
                String[] arguments2 = splitfunction(arguments1[1], "+");
                String newval = arguments2[0];
                if (hmap.containsKey(newval)) {
                    String revalue = hmap.get(newval);
                    arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                    System.out.println("Succesfully clicked on" + " " + arguments[1]);
                    if (arguments[1].contains("+")) {
                        arguments1 = splitfunction(arguments[1], "+");
                        arguments2 = splitfunction(arguments1[1], "+");
                        newval = arguments2[0];
                        if (hmap.containsKey(newval)) {
                            revalue = hmap.get(newval);
                            arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                            System.out.println("Succesfully clicked on" + " " + arguments[1]);
                            if (arguments[1].contains("+")) {
                                arguments1 = splitfunction(arguments[1], "+");
                                arguments2 = splitfunction(arguments1[1], "+");
                                newval = arguments2[0];
                                if (hmap.containsKey(newval)) {
                                    revalue = hmap.get(newval);
                                    arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                                    System.out.println("Succesfully clicked on" + " " + arguments[1]);
                                } else {
                                    ReportFunctions.LogRepoter("Fail", "wait for the element",
                                            "key not found in hashmap");
                                    Status = false;
                                }
                            }

                        }
                    }
                }
            }
            Thread.sleep(4000);

            WebElement locator = null;
            if (arguments[1].matches(".*:.*"))
            {

                  try {
                      locator = Getlocator(GlobalDriver, arguments[1]);
                  }
                  catch (StaleElementReferenceException e){
                      locator = Getlocator(GlobalDriver, arguments[1]);
                  }
                  finally {
                      locator = Getlocator(GlobalDriver, arguments[1]);
                  }




            }
            else {

                locator = getlocatorKeyValue(GlobalDriver, arguments[1]);

            }
            if (true) {
                if (arguments[3].toUpperCase().contains("SYSDATE"))
                {
//                    String sysdat = Sysdate(arguments[3]);
//                    locator.sendKeys(sysdat);
//                    System.out.println("Succesfully entered the Date" + " " + sysdat);
//                    ReportFunctions.LogRepoter("pass", "Entere the date in the feild",
//                            "Succesfully entered the Date" + sysdat);
//                    return true;
                } else if (hmap.containsKey(arguments[3])) {

                    String value = hmap.get(arguments[3]);
                    try {
                        locator.sendKeys(value);
                    }
                    catch (NoSuchElementException e)
                    {
                        locator.sendKeys(value);
                    }
                    System.out.println("Succesfully entered the value" + " " + value);
                    ReportFunctions.LogRepoter("pass", "Entere the value in the feild",
                            "Succesfully entered the value" + arguments[2] + " " + value);
                    return true;
                } else {
                    try {
                        locator.sendKeys(arguments[3]);
                    }
                    catch (NoSuchElementException e)
                    {
                        locator.sendKeys(arguments[3]);
                    }
                    System.out.println("Succesfully entered the value" + " " + arguments[3]);
                    ReportFunctions.LogRepoter("pass", "Entere the value in the feild",
                            "Succesfully entered the value" + arguments[2] + " " + " " + arguments[3]);
                    return true;
                }
            } else {
                System.out.println("not able to find" + " " + arguments[2]);
                ReportFunctions.LogRepoter("Fail", "Entere the value in the feild",
                        "not able to find text feild" + " " + arguments[2]);
                // CLOSEALLBROWSERS(driver);
                return false;
            }
        } catch (Exception e) {

            // e.printStackTrace();
            System.out.println("unable to find the locator" + " " + locator);
            ReportFunctions.LogRepoter("Fail", "Entere the value in the feild",
                    "unable to find the locator" + " " + arguments[1]);
            //CLOSEALLBROWSERS(driver);
            return false;
        }
        return true;
    }

// ************************************************************************************************************************
	/*
	 * Function Name: CLEARTEXTBOX
	 * It will clear the textbox on a webpage
	 * Author: Sahitya
	 */
// ************************************************************************************************************************ 

    public static boolean CLEARTEXTBOX(WebDriver WebDriver, String parameters) {
        String[] arguments = null;
        arguments = splitfunction(parameters, "\\->");
        if (arguments[1].contains("+")) 
        {
            String[] arguments1 = splitfunction(arguments[1], "+");
            String[] arguments2 = splitfunction(arguments1[1], "+");
            String newval = arguments2[0];
            if (hmap.containsKey(newval)) 
            {
                String revalue = hmap.get(newval);
                arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                if (arguments[1].contains("+")) 
                {
                    arguments1 = splitfunction(arguments[1], "+");
                    arguments2 = splitfunction(arguments1[1], "+");
                    newval = arguments2[0];
                    if (hmap.containsKey(newval)) {
                        revalue = hmap.get(newval);
                        arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                    } else {
                        ReportFunctions.LogRepoter("Fail", "wait for the element", "key not found in hashmap");
                        return false;
                    }
                }

            }
        }
        try {
            WebElement locator = Getlocator(driver, arguments[1]);
            if (locator.isEnabled()) {
                locator.clear();
                System.out.println("Succesfully cleared the text box");
                ReportFunctions.LogRepoter("pass", "clear the text box", "Succesfully cleared the text box");
                return true;
            } else {
                System.out.println("Text box was disabled");
                ReportFunctions.LogRepoter("Fail", "clear the  text box", "Text box was disabled");
                CLOSEALLBROWSERS(driver);
                return false;
            }
        } catch (Exception e) {

            //e.printStackTrace();
            System.out.println("unable to find the locator" + " " + locator);
            ReportFunctions.LogRepoter("Fail", "clear the  text box", "unable to find the locator" + " " + arguments[1]);
            CLOSEALLBROWSERS(driver);
            return false;
        }

    }
    
// ************************************************************************************************************************
	/*
	 * Function Name: CLICK
	 * It will click the particular element
	 * Author: Sahitya
	 */
// ************************************************************************************************************************    

    public static boolean CLICK( String parameters) throws Exception,StaleElementReferenceException {
        Thread.sleep(1000);
        Boolean Status = true;
        String[] arguments = null;
        arguments = splitfunction(parameters, "->");
        try {
//            if (arguments[1].contains("+")) {
//                String[] arguments1 = splitfunction(arguments[1], "+");
//                String[] arguments2 = splitfunction(arguments1[1], "+");
//                String newval = arguments2[0];
//                if (hmap.containsKey(newval)) {
//                    String revalue = hmap.get(newval);
//                    arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
//                    System.out.println("Succesfully clicked on" + " " + arguments[1]);
//                    if (arguments[1].contains("+")) {
//                        arguments1 = splitfunction(arguments[1], "+");
//                        arguments2 = splitfunction(arguments1[1], "+");
//                        newval = arguments2[0];
//                        if (hmap.containsKey(newval)) {
//                            revalue = hmap.get(newval);
//                            arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
//                            System.out.println("Succesfully clicked on" + " " + arguments[1]);
//                            if (arguments[1].contains("+")) {
//                                arguments1 = splitfunction(arguments[1], "+");
//                                arguments2 = splitfunction(arguments1[1], "+");
//                                newval = arguments2[0];
//                                if (hmap.containsKey(newval)) {
//                                    revalue = hmap.get(newval);
//                                    arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
//                                    System.out.println("Succesfully clicked on" + " " + arguments[1]);
//                                } else {
//                                    ReportFunctions.LogRepoter("Fail", "wait for the element",
//                                            "key not found in hashmap");
//                                    Status = false;
//                                }
//                            }
//
//                        }
//                    }
//                }
//            }
            //WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
           if (arguments[1].matches(".*:.*"))
           {



              locator = Getlocator(GlobalDriver, arguments[1]);// old method calling
               //ENTERVALUE(WebDriver,parameters);



            }
           else {

                locator = getlocatorKeyValue(GlobalDriver, arguments[1]); // object repository method calling
            }
           if (true)
           {
                Thread.sleep(3000);
                locator.click();
                System.out.println("Succesfully clicked on" + " " + arguments[2]);
                ReportFunctions.LogRepoter("pass", "click on the object", "Succesfully clicked on" + " " + arguments[2]);
            } else
            {
                System.out.println("unable to find" + " " + arguments[2]);
                ReportFunctions.LogRepoter("Fail", "click on the object", "unable to find" + " " + arguments[2]);
                //CLOSEALLBROWSERS(driver);
                Status = false;
                driver.close();
            }
        } catch (Exception e) {

            System.out.println("unable to find the locator" + " " + e.getMessage());
            Thread.sleep(2000);

            ReportFunctions.LogRepoter("Fail", "click on the object",
                    "unable to find the locator" + " ");
            System.out.println("hello");
                //CLOSEALLBROWSERS(driver);
               Status = false;
              // WebDriver.close();
        }
        return Status;

    }
    
    
     public static boolean JAVACLICK(WebDriver driver,String parameters) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, Exception, StaleElementReferenceException 
  {
    
      boolean Status = true;
           try {
          String[] arguments = null;

            arguments = splitfunction(parameters, "\\->");
        
          WebElement element = DriverScript.driver.findElement(By.xpath(arguments[1]));
        ((JavascriptExecutor) DriverScript.driver).executeScript("arguments[0].click();", new Object[]{element});
                 
      } catch (Exception e) 
      {
          System.out.println("exception value : " + e.getMessage());
          Status = false;
      }
      return Status;
  }
     
// ************************************************************************************************************************
	/*
	 * Function Name: DOUBLECLICK
	 * It is used for doubleclick on a element on webpage
	 * Author: Sahitya
	 */
// ************************************************************************************************************************     

    public static boolean DOUBLECLICK(WebDriver WebDriver, String parameters) throws InterruptedException, StaleElementReferenceException {
        Thread.sleep(3000);
        String[] arguments = null;
        arguments = splitfunction(parameters, "->");
        try {
            WebElement locator = Getlocator(driver, arguments[1]);
            Actions act = new Actions(WebDriver);
            if (locator.isEnabled()) {
                act.doubleClick(locator);
                System.out.println("Succesfully clicked on" + " " + arguments[2]);
                ReportFunctions.LogRepoter("pass", "double click on object", "Succesfully clicked on" + " " + arguments[2]);
                return true;
            } else {
                System.out.println("unable to find" + " " + arguments[2]);
                ReportFunctions.LogRepoter("Fail", "double click on object", "Application launched succesfully");
                CLOSEALLBROWSERS(driver);
                return false;
            }

        } catch (Exception e) {

            System.out.println("unable to find the locator" + " " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "double click on object", "unable to find the locator" + " " + arguments[2]);
            CLOSEALLBROWSERS(driver);
            return false;

        }

    }
    
// ************************************************************************************************************************
	/*
	 * Function Name: ALTERACTION
	 * It is used to cancel the popup
	 * Author: Sahitya
	 */
// ************************************************************************************************************************     

    public static boolean ALERTACTION(WebDriver WebDriver, String parameters) {
        try {
            String[] arguments = null;
            arguments = splitfunction(parameters, "->");
            Alert alert = WebDriver.switchTo().alert();
            if (arguments[1].equalsIgnoreCase("CANCEL")) {
                alert.dismiss();
                System.out.println("Clicked on cancel");
                ReportFunctions.LogRepoter("pass", "click on Alert", "succesfully clicked on cancel");
                return true;
            } else {
                alert.accept();
            }
            System.out.println("Alert Accepted");
            return true;
        } catch (Exception e) {

            System.out.println("unable to find the locator" + " " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "click on Alert", "succesfully clicked on Accept");
            CLOSEALLBROWSERS(driver);
            return false;
        }

    }
    
// ************************************************************************************************************************
	/*
	 * Function Name: CLOSEALLBROWSERS
	 * It is used to close all the browsers
	 * Author: Sahitya
	 */
// ************************************************************************************************************************     

    public static boolean CLOSEALLBROWSERS(WebDriver WebDriver) {
        try {
              
            //WebDriver.quit();
            WebDriver.close();
            System.out.println("successfully closed all browsers");
            //ReportFunctions.LogRepoter("pass", "close all browsers", "successfully closed all browsers");
            return true;

        } catch (Exception e) {

            System.out.println("unable to find the browser" + " " + e.getMessage());
            //ReportFunctions.LogRepoter("Fail", "close all browsers", "unable to close all browsers");
            return false;
        }

    }
    
// ************************************************************************************************************************
	/*
	 * Function Name: CLOSECURRENTBROWSER
	 * It is used to close the current browser
	 * Author: Sahitya
	 */
// ************************************************************************************************************************     

    public static boolean CLOSECURRENTBROWSER(WebDriver WebDriver) {
        try {

            WebDriver.close();
            System.out.println("successfully closed current window");
            ReportFunctions.LogRepoter("pass", "close current window", "successfully closed current window");
            return true;

        } catch (Exception e) {

            System.out.println("unable to find the locator" + " " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "close current window", "unable to close current window");
            CLOSEALLBROWSERS(driver);
            return false;
        }

    }
    
// ************************************************************************************************************************
	/*
	 * Function Name: CLOSEPOPUP
	 * It is used to close the popup
	 * Author: Sahitya
	 */
// ************************************************************************************************************************     

    public static boolean CLOSEPOPUP(WebDriver WebDriver) {
        try {
            WebDriverWait wait = new WebDriverWait(WebDriver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("close"))).click();
            System.out.println("Successfully closed the start Popup");
            ReportFunctions.LogRepoter("pass", "close pop up", "Successfully closed the start Popup");
            return true;
        } catch (Exception e) {

            System.out.println("unable to find the locator" + " " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "close pop up", "unable to close pop up");
            CLOSEALLBROWSERS(driver);
            return false;
        }

    }
    
// ************************************************************************************************************************
	/*
	 * Function Name: CLICKTAB
	 * It is used to click the tab
	 * Author: Sahitya
	 */
// ************************************************************************************************************************     

    public static boolean CLICKTAB(WebDriver WebDriver, String parameters) {
        try {
            String[] arguments = null;
            arguments = splitfunction(parameters, "->");
            WebElement locator = Getlocator(driver, arguments[1]);
            WebElement tab = locator;
            tab.click();
            ReportFunctions.LogRepoter("pass", "click on the tab", "succesfully clicked on the tab");
            return true;
        } catch (Exception e) {

            System.out.println("unable to find the locator" + " " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "click on the tab", "unable to click on the tab");
            CLOSEALLBROWSERS(driver);
            return false;
        }

    }
    
// ************************************************************************************************************************
	/*
	 * Function Name: SELECTIFRAMEBYINDEX
	 * It is used to select the iframe by the index value
	 * Author: Sahitya
	 */
// ************************************************************************************************************************     

    // * Function to Select frame by index. (Frame1: index=0 ;; Frame2: index=1)
    public static boolean SELECTIFRAMEBYINDEX(WebDriver webdriver, String parameters) {
        boolean status = false;
        String[] arguments = null;
        arguments = splitfunction(parameters, "->");
        try {
            webdriver.switchTo().frame(Integer.parseInt(arguments[1]));
            System.out.println("moved to Iframe with index:  " + arguments[1]);
            ReportFunctions.LogRepoter("Pass", "switch to frame by index", "successfully switched to window  " + arguments[1]);
            status = true;
        } catch (Exception e) {
            System.out.println("Iframe with index:" + arguments[1] + "  not found");
            ReportFunctions.LogRepoter("fail", "switch to frame by index", "failed switched to window  " + arguments[1]);
        }
        return status;

    }

// ************************************************************************************************************************
	/*
	 * Function Name: SWITCHTOWINDOW_Verify
	 * It is used to switch the control from one window to another/next window and verify
	 * Author: Sahitya
	 */
// ************************************************************************************************************************     
    public static boolean SWITCHTOWINDOW_Verify(WebDriver webdriver, String parameters)
    {
              boolean status = false;
              String[] arguments = null;
              String newval=null;
              arguments = splitfunction(parameters, "->");
//              if (arguments[1].contains("+")){
//                  String args[] = splitfunction(arguments[1], "+");
//                      if(hmap.containsKey(args[1] )){
//                       newval=hmap.get(args[1]);
//                       arguments[1]=arguments[1].replace(args[1],newval);
//                       arguments[1]=arguments[1].replace("+", "");
//                   }
//              }
              String xpath = arguments[1];
              System.out.println(xpath);
              //String label = arguments[2];
              
           try {
                        String mainWindowHandle = driver.getWindowHandle();
                        SWITCHWINDOW(driver, "SWITCHWINDOW->" + xpath);  
                        Thread.sleep(5000);
                        System.out.println("sucessfully verified the value in child window");
                        //driver.close();
                        System.out.println(driver.getCurrentUrl());
                        driver.switchTo().window(mainWindowHandle);
                        System.out.println(driver.getCurrentUrl());
                        System.out.println("sucessfully moved to parent window");
                      
                      ReportFunctions.LogRepoter("Pass", "switch to child window and verify", "sucessfully switched to child window and verified the value  " + arguments[2]);
                        status = true;
             }catch(Exception e)
                  {
                      ReportFunctions.LogRepoter("Fail", "switch to child window and verify", "failed to  switch to child window and verify value  " + arguments[2]);
                   }
              return status;
     }

// ************************************************************************************************************************
	/*
	 * Function Name: SELECTFRAME
	 * It is used to select frame by index value
	 * Author: Sahitya
	 */
// ************************************************************************************************************************     
    public static boolean SELECTFRAME(WebDriver WebDriver, String parameters) throws Exception {
        boolean flag = false;
        String[] arguments = null;
        arguments = splitfunction(parameters, "->");
        WebElement locpath = null;
        int size = driver.findElements(By.tagName("iframe")).size();
        for (int i = 0; i <= size; i++) {
            driver.switchTo().defaultContent();
            driver.switchTo().frame(i);
            locpath = Getlocator(driver, arguments[1]);
            
            try {
                if (locpath != null) {
                    flag = true;
                    System.out.println("Found the element in the frame  " + i);
                    ReportFunctions.LogRepoter("pass", "Select Frame", "Object found in frame  " + i);
                    flag = true;
                    Thread.sleep(2000);
                    break;
                }
            } catch (Exception e) {
                System.out.println("unable to switch to new frame");
            }
        }

        if (flag == false) {
            System.out.println("unable to find the locator");
            ReportFunctions.LogRepoter("fail", "Select Frame", "unable to find the locator");
            CLOSEALLBROWSERS(driver);
        }
        return flag;
    }

// ************************************************************************************************************************
	/*
	 * Function Name: WAITTIME
	 * It is used to wait for particular time given
	 * Author: Sahitya
	 */
// ************************************************************************************************************************ 
    
    public static boolean WAITTIME(String parameters) {
        String[] arguments = null;
        int sleepTime;
        arguments = splitfunction(parameters, "->");
        try {
            if (!arguments[1].isEmpty()) {
                if (hmap.containsKey(arguments[1])) {
                    String value = hmap.get(arguments[1]);
                    sleepTime = Integer.parseInt(value) * 1000;
                    System.out.println("Global Wait Time: " + sleepTime);
                    Thread.sleep(sleepTime);
                    return true;
                } else {
                    sleepTime = Integer.valueOf(arguments[1]) * 1000;
                    System.out.println("User Wait : " + sleepTime);
                    Thread.sleep(sleepTime);
                    //ReportFunctions.LogRepoter("pass", "wait time", "waited for" + sleepTime);
                    return true;
                }
            } else {

                return false;
            }
        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("pass", "wait time", "wait tme failed");
            return false;
        }

    }

// ************************************************************************************************************************
	/*
	 * Function Name: CHECKINGCHKBOX
	 * It is used for checking the check box whether the check box is clickable or not
	 * Author: Sahitya
	 */
// ************************************************************************************************************************ 
    public static boolean CHECKINGCHKBOX(WebDriver webdriver, String parameters) {
        boolean checkstatus;
        String[] arguments = null;
        arguments = splitfunction(parameters, "->");
        try {
            //WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);
            } else {

                locator = getlocatorKeyValue(driver, arguments[1]);
            }
            checkstatus = locator.isSelected();
            if (checkstatus == true) {
                System.out.println("Checkbox is already checked" + " " + arguments[2]);
                ReportFunctions.LogRepoter("Pass", "check the box", "Checkbox is already checked" + " " + arguments[2]);
                CLOSEALLBROWSERS(driver);
                return true;
            } else {
                locator.click();
                System.out.println("Checked the checkbox" + " " + arguments[2]);
                ReportFunctions.LogRepoter("pass", "check the box", "Checked the checkbox" + " " + arguments[2]);
                return true;
            }
        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "check the box", "unable to find check box");
            CLOSEALLBROWSERS(driver);
            return false;
        }

    }
    
// ************************************************************************************************************************
	/*
	 * Function Name: UNCHECKINGCHKBOX
	 * It is used for uncheck the check box whether the uncheck box is clickable or not
	 * Author: Sahitya
	 */
// ************************************************************************************************************************     

    //Uncheck check box
    public static boolean UNCHECKINGCHKBOX(WebDriver webdriver, String parameters) {
        boolean checkstatus;
        String[] arguments = null;
        arguments = splitfunction(parameters, "->");
        try {
            //WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);
            } else {

                locator = getlocatorKeyValue(driver, arguments[1]);
            }
            checkstatus = locator.isSelected();
            if (checkstatus == true) {
                locator.click();
                System.out.println("Checkbox is unchecked" + " " + arguments[2]);
                ReportFunctions.LogRepoter("pass", "uncheck the box", "Checkbox is unchecked" + " " + arguments[2]);
                return true;
            } else {
                System.out.println("Checkbox is already unchecked" + " " + arguments[2]);
                ReportFunctions.LogRepoter("Fail", "uncheck the box", "Checkbox is already unchecked" + " " + arguments[2]);
                CLOSEALLBROWSERS(driver);
                return false;
            }
        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "check the box", "unable to find check box");
            CLOSEALLBROWSERS(driver);
            return false;
        }

    }

// ************************************************************************************************************************
	/*
	 * Function Name: CHECKRADIOBTN
	 * It is used for check the radio button whether the radio button is clickable or not
	 * Author: Sahitya
	 */
// ************************************************************************************************************************      
    
    public static boolean CHECKRADIOBTN(WebDriver webdriver, String parameters) {
        boolean checkstatus;
        String[] arguments = null;
        arguments = splitfunction(parameters, "->");
        try {
            //WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);
            } else {

                locator = getlocatorKeyValue(driver, arguments[1]);
            }
            checkstatus = locator.isSelected();
            if (checkstatus == true) {
                System.out.println("Radio button is already checked" + " " + arguments[2]);
                ReportFunctions.LogRepoter("Pass", "check the radio button", "Radio button is already checked" + " " + arguments[2]);
                CLOSEALLBROWSERS(driver);
                return false;
            } else {
                locator.click();
                System.out.println("Checked the Radio button" + " " + arguments[2]);
                ReportFunctions.LogRepoter("Pass", "check the radio button", "Checked the Radio button" + " " + arguments[2]);
                return true;
            }
        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "check the radio button", "unable to find radio button");
            CLOSEALLBROWSERS(driver);
            return false;
        }

    }

// ************************************************************************************************************************
	/*
	 * Function Name: UNCHECKRADIOBTN
	 * It is used for uncheck the radio button whether the radio button is clickable or not
	 * Author: Sahitya
	 */
// ************************************************************************************************************************ 
    
    public static boolean UNCHECKRADIOBTN(WebDriver webdriver, String parameters) {
        boolean checkstatus;
        String[] arguments = null;
        arguments = splitfunction(parameters, "->");
        try {
            //WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);
            } else {

                locator = getlocatorKeyValue(driver, arguments[1]);
            }
            checkstatus = locator.isSelected();
            if (checkstatus == true) {
                locator.click();
                System.out.println("Checked the Radio button " + " " + arguments[2]);
                ReportFunctions.LogRepoter("Pass", "Uncheck the radio button", "Unchecked the Radio button" + " " + arguments[2]);
                return true;
            } else {
                System.out.println("Radio button is already unchecked" + " " + arguments[2]);
                ReportFunctions.LogRepoter("Pass", "Uncheck the radio button", "Radio button is already unchecked" + " " + arguments[2]);
                CLOSEALLBROWSERS(driver);
                return false;
            }
        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "check the radio button", "unable to find radio button");
            CLOSEALLBROWSERS(driver);
            return false;
        }

    }
    
// ************************************************************************************************************************
	/*
	 * Function Name: SELECTVALUEBYDROPDOWN
	 * It is used ti select given value from the dropdown
	 * Author: Sahitya
	 */
// ************************************************************************************************************************     

    public static boolean SELECTVALUEDROPDOWN(WebDriver webdriver, String parameters) throws InterruptedException {
        Thread.sleep(3000);
        String[] arguments = null;
        boolean checkstatus = false;
        String sValue = null;
        arguments = splitfunction(parameters, "->");
        if ((hmap.containsKey(arguments[3]) == true)) {
            arguments[3] = hmap.get(arguments[3]);
        }

        try {
            //WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);// old method calling
            } else {

                locator = getlocatorKeyValue(driver, arguments[1]); // object repository method calling
            }
            Select oSelect = new Select(locator);
            List<WebElement> elementCount = oSelect.getOptions();
            int iSize = elementCount.size();
            for (int i = 0; i < iSize; i++) {
                sValue = elementCount.get(i).getText();
                System.out.println(sValue);
                if (sValue.equalsIgnoreCase(arguments[3])) {
                    checkstatus = true;
                    if (ISNUMERIC(arguments[3])) {
                        if (arguments[3].length() == 1) {
                            int oindex = Integer.parseInt(arguments[3]);
                            oSelect.selectByIndex(oindex);
                            System.out.println("Selected the element with index " + " " + arguments[3]);
                            ReportFunctions.LogRepoter("pass", "select value from drop down with index", "Selected the element with index " + " " + arguments[3]);
                        } else {
                            oSelect.selectByValue(arguments[3]);
                            System.out.println("Selected the value " + " " + arguments[3]);
                            ReportFunctions.LogRepoter("pass", "select value from drop down with value", "Selected the element with index " + " " + arguments[3]);
                        }

                    } else {
                        oSelect.selectByVisibleText(arguments[3]);
                        System.out.println("Selected the text" + " " + arguments[3]);
                        ReportFunctions.LogRepoter("pass", "select value from drop down with visibletext", "Selected the element with index " + " " + arguments[3]);
                    }
                    break;
                }
            }
            if (checkstatus != true) {
                System.out.println("unable to find the element" + " " + arguments[3]);
                ReportFunctions.LogRepoter("Fail", "select value from drop down", "unable to find the element" + " " + arguments[3]);
                CLOSEALLBROWSERS(driver);
            }

        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "select value from drop down", "unable to find the element" + " " + arguments[3]);
            CLOSEALLBROWSERS(driver);
        }
        return checkstatus;

    }
    
// ************************************************************************************************************************
	/*
	 * Function Name: SelectvalueByIndex
	 * It is used to select the given value by index
	 * Author: Sahitya
	 */
// ************************************************************************************************************************ 
    
    public static boolean SelectvalueByIndex(WebDriver webdriver, String parameters) throws InterruptedException {
        Thread.sleep(3000);
        String[] arguments = null;
        boolean checkstatus = false;
        String sValue = null;
        arguments = splitfunction(parameters, "->");
        try {
            //WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);
            } else {

                locator = getlocatorKeyValue(driver, arguments[1]);
            }
            Select oSelect = new Select(locator);

            if (locator != null) {
                int oindex = Integer.parseInt(arguments[3]);
                oSelect.selectByIndex(oindex);
                System.out.println("Selected the element with index " + " " + arguments[3]);
                ReportFunctions.LogRepoter("pass", "select value from drop down with index", "Selected the element with index " + " " + arguments[3]);
                checkstatus = true;
            }
        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "select value from drop down", "unable to find the element" + " " + arguments[3]);
            CLOSEALLBROWSERS(driver);
        }
        return checkstatus;

    }
     

    public static boolean ISNUMERIC(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean ISDISPLAYED(WebDriver webdriver, String parameters) {

        String[] arguments = null;
        arguments = splitfunction(parameters, "->");
        try {
            //WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);
            } else {

                locator = getlocatorKeyValue(driver, arguments[1]);
            }
            boolean status = locator.isDisplayed();
            if (status == true) {
                System.out.println("Object displayed on web page" + " " + arguments[2]);
                ReportFunctions.LogRepoter("pass", "object display", "Object displayed on web page" + " " + arguments[2]);
                return true;
            } else {
                System.out.println("Object was not displayed on web page" + " " + arguments[2]);
                ReportFunctions.LogRepoter("Fail", "object display", "Object was not displayed on web page" + " " + arguments[2]);
                CLOSEALLBROWSERS(driver);
                return false;
            }
        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "object display", "Object was not displayed on web page" + " " + e.getMessage());
            CLOSEALLBROWSERS(driver);
            return false;
        }

    }

    public static boolean ISENABLED(WebDriver webdriver, String parameters) {
        String[] arguments = null;
        arguments = splitfunction(parameters, "->");
        try {
            //WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);
            } else {

                locator = getlocatorKeyValue(driver, arguments[1]);
            }
            boolean status = locator.isEnabled();
            if (status == true) {
                System.out.println("Object is enabled" + " " + arguments[2]);
                ReportFunctions.LogRepoter("pass", "object enable", "Object is enabled" + " " + arguments[2]);
                return true;
            } else {
                System.out.println("Object was not enabled" + " " + arguments[2]);
                ReportFunctions.LogRepoter("Fail", "object enable", "Object was not  enabled" + " " + arguments[2]);
                CLOSEALLBROWSERS(driver);
                return false;
            }
        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "object enable", "unable to find the element");
            CLOSEALLBROWSERS(driver);
            return false;
        }

    }

    public static boolean ISDISABLED(WebDriver webdriver, String parameters) {
        try {
            String[] arguments = null;
            arguments = splitfunction(parameters, "->");
            //WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);
            } else {

                locator = getlocatorKeyValue(driver, arguments[1]);
            }
            boolean status = locator.isEnabled();
            if (status == false) {
                System.out.println("Object is disabled" + " " + arguments[2]);
                ReportFunctions.LogRepoter("pass", "object disable", "Object is disabled" + " " + arguments[2]);
                return true;
            } else {
                System.out.println("Object was not disabled" + " " + arguments[2]);
                ReportFunctions.LogRepoter("Fail", "object disable", "Object is disabled" + " " + arguments[2]);
                CLOSEALLBROWSERS(driver);
                return false;
            }
        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "object disable", "unable to find the element");
            CLOSEALLBROWSERS(driver);
            return false;
        }

    }

    public static boolean ISSELECTED(WebDriver webdriver, String parameters) {
        try {
            String[] arguments = null;
            arguments = splitfunction(parameters, "->");
            //WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);
            } else {

                locator = getlocatorKeyValue(driver, arguments[1]);
            }
            boolean status = locator.isSelected();
            if (status == true) {
                System.out.println("current object is selected" + " " + arguments[2]);
                ReportFunctions.LogRepoter("pass", "select the object", "current object is selected" + " " + arguments[2]);
                return true;
            } else {
                System.out.println("current object was not selected" + " " + arguments[2]);
                ReportFunctions.LogRepoter("Fail", "select the object", "current object was not selected" + " " + arguments[2]);
                CLOSEALLBROWSERS(driver);
                return false;
            }
        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "select the object", "unable to find the object");
            CLOSEALLBROWSERS(driver);
            return false;
        }

    }

    public static String GETTEXTo(WebDriver webdriver, String parameters) {
        String ovalue = null;
        try {
            String[] arguments = null;
            arguments = splitfunction(parameters, "->");
            WebElement locator = Getlocator(driver, arguments[1]);
            ovalue = locator.getText();
            //System.out.println("Retrived the value" +" "+ovalue);
        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
        }

        return ovalue;
    }

    public static boolean GETTEXT(WebDriver webdriver, String parameters) {
        String ovalue = null;
        String key;

        try {
            String[] arguments = null;
            arguments = splitfunction(parameters, "->");
            key = arguments[3];
            if (arguments[1].contains("+")) {
                String[] arguments1 = splitfunction(arguments[1], "+");
                String[] arguments2 = splitfunction(arguments1[1], "+");
                String newval = arguments2[0];
                if (hmap.containsKey(newval)) {
                    String revalue = hmap.get(newval);
                    arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                    System.out.println("Succesfully clicked on" + " " + arguments[1]);
                    if (arguments[1].contains("+")) {
                        arguments1 = splitfunction(arguments[1], "+");
                        arguments2 = splitfunction(arguments1[1], "+");
                        newval = arguments2[0];
                        if (hmap.containsKey(newval)) {
                            revalue = hmap.get(newval);
                            arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                            System.out.println("Succesfully clicked on" + " " + arguments[1]);
                            if (arguments[1].contains("+")) {
                                arguments1 = splitfunction(arguments[1], "+");
                                arguments2 = splitfunction(arguments1[1], "+");
                                newval = arguments2[0];
                                if (hmap.containsKey(newval)) {
                                    revalue = hmap.get(newval);
                                    arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                                    System.out.println("Succesfully clicked on" + " " + arguments[1]);
                                } else {
                                    ReportFunctions.LogRepoter("Fail", "wait for the element", "key not found in hashmap");
                                    return false;
                                }
                            }

                        }
                    }
                }
            }

            //WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);// old method calling
            } else {

                locator = getlocatorKeyValue(driver, arguments[1]); // object repository method calling
            }
            ovalue = locator.getAttribute("value");
            if (ovalue == null) {
                ovalue = locator.getText();
            }
            if (ovalue != null) {
                //added by Satish
                hmap.put(key, ovalue);
                captureVariableData(key, ovalue);
                System.out.println("captured the value" + "  " + arguments[2] + "   " + ovalue);
                ReportFunctions.LogRepoter("pass", "capture the text", "captured the value" + "  " + arguments[2] + "   " + ovalue);
                return true;
            } else {
                System.out.println("value is null" + " " + ovalue);
                ReportFunctions.LogRepoter("Fail", "capture the text", " unable to capture the value" + "  " + arguments[2]);
                //CLOSEALLBROWSERS(driver);
                return false;
            }

        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "capture the text", " unable to locate the element");
            //CLOSEALLBROWSERS(driver);
            return false;
        }

    }

    public static boolean GETATTRIBUTE(WebDriver webdriver, String parameters) {
        String ovalue = null;
        String key;
        try {
            String[] arguments = null;
            arguments = splitfunction(parameters, "->");
            key = arguments[3];
            //WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);
            } else {

                locator = getlocatorKeyValue(driver, arguments[1]);
            }
            ovalue = locator.getAttribute(arguments[2]);
            if (ovalue != null) {
                hmap.put(key, ovalue);
                captureVariableData(key, ovalue);
                System.out.println("captured the value" + "  " + arguments[2] + "   " + ovalue);
                ReportFunctions.LogRepoter("pass", "capture the text",
                        "captured the value" + "  " + arguments[2] + "   " + ovalue);
                return true;
            } else {
                System.out.println("value is null" + " " + ovalue);
                ReportFunctions.LogRepoter("Fail", "capture the text",
                        " unable to capture the value" + "  " + arguments[2]);
                CLOSEALLBROWSERS(driver);
                return false;
            }

        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "capture the text", " unable to locate the element");
            CLOSEALLBROWSERS(driver);
            return false;
        }

    }

    public static boolean VERIFYVALUE(WebDriver webdriver, String parameters) {
        flag = 1;
        String[] arguments = null;
        arguments = splitfunction(parameters, "->");
        String value = null;
        try {

            if (arguments[1].contains("+")) {
                String[] arguments1 = splitfunction(arguments[1], "+");
                String[] arguments2 = splitfunction(arguments1[1], "+");
                String newval = arguments2[0];
                if (hmap.containsKey(newval)) {
                    String revalue = hmap.get(newval);
                    arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                    if (arguments[1].contains("+")) {
                        arguments1 = splitfunction(arguments[1], "+");
                        arguments2 = splitfunction(arguments1[1], "+");
                        newval = arguments2[0];
                        if (hmap.containsKey(newval)) {
                            revalue = hmap.get(newval);
                            arguments[1] = arguments[1].replace("+" + newval + "+", revalue);

                        } else {
                            ReportFunctions.LogRepoter("Fail", "wait for the element", "key not found in hashmap");
                            return false;
                        }
                    }

                }
            }
            //WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);
            } else {

                locator = getlocatorKeyValue(driver, arguments[1]);
            }
            String ovalue = locator.getAttribute("value");
            if (ovalue == null) {
                ovalue = locator.getText();
            }
            if (hmap.containsKey(arguments[3])) {
                value = hmap.get(arguments[3]);
            } else if (arguments[3].toUpperCase().contains("SYSDATE")) {
                String sysdat = Sysdate(arguments[3]);
                value = sysdat;
            } else if ((arguments[3].contains("+"))) {

                String[] values = splitfunction(arguments[3], "+");
                if (values.length > 1) {
                    if ((hmap.containsKey(values[0]))
                            && (hmap.containsKey(values[1]) && (hmap.containsKey(values[2])))) {
                        Float firstval = Float.parseFloat(hmap.get(values[0]));
                        Float Secval = Float.parseFloat(hmap.get(values[1]));
                        Float thirdval = Float.parseFloat(hmap.get(values[2]));
                        value = String.valueOf(firstval + Secval + thirdval);
                        hmap.put(arguments[2], value);
                    } else {
                        if ((hmap.containsKey(values[0])) && (hmap.containsKey(values[1]))) {
                            Float firstval = Float.parseFloat(hmap.get(values[0]));
                            Float Secval = Float.parseFloat(hmap.get(values[1]));
                            value = String.valueOf(firstval + Secval);
                            hmap.put(arguments[2], value);
                        }
                    }
                } else {
                    ReportFunctions.LogRepoter("Fail", "verify Value", "Failed to find values in ");
                }
            } else if ((arguments[3].contains("*"))) {

                String[] values = splitfunction(arguments[3], "*");
                if ((hmap.containsKey(values[0])) && (hmap.containsKey(values[1]))) {
                    Float firstval = Float.parseFloat(hmap.get(values[0]));
                    Float Secval = Float.parseFloat(hmap.get(values[1]));
                    value = String.valueOf(firstval * Secval);
                } else {
                    ReportFunctions.LogRepoter("Fail", "verify Value", "Failed to find values in ");
                }
            } else {
                value = arguments[3];
            }
            if (value.equalsIgnoreCase("IS NOT NULL")) {
                int len = ovalue.length();
                if (len > 0) {
                    ReportFunctions.LogRepoter("pass", "verify Value_Notnull",
                            "captured the value:  " + ovalue + " and its not null");
                } else {
                    ReportFunctions.LogRepoter("Fail", "verify Value_Notnull", "captured value is null");
                    flag = 0;

                }
            } else {
                if (ovalue.equalsIgnoreCase(value)) {
                    System.out.println("Both values mathes");
                    ReportFunctions.LogRepoter("pass", "verified  " + arguments[2] + "  value",
                            "Both values matches " + ovalue + " and " + value);
                } else {
                    System.out.println("Values did not match");
                    ReportFunctions.LogRepoter("Fail", "verified  " + arguments[2] + "  value",
                            "Both values did not match " + ovalue + " and " + value);
                    // CLOSEALLBROWSERS(driver);
                    flag = 0;
                }
            }
        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "verify both values", "unable to find the locator");
            // CLOSEALLBROWSERS(driver);
            flag = 0;
        }
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean SELECTPARENTWINDOW(WebDriver webdriver) {
        try {
            String Parent_Window = driver.getWindowHandle();
            System.out.println("Parent Window"+Parent_Window);
            System.out.println("Title "+driver.getTitle());
            driver.switchTo().window(Parent_Window);
            System.out.println("moved to parent window " + Parent_Window);
            ReportFunctions.LogRepoter("pass", "switch the parent window", "moved to parent window " + Parent_Window);
            return true;
        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "switch the window", "unable to find parent window");
            CLOSEALLBROWSERS(driver);
            return false;
        }

    }
     
    
    //Sahitya
    public static boolean SWTCHANDVERIFYINCHILDWINDOW(WebDriver webdriver) {
        try {
            String Parent_Window = driver.getWindowHandle();    

                    //get address of all windows
                        Set<String> allWH = driver.getWindowHandles();

                     //get address of all windows and store it in ArrayList
                          ArrayList<String> allWHCopy = new ArrayList<String>(allWH);

                     //close the 2nd window
                            for(int i=0;i<allWHCopy.size();i++)
                               {
                                  if(i==1)
                                  {
                                     driver.switchTo().window(allWHCopy.get(i));
                                     System.out.println("Child URL "+driver.getCurrentUrl());
                                    // JavascriptExecutor js = (JavascriptExecutor) driver;
                  //  js.executeScript("arguments[0].setAttribute('style', 'background : yellow;');","//button[contains(text(),'Download')]");
                                     driver.findElement(By.xpath("//button[contains(text(),'Download')]")).click();
                                     Thread.sleep(10000);
                    driver.findElement(By.xpath("//span[@class=\"ui-button-icon ui-icon ui-icon-athena-zoom-out\"]")).click();
                    driver.findElement(By.xpath("//span[@class=\"ui-button-icon ui-icon ui-icon-athena-zoom-out\"]")).click();                
                    driver.findElement(By.xpath("//span[@class=\"ui-button-icon ui-icon ui-icon-athena-zoom-out\"]")).click();                 
                    driver.findElement(By.xpath("//span[@class=\"ui-button-icon ui-icon ui-icon-athena-zoom-out\"]")).click();                 
                    driver.findElement(By.xpath("//span[@class=\"ui-button-icon ui-icon ui-icon-athena-zoom-out\"]")).click();       
                    driver.findElement(By.xpath("//span[@class=\"ui-button-icon ui-icon ui-icon-athena-zoom-out\"]")).click();
                    driver.findElement(By.xpath("//span[@class=\"ui-button-icon ui-icon ui-icon-athena-zoom-out\"]")).click();
                    driver.findElement(By.xpath("//span[@class=\"ui-button-icon ui-icon ui-icon-athena-zoom-out\"]")).click();
                    driver.findElement(By.xpath("//span[@class=\"ui-button-icon ui-icon ui-icon-athena-zoom-out\"]")).click();
                    driver.findElement(By.xpath("//span[@class=\"ui-button-icon ui-icon ui-icon-athena-zoom-out\"]")).click();
                                     //driver.close();
                                     Thread.sleep(5000);
                                  }
                               }

                              //To switch to main window
                     System.out.println("Parent Window"+Parent_Window);
                     System.out.println("Title "+driver.getTitle());
                     
                      driver.switchTo().window(Parent_Window);
                      System.out.println("Current Parent URL"+driver.getCurrentUrl());
                      ReportFunctions.LogRepoter("pass", "switch the parent window", "moved to parent window " + Parent_Window);
            return true;
        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "switch the window", "unable to find parent window");
            //CLOSEALLBROWSERS(driver);
            return false;
        }

    }
   
     
    public static boolean SWITCHWINDOW(WebDriver webdriver, String parameters) throws InterruptedException 
    {
        String exptitle = null;
        WebElement locpath = null;
        boolean status = true;
        Thread.sleep(4000);
        flag = 0;
        try {
            String[] arguments = null;
            arguments = splitfunction(parameters, "->");
            exptitle = arguments[1];

            Set<String> allWindowHandles = driver.getWindowHandles();                          

            for (String handle : allWindowHandles) 
            {
                driver.switchTo().window(handle);
                locpath = Getlocator(driver, arguments[1]);
                if (locpath != null) 
                {
                    driver.switchTo().window(handle);
                    System.out.println("moved to child window");
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].setAttribute('style', 'background : yellow;');",locpath);
                    ReportFunctions.LogRepoter("pass", "switch to child window", "moved to child  window ");
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                status = true;
            } else {
                System.out.println("unable to find window" + " " + exptitle);
                ReportFunctions.LogRepoter("Fail", "switch to child window", "unable to find  child  window " + exptitle);
                CLOSEALLBROWSERS(driver);
                status = false;
            }

        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "switch to child window", "unable to find  child  window ");
            CLOSEALLBROWSERS(driver);
        }
        return status;

    }
    
    

    public static void funchashmap(String args[]) {

        //HashMap<Integer,String> hmap=new HashMap<Integer,String>();
        hmap.put("key1", "murali");
        hmap.put("key2", "krishna");
        hmap.put("key3", "pentakota");

        System.out.println("Retrieving values from HashMap");
        System.out.println("**********************\n\n");
        //Set keys = hmap.keySet();
        //Iterator itr = keys.iterator();
        String value;
        value = hmap.get("key1");
        System.out.println(value);
        /* while(itr.hasNext())
        {
            key = (String)itr.next();
            value = (String)hmap.get(key);
            System.out.println(key + " - "+ value);
        }*/

    }

    public static void Readenvironmentalfile(String path) throws IOException {
        Sheet envsheet;
        String FilePath = path;
        FileInputStream envfs = new FileInputStream(FilePath);
        Workbook envwb = new XSSFWorkbook(envfs);
        envsheet = envwb.getSheetAt(0);
        //envwb.setMissingCellPolicy(Row.CREATE_NULL_AS_BLANK);
        int envrowcount = envsheet.getLastRowNum();
        int envcolcount = envsheet.getRow(envrowcount).getLastCellNum();
        int Rowval = 1;
        int colval = 1;

        String strenvname = "";
        String strenvvalue = "";

        for (Rowval = 1; Rowval <= envrowcount; Rowval++) {
            Row ro = envsheet.getRow(Rowval);

            if ((ro != null)) {
                Cell cell1 = envsheet.getRow(Rowval).getCell(0);
                Cell cell2 = envsheet.getRow(Rowval).getCell(1);
                strenvname = cell1.getStringCellValue();
                strenvname.trim();
                strenvvalue = cell2.getStringCellValue();
                strenvvalue.trim();
                if (strenvname.contains("#")) {
                    Rowval++;
                } else if (strenvname != null && strenvvalue != null) {
                    hmap.put(strenvname, strenvvalue);
                }
            } else {
                System.out.println("value is null" + " " + strenvname);
                System.out.println("value is null" + " " + strenvvalue);
            }
        }

    }

    public static void Readtestsuitefile(String path) throws Throwable {
        try {
            String Filepath = path;
            Sheet suiteheet;
            String CellData = null;
            int finval = 0;
            FileInputStream fs = new FileInputStream(Filepath);
            Workbook wb = new XSSFWorkbook(fs);
            suiteheet = wb.getSheetAt(0);
//			wb.setMissingCellPolicy(Row.CREATE_NULL_AS_BLANK);
            int rowcount = suiteheet.getLastRowNum();
            int colcount = suiteheet.getRow(rowcount).getLastCellNum();
            int Rowval = 0;
            int colval = 1;
            do {
                for (colval = 0; colval <= colcount - 1; colval++) {
                    Row ro = suiteheet.getRow(Rowval);
                    if (ro != null) {
                        Cell cell = suiteheet.getRow(Rowval).getCell(colval);
                        int cel_Type = cell.getCellType();
                        if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                        } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                            CellData = cell.getStringCellValue();
                            CellData.trim();
                            if (cell.getRichStringCellValue().getString().trim().equalsIgnoreCase("Send Mail")) {
                                cell = suiteheet.getRow(Rowval).getCell(colval + 1);
                                if (cell.getRichStringCellValue().getString().trim().equalsIgnoreCase("YES")) {
                                    sendmail = true;
                                }
                            }

                            if (cell.getRichStringCellValue().getString().trim().equalsIgnoreCase("Release Name")) {
                                cell = suiteheet.getRow(Rowval).getCell(colval + 1);
                                releasename = cell.getStringCellValue();
                            }

                            if (cell.getRichStringCellValue().getString().trim().equalsIgnoreCase("Environment")) {
                                cell = suiteheet.getRow(Rowval).getCell(colval + 1);
                                environmentname = cell.getStringCellValue();
                            }

                            if (cell.getRichStringCellValue().getString().trim().equals("Test Case Name")) {
                                int j = 1;
                                for (int i = Rowval + 1; i <= rowcount; i++) {

                                    cell = suiteheet.getRow(i).getCell(0);
                                    Cell cell1 = suiteheet.getRow(i).getCell(colval + 2);
                                    if (cell1.getRichStringCellValue().getString().trim().toUpperCase().equals("YES")) {
                                        Tcasecount = Tcasecount + 1;
                                        cell1 = suiteheet.getRow(i).getCell(colval);
                                        TChmap.put(cell.getRichStringCellValue().getString(), j);
                                        j = j + 1;
                                    }
                                }
                                finval = Rowval + 1;
                                Rowval = rowcount + 1;
                                fcolval = colval;
                                break;
                            }
                        }
                    }

                }
                Rowval = Rowval + 1;
            } while (rowcount + 1 > Rowval);
            for (Rowval = finval; Rowval <= rowcount; Rowval++) {
                Row r1 = suiteheet.getRow(Rowval);
                if (r1 != null) {
                    Cell cell = suiteheet.getRow(Rowval).getCell(fcolval + 1);
                    Cell status = suiteheet.getRow(Rowval).getCell(fcolval + 2);
                    Cell casename = suiteheet.getRow(Rowval).getCell(fcolval);
                    Cell muldata = suiteheet.getRow(Rowval).getCell(fcolval + 3);
                    Tcasename = casename.getStringCellValue();
                    if (Tcasename.equalsIgnoreCase("ReadTestData")) {
                        Readenvironmentalfile(cell.getStringCellValue());
                        storedataflag = false;
                    } else if (Tcasename.equalsIgnoreCase("CreateTestData")) {
                        storedataflag = true;
                    } else {
                        muldatastatus = muldata.getStringCellValue();
                        if (Tcase == null) {
                            Tcase = "Tcase";
                        }
                        hmap.put(Tcase, Tcasename);

                          SCellData = cell.getStringCellValue();
                        String cellstatus = status.getStringCellValue();
                        if (cellstatus.equalsIgnoreCase("Yes"))
                        {
                           DriverScript.Initializationscript(SCellData);
                        }
                    }
                }
            }
            if (sendmail == true) {
                Automation_Summary();
                Automation_Sanity_Summary();
                if (storedataflag == true) {
                    Store_data();
                    Store_data();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportFunctions.LogRepoter("Fail", "Script stopped abnormally", "" + e.getMessage());
            if (sendmail == true) {
                Automation_Summary();
                Automation_Sanity_Summary();
                if (storedataflag == true) {
                    Store_data();
                }
            }
        }
    }

    public static String selectfile() throws IOException {

        String filePath = null;
        JFileChooser chooser = new JFileChooser();

        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")+"/TestSuites"));
        
        int returnValue = chooser.showOpenDialog(null);
        java.io.File file = null;
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
        }
        if (file != null) {
            filePath = file.getPath();
            Tsuitename = file.getName();
            Tsuitename = Tsuitename.replace(".xlsx", "");
            if (suitename == null) {
                suitename = "suitename";
            }
            hmap.put(suitename, Tsuitename);
            FOLDERSTRUCTURE(Tsuitename);

        } else {
            System.out.println("File not selected");
        }
        return filePath;
    }

    public static boolean WAITFORELEMENT(WebDriver WebDriver, String parameters) throws Exception {
        boolean status = true;
        try {
            int flag = 1;
            String[] arguments = null;
            arguments = splitfunction(parameters, "->");
            if (arguments[1].contains("+")) {
                String[] arguments1 = splitfunction(arguments[1], "+");
                String[] arguments2 = splitfunction(arguments1[1], "+");
                String newval = arguments2[0];
                if (hmap.containsKey(newval)) {
                    String revalue = hmap.get(newval);
                    arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                    if (arguments[1].contains("+")) {
                        arguments1 = splitfunction(arguments[1], "+");
                        arguments2 = splitfunction(arguments1[1], "+");
                        newval = arguments2[0];
                        if (hmap.containsKey(newval)) {
                            revalue = hmap.get(newval);
                            arguments[1] = arguments[1].replace("+" + newval + "+", revalue);

                        } else {
                            ReportFunctions.LogRepoter("Fail", "wait for the element", "key not found in hashmap");
                            return false;
                        }
                    }

                }
            }
            if (arguments.length > 3) {
                if (hmap.containsKey(arguments[3])) {
                    String value = hmap.get(arguments[3]);
                    timer = Integer.parseInt(value) * 1000;
                    System.out.println("wait for element from variable: " + timer);
                    Thread.sleep(timer);
                } else {
                    timer = Integer.parseInt(arguments[3]) * 1000;
                    System.out.println("wait for element from user : " + timer);
                }
            } else {
                timer = 5000;
                System.out.println("wait for element Default : " + timer);
            }
            do {
                //WebElement locator = Getlocator(driver, arguments[1]);
                WebElement locator = null;
                if (arguments[1].matches(".*:.*")) {
                    locator = Getlocator(WebDriver, arguments[1]);
                } else {

                    locator = getlocatorKeyValue(driver, arguments[1]);
                }
                if (locator == null) {
                    timer = timer - 1;
                    if (timer == 0) {
                        timer = 5001;
                    }
                } else {
                    if (locator.isDisplayed()) {
                        timer = 5001;
                        flag = 0;
                        System.out.println("Element found" + " " + arguments[2]);
                        //JavascriptExecutor js = (JavascriptExecutor) driver;
                        //js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", locator);
                        ReportFunctions.LogRepoter("pass", "wait for the element", "Element found " + arguments[2]);
                    } else {
                        timer = timer - 1;
                        if (timer == 0) {
                            timer = 5001;
                        }
                    }
                }
            } while (timer < 5000);

            if (flag == 1) {
                status = false;
                ReportFunctions.LogRepoter("Fail", "wait for the element", "element not found " + arguments[2]);
                //CLOSEALLBROWSERS(driver);
            }
        } catch (StaleElementReferenceException e) 
        
        {
            System.out.println(e.getMessage());
            status = false;
            ReportFunctions.LogRepoter("Fail", "wait for the element", "did not found the element " + e);
            //CLOSEALLBROWSERS(driver);
        }
        return status;

    }

    public static void FOLDERSTRUCTURE(String suitename) throws IOException {
        final long MSEC_SINCE_EPOCH = System.currentTimeMillis();
        String workingDirectory = new java.io.File(".").getCanonicalPath();
        String opath = workingDirectory;
        opath = opath.replace("IRScripts", "");
        opath = opath.replace('\\', '/');
        //System.out.println(opath);
//		opath = opath.replace("IRScripts","");

        //envfilepath =  dname+"TestFlowBot-Selenium/Environmental files/EnvironmentVariables.xlsx";
        envfilepath = opath + "/EnvironmentalFiles/EnvironmentVariables.xlsx";
        File srcDir = new File(opath + "/HTMLTemplates/");
        File destDir = new File(opath + "/Reports/");
        //Calendar calendar = Calendar.getInstance();
        //Date  now = calendar.getTime();
        Date instant = new Date(MSEC_SINCE_EPOCH);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd:hh:mm:ss");
        String time = sdf.format(instant);
        time = time.replace(':', '-');
        suitename = suitename + "_" + time;
        File dir = new File(opath + "/Reports/" + suitename);
        dir.mkdir();
        FileUtils.copyDirectory(srcDir, dir);
        savedlocation = opath + "/Reports/" + suitename;

    }

    public static boolean VERIFYTABLEVALUE(WebDriver webdriver, String parameters) {
        boolean status = false;
        String[] arguments = null;
        arguments = splitfunction(parameters, "->");
        //WebElement locator = Getlocator(driver,arguments[1]);
        List<WebElement> iRows = driver.findElements(By.xpath(arguments[1]));
        try {
            int rcount = iRows.size();
            //List<WebElement> iColumns = driver.findElements(By.xpath(colpath));
            //int iColCount = iColumns.size();
            if (rcount == 1)
            {
                System.out.println(rcount);
                System.out.println("employee successfully added");
                ReportFunctions.LogRepoter("pass", "verify number of rows", "number of rows equal to one");
                status = true;
            } else 
            {
                //System.out.println(rcount);
                ReportFunctions.LogRepoter("Fail", "verify number of rows", "number of rows not equal to one");
                CLOSEALLBROWSERS(driver);
            }

        } catch (NumberFormatException e) {
            System.out.println("unable to find the locator" + " " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "verify number of rows", "unable to find the locator");
            CLOSEALLBROWSERS(driver);
        }
        return status;

    }

    public static boolean VERIFYREQUISITIONID(WebDriver webdriver, String parameters) {

        boolean status = false;
        try {
            String stext = GETTEXTo(webdriver, parameters);
            String[] arguments = null;
            arguments = splitfunction(parameters, "->");
            String Rid = hmap.get(arguments[2]);
            if (stext.equalsIgnoreCase(Rid)) {
                System.out.println("values matched");
                ReportFunctions.LogRepoter("pass", "verify requistion iD", "values matched:" + " " + " captuted value:" + " " + Rid + " " + "Actual value:" + " " + stext);
                status = true;
            } else {
                System.out.println("values did not match matched");
                ReportFunctions.LogRepoter("Fail", "verify requistion iD", "values did not match:" + " " + " captuted value:" + " " + Rid + " " + "Actual value:" + " " + stext);
            }

        } catch (NumberFormatException e) {
            System.out.println("unable to find the locator" + " " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "verify requistion iD", "Unable to find requsition id");
        }
        return status;
    }

    public static boolean GETREQUISITIONID(WebDriver webdriver, String parameters) {

        boolean status = false;
        try {

            String stext = GETTEXTo(webdriver, parameters);
            String[] arguments1 = null;
            arguments1 = splitfunction(parameters, "->");
            //parameters = "Requisition 203841 was submitted.";
            String[] arguments = null;
            arguments = splitfunction(stext, " ");
            String Rid = arguments1[3];
            String RequisitionId = arguments[1];
            hmap.put(Rid, RequisitionId);
            System.out.println(RequisitionId);
            ReportFunctions.LogRepoter("pass", "Rertive requistion iD", "Captured the requsition id  " + RequisitionId);
            status = true;
        } catch (NumberFormatException e) {
            System.out.println("unable to find the locator" + " " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "Rertive requistion iD", "Unable to find requsition id");
        }
        return status;
    }

    public static boolean SENDKEYS(WebDriver webdriver, String parameters) throws AWTException {

        boolean status = true;
        try {
            Robot robot = new Robot();
            Actions action = new Actions(driver);
            String[] arguments = null;
            arguments = splitfunction(parameters, "->");

            ActionTypes actTypes = ActionTypes.valueOf(arguments[1]);
            switch (actTypes) {

                case TAB:
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_TAB);
                    ReportFunctions.LogRepoter("Pass", "send keys", "Successfully clicked on TAB");
                    status = true;
                    break;
                case ENTER:
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                    ReportFunctions.LogRepoter("Pass", "send keys", "Successfully clicked on ENTER");
                    status = true;
                    break;
                case F12:
                    robot.keyPress(KeyEvent.VK_F12);
                    robot.keyRelease(KeyEvent.VK_F12);
                    ReportFunctions.LogRepoter("Pass", "send keys", "Successfully clicked on F12");
                    status = true;
                    break;
                case DOWN:
                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);
                    ReportFunctions.LogRepoter("Pass", "send keys", "Successfully clicked on F12");
                    status = true;
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("unable to find the locator" + " " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "send keys", "Unable to find send keys");
        }
        return status;
    }

    public static boolean APPROVEALL(WebDriver webdriver) throws InterruptedException {
        Thread.sleep(5000);
        boolean status = false;
        List<WebElement> rowCount = driver.findElements(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvw_NotificationLeaveSearch']/tbody/tr"));
        int ocount = rowCount.size();
        if (ocount > 2) {
            try {
                WebElement locator = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btn_ApproveAll"));
                WebElement locator1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_gvw_NotificationLeaveSearch_ctl01_chk_CheckAll"));
                if (locator.isEnabled()) {
                    locator1.click();
                    locator.click();
                    System.out.println("Succesfully clicked on Approve All");
                    ReportFunctions.LogRepoter("pass", "click on the link", "Succesfully clicked on Approve All");
                    status = true;
                } else {
                    System.out.println("unable to find Approve All link");
                    ReportFunctions.LogRepoter("Fail", "click on the link", "unable to find Approve All link");
                }
            } catch (Exception e) {

                System.out.println("unable to find the locator" + " " + e.getMessage());
                ReportFunctions.LogRepoter("Fail", "click on the link", "unable to find Approve All link");
            }

        } else {
            try {
                WebElement locator = driver.findElement(By.id("ctl00_ContentPlaceHolder1_gvw_NotificationLeaveSearch_ctl02_btn_Approve"));
                if (locator.isEnabled()) {
                    locator.click();
                    System.out.println("Succesfully clicked on Approve");
                    ReportFunctions.LogRepoter("pass", "click on the link", "Succesfully clicked on Approve");
                    status = true;
                } else {
                    System.out.println("unable to find Approve link");
                    ReportFunctions.LogRepoter("Fail", "click on the link", "unable to find Approve link");
                }
            } catch (Exception e) {

                System.out.println("unable to find the locator" + " " + e.getMessage());
                ReportFunctions.LogRepoter("Fail", "click on the link", "unable to find Approve link");
            }

        }
        return status;

    }

    public static boolean REJECTALL(WebDriver webdriver) throws InterruptedException {
        Thread.sleep(5000);
        boolean status = false;
        List<WebElement> rowCount = driver.findElements(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvw_NotificationLeaveSearch']/tbody/tr"));
        int ocount = rowCount.size();
        if (ocount > 2) {
            try {
                WebElement locator = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btn_RejectAll"));
                WebElement locator1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_gvw_NotificationLeaveSearch_ctl01_chk_CheckAll"));
                if (locator.isEnabled()) {
                    locator1.click();
                    locator.click();
                    System.out.println("Succesfully clicked on Reject All");
                    ReportFunctions.LogRepoter("pass", "click on the link", "Succesfully clicked on Reject All");
                    status = true;
                } else {
                    System.out.println("unable to find Reject All link");
                    ReportFunctions.LogRepoter("Fail", "click on the link", "unable to find Reject All link");
                }
            } catch (Exception e) {

                System.out.println("unable to find the locator" + " " + e.getMessage());
                ReportFunctions.LogRepoter("Fail", "click on the link", "unable to find Reject All link");
            }

        } else {
            try {
                WebElement locator = driver.findElement(By.id("ctl00_ContentPlaceHolder1_gvw_NotificationLeaveSearch_ctl02_btn_Reject"));
                if (locator.isEnabled()) {
                    locator.click();
                    System.out.println("Succesfully clicked on Reject");
                    ReportFunctions.LogRepoter("pass", "click on the link", "Succesfully clicked on Reject");
                    status = true;
                } else {
                    System.out.println("unable to find Reject link");
                    ReportFunctions.LogRepoter("Fail", "click on the link", "unable to find Reject link");
                }
            } catch (Exception e) {

                System.out.println("unable to find the locator" + " " + e.getMessage());
                ReportFunctions.LogRepoter("Fail", "click on the link", "unable to find Reject link");
            }

        }
        return status;

    }

    public static boolean CAPTUREANDAPPEND(WebDriver webdriver, String parameters) {

        boolean status = false;
        try {

            String stext = GETTEXTo(webdriver, parameters);
            String[] arguments = null;
            arguments = splitfunction(stext, ":");
            String aid = arguments[1];
            aid = arguments[1].trim();
            String url = "https://cs71.salesforce.com/" + aid;
            String parentWindowHandle = driver.getWindowHandle();
            driver.switchTo().window(parentWindowHandle);
            driver.get(url);
            System.out.println(stext);
            ReportFunctions.LogRepoter("pass", "Captured Quote iD and appended to home page", "Captured the quote id  " + stext);
            status = true;
        } catch (NumberFormatException e) {
            System.out.println("unable to find the locator" + " " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "Captured Quote iD and appended to home page", "Unable to capture and append");
        }
        return status;
    }

    public static Boolean GENERATE_UNIQVALUE(String Parameters) throws InterruptedException, IOException {
        Boolean Status = true;
        String strPrefix = null; //Variable to store prefix value
        String storevalue = null; //Variable to store output
        int strLength = 0;// Variable to store length value
        String strType = null;//Variable to store type(string/int)
        String strStringCase = null; //Variable to case(lower/upper)
        String strvalue1 = null; // Variable to store array after spliting first time
        String strvalue = null;//Variable to store array after spliting second time
        String strrndCode = null;  // Variable to store uniq value
        String strcasetype = null; // lower or upper
        int intI;      //variable to loop str length
        String Numc = null;
        int targetStringLength = 0;
        int Strprifixlength = 0;
        int uniqlength = 0;
        try {
            String[] arguments1 = splitfunction(Parameters, "->");
            if (arguments1.length == 2) {
                strType = "Alphanumeric";
                strPrefix = "ABC";
                strLength = 10;
                targetStringLength = 10;
                strcasetype = "Lowercase";
                storevalue = arguments1[1];
            } else {
                if (arguments1.length == 3) {
                    if (arguments1[1].length() == 1) {
                        targetStringLength = Integer.valueOf(arguments1[1]);
                        strType = "Alphanumeric";
                        strPrefix = "ABC";
                        strcasetype = "Lowercase";
                        storevalue = arguments1[2];
                    } else if (arguments1[1].length() > 1) {
                        String[] arguments = splitfunction(arguments1[1], ",");
                        if (arguments.length == 2) {
                            targetStringLength = Integer.valueOf(arguments[0]);
                            strType = arguments[1];
                            strPrefix = "ABC";
                            strcasetype = "Lowercase";
                            storevalue = arguments1[2];
                        }
                        if (arguments.length == 3) {
                            targetStringLength = Integer.valueOf(arguments[0]);
                            strType = arguments[1];
                            strPrefix = arguments[2];
                            strcasetype = "Lowercase";
                            storevalue = arguments1[2];
                        }
                        if (arguments.length == 4) {
                            targetStringLength = Integer.valueOf(arguments[0]);
                            strType = arguments[1];
                            strPrefix = arguments[2];
                            strcasetype = arguments[3];
                            storevalue = arguments1[2];
                        }

                    }

                }
            }
            if (targetStringLength != 0 && strType != null && strPrefix != null && strcasetype != null && storevalue != null) {
                int leftLimit = 97; // letter 'a'
                int rightLimit = 122; // letter 'z'

                int n = 9;
                int num = 0;
                String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                StringBuilder salt = new StringBuilder();
                Random random = new Random();
                StringBuilder buffer = new StringBuilder(targetStringLength);
                if (strType.toUpperCase().equalsIgnoreCase("STRING")) {
                    for (int i = 0; i < targetStringLength; i++) {
                        int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
                        buffer.append((char) randomLimitedInt);
                    }
                    String generatedString = buffer.toString();
                    generatedString = strPrefix + generatedString;

                    if (strcasetype.equalsIgnoreCase("uppercase")) {
                        System.out.println(generatedString.toUpperCase());
                        hmap.put(storevalue, generatedString.toUpperCase());
                        captureVariableData(storevalue, generatedString.toUpperCase());
                        ReportFunctions.LogRepoter("Pass", "Generated Uniq Value String  ", generatedString);
                    } else {
                        System.out.println(generatedString.toLowerCase());
                        hmap.put(storevalue, generatedString);
                        captureVariableData(storevalue, generatedString);
                        ReportFunctions.LogRepoter("Pass", "Generated Uniq Value String  ", generatedString);
                    }

                } else if (strType.toUpperCase().equalsIgnoreCase("NUMBER")) {
                    for (int i = 0; i < targetStringLength; i++) {
                        num = Integer.valueOf(String.valueOf(num) + String.valueOf(n));
                    }
                    int b = random.nextInt(num) + 1;
                    Numc = strPrefix + String.valueOf(b);
                    System.out.println(Numc);
                    hmap.put(storevalue, Numc);
                    captureVariableData(storevalue, Numc);
                    ReportFunctions.LogRepoter("Pass", "Generated Uniq Value Number  ", Numc);
                } else if (strType.toUpperCase().equalsIgnoreCase("Alphanumeric")) {
                    while (salt.length() < targetStringLength) { // length of the random string.
                        int index = (int) (random.nextFloat() * SALTCHARS.length());
                        salt.append(SALTCHARS.charAt(index));
                    }
                    String saltStr = salt.toString();
                    saltStr = strPrefix + saltStr;
                    if (strcasetype.equalsIgnoreCase("uppercase")) {
                        System.out.println(saltStr.toUpperCase());
                        hmap.put(storevalue, saltStr);
                        captureVariableData(storevalue, saltStr);
                        ReportFunctions.LogRepoter("Pass", "Generated Uniq Value Alphanumeric  ", saltStr);
                    } else {
                        System.out.println(saltStr.toLowerCase());
                        hmap.put(storevalue, saltStr);
                        captureVariableData(storevalue, saltStr);
                        ReportFunctions.LogRepoter("Pass", "Generated Uniq Value Alphanumeric  ", saltStr);
                    }
                } else {
                    ReportFunctions.LogRepoter("Fail", "Generated Uniq Value   ", "Please select String or Number or Alphanumeric");
                    System.out.println("Please select String or Number or Alphanumeric");
                }

            } else {
                ReportFunctions.LogRepoter("Fail", "Generated Uniq Value   ", "one of the input feild is null");
                System.out.println("one of the input feild is null");
                Status = false;
            }

        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            System.out.println("Missing one of the input");
            ReportFunctions.LogRepoter("Fail", "Generated Uniq Value   ", e.getMessage());
            Status = false;
        }
        return Status;
    }

    public static Boolean Connect_MySQL(String Parameters) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String[] arguments1 = splitfunction(Parameters, "->");
        String[] arguments = splitfunction(arguments1[1], ",");
        String url = hmap.get(arguments[0]);
        String user = hmap.get(arguments[1]);
        String password = hmap.get(arguments[2]);
        Boolean Status = true;
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                ReportFunctions.LogRepoter("Pass", "Successfully Connected to the database   ", "Database name: escloud_metadata_gbqa");
                System.out.println("Connected to the database escloud_metadata_gbqa");
            } else {
                ReportFunctions.LogRepoter("Fail", "Failed to connect to database  ", "Database name: escloud_metadata_gbqa");
                System.out.println("Failed to login to database escloud_metadata_gbqa");
                Status = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Status = false;
        }
        return Status;
    }

    public static Boolean Close_MySQL() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Boolean Status = true;
        if (conn != null) {
            conn.close();
            ReportFunctions.LogRepoter("Pass", "Successfully closed database connection   ", "Database name: escloud_metadata_gbqa");
            System.out.println("Successfully closed  the database escloud_metadata_gbqa");
        } else {
            ReportFunctions.LogRepoter("Fail", "Failed to close database connection   ", "Database name: escloud_metadata_gbqa");
            System.out.println("Failed to close database escloud_metadata_gbqa");
            Status = false;
        }
        return Status;
    }

    public static Boolean Query_MySQL(String Parameters) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        int count = 0;
        String output = null;
        List<Object> ValObject = new ArrayList<Object>();
        String[] arguments1 = splitfunction(Parameters, "->");
        String Verifycase = arguments1[1];
        String query = arguments1[2];
        String data;
        Boolean Status = true;
        try {
            if (conn != null) {
                Statement Sourcestmt = conn.createStatement();
                ResultSet Sourceresult = Sourcestmt.executeQuery(query);
                Object o;
                switch (Verifycase) {
                    case "Execution":
                        conn.getAutoCommit();
                        System.out.println("Successfully executed and committed the query");
                        ReportFunctions.LogRepoter("Pass", "Execution", "Successfully executed and committed the query");
                        break;
                    case "VerifyCount":
                        data = arguments1[3];
                        while (Sourceresult.next()) {;
                            count = count + 1;
                        }
                        System.out.println("Total Count:= " + count);
                        if (Integer.valueOf(data) == count) {
                            ReportFunctions.LogRepoter("Pass", "VerifyCount", "Both values  matched  Expected count:=" + data + " Actual count:=" + count);
                            System.out.println("Both values  matched  Expected count:=" + data + " Actual count:=" + count);
                        } else {
                            System.out.println("Both values did not match Expected count:=" + data + " Actual count:=" + count);
                            ReportFunctions.LogRepoter("Fail", "VerifyCount", "Both values did not match Expected count:=" + data + " Actual count:=" + count);
                            Status = false;
                        }
                        break;
                    case "VerifyValue":
                        data = arguments1[3];
                        while (Sourceresult.next()) {;
                            ValObject.add(Sourceresult.getString(1));
                        }
                        o = ValObject.get(0);
                        output = o.toString();
                        System.out.println("Sourceresult.getString(1)Databse value:= " + output);

                        if (data.equalsIgnoreCase(output)) {
                            ReportFunctions.LogRepoter("Pass", "VerifyValue", "Both values  matched  Expected Value:=" + data + " Actual Value:=" + count);
                            System.out.println("Both values  matched  Expected Value:=" + data + " Actual Value:=" + output);
                        } else {
                            System.out.println("Both values did not match Expected Value:=" + data + " Actual Value:=" + output);
                            ReportFunctions.LogRepoter("Fail", "VerifyValue", "Both values  did not match  Expected Value:=" + data + " Actual Value:=" + count);
                            Status = false;
                        }
                        break;
                    case "VerifyMutlipleColValue":
                        String[] arguments = splitfunction(arguments1[3], ",");
                        int ubound = arguments.length;
                        while (Sourceresult.next()) {;
                            for (int i = 0; i < ubound; i++) {
                                ValObject.add(Sourceresult.getString(i + 1));
                            }
                            for (int j = 0; j < ValObject.size(); j++) {
                                if (arguments[j].equalsIgnoreCase(ValObject.get(j).toString())) {
                                    System.out.println(+count + 1 + "  value: Both values  matched  Expected value:=" + arguments[j] + " Actual value:=" + ValObject.get(j));
                                    ReportFunctions.LogRepoter("Pass", "VerifyMutlipleColValue", +count + 1 + "  value:Both values matched  Expected value:=" + arguments[j] + " Actual value:=" + ValObject.get(j));
                                } else {
                                    System.out.println(+count + 1 + "  value:Both values  did not match  Expected value:=" + arguments[j] + " Actual value:=" + ValObject.get(j));
                                    ReportFunctions.LogRepoter("Fail", "VerifyMutlipleColValue", +count + 1 + "  value:Both values  did not match  Expected value:=" + arguments[j] + " Actual value:=" + ValObject.get(j));
                                    Status = false;
                                }
                                count = count + 1;
                            }
                        }
                        break;
                    case "VerifyMutlipleRowValue":
                        arguments = splitfunction(arguments1[3], ",");
                        ubound = arguments.length;
                        while (Sourceresult.next()) {;
                            ValObject.add(Sourceresult.getString(1));
                        }
                        for (int j = 0; j < ubound; j++) {
                            if (arguments[j].equalsIgnoreCase(ValObject.get(j).toString())) {
                                System.out.println(+count + 1 + "  value: Both values  matched  Expected value:=" + arguments[j] + " Actual value:=" + ValObject.get(j));
                                ReportFunctions.LogRepoter("Pass", "VerifyMutlipleRowValue", +count + 1 + "  value:Both values matched  Expected value:=" + arguments[j] + " Actual value:=" + ValObject.get(j));
                            } else {
                                System.out.println(+count + 1 + "  value:Both values  did not match  Expected value:=" + arguments[j] + " Actual value:=" + ValObject.get(j));
                                ReportFunctions.LogRepoter("Fail", "VerifyMutlipleRowValue", +count + 1 + "  value:Both values  did not match  Expected value:=" + arguments[j] + " Actual value:=" + ValObject.get(j));
                                Status = false;
                            }
                            count = count + 1;
                        }
                        break;
                    case "GetValue":
                        data = arguments1[3];
                        while (Sourceresult.next()) {;
                            ValObject.add(Sourceresult.getString(1));
                        }
                        o = ValObject.get(0);
                        if (o != null) {
                            output = o.toString();
                            hmap.put(data, output);
                            System.out.println("database value captured and stored in the variable:  " + data + " and value is" + output);
                            ReportFunctions.LogRepoter("Pass", "GetValue", "database value captured and stored in the variable:  " + data + " and value is" + output);

                        } else {
                            System.out.println("database value captured is null");
                            ReportFunctions.LogRepoter("Fail", "GetValue", "database value captured is null");
                            Status = false;
                        }
                        break;
                    case "GetMutlipleRowValue":
                        arguments = splitfunction(arguments1[3], ",");
                        ubound = arguments.length;
                        int val = 0;
                        while (Sourceresult.next()) {;
                            ValObject.add(Sourceresult.getString(1));
                            hmap.put(arguments[val], ValObject.get(val).toString());
                            ReportFunctions.LogRepoter("Pass", "GetMutlipleRowValue", +count + 1 + "Captured the value :=" + ValObject.get(val).toString() + " and Stored in:=" + arguments[val]);
                            val = val + 1;
                            count = count + 1;
                            if (count == ubound) 
                            {
                                break;
                            }
                        }
                        break;
                    case "GetMutlipleColValue":
                        arguments = splitfunction(arguments1[3], ",");
                        ubound = arguments.length;
                        while (Sourceresult.next()) {;
                            for (int i = 0; i < ubound; i++) {
                                ValObject.add(Sourceresult.getString(i + 1));
                                hmap.put(arguments[i], ValObject.get(i).toString());
                                ReportFunctions.LogRepoter("Pass", "GetMutlipleColValue", +i + 1 + "Captured the value :=" + ValObject.get(i).toString() + " and Stored in:=" + arguments[i]);
                            }
                            break;
                        }
                        break;
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ReportFunctions.LogRepoter("Fail", "Query_Mysql", "Failed to connect to database or nullpoint exception from database");
            Status = false;
        }
        return Status;

    }

    public static boolean INVISIBLEOFLOAD(WebDriver WebDriver) throws InterruptedException {
        boolean flag = false;
        try {
            WebDriverWait wait = new WebDriverWait(WebDriver, 1000);
            boolean status  = driver.findElements(By.xpath("(//div[@class=\"oj-icon oj-listview-loading-icon\"])[1]")).size() > 0;
            boolean status1 = driver.findElements(By.xpath("(//div[@class=\"oj-popup-content\"])[1]")).size() > 0;
            
            if (status || status1 ) 
            {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//div[@class=\"oj-icon oj-listview-loading-icon\"])[1]")));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//div[@class=\"oj-popup-content\"])[1]")));
                   System.out.println("Successfully waited till loader image is disappeared");
                // ReportFunctions.LogRepoter("pass", "close pop up", "Successfully waited till loader image is disappeared");
                flag = true;
            }
            if (flag == false) 
            {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-image")));
                System.out.println("Successfully waited till loader image is disappeared");
                // ReportFunctions.LogRepoter("pass", "close pop up", "Successfully waited till loader image is disappeared");
            }
            return true;
        } catch (Exception e) {
            System.out.println("unable to find the locator" + " " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "close pop up", "Loader image is still present");
            return false;
        }

    }

    public static Boolean encrypt(String Parameters) throws Exception {
        String[] arguments = splitfunction(Parameters, "->");
        String valueToEnc = arguments[1];
        if (valueToEnc != null && valueToEnc.length() > 0) {
            Key key = generateKey();
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encValue = c.doFinal(valueToEnc.getBytes());
            String encryptedValue = Base64.encodeBytes(encValue);
            hmap.put(arguments[2], encryptedValue);
            ReportFunctions.LogRepoter("Pass", "Successfully encripted the value", "encripted value " + encryptedValue);
        } else {
            ReportFunctions.LogRepoter("Fail", "Encript the value", "encripted value is null");
            return false;
        }
        return true;
    }

    public static Boolean decrypt(String Parameters) throws Exception {
        String[] arguments = splitfunction(Parameters, "->");
        String encryptedValue = arguments[1];
        if (encryptedValue != null && encryptedValue.length() > 0) {
            Key key = generateKey();
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.DECRYPT_MODE, key);
            byte[] decordedValue = Base64.decode(encryptedValue);
            byte[] decValue = c.doFinal(decordedValue);
            String decryptedValue = new String(decValue);
            hmap.put(arguments[2], decryptedValue);
            ReportFunctions.LogRepoter("Pass", "Successfully Decripted the value", "deripted value " + decryptedValue);
        } else {
            ReportFunctions.LogRepoter("Fail", "Decript the value", "decipted value is null");
            return false;
        }
        return true;
    }

    public static String decryptMultipleValues(String[] encryptedValues) throws Exception {
        for (String encryptedValue : encryptedValues) {
            if (encryptedValue != null && encryptedValue.length() > 0) {
                Key key = generateKey();
                Cipher c = Cipher.getInstance(ALGORITHM);
                c.init(Cipher.DECRYPT_MODE, key);
                byte[] decordedValue = Base64.decode(encryptedValue);
                byte[] decValue = c.doFinal(decordedValue);
                String decryptedValue = new String(decValue);
                System.out.println(encryptedValue + "     " + decryptedValue);
            }
        }
        return null;
    }

    public static String encryptMultipleValues(String[] decryptedValues) throws Exception {
        for (String decryptedValue : decryptedValues) {
            if (decryptedValue != null && decryptedValue.length() > 0) {
                Key key = generateKey();
                Cipher c = Cipher.getInstance(ALGORITHM);
                c.init(Cipher.ENCRYPT_MODE, key);
                byte[] encValue = c.doFinal(decryptedValue.getBytes());
                String encryptedValue = Base64.encodeBytes(encValue);
                System.out.println(decryptedValue + "     " + encryptedValue);
            }
        }
        return null;
    }

    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        // SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        // key = keyFactory.generateSecret(new DESKeySpec(keyValue));
        //System.out.println("Passion12@3 -> Encrypted : " +DBUtil.decrypt("f44SO21vyB0hjiTI3/3Nfw=="));
        // String[] encryptedValues = {"T83trsyPtFNK/xRNP5DQAQ=="};
        // decryptMultipleValues(encryptedValues);
        //String[] decryptedValues = {"@Q6Qqe}AmH"};
        //encryptMultipleValues(decryptedValues);
        return key;
    }

    public static boolean Getvalue_Table(WebDriver webdriver, String parameters) {
        Boolean status = true;
        try {
            String[] arguments = null;
            arguments = splitfunction(parameters, "->");
            WebElement table = Getlocator(driver, "xpath:=//table[starts-with(@class,'reference tableReport']");

        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("pass", "capture attribute", "unable to capture the Atttribute value");
            CLOSEALLBROWSERS(driver);
            status = false;
        }
        return status;
    }

    public static String Sysdate(String parameters) throws Exception {
        boolean flag = false;
        if (parameters.contains("sysdate,")) {
            dateformat = splitfunction(parameters, ",");
        } else {
            dateformat = splitfunction(parameters, ",");
            flag = true;
        }
        switch (dateformat[1].toUpperCase()) {
            case "DD-MM-YYYY":
                date = Calendar.getInstance().getTime();
                formatter = new SimpleDateFormat("dd-MM-YYYY");
                today = formatter.format(date);
                if (flag == true) {
                    date = Calendar.getInstance().getTime();
                    formatter = new SimpleDateFormat("dd-MM-YYYY");
                    today = formatter.format(date);
                    String[] odate = splitfunction(parameters, ",");
                    if (parameters.contains("+")) {
                        String[] addnum = splitfunction(odate[0], "+");
                        dat = returndate(addnum[1], today, "-");
                    } else if (parameters.contains("-")) {
                        String[] addnum = splitfunction(odate[0], "-");
                        dat = returnbackdate(addnum[1], today, "-");
                    }
                    today = dat;
                }
                break;
            case "MM-DD-YYYY":
                date = Calendar.getInstance().getTime();
                formatter = new SimpleDateFormat("MM-dd-YYYY");
                today = formatter.format(date);
                if (flag == true) {
                    date = Calendar.getInstance().getTime();
                    formatter = new SimpleDateFormat("dd-MM-YYYY");
                    today = formatter.format(date);
                    String[] odate = splitfunction(parameters, ",");
                    if (parameters.contains("+")) {
                        String[] addnum = splitfunction(odate[0], "+");
                        dat = returndate(addnum[1], today, "-");
                    } else if (parameters.contains("-")) {
                        String[] addnum = splitfunction(odate[0], "-");
                        dat = returnbackdate(addnum[1], today, "-");
                    }
                    String[] odat = splitfunction(dat, "-");
                    String len = odat[1];
                    int oval = Integer.parseInt(odat[1]);
                    if ((oval <= 9) && (len.length() == 1)) {
                        odat[1] = "0" + odat[1];
                    }

                    today = odat[1] + "-" + odat[0] + "-" + odat[2];
                }
                break;
            case "DD/MM/YYYY":
                date = Calendar.getInstance().getTime();
                formatter = new SimpleDateFormat("dd/MM/YYYY");
                today = formatter.format(date);
                if (flag == true) {
                    date = Calendar.getInstance().getTime();
                    formatter = new SimpleDateFormat("dd/MM/YYYY");
                    today = formatter.format(date);
                    String[] odate = splitfunction(parameters, ",");
                    if (parameters.contains("+")) {
                        String[] addnum = splitfunction(odate[0], "+");
                        dat = returndate(addnum[1], today, "/");
                    } else if (parameters.contains("-")) {
                        String[] addnum = splitfunction(odate[0], "-");
                        dat = returnbackdate(addnum[1], today, "/");
                    }
                    today = dat;
                }
                break;
            case "MM/DD/YYYY":
                date = Calendar.getInstance().getTime();
                formatter = new SimpleDateFormat("MM/dd/YYYY");
                today = formatter.format(date);
                if (flag == true) {
                    date = Calendar.getInstance().getTime();
                    formatter = new SimpleDateFormat("dd-MM-YYYY");
                    today = formatter.format(date);
                    String[] odate = splitfunction(parameters, ",");
                    if (parameters.contains("+")) {
                        String[] addnum = splitfunction(odate[0], "+");
                        dat = returndate(addnum[1], today, "-");
                    } else if (parameters.contains("-")) {
                        String[] addnum = splitfunction(odate[0], "-");
                        dat = returnbackdate(addnum[1], today, "-");
                    }
                    String[] odat = splitfunction(dat, "-");
                    String len = odat[1];
                    int oval = Integer.parseInt(odat[1]);

                    if ((oval <= 9) && (len.length() == 1)) {
                        odat[1] = "0" + odat[1];
                    }
                    today = odat[1] + "/" + odat[0] + "/" + odat[2];
                }
                break;
            case "DD-MM-YY":
                date = Calendar.getInstance().getTime();
                formatter = new SimpleDateFormat("dd-MM-YY");
                today = formatter.format(date);
                if (flag == true) {
                    date = Calendar.getInstance().getTime();
                    formatter = new SimpleDateFormat("dd-MM-YY");
                    today = formatter.format(date);
                    String[] odate = splitfunction(parameters, ",");
                    if (parameters.contains("+")) {
                        String[] addnum = splitfunction(odate[0], "+");
                        dat = returndate(addnum[1], today, "-");
                        today = dat;
                    } else if (parameters.contains("-")) {
                        String[] addnum = splitfunction(odate[0], "-");
                        dat = returnbackdate(addnum[1], today, "-");
                        String[] odat = splitfunction(dat, "-");
                        odat[2] = String.valueOf(odat[2]).substring(2);
                        today = odat[0] + "-" + odat[1] + "-" + odat[2];
                    }

                }
                break;
            case "MM-DD-YY":
                date = Calendar.getInstance().getTime();
                formatter = new SimpleDateFormat("MM-dd-YY");
                today = formatter.format(date);
                if (flag == true) {
                    date = Calendar.getInstance().getTime();
                    formatter = new SimpleDateFormat("dd-MM-YY");
                    today = formatter.format(date);
                    String[] odate = splitfunction(parameters, ",");
                    if (parameters.contains("+")) {
                        String[] addnum = splitfunction(odate[0], "+");
                        dat = returndate(addnum[1], today, "-");
                        String[] odat = splitfunction(dat, "-");
                        today = odat[1] + "-" + odat[0] + "-" + odat[2];
                    } else if (parameters.contains("-")) {
                        String[] addnum = splitfunction(odate[0], "-");
                        dat = returnbackdate(addnum[1], today, "-");
                        String[] odat = splitfunction(dat, "-");
                        odat[2] = String.valueOf(odat[2]).substring(2);
                        today = odat[1] + "-" + odat[0] + "-" + odat[2];
                    }

                }
                break;
            case "DD/MM/YY":
                date = Calendar.getInstance().getTime();
                formatter = new SimpleDateFormat("dd/MM/YY");
                today = formatter.format(date);
                if (flag == true) {
                    date = Calendar.getInstance().getTime();
                    formatter = new SimpleDateFormat("dd/MM/YY");
                    today = formatter.format(date);
                    String[] odate = splitfunction(parameters, ",");
                    if (parameters.contains("+")) {
                        String[] addnum = splitfunction(odate[0], "+");
                        dat = returndate(addnum[1], today, "/");
                        today = dat;
                    } else if (parameters.contains("-")) {
                        String[] addnum = splitfunction(odate[0], "-");
                        dat = returnbackdate(addnum[1], today, "/");
                        String[] odat = splitfunction(dat, "/");
                        odat[2] = String.valueOf(odat[2]).substring(2);
                        today = odat[0] + "/" + odat[1] + "/" + odat[2];

                    }

                }
                break;
            case "MM/DD/YY":
                date = Calendar.getInstance().getTime();
                formatter = new SimpleDateFormat("MM/dd/YY");
                today = formatter.format(date);
                if (flag == true) {
                    date = Calendar.getInstance().getTime();
                    formatter = new SimpleDateFormat("dd/MM/YY");
                    today = formatter.format(date);
                    String[] odate = splitfunction(parameters, ",");
                    if (parameters.contains("+")) {
                        String[] addnum = splitfunction(odate[0], "+");
                        dat = returndate(addnum[1], today, "/");
                        String[] odat = splitfunction(dat, "/");
                        today = odat[1] + "/" + odat[0] + "/" + odat[2];
                    } else if (parameters.contains("-")) {
                        String[] addnum = splitfunction(odate[0], "-");
                        dat = returnbackdate(addnum[1], today, "/");
                        String[] odat = splitfunction(dat, "/");
                        odat[2] = String.valueOf(odat[2]).substring(2);
                        today = odat[1] + "/" + odat[0] + "/" + odat[2];
                    }

                }
                break;
            case "DD-MMM-YYYY":
                date = Calendar.getInstance().getTime();
                formatter = new SimpleDateFormat("dd-MMM-YYYY");
                today = formatter.format(date);
                if (flag == true) {
                    date = Calendar.getInstance().getTime();
                    formatter = new SimpleDateFormat("dd-MMM-YYYY");
                    today = formatter.format(date);
                    String[] odate = splitfunction(parameters, ",");
                    if (parameters.contains("+")) {
                        String[] addnum = splitfunction(odate[0], "+");
                        dat = returndate(addnum[1], today, "-");
                    } else if (parameters.contains("-")) {
                        String[] addnum = splitfunction(odate[0], "-");
                        dat = returnbackdate(addnum[1], today, "-");
                    }
                    today = dat;
                }
                break;
            case "DD/MMM/YYYY":
                date = Calendar.getInstance().getTime();
                formatter = new SimpleDateFormat("dd/MMM/YYYY");
                today = formatter.format(date);
                if (flag == true) {
                    date = Calendar.getInstance().getTime();
                    formatter = new SimpleDateFormat("dd/MMM/YYYY");
                    today = formatter.format(date);
                    String[] odate = splitfunction(parameters, ",");
                    if (parameters.contains("+")) {
                        String[] addnum = splitfunction(odate[0], "+");
                        dat = returndate(addnum[1], today, "/");
                    } else if (parameters.contains("-")) {
                        String[] addnum = splitfunction(odate[0], "-");
                        dat = returnbackdate(addnum[1], today, "/");
                    }
                    today = dat;
                }
                break;
        }
        System.out.println(today);
        return today;

    }

    public static String returndate(String num, String date, String s) throws Exception {
        int oyear = 0;
        int month = 0;
        String temp = null;
        Boolean flag = true;
        String[] formats = splitfunction(date, s);
        temp = formats[1];
        switch (formats[1].toUpperCase()) {
            case "JAN":
                formats[1] = "01";
                flag = false;
                break;
            case "FEB":
                formats[1] = "02";
                flag = false;
                break;
            case "MAR":
                formats[1] = "03";
                flag = false;
                break;
            case "APR":
                formats[1] = "04";
                flag = false;
                break;
            case "MAY":
                formats[1] = "05";
                flag = false;
                break;
            case "JUN":
                formats[1] = "06";
                flag = false;
                break;
            case "JUL":
                formats[1] = "07";
                flag = false;
                break;
            case "AUG":
                formats[1] = "08";
                flag = false;
                break;
            case "SEP":
                formats[1] = "09";
                flag = false;
                break;
            case "OCT":
                formats[1] = "10";
                flag = false;
                break;
            case "NOV":
                formats[1] = "11";
                flag = false;
                break;
            case "DEC":
                formats[1] = "12";
                flag = false;
                break;
        }
        int currdate = Integer.parseInt(num) + Integer.parseInt(formats[0]);
        if (currdate >= 31) {
            while (currdate >= 31) {
                if (formats[1].equalsIgnoreCase("08") || (Integer.parseInt(formats[1]) % 2 != 0) || formats[1].equalsIgnoreCase("02") || formats[1].equalsIgnoreCase("12")) {
                    if (formats[1].equalsIgnoreCase("02")) {
                        currdate = currdate - 28;
                        month = Integer.parseInt(formats[1]) + 1;
                        if (month < 10) {
                            formats[1] = 0 + String.valueOf(month);
                        } else if ((month > 12)) {
                            month = month % 12;
                            oyear = oyear + 1;
                            formats[1] = String.valueOf(month);
                        } else if ((month >= 10) && (month <= 12)) {
                            formats[1] = String.valueOf(month);
                        }
                    } else {
                        currdate = currdate - 31;
                        month = Integer.parseInt(formats[1]) + 1;
                    }
                    if (month < 10) {
                        formats[1] = 0 + String.valueOf(month);
                        if (formats[1].equalsIgnoreCase("02")) {
                            if (currdate > 28) {
                                currdate = currdate - 28;
                                month = Integer.parseInt(formats[1]) + 1;
                                formats[1] = String.valueOf(month);
                            }
                        }
                    } else if ((month > 12)) {
                        month = month % 12;
                        formats[1] = String.valueOf(month);
                        oyear = oyear + 1;
                    } else if ((month >= 10) && (month <= 12)) {
                        formats[1] = String.valueOf(month);
                    }
                } else {
                    currdate = currdate - 30;
                    month = Integer.parseInt(formats[1]) + 1;
                    if (month < 10) {
                        formats[1] = 0 + String.valueOf(month);
                    } else if ((month > 12)) {
                        month = month % 12;
                        formats[1] = String.valueOf(month);
                        oyear = oyear + 1;
                    } else if ((month >= 10) && (month <= 12)) {
                        formats[1] = String.valueOf(month);
                    }
                }
            }
            if (flag == false) {
                switch (formats[1]) {
                    case "1":
                        formats[1] = "JAN";
                        break;
                    case "2":
                        formats[1] = "FEB";
                        flag = false;
                        break;
                    case "3":
                        formats[1] = "MAR";
                        flag = false;
                        break;
                    case "4":
                        formats[1] = "APR";
                        flag = false;
                        break;
                    case "5":
                        formats[1] = "MAY";
                        flag = false;
                        break;
                    case "6":
                        formats[1] = "JUN";
                        flag = false;
                        break;
                    case "7":
                        formats[1] = "JUL";
                        flag = false;
                        break;
                    case "8":
                        formats[1] = "AUG";
                        flag = false;
                        break;
                    case "9":
                        formats[1] = "SEP";
                        flag = false;
                        break;
                    case "10":
                        formats[1] = "OCT";
                        flag = false;
                        break;
                    case "11":
                        formats[1] = "NOV";
                        flag = false;
                        break;
                    case "12":
                        formats[1] = "DEC";
                        flag = false;
                        break;
                }
            }
            if (oyear == 0) {
                today = "0" + currdate + s + formats[1] + s + formats[2];
            } else if (oyear > 0) {
                int year = Integer.parseInt(formats[2]) + oyear;
                formats[2] = String.valueOf(year);
                today = "0" + currdate + s + formats[1] + s + formats[2];
            }
            if (currdate < 10) {
                today = "0" + currdate + s + formats[1] + s + formats[2];
            } else {
                today = currdate + s + formats[1] + s + formats[2];
            }
        } else {
            if (flag == false) {
                formats[1] = temp;
            }
            today = currdate + s + formats[1] + s + formats[2];

        }
        return today;
    }

    public static String returnbackdate(String num, String date, String s) throws Exception {
        int oyear = 0;
        int month;
        Boolean flag = true;
        String temp;
        String[] formats = splitfunction(date, s);
        temp = formats[1];
        switch (formats[1].toUpperCase()) {
            case "JAN":
                formats[1] = "01";
                flag = false;
                break;
            case "FEB":
                formats[1] = "02";
                flag = false;
                break;
            case "MAR":
                formats[1] = "03";
                flag = false;
                break;
            case "APR":
                formats[1] = "04";
                flag = false;
                break;
            case "MAY":
                formats[1] = "05";
                flag = false;
                break;
            case "JUN":
                formats[1] = "06";
                flag = false;
                break;
            case "JUL":
                formats[1] = "07";
                flag = false;
                break;
            case "AUG":
                formats[1] = "08";
                flag = false;
                break;
            case "SEP":
                formats[1] = "09";
                flag = false;
                break;
            case "OCT":
                formats[1] = "10";
                flag = false;
                break;
            case "NOV":
                formats[1] = "11";
                flag = false;
                break;
            case "DEC":
                formats[1] = "12";
                flag = false;
                break;
        }
        int currdate = Integer.parseInt(formats[0]) - Integer.parseInt(num);
        if (currdate >= 1) {
            today = currdate + s + formats[1] + s + formats[2];
        } else if (currdate <= 0) {
            while (currdate <= 0) {
                if (Integer.parseInt(formats[1]) % 2 != 0) {
                    currdate = 31 - Math.abs(currdate);
                } else {
                    currdate = 30 - Math.abs(currdate);
                }
                month = Integer.parseInt(formats[1]) - 1;
                if (month == 0) {
                    month = 12;
                    oyear = oyear + 1;
                }
                if (month < 10) {
                    formats[1] = 0 + String.valueOf(month);
                } else {
                    formats[1] = String.valueOf(month);
                }

            }
        }
        if (flag == false) {
            switch (formats[1]) {
                case "1":
                    formats[1] = "JAN";
                    break;
                case "2":
                    formats[1] = "FEB";
                    flag = false;
                    break;
                case "3":
                    formats[1] = "MAR";
                    flag = false;
                    break;
                case "4":
                    formats[1] = "APR";
                    flag = false;
                    break;
                case "5":
                    formats[1] = "MAY";
                    flag = false;
                    break;
                case "6":
                    formats[1] = "JUN";
                    flag = false;
                    break;
                case "7":
                    formats[1] = "JUL";
                    flag = false;
                    break;
                case "8":
                    formats[1] = "AUG";
                    flag = false;
                    break;
                case "9":
                    formats[1] = "SEP";
                    flag = false;
                    break;
                case "10":
                    formats[1] = "OCT";
                    flag = false;
                    break;
                case "11":
                    formats[1] = "NOV";
                    flag = false;
                    break;
                case "12":
                    formats[1] = "DEC";
                    flag = false;
                    break;
            }
        }

        int year = Calendar.getInstance().get(Calendar.YEAR) - oyear;
        formats[2] = String.valueOf(year);
        if (Math.abs(currdate) < 10) {
            today = "0" + currdate + s + formats[1] + s + formats[2];
        } else {
            today = currdate + s + formats[1] + s + formats[2];
        }
        //System.out.println(today);
        return today;
    }

    public static Boolean Storevalue(String Parameters) throws Exception {
        Boolean Status = true;
        String value;
        String[] values = null;
        String[] argum = null;
        String revalue = null;
        Boolean flag = true;
        String newoval = null;
        String[] arguments = splitfunction(Parameters, "->");
        if ((arguments[2].contains("+"))) {
            argum = splitfunction(arguments[2], "+");
            if ((hmap.containsKey(argum[0]) == false)) {
                String[] arg = splitfunction(arguments[2], "+");
                String newv = arg[1];
                if (hmap.containsKey(newv)) {
                    revalue = hmap.get(newv);
                    arguments[2] = arguments[2].replace("+" + newv, revalue);
                }
            } else if (((hmap.containsKey(argum[0]) == true))) {
                revalue = hmap.get(argum[0]);
                if (((hmap.containsKey(argum[1]) == true))) {
                    String revalue1 = hmap.get(argum[1]);
                    arguments[2] = revalue + revalue1;
                } else {
                    try {
                        Float.parseFloat(argum[1]);
                    } catch (NumberFormatException e) {
                        flag = false;
                    }
                    if (flag == true) {
                        float firstval = Float.parseFloat(revalue) + Float.parseFloat(argum[1]);
                        arguments[2] = String.valueOf(firstval);
                    } else {
                        arguments[2] = revalue + argum[1];
                    }
                }
            }
        }
        try {
            if (arguments[1] != null && arguments[2] != null) {

                if (hmap.containsKey(arguments[2])) {
                    if ((hmap.containsKey(arguments[1]))) {
                        String newvar = hmap.get(arguments[1]);
                        arguments[1] = newvar;
                    }
                    String oval = hmap.get(arguments[2]);
                    hmap.put(arguments[1], oval);
                    ReportFunctions.LogRepoter("Pass", "Storevalue",
                            "Successfully stored the value " + oval + " in " + " " + arguments[1]);
                } else if ((arguments[2].contains("+"))) {

                    values = splitfunction(arguments[2], "+");
                    if (values.length > 2) {
                        if ((hmap.containsKey(values[0]))
                                && (hmap.containsKey(values[1]) && (hmap.containsKey(values[2])))) {
                            Float firstval = Float.parseFloat(hmap.get(values[0]));
                            Float Secval = Float.parseFloat(hmap.get(values[1]));
                            Float thirdval = Float.parseFloat(hmap.get(values[2]));
                            value = String.valueOf(firstval + Secval + thirdval);
                            hmap.put(arguments[1], value);
                            ReportFunctions.LogRepoter("Pass", "Storevalue",
                                    "Successfully stored the value " + value + " in " + " " + arguments[1]);
                        } else {
                            ReportFunctions.LogRepoter("Fail", "verify Value", "Failed to find values in hash map ");
                        }
                    } else if (values.length == 2) {
                        if ((hmap.containsKey(values[0])) && (hmap.containsKey(values[1]))) {
                            Float firstval = Float.parseFloat(hmap.get(values[0]));
                            Float Secval = Float.parseFloat(hmap.get(values[1]));
                            value = String.valueOf(firstval + Secval);
                            hmap.put(arguments[1], value);
                            ReportFunctions.LogRepoter("Pass", "Storevalue",
                                    "Successfully stored the value " + value + " in " + " " + arguments[1]);
                        } else {
                            ReportFunctions.LogRepoter("Fail", "verify Value", "Failed to find values in hash map ");
                        }
                    }
                } else if ((arguments[2].contains("*"))) {

                    values = splitfunction(arguments[2], "*");
                    if ((hmap.containsKey(values[0])) && (hmap.containsKey(values[1]))) {
                        Float firstval = Float.parseFloat(hmap.get(values[0]));
                        Float Secval = Float.parseFloat(hmap.get(values[1]));
                        value = String.valueOf(firstval * Secval);
                        hmap.put(arguments[1], value);
                        ReportFunctions.LogRepoter("Pass", "Storevalue",
                                "Successfully stored the value " + value + " in " + " " + arguments[1]);
                    } else {
                        ReportFunctions.LogRepoter("Fail", "verify Value", "Failed to find values in ");
                    }

                } else if ((arguments[2].contains("minus"))) {
                    values = splitfunction(arguments[2], "minus");
                    if ((hmap.containsKey(values[0])) && (hmap.containsKey(values[1]))) {
                        Float firstval = Float.parseFloat(hmap.get(values[0]));
                        Float Secval = Float.parseFloat(hmap.get(values[1]));
                        value = String.valueOf(firstval - Secval);
                        hmap.put(arguments[1], value);
                        ReportFunctions.LogRepoter("Pass", "Storevalue",
                                "Successfully stored the value " + value + " in " + " " + arguments[1]);
                    } else {
                        ReportFunctions.LogRepoter("Fail", "verify Value", "Failed to find values in ");
                    }

                } else {
                    if (hmap.containsKey(arguments[1])) {
                        newoval = arguments[1];
                        hmap.remove(arguments[1]);
                        hmap.put(newoval, arguments[2]);
                        ReportFunctions.LogRepoter("Pass", "Storevalue",
                                "Successfully stored the value " + arguments[2] + " in " + " " + arguments[1]);
                    } else {
                        hmap.put(arguments[1], arguments[2]);
                        ReportFunctions.LogRepoter("Pass", "Storevalue",
                                "Successfully stored the value " + arguments[2] + " in " + " " + arguments[1]);
                    }

                }

            } else {
                ReportFunctions.LogRepoter("Fail", "Storevalue", "Failed stored the value as one of input is empty");
                CLOSEALLBROWSERS(driver);
                Status = false;
            }

        } catch (Exception e) {
            ReportFunctions.LogRepoter("Fail", "Storevalue", "Failed stored the value as input is wrong " + e);
            CLOSEALLBROWSERS(driver);
            Status = false;

        }
        return Status;
    }

    public static Boolean Click_Enter(String Parameters) throws Exception {
        Boolean Status = true;
        String value;
        String[] arguments = splitfunction(Parameters, "->");
        String label = arguments[1];

        if (hmap.containsKey(arguments[2])) {
            value = hmap.get(arguments[2]);
        } else {
            value = arguments[2];
        }
        String xpath = "xpath:=//td[text()=\"" + label + "\"]/following-sibling::td//input";
        String xpath2 = "xpath:=//a[text()=\"" + value + "\"]";
        try {
            WAITFORELEMENT(driver, "waitforelement->" + xpath + "->" + label + "");
            WebElement locator = Getlocator(driver, xpath);
            if (locator.isEnabled()) {
                locator.click();
                locator.clear();
                locator.sendKeys(value);
                WAITTIME("waittime->2");
                ReportFunctions.LogRepoter("pass", "Enter value ", "Succesfully entered value " + " " + arguments[2]);
                INVISIBLEOFLOAD(driver);
                WAITFORELEMENT(driver, "waitforelement->" + xpath2 + "->" + value + "");
                WebElement locator2 = Getlocator(driver, xpath2);
                if (locator2 != null) {
                    locator2.click();
                    INVISIBLEOFLOAD(driver);
                    WAITTIME("waittime->2");
                    System.out.println("Succesfully entered value" + " " + arguments[2]);
                    ReportFunctions.LogRepoter("pass", "click on the object",
                            "Succesfully clicked on" + " " + arguments[2]);
                } else {
                    ReportFunctions.LogRepoter("Fail", "click on the object", "unable to find" + " " + value);
                    Status = false;
                    CLOSEALLBROWSERS(driver);
                }

            } else {
                System.out.println("unable to find" + " " + arguments[2]);
                // ReportFunctions.LogRepoter("Fail", "click on the object", "unable to find" + " " + arguments[2]);
                CLOSEALLBROWSERS(driver);
                Status = false;
            }
        } catch (Exception e) {
            ReportFunctions.LogRepoter("Fail", "Click_Enter", "Failed to enter value " + e);
            CLOSEALLBROWSERS(driver);
            Status = false;
        }
        return Status;

    }

    public static Boolean Search_Enter(String Parameters) throws Exception {
        Boolean Status = true;
        String value;
        String[] arguments = splitfunction(Parameters, "->");
        String label = arguments[1];
        if (hmap.containsKey(arguments[2])) {
            value = hmap.get(arguments[2]);
        } else {
            value = arguments[2];
        }
        String xpath = "xpath:=//td[text()=\"" + label + "\"]/following-sibling::td//input";
        String xpath2 = "xpath:=//td[text()=\"" + value + "\"]";
        try {
            WAITFORELEMENT(driver, "waitforelement->" + xpath + "->" + label + "");
            WebElement locator = Getlocator(driver, xpath);
            if (locator.isEnabled()) {
                locator.click();
                INVISIBLEOFLOAD(driver);
                WAITTIME("waittime->4");
                WebElement search1 = Getlocator(driver, "xpath:=//input[@id=\"searchString\"]");
                search1.click();
                search1.sendKeys(value);
                WAITTIME("waittime->2");
                WebElement search2 = Getlocator(driver, "xpath:=//button[@id=\"search\"]");
                search2.click();
                ReportFunctions.LogRepoter("pass", "Enter value ", "Succesfully entered value " + " " + arguments[2]);
                INVISIBLEOFLOAD(driver);
                WAITFORELEMENT(driver, "waitforelement->" + xpath2 + "->" + value + "");
                WebElement locator2 = Getlocator(driver, xpath2);
                locator2.click();
                INVISIBLEOFLOAD(driver);
                WAITTIME("waittime->2");
                SENDKEYS(driver, "sendkeys->TAB");
                SENDKEYS(driver, "sendkeys->TAB");
                // WebElement done = Getlocator(driver,
                // "xpath:=//b[contains(text(),'Done')]");
                // done.click();
                ReportFunctions.LogRepoter("pass", "click element ", "Succesfully clicked on " + " " + arguments[2]);
            }
        } catch (Exception e) {
            ReportFunctions.LogRepoter("Fail", "Search_Enter", "Failed to enter value " + e);
            CLOSEALLBROWSERS(driver);
            Status = false;

        }
        return Status;

    }

    public static Boolean Upload_File(String Parameters) throws Exception {
        Boolean Status = true;
        String workingDirectory = new java.io.File(".").getCanonicalPath();
        try {
            String[] arguments = splitfunction(Parameters, "->");
//            String path = workingDirectory + "/" + arguments[1];
//            //String path = workingDirectory + arguments[1];
//            Thread.sleep(3000);
//            System.out.println("wscript " + path + ".vbs");
//            Runtime.getRuntime().exec("wscript " + path + ".vbs");
            String FilePath = workingDirectory+"\\UploadFiles"+"\\"+ arguments[1];

            System.out.println(FilePath);

    // creating object of Robot class
       Robot rb = new Robot();

    // copying File path to Clipboard
       StringSelection str = new StringSelection(FilePath);
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

     // press Contol+V for pasting
     rb.keyPress(KeyEvent.VK_CONTROL);
     rb.keyPress(KeyEvent.VK_V);

    // release Contol+V for pasting
    rb.keyRelease(KeyEvent.VK_CONTROL);
    rb.keyRelease(KeyEvent.VK_V);

    // for pressing and releasing Enter
    rb.keyPress(KeyEvent.VK_ENTER);
    rb.keyRelease(KeyEvent.VK_ENTER);
            ReportFunctions.LogRepoter("pass", "Upload_File  ", "Succesfully uploaded file " + " " + arguments[1]);
        } catch (Exception e) {
            ReportFunctions.LogRepoter("Fail", "Upload_File  ", "Failed to uploaded file " + e);
            Status = false;
            CLOSEALLBROWSERS(driver);
        }
        return Status;
    }

    public static void Store_data() throws Exception {
        Boolean Status = true;
        String datasheet = Tsuitename;
        try {
            String workingDirectory = new java.io.File(".").getCanonicalPath();
            System.out.println(workingDirectory);
            String path = workingDirectory + "/TestData";
            File Sfolder = new File(path);
            File[] listofsfiles = Sfolder.listFiles();
            String[] myFiles;
            if (Sfolder.isDirectory()) {
                myFiles = Sfolder.list();
                for (int k = 0; k < myFiles.length; k++) {
                    File myFile = new File(Sfolder, myFiles[k]);
                    String fname = myFile.getName();
                    fname = fname.replace(".xlsx", "");
                    if (fname.equalsIgnoreCase(datasheet)) {
                        myFile.delete();
                        break;
                    }
                }
            }
            File file1 = new File(path + "/" + datasheet + ".xlsx");
            File file = new File(path);
            file1.createNewFile();
            FileOutputStream fileOut = new FileOutputStream(file1);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet1;
            spreadsheet1 = workbook.createSheet(datasheet);
            XSSFRow Srow;
            Srow = spreadsheet1.createRow(0);
            XSSFCell Scell;
            Scell = Srow.createCell(0);
            Scell.setCellValue("Environment Variables");
            Scell = Srow.createCell(1);
            Scell.setCellValue("Variable Values");
            int i = 1;
            for (Map.Entry<String, String> entry : hmap.entrySet()) {
                Srow = spreadsheet1.createRow(i);
                Scell = Srow.createCell(0);
                Scell.setCellValue(entry.getKey());
                Scell = Srow.createCell(1);
                Scell.setCellValue(hmap.get(entry.getKey()));
                i++;
            }
            XSSFCellStyle style1 = workbook.createCellStyle();
            style1 = workbook.createCellStyle();
            spreadsheet1.setColumnWidth(0, 6000);

            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            System.out.println("Succesfully stored data in" + path);
            // ReportFunctions.LogRepoter("pass", "Store_data  ", "Succesfully stored data in" + path);

        } catch (Exception e) {
            System.out.println("Store data, Failed to store data" + e);
            System.out.println("failed to stored data");
            //ReportFunctions.LogRepoter("Fail", "Store_data  ", "Failed to store data");
        }

    }

    public static void Automation_Summary() throws Exception {
        Boolean Status = true;
        String datasheet = hmap.get(suitename);
        ArrayList<String> br = ReadXMLFile();

        try {
            String workingDirectory = new java.io.File(".").getCanonicalPath();
            System.out.println(workingDirectory);
            String path = workingDirectory + "/Automation_Summary";
            File file1 = new File(path + "/" + datasheet + ".xlsx");
            File file = new File(path);
            file1.createNewFile();
            FileOutputStream fileOut = new FileOutputStream(file1);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet1;
            XSSFSheet spreadsheet2;
            spreadsheet1 = workbook.createSheet(datasheet);
            spreadsheet2 = workbook.createSheet("Runtime Captured Values");
            XSSFRow Srow;
            XSSFCellStyle style = workbook.createCellStyle();
            style.setBorderTop(BorderStyle.DOUBLE);
            style.setBorderBottom(BorderStyle.DOUBLE);
            style.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
            XSSFFont font = workbook.createFont();
            font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
            font.setFontHeightInPoints((short) 10);
            font.setBold(true);
            font.setColor(HSSFColor.BLUE.index);
            style.setFont(font);
            Srow = spreadsheet1.createRow(0);
            XSSFCell Scell;
            Scell = Srow.createCell(0);
            Scell.setCellValue("Automation Summary");
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(1);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Suite Name");
            Scell = Srow.createCell(1);
            Scell.setCellValue(hmap.get(suitename));
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(2);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Suite Final Status ");
            Scell = Srow.createCell(1);
            Scell.setCellValue(hmap.get(ESuitestatus));
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(3);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Total Test Cases Executed ");
            Scell = Srow.createCell(1);
            Scell.setCellValue(casecount);
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(4);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Total Suite Execution Time");
            Scell = Srow.createCell(1);
            Scell.setCellValue(display);
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(5);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Total Cases Passed ");
            Scell = Srow.createCell(1);
            Scell.setCellValue(TCpasscount);
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(6);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Total Cases Failed ");
            Scell = Srow.createCell(1);
            Scell.setCellValue(TCfailcount);
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(7);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Release Name");
            Scell = Srow.createCell(1);
            Scell.setCellValue(releasename);
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(8);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Environment");
            Scell = Srow.createCell(1);
            Scell.setCellValue(environmentname);
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(10);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Test Case Name");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(1);
            Scell.setCellValue("Execution Time ");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(2);
            Scell.setCellValue("Status ");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(3);
            Scell.setCellValue("Failure Comments ");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Iterator<String> itr = br.iterator();
            int i = 11;
            int b = 0;
            XSSFRow Srow1;
            XSSFCell Scell1;
            XSSFCell Scell2;
            XSSFCell Scell3;
            XSSFFont whitefont = workbook.createFont();
            whitefont.setColor(HSSFColor.WHITE.index);
            XSSFFont blackfont = workbook.createFont();
            blackfont.setColor(HSSFColor.BLACK.index);
            XSSFCellStyle style1 = workbook.createCellStyle();
            XSSFCellStyle style2 = workbook.createCellStyle();
            XSSFCellStyle style3 = workbook.createCellStyle();
            style1.setFont(font);
            style1.setFont(whitefont);
            style1.setBorderBottom(BorderStyle.THIN);
            style2.setFont(font);
            style2.setFont(whitefont);
            style2.setBorderBottom(BorderStyle.THIN);
            style3.setFont(font);
            style3.setFont(blackfont);
            style3.setBorderBottom(BorderStyle.THIN);
            while (itr.hasNext()) {
                Srow1 = spreadsheet1.createRow(i);
                Scell1 = Srow1.createCell(0);
                Scell1.setCellValue(itr.next());
                Scell1 = Srow1.createCell(1);
                Scell1.setCellValue(itr.next());
                Scell1 = Srow1.createCell(2);
                Scell1.setCellValue(itr.next());
                Scell2 = workbook.getSheetAt(0).getRow(i).getCell(2);
                if (Scell2.toString().equalsIgnoreCase("PASS")) {
                    Scell2 = Srow1.createCell(2);
                    Scell2.setCellValue("PASS");
                    style1.setAlignment(HorizontalAlignment.CENTER);
                    style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                    Scell2.setCellStyle(style1);
                }
                if (Scell2.toString().equalsIgnoreCase("FAIL")) {
                    if (Stpname != null) {
                        Stpname = Stpname.replace(Stpname, "Stpname");
                    }
                    Stpname = Stpname + b;
                    Scell2 = Srow1.createCell(2);
                    Scell2.setCellValue("FAIL");
                    style2.setAlignment(HorizontalAlignment.CENTER);
                    style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    style2.setFillForegroundColor(IndexedColors.RED.getIndex());
                    Scell2.setCellStyle(style2);
                    Scell3 = Srow1.createCell(3);
                    Scell3.setCellValue(hmap.get(Stpname));
                    Scell3.setCellStyle(style3);
                    b++;
                }

                i++;
            }

//          spreadsheet1.setColumnWidth(2, 2000);
            for (int m = 0; m < 200; m++) {
                spreadsheet1.autoSizeColumn(m);
            }
//            XSSFCellStyle style4 = workbook.createCellStyle();
//            style4.setAlignment(HorizontalAlignment.CENTER);
//            style4.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//            style4.setFillForegroundColor(IndexedColors.BLUE.getIndex());
//            style4.setFont(whitefont);
//            XSSFRow Srow2;
//            Srow2 = spreadsheet2.createRow(0);
//            XSSFCell Scell4;
//            Scell4 = Srow2.createCell(0);
//            Scell4.setCellValue("Environment Names");
//            Scell4.setCellStyle(style4);
//            Scell4 = Srow2.createCell(1);
//            Scell4.setCellValue("Environment  Values");
//            Scell4.setCellStyle(style4);
//            int n = 1;
//            for (Map.Entry<String, String> entry : hmap.entrySet()) {
//                Srow2 = spreadsheet2.createRow(n);
//                Scell4 = Srow2.createCell(0);
//                Scell4.setCellValue(entry.getKey());
//                Scell4 = Srow2.createCell(1);
//                Scell4.setCellValue(hmap.get(entry.getKey()));
//                n++;
//            }
//
//            for (int m = 0; m < 100; m++) {
//                spreadsheet2.autoSizeColumn(m);
//            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();

            //sendAttachmentEmail("venkat@kloudgin.com,vsritharan@kloudgin.com,pvenkateswaran@kloudgin.com,rajeevb@kloudgin.com,qateam@kloudgin.com,hede@kloudgin.com,muralip@kloudgin.com", "Automation Status Report for "+hmap.get(suitename), "Hi Team Please find the Attached Automation Status Report");
            //sendAttachmentEmail("ashokb@kloudgin.com,muralip@kloudgin.com", "Automation Status Report for "+hmap.get(suitename), "Hi Team Please find the Attached Automation Status Report");
        } catch (Exception e) {
            System.out.println("Automation Summary" + e);
        }

    }

    public static ArrayList<String> ReadXMLFile() throws ParserConfigurationException, SAXException, IOException {
        ArrayList<String> ar = new ArrayList<String>();
        String res;
        try {
            //File file = new File("C:/Users/mpentakota/Documents/NetBeansProjects/MultipledataSetup/Reports/SMB_Suite_2018-08-20-03-39-09/XmlReport.xml");
            File file = new File(xmlSavedLocation);

            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            //  System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("TestSuite");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                // System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    hmap.put(Esuitename, eElement.getAttribute("Name"));
                    hmap.put(ESuitestatus, eElement.getAttribute("FinalStatus"));
                }
            }
            nList = doc.getElementsByTagName("TestCase");
            casecount = nList.getLength();
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                // System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    sanitymap.put(sanitycnt, eElement.getAttribute("Name"));
                    ar.add(eElement.getAttribute("Name"));
                    ar.add(eElement.getAttribute("Duration"));
                    ar.add(eElement.getAttribute("FinalStatus"));
                    sanitycnt = sanitycnt + 1;
                    if (eElement.getAttribute("FinalStatus").equalsIgnoreCase("PASS")) {
                        TCpasscount = TCpasscount + 1;
                    } else {
                        TCfailcount = TCfailcount + 1;
                    }
                }
            }

            nList = doc.getElementsByTagName("Log");
            int j = 0;
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                // System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    res = eElement.getAttribute("Status");
                    if (res.equalsIgnoreCase("FAIL")) {
                        Stpname = "Stpname" + j;
                        hmap.put(Stpname, eElement.getAttribute("Name"));
                        j++;
                    }
                }

            }

            nList = doc.getElementsByTagName("Log");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ar;
    }

    public static void sendAttachmentEmail(String toEmail, String subject, String body) throws IOException {
        try {
            final String fromEmail = "kg.automation.rundetails@gmail.com";
            final String password = "Sorryboss@1";
            //System.out.println("SSLEmail Start");
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };

            Session session = Session.getDefaultInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("kg.automation.rundetails@gmail.com", "KG_Automation_Run_Details"));
            msg.setReplyTo(InternetAddress.parse("kg.automation.rundetails@gmail.com", false));
            msg.setSubject(subject, "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            String workingDirectory = new java.io.File(".").getCanonicalPath();
            String path = workingDirectory + "/Automation_Summary";
            String file1 = path + "/" + hmap.get(suitename) + ".xlsx";
            String filename = file1;
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(source.getName());
            multipart.addBodyPart(messageBodyPart);
            msg.setContent(multipart);
            Transport.send(msg);
            System.out.println("EMail Sent Successfully with attachment!!");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static Boolean StaleElementClick(WebDriver webdriver, String parameters) throws Exception {
        Boolean Status = true;
        int attempts = 0;
        String[] arguments = null;
        arguments = splitfunction(parameters, "->");
        //WebElement locator = Getlocator(driver, arguments[1]);
        WebElement locator = null;
        if (arguments[1].matches(".*:.*")) {
            locator = Getlocator(driver, arguments[1]);
        } else {

            locator = getlocatorKeyValue(driver, arguments[1]);
        }
        while ((true) || (attempts > 10)) {
            try {
                locator.click();
                Status = true;
                break;
            } catch (StaleElementReferenceException e) {
                if (e.getMessage().contains("element is not attached")) {
                    Status = false;
                }
                attempts++;
            }
            if (Status) {
                locator.click();
                ReportFunctions.LogRepoter("Pass", "StaleElementClick", "Sucessfully clicked on" + arguments[2]);
                break;
            } else {
                ReportFunctions.LogRepoter("Fail", "StaleElementClick", "Failed to clic on" + arguments[2]);
            }
        }
        return Status;
    }

    public static boolean LOGIN(WebDriver WebDriver, String parameters) throws Exception {
        boolean status;
        String[] arguments = splitfunction(parameters, "->");
        String[] arguments1 = splitfunction(arguments[1], "\\|");
        String username = "id:=username";
        String tenant = "id:=tenant";
        String password = "id:=password";
        String submit = "id:=loginBtn";
        LAUNCHBROWSER(driver, arguments[1]);
        INVISIBLEOFLOAD(driver);
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement userid = Getlocator(driver, username);
        WebElement tenantid = Getlocator(driver, tenant);
        WebElement pwd = Getlocator(driver, password);
        WebElement submitbtn = Getlocator(driver, submit);
        INVISIBLEOFLOAD(driver);
        wait.until(ExpectedConditions.elementToBeClickable(userid));
        if (hmap.containsKey(arguments[2])) {
            value = hmap.get(arguments[2]);
        } else {
            value = arguments[2];
        }
        userid.sendKeys(value);
        tenantid.clear();
        if (hmap.containsKey(arguments[3])) {
            value = hmap.get(arguments[3]);
        } else {
            value = arguments[3];
        }
        tenantid.sendKeys(value);
        submitbtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(userid));
        INVISIBLEOFLOAD(driver);
        wait.until(ExpectedConditions.elementToBeClickable(pwd));
        if (hmap.containsKey(arguments[4])) {
            value = hmap.get(arguments[4]);
        } else {
            value = arguments[4];
        }
        pwd.sendKeys(value);
        submitbtn.click();
        Thread.sleep(5000);
        boolean status1 = driver.findElements(By.xpath("//i[contains(@class,'fa-bars')]")).size() > 0;
        if (status1) {
            System.out.println("Successfully loged in with the user" + " " + hmap.get(arguments1[0]));
            ReportFunctions.LogRepoter("pass", "Login with user credentials",
                    "Successfully loged in with the user" + " " + hmap.get(arguments1[0]));
            status = true;
        } else {
            System.out.println("login was not successful");
            ReportFunctions.LogRepoter("Fail", "Login with user credentials", "login was not successful");
            status = false;
        }
        return status;
    }

    public static boolean VERIFYDATA(String Parameters) throws Exception {
        boolean flag = true;
        LOGIN(driver, Parameters);
        try {
            WebDriverWait wait = new WebDriverWait(driver, 500);
            boolean status = driver.findElements(By.xpath("//img[contains(@src,'not_supported')]")).size() > 0;
            if (status) {
                System.out.println("No Data is Available");
                ReportFunctions.LogRepoter("Fail", "No Data Available Page is Displayed",
                        "No Data Available Page is Displayed");
                flag = false;
                CLOSEALLBROWSERS(driver);
            } else {
                System.out.println("Data is Available");
                ReportFunctions.LogRepoter("pass", "Data is Available", "Data is Available");
                CLOSEALLBROWSERS(driver);
            }
            //Check_data();
            return true;

        } catch (Exception e) {
            System.out.println("unable to find the locator" + " " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "close pop up", "Loader image is still present");
            CLOSEALLBROWSERS(driver);
            return false;

        }

    }

    public static boolean COMPAREVALUE(WebDriver webdriver, String parameters) {
        flag = 1;
        String[] arguments = null;
        arguments = splitfunction(parameters, "->");
        String value = null;
        String ovalue = null;
        try {

            if (arguments[1].contains("+")) {
                String[] arguments1 = splitfunction(arguments[1], "+");
                String[] arguments2 = splitfunction(arguments1[1], "+");
                String newval = arguments2[0];
                if (hmap.containsKey(newval)) {
                    String revalue = hmap.get(newval);
                    arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                    if (arguments[1].contains("+")) {
                        arguments1 = splitfunction(arguments[1], "+");
                        arguments2 = splitfunction(arguments1[1], "+");
                        newval = arguments2[0];
                        if (hmap.containsKey(newval)) {
                            revalue = hmap.get(newval);
                            arguments[1] = arguments[1].replace("+" + newval + "+", revalue);

                        } else {
                            ReportFunctions.LogRepoter("Fail", "wait for the element", "key not found in hashmap");
                            return false;
                        }
                    }

                }
            }
            if (hmap.containsKey(arguments[1])) {
                ovalue = hmap.get(arguments[1]);
                float test = Float.valueOf(ovalue);
                ovalue = String.valueOf(test);
            }
            if (hmap.containsKey(arguments[2])) {
                value = hmap.get(arguments[2]);
            }

            if (value.equalsIgnoreCase("IS NOT NULL")) {
                int len = ovalue.length();
                if (len > 0) {
                    ReportFunctions.LogRepoter("pass", "verify Value_Notnull",
                            "captured the value:  " + ovalue + " and its not null");
                } else {
                    ReportFunctions.LogRepoter("Fail", "verify Value_Notnull", "captured value is null");
                    flag = 0;

                }
            } else {
                if (ovalue.equalsIgnoreCase(value)) {
                    System.out.println("Both values mathes");
                    ReportFunctions.LogRepoter("pass", "verified  " + arguments[2] + "  value",
                            "Both values matches " + ovalue + " and " + value);
                } else {
                    System.out.println("Values did not match");
                    ReportFunctions.LogRepoter("Fail", "verified  " + arguments[2] + "  value",
                            "Both values did not match " + ovalue + " and " + value);
                    // CLOSEALLBROWSERS(driver);
                    flag = 0;
                }
            }
        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "verify both values", "unable to find the locator");
            // CLOSEALLBROWSERS(driver);
            flag = 0;
        }
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean SwitchDefault(WebDriver WebDriver) throws InterruptedException {

        driver.switchTo().defaultContent();
        ReportFunctions.LogRepoter("Pass", "move to default content", "Successfully moved to default content");
        return true;
    }

    public static boolean ValidateFilter(WebDriver WebDriver, String parameters) throws InterruptedException, Exception, StaleElementReferenceException, IOException {

        //parameters="ValidateFilter->Transaction Start Date&Transaction End Date&Transaction Type&Organization&Subinventory&Item&Site&Department&Employee->sysdate-10,MM-DD-YYYY&sysdate,MM-DD-YYYY&PRIME SHINE WAREHOUSE&IT SHOP WAREHOUSE&PENS&PSX10--10 - WWHQ&Fin - Finance&EE96104 - AGUILAR, ALBERT";
        Boolean status = true;
        String[] args;
        String[] args1;
        int ubound;
        int ubound1;
        Boolean flag = false;
        String filter = "xpath:=//img[@id=\"prompts-button-bottom\"]";
        String go = "xpath:=//input[@class=\"btn btn-primary promptsGoBtn\"]";
        String Reset = "xpath:=//input[@class=\"btn btn-primary promptsResetBtn\"]";
        String Cdate = "xpath:=//td[text()=\"Transaction Start Date\"]";
        String Edate = "xpath:=//input[@class=\"promptDatePicker\"]";
        String search = "xpath:=//input[@id=\"prompt_search\"]";
        try {
            String[] arguments = splitfunction(parameters, "->");
            args = splitfunction(arguments[2], "&");
            args1 = splitfunction(arguments[3], "&");
            String allchoices = "xpath:=//input[@value=\"All Choices\"]";
            ubound = args.length;
            ubound1 = args1.length;
            WebElement Filters = Getlocator(driver, filter);
            if (Filters != null) {
                Filters.click();
                WAITFORELEMENT(driver, "waitforelement->xpath:=//input[@class=\"btn btn-primary promptsResetBtn\"]->Reset");
                WebElement Resets = Getlocator(driver, Reset);
                if (Resets != null) {
                    Resets.click();
                    if (ubound == ubound1) {
                        for (int i = 0; i <= ubound - 1; i++) {
                            String xpath = "xpath:=//td[text()=\"" + args[i] + "\"]";
                            WebElement filtername = Getlocator(driver, xpath);
                            if (filtername != null) {
                                WAITTIME("WAITTIME->2");
                                filtername.click();
                                WAITTIME("WAITTIME->2");
                                if (args1[i].toUpperCase().contains("SYSDATE")) {
                                } else {
                                    WAITFORELEMENT(driver, "waitforelement->xpath:=//input[@value=\"All Choices\"]->search");
                                }
                                ReportFunctions.LogRepoter("Pass", "Click on filter name", "Successfully clicked on filter name  " + args[i]);
                                WebElement Searchs = Getlocator(driver, "xpath:=//input[@id=\"prompt_search\"]");
                                WebElement allchoice = Getlocator(driver, allchoices);
                                WebElement Filtervalue = Getlocator(driver, "xpath:=//div[contains(text(),'" + args1[i] + "')]");
                                if (args1[i].toUpperCase().contains("SYSDATE")) {
                                    WebElement datepicker = Getlocator(driver, "xpath:=//input[@class=\"promptDatePicker\"]");
                                    WAITFORELEMENT(driver, "waitforelement->xpath:=//input[@class=\"promptDatePicker\"]->datepicker");
                                    String sysdat = Sysdate(args1[i]);
                                    datepicker.clear();
                                    WAITTIME("WAITTIME->2");
                                    datepicker.sendKeys(sysdat);
                                } else {
                                    WAITTIME("WAITTIME->2");
                                    WAITFORELEMENT(driver, "waitforelement->" + search + "->Searchbox");
                                    WAITFORELEMENT(driver, "waitforelement->" + allchoices + "->All choices");
                                    if (allchoice != null) {
                                        allchoice.click();
                                        WAITTIME("WAITTIME->2");
                                        allchoice.click();
                                        ReportFunctions.LogRepoter("Pass", "Click on All choices check box 2 times", "Successfully clicked on All choices check box 2 times");
                                        if (Searchs != null) {
                                            if (args1[i].contains("and")) {
                                                String[] mulargs = splitfunction(args1[i], "and");
                                                int len = mulargs.length;
                                                for (int k = 0; k <= len - 1; k++) {
                                                    Searchs.clear();
                                                    WAITTIME("WAITTIME->2");
                                                    Searchs.sendKeys(mulargs[k]);
                                                    WAITTIME("WAITTIME->2");
                                                    ReportFunctions.LogRepoter("Pass", "enter value in search box", "Successfully entered value in search box   " + mulargs[k]);
                                                    // WAITFORELEMENT(driver, "waitforelement->xpath:=//div[contains(text(),'" + mulargs[k] + "')]->" + mulargs[k] + "");
                                                    flag = StaleElementClick(driver, "StaleElementClick->xpath:=//div[contains(text(),'" + mulargs[k] + "')]->" + mulargs[k] + "");
                                                    WAITTIME("WAITTIME->2");
                                                }
                                            } else {
                                                Searchs.sendKeys(args1[i]);
                                                ReportFunctions.LogRepoter("Pass", "enter value in search box", "Successfully entered value in search box   " + args1[i]);
                                                WAITFORELEMENT(driver, "waitforelement->xpath:=//div[contains(text(),'" + args1[i] + "')]->" + args1[i] + "");
                                                flag = StaleElementClick(driver, "StaleElementClick->xpath:=//div[contains(text(),'" + args1[i] + "')]->" + args1[i] + "");
                                            }
                                            if (flag == true) {
                                                ReportFunctions.LogRepoter("Pass", "Select filter value", "Successfully selected filter value  " + args1[i]);
                                                WAITTIME("WAITTIME->2");
                                            } else {
                                                ReportFunctions.LogRepoter("Fail", "Select filter value", "unable to find filter value");
                                                status = false;
                                            }
                                        } else {
                                            ReportFunctions.LogRepoter("Fail", "Enter value in search Prompt", "unable to find search text box");
                                            status = false;
                                        }

                                    } else {
                                        ReportFunctions.LogRepoter("Fail", "Click on All Choices", "Unable to find All Choices check box");
                                        status = false;
                                    }
                                }
                            } else {
                                ReportFunctions.LogRepoter("Fail", "Click on filter name", "Unable to find filter name  " + args[i]);
                                status = false;
                            }
                        }
                        WebElement goes = Getlocator(driver, go);
                        if (goes != null) {
                            goes.click();
                            INVISIBLEOFLOAD(driver);
                            WAITTIME("WAITTIME->2");
                            ReportFunctions.LogRepoter("Pass", "Click on GO", "Successfully clicked on  GO button");
                            WAITFORELEMENT(driver, "waitforelement->xpath:=//input[@class=\"searchTableX\"]->Search");
                        } else {
                            ReportFunctions.LogRepoter("Fail", "Click on GO", "Unable to find GO button");
                            status = false;
                        }

                    } else {
                        ReportFunctions.LogRepoter("Fail", "Select filers", "Filter names and values are not equal");
                        status = false;
                    }
                } else {
                    ReportFunctions.LogRepoter("Fail", "Click on Resut button", "unable to find Reset button");
                    status = false;
                }

            } else {
                ReportFunctions.LogRepoter("Fail", "Click on filter icon", "unable to find filter icon");
                status = false;
            }
        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "validate Filter", "unable to find the locator");
            status = false;
        }

        return status;
    }

    public static boolean Validatedate(WebDriver WebDriver, String parameters) throws InterruptedException, Exception {
        Boolean status = true;
        String arguments[] = splitfunction(parameters, "->");
        String args1[] = splitfunction(arguments[3], ",");
        String format = args1[1];
        String d1 = Sysdate(arguments[3]);
        //WebElement locator = Getlocator(driver, arguments[1]);
        WebElement locator = null;
        if (arguments[1].matches(".*:.*")) {
            locator = Getlocator(driver, arguments[1]);
        } else {

            locator = getlocatorKeyValue(driver, arguments[1]);
        }
        if (locator != null) {
            String d2 = locator.getText();
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            try {
                Date date1 = formatter.parse(d1);
                Date date2 = formatter.parse(d2);
                String x = formatter.format(date1);
                String y = formatter.format(date2);
                if (arguments[2].toUpperCase().equalsIgnoreCase("LESSER")) {
                    boolean a = (date2.before(date1) || date2.equals(date1));
                    if (a == true) {
                        ReportFunctions.LogRepoter("pass", "veify dates after applying filters", "UI date is less than or equal to " + d1 + "and UI date is" + d2);
                    } else {
                        ReportFunctions.LogRepoter("Fail", "veify dates after applying filters", "UI date is not less than or equal to " + d1 + "and UI date is" + d2);
                        status = false;
                    }
                } else if (arguments[2].toUpperCase().equalsIgnoreCase("GREATER")) {
                    boolean b = (date2.after(date1) || date2.equals(date1));
                    if (b == true) {
                        ReportFunctions.LogRepoter("pass", "veify dates after applying filters", "UI date is greater than or equal to " + d1 + "and UI date is" + d2);
                    } else {
                        ReportFunctions.LogRepoter("Fail", "veify dates after applying filters", "UI date is not greater than or equal to " + d1 + "and UI date is" + d2);
                        status = false;
                    }
                } else {
                    ReportFunctions.LogRepoter("Fail", "veify dates after applying filters", "Please specify lesser or greater");
                    status = false;
                }
            } catch (Exception e) {
                ReportFunctions.LogRepoter("Fail", "veify dates after applying filters", "different date format:: date is not in " + format + "\"   format");
                status = false;
            }
        } else {
            ReportFunctions.LogRepoter("Fail", "Get date from UI", "unable to find date xpath");
            status = false;
        }
        return status;
    }

    public static boolean ValidatePrompt(WebDriver WebDriver, String parameters) throws InterruptedException, Exception {
        Boolean status = true;
        int ubound;
        int ubound1;
        String[] arguments = splitfunction(parameters, "->");
        String[] args = splitfunction(arguments[2], "&");
        String allchoices = "xpath:=//input[@value=\"All Choices\"]";
        ubound = args.length;
        String[] args1 = splitfunction(arguments[3], "&");
        ubound1 = args1.length;
        String Reset = "xpath:=//button[@name=\"reset\"]";
        String search = "xpath:=//input[@id=\"prompt_search\"]";
        String Apply = "xpath:=//button[contains(text(),'Reset')]/parent::div/preceding-sibling::div//button[contains(text(),'Apply')]";
        String Done = "xpath:=//button[@id=\"done\"]/b";
        WebElement Resets = Getlocator(driver, Reset);
        if (Resets != null) {
            Resets.click();
            if (ubound == ubound1) {
                for (int i = 0; i <= ubound - 1; i++) {
                    String Promtname = "xpath:=//input[@placeholder=\"" + args[i] + "\"]";
                    WebElement Promtnames = Getlocator(driver, Promtname);
                    if (Promtnames != null) {
                        Promtnames.click();
                        ReportFunctions.LogRepoter("Pass", "Click on Prompt feild", "Sucessfully clicked on prompt  " + args[i]);
                        WAITTIME("WAITTIME->4");
                        //WAITFORELEMENT(driver, "waitforelement->" + allchoices + "->All choices");
                        WebElement allchoice = Getlocator(driver, allchoices);
                        if (allchoice != null) {
                            allchoice.click();
                            WAITTIME("WAITTIME->2");
                            allchoice.click();
                        }
                        WebElement searchs = Getlocator(driver, search);
                        if (searchs != null) {
                            if (args1[i].contains("and")) {
                                String[] mulargs = splitfunction(args1[i], "and");
                                int len = mulargs.length;
                                for (int k = 0; k <= len - 1; k++) {
                                    searchs.clear();
                                    WAITTIME("WAITTIME->2");
                                    searchs.sendKeys(mulargs[k]);
                                    WAITTIME("WAITTIME->2");
                                    ReportFunctions.LogRepoter("Pass", "enter value in search box", "Successfully entered value in search box   " + mulargs[k]);
                                    String Promptvalue = "xpath:=//input[contains(@value,'" + mulargs[k] + "')]";
                                    WebElement Promptvalues = Getlocator(driver, Promptvalue);
                                    if (Promptvalues != null) {
                                        Promptvalues.click();
                                        ReportFunctions.LogRepoter("Pass", "Select Prompt value", "Sucessfully selected prompt value  " + mulargs[k]);
                                        WAITTIME("WAITTIME->2");

                                    } else {
                                        ReportFunctions.LogRepoter("Fail", "Select Prompt value", "Unable to find prompt value  " + mulargs[k]);
                                        status = false;
                                    }
                                }
                                WebElement Dones = Getlocator(driver, Done);
                                if (Dones != null) {
                                    Dones.click();
                                    ReportFunctions.LogRepoter("Pass", "Click on Done", "Sucessfully clicked on Done");
                                    WAITTIME("WAITTIME->2");
                                    INVISIBLEOFLOAD(driver);
                                } else {
                                    ReportFunctions.LogRepoter("Fail", "Click on Done", "Successfully clicked on Done");
                                }
                            } else {
                                searchs.sendKeys(args1[i]);
                                ReportFunctions.LogRepoter("Pass", "Enter Prompt value in search feild", "Sucessfully entered value in Search Feild  " + args1[i]);
                                WAITTIME("WAITTIME->2");
                                String Promptvalue = "xpath:=//input[contains(@value,'" + args1[i] + "')]";
                                WebElement Promptvalues = Getlocator(driver, Promptvalue);
                                if (Promptvalues != null) {
                                    Promptvalues.click();
                                    ReportFunctions.LogRepoter("Pass", "Select Prompt value", "Sucessfully selected prompt value  " + args1[i]);
                                    WAITTIME("WAITTIME->2");
                                    WebElement Dones = Getlocator(driver, Done);
                                    if (Dones != null) {
                                        Dones.click();
                                        ReportFunctions.LogRepoter("Pass", "Click on Done", "Sucessfully clicked on Done");
                                        WAITTIME("WAITTIME->2");
                                        INVISIBLEOFLOAD(driver);
                                    } else {
                                        ReportFunctions.LogRepoter("Fail", "Click on Done", "Successfully clicked on Done");
                                    }
                                } else {
                                    ReportFunctions.LogRepoter("Fail", "Select Prompt value", "Unable to find prompt value  " + args1[i]);
                                    status = false;
                                }
                            }
                        } else {
                            ReportFunctions.LogRepoter("Fail", "Enter value in Seach", "Unable to find Search feild");
                            status = false;
                        }
                    } else {
                        ReportFunctions.LogRepoter("Fail", "Click on Promt name", "Unable to find Prompt name  " + args[i]);
                        status = false;
                    }
                }
                WebElement Applies = Getlocator(driver, Apply);
                if (Applies != null) {
                    Applies.click();
                    ReportFunctions.LogRepoter("Pass", "Click on Apply", "Sucessfully clicked on Apply");
                    WAITTIME("WAITTIME->2");
                    INVISIBLEOFLOAD(driver);
                } else {
                    ReportFunctions.LogRepoter("Fail", "Click on Apply", "Successfully clicked on Apply button");
                }
            } else {
                ReportFunctions.LogRepoter("Fail", "validate Prompts", "Prompt names and values are not equal");
                status = false;
            }

        } else {
            ReportFunctions.LogRepoter("Fail", "Click on Resut button", "unable to find Reset button");
            status = false;
        }

        return status;
    }

    public static Boolean Storesinglevalue(String Parameters) throws Exception {
        Boolean Status = true;
        String[] arguments = splitfunction(Parameters, "->");
        hmap.put(arguments[1], arguments[2]);
        ReportFunctions.LogRepoter("Pass", "Storevalue", "Successfully stored the value " + arguments[2] + " in " + " " + arguments[1]);
        return Status;
    }

    public static Boolean verifydashboard(WebDriver WebDriver, String Parameters) throws Exception {
        Boolean Status = true;
        Boolean newstatus = true;
        int temp1 = 0;
        int sanitycntname = 1;

        String[] arguments = splitfunction(Parameters, "->");
        String xpath = "xpath:=(//div[text()=\"" + arguments[1] + "\"])[2]";
        String xpath1 = "xpath:=//b[text()=\"No Data Available\"]";
        WebElement message = Getlocator(driver, xpath1);
        WebElement dashboard = Getlocator(driver, xpath);
        if (message != null) {
            ReportFunctions.LogRepoter("Fail", "verify NO DATA AVAILABLE message", " NO DATA AVAILABLE");
            Status = false;
            // CLOSEALLBROWSERS(driver);
        } else if (dashboard == null) {
            ReportFunctions.LogRepoter("Fail", "verify dash board name", "unable to find dash board name  " + arguments[1]);
            Status = false;
            // CLOSEALLBROWSERS(driver);
        } else {
            ReportFunctions.LogRepoter("Pass", "verify dash board", "Found the dash board  " + arguments[1]);
        }

        String TCname = hmap.get(Tcase);

        if ((sanitycntname == 1) && (TCname != sanitymap.get(temp1))) {
            sanitymap.put(temp1, TCname);
            int x = TChmap.get(TCname);
            if (Status) {
                sanitydash = 999 + x;
                sanitymap.put(sanitydash, "Pass");
            } else {
                sanitydash = 999 + x;
                sanitymap.put(sanitydash, "Fail");
            }
            sanitycntname = sanitycntname + 1;
            tempnum = sanitydash;
            newstatus = Status;
        } else {
            if ((sanitymap.get(temp1).equalsIgnoreCase(TCname)) && (newstatus != Status)) {
                sanitymap.put(tempnum, "Fail");
            }
        }

        return Status;

    }

    public static Boolean ExportExcel(WebDriver WebDriver, String Parameters) throws Exception {
        Boolean Status = true;
        Boolean flag = true;
        String tcasename = null;
        Boolean excelverification = true;
        Boolean mfiltval = false;
        Boolean finalflag = true;
        Boolean colnam = false;
        String[] myFiles = null;
        File myFile = null;
        File Sfolder;
        File[] listofsfiles;
        String fname;
        String colname = null;
        String cellvalue = null;
        int colnum = 0;
        int count = 0;
        int bound1 = 0;
        int bound2 = 0;
        String[] arguments = splitfunction(Parameters, "->");
        if (hmap.containsKey(arguments[2])) {
            arguments[2] = hmap.get(arguments[2]);
        }
        if (hmap.containsKey(arguments[3])) {
            arguments[3] = hmap.get(arguments[3]);
        }
        try {

            String xpath = "xpath:=//img[@title=\"Export to Excel\"]";
            String username = System.getProperty("user.name");
            String filepath = "C:/Users/" + username + "/Downloads";
            Sheet exportsheet;
            int envrowcount;
            int envcolcount;
            WAITFORELEMENT(driver, "waitforelement->xpath:=//img[@title=\"Export to Excel\"]->Export to excel");
            WebElement excellink = Getlocator(driver, xpath);
            Sfolder = new File(filepath);
            listofsfiles = Sfolder.listFiles();
            if (Sfolder.isDirectory()) {
                myFiles = Sfolder.list();
                for (int k = 0; k < myFiles.length; k++) {
                    myFile = new File(Sfolder, myFiles[k]);
                    myFile.delete();
                }
            }
            if (excellink != null) {
                excellink.click();
                WAITTIME("WAITTIME->5");
                Sfolder = new File(filepath);
                listofsfiles = Sfolder.listFiles();
                myFiles = Sfolder.list();
                if (myFiles.length == 1) {
                    ReportFunctions.LogRepoter("Pass", "Download excel", "Excel downloaded successfully");
                    myFile = new File(Sfolder, myFiles[0]);
                    fname = myFile.getName();
                    filepath = filepath + "/" + fname;
                    FileInputStream envfs = new FileInputStream(filepath);
                    ZipSecureFile.setMinInflateRatio(-1.0d);
                    Workbook envwb = new XSSFWorkbook(envfs);
                    exportsheet = envwb.getSheetAt(0);
                    envrowcount = exportsheet.getLastRowNum();
                    envcolcount = exportsheet.getRow(envrowcount).getLastCellNum();
                    if (arguments[2].contains("&")) {
                        String[] args1 = splitfunction(arguments[2], "&");
                        bound1 = args1.length;
                        String[] args2 = splitfunction(arguments[3], "&");
                        bound2 = args2.length;
                        if (bound1 == bound2) {
                            for (int i = 0; i <= bound1 - 1; i++) {
                                colnam = false;
                                for (int colval = 0; colval <= envcolcount - 1; colval++) {
                                    Row ro = exportsheet.getRow(0);
                                    if ((ro != null)) {
                                        Cell cell1 = exportsheet.getRow(0).getCell(colval);
                                        colname = cell1.getStringCellValue();
                                        if (colname.equalsIgnoreCase(args1[i])) {
                                            colnum = colval;
                                            colnam = true;
                                            break;
                                        }
                                    }
                                }
                                if (colnam == false) {
                                    ReportFunctions.LogRepoter("Fail", "Get Column Name", "Unable to get Column name  " + args1[i]);
                                    finalflag = false;
                                    Status = false;
                                } else {
                                    finalflag = true;
                                    for (int Rowval = 1; Rowval <= envrowcount; Rowval++) {
                                        Row ro = exportsheet.getRow(Rowval);
                                        if ((ro != null)) {
                                            Cell cell1 = exportsheet.getRow(Rowval).getCell(colnum);
                                            cellvalue = cell1.getStringCellValue();
                                            if (args2[i].toUpperCase().contains("SYSDATE")) {
                                                String[] dates = splitfunction(args2[i], "and");
                                                String[] format = splitfunction(dates[0], ",");
                                                SimpleDateFormat formatter = new SimpleDateFormat(format[1]);
                                                String sysdat1 = Sysdate(dates[0]);
                                                Date date1 = formatter.parse(sysdat1);
                                                String sysdat2 = Sysdate(dates[1]);
                                                Date date2 = formatter.parse(sysdat2);
                                                cellvalue = cell1.getStringCellValue();
                                                Date odate = formatter.parse(cellvalue);
                                                boolean a = odate.before(date2) && odate.after(date1);
                                                boolean b = odate.equals(date2) || odate.equals(date1);
                                                if (a || b) {
                                                } else {
                                                    ReportFunctions.LogRepoter("Fail", "Verify Date Range", "Date mismatched: date range =   " + sysdat1 + " and " + sysdat2 + "  actual date = " + cellvalue + "  found in row = " + Rowval);
                                                    count = count + 1;
                                                    flag = false;
                                                    finalflag = false;
                                                    Status = false;
                                                }
                                            } else if (args2[i].contains("and")) {
                                                String[] FilVals = splitfunction(args2[i], "and");
                                                int fbound = FilVals.length;
                                                for (int f = 0; f <= fbound - 1; f++) {
                                                    if (cellvalue.equalsIgnoreCase(FilVals[f])) {
                                                        mfiltval = true;
                                                        break;
                                                    }
                                                }
                                                if (mfiltval == false) {
                                                    ReportFunctions.LogRepoter("Fail", "Verify value", "value mismatched: actual value =   " + cellvalue + "  and expected value = " + FilVals[0] + " or" + FilVals[1]);
                                                    count = count + 1;
                                                    finalflag = false;
                                                    Status = false;
                                                }
                                            } else {
                                                if (cellvalue.equalsIgnoreCase(args2[i])) {
                                                } else {
                                                    ReportFunctions.LogRepoter("Fail", "Verify value", "value mismatched: actual value =   " + cellvalue + "  and expected value = " + args2[i]);
                                                    count = count + 1;
                                                    flag = false;
                                                    finalflag = false;
                                                    Status = false;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (finalflag == true) {
                                    ReportFunctions.LogRepoter("Pass", "Verify value", "All values matched for column name " + colname);
                                } else {
                                    ReportFunctions.LogRepoter("fail", "Values mismatched for column name ", "Total values mismatched  " + count + " and column name:= " + colname);
                                    Status = false;
                                }
                            }
                        } else {
                            ReportFunctions.LogRepoter("fail", "Veify column name and values", "Column names and values did not match");
                            Status = false;
                        }
                    } else {
                        colnam = false;
                        for (int colval = 0; colval <= envcolcount - 1; colval++) {
                            Row ro = exportsheet.getRow(0);
                            if ((ro != null)) {
                                Cell cell1 = exportsheet.getRow(0).getCell(colval);
                                colname = cell1.getStringCellValue();
                                if (colname.equalsIgnoreCase(arguments[2])) {
                                    colnum = colval;
                                    colnam = true;
                                    break;
                                }
                            }
                        }
                        if (colnam == false) {
                            ReportFunctions.LogRepoter("Fail", "Get Column Name", "Unable to get Column name  " + arguments[2]);
                            finalflag = false;
                            Status = false;
                        } else {
                            finalflag = true;
                            for (int Rowval = 1; Rowval <= envrowcount; Rowval++) {
                                mfiltval = false;
                                Row ro = exportsheet.getRow(Rowval);
                                if ((ro != null)) {
                                    Cell cell1 = exportsheet.getRow(Rowval).getCell(colnum);
                                    cellvalue = cell1.getStringCellValue();
                                    if (arguments[3].toUpperCase().contains("SYSDATE")) {
                                        String[] dates = splitfunction(arguments[3], "and");
                                        String[] format = splitfunction(dates[0], ",");
                                        SimpleDateFormat formatter = new SimpleDateFormat(format[1]);
                                        String sysdat1 = Sysdate(dates[0]);
                                        Date date1 = formatter.parse(sysdat1);
                                        String sysdat2 = Sysdate(dates[1]);
                                        Date date2 = formatter.parse(sysdat2);
                                        cellvalue = cell1.getStringCellValue();
                                        Date odate = formatter.parse(cellvalue);
                                        boolean a = odate.before(date2) && odate.after(date1);
                                        boolean b = odate.equals(date2) || odate.equals(date1);
                                        if (a || b) {
                                        } else {
                                            ReportFunctions.LogRepoter("Fail", "Verify Date Range", "Date mismatched: date range =   " + sysdat1 + " and " + sysdat2 + "  actual date = " + cellvalue + "  found in row = " + Rowval);
                                            count = count + 1;
                                            flag = false;
                                            finalflag = false;
                                        }
                                    } else {
                                        if (arguments[3].contains("and")) {
                                            String[] FilVals = splitfunction(arguments[3], "and");
                                            int fbound = FilVals.length;
                                            for (int f = 0; f <= fbound - 1; f++) {
                                                if (cellvalue.equalsIgnoreCase(FilVals[f])) {
                                                    mfiltval = true;
                                                    break;
                                                }
                                            }
                                            if (mfiltval == false) {
                                                ReportFunctions.LogRepoter("Fail", "Verify value", "value mismatched: actual value =   " + cellvalue + "  and expected value = " + FilVals[0] + " or" + FilVals[1]);
                                                count = count + 1;
                                                finalflag = false;
                                            }

                                        } else if (cellvalue.equalsIgnoreCase(arguments[3])) {
                                        } else {
                                            ReportFunctions.LogRepoter("Fail", "Verify value", "value mismatched: actual value =   " + cellvalue + "  and expected value = " + arguments[3]);
                                            count = count + 1;
                                            flag = false;
                                            finalflag = false;
                                        }
                                    }
                                }
                            }
                            if (finalflag == true) {
                                ReportFunctions.LogRepoter("Pass", "Verify value", "All values matched for column name " + colname);
                            } else {
                                ReportFunctions.LogRepoter("fail", "Values mismatched for column name ", "Total values mismatched  " + count + " and column name:= " + colname);
                                Status = false;
                            }
                        }
                    }
                } else {
                    ReportFunctions.LogRepoter("Fail", "Download excel", "Failed to download excel");
                    Status = false;
                }
            } else {
                ReportFunctions.LogRepoter("Pass", "Click Excel Export link", "unable to find  Export to excel link");
                Status = false;
            }
            if (Status == true) {
                myFile.delete();
            }
        } catch (Exception e) {
            System.out.println("exception" + e);
            ReportFunctions.LogRepoter("Fail", "excel verification", "exception" + e);
            Status = false;
        }
        String Vname = arguments[1];
        switch (Vname.toUpperCase()) {
            case "VALIDATEPROMPTTEXT":
                Boolean newstatus = true;
                int temp10 = 100;
                int sanitycntname = 1;
                String TCname = hmap.get(Tcase);
                if ((sanitycntname == 1) && (TCname != sanitymap.get(temp10))) {
                    sanitymap.put(temp10, TCname);
                    int x = TChmap.get(TCname);
                    if (Status) {
                        sanityVerifyOnPagePromptswithText = 4999 + x;
                        sanitymap.put(sanityVerifyOnPagePromptswithText, "Pass");
                    } else {
                        sanityVerifyOnPagePromptswithText = 4999 + x;
                        sanitymap.put(sanityVerifyOnPagePromptswithText, "Fail");
                    }
                    sanitycntname = sanitycntname + 1;
                    tempnum = sanityVerifyOnPagePromptswithText;
                    newstatus = Status;
                } else {
                    if ((sanitymap.get(temp10).equalsIgnoreCase(TCname)) && (newstatus != Status)) {
                        sanitymap.put(tempnum, "Fail");
                    }
                }
                break;
            case "VALIDATETEXTFILTER":
                newstatus = true;
                int temp13 = 103;
                sanitycntname = 1;
                TCname = hmap.get(Tcase);
                if ((sanitycntname == 1) && (TCname != sanitymap.get(temp13))) {
                    sanitymap.put(temp13, TCname);
                    int x = TChmap.get(TCname);
                    if (Status) {
                        sanityVerifyFilterswithText = 2999 + x;
                        sanitymap.put(sanityVerifyFilterswithText, "Pass");
                    } else {
                        sanityVerifyFilterswithText = 2999 + x;
                        sanitymap.put(sanityVerifyFilterswithText, "Fail");
                    }
                    sanitycntname = sanitycntname + 1;
                    tempnum = sanityVerifyFilterswithText;
                    newstatus = Status;
                } else {
                    if ((sanitymap.get(temp13).equalsIgnoreCase(TCname)) && (newstatus != Status)) {
                        sanitymap.put(tempnum, "Fail");
                    }
                }
                break;
            case "VALIDATEPROMPT":
                newstatus = true;
                int temp11 = 101;
                sanitycntname = 1;
                TCname = hmap.get(Tcase);
                if ((sanitycntname == 1) && (TCname != sanitymap.get(temp11))) {
                    sanitymap.put(temp11, TCname);
                    int x = TChmap.get(TCname);
                    if (Status) {
                        sanityVerifyOnPagePromptswithLOV = 3999 + x;
                        sanitymap.put(sanityVerifyOnPagePromptswithLOV, "Pass");
                    } else {
                        sanityVerifyOnPagePromptswithLOV = 3999 + x;
                        sanitymap.put(sanityVerifyOnPagePromptswithLOV, "Fail");
                    }
                    sanitycntname = sanitycntname + 1;
                    tempnum = sanityVerifyOnPagePromptswithLOV;
                    newstatus = Status;
                } else {
                    if ((sanitymap.get(temp11).equalsIgnoreCase(TCname)) && (newstatus != Status)) {
                        sanitymap.put(tempnum, "Fail");
                    }
                }
                break;
            case "VALIDATEFILTER":
                newstatus = true;
                int temp12 = 102;
                sanitycntname = 1;
                TCname = hmap.get(Tcase);
                if ((sanitycntname == 1) && (TCname != sanitymap.get(temp12))) {
                    sanitymap.put(temp12, TCname);
                    int x = TChmap.get(TCname);
                    if (Status) {
                        sanityVerifyFilterswithLOV = 1999 + x;
                        sanitymap.put(sanityVerifyFilterswithLOV, "Pass");
                    } else {
                        sanityVerifyFilterswithLOV = 1999 + x;
                        sanitymap.put(sanityVerifyFilterswithLOV, "Fail");
                    }
                    sanitycntname = sanitycntname + 1;
                    tempnum = sanityVerifyFilterswithLOV;
                    newstatus = Status;
                } else {
                    if ((sanitymap.get(temp12).equalsIgnoreCase(TCname)) && (newstatus != Status)) {
                        sanitymap.put(tempnum, "Fail");
                    }
                }
            case "VALIDATEDATETYPE":
                newstatus = true;
                int temp18 = 210;
                sanitycntname = 1;
                TCname = hmap.get(Tcase);
                if ((sanitycntname == 1) && (TCname != sanitymap.get(temp18))) {
                    sanitymap.put(temp18, TCname);
                    int x = TChmap.get(TCname);
                    if (Status) {
                        sanityVerifyFilterswithadaterange = 5999 + x;
                        sanitymap.put(sanityVerifyFilterswithadaterange, "Pass");
                    } else {
                        sanityVerifyFilterswithadaterange = 5999 + x;
                        sanitymap.put(sanityVerifyFilterswithadaterange, "Fail");
                    }
                    sanitycntname = sanitycntname + 1;
                    tempnum = sanityVerifyFilterswithadaterange;
                    newstatus = Status;
                } else {
                    if ((sanitymap.get(temp18).equalsIgnoreCase(TCname)) && (newstatus != Status)) {
                        sanitymap.put(tempnum, "Fail");
                    }
                }
            default:
                break;
        }

        return Status;
    }

    public static boolean VerifyNew(WebDriver WebDriver, String parameters) throws InterruptedException, Exception {
        Boolean Status = false;
        Boolean newstatus = true;
        int temp5 = 40;
        int sanitycntname = 1;
        String[] arguments = splitfunction(parameters, "->");
        WebElement newbutton = Getlocator(driver, arguments[1]);
        if (newbutton != null) {
            newbutton.click();
            ReportFunctions.LogRepoter("Pass", "Click on New", "Clicked on new Button");
            INVISIBLEOFLOAD(driver);
            Boolean cancel = WAITFORELEMENT(driver, "waitforelement->xpath:=//img[contains(@id,'cancel')]->cancel");
            if (cancel) {
                WebElement cancelbutton = Getlocator(driver, "xpath:=//img[contains(@id,'cancel')]");
                cancelbutton.click();
                INVISIBLEOFLOAD(driver);
                WAITTIME("WAITTIME->3");
                WebElement popup = Getlocator(driver, "xpath:=//input[@id=\"popup_ok\"]");
                if (popup != null) {
                    popup.click();
                    INVISIBLEOFLOAD(driver);
                    WAITTIME("WAITTIME->3");
                }
                ReportFunctions.LogRepoter("Pass", "Verify New", "New page loaded successfully and clicked on cacel");
                Status = true;
            } else {
                ReportFunctions.LogRepoter("Fail", "Verify New", "Failed to load new page");
                Status = false;
            }
        } else {
            ReportFunctions.LogRepoter("Fail", "Click on New", "Unable to find new button");
        }
        String TCname = hmap.get(Tcase);

        if ((sanitycntname == 1) && (TCname != sanitymap.get(temp5))) {
            sanitymap.put(temp5, TCname);
            int x = TChmap.get(TCname);
            if (Status) {
                sanityVerifyNewformisloading = 8999 + x;
                sanitymap.put(sanityVerifyNewformisloading, "Pass");
            } else {
                sanityVerifyNewformisloading = 8999 + x;
                sanitymap.put(sanityVerifyNewformisloading, "Fail");
            }
            sanitycntname = sanitycntname + 1;
            tempnum = sanityVerifyNewformisloading;
            newstatus = Status;
        } else {
            if ((sanitymap.get(temp5).equalsIgnoreCase(TCname)) && (newstatus != Status)) {
                sanitymap.put(tempnum, "Fail");
            }
        }
        return Status;
    }

    public static boolean VerifySavedFilters(WebDriver WebDriver, String parameters) throws InterruptedException, Exception {
        Boolean newstatus = true;
        int temp4 = 30;
        int sanitycntname = 1;
        boolean status = true;
        String filter = "xpath:=//img[@id=\"prompts-button-bottom\"]";
        String Cdate = "xpath:=//td[text()=\"Transaction Start Date\"]";
        String Edate = "xpath:=//input[@class=\"promptDatePicker\"]";
        String search = "xpath:=//input[@id=\"prompt_search\"]";
        String[] arguments = splitfunction(parameters, "->");
        String[] args = splitfunction(arguments[2], "&");
        String[] args1 = splitfunction(arguments[3], "&");
        String allchoices = "xpath:=//input[@value=\"All Choices\"]";
        int ubound = args.length;
        int ubound1 = args1.length;
        WebElement Filters = Getlocator(driver, filter);
        if (Filters != null) {
            Filters.click();
            if (ubound == ubound1) {
                for (int i = 0; i <= ubound - 1; i++) {
                    String xpath = "xpath:=//td[text()=\"" + args[i] + "\"]";
                    WebElement filtername = Getlocator(driver, xpath);
                    if (filtername != null) {
                        WAITTIME("WAITTIME->2");
                        filtername.click();
                        WAITTIME("WAITTIME->2");
                        WAITFORELEMENT(driver, "waitforelement->xpath:=//input[@value=\"All Choices\"]->search");
                        ReportFunctions.LogRepoter("Pass", "Click on filter name", "Successfully clicked on filter name  " + args[i]);
                        WebElement Searchs = Getlocator(driver, "xpath:=//input[@id=\"prompt_search\"]");
                        WebElement allchoice = Getlocator(driver, allchoices);
                        WebElement Filtervalue = Getlocator(driver, "xpath:=//div[contains(text(),'" + args1[i] + "')]");
                        if (args1[i].toUpperCase().contains("SYSDATE")) {
                            WebElement datepicker = Getlocator(driver, "xpath:=//input[@class=\"promptDatePicker\"]");
                            WAITFORELEMENT(driver, "waitforelement->xpath:=//input[@class=\"promptDatePicker\"]->datepicker");
                            String sysdat = Sysdate(args1[i]);
                            datepicker.clear();
                            WAITTIME("WAITTIME->2");
                            datepicker.sendKeys(sysdat);
                        } else {
                            WAITTIME("WAITTIME->2");
                            WAITFORELEMENT(driver, "waitforelement->" + search + "->Searchbox");
                            WAITFORELEMENT(driver, "waitforelement->" + allchoices + "->All choices");
                            if (allchoice != null) {
                                // allchoice.click();
                                //allchoice.click();
                                ReportFunctions.LogRepoter("Pass", "Click on All choices check box 2 times", "Successfully clicked on All choices check box 2 times");
                                if (Searchs != null) {
                                    Searchs.sendKeys(args1[i]);
                                    ReportFunctions.LogRepoter("Pass", "enter value in search box", "Successfully entered value in search box   " + args1[i]);
                                    Boolean flag = WAITFORELEMENT(driver, "WAITFORELEMENT->xpath:=//input[@type=\"checkbox\"and@checked=\"checked\"and @value=\"" + args1[i] + "::``::" + args1[i] + "\"]->" + args1[i]);
                                    if (flag == true) {
                                        ReportFunctions.LogRepoter("Pass", "Verify saved filter", "Filter value in checked status  " + args1[i]);
                                        WAITTIME("WAITTIME->2");
                                    } else {
                                        ReportFunctions.LogRepoter("Fail", "Verify saved filter", "Filter value in not in checked status  " + args1[i]);
                                        status = false;
                                    }
                                } else {
                                    ReportFunctions.LogRepoter("Fail", "Enter value in search Prompt", "unable to find search text box");
                                    status = false;
                                }

                            } else {
                                ReportFunctions.LogRepoter("Fail", "Click on All Choices", "Unable to find All Choices check box");
                                status = false;
                            }
                        }
                    } else {
                        ReportFunctions.LogRepoter("Fail", "Click on filter name", "Unable to find filter name  " + args[i]);
                        status = false;
                    }
                }
                String go = "xpath:=//input[@class=\"btn btn-primary promptsGoBtn\"]";
                WebElement goes = Getlocator(driver, go);
                if (goes != null) {
                    goes.click();
                    INVISIBLEOFLOAD(driver);
                    WAITTIME("WAITTIME->2");
                    ReportFunctions.LogRepoter("Pass", "Click on GO", "Successfully clicked on  GO button");
                    WAITFORELEMENT(driver, "waitforelement->xpath:=//input[@class=\"searchTableX\"]->Search");
                } else {
                    ReportFunctions.LogRepoter("Fail", "Click on GO", "Unable to find GO button");
                    status = false;
                }

            } else {
                ReportFunctions.LogRepoter("Fail", "Select filers", "Filter names and values are not equal");
                status = false;
            }

        } else {
            ReportFunctions.LogRepoter("Fail", "Click on filter icon", "unable to find filter icon");
            status = false;
        }
        String TCname = hmap.get(Tcase);

        if ((sanitycntname == 1) && (TCname != sanitymap.get(temp4))) {
            sanitymap.put(temp4, TCname);
            int x = TChmap.get(TCname);
            if (status) {
                sanityVerifysavedFilterswithLOV = 6999 + x;
                sanitymap.put(sanityVerifysavedFilterswithLOV, "Pass");
            } else {
                sanityVerifysavedFilterswithLOV = 6999 + x;
                sanitymap.put(sanityVerifysavedFilterswithLOV, "Fail");
            }
            sanitycntname = sanitycntname + 1;
            tempnum = sanityVerifysavedFilterswithLOV;
            newstatus = status;
        } else {
            if ((sanitymap.get(temp4).equalsIgnoreCase(TCname)) && (newstatus != status)) {
                sanitymap.put(tempnum, "Fail");
            }
        }

        return status;
    }

    public static void Automation_Sanity_Summary() throws Exception {
        Boolean Status = true;
        String datasheet = hmap.get(suitename);

        try {
            String workingDirectory = new java.io.File(".").getCanonicalPath();
            System.out.println(workingDirectory);
            String path = workingDirectory + "/Automation_Sanity_Summary";
            File file1 = new File(path + "/" + datasheet + ".xlsx");
            File file = new File(path);
            file1.createNewFile();
            FileOutputStream fileOut = new FileOutputStream(file1);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet1;
            spreadsheet1 = workbook.createSheet(datasheet);
            XSSFRow Srow;
            XSSFCellStyle style = workbook.createCellStyle();
            style.setBorderTop(BorderStyle.DOUBLE);
            style.setBorderBottom(BorderStyle.DOUBLE);
            style.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
            XSSFFont font = workbook.createFont();
            font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
            font.setFontHeightInPoints((short) 10);
            font.setBold(true);
            font.setColor(HSSFColor.BLUE.index);
            style.setFont(font);
            Srow = spreadsheet1.createRow(0);
            XSSFCell Scell;
            Scell = Srow.createCell(0);
            Scell.setCellValue("Automation_Sanity_Summary");
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(1);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Suite Name");
            Scell = Srow.createCell(1);
            Scell.setCellValue(hmap.get(suitename));
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(2);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Suite Final Status ");
            Scell = Srow.createCell(1);
            Scell.setCellValue(hmap.get(ESuitestatus));
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(3);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Total Dashboards Executed ");
            Scell = Srow.createCell(1);
            Scell.setCellValue(casecount);
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(4);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Total Suite Execution Time");
            Scell = Srow.createCell(1);
            Scell.setCellValue(display);
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(5);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Total Dashboards Passed ");
            Scell = Srow.createCell(1);
            Scell.setCellValue(TCpasscount);
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(6);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Total Dashboards Failed ");
            Scell = Srow.createCell(1);
            Scell.setCellValue(TCfailcount);
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(7);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Release Name");
            Scell = Srow.createCell(1);
            Scell.setCellValue(releasename);
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(8);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Environment");
            Scell = Srow.createCell(1);
            Scell.setCellValue(environmentname);
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Srow = spreadsheet1.createRow(10);
            Scell = Srow.createCell(0);
            Scell.setCellValue("Dashboard Name");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(1);
            Scell.setCellValue("Verify Dashboard is Loading Successfully");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(2);
            Scell.setCellValue("Verify Filters with LOV");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(3);
            Scell.setCellValue("Verify Filters with Text");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(4);
            Scell.setCellValue("Verify On Page Prompts with LOV");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(5);
            Scell.setCellValue("Verify On Page Prompts with Text");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(6);
            Scell.setCellValue("Verify Filters with a date range");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(7);
            Scell.setCellValue("Verify saved Filters with LOV");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(8);
            Scell.setCellValue("Verify saved Filters with Text");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(9);
            Scell.setCellValue("Verify New form is loading");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(10);
            Scell.setCellValue("Verify Search");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(11);
            Scell.setCellValue("Verify FWD Actions");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(12);
            Scell.setCellValue("Verify Drills");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(13);
            Scell.setCellValue("Verify Sorting functionality");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);
            Scell = Srow.createCell(14);
            Scell.setCellValue("Verify AngularJsPages");
            style.setAlignment(HorizontalAlignment.CENTER);
            Scell.setCellStyle(style);

            int i = 11;
            int b = 0;
            XSSFRow Srow1;
            XSSFCell Scell1;
            XSSFCell Scell2;
            XSSFCell Scell3;
            XSSFFont whitefont = workbook.createFont();
            whitefont.setColor(HSSFColor.WHITE.index);
            XSSFFont blackfont = workbook.createFont();
            blackfont.setColor(HSSFColor.BLACK.index);
            XSSFCellStyle style1 = workbook.createCellStyle();
            XSSFCellStyle style2 = workbook.createCellStyle();
            XSSFCellStyle style3 = workbook.createCellStyle();
            XSSFCellStyle style4 = workbook.createCellStyle();
            style1.setFont(font);
            style1.setFont(whitefont);
            style1.setBorderBottom(BorderStyle.THIN);
            style2.setFont(font);
            style2.setFont(whitefont);
            style2.setBorderBottom(BorderStyle.THIN);
            style3.setFont(font);
            style3.setFont(blackfont);
            style3.setBorderBottom(BorderStyle.THIN);
            style4.setFont(font);
            style4.setFont(blackfont);
            style4.setBorderBottom(BorderStyle.THIN);
            //int size =sanitymap.size();
            int size = casecount;
            int a = 1000;
            int c = 2000;
            int d = 3000;
            int e = 4000;
            int f = 5000;
            int g = 6000;
            int h = 7000;
            int j = 8000;
            int k = 9000;
            int l = 10000;
            int m = 11000;
            int n = 12000;
            int o = 13000;
            int p = 14000;
            for (int w = 0; w < size; w++) {
                Srow1 = spreadsheet1.createRow(i);
                Scell1 = Srow1.createCell(0);
                Scell1.setCellValue(sanitymap.get(w + 1));
                Scell1 = Srow1.createCell(1);
                Scell1.setCellStyle(style4);
                if (sanitymap.get(a) != null) {
                    if (sanitymap.get(a).toString().equalsIgnoreCase("PASS")) {
                        Scell1.setCellValue("PASS");
                        style1.setAlignment(HorizontalAlignment.CENTER);
                        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                        Scell1.setCellStyle(style1);
                    } else {
                        Scell1.setCellValue("FAIL");
                        style2.setAlignment(HorizontalAlignment.CENTER);
                        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style2.setFillForegroundColor(IndexedColors.RED.getIndex());
                        Scell1.setCellStyle(style2);
                    }
                } else {
                    Scell1.setCellValue("N/A");
                    style4.setAlignment(HorizontalAlignment.CENTER);
                    Scell1.setCellStyle(style4);
                }
                Scell1 = Srow1.createCell(2);
                if (sanitymap.get(c) != null) {
                    if (sanitymap.get(c).toString().equalsIgnoreCase("PASS")) {
                        Scell1.setCellValue("PASS");
                        style1.setAlignment(HorizontalAlignment.CENTER);
                        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                        Scell1.setCellStyle(style1);
                    } else {
                        Scell1.setCellValue("FAIL");
                        style2.setAlignment(HorizontalAlignment.CENTER);
                        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style2.setFillForegroundColor(IndexedColors.RED.getIndex());
                        Scell1.setCellStyle(style2);
                    }
                } else {
                    Scell1.setCellValue("N/A");
                    style4.setAlignment(HorizontalAlignment.CENTER);
                    Scell1.setCellStyle(style4);
                }
                Scell1 = Srow1.createCell(3);
                if (sanitymap.get(d) != null) {
                    if (sanitymap.get(d).toString().equalsIgnoreCase("PASS")) {
                        Scell1.setCellValue("PASS");
                        style1.setAlignment(HorizontalAlignment.CENTER);
                        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                        Scell1.setCellStyle(style1);
                    } else {
                        Scell1.setCellValue("FAIL");
                        style2.setAlignment(HorizontalAlignment.CENTER);
                        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style2.setFillForegroundColor(IndexedColors.RED.getIndex());
                        Scell1.setCellStyle(style2);
                    }
                } else {
                    Scell1.setCellValue("N/A");
                    style4.setAlignment(HorizontalAlignment.CENTER);
                    Scell1.setCellStyle(style4);
                }
                Scell1 = Srow1.createCell(4);
                if (sanitymap.get(e) != null) {
                    if (sanitymap.get(e).toString().equalsIgnoreCase("PASS")) {
                        Scell1.setCellValue("PASS");
                        style1.setAlignment(HorizontalAlignment.CENTER);
                        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                        Scell1.setCellStyle(style1);
                    } else {
                        Scell1.setCellValue("FAIL");
                        style2.setAlignment(HorizontalAlignment.CENTER);
                        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style2.setFillForegroundColor(IndexedColors.RED.getIndex());
                        Scell1.setCellStyle(style2);
                    }
                } else {
                    Scell1.setCellValue("N/A");
                    style4.setAlignment(HorizontalAlignment.CENTER);
                    Scell1.setCellStyle(style4);
                }
                Scell1 = Srow1.createCell(5);
                if (sanitymap.get(f) != null) {
                    if (sanitymap.get(f).toString().equalsIgnoreCase("PASS")) {
                        Scell1.setCellValue("PASS");
                        style1.setAlignment(HorizontalAlignment.CENTER);
                        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                        Scell1.setCellStyle(style1);
                    } else {
                        Scell1.setCellValue("FAIL");
                        style2.setAlignment(HorizontalAlignment.CENTER);
                        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style2.setFillForegroundColor(IndexedColors.RED.getIndex());
                        Scell1.setCellStyle(style2);
                    }
                } else {
                    Scell1.setCellValue("N/A");
                    style4.setAlignment(HorizontalAlignment.CENTER);
                    Scell1.setCellStyle(style4);
                }
                Scell1 = Srow1.createCell(6);
                if (sanitymap.get(g) != null) {
                    if (sanitymap.get(g).toString().equalsIgnoreCase("PASS")) {
                        Scell1.setCellValue("PASS");
                        style1.setAlignment(HorizontalAlignment.CENTER);
                        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                        Scell1.setCellStyle(style1);
                    } else {
                        Scell1.setCellValue("FAIL");
                        style2.setAlignment(HorizontalAlignment.CENTER);
                        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style2.setFillForegroundColor(IndexedColors.RED.getIndex());
                        Scell1.setCellStyle(style2);
                    }
                } else {
                    Scell1.setCellValue("N/A");
                    style4.setAlignment(HorizontalAlignment.CENTER);
                    Scell1.setCellStyle(style4);
                }
                Scell1 = Srow1.createCell(7);
                if (sanitymap.get(h) != null) {
                    if (sanitymap.get(h).toString().equalsIgnoreCase("PASS")) {
                        Scell1.setCellValue("PASS");
                        style1.setAlignment(HorizontalAlignment.CENTER);
                        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                        Scell1.setCellStyle(style1);
                    } else {
                        Scell1.setCellValue("FAIL");
                        style2.setAlignment(HorizontalAlignment.CENTER);
                        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style2.setFillForegroundColor(IndexedColors.RED.getIndex());
                        Scell1.setCellStyle(style2);
                    }
                } else {
                    Scell1.setCellValue("N/A");
                    style4.setAlignment(HorizontalAlignment.CENTER);
                    Scell1.setCellStyle(style4);
                }
                Scell1 = Srow1.createCell(8);
                if (sanitymap.get(j) != null) {
                    if (sanitymap.get(j).toString().equalsIgnoreCase("PASS")) {
                        Scell1.setCellValue("PASS");
                        style1.setAlignment(HorizontalAlignment.CENTER);
                        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                        Scell1.setCellStyle(style1);
                    } else {
                        Scell1.setCellValue("FAIL");
                        style2.setAlignment(HorizontalAlignment.CENTER);
                        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style2.setFillForegroundColor(IndexedColors.RED.getIndex());
                        Scell1.setCellStyle(style2);
                    }
                } else {
                    Scell1.setCellValue("N/A");
                    style4.setAlignment(HorizontalAlignment.CENTER);
                    Scell1.setCellStyle(style4);
                }
                Scell1 = Srow1.createCell(9);
                if (sanitymap.get(k) != null) {
                    if (sanitymap.get(k).toString().equalsIgnoreCase("PASS")) {
                        Scell1.setCellValue("PASS");
                        style1.setAlignment(HorizontalAlignment.CENTER);
                        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                        Scell1.setCellStyle(style1);
                    } else {
                        Scell1.setCellValue("FAIL");
                        style2.setAlignment(HorizontalAlignment.CENTER);
                        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style2.setFillForegroundColor(IndexedColors.RED.getIndex());
                        Scell1.setCellStyle(style2);
                    }
                } else {
                    Scell1.setCellValue("N/A");
                    style4.setAlignment(HorizontalAlignment.CENTER);
                    Scell1.setCellStyle(style4);
                }
                Scell1 = Srow1.createCell(10);
                if (sanitymap.get(l) != null) {
                    if (sanitymap.get(l).toString().equalsIgnoreCase("PASS")) {
                        Scell1.setCellValue("PASS");
                        style1.setAlignment(HorizontalAlignment.CENTER);
                        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                        Scell1.setCellStyle(style1);
                    } else {
                        Scell1.setCellValue("FAIL");
                        style2.setAlignment(HorizontalAlignment.CENTER);
                        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style2.setFillForegroundColor(IndexedColors.RED.getIndex());
                        Scell1.setCellStyle(style2);
                    }
                } else {
                    Scell1.setCellValue("N/A");
                    style4.setAlignment(HorizontalAlignment.CENTER);
                    Scell1.setCellStyle(style4);
                }
                Scell1 = Srow1.createCell(11);
                if (sanitymap.get(m) != null) {
                    if (sanitymap.get(m).toString().equalsIgnoreCase("PASS")) {
                        Scell1.setCellValue("PASS");
                        style1.setAlignment(HorizontalAlignment.CENTER);
                        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                        Scell1.setCellStyle(style1);
                    } else {
                        Scell1.setCellValue("FAIL");
                        style2.setAlignment(HorizontalAlignment.CENTER);
                        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style2.setFillForegroundColor(IndexedColors.RED.getIndex());
                        Scell1.setCellStyle(style2);
                    }
                } else {
                    Scell1.setCellValue("N/A");
                    style4.setAlignment(HorizontalAlignment.CENTER);
                    Scell1.setCellStyle(style4);
                }
                Scell1 = Srow1.createCell(12);
                if (sanitymap.get(n) != null) {
                    if (sanitymap.get(n).toString().equalsIgnoreCase("PASS")) {
                        Scell1.setCellValue("PASS");
                        style1.setAlignment(HorizontalAlignment.CENTER);
                        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                        Scell1.setCellStyle(style1);
                    } else {
                        Scell1.setCellValue("FAIL");
                        style2.setAlignment(HorizontalAlignment.CENTER);
                        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style2.setFillForegroundColor(IndexedColors.RED.getIndex());
                        Scell1.setCellStyle(style2);
                    }
                } else {
                    Scell1.setCellValue("N/A");
                    style4.setAlignment(HorizontalAlignment.CENTER);
                    Scell1.setCellStyle(style4);
                }
                Scell1 = Srow1.createCell(13);
                if (sanitymap.get(o) != null) {
                    if (sanitymap.get(o).toString().equalsIgnoreCase("PASS")) {
                        Scell1.setCellValue("PASS");
                        style1.setAlignment(HorizontalAlignment.CENTER);
                        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                        Scell1.setCellStyle(style1);
                    } else {
                        Scell1.setCellValue("FAIL");
                        style2.setAlignment(HorizontalAlignment.CENTER);
                        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style2.setFillForegroundColor(IndexedColors.RED.getIndex());
                        Scell1.setCellStyle(style2);
                    }
                } else {
                    Scell1.setCellValue("N/A");
                    style4.setAlignment(HorizontalAlignment.CENTER);
                    Scell1.setCellStyle(style4);
                }
                Scell1 = Srow1.createCell(14);
                if (sanitymap.get(p) != null) {
                    if (sanitymap.get(p).toString().equalsIgnoreCase("PASS")) {
                        Scell1.setCellValue("PASS");
                        style1.setAlignment(HorizontalAlignment.CENTER);
                        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                        Scell1.setCellStyle(style1);
                    } else {
                        Scell1.setCellValue("FAIL");
                        style2.setAlignment(HorizontalAlignment.CENTER);
                        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style2.setFillForegroundColor(IndexedColors.RED.getIndex());
                        Scell1.setCellStyle(style2);
                    }
                } else {
                    Scell1.setCellValue("N/A");
                    style4.setAlignment(HorizontalAlignment.CENTER);
                    Scell1.setCellStyle(style4);
                }

                i++;
                a = a + 1;
                c = c + 1;
                d = d + 1;
                e = e + 1;
                f = f + 1;
                g = g + 1;
                h = h + 1;
                j = j + 1;
                k = k + 1;
                l = l + 1;
                m = m + 1;
                n = n + 1;
                o = o + 1;
                p = p + 1;
            }
            for (int z = 0; z < 200; z++) {
                spreadsheet1.autoSizeColumn(z);
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Automation Summary" + e);
        }

    }

    public static Boolean verifySearch(WebDriver WebDriver, String Parameters) throws Exception {
        Boolean Status = true;
        Boolean newstatus = true;
        int temp3 = 20;
        int sanitycntname = 1;
        String[] arguments = splitfunction(Parameters, "->");
        String xpath = "xpath:=//input[@class='searchTableX']";
        if (arguments[1].contains("+")) {
            String[] arguments1 = splitfunction(arguments[1], "+");
            String[] arguments2 = splitfunction(arguments1[1], "+");
            String newval = arguments2[0];
            if (hmap.containsKey(newval)) {
                String revalue = hmap.get(newval);
                arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                System.out.println("Succesfully clicked on" + " " + arguments[1]);
                if (arguments[1].contains("+")) {
                    arguments1 = splitfunction(arguments[1], "+");
                    arguments2 = splitfunction(arguments1[1], "+");
                    newval = arguments2[0];
                    if (hmap.containsKey(newval)) {
                        revalue = hmap.get(newval);
                        arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                        System.out.println("Succesfully clicked on" + " " + arguments[1]);
                        if (arguments[1].contains("+")) {
                            arguments1 = splitfunction(arguments[1], "+");
                            arguments2 = splitfunction(arguments1[1], "+");
                            newval = arguments2[0];
                            if (hmap.containsKey(newval)) {
                                revalue = hmap.get(newval);
                                arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                                System.out.println("Succesfully clicked on" + " " + arguments[1]);
                            } else {
                                ReportFunctions.LogRepoter("Fail", "search element", "key not found in hashmap");
                                Status = false;
                            }
                        }

                    }
                }
            }
        }
        String xpath1 = arguments[1];
        if (hmap.containsKey(arguments[2])) {
            arguments[2] = hmap.get(arguments[2]);
        }
        if (hmap.containsKey(arguments[3])) {
            arguments[3] = hmap.get(arguments[3]);
        }

        WebElement serach = Getlocator(driver, xpath);
        if (serach != null) {
            serach.click();
            serach.clear();
            serach.sendKeys(arguments[2]);
            ReportFunctions.LogRepoter("Pass", "Enter value in Search", "Enter the value in search " + arguments[2]);
            WAITTIME("waittime->5");
            WebElement verify = Getlocator(driver, xpath1);
            if (verify != null) {
                String verifyvalue = verify.getText();
                if (verifyvalue.equalsIgnoreCase(arguments[3])) {
                    ReportFunctions.LogRepoter("Pass", "Verify Both Values", "Both Values matches  " + arguments[3] + "  and" + verifyvalue);
                } else {
                    ReportFunctions.LogRepoter("Fail", "Verify Both Values", "Both Values did not match  " + arguments[3] + "  and" + verifyvalue);
                    Status = false;
                }
            } else {
                ReportFunctions.LogRepoter("Fail", "Verify Both Values", "unable to find xpath  " + arguments[1]);
                Status = false;
            }
        } else {
            ReportFunctions.LogRepoter("Fail", "Enter value in Search", "Unable to find search ");
            Status = false;
        }

        String TCname = hmap.get(Tcase);

        if ((sanitycntname == 1) && (TCname != sanitymap.get(temp3))) {
            sanitymap.put(temp3, TCname);
            int x = TChmap.get(TCname);
            if (Status) {
                sanityVerifySearch = 9999 + x;
                sanitymap.put(sanityVerifySearch, "Pass");
            } else {
                sanityVerifySearch = 9999 + x;
                sanitymap.put(sanityVerifySearch, "Fail");
            }
            sanitycntname = sanitycntname + 1;
            tempnum = sanityVerifySearch;
            newstatus = Status;
        } else {
            if ((sanitymap.get(temp3).equalsIgnoreCase(TCname)) && (newstatus != Status)) {
                sanitymap.put(tempnum, "Fail");
            }
        }
        return Status;
    }

    public static boolean ValidatePromptText(WebDriver WebDriver, String parameters) throws InterruptedException, Exception {
        Boolean Status = true;
        String[] arguments = splitfunction(parameters, "->");
        if (hmap.containsKey(arguments[2])) {
            arguments[2] = hmap.get(arguments[2]);
        }
        if (hmap.containsKey(arguments[3])) {
            arguments[3] = hmap.get(arguments[3]);
        }
        String Applyxpath = "xpath:=//button[contains(text(),'Reset')]/parent::div/preceding-sibling::div//button[contains(text(),'Apply')]";
        String Resetxpath = "xpath:=//button[@name=\"reset\"]";
        WAITTIME("waittime->3");
        WebElement Reset = Getlocator(driver, Resetxpath);
        WebElement Apply = Getlocator(driver, Applyxpath);
        String[] args = splitfunction(arguments[2], "&");
        String[] args1 = splitfunction(arguments[3], "&");
        int ubound = args.length;
        int ubound1 = args1.length;
        if (Reset != null) {
            Reset.click();
            ReportFunctions.LogRepoter("Pass", "Click on reset", "Successfully clicked on Reset");
            for (int i = 0; i <= ubound - 1; i++) {
                String prompttextname = "xpath:=//input[@placeholder=\"" + args[i] + "\"]";
                WebElement prompttext = Getlocator(driver, prompttextname);
                if (prompttext != null) {
                    prompttext.click();
                    if (hmap.containsKey(args1[i])) {
                        String value = hmap.get(args1[i]);
                        prompttext.clear();
                        prompttext.sendKeys(value);
                    } else if (args1[i].toUpperCase().contains("SYSDATE")) {
                        prompttext.clear();
                        String sysdat = Sysdate(args1[i]);
                        prompttext.sendKeys(sysdat);
                    } else {
                        prompttext.clear();
                        prompttext.sendKeys(args1[i]);
                    }
                    ReportFunctions.LogRepoter("Pass", "Enter PromptText value", "Successfully enterd the prompttext  " + args1[i]);
                    WAITTIME("waittime->2");
                } else {
                    ReportFunctions.LogRepoter("Fail", "Click on PromptText", "Unable to find Prompt text locator  " + args[i]);
                    Status = false;
                }
            }
            if (Apply != null) {
                Apply.click();
                ReportFunctions.LogRepoter("Pass", "Click on Apply", "Successfully clicked on Apply");
            } else {
                ReportFunctions.LogRepoter("Fail", "Click on Apply", "Unable to find Apply Button");
                Status = false;
            }
        } else {
            ReportFunctions.LogRepoter("Fail", "Click on reset", "unable to find Reset Button");
            Status = false;
        }
        String TCname = hmap.get(Tcase);

        return Status;
    }

    public static boolean ValidateTextFilter(WebDriver WebDriver, String parameters) throws InterruptedException, Exception {
        Boolean Status = false;
        String[] arguments = splitfunction(parameters, "->");
        String filter = "xpath:=//img[@id=\"prompts-button-bottom\"]";
        String enter = " Enter ";
        String datepicker = "promptDatePicker";
        String xpath = "xpath:=//input[@placeholder=\"" + enter + "\"]";
        String xpath1 = "xpath:=//input[@class=\"promptDatePicker\"]";
        String go = "xpath:=//input[@class=\"btn btn-primary promptsGoBtn\"]";
        String Resets = "xpath:=//input[@class=\"btn btn-primary promptsResetBtn\"]";
        WAITTIME("waittime->3");
        WebElement Filtertext = null;
        String[] args = splitfunction(arguments[2], "&");
        String[] args1 = splitfunction(arguments[3], "&");
        int ubound = args.length;
        int ubound1 = args1.length;
        WebElement Filters = Getlocator(driver, filter);
        if (ubound == ubound1) {
            if (Filters != null) {
                Filters.click();
                WAITFORELEMENT(driver, "waitforelement->xpath:=//input[@class=\"btn btn-primary promptsResetBtn\"]->Reset");
                WebElement Reset = Getlocator(driver, Resets);
                if (Reset != null) {
                    Reset.click();
                    ReportFunctions.LogRepoter("Pass", "Enter on reset button", "Successfully clicked on reset button");
                    for (int i = 0; i <= ubound - 1; i++) {
                        String Filtername = "xpath:=//td[text()=\"" + args[i] + "\"]";
                        WebElement filtername = Getlocator(driver, Filtername);
                        if (filtername != null) {
                            filtername.click();
                            WAITTIME("waittime->2");
                            if (arguments[3].toUpperCase().contains("SYSDATE")) {
                                Filtertext = Getlocator(driver, xpath1);
                            } else {
                                Filtertext = Getlocator(driver, xpath);
                            }
                            if (Filtertext != null) {
                                Filtertext.click();
                                Filtertext.clear();
                                if (hmap.containsKey(args1[i])) {
                                    String value = hmap.get(args1[i]);
                                    Filtertext.sendKeys(value);
                                } else if (args1[i].toUpperCase().contains("SYSDATE")) {
                                    String sysdat = Sysdate(args1[i]);
                                    Filtertext.sendKeys(sysdat);
                                } else {
                                    Filtertext.sendKeys(args1[i]);
                                }
                                WAITTIME("waittime->2");
                                ReportFunctions.LogRepoter("Pass", "Enter FilterText value", "Successfully enterd the Filtertext  " + args1[i]);
                                Status = true;
                            } else {
                                ReportFunctions.LogRepoter("Fail", "Enter FilterText value", "Unable to find Filter text locator  " + args1[i]);
                                Status = false;
                            }
                        } else {
                            ReportFunctions.LogRepoter("Fail", "Click on filter name", "Unable to find Filter name  " + args[i]);
                        }
                    }

                } else {
                    ReportFunctions.LogRepoter("Fail", "Enter on reset button", "Unable to find reset button");
                    Status = false;
                }
            } else {
                ReportFunctions.LogRepoter("Fail", "Click on filter icon", "unable to find filter icon");
                Status = false;
            }
            WebElement goes = Getlocator(driver, go);
            if (goes != null) {
                goes.click();
                INVISIBLEOFLOAD(driver);
                WAITTIME("WAITTIME->3");
                ReportFunctions.LogRepoter("Pass", "Click on GO", "Successfully clicked on  GO button");
                WAITFORELEMENT(driver, "waitforelement->xpath:=//input[@class=\"searchTableX\"]->Search");
            } else {
                ReportFunctions.LogRepoter("Fail", "Click on GO", "Unable to find GO button");
                Status = false;
            }
        } else {
            ReportFunctions.LogRepoter("Fail", "Select filers", "Filter names and values are not equal");
            Status = false;
        }

        return Status;
    }

    public static boolean VerifyDrill(WebDriver WebDriver, String parameters) throws InterruptedException, Exception, StaleElementReferenceException, IOException {
        Boolean Status = true;
        String workoredernum = null;
        Boolean newstatus = true;
        int temp2 = 10;
        int sanitycntname = 1;
        String[] arguments = splitfunction(parameters, "->");
        if (arguments[1].contains("+")) {
            String[] arguments1 = splitfunction(arguments[1], "+");
            String[] arguments2 = splitfunction(arguments1[1], "+");
            String newval = arguments2[0];
            if (hmap.containsKey(newval)) {
                String revalue = hmap.get(newval);
                arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                System.out.println("Succesfully clicked on" + " " + arguments[1]);
                if (arguments[1].contains("+")) {
                    arguments1 = splitfunction(arguments[1], "+");
                    arguments2 = splitfunction(arguments1[1], "+");
                    newval = arguments2[0];
                    if (hmap.containsKey(newval)) {
                        revalue = hmap.get(newval);
                        arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                        System.out.println("Succesfully clicked on" + " " + arguments[1]);
                        if (arguments[1].contains("+")) {
                            arguments1 = splitfunction(arguments[1], "+");
                            arguments2 = splitfunction(arguments1[1], "+");
                            newval = arguments2[0];
                            if (hmap.containsKey(newval)) {
                                revalue = hmap.get(newval);
                                arguments[1] = arguments[1].replace("+" + newval + "+", revalue);
                                System.out.println("Succesfully clicked on" + " " + arguments[1]);
                            } else {
                                ReportFunctions.LogRepoter("Fail", "search element", "key not found in hashmap");
                                Status = false;
                            }
                        }

                    }
                }
            }
        }

        String xpath = arguments[1];
        String Action = arguments[2];
        String args[] = splitfunction(arguments[3], ",");
        WebElement locator = Getlocator(driver, arguments[1]);

        try {
            if (locator != null) {
                //StaleElementClick(driver, "StaleElementClick->arguments[1]->drill");  
                locator.click();
                INVISIBLEOFLOAD(driver);
                WAITTIME("WAITTIME->3");
                ReportFunctions.LogRepoter("Pass", "Click on Drill", "Successfully Clicked on drill  " + arguments[2]);
//            if ((arguments[2].toUpperCase().equalsIgnoreCase("EDIT")) || (arguments[2].toUpperCase().equalsIgnoreCase("SPLIT"))) {
//                WebElement orderdetails = Getlocator(driver, "xpath:=//span[text()=\"Order Details\"]");
//                if (orderdetails != null) {
//                    orderdetails.click();
//                    INVISIBLEOFLOAD(driver);
//                    WAITTIME("WAITTIME->3");
//                    WebElement workorder = Getlocator(driver, "xpath:=//td[text()=\"WorkOrder Number\"]//following-sibling::td//input");
//                     workoredernum = workorder.getText();
//                    if (workoredernum.equalsIgnoreCase(args[1])) {
//                        ReportFunctions.LogRepoter("Pass", "Verify WorkOrder Number", "Work order number matched  " + workoredernum);
//                        WebElement workorderlink = Getlocator(driver, "xpath:=//div[@title=\"WorkOrders\"]");
//                        if (workorderlink != null) {
//                            workorderlink.click();
//                            ReportFunctions.LogRepoter("Pass", "Click on WorkOrder Number", "Successfully clicked on work order number");
//                        } else {
//                            ReportFunctions.LogRepoter("fail", "Click on WorkOrder Number", "unable to find  work order number");
//                            Status = false;
//                        }
//                    } else {
//                        ReportFunctions.LogRepoter("Fail", "Verify WorkOrder Number", "Both values did not match  " + workoredernum + "  and  " + arguments[3]);
//                        Status = false;
//                    }
//                } else {
//                    ReportFunctions.LogRepoter("Fail", "Click on Order Details", "Unable to find order details to verify order number");
//                    Status = false;
//                }
//            } else {
//
                WebElement Actions = Getlocator(driver, "xpath:=//div[@title=\"" + args[1] + "\"]");
                if (Actions != null) {
                    String value = Actions.getText();
                    if (value.equalsIgnoreCase(args[1])) {
                        ReportFunctions.LogRepoter("Pass", "Verify dashboard name", "dashboard name matched  " + value + " and " + args[1]);
                        WebElement dashboard = Getlocator(driver, "xpath:=//div[@title=\"" + args[0] + "\"]");
                        if (dashboard != null) {
                            dashboard.click();
                            INVISIBLEOFLOAD(driver);
                            WAITTIME("WAITTIME->3");
                            WebElement popup = Getlocator(driver, "xpath:=//input[@id=\"popup_ok\"]");
                            if (popup != null) {
                                popup.click();
                                INVISIBLEOFLOAD(driver);
                                WAITTIME("WAITTIME->3");

                            }
                            ReportFunctions.LogRepoter("Pass", "Click on dashboard", "Successfully clicked on dashboard  " + args[0]);
                        } else {
                            ReportFunctions.LogRepoter("Fail", "Click on dashboard", "unable to find dashboard name");
                            Status = false;
                        }
                    } else {
                        ReportFunctions.LogRepoter("Fail", "Verify dashboard name", "dashboard name mismatched  " + args[1] + "  and " + value);
                        Status = false;
                        WebElement dashboard = Getlocator(driver, "xpath:=//div[@title=\"" + args[0] + "\"]");
                        if (dashboard != null) {
                            dashboard.click();
                            INVISIBLEOFLOAD(driver);
                            WAITTIME("WAITTIME->3");
                            WebElement popup = Getlocator(driver, "xpath:=//input[@id=\"popup_ok\"]");
                            if (popup != null) {
                                popup.click();
                                INVISIBLEOFLOAD(driver);
                                WAITTIME("WAITTIME->3");
                            }
                        }
                    }
                } else {
                    ReportFunctions.LogRepoter("Fail", "verify dashboard name", "Unable to find dash board name  " + args[1]);
                    Status = false;
                    WebElement dashboard = Getlocator(driver, "xpath:=//div[@title=\"" + args[0] + "\"]");
                    if (dashboard != null) {
                        dashboard.click();
                        INVISIBLEOFLOAD(driver);
                        WAITTIME("WAITTIME->3");
                        WebElement popup = Getlocator(driver, "xpath:=//input[@id=\"popup_ok\"]");
                        if (popup != null) {
                            popup.click();
                            INVISIBLEOFLOAD(driver);
                            WAITTIME("WAITTIME->3");
                        }
                    }

                }
                //}
            } else {
                ReportFunctions.LogRepoter("Fail", "Click on Drill", "Unable to locate  drill  " + arguments[2]);
                Status = false;
            }
            String TCname = hmap.get(Tcase);

            if ((sanitycntname == 1) && (TCname != sanitymap.get(temp2))) {
                sanitymap.put(temp2, TCname);
                int x = TChmap.get(TCname);
                if (Status) {
                    sanityVerifyDrills = 11999 + x;
                    sanitymap.put(sanityVerifyDrills, "Pass");
                } else {
                    sanityVerifyDrills = 11999 + x;
                    sanitymap.put(sanityVerifyDrills, "Fail");
                }
                sanitycntname = sanitycntname + 1;
                tempnum = sanityVerifyDrills;
                newstatus = Status;
            } else {
                if ((sanitymap.get(temp2).equalsIgnoreCase(TCname)) && (newstatus != Status)) {
                    sanitymap.put(tempnum, "Fail");
                }
            }

        } catch (Exception e) {
            System.out.println("unable to find the locator" + arguments[1]);
            ReportFunctions.LogRepoter("Fail", "Click on Drill", "Unable to locate  drill  " + arguments[1]);
            Status = false;
        }
        return Status;

    }

    public static boolean VerifyFwdAction(WebDriver WebDriver, String parameters) throws InterruptedException, Exception {
        Boolean Status = false;
        Boolean newstatus = true;
        int temp20 = 300;
        int sanitycntname = 1;
        String[] arguments = splitfunction(parameters, "->");
        String[] args = splitfunction(arguments[2], ",");
        INVISIBLEOFLOAD(driver);
        WAITTIME("WAITTIME->4");
        WebElement Fwdaction = Getlocator(driver, "xpath:=//img[@title=\"" + arguments[1] + "\"]");
        if (Fwdaction != null) {
            Fwdaction.click();
            WAITTIME("WAITTIME->4");
            ReportFunctions.LogRepoter("Pass", "Click on Fwd Action", "Clicked on Fwd Action  " + arguments[1]);
            INVISIBLEOFLOAD(driver);
            Boolean verifydashboard = WAITFORELEMENT(driver, "waitforelement->xpath:=//div[@title=\"" + args[1] + "\"]->" + args[1]);
            if (verifydashboard) {
                WebElement backdashboard = Getlocator(driver, "xpath:=//div[@title=\"" + args[0] + "\"]");
                backdashboard.click();
                INVISIBLEOFLOAD(driver);
                WAITTIME("WAITTIME->4");
                ReportFunctions.LogRepoter("Pass", "Verify Fwd Action", "Fwd action was successfull for  " + arguments[1]);
                Status = true;
            } else {
                ReportFunctions.LogRepoter("Fail", "Verify Fwd Action", "Fwd action was not successfull for  " + arguments[1]);
                WebElement backdashboard = Getlocator(driver, "xpath:=//div[@title=\"" + args[0] + "\"]");
                backdashboard.click();
                INVISIBLEOFLOAD(driver);
                WAITTIME("WAITTIME->4");
                Status = false;
            }
        } else {
            ReportFunctions.LogRepoter("Pass", "Verify Fwd Action", "Unable to find name  " + args[1]);
            Status = false;
        }
        String TCname = hmap.get(Tcase);

        if ((sanitycntname == 1) && (TCname != sanitymap.get(temp20))) {
            sanitymap.put(temp20, TCname);
            int x = TChmap.get(TCname);
            if (Status) {
                sanityVerifyFWDActions = 10999 + x;
                sanitymap.put(sanityVerifyFWDActions, "Pass");
            } else {
                sanityVerifyFWDActions = 10999 + x;
                sanitymap.put(sanityVerifyFWDActions, "Fail");
            }
            sanitycntname = sanitycntname + 1;
            tempnum = sanityVerifyFWDActions;
            newstatus = Status;
        } else {
            if ((sanitymap.get(temp20).equalsIgnoreCase(TCname)) && (newstatus != Status)) {
                sanitymap.put(tempnum, "Fail");
            }
        }
        return Status;
    }

    public static boolean ValidateDateType(WebDriver WebDriver, String parameters) throws InterruptedException, Exception {
        Boolean status = true;
        int ubound;
        int ubound1;
        Boolean flag = false;
        Boolean newstatus = true;
        int temp54 = 546;
        int sanitycntname = 1;
        String filter = "xpath:=//img[@id=\"prompts-button-bottom\"]";
        String go = "xpath:=//input[@class=\"btn btn-primary promptsGoBtn\"]";
        String Reset = "xpath:=//input[@class=\"btn btn-primary promptsResetBtn\"]";
        String Cdate = "xpath:=//td[text()=\"Transaction Start Date\"]";
        String Edate = "xpath:=(//input[@class=\"promptDatePicker\"])[1]";
        String Sdate = "xpath:=(//input[@class=\"promptDatePicker\"])[2]";
        String search = "xpath:=//input[@id=\"prompt_search\"]";
        String[] arguments = splitfunction(parameters, "->");
        String allchoices = "xpath:=//input[@value=\"All Choices\"]";
        WebElement Filters = Getlocator(driver, filter);
        if (Filters != null) {
            Filters.click();
            WAITFORELEMENT(driver, "waitforelement->xpath:=//input[@class=\"btn btn-primary promptsResetBtn\"]->Reset");
            WebElement Resets = Getlocator(driver, Reset);
            if (Resets != null) {
                Resets.click();
                String xpath = "xpath:=//td[text()=\"" + arguments[2] + "\"]";
                WebElement filtername = Getlocator(driver, xpath);
                if (filtername != null) {
                    WAITTIME("WAITTIME->2");
                    filtername.click();
                    WAITTIME("WAITTIME->2");
                    String args[] = splitfunction(arguments[3], "&");
                    Boolean selectq = SELECTVALUEDROPDOWN(driver, "SELECTVALUEDROPDOWN->xpath:=//select[@id=\"operatorsList\"]->Condition->" + args[0]);
                    if (selectq) {
                        WebElement date1 = Getlocator(driver, Edate);
                        if (date1 != null) {
                            if (args[0].equalsIgnoreCase("Between")) {
                                WebElement date2 = Getlocator(driver, Sdate);
                                String args1[] = splitfunction(args[1], "and");
                                if (args1[1].toUpperCase().contains("SYSDATE")) {
                                    String sysdat = Sysdate(args1[0]);
                                    date1.sendKeys(sysdat);
                                    ReportFunctions.LogRepoter("Pass", "Enter date condition", "successfully entered first date  " + sysdat);
                                    String sysdat1 = Sysdate(args1[1]);
                                    SENDKEYS(driver, "SENDKEYS->TAB");
                                    WAITTIME("WAITTIME->3");
                                    date2.sendKeys(sysdat1);
                                    SENDKEYS(driver, "SENDKEYS->TAB");
                                    WAITTIME("WAITTIME->3");
                                    ReportFunctions.LogRepoter("Pass", "Enter date condition", "successfully entered first date  " + sysdat1);
                                } else {
                                    date1.sendKeys(args1[0]);
                                    date2.sendKeys(args1[1]);
                                    ReportFunctions.LogRepoter("Pass", "Enter date condition", "successfully entered first date  " + args1[0]);
                                    ReportFunctions.LogRepoter("Pass", "Enter date condition", "successfully entered first date  " + args1[1]);
                                }
                            } else {
                                if (args[1].toUpperCase().contains("SYSDATE")) {
                                    String sysdat = Sysdate(args[1]);
                                    date1.sendKeys(sysdat);
                                    date1.click();
                                    //SENDKEYS(driver, "SENDKEYS->TAB");
                                    WAITTIME("WAITTIME->3");
                                    ReportFunctions.LogRepoter("Pass", "Enter date condition", "successfully entered date  " + args[0] + "  " + sysdat);
                                } else {
                                    date1.sendKeys(args[1]);
                                    ReportFunctions.LogRepoter("Pass", "Enter date condition", "successfully entered date  " + args[0] + "" + args[1]);
                                }
                            }
                        } else {
                            ReportFunctions.LogRepoter("Fail", "Enter date condition", "failed to enter  entered date  " + arguments[2]);
                            status = false;
                        }
                    } else {
                        ReportFunctions.LogRepoter("Fail", "Select condition", "Unable to find condition value from dropdown");
                        status = false;
                    }
                } else {
                    ReportFunctions.LogRepoter("Fail", "Click on filter name", "Unable to find filter name  " + arguments[2]);
                    status = false;
                }
                WebElement goes = Getlocator(driver, go);
                if (goes != null) {
                    goes.click();
                    INVISIBLEOFLOAD(driver);
                    WAITTIME("WAITTIME->2");
                    ReportFunctions.LogRepoter("Pass", "Click on GO", "Successfully clicked on  GO button");
                    WAITFORELEMENT(driver, "waitforelement->xpath:=//input[@class=\"searchTableX\"]->Search");
                } else {
                    ReportFunctions.LogRepoter("Fail", "Click on GO", "Unable to find GO button");
                    status = false;
                }
            } else {
                ReportFunctions.LogRepoter("Fail", "Click on Resut button", "unable to find Reset button");
                status = false;
            }

        } else {
            ReportFunctions.LogRepoter("Fail", "Click on filter icon", "unable to find filter icon");
            status = false;
        }
        String TCname = hmap.get(Tcase);

        if ((sanitycntname == 1) && (TCname != sanitymap.get(temp54))) {
            sanitymap.put(temp54, TCname);
            int x = TChmap.get(TCname);
            if (status) {
                sanityVerifyFilterswithadaterange = 5999 + x;
                sanitymap.put(sanityVerifyFilterswithadaterange, "Pass");
            } else {
                sanityVerifyFilterswithadaterange = 5999 + x;
                sanitymap.put(sanityVerifyFilterswithadaterange, "Fail");
            }
            sanitycntname = sanitycntname + 1;
            tempnum = sanityVerifyFilterswithadaterange;
            newstatus = status;
        } else {
            if ((sanitymap.get(temp54).equalsIgnoreCase(TCname)) && (newstatus != status)) {
                sanitymap.put(tempnum, "Fail");
            }
        }
        return status;
    }

    public static boolean sanity_OpenAngularpage(WebDriver WebDriver, String parameters) throws Exception {
        boolean status = true;
        int count = 0;
        boolean flag = false;
        Boolean newstatus = true;
        int temp44 = 456;
        int sanitycntname = 1;
        String[] arguments = splitfunction(parameters, "->");
        String directsearch = "xpath:=//div[@id=\"activity-table_filter\"]/label/input";
        String clicksearch = "xpath:=//i[@class=\"fa fa-search\"]";
        String entersearch = "xpath:=//input[@ng-model=\"searchVal\"]";
        String othersearch = "xpath:=//input[@class=\"form-control input-sm\"]";
        try {
            do {
                WAITTIME("waittime->25");
                driver.switchTo().defaultContent();
                driver.switchTo().frame(0);
                // WebElement locator = Getlocator(driver, "xpath:=//input[@type=\"search\"]");
                WebElement locator = Getlocator(driver, "xpath:=//input [(@id=\"searchtext\") or (@type=\"search\")]");
                if (locator != null) {
                    WebElement New = Getlocator(driver, "xpath:=//*[@id=\"btn-new\"]");
                    ReportFunctions.LogRepoter("Pass", "Wait for angular js page", "Sucessfully angular js page loaded");
                    WAITTIME("waittime->2");
                    flag = true;
                    count = 5001;
                    WebElement DS = Getlocator(driver, directsearch);
                    WebElement CS = Getlocator(driver, clicksearch);
                    WebElement ES = Getlocator(driver, entersearch);
                    WebElement OS = Getlocator(driver, othersearch);
                    if ((DS != null) || (OS != null)) {
                        if (OS != null) {
                            OS.click();
                            OS.sendKeys(arguments[3]);
                        } else {
                            DS.click();
                            DS.sendKeys(arguments[3]);
                        }
                        WAITTIME("waittime->4");
                        WebElement Verify = Getlocator(driver, arguments[1]);
                        String vvalue = Verify.getText();
                        if (vvalue.equalsIgnoreCase(arguments[3])) {
                            ReportFunctions.LogRepoter("Pass", "Verify A.Js pase search", "Both values matched " + vvalue + "and  " + arguments[3]);
                        } else {
                            ReportFunctions.LogRepoter("Fail", "Verify A.Js pase search", "Both values did not match " + vvalue + "and  " + arguments[3]);
                            status = false;
                        }
                    } else if (ES != null) {
                        ES.click();
                        ES.sendKeys(arguments[3]);
                        WAITTIME("waittime->2");
                        CS.click();
                        WAITTIME("waittime->4");
                        WebElement Verify = Getlocator(driver, arguments[1]);
                        String vvalue = Verify.getText();
                        if (vvalue.equalsIgnoreCase(arguments[3])) {
                            ReportFunctions.LogRepoter("Pass", "Verify A.Js pase search", "Both values matched " + vvalue + "and  " + arguments[3]);
                        } else {
                            ReportFunctions.LogRepoter("Fail", "Verify A.Js pase search", "Both values did not match " + vvalue + "and  " + arguments[3]);
                            status = false;
                        }
                    } else {
                        ReportFunctions.LogRepoter("Fail", "Verify A.Js pase search", "unable to find search");
                        status = false;
                    }
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
                sanity_OpenAngularpage(driver, parameters);
            }
        }
        String TCname = hmap.get(Tcase);
        if ((sanitycntname == 1) && (TCname != sanitymap.get(temp44))) {
            sanitymap.put(temp44, TCname);
            int x = TChmap.get(TCname);
            if (status) {
                sanityVerifyangularpage = 13999 + x;
                sanitymap.put(sanityVerifyangularpage, "Pass");
            } else {
                sanityVerifyangularpage = 13999 + x;
                sanitymap.put(sanityVerifyangularpage, "Fail");
            }
            sanitycntname = sanitycntname + 1;
            tempnum = sanityVerifyangularpage;
            newstatus = status;
        } else {
            if ((sanitymap.get(temp44).equalsIgnoreCase(TCname)) && (newstatus != status)) {
                sanitymap.put(tempnum, "Fail");
            }
        }
        return status;
    }
    // new function satish  
//1    

    public static boolean PRESSTABKEY(WebDriver WebDriver, String parameters) throws InterruptedException {
        boolean flag = false;
        String[] arguments = null;
        Boolean Status = true;
        arguments = splitfunction(parameters, "\\->");
        String xpath = arguments[1];

        try {
//WebElement DIVelement = driver.findElement(By.xpath(xpath));
//WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);// old method calling
            } else {

                locator = getlocatorKeyValue(driver, arguments[1]); // object repository method calling
            }
            locator.sendKeys(Keys.TAB);
            System.out.println("PRESSTABKEY()");
            ReportFunctions.LogRepoter("pass", "PRESSTABKEY", "PRESSTABKEY is Successful");
            flag = true;
            return true;
        } catch (Exception e) {
            System.out.println("unable to find the locator" + " " + e.getMessage());
            ReportFunctions.LogRepoter("fail", "PRESSTABKEY", "PRESSTABKEY Failed");
            return false;
        }
    } //method 

//2
    public static boolean ACTIONSCLICK(WebDriver WebDriver, String parameters) throws InterruptedException {
        System.out.println("ActionsClick()");
        boolean flag = false;
        String[] arguments = null;
        Boolean Status = true;
        arguments = splitfunction(parameters, "\\->");
        String xpath = arguments[1];

        try {
//WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);// old method calling
            } else {

                locator = getlocatorKeyValue(driver, arguments[1]); // object repository method calling
            }

            Actions action = new Actions(driver);

            if (arguments.length > 2) {
                action.doubleClick(locator).click().perform();
            } else {
                action.click(locator).perform();
            }
            System.out.println("ACTIONSCLICK()");
            ReportFunctions.LogRepoter("pass", "ACTIONSCLICK", "Clicked on :" + arguments[2]);
            flag = true;
            return flag;
        } catch (Exception e) {
            System.out.println("unable to find the locator" + " " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "ACTIONSCLICK", "Unable to click on :" + arguments[2]);
            return false;
        }
    } //method 

    public static boolean VERIFYBASEDONLABEL(WebDriver WebDriver, String parameters) throws InterruptedException {
        System.out.println("VERIFYBASEDONLABEL()??");
        boolean flag = false;
        String[] arguments = null;
        String ovalue = null;
        arguments = splitfunction(parameters, "->");
//String xpath1 = arguments[1];
        String vValue = null;
//String vValue=arguments[3];
//reading from ENV file.
        if (!arguments[3].isEmpty()) {
            if (hmap.containsKey(arguments[3])) {
                vValue = hmap.get(arguments[3]);
            } else {
                vValue = arguments[3];
            }
        }
        try {
            //WebElement locator = Getlocator(driver, arguments[1]);
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);// old method calling
            } else {
                locator = getlocatorKeyValue(driver, arguments[1]); // object repository method calling
            }
            ovalue = locator.getText();
            if (ovalue.equals(vValue)) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 1px solid red;');", locator);
                System.out.println("Original vlaue <" + ovalue + "> is Matched with application value <" + vValue + ">");
                ReportFunctions.LogRepoter("Pass", "Data Verified", "Data Verified Successfully : <" + vValue + ">");
                flag = true;
                return true;
            } else {
                System.out.println("Original vlaue <" + ovalue + "> is Not Matched with application value <" + vValue + ">");
                ReportFunctions.LogRepoter("Fail", "Data Not Verified", "Data Not Verified");
                return flag;
            }
        } catch (Exception e) {
            System.out.println("unable verify data:" + " " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "unable verify data", "unable verify data");
            return false;
        }
    } //method 

//3
    public static boolean NAVIGATETO(WebDriver WebDriver, String parameters) throws InterruptedException {
        boolean flag = false;
        String[] arguments = null;
        Boolean Status = true;
        arguments = splitfunction(parameters, "\\->");
        String URL = arguments[2];

        try {
            if (hmap.containsKey(arguments[2])) {
                URL = hmap.get(arguments[2]);
                driver.navigate().to(URL);
                flag = true;
                return flag;
            } else {
                driver.navigate().to(URL);
                flag = true;
                return flag;
            }
        } catch (Exception e) {
            System.out.println("unable to navigate().to()" + " " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "close pop up", "Loader image is still present");
            return false;
        }
    } //method 
//4

    public static boolean EMAILCONFIRMATION(WebDriver WebDriver, String parameters) throws InterruptedException {

        boolean flag = false;
        String[] arguments = null;
        Boolean Status = true;
        arguments = splitfunction(parameters, "\\->");
//String credentials = arguments[2];
        WebDriverWait wt = new WebDriverWait(driver, 1000);
        String parent_window = driver.getWindowHandle();
//System.out.println("Parent Window : "+parent_window);

        try {
            if (!parent_window.isEmpty()) {   //System.out.println("!parent_window.isEmpty()");
                wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='zA zE']")));
                List<WebElement> inboxEmails = wt.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[@class='zA zE']"))));
                for (WebElement email : inboxEmails) {
                    if (email.isDisplayed() && email.getText().contains("Thank you for your interest in becoming a Skywards Everyday partner")) { //System.out.println("email.isDisplayed()");
                        email.click();
                        Thread.sleep(3000);
                        WebElement subject = wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Thank you for your interest in becoming a Skywards Everyday partner')]")));
                        wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("here")));
                        driver.findElement(By.linkText("here")).click();;
                        Thread.sleep(3000);

                        Set<String> allWindows = driver.getWindowHandles();
                        for (String child_1 : allWindows) {
                            if (!parent_window.equalsIgnoreCase(child_1)) {
                                Thread.sleep(2000);
                                driver.switchTo().window(child_1);
                                Thread.sleep(2000);
                                System.out.println("new window : " + driver.getTitle());
                                List<WebElement> newEle = driver.findElements(By.tagName("button"));
                                if (newEle.size() > 0) {
                                    System.out.println("" + newEle.get(0).getAttribute("onclick"));
                                }
                                newEle.get(0).click();
                                Thread.sleep(3000);
                                flag = true;
                                driver.close();
                                driver.switchTo().window(parent_window);
                                Thread.sleep(3000);

                            }//if
                        }
                    }//if

                }//for
            }///if

            driver.navigate().to(hmap.get("GV_Gmail_Inbox"));
            Thread.sleep(1000);
            //driver.findElement(By.xpath("//div[@class='TN bzz aHS-bnt']")).click();
            Thread.sleep(3000);

            if (flag) {
                System.out.println("Succesfully Verified email..");
                ReportFunctions.LogRepoter("pass", "E-Mail : ", "Succesfully Verified email.. ");
                return true;
            } else {
                System.out.println("E-Mail verification failed.");
                ReportFunctions.LogRepoter("fail", "E-Mail : ", "E-Mail verification failed.");
                return false;
            }

        } catch (Exception e) {
            System.out.println("unable to Verified email.." + " " + e.getMessage());
            ReportFunctions.LogRepoter("fail", "E-Mail : ", "E-Mail verification failed. ");
            return false;
        }

    }//method

//5
    public static String getLocatorKey(WebDriver driver, String key) throws IOException {
        System.out.println();
        System.out.println("key :" + key);
        //System.out.println("readpath() : "+readpath());
        Properties propObj = new Properties();
        FileInputStream fis = new FileInputStream(readpath() + "\\src\\Config\\Object_Repository.properties");
        propObj.load(fis);
        String LocatorValue = propObj.getProperty(key);
        if (!LocatorValue.isEmpty()) {
            return LocatorValue;
        } else {
            ReportFunctions.LogRepoter("Fail", "locator Key not Found", " locator Key not Found::" + "  " + key);
            return null;
        }
    }//method

    public static WebElement getlocatorKeyValue(WebDriver WebDriver, String parameters) throws IOException {
        parameters = getLocatorKey(WebDriver, parameters);

        if (parameters.isEmpty())
        {
            System.out.println("unable to find the locator::" + " " + locator);
            ReportFunctions.LogRepoter("Fail", "locator not identified", " unable to find the locator::" + "  " + locator);
            return null;
        }
        System.out.println("keyValue :" + parameters);

        WebElement locpath = null;
        try {

            String[] arguments = null;
            boolean b;
            b = parameters.matches(".*:.*");

            if (b) {
                arguments = splitfunction(parameters, ":=");
            } else {
                arguments = splitfunction(parameters, "\\|");
            }

            String mode = arguments[0];
            arguments[0].trim();
            locator = arguments[1];
            //satish
            JavascriptExecutor js = (JavascriptExecutor)WebDriver;
            //js.executeScript("arguments[0].setAttribute('style', 'background: orange; border: 1px solid red;');", locator);

            arguments[1].trim();

            switch (mode) {

                case "id":
                    locpath = WebDriver.findElement(By.id(locator));
                    break;
                case "name":
                    locpath = WebDriver.findElement(By.name(locator));
                    break;
                case "linkText":
                    locpath = WebDriver.findElement(By.linkText(locator));
                    break;
                case "xpath":
                    locpath = WebDriver.findElement(By.xpath(locator));
                  //js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 1px solid blue;');", driver.findElement(By.xpath(locator)));
                    break;
                case "cssSelector":
                    locpath = WebDriver.findElement(By.cssSelector(locator));
                    break;
                case "partialLinkText":
                    locpath = driver.findElement(By.partialLinkText(locator));
                    break;
                case "className":
                    locpath = driver.findElement(By.className(locator));
                    break;
                case "tagName":
                    locpath = driver.findElement(By.tagName(locator));
                    break;

            }

        } catch (Exception e) {

            //e.printStackTrace();
            System.out.println("unable to find the locator::" + " " + locator);
            //ReportFunctions.LogRepoter("Fail", "locator not identified", " unable to find the locator::" + "  " + locator);

        }

        return locpath;

    }//method

    public static boolean GETNUMBERFROMTEXT(WebDriver driver, String parameters) throws Exception {
        String ovalue = null;
        String key;

        try {
            String[] arguments = null;
            arguments = splitfunction(parameters, "->");
            key = arguments[3];
            WebElement locator = null;
            if (arguments[1].matches(".*:.*")) {
                locator = Getlocator(driver, arguments[1]);// old method calling
            } else {

                locator = getlocatorKeyValue(driver, arguments[1]); // object repository method calling
            }
            ovalue = locator.getAttribute("value");
            if (ovalue == null) {
                ovalue = locator.getText();
                Pattern p = Pattern.compile("\\d+");
                Matcher m = p.matcher(ovalue);
                if (m.find()) {
                    ovalue = m.group();
                } else {
                    ovalue = null;
                }
            }
            if (ovalue != null) {
                //added by Satish
                hmap.put(key, ovalue);
                captureVariableData(key, ovalue);
                System.out.println("captured the value" + "  " + arguments[2] + "   " + ovalue);
                ReportFunctions.LogRepoter("pass", "capture the text", "captured the value" + "  " + arguments[2] + "   " + ovalue);
                return true;
            } else {
                System.out.println("value is null" + " " + ovalue);
                ReportFunctions.LogRepoter("Fail", "capture the text", " unable to capture the value" + "  " + arguments[2]);
                //CLOSEALLBROWSERS(driver);
                return false;
            }

        } catch (Exception e) {
            System.out.println("exception value : " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "capture the text", " unable to locate the element");
            //CLOSEALLBROWSERS(driver);
            return false;
        }
    }//method
//This method is used to capture application data and saves into properties file.

    public static void captureVariableData(String key, String ovalue) throws IOException {
        Properties propObj = new Properties();
        FileInputStream fis = new FileInputStream(readpath() + "\\EnvironmentalFiles\\data.properties");
        propObj.load(fis);
        fis.close();
        FileOutputStream out = new FileOutputStream(readpath() + "\\EnvironmentalFiles\\data.properties");
        if (propObj.containsKey(key)) {
            propObj.replace(key, ovalue);
            propObj.store(out, null);
            out.close();
        } else {
            propObj.setProperty(key, ovalue);
            propObj.store(out, null);
            out.close();
        }
    }//method

    public static String getVariableData(String key) throws IOException {
        String value = null;
        Properties propObj = new Properties();
        FileInputStream fis = new FileInputStream(readpath() + "\\EnvironmentalFiles\\data.properties");
        propObj.load(fis);
        if (propObj.containsKey(key)) {
            value = propObj.getProperty(key);
            System.out.println("PP file value :" + key);
            fis.close();
            return value;
        } else {
            fis.close();
            return value;
        }
    }//method

    public static Boolean DJANGOFIN(String Parameters) throws Exception {
        Boolean Status = true;
        String[] arguments = splitfunction(Parameters, "->");
        String[] data = splitfunction(arguments[1], ",");
        //System.out.println("length :"+data.length);
        if (data.length == 3) {
            //String conn="{\"username\": \""+username+"\",\"password\": \""+password+"\"}";  
            String SID = hmap.get(data[0]);
            //System.out.println("hmap.get(data[0] :"+SID);
            if (SID == null) {
                SID = getVariableData(data[0]);
            }
            System.out.println("SPonsor ID :" + SID);
            // SID="1370";
            String FID = hmap.get(data[1]);
            String type = data[2];
            System.out.println("PaymentType :" + type);
            String uname = hmap.get("GV_GravityUser");
            String pwd = hmap.get("GV_GravityPWD");
            String loginURL = hmap.get("DJANGOlogin");
            String conn = "{\"username\": \"" + uname + "\",\"password\": \"" + pwd + "\"}";
            //API Call
            Client client = Client.create();
            WebResource wr = client.resource(loginURL);
            ClientResponse resp = wr.header("Authorization", "No Auth").type("application/json").accept("application/json").post(ClientResponse.class, conn);
            String jsonStr = resp.getEntity(String.class);
            JSONObject obj = new JSONObject(jsonStr);
            String token = "JWT " + obj.get("token").toString();
            //System.out.println("token :"+token);
            //API Adding Financial Identifier
            String finURL = "https://ekqa.gravtee.com/bolapi/v1/sponsors/" + SID + "/billing-config/";
            String finReq = "{\"id\":602,\"financial_identifier\":\"" + FID + "\","
                    + "\"balance\":25000,\"credit_limit\":25000,\"due_amount\":0,\"due_date\":null,\"tax_rate_id\":2,"
                    + "\"billing_plan\":{\"id\":\"\",\"payment_plan\":\"" + type + "\",\"rate\":0.071}}";
            System.out.println("finURL :" + finURL);
            // System.out.println("finReq :"+finReq);
            Client client1 = Client.create();
            WebResource wr1 = client1.resource(finURL);
            ClientResponse resp1 = wr1.header("Authorization", token).type("application/json").accept("application/json").post(ClientResponse.class, finReq);
            String jsonStr1 = resp1.getEntity(String.class);
            JSONObject obj1 = new JSONObject(jsonStr1);
            System.out.println("response :" + obj1.toString());
            ReportFunctions.LogRepoter("Pass", "Sponsor id" + SID, "DJANGO API Passed" + obj1.toString());
        } else {
            System.out.println("SponsorID value is missing");
            ReportFunctions.LogRepoter("Fail", "Invalid Sponsor id", "DJANGO API Failed");
        }

        return Status;
    }//method

    public static boolean SCROLLDOWN(WebDriver WebDriver, String parameters) throws InterruptedException {
        boolean flag = false;
        String[] arguments = null;
        Boolean Status = true;
        arguments = splitfunction(parameters, "\\->");
        String xpath = arguments[1];
        try {
            WebElement m = driver.findElement(By.xpath(xpath));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true)", m);

            flag = true;
            return true;
        } catch (Exception e) {
            System.out.println("unable to find the locator" + " " + e.getMessage());
            ReportFunctions.LogRepoter("Fail", "close pop up", "Loader image is still present");
            return false;
        }

    }
}
