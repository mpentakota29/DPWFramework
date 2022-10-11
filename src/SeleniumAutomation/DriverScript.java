package SeleniumAutomation;

import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Properties;

import static SeleniumAutomation.ReportFunctions.iteratorCnt;
public class DriverScript extends CommonFunctions implements Runnable
{
    public static org.openqa.selenium.WebDriver WebDriver;
    public static boolean dockerlaunch;
    public static boolean LocalLaunch = false;
    public static boolean dockerChromeFirefoxedgelaunch = false;
    public static boolean dockerChromeFirefoxlaunch = false;
    public static boolean dockerChromelaunch = false;
    public static int finval;
    public static int rowcount;
    public static int rowcount1;
    public static int colval;
    public static int colcount;
    public static int colcount1;
    public static int Rowval;
    public static String CellData;
    public static String NumVal;
    public static Sheet sheet;
    public static Sheet sheet1;
    public static int flag;
    public static String Strparameters;
    public static java.util.Date odate;
    public static String blankcell;
    public static int count;
    public static boolean CellValue;
    public static boolean blnResult;
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
    public static int x;
    public static int newcol = 0;

    public DriverScript(org.openqa.selenium.WebDriver WebDriver, String Path)
    {

       // super(WebDriver, Path,Browser);
        // TODO Auto-generated constructor stub
        this.Path = Path;
        this.WebDriver = WebDriver;


    }

    public void run()


    {
        try {
            ReadSuite(Path);
        } catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    String Path;
    public static org.openqa.selenium.WebDriver DockerChromeDriver(String Browser) throws MalformedURLException, InterruptedException
    {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName(Browser);

        URL url = new URL("http://localhost:4444/wd/hub");

        WebDriver = new RemoteWebDriver(url,dc);



        return WebDriver;


    }



  // ************************************************************************************************************************
	/*
	 * Function Name:CHECKING WHETHER SUITE EXECUTION STATUS IS YES/NO
	 * If execution status is YES it will capture the suite
	 * Author: Sahitya
	 */
    // *************************************************************************************************************************

    @SneakyThrows
    public static void main(String[] args) throws InterruptedException
    {


      //startDockerGrid();
      DriverScript ds = new DriverScript(driver,"AmazonSuite");
    //Thread.sleep(12000);
      DriverScript ds2 = new DriverScript(driver2,"FlipkartSuite");
      Thread th  = new Thread(ds);
      Thread th2  = new Thread(ds2);
      th.start();
      Thread.sleep(12000);
      th2.start();
       // ReadSuite("FlipkartSuite");


    }


    public  static void ReadSuite(String Suitepath) throws Throwable
    {

        final long MSEC_SINCE_EPOCH = System.currentTimeMillis();
	       String workingDirectory = new File(".").getCanonicalPath();
	        String dir = workingDirectory;
	        String Estatus;
	        String esuite;
	        java.lang.String suiteExecutionFile = dir + "\\SuiteFiles\\"+Suitepath+".xlsx";
	        FileInputStream fs = new FileInputStream(suiteExecutionFile);
	        Workbook wbs = new XSSFWorkbook(fs);
	        Sheet ssheet = wbs.getSheetAt(0);
	        int rc = ssheet.getLastRowNum();
	        int valr;
        Cell cell1 = ssheet.getRow(1).getCell(3);
        Cell cell2 = ssheet.getRow(1).getCell(4);


        Cell cell3 = ssheet.getRow(1).getCell(5);
        Cell cell4 = ssheet.getRow(1).getCell(6);

        String Estatus1 = cell1.getStringCellValue();
        String Estatus2 = cell2.getStringCellValue();
        String Estatus3 = cell3.getStringCellValue();
        String Estatus4 = cell4.getStringCellValue();


        if(Estatus1.trim().equalsIgnoreCase("Docker"))
        {

            dockerlaunch = true;
            if(Estatus2.trim().equalsIgnoreCase("YES")&&Estatus3.trim().equalsIgnoreCase("YES")&&Estatus4.trim().equalsIgnoreCase("YES"))
            {

                dockerChromeFirefoxedgelaunch = true;


            }

            else if(Estatus2.trim().equalsIgnoreCase("YES")&&Estatus4.trim().equalsIgnoreCase("YES"))

            {

                dockerChromeFirefoxlaunch = true;


            }

            else if(Estatus2.trim().equalsIgnoreCase("YES"))
            {

                dockerChromelaunch = true;

            }



        }
        else if(Estatus1.trim().equalsIgnoreCase("Local")) {

            LocalLaunch = true;
            if (Estatus2.trim().equalsIgnoreCase("YES") && Estatus3.trim().equalsIgnoreCase("YES") && Estatus4.trim().equalsIgnoreCase("YES")) {
                dockerChromeFirefoxedgelaunch = true;


            } else if (Estatus2.trim().equalsIgnoreCase("YES") && Estatus4.trim().equalsIgnoreCase("YES")) {
                dockerChromeFirefoxlaunch = true;


            } else if (Estatus2.trim().equalsIgnoreCase("YES")) {
                dockerChromelaunch = true;


            }
        }

	        for (valr = 1; valr <= rc; valr++)
            {
	            Row rs = ssheet.getRow(valr);
	            if (rs != null) {
	                Cell cell = ssheet.getRow(valr).getCell(1);
	                Estatus = cell.getStringCellValue();
	                if (Estatus.trim().equalsIgnoreCase("YES"))
                        {
	                    cell = ssheet.getRow(valr).getCell(0);
	                    esuite = cell.getStringCellValue();
	                    getEnvironmentDetails(esuite, dir);
	                }
	            }
	           ReportFunctions.tsID =0;
	           ReportFunctions.tcID=0;
	           ReportFunctions.tstpID=0;
	           iteratorCnt=0;
	           hmap.remove(updstpstatus);
	           TCpasscount = 0;
	           TCfailcount = 0;
	           casecount =0;
	        }

	        wbs.close();
    }


    // ************************************************************************************************************************
	/*
	 * Function Name:getEnvironmentDetails
	 * Suitepath is saved as suitename in hashmap
	 * Author: Sahitya
	 */
    // *************************************************************************************************************************

      public static void getEnvironmentDetails(String runsuitename, String dir) throws Throwable
      {
	        Tsuitename = runsuitename;
	        String suitepath = dir + "\\TestSuites\\" + runsuitename + ".xlsx";
	        if (suitename == null) {
	            suitename = "suitename";
	        }
	        hmap.put(suitename, Tsuitename);
	        FOLDERSTRUCTURE(runsuitename);
	        Readenvironmentalfile(envfilepath);
	        Readtestsuitefile(suitepath);

	    }

    // ************************************************************************************************************************
	/*
	 * Function Name:Initializationscript
	 * It will read the testcase and it will check whether the cell contains keyword or not,after keyword cell it will
           moves to next row and it will read each row one by one,and each keyword is saved in hashmap,if the cell contains empty
           data then it will not read.It will check whether multiple data set is YES/NO.
	 * Author: Sahitya
	 */
    // *************************************************************************************************************************

    public static void Initializationscript(String testcasepath) throws Throwable {
        try {
            Strparameters = "";
            count = 1;
            String workingDirectory = new java.io.File(".").getCanonicalPath();
            String FilePath = workingDirectory +"/TestCase" +testcasepath;
            //String FilePath = testcasepath;
            FileInputStream fs = new FileInputStream(FilePath);
            Workbook wb = new XSSFWorkbook(fs);
            sheet = wb.getSheetAt(0);
            // wb.setMissingCellPolicy(Row.CREATE_NULL_AS_BLANK);
            rowcount = sheet.getLastRowNum();
            colcount = sheet.getRow(rowcount).getLastCellNum();
            int Rowval = 0;
            int colval = 0;
            do {

                for (colval = 0; colval <= colcount - 1; colval++) {
                    Row ro = sheet.getRow(Rowval);
                    if (ro != null) {
                        Cell cell = sheet.getRow(Rowval).getCell(colval);
                        //int cel_Type = cell.getCellType();
                        // if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        CellData = cell.getStringCellValue();
                        CellData.trim();
                        //System.out.println(CellData);
                        if (cell.getRichStringCellValue().getString().trim().equals("Keyword")) {
                            finval = Rowval + 1;
                            Rowval = rowcount + 1;
                            //System.out.println(finval);
                            break;
                        }
                        //}
                    }
                }
                Rowval = Rowval + 1;
            } while (rowcount + 1 > Rowval);

        } catch (Exception e) {

            //e.printStackTrace();
            System.out.println(e.getMessage());
        }

        int currentrow = finval;
        while (rowcount + 1 > currentrow) {
            for (colval = 0; colval <= colcount - 1; colval++) {
                Row r1 = sheet.getRow(currentrow);
                if (r1 != null) {
                    Cell cell = sheet.getRow(currentrow).getCell(colval);
                    int cel_Type = cell.getCellType();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            if (DateUtil.isCellDateFormatted(sheet.getRow(currentrow).getCell(colval))) {
                                odate = cell.getDateCellValue();
                                System.out.println(sdf.format(odate));
                                flag = 1;

                            } else {
                                NumVal = String.valueOf((int) cell.getNumericCellValue());
                                flag = 2;
                            }
                            break;
                        case Cell.CELL_TYPE_STRING:
                            CellData = cell.getStringCellValue();
                            flag = 3;
                            break;
                        case Cell.CELL_TYPE_BLANK:
                            blankcell = "";
                            flag = 4;
                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            CellValue = cell.getBooleanCellValue();
                            flag = 5;
                            break;

                        default:
                            break;
                    }

                }
                if (flag == 1) {
                    Strparameters = Strparameters + "->" + sdf.format(odate);
                } else if (flag == 2) {
                    Strparameters = Strparameters + "->" + NumVal;
                } else if (flag == 3) {

                    Strparameters = Strparameters + "->" + CellData;
                    if (count == 1) {
                        Strparameters = Strparameters.replace("->", "");
                    }
                    count = count + 1;
                } else if (flag == 4) {
                    Strparameters = Strparameters + blankcell;
                } else if (flag == 5) {
                    Strparameters = Strparameters + "->" + CellValue;
                }
            }
            String[] parameters = Strparameters.split("->");
            if (Tstep == null) {
                Tstep = "Tstep";
            }
            hmap.put(Tstep, parameters[0]);
            if (parameters[0].contains("#")) {
                Strparameters = "";
                count = 1;
                currentrow = currentrow + 1;
            } else {
                if (Strparameters.toUpperCase().contains("SKIP")) {
                    Strparameters = "";
                    count = 1;
                    currentrow = currentrow + 1;
                } else {
                    blnResult = Invokekeyword(WebDriver,parameters[0], Strparameters);
                    if (blnResult == false) {
                       if (Tsuitename.toUpperCase().contains("SANITY"))
                       {
                       } else {
                           break;
                      }
                    }
                    Strparameters = "";
                    count = 1;
                    currentrow = currentrow + 1;
                }
            }
        }
        // x = 2;
        if (muldatastatus.equals("Yes")) {
            String temp = null;
            //temp = Tcasename;
            //temp = temp + "_" + x;
            //hmap.put(Tcase, temp);
            MulInitializationscript(testcasepath);
        }

    }
     static Properties prop;
    public static void readObjRepositoryFile()
    {
        final String propFile = System.getProperty("user.dir")+ "//Config//Object_Repository.properties";
        File file = new File(propFile);
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
         prop = new Properties();
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ***********************************************************************************************************************************************
	/*
	 * Function Name:Invokekeyword
	 * This method compares all the keywords using all switch case statements one by one,after comparing if it is true then it will execute switch case
	 * Author: Sahitya
	 */
    // *************************************************************************************************************************


    // *************************************************************************************************************************
	/*
	 * Function Name: MulInitializationscript
	 * If testcase contains Multiple data set is YES,then it will read the testcase which contains multiple data in sheet2
	 * Author: Sahitya
	 */
    // *************************************************************************************************************************

    public static void MulInitializationscript(String testcasepath) throws Throwable {

        Strparameters = "";
        count = 1;
        Boolean skipflag = false;
        String FilePath = testcasepath;
        FileInputStream fs = new FileInputStream(FilePath);
        Workbook wb = new XSSFWorkbook(fs);
        sheet = wb.getSheetAt(0);
        sheet1 = wb.getSheetAt(1);
        // wb.setMissingCellPolicy(Row.CREATE_NULL_AS_BLANK);
        rowcount = sheet.getLastRowNum();
        colcount = sheet.getRow(rowcount).getLastCellNum();
        rowcount1 = sheet1.getLastRowNum();
        colcount1 = sheet1.getRow(rowcount1).getLastCellNum();
        int Rowval = 0;
        int colval = 0;
        int Rowval1;
        for (Rowval1 = 1; Rowval1 <= rowcount1; Rowval1++) {
            do {
                Cell cell1 = sheet1.getRow(Rowval1).getCell(0);
                Tcasename = cell1.getStringCellValue();
                hmap.put(Tcase, Tcasename);
                for (colval = 0; colval <= colcount - 1; colval++) {
                    Row ro = sheet.getRow(Rowval);
                    if (ro != null) {
                        Cell cell = sheet.getRow(Rowval).getCell(colval);
                        //int cel_Type = cell.getCellType();
                        // if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        CellData = cell.getStringCellValue();
                        CellData.trim();
                        //System.out.println(CellData);
                        if (cell.getRichStringCellValue().getString().trim().equals("Keyword")) {
                            finval = Rowval + 1;
                            Rowval = rowcount + 1;
                            //System.out.println(finval);
                            break;
                        }
                        //}
                    }
                }
                Rowval = Rowval + 1;
            } while (rowcount + 1 > Rowval);

            int currentrow = finval;
            while (rowcount + 1 > currentrow) {
                for (colval = 0; colval <= colcount - 2; colval++) {
                    Row r1 = sheet.getRow(currentrow);
                    if (r1 != null) {
                        Cell cell = sheet.getRow(currentrow).getCell(colval);
                        int cel_Type = cell.getCellType();
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                if (DateUtil.isCellDateFormatted(sheet.getRow(currentrow).getCell(colval))) {
                                    odate = cell.getDateCellValue();
                                    System.out.println(sdf.format(odate));
                                    flag = 1;

                                } else {
                                    NumVal = String.valueOf((int) cell.getNumericCellValue());
                                    flag = 2;
                                }
                                break;
                            case Cell.CELL_TYPE_STRING:
                                CellData = cell.getStringCellValue();
                                flag = 3;
                                break;
                            case Cell.CELL_TYPE_BLANK:
                                blankcell = "";
                                flag = 4;
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                CellValue = cell.getBooleanCellValue();
                                flag = 5;
                                break;

                            default:
                                break;
                        }

                    }
                    if (flag == 1) {
                        Strparameters = Strparameters + "->" + sdf.format(odate);
                    } else if (flag == 2) {
                        Strparameters = Strparameters + "->" + NumVal;
                    } else if (flag == 3) {

                        Strparameters = Strparameters + "->" + CellData;
                        if (count == 1) {
                            Strparameters = Strparameters.replace("->", "");
                        }
                        count = count + 1;
                    } else if (flag == 4) {
                        Strparameters = Strparameters + blankcell;
                    } else if (flag == 5) {
                        Strparameters = Strparameters + "->" + CellValue;
                    }
                }
                Cell cell2 = sheet.getRow(currentrow).getCell(3);
                if (cell2.getCellType() == cell2.CELL_TYPE_BLANK) {
                } else {
                    Cell cell1 = sheet1.getRow(Rowval1).getCell(newcol + 1);
                    if (cell1.getCellType() == cell2.CELL_TYPE_NUMERIC) {
                        CellData = String.valueOf((int) cell1.getNumericCellValue());
                        Strparameters = Strparameters + "->" + CellData;
                        newcol = newcol + 1;
                    } else {
                        CellData = cell1.getStringCellValue();
                        Strparameters = Strparameters + "->" + CellData;
                        newcol = newcol + 1;
                        if (CellData.toUpperCase().equalsIgnoreCase("SKIP")) {
                            skipflag = true;
                        }
                    }
                }
                String[] parameters = Strparameters.split("->");
                if (Tstep == null) {
                    Tstep = "Tstep";
                }
                hmap.put(Tstep, parameters[0]);
                if ((Tcasename.contains("#")) || (Strparameters.contains("#"))) {
                    Strparameters = "";
                    count = 1;
                    currentrow = currentrow + 1;
                } else {
                    if (skipflag == true) {
                        Strparameters = "";
                        count = 1;
                        skipflag = false;
                        currentrow = currentrow + 1;
                    } else {
                        blnResult = Invokekeyword(WebDriver,parameters[0], Strparameters);
                        if (blnResult == false) {
//                            if (Tsuitename.toUpperCase().contains("SANITY")) {
//                            } else {
                                break;
//                            }
                        }
                        Strparameters = "";
                        count = 1;
                        currentrow = currentrow + 1;
                    }
                }
            }
            // x = x + 1;
            //Tcasename = Tcasename + "_" + x;
            //hmap.put(Tcase, Tcasename);
            // Tcasename = Tcasename.replace("_" + x, "");
            newcol = 0;
            Strparameters = "";
            count = 1;
        }
    }
}
