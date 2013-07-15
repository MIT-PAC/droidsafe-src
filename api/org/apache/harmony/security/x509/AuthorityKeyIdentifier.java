package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.math.BigInteger;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.utils.Array;

public final class AuthorityKeyIdentifier extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.694 -0400", hash_original_field = "9F0DD5628B477CA3A412BD884083C065", hash_generated_field = "8624F6D40EA85567CEFE871C2375AD75")

    private byte[] keyIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.694 -0400", hash_original_field = "AE001176BDF9EAFDDC47A63363932B67", hash_generated_field = "AB8260635016A24FB1B26F25A3A14544")

    private GeneralNames authorityCertIssuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.694 -0400", hash_original_field = "4FD60441A1D09E46D70FB64E3DC2948C", hash_generated_field = "FE603145245634792C066DB175A3D8A0")

    private BigInteger authorityCertSerialNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.695 -0400", hash_original_method = "5D5E1041410A971B297479A3E9285379", hash_generated_method = "9AA133B7694427BFE4C2E449B4FADBE5")
    public  AuthorityKeyIdentifier(byte[] keyIdentifier,
            GeneralNames authorityCertIssuer,
            BigInteger authorityCertSerialNumber) {
        this.keyIdentifier = keyIdentifier;
        this.authorityCertIssuer = authorityCertIssuer;
        this.authorityCertSerialNumber = authorityCertSerialNumber;
        // ---------- Original Method ----------
        //this.keyIdentifier = keyIdentifier;
        //this.authorityCertIssuer = authorityCertIssuer;
        //this.authorityCertSerialNumber = authorityCertSerialNumber;
    }

    
        public static AuthorityKeyIdentifier decode(byte[] encoding) throws IOException {
        AuthorityKeyIdentifier aki = (AuthorityKeyIdentifier) ASN1.decode(encoding);
        aki.encoding = encoding;
        return aki;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.695 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "403C4003C0C66D7CC58413CA92F04042")
    @Override
    public byte[] getEncoded() {
    if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_2093402963 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1654576466 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1654576466;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.695 -0400", hash_original_method = "8E2FBEC1389F8AD5C10937DA32053F15", hash_generated_method = "837728F7EE4D5A0D0FCD5C67A7236EC6")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix).append("AuthorityKeyIdentifier [\n");
    if(keyIdentifier != null)        
        {
            sb.append(prefix).append("  keyIdentifier:\n");
            sb.append(Array.toString(keyIdentifier, prefix + "    "));
        } //End block
    if(authorityCertIssuer != null)        
        {
            sb.append(prefix).append("  authorityCertIssuer: [\n");
            authorityCertIssuer.dumpValue(sb, prefix + "    ");
            sb.append(prefix).append("  ]\n");
        } //End block
    if(authorityCertSerialNumber != null)        
        {
            sb.append(prefix).append("  authorityCertSerialNumber: ");
            sb.append(authorityCertSerialNumber).append('\n');
        } //End block
        sb.append(prefix).append("]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append("AuthorityKeyIdentifier [\n");
        //if (keyIdentifier != null) {
            //sb.append(prefix).append("  keyIdentifier:\n");
            //sb.append(Array.toString(keyIdentifier, prefix + "    "));
        //}
        //if (authorityCertIssuer != null) {
            //sb.append(prefix).append("  authorityCertIssuer: [\n");
            //authorityCertIssuer.dumpValue(sb, prefix + "    ");
            //sb.append(prefix).append("  ]\n");
        //}
        //if (authorityCertSerialNumber != null) {
            //sb.append(prefix).append("  authorityCertSerialNumber: ");
            //sb.append(authorityCertSerialNumber).append('\n');
        //}
        //sb.append(prefix).append("]\n");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.696 -0400", hash_original_field = "614641B23F87DF30A1DD861AAD515E47", hash_generated_field = "E137446FB1207E7CEC699888878370F5")

    public static final ASN1Type ASN1 = new ASN1Sequence(
            new ASN1Type[] {
                new ASN1Implicit(0, ASN1OctetString.getInstance()),
                new ASN1Implicit(1, GeneralNames.ASN1),
                new ASN1Implicit(2, ASN1Integer.getInstance()),
            }) {
        {
            setOptional(0);
            setOptional(1);
            setOptional(2);
        }

        @Override protected Object getDecodedObject(BerInputStream in) throws IOException {
            Object[] values = (Object[]) in.content;

            byte[] enc = (byte[]) values[2];
            BigInteger authorityCertSerialNumber = null;
            if (enc != null) {
                authorityCertSerialNumber = new BigInteger(enc);
            }

            return new AuthorityKeyIdentifier((byte[]) values[0],
                    (GeneralNames) values[1], authorityCertSerialNumber);
        }

        @Override protected void getValues(Object object, Object[] values) {
            AuthorityKeyIdentifier akid = (AuthorityKeyIdentifier) object;
            values[0] = akid.keyIdentifier;
            values[1] = akid.authorityCertIssuer;
            if (akid.authorityCertSerialNumber != null) {
                values[2] = akid.authorityCertSerialNumber.toByteArray();
            }
        }
    };
}

