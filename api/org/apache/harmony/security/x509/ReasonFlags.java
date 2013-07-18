package org.apache.harmony.security.x509;

// Droidsafe Imports
import java.io.IOException;

import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BerOutputStream;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class ReasonFlags {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.687 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "EDA6943CEE7FB962748614E813BD6977")

    private boolean[] flags;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.687 -0400", hash_original_method = "0723455182874DC076BEC16F53F1DAFE", hash_generated_method = "ACE7EB18781E115780B1426F26EFDD8E")
    public  ReasonFlags(boolean[] flags) {
        this.flags = flags;
        // ---------- Original Method ----------
        //this.flags = flags;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.688 -0400", hash_original_method = "4426D7C44C68FE2DDBEE0B08652B6069", hash_generated_method = "A270A8CE89307BF26CB2AB5C17A62AAE")
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix);
        sb.append("ReasonFlags [\n");
for(int i=0;i<flags.length;i++)
        {
            if(flags[i])            
            {
                sb.append(prefix).append("  ").append(REASONS[i]).append('\n');
            } //End block
        } //End block
        sb.append(prefix);
        sb.append("]\n");
        // ---------- Original Method ----------
        //sb.append(prefix);
        //sb.append("ReasonFlags [\n");
        //for (int i=0; i<flags.length; i++) {
            //if (flags[i]) {
                //sb.append(prefix).append("  ").append(REASONS[i]).append('\n');
            //}
        //}
        //sb.append(prefix);
        //sb.append("]\n");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.688 -0400", hash_original_field = "CDF089F9218B4B6ED828B2FB67D9A884", hash_generated_field = "348B9970CC87333497E0122E357CC7BA")

    static final String[] REASONS = {
        "unused",
        "keyCompromise",
        "cACompromise",
        "affiliationChanged",
        "superseded",
        "cessationOfOperation",
        "certificateHold",
        "privilegeWithdrawn",
        "aACompromise"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.689 -0400", hash_original_field = "57F71CEED326110CDAC13EC2F1222EE2", hash_generated_field = "9A6C9509CE1B547AF3B36185903C2664")

    public static final ASN1BitString ASN1 =
                            new ASN1BitString.ASN1NamedBitList(REASONS.length) {
        public Object getDecodedObject(BerInputStream in) throws IOException {
            return new ReasonFlags((boolean[]) super.getDecodedObject(in));
        }

        public void setEncodingContent(BerOutputStream out) {
            out.content = ((ReasonFlags) out.content).flags;
            super.setEncodingContent(out);
        }
    };
}

