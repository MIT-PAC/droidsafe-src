package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class FinitePool<T extends Poolable<T>> implements Pool<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.772 -0400", hash_original_field = "1D4FD4FBF6080AF66D4D90562FE06036", hash_generated_field = "263F1F5C5ECE190F0DC9583236769778")

    private PoolableManager<T> mManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.772 -0400", hash_original_field = "5B168C2292FF8EC273A67B1639E35C5D", hash_generated_field = "4EC83DFC67A77EF18032B269F8E92E02")

    private int mLimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.772 -0400", hash_original_field = "4157F13E118F9F9EA65516C981804C02", hash_generated_field = "B7F8D9172C7DAC966FA21394C9C9EF7B")

    private boolean mInfinite;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.772 -0400", hash_original_field = "45682D04D23E9DFA9A87C72737AEDE4C", hash_generated_field = "EB122BF46F1C40CB06087B3F34511BDC")

    private T mRoot;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.772 -0400", hash_original_field = "2243FD79B5ED841D9023629C87E90851", hash_generated_field = "47A76FA1CCA216BE1DAEAFB6D7AEE2F8")

    private int mPoolCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.773 -0400", hash_original_method = "E32E280D36A91DE3F8C1D108448A5172", hash_generated_method = "5E4FA79BA7201907DBEC838688972D4C")
      FinitePool(PoolableManager<T> manager) {
        mManager = manager;
        mLimit = 0;
        mInfinite = true;
        // ---------- Original Method ----------
        //mManager = manager;
        //mLimit = 0;
        //mInfinite = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.773 -0400", hash_original_method = "1F77D1F43E03D174D17C1D886C3B593A", hash_generated_method = "DD8A3842A3F3B01E9FC0FCFB394B1710")
      FinitePool(PoolableManager<T> manager, int limit) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The pool limit must be > 0");
        mManager = manager;
        mLimit = limit;
        mInfinite = false;
        // ---------- Original Method ----------
        //if (limit <= 0) throw new IllegalArgumentException("The pool limit must be > 0");
        //mManager = manager;
        //mLimit = limit;
        //mInfinite = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.785 -0400", hash_original_method = "7D07537AD43CB2EA058390D31632CED6", hash_generated_method = "5E8C46630362C19622807F1233DE7F06")
    public T acquire() {
        T varB4EAC82CA7396A68D541C85D26508E83_288955903 = null; //Variable for return #1
        T element;
        {
            element = mRoot;
            mRoot = element.getNextPoolable();
        } //End block
        {
            element = mManager.newInstance();
        } //End block
        {
            element.setNextPoolable(null);
            element.setPooled(false);
            mManager.onAcquired(element);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_288955903 = element;
        varB4EAC82CA7396A68D541C85D26508E83_288955903.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_288955903;
        // ---------- Original Method ----------
        //T element;
        //if (mRoot != null) {
            //element = mRoot;
            //mRoot = element.getNextPoolable();
            //mPoolCount--;
        //} else {
            //element = mManager.newInstance();
        //}
        //if (element != null) {
            //element.setNextPoolable(null);
            //element.setPooled(false);
            //mManager.onAcquired(element);            
        //}
        //return element;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.795 -0400", hash_original_method = "682D089BAC6076782B5E99EF5FBF0695", hash_generated_method = "B1E0E1D0A853644BC735F9A9D433EF7F")
    public void release(T element) {
        {
            boolean var5FC43357289D29F41938F96527965211_1607333110 = (!element.isPooled());
            {
                {
                    element.setNextPoolable(mRoot);
                    element.setPooled(true);
                    mRoot = element;
                } //End block
                mManager.onReleased(element);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!element.isPooled()) {
            //if (mInfinite || mPoolCount < mLimit) {
                //mPoolCount++;
                //element.setNextPoolable(mRoot);
                //element.setPooled(true);
                //mRoot = element;
            //}
            //mManager.onReleased(element);
        //} else {
            //Log.w(LOG_TAG, "Element is already in pool: " + element);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.795 -0400", hash_original_field = "AA4E01504FD4F01FA8D4A651DBDB41CA", hash_generated_field = "7466CB9DAC73FB50218C5DEA7F8DE077")

    private static String LOG_TAG = "FinitePool";
}

