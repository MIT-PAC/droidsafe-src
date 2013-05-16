package android.database;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public abstract class DataSetObserver {
	@DSModeled(DSC.SAFE)
	public void onChanged() {
        // Do nothing
    }
	
	@DSModeled(DSC.SAFE)
	public void onInvalidated() {
        // Do nothing
    }
}
