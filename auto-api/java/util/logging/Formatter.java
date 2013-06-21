package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public abstract class Formatter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.410 -0400", hash_original_method = "3D350E85A089AFD791F4A318777DFCA3", hash_generated_method = "6FBB4F35E1975CE926BE7C768BE8709E")
    @DSModeled(DSC.SAFE)
    protected Formatter() {
        // ---------- Original Method ----------
    }

    
    public abstract String format(LogRecord r);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.411 -0400", hash_original_method = "C04F7375B92ACCB2488DC0EF0253C5B2", hash_generated_method = "480E6A6C13B06E5C0E9C7CAC7687F39E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String formatMessage(LogRecord r) {
        dsTaint.addTaint(r.dsTaint);
        String pattern;
        pattern = r.getMessage();
        ResourceBundle rb;
        rb = null;
        {
            boolean varBA984FB857383D5A65C9C6498F2E0AF7_1944620834 = ((rb = r.getResourceBundle()) != null);
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
        } //End collapsed parenthetic
        {
            Object[] params;
            params = r.getParameters();
            {
                boolean var8FAB585DC6784EA9512177C65E227803_1094216416 = (pattern.indexOf("{0") >= 0 && params != null && params.length > 0);
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
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.411 -0400", hash_original_method = "07107B089EAE5612AD155B7D9F923109", hash_generated_method = "58B69EBC015BA247484DD79AB5AE480C")
    @DSModeled(DSC.SAFE)
    public String getHead(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.411 -0400", hash_original_method = "C189C1A511189A9AF799AA8C081148A1", hash_generated_method = "07B59C2F4287AAFEF1D651F63E2B06D1")
    @DSModeled(DSC.SAFE)
    public String getTail(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "";
    }

    
}

