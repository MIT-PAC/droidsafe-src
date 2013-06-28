package org.apache.harmony.security.x501;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.DerInputStream;
import org.apache.harmony.security.x509.DNParser;

public final class Name {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.556 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "30CBCFF31EBF02BAF8CCE8746893E2BE")

    private volatile byte[] encoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.556 -0400", hash_original_field = "D3D447AF80DE9C9F3D9B63CF94F55184", hash_generated_field = "E9B4D5E56AD2A3335D3949EE5A0BDAE4")

    private String rfc1779String;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.556 -0400", hash_original_field = "664A0E8FFD9C61643C45E3F591AD329D", hash_generated_field = "4EB0ACB941F165E12B4051EF94EDEC10")

    private String rfc2253String;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.556 -0400", hash_original_field = "B29221210691C6B855770C8489C5F896", hash_generated_field = "176833DBCE1C94B471D76BC4A5F6B374")

    private String canonicalString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.556 -0400", hash_original_field = "A7C4EB7A67911D7C03FB9703168ED3E7", hash_generated_field = "613FBB7F6EF0BF172336FED0F72DF53F")

    private List<List<AttributeTypeAndValue>> rdn;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.557 -0400", hash_original_method = "7EBA5C9ECD25887AF5B543E5839AFD7E", hash_generated_method = "352DC8B42972CEE58709799A50D660C8")
    public  Name(byte[] encoding) throws IOException {
        DerInputStream in = new DerInputStream(encoding);
        {
            boolean var7BCB0509788D553E8FA912AF9C311FBA_704279109 = (in.getEndOffset() != encoding.length);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Wrong content length");
            } //End block
        } //End collapsed parenthetic
        ASN1.decode(in);
        this.rdn = (List<List<AttributeTypeAndValue>>) in.content;
        addTaint(encoding[0]);
        // ---------- Original Method ----------
        //DerInputStream in = new DerInputStream(encoding);
        //if (in.getEndOffset() != encoding.length) {
            //throw new IOException("Wrong content length");
        //}
        //ASN1.decode(in);
        //this.rdn = (List<List<AttributeTypeAndValue>>) in.content;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.557 -0400", hash_original_method = "C2DB210B9AE13E0849500530EB26AF9F", hash_generated_method = "99987687812445E7EE166CCEBCAFD37E")
    public  Name(String name) throws IOException {
        rdn = new DNParser(name).parse();
        // ---------- Original Method ----------
        //rdn = new DNParser(name).parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.557 -0400", hash_original_method = "31033A15DF0AC22272F2A1E0E5DFAD4C", hash_generated_method = "8232F001CAB6A6D20D5565435712EF88")
    private  Name(List<List<AttributeTypeAndValue>> rdn) {
        this.rdn = rdn;
        // ---------- Original Method ----------
        //this.rdn = rdn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.558 -0400", hash_original_method = "0542B71517FD35CAEA3075D7EB945221", hash_generated_method = "8992B0605040D6FE93B6627F145FCB5B")
    public X500Principal getX500Principal() {
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_959391652 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_959391652 = new X500Principal(getEncoded());
        varB4EAC82CA7396A68D541C85D26508E83_959391652.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_959391652;
        // ---------- Original Method ----------
        //return new X500Principal(getEncoded());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.559 -0400", hash_original_method = "5BEC09DB13BD8A96A72F05D9AA4FB5FA", hash_generated_method = "36036F32B34C874C3A9C9B18E12302EA")
    public String getName(String format) {
        String varB4EAC82CA7396A68D541C85D26508E83_1219086171 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_851982604 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_739378347 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_802962636 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_2066826584 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_611774744 = null; //Variable for return #6
        {
            boolean var9F3E2E2B2C63C7BA67AE80E135A949C7_1331859726 = (X500Principal.RFC1779.equals(format));
            {
                {
                    rfc1779String = getName0(format);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1219086171 = rfc1779String;
            } //End block
            {
                boolean var635B3366C601FAF6F89B027A5B4C0FBB_846605284 = (X500Principal.RFC2253.equals(format));
                {
                    {
                        rfc2253String = getName0(format);
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_851982604 = rfc2253String;
                } //End block
                {
                    boolean var8458FA31BAAF6CD07D7E0DCEE6BB7213_2128292077 = (X500Principal.CANONICAL.equals(format));
                    {
                        {
                            canonicalString = getName0(format);
                        } //End block
                        varB4EAC82CA7396A68D541C85D26508E83_739378347 = canonicalString;
                    } //End block
                    {
                        boolean varBBDF17E278B208711BBFE0B7A0326264_968783921 = (X500Principal.RFC1779.equalsIgnoreCase(format));
                        {
                            {
                                rfc1779String = getName0(X500Principal.RFC1779);
                            } //End block
                            varB4EAC82CA7396A68D541C85D26508E83_802962636 = rfc1779String;
                        } //End block
                        {
                            boolean varAB40B8C6605B7679B4FE08F3C1B2698B_2143740408 = (X500Principal.RFC2253.equalsIgnoreCase(format));
                            {
                                {
                                    rfc2253String = getName0(X500Principal.RFC2253);
                                } //End block
                                varB4EAC82CA7396A68D541C85D26508E83_2066826584 = rfc2253String;
                            } //End block
                            {
                                boolean var9FF9CDC2F36283DAF8FFAA752D307F5F_812831776 = (X500Principal.CANONICAL.equalsIgnoreCase(format));
                                {
                                    {
                                        canonicalString = getName0(X500Principal.CANONICAL);
                                    } //End block
                                    varB4EAC82CA7396A68D541C85D26508E83_611774744 = canonicalString;
                                } //End block
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Illegal format: " + format);
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_1528668745; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1528668745 = varB4EAC82CA7396A68D541C85D26508E83_1219086171;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1528668745 = varB4EAC82CA7396A68D541C85D26508E83_851982604;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1528668745 = varB4EAC82CA7396A68D541C85D26508E83_739378347;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1528668745 = varB4EAC82CA7396A68D541C85D26508E83_802962636;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1528668745 = varB4EAC82CA7396A68D541C85D26508E83_2066826584;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1528668745 = varB4EAC82CA7396A68D541C85D26508E83_611774744;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1528668745.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1528668745;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.562 -0400", hash_original_method = "F650F61C4EF367763857B0C83C9384E7", hash_generated_method = "962B61675D874AAA90FF87F8854B1B78")
    private String getName0(String format) {
        String varB4EAC82CA7396A68D541C85D26508E83_1606403599 = null; //Variable for return #1
        StringBuilder name = new StringBuilder();
        {
            int i = rdn.size() - 1;
            {
                List<AttributeTypeAndValue> atavList = rdn.get(i);
                {
                    atavList = new ArrayList<AttributeTypeAndValue>(atavList);
                    Collections.sort(atavList, new AttributeTypeAndValueComparator());
                } //End block
                Iterator<AttributeTypeAndValue> it = atavList.iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_2080938415 = (it.hasNext());
                    {
                        AttributeTypeAndValue attributeTypeAndValue = it.next();
                        attributeTypeAndValue.appendName(format, name);
                        {
                            boolean var19710F7E505762555D6239218929D393_1613052411 = (it.hasNext());
                            {
                                {
                                    name.append(" + ");
                                } //End block
                                {
                                    name.append('+');
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    name.append(',');
                    {
                        name.append(' ');
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        String sName = name.toString();
        {
            boolean var03913642DFC5582E852E52BB2FD4098E_44451682 = (X500Principal.CANONICAL.equals(format));
            {
                sName = sName.toLowerCase(Locale.US);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1606403599 = sName;
        addTaint(format.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1606403599.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1606403599;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.562 -0400", hash_original_method = "2981EA1A601F56A7B701653790363606", hash_generated_method = "CBD49304324945EF69D521F5E192C7FF")
    public byte[] getEncoded() {
        {
            encoded = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_842337145 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_842337145;
        // ---------- Original Method ----------
        //if (encoded == null) {
            //encoded = ASN1.encode(this);
        //}
        //return encoded;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.562 -0400", hash_original_field = "7583F52F0E9C85B2DF53D66BFAA66FF7", hash_generated_field = "292A5C4C3AF0A6F5B034171E032DDEFA")

    public static final ASN1SetOf ASN1_RDN = new ASN1SetOf(
            AttributeTypeAndValue.ASN1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.562 -0400", hash_original_field = "8455297A18620927B582292F082B718B", hash_generated_field = "597EE65661FDE3B49FE8B0352BA399B9")

    public static final ASN1SequenceOf ASN1 = new ASN1SequenceOf(ASN1_RDN) {

        public Object getDecodedObject(BerInputStream in) {
            return new Name((List<List<AttributeTypeAndValue>>) in.content);
        }

        public Collection getValues(Object object) {
            return ((Name) object).rdn;
        }
    };
    // orphaned legacy method
    public Collection getValues(Object object) {
            return ((Name) object).rdn;
        }
    
    // orphaned legacy method
    public Object getDecodedObject(BerInputStream in) {
            return new Name((List<List<AttributeTypeAndValue>>) in.content);
        }
    
}

