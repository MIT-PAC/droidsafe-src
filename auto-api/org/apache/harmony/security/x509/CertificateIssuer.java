package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.Name;

public final class CertificateIssuer extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.485 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "30FEA84FB35EF28DB029D29044BA91EC")

    private X500Principal issuer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.491 -0400", hash_original_method = "DA4BDBC496D2A998B5C29C74B17A91EA", hash_generated_method = "45AD7D84F74F2142DA3FF47565C306EC")
    public  CertificateIssuer(byte[] encoding) {
        super(encoding);
        addTaint(encoding[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.492 -0400", hash_original_method = "A624F7DB93A0D045C3602F26988D09C5", hash_generated_method = "71F6B7D418810237ED6191D431283D06")
    public X500Principal getIssuer() throws IOException {
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_1930951000 = null; //Variable for return #1
        {
            issuer = (X500Principal) ASN1.decode(getEncoded());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1930951000 = issuer;
        varB4EAC82CA7396A68D541C85D26508E83_1930951000.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1930951000;
        // ---------- Original Method ----------
        //if (issuer == null) {
            //issuer = (X500Principal) ASN1.decode(getEncoded());
        //}
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.492 -0400", hash_original_method = "50826A9F4B6111EEE8495EBA7ED178B7", hash_generated_method = "E4759D7A5C40065FD80574D86B7EEF98")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Certificate Issuer: ");
        {
            try 
            {
                issuer = getIssuer();
            } //End block
            catch (IOException e)
            {
                sb.append("Unparseable (incorrect!) extension value:\n");
                super.dumpValue(sb);
            } //End block
        } //End block
        sb.append(issuer).append('\n');
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //sb.append(prefix).append("Certificate Issuer: ");
        //if (issuer == null) {
            //try {
                //issuer = getIssuer();
            //} catch (IOException e) {
                //sb.append("Unparseable (incorrect!) extension value:\n");
                //super.dumpValue(sb);
            //}
        //}
        //sb.append(issuer).append('\n');
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.493 -0400", hash_original_field = "26467BCE56C2E2E5052FBB838762A5FF", hash_generated_field = "FE3BF8D4A6349EB434E9E8BE6B183663")

    public static final ASN1Type ASN1 = new ASN1Sequence(new ASN1Type[] { GeneralName.ASN1 }) {
        @Override public Object getDecodedObject(BerInputStream in) {
            return ((Name) ((GeneralName) ((Object[]) in.content)[0])
                    .getName()).getX500Principal();
        }

        @Override protected void getValues(Object object, Object[] values) {
            values[0] = object;
        }
    };
}

