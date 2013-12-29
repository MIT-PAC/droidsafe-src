package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;



class FinitePool<T extends Poolable<T>> implements Pool<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.308 -0500", hash_original_field = "FAA5BCD910EC1E96EA623DF5F9CEA72D", hash_generated_field = "D4F5669F7C6CCD0730D510AE50304291")

    private static final String LOG_TAG = "FinitePool";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.309 -0500", hash_original_field = "16FBDD2BED1206CEC60A401E12BAABBE", hash_generated_field = "263F1F5C5ECE190F0DC9583236769778")

    private  PoolableManager<T> mManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.310 -0500", hash_original_field = "EAF07362CB0DE5A45A6B09193DE62144", hash_generated_field = "4EC83DFC67A77EF18032B269F8E92E02")

    private  int mLimit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.310 -0500", hash_original_field = "5F66AC836C96A4F0FB471E9F80C20A7B", hash_generated_field = "B7F8D9172C7DAC966FA21394C9C9EF7B")

    private  boolean mInfinite;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.311 -0500", hash_original_field = "C8D6B6F7C1C2F627F3D8DF452F81C02E", hash_generated_field = "EB122BF46F1C40CB06087B3F34511BDC")

    private T mRoot;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.312 -0500", hash_original_field = "29DF88CD5F34B848D47EE667C3590F54", hash_generated_field = "47A76FA1CCA216BE1DAEAFB6D7AEE2F8")

    private int mPoolCount;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.313 -0500", hash_original_method = "E32E280D36A91DE3F8C1D108448A5172", hash_generated_method = "E32E280D36A91DE3F8C1D108448A5172")
    FinitePool(PoolableManager<T> manager) {
        mManager = manager;
        mLimit = 0;
        mInfinite = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.314 -0500", hash_original_method = "1F77D1F43E03D174D17C1D886C3B593A", hash_generated_method = "1F77D1F43E03D174D17C1D886C3B593A")
    FinitePool(PoolableManager<T> manager, int limit) {
        if (limit <= 0) throw new IllegalArgumentException("The pool limit must be > 0");

        mManager = manager;
        mLimit = limit;
        mInfinite = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.315 -0500", hash_original_method = "7D07537AD43CB2EA058390D31632CED6", hash_generated_method = "25EC2E1E8019CE33B6E038EDB65A21D2")
    public T acquire() {
        T element;

        if (mRoot != null) {
            element = mRoot;
            mRoot = element.getNextPoolable();
            mPoolCount--;
        } else {
            element = mManager.newInstance();
        }

        if (element != null) {
            element.setNextPoolable(null);
            element.setPooled(false);
            mManager.onAcquired(element);            
        }

        return element;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.315 -0500", hash_original_method = "682D089BAC6076782B5E99EF5FBF0695", hash_generated_method = "F538286E773F35276867A20EC59412BD")
    public void release(T element) {
        if (!element.isPooled()) {
            if (mInfinite || mPoolCount < mLimit) {
                mPoolCount++;
                element.setNextPoolable(mRoot);
                element.setPooled(true);
                mRoot = element;
            }
            mManager.onReleased(element);
        } else {
            Log.w(LOG_TAG, "Element is already in pool: " + element);
        }
    }
}

