package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERUTF8String;
import java.io.IOException;

public class X509DefaultEntryConverter extends X509NameEntryConverter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.156 -0400", hash_original_method = "685C200736A0E688088DFBD6E10169A1", hash_generated_method = "685C200736A0E688088DFBD6E10169A1")
    public X509DefaultEntryConverter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.175 -0400", hash_original_method = "E0075DF75B4E99D6DCA984CA2F76B1C5", hash_generated_method = "83C690C39CC17B37A9520E7A12E345BE")
    public DERObject getConvertedValue(
        DERObjectIdentifier  oid,
        String               value) {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_923035481 = null; //Variable for return #1
        DERObject varB4EAC82CA7396A68D541C85D26508E83_952499186 = null; //Variable for return #2
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1947435300 = null; //Variable for return #3
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2109297311 = null; //Variable for return #4
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1485333822 = null; //Variable for return #5
        {
            boolean var6AB4A1536900027F51CF72957960A845_1271394046 = (value.length() != 0 && value.charAt(0) == '#');
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_923035481 = convertHexEncoded(value, 1);
                } //End block
                catch (IOException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("can't recode value for oid " + oid.getId());
                } //End block
            } //End block
            {
                {
                    boolean var2F99FAD1BF6C9CE40AAB172EEF759C4E_1062024158 = (value.length() != 0 && value.charAt(0) == '\\');
                    {
                        value = value.substring(1);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var6E581A8D3543172B5D76DEAB4500D5F8_295637424 = (oid.equals(X509Name.EmailAddress) || oid.equals(X509Name.DC));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_952499186 = new DERIA5String(value);
                    } //End block
                    {
                        boolean var1EB619398D97B189EC59A003073B396E_2035267326 = (oid.equals(X509Name.DATE_OF_BIRTH));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1947435300 = new DERGeneralizedTime(value);
                        } //End block
                        {
                            boolean var61D65ED522D75F26E9F92081DA54A86B_394842837 = (oid.equals(X509Name.C) || oid.equals(X509Name.SN) || oid.equals(X509Name.DN_QUALIFIER)
                || oid.equals(X509Name.TELEPHONE_NUMBER));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_2109297311 = new DERPrintableString(value);
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1485333822 = new DERUTF8String(value);
        addTaint(oid.getTaint());
        addTaint(value.getTaint());
        DERObject varA7E53CE21691AB073D9660D615818899_1965472679; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1965472679 = varB4EAC82CA7396A68D541C85D26508E83_923035481;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1965472679 = varB4EAC82CA7396A68D541C85D26508E83_952499186;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1965472679 = varB4EAC82CA7396A68D541C85D26508E83_1947435300;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1965472679 = varB4EAC82CA7396A68D541C85D26508E83_2109297311;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1965472679 = varB4EAC82CA7396A68D541C85D26508E83_1485333822;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1965472679.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1965472679;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

