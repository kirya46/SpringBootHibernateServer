package com.common.util.log;

import org.apache.log4j.Logger;

import java.util.Arrays;


/**
 * Created by Kirill Stoianov on 04/09/17.
 */
public class Log {

    public enum Level {ALL, DEBUG, ERROR}

    private String TAG = Log.class.getSimpleName();

    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RANDOM = "\u001B[35m";
    private static final String ANSI_RESET = "\u001B[0m";


    private Logger logger;
    private Level level;

    public Log(String tag) {
        this(tag, Level.ALL);
    }

    public Log(Class<?> clazz) {
        this(clazz, Level.ALL);
    }

    public Log(Class clazz, Level level) {
        this(clazz.getSimpleName(), level);
    }

    public Log(String tag, Level level) {
        this.TAG = tag;
        this.logger = Logger.getLogger(this.TAG);
        setLogLevele(level);
    }

    public void setLogLevele(Level level) {

        this.level = level;

        switch (level) {
            case ALL:
                this.logger.setLevel(org.apache.log4j.Level.ALL);
                break;
            case DEBUG:
                this.logger.setLevel(org.apache.log4j.Level.DEBUG);
                break;
            case ERROR:
                this.logger.setLevel(org.apache.log4j.Level.WARN);
                break;
        }
    }

    /*instance*/
    public void debug(String message) {
        if (this.level.equals(Level.ALL) || this.level.equals(Level.DEBUG))
            this.logger.debug(message);

        //https://stackoverflow.com/questions/1486233/java-logging-show-the-source-line-number-of-the-caller-not-the-logging-helper
    }

    public void error(String message) {

        //colorize string
        message = ANSI_RED + message + ANSI_RESET;

        if (this.level.equals(Level.ALL) || this.level.equals(Level.DEBUG) || this.level.equals(Level.ERROR)) {
            this.logger.error(message);
        }

    }

    public void error(Exception e) {
        this.error(e.getClass().getSimpleName() + ": " + e.getMessage());
    }

    public void error(String descriptionMessage, Exception e) {
        this.error(descriptionMessage + " Caused with: " + e.getMessage() + ". Stack trace: " + Arrays.toString(e.getStackTrace()));
    }

    public void error(String descriptionMessage, Throwable e) {
        this.error(descriptionMessage + " Caused with: " + e.getClass().getSimpleName() + ": " + e.getMessage() + ". Stack trace: " + Arrays.toString(e.getStackTrace()));
    }

    public void fatalError(RuntimeException e) {
        this.fatalError(null,e);
    }

    public void fatalError(String description, Exception exception){
        String s =
                "\n"+ANSI_RED+"====================================================================================================\n" +
                        (description!=null?description:"") + " Cause with: " +exception.getClass().getSimpleName() + ": " + exception.getMessage() +
                        "\n===================================================================================================="+ANSI_RESET+"\n\n";
        this.logger.fatal(s);
    }

    public void warning(String message) {

        //colorize string
        message = ANSI_YELLOW + message + ANSI_RESET;

        if (this.level.equals(Level.ALL) || this.level.equals(Level.DEBUG) || this.level.equals(Level.ERROR))
            this.logger.warn(message);
    }

    /*static*/


    //    err("ERROR " + TAG, message);
    public static void d(String tag, String message) {
        System.out.println(tag + ": " + message);
    }

    public static void wrn(String tag, String message) {
        System.err.println(ANSI_YELLOW + tag + ": " + message + ANSI_RESET);
    }

    public static void colorized(String tag, String message) {
//        System.err.println(ANSI_RANDOM + tag + ": " + message + ANSI_RESET);
        System.err.println(ANSI_RANDOM +  message + ANSI_RESET);
    }

    public static void err(String tag, String message) {
        System.err.println(ANSI_RED + tag + ": " + message + ANSI_RESET);
    }

    public static void wtf(String tag, String message) {
        System.err.println(ANSI_RED + tag + ": " + message + ANSI_RESET);
    }

}
