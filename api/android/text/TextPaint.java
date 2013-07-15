package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Paint;

public class TextPaint extends Paint {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.155 -0400", hash_original_field = "F4E054AD68D86FAA3DE848C731B7ADD9", hash_generated_field = "EB7BBC6E5D9DF7183393887C906C4F9C")

    public int bgColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.155 -0400", hash_original_field = "F0F69BF9358BDE45DECAB08638D530A7", hash_generated_field = "4DED743B5FA3E5D7F4883CAE8C2F36F3")

    public int baselineShift;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.155 -0400", hash_original_field = "C51DF778C6116A54F11F666E246AAE32", hash_generated_field = "4E2C9CBDEF424AC57FBE0273164EE548")

    public int linkColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.155 -0400", hash_original_field = "7A12E87773589D809FD51F1A26B9BDA9", hash_generated_field = "9E6126665E3E6AB45DFE77252B8A8CD0")

    public int[] drawableState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.156 -0400", hash_original_field = "CD67E498D3B5E7759721D75041666DA0", hash_generated_field = "9A849DADA5F16B5B92F73273AB33B9F5")

    public float density = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.156 -0400", hash_original_field = "52D642FD78591A3B94C7FBEE5888E6DB", hash_generated_field = "BF6908E922790BD6999F21445CD79883")

    public int underlineColor = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.156 -0400", hash_original_field = "CD6B23D3483044334D64D6575239746D", hash_generated_field = "14A5494972706A263F4C27898CA0F26A")

    public float underlineThickness;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.156 -0400", hash_original_method = "618AB1B9CBAFB419831828FB2E1722C9", hash_generated_method = "184089B139E22F497C16BD8D371A9B08")
    public  TextPaint() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.157 -0400", hash_original_method = "512D920DE77B40AA9B525CC82C9BBF96", hash_generated_method = "DE922740154B87E22B3BB98FB3439983")
    public  TextPaint(int flags) {
        super(flags);
        addTaint(flags);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.157 -0400", hash_original_method = "EB2846FC8EC35D49B4CB30B890D5BAE5", hash_generated_method = "CF91856792D1C86756E14BC914E80401")
    public  TextPaint(Paint p) {
        super(p);
        addTaint(p.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.159 -0400", hash_original_method = "1430CF075B6F082AE7C06C83102C116C", hash_generated_method = "37AB51D9D211DE70358C29A3C6CE36E8")
    public void set(TextPaint tp) {
        super.set(tp);
        bgColor = tp.bgColor;
        baselineShift = tp.baselineShift;
        linkColor = tp.linkColor;
        drawableState = tp.drawableState;
        density = tp.density;
        underlineColor = tp.underlineColor;
        underlineThickness = tp.underlineThickness;
        // ---------- Original Method ----------
        //super.set(tp);
        //bgColor = tp.bgColor;
        //baselineShift = tp.baselineShift;
        //linkColor = tp.linkColor;
        //drawableState = tp.drawableState;
        //density = tp.density;
        //underlineColor = tp.underlineColor;
        //underlineThickness = tp.underlineThickness;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.160 -0400", hash_original_method = "398799A16623F5BF0623CBD73B973047", hash_generated_method = "3690268F0ABD1784A1E205BC780E2E16")
    public void setUnderlineText(int color, float thickness) {
        underlineColor = color;
        underlineThickness = thickness;
        // ---------- Original Method ----------
        //underlineColor = color;
        //underlineThickness = thickness;
    }

    
}

