package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class StatFs {
    private int mNativeContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.217 -0400", hash_original_method = "B32C82E8AC66960E05928520E920B8ED", hash_generated_method = "62AA50B90A61741D0E045063BFD1ED0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StatFs(String path) {
        dsTaint.addTaint(path);
        native_setup(path);
        // ---------- Original Method ----------
        //native_setup(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.218 -0400", hash_original_method = "8AF6434E2BA3E41CBFFC05A34FB3A23C", hash_generated_method = "109D615B81E53FFE1F81A129D0D9C358")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restat(String path) {
        dsTaint.addTaint(path);
        native_restat(path);
        // ---------- Original Method ----------
        //native_restat(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.218 -0400", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "50625AE6DF481AE64B3EB15F7175DFBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() {
        native_finalize();
        // ---------- Original Method ----------
        //native_finalize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.218 -0400", hash_original_method = "69F794FD342F65559C8B48F7A39B3D6D", hash_generated_method = "D9126A775456CFE3E63D9DC3A841F493")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getBlockSize() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.218 -0400", hash_original_method = "AA8CC1613F4A2D3F7308C06B4F7C4105", hash_generated_method = "DF6255810BE6A110204A6F68A0440E7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getBlockCount() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.219 -0400", hash_original_method = "F279B1780F1BAD71D18F3CF49F704643", hash_generated_method = "1ED4823FE0ABBD604AE995B86C56FEAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getFreeBlocks() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.219 -0400", hash_original_method = "39AF4947A221201A3EFDFD20EE46EF90", hash_generated_method = "1A2BD4760976F5D16A6150E1BA850844")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAvailableBlocks() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.219 -0400", hash_original_method = "59CA121EFB9D79074525B44E468BE4BE", hash_generated_method = "2FD933FC54F640D92041755D27B9CB70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_restat(String path) {
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.220 -0400", hash_original_method = "1E41289F3DA4BBE4A138859E5014C4A0", hash_generated_method = "F0CD511E9B587C8225B4E43D6F46FF7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_setup(String path) {
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.220 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "3A27293ECCA15B583017AC8E293B284F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_finalize() {
    }

    
}

