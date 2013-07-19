package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import javax.net.ssl.SSLException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class AlertException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.886 -0400", hash_original_field = "40BEA8D637CDF2C1B07FCF0630482B73", hash_generated_field = "C530EE3CBD485644D7525A400EA925B6")

    private SSLException reason;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.886 -0400", hash_original_field = "67DAF92C833C41C95DB874E18FCB2786", hash_generated_field = "970155BA799F3943C9383598DE4C30A5")

    private byte description;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.887 -0400", hash_original_method = "76164594E21D6CE99D1A0A90A760CF7A", hash_generated_method = "C31398FCD1D6FC21427CE5C9A0C803C3")
    protected  AlertException(byte description, SSLException reason) {
        super(reason);
        this.reason = reason;
        this.description = description;
        // ---------- Original Method ----------
        //this.reason = reason;
        //this.description = description;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.887 -0400", hash_original_method = "5B702ECC4BAE0D4CD4DED59A097CDBFC", hash_generated_method = "759A129DCCDB366245F7DD4F605327F9")
    protected SSLException getReason() {
SSLException varD602C4C1684F7464133CA1A6851CC44A_1482145504 =         reason;
        varD602C4C1684F7464133CA1A6851CC44A_1482145504.addTaint(taint);
        return varD602C4C1684F7464133CA1A6851CC44A_1482145504;
        // ---------- Original Method ----------
        //return reason;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.888 -0400", hash_original_method = "4016638ED8025AA5C043B11675AF3321", hash_generated_method = "A102F6137693B155D298DCCAAA90901A")
    protected byte getDescriptionCode() {
        byte var67DAF92C833C41C95DB874E18FCB2786_1646955767 = (description);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_794400460 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_794400460;
        // ---------- Original Method ----------
        //return description;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.888 -0400", hash_original_field = "AA9487126D7D010735548D102ECD2BCD", hash_generated_field = "49414C5F100260BFB79C458FA4822DE5")

    private static final long serialVersionUID = -4448327177165687581L;
}

