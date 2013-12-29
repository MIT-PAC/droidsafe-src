package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.util.AttributeSet;



@DSVAModeled
public class Button extends TextView {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:51.703 -0500", hash_original_method = "C06F98A3CD878B8C7E36A915748630BD", hash_generated_method = "4E2CDF635C0F1B9708513A26F512504C")
    public Button(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:51.704 -0500", hash_original_method = "073102849ED65AD03507E980F361FFAC", hash_generated_method = "4704B79E0E6CBD10A3B73B6A47B1FB82")
    public Button(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.buttonStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:51.705 -0500", hash_original_method = "2B23966CE985495BE71C0F8B526B5B54", hash_generated_method = "EB6CFCB3AF255214E9023F18D6D72464")
    public Button(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    
}

