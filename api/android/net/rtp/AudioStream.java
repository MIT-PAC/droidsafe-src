package android.net.rtp;

// Droidsafe Imports
import java.net.InetAddress;
import java.net.SocketException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class AudioStream extends RtpStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.027 -0400", hash_original_field = "55B2094583B3D384F35AED660A0AC170", hash_generated_field = "48FE1FD1A45DD00365BBA4B7AFE1C228")

    private AudioCodec mCodec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.027 -0400", hash_original_field = "75261E386DBD630353F25C4352ABA4E4", hash_generated_field = "AAAC9649291EA7E9AF23C6AFE907EAE5")

    private int mDtmfType = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.027 -0400", hash_original_field = "21346FE9F16EBAFFE8F776F66247523D", hash_generated_field = "240D951663574AC277AC31BCA3E190DC")

    private AudioGroup mGroup;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.028 -0400", hash_original_method = "409408EC0859D4060DA7CEF5328B7220", hash_generated_method = "6D79D768C8F6FE3D78AE99145267A775")
    public  AudioStream(InetAddress address) throws SocketException {
        super(address);
        addTaint(address.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.028 -0400", hash_original_method = "254DAECE553220B60B3DDCDB0D3A9A7B", hash_generated_method = "C291D10BC96CB0C84C5A7B70B8455D8F")
    @Override
    public final boolean isBusy() {
        boolean var893EB519F818FFC871EF40D76FDB054E_87789966 = (mGroup != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1588328733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1588328733;
        // ---------- Original Method ----------
        //return mGroup != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.028 -0400", hash_original_method = "477F536A3076B0B10A19072AA2686CEC", hash_generated_method = "C902D87C0F8237DFF7BED304D13BEF3D")
    public AudioGroup getGroup() {
AudioGroup var8FC275F44636F88FF4B87724812634C3_1694241955 =         mGroup;
        var8FC275F44636F88FF4B87724812634C3_1694241955.addTaint(taint);
        return var8FC275F44636F88FF4B87724812634C3_1694241955;
        // ---------- Original Method ----------
        //return mGroup;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.029 -0400", hash_original_method = "119D45B9BF5FF64C97C7293B3DF5F7E3", hash_generated_method = "854D05190E7FE6F03C059E08515C79A6")
    public void join(AudioGroup group) {
        synchronized
(this)        {
            if(mGroup == group)            
            {
                return;
            } //End block
            if(mGroup != null)            
            {
                mGroup.remove(this);
                mGroup = null;
            } //End block
            if(group != null)            
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.029 -0400", hash_original_method = "477233579E49B9ACBFE0DA40A2D8DF9C", hash_generated_method = "C9DAB2F75F184DDAC8DC91402E126663")
    public AudioCodec getCodec() {
AudioCodec var37F81D7BD8453D5EBF6A6F3DDE0E93D2_1485196859 =         mCodec;
        var37F81D7BD8453D5EBF6A6F3DDE0E93D2_1485196859.addTaint(taint);
        return var37F81D7BD8453D5EBF6A6F3DDE0E93D2_1485196859;
        // ---------- Original Method ----------
        //return mCodec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.030 -0400", hash_original_method = "E0A36AFBD97A7B298B1941948E16CA1A", hash_generated_method = "69D66076D8D3B2BCC1BED98CA5C993BE")
    public void setCodec(AudioCodec codec) {
        if(isBusy())        
        {
            IllegalStateException varEB02D49C7F66BF6343EB56DDF1963715_348411878 = new IllegalStateException("Busy");
            varEB02D49C7F66BF6343EB56DDF1963715_348411878.addTaint(taint);
            throw varEB02D49C7F66BF6343EB56DDF1963715_348411878;
        } //End block
        if(codec.type == mDtmfType)        
        {
            IllegalArgumentException var8F6F87B886BF78DCA73ED1B291C49528_1660710945 = new IllegalArgumentException("The type is used by DTMF");
            var8F6F87B886BF78DCA73ED1B291C49528_1660710945.addTaint(taint);
            throw var8F6F87B886BF78DCA73ED1B291C49528_1660710945;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.031 -0400", hash_original_method = "67DA2B7B029AD6BDA2A522BA945FCCC7", hash_generated_method = "607D9BF8D44155741F136FADE3ADA606")
    public int getDtmfType() {
        int var076EC8EB5A4D8D6D0B7B64B27BFB2FB2_483825395 = (mDtmfType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_515747722 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_515747722;
        // ---------- Original Method ----------
        //return mDtmfType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.031 -0400", hash_original_method = "08CFB9D3491C3CF797064DF404EB556C", hash_generated_method = "4F25C1F0B765B847FA9DFE5E4D7DD1D4")
    public void setDtmfType(int type) {
        if(isBusy())        
        {
            IllegalStateException varEB02D49C7F66BF6343EB56DDF1963715_1043453538 = new IllegalStateException("Busy");
            varEB02D49C7F66BF6343EB56DDF1963715_1043453538.addTaint(taint);
            throw varEB02D49C7F66BF6343EB56DDF1963715_1043453538;
        } //End block
        if(type != -1)        
        {
            if(type < 96 || type > 127)            
            {
                IllegalArgumentException var9318CB30B49EC598F0007E207440476A_20634240 = new IllegalArgumentException("Invalid type");
                var9318CB30B49EC598F0007E207440476A_20634240.addTaint(taint);
                throw var9318CB30B49EC598F0007E207440476A_20634240;
            } //End block
            if(type == mCodec.type)            
            {
                IllegalArgumentException var668DAC7753EFB03E4CBB71C2905E5098_432184579 = new IllegalArgumentException("The type is used by codec");
                var668DAC7753EFB03E4CBB71C2905E5098_432184579.addTaint(taint);
                throw var668DAC7753EFB03E4CBB71C2905E5098_432184579;
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

