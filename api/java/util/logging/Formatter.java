package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public abstract class Formatter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.061 -0400", hash_original_method = "3D350E85A089AFD791F4A318777DFCA3", hash_generated_method = "6FBB4F35E1975CE926BE7C768BE8709E")
    protected  Formatter() {
        // ---------- Original Method ----------
    }

    
    public abstract String format(LogRecord r);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.063 -0400", hash_original_method = "C04F7375B92ACCB2488DC0EF0253C5B2", hash_generated_method = "6E31749E63894F597E79D5DDD5D814FF")
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
String var407D32260E541B695CF3FD3F7EFB76AB_13198181 =         pattern;
        var407D32260E541B695CF3FD3F7EFB76AB_13198181.addTaint(taint);
        return var407D32260E541B695CF3FD3F7EFB76AB_13198181;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.064 -0400", hash_original_method = "07107B089EAE5612AD155B7D9F923109", hash_generated_method = "2A05E7E97CE2EBB45C5A67CFF706F2B4")
    public String getHead(Handler h) {
        addTaint(h.getTaint());
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1678275127 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1678275127.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1678275127;
        // ---------- Original Method ----------
        //return "";
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.064 -0400", hash_original_method = "C189C1A511189A9AF799AA8C081148A1", hash_generated_method = "193ACCC2A80FE735AD2F0EC7A5D161DB")
    public String getTail(Handler h) {
        addTaint(h.getTaint());
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_377276471 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_377276471.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_377276471;
        // ---------- Original Method ----------
        //return "";
    }

    
}

