package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.FloatMath;

public class ColorMatrix {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.195 -0400", hash_original_field = "715644611DDEB8B9E5B07CF83EAF2601", hash_generated_field = "EB497EE5AD03BD0F08D38D6437611B86")

    private final float[] mArray = new float[20];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.196 -0400", hash_original_method = "7C280C0D6BD3CA85A908B9065390FD08", hash_generated_method = "6DEF39A3008ED08D4A1B025A428FE1FD")
    public  ColorMatrix() {
        reset();
        // ---------- Original Method ----------
        //reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.196 -0400", hash_original_method = "E88FC6AE9EAD423F2D43BC5A2B86150F", hash_generated_method = "7E4012C738026800C49D63F2B3F72F99")
    public  ColorMatrix(float[] src) {
        addTaint(src[0]);
        System.arraycopy(src, 0, mArray, 0, 20);
        // ---------- Original Method ----------
        //System.arraycopy(src, 0, mArray, 0, 20);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.196 -0400", hash_original_method = "668D89CF48F3ADC6BE7AF94D782DA652", hash_generated_method = "616C3AD70D489E51A138B69F12C5E978")
    public  ColorMatrix(ColorMatrix src) {
        addTaint(src.getTaint());
        System.arraycopy(src.mArray, 0, mArray, 0, 20);
        // ---------- Original Method ----------
        //System.arraycopy(src.mArray, 0, mArray, 0, 20);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.197 -0400", hash_original_method = "C51050FB528280ED78B19148B7D68B9E", hash_generated_method = "F94980ED8D6C60A3FA36AA3A32A735E3")
    public final float[] getArray() {
        float[] var982501881A3C318D6605E92D3AB0ADBA_1443116554 = (mArray);
                float[] varB2C245003BAB9224CFB496218F7DAFE0_1182492703 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_1182492703;
        // ---------- Original Method ----------
        //return mArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.197 -0400", hash_original_method = "651EAEC497B28FBE14AC71396739DF99", hash_generated_method = "C9802DD4B14A25277F01312014A8FD63")
    public void reset() {
        final float[] a = mArray;
for(int i = 19;i > 0;--i)
        {
            a[i] = 0;
        } //End block
        a[0] = a[6] = a[12] = a[18] = 1;
        // ---------- Original Method ----------
        //final float[] a = mArray;
        //for (int i = 19; i > 0; --i) {
            //a[i] = 0;
        //}
        //a[0] = a[6] = a[12] = a[18] = 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.198 -0400", hash_original_method = "9919D3B45BE014B7359BBBE4E1EE27A7", hash_generated_method = "065A1847BB1E5D640A8807F6DE1383E5")
    public void set(ColorMatrix src) {
        addTaint(src.getTaint());
        System.arraycopy(src.mArray, 0, mArray, 0, 20);
        // ---------- Original Method ----------
        //System.arraycopy(src.mArray, 0, mArray, 0, 20);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.198 -0400", hash_original_method = "1B16B7E11AFFA7F8CD6600BA7D48EFFB", hash_generated_method = "D838F37399C99E8E26F096B5AF24E813")
    public void set(float[] src) {
        addTaint(src[0]);
        System.arraycopy(src, 0, mArray, 0, 20);
        // ---------- Original Method ----------
        //System.arraycopy(src, 0, mArray, 0, 20);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.200 -0400", hash_original_method = "0974414711261BF80A4D723D743AAB06", hash_generated_method = "0253D4D01530EF96653929C114A0FF57")
    public void setScale(float rScale, float gScale, float bScale,
                         float aScale) {
        addTaint(aScale);
        addTaint(bScale);
        addTaint(gScale);
        addTaint(rScale);
        final float[] a = mArray;
for(int i = 19;i > 0;--i)
        {
            a[i] = 0;
        } //End block
        a[0] = rScale;
        a[6] = gScale;
        a[12] = bScale;
        a[18] = aScale;
        // ---------- Original Method ----------
        //final float[] a = mArray;
        //for (int i = 19; i > 0; --i) {
            //a[i] = 0;
        //}
        //a[0] = rScale;
        //a[6] = gScale;
        //a[12] = bScale;
        //a[18] = aScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.201 -0400", hash_original_method = "F365836E7CADE057885AC91CF063AD58", hash_generated_method = "0545F47EDDECE2199D3623E523109B0C")
    public void setRotate(int axis, float degrees) {
        addTaint(degrees);
        addTaint(axis);
        reset();
        float radians = degrees * (float)Math.PI / 180;
        float cosine = FloatMath.cos(radians);
        float sine = FloatMath.sin(radians);
switch(axis){
        case 0:
        mArray[6] = mArray[12] = cosine;
        mArray[7] = sine;
        mArray[11] = -sine;
        break;
        case 1:
        mArray[0] = mArray[12] = cosine;
        mArray[2] = -sine;
        mArray[10] = sine;
        break;
        case 2:
        mArray[0] = mArray[6] = cosine;
        mArray[1] = sine;
        mArray[5] = -sine;
        break;
        default:
        RuntimeException varF1484B21EF4EE84F790184975238945B_211780597 = new RuntimeException();
        varF1484B21EF4EE84F790184975238945B_211780597.addTaint(taint);
        throw varF1484B21EF4EE84F790184975238945B_211780597;
}
        // ---------- Original Method ----------
        //reset();
        //float radians = degrees * (float)Math.PI / 180;
        //float cosine = FloatMath.cos(radians);
        //float sine = FloatMath.sin(radians);
        //switch (axis) {
        //case 0:
            //mArray[6] = mArray[12] = cosine;
            //mArray[7] = sine;
            //mArray[11] = -sine;
            //break;
        //case 1:
            //mArray[0] = mArray[12] = cosine;
            //mArray[2] = -sine;
            //mArray[10] = sine;
            //break;
        //case 2:
            //mArray[0] = mArray[6] = cosine;
            //mArray[1] = sine;
            //mArray[5] = -sine;
            //break;
        //default:
            //throw new RuntimeException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.203 -0400", hash_original_method = "843BB575BEC1DC3153103BA70AD6226C", hash_generated_method = "072AF0A4277C4BB9FFEFE9C149E03E1B")
    public void setConcat(ColorMatrix matA, ColorMatrix matB) {
        addTaint(matB.getTaint());
        addTaint(matA.getTaint());
        float[] tmp = null;
    if(matA == this || matB == this)        
        {
            tmp = new float[20];
        } //End block
        else
        {
            tmp = mArray;
        } //End block
        final float[] a = matA.mArray;
        final float[] b = matB.mArray;
        int index = 0;
for(int j = 0;j < 20;j += 5)
        {
for(int i = 0;i < 4;i++)
            {
                tmp[index++] = a[j + 0] * b[i + 0] +  a[j + 1] * b[i + 5] +
                               a[j + 2] * b[i + 10] + a[j + 3] * b[i + 15];
            } //End block
            tmp[index++] = a[j + 0] * b[4] +  a[j + 1] * b[9] +
                           a[j + 2] * b[14] + a[j + 3] * b[19] +
                           a[j + 4];
        } //End block
    if(tmp != mArray)        
        {
            System.arraycopy(tmp, 0, mArray, 0, 20);
        } //End block
        // ---------- Original Method ----------
        //float[] tmp = null;
        //if (matA == this || matB == this) {
            //tmp = new float[20];
        //}
        //else {
            //tmp = mArray;
        //}
        //final float[] a = matA.mArray;
        //final float[] b = matB.mArray;
        //int index = 0;
        //for (int j = 0; j < 20; j += 5) {
            //for (int i = 0; i < 4; i++) {
                //tmp[index++] = a[j + 0] * b[i + 0] +  a[j + 1] * b[i + 5] +
                               //a[j + 2] * b[i + 10] + a[j + 3] * b[i + 15];
            //}
            //tmp[index++] = a[j + 0] * b[4] +  a[j + 1] * b[9] +
                           //a[j + 2] * b[14] + a[j + 3] * b[19] +
                           //a[j + 4];
        //}
        //if (tmp != mArray) {
            //System.arraycopy(tmp, 0, mArray, 0, 20);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.203 -0400", hash_original_method = "776A0D16BAF4033F49AFC0802778097D", hash_generated_method = "A7EFF7AEE3A93F17165BB609E2CC0CCB")
    public void preConcat(ColorMatrix prematrix) {
        addTaint(prematrix.getTaint());
        setConcat(this, prematrix);
        // ---------- Original Method ----------
        //setConcat(this, prematrix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.204 -0400", hash_original_method = "B5BC76A876DDBB43CC54F09A33784608", hash_generated_method = "476C3F81C017F71CA6BAD2C39A2F2008")
    public void postConcat(ColorMatrix postmatrix) {
        addTaint(postmatrix.getTaint());
        setConcat(postmatrix, this);
        // ---------- Original Method ----------
        //setConcat(postmatrix, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.205 -0400", hash_original_method = "4B5CDCAEBB0220A2068E2CB6AD49DF79", hash_generated_method = "A855F60439B30805C3687CDA6BCC8AC3")
    public void setSaturation(float sat) {
        addTaint(sat);
        reset();
        float[] m = mArray;
        final float invSat = 1 - sat;
        final float R = 0.213f * invSat;
        final float G = 0.715f * invSat;
        final float B = 0.072f * invSat;
        m[0] = R + sat;
        m[1] = G;
        m[2] = B;
        m[5] = R;
        m[6] = G + sat;
        m[7] = B;
        m[10] = R;
        m[11] = G;
        m[12] = B + sat;
        // ---------- Original Method ----------
        //reset();
        //float[] m = mArray;
        //final float invSat = 1 - sat;
        //final float R = 0.213f * invSat;
        //final float G = 0.715f * invSat;
        //final float B = 0.072f * invSat;
        //m[0] = R + sat;
        //m[1] = G;
        //m[2] = B;
        //m[5] = R;
        //m[6] = G + sat;
        //m[7] = B;
        //m[10] = R;
        //m[11] = G;
        //m[12] = B + sat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.206 -0400", hash_original_method = "5B1F12450A5CDB7BE7A8B64628B4B21E", hash_generated_method = "D8F83239DB90C7E2742FBA6002BDF7AD")
    public void setRGB2YUV() {
        reset();
        float[] m = mArray;
        m[0]  = 0.299f;
        m[1]  = 0.587f;
        m[2]  = 0.114f;
        m[5]  = -0.16874f;
        m[6]  = -0.33126f;
        m[7]  = 0.5f;
        m[10] = 0.5f;
        m[11] = -0.41869f;
        m[12] = -0.08131f;
        // ---------- Original Method ----------
        //reset();
        //float[] m = mArray;
        //m[0]  = 0.299f;
        //m[1]  = 0.587f;
        //m[2]  = 0.114f;
        //m[5]  = -0.16874f;
        //m[6]  = -0.33126f;
        //m[7]  = 0.5f;
        //m[10] = 0.5f;
        //m[11] = -0.41869f;
        //m[12] = -0.08131f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.207 -0400", hash_original_method = "6D15755F0D0866427FC697B26AFE845E", hash_generated_method = "FB420D06D4A45C38C49748F9158E62E7")
    public void setYUV2RGB() {
        reset();
        float[] m = mArray;
        m[2] = 1.402f;
        m[5] = 1;
        m[6] = -0.34414f;
        m[7] = -0.71414f;
        m[10] = 1;
        m[11] = 1.772f;
        m[12] = 0;
        // ---------- Original Method ----------
        //reset();
        //float[] m = mArray;
        //m[2] = 1.402f;
        //m[5] = 1;
        //m[6] = -0.34414f;
        //m[7] = -0.71414f;
        //m[10] = 1;
        //m[11] = 1.772f;
        //m[12] = 0;
    }

    
}

