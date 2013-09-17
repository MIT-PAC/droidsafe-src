package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.InputStream;






abstract class LimitedInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.781 -0400", hash_original_field = "678DB741D1B48B4477A490AEDCFD1EC9", hash_generated_field = "274538152B8B82436D94F9F1A496F39B")

    protected InputStream _in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.781 -0400", hash_original_field = "21B59360B06F124AC143A9061C12E7FA", hash_generated_field = "CC1F761CCB044A54710FD1E5F22ED61A")

    private int _limit;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.782 -0400", hash_original_method = "0D8C2EADFFB47C1CBCA5E0CC8CF6BC20", hash_generated_method = "055279600C3D6430555A03116D898451")
      LimitedInputStream(
        InputStream in,
        int         limit) {
        this._in = in;
        this._limit = limit;
        // ---------- Original Method ----------
        //this._in = in;
        //this._limit = limit;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.782 -0400", hash_original_method = "40872598AE6AA3CD657ADA29CC622AC7", hash_generated_method = "E5B18C5668106F5D336A1BF9459295D8")
     int getRemaining() {
        int var21B59360B06F124AC143A9061C12E7FA_1917935964 = (_limit);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1788001523 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1788001523;
        // ---------- Original Method ----------
        //return _limit;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.782 -0400", hash_original_method = "C0E0722B99096B33B184C9FBB5E52E11", hash_generated_method = "AD66AA47DA5023E1EE9584ACE6A423A3")
    protected void setParentEofDetect(boolean on) {
        addTaint(on);
        if(_in instanceof IndefiniteLengthInputStream)        
        {
            ((IndefiniteLengthInputStream)_in).setEofOn00(on);
        } //End block
        // ---------- Original Method ----------
        //if (_in instanceof IndefiniteLengthInputStream)
        //{
            //((IndefiniteLengthInputStream)_in).setEofOn00(on);
        //}
    }

    
}

