package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.View;
import android.view.ViewGroup;

public interface SpinnerAdapter extends Adapter {
    
    public View getDropDownView(int position, View convertView, ViewGroup parent);
}
