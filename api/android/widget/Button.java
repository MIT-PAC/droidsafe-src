package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.util.AttributeSet;



@DSVAModeled
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

