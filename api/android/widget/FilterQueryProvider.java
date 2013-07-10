package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.database.Cursor;

public interface FilterQueryProvider {
    
    Cursor runQuery(CharSequence constraint);
}
