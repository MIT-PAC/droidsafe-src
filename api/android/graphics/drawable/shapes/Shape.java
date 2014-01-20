package android.graphics.drawable.shapes;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Shape implements Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.793 -0500", hash_original_field = "8BEDDF49B8B9212E63E741BD6656B2A4", hash_generated_field = "08D9327CB0A0089C173FB95F7B57B648")

    private float mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.795 -0500", hash_original_field = "2674BC94EE6F0A8B8E52BD7CB368BD8B", hash_generated_field = "AB7D3C8140C4809E830D256F2E315AC4")

    private float mHeight;
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.862 -0400", hash_original_method = "DE7169FFA3F4BAA3781895C367880AD0", hash_generated_method = "DE7169FFA3F4BAA3781895C367880AD0")
    public Shape ()
    {
        //Synthesized constructor
    }
    
    /**
     * Returns the width of the Shape.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.797 -0500", hash_original_method = "AE68E159D936DCF4407D65307DCA00BB", hash_generated_method = "2EBC100F8EEA435FCFB1D71DF02003DC")
    
public final float getWidth() {
        return mWidth;
    }
    
    /**
     * Returns the height of the Shape.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.799 -0500", hash_original_method = "DE764EE6028A1B0E9211313F1870FFB9", hash_generated_method = "CE68295D107697A1A2FEF1CEA5826C51")
    
public final float getHeight() {
        return mHeight;
    }

    /**
     * Draw this shape into the provided Canvas, with the provided Paint.
     * Before calling this, you must call {@link #resize(float,float)}.
     * 
     * @param canvas the Canvas within which this shape should be drawn
     * @param paint  the Paint object that defines this shape's characteristics
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.801 -0500", hash_original_method = "4FF66B2B9CB8872729DAA8331BAA7F65", hash_generated_method = "186226CA2153FE9A17149A68400BA41E")
    
public abstract void draw(Canvas canvas, Paint paint);

    /**
     * Resizes the dimensions of this shape.
     * Must be called before {@link #draw(Canvas,Paint)}.
     * 
     * @param width the width of the shape (in pixels)
     * @param height the height of the shape (in pixels)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.804 -0500", hash_original_method = "479131B2F6B84573C2C45F62E9B9CD93", hash_generated_method = "A96EE469A7660E14176DAC899CD05FF0")
    
public final void resize(float width, float height) {
        if (width < 0) {
            width = 0;
        }
        if (height < 0) {
            height =0;
        }
        if (mWidth != width || mHeight != height) {
            mWidth = width;
            mHeight = height;
            onResize(width, height);
        }
    }
    
    /**
     * Checks whether the Shape is opaque.
     * Default impl returns true. Override if your subclass can be opaque.
     * 
     * @return true if any part of the drawable is <em>not</em> opaque. 
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.806 -0500", hash_original_method = "E1C0EB5C360EF4564AFB59E1743F2057", hash_generated_method = "DF84950A2941C3F2A1543A61F396C2BD")
    
public boolean hasAlpha() {
        return true;
    }
    
    /**
     * Callback method called when {@link #resize(float,float)} is executed.
     * 
     * @param width the new width of the Shape
     * @param height the new height of the Shape
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.808 -0500", hash_original_method = "BE42972290D2C4FCDE54C91B730EEF2B", hash_generated_method = "10737606103A81DBA34BDDD300C5ED40")
    
protected void onResize(float width, float height) {}

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.810 -0500", hash_original_method = "581DCFE006AA020FE949D9FFE91E7EA5", hash_generated_method = "9FCC5714555E11C6EA6BBEBB14179B05")
    
@Override
    public Shape clone() throws CloneNotSupportedException {
        return (Shape) super.clone();
    }
    
}

