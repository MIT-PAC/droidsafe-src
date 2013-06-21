package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.SurfaceView;
import android.webkit.HTML5VideoViewProxy;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class HTML5VideoView implements MediaPlayer.OnPreparedListener {
    protected int mCurrentState;
    protected HTML5VideoViewProxy mProxy;
    protected int mSaveSeekTime;
    protected int mVideoLayerId;
    protected MediaPlayer mPlayer;
    protected boolean mAutostart;
    protected Uri mUri;
    protected Map<String, String> mHeaders;
    protected boolean mPauseDuringPreparing;
    public boolean mPlayerBuffering = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.320 -0400", hash_original_method = "28D653DD01D92986A2B4676333E22F44", hash_generated_method = "E877102CF44EDBE37327EE0B3614BDF9")
    @DSModeled(DSC.SAFE)
    protected HTML5VideoView() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.320 -0400", hash_original_method = "3012844A52D4FF8D08A8750FA45AE671", hash_generated_method = "1396C9E4303ED6E8F83C63E801BAF34A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void start() {
        {
            {
                mTimer = new Timer();
                mTimer.schedule(new TimeupdateTask(mProxy), TIMEUPDATE_PERIOD,
                        TIMEUPDATE_PERIOD);
            } //End block
            mPlayer.start();
            setPlayerBuffering(false);
        } //End block
        // ---------- Original Method ----------
        //if (mCurrentState == STATE_PREPARED) {
            //if (mTimer == null)
            //{
                //mTimer = new Timer();
                //mTimer.schedule(new TimeupdateTask(mProxy), TIMEUPDATE_PERIOD,
                        //TIMEUPDATE_PERIOD);
            //}
            //mPlayer.start();
            //setPlayerBuffering(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.321 -0400", hash_original_method = "53F6A4797DD5828003875392A3AF17CE", hash_generated_method = "C72B6EE756C6C141322C91926501993A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void pause() {
        {
            boolean varF201D1289221CC8E3849EC18FF46A02A_80233436 = (isPlaying());
            {
                mPlayer.pause();
            } //End block
            {
                mPauseDuringPreparing = true;
            } //End block
        } //End collapsed parenthetic
        {
            mTimer.purge();
            mTimer.cancel();
            mTimer = null;
        } //End block
        // ---------- Original Method ----------
        //if (isPlaying()) {
            //mPlayer.pause();
        //} else if (mCurrentState == STATE_NOTPREPARED) {
            //mPauseDuringPreparing = true;
        //}
        //if (mTimer != null) {
            //mTimer.purge();
            //mTimer.cancel();
            //mTimer = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.321 -0400", hash_original_method = "439630F284E895C4A0EC26592582E769", hash_generated_method = "51CA0A5E684739E9FC9BFC612AF2502F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDuration() {
        {
            int var5FEFC5FCA84B13AB9FEADC62B6A961FC_1016864412 = (mPlayer.getDuration());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mCurrentState == STATE_PREPARED) {
            //return mPlayer.getDuration();
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.321 -0400", hash_original_method = "5E9270330E1DC98C2EF1834461EFA6AE", hash_generated_method = "4FB1DDB09449822ED5A9E809FFB55A87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCurrentPosition() {
        {
            int var8634387E01C283C5F7FA944275E46C0C_1542764422 = (mPlayer.getCurrentPosition());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mCurrentState == STATE_PREPARED) {
            //return mPlayer.getCurrentPosition();
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.321 -0400", hash_original_method = "29179F4E6F5DEF8BE6DF61D7C781E0A2", hash_generated_method = "0E7F2DB509CDB0BC9BC5838ABFEB7EED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void seekTo(int pos) {
        dsTaint.addTaint(pos);
        mPlayer.seekTo(pos);
        // ---------- Original Method ----------
        //if (mCurrentState == STATE_PREPARED)
            //mPlayer.seekTo(pos);
        //else
            //mSaveSeekTime = pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.321 -0400", hash_original_method = "FFF63CE630758A2DC8461EEC2B2493E2", hash_generated_method = "CC28644500F745FE2F4CD12ED0CBD547")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPlaying() {
        {
            boolean var39B4349F3FF67B6FA000A266CC9AF48C_859468585 = (mPlayer.isPlaying());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mCurrentState == STATE_PREPARED) {
            //return mPlayer.isPlaying();
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.322 -0400", hash_original_method = "0FBE82A8FF8F42AB54B25C4455F7DE4C", hash_generated_method = "39686718BE926761D41941F442CF5B1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void release() {
        {
            mPlayer.release();
        } //End block
        mCurrentState = STATE_RELEASED;
        // ---------- Original Method ----------
        //if (mCurrentState != STATE_RELEASED) {
            //mPlayer.release();
        //}
        //mCurrentState = STATE_RELEASED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.322 -0400", hash_original_method = "59D4F83219BBDE4F48B39B417FC8C6D3", hash_generated_method = "064D6A57BA1A5112703637AACC1A024C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopPlayback() {
        {
            mPlayer.stop();
        } //End block
        // ---------- Original Method ----------
        //if (mCurrentState == STATE_PREPARED) {
            //mPlayer.stop();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.322 -0400", hash_original_method = "FE87C901FEC48725BE9A00E5A7A6B389", hash_generated_method = "61387148D901BE4C2361ACB043826568")
    @DSModeled(DSC.SAFE)
    public boolean getAutostart() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAutostart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.322 -0400", hash_original_method = "83FF2150FEBE6917B81E8E4D5EFDEDB8", hash_generated_method = "262B34C5DAD2DDB411BC293041B77264")
    @DSModeled(DSC.SAFE)
    public boolean getPauseDuringPreparing() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPauseDuringPreparing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.322 -0400", hash_original_method = "25A3A58F4D699286035B0F84C85D6FDC", hash_generated_method = "75B34620AD7C455C82DC2AB7ACC206CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void init(int videoLayerId, int position, boolean autoStart) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(autoStart);
        dsTaint.addTaint(videoLayerId);
        mPlayer = new MediaPlayer();
        mCurrentState = STATE_INITIALIZED;
        mProxy = null;
        mTimer = null;
        mPauseDuringPreparing = false;
        // ---------- Original Method ----------
        //mPlayer = new MediaPlayer();
        //mCurrentState = STATE_INITIALIZED;
        //mProxy = null;
        //mVideoLayerId = videoLayerId;
        //mSaveSeekTime = position;
        //mAutostart = autoStart;
        //mTimer = null;
        //mPauseDuringPreparing = false;
    }

    
        protected static Map<String, String> generateHeaders(String url,
            HTML5VideoViewProxy proxy) {
        boolean isPrivate = proxy.getWebView().isPrivateBrowsingEnabled();
        String cookieValue = CookieManager.getInstance().getCookie(url, isPrivate);
        Map<String, String> headers = new HashMap<String, String>();
        if (cookieValue != null) {
            headers.put(COOKIE, cookieValue);
        }
        if (isPrivate) {
            headers.put(HIDE_URL_LOGS, "true");
        }
        return headers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.323 -0400", hash_original_method = "4A72F313DB07B237CDCFE2148C78F1A8", hash_generated_method = "0B30FE3CA2E65103D4FDBA0AF098FCFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVideoURI(String uri, HTML5VideoViewProxy proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(uri);
        mUri = Uri.parse(uri);
        mHeaders = generateHeaders(uri, proxy);
        // ---------- Original Method ----------
        //mUri = Uri.parse(uri);
        //mHeaders = generateHeaders(uri, proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.323 -0400", hash_original_method = "7F2C5845AC97F9E01BF6739081098AFA", hash_generated_method = "FBD0BC451AC9A4A10F608A970A92B60D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnCompletionListener(HTML5VideoViewProxy proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        mPlayer.setOnCompletionListener(proxy);
        // ---------- Original Method ----------
        //mPlayer.setOnCompletionListener(proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.323 -0400", hash_original_method = "B3DA09063B346725FC2FACD292CDBF3D", hash_generated_method = "B877EA452D52EBBF0DFCA144914D81C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnErrorListener(HTML5VideoViewProxy proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        mPlayer.setOnErrorListener(proxy);
        // ---------- Original Method ----------
        //mPlayer.setOnErrorListener(proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.323 -0400", hash_original_method = "88BA8808B84DAD90592F4339F231D5ED", hash_generated_method = "0DEC665C30FE0EF33FAAA65B68572579")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnPreparedListener(HTML5VideoViewProxy proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        mPlayer.setOnPreparedListener(this);
        // ---------- Original Method ----------
        //mProxy = proxy;
        //mPlayer.setOnPreparedListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.323 -0400", hash_original_method = "9B3DE5A2AE36BDD54043208A8ECFD89C", hash_generated_method = "CC92E6208F796A18623E3ABF24FB8A56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnInfoListener(HTML5VideoViewProxy proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        mPlayer.setOnInfoListener(proxy);
        // ---------- Original Method ----------
        //mPlayer.setOnInfoListener(proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.323 -0400", hash_original_method = "F9607B1B919A7A6BBECF31855FC93C59", hash_generated_method = "85BA95A9FA94F6740BB78EBB3DD04856")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void prepareDataAndDisplayMode(HTML5VideoViewProxy proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        decideDisplayMode();
        setOnCompletionListener(proxy);
        setOnPreparedListener(proxy);
        setOnErrorListener(proxy);
        setOnInfoListener(proxy);
        try 
        {
            mPlayer.setDataSource(mProxy.getContext(), mUri, mHeaders);
            mPlayer.prepareAsync();
        } //End block
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        } //End block
        catch (IllegalStateException e)
        {
            e.printStackTrace();
        } //End block
        catch (IOException e)
        {
            e.printStackTrace();
        } //End block
        mCurrentState = STATE_NOTPREPARED;
        // ---------- Original Method ----------
        //decideDisplayMode();
        //setOnCompletionListener(proxy);
        //setOnPreparedListener(proxy);
        //setOnErrorListener(proxy);
        //setOnInfoListener(proxy);
        //try {
            //mPlayer.setDataSource(mProxy.getContext(), mUri, mHeaders);
            //mPlayer.prepareAsync();
        //} catch (IllegalArgumentException e) {
            //e.printStackTrace();
        //} catch (IllegalStateException e) {
            //e.printStackTrace();
        //} catch (IOException e) {
            //e.printStackTrace();
        //}
        //mCurrentState = STATE_NOTPREPARED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.324 -0400", hash_original_method = "4F2E24A50F82208E59877C3E2625C348", hash_generated_method = "C0ED202FE5605A341640F45523AD313C")
    @DSModeled(DSC.SAFE)
    public int getVideoLayerId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mVideoLayerId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.324 -0400", hash_original_method = "90E098B5ED1DEFDE8C60551334D6CBD4", hash_generated_method = "9416E62CA0817F2BABABFE39BE1D0D78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCurrentState() {
        {
            boolean varF201D1289221CC8E3849EC18FF46A02A_1061124924 = (isPlaying());
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (isPlaying()) {
            //return STATE_PLAYING;
        //} else {
            //return mCurrentState;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.324 -0400", hash_original_method = "023FEEEA138ACC710F3FC682E3FCF8D2", hash_generated_method = "08D75C31FC09CA6140B77A6E1781813E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onPrepared(MediaPlayer mp) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mp.dsTaint);
        mCurrentState = STATE_PREPARED;
        seekTo(mSaveSeekTime);
        {
            mProxy.onPrepared(mp);
        } //End block
        {
            pauseAndDispatch(mProxy);
            mPauseDuringPreparing = false;
        } //End block
        // ---------- Original Method ----------
        //mCurrentState = STATE_PREPARED;
        //seekTo(mSaveSeekTime);
        //if (mProxy != null) {
            //mProxy.onPrepared(mp);
        //}
        //if (mPauseDuringPreparing) {
            //pauseAndDispatch(mProxy);
            //mPauseDuringPreparing = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.324 -0400", hash_original_method = "61063445AE0708B1C305C74A0C0CFD4D", hash_generated_method = "D2C11A051B409C5178BE1FE4405B9F2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void pauseAndDispatch(HTML5VideoViewProxy proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        pause();
        {
            proxy.dispatchOnPaused();
        } //End block
        // ---------- Original Method ----------
        //pause();
        //if (proxy != null) {
            //proxy.dispatchOnPaused();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.324 -0400", hash_original_method = "9BC7893A1A30D65DD41983AD520ABA24", hash_generated_method = "8934BCBC51D3130FB712E17188B7670E")
    @DSModeled(DSC.SAFE)
    public void enterFullScreenVideoState(int layerId,
            HTML5VideoViewProxy proxy, WebView webView) {
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(webView.dsTaint);
        dsTaint.addTaint(layerId);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.324 -0400", hash_original_method = "040F96FADC077BA4992C03214586310A", hash_generated_method = "BA49BB02E4B9B84E8816E2CDA5D7C9B8")
    @DSModeled(DSC.SAFE)
    public boolean isFullScreenMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.325 -0400", hash_original_method = "576D7BAAE83D7D96FC7F76762AF5D519", hash_generated_method = "72B0C98E60E0E0F576CB0E078AC7C55A")
    @DSModeled(DSC.SAFE)
    public void decideDisplayMode() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.325 -0400", hash_original_method = "C9A7CF84D371C51EADC63585245E2DF8", hash_generated_method = "8F7D04630654F572D3192C99F7C9EA4C")
    @DSModeled(DSC.SAFE)
    public boolean getReadyToUseSurfTex() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.325 -0400", hash_original_method = "EB4C543379CBB61A7D197317729D4B81", hash_generated_method = "A3229C1B169CFC4C74CAE6836BE1958D")
    @DSModeled(DSC.SAFE)
    public SurfaceTexture getSurfaceTexture(int videoLayerId) {
        dsTaint.addTaint(videoLayerId);
        return (SurfaceTexture)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.325 -0400", hash_original_method = "F878AB9D8B307F7725C7D90E69C96D89", hash_generated_method = "07BFA0BF77B7C18AD06224A1226A429A")
    @DSModeled(DSC.SAFE)
    public void deleteSurfaceTexture() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.325 -0400", hash_original_method = "4BDE667A00FC91D9C95E5191E09A54C3", hash_generated_method = "EAA2230894971373315ADFAC6A9EE066")
    @DSModeled(DSC.SAFE)
    public int getTextureName() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.325 -0400", hash_original_method = "BA6BA92F877820EFB4A7324F8FF815C7", hash_generated_method = "0E53BC35DDE08327C1A9DEB7AF69D0C7")
    @DSModeled(DSC.SAFE)
    public boolean getPlayerBuffering() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPlayerBuffering;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.325 -0400", hash_original_method = "90D4C50A046C8B21871A46FE1FDA531C", hash_generated_method = "5E8E8B3998679A283045C46EB0AD6F69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPlayerBuffering(boolean playerBuffering) {
        dsTaint.addTaint(playerBuffering);
        switchProgressView(playerBuffering);
        // ---------- Original Method ----------
        //mPlayerBuffering = playerBuffering;
        //switchProgressView(playerBuffering);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.326 -0400", hash_original_method = "D1649F9781058EFE73B80767CB5DBB7F", hash_generated_method = "6B77479905B9D0D54830CE3F83FEA1D6")
    @DSModeled(DSC.SAFE)
    protected void switchProgressView(boolean playerBuffering) {
        dsTaint.addTaint(playerBuffering);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.326 -0400", hash_original_method = "620458B5B8BB9506BFC901A9D3B27999", hash_generated_method = "60AA69E551048201160D670AD62994B0")
    @DSModeled(DSC.SAFE)
    public boolean surfaceTextureDeleted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.326 -0400", hash_original_method = "8A279E58756D4B031794A7C12A636619", hash_generated_method = "A108108344A5F453287CF546C64C0BB6")
    @DSModeled(DSC.SAFE)
    public boolean fullScreenExited() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    private static final class TimeupdateTask extends TimerTask {
        private HTML5VideoViewProxy mProxy;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.326 -0400", hash_original_method = "3C26C895A00D8A9565624E1D679282AA", hash_generated_method = "F38AADF01A92B8920707DE8B01C41996")
        @DSModeled(DSC.SAFE)
        public TimeupdateTask(HTML5VideoViewProxy proxy) {
            dsTaint.addTaint(proxy.dsTaint);
            // ---------- Original Method ----------
            //mProxy = proxy;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.326 -0400", hash_original_method = "BCE01212467B54ADF40E3CF16EDCE71A", hash_generated_method = "720F4FE730506E910812AE5C0641C63B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void run() {
            mProxy.onTimeupdate();
            // ---------- Original Method ----------
            //mProxy.onTimeupdate();
        }

        
    }


    
    protected static final String LOGTAG = "HTML5VideoView";
    protected static final String COOKIE = "Cookie";
    protected static final String HIDE_URL_LOGS = "x-hide-urls-from-log";
    static final int STATE_INITIALIZED        = 0;
    static final int STATE_NOTPREPARED        = 1;
    static final int STATE_PREPARED           = 2;
    static final int STATE_PLAYING            = 3;
    static final int STATE_RELEASED           = 4;
    protected static Timer mTimer;
    private static final int TIMEUPDATE_PERIOD = 250;
}

