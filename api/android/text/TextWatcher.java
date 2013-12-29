package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface TextWatcher extends NoCopySpan {
    
    public void beforeTextChanged(CharSequence s, int start,
                                  int count, int after);
    
    public void onTextChanged(CharSequence s, int start, int before, int count);

    
    public void afterTextChanged(Editable s);
}
