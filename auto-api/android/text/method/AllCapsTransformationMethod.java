package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.util.Locale;

public class AllCapsTransformationMethod implements TransformationMethod2 {
    private static final String TAG = "AllCapsTransformationMethod";
    private boolean mEnabled;
    private Locale mLocale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.022 -0400", hash_original_method = "3B95B7992FFC661A96A84916391DF4EA", hash_generated_method = "C8C4E1B3E40DD571E3D6E2D55DE8D5E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AllCapsTransformationMethod(Context context) {
        dsTaint.addTaint(context.dsTaint);
        mLocale = context.getResources().getConfiguration().locale;
        // ---------- Original Method ----------
        //mLocale = context.getResources().getConfiguration().locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.023 -0400", hash_original_method = "78672DB29526C1EED454DBBBA0FA4686", hash_generated_method = "F0E5874BA67804B506065A835B8B6912")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharSequence getTransformation(CharSequence source, View view) {
        dsTaint.addTaint(source);
        dsTaint.addTaint(view.dsTaint);
        {
            {
                Object varD5698F773F2973FDF607339ADFAFC26E_908905498 = (source.toString().toUpperCase(mLocale));
            } //End flattened ternary
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mEnabled) {
            //return source != null ? source.toString().toUpperCase(mLocale) : null;
        //}
        //Log.w(TAG, "Caller did not enable length changes; not transforming text");
        //return source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.023 -0400", hash_original_method = "13D8211EBDC6D4196EF2DDB70ED5CACD", hash_generated_method = "ACBBE34C8AF2D69D0CA6DF2CFCF06B75")
    @DSModeled(DSC.SAFE)
    @Override
    public void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(sourceText);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focused);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.023 -0400", hash_original_method = "507549025152D254EA227D255598B5AF", hash_generated_method = "80FB82D18479F8E887EA138C3C55B59E")
    @DSModeled(DSC.SAFE)
    @Override
    public void setLengthChangesAllowed(boolean allowLengthChanges) {
        dsTaint.addTaint(allowLengthChanges);
        // ---------- Original Method ----------
        //mEnabled = allowLengthChanges;
    }

    
}


