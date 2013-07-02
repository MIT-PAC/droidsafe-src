package com.android.internal.telephony.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.telephony.Call;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.UUSInfo;
import android.net.sip.SipAudioCall;
import android.os.SystemClock;
import android.util.Log;
import android.telephony.PhoneNumberUtils;

abstract class SipConnectionBase extends Connection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.083 -0400", hash_original_field = "DF701BED26C9A6E82B434D3ADA19F19A", hash_generated_field = "D1359B5A0587476130FC171DA764AC68")

    private SipAudioCall mSipAudioCall;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.083 -0400", hash_original_field = "6BEE54DB0A5A8BDBAB5D2767D60E4A06", hash_generated_field = "E672830D2E0B106901DACBA6E0B923A6")

    private String dialString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.083 -0400", hash_original_field = "651EFD6FB9FDDF9C1713795AFFA34606", hash_generated_field = "6F94828D80A08223A3D2C4840C810E5C")

    private String postDialString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.083 -0400", hash_original_field = "0F847399DDED77AD45DD7EA28753707C", hash_generated_field = "A0D8F46E603AB3E7C2624AFEC4BCC56F")

    private int nextPostDialChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.083 -0400", hash_original_field = "BC23EBAFF55FFCC779696072ED387D2F", hash_generated_field = "899B35935BADAD00E40EEE48034FA777")

    private boolean isIncoming;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.083 -0400", hash_original_field = "1ED2E1B19B6E55D52D2473BE17A4AFD9", hash_generated_field = "2B7C094BB4119A5846E4078843652104")

    private long createTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.083 -0400", hash_original_field = "2A390E9117109AD2E2B8D0011E8B167F", hash_generated_field = "3A10CD6DE0D1F8841131E8E3B55CDF17")

    private long connectTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.083 -0400", hash_original_field = "AD92DC1F9C0B5401DB7C9C68DE643AD5", hash_generated_field = "4A468F625B3893CC4E044A175513CACE")

    private long disconnectTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.083 -0400", hash_original_field = "109C61524952CEA8F4A768697A2B73EA", hash_generated_field = "BD81C614EFF599A99945A7CA6F0301ED")

    private long connectTimeReal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.083 -0400", hash_original_field = "B233BB93E83D178371054578F279C542", hash_generated_field = "B71E8F5397B52F575D65D0F3A413011B")

    private long duration = -1L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.083 -0400", hash_original_field = "A2E64D805CF0AE78B184102EDC3BD0CA", hash_generated_field = "0C720B6C915AEB7736CF4596137134F0")

    private long holdingStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.083 -0400", hash_original_field = "2C3EDA892EC57CCBFC8A3FC4EDCA5971", hash_generated_field = "A263BBCF4D1AE1517BA0D25DE4E6D1FC")

    private DisconnectCause mCause = DisconnectCause.NOT_DISCONNECTED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.083 -0400", hash_original_field = "9D7046FD56054C9553777648B65C3DFB", hash_generated_field = "D20AEA8FE258625EB4F340AF843F84F8")

    private PostDialState postDialState = PostDialState.NOT_STARTED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.083 -0400", hash_original_method = "D12ADA666E21FFAC81BC845F1B1B388F", hash_generated_method = "0A147067DDC7E6520776E477ED6F8818")
      SipConnectionBase(String dialString) {
        this.dialString = dialString;
        postDialString = PhoneNumberUtils.extractPostDialPortion(dialString);
        isIncoming = false;
        createTime = System.currentTimeMillis();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.084 -0400", hash_original_method = "9D87CB1ACC156683FA215308BE25D1D9", hash_generated_method = "F5656525211514DEA1ADCE820CBCC947")
    protected void setState(Call.State state) {
        
        {
            connectTimeReal = SystemClock.elapsedRealtime();
            connectTime = System.currentTimeMillis();
        } 
        
        
        duration = getDurationMillis();
        
        
        disconnectTime = System.currentTimeMillis();
        
        
        holdingStartTime = SystemClock.elapsedRealtime();
        
        addTaint(state.getTaint());
        
        
            
                
                    
                    
                
                
            
                
                
                
            
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.084 -0400", hash_original_method = "A8956DD6ACAC2731E62816490C646631", hash_generated_method = "2851F0C6353A96A26B8D2BBDBB18D934")
    @Override
    public long getCreateTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_361513468 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_361513468;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.085 -0400", hash_original_method = "540CF01EF64CF5C6BAC1246743ECA8F1", hash_generated_method = "159AD090C96A401F2DC15BABC79824D8")
    @Override
    public long getConnectTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_368335593 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_368335593;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.085 -0400", hash_original_method = "D17BC9E58BABC2D5CE1B7492B59E2165", hash_generated_method = "7977E864D95978DB777F7AE4460DAD63")
    @Override
    public long getDisconnectTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_437487633 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_437487633;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.086 -0400", hash_original_method = "8E0034C90F1E75659D16C0CDCE6F5793", hash_generated_method = "5B8688E14A0752B07532DDA693672281")
    @Override
    public long getDurationMillis() {
        {
            long var2E584F737203A878ED4A9BB9708321A8_824057952 = (SystemClock.elapsedRealtime() - connectTimeReal);
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_480656205 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_480656205;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.086 -0400", hash_original_method = "2CFF5FB4AC83B238AC9B892D795EB1DE", hash_generated_method = "3613E1E66703174741AA5FDF554405FE")
    @Override
    public long getHoldDurationMillis() {
        {
            boolean var65303E1BDDCE597941A633CC414B8ACE_1372307130 = (getState() != Call.State.HOLDING);
            {
                long var2C126D63011C35D772AC44944CB08D74_1061866198 = (SystemClock.elapsedRealtime() - holdingStartTime);
            } 
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_102049788 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_102049788;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.087 -0400", hash_original_method = "28455B27DA94996FB17C07BF72898FB4", hash_generated_method = "3E4AAC99F1A9C11835B2FA131F93170D")
    @Override
    public DisconnectCause getDisconnectCause() {
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_806055255 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_806055255 = mCause;
        varB4EAC82CA7396A68D541C85D26508E83_806055255.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_806055255;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.088 -0400", hash_original_method = "04AFA3AB4AAFB99A0A1522AC045EFCCB", hash_generated_method = "CC2251B1F2D7B949CA5CE6AAB3C0D01C")
     void setDisconnectCause(DisconnectCause cause) {
        mCause = cause;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.089 -0400", hash_original_method = "4EE87D2E41D94C18F614BA2D1494AD36", hash_generated_method = "610C02ECE56EE4831ACCC7DA8E4CA6BD")
    @Override
    public PostDialState getPostDialState() {
        PostDialState varB4EAC82CA7396A68D541C85D26508E83_1594450517 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1594450517 = postDialState;
        varB4EAC82CA7396A68D541C85D26508E83_1594450517.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1594450517;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.091 -0400", hash_original_method = "0751315CA6FC4E16145F947C7FEC6A28", hash_generated_method = "BB3C4E9784C28AF1655F838F726D7EED")
    @Override
    public void proceedAfterWaitChar() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.092 -0400", hash_original_method = "1CC81519C3754B491F6AACE2E776B1AA", hash_generated_method = "9904AF5CB47E02718508F28B9EA971B1")
    @Override
    public void proceedAfterWildChar(String str) {
        addTaint(str.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.092 -0400", hash_original_method = "A990DB72552DFD3D94264491EEB59CEC", hash_generated_method = "34D7B16591BBD4AA8BCBE387281F2D17")
    @Override
    public void cancelPostDial() {
        
    }

    
    protected abstract Phone getPhone();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.094 -0400", hash_original_method = "0D579DEEA4ADF8476D536663A83CC650", hash_generated_method = "982F58185678C0858B5DE3B041DA43FE")
    @Override
    public String getRemainingPostDialString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1524288963 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1027748425 = null; 
        {
            boolean varCBE29C650BD63B7D36FF87F87B8A05C3_656002874 = (postDialState == PostDialState.CANCELLED
            || postDialState == PostDialState.COMPLETE
            || postDialString == null
            || postDialString.length() <= nextPostDialChar);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1524288963 = "";
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1027748425 = postDialString.substring(nextPostDialChar);
        String varA7E53CE21691AB073D9660D615818899_1179384051; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1179384051 = varB4EAC82CA7396A68D541C85D26508E83_1524288963;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1179384051 = varB4EAC82CA7396A68D541C85D26508E83_1027748425;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1179384051.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1179384051;
        
        
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.095 -0400", hash_original_method = "780D5AE6347C99C37A99BA1F1D4E1D8E", hash_generated_method = "DA7B580AD573139BAECDC3B4C2D224F0")
    private void log(String msg) {
        Log.d(LOG_TAG, "[SipConn] " + msg);
        addTaint(msg.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.095 -0400", hash_original_method = "6B6F8D6F29C0FEAF9C52CC30010D6FE2", hash_generated_method = "2FFD42549D63FE77F4830E5CEE6AB763")
    @Override
    public int getNumberPresentation() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_243345067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_243345067;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.096 -0400", hash_original_method = "8B171385F62C7AA97B0882209EC3A206", hash_generated_method = "F650C5D3FE400B286ED79ABEBFAAB2A1")
    @Override
    public UUSInfo getUUSInfo() {
        UUSInfo varB4EAC82CA7396A68D541C85D26508E83_1981284828 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1981284828 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1981284828.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1981284828;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.096 -0400", hash_original_field = "37941D035922D251546A654E3A92595A", hash_generated_field = "A3F8AA293EF1D8E9E944DD7FF4AA0255")

    private static final String LOG_TAG = "SIP_CONN";
}

