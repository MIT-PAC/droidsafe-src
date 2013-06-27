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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.314 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "30CBCFF31EBF02BAF8CCE8746893E2BE")

    private volatile byte[] encoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.315 -0400", hash_original_field = "D3D447AF80DE9C9F3D9B63CF94F55184", hash_generated_field = "E9B4D5E56AD2A3335D3949EE5A0BDAE4")

    private String rfc1779String;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.315 -0400", hash_original_field = "664A0E8FFD9C61643C45E3F591AD329D", hash_generated_field = "4EB0ACB941F165E12B4051EF94EDEC10")

    private String rfc2253String;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.315 -0400", hash_original_field = "B29221210691C6B855770C8489C5F896", hash_generated_field = "176833DBCE1C94B471D76BC4A5F6B374")

    private String canonicalString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.315 -0400", hash_original_field = "A7C4EB7A67911D7C03FB9703168ED3E7", hash_generated_field = "613FBB7F6EF0BF172336FED0F72DF53F")

    private List<List<AttributeTypeAndValue>> rdn;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.331 -0400", hash_original_method = "7EBA5C9ECD25887AF5B543E5839AFD7E", hash_generated_method = "3F1276183A853AAA92EBB24D1E45C696")
    public  Name(byte[] encoding) throws IOException {
        DerInputStream in;
        in = new DerInputStream(encoding);
        {
            boolean var7BCB0509788D553E8FA912AF9C311FBA_25584026 = (in.getEndOffset() != encoding.length);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.332 -0400", hash_original_method = "C2DB210B9AE13E0849500530EB26AF9F", hash_generated_method = "99987687812445E7EE166CCEBCAFD37E")
    public  Name(String name) throws IOException {
        rdn = new DNParser(name).parse();
        // ---------- Original Method ----------
        //rdn = new DNParser(name).parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.333 -0400", hash_original_method = "31033A15DF0AC22272F2A1E0E5DFAD4C", hash_generated_method = "8232F001CAB6A6D20D5565435712EF88")
    private  Name(List<List<AttributeTypeAndValue>> rdn) {
        this.rdn = rdn;
        // ---------- Original Method ----------
        //this.rdn = rdn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.333 -0400", hash_original_method = "0542B71517FD35CAEA3075D7EB945221", hash_generated_method = "33B23BEE0D44A1EE2903B84264E6A036")
    public X500Principal getX500Principal() {
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_1663654264 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1663654264 = new X500Principal(getEncoded());
        varB4EAC82CA7396A68D541C85D26508E83_1663654264.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1663654264;
        // ---------- Original Method ----------
        //return new X500Principal(getEncoded());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.334 -0400", hash_original_method = "5BEC09DB13BD8A96A72F05D9AA4FB5FA", hash_generated_method = "23A35800843031F1306DF9ECCFC6667E")
    public String getName(String format) {
        String varB4EAC82CA7396A68D541C85D26508E83_1891270962 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_183181395 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_761546549 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_521785635 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_818618119 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_1786410603 = null; //Variable for return #6
        {
            boolean var9F3E2E2B2C63C7BA67AE80E135A949C7_604269182 = (X500Principal.RFC1779.equals(format));
            {
                {
                    rfc1779String = getName0(format);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1891270962 = rfc1779String;
            } //End block
            {
                boolean var635B3366C601FAF6F89B027A5B4C0FBB_773220738 = (X500Principal.RFC2253.equals(format));
                {
                    {
                        rfc2253String = getName0(format);
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_183181395 = rfc2253String;
                } //End block
                {
                    boolean var8458FA31BAAF6CD07D7E0DCEE6BB7213_177153072 = (X500Principal.CANONICAL.equals(format));
                    {
                        {
                            canonicalString = getName0(format);
                        } //End block
                        varB4EAC82CA7396A68D541C85D26508E83_761546549 = canonicalString;
                    } //End block
                    {
                        boolean varBBDF17E278B208711BBFE0B7A0326264_1216299353 = (X500Principal.RFC1779.equalsIgnoreCase(format));
                        {
                            {
                                rfc1779String = getName0(X500Principal.RFC1779);
                            } //End block
                            varB4EAC82CA7396A68D541C85D26508E83_521785635 = rfc1779String;
                        } //End block
                        {
                            boolean varAB40B8C6605B7679B4FE08F3C1B2698B_690094448 = (X500Principal.RFC2253.equalsIgnoreCase(format));
                            {
                                {
                                    rfc2253String = getName0(X500Principal.RFC2253);
                                } //End block
                                varB4EAC82CA7396A68D541C85D26508E83_818618119 = rfc2253String;
                            } //End block
                            {
                                boolean var9FF9CDC2F36283DAF8FFAA752D307F5F_1699680329 = (X500Principal.CANONICAL.equalsIgnoreCase(format));
                                {
                                    {
                                        canonicalString = getName0(X500Principal.CANONICAL);
                                    } //End block
                                    varB4EAC82CA7396A68D541C85D26508E83_1786410603 = canonicalString;
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
        String varA7E53CE21691AB073D9660D615818899_1330589627; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1330589627 = varB4EAC82CA7396A68D541C85D26508E83_1891270962;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1330589627 = varB4EAC82CA7396A68D541C85D26508E83_183181395;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1330589627 = varB4EAC82CA7396A68D541C85D26508E83_761546549;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1330589627 = varB4EAC82CA7396A68D541C85D26508E83_521785635;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1330589627 = varB4EAC82CA7396A68D541C85D26508E83_818618119;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1330589627 = varB4EAC82CA7396A68D541C85D26508E83_1786410603;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1330589627.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1330589627;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.342 -0400", hash_original_method = "F650F61C4EF367763857B0C83C9384E7", hash_generated_method = "D6C923467C2E50EC626ECE9B73F47CDB")
    private String getName0(String format) {
        String varB4EAC82CA7396A68D541C85D26508E83_848254984 = null; //Variable for return #1
        StringBuilder name;
        name = new StringBuilder();
        {
            int i;
            i = rdn.size() - 1;
            {
                List<AttributeTypeAndValue> atavList;
                atavList = rdn.get(i);
                {
                    atavList = new ArrayList<AttributeTypeAndValue>(atavList);
                    Collections.sort(atavList, new AttributeTypeAndValueComparator());
                } //End block
                Iterator<AttributeTypeAndValue> it;
                it = atavList.iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1754714698 = (it.hasNext());
                    {
                        AttributeTypeAndValue attributeTypeAndValue;
                        attributeTypeAndValue = it.next();
                        attributeTypeAndValue.appendName(format, name);
                        {
                            boolean var19710F7E505762555D6239218929D393_1566706396 = (it.hasNext());
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
        String sName;
        sName = name.toString();
        {
            boolean var03913642DFC5582E852E52BB2FD4098E_1933913815 = (X500Principal.CANONICAL.equals(format));
            {
                sName = sName.toLowerCase(Locale.US);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_848254984 = sName;
        addTaint(format.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_848254984.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_848254984;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.343 -0400", hash_original_method = "2981EA1A601F56A7B701653790363606", hash_generated_method = "8C6604CEB51EFF49366F10307B400AB1")
    public byte[] getEncoded() {
        {
            encoded = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1205534157 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1205534157;
        // ---------- Original Method ----------
        //if (encoded == null) {
            //encoded = ASN1.encode(this);
        //}
        //return encoded;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.343 -0400", hash_original_field = "7583F52F0E9C85B2DF53D66BFAA66FF7", hash_generated_field = "292A5C4C3AF0A6F5B034171E032DDEFA")

    public static final ASN1SetOf ASN1_RDN = new ASN1SetOf(
            AttributeTypeAndValue.ASN1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.343 -0400", hash_original_field = "8455297A18620927B582292F082B718B", hash_generated_field = "597EE65661FDE3B49FE8B0352BA399B9")

    public static final ASN1SequenceOf ASN1 = new ASN1SequenceOf(ASN1_RDN) {

        public Object getDecodedObject(BerInputStream in) {
            return new Name((List<List<AttributeTypeAndValue>>) in.content);
        }

        public Collection getValues(Object object) {
            return ((Name) object).rdn;
        }
    };
}

