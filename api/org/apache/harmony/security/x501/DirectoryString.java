package org.apache.harmony.security.x501;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.harmony.security.asn1.ASN1Choice;
import org.apache.harmony.security.asn1.ASN1StringType;
import org.apache.harmony.security.asn1.ASN1Type;




public final class DirectoryString {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.725 -0400", hash_original_method = "53F57E3BE98311F5CEA26B08849D5BFD", hash_generated_method = "53F57E3BE98311F5CEA26B08849D5BFD")
    public DirectoryString ()
    {
        //Synthesized constructor
    }


    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.725 -0400", hash_original_field = "E7E2E2A95D92BDA7E2FD183733591C19", hash_generated_field = "9D15DB0196D54BA7CB009367A7A70C68")

    public static final ASN1Choice ASN1 = new ASN1Choice(new ASN1Type[] {
           ASN1StringType.TELETEXSTRING,
           ASN1StringType.PRINTABLESTRING,
           ASN1StringType.UNIVERSALSTRING,
           ASN1StringType.UTF8STRING,
           ASN1StringType.BMPSTRING }) {

        @DSModeled(DSC.SAFE)
        public int getIndex(java.lang.Object object) {
            return 1; 
            
        }

        @DSModeled(DSC.SAFE)
        public Object getObjectToEncode(Object object) {
            return  object;
        }
    };
    // orphaned legacy method
    public int getIndex(java.lang.Object object) {
            return 1; 
            
        }
    
    // orphaned legacy method
    public Object getObjectToEncode(Object object) {
            return  object;
        }
    
}

