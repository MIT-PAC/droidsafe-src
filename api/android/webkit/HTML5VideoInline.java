package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.Manifest.permission;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.PowerManager;
import android.view.Surface;

public class HTML5VideoInline extends HTML5VideoView {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.610 -0500", hash_original_field = "1C21384017FD7B8B1159EDD33E4F9317", hash_generated_field = "54CA08CDDD6B8113BA2A66342BADB90D")

    // surface texture as singleton. But the GL texture (m_textureNames)
    // associated with the surface texture can be used for showing the screen
    // shot when paused, so they are not singleton.
    private static SurfaceTexture mSurfaceTexture = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.614 -0500", hash_original_field = "FD2BAF80125A3A4189ED725D0E575163", hash_generated_field = "8FA2A64FDAE4D16C132985E099F81004")

    // SurfaceTexture in order to delete the old video's decoder memory.
    private static int mVideoLayerUsingSurfaceTexture = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.612 -0500", hash_original_field = "4B9082E563D90D3226738A88A17FC9B4", hash_generated_field = "36A133C93FDB38616761627290A0A20E")

    private int[] mTextureNames;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.618 -0500", hash_original_method = "8F7DD5B8943380A1AC60FFDF0F122D77", hash_generated_method = "8F7DD5B8943380A1AC60FFDF0F122D77")
    
HTML5VideoInline(int videoLayerId, int position,
            boolean autoStart) {
        init(videoLayerId, position, autoStart);
        mTextureNames = null;
    }

    // Video control FUNCTIONS:
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.616 -0500", hash_original_method = "D7EA882E28D2C4D67824D79C998B9B60", hash_generated_method = "D37F0A457763BDBD688AD4589E7C839A")
    
@Override
    public void start() {
        if (!getPauseDuringPreparing()) {
            super.start();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.621 -0500", hash_original_method = "21B0AE17630D7867C6531BD31731CD32", hash_generated_method = "0C5EB035D5C6F7F7B2D034A6E3E443A1")
    
@Override
    public void decideDisplayMode() {
        SurfaceTexture surfaceTexture = getSurfaceTexture(getVideoLayerId());
        Surface surface = new Surface(surfaceTexture);
        mPlayer.setSurface(surface);
        surface.release();
    }

    // Normally called immediately after setVideoURI. But for full screen,
    // this should be after surface holder created
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.624 -0500", hash_original_method = "AC7A2076B2D6AB73AC076068AFFF2875", hash_generated_method = "9133E4781F697947BB4DBD083E94D1C0")
    
@Override
    public void prepareDataAndDisplayMode(HTML5VideoViewProxy proxy) {
        super.prepareDataAndDisplayMode(proxy);
        setFrameAvailableListener(proxy);
        // TODO: This is a workaround, after b/5375681 fixed, we should switch
        // to the better way.
        if (mProxy.getContext().checkCallingOrSelfPermission(permission.WAKE_LOCK)
                == PackageManager.PERMISSION_GRANTED) {
            mPlayer.setWakeMode(proxy.getContext(), PowerManager.FULL_WAKE_LOCK);
        }
    }

    // Pause the play and update the play/pause button
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.626 -0500", hash_original_method = "A225789E523D8A62A1731E2AAAAB0AC9", hash_generated_method = "F906ADD894888B783CE47855DC461292")
    
@Override
    public void pauseAndDispatch(HTML5VideoViewProxy proxy) {
        super.pauseAndDispatch(proxy);
    }

    // Inline Video specific FUNCTIONS:

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.628 -0500", hash_original_method = "DAEA7A8CB1E990B0D919DD9331E6C437", hash_generated_method = "9FB9644FD0852D40C24FE479072D032F")
    
@Override
    public SurfaceTexture getSurfaceTexture(int videoLayerId) {
        // Create the surface texture.
        if (videoLayerId != mVideoLayerUsingSurfaceTexture
            || mSurfaceTexture == null
            || mTextureNames == null) {
            if (mTextureNames != null) {
                GLES20.glDeleteTextures(1, mTextureNames, 0);
            }
            mTextureNames = new int[1];
            GLES20.glGenTextures(1, mTextureNames, 0);
            mSurfaceTexture = new SurfaceTexture(mTextureNames[0]);
        }
        mVideoLayerUsingSurfaceTexture = videoLayerId;
        return mSurfaceTexture;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.631 -0500", hash_original_method = "AA8729C4AB453FEA19B6A154CE4123AC", hash_generated_method = "B225BFDA3D8189B350A783676A8AF3C6")
    
public boolean surfaceTextureDeleted() {
        return (mSurfaceTexture == null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.633 -0500", hash_original_method = "E38F4460BC96178C575F30AC43E88839", hash_generated_method = "E368EAD25971E910DD16CA3DC90BBFB4")
    
@Override
    public void deleteSurfaceTexture() {
        mSurfaceTexture = null;
        mVideoLayerUsingSurfaceTexture = -1;
        return;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.636 -0500", hash_original_method = "B622F7D686DE5D5F2F53BAC4F4685738", hash_generated_method = "D33C606A51A2E450678C902B31353458")
    
@Override
    public int getTextureName() {
        if (mTextureNames != null) {
            return mTextureNames[0];
        } else {
            return 0;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.638 -0500", hash_original_method = "014F80B09B9F7311C2350A9A36445759", hash_generated_method = "86C9429E9D908D9077934B83FE885678")
    
private void setFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener l) {
        mSurfaceTexture.setOnFrameAvailableListener(l);
    }
}

