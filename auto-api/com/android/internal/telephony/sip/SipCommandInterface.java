package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.android.internal.telephony.BaseCommands;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.UUSInfo;
import com.android.internal.telephony.gsm.SmsBroadcastConfigInfo;

class SipCommandInterface extends BaseCommands implements CommandsInterface {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.113 -0400", hash_original_method = "A6511375FC27D28438216697969D84B8", hash_generated_method = "D48D501D90C73361977BFCE6D761BC5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SipCommandInterface(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.113 -0400", hash_original_method = "7892594A38871B784C768CFB911D0AFF", hash_generated_method = "EF2E04BF41FF834D0BEC7BF52157167F")
    @DSModeled(DSC.SAFE)
    @Override
    public void setOnNITZTime(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.113 -0400", hash_original_method = "4FF9B345C0ACD80EE0490BCC729EF93D", hash_generated_method = "EDBAE01833763B6BB296A8289E6213AC")
    @DSModeled(DSC.SAFE)
    public void getIccCardStatus(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.113 -0400", hash_original_method = "312175F43C21A9CB89FD25F385D47375", hash_generated_method = "C0E5CAAEA560269E7EC7AED0443A98A8")
    @DSModeled(DSC.SAFE)
    public void supplyIccPin(String pin, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(pin);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.114 -0400", hash_original_method = "8D2388C3F4BE09E9BCDF564DE7BCBB17", hash_generated_method = "1D2BD09014D5DDB83F9599F29D066086")
    @DSModeled(DSC.SAFE)
    public void supplyIccPuk(String puk, String newPin, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(puk);
        dsTaint.addTaint(newPin);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.114 -0400", hash_original_method = "498621A7956DB667721B9B2B71D65CFE", hash_generated_method = "72A32E2349D320B8960932D9F104C954")
    @DSModeled(DSC.SAFE)
    public void supplyIccPin2(String pin, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(pin);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.114 -0400", hash_original_method = "40AAC8CED8D5308D12D2E5CDAF9B6A47", hash_generated_method = "3E5E8133CCD0C983F42B43D05954ABD5")
    @DSModeled(DSC.SAFE)
    public void supplyIccPuk2(String puk, String newPin2, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(newPin2);
        dsTaint.addTaint(puk);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.114 -0400", hash_original_method = "B3FC9EBBB6773F816458111FF8F155DE", hash_generated_method = "32A94FFB1DCD465E8BC992D297A22042")
    @DSModeled(DSC.SAFE)
    public void changeIccPin(String oldPin, String newPin, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(oldPin);
        dsTaint.addTaint(newPin);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.114 -0400", hash_original_method = "8D51802625738E75E56F41DE488CEBFD", hash_generated_method = "56B1D8A2B56E49A03D5322FED6E57E27")
    @DSModeled(DSC.SAFE)
    public void changeIccPin2(String oldPin2, String newPin2, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(newPin2);
        dsTaint.addTaint(oldPin2);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.115 -0400", hash_original_method = "FE49297D5F160C632D8EB8B38400EA83", hash_generated_method = "65D2F868B677657FFACFA915B4A02E1A")
    @DSModeled(DSC.SAFE)
    public void changeBarringPassword(String facility, String oldPwd,
            String newPwd, Message result) {
        dsTaint.addTaint(newPwd);
        dsTaint.addTaint(oldPwd);
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(facility);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.115 -0400", hash_original_method = "CEDA07561D4A2E174B41C09240087336", hash_generated_method = "C640DE7F9036C75FAC2EF5FEDA4FBC26")
    @DSModeled(DSC.SAFE)
    public void supplyNetworkDepersonalization(String netpin, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(netpin);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.115 -0400", hash_original_method = "0065DCF0A6FA35BBD3B5D6CD7BC5264B", hash_generated_method = "3D5C700F6486E19E44B4B298126460EE")
    @DSModeled(DSC.SAFE)
    public void getCurrentCalls(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.125 -0400", hash_original_method = "1C2C08D3245326421BB25469D878BC40", hash_generated_method = "9DD1DF004B52A2A4E51A54D5EF189C9B")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void getPDPContextList(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.126 -0400", hash_original_method = "327D3ACFB77EFA2CD859CBEFD5183E40", hash_generated_method = "3311943FC5ACA86BB5A3386513060019")
    @DSModeled(DSC.SAFE)
    public void getDataCallList(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.128 -0400", hash_original_method = "DAA1A0C85E21F9D3405F2D9B646EE982", hash_generated_method = "D617F00556EA23157439A304865BDBE4")
    @DSModeled(DSC.SAFE)
    public void dial(String address, int clirMode, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(address);
        dsTaint.addTaint(clirMode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.128 -0400", hash_original_method = "013CAFE12783E64D183D4781FFBCA18A", hash_generated_method = "62A745A7FBA236148EB734672B8D5EB7")
    @DSModeled(DSC.SAFE)
    public void dial(String address, int clirMode, UUSInfo uusInfo,
            Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(uusInfo.dsTaint);
        dsTaint.addTaint(address);
        dsTaint.addTaint(clirMode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.128 -0400", hash_original_method = "1348EC8F8E592B792A235EF8BDA1A728", hash_generated_method = "3F7745357EC515BB809FAC5E79E6361C")
    @DSModeled(DSC.SAFE)
    public void getIMSI(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.129 -0400", hash_original_method = "9CFFA6883C5B8E59E96AC7EBA98411BF", hash_generated_method = "7AFB001369C8BA796B0F08AC4F5A9F73")
    @DSModeled(DSC.SAFE)
    public void getIMEI(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.129 -0400", hash_original_method = "16825ADE4AEE806A281B5593AC7D63E8", hash_generated_method = "340ECBFCE34D1A60CD9DA43845823F72")
    @DSModeled(DSC.SAFE)
    public void getIMEISV(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.129 -0400", hash_original_method = "367D9C3523440D236020890B46AD46EA", hash_generated_method = "086250688B5F629AB82D0C73D3D59559")
    @DSModeled(DSC.SAFE)
    public void hangupConnection(int gsmIndex, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(gsmIndex);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.130 -0400", hash_original_method = "24CF4908E9C6B567B8992DC13D635451", hash_generated_method = "8723462D5996548FDB51BC2DE9EFA782")
    @DSModeled(DSC.SAFE)
    public void hangupWaitingOrBackground(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.130 -0400", hash_original_method = "B6BFA6F3A6A105C9D4B6C1E698A66938", hash_generated_method = "4FE2E69B8091DD9F9D6362FCBC1401AD")
    @DSModeled(DSC.SAFE)
    public void hangupForegroundResumeBackground(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.131 -0400", hash_original_method = "E5CA3DEE020231D0A58CD27DCC9A3298", hash_generated_method = "4EE77D6673506D63E0FD6D61B0564B00")
    @DSModeled(DSC.SAFE)
    public void switchWaitingOrHoldingAndActive(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.131 -0400", hash_original_method = "1DEC6D6ED7076F247D9C03337753D9B5", hash_generated_method = "AD605E9D644C2A1C12C7F2D937D0589D")
    @DSModeled(DSC.SAFE)
    public void conference(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.132 -0400", hash_original_method = "F8189B7D9A2D4B100A35E308752559C1", hash_generated_method = "3EF8C8E3782C62A85F2096D773B19ED2")
    @DSModeled(DSC.SAFE)
    public void setPreferredVoicePrivacy(boolean enable, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.133 -0400", hash_original_method = "7AC939257493C8EDA50728ACBE47AB6E", hash_generated_method = "F57C91F852C227FD00F0B9EFA7A5E30D")
    @DSModeled(DSC.SAFE)
    public void getPreferredVoicePrivacy(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.134 -0400", hash_original_method = "0FFF3C40EB3863D408D749356210235C", hash_generated_method = "4247B768D2D12D2315E7D34FD0321DFC")
    @DSModeled(DSC.SAFE)
    public void separateConnection(int gsmIndex, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(gsmIndex);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.134 -0400", hash_original_method = "5D47CDCEE79D220D19ED199AB41576BB", hash_generated_method = "F7C41BE0EFECA59D0B2B224700A1B0C9")
    @DSModeled(DSC.SAFE)
    public void acceptCall(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.134 -0400", hash_original_method = "B0370CE1AC140C2D8FD8DDB138D51178", hash_generated_method = "B14E004F5B46B71E9E1A4FBD6ECACCDF")
    @DSModeled(DSC.SAFE)
    public void rejectCall(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.134 -0400", hash_original_method = "423F7E66395D67C4DDE50E0CD115AB32", hash_generated_method = "7A6ED8287D2AEAC98355CBDFFB43B78F")
    @DSModeled(DSC.SAFE)
    public void explicitCallTransfer(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.135 -0400", hash_original_method = "452E3A07FEEB48EC41C26B70B19470A7", hash_generated_method = "701916ECDF006C84E967CD1D7B62B980")
    @DSModeled(DSC.SAFE)
    public void getLastCallFailCause(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.135 -0400", hash_original_method = "866637DA865C177743D4ACCECF2320D1", hash_generated_method = "98840E78DD9FBBCBAD5C57284ABF23E2")
    @DSModeled(DSC.SAFE)
    public void getLastPdpFailCause(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.135 -0400", hash_original_method = "5E09CD605032BAD12B5071D1198B480C", hash_generated_method = "CD63F1FA47F1E0EC1519A0D4F93714AE")
    @DSModeled(DSC.SAFE)
    public void getLastDataCallFailCause(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.135 -0400", hash_original_method = "47C0EC939F57E1591B76316E27B95AC6", hash_generated_method = "1686299C367D37B75EDFBF7C09EEC192")
    @DSModeled(DSC.SAFE)
    public void setMute(boolean enableMute, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(enableMute);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.135 -0400", hash_original_method = "18914EB1B73273C70F170F17B7ABD9F7", hash_generated_method = "02C638C5968F784DB1DEC8C50672172C")
    @DSModeled(DSC.SAFE)
    public void getMute(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.136 -0400", hash_original_method = "2E5F50302D75BF22D071DDE735D84DDB", hash_generated_method = "A2F4BFF74072A73053E7E2658FCEDA3D")
    @DSModeled(DSC.SAFE)
    public void getSignalStrength(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.136 -0400", hash_original_method = "E48AE2BAAEA38C3013B3567C40E7D695", hash_generated_method = "47771CC8B945474DFC8377BE6CBECCC8")
    @DSModeled(DSC.SAFE)
    public void getVoiceRegistrationState(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.136 -0400", hash_original_method = "3D40BE498077599AA87C5D11079E9906", hash_generated_method = "67E0CEF466326D160EE0ED33DC2F4B47")
    @DSModeled(DSC.SAFE)
    public void getDataRegistrationState(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.136 -0400", hash_original_method = "0ABE511CA2DC2D12C96958F57DAAD741", hash_generated_method = "8B9E8E7D5D3E735B24E2D1CA084E30E6")
    @DSModeled(DSC.SAFE)
    public void getOperator(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.136 -0400", hash_original_method = "AD70FA03EB7E7D9139EEB149F6091A1C", hash_generated_method = "EE6F8CDDC93980FDF4001E7FCCCDECFE")
    @DSModeled(DSC.SAFE)
    public void sendDtmf(char c, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(c);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.136 -0400", hash_original_method = "EE6742CCEC46FE0C371CDA35CEE96A7C", hash_generated_method = "BBF992395121C4725FCF243ED96C78DE")
    @DSModeled(DSC.SAFE)
    public void startDtmf(char c, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(c);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.137 -0400", hash_original_method = "CE80A91715BFB5541CB44AB81DDE6D0F", hash_generated_method = "90811B24D3CAE25A1083AFB56D9B7CFE")
    @DSModeled(DSC.SAFE)
    public void stopDtmf(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.137 -0400", hash_original_method = "9D33455A19E4CDFE7486EF4C6C2B8AAA", hash_generated_method = "8EC090BED727ADEFCEADBD6F9BA0C298")
    @DSModeled(DSC.SAFE)
    public void sendBurstDtmf(String dtmfString, int on, int off,
            Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(off);
        dsTaint.addTaint(on);
        dsTaint.addTaint(dtmfString);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.137 -0400", hash_original_method = "1A6264A9FF23649BF5DB6F7920F9A21A", hash_generated_method = "A8B4BE865696FAA7B6D09307F5624101")
    @DSModeled(DSC.SAFE)
    public void sendSMS(String smscPDU, String pdu, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(pdu);
        dsTaint.addTaint(smscPDU);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.137 -0400", hash_original_method = "6EB636270661AC6BE13856E5BA601B13", hash_generated_method = "A2DD3D67E231B4DE355C1FFDF240B068")
    @DSModeled(DSC.SAFE)
    public void sendCdmaSms(byte[] pdu, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(pdu[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.137 -0400", hash_original_method = "D5DE63795C5344B7C78E8B6314329432", hash_generated_method = "E199581F303794E5BD11F5F4549AF667")
    @DSModeled(DSC.SAFE)
    public void deleteSmsOnSim(int index, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.138 -0400", hash_original_method = "03C10B95DDA41CA22B6255050F7053EA", hash_generated_method = "E61EF62BBA5FF8425961FF4012D28A0F")
    @DSModeled(DSC.SAFE)
    public void deleteSmsOnRuim(int index, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.138 -0400", hash_original_method = "E5ECA9ECE683BEAA97AF5287FA4FD73D", hash_generated_method = "5AC00EDBD09BA4F0C3C92886E03AAF3A")
    @DSModeled(DSC.SAFE)
    public void writeSmsToSim(int status, String smsc, String pdu, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(status);
        dsTaint.addTaint(pdu);
        dsTaint.addTaint(smsc);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.138 -0400", hash_original_method = "301EEEF677F35EBA7B87E2EF64620E88", hash_generated_method = "E369640D9A7E3F03200CDCFF1F607316")
    @DSModeled(DSC.SAFE)
    public void writeSmsToRuim(int status, String pdu, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(status);
        dsTaint.addTaint(pdu);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.138 -0400", hash_original_method = "5419A5B08D65477966DC4B41045B2D43", hash_generated_method = "E4EAFF63F4364B0B38DCEB00D79CF555")
    @DSModeled(DSC.SAFE)
    public void setupDataCall(String radioTechnology, String profile,
            String apn, String user, String password, String authType,
            String protocol, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(authType);
        dsTaint.addTaint(apn);
        dsTaint.addTaint(password);
        dsTaint.addTaint(user);
        dsTaint.addTaint(profile);
        dsTaint.addTaint(radioTechnology);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.138 -0400", hash_original_method = "F4E5DEF79555248AC6400DB4F70FA346", hash_generated_method = "3088BB8A853AAADA760352944E75D779")
    @DSModeled(DSC.SAFE)
    public void deactivateDataCall(int cid, int reason, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(reason);
        dsTaint.addTaint(cid);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.138 -0400", hash_original_method = "658BFFD1699DF28E1FC33C876F64D0E2", hash_generated_method = "42835222CA44D543E96F4347EEE712A8")
    @DSModeled(DSC.SAFE)
    public void setRadioPower(boolean on, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(on);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.139 -0400", hash_original_method = "34A3D962E1CAE2FDD06754C7CD1F32F3", hash_generated_method = "BB5B99E73721B3FD868815031F8E2704")
    @DSModeled(DSC.SAFE)
    public void setSuppServiceNotifications(boolean enable, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.139 -0400", hash_original_method = "04D2C2576FBA17CACB979DAC278A3D84", hash_generated_method = "6CACEC5F39B8C5EE2B1636225FDB7346")
    @DSModeled(DSC.SAFE)
    public void acknowledgeLastIncomingGsmSms(boolean success, int cause,
            Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(cause);
        dsTaint.addTaint(success);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.139 -0400", hash_original_method = "BBFEF1AC264FC2EFFBA144FBBD11A68E", hash_generated_method = "A35BC7C7A8BA9117100CC545B8131240")
    @DSModeled(DSC.SAFE)
    public void acknowledgeLastIncomingCdmaSms(boolean success, int cause,
            Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(cause);
        dsTaint.addTaint(success);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.139 -0400", hash_original_method = "281B95F00D12B8C721DC5976D4A537AE", hash_generated_method = "5D5AFE5E19DFFABABAF773E4252D7799")
    @DSModeled(DSC.SAFE)
    public void acknowledgeIncomingGsmSmsWithPdu(boolean success, String ackPdu,
            Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(success);
        dsTaint.addTaint(ackPdu);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.139 -0400", hash_original_method = "D56D36D653FFB0D666CDD952E4E3B98E", hash_generated_method = "B7049594C8DD4A9383E436143A699094")
    @DSModeled(DSC.SAFE)
    public void iccIO(int command, int fileid, String path, int p1, int p2,
            int p3, String data, String pin2, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(p3);
        dsTaint.addTaint(pin2);
        dsTaint.addTaint(p2);
        dsTaint.addTaint(p1);
        dsTaint.addTaint(data);
        dsTaint.addTaint(path);
        dsTaint.addTaint(command);
        dsTaint.addTaint(fileid);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.140 -0400", hash_original_method = "97A78B1A23DB91BDC82BEB1858BCD95E", hash_generated_method = "69527C540E4AA8934E2AF3D5906361F6")
    @DSModeled(DSC.SAFE)
    public void getCLIR(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.140 -0400", hash_original_method = "B8D63B72DC65EE3608FC65F298DE2981", hash_generated_method = "E67CD9720E54F36FD3329C7C05992896")
    @DSModeled(DSC.SAFE)
    public void setCLIR(int clirMode, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(clirMode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.140 -0400", hash_original_method = "5B2012150FA92F57F4DA5FBC8874C419", hash_generated_method = "BF18B622029B14FE02AC6383C593991C")
    @DSModeled(DSC.SAFE)
    public void queryCallWaiting(int serviceClass, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(serviceClass);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.140 -0400", hash_original_method = "5B610ADF58E8A4CB2911C741C5D1D851", hash_generated_method = "8E17C249E0BEF0F284E14570FFA275E8")
    @DSModeled(DSC.SAFE)
    public void setCallWaiting(boolean enable, int serviceClass,
            Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(serviceClass);
        dsTaint.addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.140 -0400", hash_original_method = "958A118B1D6DEAAC3F2CD7A0471E8E5A", hash_generated_method = "5E7FFA9B4297CBB83246324E90789FCA")
    @DSModeled(DSC.SAFE)
    public void setNetworkSelectionModeAutomatic(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.141 -0400", hash_original_method = "A699748593EA9CB79EF65A1D8087DE87", hash_generated_method = "31D75A2EA417FF2690AEA4E1BB4EBD78")
    @DSModeled(DSC.SAFE)
    public void setNetworkSelectionModeManual(
            String operatorNumeric, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(operatorNumeric);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.141 -0400", hash_original_method = "37E66FF0A3AEDBEF007D30C9E2FF98CD", hash_generated_method = "75FD10EF70944C7CB1EBE25C1124CFB5")
    @DSModeled(DSC.SAFE)
    public void getNetworkSelectionMode(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.141 -0400", hash_original_method = "F3D2B6350F8E1C278AFA7ECA9187C8D7", hash_generated_method = "3E3F50BB94B25E2D622FD080BCC810CF")
    @DSModeled(DSC.SAFE)
    public void getAvailableNetworks(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.141 -0400", hash_original_method = "DA232DDE50E73AC5D636EAD7EF5FC864", hash_generated_method = "AA7BBEA8E01CC7B9809F50BBC6A6384B")
    @DSModeled(DSC.SAFE)
    public void setCallForward(int action, int cfReason, int serviceClass,
                String number, int timeSeconds, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(serviceClass);
        dsTaint.addTaint(timeSeconds);
        dsTaint.addTaint(cfReason);
        dsTaint.addTaint(action);
        dsTaint.addTaint(number);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.141 -0400", hash_original_method = "455A9434E862CC2E0C873DE31EB09A28", hash_generated_method = "CC831A3BDC06734A570FBEA3B85B75B5")
    @DSModeled(DSC.SAFE)
    public void queryCallForwardStatus(int cfReason, int serviceClass,
            String number, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(serviceClass);
        dsTaint.addTaint(cfReason);
        dsTaint.addTaint(number);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.141 -0400", hash_original_method = "1E5E60364AF2DDDA55FE9584B8EF0B2C", hash_generated_method = "7271FA1621EF1F1EFD8EB50A584F5056")
    @DSModeled(DSC.SAFE)
    public void queryCLIP(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.141 -0400", hash_original_method = "EE7857BCB5A1D2385833186B6353BDF6", hash_generated_method = "79F796AA90CB8FDEB67E4ED187E11639")
    @DSModeled(DSC.SAFE)
    public void getBasebandVersion(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.141 -0400", hash_original_method = "A56D965167C62C2F95036EFE39C4CA71", hash_generated_method = "41F97E9B1F8AAF921FAC5D519635056F")
    @DSModeled(DSC.SAFE)
    @Override
    public void queryFacilityLock(String facility, String password,
            int serviceClass, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(serviceClass);
        dsTaint.addTaint(facility);
        dsTaint.addTaint(password);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.142 -0400", hash_original_method = "230F3C7CDCF2BDF61799EBE662AE054E", hash_generated_method = "310954F742103ABE0B7CD38FB18FA314")
    @DSModeled(DSC.SAFE)
    @Override
    public void queryFacilityLockForApp(String facility, String password,
            int serviceClass, String appId, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(serviceClass);
        dsTaint.addTaint(appId);
        dsTaint.addTaint(facility);
        dsTaint.addTaint(password);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.142 -0400", hash_original_method = "AD3FF097428D5AB19C8EE6C9813E3899", hash_generated_method = "2FFBCEE0FA180304311250A66E53220D")
    @DSModeled(DSC.SAFE)
    @Override
    public void setFacilityLock(String facility, boolean lockState,
            String password, int serviceClass, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(serviceClass);
        dsTaint.addTaint(facility);
        dsTaint.addTaint(password);
        dsTaint.addTaint(lockState);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.142 -0400", hash_original_method = "933F2123A615A9A39A40CBF915D35DBF", hash_generated_method = "889E39169A693B7AF4A8EB76D94942DA")
    @DSModeled(DSC.SAFE)
    @Override
    public void setFacilityLockForApp(String facility, boolean lockState,
            String password, int serviceClass, String appId, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(serviceClass);
        dsTaint.addTaint(appId);
        dsTaint.addTaint(facility);
        dsTaint.addTaint(password);
        dsTaint.addTaint(lockState);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.142 -0400", hash_original_method = "F9FFB06D76A77B7B92045DB70103041E", hash_generated_method = "B313F8C131A235E41D2E3E86C122EB72")
    @DSModeled(DSC.SAFE)
    public void sendUSSD(String ussdString, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(ussdString);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.142 -0400", hash_original_method = "087B5572C84FB61528C8D96F1C079352", hash_generated_method = "C85FA68A1471C64A63C66E2252F689A0")
    @DSModeled(DSC.SAFE)
    public void cancelPendingUssd(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.142 -0400", hash_original_method = "B603C96410E7BFF356539653D85D8A4B", hash_generated_method = "E40AF0DD03A28CAB914A5D5161959E8A")
    @DSModeled(DSC.SAFE)
    public void resetRadio(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.142 -0400", hash_original_method = "304D94F0A203021B29E8BE917AB2A88E", hash_generated_method = "B4EF58F5A0AD8EADDCEFB30FE09FCE06")
    @DSModeled(DSC.SAFE)
    public void invokeOemRilRequestRaw(byte[] data, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.143 -0400", hash_original_method = "5FCB7D9B46CBA85CB2A2479605C5EBE0", hash_generated_method = "9CE0092B2265294AE7A471636A465ED7")
    @DSModeled(DSC.SAFE)
    public void invokeOemRilRequestStrings(String[] strings, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(strings[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.143 -0400", hash_original_method = "B390B8B053975D6E247D6ADF9DE7B6FC", hash_generated_method = "01E7AFC404FCAEDAD7E061999CAED776")
    @DSModeled(DSC.SAFE)
    public void setBandMode(int bandMode, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(bandMode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.143 -0400", hash_original_method = "CDBADCA8574456832760B996C8943606", hash_generated_method = "20B601458210E950572C2B467D6AE02C")
    @DSModeled(DSC.SAFE)
    public void queryAvailableBandMode(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.143 -0400", hash_original_method = "1B08354C58BC7E4FA9F6A992437EB8EB", hash_generated_method = "78B0DB8D0D3F0E0A476824486B39EF35")
    @DSModeled(DSC.SAFE)
    public void sendTerminalResponse(String contents, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(contents);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.143 -0400", hash_original_method = "8510CB1FCB2D71445BC7D7948652F9FF", hash_generated_method = "6085DCC25FCB5DA148DCE431F4C8FE83")
    @DSModeled(DSC.SAFE)
    public void sendEnvelope(String contents, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(contents);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.143 -0400", hash_original_method = "A584A8270CEEFF3893478A017045D938", hash_generated_method = "65156F7982D6DF61659CAD7F89F6B493")
    @DSModeled(DSC.SAFE)
    public void sendEnvelopeWithStatus(String contents, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(contents);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.143 -0400", hash_original_method = "7D7F347B6C7F161149D5C29633177CD2", hash_generated_method = "092F7BE73F401BE342FCF066C9652FD3")
    @DSModeled(DSC.SAFE)
    public void handleCallSetupRequestFromSim(
            boolean accept, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(accept);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.144 -0400", hash_original_method = "27AB8573439D5EB2F33C81C73E25E8F8", hash_generated_method = "00CA66EE0708F05B9A19C90B7CDFFBCC")
    @DSModeled(DSC.SAFE)
    public void setPreferredNetworkType(int networkType , Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(networkType);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.144 -0400", hash_original_method = "C86073EB20CA48BDFFC81AAA868A3BB1", hash_generated_method = "5502F78C76F1CB831209DF8C5336FB0B")
    @DSModeled(DSC.SAFE)
    public void getPreferredNetworkType(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.144 -0400", hash_original_method = "1E1F359D4473F2441E02E8FE890DEF1C", hash_generated_method = "A4B0BE56110081A9C5ECBF549C763C49")
    @DSModeled(DSC.SAFE)
    public void getNeighboringCids(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.144 -0400", hash_original_method = "8F4AD1B328B83D997278B06A4EE5820C", hash_generated_method = "3979E30FC09B5352B9C09F6BE58C61BF")
    @DSModeled(DSC.SAFE)
    public void setLocationUpdates(boolean enable, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.144 -0400", hash_original_method = "341ECD479C88F08657B8FDC222C9F79A", hash_generated_method = "D157A7962E1912ECF37E1E99330B907D")
    @DSModeled(DSC.SAFE)
    public void getSmscAddress(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.144 -0400", hash_original_method = "7097F8C49B12B71CDD20291B3AB7964A", hash_generated_method = "6EAC8A280B6F5712D3C60BCB83C8B6D6")
    @DSModeled(DSC.SAFE)
    public void setSmscAddress(String address, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(address);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.144 -0400", hash_original_method = "BC0B755F5F01D800040615DED3BCDBA0", hash_generated_method = "EF93D57CCA5CA13AFCA97B69388EC131")
    @DSModeled(DSC.SAFE)
    public void reportSmsMemoryStatus(boolean available, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(available);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.145 -0400", hash_original_method = "F7AB9C173D1A57BFEBFB44A47237DF7D", hash_generated_method = "9DD0F9CE8496E8BAEC17383EC203FD0D")
    @DSModeled(DSC.SAFE)
    public void reportStkServiceIsRunning(Message result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.145 -0400", hash_original_method = "9CF99F7F300A93DDBFE74502145A8475", hash_generated_method = "D949B559DC9E8BBF8AFF7C973734360E")
    @DSModeled(DSC.SAFE)
    @Override
    public void getCdmaSubscriptionSource(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.145 -0400", hash_original_method = "4329D3CD35E915BD99C5B818B449ACA1", hash_generated_method = "EAEB2AD006D947EF7A2DC6427862ED9D")
    @DSModeled(DSC.SAFE)
    public void getGsmBroadcastConfig(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.145 -0400", hash_original_method = "BEC32E28BD6A6EC85956F36B9D44924D", hash_generated_method = "4731C708190D6FCF56EF1FC411E6C04B")
    @DSModeled(DSC.SAFE)
    public void setGsmBroadcastConfig(SmsBroadcastConfigInfo[] config, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(config[0].dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.146 -0400", hash_original_method = "2F3C945F2B405B443912668B2367D904", hash_generated_method = "4A257AF2883B97D33DF341E1DDE8C0E1")
    @DSModeled(DSC.SAFE)
    public void setGsmBroadcastActivation(boolean activate, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(activate);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.146 -0400", hash_original_method = "BB255671D9D9AE82C00FD12FF12E7590", hash_generated_method = "510420EE44D861F894007B6567A381C9")
    @DSModeled(DSC.SAFE)
    public void getDeviceIdentity(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.158 -0400", hash_original_method = "A28D6B43032903DAFA850C3B9E02D39E", hash_generated_method = "D67917EEBBD77EF2F622B8CAFB3AC995")
    @DSModeled(DSC.SAFE)
    public void getCDMASubscription(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.158 -0400", hash_original_method = "6A64EDF04D6CCF6DA11C17A9004CF963", hash_generated_method = "D97E78A4885406EB85367234971343F2")
    @DSModeled(DSC.SAFE)
    public void setPhoneType(int phoneType) {
        dsTaint.addTaint(phoneType);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.158 -0400", hash_original_method = "A9CEBF170D0F656D33BCE6259BBB358F", hash_generated_method = "FEF667BBA85A1E346281BB4361A36164")
    @DSModeled(DSC.SAFE)
    public void queryCdmaRoamingPreference(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.158 -0400", hash_original_method = "A524FD7F96F7FB62BB4ABD4057A9354C", hash_generated_method = "890AFA983AEF2D2B8FC60D82FDBCB796")
    @DSModeled(DSC.SAFE)
    public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(cdmaRoamingType);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.160 -0400", hash_original_method = "87C7978CD92754BB7623428AEFA60479", hash_generated_method = "8D26DA116D46BA8F59E3768D0A42CD1D")
    @DSModeled(DSC.SAFE)
    public void setCdmaSubscriptionSource(int cdmaSubscription , Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(cdmaSubscription);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.161 -0400", hash_original_method = "DC6F83E2EE7B0408161F523478208FCE", hash_generated_method = "E0DE0BE11C538CFA1435E49A08907C2A")
    @DSModeled(DSC.SAFE)
    public void queryTTYMode(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.161 -0400", hash_original_method = "44348CEECDEE74EEC687675A834A99DA", hash_generated_method = "CEC8F1B5EC63EDF8301D37E20175068F")
    @DSModeled(DSC.SAFE)
    public void setTTYMode(int ttyMode, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(ttyMode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.162 -0400", hash_original_method = "D826071ECAAC08358EF9CEAACAFF0A2A", hash_generated_method = "336A9601A3D1DAD8AF907AA5D3200537")
    @DSModeled(DSC.SAFE)
    public void sendCDMAFeatureCode(String FeatureCode, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(FeatureCode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.162 -0400", hash_original_method = "DCBE6B932ED9844344E5753E79DB999C", hash_generated_method = "DF9FA3EB06C101361B82FCE65DE5B3E2")
    @DSModeled(DSC.SAFE)
    public void getCdmaBroadcastConfig(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.162 -0400", hash_original_method = "86E74F47BAC216027EBD89BDEFC4A2E0", hash_generated_method = "2B16DF190FF813CB163BF3122B037E21")
    @DSModeled(DSC.SAFE)
    public void setCdmaBroadcastConfig(int[] configValuesArray, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(configValuesArray[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.163 -0400", hash_original_method = "02EE3B357DCB6CF5847DAE1F69A62BD8", hash_generated_method = "0E8906E77EBE9F966FB3AC0C2FF9A058")
    @DSModeled(DSC.SAFE)
    public void setCdmaBroadcastActivation(boolean activate, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(activate);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.163 -0400", hash_original_method = "B73B7043BB86BD20367E2BA4C1F7579D", hash_generated_method = "401CB23BBC57856A199CBDED4B762121")
    @DSModeled(DSC.SAFE)
    public void exitEmergencyCallbackMode(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.163 -0400", hash_original_method = "A7B720D7AAE639C9AA81ACDD2FD07958", hash_generated_method = "1D0082D1802A27CB41E4B6C9727A5516")
    @DSModeled(DSC.SAFE)
    @Override
    public void supplyIccPinForApp(String pin, String aid, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(pin);
        dsTaint.addTaint(aid);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.164 -0400", hash_original_method = "85052B085E211221DC52D076F63CDE51", hash_generated_method = "E752A39E3D7D70F72D80B175B9E95D68")
    @DSModeled(DSC.SAFE)
    @Override
    public void supplyIccPukForApp(String puk, String newPin, String aid, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(puk);
        dsTaint.addTaint(aid);
        dsTaint.addTaint(newPin);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.165 -0400", hash_original_method = "4EA9B69CB4BB92F6CBD1A973DB39784D", hash_generated_method = "B076D6734F20554422B04E9100B2EFC6")
    @DSModeled(DSC.SAFE)
    @Override
    public void supplyIccPin2ForApp(String pin2, String aid, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(pin2);
        dsTaint.addTaint(aid);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.166 -0400", hash_original_method = "FF125CC3CEA22589265ADC8CAED2B3CC", hash_generated_method = "850C30B414D230383AAF9339BE70C748")
    @DSModeled(DSC.SAFE)
    @Override
    public void supplyIccPuk2ForApp(String puk2, String newPin2, String aid, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(puk2);
        dsTaint.addTaint(newPin2);
        dsTaint.addTaint(aid);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.166 -0400", hash_original_method = "A51A50ABC77958852F41695682CE2620", hash_generated_method = "DEE39E2065E25B8CC02155532D528591")
    @DSModeled(DSC.SAFE)
    @Override
    public void changeIccPinForApp(String oldPin, String newPin, String aidPtr, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(oldPin);
        dsTaint.addTaint(aidPtr);
        dsTaint.addTaint(newPin);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.166 -0400", hash_original_method = "39AB2DAFFDF72A29B22CB665239943F5", hash_generated_method = "FB3AF56891080469B57E839695557E76")
    @DSModeled(DSC.SAFE)
    @Override
    public void changeIccPin2ForApp(String oldPin2, String newPin2, String aidPtr,
            Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(newPin2);
        dsTaint.addTaint(oldPin2);
        dsTaint.addTaint(aidPtr);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.166 -0400", hash_original_method = "417EB29332801A205E6BDDA18E3F8488", hash_generated_method = "EC26D72AC46AD989B4B11EE0A914B936")
    @DSModeled(DSC.SAFE)
    public void requestIsimAuthentication(String nonce, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(nonce);
        // ---------- Original Method ----------
    }

    
}

