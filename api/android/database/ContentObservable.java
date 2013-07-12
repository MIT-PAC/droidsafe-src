package android.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ContentObservable extends Observable<ContentObserver> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.025 -0400", hash_original_method = "0D8C230D46EFDA6222B6D152F7216617", hash_generated_method = "0D8C230D46EFDA6222B6D152F7216617")
    public ContentObservable ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.025 -0400", hash_original_method = "4478BB946B12E492F4CEF86404F7FDB4", hash_generated_method = "899EFC8C24972B9B2FB8AB25C86A4586")
    @Override
    public void registerObserver(ContentObserver observer) {
        
        addTaint(observer.getTaint());
        super.registerObserver(observer);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.026 -0400", hash_original_method = "2404EE3C179A56E4FBB403E872AACE69", hash_generated_method = "3AA5A40DDC3B68118FE7597661DD9009")
    public void dispatchChange(boolean selfChange) {
        addTaint(selfChange);
        synchronized
(mObservers)        {
for(ContentObserver observer : mObservers)
            {
    if(!selfChange || observer.deliverSelfNotifications())                
                {
                    observer.dispatchChange(selfChange);
                } 
            } 
        } 
        
        
            
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.026 -0400", hash_original_method = "6E785AECA168F3220756C0C7D730B7FB", hash_generated_method = "6BB68C9F5CDD96272D5EAFF9AA4B6EC0")
    public void notifyChange(boolean selfChange) {
        addTaint(selfChange);
        synchronized
(mObservers)        {
for(ContentObserver observer : mObservers)
            {
                observer.onChange(selfChange);
            } 
        } 
        
        
            
                
            
        
    }

    
}

