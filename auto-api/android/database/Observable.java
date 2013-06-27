package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;

public abstract class Observable<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.178 -0400", hash_original_field = "4568676A708AC893FC758A70E573C153", hash_generated_field = "C42053F6BE4C24F1A28BE5E5A9547CA9")

    protected ArrayList<T> mObservers = new ArrayList<T>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.178 -0400", hash_original_method = "70464F2D6E4F3B59517C778B3B1A93D5", hash_generated_method = "70464F2D6E4F3B59517C778B3B1A93D5")
    public Observable ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.179 -0400", hash_original_method = "E1D85670162EF30644779B34B74FE79F", hash_generated_method = "5D35B3BFC50BADE22989D82B112F1AF9")
    public void registerObserver(T observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The observer is null.");
        } //End block
        {
            {
                boolean varB1C365CA1474DBF7A76FDBEB30F97622_2104897319 = (mObservers.contains(observer));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Observer " + observer + " is already registered.");
                } //End block
            } //End collapsed parenthetic
            mObservers.add(observer);
        } //End block
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //if (observer == null) {
            //throw new IllegalArgumentException("The observer is null.");
        //}
        //synchronized(mObservers) {
            //if (mObservers.contains(observer)) {
                //throw new IllegalStateException("Observer " + observer + " is already registered.");
            //}
            //mObservers.add(observer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.180 -0400", hash_original_method = "5FAF0F37EA51171D6350539680C2708B", hash_generated_method = "29F6312CD04289030E426AD2D4979805")
    public void unregisterObserver(T observer) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The observer is null.");
        } //End block
        {
            int index;
            index = mObservers.indexOf(observer);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Observer " + observer + " was not registered.");
            } //End block
            mObservers.remove(index);
        } //End block
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //if (observer == null) {
            //throw new IllegalArgumentException("The observer is null.");
        //}
        //synchronized(mObservers) {
            //int index = mObservers.indexOf(observer);
            //if (index == -1) {
                //throw new IllegalStateException("Observer " + observer + " was not registered.");
            //}
            //mObservers.remove(index);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.198 -0400", hash_original_method = "68DB825828DE5D87C3617DBC5932D86C", hash_generated_method = "15DCF18EAD87632038A03531805C5E0F")
    public void unregisterAll() {
        {
            mObservers.clear();
        } //End block
        // ---------- Original Method ----------
        //synchronized(mObservers) {
            //mObservers.clear();
        //}
    }

    
}

