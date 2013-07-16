package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Matrix;
import java.io.PrintWriter;

public class Transformation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.990 -0400", hash_original_field = "9FEB0FB4D7668A1A69C2CCE86D8FE6AA", hash_generated_field = "22DB0525CC1913C27DD5ABB85563881B")

    protected Matrix mMatrix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.990 -0400", hash_original_field = "7574041472B9B2E76867A37482E74343", hash_generated_field = "57D7CB4B870C728DA589BE845D2CCF9A")

    protected float mAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.990 -0400", hash_original_field = "E809ABB3554FAD67C52E87DB28F12771", hash_generated_field = "DB4B986E23B155A24C9B9B73A0081B20")

    protected int mTransformationType;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.990 -0400", hash_original_method = "B51BFBC203820EC809B8E082E20903C2", hash_generated_method = "3F4DA68BCEF9BF3D04E9F77E20D14323")
    public  Transformation() {
        clear();
        // ---------- Original Method ----------
        //clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.991 -0400", hash_original_method = "BA6C10BE71EC314AFE280F9349735494", hash_generated_method = "83AC86B6E75EBDD895DE2CB56E889E5B")
    public void clear() {
    if(mMatrix == null)        
        {
            mMatrix = new Matrix();
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.991 -0400", hash_original_method = "8DFDD7EF6072FC95D95C5176557C9475", hash_generated_method = "540AE450E8ED864228FB5C0DC1CF6495")
    public int getTransformationType() {
        int varE809ABB3554FAD67C52E87DB28F12771_1375712427 = (mTransformationType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263598833 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263598833;
        // ---------- Original Method ----------
        //return mTransformationType;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.991 -0400", hash_original_method = "B4636E05B9A8A9BE17FDDB51FD79878A", hash_generated_method = "39AC39ACD4F7908E138EDFE8ECD24ED9")
    public void setTransformationType(int transformationType) {
        mTransformationType = transformationType;
        // ---------- Original Method ----------
        //mTransformationType = transformationType;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.992 -0400", hash_original_method = "6A74ACE3E87C2A5E84C908FCAD2903E1", hash_generated_method = "AA3A3FDF21E49D36483D40C6AB86DBDC")
    public void set(Transformation t) {
        mAlpha = t.getAlpha();
        mMatrix.set(t.getMatrix());
        mTransformationType = t.getTransformationType();
        // ---------- Original Method ----------
        //mAlpha = t.getAlpha();
        //mMatrix.set(t.getMatrix());
        //mTransformationType = t.getTransformationType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.992 -0400", hash_original_method = "2FE33ABC0A8D366A40495EBCED9F5958", hash_generated_method = "B2C134E54DEE8C2414C9FCCC7ADE8EB3")
    public void compose(Transformation t) {
        mAlpha *= t.getAlpha();
        mMatrix.preConcat(t.getMatrix());
        // ---------- Original Method ----------
        //mAlpha *= t.getAlpha();
        //mMatrix.preConcat(t.getMatrix());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.993 -0400", hash_original_method = "2E54F4327BDE93D0CE557FC100DEED67", hash_generated_method = "2331EC2C00652F69357B22091433A957")
    public Matrix getMatrix() {
Matrix var49A816397330451E1FD30BEA000F3851_1270977908 =         mMatrix;
        var49A816397330451E1FD30BEA000F3851_1270977908.addTaint(taint);
        return var49A816397330451E1FD30BEA000F3851_1270977908;
        // ---------- Original Method ----------
        //return mMatrix;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.993 -0400", hash_original_method = "0C33009713633FC103F0B586FD422009", hash_generated_method = "C9CD91170EA13924C0FBD5C314E4E67F")
    public void setAlpha(float alpha) {
        mAlpha = alpha;
        // ---------- Original Method ----------
        //mAlpha = alpha;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.993 -0400", hash_original_method = "84CA63CC358414A9CD87B6516C604402", hash_generated_method = "7187A556A5BF42863ED51A9ADAFBE484")
    public float getAlpha() {
        float var7574041472B9B2E76867A37482E74343_908194804 = (mAlpha);
                float var546ADE640B6EDFBC8A086EF31347E768_751498866 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_751498866;
        // ---------- Original Method ----------
        //return mAlpha;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.994 -0400", hash_original_method = "6F2D8252A709B880F4404B074507697E", hash_generated_method = "A38E5271B41326A74D795930D4AA4967")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Transformation");
        toShortString(sb);
String var2460B846747F8B22185AD8BE722266A5_825600311 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_825600311.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_825600311;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //sb.append("Transformation");
        //toShortString(sb);
        //return sb.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.994 -0400", hash_original_method = "9DDD7B6FB851EDEB6218261EF1A63117", hash_generated_method = "D9095526A9CEAD7031223F9941517BA1")
    public String toShortString() {
        StringBuilder sb = new StringBuilder(64);
        toShortString(sb);
String var2460B846747F8B22185AD8BE722266A5_1012984187 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1012984187.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1012984187;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //toShortString(sb);
        //return sb.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.994 -0400", hash_original_method = "1DD4705BF9B7609556F25B5998828696", hash_generated_method = "829B61668E32909A783B8000FB54F779")
    public void toShortString(StringBuilder sb) {
        addTaint(sb.getTaint());
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.995 -0400", hash_original_method = "434986F5E9E4AD2D5C5ADC5B37E7986B", hash_generated_method = "D7B21699736F25ACFD6128B78A3CEF97")
    public void printShortString(PrintWriter pw) {
        addTaint(pw.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.995 -0400", hash_original_field = "F11818DB7A7EB00BD5D53554D7B55ECA", hash_generated_field = "251BA68661EA4866D7BD703B646D7AF6")

    public static int TYPE_IDENTITY = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.995 -0400", hash_original_field = "98513AF7915E6589ABC1AC130C2FE67F", hash_generated_field = "C5981F1CB9C9F8B672D5F5D6F97B014F")

    public static int TYPE_ALPHA = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.995 -0400", hash_original_field = "2A6B39DACDDCF846D9229B4F5D21874A", hash_generated_field = "EDE84DD947CCFB723011B78BBFE5AD41")

    public static int TYPE_MATRIX = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.995 -0400", hash_original_field = "5D9EBA6F42EFD79BCEF2AD687D2845E4", hash_generated_field = "FC429AE0F94503BEF7A3ABEB76224BFA")

    public static int TYPE_BOTH = TYPE_ALPHA | TYPE_MATRIX;
}

