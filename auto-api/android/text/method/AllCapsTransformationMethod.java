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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.569 -0400", hash_original_field = "6F84A7F10C955D3C78F44E5278F6195B", hash_generated_field = "7A48C52BD142368ED44BC086FD9013A2")

    private boolean mEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.569 -0400", hash_original_field = "CF3890B8F9E27793E741F9D9569D3C34", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.570 -0400", hash_original_method = "3B95B7992FFC661A96A84916391DF4EA", hash_generated_method = "3EE0716C8BD5BB93DA9729F2D1CDECCC")
    public  AllCapsTransformationMethod(Context context) {
        mLocale = context.getResources().getConfiguration().locale;
        // ---------- Original Method ----------
        //mLocale = context.getResources().getConfiguration().locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.592 -0400", hash_original_method = "78672DB29526C1EED454DBBBA0FA4686", hash_generated_method = "C109883739B236E8E3CA19D71D30AEEE")
    @Override
    public CharSequence getTransformation(CharSequence source, View view) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_87184554 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1934514251 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_87184554 = source != null ? source.toString().toUpperCase(mLocale) : null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1934514251 = source;
        addTaint(source.getTaint());
        addTaint(view.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_740097730; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_740097730 = varB4EAC82CA7396A68D541C85D26508E83_87184554;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_740097730 = varB4EAC82CA7396A68D541C85D26508E83_1934514251;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_740097730.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_740097730;
        // ---------- Original Method ----------
        //if (mEnabled) {
            //return source != null ? source.toString().toUpperCase(mLocale) : null;
        //}
        //Log.w(TAG, "Caller did not enable length changes; not transforming text");
        //return source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.592 -0400", hash_original_method = "13D8211EBDC6D4196EF2DDB70ED5CACD", hash_generated_method = "9D159F53239E26DFAC6C4F4E8981C85A")
    @Override
    public void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(view.getTaint());
        addTaint(sourceText.getTaint());
        addTaint(focused);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.593 -0400", hash_original_method = "507549025152D254EA227D255598B5AF", hash_generated_method = "6202744402AD62DFF59CB62A9EF703E9")
    @Override
    public void setLengthChangesAllowed(boolean allowLengthChanges) {
        mEnabled = allowLengthChanges;
        // ---------- Original Method ----------
        //mEnabled = allowLengthChanges;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.593 -0400", hash_original_field = "44949DAF78AF0DE5B9E1A5EBD105B256", hash_generated_field = "2B7C81C08CF9D2F61154F79061CF4EBD")

    private static String TAG = "AllCapsTransformationMethod";
}

