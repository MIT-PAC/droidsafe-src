package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.Manifest.permission;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.webkit.HTML5VideoView;
import android.webkit.HTML5VideoViewProxy;
import android.view.Surface;
import android.opengl.GLES20;
import android.os.PowerManager;

public class HTML5VideoInline extends HTML5VideoView {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.267 -0400", hash_original_field = "40E64BF46DE36A44337E332FB1B3CAA0", hash_generated_field = "36A133C93FDB38616761627290A0A20E")

    private int[] mTextureNames;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.268 -0400", hash_original_method = "8F7DD5B8943380A1AC60FFDF0F122D77", hash_generated_method = "258EF00BFFBCA1247CB02305549B6C5C")
      HTML5VideoInline(int videoLayerId, int position,
            boolean autoStart) {
        addTaint(autoStart);
        addTaint(position);
        addTaint(videoLayerId);
        init(videoLayerId, position, autoStart);
        mTextureNames = null;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.269 -0400", hash_original_method = "D7EA882E28D2C4D67824D79C998B9B60", hash_generated_method = "736B7BB8266C918A346AAB0A0D75F86C")
    @Override
    public void start() {
    if(!getPauseDuringPreparing())        
        {
            super.start();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.269 -0400", hash_original_method = "21B0AE17630D7867C6531BD31731CD32", hash_generated_method = "D797356A7EE2E977A002216664ECC960")
    @Override
    public void decideDisplayMode() {
        SurfaceTexture surfaceTexture = getSurfaceTexture(getVideoLayerId());
        Surface surface = new Surface(surfaceTexture);
        mPlayer.setSurface(surface);
        surface.release();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.270 -0400", hash_original_method = "AC7A2076B2D6AB73AC076068AFFF2875", hash_generated_method = "88BFC685952B0E0A1CCADB31678C34A9")
    @Override
    public void prepareDataAndDisplayMode(HTML5VideoViewProxy proxy) {
        addTaint(proxy.getTaint());
        super.prepareDataAndDisplayMode(proxy);
        setFrameAvailableListener(proxy);
    if(mProxy.getContext().checkCallingOrSelfPermission(permission.WAKE_LOCK)
                == PackageManager.PERMISSION_GRANTED)        
        {
            mPlayer.setWakeMode(proxy.getContext(), PowerManager.FULL_WAKE_LOCK);
        } 
        
        
        
        
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.270 -0400", hash_original_method = "A225789E523D8A62A1731E2AAAAB0AC9", hash_generated_method = "59984A467758060589DCED1C97212C63")
    @Override
    public void pauseAndDispatch(HTML5VideoViewProxy proxy) {
        addTaint(proxy.getTaint());
        super.pauseAndDispatch(proxy);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.272 -0400", hash_original_method = "DAEA7A8CB1E990B0D919DD9331E6C437", hash_generated_method = "DD180B54312E0BC9DF3E8C304C0A34EE")
    @Override
    public SurfaceTexture getSurfaceTexture(int videoLayerId) {
        addTaint(videoLayerId);
    if(videoLayerId != mVideoLayerUsingSurfaceTexture
            || mSurfaceTexture == null
            || mTextureNames == null)        
        {
    if(mTextureNames != null)            
            {
                GLES20.glDeleteTextures(1, mTextureNames, 0);
            } 
            mTextureNames = new int[1];
            GLES20.glGenTextures(1, mTextureNames, 0);
            mSurfaceTexture = new SurfaceTexture(mTextureNames[0]);
        } 
        mVideoLayerUsingSurfaceTexture = videoLayerId;
SurfaceTexture var74CF9B55B7E0EE39E0DCA6D5B6226059_402270780 =         mSurfaceTexture;
        var74CF9B55B7E0EE39E0DCA6D5B6226059_402270780.addTaint(taint);
        return var74CF9B55B7E0EE39E0DCA6D5B6226059_402270780;
        
        
            
            
            
                
            
            
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.272 -0400", hash_original_method = "AA8729C4AB453FEA19B6A154CE4123AC", hash_generated_method = "D1553325183BAB312BD18EABC012495F")
    public boolean surfaceTextureDeleted() {
        boolean varF0304B2B44BAAD2EABB9072CBF7697C5_306170180 = ((mSurfaceTexture == null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1002280718 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1002280718;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.273 -0400", hash_original_method = "E38F4460BC96178C575F30AC43E88839", hash_generated_method = "0649F690C1335D86D8BEA9B37763F0CA")
    @Override
    public void deleteSurfaceTexture() {
        mSurfaceTexture = null;
        mVideoLayerUsingSurfaceTexture = -1;
        return;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.273 -0400", hash_original_method = "B622F7D686DE5D5F2F53BAC4F4685738", hash_generated_method = "CF36F2F073C6A3679E765779B5C4FDDD")
    @Override
    public int getTextureName() {
    if(mTextureNames != null)        
        {
            int var8E040960FA71CA7E6D4F1A4DED032DB2_1871723172 = (mTextureNames[0]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_682603848 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_682603848;
        } 
        else
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1561033399 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_92314797 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_92314797;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.273 -0400", hash_original_method = "014F80B09B9F7311C2350A9A36445759", hash_generated_method = "ECE77E9B17CA74C3E286411EF5056650")
    private void setFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener l) {
        addTaint(l.getTaint());
        mSurfaceTexture.setOnFrameAvailableListener(l);
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.274 -0400", hash_original_field = "CDB938579708E04BDF53415531029A30", hash_generated_field = "81CAA2CE37C5C8EED1FA7329F6581A8D")

    private static SurfaceTexture mSurfaceTexture = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.274 -0400", hash_original_field = "DBF4FACCD9237FA64344E0E812AE1633", hash_generated_field = "AB6AE0F70E7C631006102E41C147653F")

    private static int mVideoLayerUsingSurfaceTexture = -1;
}

