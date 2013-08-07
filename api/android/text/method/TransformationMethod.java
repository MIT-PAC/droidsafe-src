package android.text.method;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.graphics.Rect;
import android.view.View;

public interface TransformationMethod
{
    
    public CharSequence getTransformation(CharSequence source, View view);

    
    public void onFocusChanged(View view, CharSequence sourceText,
                               boolean focused, int direction,
                               Rect previouslyFocusedRect);
}
