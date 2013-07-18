package android.text.method;

// Droidsafe Imports
import java.util.Locale;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class AllCapsTransformationMethod implements TransformationMethod2 {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.843 -0400", hash_original_field = "6F84A7F10C955D3C78F44E5278F6195B", hash_generated_field = "7A48C52BD142368ED44BC086FD9013A2")

    private boolean mEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.843 -0400", hash_original_field = "CF3890B8F9E27793E741F9D9569D3C34", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.843 -0400", hash_original_method = "3B95B7992FFC661A96A84916391DF4EA", hash_generated_method = "3EE0716C8BD5BB93DA9729F2D1CDECCC")
    public  AllCapsTransformationMethod(Context context) {
        mLocale = context.getResources().getConfiguration().locale;
        // ---------- Original Method ----------
        //mLocale = context.getResources().getConfiguration().locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.843 -0400", hash_original_method = "78672DB29526C1EED454DBBBA0FA4686", hash_generated_method = "AE0CA9521CCA3AC1CB7353246586CA1C")
    @Override
    public CharSequence getTransformation(CharSequence source, View view) {
        addTaint(view.getTaint());
        addTaint(source.getTaint());
        if(mEnabled)        
        {
CharSequence varD44AA49AC93BEB4F58E5B4142583FDE2_1733781574 =             source != null ? source.toString().toUpperCase(mLocale) : null;
            varD44AA49AC93BEB4F58E5B4142583FDE2_1733781574.addTaint(taint);
            return varD44AA49AC93BEB4F58E5B4142583FDE2_1733781574;
        } //End block
CharSequence var87D92E4D22D3928BDE6A72969186AF86_54797354 =         source;
        var87D92E4D22D3928BDE6A72969186AF86_54797354.addTaint(taint);
        return var87D92E4D22D3928BDE6A72969186AF86_54797354;
        // ---------- Original Method ----------
        //if (mEnabled) {
            //return source != null ? source.toString().toUpperCase(mLocale) : null;
        //}
        //Log.w(TAG, "Caller did not enable length changes; not transforming text");
        //return source;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.843 -0400", hash_original_method = "13D8211EBDC6D4196EF2DDB70ED5CACD", hash_generated_method = "01EA32A40C08E89031D903EDB0FF1C9F")
    @Override
    public void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        addTaint(focused);
        addTaint(sourceText.getTaint());
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.843 -0400", hash_original_method = "507549025152D254EA227D255598B5AF", hash_generated_method = "6202744402AD62DFF59CB62A9EF703E9")
    @Override
    public void setLengthChangesAllowed(boolean allowLengthChanges) {
        mEnabled = allowLengthChanges;
        // ---------- Original Method ----------
        //mEnabled = allowLengthChanges;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.843 -0400", hash_original_field = "44949DAF78AF0DE5B9E1A5EBD105B256", hash_generated_field = "4F51E6D9C8017CC0D76D6E29A09B68C6")

    private static final String TAG = "AllCapsTransformationMethod";
}

