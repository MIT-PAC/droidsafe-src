package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class StatFs {
    private int mNativeContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.873 -0400", hash_original_method = "B32C82E8AC66960E05928520E920B8ED", hash_generated_method = "8EFCC274407C7F8E5BA9C57A413D6FAC")
    @DSModeled(DSC.SAFE)
    public StatFs(String path) {
        dsTaint.addTaint(path);
        native_setup(path);
        // ---------- Original Method ----------
        //native_setup(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.873 -0400", hash_original_method = "8AF6434E2BA3E41CBFFC05A34FB3A23C", hash_generated_method = "63DFBADB107AB1BBC943C004C78CBE98")
    @DSModeled(DSC.SAFE)
    public void restat(String path) {
        dsTaint.addTaint(path);
        native_restat(path);
        // ---------- Original Method ----------
        //native_restat(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.874 -0400", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "2A5F99104A7626AF3A9C05307F5FED64")
    @DSModeled(DSC.SAFE)
    @Override
    protected void finalize() {
        native_finalize();
        // ---------- Original Method ----------
        //native_finalize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.874 -0400", hash_original_method = "69F794FD342F65559C8B48F7A39B3D6D", hash_generated_method = "B78196B0A05A86C6BA00EA6DF71D68F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getBlockSize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.874 -0400", hash_original_method = "AA8CC1613F4A2D3F7308C06B4F7C4105", hash_generated_method = "F90CDCB69F829577D8D6BD7C7BE58345")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getBlockCount() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.874 -0400", hash_original_method = "F279B1780F1BAD71D18F3CF49F704643", hash_generated_method = "18068C7727FC0203CC360418D34D8A13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getFreeBlocks() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.874 -0400", hash_original_method = "39AF4947A221201A3EFDFD20EE46EF90", hash_generated_method = "1ECBAC0B056DCFE05D06D0FEE5E30540")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAvailableBlocks() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.874 -0400", hash_original_method = "59CA121EFB9D79074525B44E468BE4BE", hash_generated_method = "DD4290473661919BE115390B12427B3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_restat(String path) {
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.874 -0400", hash_original_method = "1E41289F3DA4BBE4A138859E5014C4A0", hash_generated_method = "B79F99468152A45ACF10F5A2073EF672")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_setup(String path) {
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.874 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "8F7982D91871184F41D8893500D1123F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_finalize() {
    }

    
}


