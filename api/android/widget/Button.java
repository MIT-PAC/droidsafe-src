package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.util.AttributeSet;



@DSVAModeled
public class Button extends TextView {
   
    @DSVAModeled
    private String TEXT;
    
    @DSModeled(DSC.SAFE) 
    public void setTextDS(String text) {
        this.TEXT = text;
    }
    
    
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

