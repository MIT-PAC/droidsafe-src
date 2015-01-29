package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.View;
import android.view.ViewGroup;

public interface SpinnerAdapter extends Adapter {
    @DSVerified
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public View getDropDownView(int position, View convertView, ViewGroup parent);
}
