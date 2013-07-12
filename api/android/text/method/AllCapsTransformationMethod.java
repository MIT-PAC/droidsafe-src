package android.text.method;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.util.Locale;

public class AllCapsTransformationMethod implements TransformationMethod2 {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.250 -0400", hash_original_field = "6F84A7F10C955D3C78F44E5278F6195B", hash_generated_field = "7A48C52BD142368ED44BC086FD9013A2")

    private boolean mEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.250 -0400", hash_original_field = "CF3890B8F9E27793E741F9D9569D3C34", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.250 -0400", hash_original_method = "3B95B7992FFC661A96A84916391DF4EA", hash_generated_method = "3EE0716C8BD5BB93DA9729F2D1CDECCC")
    public  AllCapsTransformationMethod(Context context) {
        mLocale = context.getResources().getConfiguration().locale;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.251 -0400", hash_original_method = "78672DB29526C1EED454DBBBA0FA4686", hash_generated_method = "732D7E2DD7F8A23D10D1A7F3F68971E2")
    @Override
    public CharSequence getTransformation(CharSequence source, View view) {
        addTaint(view.getTaint());
        addTaint(source.getTaint());
    if(mEnabled)        
        {
CharSequence varD44AA49AC93BEB4F58E5B4142583FDE2_1731523836 =             source != null ? source.toString().toUpperCase(mLocale) : null;
            varD44AA49AC93BEB4F58E5B4142583FDE2_1731523836.addTaint(taint);
            return varD44AA49AC93BEB4F58E5B4142583FDE2_1731523836;
        } 
CharSequence var87D92E4D22D3928BDE6A72969186AF86_1737606110 =         source;
        var87D92E4D22D3928BDE6A72969186AF86_1737606110.addTaint(taint);
        return var87D92E4D22D3928BDE6A72969186AF86_1737606110;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.251 -0400", hash_original_method = "13D8211EBDC6D4196EF2DDB70ED5CACD", hash_generated_method = "01EA32A40C08E89031D903EDB0FF1C9F")
    @Override
    public void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction,
            Rect previouslyFocusedRect) {
        
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        addTaint(focused);
        addTaint(sourceText.getTaint());
        addTaint(view.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.251 -0400", hash_original_method = "507549025152D254EA227D255598B5AF", hash_generated_method = "6202744402AD62DFF59CB62A9EF703E9")
    @Override
    public void setLengthChangesAllowed(boolean allowLengthChanges) {
        mEnabled = allowLengthChanges;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.252 -0400", hash_original_field = "44949DAF78AF0DE5B9E1A5EBD105B256", hash_generated_field = "4F51E6D9C8017CC0D76D6E29A09B68C6")

    private static final String TAG = "AllCapsTransformationMethod";
}

