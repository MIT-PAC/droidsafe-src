package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class FinitePool<T extends Poolable<T>> implements Pool<T> {
    private PoolableManager<T> mManager;
    private int mLimit;
    private boolean mInfinite;
    private T mRoot;
    private int mPoolCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.205 -0400", hash_original_method = "E32E280D36A91DE3F8C1D108448A5172", hash_generated_method = "63FB5C978491A189CBD6252C7C105952")
    @DSModeled(DSC.SAFE)
     FinitePool(PoolableManager<T> manager) {
        dsTaint.addTaint(manager.dsTaint);
        mLimit = 0;
        mInfinite = true;
        // ---------- Original Method ----------
        //mManager = manager;
        //mLimit = 0;
        //mInfinite = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.205 -0400", hash_original_method = "1F77D1F43E03D174D17C1D886C3B593A", hash_generated_method = "308C96B2CBC3235273E76EB3355F9635")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     FinitePool(PoolableManager<T> manager, int limit) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(manager.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The pool limit must be > 0");
        mInfinite = false;
        // ---------- Original Method ----------
        //if (limit <= 0) throw new IllegalArgumentException("The pool limit must be > 0");
        //mManager = manager;
        //mLimit = limit;
        //mInfinite = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.205 -0400", hash_original_method = "7D07537AD43CB2EA058390D31632CED6", hash_generated_method = "CE2B8376CE1DE397A1685AEB4186B7E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public T acquire() {
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
        return (T)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.206 -0400", hash_original_method = "682D089BAC6076782B5E99EF5FBF0695", hash_generated_method = "A0122544B921FA3D57A4B99B57541C6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void release(T element) {
        dsTaint.addTaint(element.dsTaint);
        {
            boolean var5FC43357289D29F41938F96527965211_1240167030 = (!element.isPooled());
            {
                {
                    element.setNextPoolable(mRoot);
                    element.setPooled(true);
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

    
    private static final String LOG_TAG = "FinitePool";
}

