package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class InputMismatchException extends NoSuchElementException implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.090 -0400", hash_original_method = "E660D99FFDDF21F21077CDA3D732980B", hash_generated_method = "FB144C024DC7EC0E617E9E9B95497E86")
    public  InputMismatchException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.090 -0400", hash_original_method = "47047CB10E710A9BD2F04A12F2CE94CF", hash_generated_method = "AA3FF23E9205A85C7C05DC2E94DE10ED")
    public  InputMismatchException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.090 -0400", hash_original_field = "2C673C009E40DFCC348A4514679C11A6", hash_generated_field = "2B9B54720A6E14E024007AD123351E53")

    private static long serialVersionUID = 8811230760997066428L;
}

