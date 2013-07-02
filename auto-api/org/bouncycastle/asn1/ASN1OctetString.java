package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

public abstract class ASN1OctetString extends ASN1Object implements ASN1OctetStringParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.925 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "4DFAD1EC9079C516825D3C67F76850BC")

    byte[] string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.925 -0400", hash_original_method = "210B116B260CE188F6D07BB4AB757CE1", hash_generated_method = "78C1B0AAF84BD1CAEDF7F28C981E84AD")
    public  ASN1OctetString(
        byte[]  string) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("string cannot be null");
        } 
        this.string = string;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.926 -0400", hash_original_method = "654F394A2F1F18AA4253E49ED9387EFC", hash_generated_method = "D054636742C275320E7ABB3D88479A8B")
    public  ASN1OctetString(
        DEREncodable obj) {
        try 
        {
            this.string = obj.getDERObject().getEncoded(ASN1Encodable.DER);
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Error processing object : " + e.toString());
        } 
        
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    public static ASN1OctetString getInstance(
        ASN1TaggedObject    obj,
        boolean             explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof ASN1OctetString)
        {
            return getInstance(o);
        }
        else
        {
            return BERConstructedOctetString.fromSequence(ASN1Sequence.getInstance(o)); 
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static ASN1OctetString getInstance(
        Object  obj) {
        if (obj == null || obj instanceof ASN1OctetString)
        {
            return (ASN1OctetString)obj;
        }
        if (obj instanceof ASN1TaggedObject)
        {
            return getInstance(((ASN1TaggedObject)obj).getObject());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.927 -0400", hash_original_method = "34640A97A031BA78080CEBB6F9EA17E5", hash_generated_method = "16B1E992E6C15592BCDDE2DAF50564C2")
    public InputStream getOctetStream() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1991390541 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1991390541 = new ByteArrayInputStream(string);
        varB4EAC82CA7396A68D541C85D26508E83_1991390541.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1991390541;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.927 -0400", hash_original_method = "9D3ECD11646B7B9703C16B797DA8DA2E", hash_generated_method = "03CD060905CFA554824909EADE7D7F8C")
    public ASN1OctetStringParser parser() {
        ASN1OctetStringParser varB4EAC82CA7396A68D541C85D26508E83_315310235 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_315310235 = this;
        varB4EAC82CA7396A68D541C85D26508E83_315310235.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_315310235;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.928 -0400", hash_original_method = "C5326C1D0359BDCEF8241B3A70DD591D", hash_generated_method = "E34EC1948B248599FCB482DE4DAED154")
    public byte[] getOctets() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_288522910 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_288522910;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.928 -0400", hash_original_method = "306C0053EB93BF3AE4D12BCDAA093AD0", hash_generated_method = "EE71CB960924541963D49300F75E324D")
    public int hashCode() {
        int var41933DA9B61B1D0D596F60166BA264CB_966180258 = (Arrays.hashCode(this.getOctets()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1779114908 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1779114908;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.929 -0400", hash_original_method = "5FE20DA2EBC8E33EF5740C0666CFE34F", hash_generated_method = "C0AB40BBD154433AD746B5E67ACB6E2B")
     boolean asn1Equals(
        DERObject  o) {
        ASN1OctetString other = (ASN1OctetString)o;
        boolean var46918AEC61FFB3A9DECC5C637B9D6AC0_2066438908 = (Arrays.areEqual(string, other.string));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1226401429 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1226401429;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.929 -0400", hash_original_method = "D3363286272FDA8D05900543905FFBE8", hash_generated_method = "814B2171E11D5FAFC00A83F74AD83E8C")
    public DERObject getLoadedObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_175807687 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_175807687 = this.getDERObject();
        varB4EAC82CA7396A68D541C85D26508E83_175807687.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_175807687;
        
        
    }

    
    abstract void encode(DEROutputStream out)
        throws IOException;

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.930 -0400", hash_original_method = "A6F4AE428E861451DA18F2BDC0B16A3E", hash_generated_method = "37B5A9430E6DA3E6BE348738DD122E58")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1737126082 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1737126082 = "#"+new String(Hex.encode(string));
        varB4EAC82CA7396A68D541C85D26508E83_1737126082.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1737126082;
        
        
    }

    
}

