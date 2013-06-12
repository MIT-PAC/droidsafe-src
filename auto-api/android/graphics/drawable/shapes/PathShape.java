package android.graphics.drawable.shapes;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class PathShape extends Shape {
    private Path    mPath;
    private float   mStdWidth;
    private float   mStdHeight;
    private float   mScaleX;
    private float   mScaleY;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:13:25.909 -0400", hash_original_method = "D5FE69E7915F1F0AEE9B2C6A959CB284", hash_generated_method = "9B9815848550DFCC141E2962E759CB5B")
    @DSModeled(DSC.SAFE)
    public PathShape(Path path, float stdWidth, float stdHeight) {
        dsTaint.addTaint(stdWidth);
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(stdHeight);
        // ---------- Original Method ----------
        //mPath = path;
        //mStdWidth = stdWidth;
        //mStdHeight = stdHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:13:25.914 -0400", hash_original_method = "11356F6E40B6080EC6A142D2D7D6F297", hash_generated_method = "657832165FE6D295479C1554438A604C")
    @DSModeled(DSC.SAFE)
    @Override
    public void draw(Canvas canvas, Paint paint) {
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        canvas.save();
        canvas.scale(mScaleX, mScaleY);
        canvas.drawPath(mPath, paint);
        canvas.restore();
        // ---------- Original Method ----------
        //canvas.save();
        //canvas.scale(mScaleX, mScaleY);
        //canvas.drawPath(mPath, paint);
        //canvas.restore();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:13:25.919 -0400", hash_original_method = "1E6491C957E70DFF6060793A74ABACB4", hash_generated_method = "F2B9779D8DFE9F83B7F4DAE51E9741F2")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onResize(float width, float height) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        mScaleX = width / mStdWidth;
        mScaleY = height / mStdHeight;
        // ---------- Original Method ----------
        //mScaleX = width / mStdWidth;
        //mScaleY = height / mStdHeight;
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-12 11:10:59.466 -0400",hash_original_method="50BD3A54D860E4E23C838C59D748E4B2",hash_generated_method="27FFD633F0A9D1F0F1E36C27F66387F5")
@Override
    public PathShape clone() throws CloneNotSupportedException {
        PathShape shape;
        shape = (PathShape) super.clone();
        shape.mPath = new Path(mPath);
        return (PathShape)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PathShape shape = (PathShape) super.clone();
        //shape.mPath = new Path(mPath);
        //return shape;
    }

    
}


