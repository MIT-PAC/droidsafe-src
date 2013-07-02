package android.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class ContentObservable extends Observable<ContentObserver> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.654 -0400", hash_original_method = "0D8C230D46EFDA6222B6D152F7216617", hash_generated_method = "0D8C230D46EFDA6222B6D152F7216617")
    public ContentObservable ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.655 -0400", hash_original_method = "4478BB946B12E492F4CEF86404F7FDB4", hash_generated_method = "5B7E131AEF66111CFDD758AEF440BA96")
    @Override
    public void registerObserver(ContentObserver observer) {
        
        super.registerObserver(observer);
        addTaint(observer.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.660 -0400", hash_original_method = "2404EE3C179A56E4FBB403E872AACE69", hash_generated_method = "ED8684DCD95A0E776F6664EC0E9DA476")
    public void dispatchChange(boolean selfChange) {
        {
            {
                Iterator<ContentObserver> var26C534EC1982BC99FB26C7B41E9438B1_1934249201 = (mObservers).iterator();
                var26C534EC1982BC99FB26C7B41E9438B1_1934249201.hasNext();
                ContentObserver observer = var26C534EC1982BC99FB26C7B41E9438B1_1934249201.next();
                {
                    {
                        boolean var634E230D7A01ED031A0EEA41DB104AE4_994277596 = (!selfChange || observer.deliverSelfNotifications());
                        {
                            observer.dispatchChange(selfChange);
                        } 
                    } 
                } 
            } 
        } 
        addTaint(selfChange);
        
        
            
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.667 -0400", hash_original_method = "6E785AECA168F3220756C0C7D730B7FB", hash_generated_method = "2EA3AE139FD8BAF58F9F89A72C5F6981")
    public void notifyChange(boolean selfChange) {
        {
            {
                Iterator<ContentObserver> var26C534EC1982BC99FB26C7B41E9438B1_542274034 = (mObservers).iterator();
                var26C534EC1982BC99FB26C7B41E9438B1_542274034.hasNext();
                ContentObserver observer = var26C534EC1982BC99FB26C7B41E9438B1_542274034.next();
                {
                    observer.onChange(selfChange);
                } 
            } 
        } 
        addTaint(selfChange);
        
        
            
                
            
        
    }

    
}

