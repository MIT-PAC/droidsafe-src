package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.PrintWriter;

import android.graphics.Matrix;

public class Transformation {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.895 -0500", hash_original_field = "9704FF865769EA95AB8B88F86C46851B", hash_generated_field = "251BA68661EA4866D7BD703B646D7AF6")

    public static int TYPE_IDENTITY = 0x0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.897 -0500", hash_original_field = "56B1E603CF93A54EA93034525F96A0F7", hash_generated_field = "C5981F1CB9C9F8B672D5F5D6F97B014F")

    public static int TYPE_ALPHA = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.900 -0500", hash_original_field = "DAF5B4E170526D335007E29157D193D3", hash_generated_field = "EDE84DD947CCFB723011B78BBFE5AD41")

    public static int TYPE_MATRIX = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.902 -0500", hash_original_field = "7692363DCDE50976F42EF36FB082ACF5", hash_generated_field = "FC429AE0F94503BEF7A3ABEB76224BFA")

    public static int TYPE_BOTH = TYPE_ALPHA | TYPE_MATRIX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.905 -0500", hash_original_field = "ECC1E936684D992B258D335000C3D72A", hash_generated_field = "22DB0525CC1913C27DD5ABB85563881B")

    protected Matrix mMatrix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.908 -0500", hash_original_field = "1109060D01B8BF804FF00B533C2F6EC9", hash_generated_field = "57D7CB4B870C728DA589BE845D2CCF9A")

    protected float mAlpha;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.910 -0500", hash_original_field = "3C368F859FF2C6FEF4756EA691457826", hash_generated_field = "DB4B986E23B155A24C9B9B73A0081B20")

    protected int mTransformationType;
    
    @DSComment("no actions/not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
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

    /**
     * Indicates the nature of this transformation.
     *
     * @return {@link #TYPE_ALPHA}, {@link #TYPE_MATRIX},
     *         {@link #TYPE_BOTH} or {@link #TYPE_IDENTITY}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.917 -0500", hash_original_method = "8DFDD7EF6072FC95D95C5176557C9475", hash_generated_method = "E83AF2E7467626B14B9AB2FDD1E3526F")
    
public int getTransformationType() {
        return mTransformationType;
    }

    /**
     * Sets the transformation type.
     *
     * @param transformationType One of {@link #TYPE_ALPHA},
     *        {@link #TYPE_MATRIX}, {@link #TYPE_BOTH} or
     *        {@link #TYPE_IDENTITY}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.920 -0500", hash_original_method = "B4636E05B9A8A9BE17FDDB51FD79878A", hash_generated_method = "BEB3418C17DAC73B52B3B6CF91BF5785")
    
public void setTransformationType(int transformationType) {
        mTransformationType = transformationType;
    }

    /**
     * Clones the specified transformation.
     *
     * @param t The transformation to clone.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.922 -0500", hash_original_method = "6A74ACE3E87C2A5E84C908FCAD2903E1", hash_generated_method = "FB97CDADAEF57BCB0A2A4BF697D806B5")
    
public void set(Transformation t) {
        mAlpha = t.getAlpha();
        mMatrix.set(t.getMatrix());
        mTransformationType = t.getTransformationType();
    }
    
    /**
     * Apply this Transformation to an existing Transformation, e.g. apply
     * a scale effect to something that has already been rotated.
     * @param t
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.924 -0500", hash_original_method = "2FE33ABC0A8D366A40495EBCED9F5958", hash_generated_method = "AEFE42ADD2D2344BC1E390875D1D1047")
    
public void compose(Transformation t) {
        mAlpha *= t.getAlpha();
        mMatrix.preConcat(t.getMatrix());
    }
    
    /**
     * @return The 3x3 Matrix representing the trnasformation to apply to the
     * coordinates of the object being animated
     */
    @DSComment("no actions/not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.926 -0500", hash_original_method = "2E54F4327BDE93D0CE557FC100DEED67", hash_generated_method = "AC792DF5DA6D0C3559608A10F5A9B778")
    
public Matrix getMatrix() {
        return mMatrix;
    }
    
    /**
     * Sets the degree of transparency
     * @param alpha 1.0 means fully opaqe and 0.0 means fully transparent
     */
    @DSComment("no actions/not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.928 -0500", hash_original_method = "0C33009713633FC103F0B586FD422009", hash_generated_method = "B215FC12BBF0BB31CC65FC8A77253541")
    
public void setAlpha(float alpha) {
        mAlpha = alpha;
    }

    /**
     * @return The degree of transparency
     */
    @DSComment("no actions/not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.931 -0500", hash_original_method = "84CA63CC358414A9CD87B6516C604402", hash_generated_method = "BB0D60558DFDFA2BC395B22614DE6493")
    
public float getAlpha() {
        return mAlpha;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.933 -0500", hash_original_method = "6F2D8252A709B880F4404B074507697E", hash_generated_method = "783FC16ADCE7A491E5FF35F599778DD7")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Transformation");
        toShortString(sb);
        return sb.toString();
    }
    
    /**
     * Return a string representation of the transformation in a compact form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.935 -0500", hash_original_method = "9DDD7B6FB851EDEB6218261EF1A63117", hash_generated_method = "E0AB274C134F13D11EEA12E8EFF7137F")
    
public String toShortString() {
        StringBuilder sb = new StringBuilder(64);
        toShortString(sb);
        return sb.toString();
    }
    
    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.938 -0500", hash_original_method = "1DD4705BF9B7609556F25B5998828696", hash_generated_method = "EB0C86EA0367DF9E56CE0E396B815498")
    
public void toShortString(StringBuilder sb) {
        sb.append("{alpha="); sb.append(mAlpha);
        sb.append(" matrix="); mMatrix.toShortString(sb);
        sb.append('}');
    }
    
    /**
     * Print short string, to optimize dumping.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.941 -0500", hash_original_method = "434986F5E9E4AD2D5C5ADC5B37E7986B", hash_generated_method = "6DB1D1D6641E40B427D761E20F6339C6")
    
public void printShortString(PrintWriter pw) {
        pw.print("{alpha="); pw.print(mAlpha);
        pw.print(" matrix=");
        mMatrix.printShortString(pw);
        pw.print('}');
    }
}

