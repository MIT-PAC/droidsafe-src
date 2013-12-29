package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.InputStream;






abstract class LimitedInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:52.049 -0500", hash_original_field = "0AF8B53607342E2932B67C3C39DDF67E", hash_generated_field = "274538152B8B82436D94F9F1A496F39B")

    protected  InputStream _in;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:52.049 -0500", hash_original_field = "ADA4D5F0AAE64549A210DC56084FD197", hash_generated_field = "CC1F761CCB044A54710FD1E5F22ED61A")

    private int _limit;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:52.050 -0500", hash_original_method = "0D8C2EADFFB47C1CBCA5E0CC8CF6BC20", hash_generated_method = "0D8C2EADFFB47C1CBCA5E0CC8CF6BC20")
    LimitedInputStream(
        InputStream in,
        int         limit)
    {
        this._in = in;
        this._limit = limit;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:52.051 -0500", hash_original_method = "40872598AE6AA3CD657ADA29CC622AC7", hash_generated_method = "898086B79DA7CE22E1C6420B6C7C7693")
    int getRemaining()
    {
        // TODO: maybe one day this can become more accurate
        return _limit;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:52.052 -0500", hash_original_method = "C0E0722B99096B33B184C9FBB5E52E11", hash_generated_method = "D1C273FA5DCFD115FF7F52C54E7566B8")
    protected void setParentEofDetect(boolean on)
    {
        if (_in instanceof IndefiniteLengthInputStream)
        {
            ((IndefiniteLengthInputStream)_in).setEofOn00(on);
        }
    }

    
}

