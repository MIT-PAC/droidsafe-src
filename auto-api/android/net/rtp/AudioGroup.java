package android.net.rtp;

// Droidsafe Imports
import java.util.HashMap;
import java.util.Map;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class AudioGroup {
    public static final int MODE_ON_HOLD = 0;
    public static final int MODE_MUTED = 1;
    public static final int MODE_NORMAL = 2;
    public static final int MODE_ECHO_SUPPRESSION = 3;
    private static final int MODE_LAST = 3;
    private final Map<AudioStream, Integer> mStreams;
    private int mMode = MODE_ON_HOLD;
    private int mNative;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.283 -0400", hash_original_method = "9E113DACC3DCFC949CC90EBD557A2ACA", hash_generated_method = "FFF61C7FE46C0577C54798BD0F4B6EB4")
    @DSModeled(DSC.SAFE)
    public AudioGroup() {
        mStreams = new HashMap<AudioStream, Integer>();
        // ---------- Original Method ----------
        //mStreams = new HashMap<AudioStream, Integer>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.283 -0400", hash_original_method = "868089D57ED1EE56E9ACF33DE8DED38E", hash_generated_method = "C1F2690B2F4844A515D27330DC6E80BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AudioStream[] getStreams() {
        {
            AudioStream[] varB86D8BBD4FFBDC772AC682BB7ADBAAC6_1053735692 = (mStreams.keySet().toArray(new AudioStream[mStreams.size()]));
        } //End block
        return (AudioStream[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mStreams.keySet().toArray(new AudioStream[mStreams.size()]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.283 -0400", hash_original_method = "46CDEAEE57FC46504BB8BB611AFCF88D", hash_generated_method = "CD5645CD4FC965CE17B38E67F6DA3C8D")
    @DSModeled(DSC.SAFE)
    public int getMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.284 -0400", hash_original_method = "3B407E7A126047BBCD9831E47F9B5D99", hash_generated_method = "B2C940F0CAA8B42310B32D2EA4CFE5CD")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.284 -0400", hash_original_method = "49E777EBA85E577A92F07DB5E1A4FF69", hash_generated_method = "908DABE7A1782F6431425AAF73B8ECE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetMode(int mode) {
        dsTaint.addTaint(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.284 -0400", hash_original_method = "91004DD6DF12C73407D3712D3F37E9FF", hash_generated_method = "926BF9170144E3D7D4835634AF84FE88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void add(AudioStream stream, AudioCodec codec, int dtmfType) {
        dsTaint.addTaint(stream.dsTaint);
        dsTaint.addTaint(codec.dsTaint);
        dsTaint.addTaint(dtmfType);
        {
            boolean var462179FDA5D963857F5CDBF7C2D70E51_1377369849 = (!mStreams.containsKey(stream));
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
                    throw new IllegalStateException(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.284 -0400", hash_original_method = "779FC85A590DA71DFFB7AE3A48802754", hash_generated_method = "3ECA9E313740633C02DD98209795E928")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeAdd(int mode, int socket, String remoteAddress,
            int remotePort, String codecSpec, int dtmfType) {
        dsTaint.addTaint(codecSpec);
        dsTaint.addTaint(remoteAddress);
        dsTaint.addTaint(socket);
        dsTaint.addTaint(remotePort);
        dsTaint.addTaint(mode);
        dsTaint.addTaint(dtmfType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.284 -0400", hash_original_method = "E79257D576B41A04A93E4BDE1747C69F", hash_generated_method = "4A2999EB6DC39EEAC7B02993134415E3")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.284 -0400", hash_original_method = "B9A11772A106AE9307E1900F5171D964", hash_generated_method = "F954AD3FCD3124B5830A4395B5CC274D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeRemove(int socket) {
        dsTaint.addTaint(socket);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.284 -0400", hash_original_method = "9822465C491E40F2280BD966A816AB8D", hash_generated_method = "0C18DC21D35BA1F7E563FA8A39111809")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.284 -0400", hash_original_method = "679235D0DC30313046A01D4FDDB17DEF", hash_generated_method = "217E17489E7B22E7B11461A98A03DC7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSendDtmf(int event) {
        dsTaint.addTaint(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.284 -0400", hash_original_method = "C7FD23B4AAD822C8D51633C16B0BB499", hash_generated_method = "22775CB2EC6E0AA43E965198E12BA25F")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.285 -0400", hash_original_method = "33021D83EBB0A5B0B0CD9D3745D70974", hash_generated_method = "C3BCD165F92ED961495AFE214C08CE69")
    @DSModeled(DSC.SAFE)
    @Override
    protected void finalize() throws Throwable {
        clear();
        super.finalize();
        // ---------- Original Method ----------
        //clear();
        //super.finalize();
    }

    
    static {
        System.loadLibrary("rtp_jni");
    }
    
}


