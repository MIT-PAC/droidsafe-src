package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class StatFs {
    private int mNativeContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.835 -0400", hash_original_method = "B32C82E8AC66960E05928520E920B8ED", hash_generated_method = "8EFCC274407C7F8E5BA9C57A413D6FAC")
    @DSModeled(DSC.SAFE)
    public StatFs(String path) {
        dsTaint.addTaint(path);
        native_setup(path);
        // ---------- Original Method ----------
        //native_setup(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.835 -0400", hash_original_method = "8AF6434E2BA3E41CBFFC05A34FB3A23C", hash_generated_method = "63DFBADB107AB1BBC943C004C78CBE98")
    @DSModeled(DSC.SAFE)
    public void restat(String path) {
        dsTaint.addTaint(path);
        native_restat(path);
        // ---------- Original Method ----------
        //native_restat(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.836 -0400", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "2A5F99104A7626AF3A9C05307F5FED64")
    @DSModeled(DSC.SAFE)
    @Override
    protected void finalize() {
        native_finalize();
        // ---------- Original Method ----------
        //native_finalize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.836 -0400", hash_original_method = "69F794FD342F65559C8B48F7A39B3D6D", hash_generated_method = "83909D31B6F86B4ABE55172A2BE2A27C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getBlockSize() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.836 -0400", hash_original_method = "AA8CC1613F4A2D3F7308C06B4F7C4105", hash_generated_method = "34F1071BB4E09624E7951210E6CE8F2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getBlockCount() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.836 -0400", hash_original_method = "F279B1780F1BAD71D18F3CF49F704643", hash_generated_method = "CD57B3C82A9BB9FC4910F59FDE36969E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getFreeBlocks() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.837 -0400", hash_original_method = "39AF4947A221201A3EFDFD20EE46EF90", hash_generated_method = "8402EF9AEB138B781960A61648F54F2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAvailableBlocks() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.837 -0400", hash_original_method = "59CA121EFB9D79074525B44E468BE4BE", hash_generated_method = "DD4290473661919BE115390B12427B3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_restat(String path) {
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.837 -0400", hash_original_method = "1E41289F3DA4BBE4A138859E5014C4A0", hash_generated_method = "B79F99468152A45ACF10F5A2073EF672")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_setup(String path) {
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.837 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "8F7982D91871184F41D8893500D1123F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_finalize() {
    }

    
}


