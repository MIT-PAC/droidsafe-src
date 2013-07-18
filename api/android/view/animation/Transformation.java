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

    
    public void clear() {
        mAlpha = 1.0f;
        mTransformationType = TYPE_BOTH;
        mMatrix.reset();
        addTaint(mAlpha);
        addTaint(mTransformationType);
    }

    
    public int getTransformationType() {
        return mTransformationType;
    }

    
    public void setTransformationType(int transformationType) {
        mTransformationType = transformationType;
    }

    
    public void set(Transformation t) {
        mAlpha = t.getAlpha();
        mMatrix.set(t.getMatrix());
        mTransformationType = t.getTransformationType();
    }

    
    public void compose(Transformation t) {
        mAlpha *= t.getAlpha();
        mMatrix.preConcat(t.getMatrix());
    }

    
    public Matrix getMatrix() {
        return mMatrix;
    }

    
    public void setAlpha(float alpha) {
        mAlpha = alpha;
    }

    
    public float getAlpha() {
        return mAlpha;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Transformation");
        toShortString(sb);
        return sb.toString();
    }

    
    public String toShortString() {
        StringBuilder sb = new StringBuilder(64);
        toShortString(sb);
        return sb.toString();
    }

    
    public void toShortString(StringBuilder sb) {
        sb.append("{alpha="); sb.append(mAlpha);
        sb.append(" matrix="); mMatrix.toShortString(sb);
        sb.append('}');
    }

    
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

