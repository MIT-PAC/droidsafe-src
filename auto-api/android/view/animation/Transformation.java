package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.graphics.Matrix;
import java.io.PrintWriter;

public class Transformation {
    public static int TYPE_IDENTITY = 0x0;
    public static int TYPE_ALPHA = 0x1;
    public static int TYPE_MATRIX = 0x2;
    public static int TYPE_BOTH = TYPE_ALPHA | TYPE_MATRIX;
    protected Matrix mMatrix;
    protected float mAlpha;
    protected int mTransformationType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.875 -0400", hash_original_method = "B51BFBC203820EC809B8E082E20903C2", hash_generated_method = "A39A5FCF52CCF0340D9DABC062F7E13A")
    @DSModeled(DSC.SAFE)
    public Transformation() {
        clear();
        // ---------- Original Method ----------
        //clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.876 -0400", hash_original_method = "BA6C10BE71EC314AFE280F9349735494", hash_generated_method = "C2CBCFEFC73786EAE29A5A736B46B1C4")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.876 -0400", hash_original_method = "8DFDD7EF6072FC95D95C5176557C9475", hash_generated_method = "BF867E218A306488011AD18F2A448A0E")
    @DSModeled(DSC.SAFE)
    public int getTransformationType() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTransformationType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.876 -0400", hash_original_method = "B4636E05B9A8A9BE17FDDB51FD79878A", hash_generated_method = "3A59F85C30DBA76D9D6808E1C88DE660")
    @DSModeled(DSC.SAFE)
    public void setTransformationType(int transformationType) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(transformationType);
        // ---------- Original Method ----------
        //mTransformationType = transformationType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.876 -0400", hash_original_method = "6A74ACE3E87C2A5E84C908FCAD2903E1", hash_generated_method = "44094E881BC9C26F73247922A7956318")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.876 -0400", hash_original_method = "2FE33ABC0A8D366A40495EBCED9F5958", hash_generated_method = "0B8BFAF67CC2C519201F50395A74D1BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void compose(Transformation t) {
        dsTaint.addTaint(t.dsTaint);
        mAlpha *= t.getAlpha();
        mMatrix.preConcat(t.getMatrix());
        // ---------- Original Method ----------
        //mAlpha *= t.getAlpha();
        //mMatrix.preConcat(t.getMatrix());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.876 -0400", hash_original_method = "2E54F4327BDE93D0CE557FC100DEED67", hash_generated_method = "BDE6D64AF6D48B1D5AB81BF18691D9BC")
    @DSModeled(DSC.SAFE)
    public Matrix getMatrix() {
        return (Matrix)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mMatrix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.876 -0400", hash_original_method = "0C33009713633FC103F0B586FD422009", hash_generated_method = "39BC475CB01542CA9BBCDC2101BB5863")
    @DSModeled(DSC.SAFE)
    public void setAlpha(float alpha) {
        dsTaint.addTaint(alpha);
        // ---------- Original Method ----------
        //mAlpha = alpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.876 -0400", hash_original_method = "84CA63CC358414A9CD87B6516C604402", hash_generated_method = "222D50DCEF441BE06A38FBF58E42509E")
    @DSModeled(DSC.SAFE)
    public float getAlpha() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mAlpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.876 -0400", hash_original_method = "6F2D8252A709B880F4404B074507697E", hash_generated_method = "2D940FF670493A4CD99F8542CE6C553E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(64);
        sb.append("Transformation");
        toShortString(sb);
        String var806458D832AB974D230FEE4CBBDBD390_524448930 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //sb.append("Transformation");
        //toShortString(sb);
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.876 -0400", hash_original_method = "9DDD7B6FB851EDEB6218261EF1A63117", hash_generated_method = "4142ED7744384A1B51751E06387A5F28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toShortString() {
        StringBuilder sb;
        sb = new StringBuilder(64);
        toShortString(sb);
        String var806458D832AB974D230FEE4CBBDBD390_1036817160 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //toShortString(sb);
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.876 -0400", hash_original_method = "1DD4705BF9B7609556F25B5998828696", hash_generated_method = "1C65D550201D9D838F683A490CBA57F1")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.876 -0400", hash_original_method = "434986F5E9E4AD2D5C5ADC5B37E7986B", hash_generated_method = "A8817B04F9D8566B4D531B087D1A3386")
    @DSModeled(DSC.SAFE)
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

    
}


