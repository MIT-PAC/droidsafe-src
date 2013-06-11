package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class DataSetObservable extends Observable<DataSetObserver> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.686 -0400", hash_original_method = "FCDAC37DCBE00C8E72E2289D698E0B3F", hash_generated_method = "98FFECF96B0277AAE8896641BF740FFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.687 -0400", hash_original_method = "C67632C7194D1964FA22740DFB1AA62E", hash_generated_method = "F76DA9F3763A2BAF9FA4E5756D25B713")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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


