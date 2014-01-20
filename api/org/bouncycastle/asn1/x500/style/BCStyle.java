package org.bouncycastle.asn1.x500.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Hashtable;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;

public class BCStyle implements X500NameStyle {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.198 -0500", hash_original_field = "14EECF58FF12DE9D1A9B3EDCC3D81AEE", hash_generated_field = "C060850A5B8A43A9641AC7C3AC19DAD7")

    public static final X500NameStyle INSTANCE = new BCStyle();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.201 -0500", hash_original_field = "73D81AB761AD0DD1368B09CDD84C52B9", hash_generated_field = "6B28731F0BA377BA3BC00D3B29680EC1")

    public static final ASN1ObjectIdentifier C = new ASN1ObjectIdentifier("2.5.4.6");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.204 -0500", hash_original_field = "7C20096B8D92FB48F8968BBA708DC654", hash_generated_field = "DCD93051F670D07A94A163A4BE5E36EF")

    public static final ASN1ObjectIdentifier O = new ASN1ObjectIdentifier("2.5.4.10");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.207 -0500", hash_original_field = "261320B7D7A937905795F882118E4E09", hash_generated_field = "9AB62218CD4C726913D30E0BBEBC7C7C")

    public static final ASN1ObjectIdentifier OU = new ASN1ObjectIdentifier("2.5.4.11");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.210 -0500", hash_original_field = "434F07241DCA4ABB45B208E5A1CC0F9E", hash_generated_field = "0EDFBC5765D192124E2D2BB3B3E17741")

    public static final ASN1ObjectIdentifier T = new ASN1ObjectIdentifier("2.5.4.12");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.212 -0500", hash_original_field = "64F2A24255D0083FA41103C3E04946C0", hash_generated_field = "E4A6683D7D329DBD320CF3D2B2EA169C")

    public static final ASN1ObjectIdentifier CN = new ASN1ObjectIdentifier("2.5.4.3");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.215 -0500", hash_original_field = "2A334247662CB3AC10543E7C6E1F2E7F", hash_generated_field = "DD2BAC4A277DDB3FD10FF9B797FE9F9F")

    public static final ASN1ObjectIdentifier SN = new ASN1ObjectIdentifier("2.5.4.5");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.218 -0500", hash_original_field = "205E4CE2323A7484E18CE86BF536E799", hash_generated_field = "DCCEE879790C242119D271A476CBFC2A")

    public static final ASN1ObjectIdentifier STREET = new ASN1ObjectIdentifier("2.5.4.9");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.221 -0500", hash_original_field = "DB080139CF0F8DC50CBD6D225A67326B", hash_generated_field = "8799CCA7411F87A17F66029334CEB2B0")

    public static final ASN1ObjectIdentifier SERIALNUMBER = SN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.223 -0500", hash_original_field = "FB4B2E953DCECD07D4AA41EB6D4BA3BD", hash_generated_field = "DB4DE5AFB6B9EB71ACB9A4701CAFDAAB")

    public static final ASN1ObjectIdentifier L = new ASN1ObjectIdentifier("2.5.4.7");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.226 -0500", hash_original_field = "5DD4F56E6CE6122F4C8862FABCDD72A7", hash_generated_field = "251E35276C1DCFF2938FEEBD4AD8B644")

    public static final ASN1ObjectIdentifier ST = new ASN1ObjectIdentifier("2.5.4.8");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.228 -0500", hash_original_field = "E11A0F31B5D8CF61D084F672D212F134", hash_generated_field = "3695E4F72DE11638D74469831AF5929C")

    public static final ASN1ObjectIdentifier SURNAME = new ASN1ObjectIdentifier("2.5.4.4");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.231 -0500", hash_original_field = "A85ABDC95C916371CF20280195D5D73B", hash_generated_field = "77FD96683E323E771BCC50C906DF9C79")

    public static final ASN1ObjectIdentifier GIVENNAME = new ASN1ObjectIdentifier("2.5.4.42");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.233 -0500", hash_original_field = "8FCAC6F24F2503411149DB897132006B", hash_generated_field = "DA98051E334D0DD7CDFE685451ADD496")

    public static final ASN1ObjectIdentifier INITIALS = new ASN1ObjectIdentifier("2.5.4.43");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.236 -0500", hash_original_field = "38FDCDF4071D394CB102AA2560DC8C15", hash_generated_field = "5737E3ABFD2D4040805F7878259AF508")

    public static final ASN1ObjectIdentifier GENERATION = new ASN1ObjectIdentifier("2.5.4.44");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.239 -0500", hash_original_field = "5D5AC0609CBA20300CDF8CFD04C66C92", hash_generated_field = "893B9D2C6C1C3B3A18AF963C8C678081")

    public static final ASN1ObjectIdentifier UNIQUE_IDENTIFIER = new ASN1ObjectIdentifier("2.5.4.45");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.242 -0500", hash_original_field = "FDBD2A9EC71D562DCEC1DD2A76ABDD6C", hash_generated_field = "F3121166E0BE18E9CA551FF6E105E14F")

    public static final ASN1ObjectIdentifier BUSINESS_CATEGORY = new ASN1ObjectIdentifier(
        "2.5.4.15");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.244 -0500", hash_original_field = "4EA924988DB48327C9B95E32B385691E", hash_generated_field = "D0103C15BA15D290911D36A6E8B05BEF")

    public static final ASN1ObjectIdentifier POSTAL_CODE = new ASN1ObjectIdentifier(
        "2.5.4.17");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.248 -0500", hash_original_field = "65209EB0BB05C67D7921B307FAF7232E", hash_generated_field = "A6604F09378F02C3F9F7E14C925545A4")

    public static final ASN1ObjectIdentifier DN_QUALIFIER = new ASN1ObjectIdentifier(
        "2.5.4.46");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.250 -0500", hash_original_field = "193D5D621785CBFE77DE0CA4950443B2", hash_generated_field = "BBE741739A39F87431005A9211781950")

    public static final ASN1ObjectIdentifier PSEUDONYM = new ASN1ObjectIdentifier(
        "2.5.4.65");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.253 -0500", hash_original_field = "F2578A8A11B411E8FD640934A5147D98", hash_generated_field = "3919D8BC4E0752B5A5D4B9A2777A6C49")

    public static final ASN1ObjectIdentifier DATE_OF_BIRTH = new ASN1ObjectIdentifier(
        "1.3.6.1.5.5.7.9.1");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.255 -0500", hash_original_field = "39A6954C77102FD829C8F40785626AFB", hash_generated_field = "FC9C0DA941FD49257DA639F087D05445")

    public static final ASN1ObjectIdentifier PLACE_OF_BIRTH = new ASN1ObjectIdentifier(
        "1.3.6.1.5.5.7.9.2");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.258 -0500", hash_original_field = "4BCB68EBA1BE1674464543F0C99E18DD", hash_generated_field = "930968633593A298F6B31E8852A0BE7E")

    public static final ASN1ObjectIdentifier GENDER = new ASN1ObjectIdentifier(
        "1.3.6.1.5.5.7.9.3");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.261 -0500", hash_original_field = "2978189DA05811E2AB6589CD1BE44DB0", hash_generated_field = "3B8A2BCCC5E177AFADF12BDA6D520BB3")

    public static final ASN1ObjectIdentifier COUNTRY_OF_CITIZENSHIP = new ASN1ObjectIdentifier(
        "1.3.6.1.5.5.7.9.4");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.263 -0500", hash_original_field = "6962A78EB10F329700077EF326DDC6C0", hash_generated_field = "2B0839E58743B99E48859FB6D192EFAE")

    public static final ASN1ObjectIdentifier COUNTRY_OF_RESIDENCE = new ASN1ObjectIdentifier(
        "1.3.6.1.5.5.7.9.5");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.266 -0500", hash_original_field = "CAA4A191805D1CF84D7A9265DACCE4C0", hash_generated_field = "7AE5C39091A4CDDC2D9AF0B1D718DB07")

    public static final ASN1ObjectIdentifier NAME_AT_BIRTH = new ASN1ObjectIdentifier("1.3.36.8.3.14");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.269 -0500", hash_original_field = "45A588F362EF8945A8C0B39993A25F3A", hash_generated_field = "D1C997078495D2FD99EEF9EA6A41DD23")

    public static final ASN1ObjectIdentifier POSTAL_ADDRESS = new ASN1ObjectIdentifier("2.5.4.16");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.271 -0500", hash_original_field = "33C40600055CEC4F16EFCEA20083D269", hash_generated_field = "A260837E3A196A3A66F3FD05B823BE27")

    public static final ASN1ObjectIdentifier DMD_NAME = new ASN1ObjectIdentifier("2.5.4.54");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.273 -0500", hash_original_field = "D503D3FE6FF9D6AEFD0E3605CEB3BA2E", hash_generated_field = "6D0BA46185F6A42217195304B2C48E58")

    public static final ASN1ObjectIdentifier TELEPHONE_NUMBER = X509ObjectIdentifiers.id_at_telephoneNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.276 -0500", hash_original_field = "E9EDC0CECF09B0459B017C7E7A8C49A0", hash_generated_field = "78046C0D514B11059FCF6140B23BD69F")

    public static final ASN1ObjectIdentifier NAME = X509ObjectIdentifiers.id_at_name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.278 -0500", hash_original_field = "5542DA1DD2158A38E4D228E6F3785B2D", hash_generated_field = "94768FD0A0AB3FD788AA8DF7729248B3")

    public static final ASN1ObjectIdentifier EmailAddress = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.282 -0500", hash_original_field = "5D83861705C711D925B1BE338C9807FB", hash_generated_field = "4D93C13CEDC0C534265A556FB79EF3F2")

    public static final ASN1ObjectIdentifier UnstructuredName = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.284 -0500", hash_original_field = "236E995CAA2A8E5A98D9C69C1AEE2905", hash_generated_field = "63E5E1B58595E52C940179E3469A4EDB")

    public static final ASN1ObjectIdentifier UnstructuredAddress = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.287 -0500", hash_original_field = "4E5FEA981BDD2164BCE47F293EBB1D01", hash_generated_field = "86CB254127BC8C87A86C3CFB8F5D1BA7")

    public static final ASN1ObjectIdentifier E = EmailAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.289 -0500", hash_original_field = "F3A59E520E18B2E0EC587EFA3EDFA71D", hash_generated_field = "62065CBD2CB2E1E03C54078E6D100D7F")

    public static final ASN1ObjectIdentifier DC = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.292 -0500", hash_original_field = "1CA13852AA2F5D130D5A5D87E7D6E64F", hash_generated_field = "6696F260EEF01FB0CFC05225B4A9E9B4")

    public static final ASN1ObjectIdentifier UID = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.295 -0500", hash_original_field = "BB36420B0085FE57C4931038638024E1", hash_generated_field = "DA9A8DC7E5E394013019E7145DE74EC2")

    private static final Hashtable DefaultSymbols = new Hashtable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.298 -0500", hash_original_field = "6A9B8BA2687E2B038C6E773AEF73F5D5", hash_generated_field = "CFA0F3F94E79998418B90A094C11CB18")

    private static final Hashtable DefaultLookUp = new Hashtable();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.301 -0500", hash_original_method = "0ABD618DA1E5963140699C4BF03983EF", hash_generated_method = "61B48DA66F30B4E5130E97C77C601644")
    
protected BCStyle()
    {

    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.304 -0500", hash_original_method = "BD2E63080765E1C5F0301383BAEA0055", hash_generated_method = "B6E79ACF4EC8A4C418592D7E89927AC7")
    
public ASN1Encodable stringToValue(ASN1ObjectIdentifier oid, String value)
    {
        if (value.length() != 0 && value.charAt(0) == '#')
        {
            try
            {
                return IETFUtils.valueFromHexString(value, 1);
            }
            catch (IOException e)
            {
                throw new RuntimeException("can't recode value for oid " + oid.getId());
            }
        }
        else
        {
            if (value.length() != 0 && value.charAt(0) == '\\')
            {
                value = value.substring(1);
            }
            if (oid.equals(EmailAddress) || oid.equals(DC))
            {
                return new DERIA5String(value);
            }
            else if (oid.equals(DATE_OF_BIRTH))  // accept time string as well as # (for compatibility)
            {
                return new DERGeneralizedTime(value);
            }
            else if (oid.equals(C) || oid.equals(SN) || oid.equals(DN_QUALIFIER)
                || oid.equals(TELEPHONE_NUMBER))
            {
                return new DERPrintableString(value);
            }
        }

        return new DERUTF8String(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.307 -0500", hash_original_method = "9484E4F8104F6AF4F123D2A5FD97E1FE", hash_generated_method = "32461126B147CC801BF23B9115D91674")
    
public ASN1ObjectIdentifier attrNameToOID(String attrName)
    {
        return IETFUtils.decodeAttrName(attrName, DefaultLookUp);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.309 -0500", hash_original_method = "3E0470485E902738E6BF6ED5F1A7F39D", hash_generated_method = "3310208CA47A026AB10903BAAB3EC31C")
    
public boolean areEqual(X500Name name1, X500Name name2)
    {
        RDN[] rdns1 = name1.getRDNs();
        RDN[] rdns2 = name2.getRDNs();

        if (rdns1.length != rdns2.length)
        {
            return false;
        }

        boolean reverse = false;

        if (rdns1[0].getFirst() != null && rdns2[0].getFirst() != null)
        {
            reverse = !rdns1[0].getFirst().getType().equals(rdns2[0].getFirst().getType());  // guess forward
        }

        for (int i = 0; i != rdns1.length; i++)
        {
            if (!foundMatch(reverse, rdns1[i], rdns2))
            {
                return false;
            }
        }

        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.312 -0500", hash_original_method = "54A0483298F3DFD022315937FBAF5933", hash_generated_method = "3E745317653D6C3DD80B0C0A65CC8360")
    
private boolean foundMatch(boolean reverse, RDN rdn, RDN[] possRDNs)
    {
        if (reverse)
        {
            for (int i = possRDNs.length - 1; i >= 0; i--)
            {
                if (possRDNs[i] != null && rdnAreEqual(rdn, possRDNs[i]))
                {
                    possRDNs[i] = null;
                    return true;
                }
            }
        }
        else
        {
            for (int i = 0; i != possRDNs.length; i++)
            {
                if (possRDNs[i] != null && rdnAreEqual(rdn, possRDNs[i]))
                {
                    possRDNs[i] = null;
                    return true;
                }
            }
        }

        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.315 -0500", hash_original_method = "D45006114E7131F95F9CCEC1C09C1466", hash_generated_method = "8A3D90C144F23291D996BE6B895644F3")
    
protected boolean rdnAreEqual(RDN rdn1, RDN rdn2)
    {
        if (rdn1.isMultiValued())
        {
            if (rdn2.isMultiValued())
            {
                AttributeTypeAndValue[] atvs1 = rdn1.getTypesAndValues();
                AttributeTypeAndValue[] atvs2 = rdn2.getTypesAndValues();

                if (atvs1.length != atvs2.length)
                {
                    return false;
                }

                for (int i = 0; i != atvs1.length; i++)
                {
                    if (!atvAreEqual(atvs1[i], atvs2[i]))
                    {
                        return false;
                    }
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            if (!rdn2.isMultiValued())
            {
                return atvAreEqual(rdn1.getFirst(), rdn2.getFirst());
            }
            else
            {
                return false;
            }
        }

        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.317 -0500", hash_original_method = "9BB2C53F6636F1E7BA3066DC2FBD5F40", hash_generated_method = "21AFE7C629E132C230961AD1A1A741F9")
    
private boolean atvAreEqual(AttributeTypeAndValue atv1, AttributeTypeAndValue atv2)
    {
        if (atv1 == atv2)
        {
            return true;
        }

        if (atv1 == null)
        {
            return false;
        }

        if (atv2 == null)
        {
            return false;
        }

        ASN1ObjectIdentifier o1 = atv1.getType();
        ASN1ObjectIdentifier o2 = atv2.getType();

        if (!o1.equals(o2))
        {
            return false;
        }

        String v1 = IETFUtils.canonicalize(IETFUtils.valueToString(atv1.getValue()));
        String v2 = IETFUtils.canonicalize(IETFUtils.valueToString(atv2.getValue()));

        if (!v1.equals(v2))
        {
            return false;
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.320 -0500", hash_original_method = "A9463F881D57C8D610E0B84E4769BF0F", hash_generated_method = "6251EC235DCDBA1B6B3598D12DD1AB30")
    
public RDN[] fromString(String dirName)
    {
        return IETFUtils.rDNsFromString(dirName, this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.322 -0500", hash_original_method = "EA77324623CE6D0B04D0F275B161435F", hash_generated_method = "B0785328296350D825FFBF13D548C98B")
    
public int calculateHashCode(X500Name name)
    {
        int hashCodeValue = 0;
        RDN[] rdns = name.getRDNs();

        // this needs to be order independent, like equals
        for (int i = 0; i != rdns.length; i++)
        {
            if (rdns[i].isMultiValued())
            {
                AttributeTypeAndValue[] atv = rdns[i].getTypesAndValues();

                for (int j = 0; j != atv.length; j++)
                {
                    hashCodeValue ^= atv[j].getType().hashCode();
                    hashCodeValue ^= calcHashCode(atv[j].getValue());
                }
            }
            else
            {
                hashCodeValue ^= rdns[i].getFirst().getType().hashCode();
                hashCodeValue ^= calcHashCode(rdns[i].getFirst().getValue());
            }
        }

        return hashCodeValue;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.326 -0500", hash_original_method = "D9D0265B1123594600F423F1ABB5E8A9", hash_generated_method = "427E59F503130DA5A5103EE91BDFAB18")
    
private int calcHashCode(ASN1Encodable enc)
    {
        String value = IETFUtils.valueToString(enc);

        value = IETFUtils.canonicalize(value);

        return value.hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.329 -0500", hash_original_method = "C53C9B056BF6D42B40010FA6E5F8B1BD", hash_generated_method = "4DBAD7455486DC987C476499ED3B1473")
    
public String toString(X500Name name)
    {
        StringBuffer buf = new StringBuffer();
        boolean first = true;

        RDN[] rdns = name.getRDNs();

        for (int i = 0; i < rdns.length; i++)
        {
            if (first)
            {
                first = false;
            }
            else
            {
                buf.append(',');
            }

            if (rdns[i].isMultiValued())
            {
                AttributeTypeAndValue[] atv = rdns[i].getTypesAndValues();
                boolean firstAtv = true;

                for (int j = 0; j != atv.length; j++)
                {
                    if (firstAtv)
                    {
                        firstAtv = false;
                    }
                    else
                    {
                        buf.append('+');
                    }
                    
                    IETFUtils.appendTypeAndValue(buf, atv[j], DefaultSymbols);
                }
            }
            else
            {
                IETFUtils.appendTypeAndValue(buf, rdns[i].getFirst(), DefaultSymbols);
            }
        }

        return buf.toString();
    }
    static {
        DefaultSymbols.put(C, "C");
        DefaultSymbols.put(O, "O");
        DefaultSymbols.put(T, "T");
        DefaultSymbols.put(OU, "OU");
        DefaultSymbols.put(CN, "CN");
        DefaultSymbols.put(L, "L");
        DefaultSymbols.put(ST, "ST");
        DefaultSymbols.put(SN, "SERIALNUMBER");
        DefaultSymbols.put(EmailAddress, "E");
        DefaultSymbols.put(DC, "DC");
        DefaultSymbols.put(UID, "UID");
        DefaultSymbols.put(STREET, "STREET");
        DefaultSymbols.put(SURNAME, "SURNAME");
        DefaultSymbols.put(GIVENNAME, "GIVENNAME");
        DefaultSymbols.put(INITIALS, "INITIALS");
        DefaultSymbols.put(GENERATION, "GENERATION");
        DefaultSymbols.put(UnstructuredAddress, "unstructuredAddress");
        DefaultSymbols.put(UnstructuredName, "unstructuredName");
        DefaultSymbols.put(UNIQUE_IDENTIFIER, "UniqueIdentifier");
        DefaultSymbols.put(DN_QUALIFIER, "DN");
        DefaultSymbols.put(PSEUDONYM, "Pseudonym");
        DefaultSymbols.put(POSTAL_ADDRESS, "PostalAddress");
        DefaultSymbols.put(NAME_AT_BIRTH, "NameAtBirth");
        DefaultSymbols.put(COUNTRY_OF_CITIZENSHIP, "CountryOfCitizenship");
        DefaultSymbols.put(COUNTRY_OF_RESIDENCE, "CountryOfResidence");
        DefaultSymbols.put(GENDER, "Gender");
        DefaultSymbols.put(PLACE_OF_BIRTH, "PlaceOfBirth");
        DefaultSymbols.put(DATE_OF_BIRTH, "DateOfBirth");
        DefaultSymbols.put(POSTAL_CODE, "PostalCode");
        DefaultSymbols.put(BUSINESS_CATEGORY, "BusinessCategory");
        DefaultSymbols.put(TELEPHONE_NUMBER, "TelephoneNumber");
        DefaultSymbols.put(NAME, "Name");
        DefaultLookUp.put("c", C);
        DefaultLookUp.put("o", O);
        DefaultLookUp.put("t", T);
        DefaultLookUp.put("ou", OU);
        DefaultLookUp.put("cn", CN);
        DefaultLookUp.put("l", L);
        DefaultLookUp.put("st", ST);
        DefaultLookUp.put("sn", SN);
        DefaultLookUp.put("serialnumber", SN);
        DefaultLookUp.put("street", STREET);
        DefaultLookUp.put("emailaddress", E);
        DefaultLookUp.put("dc", DC);
        DefaultLookUp.put("e", E);
        DefaultLookUp.put("uid", UID);
        DefaultLookUp.put("surname", SURNAME);
        DefaultLookUp.put("givenname", GIVENNAME);
        DefaultLookUp.put("initials", INITIALS);
        DefaultLookUp.put("generation", GENERATION);
        DefaultLookUp.put("unstructuredaddress", UnstructuredAddress);
        DefaultLookUp.put("unstructuredname", UnstructuredName);
        DefaultLookUp.put("uniqueidentifier", UNIQUE_IDENTIFIER);
        DefaultLookUp.put("dn", DN_QUALIFIER);
        DefaultLookUp.put("pseudonym", PSEUDONYM);
        DefaultLookUp.put("postaladdress", POSTAL_ADDRESS);
        DefaultLookUp.put("nameofbirth", NAME_AT_BIRTH);
        DefaultLookUp.put("countryofcitizenship", COUNTRY_OF_CITIZENSHIP);
        DefaultLookUp.put("countryofresidence", COUNTRY_OF_RESIDENCE);
        DefaultLookUp.put("gender", GENDER);
        DefaultLookUp.put("placeofbirth", PLACE_OF_BIRTH);
        DefaultLookUp.put("dateofbirth", DATE_OF_BIRTH);
        DefaultLookUp.put("postalcode", POSTAL_CODE);
        DefaultLookUp.put("businesscategory", BUSINESS_CATEGORY);
        DefaultLookUp.put("telephonenumber", TELEPHONE_NUMBER);
        DefaultLookUp.put("name", NAME);
    }
    
}

