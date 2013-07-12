package org.apache.harmony.security.x501;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.495 -0400", hash_original_field = "130F43112BB8A7A7790EBFC08EE9D6AF", hash_generated_field = "8882A462AEDA287957EC397E85D609FD")

    private ObjectIdentifier oid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.495 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "4F163C427394BA0FF5E07FEF103C118C")

    private AttributeValue value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.496 -0400", hash_original_method = "6EC11ED1743D72D03D153EE3955FA226", hash_generated_method = "E5E12649FAADB9729D11ACE6459D9D75")
    private  AttributeTypeAndValue(int[] oid, AttributeValue value) throws IOException {
        ObjectIdentifier thisOid = getOID(oid);
    if(thisOid == null)        
        {
            thisOid = new ObjectIdentifier(oid);
        } 
        this.oid = thisOid;
        this.value = value;
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.497 -0400", hash_original_method = "C6730356D790440CF3C53B1796ADEA2C", hash_generated_method = "5EC92E46F1AD9AE129F044E8B4F66FE2")
    public  AttributeTypeAndValue(String sOid, AttributeValue value) throws IOException {
    if(sOid.charAt(0) >= '0' && sOid.charAt(0) <= '9')        
        {
            int[] array = org.apache.harmony.security.asn1.ObjectIdentifier.toIntArray(sOid);
            ObjectIdentifier thisOid = getOID(array);
    if(thisOid == null)            
            {
                thisOid = new ObjectIdentifier(array);
            } 
            this.oid = thisOid;
        } 
        else
        {
            this.oid = KNOWN_NAMES.get(sOid.toUpperCase(Locale.US));
    if(this.oid == null)            
            {
                IOException varDB8D0A1481468F0B8911412768EAF7DE_118639173 = new IOException("Unrecognizable attribute name: " + sOid);
                varDB8D0A1481468F0B8911412768EAF7DE_118639173.addTaint(taint);
                throw varDB8D0A1481468F0B8911412768EAF7DE_118639173;
            } 
        } 
        this.value = value;
        
        
            
            
            
                
            
            
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.499 -0400", hash_original_method = "296A7913293032A81F372D58309D975C", hash_generated_method = "B282C0AD8EABF105319CBFA704CC99BE")
    public void appendName(String attrFormat, StringBuilder sb) {
        addTaint(sb.getTaint());
        addTaint(attrFormat.getTaint());
        boolean hexFormat = false;
    if(X500Principal.RFC1779.equals(attrFormat))        
        {
    if(RFC1779_NAMES == oid.getGroup())            
            {
                sb.append(oid.getName());
            } 
            else
            {
                sb.append(oid.toOIDString());
            } 
            sb.append('=');
    if(value.escapedString == value.getHexString())            
            {
                sb.append(value.getHexString().toUpperCase(Locale.US));
            } 
            else
    if(value.escapedString.length() != value.rawString.length())            
            {
                value.appendQEString(sb);
            } 
            else
            {
                sb.append(value.escapedString);
            } 
        } 
        else
        {
            Object group = oid.getGroup();
    if(RFC1779_NAMES == group || RFC2253_NAMES == group)            
            {
                sb.append(oid.getName());
    if(X500Principal.CANONICAL.equals(attrFormat))                
                {
                    int tag = value.getTag();
    if(!ASN1StringType.UTF8STRING.checkTag(tag)
                            && !ASN1StringType.PRINTABLESTRING.checkTag(tag)
                            && !ASN1StringType.TELETEXSTRING.checkTag(tag))                    
                    {
                        hexFormat = true;
                    } 
                } 
            } 
            else
            {
                sb.append(oid.toString());
                hexFormat = true;
            } 
            sb.append('=');
    if(hexFormat)            
            {
                sb.append(value.getHexString());
            } 
            else
            {
    if(X500Principal.CANONICAL.equals(attrFormat))                
                {
                    sb.append(value.makeCanonical());
                } 
                else
                {
                    sb.append(value.escapedString);
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.500 -0400", hash_original_method = "FA85FF96313B2EEDB4486C871DCE0458", hash_generated_method = "7F121C6105DA0460708ACECE2782557C")
    public ObjectIdentifier getType() {
ObjectIdentifier var6EE0E520E830DF58CC7591C0A7BECFB6_1508207867 =         oid;
        var6EE0E520E830DF58CC7591C0A7BECFB6_1508207867.addTaint(taint);
        return var6EE0E520E830DF58CC7591C0A7BECFB6_1508207867;
        
        
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

    
        @DSModeled(DSC.SAFE)
    private static int hashIntArray(int[] oid) {
        int intHash = 0;
        for (int i = 0; i < oid.length && i < 4; i++) {
            intHash += oid[i] << (8 * i); 
        }
        return intHash & 0x7FFFFFFF;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.501 -0400", hash_original_field = "3097D00F40A0BC26599DB082C5B3D026", hash_generated_field = "5207D163779DEE9675E626EA13EFBE30")

    private static final HashMap<String, ObjectIdentifier> RFC1779_NAMES = new HashMap<String, ObjectIdentifier>(10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.501 -0400", hash_original_field = "81C840B786F9FB0B04014EA75DD48B77", hash_generated_field = "8066102F970313958E622F86A17AE18D")

    private static final HashMap<String, ObjectIdentifier> KNOWN_NAMES = new HashMap<String, ObjectIdentifier>(30);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.501 -0400", hash_original_field = "80EA0705220C65ABAC9D3BE34ECC73F4", hash_generated_field = "EF00B04823B98540169FF1AB7F4513ED")

    private static final HashMap<String, ObjectIdentifier> RFC2253_NAMES = new HashMap<String, ObjectIdentifier>(10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.501 -0400", hash_original_field = "2B24BBB26971FD5DEECA6F62E121CF0B", hash_generated_field = "D6C412F713A28CD3973BFEED8B39D464")

    private static final HashMap<String, ObjectIdentifier> RFC2459_NAMES = new HashMap<String, ObjectIdentifier>(10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.501 -0400", hash_original_field = "D01C69C84B0C9E09E6B2B681D3BFAC7E", hash_generated_field = "8CB088E05D348A8F09614B48F4BF38BA")

    private static final ObjectIdentifier C = new ObjectIdentifier(new int[] { 2, 5, 4, 6 }, "C", RFC1779_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.501 -0400", hash_original_field = "6C21C198821C41996120F12EC4EF2B3A", hash_generated_field = "62019E46EE850D23270F9E3DC652B5CE")

    private static final ObjectIdentifier CN = new ObjectIdentifier(new int[] { 2, 5, 4, 3 }, "CN", RFC1779_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.501 -0400", hash_original_field = "F8621FAE4B5D38B9D4D7B519A2296507", hash_generated_field = "E89A0D43336082D6B88BB1634AA2C65A")

    private static final ObjectIdentifier DC = new ObjectIdentifier(
            new int[] { 0, 9, 2342, 19200300, 100, 1, 25 }, "DC", RFC2253_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.501 -0400", hash_original_field = "6D843B12950E7E76A710817940E4862E", hash_generated_field = "4206325E209BCC75E8D09F6566439C1E")

    private static final ObjectIdentifier DNQ = new ObjectIdentifier(new int[] { 2, 5, 4, 46 }, "DNQ", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.501 -0400", hash_original_field = "25A4EBB2F79A5A6F681969FD9EB169B4", hash_generated_field = "188B912ADB054B566A701AFA00C51543")

    private static final ObjectIdentifier DNQUALIFIER = new ObjectIdentifier(new int[] { 2, 5, 4, 46 }, "DNQUALIFIER", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.502 -0400", hash_original_field = "CCB95DBFB30CC384022453678D84D1D4", hash_generated_field = "ECF87076C29754CD3A47D1F600E03D36")

    private static final ObjectIdentifier EMAILADDRESS = new ObjectIdentifier(
            new int[] { 1, 2, 840, 113549, 1, 9, 1}, "EMAILADDRESS", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.502 -0400", hash_original_field = "FB4DB7DD5C5683B14ECE280AA0D149E6", hash_generated_field = "89E386C4E13C2710860B9E2B4D58F012")

    private static final ObjectIdentifier GENERATION = new ObjectIdentifier(new int[] { 2, 5, 4, 44 }, "GENERATION", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.502 -0400", hash_original_field = "208A2D7D9F7C89DCABFC2AA3AA7FB808", hash_generated_field = "FECEA0BD201D269BBB53725DB5B9838E")

    private static final ObjectIdentifier GIVENNAME = new ObjectIdentifier(new int[] { 2, 5, 4, 42 }, "GIVENNAME", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.502 -0400", hash_original_field = "4DC66788B52A16D42C5C0628EA0E817E", hash_generated_field = "1D557C1E8E06306A4E0632901015C2C0")

    private static final ObjectIdentifier INITIALS = new ObjectIdentifier(new int[] { 2, 5, 4, 43 }, "INITIALS", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.502 -0400", hash_original_field = "8198152FE1CBC856790D0DF35CA7912C", hash_generated_field = "6BA6F2EA3D1BBB84B8BF35E1E59C76C9")

    private static final ObjectIdentifier L = new ObjectIdentifier(new int[] { 2, 5, 4, 7 }, "L", RFC1779_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.502 -0400", hash_original_field = "04294E61938F8515303B48828724878C", hash_generated_field = "FF0191CC096C1961ACFBE7F14EF0EC1E")

    private static final ObjectIdentifier O = new ObjectIdentifier(new int[] { 2, 5, 4, 10 }, "O", RFC1779_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.502 -0400", hash_original_field = "58EDCD40029313A9493DBFE0BE236F58", hash_generated_field = "D0C255D53E24FFD7ED03EB524107F518")

    private static final ObjectIdentifier OU = new ObjectIdentifier(new int[] { 2, 5, 4, 11 }, "OU", RFC1779_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.502 -0400", hash_original_field = "8FADC3BDC6D0D0D3C8BD181ADAF93778", hash_generated_field = "4B5476A6E7F002FA4498E2B57B02FA56")

    private static final ObjectIdentifier SERIALNUMBER = new ObjectIdentifier(new int[] { 2, 5, 4, 5 }, "SERIALNUMBER", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.502 -0400", hash_original_field = "7BB7B417882E47CBD948AF6E295559F2", hash_generated_field = "F49BCBBFE38E5E8659597739D8D96955")

    private static final ObjectIdentifier ST = new ObjectIdentifier(new int[] { 2, 5, 4, 8 }, "ST", RFC1779_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.502 -0400", hash_original_field = "F7AE5940B6801EEBFEB14A725CA0B1CB", hash_generated_field = "3DE3D60B4A41F406FFF34CD8BE6C0C4D")

    private static final ObjectIdentifier STREET = new ObjectIdentifier(new int[] { 2, 5, 4, 9 }, "STREET", RFC1779_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.502 -0400", hash_original_field = "44B3E3BD9776C2E1353C426C38CDC0A0", hash_generated_field = "939200CC1A97087F817576C7C025D9D6")

    private static final ObjectIdentifier SURNAME = new ObjectIdentifier(new int[] { 2, 5, 4, 4 }, "SURNAME", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.503 -0400", hash_original_field = "C684466BFE2E84E728C7EB8303F41731", hash_generated_field = "997CD818EEB2AE6309709767B20EB267")

    private static final ObjectIdentifier T = new ObjectIdentifier(new int[] { 2, 5, 4, 12 }, "T", RFC2459_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.503 -0400", hash_original_field = "691DD32C5172DEBC34B32C3E4E1C2954", hash_generated_field = "EE00D14202867529C037600B0E0A0159")

    private static final ObjectIdentifier UID = new ObjectIdentifier(
            new int[]{ 0, 9, 2342, 19200300, 100, 1, 1 }, "UID", RFC2253_NAMES);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.503 -0400", hash_original_field = "DA3B2CF3AE8FDE7F702A191702DE08EB", hash_generated_field = "D1143EB3F5AB2EA1D8FE8AB241E7C1A7")

    private static final int CAPACITY = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.503 -0400", hash_original_field = "7F7C994A2BF3225FE6DFDDCA3307882A", hash_generated_field = "70468A6CBECF0AAF7AB8398F9B18D4C4")

    private static final int SIZE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.503 -0400", hash_original_field = "33C3EDABA2AC5A34BAAC8F7075DA7E0D", hash_generated_field = "C6E5CDF5F54C03C730B88D808733A92F")

    private static final ObjectIdentifier[][] KNOWN_OIDS = new ObjectIdentifier[SIZE][CAPACITY];
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.503 -0400", hash_original_field = "D4833F66C11E12436FE13D081F4B6A4B", hash_generated_field = "ACD1F0C015E6FEB6E7B03425C7BFACF0")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.504 -0400", hash_original_field = "9892E1681AC4411F169704812D66E8F6", hash_generated_field = "FEE5174CB85B698A746B4AA7D266C177")

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
    
    
    public void encodeContent(BerOutputStream out) {
            
            throw new RuntimeException("AttributeValue encodeContent MUST NOT be invoked");
        }
    
}

