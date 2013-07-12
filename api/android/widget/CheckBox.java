package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import com.android.internal.R;

public class CheckBox extends CompoundButton {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.806 -0400", hash_original_method = "07A60C33F591AF3364367476C757E191", hash_generated_method = "57493A5C7895739BD4734FFF00FA922D")
    public  CheckBox(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.807 -0400", hash_original_method = "8805AB2AC1AEC0E9A85C20D3125221E0", hash_generated_method = "DACE10FF5A2974B3ED9E683BE919A59F")
    public  CheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.checkboxStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.807 -0400", hash_original_method = "DC2D9AD560E05B0AD2F1F269CCCF9F57", hash_generated_method = "F127D2D7B82FE520F6469CE003365D91")
    public  CheckBox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.808 -0400", hash_original_method = "270C42284D505CD6CA182328DD88ED30", hash_generated_method = "33B1C9AD6A033C3BD2091B162CBC8505")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        
        addTaint(event.getTaint());
        super.onPopulateAccessibilityEvent(event);
    if(isChecked())        
        {
            event.getText().add(mContext.getString(R.string.checkbox_checked));
        } 
        else
        {
            event.getText().add(mContext.getString(R.string.checkbox_not_checked));
        } 
        
        
        
            
        
            
        
    }

    
}

