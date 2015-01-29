package javax.security.auth.x500;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.Principal;
import java.util.Map;

import org.apache.harmony.security.x501.Name;

public final class X500Principal implements Serializable, Principal {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.456 -0500", hash_original_field = "00E4E4A5959D860DD5AF1B3E3F0EC680", hash_generated_field = "26CAD3B6FC0EACF2E9B47D2D50E32979")

    private static final long serialVersionUID = -500463348111345721L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.458 -0500", hash_original_field = "8E3026356C6F229C5422E761DC5AFAC7", hash_generated_field = "82CE65EBAABC70666F50B8A10883BA7F")

    public static final String CANONICAL = "CANONICAL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.461 -0500", hash_original_field = "DBB8092656BB486E2BBB8FA44A908245", hash_generated_field = "DBAC8AB28BADF6FBFEEA44C4163EFD9F")

    public static final String RFC1779 = "RFC1779";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.463 -0500", hash_original_field = "3B11DAF8B0D67A99F3F6029EBC147902", hash_generated_field = "C120F901C78A5D9CE52D3BC1A7B434D8")

    public static final String RFC2253 = "RFC2253";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.466 -0500", hash_original_field = "A0C5DA2FB4B0C8D039D936457DC0FA73", hash_generated_field = "CFC846905F9BAB769B1824279452E9D4")

    private transient Name dn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.483 -0500", hash_original_field = "232080F63068CCD875338225CCA78208", hash_generated_field = "6B8880E941EC803BC6CC2DFD6A5E024B")

    private transient String canonicalName;

    /**
     * Creates a new X500Principal from a given ASN.1 DER encoding of a
     * distinguished name.
     *
     * @param name
     *            the ASN.1 DER-encoded distinguished name
     *
     * @throws IllegalArgumentException
     *             if the ASN.1 DER-encoded distinguished name is incorrect
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.468 -0500", hash_original_method = "A3047134DA2BBFDCD9EABEAC496A6A0D", hash_generated_method = "F536D3834BA3A1966C0D2AEDA6B38E1F")
    
public X500Principal(byte[] name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        try {
            // FIXME dn = new Name(name);
            dn = (Name) Name.ASN1.decode(name);
        } catch (IOException e) {
            throw incorrectInputEncoding(e);
        }
    }

    /**
     * Creates a new X500Principal from a given ASN.1 DER encoding of a
     * distinguished name.
     *
     * @param in
     *            an {@code InputStream} holding the ASN.1 DER-encoded
     *            distinguished name
     *
     * @throws IllegalArgumentException
     *             if the ASN.1 DER-encoded distinguished name is incorrect
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.471 -0500", hash_original_method = "BF19E6A321D84C3196CD725DF225766B", hash_generated_method = "89BB4FA4A2363FF867FF7FCF5DE0D0FA")
    
public X500Principal(InputStream in) {
        if (in == null) {
            throw new NullPointerException("in == null");
        }
        try {
            // FIXME dn = new Name(is);
            dn = (Name) Name.ASN1.decode(in);
        } catch (IOException e) {
            throw incorrectInputEncoding(e);
        }
    }

    /**
     * Creates a new X500Principal from a string representation of a
     * distinguished name.
     *
     * @param name
     *            the string representation of the distinguished name
     *
     * @throws IllegalArgumentException
     *             if the string representation of the distinguished name is
     *             incorrect
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.476 -0500", hash_original_method = "4B12F08D986FED39E34C8D26B1B878DE", hash_generated_method = "3D502F2D233A6F112E67770D12130E4A")
    
public X500Principal(String name) {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }
        try {
            dn = new Name(name);
        } catch (IOException e) {
            throw incorrectInputName(e, name);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.478 -0500", hash_original_method = "2009C8B3D7F2D72E316D77325E1D8621", hash_generated_method = "BEFEAFA7F75DABF510947C40F40FF752")
    
public X500Principal(String name, Map<String,String> keywordMap){
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }
        try {
            dn = new Name(substituteNameFromMap(name, keywordMap));
        } catch (IOException e) {
            throw incorrectInputName(e, name);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.473 -0500", hash_original_method = "9E8384C79D62223409840D75AB5AB58E", hash_generated_method = "AEA0F5E8599DEECC5DC2E48F8246FB22")
    
private IllegalArgumentException incorrectInputEncoding(IOException e) {
        IllegalArgumentException iae = new IllegalArgumentException("Incorrect input encoding");
        iae.initCause(e);
        throw iae;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.481 -0500", hash_original_method = "6436965683334E035C1CE670538AE7C6", hash_generated_method = "AE34CECE39AD5164D7DD93651AA682A2")
    
private IllegalArgumentException incorrectInputName(IOException e, String name) {
        IllegalArgumentException iae = new IllegalArgumentException("Incorrect input name:" + name);
        iae.initCause(e);
        throw iae;
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.486 -0500", hash_original_method = "4587ED52F7AA726C7418DB94B8315A23", hash_generated_method = "852B9C78EAF841C5A0B6634DA8FB4360")
    
private synchronized String getCanonicalName() {
        if (canonicalName == null) {
            canonicalName = dn.getName(CANONICAL);
        }
        return canonicalName;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.488 -0500", hash_original_method = "16164FE0EFFEA9276C58202163E56457", hash_generated_method = "21976A464F3BC3943AB2078CCE99F2EE")
    
@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        X500Principal principal = (X500Principal) o;
        return getCanonicalName().equals(principal.getCanonicalName());
    }

    /**
     * Returns an ASN.1 DER-encoded representation of the distinguished name
     * contained in this X.500 principal.
     *
     * @return the ASN.1 DER-encoded representation
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.491 -0500", hash_original_method = "0D44433D57FF4BE42B367E2D93A9CEDF", hash_generated_method = "96B69107316F2A8A7D472BC1D950A6AE")
    
public byte[] getEncoded() {
        byte[] src = dn.getEncoded();
        byte[] dst = new byte[src.length];
        System.arraycopy(src, 0, dst, 0, dst.length);
        return dst;
    }

    /**
     * Returns a human-readable string representation of the distinguished name
     * contained in this X.500 principal.
     *
     * @return the string representation
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.493 -0500", hash_original_method = "2BCB4CFF6EEF485C6E2E6569B64BAD8B", hash_generated_method = "116942470DF5577D36E8CF2EA652C6BB")
    
public String getName() {
        return dn.getName(RFC2253);
    }

    /**
     * Returns a string representation of the distinguished name contained in
     * this X.500 principal. The format of the representation can be chosen.
     * Valid arguments are {@link #RFC1779}, {@link #RFC2253}, and
     * {@link #CANONICAL}. The representations are specified in RFC 1779 and RFC
     * 2253, respectively. The canonical form is based on RFC 2253, but adds
     * some canonicalizing operations like removing leading and trailing
     * whitespace, lower-casing the whole name, and bringing it into a
     * normalized Unicode representation.
     *
     * @param format
     *            the name of the format to use for the representation
     *
     * @return the string representation
     *
     * @throws IllegalArgumentException
     *             if the {@code format} argument is not one of the three
     *             mentioned above
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.495 -0500", hash_original_method = "DC6B95F939C1817F13ECF66B400795F1", hash_generated_method = "E5CA5985425CFE5E803F2C51ECF2A19A")
    
public String getName(String format) {
        if (CANONICAL.equals(format)) {
            return getCanonicalName();
        }

        return dn.getName(format);
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.499 -0500", hash_original_method = "F26EAC27584EEA69A397CAF64D802897", hash_generated_method = "94B75119BBA3F618CC044E59DBDD08DE")
    
public String getName(String format, Map<String, String> oidMap) {
        String rfc1779Name = dn.getName(RFC1779);
        String rfc2253Name = dn.getName(RFC2253);

        if (format.equalsIgnoreCase("RFC1779")) {
            StringBuilder resultName = new StringBuilder(rfc1779Name);
            int fromIndex = resultName.length();
            int equalIndex = -1;
            while (-1 != (equalIndex = resultName.lastIndexOf("=", fromIndex))) {
                int commaIndex = resultName.lastIndexOf(",", equalIndex);
                String subName = resultName.substring(commaIndex + 1,
                        equalIndex).trim();
                if (subName.length() > 4
                        && subName.substring(0, 4).equals("OID.")) {
                    String subSubName = subName.substring(4);
                    if (oidMap.containsKey(subSubName)) {
                        String replaceName = oidMap.get(subSubName);
                        if(commaIndex > 0) replaceName = " " + replaceName;
                        resultName.replace(commaIndex + 1, equalIndex, replaceName);
                    }
                }
                fromIndex = commaIndex;
            }
            return resultName.toString();
        } else if (format.equalsIgnoreCase("RFC2253")) {
            StringBuilder resultName = new StringBuilder(rfc2253Name);
            StringBuilder subsidyName = new StringBuilder(rfc1779Name);

            int fromIndex = resultName.length();
            int subsidyFromIndex = subsidyName.length();
            int equalIndex = -1;
            int subsidyEqualIndex = -1;
            while (-1 != (equalIndex = resultName.lastIndexOf("=", fromIndex))) {
                subsidyEqualIndex = subsidyName.lastIndexOf("=",
                        subsidyFromIndex);
                int commaIndex = resultName.lastIndexOf(",", equalIndex);
                String subName = resultName.substring(commaIndex + 1,
                        equalIndex).trim();
                if (oidMap.containsKey(subName)) {
                    int subOrignalEndIndex = resultName
                            .indexOf(",", equalIndex);
                    if (subOrignalEndIndex == -1)
                        subOrignalEndIndex = resultName.length();
                    int subGoalEndIndex = subsidyName.indexOf(",",
                            subsidyEqualIndex);
                    if (subGoalEndIndex == -1)
                        subGoalEndIndex = subsidyName.length();
                    resultName.replace(equalIndex + 1, subOrignalEndIndex,
                            subsidyName.substring(subsidyEqualIndex + 1,
                                    subGoalEndIndex));
                    resultName.replace(commaIndex + 1, equalIndex, oidMap
                            .get(subName));
                }
                fromIndex = commaIndex;
                subsidyFromIndex = subsidyEqualIndex - 1;
            }
            return resultName.toString();
        } else {
            throw new IllegalArgumentException("invalid format specified: " + format);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.501 -0500", hash_original_method = "4EF4800FE4F6884E38EE2C97450FA744", hash_generated_method = "3A88B40C0022DC27EB5CA08AAE93161F")
    
@Override
    public int hashCode() {
        return getCanonicalName().hashCode();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.503 -0500", hash_original_method = "FEC69921702EBFC3E3DC123C0BE46430", hash_generated_method = "14F925DECB3B9A5B93DB0759A2B51321")
    
@Override
    public String toString() {
        return dn.getName(RFC1779);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.506 -0500", hash_original_method = "11CA04BE900A069B4C6C484CD5BEB982", hash_generated_method = "6F4A84C0992D05135498066119F614D0")
    
private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(dn.getEncoded());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.508 -0500", hash_original_method = "8759D8976B48D4CB6209F3200BF3598B", hash_generated_method = "861E36731E7A5E3C87A1D703DF85C9CF")
    
private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        dn = (Name) Name.ASN1.decode((byte[]) in.readObject());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.511 -0500", hash_original_method = "84EFD5BFB0134499160A2521897988D3", hash_generated_method = "2DD43C54293F4296C923660BF90BAEA9")
    
private String substituteNameFromMap(String name, Map<String, String> keywordMap) {
        StringBuilder sbName = new StringBuilder(name);
        int fromIndex = sbName.length();
        int equalIndex;
        while (-1 != (equalIndex = sbName.lastIndexOf("=", fromIndex))) {
            int commaIndex = sbName.lastIndexOf(",", equalIndex);
            String subName = sbName.substring(commaIndex + 1, equalIndex).trim();
            if (keywordMap.containsKey(subName)) {
                sbName.replace(commaIndex + 1, equalIndex, keywordMap.get(subName));
            }
            fromIndex = commaIndex;
        }
        return sbName.toString();
    }
}

