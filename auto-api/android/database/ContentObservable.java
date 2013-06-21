package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ContentObservable extends Observable<ContentObserver> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.937 -0400", hash_original_method = "58C0910D88A5B234F87666F612A471C0", hash_generated_method = "58C0910D88A5B234F87666F612A471C0")
        public ContentObservable ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.937 -0400", hash_original_method = "4478BB946B12E492F4CEF86404F7FDB4", hash_generated_method = "564DE90BF6DBE458B2EC73B89C0EE1E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void registerObserver(ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        super.registerObserver(observer);
        // ---------- Original Method ----------
        //super.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.948 -0400", hash_original_method = "2404EE3C179A56E4FBB403E872AACE69", hash_generated_method = "423BA7442220F4998D34309794137A8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchChange(boolean selfChange) {
        dsTaint.addTaint(selfChange);
        {
            {
                Iterator<ContentObserver> var26C534EC1982BC99FB26C7B41E9438B1_649205771 = (mObservers).iterator();
                var26C534EC1982BC99FB26C7B41E9438B1_649205771.hasNext();
                ContentObserver observer = var26C534EC1982BC99FB26C7B41E9438B1_649205771.next();
                {
                    {
                        boolean var634E230D7A01ED031A0EEA41DB104AE4_1602773847 = (!selfChange || observer.deliverSelfNotifications());
                        {
                            observer.dispatchChange(selfChange);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized(mObservers) {
            //for (ContentObserver observer : mObservers) {
                //if (!selfChange || observer.deliverSelfNotifications()) {
                    //observer.dispatchChange(selfChange);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.970 -0400", hash_original_method = "6E785AECA168F3220756C0C7D730B7FB", hash_generated_method = "8FEB310807784D9BC1B1D4D729F52E4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyChange(boolean selfChange) {
        dsTaint.addTaint(selfChange);
        {
            {
                Iterator<ContentObserver> var26C534EC1982BC99FB26C7B41E9438B1_1199816348 = (mObservers).iterator();
                var26C534EC1982BC99FB26C7B41E9438B1_1199816348.hasNext();
                ContentObserver observer = var26C534EC1982BC99FB26C7B41E9438B1_1199816348.next();
                {
                    observer.onChange(selfChange);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized(mObservers) {
            //for (ContentObserver observer : mObservers) {
                //observer.onChange(selfChange);
            //}
        //}
    }

    
}

