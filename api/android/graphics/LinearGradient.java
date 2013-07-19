package android.graphics;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class LinearGradient extends Shader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.250 -0400", hash_original_method = "E21158B8192A6A62E47E5DB23E5C8298", hash_generated_method = "D485F6C080F42E6154FAB88C5D30A76B")
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
            IllegalArgumentException var38C288485201E20FEF77EEB0BDD8A17B_261792192 = new IllegalArgumentException("needs >= 2 number of colors");
            var38C288485201E20FEF77EEB0BDD8A17B_261792192.addTaint(taint);
            throw var38C288485201E20FEF77EEB0BDD8A17B_261792192;
        } //End block
        if(positions != null && colors.length != positions.length)        
        {
            IllegalArgumentException varFBD021BA7FC99ABEF82125BE636E6EF0_367577330 = new IllegalArgumentException("color and position arrays must be of equal length");
            varFBD021BA7FC99ABEF82125BE636E6EF0_367577330.addTaint(taint);
            throw varFBD021BA7FC99ABEF82125BE636E6EF0_367577330;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.252 -0400", hash_original_method = "138E7D6C6B15213658AC13EABF129E3A", hash_generated_method = "11EED24E4F210F48B8DCBAEC4926ADC9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.253 -0400", hash_original_method = "B94A77D14C5B8671FB729EA28F4EAAD5", hash_generated_method = "9ED47C5B88A9BEF7B95A2C67088CB080")
    private int nativeCreate1(float x0, float y0, float x1, float y1,
            int colors[], float positions[], int tileMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_174522854 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_174522854;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.253 -0400", hash_original_method = "CCD3C7044708751014C9FDE6E03EC148", hash_generated_method = "3D9411DE018759EA3639B74944BC4900")
    private int nativeCreate2(float x0, float y0, float x1, float y1,
            int color0, int color1, int tileMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_46069743 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_46069743;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.254 -0400", hash_original_method = "3D4FC89E238038D87C8D1AA41C910405", hash_generated_method = "552FE4A298D93D004A880E88492A0A6C")
    private int nativePostCreate1(int native_shader, float x0, float y0, float x1, float y1,
            int colors[], float positions[], int tileMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_199987309 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_199987309;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.255 -0400", hash_original_method = "9C29B9E72B1A16A8D3A2370F81F87105", hash_generated_method = "E45286B86C7EA83C089C4A6B492A5FE7")
    private int nativePostCreate2(int native_shader, float x0, float y0, float x1, float y1,
            int color0, int color1, int tileMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_346829333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_346829333;
    }

    
}

