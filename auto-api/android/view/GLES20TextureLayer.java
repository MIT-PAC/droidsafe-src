package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;

class GLES20TextureLayer extends GLES20Layer {
    private int mTexture;
    private SurfaceTexture mSurface;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.691 -0400", hash_original_method = "CC530FDF67357759801B1D3133D8497C", hash_generated_method = "B60C21F8185A8A61860F35AD9929ABFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     GLES20TextureLayer(boolean isOpaque) {
        dsTaint.addTaint(isOpaque);
        int[] layerInfo;
        layerInfo = new int[2];
        mLayer = GLES20Canvas.nCreateTextureLayer(isOpaque, layerInfo);
        {
            mTexture = layerInfo[0];
            mFinalizer = new Finalizer(mLayer);
        } //End block
        {
            mFinalizer = null;
        } //End block
        // ---------- Original Method ----------
        //int[] layerInfo = new int[2];
        //mLayer = GLES20Canvas.nCreateTextureLayer(isOpaque, layerInfo);
        //if (mLayer != 0) {
            //mTexture = layerInfo[0];
            //mFinalizer = new Finalizer(mLayer);
        //} else {
            //mFinalizer = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.691 -0400", hash_original_method = "11B63BDC356D1B06476790C8BA000825", hash_generated_method = "F2A40676D40FD6A0072BC032DA4E0F7B")
    @DSModeled(DSC.SAFE)
    @Override
     boolean isValid() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLayer != 0 && mTexture != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.692 -0400", hash_original_method = "E6D4E5987C63DC0417A704140ED92009", hash_generated_method = "45C42C36011659D5F4B53E1C63176B6C")
    @DSModeled(DSC.SAFE)
    @Override
     void resize(int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.692 -0400", hash_original_method = "FE3F18C4DF5FFEAAB94B6C71D2FF4AC1", hash_generated_method = "748CFE5BF129608FB7E37807C4855A06")
    @DSModeled(DSC.SAFE)
    @Override
     HardwareCanvas getCanvas() {
        return (HardwareCanvas)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.692 -0400", hash_original_method = "2311903AB2BF759F2AF64EC85ECFCD74", hash_generated_method = "07EA2FE4AD046D2AC7F882C2816EC8E0")
    @DSModeled(DSC.SAFE)
    @Override
     HardwareCanvas start(Canvas currentCanvas) {
        dsTaint.addTaint(currentCanvas.dsTaint);
        return (HardwareCanvas)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.692 -0400", hash_original_method = "8A4AD7636F89A9F2F6FF510EF4082BAC", hash_generated_method = "479CF4D69E4DA7E35CCE1FE5247A1255")
    @DSModeled(DSC.SAFE)
    @Override
     void end(Canvas currentCanvas) {
        dsTaint.addTaint(currentCanvas.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.692 -0400", hash_original_method = "CDD23CBBC42E4C818DBF49A0C1C7FFA6", hash_generated_method = "97FBF280F7B9F4AF4B92FD77AF2520F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SurfaceTexture getSurfaceTexture() {
        {
            mSurface = new SurfaceTexture(mTexture, false);
        } //End block
        return (SurfaceTexture)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mSurface == null) {
            //mSurface = new SurfaceTexture(mTexture, false);
        //}
        //return mSurface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.693 -0400", hash_original_method = "1A4F8689DF0CBFF789DC290DBC90C4B6", hash_generated_method = "7866605CEC6740DF934643923A1FDF23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void update(int width, int height, boolean isOpaque) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(isOpaque);
        super.update(width, height, isOpaque);
        GLES20Canvas.nUpdateTextureLayer(mLayer, width, height, isOpaque, mSurface);
        // ---------- Original Method ----------
        //super.update(width, height, isOpaque);
        //GLES20Canvas.nUpdateTextureLayer(mLayer, width, height, isOpaque, mSurface);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.693 -0400", hash_original_method = "A2F486FA7726377A1A987D8CE4D8F80A", hash_generated_method = "69C466B4560369E3A65DEE21864068C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void setTransform(Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        GLES20Canvas.nSetTextureLayerTransform(mLayer, matrix.native_instance);
        // ---------- Original Method ----------
        //GLES20Canvas.nSetTextureLayerTransform(mLayer, matrix.native_instance);
    }

    
}

