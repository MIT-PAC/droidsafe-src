package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.view.View;
import android.view.ViewGroup;

public interface SpinnerAdapter extends Adapter {
    
    public View getDropDownView(int position, View convertView, ViewGroup parent);
}

