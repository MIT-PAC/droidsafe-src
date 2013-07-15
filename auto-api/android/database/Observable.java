package android.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ArrayList;

public abstract class Observable<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.046 -0400", hash_original_field = "4568676A708AC893FC758A70E573C153", hash_generated_field = "68FF9C8CE88B8AC7C5CD64388A1A318D")

    protected final ArrayList<T> mObservers = new ArrayList<T>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.047 -0400", hash_original_method = "70464F2D6E4F3B59517C778B3B1A93D5", hash_generated_method = "70464F2D6E4F3B59517C778B3B1A93D5")
    public Observable ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.047 -0400", hash_original_method = "E1D85670162EF30644779B34B74FE79F", hash_generated_method = "F76C623B8543B7A89A22D48FE51D89F0")
    public void registerObserver(T observer) {
        
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The observer is null.");
        } 
        {
            {
                boolean varB1C365CA1474DBF7A76FDBEB30F97622_378364303 = (mObservers.contains(observer));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Observer " + observer + " is already registered.");
                } 
            } 
            mObservers.add(observer);
        } 
        addTaint(observer.getTaint());
        
        
            
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.048 -0400", hash_original_method = "5FAF0F37EA51171D6350539680C2708B", hash_generated_method = "C9E5AD511B805E188E7EB8A82A4BF2E0")
    public void unregisterObserver(T observer) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The observer is null.");
        } 
        {
            int index = mObservers.indexOf(observer);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Observer " + observer + " was not registered.");
            } 
            mObservers.remove(index);
        } 
        addTaint(observer.getTaint());
        
        
            
        
        
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.048 -0400", hash_original_method = "68DB825828DE5D87C3617DBC5932D86C", hash_generated_method = "15DCF18EAD87632038A03531805C5E0F")
    public void unregisterAll() {
        {
            mObservers.clear();
        } 
        
        
            
        
    }

    
}

