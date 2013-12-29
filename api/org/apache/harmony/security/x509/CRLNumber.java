package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Type;






public final class CRLNumber extends ExtensionValue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:07.321 -0500", hash_original_field = "CC5D8764BBAD99198237F31D02B97898", hash_generated_field = "7B920D394449223FD2E6E364A4B27926")

    public static final ASN1Type ASN1 = ASN1Integer.getInstance();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:07.316 -0500", hash_original_field = "368C254C5AE70D812371AB837F173C30", hash_generated_field = "74AD3D429EE1BAEF847B6467FE79538D")

    private  BigInteger number;

    /**
     * Constructs the object on the base of its encoded form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:07.317 -0500", hash_original_method = "F2D26D3BB1859BB9D7AC567B8EA30F7D", hash_generated_method = "D63FC22CD5BA247533281126B37F5678")
    public CRLNumber(byte[] encoding) throws IOException {
        super(encoding);
        number = new BigInteger((byte[]) ASN1.decode(encoding));
    }

    /**
     * Returns the invalidity date.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:07.318 -0500", hash_original_method = "ABBA63B4278019F3F838A8B1357B04F0", hash_generated_method = "E37AC206F1FC9EAF282C8DCD0787C41D")
    public BigInteger getNumber() {
        return number;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 CRLNumber value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:07.319 -0500", hash_original_method = "264373D11CB6B7A95DC9A45E336ACDCB", hash_generated_method = "06E3593BD04818F66D486922BDEB8794")
    @Override
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(number.toByteArray());
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:07.320 -0500", hash_original_method = "C82E67A30D76F52198943C49A8E53C0F", hash_generated_method = "4DBCBD5E9954A0C1219BA485E58B0911")
    @Override
public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("CRL Number: [ ").append(number).append(" ]\n");
    }
}

