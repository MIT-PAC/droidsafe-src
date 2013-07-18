package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.IOException;
import java.io.InputStream;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DEROctetStringParser implements ASN1OctetStringParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.459 -0400", hash_original_field = "F7B44CFAFD5C52223D5498196C8A2E7B", hash_generated_field = "B52609448A7FFECE6579BC5E2EF825EF")

    private DefiniteLengthInputStream stream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.460 -0400", hash_original_method = "18F90E7C8910F20983A0E830634FAC28", hash_generated_method = "9D5CE2CB595BD9C55B8D972104EAB19F")
      DEROctetStringParser(
        DefiniteLengthInputStream stream) {
        this.stream = stream;
        // ---------- Original Method ----------
        //this.stream = stream;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.460 -0400", hash_original_method = "18DABC7937263BD98D8856E466803052", hash_generated_method = "CDBC81BF3C01E6E55C573C9C969C0115")
    public InputStream getOctetStream() {
InputStream varA87CF74140B150613F4203E71875F9A7_453850622 =         stream;
        varA87CF74140B150613F4203E71875F9A7_453850622.addTaint(taint);
        return varA87CF74140B150613F4203E71875F9A7_453850622;
        // ---------- Original Method ----------
        //return stream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.460 -0400", hash_original_method = "61774CD0E60B254BC7D8FDAA497BBCE4", hash_generated_method = "FA62F6F0EB2512EE23C1694C2EDC2E4C")
    public DERObject getLoadedObject() throws IOException {
DERObject varBA3D40898413DBB6104C2FA267A66322_1090143427 =         new DEROctetString(stream.toByteArray());
        varBA3D40898413DBB6104C2FA267A66322_1090143427.addTaint(taint);
        return varBA3D40898413DBB6104C2FA267A66322_1090143427;
        // ---------- Original Method ----------
        //return new DEROctetString(stream.toByteArray());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.461 -0400", hash_original_method = "9966B03EEC95948C208DE961DDFE6334", hash_generated_method = "0B0BD396341F33ED3DD6DC1A2FDA718D")
    public DERObject getDERObject() {
        try 
        {
DERObject var7CA8C38BF885E63AD9395CA9CA98D912_1621701012 =             getLoadedObject();
            var7CA8C38BF885E63AD9395CA9CA98D912_1621701012.addTaint(taint);
            return var7CA8C38BF885E63AD9395CA9CA98D912_1621701012;
        } //End block
        catch (IOException e)
        {
            ASN1ParsingException varD0CC19A43964E4E112C5E76CFAB8A437_1465267506 = new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
            varD0CC19A43964E4E112C5E76CFAB8A437_1465267506.addTaint(taint);
            throw varD0CC19A43964E4E112C5E76CFAB8A437_1465267506;
        } //End block
        // ---------- Original Method ----------
        //try
        //{
            //return getLoadedObject();
        //}
        //catch (IOException e)
        //{
            //throw new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
        //}
    }

    
}

