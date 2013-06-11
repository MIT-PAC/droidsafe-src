package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface TextWatcher extends NoCopySpan {
    
    public void beforeTextChanged(CharSequence s, int start,
                                  int count, int after);
    
    public void onTextChanged(CharSequence s, int start, int before, int count);

    
    public void afterTextChanged(Editable s);
}

