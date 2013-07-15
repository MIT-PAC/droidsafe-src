package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class InheritableThreadLocal<T> extends ThreadLocal<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.906 -0400", hash_original_method = "013FA75455B3B99BD273198992B6DC3D", hash_generated_method = "E069ECF21285DFACCB09CA4095DD4CD7")
    public  InheritableThreadLocal() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.906 -0400", hash_original_method = "21950621664F241C91FE4E959BCE80F5", hash_generated_method = "D66A59D8DC0DC8E6E7F9EE0C8FC834A7")
    protected T childValue(T parentValue) {
        addTaint(parentValue.getTaint());
T var5B50CF7DCD7B0E8E9DCFB7F13A8B2F1B_2063967633 =         parentValue;
        var5B50CF7DCD7B0E8E9DCFB7F13A8B2F1B_2063967633.addTaint(taint);
        return var5B50CF7DCD7B0E8E9DCFB7F13A8B2F1B_2063967633;
        // ---------- Original Method ----------
        //return parentValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.907 -0400", hash_original_method = "5F640D0B7D2E60FEE01A049AD8233DEB", hash_generated_method = "B47E9E2CDFA56C159831499E5F6DF572")
    @Override
     Values values(Thread current) {
        addTaint(current.getTaint());
Values varFD13BEAC833885316C9D98DFD25DC72D_1179740654 =         current.inheritableValues;
        varFD13BEAC833885316C9D98DFD25DC72D_1179740654.addTaint(taint);
        return varFD13BEAC833885316C9D98DFD25DC72D_1179740654;
        // ---------- Original Method ----------
        //return current.inheritableValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.908 -0400", hash_original_method = "198C51D572472BCFE1CF3566F6918855", hash_generated_method = "ECC1FFC584A7FF13350024783D1E65C9")
    @Override
     Values initializeValues(Thread current) {
        addTaint(current.getTaint());
Values varFA06F5287CC4CB6B390064F9EE6BF5A9_16292548 =         current.inheritableValues = new Values();
        varFA06F5287CC4CB6B390064F9EE6BF5A9_16292548.addTaint(taint);
        return varFA06F5287CC4CB6B390064F9EE6BF5A9_16292548;
        // ---------- Original Method ----------
        //return current.inheritableValues = new Values();
    }

    
}

