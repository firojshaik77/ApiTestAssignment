package org.testng.propertymgr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Purpose: Defines a helper class for loading property files.
 * @author Firoj Shaik
 *
 */
public class PropertyManager {

    private final Properties property;
    public int RESPONSE_STATUS_CODE_200 = 200;
    //public int RESPONSE_STATUS_CODE_201 = 201;

    /**
     * Constructor for PropertyManager.
     */
    public PropertyManager() {
        property = new Properties();
    }

    /**
     * Method for loading property file.
     * @param propertyToLoad
     * @return
     */
    public Properties loadPropertyFile(String propertyToLoad) {
        try {
            property.load(new FileInputStream(new File(System
                    .getProperty("user.dir")
                    + "\\src\\test\\java\\org\\testng\\properties\\"
                    + propertyToLoad)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
}

	
	
	
	


