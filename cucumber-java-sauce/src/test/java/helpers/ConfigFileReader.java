package helpers;

import enums.DriverType;
import enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ConfigFileReader {
    private Properties properties;

    public ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = "config//Configuration.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPathChrome() {
        String driverPath = properties.getProperty("driverPathChrome");
        if (driverPath != null) return driverPath;
        else
            throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");
    }

    public String getDriverPathFirefox() {
        String driverPath = properties.getProperty("driverPathFirefox");
        if (driverPath != null) return driverPath;
        else
            throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");
    }


    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) {
            try {
                return Long.parseLong(implicitlyWait);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
            }
        }
        return 30;
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else
            throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
    }

    /**
     * Default value is returned as DriverType.Chrome in case of Null.
     * Exception is thrown if the value does not match with anything.
     */

    public DriverType getBrowser() {
        String browserName = System.getProperty("browser");
        if (browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
        else if (browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else if (browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
        else
            throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }


    /**
     * EnvironmentType.Local is returned in case of Null and if the value is equal to Local.
     * Which means that in case of missing environment property,
     * execution will be carried on local machine.
     */
    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");
        if (environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
        else if (environmentName.equals("remote")) return EnvironmentType.REMOTE;
        else
            throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
    }

    /**
     * Retrieve the property using getProperty method of Properties class.
     * Null check is performed and in case of null by default value is returned as true.
     * In case of not null, String value is parsed to Boolean.
     */


    public Boolean getBrowserWindowSize() {
        String windowSize = properties.getProperty("windowMaximize");
        if (windowSize != null) return Boolean.valueOf(windowSize);
        return true;
    }

    public String getReportConfigPath() {
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if (reportConfigPath != null) return reportConfigPath;
        else
            throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    public String getConfluenceUser() {
        return properties.getProperty("confluenceUser");
    }

    public String getConfluenceAPIKey() {
        return properties.getProperty("confluenceAPIKey");
    }
}
