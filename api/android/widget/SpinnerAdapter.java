package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.view.View;
import android.view.ViewGroup;

public interface SpinnerAdapter extends Adapter {
    
    public View getDropDownView(int position, View convertView, ViewGroup parent);
}
