package org.apache.harmony.security.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Date;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class Validity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.576 -0400", hash_original_field = "CF2C84750B842AAA309ECBA4D79FF935", hash_generated_field = "E3E827D7CD2761B5AB55619FED686D61")

    private Date notBefore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.577 -0400", hash_original_field = "21F1BA3A4A4A624D712B87C23B2FD95A", hash_generated_field = "9EC5214487C0E45ED3A209D46FF5E8A8")

    private Date notAfter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.577 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.578 -0400", hash_original_method = "F8867A5D4F27966CF2038460A4C147B6", hash_generated_method = "3695B438AEFDA2C428F57F58CBFD712B")
    public  Validity(Date notBefore, Date notAfter) {
        this.notBefore = notBefore;
        this.notAfter = notAfter;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.579 -0400", hash_original_method = "CB2A2B3C356F1AD47950BB2253ACA4BD", hash_generated_method = "241FF2032FB062C4D43AF6C219A2B497")
    public Date getNotBefore() {
        Date varB4EAC82CA7396A68D541C85D26508E83_758534511 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_758534511 = notBefore;
        varB4EAC82CA7396A68D541C85D26508E83_758534511.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_758534511;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.579 -0400", hash_original_method = "9EADF7E1E76408811693CE379F621727", hash_generated_method = "C3230068B2228FF23E8695FAB4D0A1F9")
    public Date getNotAfter() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1823368989 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1823368989 = notAfter;
        varB4EAC82CA7396A68D541C85D26508E83_1823368989.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1823368989;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.580 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "14848C601F1F9806F312586A5A716C03")
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1244482004 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1244482004;
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.580 -0400", hash_original_field = "A6DF2012EFBA1C423892102016009D73", hash_generated_field = "07FA11BFB5637FC4281B8963015521E1")

    public static final ASN1Sequence ASN1
        = new ASN1Sequence(new ASN1Type[] {Time.ASN1, Time.ASN1 }) {

        @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new Validity((Date) values[0], (Date) values[1]);
        }

        @Override protected void getValues(Object object, Object[] values) {
            Validity validity = (Validity) object;
            values[0] = validity.notBefore;
            values[1] = validity.notAfter;
        }
    };
    
}

