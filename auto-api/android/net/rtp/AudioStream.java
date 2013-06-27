package android.net.rtp;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.InetAddress;
import java.net.SocketException;

public class AudioStream extends RtpStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.283 -0400", hash_original_field = "55B2094583B3D384F35AED660A0AC170", hash_generated_field = "48FE1FD1A45DD00365BBA4B7AFE1C228")

    private AudioCodec mCodec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.283 -0400", hash_original_field = "75261E386DBD630353F25C4352ABA4E4", hash_generated_field = "AAAC9649291EA7E9AF23C6AFE907EAE5")

    private int mDtmfType = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.283 -0400", hash_original_field = "21346FE9F16EBAFFE8F776F66247523D", hash_generated_field = "240D951663574AC277AC31BCA3E190DC")

    private AudioGroup mGroup;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.284 -0400", hash_original_method = "409408EC0859D4060DA7CEF5328B7220", hash_generated_method = "6D79D768C8F6FE3D78AE99145267A775")
    public  AudioStream(InetAddress address) throws SocketException {
        super(address);
        addTaint(address.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.288 -0400", hash_original_method = "254DAECE553220B60B3DDCDB0D3A9A7B", hash_generated_method = "27B8A691C01348DC34BF09009478E440")
    @Override
    public final boolean isBusy() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1955007755 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1955007755;
        // ---------- Original Method ----------
        //return mGroup != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.309 -0400", hash_original_method = "477F536A3076B0B10A19072AA2686CEC", hash_generated_method = "760F059A1E36623AD199E8C3FE6023BC")
    public AudioGroup getGroup() {
        AudioGroup varB4EAC82CA7396A68D541C85D26508E83_1320796150 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1320796150 = mGroup;
        varB4EAC82CA7396A68D541C85D26508E83_1320796150.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1320796150;
        // ---------- Original Method ----------
        //return mGroup;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.311 -0400", hash_original_method = "119D45B9BF5FF64C97C7293B3DF5F7E3", hash_generated_method = "5B85254483E7116788C2267B51F9F2A1")
    public void join(AudioGroup group) {
        {
            {
                mGroup.remove(this);
                mGroup = null;
            } //End block
            {
                group.add(this, mCodec, mDtmfType);
                mGroup = group;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mGroup == group) {
                //return;
            //}
            //if (mGroup != null) {
                //mGroup.remove(this);
                //mGroup = null;
            //}
            //if (group != null) {
                //group.add(this, mCodec, mDtmfType);
                //mGroup = group;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.312 -0400", hash_original_method = "477233579E49B9ACBFE0DA40A2D8DF9C", hash_generated_method = "9BBD8571031010B8A4F77D81143C6C2D")
    public AudioCodec getCodec() {
        AudioCodec varB4EAC82CA7396A68D541C85D26508E83_1132587088 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1132587088 = mCodec;
        varB4EAC82CA7396A68D541C85D26508E83_1132587088.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1132587088;
        // ---------- Original Method ----------
        //return mCodec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.333 -0400", hash_original_method = "E0A36AFBD97A7B298B1941948E16CA1A", hash_generated_method = "4D239907F7BA3F848E1DCF51982FCF49")
    public void setCodec(AudioCodec codec) {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_2068155984 = (isBusy());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Busy");
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The type is used by DTMF");
        } //End block
        mCodec = codec;
        // ---------- Original Method ----------
        //if (isBusy()) {
            //throw new IllegalStateException("Busy");
        //}
        //if (codec.type == mDtmfType) {
            //throw new IllegalArgumentException("The type is used by DTMF");
        //}
        //mCodec = codec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.337 -0400", hash_original_method = "67DA2B7B029AD6BDA2A522BA945FCCC7", hash_generated_method = "9E43F0674E37828B808EE61E4F586F68")
    public int getDtmfType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1033561900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1033561900;
        // ---------- Original Method ----------
        //return mDtmfType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.338 -0400", hash_original_method = "08CFB9D3491C3CF797064DF404EB556C", hash_generated_method = "929AB1420E834722ABB5FB5B3A9AC663")
    public void setDtmfType(int type) {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_925400816 = (isBusy());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Busy");
            } //End block
        } //End collapsed parenthetic
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid type");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The type is used by codec");
            } //End block
        } //End block
        mDtmfType = type;
        // ---------- Original Method ----------
        //if (isBusy()) {
            //throw new IllegalStateException("Busy");
        //}
        //if (type != -1) {
            //if (type < 96 || type > 127) {
                //throw new IllegalArgumentException("Invalid type");
            //}
            //if (type == mCodec.type) {
                //throw new IllegalArgumentException("The type is used by codec");
            //}
        //}
        //mDtmfType = type;
    }

    
}

