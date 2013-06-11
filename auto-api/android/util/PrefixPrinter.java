package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class PrefixPrinter implements Printer {
    private final Printer mPrinter;
    private final String mPrefix;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.656 -0400", hash_original_method = "F8CFF4B37C5F46A6632B10286A6992AD", hash_generated_method = "F8F4FB90C261FDD6C196513931F168A4")
    @DSModeled(DSC.SAFE)
    private PrefixPrinter(Printer printer, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(printer.dsTaint);
        // ---------- Original Method ----------
        //mPrinter = printer;
        //mPrefix = prefix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.656 -0400", hash_original_method = "A0BB95EDEC5F19F9948C1664AD39C99B", hash_generated_method = "CECCF24EB637E7DDDE076A2842FAEA70")
    public static Printer create(Printer printer, String prefix) {
        if (prefix == null || prefix.equals("")) {
            return printer;
        }
        return new PrefixPrinter(printer, prefix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.656 -0400", hash_original_method = "278C97F139303CC78C423B9DD8BE836F", hash_generated_method = "05293BEFC3768FA4C45046D837CA48DF")
    @DSModeled(DSC.SAFE)
    public void println(String str) {
        dsTaint.addTaint(str);
        mPrinter.println(mPrefix + str);
        // ---------- Original Method ----------
        //mPrinter.println(mPrefix + str);
    }

    
}


