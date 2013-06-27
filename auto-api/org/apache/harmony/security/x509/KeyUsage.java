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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.018 -0400", hash_original_field = "D5EDBDDB1AE6E3CE3EE0E039107E39E4", hash_generated_field = "C6468962076BC1172F0F351DE545D4EE")

    private boolean[] keyUsage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.018 -0400", hash_original_method = "DB6BBF789AE77B5AE6E5E06EC389C87F", hash_generated_method = "93E839BBB32F603F214F35D4E964F3AE")
    public  KeyUsage(byte[] encoding) throws IOException {
        super(encoding);
        this.keyUsage = (boolean[]) ASN1.decode(encoding);
        // ---------- Original Method ----------
        //this.keyUsage = (boolean[]) ASN1.decode(encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.019 -0400", hash_original_method = "14A58386ABBA8977CF43289C95A15404", hash_generated_method = "307D37DBE2FA9C62D68E055C250EFDFE")
    public boolean[] getKeyUsage() {
        boolean[] var503EB2F420079C4024483971CE5EDEA8_2060727474 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_2060727474;
        // ---------- Original Method ----------
        //return keyUsage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.069 -0400", hash_original_method = "F00F1E8212387BCE78D166E85787DB94", hash_generated_method = "2F1141DD8741C7F9190FB44B8961DAB8")
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(keyUsage);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_989109581 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_989109581;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(keyUsage);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.070 -0400", hash_original_method = "C3D25371DA677875302E0FC1058C6A6C", hash_generated_method = "C3158B1829BEA0A83D600794460BD0B1")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
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
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //sb.append(prefix).append("KeyUsage [\n");
        //for (int i = 0; i < keyUsage.length; i++) {
            //if (keyUsage[i]) {
                //sb.append(prefix).append("  ").append(USAGES[i]).append('\n');
            //}
        //}
        //sb.append(prefix).append("]\n");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.070 -0400", hash_original_field = "702DDBA39271BC18146A500F7F424BBD", hash_generated_field = "61F05DECB6ABBAB12C74E3A9EC113EC9")

    private static String[] USAGES = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.070 -0400", hash_original_field = "5094F4CF60830A3061523AA234980FE6", hash_generated_field = "4E336C248C9B9DF474ABE0F95D68DA40")

    private static ASN1Type ASN1 = new ASN1BitString.ASN1NamedBitList(9);
}

