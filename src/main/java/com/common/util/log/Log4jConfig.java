package com.common.util.log;

import org.apache.log4j.*;

import java.io.File;

/**
 * Created by Kirill Stoianov on 04/09/17.
 */
public class Log4jConfig {

    private static String logFilePath = System.getProperty("user.dir")+ File.separator + "main.log";

    public Log4jConfig() {
        // configures the root logger
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.ALL);

        // creates pattern layout
        PatternLayout layout = new PatternLayout();

        String conversionPattern = "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n";
        layout.setConversionPattern(conversionPattern);

        // creates console appender
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setLayout(layout);
        consoleAppender.activateOptions();

        //set console appender
        rootLogger.addAppender(consoleAppender);

        // creates file appender
        if (logFilePath != null && !logFilePath.equals("")) {
            RollingFileAppender fileAppender = new RollingFileAppender();
            fileAppender.setFile(logFilePath);
            fileAppender.setMaxBackupIndex(0); //file counts
            fileAppender.setMaxFileSize("500000000"); // 500000000 = 500MB
            fileAppender.setBufferSize(fileAppender.getBufferSize() * 2);
            fileAppender.setLayout(layout);
            fileAppender.activateOptions();

            //set file appender
            rootLogger.addAppender(fileAppender);
        } else {
            Log.wrn("\n" + Log4jConfig.class.getSimpleName(), "Log file path is not defined. Logs writes only in console\n");
        }
    }
}
