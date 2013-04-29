package android.database;

import java.util.ArrayList;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public abstract class Observable<T> {
	protected final ArrayList<T> mObservers = new ArrayList<T>();
	
	private DSTaintObject dsTaint = new DSTaintObject();
	
	@DSModeled(DSC.SAFE)
	public Observable() {
		//Does not exist in original implementation
	}
	
	public void registerObserver(T observer) {
		dsTaint.addTaint(observer);
		/*
        if (observer == null) {
            throw new IllegalArgumentException("The observer is null.");
        }
        synchronized(mObservers) {
            if (mObservers.contains(observer)) {
                throw new IllegalStateException("Observer " + observer + " is already registered.");
            }
            mObservers.add(observer);
        }
        */
		mObservers.add(observer);
    }
	
	
	public void unregisterObserver(T observer) {
		/*
        if (observer == null) {
            throw new IllegalArgumentException("The observer is null.");
        }
        synchronized(mObservers) {
            int index = mObservers.indexOf(observer);
            if (index == -1) {
                throw new IllegalStateException("Observer " + observer + " was not registered.");
            }
            mObservers.remove(index);
        }
        */
		int index = mObservers.indexOf(observer);
		mObservers.remove(index);
    }
}
