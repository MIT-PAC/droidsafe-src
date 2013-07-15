package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.803 -0400", hash_original_field = "40E64BF46DE36A44337E332FB1B3CAA0", hash_generated_field = "36A133C93FDB38616761627290A0A20E")

    private int[] mTextureNames;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.803 -0400", hash_original_method = "8F7DD5B8943380A1AC60FFDF0F122D77", hash_generated_method = "EC9A5763D9478F2465DEB6CA0DD8D6F3")
      HTML5VideoInline(int videoLayerId, int position,
            boolean autoStart) {
        init(videoLayerId, position, autoStart);
        mTextureNames = null;
        addTaint(videoLayerId);
        addTaint(position);
        addTaint(autoStart);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.804 -0400", hash_original_method = "D7EA882E28D2C4D67824D79C998B9B60", hash_generated_method = "7889140CB42507C6DBE4C298A9B746BD")
    @Override
    public void start() {
        {
            boolean var9900794E96251044BA342A0A224BC05B_190485826 = (!getPauseDuringPreparing());
            {
                super.start();
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.804 -0400", hash_original_method = "21B0AE17630D7867C6531BD31731CD32", hash_generated_method = "D797356A7EE2E977A002216664ECC960")
    @Override
    public void decideDisplayMode() {
        SurfaceTexture surfaceTexture = getSurfaceTexture(getVideoLayerId());
        Surface surface = new Surface(surfaceTexture);
        mPlayer.setSurface(surface);
        surface.release();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.804 -0400", hash_original_method = "AC7A2076B2D6AB73AC076068AFFF2875", hash_generated_method = "085BA9C7378DFB958BA4741E6A954440")
    @Override
    public void prepareDataAndDisplayMode(HTML5VideoViewProxy proxy) {
        super.prepareDataAndDisplayMode(proxy);
        setFrameAvailableListener(proxy);
        {
            boolean varCECFE0804C5669CDC9E2A263387B3BF3_1709995161 = (mProxy.getContext().checkCallingOrSelfPermission(permission.WAKE_LOCK)
                == PackageManager.PERMISSION_GRANTED);
            {
                mPlayer.setWakeMode(proxy.getContext(), PowerManager.FULL_WAKE_LOCK);
            } 
        } 
        addTaint(proxy.getTaint());
        
        
        
        
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.805 -0400", hash_original_method = "A225789E523D8A62A1731E2AAAAB0AC9", hash_generated_method = "08930D19CADE24E2C2B58F9A51C524A6")
    @Override
    public void pauseAndDispatch(HTML5VideoViewProxy proxy) {
        super.pauseAndDispatch(proxy);
        addTaint(proxy.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.805 -0400", hash_original_method = "DAEA7A8CB1E990B0D919DD9331E6C437", hash_generated_method = "7F555397E3D9FA573ED623467DD5EE63")
    @Override
    public SurfaceTexture getSurfaceTexture(int videoLayerId) {
        SurfaceTexture varB4EAC82CA7396A68D541C85D26508E83_184504282 = null; 
        {
            {
                GLES20.glDeleteTextures(1, mTextureNames, 0);
            } 
            mTextureNames = new int[1];
            GLES20.glGenTextures(1, mTextureNames, 0);
            mSurfaceTexture = new SurfaceTexture(mTextureNames[0]);
        } 
        mVideoLayerUsingSurfaceTexture = videoLayerId;
        varB4EAC82CA7396A68D541C85D26508E83_184504282 = mSurfaceTexture;
        addTaint(videoLayerId);
        varB4EAC82CA7396A68D541C85D26508E83_184504282.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_184504282;
        
        
            
            
            
                
            
            
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.805 -0400", hash_original_method = "AA8729C4AB453FEA19B6A154CE4123AC", hash_generated_method = "D0D13C7D084FBE9084A3508292A69813")
    public boolean surfaceTextureDeleted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_334961802 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_334961802;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.806 -0400", hash_original_method = "E38F4460BC96178C575F30AC43E88839", hash_generated_method = "F1BB64CE92C1AFA610EE4ED22B48313F")
    @Override
    public void deleteSurfaceTexture() {
        mSurfaceTexture = null;
        mVideoLayerUsingSurfaceTexture = -1;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.806 -0400", hash_original_method = "B622F7D686DE5D5F2F53BAC4F4685738", hash_generated_method = "B5B9B997AF210DEBADCDD9EFD4016237")
    @Override
    public int getTextureName() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_53870407 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_53870407;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.806 -0400", hash_original_method = "014F80B09B9F7311C2350A9A36445759", hash_generated_method = "E02084016E9291340BA262DF006B6913")
    private void setFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener l) {
        mSurfaceTexture.setOnFrameAvailableListener(l);
        addTaint(l.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.806 -0400", hash_original_field = "CDB938579708E04BDF53415531029A30", hash_generated_field = "81CAA2CE37C5C8EED1FA7329F6581A8D")

    private static SurfaceTexture mSurfaceTexture = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.806 -0400", hash_original_field = "DBF4FACCD9237FA64344E0E812AE1633", hash_generated_field = "AB6AE0F70E7C631006102E41C147653F")

    private static int mVideoLayerUsingSurfaceTexture = -1;
}

