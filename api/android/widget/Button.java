package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.KeyEvent;
import android.widget.RemoteViews.RemoteView;

public class Button extends TextView {
    
    @DSModeled(DSC.SAFE)
    public Button(Context context) {
        this(context, null);
    }

    
    @DSModeled(DSC.SAFE)
    public Button(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.buttonStyle);
    }

    
    @DSModeled(DSC.SAFE)
    public Button(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    
}

