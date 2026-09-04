package Shared_Data.Browser;

import org.openqa.selenium.WebDriver;

public class Browser_Factory {

        public WebDriver getBrowserFactory(){

            String browser = System.getProperty("browser");

            switch (browser){
                case Browser_Type.BROWSER_CHROME:
                    Chrome_Service_Browser chromeServiceBrowser = new Chrome_Service_Browser();
                    chromeServiceBrowser.openBrowser();
                    System.out.println("Acum ruleaza pe " + browser);
                    return chromeServiceBrowser.getDriver();

                case Browser_Type.BROWSER_EDGE:
                    Edge_Service_Browser edgeServiceBrowser = new Edge_Service_Browser();
                    edgeServiceBrowser.openBrowser();
                    System.out.println("Acum ruleaza pe " + browser);
                    return edgeServiceBrowser.getDriver();
            }
            return null;
        }
}

