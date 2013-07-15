package org.bouncycastle.asn1.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class IssuerSerial extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.867 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "FBA189AA1CCDF885E2BAFE3258EFE992")

    GeneralNames issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.867 -0400", hash_original_field = "74136B24217CB75599440E6E1D807CF7", hash_generated_field = "B567171129E718B07996A791966D9A47")

    DERInteger serial;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.867 -0400", hash_original_field = "CE6DDC63C62D781984F661A1BC02AA1B", hash_generated_field = "3D9E898FBB0D3A6964BB9F619F1BE32F")

    DERBitString issuerUID;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.868 -0400", hash_original_method = "6A7E42DF8EF9B09B844C872DFCA023C7", hash_generated_method = "904FC2CA058AF3C6EA9ABFAB6A18B198")
    public  IssuerSerial(
        ASN1Sequence    seq) {
        {
            boolean varE66FC7BCB62D6129C3B052068045942B_2042088738 = (seq.size() != 2 && seq.size() != 3);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: " + seq.size());
            } 
        } 
        issuer = GeneralNames.getInstance(seq.getObjectAt(0));
        serial = DERInteger.getInstance(seq.getObjectAt(1));
        {
            boolean varB84C8522B025613859E5A51D2B72F1B8_1363474941 = (seq.size() == 3);
            {
                issuerUID = DERBitString.getInstance(seq.getObjectAt(2));
            } 
        } 
        
        
        
            
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.869 -0400", hash_original_method = "B838D7E53D177DFF65C1A291EEAEEEE1", hash_generated_method = "D4EC88DF2D8A028D56F6AF5E2A27DDE6")
    public  IssuerSerial(
        GeneralNames    issuer,
        DERInteger      serial) {
        this.issuer = issuer;
        this.serial = serial;
        
        
        
    }

    
    public static IssuerSerial getInstance(
            Object  obj) {
        if (obj == null || obj instanceof IssuerSerial)
        {
            return (IssuerSerial)obj;
        }
        if (obj instanceof ASN1Sequence)
        {
            return new IssuerSerial((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    public static IssuerSerial getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.870 -0400", hash_original_method = "C6A01CC056B505ECB1961F3D46D5E125", hash_generated_method = "843117B9D90A3F8B4944F4ECDFC45C50")
    public GeneralNames getIssuer() {
        GeneralNames varB4EAC82CA7396A68D541C85D26508E83_1157029777 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1157029777 = issuer;
        varB4EAC82CA7396A68D541C85D26508E83_1157029777.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1157029777;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.870 -0400", hash_original_method = "4A26172B3E4E9D1CBD95C0010541030C", hash_generated_method = "27C3E8BE3FF8795E31C2B79B144F4E16")
    public DERInteger getSerial() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_1509612519 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1509612519 = serial;
        varB4EAC82CA7396A68D541C85D26508E83_1509612519.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1509612519;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.871 -0400", hash_original_method = "6FC86B4935E8EDEA9326972109BFF43A", hash_generated_method = "F423B0B0034560C73EF76058E6C6F4E5")
    public DERBitString getIssuerUID() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_1793235621 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1793235621 = issuerUID;
        varB4EAC82CA7396A68D541C85D26508E83_1793235621.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1793235621;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.871 -0400", hash_original_method = "91432FD7FC59DB0CA5EF9903A7843F73", hash_generated_method = "0FEB7DBB242110CEB4F15123E89BE97D")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_70449689 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(issuer);
        v.add(serial);
        {
            v.add(issuerUID);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_70449689 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_70449689.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_70449689;
        
        
        
        
        
        
            
        
        
    }

    
}

