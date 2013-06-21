package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Matrix;
import java.io.PrintWriter;

public class Transformation {
    protected Matrix mMatrix;
    protected float mAlpha;
    protected int mTransformationType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.192 -0400", hash_original_method = "B51BFBC203820EC809B8E082E20903C2", hash_generated_method = "3F4DA68BCEF9BF3D04E9F77E20D14323")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Transformation() {
        clear();
        // ---------- Original Method ----------
        //clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.193 -0400", hash_original_method = "BA6C10BE71EC314AFE280F9349735494", hash_generated_method = "6F7AB4A86286C643C91F048E17B23CAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        {
            mMatrix = new Matrix();
        } //End block
        {
            mMatrix.reset();
        } //End block
        mAlpha = 1.0f;
        mTransformationType = TYPE_BOTH;
        // ---------- Original Method ----------
        //if (mMatrix == null) {
            //mMatrix = new Matrix();
        //} else {
            //mMatrix.reset();
        //}
        //mAlpha = 1.0f;
        //mTransformationType = TYPE_BOTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.193 -0400", hash_original_method = "8DFDD7EF6072FC95D95C5176557C9475", hash_generated_method = "4FFFC8FEB09B1D819D7665D6C1BD3643")
    @DSModeled(DSC.SAFE)
    public int getTransformationType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTransformationType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.193 -0400", hash_original_method = "B4636E05B9A8A9BE17FDDB51FD79878A", hash_generated_method = "833B3536F4EE1DFF01F4D8B49569EB6F")
    @DSModeled(DSC.SAFE)
    public void setTransformationType(int transformationType) {
        dsTaint.addTaint(transformationType);
        // ---------- Original Method ----------
        //mTransformationType = transformationType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.193 -0400", hash_original_method = "6A74ACE3E87C2A5E84C908FCAD2903E1", hash_generated_method = "8C515F6033E82649E5A95B2C0CEF8C76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(Transformation t) {
        dsTaint.addTaint(t.dsTaint);
        mAlpha = t.getAlpha();
        mMatrix.set(t.getMatrix());
        mTransformationType = t.getTransformationType();
        // ---------- Original Method ----------
        //mAlpha = t.getAlpha();
        //mMatrix.set(t.getMatrix());
        //mTransformationType = t.getTransformationType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.194 -0400", hash_original_method = "2FE33ABC0A8D366A40495EBCED9F5958", hash_generated_method = "96CD9417E384EA3DA4E5483BC48CF8B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void compose(Transformation t) {
        dsTaint.addTaint(t.dsTaint);
        mAlpha *= t.getAlpha();
        mMatrix.preConcat(t.getMatrix());
        // ---------- Original Method ----------
        //mAlpha *= t.getAlpha();
        //mMatrix.preConcat(t.getMatrix());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.195 -0400", hash_original_method = "2E54F4327BDE93D0CE557FC100DEED67", hash_generated_method = "04E344641999EB1FB0CD9BE0B0AC2C9C")
    @DSModeled(DSC.SAFE)
    public Matrix getMatrix() {
        return (Matrix)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mMatrix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.195 -0400", hash_original_method = "0C33009713633FC103F0B586FD422009", hash_generated_method = "66A60D267899DCD80F0B432A18D2E3DC")
    @DSModeled(DSC.SAFE)
    public void setAlpha(float alpha) {
        dsTaint.addTaint(alpha);
        // ---------- Original Method ----------
        //mAlpha = alpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.196 -0400", hash_original_method = "84CA63CC358414A9CD87B6516C604402", hash_generated_method = "70B1B0DC6A011146B47A2C3F1793327F")
    @DSModeled(DSC.SAFE)
    public float getAlpha() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mAlpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.196 -0400", hash_original_method = "6F2D8252A709B880F4404B074507697E", hash_generated_method = "C3DAF1F786CE22107729DFACEBCB2633")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(64);
        sb.append("Transformation");
        toShortString(sb);
        String var806458D832AB974D230FEE4CBBDBD390_3111940 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //sb.append("Transformation");
        //toShortString(sb);
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.197 -0400", hash_original_method = "9DDD7B6FB851EDEB6218261EF1A63117", hash_generated_method = "F42C34C5D4485E55FA41B3D387474922")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toShortString() {
        StringBuilder sb;
        sb = new StringBuilder(64);
        toShortString(sb);
        String var806458D832AB974D230FEE4CBBDBD390_1022594874 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //toShortString(sb);
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.197 -0400", hash_original_method = "1DD4705BF9B7609556F25B5998828696", hash_generated_method = "38B455E2EE239C58333C0CA825C96954")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void toShortString(StringBuilder sb) {
        dsTaint.addTaint(sb.dsTaint);
        sb.append("{alpha=");
        sb.append(mAlpha);
        sb.append(" matrix=");
        mMatrix.toShortString(sb);
        sb.append('}');
        // ---------- Original Method ----------
        //sb.append("{alpha=");
        //sb.append(mAlpha);
        //sb.append(" matrix=");
        //mMatrix.toShortString(sb);
        //sb.append('}');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.197 -0400", hash_original_method = "434986F5E9E4AD2D5C5ADC5B37E7986B", hash_generated_method = "E0AEBC98745DACC5D9A3382235C2A7D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void printShortString(PrintWriter pw) {
        dsTaint.addTaint(pw.dsTaint);
        pw.print("{alpha=");
        pw.print(mAlpha);
        pw.print(" matrix=");
        mMatrix.printShortString(pw);
        pw.print('}');
        // ---------- Original Method ----------
        //pw.print("{alpha=");
        //pw.print(mAlpha);
        //pw.print(" matrix=");
        //mMatrix.printShortString(pw);
        //pw.print('}');
    }

    
    public static int TYPE_IDENTITY = 0x0;
    public static int TYPE_ALPHA = 0x1;
    public static int TYPE_MATRIX = 0x2;
    public static int TYPE_BOTH = TYPE_ALPHA | TYPE_MATRIX;
}

