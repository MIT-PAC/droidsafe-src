package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;

class GLES20TextureLayer extends GLES20Layer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.621 -0500", hash_original_field = "BDB6A6C8A3F80F4A028EAF374A5C2487", hash_generated_field = "95BD811F6C75A4EC837CB912DCEC863B")

    private int mTexture;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.624 -0500", hash_original_field = "2DB428339FB9F1F6E6D23DD5A01621BD", hash_generated_field = "620EA06673388F6E0C713D180E59A2BE")

    private SurfaceTexture mSurface;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.626 -0500", hash_original_method = "CC530FDF67357759801B1D3133D8497C", hash_generated_method = "CC530FDF67357759801B1D3133D8497C")
    
GLES20TextureLayer(boolean isOpaque) {
        int[] layerInfo = new int[2];
        mLayer = GLES20Canvas.nCreateTextureLayer(isOpaque, layerInfo);

        if (mLayer != 0) {
            mTexture = layerInfo[0];
            mFinalizer = new Finalizer(mLayer);
        } else {
            mFinalizer = null;
        }        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.628 -0500", hash_original_method = "11B63BDC356D1B06476790C8BA000825", hash_generated_method = "9B7C9A87E96D2A9B83C2FDE713A3EF2B")
    
@Override
    boolean isValid() {
        return mLayer != 0 && mTexture != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.631 -0500", hash_original_method = "E6D4E5987C63DC0417A704140ED92009", hash_generated_method = "2250F39638A9D272CD23AEDC119315C2")
    
@Override
    void resize(int width, int height) {
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.633 -0500", hash_original_method = "FE3F18C4DF5FFEAAB94B6C71D2FF4AC1", hash_generated_method = "E1827AD236E6122B2580FCDDB65E8C53")
    
@Override
    HardwareCanvas getCanvas() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.635 -0500", hash_original_method = "2311903AB2BF759F2AF64EC85ECFCD74", hash_generated_method = "4EF99C99ADB0A028650241CA4DE380EA")
    
@Override
    HardwareCanvas start(Canvas currentCanvas) {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.637 -0500", hash_original_method = "8A4AD7636F89A9F2F6FF510EF4082BAC", hash_generated_method = "F837A8C4E2DB540DA76051BC376B8CC4")
    
@Override
    void end(Canvas currentCanvas) {
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.639 -0500", hash_original_method = "CDD23CBBC42E4C818DBF49A0C1C7FFA6", hash_generated_method = "CDD23CBBC42E4C818DBF49A0C1C7FFA6")
    
SurfaceTexture getSurfaceTexture() {
        if (mSurface == null) {
            mSurface = new SurfaceTexture(mTexture, false);
        }
        return mSurface;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.642 -0500", hash_original_method = "1A4F8689DF0CBFF789DC290DBC90C4B6", hash_generated_method = "265612BC3D36F505F5DA8037402011D6")
    
@Override
    void update(int width, int height, boolean isOpaque) {
        super.update(width, height, isOpaque);
        GLES20Canvas.nUpdateTextureLayer(mLayer, width, height, isOpaque, mSurface);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.644 -0500", hash_original_method = "A2F486FA7726377A1A987D8CE4D8F80A", hash_generated_method = "0B46F5D91B999EC9E221C2651B58AB64")
    
@Override
    void setTransform(Matrix matrix) {
        GLES20Canvas.nSetTextureLayerTransform(mLayer, matrix.native_instance);
    }
    
}

