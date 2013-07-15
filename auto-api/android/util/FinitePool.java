package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

class FinitePool<T extends Poolable<T>> implements Pool<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.301 -0400", hash_original_field = "1D4FD4FBF6080AF66D4D90562FE06036", hash_generated_field = "263F1F5C5ECE190F0DC9583236769778")

    private PoolableManager<T> mManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.301 -0400", hash_original_field = "5B168C2292FF8EC273A67B1639E35C5D", hash_generated_field = "4EC83DFC67A77EF18032B269F8E92E02")

    private int mLimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.301 -0400", hash_original_field = "4157F13E118F9F9EA65516C981804C02", hash_generated_field = "B7F8D9172C7DAC966FA21394C9C9EF7B")

    private boolean mInfinite;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.301 -0400", hash_original_field = "45682D04D23E9DFA9A87C72737AEDE4C", hash_generated_field = "EB122BF46F1C40CB06087B3F34511BDC")

    private T mRoot;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.301 -0400", hash_original_field = "2243FD79B5ED841D9023629C87E90851", hash_generated_field = "47A76FA1CCA216BE1DAEAFB6D7AEE2F8")

    private int mPoolCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.301 -0400", hash_original_method = "E32E280D36A91DE3F8C1D108448A5172", hash_generated_method = "5E4FA79BA7201907DBEC838688972D4C")
      FinitePool(PoolableManager<T> manager) {
        mManager = manager;
        mLimit = 0;
        mInfinite = true;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.302 -0400", hash_original_method = "1F77D1F43E03D174D17C1D886C3B593A", hash_generated_method = "DD8A3842A3F3B01E9FC0FCFB394B1710")
      FinitePool(PoolableManager<T> manager, int limit) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The pool limit must be > 0");
        mManager = manager;
        mLimit = limit;
        mInfinite = false;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.302 -0400", hash_original_method = "7D07537AD43CB2EA058390D31632CED6", hash_generated_method = "1CF6DD69F52816D0E6E955A3F1A32E87")
    public T acquire() {
        T varB4EAC82CA7396A68D541C85D26508E83_1318690405 = null; 
        T element;
        {
            element = mRoot;
            mRoot = element.getNextPoolable();
        } 
        {
            element = mManager.newInstance();
        } 
        {
            element.setNextPoolable(null);
            element.setPooled(false);
            mManager.onAcquired(element);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1318690405 = element;
        varB4EAC82CA7396A68D541C85D26508E83_1318690405.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1318690405;
        
        
        
            
            
            
        
            
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.303 -0400", hash_original_method = "682D089BAC6076782B5E99EF5FBF0695", hash_generated_method = "C3972C47B0A961F24CF696D44F702243")
    public void release(T element) {
        {
            boolean var5FC43357289D29F41938F96527965211_703145967 = (!element.isPooled());
            {
                {
                    element.setNextPoolable(mRoot);
                    element.setPooled(true);
                    mRoot = element;
                } 
                mManager.onReleased(element);
            } 
        } 
        
        
            
                
                
                
                
            
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.303 -0400", hash_original_field = "AA4E01504FD4F01FA8D4A651DBDB41CA", hash_generated_field = "D4F5669F7C6CCD0730D510AE50304291")

    private static final String LOG_TAG = "FinitePool";
}

