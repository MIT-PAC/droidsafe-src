package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class PrefixPrinter implements Printer {

    /**
     * Creates a new PrefixPrinter.
     *
     * <p>If prefix is null or empty, the provided printer is returned, rather
     * than making a prefixing printer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.594 -0500", hash_original_method = "A0BB95EDEC5F19F9948C1664AD39C99B", hash_generated_method = "CECCF24EB637E7DDDE076A2842FAEA70")
    
public static Printer create(Printer printer, String prefix) {
        if (prefix == null || prefix.equals("")) {
            return printer;
        }
        return new PrefixPrinter(printer, prefix);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.590 -0500", hash_original_field = "77E67E10829C35D24CDC79FAD30E1196", hash_generated_field = "68E1840BE1EE0E08368BEA594CC31769")

    private  Printer mPrinter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.592 -0500", hash_original_field = "63CF499203F1BC588577994953596FB6", hash_generated_field = "6FD96CD8096FFCAC99571AB291EA06B9")

    private  String mPrefix;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.597 -0500", hash_original_method = "F8CFF4B37C5F46A6632B10286A6992AD", hash_generated_method = "0CBE8A4B7DCB6AC405BBF5FD92AC017A")
    
private PrefixPrinter(Printer printer, String prefix) {
        mPrinter = printer;
        mPrefix = prefix;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.599 -0500", hash_original_method = "278C97F139303CC78C423B9DD8BE836F", hash_generated_method = "880245808C15DF5AD2EB2520DF36F7F5")
    
public void println(String str) {
        mPrinter.println(mPrefix + str);
    }
    
}

