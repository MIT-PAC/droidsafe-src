package android.text;

// Droidsafe Imports
import android.os.Parcelable;

public interface ParcelableSpan extends Parcelable {
    
    public abstract int getSpanTypeId();
}
