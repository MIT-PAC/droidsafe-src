package android.net.rtp;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.media.AudioManager;
import java.util.HashMap;
import java.util.Map;

public class AudioGroup {
    private Map<AudioStream, Integer> mStreams;
    private int mMode = MODE_ON_HOLD;
    private int mNative;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.134 -0400", hash_original_method = "9E113DACC3DCFC949CC90EBD557A2ACA", hash_generated_method = "0A80C29DBACA16C4F76FC1A830D63EA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AudioGroup() {
        mStreams = new HashMap<AudioStream, Integer>();
        // ---------- Original Method ----------
        //mStreams = new HashMap<AudioStream, Integer>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.134 -0400", hash_original_method = "868089D57ED1EE56E9ACF33DE8DED38E", hash_generated_method = "27F359E756A71A4D4844D4D2248F3A87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AudioStream[] getStreams() {
        {
            AudioStream[] varB86D8BBD4FFBDC772AC682BB7ADBAAC6_147245630 = (mStreams.keySet().toArray(new AudioStream[mStreams.size()]));
        } //End block
        return (AudioStream[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mStreams.keySet().toArray(new AudioStream[mStreams.size()]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.134 -0400", hash_original_method = "46CDEAEE57FC46504BB8BB611AFCF88D", hash_generated_method = "1B0905CC702C46C8C3A70BD6A436C7FD")
    @DSModeled(DSC.SAFE)
    public int getMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.134 -0400", hash_original_method = "3B407E7A126047BBCD9831E47F9B5D99", hash_generated_method = "ECB9FB904ECBEE178F1C33E1F2370590")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMode(int mode) {
        dsTaint.addTaint(mode);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid mode");
        } //End block
        {
            nativeSetMode(mode);
        } //End block
        // ---------- Original Method ----------
        //if (mode < 0 || mode > MODE_LAST) {
            //throw new IllegalArgumentException("Invalid mode");
        //}
        //synchronized (this) {
            //nativeSetMode(mode);
            //mMode = mode;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.135 -0400", hash_original_method = "49E777EBA85E577A92F07DB5E1A4FF69", hash_generated_method = "87F5A020EAEBDA368AF201E77AA17138")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetMode(int mode) {
        dsTaint.addTaint(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.135 -0400", hash_original_method = "91004DD6DF12C73407D3712D3F37E9FF", hash_generated_method = "B166CFC41E0CE8702F59F63327ACCE43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void add(AudioStream stream, AudioCodec codec, int dtmfType) {
        dsTaint.addTaint(stream.dsTaint);
        dsTaint.addTaint(codec.dsTaint);
        dsTaint.addTaint(dtmfType);
        {
            boolean var462179FDA5D963857F5CDBF7C2D70E51_554395305 = (!mStreams.containsKey(stream));
            {
                try 
                {
                    int socket;
                    socket = stream.dup();
                    String codecSpec;
                    codecSpec = String.format("%d %s %s", codec.type,
                        codec.rtpmap, codec.fmtp);
                    nativeAdd(stream.getMode(), socket,
                        stream.getRemoteAddress().getHostAddress(),
                        stream.getRemotePort(), codecSpec, dtmfType);
                    mStreams.put(stream, socket);
                } //End block
                catch (NullPointerException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(e);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!mStreams.containsKey(stream)) {
            //try {
                //int socket = stream.dup();
                //String codecSpec = String.format("%d %s %s", codec.type,
                        //codec.rtpmap, codec.fmtp);
                //nativeAdd(stream.getMode(), socket,
                        //stream.getRemoteAddress().getHostAddress(),
                        //stream.getRemotePort(), codecSpec, dtmfType);
                //mStreams.put(stream, socket);
            //} catch (NullPointerException e) {
                //throw new IllegalStateException(e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.135 -0400", hash_original_method = "779FC85A590DA71DFFB7AE3A48802754", hash_generated_method = "33743FA1825382B98C203316F71F432E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeAdd(int mode, int socket, String remoteAddress,
            int remotePort, String codecSpec, int dtmfType) {
        dsTaint.addTaint(codecSpec);
        dsTaint.addTaint(remoteAddress);
        dsTaint.addTaint(socket);
        dsTaint.addTaint(remotePort);
        dsTaint.addTaint(dtmfType);
        dsTaint.addTaint(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.136 -0400", hash_original_method = "E79257D576B41A04A93E4BDE1747C69F", hash_generated_method = "534E682CDC7C8AF39B71ABC3A35E96B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void remove(AudioStream stream) {
        dsTaint.addTaint(stream.dsTaint);
        Integer socket;
        socket = mStreams.remove(stream);
        {
            nativeRemove(socket);
        } //End block
        // ---------- Original Method ----------
        //Integer socket = mStreams.remove(stream);
        //if (socket != null) {
            //nativeRemove(socket);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.136 -0400", hash_original_method = "B9A11772A106AE9307E1900F5171D964", hash_generated_method = "60EEB5A84522CB30F4AA53F5EC6695AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeRemove(int socket) {
        dsTaint.addTaint(socket);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.136 -0400", hash_original_method = "9822465C491E40F2280BD966A816AB8D", hash_generated_method = "8E3BC1304AE7C9F1B18556E224E219F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendDtmf(int event) {
        dsTaint.addTaint(event);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid event");
        } //End block
        {
            nativeSendDtmf(event);
        } //End block
        // ---------- Original Method ----------
        //if (event < 0 || event > 15) {
            //throw new IllegalArgumentException("Invalid event");
        //}
        //synchronized (this) {
            //nativeSendDtmf(event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.136 -0400", hash_original_method = "679235D0DC30313046A01D4FDDB17DEF", hash_generated_method = "53F23F74DD7E160B1B714A4893E66FA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSendDtmf(int event) {
        dsTaint.addTaint(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.136 -0400", hash_original_method = "C7FD23B4AAD822C8D51633C16B0BB499", hash_generated_method = "FEEADEC12D5D8DC1127D9ABF951EFE9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        {
            mStreams.clear();
            nativeRemove(-1);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mStreams.clear();
            //nativeRemove(-1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.137 -0400", hash_original_method = "33021D83EBB0A5B0B0CD9D3745D70974", hash_generated_method = "714CF28135346593C7022C3C55084927")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        clear();
        super.finalize();
        // ---------- Original Method ----------
        //clear();
        //super.finalize();
    }

    
    public static final int MODE_ON_HOLD = 0;
    public static final int MODE_MUTED = 1;
    public static final int MODE_NORMAL = 2;
    public static final int MODE_ECHO_SUPPRESSION = 3;
    private static final int MODE_LAST = 3;
    static {
        System.loadLibrary("rtp_jni");
    }
    
}

