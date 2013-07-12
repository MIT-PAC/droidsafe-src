package android.net.rtp;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.media.AudioManager;
import java.util.HashMap;
import java.util.Map;

public class AudioGroup {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.843 -0400", hash_original_field = "A1ADF33EC233D9220AFA3F7B9CA06090", hash_generated_field = "FA164271CF2AFF347DB26D34D85762CF")

    private Map<AudioStream, Integer> mStreams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.843 -0400", hash_original_field = "69195263FDF704D386CDDE3B1ADC9F0C", hash_generated_field = "4C7DBC83368DD32BF5C59F718910AF60")

    private int mMode = MODE_ON_HOLD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.843 -0400", hash_original_field = "8AF77D45DED615EEBE14D961B1D7F7CE", hash_generated_field = "9DD3DA3B4DB5A1786C464E9BB7FF265B")

    private int mNative;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.844 -0400", hash_original_method = "9E113DACC3DCFC949CC90EBD557A2ACA", hash_generated_method = "0A80C29DBACA16C4F76FC1A830D63EA7")
    public  AudioGroup() {
        mStreams = new HashMap<AudioStream, Integer>();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.844 -0400", hash_original_method = "868089D57ED1EE56E9ACF33DE8DED38E", hash_generated_method = "3904EFE7E63C0657314093A507010B05")
    public AudioStream[] getStreams() {
        synchronized
(this)        {
AudioStream[] varE7B6A514283364169051E32B606A4A2B_213561784 =             mStreams.keySet().toArray(new AudioStream[mStreams.size()]);
            varE7B6A514283364169051E32B606A4A2B_213561784.addTaint(taint);
            return varE7B6A514283364169051E32B606A4A2B_213561784;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.845 -0400", hash_original_method = "46CDEAEE57FC46504BB8BB611AFCF88D", hash_generated_method = "244E0BC75CFF5850A8C23113EBC345ED")
    public int getMode() {
        int varC5AB706852158521E9D44BF62A49B1C9_1823317999 = (mMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117206190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117206190;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.846 -0400", hash_original_method = "3B407E7A126047BBCD9831E47F9B5D99", hash_generated_method = "DB60A0D05F1C17F8763565C469D3E621")
    public void setMode(int mode) {
    if(mode < 0 || mode > MODE_LAST)        
        {
            IllegalArgumentException varAED0A43B1A76B4B03E1EFA392603C665_2133177070 = new IllegalArgumentException("Invalid mode");
            varAED0A43B1A76B4B03E1EFA392603C665_2133177070.addTaint(taint);
            throw varAED0A43B1A76B4B03E1EFA392603C665_2133177070;
        } 
        synchronized
(this)        {
            nativeSetMode(mode);
            mMode = mode;
        } 
        
        
            
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.846 -0400", hash_original_method = "49E777EBA85E577A92F07DB5E1A4FF69", hash_generated_method = "506A37E6792F21E53D3F6FDBE4ED0F16")
    private void nativeSetMode(int mode) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.847 -0400", hash_original_method = "91004DD6DF12C73407D3712D3F37E9FF", hash_generated_method = "85BC8F3D09666D358F2919365FDCF720")
    synchronized void add(AudioStream stream, AudioCodec codec, int dtmfType) {
        addTaint(dtmfType);
        addTaint(codec.getTaint());
        addTaint(stream.getTaint());
    if(!mStreams.containsKey(stream))        
        {
            try 
            {
                int socket = stream.dup();
                String codecSpec = String.format("%d %s %s", codec.type,
                        codec.rtpmap, codec.fmtp);
                nativeAdd(stream.getMode(), socket,
                        stream.getRemoteAddress().getHostAddress(),
                        stream.getRemotePort(), codecSpec, dtmfType);
                mStreams.put(stream, socket);
            } 
            catch (NullPointerException e)
            {
                IllegalStateException var9CE996783689A44496E32DC249802075_1259563562 = new IllegalStateException(e);
                var9CE996783689A44496E32DC249802075_1259563562.addTaint(taint);
                throw var9CE996783689A44496E32DC249802075_1259563562;
            } 
        } 
        
        
            
                
                
                        
                
                        
                        
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.849 -0400", hash_original_method = "779FC85A590DA71DFFB7AE3A48802754", hash_generated_method = "649CA0A7A04D96E68294E9EEAD7DE3F3")
    private void nativeAdd(int mode, int socket, String remoteAddress,
            int remotePort, String codecSpec, int dtmfType) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.850 -0400", hash_original_method = "E79257D576B41A04A93E4BDE1747C69F", hash_generated_method = "5FE7B03FEF0C925470288E4EA7A746B4")
    synchronized void remove(AudioStream stream) {
        addTaint(stream.getTaint());
        Integer socket = mStreams.remove(stream);
    if(socket != null)        
        {
            nativeRemove(socket);
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.851 -0400", hash_original_method = "B9A11772A106AE9307E1900F5171D964", hash_generated_method = "FB353169F1C9BF8BEE1773EEEE62E147")
    private void nativeRemove(int socket) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.852 -0400", hash_original_method = "9822465C491E40F2280BD966A816AB8D", hash_generated_method = "F9F033368BD8208C34F218E7B2B40C0B")
    public void sendDtmf(int event) {
        addTaint(event);
    if(event < 0 || event > 15)        
        {
            IllegalArgumentException varD7A395C13AE3769DC0B7E68D62E846C2_1765501901 = new IllegalArgumentException("Invalid event");
            varD7A395C13AE3769DC0B7E68D62E846C2_1765501901.addTaint(taint);
            throw varD7A395C13AE3769DC0B7E68D62E846C2_1765501901;
        } 
        synchronized
(this)        {
            nativeSendDtmf(event);
        } 
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.852 -0400", hash_original_method = "679235D0DC30313046A01D4FDDB17DEF", hash_generated_method = "941DDD9A7FDB872AD700C070C8E036BF")
    private void nativeSendDtmf(int event) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.853 -0400", hash_original_method = "C7FD23B4AAD822C8D51633C16B0BB499", hash_generated_method = "EF5D67FF6D2260FAD583D2C50AC857D3")
    public void clear() {
        synchronized
(this)        {
            mStreams.clear();
            nativeRemove(-1);
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.854 -0400", hash_original_method = "33021D83EBB0A5B0B0CD9D3745D70974", hash_generated_method = "714CF28135346593C7022C3C55084927")
    @Override
    protected void finalize() throws Throwable {
        clear();
        super.finalize();
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.854 -0400", hash_original_field = "98192EACA477A586761B6D8CDB089C5D", hash_generated_field = "C466F26B6C54C57012B25D93B43C8CA1")

    public static final int MODE_ON_HOLD = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.854 -0400", hash_original_field = "D2F89274C448233CCFB1966837368D47", hash_generated_field = "0FA96ED453D89F1C2DF647EAC5D004AB")

    public static final int MODE_MUTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.854 -0400", hash_original_field = "E2791FE7213F504CD091FEF19A00F984", hash_generated_field = "522E920E044FB5E01D5448F2B3D022F8")

    public static final int MODE_NORMAL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.854 -0400", hash_original_field = "0C55CD278FE41B37D1616CECC284B970", hash_generated_field = "DBC4601D49F876BB8D452756F285D1C8")

    public static final int MODE_ECHO_SUPPRESSION = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.854 -0400", hash_original_field = "AF8485CCCA8A2CDAE6DDEB6959D43343", hash_generated_field = "040E41B70671A8BCEAA18EF1D13E7413")

    private static final int MODE_LAST = 3;
    static {
        System.loadLibrary("rtp_jni");
    }
    
}

