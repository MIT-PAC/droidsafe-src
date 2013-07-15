package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;

public interface TransformationMethod
{
    
    public CharSequence getTransformation(CharSequence source, View view);

    
    public void onFocusChanged(View view, CharSequence sourceText,
                               boolean focused, int direction,
                               Rect previouslyFocusedRect);
}
