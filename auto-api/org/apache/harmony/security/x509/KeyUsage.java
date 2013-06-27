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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.928 -0400", hash_original_field = "D5EDBDDB1AE6E3CE3EE0E039107E39E4", hash_generated_field = "C6468962076BC1172F0F351DE545D4EE")

    private boolean[] keyUsage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.928 -0400", hash_original_method = "DB6BBF789AE77B5AE6E5E06EC389C87F", hash_generated_method = "93E839BBB32F603F214F35D4E964F3AE")
    public  KeyUsage(byte[] encoding) throws IOException {
        super(encoding);
        this.keyUsage = (boolean[]) ASN1.decode(encoding);
        // ---------- Original Method ----------
        //this.keyUsage = (boolean[]) ASN1.decode(encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.929 -0400", hash_original_method = "14A58386ABBA8977CF43289C95A15404", hash_generated_method = "D521A4AF683F79966B213C76F393C036")
    public boolean[] getKeyUsage() {
        boolean[] var503EB2F420079C4024483971CE5EDEA8_390718540 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_390718540;
        // ---------- Original Method ----------
        //return keyUsage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.947 -0400", hash_original_method = "F00F1E8212387BCE78D166E85787DB94", hash_generated_method = "885AE5C69A6F86E03616CB51702048A5")
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(keyUsage);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_857251088 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_857251088;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(keyUsage);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.948 -0400", hash_original_method = "C3D25371DA677875302E0FC1058C6A6C", hash_generated_method = "C3158B1829BEA0A83D600794460BD0B1")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.948 -0400", hash_original_field = "702DDBA39271BC18146A500F7F424BBD", hash_generated_field = "6AD499FFA5C3C1E9235E8AF18478EC0B")

    private static String[] USAGES = {
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.948 -0400", hash_original_field = "5094F4CF60830A3061523AA234980FE6", hash_generated_field = "4E336C248C9B9DF474ABE0F95D68DA40")

    private static ASN1Type ASN1 = new ASN1BitString.ASN1NamedBitList(9);
}

