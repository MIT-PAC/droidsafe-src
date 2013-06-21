package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class ORAddress {
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.888 -0400", hash_original_method = "ADE79A77109FECF511466010232E3557", hash_generated_method = "ADE79A77109FECF511466010232E3557")
        public ORAddress ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.889 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            new ASN1Sequence(new ASN1Type[] {}) {
                @Override protected void getValues(Object object, Object[] values) {}
            }}) {        private Object foo = new Object();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.889 -0400", hash_original_method = "FD441BE0EF348E7086E1C3476170DCA0", hash_generated_method = "2C81BE9E7EE8F622A31F2CFCBE42EEDA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object var25447B43BB64FE3D8D37002AFEABBF9F_1889346802 = (new ORAddress());
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ORAddress();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.889 -0400", hash_original_method = "1799E673C05BD9DC6FDA8F503F5A713E", hash_generated_method = "9B8C525AD887CD7707A6721A74956916")
        @DSModeled(DSC.SAFE)
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            values[0] = foo;
            // ---------- Original Method ----------
            //values[0] = foo;
        }

        
}; //Transformed anonymous class
}

