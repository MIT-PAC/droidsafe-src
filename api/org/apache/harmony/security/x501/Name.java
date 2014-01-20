package org.apache.harmony.security.x501;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.388 -0500", hash_original_field = "E7AEB4B69F3F0B113B0771D3CC8C087B", hash_generated_field = "292A5C4C3AF0A6F5B034171E032DDEFA")

    public static final ASN1SetOf ASN1_RDN = new ASN1SetOf(
            AttributeTypeAndValue.ASN1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.757 -0400", hash_original_field = "8455297A18620927B582292F082B718B", hash_generated_field = "597EE65661FDE3B49FE8B0352BA399B9")

    public static final ASN1SequenceOf ASN1 = new ASN1SequenceOf(ASN1_RDN) {

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.391 -0500", hash_original_method = "AE12B5F4C720C4DD20E3FB3F6A6065AA", hash_generated_method = "EE3D2EDCF166EEA81DE3CFE1F7BB50EE")
        
public Object getDecodedObject(BerInputStream in) {
            return new Name((List<List<AttributeTypeAndValue>>) in.content);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.393 -0500", hash_original_method = "016399535C7822D693ADBCE49E7AA104", hash_generated_method = "624FBB7CDC759BB834C832F6B4D09013")
        
public Collection getValues(Object object) {
            return ((Name) object).rdn;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.358 -0500", hash_original_field = "B26EA4441AC976CE9D513DB2C8639526", hash_generated_field = "30CBCFF31EBF02BAF8CCE8746893E2BE")

    private volatile byte[] encoded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.360 -0500", hash_original_field = "30F59B17F4E3E2C15565B845F2B8585E", hash_generated_field = "E9B4D5E56AD2A3335D3949EE5A0BDAE4")

    private String rfc1779String;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.362 -0500", hash_original_field = "F049C683DF202E15932CB57E2D3DF046", hash_generated_field = "4EB0ACB941F165E12B4051EF94EDEC10")

    private String rfc2253String;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.365 -0500", hash_original_field = "D36960F05E8FF74E7043CB92DECCF5FF", hash_generated_field = "176833DBCE1C94B471D76BC4A5F6B374")

    private String canonicalString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.367 -0500", hash_original_field = "012D3A7AA6D3A8BD65CA2971458AA52E", hash_generated_field = "613FBB7F6EF0BF172336FED0F72DF53F")

    private List<List<AttributeTypeAndValue>> rdn;

    /**
     * Creates new <code>Name</code> instance from its DER encoding
     *
     * @param encoding - ASN.1 DER encoding
     * @throws IOException - if encoding is wrong
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.369 -0500", hash_original_method = "7EBA5C9ECD25887AF5B543E5839AFD7E", hash_generated_method = "3391E4ABB388AC16FD6FF8639A129B78")
    
public Name(byte[] encoding) throws IOException {
        DerInputStream in = new DerInputStream(encoding);

        if (in.getEndOffset() != encoding.length) {
            throw new IOException("Wrong content length");
        }

        ASN1.decode(in);

        this.rdn = (List<List<AttributeTypeAndValue>>) in.content;
    }

    /**
     * Creates new <code>Name</code> instance
     *
     * @param name - Name as String
     * @throws IOException - if string is wrong
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.373 -0500", hash_original_method = "C2DB210B9AE13E0849500530EB26AF9F", hash_generated_method = "148E380D1EF6B778045A602221D318B4")
    
public Name(String name) throws IOException {
        rdn = new DNParser(name).parse();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.375 -0500", hash_original_method = "31033A15DF0AC22272F2A1E0E5DFAD4C", hash_generated_method = "9E78C482BB5C208FA2EF04F47FDCC22E")
    
private Name(List<List<AttributeTypeAndValue>> rdn) {
        this.rdn = rdn;
    }

    /**
     * Returns <code>X500Principal</code> instance corresponding to this
     * <code>Name</code> instance
     *
     * @return equivalent X500Principal object
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.377 -0500", hash_original_method = "0542B71517FD35CAEA3075D7EB945221", hash_generated_method = "FACAF1712D8A1F2F2E6150BC234BD5E8")
    
public X500Principal getX500Principal(){
        return new X500Principal(getEncoded());
    }

    /**
     * Returns Relative Distinguished Name as <code>String</code> according
     * the format requested
     *
     * @param format one of X500Principal.CANONICAL, X500Principal.RFC1779, or
     *     X500Principal.RFC2253, case insensitive
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.380 -0500", hash_original_method = "5BEC09DB13BD8A96A72F05D9AA4FB5FA", hash_generated_method = "7E2085EC43237AA4D9771CF476A231D4")
    
public String getName(String format) {
        //
        // check X500Principal constants first
        //
        if (X500Principal.RFC1779.equals(format)) {

            if (rfc1779String == null) {
                rfc1779String = getName0(format);
            }
            return rfc1779String;

        } else if (X500Principal.RFC2253.equals(format)) {

            if (rfc2253String == null) {
                rfc2253String = getName0(format);
            }
            return rfc2253String;

        } else if (X500Principal.CANONICAL.equals(format)) {

            if (canonicalString == null) {
                canonicalString = getName0(format);
            }
            return canonicalString;

        }
        //
        // compare ignore case
        //
        else if (X500Principal.RFC1779.equalsIgnoreCase(format)) {

            if (rfc1779String == null) {
                rfc1779String = getName0(X500Principal.RFC1779);
            }
            return rfc1779String;

        } else if (X500Principal.RFC2253.equalsIgnoreCase(format)) {

            if (rfc2253String == null) {
                rfc2253String = getName0(X500Principal.RFC2253);
            }
            return rfc2253String;

        } else if (X500Principal.CANONICAL.equalsIgnoreCase(format)) {

            if (canonicalString == null) {
                canonicalString = getName0(X500Principal.CANONICAL);
            }
            return canonicalString;

        } else {
            throw new IllegalArgumentException("Illegal format: " + format);
        }
    }

    /**
     * Returns Relative Distinguished Name as <code>String</code> according
     * the format requested, format is int value
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.382 -0500", hash_original_method = "F650F61C4EF367763857B0C83C9384E7", hash_generated_method = "F2AD697B381CADF5E0DD2E6D3A8577EB")
    
private String getName0(String format) {
        StringBuilder name = new StringBuilder();

        // starting with the last element and moving to the first.
        for (int i = rdn.size() - 1; i >= 0; i--) {
            List<AttributeTypeAndValue> atavList = rdn.get(i);

            if (X500Principal.CANONICAL == format) {
                atavList = new ArrayList<AttributeTypeAndValue>(atavList);
                Collections.sort(atavList, new AttributeTypeAndValueComparator());
            }

            // Relative Distinguished Name to string
            Iterator<AttributeTypeAndValue> it = atavList.iterator();
            while (it.hasNext()) {
                AttributeTypeAndValue attributeTypeAndValue = it.next();
                attributeTypeAndValue.appendName(format, name);
                if (it.hasNext()) {
                    // multi-valued RDN
                    if (X500Principal.RFC1779 == format) {
                        name.append(" + ");
                    } else {
                        name.append('+');
                    }
                }
            }

            if (i != 0) {
                name.append(',');
                if (format == X500Principal.RFC1779) {
                    name.append(' ');
                }
            }
        }

        String sName = name.toString();
        if (X500Principal.CANONICAL.equals(format)) {
            sName = sName.toLowerCase(Locale.US);
        }
        return sName;
    }

    /**
     * Gets encoded form of DN
     *
     * @return return encoding, no copying is performed
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.385 -0500", hash_original_method = "2981EA1A601F56A7B701653790363606", hash_generated_method = "6169E38820F7CA96C774C4D5BCA28D6D")
    
public byte[] getEncoded() {
        if (encoded == null) {
            encoded = ASN1.encode(this);
        }
        return encoded;
    }
    // orphaned legacy method
    public Collection getValues(Object object) {
            return ((Name) object).rdn;
        }
    
    // orphaned legacy method
    public Object getDecodedObject(BerInputStream in) {
            return new Name((List<List<AttributeTypeAndValue>>) in.content);
        }
    
}

