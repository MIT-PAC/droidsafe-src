package org.apache.harmony.security.x501;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

    /**
     * Returns known OID or null.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.393 -0500", hash_original_method = "E69664DF4B06AA7B2D486D69240A9EDA", hash_generated_method = "78762018B546B35CC876C218AF5DCF8D")
    
private static ObjectIdentifier getOID(int[] oid) {
        int index = hashIntArray(oid) % CAPACITY;

        // look for OID in the pool
        ObjectIdentifier[] list = KNOWN_OIDS[index];
        for (int i = 0; list[i] != null; i++) {
            if (Arrays.equals(oid, list[i].getOid())) {
                return list[i];
            }
        }
        return null;
    }

    /**
     * Adds known OID to pool.
     * for static AttributeTypeAndValue initialization only
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.397 -0500", hash_original_method = "BFF86F06D273903B963DFA916A722686", hash_generated_method = "4FE0FBBFCB4CFF862AE86B08133326C6")
    
private static void addOID(ObjectIdentifier oid) {
        int[] newOid = oid.getOid();
        int index = hashIntArray(newOid) % CAPACITY;

        // look for OID in the pool
        ObjectIdentifier[] list = KNOWN_OIDS[index];
        int i = 0;
        for (; list[i] != null; i++) {
            // check wrong static initialization: no duplicate OIDs
            if (Arrays.equals(newOid, list[i].getOid())) {
                throw new Error("ObjectIdentifier: invalid static initialization; " +
                        "duplicate OIDs: " + oid.getName() + " " + list[i].getName());
            }
        }

        // check : to avoid NPE
        if (i == (CAPACITY - 1)) {
            throw new Error("ObjectIdentifier: invalid static initialization; " +
                    "small OID pool capacity");
        }
        list[i] = oid;
    }

    /**
     * Returns hash for array of integers.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.400 -0500", hash_original_method = "9326E50D231DBE55A4CC7DEFA5FC4FF2", hash_generated_method = "AFBCD72A8015E7440F7486AFB8662303")
    
private static int hashIntArray(int[] oid) {
        int intHash = 0;
        for (int i = 0; i < oid.length && i < 4; i++) {
            intHash += oid[i] << (8 * i); //TODO what about to find better one?
        }
        return intHash & 0x7FFFFFFF; // only positive
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.216 -0500", hash_original_field = "6EBC08B8A2BC982BE4B2D585315CB5D9", hash_generated_field = "5207D163779DEE9675E626EA13EFBE30")

    private static final HashMap<String, ObjectIdentifier> RFC1779_NAMES
            = new HashMap<String, ObjectIdentifier>(10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.220 -0500", hash_original_field = "D9EFCC410410EC7544B85A023A6CAB69", hash_generated_field = "8066102F970313958E622F86A17AE18D")

    private static final HashMap<String, ObjectIdentifier> KNOWN_NAMES
            = new HashMap<String, ObjectIdentifier>(30);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.224 -0500", hash_original_field = "456063591053670D4BF8C85065C279FC", hash_generated_field = "EF00B04823B98540169FF1AB7F4513ED")

    private static final HashMap<String, ObjectIdentifier> RFC2253_NAMES
            = new HashMap<String, ObjectIdentifier>(10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.229 -0500", hash_original_field = "5FB2070C37FE434F661BA9AD5A5684A5", hash_generated_field = "D6C412F713A28CD3973BFEED8B39D464")

    private static final HashMap<String, ObjectIdentifier> RFC2459_NAMES
            = new HashMap<String, ObjectIdentifier>(10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.233 -0500", hash_original_field = "C6CD9A4D86DBEA00D00AC9C96ED9F4C3", hash_generated_field = "8CB088E05D348A8F09614B48F4BF38BA")

    private static final ObjectIdentifier C
            = new ObjectIdentifier(new int[] { 2, 5, 4, 6 }, "C", RFC1779_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.237 -0500", hash_original_field = "82AEBF2F8991357FC787250BC59E79B7", hash_generated_field = "62019E46EE850D23270F9E3DC652B5CE")

    private static final ObjectIdentifier CN
            = new ObjectIdentifier(new int[] { 2, 5, 4, 3 }, "CN", RFC1779_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.241 -0500", hash_original_field = "26CB62F2F1A5E0415989EDB20E68045A", hash_generated_field = "E89A0D43336082D6B88BB1634AA2C65A")

    private static final ObjectIdentifier DC = new ObjectIdentifier(
            new int[] { 0, 9, 2342, 19200300, 100, 1, 25 }, "DC", RFC2253_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.245 -0500", hash_original_field = "2450F51303494C0D530A73B8E9C21A9A", hash_generated_field = "4206325E209BCC75E8D09F6566439C1E")

    private static final ObjectIdentifier DNQ
            = new ObjectIdentifier(new int[] { 2, 5, 4, 46 }, "DNQ", RFC2459_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.249 -0500", hash_original_field = "328C2184289264351D05B861768AE32B", hash_generated_field = "188B912ADB054B566A701AFA00C51543")

    private static final ObjectIdentifier DNQUALIFIER
            = new ObjectIdentifier(new int[] { 2, 5, 4, 46 }, "DNQUALIFIER", RFC2459_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.253 -0500", hash_original_field = "0ECACBDF3ED551EA32197932D01392D7", hash_generated_field = "ECF87076C29754CD3A47D1F600E03D36")

    private static final ObjectIdentifier EMAILADDRESS = new ObjectIdentifier(
            new int[] { 1, 2, 840, 113549, 1, 9, 1}, "EMAILADDRESS", RFC2459_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.257 -0500", hash_original_field = "CEDBF57C6F2EEB472958013EC124CA20", hash_generated_field = "89E386C4E13C2710860B9E2B4D58F012")

    private static final ObjectIdentifier GENERATION
            = new ObjectIdentifier(new int[] { 2, 5, 4, 44 }, "GENERATION", RFC2459_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.261 -0500", hash_original_field = "CDB77315077E4779CA2E8FE7A1AE82D6", hash_generated_field = "FECEA0BD201D269BBB53725DB5B9838E")

    private static final ObjectIdentifier GIVENNAME
            = new ObjectIdentifier(new int[] { 2, 5, 4, 42 }, "GIVENNAME", RFC2459_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.265 -0500", hash_original_field = "DF6DF77952DA218FD1231AA2FD3262AD", hash_generated_field = "1D557C1E8E06306A4E0632901015C2C0")

    private static final ObjectIdentifier INITIALS
            = new ObjectIdentifier(new int[] { 2, 5, 4, 43 }, "INITIALS", RFC2459_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.269 -0500", hash_original_field = "D5EBEC7B94B59492DACB7C375E9C49BB", hash_generated_field = "6BA6F2EA3D1BBB84B8BF35E1E59C76C9")

    private static final ObjectIdentifier L
            = new ObjectIdentifier(new int[] { 2, 5, 4, 7 }, "L", RFC1779_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.273 -0500", hash_original_field = "9F1B0BF363E021281C31A9DD3D6075C3", hash_generated_field = "FF0191CC096C1961ACFBE7F14EF0EC1E")

    private static final ObjectIdentifier O
            = new ObjectIdentifier(new int[] { 2, 5, 4, 10 }, "O", RFC1779_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.276 -0500", hash_original_field = "E174C90C557CE08E1D5F8ABE4E168E38", hash_generated_field = "D0C255D53E24FFD7ED03EB524107F518")

    private static final ObjectIdentifier OU
            = new ObjectIdentifier(new int[] { 2, 5, 4, 11 }, "OU", RFC1779_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.281 -0500", hash_original_field = "962442119729E22F3C8DAD9A87FD236E", hash_generated_field = "4B5476A6E7F002FA4498E2B57B02FA56")

    private static final ObjectIdentifier SERIALNUMBER
            = new ObjectIdentifier(new int[] { 2, 5, 4, 5 }, "SERIALNUMBER", RFC2459_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.284 -0500", hash_original_field = "2487C009A85FD1E474DB892AC325C9B8", hash_generated_field = "F49BCBBFE38E5E8659597739D8D96955")

    private static final ObjectIdentifier ST
            = new ObjectIdentifier(new int[] { 2, 5, 4, 8 }, "ST", RFC1779_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.288 -0500", hash_original_field = "A9D5CCC8BAB9DD0E577E406817A4201C", hash_generated_field = "3DE3D60B4A41F406FFF34CD8BE6C0C4D")

    private static final ObjectIdentifier STREET
            = new ObjectIdentifier(new int[] { 2, 5, 4, 9 }, "STREET", RFC1779_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.292 -0500", hash_original_field = "83FD6A748F12F0832AB27CA74E1DBAB7", hash_generated_field = "939200CC1A97087F817576C7C025D9D6")

    private static final ObjectIdentifier SURNAME
            = new ObjectIdentifier(new int[] { 2, 5, 4, 4 }, "SURNAME", RFC2459_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.297 -0500", hash_original_field = "A29BC2DA31AC156B66DC4278056FF08B", hash_generated_field = "997CD818EEB2AE6309709767B20EB267")

    private static final ObjectIdentifier T
            = new ObjectIdentifier(new int[] { 2, 5, 4, 12 }, "T", RFC2459_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.301 -0500", hash_original_field = "3BA3D14F2BDF5C624075ECCF71804379", hash_generated_field = "EE00D14202867529C037600B0E0A0159")

    private static final ObjectIdentifier UID = new ObjectIdentifier(
            new int[]{ 0, 9, 2342, 19200300, 100, 1, 1 }, "UID", RFC2253_NAMES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.304 -0500", hash_original_field = "2625278C87E2DCD19FC4AF4501288607", hash_generated_field = "D1143EB3F5AB2EA1D8FE8AB241E7C1A7")

    private static final int CAPACITY = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.308 -0500", hash_original_field = "EF3B102BE0ABDC78921BA3B5AA46C75F", hash_generated_field = "70468A6CBECF0AAF7AB8398F9B18D4C4")

    private static final int SIZE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.312 -0500", hash_original_field = "09B62EFD97CA9862BC547BDD0B1AEB22", hash_generated_field = "C6E5CDF5F54C03C730B88D808733A92F")

    private static final ObjectIdentifier[][] KNOWN_OIDS = new ObjectIdentifier[SIZE][CAPACITY];
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.518 -0400", hash_original_field = "D4833F66C11E12436FE13D081F4B6A4B", hash_generated_field = "ACD1F0C015E6FEB6E7B03425C7BFACF0")

    public static final ASN1Type attributeValue = new ASN1Type(ASN1Constants.TAG_PRINTABLESTRING) {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.343 -0500", hash_original_method = "0E705085A9B1D73F25D30FC4A7DB73D9", hash_generated_method = "4A1E423FEDE7C14FE65C3996F1372E11")
        
public boolean checkTag(int tag) {
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.347 -0500", hash_original_method = "47B9DE0A06449E5D837276EC22B3F0E8", hash_generated_method = "4706185B32D0AB80A7CA4C86EA7DFEBB")
        
public Object decode(BerInputStream in) throws IOException {
            // FIXME what about constr???
            String str = null;
            if (DirectoryString.ASN1.checkTag(in.tag)) {
                // has string representation
                str = (String) DirectoryString.ASN1.decode(in);
            } else {
                // gets octets only
                in.readContent();
            }

            byte[] bytesEncoded = new byte[in.getOffset() - in.getTagOffset()];
            System.arraycopy(in.getBuffer(), in.getTagOffset(), bytesEncoded,
                    0, bytesEncoded.length);

            return new AttributeValue(str, bytesEncoded, in.tag);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.351 -0500", hash_original_method = "7DF56D76B0B7364F01AC493B84727F79", hash_generated_method = "995C5EF05C5ED12603776BEE26B568DD")
        
@Override public Object getDecodedObject(BerInputStream in) throws IOException {
            // stub to avoid wrong decoder usage
            throw new RuntimeException("AttributeValue getDecodedObject MUST NOT be invoked");
        }

        //
        // Encode
        //
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.356 -0500", hash_original_method = "BE595AA7EBC46615F96838D06A8BB9E6", hash_generated_method = "7F2C8FBB675F0DF592949387C0377532")
        
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

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.361 -0500", hash_original_method = "23586BD12951670B298A785C71BB9FF4", hash_generated_method = "ACBCC99F666986B6AF7AB3F9537C495D")
        
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.365 -0500", hash_original_method = "1D8F631AE92C0A1AA4D055920CF0287B", hash_generated_method = "373B8C2B09AFF2821F9426B3446F0E7D")
        
public void encodeContent(BerOutputStream out) {
            // stub to avoid wrong encoder usage
            throw new RuntimeException("AttributeValue encodeContent MUST NOT be invoked");
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.369 -0500", hash_original_method = "BC25F25AEFB600C56F14C45BC364CF5C", hash_generated_method = "823D9FCC8D10C74BCE74958C343D4FC1")
        
@Override public int getEncodedLength(BerOutputStream out) { //FIXME name
            AttributeValue av = (AttributeValue) out.content;
            if (av.encoded != null) {
                return out.length;
            } else {
                return super.getEncodedLength(out);
            }
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.518 -0400", hash_original_field = "9892E1681AC4411F169704812D66E8F6", hash_generated_field = "FEE5174CB85B698A746B4AA7D266C177")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Oid.getInstance(), attributeValue }) {

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.380 -0500", hash_original_method = "D8107E6357EFE36630D3CBCE737F6259", hash_generated_method = "2FA6C59B2B9119548883FDA128E87FC3")
        
@Override protected Object getDecodedObject(BerInputStream in) throws IOException {
            Object[] values = (Object[]) in.content;
            return new AttributeTypeAndValue((int[]) values[0], (AttributeValue) values[1]);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.384 -0500", hash_original_method = "63A50B62635E4187659C3BDD7CE857B1", hash_generated_method = "175ACDA24D9DCFA834A829B64E163A19")
        
@Override protected void getValues(Object object, Object[] values) {
            AttributeTypeAndValue atav = (AttributeTypeAndValue) object;
            values[0] = atav.oid.getOid();
            values[1] = atav.value;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.317 -0500", hash_original_field = "794BB2E15805CC7F48AFFECC7F6B34CC", hash_generated_field = "8882A462AEDA287957EC397E85D609FD")

    private  ObjectIdentifier oid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.321 -0500", hash_original_field = "92F2E406F79FFD9F26E7D286CDB7138F", hash_generated_field = "4F163C427394BA0FF5E07FEF103C118C")

    private  AttributeValue value;

    // for decoder only
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.325 -0500", hash_original_method = "6EC11ED1743D72D03D153EE3955FA226", hash_generated_method = "D3248DE04962BAD63BCFA76115DC7F20")
    
private AttributeTypeAndValue(int[] oid, AttributeValue value) throws IOException {
        ObjectIdentifier thisOid = getOID(oid);
        if (thisOid == null) {
            thisOid = new ObjectIdentifier(oid);
        }
        this.oid = thisOid;
        this.value = value;
    }

    /**
     * Creates AttributeTypeAndValue with OID and AttributeValue. Parses OID
     * string representation
     *
     * @param sOid
     *            string representation of OID
     * @param value
     *            attribute value
     * @throws IOException
     *             if OID can not be created from its string representation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.329 -0500", hash_original_method = "C6730356D790440CF3C53B1796ADEA2C", hash_generated_method = "0CAD47B083AF93FFE9E90E4101142A11")
    
public AttributeTypeAndValue(String sOid, AttributeValue value) throws IOException {
        if (sOid.charAt(0) >= '0' && sOid.charAt(0) <= '9') {
            int[] array = org.apache.harmony.security.asn1.ObjectIdentifier.toIntArray(sOid);
            ObjectIdentifier thisOid = getOID(array);
            if (thisOid == null) {
                thisOid = new ObjectIdentifier(array);
            }
            this.oid = thisOid;

        } else {
            this.oid = KNOWN_NAMES.get(sOid.toUpperCase(Locale.US));
            if (this.oid == null) {
                throw new IOException("Unrecognizable attribute name: " + sOid);
            }
        }
        this.value = value;
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

    /**
     * Appends AttributeTypeAndValue string representation
     *
     * @param attrFormat - format of DN
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.333 -0500", hash_original_method = "296A7913293032A81F372D58309D975C", hash_generated_method = "2DCFB75665D03A476E8B08961103B604")
    
public void appendName(String attrFormat, StringBuilder sb) {
        boolean hexFormat = false;
        if (X500Principal.RFC1779.equals(attrFormat)) {
            if (RFC1779_NAMES == oid.getGroup()) {
                sb.append(oid.getName());
            } else {
                sb.append(oid.toOIDString());
            }

            sb.append('=');
            if (value.escapedString == value.getHexString()) {
                sb.append(value.getHexString().toUpperCase(Locale.US));
            } else if (value.escapedString.length() != value.rawString.length()) {
                // was escaped
                value.appendQEString(sb);
            } else {
                sb.append(value.escapedString);
            }
        } else {
            Object group = oid.getGroup();
            // RFC2253 includes names from RFC1779
            if (RFC1779_NAMES == group || RFC2253_NAMES == group) {
                sb.append(oid.getName());

                if (X500Principal.CANONICAL.equals(attrFormat)) {
                    // only PrintableString and UTF8String in string format
                    // all others are output in hex format
                    // no hex for teletex; see http://b/2102191
                    int tag = value.getTag();
                    if (!ASN1StringType.UTF8STRING.checkTag(tag)
                            && !ASN1StringType.PRINTABLESTRING.checkTag(tag)
                            && !ASN1StringType.TELETEXSTRING.checkTag(tag)) {
                        hexFormat = true;
                    }
                }

            } else {
                sb.append(oid.toString());
                hexFormat = true;
            }

            sb.append('=');

            if (hexFormat) {
                sb.append(value.getHexString());
            } else {
                if (X500Principal.CANONICAL.equals(attrFormat)) {
                    sb.append(value.makeCanonical());
                } else {
                    sb.append(value.escapedString);
                }
            }
        }
    }

    /**
     * Gets type of the AttributeTypeAndValue
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.338 -0500", hash_original_method = "FA85FF96313B2EEDB4486C871DCE0458", hash_generated_method = "978C1306EB6EC4C023A636CD52F4898F")
    
public ObjectIdentifier getType() {
        return oid;
    }
    // orphaned legacy method
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
    
    // orphaned legacy method
    public boolean checkTag(int tag) {
            return true;
        }
    
    // orphaned legacy method
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
    
    // orphaned legacy method
    public void encodeContent(BerOutputStream out) {
            
            throw new RuntimeException("AttributeValue encodeContent MUST NOT be invoked");
        }
    
}

