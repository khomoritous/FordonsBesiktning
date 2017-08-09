/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moma.se.kth.iv1350.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Skapar en logg för undantag som kastas.
 * @author monde
 */
public class LogHandler {
    
    private static final String LOG_FILE_NAME = "fordonsbesiktning-log.txt";
    
    private PrintWriter logFile;
    
    /**
     * Skapar en ny instans.
     * Sköter in- och outputströmmar.
     * @throws <code>IOException</code>, om öppnande till in- och outpuströmmar misslyckades.
     */
    public LogHandler() throws IOException {
        logFile = new PrintWriter(new FileWriter(new File(LOG_FILE_NAME),true),true);
    }
    
    /**
     * Skriver till logfilen.
     * @param exception Instans av klassen <code>Exception</code> som skrivs 
     * logfilen.
     */
    public void logException(Exception exception) {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(createTime());
        logMsgBuilder.append(",Exception was thrown: ");
        logMsgBuilder.append(exception.getMessage());
        logFile.println(logMsgBuilder);
        exception.printStackTrace(logFile);
        
    } 
    
    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
    
}
