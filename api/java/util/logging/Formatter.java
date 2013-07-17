package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public abstract class Formatter {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.071 -0400", hash_original_method = "3D350E85A089AFD791F4A318777DFCA3", hash_generated_method = "6FBB4F35E1975CE926BE7C768BE8709E")
    protected  Formatter() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public abstract String format(LogRecord r);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.073 -0400", hash_original_method = "C04F7375B92ACCB2488DC0EF0253C5B2", hash_generated_method = "45F62138E03AA2FDD7E81C77DD4E0CC3")
    public String formatMessage(LogRecord r) {
        addTaint(r.getTaint());
        String pattern = r.getMessage();
        ResourceBundle rb = null;
        if((rb = r.getResourceBundle()) != null)        
        {
            try 
            {
                pattern = rb.getString(pattern);
            } //End block
            catch (Exception e)
            {
                pattern = r.getMessage();
            } //End block
        } //End block
        if(pattern != null)        
        {
            Object[] params = r.getParameters();
            if(pattern.indexOf("{0") >= 0 && params != null && params.length > 0)            
            {
                try 
                {
                    pattern = MessageFormat.format(pattern, params);
                } //End block
                catch (IllegalArgumentException e)
                {
                    pattern = r.getMessage();
                } //End block
            } //End block
        } //End block
String var407D32260E541B695CF3FD3F7EFB76AB_287126499 =         pattern;
        var407D32260E541B695CF3FD3F7EFB76AB_287126499.addTaint(taint);
        return var407D32260E541B695CF3FD3F7EFB76AB_287126499;
        // ---------- Original Method ----------
        //String pattern = r.getMessage();
        //ResourceBundle rb = null;
        //if ((rb = r.getResourceBundle()) != null) {
            //try {
                //pattern = rb.getString(pattern);
            //} catch (Exception e) {
                //pattern = r.getMessage();
            //}
        //}
        //if (pattern != null) {
            //Object[] params = r.getParameters();
            //if (pattern.indexOf("{0") >= 0 && params != null && params.length > 0) {
                //try {
                    //pattern = MessageFormat.format(pattern, params);
                //} catch (IllegalArgumentException e) {
                    //pattern = r.getMessage();
                //}
            //}
        //}
        //return pattern;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.073 -0400", hash_original_method = "07107B089EAE5612AD155B7D9F923109", hash_generated_method = "FB168E85580D430FD6B24F5D4EF25E02")
    public String getHead(Handler h) {
        addTaint(h.getTaint());
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1774945831 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1774945831.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1774945831;
        // ---------- Original Method ----------
        //return "";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.074 -0400", hash_original_method = "C189C1A511189A9AF799AA8C081148A1", hash_generated_method = "9352015DC86EFCD3E13946BC1025C6F3")
    public String getTail(Handler h) {
        addTaint(h.getTaint());
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_227629306 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_227629306.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_227629306;
        // ---------- Original Method ----------
        //return "";
    }

    
}

