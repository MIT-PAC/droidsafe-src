package java.lang;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class InheritableThreadLocal<T> extends ThreadLocal<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.070 -0400", hash_original_method = "013FA75455B3B99BD273198992B6DC3D", hash_generated_method = "E069ECF21285DFACCB09CA4095DD4CD7")
    public  InheritableThreadLocal() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.070 -0400", hash_original_method = "21950621664F241C91FE4E959BCE80F5", hash_generated_method = "E13ECF9F873781364FCD1C86DB3F9C78")
    protected T childValue(T parentValue) {
        addTaint(parentValue.getTaint());
T var5B50CF7DCD7B0E8E9DCFB7F13A8B2F1B_412074257 =         parentValue;
        var5B50CF7DCD7B0E8E9DCFB7F13A8B2F1B_412074257.addTaint(taint);
        return var5B50CF7DCD7B0E8E9DCFB7F13A8B2F1B_412074257;
        // ---------- Original Method ----------
        //return parentValue;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.071 -0400", hash_original_method = "5F640D0B7D2E60FEE01A049AD8233DEB", hash_generated_method = "894A935B6F17205B88331EDD46190960")
    @Override
     Values values(Thread current) {
        addTaint(current.getTaint());
Values varFD13BEAC833885316C9D98DFD25DC72D_2099164328 =         current.inheritableValues;
        varFD13BEAC833885316C9D98DFD25DC72D_2099164328.addTaint(taint);
        return varFD13BEAC833885316C9D98DFD25DC72D_2099164328;
        // ---------- Original Method ----------
        //return current.inheritableValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.071 -0400", hash_original_method = "198C51D572472BCFE1CF3566F6918855", hash_generated_method = "8422C65D9EA725AD7ACC5B23EFC0711E")
    @Override
     Values initializeValues(Thread current) {
        addTaint(current.getTaint());
Values varFA06F5287CC4CB6B390064F9EE6BF5A9_1168395137 =         current.inheritableValues = new Values();
        varFA06F5287CC4CB6B390064F9EE6BF5A9_1168395137.addTaint(taint);
        return varFA06F5287CC4CB6B390064F9EE6BF5A9_1168395137;
        // ---------- Original Method ----------
        //return current.inheritableValues = new Values();
    }

    
}

