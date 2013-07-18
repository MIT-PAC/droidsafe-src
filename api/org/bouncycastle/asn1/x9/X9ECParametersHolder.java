package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class X9ECParametersHolder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.355 -0400", hash_original_field = "21FFCE5B8A6CC8CC6A41448DD69623C9", hash_generated_field = "4C1B71428688017C93ABE5D3E920C724")

    private X9ECParameters params;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.355 -0400", hash_original_method = "FD737115DECB7E666F320685834584A5", hash_generated_method = "FD737115DECB7E666F320685834584A5")
    public X9ECParametersHolder ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.356 -0400", hash_original_method = "DFAA4BD61A3833EE49852C9B8E577AF7", hash_generated_method = "93BE65BE7666AB6247D6C7C7EBD6BB38")
    public X9ECParameters getParameters() {
        if(params == null)        
        {
            params = createParameters();
        } //End block
X9ECParameters varD15CEB6F45B18F7EB233792D020C6115_2008282775 =         params;
        varD15CEB6F45B18F7EB233792D020C6115_2008282775.addTaint(taint);
        return varD15CEB6F45B18F7EB233792D020C6115_2008282775;
        // ---------- Original Method ----------
        //if (params == null)
        //{
            //params = createParameters();
        //}
        //return params;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract X9ECParameters createParameters();

    
}

