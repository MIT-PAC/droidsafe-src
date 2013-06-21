package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class GeneralSubtree {
    private GeneralName base;
    private int minimum;
    private int maximum;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.795 -0400", hash_original_method = "438D69377D52986D40A8B5F5E96E3A6B", hash_generated_method = "B75584BA30FA7920DCBB6013B959AE91")
    @DSModeled(DSC.SAFE)
    public GeneralSubtree(GeneralName base, int minimum, int maximum) {
        dsTaint.addTaint(minimum);
        dsTaint.addTaint(maximum);
        dsTaint.addTaint(base.dsTaint);
        // ---------- Original Method ----------
        //this.base = base;
        //this.minimum = minimum;
        //this.maximum = maximum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.795 -0400", hash_original_method = "FBC8A3DE80F48DE1891C2D6208F82433", hash_generated_method = "236873BED25CBF71DD009E4E52BC5252")
    @DSModeled(DSC.SAFE)
    public GeneralName getBase() {
        return (GeneralName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return base;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.795 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.795 -0400", hash_original_method = "EBC343B993E4A537A05E52D600D1ECC2", hash_generated_method = "447E6D0D37B43209A876904A793ADBD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append("General Subtree: [\n");
        sb.append(prefix).append("  base: ").append(base).append('\n');
        sb.append(prefix).append("  minimum: ").append(minimum).append('\n');
        {
            sb.append(prefix).append("  maximum: ").append(maximum).append('\n');
        } //End block
        sb.append(prefix).append("]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append("General Subtree: [\n");
        //sb.append(prefix).append("  base: ").append(base).append('\n');
        //sb.append(prefix).append("  minimum: ").append(minimum).append('\n');
        //if (maximum >= 0) {
            //sb.append(prefix).append("  maximum: ").append(maximum).append('\n');
        //}
        //sb.append(prefix).append("]\n");
    }

    
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            GeneralName.ASN1,
            new ASN1Implicit(0, ASN1Integer.getInstance()),
            new ASN1Implicit(1, ASN1Integer.getInstance()) }) {        {
            setDefault(new byte[] {0}, 1);  
            setOptional(2);                 
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.796 -0400", hash_original_method = "2A7F97C8A163408D03702038DFF11AD2", hash_generated_method = "94A6AF08D12B5BBF65E73C92B7FAA394")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            int maximum;
            maximum = -1;
            {
                maximum = ASN1Integer.toIntValue(values[2]);
            } //End block
            Object varC4848D58C64E12E95DFA9D283F765716_1025766089 = (new GeneralSubtree((GeneralName) values[0],
                    ASN1Integer.toIntValue(values[1]),
                    maximum));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //int maximum = -1;
            //if (values[2] != null) {
                //maximum = ASN1Integer.toIntValue(values[2]); 
            //}
            //return new GeneralSubtree((GeneralName) values[0],
                    //ASN1Integer.toIntValue(values[1]),
                    //maximum);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.796 -0400", hash_original_method = "ACDF1910F99EABBA7FBE75C880969DB4", hash_generated_method = "B928919F97E94E9DC2850919B9037CFC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            GeneralSubtree gs;
            gs = (GeneralSubtree) object;
            values[0] = gs.base;
            values[1] = ASN1Integer.fromIntValue(gs.minimum);
            {
                values[2] = ASN1Integer.fromIntValue(gs.maximum);
            } //End block
            // ---------- Original Method ----------
            //GeneralSubtree gs = (GeneralSubtree) object;
            //values[0] = gs.base;
            //values[1] = ASN1Integer.fromIntValue(gs.minimum);
            //if (gs.maximum > -1) {
                //values[2] = ASN1Integer.fromIntValue(gs.maximum);
            //}
        }

        
}; //Transformed anonymous class
}

