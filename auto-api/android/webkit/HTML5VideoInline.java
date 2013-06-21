package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private int[] mTextureNames;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.314 -0400", hash_original_method = "8F7DD5B8943380A1AC60FFDF0F122D77", hash_generated_method = "583EEB0E20C2AF81A2C4C33ED6C4F30D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HTML5VideoInline(int videoLayerId, int position,
            boolean autoStart) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(autoStart);
        dsTaint.addTaint(videoLayerId);
        init(videoLayerId, position, autoStart);
        mTextureNames = null;
        // ---------- Original Method ----------
        //init(videoLayerId, position, autoStart);
        //mTextureNames = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.314 -0400", hash_original_method = "D7EA882E28D2C4D67824D79C998B9B60", hash_generated_method = "A9C18FC5BF136F3D899E96CB07A19DD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void start() {
        {
            boolean var9900794E96251044BA342A0A224BC05B_434096336 = (!getPauseDuringPreparing());
            {
                super.start();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!getPauseDuringPreparing()) {
            //super.start();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.314 -0400", hash_original_method = "21B0AE17630D7867C6531BD31731CD32", hash_generated_method = "755D82B00353A7898464FBE948C6AEC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void decideDisplayMode() {
        SurfaceTexture surfaceTexture;
        surfaceTexture = getSurfaceTexture(getVideoLayerId());
        Surface surface;
        surface = new Surface(surfaceTexture);
        mPlayer.setSurface(surface);
        surface.release();
        // ---------- Original Method ----------
        //SurfaceTexture surfaceTexture = getSurfaceTexture(getVideoLayerId());
        //Surface surface = new Surface(surfaceTexture);
        //mPlayer.setSurface(surface);
        //surface.release();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.314 -0400", hash_original_method = "AC7A2076B2D6AB73AC076068AFFF2875", hash_generated_method = "ED86C6922FD99D5208896F953C9B2C8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void prepareDataAndDisplayMode(HTML5VideoViewProxy proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        super.prepareDataAndDisplayMode(proxy);
        setFrameAvailableListener(proxy);
        {
            boolean varCECFE0804C5669CDC9E2A263387B3BF3_1773679334 = (mProxy.getContext().checkCallingOrSelfPermission(permission.WAKE_LOCK)
                == PackageManager.PERMISSION_GRANTED);
            {
                mPlayer.setWakeMode(proxy.getContext(), PowerManager.FULL_WAKE_LOCK);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.prepareDataAndDisplayMode(proxy);
        //setFrameAvailableListener(proxy);
        //if (mProxy.getContext().checkCallingOrSelfPermission(permission.WAKE_LOCK)
                //== PackageManager.PERMISSION_GRANTED) {
            //mPlayer.setWakeMode(proxy.getContext(), PowerManager.FULL_WAKE_LOCK);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.315 -0400", hash_original_method = "A225789E523D8A62A1731E2AAAAB0AC9", hash_generated_method = "81F202C38BA1C4D865D207F2A77E305F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void pauseAndDispatch(HTML5VideoViewProxy proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        super.pauseAndDispatch(proxy);
        // ---------- Original Method ----------
        //super.pauseAndDispatch(proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.315 -0400", hash_original_method = "DAEA7A8CB1E990B0D919DD9331E6C437", hash_generated_method = "E40CE67602448A66A875F814C328AC8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SurfaceTexture getSurfaceTexture(int videoLayerId) {
        dsTaint.addTaint(videoLayerId);
        {
            {
                GLES20.glDeleteTextures(1, mTextureNames, 0);
            } //End block
            mTextureNames = new int[1];
            GLES20.glGenTextures(1, mTextureNames, 0);
            mSurfaceTexture = new SurfaceTexture(mTextureNames[0]);
        } //End block
        mVideoLayerUsingSurfaceTexture = videoLayerId;
        return (SurfaceTexture)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (videoLayerId != mVideoLayerUsingSurfaceTexture
            //|| mSurfaceTexture == null
            //|| mTextureNames == null) {
            //if (mTextureNames != null) {
                //GLES20.glDeleteTextures(1, mTextureNames, 0);
            //}
            //mTextureNames = new int[1];
            //GLES20.glGenTextures(1, mTextureNames, 0);
            //mSurfaceTexture = new SurfaceTexture(mTextureNames[0]);
        //}
        //mVideoLayerUsingSurfaceTexture = videoLayerId;
        //return mSurfaceTexture;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.315 -0400", hash_original_method = "AA8729C4AB453FEA19B6A154CE4123AC", hash_generated_method = "DA99C51EBEC76D00BCF14FBD8E1221B4")
    @DSModeled(DSC.SAFE)
    public boolean surfaceTextureDeleted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mSurfaceTexture == null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.315 -0400", hash_original_method = "E38F4460BC96178C575F30AC43E88839", hash_generated_method = "F1BB64CE92C1AFA610EE4ED22B48313F")
    @DSModeled(DSC.SAFE)
    @Override
    public void deleteSurfaceTexture() {
        mSurfaceTexture = null;
        mVideoLayerUsingSurfaceTexture = -1;
        // ---------- Original Method ----------
        //mSurfaceTexture = null;
        //mVideoLayerUsingSurfaceTexture = -1;
        //return;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.315 -0400", hash_original_method = "B622F7D686DE5D5F2F53BAC4F4685738", hash_generated_method = "027B940B716B668824862A1AF481CB23")
    @DSModeled(DSC.SAFE)
    @Override
    public int getTextureName() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mTextureNames != null) {
            //return mTextureNames[0];
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.315 -0400", hash_original_method = "014F80B09B9F7311C2350A9A36445759", hash_generated_method = "DF70A438B72C329CF51CA6C4CEA4F9C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener l) {
        dsTaint.addTaint(l.dsTaint);
        mSurfaceTexture.setOnFrameAvailableListener(l);
        // ---------- Original Method ----------
        //mSurfaceTexture.setOnFrameAvailableListener(l);
    }

    
    private static SurfaceTexture mSurfaceTexture = null;
    private static int mVideoLayerUsingSurfaceTexture = -1;
}

