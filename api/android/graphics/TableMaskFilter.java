package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
public class TableMaskFilter extends MaskFilter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.006 -0400", hash_original_method = "2838A0F74A029364BA1430ED0E0DC224", hash_generated_method = "469EE904B61EA31594C6AFF0B490C2CF")
    public  TableMaskFilter(byte[] table) {
        addTaint(table[0]);
        if(table.length<256)        
        {
            RuntimeException var70D44AC6FC58CC9C08128FD329CFAD1B_1797719282 = new RuntimeException("table.length must be >= 256");
            var70D44AC6FC58CC9C08128FD329CFAD1B_1797719282.addTaint(taint);
            throw var70D44AC6FC58CC9C08128FD329CFAD1B_1797719282;
        } //End block
native_instance=nativeNewTable(table)
        // ---------- Original Method ----------
        //if (table.length < 256) {
            //throw new RuntimeException("table.length must be >= 256");
        //}
        //native_instance = nativeNewTable(table);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.008 -0400", hash_original_method = "BEA169039F07C18DD9FD85488373CC35", hash_generated_method = "6C6DFC113E3C3B7859ADF24284C7B8B1")
    private  TableMaskFilter(int ni) {
        addTaint(ni);
native_instance=ni
        // ---------- Original Method ----------
        //native_instance = ni;
    }

    
    public static TableMaskFilter CreateClipTable(int min, int max) {
        return new TableMaskFilter(nativeNewClip(min, max));
    }

    
    public static TableMaskFilter CreateGammaTable(float gamma) {
        return new TableMaskFilter(nativeNewGamma(gamma));
    }

    
    private static int nativeNewTable(byte[] table) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990118271 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990118271;
    }

    
    private static int nativeNewClip(int min, int max) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_754365558 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_754365558;
    }

    
    private static int nativeNewGamma(float gamma) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_573922969 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_573922969;
    }

    
}

