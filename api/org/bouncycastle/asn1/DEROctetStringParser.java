package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;

public class DEROctetStringParser implements ASN1OctetStringParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.142 -0400", hash_original_field = "F7B44CFAFD5C52223D5498196C8A2E7B", hash_generated_field = "B52609448A7FFECE6579BC5E2EF825EF")

    private DefiniteLengthInputStream stream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.142 -0400", hash_original_method = "18F90E7C8910F20983A0E830634FAC28", hash_generated_method = "9D5CE2CB595BD9C55B8D972104EAB19F")
      DEROctetStringParser(
        DefiniteLengthInputStream stream) {
        this.stream = stream;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.143 -0400", hash_original_method = "18DABC7937263BD98D8856E466803052", hash_generated_method = "F9ABE140CB2FA6D2E049571179AE840A")
    public InputStream getOctetStream() {
InputStream varA87CF74140B150613F4203E71875F9A7_1854216313 =         stream;
        varA87CF74140B150613F4203E71875F9A7_1854216313.addTaint(taint);
        return varA87CF74140B150613F4203E71875F9A7_1854216313;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.143 -0400", hash_original_method = "61774CD0E60B254BC7D8FDAA497BBCE4", hash_generated_method = "6155EC2EDDEEE3577050F5F4CF7B6D29")
    public DERObject getLoadedObject() throws IOException {
DERObject varBA3D40898413DBB6104C2FA267A66322_1063607166 =         new DEROctetString(stream.toByteArray());
        varBA3D40898413DBB6104C2FA267A66322_1063607166.addTaint(taint);
        return varBA3D40898413DBB6104C2FA267A66322_1063607166;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.143 -0400", hash_original_method = "9966B03EEC95948C208DE961DDFE6334", hash_generated_method = "E6FDA97CF118C91E4D1478418781B712")
    public DERObject getDERObject() {
        try 
        {
DERObject var7CA8C38BF885E63AD9395CA9CA98D912_1174139373 =             getLoadedObject();
            var7CA8C38BF885E63AD9395CA9CA98D912_1174139373.addTaint(taint);
            return var7CA8C38BF885E63AD9395CA9CA98D912_1174139373;
        } 
        catch (IOException e)
        {
            ASN1ParsingException varD0CC19A43964E4E112C5E76CFAB8A437_879219766 = new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
            varD0CC19A43964E4E112C5E76CFAB8A437_879219766.addTaint(taint);
            throw varD0CC19A43964E4E112C5E76CFAB8A437_879219766;
        } 
        
        
        
            
        
        
        
            
        
    }

    
}

