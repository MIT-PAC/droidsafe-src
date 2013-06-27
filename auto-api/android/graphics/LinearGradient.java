package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class LinearGradient extends Shader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.026 -0400", hash_original_method = "E21158B8192A6A62E47E5DB23E5C8298", hash_generated_method = "24CAFA479A98150D13D836B237869017")
    public  LinearGradient(float x0, float y0, float x1, float y1,
                          int colors[], float positions[], TileMode tile) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("needs >= 2 number of colors");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("color and position arrays must be of equal length");
        } //End block
        native_instance = nativeCreate1(x0, y0, x1, y1, colors, positions, tile.nativeInt);
        native_shader = nativePostCreate1(native_instance, x0, y0, x1, y1, colors, positions,
                tile.nativeInt);
        addTaint(x0);
        addTaint(y0);
        addTaint(x1);
        addTaint(y1);
        addTaint(colors);
        addTaint(positions);
        addTaint(tile.getTaint());
        // ---------- Original Method ----------
        //if (colors.length < 2) {
            //throw new IllegalArgumentException("needs >= 2 number of colors");
        //}
        //if (positions != null && colors.length != positions.length) {
            //throw new IllegalArgumentException("color and position arrays must be of equal length");
        //}
        //native_instance = nativeCreate1(x0, y0, x1, y1, colors, positions, tile.nativeInt);
        //native_shader = nativePostCreate1(native_instance, x0, y0, x1, y1, colors, positions,
                //tile.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.027 -0400", hash_original_method = "138E7D6C6B15213658AC13EABF129E3A", hash_generated_method = "42C8961BD65093AE777D9AF004D99C63")
    public  LinearGradient(float x0, float y0, float x1, float y1,
                          int color0, int color1, TileMode tile) {
        native_instance = nativeCreate2(x0, y0, x1, y1, color0, color1, tile.nativeInt);
        native_shader = nativePostCreate2(native_instance, x0, y0, x1, y1, color0, color1,
                tile.nativeInt);
        addTaint(x0);
        addTaint(y0);
        addTaint(x1);
        addTaint(y1);
        addTaint(color0);
        addTaint(color1);
        addTaint(tile.getTaint());
        // ---------- Original Method ----------
        //native_instance = nativeCreate2(x0, y0, x1, y1, color0, color1, tile.nativeInt);
        //native_shader = nativePostCreate2(native_instance, x0, y0, x1, y1, color0, color1,
                //tile.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.028 -0400", hash_original_method = "B94A77D14C5B8671FB729EA28F4EAAD5", hash_generated_method = "63276F7572C4871BD58A41059BD0CB6A")
    private int nativeCreate1(float x0, float y0, float x1, float y1,
            int colors[], float positions[], int tileMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372877970 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372877970;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.028 -0400", hash_original_method = "CCD3C7044708751014C9FDE6E03EC148", hash_generated_method = "0EF27B80D992A83E982ABC1290DF499E")
    private int nativeCreate2(float x0, float y0, float x1, float y1,
            int color0, int color1, int tileMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_602789406 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_602789406;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.054 -0400", hash_original_method = "3D4FC89E238038D87C8D1AA41C910405", hash_generated_method = "15BE7B03FECA62974D3F5266DBBF8FA8")
    private int nativePostCreate1(int native_shader, float x0, float y0, float x1, float y1,
            int colors[], float positions[], int tileMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645688803 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645688803;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.054 -0400", hash_original_method = "9C29B9E72B1A16A8D3A2370F81F87105", hash_generated_method = "43B8ED8A37E1CB6AC1A48BD2E107F3EE")
    private int nativePostCreate2(int native_shader, float x0, float y0, float x1, float y1,
            int color0, int color1, int tileMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_426178726 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_426178726;
    }

    
}

