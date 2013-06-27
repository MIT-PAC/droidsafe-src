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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.097 -0400", hash_original_field = "A1ADF33EC233D9220AFA3F7B9CA06090", hash_generated_field = "FA164271CF2AFF347DB26D34D85762CF")

    private Map<AudioStream, Integer> mStreams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.097 -0400", hash_original_field = "69195263FDF704D386CDDE3B1ADC9F0C", hash_generated_field = "4C7DBC83368DD32BF5C59F718910AF60")

    private int mMode = MODE_ON_HOLD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.097 -0400", hash_original_field = "8AF77D45DED615EEBE14D961B1D7F7CE", hash_generated_field = "9DD3DA3B4DB5A1786C464E9BB7FF265B")

    private int mNative;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.102 -0400", hash_original_method = "9E113DACC3DCFC949CC90EBD557A2ACA", hash_generated_method = "0A80C29DBACA16C4F76FC1A830D63EA7")
    public  AudioGroup() {
        mStreams = new HashMap<AudioStream, Integer>();
        // ---------- Original Method ----------
        //mStreams = new HashMap<AudioStream, Integer>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.112 -0400", hash_original_method = "868089D57ED1EE56E9ACF33DE8DED38E", hash_generated_method = "E04D2B515603C236FCEF883BBCAC2D75")
    public AudioStream[] getStreams() {
        AudioStream[] varB4EAC82CA7396A68D541C85D26508E83_834691371 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_834691371 = mStreams.keySet().toArray(new AudioStream[mStreams.size()]);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_834691371.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_834691371;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mStreams.keySet().toArray(new AudioStream[mStreams.size()]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.124 -0400", hash_original_method = "46CDEAEE57FC46504BB8BB611AFCF88D", hash_generated_method = "6B31DD65DDEC41E434CE99824C24C662")
    public int getMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_581688816 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_581688816;
        // ---------- Original Method ----------
        //return mMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.125 -0400", hash_original_method = "3B407E7A126047BBCD9831E47F9B5D99", hash_generated_method = "5221C08244862F3B8D3F235F45B991C1")
    public void setMode(int mode) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid mode");
        } //End block
        {
            nativeSetMode(mode);
            mMode = mode;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.125 -0400", hash_original_method = "49E777EBA85E577A92F07DB5E1A4FF69", hash_generated_method = "506A37E6792F21E53D3F6FDBE4ED0F16")
    private void nativeSetMode(int mode) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.130 -0400", hash_original_method = "91004DD6DF12C73407D3712D3F37E9FF", hash_generated_method = "38FF0BB01E1EFA4F3019D69B45E4324D")
    synchronized void add(AudioStream stream, AudioCodec codec, int dtmfType) {
        {
            boolean var462179FDA5D963857F5CDBF7C2D70E51_2144186450 = (!mStreams.containsKey(stream));
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
        addTaint(stream.getTaint());
        addTaint(codec.getTaint());
        addTaint(dtmfType);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.131 -0400", hash_original_method = "779FC85A590DA71DFFB7AE3A48802754", hash_generated_method = "649CA0A7A04D96E68294E9EEAD7DE3F3")
    private void nativeAdd(int mode, int socket, String remoteAddress,
            int remotePort, String codecSpec, int dtmfType) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.132 -0400", hash_original_method = "E79257D576B41A04A93E4BDE1747C69F", hash_generated_method = "FE7427ECEB853CCDBCDD959410E9038D")
    synchronized void remove(AudioStream stream) {
        Integer socket;
        socket = mStreams.remove(stream);
        {
            nativeRemove(socket);
        } //End block
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //Integer socket = mStreams.remove(stream);
        //if (socket != null) {
            //nativeRemove(socket);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.132 -0400", hash_original_method = "B9A11772A106AE9307E1900F5171D964", hash_generated_method = "FB353169F1C9BF8BEE1773EEEE62E147")
    private void nativeRemove(int socket) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.167 -0400", hash_original_method = "9822465C491E40F2280BD966A816AB8D", hash_generated_method = "1D3C9B9BDA207982B79288C9F9B874D4")
    public void sendDtmf(int event) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid event");
        } //End block
        {
            nativeSendDtmf(event);
        } //End block
        addTaint(event);
        // ---------- Original Method ----------
        //if (event < 0 || event > 15) {
            //throw new IllegalArgumentException("Invalid event");
        //}
        //synchronized (this) {
            //nativeSendDtmf(event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.167 -0400", hash_original_method = "679235D0DC30313046A01D4FDDB17DEF", hash_generated_method = "941DDD9A7FDB872AD700C070C8E036BF")
    private void nativeSendDtmf(int event) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.168 -0400", hash_original_method = "C7FD23B4AAD822C8D51633C16B0BB499", hash_generated_method = "FEEADEC12D5D8DC1127D9ABF951EFE9D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.169 -0400", hash_original_method = "33021D83EBB0A5B0B0CD9D3745D70974", hash_generated_method = "714CF28135346593C7022C3C55084927")
    @Override
    protected void finalize() throws Throwable {
        clear();
        super.finalize();
        // ---------- Original Method ----------
        //clear();
        //super.finalize();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.169 -0400", hash_original_field = "98192EACA477A586761B6D8CDB089C5D", hash_generated_field = "C466F26B6C54C57012B25D93B43C8CA1")

    public static final int MODE_ON_HOLD = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.169 -0400", hash_original_field = "D2F89274C448233CCFB1966837368D47", hash_generated_field = "0FA96ED453D89F1C2DF647EAC5D004AB")

    public static final int MODE_MUTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.169 -0400", hash_original_field = "E2791FE7213F504CD091FEF19A00F984", hash_generated_field = "522E920E044FB5E01D5448F2B3D022F8")

    public static final int MODE_NORMAL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.169 -0400", hash_original_field = "0C55CD278FE41B37D1616CECC284B970", hash_generated_field = "DBC4601D49F876BB8D452756F285D1C8")

    public static final int MODE_ECHO_SUPPRESSION = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.169 -0400", hash_original_field = "AF8485CCCA8A2CDAE6DDEB6959D43343", hash_generated_field = "FF6CC6B6CD5E66C393F0943FE0A77929")

    private static int MODE_LAST = 3;
    static {
        System.loadLibrary("rtp_jni");
    }
    
}

