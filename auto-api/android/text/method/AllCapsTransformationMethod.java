package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.util.Locale;

public class AllCapsTransformationMethod implements TransformationMethod2 {
    private boolean mEnabled;
    private Locale mLocale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.137 -0400", hash_original_method = "3B95B7992FFC661A96A84916391DF4EA", hash_generated_method = "8AA15B204151EAD4BF0FC3F39F5D019C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AllCapsTransformationMethod(Context context) {
        dsTaint.addTaint(context.dsTaint);
        mLocale = context.getResources().getConfiguration().locale;
        // ---------- Original Method ----------
        //mLocale = context.getResources().getConfiguration().locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.137 -0400", hash_original_method = "78672DB29526C1EED454DBBBA0FA4686", hash_generated_method = "DD8A898E3FC347DC8C9BC5705A50C688")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharSequence getTransformation(CharSequence source, View view) {
        dsTaint.addTaint(source);
        dsTaint.addTaint(view.dsTaint);
        {
            {
                Object varD5698F773F2973FDF607339ADFAFC26E_655603752 = (source.toString().toUpperCase(mLocale));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.137 -0400", hash_original_method = "13D8211EBDC6D4196EF2DDB70ED5CACD", hash_generated_method = "5907AE7D302F7F32670C8209E0899341")
    @DSModeled(DSC.SAFE)
    @Override
    public void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(direction);
        dsTaint.addTaint(sourceText);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        dsTaint.addTaint(focused);
        dsTaint.addTaint(view.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.138 -0400", hash_original_method = "507549025152D254EA227D255598B5AF", hash_generated_method = "98284F2FA41F6604620F01511FDB8330")
    @DSModeled(DSC.SAFE)
    @Override
    public void setLengthChangesAllowed(boolean allowLengthChanges) {
        dsTaint.addTaint(allowLengthChanges);
        // ---------- Original Method ----------
        //mEnabled = allowLengthChanges;
    }

    
    private static final String TAG = "AllCapsTransformationMethod";
}

