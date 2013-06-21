package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Type;

public final class KeyUsage extends ExtensionValue {
    private boolean[] keyUsage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.833 -0400", hash_original_method = "DB6BBF789AE77B5AE6E5E06EC389C87F", hash_generated_method = "DCBBAD75A3E32495B8D560C46A35B9FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyUsage(byte[] encoding) throws IOException {
        super(encoding);
        dsTaint.addTaint(encoding[0]);
        this.keyUsage = (boolean[]) ASN1.decode(encoding);
        // ---------- Original Method ----------
        //this.keyUsage = (boolean[]) ASN1.decode(encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.834 -0400", hash_original_method = "14A58386ABBA8977CF43289C95A15404", hash_generated_method = "78D42B9964C6EA45B3592B47D8C07EBA")
    @DSModeled(DSC.SAFE)
    public boolean[] getKeyUsage() {
        boolean[] retVal = new boolean[1];
        retVal[0] = dsTaint.getTaintBoolean();
        return retVal;
        // ---------- Original Method ----------
        //return keyUsage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.834 -0400", hash_original_method = "F00F1E8212387BCE78D166E85787DB94", hash_generated_method = "DC0562D48600C0122D2722BC6BB22EA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(keyUsage);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(keyUsage);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.834 -0400", hash_original_method = "C3D25371DA677875302E0FC1058C6A6C", hash_generated_method = "2E378C7816E0F28B3800E890DBC8562F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append("KeyUsage [\n");
        {
            int i;
            i = 0;
            {
                {
                    sb.append(prefix).append("  ").append(USAGES[i]).append('\n');
                } //End block
            } //End block
        } //End collapsed parenthetic
        sb.append(prefix).append("]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append("KeyUsage [\n");
        //for (int i = 0; i < keyUsage.length; i++) {
            //if (keyUsage[i]) {
                //sb.append(prefix).append("  ").append(USAGES[i]).append('\n');
            //}
        //}
        //sb.append(prefix).append("]\n");
    }

    
    private static final String[] USAGES = {
        "digitalSignature",
        "nonRepudiation",
        "keyEncipherment",
        "dataEncipherment",
        "keyAgreement",
        "keyCertSign",
        "cRLSign",
        "encipherOnly",
        "decipherOnly",
    };
    private static final ASN1Type ASN1 = new ASN1BitString.ASN1NamedBitList(9);
}

