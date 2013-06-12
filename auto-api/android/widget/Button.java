package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.KeyEvent;
import android.widget.RemoteViews.RemoteView;

public class Button extends TextView {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.473 -0400", hash_original_method = "C06F98A3CD878B8C7E36A915748630BD", hash_generated_method = "F70136A5DEA32206252409FB14473445")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Button(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.473 -0400", hash_original_method = "073102849ED65AD03507E980F361FFAC", hash_generated_method = "731C7740C07EE78F60852344FAC7A264")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Button(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.buttonStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.473 -0400", hash_original_method = "2B23966CE985495BE71C0F8B526B5B54", hash_generated_method = "988F7C6A5FFAA185DF330E5D320B8A5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Button(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
}


