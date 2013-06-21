package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InheritableThreadLocal<T> extends ThreadLocal<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.747 -0400", hash_original_method = "013FA75455B3B99BD273198992B6DC3D", hash_generated_method = "E069ECF21285DFACCB09CA4095DD4CD7")
    @DSModeled(DSC.SAFE)
    public InheritableThreadLocal() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.748 -0400", hash_original_method = "21950621664F241C91FE4E959BCE80F5", hash_generated_method = "673C48D9CC25BC167D5B8F00D18194E1")
    @DSModeled(DSC.SAFE)
    protected T childValue(T parentValue) {
        dsTaint.addTaint(parentValue.dsTaint);
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parentValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.748 -0400", hash_original_method = "5F640D0B7D2E60FEE01A049AD8233DEB", hash_generated_method = "09D91AE6CE67A40F589D4DA9B543DCD6")
    @DSModeled(DSC.SAFE)
    @Override
     Values values(Thread current) {
        dsTaint.addTaint(current.dsTaint);
        return (Values)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return current.inheritableValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.748 -0400", hash_original_method = "198C51D572472BCFE1CF3566F6918855", hash_generated_method = "0D182B313ADAEDBB6D456A178F278579")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     Values initializeValues(Thread current) {
        dsTaint.addTaint(current.dsTaint);
        Values var2043C9669BAD8017E1FF9ACC388A5EBB_1848885434 = (current.inheritableValues = new Values());
        return (Values)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return current.inheritableValues = new Values();
    }

    
}

