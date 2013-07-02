package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;

class GLES20TextureLayer extends GLES20Layer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.295 -0400", hash_original_field = "869F26C1617D8AD4BF945B4889DECFF6", hash_generated_field = "95BD811F6C75A4EC837CB912DCEC863B")

    private int mTexture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.295 -0400", hash_original_field = "76C3E3B9188F3B101287AE8BD0308DA5", hash_generated_field = "620EA06673388F6E0C713D180E59A2BE")

    private SurfaceTexture mSurface;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.296 -0400", hash_original_method = "CC530FDF67357759801B1D3133D8497C", hash_generated_method = "42A4412DD4893E9CB4EA378D0034D76A")
      GLES20TextureLayer(boolean isOpaque) {
        int[] layerInfo = new int[2];
        mLayer = GLES20Canvas.nCreateTextureLayer(isOpaque, layerInfo);
        {
            mTexture = layerInfo[0];
            mFinalizer = new Finalizer(mLayer);
        } 
        {
            mFinalizer = null;
        } 
        addTaint(isOpaque);
        
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.296 -0400", hash_original_method = "11B63BDC356D1B06476790C8BA000825", hash_generated_method = "31A17DA24374A3D0231EE362C9ED8A3F")
    @Override
     boolean isValid() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_567830195 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_567830195;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.297 -0400", hash_original_method = "E6D4E5987C63DC0417A704140ED92009", hash_generated_method = "05C20B5E0F7AFA380884E666AA3D8601")
    @Override
     void resize(int width, int height) {
        addTaint(width);
        addTaint(height);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.297 -0400", hash_original_method = "FE3F18C4DF5FFEAAB94B6C71D2FF4AC1", hash_generated_method = "70E98F674CFB6E939CE29EED10957BF2")
    @Override
     HardwareCanvas getCanvas() {
        HardwareCanvas varB4EAC82CA7396A68D541C85D26508E83_2030746177 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2030746177 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2030746177.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2030746177;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.298 -0400", hash_original_method = "2311903AB2BF759F2AF64EC85ECFCD74", hash_generated_method = "E08CF8B27E2309E0F114628D46B0257A")
    @Override
     HardwareCanvas start(Canvas currentCanvas) {
        HardwareCanvas varB4EAC82CA7396A68D541C85D26508E83_496522555 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_496522555 = null;
        addTaint(currentCanvas.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_496522555.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_496522555;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.298 -0400", hash_original_method = "8A4AD7636F89A9F2F6FF510EF4082BAC", hash_generated_method = "99E4F141B60ED953D3D1624851C86C2F")
    @Override
     void end(Canvas currentCanvas) {
        addTaint(currentCanvas.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.299 -0400", hash_original_method = "CDD23CBBC42E4C818DBF49A0C1C7FFA6", hash_generated_method = "F05E7B18C73C32C70CDB176A73611C27")
     SurfaceTexture getSurfaceTexture() {
        SurfaceTexture varB4EAC82CA7396A68D541C85D26508E83_834800292 = null; 
        {
            mSurface = new SurfaceTexture(mTexture, false);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_834800292 = mSurface;
        varB4EAC82CA7396A68D541C85D26508E83_834800292.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_834800292;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.300 -0400", hash_original_method = "1A4F8689DF0CBFF789DC290DBC90C4B6", hash_generated_method = "0F56F1F918E453BB2D8874CB0A6AA279")
    @Override
     void update(int width, int height, boolean isOpaque) {
        super.update(width, height, isOpaque);
        GLES20Canvas.nUpdateTextureLayer(mLayer, width, height, isOpaque, mSurface);
        addTaint(width);
        addTaint(height);
        addTaint(isOpaque);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.300 -0400", hash_original_method = "A2F486FA7726377A1A987D8CE4D8F80A", hash_generated_method = "142B8C81C1E743C0B9B2B62AABAE21AF")
    @Override
     void setTransform(Matrix matrix) {
        GLES20Canvas.nSetTextureLayerTransform(mLayer, matrix.native_instance);
        addTaint(matrix.getTaint());
        
        
    }

    
}

