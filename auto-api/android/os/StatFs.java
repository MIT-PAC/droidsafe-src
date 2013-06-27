package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class StatFs {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.524 -0400", hash_original_field = "20E813A614226843849BF2E571A8EBCA", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.525 -0400", hash_original_method = "B32C82E8AC66960E05928520E920B8ED", hash_generated_method = "AA73C2BDD9D17E2ACB3E8691F4E80282")
    public  StatFs(String path) {
        native_setup(path);
        addTaint(path.getTaint());
        // ---------- Original Method ----------
        //native_setup(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.526 -0400", hash_original_method = "8AF6434E2BA3E41CBFFC05A34FB3A23C", hash_generated_method = "3CDF015B411E46EB8DD262ECE1A1C7F2")
    public void restat(String path) {
        native_restat(path);
        addTaint(path.getTaint());
        // ---------- Original Method ----------
        //native_restat(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.526 -0400", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "50625AE6DF481AE64B3EB15F7175DFBD")
    @Override
    protected void finalize() {
        native_finalize();
        // ---------- Original Method ----------
        //native_finalize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.527 -0400", hash_original_method = "69F794FD342F65559C8B48F7A39B3D6D", hash_generated_method = "06EB868E0F95A3FCCED85C153797991F")
    public int getBlockSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353869414 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353869414;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.538 -0400", hash_original_method = "AA8CC1613F4A2D3F7308C06B4F7C4105", hash_generated_method = "DC73455CCA54ECB51AA67EEB960C40C7")
    public int getBlockCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1600568048 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1600568048;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.542 -0400", hash_original_method = "F279B1780F1BAD71D18F3CF49F704643", hash_generated_method = "870B9A8F0E90961CB1EB279904449D2C")
    public int getFreeBlocks() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878575197 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878575197;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.543 -0400", hash_original_method = "39AF4947A221201A3EFDFD20EE46EF90", hash_generated_method = "444D20D08431DB42200A8B53418EBE7A")
    public int getAvailableBlocks() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992167550 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992167550;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.543 -0400", hash_original_method = "59CA121EFB9D79074525B44E468BE4BE", hash_generated_method = "F00DF08453A08280B8F5BA9830660CEC")
    private void native_restat(String path) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.544 -0400", hash_original_method = "1E41289F3DA4BBE4A138859E5014C4A0", hash_generated_method = "BBFC4EB7D2311CA879BC2E3377EB3DA6")
    private void native_setup(String path) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.544 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "3A27293ECCA15B583017AC8E293B284F")
    private void native_finalize() {
    }

    
}

