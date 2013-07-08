package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public final class ASN1Any extends ASN1Type {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.377 -0400", hash_original_method = "DC9940F4B091FD322F1F3A80DE5DA9F7", hash_generated_method = "4BC9F36E0DA8D5C47FBAC49DEA0BD42A")
    public  ASN1Any() {
        super(TAG_ANY);
        
    }

    
    @DSModeled(DSC.SAFE)
    public static ASN1Any getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.378 -0400", hash_original_method = "0A9787140DA63C802B73071FD0FF80EC", hash_generated_method = "25F9D238EA2B6DA13E539E614304B2D7")
    public final boolean checkTag(int identifier) {
        addTaint(identifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_173985004 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_173985004;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.378 -0400", hash_original_method = "F8B6556748DA568C4BCDCD3BC4853721", hash_generated_method = "0233C589B1059572B33503E8880F7EDB")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1514046157 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1363579250 = null; 
        in.readContent();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1514046157 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1363579250 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_356196857; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_356196857 = varB4EAC82CA7396A68D541C85D26508E83_1514046157;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_356196857 = varB4EAC82CA7396A68D541C85D26508E83_1363579250;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_356196857.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_356196857;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.380 -0400", hash_original_method = "7A8EAE0B0D15C25D8FE798817C72F0C1", hash_generated_method = "2E267190F44325AFE83D8A149317FE39")
    public Object getDecodedObject(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1086947433 = null; 
        byte[] bytesEncoded = new byte[in.offset - in.tagOffset];
        System.arraycopy(in.buffer, in.tagOffset, bytesEncoded, 0,
                bytesEncoded.length);
        varB4EAC82CA7396A68D541C85D26508E83_1086947433 = bytesEncoded;
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1086947433.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1086947433;
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.380 -0400", hash_original_method = "7511C9B0E36E939B1775FC9EA0F02F20", hash_generated_method = "A8E9C457ADBC773C8E6B07ACE83BB161")
    public void encodeASN(BerOutputStream out) {
        out.encodeANY();
        addTaint(out.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.381 -0400", hash_original_method = "E4481BCA62553D7934DD52F370937ED4", hash_generated_method = "0E2C909D3F4634D5C1DDBFD77A5BB9EC")
    public void encodeContent(BerOutputStream out) {
        out.encodeANY();
        addTaint(out.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.381 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "28412896F17AF4B874C6F607DA4D2993")
    public void setEncodingContent(BerOutputStream out) {
        out.length = ((byte[]) out.content).length;
        addTaint(out.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.381 -0400", hash_original_method = "4E35D9A00930BDC0DD7D3944E7329986", hash_generated_method = "BD4876C207AFE2BFF898D9221D887ABE")
    public int getEncodedLength(BerOutputStream out) {
        addTaint(out.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_310886213 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_310886213;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.381 -0400", hash_original_field = "0236CB100B50FFA118DD93153CCD6AB1", hash_generated_field = "C58706DC2D33CE9466BC907D05FF43CF")

    private static final ASN1Any ASN1 = new ASN1Any();
}

