package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public class InheritableThreadLocal<T> extends ThreadLocal<T> {

    /**
     * Creates a new inheritable thread-local variable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.537 -0500", hash_original_method = "013FA75455B3B99BD273198992B6DC3D", hash_generated_method = "E13EE25F4E019254954C6350304C79AC")
    
public InheritableThreadLocal() {
    }

    /**
     * Computes the initial value of this thread-local variable for the child
     * thread given the parent thread's value. Called from the parent thread when
     * creating a child thread. The default implementation returns the parent
     * thread's value.
     *
     * @param parentValue the value of the variable in the parent thread.
     * @return the initial value of the variable for the child thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.541 -0500", hash_original_method = "21950621664F241C91FE4E959BCE80F5", hash_generated_method = "8D17A7D6545AFF55B795464598770CC6")
    
protected T childValue(T parentValue) {
        return parentValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.543 -0500", hash_original_method = "5F640D0B7D2E60FEE01A049AD8233DEB", hash_generated_method = "663009C2DB6D2EF65EB42BB969A6976E")
    
@Override
    Values values(Thread current) {
        return current.inheritableValues;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.545 -0500", hash_original_method = "198C51D572472BCFE1CF3566F6918855", hash_generated_method = "7476F3413E3E995DF44BCBC94333B86C")
    
@Override
    Values initializeValues(Thread current) {
        return current.inheritableValues = new Values();
    }

    
}

