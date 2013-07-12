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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.601 -0400", hash_original_method = "C06F98A3CD878B8C7E36A915748630BD", hash_generated_method = "BB2AD8BE0F1709E096019A62C4A67755")
    public  Button(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.601 -0400", hash_original_method = "073102849ED65AD03507E980F361FFAC", hash_generated_method = "903412A071D9D67B0490A97A692CB249")
    public  Button(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.buttonStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.602 -0400", hash_original_method = "2B23966CE985495BE71C0F8B526B5B54", hash_generated_method = "106ABEA1634FC9D920F477249C530AE9")
    public  Button(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
}

