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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.576 -0400", hash_original_field = "40E64BF46DE36A44337E332FB1B3CAA0", hash_generated_field = "36A133C93FDB38616761627290A0A20E")

    private int[] mTextureNames;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.577 -0400", hash_original_method = "8F7DD5B8943380A1AC60FFDF0F122D77", hash_generated_method = "EC9A5763D9478F2465DEB6CA0DD8D6F3")
      HTML5VideoInline(int videoLayerId, int position,
            boolean autoStart) {
        init(videoLayerId, position, autoStart);
        mTextureNames = null;
        addTaint(videoLayerId);
        addTaint(position);
        addTaint(autoStart);
        // ---------- Original Method ----------
        //init(videoLayerId, position, autoStart);
        //mTextureNames = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.577 -0400", hash_original_method = "D7EA882E28D2C4D67824D79C998B9B60", hash_generated_method = "952E0B92D806DCBE295D83E1B3FBFBE8")
    @Override
    public void start() {
        {
            boolean var9900794E96251044BA342A0A224BC05B_1126747565 = (!getPauseDuringPreparing());
            {
                super.start();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!getPauseDuringPreparing()) {
            //super.start();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.578 -0400", hash_original_method = "21B0AE17630D7867C6531BD31731CD32", hash_generated_method = "755D82B00353A7898464FBE948C6AEC5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.578 -0400", hash_original_method = "AC7A2076B2D6AB73AC076068AFFF2875", hash_generated_method = "CCBFF01380B43CEB6AB31520382A58EF")
    @Override
    public void prepareDataAndDisplayMode(HTML5VideoViewProxy proxy) {
        super.prepareDataAndDisplayMode(proxy);
        setFrameAvailableListener(proxy);
        {
            boolean varCECFE0804C5669CDC9E2A263387B3BF3_1313877890 = (mProxy.getContext().checkCallingOrSelfPermission(permission.WAKE_LOCK)
                == PackageManager.PERMISSION_GRANTED);
            {
                mPlayer.setWakeMode(proxy.getContext(), PowerManager.FULL_WAKE_LOCK);
            } //End block
        } //End collapsed parenthetic
        addTaint(proxy.getTaint());
        // ---------- Original Method ----------
        //super.prepareDataAndDisplayMode(proxy);
        //setFrameAvailableListener(proxy);
        //if (mProxy.getContext().checkCallingOrSelfPermission(permission.WAKE_LOCK)
                //== PackageManager.PERMISSION_GRANTED) {
            //mPlayer.setWakeMode(proxy.getContext(), PowerManager.FULL_WAKE_LOCK);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.578 -0400", hash_original_method = "A225789E523D8A62A1731E2AAAAB0AC9", hash_generated_method = "08930D19CADE24E2C2B58F9A51C524A6")
    @Override
    public void pauseAndDispatch(HTML5VideoViewProxy proxy) {
        super.pauseAndDispatch(proxy);
        addTaint(proxy.getTaint());
        // ---------- Original Method ----------
        //super.pauseAndDispatch(proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.579 -0400", hash_original_method = "DAEA7A8CB1E990B0D919DD9331E6C437", hash_generated_method = "3BBE262A44611FD1F97A9C00A4E2E32A")
    @Override
    public SurfaceTexture getSurfaceTexture(int videoLayerId) {
        SurfaceTexture varB4EAC82CA7396A68D541C85D26508E83_1731520665 = null; //Variable for return #1
        {
            {
                GLES20.glDeleteTextures(1, mTextureNames, 0);
            } //End block
            mTextureNames = new int[1];
            GLES20.glGenTextures(1, mTextureNames, 0);
            mSurfaceTexture = new SurfaceTexture(mTextureNames[0]);
        } //End block
        mVideoLayerUsingSurfaceTexture = videoLayerId;
        varB4EAC82CA7396A68D541C85D26508E83_1731520665 = mSurfaceTexture;
        addTaint(videoLayerId);
        varB4EAC82CA7396A68D541C85D26508E83_1731520665.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1731520665;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.579 -0400", hash_original_method = "AA8729C4AB453FEA19B6A154CE4123AC", hash_generated_method = "CD1D3077B0595AD0C382F2E55627BC08")
    public boolean surfaceTextureDeleted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483755860 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_483755860;
        // ---------- Original Method ----------
        //return (mSurfaceTexture == null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.580 -0400", hash_original_method = "E38F4460BC96178C575F30AC43E88839", hash_generated_method = "F1BB64CE92C1AFA610EE4ED22B48313F")
    @Override
    public void deleteSurfaceTexture() {
        mSurfaceTexture = null;
        mVideoLayerUsingSurfaceTexture = -1;
        // ---------- Original Method ----------
        //mSurfaceTexture = null;
        //mVideoLayerUsingSurfaceTexture = -1;
        //return;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.580 -0400", hash_original_method = "B622F7D686DE5D5F2F53BAC4F4685738", hash_generated_method = "B0DB801B5D64A38F3D9DD0056402141F")
    @Override
    public int getTextureName() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906393126 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906393126;
        // ---------- Original Method ----------
        //if (mTextureNames != null) {
            //return mTextureNames[0];
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.580 -0400", hash_original_method = "014F80B09B9F7311C2350A9A36445759", hash_generated_method = "E02084016E9291340BA262DF006B6913")
    private void setFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener l) {
        mSurfaceTexture.setOnFrameAvailableListener(l);
        addTaint(l.getTaint());
        // ---------- Original Method ----------
        //mSurfaceTexture.setOnFrameAvailableListener(l);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.580 -0400", hash_original_field = "CDB938579708E04BDF53415531029A30", hash_generated_field = "81CAA2CE37C5C8EED1FA7329F6581A8D")

    private static SurfaceTexture mSurfaceTexture = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.580 -0400", hash_original_field = "DBF4FACCD9237FA64344E0E812AE1633", hash_generated_field = "AB6AE0F70E7C631006102E41C147653F")

    private static int mVideoLayerUsingSurfaceTexture = -1;
}

