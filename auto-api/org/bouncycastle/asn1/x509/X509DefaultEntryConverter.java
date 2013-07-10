package org.bouncycastle.asn1.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERUTF8String;
import java.io.IOException;

public class X509DefaultEntryConverter extends X509NameEntryConverter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.088 -0400", hash_original_method = "685C200736A0E688088DFBD6E10169A1", hash_generated_method = "685C200736A0E688088DFBD6E10169A1")
    public X509DefaultEntryConverter ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.090 -0400", hash_original_method = "E0075DF75B4E99D6DCA984CA2F76B1C5", hash_generated_method = "C5B02BE2F8CF5BCC89C9C83D4D88976B")
    public DERObject getConvertedValue(
        DERObjectIdentifier  oid,
        String               value) {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_48074849 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_424181328 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1803856199 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1797697889 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1170471120 = null; 
        {
            boolean var6AB4A1536900027F51CF72957960A845_844285671 = (value.length() != 0 && value.charAt(0) == '#');
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_48074849 = convertHexEncoded(value, 1);
                } 
                catch (IOException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("can't recode value for oid " + oid.getId());
                } 
            } 
            {
                {
                    boolean var2F99FAD1BF6C9CE40AAB172EEF759C4E_2102320720 = (value.length() != 0 && value.charAt(0) == '\\');
                    {
                        value = value.substring(1);
                    } 
                } 
                {
                    boolean var6E581A8D3543172B5D76DEAB4500D5F8_1636267512 = (oid.equals(X509Name.EmailAddress) || oid.equals(X509Name.DC));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_424181328 = new DERIA5String(value);
                    } 
                    {
                        boolean var1EB619398D97B189EC59A003073B396E_1954465092 = (oid.equals(X509Name.DATE_OF_BIRTH));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1803856199 = new DERGeneralizedTime(value);
                        } 
                        {
                            boolean var61D65ED522D75F26E9F92081DA54A86B_1440855093 = (oid.equals(X509Name.C) || oid.equals(X509Name.SN) || oid.equals(X509Name.DN_QUALIFIER)
                || oid.equals(X509Name.TELEPHONE_NUMBER));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1797697889 = new DERPrintableString(value);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1170471120 = new DERUTF8String(value);
        addTaint(oid.getTaint());
        addTaint(value.getTaint());
        DERObject varA7E53CE21691AB073D9660D615818899_1034931187; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1034931187 = varB4EAC82CA7396A68D541C85D26508E83_48074849;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1034931187 = varB4EAC82CA7396A68D541C85D26508E83_424181328;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1034931187 = varB4EAC82CA7396A68D541C85D26508E83_1803856199;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1034931187 = varB4EAC82CA7396A68D541C85D26508E83_1797697889;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1034931187 = varB4EAC82CA7396A68D541C85D26508E83_1170471120;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1034931187.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1034931187;
        
        
    }

    
}

