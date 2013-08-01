package android.view.animation;

// Droidsafe Imports
import java.io.PrintWriter;

import android.graphics.Matrix;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Transformation {
    protected Matrix mMatrix;
    protected float mAlpha;
    protected int mTransformationType;
    
    @DSModeled(DSC.SAFE)
    public Transformation() {
        mMatrix = new Matrix();
    }

    
    @DSModeled(DSC.SAFE)
    public void clear() {
        mAlpha = 1.0f;
        mTransformationType = TYPE_BOTH;
        mMatrix.reset();
        addTaint(mAlpha);
        addTaint(mTransformationType);
    }

    
    @DSModeled(DSC.SAFE)
    public int getTransformationType() {
        return mTransformationType;
    }

    
    @DSModeled(DSC.SAFE)
    public void setTransformationType(int transformationType) {
        mTransformationType = transformationType;
    }

    
    @DSModeled(DSC.SAFE)
    public void set(Transformation t) {
        mAlpha = t.getAlpha();
        mMatrix.set(t.getMatrix());
        mTransformationType = t.getTransformationType();
    }

    
    @DSModeled(DSC.SAFE)
    public void compose(Transformation t) {
        mAlpha *= t.getAlpha();
        mMatrix.preConcat(t.getMatrix());
    }

    
    @DSModeled(DSC.SAFE)
    public Matrix getMatrix() {
        return mMatrix;
    }

    
    @DSModeled(DSC.SAFE)
    public void setAlpha(float alpha) {
        mAlpha = alpha;
    }

    
    @DSModeled(DSC.SAFE)
    public float getAlpha() {
        return mAlpha;
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Transformation");
        toShortString(sb);
        return sb.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public String toShortString() {
        StringBuilder sb = new StringBuilder(64);
        toShortString(sb);
        return sb.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public void toShortString(StringBuilder sb) {
        sb.append("{alpha="); sb.append(mAlpha);
        sb.append(" matrix="); mMatrix.toShortString(sb);
        sb.append('}');
    }

    
    @DSModeled(DSC.SAFE)
    public void printShortString(PrintWriter pw) {
        pw.print("{alpha="); pw.print(mAlpha);
        pw.print(" matrix=");
        mMatrix.printShortString(pw);
        pw.print('}');
    }

    
    public static int TYPE_IDENTITY = 0x0;
    public static int TYPE_ALPHA = 0x1;
    public static int TYPE_MATRIX = 0x2;
    public static int TYPE_BOTH = TYPE_ALPHA | TYPE_MATRIX;
}

