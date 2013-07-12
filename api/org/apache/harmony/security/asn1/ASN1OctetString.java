package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Arrays;

public class ASN1OctetString extends ASN1StringType {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.632 -0400", hash_original_method = "FE8C061A61754FEAD4E80D2F91CDD232", hash_generated_method = "D6ED9BA2FC4CE32BD81039A4C8CEA95C")
    public  ASN1OctetString() {
        super(TAG_OCTETSTRING);
        
    }

    
        @DSModeled(DSC.SAFE)
    public static ASN1OctetString getInstance() {
        return ASN1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.633 -0400", hash_original_method = "28376DFC29A2213C4817BE9D28454968", hash_generated_method = "2FBDB6890430AE6F0746A808396E59F0")
    @Override
    public Object decode(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        in.readOctetString();
    if(in.isVerify)        
        {
Object var540C13E9E156B687226421B24F2DF178_915011588 =             null;
            var540C13E9E156B687226421B24F2DF178_915011588.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_915011588;
        } 
Object var6AD043AF0280111F31D0D60A6CD70863_902772814 =         getDecodedObject(in);
        var6AD043AF0280111F31D0D60A6CD70863_902772814.addTaint(taint);
        return var6AD043AF0280111F31D0D60A6CD70863_902772814;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.633 -0400", hash_original_method = "82D4C6A7EA2B5E6BF0228FD44BF29A31", hash_generated_method = "D13747C226ED4ADDC9501D526C4C6C62")
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
Object var799D9F18AD20BC40A384FA5E7CC005DE_413523197 =         Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length);
        var799D9F18AD20BC40A384FA5E7CC005DE_413523197.addTaint(taint);
        return var799D9F18AD20BC40A384FA5E7CC005DE_413523197;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.634 -0400", hash_original_method = "612A16573B17613AF81AE7469C8D7FB4", hash_generated_method = "57AE45A90B6F1E47245A3636A7F0AFDB")
    @Override
    public void encodeContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeOctetString();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.634 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "0A6C24B266608A499D36BD79B2B42EB8")
    @Override
    public void setEncodingContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.length = ((byte[]) out.content).length;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.634 -0400", hash_original_field = "25107E945D1756F345B685F812B017DB", hash_generated_field = "BBC2F7EF6217ADF6A8ED0EF7FBD1ADB4")

    private static final ASN1OctetString ASN1 = new ASN1OctetString();
}

