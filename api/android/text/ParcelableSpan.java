package android.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcelable;

public interface ParcelableSpan extends Parcelable {
    
    public abstract int getSpanTypeId();
}
