package android.net.rtp;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.net.InetAddress;
import java.net.SocketException;

public class AudioStream extends RtpStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.525 -0400", hash_original_field = "55B2094583B3D384F35AED660A0AC170", hash_generated_field = "48FE1FD1A45DD00365BBA4B7AFE1C228")

    private AudioCodec mCodec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.525 -0400", hash_original_field = "75261E386DBD630353F25C4352ABA4E4", hash_generated_field = "AAAC9649291EA7E9AF23C6AFE907EAE5")

    private int mDtmfType = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.525 -0400", hash_original_field = "21346FE9F16EBAFFE8F776F66247523D", hash_generated_field = "240D951663574AC277AC31BCA3E190DC")

    private AudioGroup mGroup;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.526 -0400", hash_original_method = "409408EC0859D4060DA7CEF5328B7220", hash_generated_method = "6D79D768C8F6FE3D78AE99145267A775")
    public  AudioStream(InetAddress address) throws SocketException {
        super(address);
        addTaint(address.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.526 -0400", hash_original_method = "254DAECE553220B60B3DDCDB0D3A9A7B", hash_generated_method = "1C8F8E9B7AA4B31C7C445CB20FDD7D19")
    @Override
    public final boolean isBusy() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_701593714 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_701593714;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.526 -0400", hash_original_method = "477F536A3076B0B10A19072AA2686CEC", hash_generated_method = "0DDBB4CA0C3641C17098D38592D17CE4")
    public AudioGroup getGroup() {
        AudioGroup varB4EAC82CA7396A68D541C85D26508E83_1523208866 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1523208866 = mGroup;
        varB4EAC82CA7396A68D541C85D26508E83_1523208866.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1523208866;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.527 -0400", hash_original_method = "119D45B9BF5FF64C97C7293B3DF5F7E3", hash_generated_method = "5B85254483E7116788C2267B51F9F2A1")
    public void join(AudioGroup group) {
        {
            {
                mGroup.remove(this);
                mGroup = null;
            } 
            {
                group.add(this, mCodec, mDtmfType);
                mGroup = group;
            } 
        } 
        
        
            
                
            
            
                
                
            
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.527 -0400", hash_original_method = "477233579E49B9ACBFE0DA40A2D8DF9C", hash_generated_method = "5B962C8255025EF33780899818A4380A")
    public AudioCodec getCodec() {
        AudioCodec varB4EAC82CA7396A68D541C85D26508E83_1190711589 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1190711589 = mCodec;
        varB4EAC82CA7396A68D541C85D26508E83_1190711589.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1190711589;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.528 -0400", hash_original_method = "E0A36AFBD97A7B298B1941948E16CA1A", hash_generated_method = "E54ACCF6E405279D954B8F777A3DF61B")
    public void setCodec(AudioCodec codec) {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_147308850 = (isBusy());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Busy");
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The type is used by DTMF");
        } 
        mCodec = codec;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.528 -0400", hash_original_method = "67DA2B7B029AD6BDA2A522BA945FCCC7", hash_generated_method = "3C02EEA2FC85697E1C1FEAED42F26D63")
    public int getDtmfType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1053953620 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1053953620;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.529 -0400", hash_original_method = "08CFB9D3491C3CF797064DF404EB556C", hash_generated_method = "65706991252B9D48B425281CD22D4078")
    public void setDtmfType(int type) {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_840530891 = (isBusy());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Busy");
            } 
        } 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid type");
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The type is used by codec");
            } 
        } 
        mDtmfType = type;
        
        
            
        
        
            
                
            
            
                
            
        
        
    }

    
}

