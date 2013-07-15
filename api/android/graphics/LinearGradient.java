package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class LinearGradient extends Shader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.290 -0400", hash_original_method = "E21158B8192A6A62E47E5DB23E5C8298", hash_generated_method = "7B0582EB5220F9F0E91051AB9705963C")
    public  LinearGradient(float x0, float y0, float x1, float y1,
                          int colors[], float positions[], TileMode tile) {
        addTaint(tile.getTaint());
        addTaint(positions[0]);
        addTaint(colors[0]);
        addTaint(y1);
        addTaint(x1);
        addTaint(y0);
        addTaint(x0);
    if(colors.length < 2)        
        {
            IllegalArgumentException var38C288485201E20FEF77EEB0BDD8A17B_259008828 = new IllegalArgumentException("needs >= 2 number of colors");
            var38C288485201E20FEF77EEB0BDD8A17B_259008828.addTaint(taint);
            throw var38C288485201E20FEF77EEB0BDD8A17B_259008828;
        } //End block
    if(positions != null && colors.length != positions.length)        
        {
            IllegalArgumentException varFBD021BA7FC99ABEF82125BE636E6EF0_859196121 = new IllegalArgumentException("color and position arrays must be of equal length");
            varFBD021BA7FC99ABEF82125BE636E6EF0_859196121.addTaint(taint);
            throw varFBD021BA7FC99ABEF82125BE636E6EF0_859196121;
        } //End block
        native_instance = nativeCreate1(x0, y0, x1, y1, colors, positions, tile.nativeInt);
        native_shader = nativePostCreate1(native_instance, x0, y0, x1, y1, colors, positions,
                tile.nativeInt);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.291 -0400", hash_original_method = "138E7D6C6B15213658AC13EABF129E3A", hash_generated_method = "11EED24E4F210F48B8DCBAEC4926ADC9")
    public  LinearGradient(float x0, float y0, float x1, float y1,
                          int color0, int color1, TileMode tile) {
        addTaint(tile.getTaint());
        addTaint(color1);
        addTaint(color0);
        addTaint(y1);
        addTaint(x1);
        addTaint(y0);
        addTaint(x0);
        native_instance = nativeCreate2(x0, y0, x1, y1, color0, color1, tile.nativeInt);
        native_shader = nativePostCreate2(native_instance, x0, y0, x1, y1, color0, color1,
                tile.nativeInt);
        // ---------- Original Method ----------
        //native_instance = nativeCreate2(x0, y0, x1, y1, color0, color1, tile.nativeInt);
        //native_shader = nativePostCreate2(native_instance, x0, y0, x1, y1, color0, color1,
                //tile.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.292 -0400", hash_original_method = "B94A77D14C5B8671FB729EA28F4EAAD5", hash_generated_method = "40B1B4D7920539C65AC47A360D8EBFB0")
    private int nativeCreate1(float x0, float y0, float x1, float y1,
            int colors[], float positions[], int tileMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_848783906 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_848783906;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.293 -0400", hash_original_method = "CCD3C7044708751014C9FDE6E03EC148", hash_generated_method = "91FCE77C91602F83842C55A4663C895F")
    private int nativeCreate2(float x0, float y0, float x1, float y1,
            int color0, int color1, int tileMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413682177 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413682177;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.294 -0400", hash_original_method = "3D4FC89E238038D87C8D1AA41C910405", hash_generated_method = "32743CC8FC9102B7D7EA09F3ABA58C89")
    private int nativePostCreate1(int native_shader, float x0, float y0, float x1, float y1,
            int colors[], float positions[], int tileMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762763982 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762763982;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.294 -0400", hash_original_method = "9C29B9E72B1A16A8D3A2370F81F87105", hash_generated_method = "E3866EDC39E5C99CA7073F2B76ACE001")
    private int nativePostCreate2(int native_shader, float x0, float y0, float x1, float y1,
            int color0, int color1, int tileMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_532712297 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_532712297;
    }

    
}

