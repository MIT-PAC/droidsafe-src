package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;

public interface ParcelableSpan extends Parcelable {
    
    public abstract int getSpanTypeId();
}
