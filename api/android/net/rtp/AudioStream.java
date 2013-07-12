package android.net.rtp;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.InetAddress;
import java.net.SocketException;

public class AudioStream extends RtpStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.862 -0400", hash_original_field = "55B2094583B3D384F35AED660A0AC170", hash_generated_field = "48FE1FD1A45DD00365BBA4B7AFE1C228")

    private AudioCodec mCodec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.862 -0400", hash_original_field = "75261E386DBD630353F25C4352ABA4E4", hash_generated_field = "AAAC9649291EA7E9AF23C6AFE907EAE5")

    private int mDtmfType = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.863 -0400", hash_original_field = "21346FE9F16EBAFFE8F776F66247523D", hash_generated_field = "240D951663574AC277AC31BCA3E190DC")

    private AudioGroup mGroup;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.863 -0400", hash_original_method = "409408EC0859D4060DA7CEF5328B7220", hash_generated_method = "6D79D768C8F6FE3D78AE99145267A775")
    public  AudioStream(InetAddress address) throws SocketException {
        super(address);
        addTaint(address.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.863 -0400", hash_original_method = "254DAECE553220B60B3DDCDB0D3A9A7B", hash_generated_method = "C21CFE11AA382F336665CE22E3CA87B6")
    @Override
    public final boolean isBusy() {
        boolean var893EB519F818FFC871EF40D76FDB054E_150940831 = (mGroup != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1355038123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1355038123;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.864 -0400", hash_original_method = "477F536A3076B0B10A19072AA2686CEC", hash_generated_method = "C11A4416DDB66440DAEAEA62CD783E9F")
    public AudioGroup getGroup() {
AudioGroup var8FC275F44636F88FF4B87724812634C3_581841642 =         mGroup;
        var8FC275F44636F88FF4B87724812634C3_581841642.addTaint(taint);
        return var8FC275F44636F88FF4B87724812634C3_581841642;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.865 -0400", hash_original_method = "119D45B9BF5FF64C97C7293B3DF5F7E3", hash_generated_method = "854D05190E7FE6F03C059E08515C79A6")
    public void join(AudioGroup group) {
        synchronized
(this)        {
    if(mGroup == group)            
            {
                return;
            } 
    if(mGroup != null)            
            {
                mGroup.remove(this);
                mGroup = null;
            } 
    if(group != null)            
            {
                group.add(this, mCodec, mDtmfType);
                mGroup = group;
            } 
        } 
        
        
            
                
            
            
                
                
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.866 -0400", hash_original_method = "477233579E49B9ACBFE0DA40A2D8DF9C", hash_generated_method = "05C1701C6A1FA5014D1E5801460C992A")
    public AudioCodec getCodec() {
AudioCodec var37F81D7BD8453D5EBF6A6F3DDE0E93D2_516839202 =         mCodec;
        var37F81D7BD8453D5EBF6A6F3DDE0E93D2_516839202.addTaint(taint);
        return var37F81D7BD8453D5EBF6A6F3DDE0E93D2_516839202;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.867 -0400", hash_original_method = "E0A36AFBD97A7B298B1941948E16CA1A", hash_generated_method = "A8E588528BCA1AFFF68CBF167FCAAD9D")
    public void setCodec(AudioCodec codec) {
    if(isBusy())        
        {
            IllegalStateException varEB02D49C7F66BF6343EB56DDF1963715_1084720105 = new IllegalStateException("Busy");
            varEB02D49C7F66BF6343EB56DDF1963715_1084720105.addTaint(taint);
            throw varEB02D49C7F66BF6343EB56DDF1963715_1084720105;
        } 
    if(codec.type == mDtmfType)        
        {
            IllegalArgumentException var8F6F87B886BF78DCA73ED1B291C49528_479986366 = new IllegalArgumentException("The type is used by DTMF");
            var8F6F87B886BF78DCA73ED1B291C49528_479986366.addTaint(taint);
            throw var8F6F87B886BF78DCA73ED1B291C49528_479986366;
        } 
        mCodec = codec;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.867 -0400", hash_original_method = "67DA2B7B029AD6BDA2A522BA945FCCC7", hash_generated_method = "62A253F12CB222AB808B21216E17ED9C")
    public int getDtmfType() {
        int var076EC8EB5A4D8D6D0B7B64B27BFB2FB2_974836538 = (mDtmfType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1546197463 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1546197463;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.868 -0400", hash_original_method = "08CFB9D3491C3CF797064DF404EB556C", hash_generated_method = "77EA81BC23B8A2C67817C22792BAE0EB")
    public void setDtmfType(int type) {
    if(isBusy())        
        {
            IllegalStateException varEB02D49C7F66BF6343EB56DDF1963715_652366150 = new IllegalStateException("Busy");
            varEB02D49C7F66BF6343EB56DDF1963715_652366150.addTaint(taint);
            throw varEB02D49C7F66BF6343EB56DDF1963715_652366150;
        } 
    if(type != -1)        
        {
    if(type < 96 || type > 127)            
            {
                IllegalArgumentException var9318CB30B49EC598F0007E207440476A_1490829366 = new IllegalArgumentException("Invalid type");
                var9318CB30B49EC598F0007E207440476A_1490829366.addTaint(taint);
                throw var9318CB30B49EC598F0007E207440476A_1490829366;
            } 
    if(type == mCodec.type)            
            {
                IllegalArgumentException var668DAC7753EFB03E4CBB71C2905E5098_554846699 = new IllegalArgumentException("The type is used by codec");
                var668DAC7753EFB03E4CBB71C2905E5098_554846699.addTaint(taint);
                throw var668DAC7753EFB03E4CBB71C2905E5098_554846699;
            } 
        } 
        mDtmfType = type;
        
        
            
        
        
            
                
            
            
                
            
        
        
    }

    
}

