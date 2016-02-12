package com.base;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.util.Configuration;

/**
 * Created by Shruti Reddy
 */
public abstract class BaseTest {

    public static final Configuration config;
    public Logger logger;

    static {
        config = new Configuration("web");
        
        
    }

   
  

    public BaseTest() {
          logger = Logger.getLogger(BaseTest.class);
          PropertyConfigurator.configure("/Users/shruti/Documents/workspace/SutterHealth/log4j.properties");

    }

}

