package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;

public class BERTaggedObjectParser implements ASN1TaggedObjectParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.206 -0400", hash_original_field = "B52D9E9D9646E0353AB30807D53B3F06", hash_generated_field = "FF4CF5F81862B8524694C4DB9DDE635D")

    private boolean _constructed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.206 -0400", hash_original_field = "EAE2E4D0FF1C370A789CC8A0673A645C", hash_generated_field = "62F1DF151C857CACD0771E182D275DC9")

    private int _tagNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.206 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.207 -0400", hash_original_method = "CEDFC0E6C0BD9B3FF1D771A70B508D94", hash_generated_method = "B7692F4602B2684854AF66EFA322266A")
    protected  BERTaggedObjectParser(
        int         baseTag,
        int         tagNumber,
        InputStream contentStream) {
        this((baseTag & DERTags.CONSTRUCTED) != 0, tagNumber, new ASN1StreamParser(contentStream));
        addTaint(baseTag);
        addTaint(tagNumber);
        addTaint(contentStream.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.208 -0400", hash_original_method = "641FC71F34D5E5D1E36A069067B2FFCA", hash_generated_method = "4224D6E59DB0E81A205C5A86FC970910")
      BERTaggedObjectParser(
        boolean             constructed,
        int                 tagNumber,
        ASN1StreamParser    parser) {
        _constructed = constructed;
        _tagNumber = tagNumber;
        _parser = parser;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.209 -0400", hash_original_method = "E640F7F01BC858A63ED48B7251E0457D", hash_generated_method = "4E6603367CC3D5D905A01A9BDF5127DD")
    public boolean isConstructed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_333552959 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_333552959;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.209 -0400", hash_original_method = "B35ABF3B77036668E0072FBBE52EC3E8", hash_generated_method = "A120B7B0D3B5AB37F11F2AE70C68FA53")
    public int getTagNo() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_305198053 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_305198053;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.210 -0400", hash_original_method = "4AD739EA93AB775B40026E215844A8E7", hash_generated_method = "853AD4EEFDAF570647CFEF04CB3B473F")
    public DEREncodable getObjectParser(
        int     tag,
        boolean isExplicit) throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_207427295 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_530458261 = null; 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
            } 
            varB4EAC82CA7396A68D541C85D26508E83_207427295 = _parser.readObject();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_530458261 = _parser.readImplicit(_constructed, tag);
        addTaint(tag);
        addTaint(isExplicit);
        DEREncodable varA7E53CE21691AB073D9660D615818899_69750012; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_69750012 = varB4EAC82CA7396A68D541C85D26508E83_207427295;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_69750012 = varB4EAC82CA7396A68D541C85D26508E83_530458261;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_69750012.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_69750012;
        
        
        
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.211 -0400", hash_original_method = "966C66B264046D402E2F3ED8541B4BF3", hash_generated_method = "C51FF9D48F8ED6E8CCC565FC073EEC7A")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1989366049 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1989366049 = _parser.readTaggedObject(_constructed, _tagNumber);
        varB4EAC82CA7396A68D541C85D26508E83_1989366049.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1989366049;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.212 -0400", hash_original_method = "8993E91076953DCCDD0896DB0B3E91BE", hash_generated_method = "981DB2D5D88B5B312310FA2B24121A3A")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_953209599 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_953209599 = this.getLoadedObject();
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException(e.getMessage());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_953209599.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_953209599;
        
        
        
            
        
        
        
            
        
    }

    
}

