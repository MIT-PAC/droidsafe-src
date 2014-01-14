package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Paint;

public class TextPaint extends Paint {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.466 -0500", hash_original_field = "0910FC77EF934A081A1665762C691AA7", hash_generated_field = "EB7BBC6E5D9DF7183393887C906C4F9C")

    public int bgColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.468 -0500", hash_original_field = "B5E4A759A9C92EF66EC896D90959AB52", hash_generated_field = "4DED743B5FA3E5D7F4883CAE8C2F36F3")

    public int baselineShift;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.470 -0500", hash_original_field = "0FB4446631D461CC755CC9B774B02B6A", hash_generated_field = "4E2C9CBDEF424AC57FBE0273164EE548")

    public int linkColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.473 -0500", hash_original_field = "C0E72C99BED1745170AD14FA8A5CAD22", hash_generated_field = "9E6126665E3E6AB45DFE77252B8A8CD0")

    public int[] drawableState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.475 -0500", hash_original_field = "DD1896BB3AB95B4218D2883983C42912", hash_generated_field = "9A849DADA5F16B5B92F73273AB33B9F5")

    public float density = 1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.478 -0500", hash_original_field = "B6BBF0E2E9B258A6DD1CC660E0383CEB", hash_generated_field = "BF6908E922790BD6999F21445CD79883")

    public int underlineColor = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.481 -0500", hash_original_field = "EE52EA72C6FFF34B74A5E4388E11378A", hash_generated_field = "14A5494972706A263F4C27898CA0F26A")

    public float underlineThickness;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.484 -0500", hash_original_method = "618AB1B9CBAFB419831828FB2E1722C9", hash_generated_method = "C575E1DCDBDEE9AED8D052E4AC8C657D")
    
public TextPaint() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.486 -0500", hash_original_method = "512D920DE77B40AA9B525CC82C9BBF96", hash_generated_method = "79B96FBDA5657F44CDB027702F8F1EF9")
    
public TextPaint(int flags) {
        super(flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.489 -0500", hash_original_method = "EB2846FC8EC35D49B4CB30B890D5BAE5", hash_generated_method = "42344769384791985B9DB0746B0EA27A")
    
public TextPaint(Paint p) {
        super(p);
    }

    /**
     * Copy the fields from tp into this TextPaint, including the
     * fields inherited from Paint.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.491 -0500", hash_original_method = "1430CF075B6F082AE7C06C83102C116C", hash_generated_method = "A4C11FF678332E47FFA1D2F56710455A")
    
public void set(TextPaint tp) {
        super.set(tp);

        bgColor = tp.bgColor;
        baselineShift = tp.baselineShift;
        linkColor = tp.linkColor;
        drawableState = tp.drawableState;
        density = tp.density;
        underlineColor = tp.underlineColor;
        underlineThickness = tp.underlineThickness;
    }

    /**
     * Defines a custom underline for this Paint.
     * @param color underline solid color
     * @param thickness underline thickness
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.494 -0500", hash_original_method = "398799A16623F5BF0623CBD73B973047", hash_generated_method = "0EBF4431921869C78567056BE8830C59")
    
public void setUnderlineText(int color, float thickness) {
        underlineColor = color;
        underlineThickness = thickness;
    }
    
}

