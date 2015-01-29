package android.graphics.drawable.shapes;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class RectShape extends Shape {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.868 -0500", hash_original_field = "499D59727FC656C05DFD3E86493F2A86", hash_generated_field = "E080B89EC7A364FFC5B71FB812B38393")

    private RectF mRect = new RectF();
    
    /**
     * RectShape constructor.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.870 -0500", hash_original_method = "86D7394A029CE4FDE438585868C447F4", hash_generated_method = "EC5781DC7AC5EFDE946C3D218DF4DE25")
    
public RectShape() {}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.872 -0500", hash_original_method = "6BDD25C71E92DEE23AC033397583FF85", hash_generated_method = "D491C0BAAE13D6ABD26109B94459C615")
    
@Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawRect(mRect, paint);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.875 -0500", hash_original_method = "62B0D2225FCA5D4099BD1D1E514DF479", hash_generated_method = "0E0257AB5295FC7A2707F3B86C8F57BE")
    
@Override
    protected void onResize(float width, float height) {
        mRect.set(0, 0, width, height);
    }
    
    /**
     * Returns the RectF that defines this rectangle's bounds.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.877 -0500", hash_original_method = "B472369E445B34AFDD84E5B389A9601D", hash_generated_method = "7E96FE508A65015DCC33416C426C9ABB")
    
protected final RectF rect() {
        return mRect;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.879 -0500", hash_original_method = "F35F96D345FDD22204E61750D42DDCE2", hash_generated_method = "9A677C1BB30000268489CBC29CF67DCC")
    
@Override
    public RectShape clone() throws CloneNotSupportedException {
        final RectShape shape = (RectShape) super.clone();
        shape.mRect = new RectF(mRect);
        return shape;
    }
    
}

