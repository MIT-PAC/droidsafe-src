package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.293 -0400", hash_original_field = "6C7797A425EBA1D07F236FF9B39AA429", hash_generated_field = "D427CDF1FC427D67E4945D1E0E231D42")

    protected int mCurrentState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.293 -0400", hash_original_field = "7D88DE9DD0EF018B770128257B4D159F", hash_generated_field = "A9417E42DC0EBFA2CF2015D2CB329A68")

    protected HTML5VideoViewProxy mProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.293 -0400", hash_original_field = "D04CD0659FBA036CA8826150F1F1E62A", hash_generated_field = "B8C51FE12DAEADA10B46180012D4E013")

    protected int mSaveSeekTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.293 -0400", hash_original_field = "984724E54A3D174511409B8A76927E34", hash_generated_field = "0752FEDDB1622AE4DFBC1A284DB7079B")

    protected int mVideoLayerId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.294 -0400", hash_original_field = "01AE51C88036C324EFB5646FEE9EB109", hash_generated_field = "C795F3B69D878B3EB8FFD62D53BE5467")

    protected MediaPlayer mPlayer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.294 -0400", hash_original_field = "31825AE6E4F03F79884718C65CDD49D5", hash_generated_field = "82B2974D11DC8EF00D6DE680FC278C81")

    protected boolean mAutostart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.294 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "4309285A2AF5294EC8D8A6725673F542")

    protected Uri mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.294 -0400", hash_original_field = "9DA6583E4F64A78649E80D72BFE1DBCC", hash_generated_field = "DE0CB0B3CC8CF9FE0713E37CB69C3430")

    protected Map<String, String> mHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.294 -0400", hash_original_field = "F31379AC693AFD32806C2F8AFF4FB2B1", hash_generated_field = "4B797C0AD5CBAEABB54B83FEF8D06E8A")

    protected boolean mPauseDuringPreparing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.294 -0400", hash_original_field = "D8A44452255315582684719CBEAE3A2C", hash_generated_field = "3C382F7E45E0380C589CD364462525D1")

    public boolean mPlayerBuffering = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.294 -0400", hash_original_method = "28D653DD01D92986A2B4676333E22F44", hash_generated_method = "E877102CF44EDBE37327EE0B3614BDF9")
    protected  HTML5VideoView() {
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.295 -0400", hash_original_method = "3012844A52D4FF8D08A8750FA45AE671", hash_generated_method = "D7C8A7B98F068ECA8592BF1958291198")
    public void start() {
    if(mCurrentState == STATE_PREPARED)        
        {
    if(mTimer == null)            
            {
                mTimer = new Timer();
                mTimer.schedule(new TimeupdateTask(mProxy), TIMEUPDATE_PERIOD,
                        TIMEUPDATE_PERIOD);
            } 
            mPlayer.start();
            setPlayerBuffering(false);
        } 
        
        
            
            
                
                
                        
            
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.295 -0400", hash_original_method = "53F6A4797DD5828003875392A3AF17CE", hash_generated_method = "239EDB5FE582BE1EF9B63082D70E7BA2")
    public void pause() {
    if(isPlaying())        
        {
            mPlayer.pause();
        } 
        else
    if(mCurrentState == STATE_NOTPREPARED)        
        {
            mPauseDuringPreparing = true;
        } 
    if(mTimer != null)        
        {
            mTimer.purge();
            mTimer.cancel();
            mTimer = null;
        } 
        
        
            
        
            
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.296 -0400", hash_original_method = "439630F284E895C4A0EC26592582E769", hash_generated_method = "845C91D4E126F42C4C901B2D908F9EDF")
    public int getDuration() {
    if(mCurrentState == STATE_PREPARED)        
        {
            int varE6A4D58BC36106FFC7E11B87F36D48AB_1661472164 = (mPlayer.getDuration());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1181638705 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1181638705;
        } 
        else
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1385765967 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_239022157 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_239022157;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.298 -0400", hash_original_method = "5E9270330E1DC98C2EF1834461EFA6AE", hash_generated_method = "1AD316097D37396676B50D9AF988810C")
    public int getCurrentPosition() {
    if(mCurrentState == STATE_PREPARED)        
        {
            int varCEA3D69E014FF77B91BE1913FC89492B_1570463067 = (mPlayer.getCurrentPosition());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1926122481 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1926122481;
        } 
        int varCFCD208495D565EF66E7DFF9F98764DA_488066382 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960174834 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960174834;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.299 -0400", hash_original_method = "29179F4E6F5DEF8BE6DF61D7C781E0A2", hash_generated_method = "E32EAC0E3969A7C5407467F62677A933")
    public void seekTo(int pos) {
    if(mCurrentState == STATE_PREPARED)        
        mPlayer.seekTo(pos);
        else
        mSaveSeekTime = pos;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.300 -0400", hash_original_method = "FFF63CE630758A2DC8461EEC2B2493E2", hash_generated_method = "1B66BF40C1E334CD08CC13301E014493")
    public boolean isPlaying() {
    if(mCurrentState == STATE_PREPARED)        
        {
            boolean var774CF28519C3CEE2356ACF4DB6B41A98_355732497 = (mPlayer.isPlaying());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_462242533 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_462242533;
        } 
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_466605242 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1718504321 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1718504321;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.301 -0400", hash_original_method = "0FBE82A8FF8F42AB54B25C4455F7DE4C", hash_generated_method = "EC615B19064898D7226096A372E245A3")
    public void release() {
    if(mCurrentState != STATE_RELEASED)        
        {
            mPlayer.release();
        } 
        mCurrentState = STATE_RELEASED;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.302 -0400", hash_original_method = "59D4F83219BBDE4F48B39B417FC8C6D3", hash_generated_method = "399EF696E9097B91AE462CC144E22C35")
    public void stopPlayback() {
    if(mCurrentState == STATE_PREPARED)        
        {
            mPlayer.stop();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.302 -0400", hash_original_method = "FE87C901FEC48725BE9A00E5A7A6B389", hash_generated_method = "CA416153E2A99EFC47DBA4DC4E3A21C1")
    public boolean getAutostart() {
        boolean var31825AE6E4F03F79884718C65CDD49D5_2052159021 = (mAutostart);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1734646996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1734646996;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.303 -0400", hash_original_method = "83FF2150FEBE6917B81E8E4D5EFDEDB8", hash_generated_method = "CEF296359800DE460ABE970C2B3C2245")
    public boolean getPauseDuringPreparing() {
        boolean varF31379AC693AFD32806C2F8AFF4FB2B1_989931560 = (mPauseDuringPreparing);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1359730271 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1359730271;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.304 -0400", hash_original_method = "25A3A58F4D699286035B0F84C85D6FDC", hash_generated_method = "8D5F2A249F2CD08E0E39617378FD04E1")
    public void init(int videoLayerId, int position, boolean autoStart) {
        mPlayer = new MediaPlayer();
        mCurrentState = STATE_INITIALIZED;
        mProxy = null;
        mVideoLayerId = videoLayerId;
        mSaveSeekTime = position;
        mAutostart = autoStart;
        mTimer = null;
        mPauseDuringPreparing = false;
        
        
        
        
        
        
        
        
        
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.305 -0400", hash_original_method = "4A72F313DB07B237CDCFE2148C78F1A8", hash_generated_method = "EAB59583A6ABB2F017872447AEE18A8E")
    public void setVideoURI(String uri, HTML5VideoViewProxy proxy) {
        mUri = Uri.parse(uri);
        mHeaders = generateHeaders(uri, proxy);
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.305 -0400", hash_original_method = "7F2C5845AC97F9E01BF6739081098AFA", hash_generated_method = "9C97881D86FD74143394FC7DFA1C2BF4")
    public void setOnCompletionListener(HTML5VideoViewProxy proxy) {
        addTaint(proxy.getTaint());
        mPlayer.setOnCompletionListener(proxy);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.305 -0400", hash_original_method = "B3DA09063B346725FC2FACD292CDBF3D", hash_generated_method = "4B544866EE92AA9C84184724C5701A23")
    public void setOnErrorListener(HTML5VideoViewProxy proxy) {
        addTaint(proxy.getTaint());
        mPlayer.setOnErrorListener(proxy);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.305 -0400", hash_original_method = "88BA8808B84DAD90592F4339F231D5ED", hash_generated_method = "4D6AF3753C8541AA77B64DFD77C61EFB")
    public void setOnPreparedListener(HTML5VideoViewProxy proxy) {
        mProxy = proxy;
        mPlayer.setOnPreparedListener(this);
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.306 -0400", hash_original_method = "9B3DE5A2AE36BDD54043208A8ECFD89C", hash_generated_method = "5C574C787098B3BC3B5139FF18561C47")
    public void setOnInfoListener(HTML5VideoViewProxy proxy) {
        addTaint(proxy.getTaint());
        mPlayer.setOnInfoListener(proxy);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.306 -0400", hash_original_method = "F9607B1B919A7A6BBECF31855FC93C59", hash_generated_method = "8A33A6DF4C5291E75BF0E813CDED435F")
    public void prepareDataAndDisplayMode(HTML5VideoViewProxy proxy) {
        addTaint(proxy.getTaint());
        decideDisplayMode();
        setOnCompletionListener(proxy);
        setOnPreparedListener(proxy);
        setOnErrorListener(proxy);
        setOnInfoListener(proxy);
        try 
        {
            mPlayer.setDataSource(mProxy.getContext(), mUri, mHeaders);
            mPlayer.prepareAsync();
        } 
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        } 
        catch (IllegalStateException e)
        {
            e.printStackTrace();
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        } 
        mCurrentState = STATE_NOTPREPARED;
        
        
        
        
        
        
        
            
            
        
            
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.307 -0400", hash_original_method = "4F2E24A50F82208E59877C3E2625C348", hash_generated_method = "AFAE5397B7F8F588F71CECF6483C9FDF")
    public int getVideoLayerId() {
        int var984724E54A3D174511409B8A76927E34_1351826306 = (mVideoLayerId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_829822927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_829822927;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.307 -0400", hash_original_method = "90E098B5ED1DEFDE8C60551334D6CBD4", hash_generated_method = "4CCE937779115E576F2EE471CB5C3D54")
    public int getCurrentState() {
    if(isPlaying())        
        {
            int var46106D784544B47292475B21943AB7AD_1330486527 = (STATE_PLAYING);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1716175145 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1716175145;
        } 
        else
        {
            int var6C7797A425EBA1D07F236FF9B39AA429_1112288929 = (mCurrentState);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1949898139 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1949898139;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.308 -0400", hash_original_method = "023FEEEA138ACC710F3FC682E3FCF8D2", hash_generated_method = "0330F2FAB61F0883B5F6BF95A39075D4")
    @Override
    public void onPrepared(MediaPlayer mp) {
        
        addTaint(mp.getTaint());
        mCurrentState = STATE_PREPARED;
        seekTo(mSaveSeekTime);
    if(mProxy != null)        
        {
            mProxy.onPrepared(mp);
        } 
    if(mPauseDuringPreparing)        
        {
            pauseAndDispatch(mProxy);
            mPauseDuringPreparing = false;
        } 
        
        
        
        
            
        
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.308 -0400", hash_original_method = "61063445AE0708B1C305C74A0C0CFD4D", hash_generated_method = "CD6EE95AC0F91FE126976F3154F9EDEE")
    public void pauseAndDispatch(HTML5VideoViewProxy proxy) {
        addTaint(proxy.getTaint());
        pause();
    if(proxy != null)        
        {
            proxy.dispatchOnPaused();
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.309 -0400", hash_original_method = "9BC7893A1A30D65DD41983AD520ABA24", hash_generated_method = "1815228FE6AF9C66AC74D74832BB079D")
    public void enterFullScreenVideoState(int layerId,
            HTML5VideoViewProxy proxy, WebView webView) {
        addTaint(webView.getTaint());
        addTaint(proxy.getTaint());
        addTaint(layerId);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.309 -0400", hash_original_method = "040F96FADC077BA4992C03214586310A", hash_generated_method = "9CC0B9E47B63A905799BC60FB454E882")
    public boolean isFullScreenMode() {
        boolean var68934A3E9455FA72420237EB05902327_1938216739 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1173154194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1173154194;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.309 -0400", hash_original_method = "576D7BAAE83D7D96FC7F76762AF5D519", hash_generated_method = "72B0C98E60E0E0F576CB0E078AC7C55A")
    public void decideDisplayMode() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.310 -0400", hash_original_method = "C9A7CF84D371C51EADC63585245E2DF8", hash_generated_method = "CBAF8E69DDC3BC42C992C6BA3D3641E1")
    public boolean getReadyToUseSurfTex() {
        boolean var68934A3E9455FA72420237EB05902327_1919854933 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_638371051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_638371051;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.310 -0400", hash_original_method = "EB4C543379CBB61A7D197317729D4B81", hash_generated_method = "B227CE9A00CC6B2849F227B7957FAD07")
    public SurfaceTexture getSurfaceTexture(int videoLayerId) {
        addTaint(videoLayerId);
SurfaceTexture var540C13E9E156B687226421B24F2DF178_1542558344 =         null;
        var540C13E9E156B687226421B24F2DF178_1542558344.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1542558344;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.310 -0400", hash_original_method = "F878AB9D8B307F7725C7D90E69C96D89", hash_generated_method = "07BFA0BF77B7C18AD06224A1226A429A")
    public void deleteSurfaceTexture() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.310 -0400", hash_original_method = "4BDE667A00FC91D9C95E5191E09A54C3", hash_generated_method = "0AF15D893F75DD15A0FB7AC1A68D54B1")
    public int getTextureName() {
        int varCFCD208495D565EF66E7DFF9F98764DA_8108756 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1228830918 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1228830918;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.310 -0400", hash_original_method = "BA6BA92F877820EFB4A7324F8FF815C7", hash_generated_method = "EE5DF99BCCBA58B440591F586EEBC321")
    public boolean getPlayerBuffering() {
        boolean var21A94B24414CC83F408019CEEE7256DB_194512258 = (mPlayerBuffering);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192571167 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_192571167;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.311 -0400", hash_original_method = "90D4C50A046C8B21871A46FE1FDA531C", hash_generated_method = "453F7193DA9035441C449E361090501E")
    public void setPlayerBuffering(boolean playerBuffering) {
        mPlayerBuffering = playerBuffering;
        switchProgressView(playerBuffering);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.311 -0400", hash_original_method = "D1649F9781058EFE73B80767CB5DBB7F", hash_generated_method = "78654B15F1DDD1BB483C8E3622ECF5B9")
    protected void switchProgressView(boolean playerBuffering) {
        addTaint(playerBuffering);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.311 -0400", hash_original_method = "620458B5B8BB9506BFC901A9D3B27999", hash_generated_method = "AD77A4D7CAA42AA020CD917D61EBE5F2")
    public boolean surfaceTextureDeleted() {
        boolean var68934A3E9455FA72420237EB05902327_741923964 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_845353678 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_845353678;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.311 -0400", hash_original_method = "8A279E58756D4B031794A7C12A636619", hash_generated_method = "841BEE1C37AEAB05AF807B332A1E0190")
    public boolean fullScreenExited() {
        boolean var68934A3E9455FA72420237EB05902327_1698431951 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1561386521 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1561386521;
        
        
    }

    
    private static final class TimeupdateTask extends TimerTask {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.312 -0400", hash_original_field = "7D88DE9DD0EF018B770128257B4D159F", hash_generated_field = "701E8A5CEFF22C717E0E1190038ED0C2")

        private HTML5VideoViewProxy mProxy;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.312 -0400", hash_original_method = "3C26C895A00D8A9565624E1D679282AA", hash_generated_method = "0F41425E63DDD706022823AA445EA086")
        public  TimeupdateTask(HTML5VideoViewProxy proxy) {
            mProxy = proxy;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.312 -0400", hash_original_method = "BCE01212467B54ADF40E3CF16EDCE71A", hash_generated_method = "720F4FE730506E910812AE5C0641C63B")
        @Override
        public void run() {
            mProxy.onTimeupdate();
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.313 -0400", hash_original_field = "23A1AFCA8BE06FFFB26446468AA15EE5", hash_generated_field = "F28BD250BE49F871DBD48569862C0B31")

    protected static final String LOGTAG = "HTML5VideoView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.313 -0400", hash_original_field = "9A71485BAE34D870CB99A56794E33727", hash_generated_field = "DA39A01DF5AB155F9CB6B9FF9001FE68")

    protected static final String COOKIE = "Cookie";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.313 -0400", hash_original_field = "27A993EDFD63555E2CA2047D198F916F", hash_generated_field = "9881974001B645494AB5FC175DFA6D3E")

    protected static final String HIDE_URL_LOGS = "x-hide-urls-from-log";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.313 -0400", hash_original_field = "5D51BBD586E32FF369C39A1432B1D1FE", hash_generated_field = "F87702CD8372B94E855116553EA5A2CA")

    static final int STATE_INITIALIZED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.313 -0400", hash_original_field = "306E5AD3AF067CF0A2BD527C24682116", hash_generated_field = "5FB03EFA27A8E29EFAB8448370D21C6E")

    static final int STATE_NOTPREPARED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.313 -0400", hash_original_field = "95BFE9F657F45E05E13CA2B88A7E534C", hash_generated_field = "ED6A5A72E4407D351D0E711B5368AB37")

    static final int STATE_PREPARED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.313 -0400", hash_original_field = "F8E97D8069CEFFD6F193B01736254DA5", hash_generated_field = "980EFA6A2B53D27841C185532A5FD596")

    static final int STATE_PLAYING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.313 -0400", hash_original_field = "3EA9E6AECB20C4694288BB1A98264609", hash_generated_field = "7597F5A47281EA761032DDC95EFD8646")

    static final int STATE_RELEASED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.313 -0400", hash_original_field = "18CC450E4B3A37C32021860E8C8343C3", hash_generated_field = "D3C1D0BC931E22CE6A6DFBB2150EFF9F")

    protected static Timer mTimer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.313 -0400", hash_original_field = "D553B3E2F0768723E9DB1BA83F91694F", hash_generated_field = "803E0BB34E42CE66FDB6CAF172B04845")

    private static final int TIMEUPDATE_PERIOD = 250;
}

