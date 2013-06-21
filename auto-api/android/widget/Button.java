package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.KeyEvent;
import android.widget.RemoteViews.RemoteView;

public class Button extends TextView {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.347 -0400", hash_original_method = "C06F98A3CD878B8C7E36A915748630BD", hash_generated_method = "0819D76B824588B390ECBD973114CB20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Button(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.347 -0400", hash_original_method = "073102849ED65AD03507E980F361FFAC", hash_generated_method = "10565F185C7CD6FF74C71B464A7E5B27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Button(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.buttonStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.347 -0400", hash_original_method = "2B23966CE985495BE71C0F8B526B5B54", hash_generated_method = "EA936853D0C356A3D9ABCC7E0ABD4DDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Button(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
}

