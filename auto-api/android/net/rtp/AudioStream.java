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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.086 -0400", hash_original_field = "55B2094583B3D384F35AED660A0AC170", hash_generated_field = "48FE1FD1A45DD00365BBA4B7AFE1C228")

    private AudioCodec mCodec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.086 -0400", hash_original_field = "75261E386DBD630353F25C4352ABA4E4", hash_generated_field = "AAAC9649291EA7E9AF23C6AFE907EAE5")

    private int mDtmfType = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.086 -0400", hash_original_field = "21346FE9F16EBAFFE8F776F66247523D", hash_generated_field = "240D951663574AC277AC31BCA3E190DC")

    private AudioGroup mGroup;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.095 -0400", hash_original_method = "409408EC0859D4060DA7CEF5328B7220", hash_generated_method = "6D79D768C8F6FE3D78AE99145267A775")
    public  AudioStream(InetAddress address) throws SocketException {
        super(address);
        addTaint(address.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.095 -0400", hash_original_method = "254DAECE553220B60B3DDCDB0D3A9A7B", hash_generated_method = "978B0F1EBAF4B59CAF968F4BF3837BDA")
    @Override
    public final boolean isBusy() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2043893970 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2043893970;
        // ---------- Original Method ----------
        //return mGroup != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.096 -0400", hash_original_method = "477F536A3076B0B10A19072AA2686CEC", hash_generated_method = "353FAC58F814C33170F1BEBF7A969F1D")
    public AudioGroup getGroup() {
        AudioGroup varB4EAC82CA7396A68D541C85D26508E83_1142090615 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1142090615 = mGroup;
        varB4EAC82CA7396A68D541C85D26508E83_1142090615.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1142090615;
        // ---------- Original Method ----------
        //return mGroup;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.108 -0400", hash_original_method = "119D45B9BF5FF64C97C7293B3DF5F7E3", hash_generated_method = "5B85254483E7116788C2267B51F9F2A1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.109 -0400", hash_original_method = "477233579E49B9ACBFE0DA40A2D8DF9C", hash_generated_method = "508D22884C1552709FF62D9955341529")
    public AudioCodec getCodec() {
        AudioCodec varB4EAC82CA7396A68D541C85D26508E83_61811159 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_61811159 = mCodec;
        varB4EAC82CA7396A68D541C85D26508E83_61811159.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_61811159;
        // ---------- Original Method ----------
        //return mCodec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.109 -0400", hash_original_method = "E0A36AFBD97A7B298B1941948E16CA1A", hash_generated_method = "98F89F536E6222E9ADB1E7B5DE93F933")
    public void setCodec(AudioCodec codec) {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_1384508416 = (isBusy());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.112 -0400", hash_original_method = "67DA2B7B029AD6BDA2A522BA945FCCC7", hash_generated_method = "D802DCDA495C519C740D5C02C8829097")
    public int getDtmfType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_627675312 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_627675312;
        // ---------- Original Method ----------
        //return mDtmfType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.113 -0400", hash_original_method = "08CFB9D3491C3CF797064DF404EB556C", hash_generated_method = "0511E17B08FB1A3C64157115519FC0EE")
    public void setDtmfType(int type) {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_2094855423 = (isBusy());
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

