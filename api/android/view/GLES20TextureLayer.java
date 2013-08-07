package android.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;





class GLES20TextureLayer extends GLES20Layer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.263 -0400", hash_original_field = "869F26C1617D8AD4BF945B4889DECFF6", hash_generated_field = "95BD811F6C75A4EC837CB912DCEC863B")

    private int mTexture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.263 -0400", hash_original_field = "76C3E3B9188F3B101287AE8BD0308DA5", hash_generated_field = "620EA06673388F6E0C713D180E59A2BE")

    private SurfaceTexture mSurface;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.263 -0400", hash_original_method = "CC530FDF67357759801B1D3133D8497C", hash_generated_method = "C12D6DCDF45E95507C5ABD93A9CB7A40")
      GLES20TextureLayer(boolean isOpaque) {
        addTaint(isOpaque);
        int[] layerInfo = new int[2];
        mLayer = GLES20Canvas.nCreateTextureLayer(isOpaque, layerInfo);
        if(mLayer != 0)        
        {
            mTexture = layerInfo[0];
            mFinalizer = new Finalizer(mLayer);
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.264 -0400", hash_original_method = "11B63BDC356D1B06476790C8BA000825", hash_generated_method = "3714A4EFA5882323EC3E137659EC5690")
    @Override
     boolean isValid() {
        boolean var973306D035EAA8A637CD75F15ED5A181_1146231079 = (mLayer != 0 && mTexture != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_65140862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_65140862;
        // ---------- Original Method ----------
        //return mLayer != 0 && mTexture != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.264 -0400", hash_original_method = "E6D4E5987C63DC0417A704140ED92009", hash_generated_method = "48F23F144C9F629B3B3DC10A41EAD21C")
    @Override
     void resize(int width, int height) {
        addTaint(height);
        addTaint(width);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.264 -0400", hash_original_method = "FE3F18C4DF5FFEAAB94B6C71D2FF4AC1", hash_generated_method = "544D8711EE04F5853E38EB387C123D6E")
    @Override
     HardwareCanvas getCanvas() {
HardwareCanvas var540C13E9E156B687226421B24F2DF178_2060298074 =         null;
        var540C13E9E156B687226421B24F2DF178_2060298074.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2060298074;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.265 -0400", hash_original_method = "2311903AB2BF759F2AF64EC85ECFCD74", hash_generated_method = "F9ABFEFD6D85988CD94A9733A6D59793")
    @Override
     HardwareCanvas start(Canvas currentCanvas) {
        addTaint(currentCanvas.getTaint());
HardwareCanvas var540C13E9E156B687226421B24F2DF178_488240463 =         null;
        var540C13E9E156B687226421B24F2DF178_488240463.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_488240463;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.265 -0400", hash_original_method = "8A4AD7636F89A9F2F6FF510EF4082BAC", hash_generated_method = "99E4F141B60ED953D3D1624851C86C2F")
    @Override
     void end(Canvas currentCanvas) {
        addTaint(currentCanvas.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.265 -0400", hash_original_method = "CDD23CBBC42E4C818DBF49A0C1C7FFA6", hash_generated_method = "0E7455456CB4C9B923C6DFF80EBD8CE2")
     SurfaceTexture getSurfaceTexture() {
        if(mSurface == null)        
        {
            mSurface = new SurfaceTexture(mTexture, false);
        } //End block
SurfaceTexture varB7C98568942B156EFD367CE054011CDA_2040893651 =         mSurface;
        varB7C98568942B156EFD367CE054011CDA_2040893651.addTaint(taint);
        return varB7C98568942B156EFD367CE054011CDA_2040893651;
        // ---------- Original Method ----------
        //if (mSurface == null) {
            //mSurface = new SurfaceTexture(mTexture, false);
        //}
        //return mSurface;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.266 -0400", hash_original_method = "1A4F8689DF0CBFF789DC290DBC90C4B6", hash_generated_method = "FA32477217667E6A245305472C350461")
    @Override
     void update(int width, int height, boolean isOpaque) {
        addTaint(isOpaque);
        addTaint(height);
        addTaint(width);
        super.update(width, height, isOpaque);
        GLES20Canvas.nUpdateTextureLayer(mLayer, width, height, isOpaque, mSurface);
        // ---------- Original Method ----------
        //super.update(width, height, isOpaque);
        //GLES20Canvas.nUpdateTextureLayer(mLayer, width, height, isOpaque, mSurface);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.266 -0400", hash_original_method = "A2F486FA7726377A1A987D8CE4D8F80A", hash_generated_method = "1C942EECCC683208F04F691C39E8B4B2")
    @Override
     void setTransform(Matrix matrix) {
        addTaint(matrix.getTaint());
        GLES20Canvas.nSetTextureLayerTransform(mLayer, matrix.native_instance);
        // ---------- Original Method ----------
        //GLES20Canvas.nSetTextureLayerTransform(mLayer, matrix.native_instance);
    }

    
}

