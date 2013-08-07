package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import javax.security.auth.x500.X500Principal;

import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.Name;




public final class CertificateIssuer extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.905 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "30FEA84FB35EF28DB029D29044BA91EC")

    private X500Principal issuer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.905 -0400", hash_original_method = "DA4BDBC496D2A998B5C29C74B17A91EA", hash_generated_method = "45AD7D84F74F2142DA3FF47565C306EC")
    public  CertificateIssuer(byte[] encoding) {
        super(encoding);
        addTaint(encoding[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.906 -0400", hash_original_method = "A624F7DB93A0D045C3602F26988D09C5", hash_generated_method = "CCC072B52FF88A9F691540B081DD31EF")
    public X500Principal getIssuer() throws IOException {
        if(issuer == null)        
        {
            issuer = (X500Principal) ASN1.decode(getEncoded());
        } //End block
X500Principal var8EF52627413B91AB97DB59853805E979_2078625217 =         issuer;
        var8EF52627413B91AB97DB59853805E979_2078625217.addTaint(taint);
        return var8EF52627413B91AB97DB59853805E979_2078625217;
        // ---------- Original Method ----------
        //if (issuer == null) {
            //issuer = (X500Principal) ASN1.decode(getEncoded());
        //}
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.906 -0400", hash_original_method = "50826A9F4B6111EEE8495EBA7ED178B7", hash_generated_method = "4BD4A8D1208955EF6674A3D57DCD77DE")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix).append("Certificate Issuer: ");
        if(issuer == null)        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.907 -0400", hash_original_field = "26467BCE56C2E2E5052FBB838762A5FF", hash_generated_field = "FE3BF8D4A6349EB434E9E8BE6B183663")

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

