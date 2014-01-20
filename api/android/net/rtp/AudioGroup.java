package android.net.rtp;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;

public class AudioGroup {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.247 -0500", hash_original_field = "4465920A7E69674D8A76280FFFBFC021", hash_generated_field = "C466F26B6C54C57012B25D93B43C8CA1")

    public static final int MODE_ON_HOLD = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.249 -0500", hash_original_field = "3C6B5220ED0769A5E40C8268CAA16E27", hash_generated_field = "0FA96ED453D89F1C2DF647EAC5D004AB")

    public static final int MODE_MUTED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.252 -0500", hash_original_field = "DA3F5B46A5C3C867124EF2B887568F3E", hash_generated_field = "522E920E044FB5E01D5448F2B3D022F8")

    public static final int MODE_NORMAL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.254 -0500", hash_original_field = "B2B59854B998DD1DA5B652920656F0EA", hash_generated_field = "DBC4601D49F876BB8D452756F285D1C8")

    public static final int MODE_ECHO_SUPPRESSION = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.257 -0500", hash_original_field = "8C2592C4A43E1D96B87363ABBF4CE4FE", hash_generated_field = "040E41B70671A8BCEAA18EF1D13E7413")

    private static final int MODE_LAST = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.259 -0500", hash_original_field = "FCB49B9BB76565C2E267D5FB87459819", hash_generated_field = "FA164271CF2AFF347DB26D34D85762CF")

    private  Map<AudioStream, Integer> mStreams;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.261 -0500", hash_original_field = "4233B9BD189FE4002921E820D5754108", hash_generated_field = "4C7DBC83368DD32BF5C59F718910AF60")

    private int mMode = MODE_ON_HOLD;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.263 -0500", hash_original_field = "D883352313723F88BD080533FB82D9CF", hash_generated_field = "9DD3DA3B4DB5A1786C464E9BB7FF265B")

    private int mNative;

    /**
     * Creates an empty AudioGroup.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.267 -0500", hash_original_method = "9E113DACC3DCFC949CC90EBD557A2ACA", hash_generated_method = "834E7F118B11507315081F9FC7A5FE41")
    
public AudioGroup() {
        mStreams = new HashMap<AudioStream, Integer>();
    }

    /**
     * Returns the {@link AudioStream}s in this group.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.269 -0500", hash_original_method = "868089D57ED1EE56E9ACF33DE8DED38E", hash_generated_method = "6E7CF440C1005896AC75B06E058557E9")
    
public AudioStream[] getStreams() {
        synchronized (this) {
            return mStreams.keySet().toArray(new AudioStream[mStreams.size()]);
        }
    }

    /**
     * Returns the current mode.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.271 -0500", hash_original_method = "46CDEAEE57FC46504BB8BB611AFCF88D", hash_generated_method = "70517447F35CFDB022215DEF7415008A")
    
public int getMode() {
        return mMode;
    }

    /**
     * Changes the current mode. It must be one of {@link #MODE_ON_HOLD},
     * {@link #MODE_MUTED}, {@link #MODE_NORMAL}, and
     * {@link #MODE_ECHO_SUPPRESSION}.
     *
     * @param mode The mode to change to.
     * @throws IllegalArgumentException if the mode is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.273 -0500", hash_original_method = "3B407E7A126047BBCD9831E47F9B5D99", hash_generated_method = "80D7549EE5345EE67E06C57BA5B47312")
    
public void setMode(int mode) {
        if (mode < 0 || mode > MODE_LAST) {
            throw new IllegalArgumentException("Invalid mode");
        }
        synchronized (this) {
            nativeSetMode(mode);
            mMode = mode;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.277 -0500", hash_original_method = "49E777EBA85E577A92F07DB5E1A4FF69", hash_generated_method = "5D2B2CD541B48124F75046A904A2B06A")
    
    private void nativeSetMode(int mode){
    	//Formerly a native method
    	addTaint(mode);
    }

    // Package-private method used by AudioStream.join().
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.279 -0500", hash_original_method = "91004DD6DF12C73407D3712D3F37E9FF", hash_generated_method = "F14A8129148CE1D154B64A4C9175583B")
    
synchronized void add(AudioStream stream, AudioCodec codec, int dtmfType) {
        if (!mStreams.containsKey(stream)) {
            try {
                int socket = stream.dup();
                String codecSpec = String.format("%d %s %s", codec.type,
                        codec.rtpmap, codec.fmtp);
                nativeAdd(stream.getMode(), socket,
                        stream.getRemoteAddress().getHostAddress(),
                        stream.getRemotePort(), codecSpec, dtmfType);
                mStreams.put(stream, socket);
            } catch (NullPointerException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.283 -0500", hash_original_method = "779FC85A590DA71DFFB7AE3A48802754", hash_generated_method = "5B6D56C5B51BCDA2F140D86B9F10B1A1")
    
    private void nativeAdd(int mode, int socket, String remoteAddress,
                int remotePort, String codecSpec, int dtmfType){
    	//Formerly a native method
    	addTaint(mode);
    	addTaint(socket);
    	addTaint(remoteAddress.getTaint());
    	addTaint(remotePort);
    	addTaint(codecSpec.getTaint());
    	addTaint(dtmfType);
    }

    // Package-private method used by AudioStream.join().
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.285 -0500", hash_original_method = "E79257D576B41A04A93E4BDE1747C69F", hash_generated_method = "E251AC8033A40DE9CD84D9EB4AE47227")
    
synchronized void remove(AudioStream stream) {
        Integer socket = mStreams.remove(stream);
        if (socket != null) {
            nativeRemove(socket);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.288 -0500", hash_original_method = "B9A11772A106AE9307E1900F5171D964", hash_generated_method = "6D9CA59C2EE4CC5E96E3A5B9A971967A")
    
    private void nativeRemove(int socket){
    	//Formerly a native method
    	addTaint(socket);
    }

    /**
     * Sends a DTMF digit to every {@link AudioStream} in this group. Currently
     * only event {@code 0} to {@code 15} are supported.
     *
     * @throws IllegalArgumentException if the event is invalid.
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.291 -0500", hash_original_method = "9822465C491E40F2280BD966A816AB8D", hash_generated_method = "B9E21FC581C3B5493DA87868773384EC")
    
public void sendDtmf(int event) {
        if (event < 0 || event > 15) {
            throw new IllegalArgumentException("Invalid event");
        }
        synchronized (this) {
            nativeSendDtmf(event);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.294 -0500", hash_original_method = "679235D0DC30313046A01D4FDDB17DEF", hash_generated_method = "FC87FC70DD2069A134CCF357070570B8")
    
    private void nativeSendDtmf(int event){
    	//Formerly a native method
    	addTaint(event);
    }

    /**
     * Removes every {@link AudioStream} in this group.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.297 -0500", hash_original_method = "C7FD23B4AAD822C8D51633C16B0BB499", hash_generated_method = "68D688D9EC5BB816AA4B3F9C351E3E63")
    
public void clear() {
        synchronized (this) {
            mStreams.clear();
            nativeRemove(-1);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.299 -0500", hash_original_method = "33021D83EBB0A5B0B0CD9D3745D70974", hash_generated_method = "45D8EB3F8B2095FB7A733B494EF55201")
    
@Override
    protected void finalize() throws Throwable {
        clear();
        super.finalize();
    }
    static {
        System.loadLibrary("rtp_jni");
    }
    
}

