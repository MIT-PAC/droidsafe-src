package org.apache.harmony.security.x501;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.harmony.security.asn1.ASN1Choice;
import org.apache.harmony.security.asn1.ASN1StringType;
import org.apache.harmony.security.asn1.ASN1Type;

public final class DirectoryString {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.505 -0400", hash_original_method = "7175B1E9416E14F4EEA3B1FA3995AEFC", hash_generated_method = "7175B1E9416E14F4EEA3B1FA3995AEFC")
        public DirectoryString ()
    {
    }


    public static final ASN1Choice ASN1 = new ASN1Choice(new ASN1Type[] {
           ASN1StringType.TELETEXSTRING,
           ASN1StringType.PRINTABLESTRING,
           ASN1StringType.UNIVERSALSTRING,
           ASN1StringType.UTF8STRING,
           ASN1StringType.BMPSTRING }) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.505 -0400", hash_original_method = "B50919D6E7CA13884A6C9F096964941D", hash_generated_method = "2295646329199676050FCE8D3D26C17C")
        @DSModeled(DSC.SAFE)
        public int getIndex(java.lang.Object object) {
            dsTaint.addTaint(object.dsTaint);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.505 -0400", hash_original_method = "75F68B3A16DBDA02F9B0A49BA52B584E", hash_generated_method = "034259263D6A1DB22C3247102039B9A1")
        @DSModeled(DSC.SAFE)
        public Object getObjectToEncode(Object object) {
            dsTaint.addTaint(object.dsTaint);
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return  object;
        }

        
}; //Transformed anonymous class
}

