package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PrefixPrinter implements Printer {
    private Printer mPrinter;
    private String mPrefix;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.312 -0400", hash_original_method = "F8CFF4B37C5F46A6632B10286A6992AD", hash_generated_method = "7A3788421EBA6631E344216927127F0D")
    @DSModeled(DSC.SAFE)
    private PrefixPrinter(Printer printer, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(printer.dsTaint);
        // ---------- Original Method ----------
        //mPrinter = printer;
        //mPrefix = prefix;
    }

    
        public static Printer create(Printer printer, String prefix) {
        if (prefix == null || prefix.equals("")) {
            return printer;
        }
        return new PrefixPrinter(printer, prefix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.313 -0400", hash_original_method = "278C97F139303CC78C423B9DD8BE836F", hash_generated_method = "5E89FB61B10E74093747F71CFF4DC2DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(String str) {
        dsTaint.addTaint(str);
        mPrinter.println(mPrefix + str);
        // ---------- Original Method ----------
        //mPrinter.println(mPrefix + str);
    }

    
}

