package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BerOutputStream;

public final class ReasonFlags {
    private boolean[] flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.914 -0400", hash_original_method = "0723455182874DC076BEC16F53F1DAFE", hash_generated_method = "4D9429C07F66C8934DB306C02A21D54F")
    @DSModeled(DSC.SAFE)
    public ReasonFlags(boolean[] flags) {
        dsTaint.addTaint(flags[0]);
        // ---------- Original Method ----------
        //this.flags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.914 -0400", hash_original_method = "4426D7C44C68FE2DDBEE0B08652B6069", hash_generated_method = "57FFA51A8B6B6E245AF38F420C76F2D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix);
        sb.append("ReasonFlags [\n");
        {
            int i;
            i = 0;
            {
                {
                    sb.append(prefix).append("  ").append(REASONS[i]).append('\n');
                } //End block
            } //End block
        } //End collapsed parenthetic
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
    public static final ASN1BitString ASN1 = new ASN1BitString.ASN1NamedBitList(REASONS.length) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.915 -0400", hash_original_method = "31573B2F4CCD62BF50FDA97899BAB266", hash_generated_method = "ABA59991DB5CD06E2D02DDD9EEE57E24")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object getDecodedObject(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            Object var6531413CB1648254E5CDFF596EFE3BD0_258776935 = (new ReasonFlags((boolean[]) super.getDecodedObject(in)));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ReasonFlags((boolean[]) super.getDecodedObject(in));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.915 -0400", hash_original_method = "7CAEE2990EB6DF6257751BA848966F42", hash_generated_method = "A5E591E9715FC8C855A76915BE325300")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setEncodingContent(BerOutputStream out) {
            dsTaint.addTaint(out.dsTaint);
            out.content = ((ReasonFlags) out.content).flags;
            super.setEncodingContent(out);
            // ---------- Original Method ----------
            //out.content = ((ReasonFlags) out.content).flags;
            //super.setEncodingContent(out);
        }

        
}; //Transformed anonymous class
}

