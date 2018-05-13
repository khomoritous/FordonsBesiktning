package se.moma.kth.iv1350.util;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Hjälper till att visa felmeddelanden till användaren.
 * @author monde
 */
public class ErrorMessageHandler {
    
    
    /**
     * @param msg Textsträng som anger felmeddelandet.
     */
    public void showErrorMsg(String msg) {
        StringBuilder errorMsgBuilder = new StringBuilder();
        errorMsgBuilder.append(createTime());
        errorMsgBuilder.append(",ERROR: ");
        errorMsgBuilder.append(msg);
        System.out.println(errorMsgBuilder);
    } 
    
    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
    
    
    
}