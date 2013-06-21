package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private byte[] keyIdentifier;
    private GeneralNames authorityCertIssuer;
    private BigInteger authorityCertSerialNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.542 -0400", hash_original_method = "5D5E1041410A971B297479A3E9285379", hash_generated_method = "1F686DFA81AEDE1213AD58A135CFEEC8")
    @DSModeled(DSC.SAFE)
    public AuthorityKeyIdentifier(byte[] keyIdentifier,
            GeneralNames authorityCertIssuer,
            BigInteger authorityCertSerialNumber) {
        dsTaint.addTaint(authorityCertIssuer.dsTaint);
        dsTaint.addTaint(authorityCertSerialNumber.dsTaint);
        dsTaint.addTaint(keyIdentifier[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.543 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "07B62BEE8032AB4E194FDF661E084439")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.543 -0400", hash_original_method = "8E2FBEC1389F8AD5C10937DA32053F15", hash_generated_method = "608607267EA40449CD7FE0CFEA82F8B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append("AuthorityKeyIdentifier [\n");
        {
            sb.append(prefix).append("  keyIdentifier:\n");
            sb.append(Array.toString(keyIdentifier, prefix + "    "));
        } //End block
        {
            sb.append(prefix).append("  authorityCertIssuer: [\n");
            authorityCertIssuer.dumpValue(sb, prefix + "    ");
            sb.append(prefix).append("  ]\n");
        } //End block
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

    
    public static final ASN1Type ASN1 = new ASN1Sequence(
            new ASN1Type[] {
                new ASN1Implicit(0, ASN1OctetString.getInstance()),
                new ASN1Implicit(1, GeneralNames.ASN1),
                new ASN1Implicit(2, ASN1Integer.getInstance()),
            }) {        {
            setOptional(0);
            setOptional(1);
            setOptional(2);
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.544 -0400", hash_original_method = "8440A55DE3509FBE8D7DFB533886663B", hash_generated_method = "3C6444F80EC5FD324FC055322641C04E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            byte[] enc;
            enc = (byte[]) values[2];
            BigInteger authorityCertSerialNumber;
            authorityCertSerialNumber = null;
            {
                authorityCertSerialNumber = new BigInteger(enc);
            } //End block
            Object varD8A888509548E1D9F4174FAD19C9BC22_853913681 = (new AuthorityKeyIdentifier((byte[]) values[0],
                    (GeneralNames) values[1], authorityCertSerialNumber));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //byte[] enc = (byte[]) values[2];
            //BigInteger authorityCertSerialNumber = null;
            //if (enc != null) {
                //authorityCertSerialNumber = new BigInteger(enc);
            //}
            //return new AuthorityKeyIdentifier((byte[]) values[0],
                    //(GeneralNames) values[1], authorityCertSerialNumber);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.544 -0400", hash_original_method = "060A82E416E41470B7568E6658017C0D", hash_generated_method = "BE5407E65EF48549866C0CB750377076")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            AuthorityKeyIdentifier akid;
            akid = (AuthorityKeyIdentifier) object;
            values[0] = akid.keyIdentifier;
            values[1] = akid.authorityCertIssuer;
            {
                values[2] = akid.authorityCertSerialNumber.toByteArray();
            } //End block
            // ---------- Original Method ----------
            //AuthorityKeyIdentifier akid = (AuthorityKeyIdentifier) object;
            //values[0] = akid.keyIdentifier;
            //values[1] = akid.authorityCertIssuer;
            //if (akid.authorityCertSerialNumber != null) {
                //values[2] = akid.authorityCertSerialNumber.toByteArray();
            //}
        }

        
}; //Transformed anonymous class
}

