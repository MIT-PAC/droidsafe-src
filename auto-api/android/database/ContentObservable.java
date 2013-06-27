package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ContentObservable extends Observable<ContentObserver> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.693 -0400", hash_original_method = "0D8C230D46EFDA6222B6D152F7216617", hash_generated_method = "0D8C230D46EFDA6222B6D152F7216617")
    public ContentObservable ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.694 -0400", hash_original_method = "4478BB946B12E492F4CEF86404F7FDB4", hash_generated_method = "5B7E131AEF66111CFDD758AEF440BA96")
    @Override
    public void registerObserver(ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        super.registerObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //super.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.821 -0400", hash_original_method = "2404EE3C179A56E4FBB403E872AACE69", hash_generated_method = "9210E824DD397B94C0ED7B33748024B2")
    public void dispatchChange(boolean selfChange) {
        {
            {
                Iterator<ContentObserver> var26C534EC1982BC99FB26C7B41E9438B1_1409882147 = (mObservers).iterator();
                var26C534EC1982BC99FB26C7B41E9438B1_1409882147.hasNext();
                ContentObserver observer = var26C534EC1982BC99FB26C7B41E9438B1_1409882147.next();
                {
                    {
                        boolean var634E230D7A01ED031A0EEA41DB104AE4_1644291322 = (!selfChange || observer.deliverSelfNotifications());
                        {
                            observer.dispatchChange(selfChange);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(selfChange);
        // ---------- Original Method ----------
        //synchronized(mObservers) {
            //for (ContentObserver observer : mObservers) {
                //if (!selfChange || observer.deliverSelfNotifications()) {
                    //observer.dispatchChange(selfChange);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.950 -0400", hash_original_method = "6E785AECA168F3220756C0C7D730B7FB", hash_generated_method = "060483DC657C166A333684AD7B44D735")
    public void notifyChange(boolean selfChange) {
        {
            {
                Iterator<ContentObserver> var26C534EC1982BC99FB26C7B41E9438B1_1217938640 = (mObservers).iterator();
                var26C534EC1982BC99FB26C7B41E9438B1_1217938640.hasNext();
                ContentObserver observer = var26C534EC1982BC99FB26C7B41E9438B1_1217938640.next();
                {
                    observer.onChange(selfChange);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(selfChange);
        // ---------- Original Method ----------
        //synchronized(mObservers) {
            //for (ContentObserver observer : mObservers) {
                //observer.onChange(selfChange);
            //}
        //}
    }

    
}

