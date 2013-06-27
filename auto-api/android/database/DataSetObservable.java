package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DataSetObservable extends Observable<DataSetObserver> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.883 -0400", hash_original_method = "272BBF2661CCEF03EAE77BBF3297984E", hash_generated_method = "272BBF2661CCEF03EAE77BBF3297984E")
    public DataSetObservable ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.884 -0400", hash_original_method = "FCDAC37DCBE00C8E72E2289D698E0B3F", hash_generated_method = "0217B011F40F38CA505DA094AAE2177D")
    public void notifyChanged() {
        {
            {
                int i;
                i = mObservers.size() - 1;
                {
                    mObservers.get(i).onChanged();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized(mObservers) {
            //for (int i = mObservers.size() - 1; i >= 0; i--) {
                //mObservers.get(i).onChanged();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.885 -0400", hash_original_method = "C67632C7194D1964FA22740DFB1AA62E", hash_generated_method = "4CCDD96EF40CAB6A7D4812942EF81748")
    public void notifyInvalidated() {
        {
            {
                int i;
                i = mObservers.size() - 1;
                {
                    mObservers.get(i).onInvalidated();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (mObservers) {
            //for (int i = mObservers.size() - 1; i >= 0; i--) {
                //mObservers.get(i).onInvalidated();
            //}
        //}
    }

    
}

