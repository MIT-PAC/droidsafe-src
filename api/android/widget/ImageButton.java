package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.util.AttributeSet;




public class ImageButton extends ImageView {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.382 -0500", hash_original_method = "D776EEA4260F4386B702AF839A43C27E", hash_generated_method = "C4490DFFEC8CC44950F038A265528F56")
    
public ImageButton(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.385 -0500", hash_original_method = "69F1C1BA5F8D6B6EC679242C32E07C96", hash_generated_method = "D61FED03873F5B8C666507C499CDA227")
    
public ImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.imageButtonStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.388 -0500", hash_original_method = "47E1B94896A9BFD998FAA5ACD5A61A9C", hash_generated_method = "0910C04E3E6A0C6A0E44C286DD0A6402")
    
public ImageButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFocusable(true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.390 -0500", hash_original_method = "DC47911C20E58BC47F643D76AAAF3E73", hash_generated_method = "45E11B8C629AB0C29234776BDCC9C9B0")
    
@Override
    protected boolean onSetAlpha(int alpha) {
        return false;
    }

    
}

