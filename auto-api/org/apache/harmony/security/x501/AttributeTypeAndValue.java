package org.apache.harmony.security.x501;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.nio.charset.Charsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1Constants;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1StringType;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BerOutputStream;
import org.apache.harmony.security.utils.ObjectIdentifier;

public final class AttributeTypeAndValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.253 -0400", hash_original_field = "130F43112BB8A7A7790EBFC08EE9D6AF", hash_generated_field = "8882A462AEDA287957EC397E85D609FD")

    private ObjectIdentifier oid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.254 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "4F163C427394BA0FF5E07FEF103C118C")

    private AttributeValue value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.254 -0400", hash_original_method = "6EC11ED1743D72D03D153EE3955FA226", hash_generated_method = "D627174A29D67D5AC7AC98CFEAEA87E5")
    private  AttributeTypeAndValue(int[] oid, AttributeValue value) throws IOException {
        ObjectIdentifier thisOid;
        thisOid = getOID(oid);
        {
            thisOid = new ObjectIdentifier(oid);
        } //End block
        this.oid = thisOid;
        this.value = value;
        // ---------- Original Method ----------
        //ObjectIdentifier thisOid = getOID(oid);
        //if (thisOid == null) {
            //thisOid = new ObjectIdentifier(oid);
        //}
        //this.oid = thisOid;
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.257 -0400", hash_original_method = "C6730356D790440CF3C53B1796ADEA2C", hash_generated_method = "04F8ECBE36BCC9B428A582FFC7BD057B")
    public  AttributeTypeAndValue(String sOid, AttributeValue value) throws IOException {
        {
            boolean varA10F776189F297B791BEA0761543AE74_1282960906 = (sOid.charAt(0) >= '0' && sOid.charAt(0) <= '9');
            {
                int[] array;
                array = org.apache.harmony.security.asn1.ObjectIdentifier.toIntArray(sOid);
                ObjectIdentifier thisOid;
                thisOid = getOID(array);
                {
                    thisOid = new ObjectIdentifier(array);
                } //End block
                this.oid = thisOid;
            } //End block
            {
                this.oid = KNOWN_NAMES.get(sOid.toUpperCase(Locale.US));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Unrecognizable attribute name: " + sOid);
                } //End block
            } //End block
        } //End collapsed parenthetic
        this.value = value;
        // ---------- Original Method ----------
        //if (sOid.charAt(0) >= '0' && sOid.charAt(0) <= '9') {
            //int[] array = org.apache.harmony.security.asn1.ObjectIdentifier.toIntArray(sOid);
            //ObjectIdentifier thisOid = getOID(array);
            //if (thisOid == null) {
                //thisOid = new ObjectIdentifier(array);
            //}
            //this.oid = thisOid;
        //} else {
            //this.oid = KNOWN_NAMES.get(sOid.toUpperCase(Locale.US));
            //if (this.oid == null) {
                //throw new IOException("Unrecognizable attribute name: " + sOid);
            //}
        //}
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.260 -0400", hash_original_method = "296A7913293032A81F372D58309D975C", hash_generated_method = "FAD14584431C0264D9740173556052B3")
    public void appendName(String attrFormat, StringBuilder sb) {
        boolean hexFormat;
        hexFormat = false;
        {
            boolean var5A26DDC9239697988704479E9F19088F_1224200480 = (X500Principal.RFC1779.equals(attrFormat));
            {
                {
                    boolean var226FF93F9DDEB8508CA47FD5E240643C_1276655088 = (RFC1779_NAMES == oid.getGroup());
                    {
                        sb.append(oid.getName());
                    } //End block
                    {
                        sb.append(oid.toOIDString());
                    } //End block
                } //End collapsed parenthetic
                sb.append('=');
                {
                    boolean varEF16AD10E9E898EE73AC67F4A2D222E5_1481336517 = (value.escapedString == value.getHexString());
                    {
                        sb.append(value.getHexString().toUpperCase(Locale.US));
                    } //End block
                    {
                        boolean varC66608B564A0349649E67963FFB6F626_1768105286 = (value.escapedString.length() != value.rawString.length());
                        {
                            value.appendQEString(sb);
                        } //End block
                        {
                            sb.append(value.escapedString);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            {
                Object group;
                group = oid.getGroup();
                {
                    sb.append(oid.getName());
                    {
                        boolean varD6B997AF692A4DD4D9B3E5F589E91E4F_1056488378 = (X500Principal.CANONICAL.equals(attrFormat));
                        {
                            int tag;
                            tag = value.getTag();
                            {
                                boolean varD2D7B742603C4F73D4ECF89FE0AC8E79_228441849 = (!ASN1StringType.UTF8STRING.checkTag(tag)
                            && !ASN1StringType.PRINTABLESTRING.checkTag(tag)
                            && !ASN1StringType.TELETEXSTRING.checkTag(tag));
                                {
                                    hexFormat = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    sb.append(oid.toString());
                    hexFormat = true;
                } //End block
                sb.append('=');
                {
                    sb.append(value.getHexString());
                } //End block
                {
                    {
                        boolean varD6B997AF692A4DD4D9B3E5F589E91E4F_1346800001 = (X500Principal.CANONICAL.equals(attrFormat));
                        {
                            sb.append(value.makeCanonical());
                        } //End block
                        {
                            sb.append(value.escapedString);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(attrFormat.getTaint());
        addTaint(sb.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.261 -0400", hash_original_method = "FA85FF96313B2EEDB4486C871DCE0458", hash_generated_method = "27064C0FF6D30B803921DEFC25F7B316")
    public ObjectIdentifier getType() {
        ObjectIdentifier varB4EAC82CA7396A68D541C85D26508E83_756953703 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_756953703 = oid;
        varB4EAC82CA7396A68D541C85D26508E83_756953703.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_756953703;
        // ---------- Original Method ----------
        //return oid;
    }

    
        private static ObjectIdentifier getOID(int[] oid) {
        int index = hashIntArray(oid) % CAPACITY;
        ObjectIdentifier[] list = KNOWN_OIDS[index];
        for (int i = 0; list[i] != null; i++) {
            if (Arrays.equals(oid, list[i].getOid())) {
                return list[i];
            }
        }
        return null;
    }

    
        private static void addOID(ObjectIdentifier oid) {
        int[] newOid = oid.getOid();
        int index = hashIntArray(newOid) % CAPACITY;
        ObjectIdentifier[] list = KNOWN_OIDS[index];
        int i = 0;
        for (; list[i] != null; i++) {
            if (Arrays.equals(newOid, list[i].getOid())) {
                throw new Error("ObjectIdentifier: invalid static initialization; " +
                        "duplicate OIDs: " + oid.getName() + " " + list[i].getName());
            }
        }
        if (i == (CAPACITY - 1)) {
            throw new Error("ObjectIdentifier: invalid static initialization; " +
                    "small OID pool capacity");
        }
        list[i] = oid;
    }

    
        private static int hashIntArray(int[] oid) {
        int intHash = 0;
        for (int i = 0; i < oid.length && i < 4; i++) {
            intHash += oid[i] << (8 * i); 
        }
        return intHash & 0x7FFFFFFF;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.262 -0400", hash_original_field = "3097D00F40A0BC26599DB082C5B3D026", hash_generated_field = "FCB06F36F7E15F878DF9A96AECE8A386")

    private static HashMap<String, ObjectIdentifier> RFC1779_NAMES = new HashMap<String, ObjectIdentifier>(10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.262 -0400", hash_original_field = "81C840B786F9FB0B04014EA75DD48B77", hash_generated_field = "C030CE2AAFA4ADD633F61FBDE0854D50")

    private static HashMap<String, ObjectIdentifier> KNOWN_NAMES = new HashMap<String, ObjectIdentifier>(30);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.262 -0400", hash_original_field = "80EA0705220C65ABAC9D3BE34ECC73F4", hash_generated_field = "FB2A5FDA06DC22E176C7994CDEE610E7")

    private static HashMap<String, ObjectIdentifier> RFC2253_NAMES = new HashMap<String, ObjectIdentifier>(10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.262 -0400", hash_original_field = "2B24BBB26971FD5DEECA6F62E121CF0B", hash_generated_field = "993B39F655D3C1BD2ABAD34754C1B1BB")

    private static HashMap<String, ObjectIdentifier> RFC2459_NAMES = new HashMap<String, ObjectIdentifier>(10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.262 -0400", hash_original_field = "D01C69C84B0C9E09E6B2B681D3BFAC7E", hash_generated_field = "DBF9027C3DDCEA75987DE97057FEED3A")

    private static ObjectIdentifier C = new ObjectIdentifier(new int[] { 2, 5, 4, 6 }, "C", RFC1779_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.262 -0400", hash_original_field = "6C21C198821C41996120F12EC4EF2B3A", hash_generated_field = "CC6BD8F902DF775A4574C8CEEB8589B4")

    private static ObjectIdentifier CN = new ObjectIdentifier(new int[] { 2, 5, 4, 3 }, "CN", RFC1779_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.262 -0400", hash_original_field = "F8621FAE4B5D38B9D4D7B519A2296507", hash_generated_field = "48F9736029B7F2EFD5877AAD1544AC54")

    private static ObjectIdentifier DC = new ObjectIdentifier(
            new int[] { 0, 9, 2342, 19200300, 100, 1, 25 }, "DC", RFC2253_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.262 -0400", hash_original_field = "6D843B12950E7E76A710817940E4862E", hash_generated_field = "97CFA74154D75489C52FBC995ED3019C")

    private static ObjectIdentifier DNQ = new ObjectIdentifier(new int[] { 2, 5, 4, 46 }, "DNQ", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.262 -0400", hash_original_field = "25A4EBB2F79A5A6F681969FD9EB169B4", hash_generated_field = "B682E463BCF5F182E5C09CB00AB51EC3")

    private static ObjectIdentifier DNQUALIFIER = new ObjectIdentifier(new int[] { 2, 5, 4, 46 }, "DNQUALIFIER", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.262 -0400", hash_original_field = "CCB95DBFB30CC384022453678D84D1D4", hash_generated_field = "E348AE70D4E092E489322413F9D43ABB")

    private static ObjectIdentifier EMAILADDRESS = new ObjectIdentifier(
            new int[] { 1, 2, 840, 113549, 1, 9, 1}, "EMAILADDRESS", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.262 -0400", hash_original_field = "FB4DB7DD5C5683B14ECE280AA0D149E6", hash_generated_field = "70C02DB234F636C77423EB7A55C9CAB8")

    private static ObjectIdentifier GENERATION = new ObjectIdentifier(new int[] { 2, 5, 4, 44 }, "GENERATION", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.263 -0400", hash_original_field = "208A2D7D9F7C89DCABFC2AA3AA7FB808", hash_generated_field = "03C2AC00A5833B99B7E6868DFFD7C31D")

    private static ObjectIdentifier GIVENNAME = new ObjectIdentifier(new int[] { 2, 5, 4, 42 }, "GIVENNAME", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.263 -0400", hash_original_field = "4DC66788B52A16D42C5C0628EA0E817E", hash_generated_field = "BA5A24D348F6CBA1719520BFB5B870FF")

    private static ObjectIdentifier INITIALS = new ObjectIdentifier(new int[] { 2, 5, 4, 43 }, "INITIALS", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.263 -0400", hash_original_field = "8198152FE1CBC856790D0DF35CA7912C", hash_generated_field = "B79EB1E6C0E2FCA6DD573D3144714281")

    private static ObjectIdentifier L = new ObjectIdentifier(new int[] { 2, 5, 4, 7 }, "L", RFC1779_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.263 -0400", hash_original_field = "04294E61938F8515303B48828724878C", hash_generated_field = "B24E6E2DBBE5898AB9FED32006209993")

    private static ObjectIdentifier O = new ObjectIdentifier(new int[] { 2, 5, 4, 10 }, "O", RFC1779_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.263 -0400", hash_original_field = "58EDCD40029313A9493DBFE0BE236F58", hash_generated_field = "010E58AA4A75D85FE8F42577737F6980")

    private static ObjectIdentifier OU = new ObjectIdentifier(new int[] { 2, 5, 4, 11 }, "OU", RFC1779_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.263 -0400", hash_original_field = "8FADC3BDC6D0D0D3C8BD181ADAF93778", hash_generated_field = "0D8D1F3090BBEE324EB9A8C371426B12")

    private static ObjectIdentifier SERIALNUMBER = new ObjectIdentifier(new int[] { 2, 5, 4, 5 }, "SERIALNUMBER", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.263 -0400", hash_original_field = "7BB7B417882E47CBD948AF6E295559F2", hash_generated_field = "BE23E3F1DDA4C1705666053CACAB4C01")

    private static ObjectIdentifier ST = new ObjectIdentifier(new int[] { 2, 5, 4, 8 }, "ST", RFC1779_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.263 -0400", hash_original_field = "F7AE5940B6801EEBFEB14A725CA0B1CB", hash_generated_field = "964FC3A2B6AC980F12520B90DEC2FF37")

    private static ObjectIdentifier STREET = new ObjectIdentifier(new int[] { 2, 5, 4, 9 }, "STREET", RFC1779_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.263 -0400", hash_original_field = "44B3E3BD9776C2E1353C426C38CDC0A0", hash_generated_field = "FD40FE9AE50DB04E34FE14C01E367642")

    private static ObjectIdentifier SURNAME = new ObjectIdentifier(new int[] { 2, 5, 4, 4 }, "SURNAME", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.263 -0400", hash_original_field = "C684466BFE2E84E728C7EB8303F41731", hash_generated_field = "EE4F9E7E036EC4ACE194B21AEA90B9FB")

    private static ObjectIdentifier T = new ObjectIdentifier(new int[] { 2, 5, 4, 12 }, "T", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.263 -0400", hash_original_field = "691DD32C5172DEBC34B32C3E4E1C2954", hash_generated_field = "891E1F558399A10B2DA9B1152D8579F7")

    private static ObjectIdentifier UID = new ObjectIdentifier(
            new int[]{ 0, 9, 2342, 19200300, 100, 1, 1 }, "UID", RFC2253_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.263 -0400", hash_original_field = "DA3B2CF3AE8FDE7F702A191702DE08EB", hash_generated_field = "5AA01CC2680E2FA1C89C7572216A6E8A")

    private static int CAPACITY = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.263 -0400", hash_original_field = "7F7C994A2BF3225FE6DFDDCA3307882A", hash_generated_field = "C2A9A198F043C4185A40D1EAD4E7C587")

    private static int SIZE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.263 -0400", hash_original_field = "33C3EDABA2AC5A34BAAC8F7075DA7E0D", hash_generated_field = "11A3D29345C33ACB7901C5284272C271")

    private static ObjectIdentifier[][] KNOWN_OIDS = new ObjectIdentifier[SIZE][CAPACITY];
    static {
        RFC1779_NAMES.put(CN.getName(), CN);
        RFC1779_NAMES.put(L.getName(), L);
        RFC1779_NAMES.put(ST.getName(), ST);
        RFC1779_NAMES.put(O.getName(), O);
        RFC1779_NAMES.put(OU.getName(), OU);
        RFC1779_NAMES.put(C.getName(), C);
        RFC1779_NAMES.put(STREET.getName(), STREET);
        RFC2253_NAMES.putAll(RFC1779_NAMES);
        RFC2253_NAMES.put(DC.getName(), DC);
        RFC2253_NAMES.put(UID.getName(), UID);
        RFC2459_NAMES.put(DNQ.getName(), DNQ);
        RFC2459_NAMES.put(DNQUALIFIER.getName(), DNQUALIFIER);
        RFC2459_NAMES.put(EMAILADDRESS.getName(), EMAILADDRESS);
        RFC2459_NAMES.put(GENERATION.getName(), GENERATION);
        RFC2459_NAMES.put(GIVENNAME.getName(), GIVENNAME);
        RFC2459_NAMES.put(INITIALS.getName(), INITIALS);
        RFC2459_NAMES.put(SERIALNUMBER.getName(), SERIALNUMBER);
        RFC2459_NAMES.put(SURNAME.getName(), SURNAME);
        RFC2459_NAMES.put(T.getName(), T);
        for (ObjectIdentifier objectIdentifier : RFC2253_NAMES.values()) {
            addOID(objectIdentifier);
        }
        for (ObjectIdentifier o : RFC2459_NAMES.values()) {
            if (!(o == DNQUALIFIER)) {
                addOID(o);
            }
        }
        KNOWN_NAMES.putAll(RFC2253_NAMES); 
        KNOWN_NAMES.putAll(RFC2459_NAMES);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.263 -0400", hash_original_field = "D4833F66C11E12436FE13D081F4B6A4B", hash_generated_field = "ACD1F0C015E6FEB6E7B03425C7BFACF0")

    public static final ASN1Type attributeValue = new ASN1Type(ASN1Constants.TAG_PRINTABLESTRING) {

        public boolean checkTag(int tag) {
            return true;
        }

        public Object decode(BerInputStream in) throws IOException {
            
            String str = null;
            if (DirectoryString.ASN1.checkTag(in.tag)) {
                
                str = (String) DirectoryString.ASN1.decode(in);
            } else {
                
                in.readContent();
            }

            byte[] bytesEncoded = new byte[in.getOffset() - in.getTagOffset()];
            System.arraycopy(in.getBuffer(), in.getTagOffset(), bytesEncoded,
                    0, bytesEncoded.length);

            return new AttributeValue(str, bytesEncoded, in.tag);
        }

        @Override public Object getDecodedObject(BerInputStream in) throws IOException {
            
            throw new RuntimeException("AttributeValue getDecodedObject MUST NOT be invoked");
        }

        
        
        
        public void encodeASN(BerOutputStream out) {
            AttributeValue av = (AttributeValue) out.content;

            if (av.encoded != null) {
                out.content = av.encoded;
                out.encodeANY();
            } else {
                out.encodeTag(av.getTag());
                out.content = av.bytes;
                out.encodeString();
            }
        }

        public void setEncodingContent(BerOutputStream out) {
            AttributeValue av = (AttributeValue) out.content;

            if (av.encoded != null) {
                out.length = av.encoded.length;
            } else {
                if (av.getTag() == ASN1Constants.TAG_UTF8STRING) {
                    out.content = av.rawString;
                    ASN1StringType.UTF8STRING.setEncodingContent(out);
                    av.bytes = (byte[]) out.content;
                    out.content = av;
                } else {
                    av.bytes = av.rawString.getBytes(Charsets.UTF_8);
                    out.length = av.bytes.length;
                }
            }
        }

        public void encodeContent(BerOutputStream out) {
            
            throw new RuntimeException("AttributeValue encodeContent MUST NOT be invoked");
        }

        @Override public int getEncodedLength(BerOutputStream out) { 
            AttributeValue av = (AttributeValue) out.content;
            if (av.encoded != null) {
                return out.length;
            } else {
                return super.getEncodedLength(out);
            }
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.263 -0400", hash_original_field = "9892E1681AC4411F169704812D66E8F6", hash_generated_field = "FEE5174CB85B698A746B4AA7D266C177")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Oid.getInstance(), attributeValue }) {

        @Override protected Object getDecodedObject(BerInputStream in) throws IOException {
            Object[] values = (Object[]) in.content;
            return new AttributeTypeAndValue((int[]) values[0], (AttributeValue) values[1]);
        }

        @Override protected void getValues(Object object, Object[] values) {
            AttributeTypeAndValue atav = (AttributeTypeAndValue) object;
            values[0] = atav.oid.getOid();
            values[1] = atav.value;
        }
    };
}

