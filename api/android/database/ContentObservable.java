package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ContentObservable extends Observable<ContentObserver> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.555 -0400", hash_original_method = "0D8C230D46EFDA6222B6D152F7216617", hash_generated_method = "0D8C230D46EFDA6222B6D152F7216617")
    public ContentObservable ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.829 -0500", hash_original_method = "4478BB946B12E492F4CEF86404F7FDB4", hash_generated_method = "34DE4A87BCB1B618F11967568623B645")
    
@Override
    public void registerObserver(ContentObserver observer) {
        super.registerObserver(observer);
    }

    /**
     * invokes dispatchUpdate on each observer, unless the observer doesn't want
     * self-notifications and the update is from a self-notification
     * @param selfChange
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.832 -0500", hash_original_method = "2404EE3C179A56E4FBB403E872AACE69", hash_generated_method = "726453482F3669E41225D0560A9371CC")
    
public void dispatchChange(boolean selfChange) {
        synchronized(mObservers) {
            for (ContentObserver observer : mObservers) {
                if (!selfChange || observer.deliverSelfNotifications()) {
                    observer.dispatchChange(selfChange);
                }
            }
        }
    }

    /**
     * invokes onChange on each observer
     * @param selfChange
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.834 -0500", hash_original_method = "6E785AECA168F3220756C0C7D730B7FB", hash_generated_method = "EEEAAD5A170D7CCE5625A72FA61DF131")
    
public void notifyChange(boolean selfChange) {
        synchronized(mObservers) {
            for (ContentObserver observer : mObservers) {
                observer.onChange(selfChange);
            }
        }
    }
    
}

