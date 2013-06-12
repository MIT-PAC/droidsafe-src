package org.apache.harmony.security.x501;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final HashMap<String, ObjectIdentifier> RFC1779_NAMES
            = new HashMap<String, ObjectIdentifier>(10);
    private static final HashMap<String, ObjectIdentifier> KNOWN_NAMES
            = new HashMap<String, ObjectIdentifier>(30);
    private static final HashMap<String, ObjectIdentifier> RFC2253_NAMES
            = new HashMap<String, ObjectIdentifier>(10);
    private static final HashMap<String, ObjectIdentifier> RFC2459_NAMES
            = new HashMap<String, ObjectIdentifier>(10);
    private static final ObjectIdentifier C
            = new ObjectIdentifier(new int[] { 2, 5, 4, 6 }, "C", RFC1779_NAMES);
    private static final ObjectIdentifier CN
            = new ObjectIdentifier(new int[] { 2, 5, 4, 3 }, "CN", RFC1779_NAMES);
    private static final ObjectIdentifier DC = new ObjectIdentifier(
            new int[] { 0, 9, 2342, 19200300, 100, 1, 25 }, "DC", RFC2253_NAMES);
    private static final ObjectIdentifier DNQ
            = new ObjectIdentifier(new int[] { 2, 5, 4, 46 }, "DNQ", RFC2459_NAMES);
    private static final ObjectIdentifier DNQUALIFIER
            = new ObjectIdentifier(new int[] { 2, 5, 4, 46 }, "DNQUALIFIER", RFC2459_NAMES);
    private static final ObjectIdentifier EMAILADDRESS = new ObjectIdentifier(
            new int[] { 1, 2, 840, 113549, 1, 9, 1}, "EMAILADDRESS", RFC2459_NAMES);
    private static final ObjectIdentifier GENERATION
            = new ObjectIdentifier(new int[] { 2, 5, 4, 44 }, "GENERATION", RFC2459_NAMES);
    private static final ObjectIdentifier GIVENNAME
            = new ObjectIdentifier(new int[] { 2, 5, 4, 42 }, "GIVENNAME", RFC2459_NAMES);
    private static final ObjectIdentifier INITIALS
            = new ObjectIdentifier(new int[] { 2, 5, 4, 43 }, "INITIALS", RFC2459_NAMES);
    private static final ObjectIdentifier L
            = new ObjectIdentifier(new int[] { 2, 5, 4, 7 }, "L", RFC1779_NAMES);
    private static final ObjectIdentifier O
            = new ObjectIdentifier(new int[] { 2, 5, 4, 10 }, "O", RFC1779_NAMES);
    private static final ObjectIdentifier OU
            = new ObjectIdentifier(new int[] { 2, 5, 4, 11 }, "OU", RFC1779_NAMES);
    private static final ObjectIdentifier SERIALNUMBER
            = new ObjectIdentifier(new int[] { 2, 5, 4, 5 }, "SERIALNUMBER", RFC2459_NAMES);
    private static final ObjectIdentifier ST
            = new ObjectIdentifier(new int[] { 2, 5, 4, 8 }, "ST", RFC1779_NAMES);
    private static final ObjectIdentifier STREET
            = new ObjectIdentifier(new int[] { 2, 5, 4, 9 }, "STREET", RFC1779_NAMES);
    private static final ObjectIdentifier SURNAME
            = new ObjectIdentifier(new int[] { 2, 5, 4, 4 }, "SURNAME", RFC2459_NAMES);
    private static final ObjectIdentifier T
            = new ObjectIdentifier(new int[] { 2, 5, 4, 12 }, "T", RFC2459_NAMES);
    private static final ObjectIdentifier UID = new ObjectIdentifier(
            new int[]{ 0, 9, 2342, 19200300, 100, 1, 1 }, "UID", RFC2253_NAMES);
    private static final int CAPACITY = 10;
    private static final int SIZE = 10;
    private static final ObjectIdentifier[][] KNOWN_OIDS = new ObjectIdentifier[SIZE][CAPACITY];
    private ObjectIdentifier oid;
    private final AttributeValue value;
    public static final ASN1Type attributeValue = new ASN1Type(ASN1Constants.TAG_PRINTABLESTRING) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.812 -0400", hash_original_method = "0E705085A9B1D73F25D30FC4A7DB73D9", hash_generated_method = "91FAE9694A4EC5A3926B3D147461CB22")
        @DSModeled(DSC.SAFE)
        public boolean checkTag(int tag) {
            dsTaint.addTaint(tag);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.813 -0400", hash_original_method = "47B9DE0A06449E5D837276EC22B3F0E8", hash_generated_method = "682491010996FEE6B86AFAE559F05578")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object decode(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            String str;
            str = null;
            {
                boolean var31C139B4E94DF8D8A7DBC3E6DC26D73E_1039459803 = (DirectoryString.ASN1.checkTag(in.tag));
                {
                    str = (String) DirectoryString.ASN1.decode(in);
                } //End block
                {
                    in.readContent();
                } //End block
            } //End collapsed parenthetic
            byte[] bytesEncoded;
            bytesEncoded = new byte[in.getOffset() - in.getTagOffset()];
            System.arraycopy(in.getBuffer(), in.getTagOffset(), bytesEncoded,
                    0, bytesEncoded.length);
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //String str = null;
            //if (DirectoryString.ASN1.checkTag(in.tag)) {
                //str = (String) DirectoryString.ASN1.decode(in);
            //} else {
                //in.readContent();
            //}
            //byte[] bytesEncoded = new byte[in.getOffset() - in.getTagOffset()];
            //System.arraycopy(in.getBuffer(), in.getTagOffset(), bytesEncoded,
                    //0, bytesEncoded.length);
            //return new AttributeValue(str, bytesEncoded, in.tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.813 -0400", hash_original_method = "7DF56D76B0B7364F01AC493B84727F79", hash_generated_method = "7D29AF3D053173D25C53F86AAC711D22")
        @DSModeled(DSC.SAFE)
        @Override
        public Object getDecodedObject(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("AttributeValue getDecodedObject MUST NOT be invoked");
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new RuntimeException("AttributeValue getDecodedObject MUST NOT be invoked");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.813 -0400", hash_original_method = "BE595AA7EBC46615F96838D06A8BB9E6", hash_generated_method = "614D27F6DF2AF7D61EF32D6AFE182EF3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void encodeASN(BerOutputStream out) {
            dsTaint.addTaint(out.dsTaint);
            AttributeValue av;
            av = (AttributeValue) out.content;
            {
                out.content = av.encoded;
                out.encodeANY();
            } //End block
            {
                out.encodeTag(av.getTag());
                out.content = av.bytes;
                out.encodeString();
            } //End block
            // ---------- Original Method ----------
            //AttributeValue av = (AttributeValue) out.content;
            //if (av.encoded != null) {
                //out.content = av.encoded;
                //out.encodeANY();
            //} else {
                //out.encodeTag(av.getTag());
                //out.content = av.bytes;
                //out.encodeString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.813 -0400", hash_original_method = "23586BD12951670B298A785C71BB9FF4", hash_generated_method = "1749497F9C3F78EEE48926C2C4CA4A04")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setEncodingContent(BerOutputStream out) {
            dsTaint.addTaint(out.dsTaint);
            AttributeValue av;
            av = (AttributeValue) out.content;
            {
                out.length = av.encoded.length;
            } //End block
            {
                {
                    boolean varA9374937E9A81444462DC2067FC2B0FD_141267108 = (av.getTag() == ASN1Constants.TAG_UTF8STRING);
                    {
                        out.content = av.rawString;
                        ASN1StringType.UTF8STRING.setEncodingContent(out);
                        av.bytes = (byte[]) out.content;
                        out.content = av;
                    } //End block
                    {
                        av.bytes = av.rawString.getBytes(Charsets.UTF_8);
                        out.length = av.bytes.length;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //AttributeValue av = (AttributeValue) out.content;
            //if (av.encoded != null) {
                //out.length = av.encoded.length;
            //} else {
                //if (av.getTag() == ASN1Constants.TAG_UTF8STRING) {
                    //out.content = av.rawString;
                    //ASN1StringType.UTF8STRING.setEncodingContent(out);
                    //av.bytes = (byte[]) out.content;
                    //out.content = av;
                //} else {
                    //av.bytes = av.rawString.getBytes(Charsets.UTF_8);
                    //out.length = av.bytes.length;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.813 -0400", hash_original_method = "1D8F631AE92C0A1AA4D055920CF0287B", hash_generated_method = "1AB381B34B8814F0C285A73934991378")
        @DSModeled(DSC.SAFE)
        public void encodeContent(BerOutputStream out) {
            dsTaint.addTaint(out.dsTaint);
            throw new RuntimeException("AttributeValue encodeContent MUST NOT be invoked");
            // ---------- Original Method ----------
            //throw new RuntimeException("AttributeValue encodeContent MUST NOT be invoked");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.813 -0400", hash_original_method = "BC25F25AEFB600C56F14C45BC364CF5C", hash_generated_method = "F24CE3D0DE95C72600F595A75E5F16E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int getEncodedLength(BerOutputStream out) {
            dsTaint.addTaint(out.dsTaint);
            AttributeValue av;
            av = (AttributeValue) out.content;
            {
                int varEDC3B45F16A8E6884B22741000B86CEA_1192303518 = (super.getEncodedLength(out));
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //AttributeValue av = (AttributeValue) out.content;
            //if (av.encoded != null) {
                //return out.length;
            //} else {
                //return super.getEncodedLength(out);
            //}
        }

        
}; //Transformed anonymous class
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Oid.getInstance(), attributeValue }) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.813 -0400", hash_original_method = "D8107E6357EFE36630D3CBCE737F6259", hash_generated_method = "FF32297AD46B5EA4B3C65FE280D14097")
        @DSModeled(DSC.SAFE)
        @Override
        protected Object getDecodedObject(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //return new AttributeTypeAndValue((int[]) values[0], (AttributeValue) values[1]);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.813 -0400", hash_original_method = "63A50B62635E4187659C3BDD7CE857B1", hash_generated_method = "7AD4CA3ABF91A07D509BE86A6747EB35")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            AttributeTypeAndValue atav;
            atav = (AttributeTypeAndValue) object;
            values[0] = atav.oid.getOid();
            values[1] = atav.value;
            // ---------- Original Method ----------
            //AttributeTypeAndValue atav = (AttributeTypeAndValue) object;
            //values[0] = atav.oid.getOid();
            //values[1] = atav.value;
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.813 -0400", hash_original_method = "6EC11ED1743D72D03D153EE3955FA226", hash_generated_method = "2DA47929506D747D7DC86147264F9149")
    @DSModeled(DSC.SAFE)
    private AttributeTypeAndValue(int[] oid, AttributeValue value) throws IOException {
        dsTaint.addTaint(oid);
        dsTaint.addTaint(value.dsTaint);
        this.value = value;
        ObjectIdentifier thisOid;
        thisOid = getOID(oid);
        {
            thisOid = new ObjectIdentifier(oid);
        } //End block
        this.oid = thisOid;
        // ---------- Original Method ----------
        //ObjectIdentifier thisOid = getOID(oid);
        //if (thisOid == null) {
            //thisOid = new ObjectIdentifier(oid);
        //}
        //this.oid = thisOid;
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.814 -0400", hash_original_method = "C6730356D790440CF3C53B1796ADEA2C", hash_generated_method = "C344707B52CE1695F10D379506E3A7BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributeTypeAndValue(String sOid, AttributeValue value) throws IOException {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(sOid);
        {
            boolean varA10F776189F297B791BEA0761543AE74_1396827831 = (sOid.charAt(0) >= '0' && sOid.charAt(0) <= '9');
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
                    throw new IOException("Unrecognizable attribute name: " + sOid);
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.814 -0400", hash_original_method = "296A7913293032A81F372D58309D975C", hash_generated_method = "B7F104F5164319482ABD5A1553CE6A69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void appendName(String attrFormat, StringBuilder sb) {
        dsTaint.addTaint(attrFormat);
        dsTaint.addTaint(sb.dsTaint);
        boolean hexFormat;
        hexFormat = false;
        {
            boolean var5A26DDC9239697988704479E9F19088F_174858197 = (X500Principal.RFC1779.equals(attrFormat));
            {
                {
                    boolean var226FF93F9DDEB8508CA47FD5E240643C_463725512 = (RFC1779_NAMES == oid.getGroup());
                    {
                        sb.append(oid.getName());
                    } //End block
                    {
                        sb.append(oid.toOIDString());
                    } //End block
                } //End collapsed parenthetic
                sb.append('=');
                {
                    boolean varEF16AD10E9E898EE73AC67F4A2D222E5_1296641536 = (value.escapedString == value.getHexString());
                    {
                        sb.append(value.getHexString().toUpperCase(Locale.US));
                    } //End block
                    {
                        boolean varC66608B564A0349649E67963FFB6F626_645937104 = (value.escapedString.length() != value.rawString.length());
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
                        boolean varD6B997AF692A4DD4D9B3E5F589E91E4F_1220228773 = (X500Principal.CANONICAL.equals(attrFormat));
                        {
                            int tag;
                            tag = value.getTag();
                            {
                                boolean varD2D7B742603C4F73D4ECF89FE0AC8E79_521183111 = (!ASN1StringType.UTF8STRING.checkTag(tag)
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
                        boolean varD6B997AF692A4DD4D9B3E5F589E91E4F_1404101864 = (X500Principal.CANONICAL.equals(attrFormat));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.814 -0400", hash_original_method = "FA85FF96313B2EEDB4486C871DCE0458", hash_generated_method = "A29ED91F90EFF394A5061AAC97E3FCFD")
    @DSModeled(DSC.SAFE)
    public ObjectIdentifier getType() {
        return (ObjectIdentifier)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return oid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.814 -0400", hash_original_method = "E69664DF4B06AA7B2D486D69240A9EDA", hash_generated_method = "2B5D08B68F93FC0B21175FCDDFBF454B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.814 -0400", hash_original_method = "BFF86F06D273903B963DFA916A722686", hash_generated_method = "7F05D5B6368F64320316F086B7481D96")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.814 -0400", hash_original_method = "9326E50D231DBE55A4CC7DEFA5FC4FF2", hash_generated_method = "D5B4F7102AFF9507402B99C8002387B2")
    private static int hashIntArray(int[] oid) {
        int intHash = 0;
        for (int i = 0; i < oid.length && i < 4; i++) {
            intHash += oid[i] << (8 * i); 
        }
        return intHash & 0x7FFFFFFF;
    }

    
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
    
}


