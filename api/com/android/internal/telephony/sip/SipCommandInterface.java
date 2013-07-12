package com.android.internal.telephony.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.android.internal.telephony.BaseCommands;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.UUSInfo;
import com.android.internal.telephony.gsm.SmsBroadcastConfigInfo;

class SipCommandInterface extends BaseCommands implements CommandsInterface {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.099 -0400", hash_original_method = "A6511375FC27D28438216697969D84B8", hash_generated_method = "A859198BE8A3007C12546D581D9014DC")
      SipCommandInterface(Context context) {
        super(context);
        addTaint(context.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.100 -0400", hash_original_method = "7892594A38871B784C768CFB911D0AFF", hash_generated_method = "50D976BC8A2D1F224A5F3DEE5A5257DE")
    @Override
    public void setOnNITZTime(Handler h, int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.101 -0400", hash_original_method = "4FF9B345C0ACD80EE0490BCC729EF93D", hash_generated_method = "F24701863F5458CA56139F025132F419")
    public void getIccCardStatus(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.101 -0400", hash_original_method = "312175F43C21A9CB89FD25F385D47375", hash_generated_method = "01D9D18D1295F3C5798E543A4FF8844D")
    public void supplyIccPin(String pin, Message result) {
        addTaint(result.getTaint());
        addTaint(pin.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.101 -0400", hash_original_method = "8D2388C3F4BE09E9BCDF564DE7BCBB17", hash_generated_method = "70A5A8DC7DB9D67461D4DD4594305B57")
    public void supplyIccPuk(String puk, String newPin, Message result) {
        addTaint(result.getTaint());
        addTaint(newPin.getTaint());
        addTaint(puk.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.102 -0400", hash_original_method = "498621A7956DB667721B9B2B71D65CFE", hash_generated_method = "A086A3A56A58BDE1C3CB9EF902809F17")
    public void supplyIccPin2(String pin, Message result) {
        addTaint(result.getTaint());
        addTaint(pin.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.102 -0400", hash_original_method = "40AAC8CED8D5308D12D2E5CDAF9B6A47", hash_generated_method = "F3A3C410784B251C34F3742B15CB978C")
    public void supplyIccPuk2(String puk, String newPin2, Message result) {
        addTaint(result.getTaint());
        addTaint(newPin2.getTaint());
        addTaint(puk.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.102 -0400", hash_original_method = "B3FC9EBBB6773F816458111FF8F155DE", hash_generated_method = "0A941721CAA8FCE2FE510F613A108A9B")
    public void changeIccPin(String oldPin, String newPin, Message result) {
        addTaint(result.getTaint());
        addTaint(newPin.getTaint());
        addTaint(oldPin.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.113 -0400", hash_original_method = "8D51802625738E75E56F41DE488CEBFD", hash_generated_method = "44AAAF70398611193B9425B01C7520C5")
    public void changeIccPin2(String oldPin2, String newPin2, Message result) {
        addTaint(result.getTaint());
        addTaint(newPin2.getTaint());
        addTaint(oldPin2.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.113 -0400", hash_original_method = "FE49297D5F160C632D8EB8B38400EA83", hash_generated_method = "51DC9B9F8C93C052B2C46E4D56152218")
    public void changeBarringPassword(String facility, String oldPwd,
            String newPwd, Message result) {
        addTaint(result.getTaint());
        addTaint(newPwd.getTaint());
        addTaint(oldPwd.getTaint());
        addTaint(facility.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.113 -0400", hash_original_method = "CEDA07561D4A2E174B41C09240087336", hash_generated_method = "675973EFD77A5C2A524AFC8E5C2EA6AA")
    public void supplyNetworkDepersonalization(String netpin, Message result) {
        addTaint(result.getTaint());
        addTaint(netpin.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.113 -0400", hash_original_method = "0065DCF0A6FA35BBD3B5D6CD7BC5264B", hash_generated_method = "A9FD7129926168194F8C81738F73B523")
    public void getCurrentCalls(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.113 -0400", hash_original_method = "1C2C08D3245326421BB25469D878BC40", hash_generated_method = "65E61C9D84233D07628E18B039C789FC")
    @Deprecated
    public void getPDPContextList(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.113 -0400", hash_original_method = "327D3ACFB77EFA2CD859CBEFD5183E40", hash_generated_method = "6B4B0DFBD4A658CE1D78BA583D8B89B4")
    public void getDataCallList(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.113 -0400", hash_original_method = "DAA1A0C85E21F9D3405F2D9B646EE982", hash_generated_method = "0252DD0B7BDA1F311AD10DEA4FA153BF")
    public void dial(String address, int clirMode, Message result) {
        addTaint(result.getTaint());
        addTaint(clirMode);
        addTaint(address.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.113 -0400", hash_original_method = "013CAFE12783E64D183D4781FFBCA18A", hash_generated_method = "602BC4678809614BCBF2C725DD34443A")
    public void dial(String address, int clirMode, UUSInfo uusInfo,
            Message result) {
        addTaint(result.getTaint());
        addTaint(uusInfo.getTaint());
        addTaint(clirMode);
        addTaint(address.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.113 -0400", hash_original_method = "1348EC8F8E592B792A235EF8BDA1A728", hash_generated_method = "1BC3CF6348D02C0F570A871C8BBFFA45")
    public void getIMSI(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.113 -0400", hash_original_method = "9CFFA6883C5B8E59E96AC7EBA98411BF", hash_generated_method = "4A2BAF0F00DC24A2AA69BBF374CCA3DD")
    public void getIMEI(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.113 -0400", hash_original_method = "16825ADE4AEE806A281B5593AC7D63E8", hash_generated_method = "3BB7929D47817BC305092EC99E5B8635")
    public void getIMEISV(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.114 -0400", hash_original_method = "367D9C3523440D236020890B46AD46EA", hash_generated_method = "B0B238908FC7D1E1AF10F4E39C172B84")
    public void hangupConnection(int gsmIndex, Message result) {
        addTaint(result.getTaint());
        addTaint(gsmIndex);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.114 -0400", hash_original_method = "24CF4908E9C6B567B8992DC13D635451", hash_generated_method = "9CF931A7984CF9D3DFD49C044AD9E861")
    public void hangupWaitingOrBackground(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.114 -0400", hash_original_method = "B6BFA6F3A6A105C9D4B6C1E698A66938", hash_generated_method = "EB5FF15763B981051CDE84C45FC37FDD")
    public void hangupForegroundResumeBackground(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.114 -0400", hash_original_method = "E5CA3DEE020231D0A58CD27DCC9A3298", hash_generated_method = "2EB6B5FB9DD529E12232CA700C580183")
    public void switchWaitingOrHoldingAndActive(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.114 -0400", hash_original_method = "1DEC6D6ED7076F247D9C03337753D9B5", hash_generated_method = "00621E9ACCB42DF5B85E6254C9122846")
    public void conference(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.114 -0400", hash_original_method = "F8189B7D9A2D4B100A35E308752559C1", hash_generated_method = "3000F0DA05D969EF140E6A6F0FE5B702")
    public void setPreferredVoicePrivacy(boolean enable, Message result) {
        addTaint(result.getTaint());
        addTaint(enable);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.114 -0400", hash_original_method = "7AC939257493C8EDA50728ACBE47AB6E", hash_generated_method = "044CDAD52FE5D5F0B5C779E0CE297612")
    public void getPreferredVoicePrivacy(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.114 -0400", hash_original_method = "0FFF3C40EB3863D408D749356210235C", hash_generated_method = "3B52B3A30AF73BD39C99DBC8313E3D3D")
    public void separateConnection(int gsmIndex, Message result) {
        addTaint(result.getTaint());
        addTaint(gsmIndex);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.114 -0400", hash_original_method = "5D47CDCEE79D220D19ED199AB41576BB", hash_generated_method = "DFE95CFD54ECEF124528CED319D5697E")
    public void acceptCall(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.114 -0400", hash_original_method = "B0370CE1AC140C2D8FD8DDB138D51178", hash_generated_method = "0FE53FDD0041F1BCA7DF741C14DBE141")
    public void rejectCall(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.114 -0400", hash_original_method = "423F7E66395D67C4DDE50E0CD115AB32", hash_generated_method = "FD83E185257D53510C5E0E9D216695F3")
    public void explicitCallTransfer(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.114 -0400", hash_original_method = "452E3A07FEEB48EC41C26B70B19470A7", hash_generated_method = "682C0B022992F413C4D7A22CF5F801C5")
    public void getLastCallFailCause(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.114 -0400", hash_original_method = "866637DA865C177743D4ACCECF2320D1", hash_generated_method = "335BC2681608A5C56412A2FD0E8D2C2F")
    public void getLastPdpFailCause(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.114 -0400", hash_original_method = "5E09CD605032BAD12B5071D1198B480C", hash_generated_method = "5010C1BF40DDE1230AD9415958DAD666")
    public void getLastDataCallFailCause(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.114 -0400", hash_original_method = "47C0EC939F57E1591B76316E27B95AC6", hash_generated_method = "866BB7FD1B89A05D76C6615D3E56A542")
    public void setMute(boolean enableMute, Message response) {
        addTaint(response.getTaint());
        addTaint(enableMute);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.115 -0400", hash_original_method = "18914EB1B73273C70F170F17B7ABD9F7", hash_generated_method = "61548E4FA53247DA0988874CDE5990B2")
    public void getMute(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.115 -0400", hash_original_method = "2E5F50302D75BF22D071DDE735D84DDB", hash_generated_method = "5BCBB88C39ABDACE5025F557438913AA")
    public void getSignalStrength(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.115 -0400", hash_original_method = "E48AE2BAAEA38C3013B3567C40E7D695", hash_generated_method = "1DD98F561D2F66B1206EACD26CAB0AA4")
    public void getVoiceRegistrationState(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.115 -0400", hash_original_method = "3D40BE498077599AA87C5D11079E9906", hash_generated_method = "53BCA2DDD180EE45B506353788C026C0")
    public void getDataRegistrationState(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.115 -0400", hash_original_method = "0ABE511CA2DC2D12C96958F57DAAD741", hash_generated_method = "27B44CA05C8A23318034154BD171C433")
    public void getOperator(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.115 -0400", hash_original_method = "AD70FA03EB7E7D9139EEB149F6091A1C", hash_generated_method = "0A9511FDA8B56853B3A210BB43B3360B")
    public void sendDtmf(char c, Message result) {
        addTaint(result.getTaint());
        addTaint(c);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.115 -0400", hash_original_method = "EE6742CCEC46FE0C371CDA35CEE96A7C", hash_generated_method = "422E1DFDF62C8082D65B32A7ABBEE2ED")
    public void startDtmf(char c, Message result) {
        addTaint(result.getTaint());
        addTaint(c);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.115 -0400", hash_original_method = "CE80A91715BFB5541CB44AB81DDE6D0F", hash_generated_method = "C6E4F2B30088D852AF2F167D7624A826")
    public void stopDtmf(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.115 -0400", hash_original_method = "9D33455A19E4CDFE7486EF4C6C2B8AAA", hash_generated_method = "2DF360359D8702829CF749F4CBE38492")
    public void sendBurstDtmf(String dtmfString, int on, int off,
            Message result) {
        addTaint(result.getTaint());
        addTaint(off);
        addTaint(on);
        addTaint(dtmfString.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.115 -0400", hash_original_method = "1A6264A9FF23649BF5DB6F7920F9A21A", hash_generated_method = "DDA83F7A3DA6C2DFCB2DF67C58157714")
    public void sendSMS(String smscPDU, String pdu, Message result) {
        addTaint(result.getTaint());
        addTaint(pdu.getTaint());
        addTaint(smscPDU.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.115 -0400", hash_original_method = "6EB636270661AC6BE13856E5BA601B13", hash_generated_method = "EEF86FDAE53AA98584D39C2171FD6F56")
    public void sendCdmaSms(byte[] pdu, Message result) {
        addTaint(result.getTaint());
        addTaint(pdu[0]);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.115 -0400", hash_original_method = "D5DE63795C5344B7C78E8B6314329432", hash_generated_method = "FCEB766F384ED582777585496CD2997C")
    public void deleteSmsOnSim(int index, Message response) {
        addTaint(response.getTaint());
        addTaint(index);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.116 -0400", hash_original_method = "03C10B95DDA41CA22B6255050F7053EA", hash_generated_method = "FF594D26DB87C4F0303CD47ED870F4D8")
    public void deleteSmsOnRuim(int index, Message response) {
        addTaint(response.getTaint());
        addTaint(index);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.116 -0400", hash_original_method = "E5ECA9ECE683BEAA97AF5287FA4FD73D", hash_generated_method = "E1C21DC5C086AC451EA77EB72E4F711A")
    public void writeSmsToSim(int status, String smsc, String pdu, Message response) {
        addTaint(response.getTaint());
        addTaint(pdu.getTaint());
        addTaint(smsc.getTaint());
        addTaint(status);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.116 -0400", hash_original_method = "301EEEF677F35EBA7B87E2EF64620E88", hash_generated_method = "C5723D6D6AB359F70EC3408DF6AA24DF")
    public void writeSmsToRuim(int status, String pdu, Message response) {
        addTaint(response.getTaint());
        addTaint(pdu.getTaint());
        addTaint(status);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.116 -0400", hash_original_method = "5419A5B08D65477966DC4B41045B2D43", hash_generated_method = "AAB046DE4217644CCF0867EDD4206E0C")
    public void setupDataCall(String radioTechnology, String profile,
            String apn, String user, String password, String authType,
            String protocol, Message result) {
        addTaint(result.getTaint());
        addTaint(protocol.getTaint());
        addTaint(authType.getTaint());
        addTaint(password.getTaint());
        addTaint(user.getTaint());
        addTaint(apn.getTaint());
        addTaint(profile.getTaint());
        addTaint(radioTechnology.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.116 -0400", hash_original_method = "F4E5DEF79555248AC6400DB4F70FA346", hash_generated_method = "C4601460B30AFC6461B34623DD83F881")
    public void deactivateDataCall(int cid, int reason, Message result) {
        addTaint(result.getTaint());
        addTaint(reason);
        addTaint(cid);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.116 -0400", hash_original_method = "658BFFD1699DF28E1FC33C876F64D0E2", hash_generated_method = "4FD426D81286409565D47503F148234C")
    public void setRadioPower(boolean on, Message result) {
        addTaint(result.getTaint());
        addTaint(on);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.116 -0400", hash_original_method = "34A3D962E1CAE2FDD06754C7CD1F32F3", hash_generated_method = "F727A2439B4BD3D04A19A43C456921C8")
    public void setSuppServiceNotifications(boolean enable, Message result) {
        addTaint(result.getTaint());
        addTaint(enable);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.116 -0400", hash_original_method = "04D2C2576FBA17CACB979DAC278A3D84", hash_generated_method = "76212FD231600376799B12D1227CD1E2")
    public void acknowledgeLastIncomingGsmSms(boolean success, int cause,
            Message result) {
        addTaint(result.getTaint());
        addTaint(cause);
        addTaint(success);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.116 -0400", hash_original_method = "BBFEF1AC264FC2EFFBA144FBBD11A68E", hash_generated_method = "F3C1345F508363A561A4FAC7116047E1")
    public void acknowledgeLastIncomingCdmaSms(boolean success, int cause,
            Message result) {
        addTaint(result.getTaint());
        addTaint(cause);
        addTaint(success);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.116 -0400", hash_original_method = "281B95F00D12B8C721DC5976D4A537AE", hash_generated_method = "152466A5B5A8E4F21B741F0BB637443D")
    public void acknowledgeIncomingGsmSmsWithPdu(boolean success, String ackPdu,
            Message result) {
        addTaint(result.getTaint());
        addTaint(ackPdu.getTaint());
        addTaint(success);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.117 -0400", hash_original_method = "D56D36D653FFB0D666CDD952E4E3B98E", hash_generated_method = "8869FC9C480118ECD3E3AE6B37D1E448")
    public void iccIO(int command, int fileid, String path, int p1, int p2,
            int p3, String data, String pin2, Message result) {
        addTaint(result.getTaint());
        addTaint(pin2.getTaint());
        addTaint(data.getTaint());
        addTaint(p3);
        addTaint(p2);
        addTaint(p1);
        addTaint(path.getTaint());
        addTaint(fileid);
        addTaint(command);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.117 -0400", hash_original_method = "97A78B1A23DB91BDC82BEB1858BCD95E", hash_generated_method = "DEFE694FDA9832A3244B7548A67F8BEA")
    public void getCLIR(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.117 -0400", hash_original_method = "B8D63B72DC65EE3608FC65F298DE2981", hash_generated_method = "D0CB34E26D72909033E85718CE2B8AE5")
    public void setCLIR(int clirMode, Message result) {
        addTaint(result.getTaint());
        addTaint(clirMode);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.117 -0400", hash_original_method = "5B2012150FA92F57F4DA5FBC8874C419", hash_generated_method = "B7551992587AE4A15B29BC8BD685B8E5")
    public void queryCallWaiting(int serviceClass, Message response) {
        addTaint(response.getTaint());
        addTaint(serviceClass);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.117 -0400", hash_original_method = "5B610ADF58E8A4CB2911C741C5D1D851", hash_generated_method = "BFBEE9A6BAEB7351333169B8C059E7C3")
    public void setCallWaiting(boolean enable, int serviceClass,
            Message response) {
        addTaint(response.getTaint());
        addTaint(serviceClass);
        addTaint(enable);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.117 -0400", hash_original_method = "958A118B1D6DEAAC3F2CD7A0471E8E5A", hash_generated_method = "7A56B99868460FC0089A1CFE78EAEABC")
    public void setNetworkSelectionModeAutomatic(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.117 -0400", hash_original_method = "A699748593EA9CB79EF65A1D8087DE87", hash_generated_method = "162B52E0B872C80B84D84C256DDD84EB")
    public void setNetworkSelectionModeManual(
            String operatorNumeric, Message response) {
        addTaint(response.getTaint());
        addTaint(operatorNumeric.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.117 -0400", hash_original_method = "37E66FF0A3AEDBEF007D30C9E2FF98CD", hash_generated_method = "CE677D930885CD53D9A4B104247DF930")
    public void getNetworkSelectionMode(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.117 -0400", hash_original_method = "F3D2B6350F8E1C278AFA7ECA9187C8D7", hash_generated_method = "8DE8805B27756ABC38F4FA4C3F7580C2")
    public void getAvailableNetworks(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.117 -0400", hash_original_method = "DA232DDE50E73AC5D636EAD7EF5FC864", hash_generated_method = "96D0F85BE8D73CF6889F728EB026E6E7")
    public void setCallForward(int action, int cfReason, int serviceClass,
                String number, int timeSeconds, Message response) {
        addTaint(response.getTaint());
        addTaint(timeSeconds);
        addTaint(number.getTaint());
        addTaint(serviceClass);
        addTaint(cfReason);
        addTaint(action);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.118 -0400", hash_original_method = "455A9434E862CC2E0C873DE31EB09A28", hash_generated_method = "5406B527F2092EFCD0C04D595F5968C8")
    public void queryCallForwardStatus(int cfReason, int serviceClass,
            String number, Message response) {
        addTaint(response.getTaint());
        addTaint(number.getTaint());
        addTaint(serviceClass);
        addTaint(cfReason);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.118 -0400", hash_original_method = "1E5E60364AF2DDDA55FE9584B8EF0B2C", hash_generated_method = "9147641EFFDAF93914A6EABC0CFE6AB9")
    public void queryCLIP(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.118 -0400", hash_original_method = "EE7857BCB5A1D2385833186B6353BDF6", hash_generated_method = "8EF8B502E5543E4FA6B8D0E9B9B758FD")
    public void getBasebandVersion(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.118 -0400", hash_original_method = "A56D965167C62C2F95036EFE39C4CA71", hash_generated_method = "B54224A9A59DE514DCF1E8421DBC3F3B")
    @Override
    public void queryFacilityLock(String facility, String password,
            int serviceClass, Message response) {
        addTaint(response.getTaint());
        addTaint(serviceClass);
        addTaint(password.getTaint());
        addTaint(facility.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.119 -0400", hash_original_method = "230F3C7CDCF2BDF61799EBE662AE054E", hash_generated_method = "155F0815FB3127D858CA2B683C063583")
    @Override
    public void queryFacilityLockForApp(String facility, String password,
            int serviceClass, String appId, Message response) {
        addTaint(response.getTaint());
        addTaint(appId.getTaint());
        addTaint(serviceClass);
        addTaint(password.getTaint());
        addTaint(facility.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.119 -0400", hash_original_method = "AD3FF097428D5AB19C8EE6C9813E3899", hash_generated_method = "1B5BCAEFE15DF77124D79F989BA341BE")
    @Override
    public void setFacilityLock(String facility, boolean lockState,
            String password, int serviceClass, Message response) {
        addTaint(response.getTaint());
        addTaint(serviceClass);
        addTaint(password.getTaint());
        addTaint(lockState);
        addTaint(facility.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.119 -0400", hash_original_method = "933F2123A615A9A39A40CBF915D35DBF", hash_generated_method = "8044789C9B0A8CBE67D0CB07D54088EF")
    @Override
    public void setFacilityLockForApp(String facility, boolean lockState,
            String password, int serviceClass, String appId, Message response) {
        addTaint(response.getTaint());
        addTaint(appId.getTaint());
        addTaint(serviceClass);
        addTaint(password.getTaint());
        addTaint(lockState);
        addTaint(facility.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.119 -0400", hash_original_method = "F9FFB06D76A77B7B92045DB70103041E", hash_generated_method = "A502491F26D17F9676F63FA4314E9FB8")
    public void sendUSSD(String ussdString, Message response) {
        addTaint(response.getTaint());
        addTaint(ussdString.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.119 -0400", hash_original_method = "087B5572C84FB61528C8D96F1C079352", hash_generated_method = "236723AE7FCF2BF8A022AB9F84BA8CF8")
    public void cancelPendingUssd(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.119 -0400", hash_original_method = "B603C96410E7BFF356539653D85D8A4B", hash_generated_method = "48880F5B99EA0990FA58F3834AFA969F")
    public void resetRadio(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.119 -0400", hash_original_method = "304D94F0A203021B29E8BE917AB2A88E", hash_generated_method = "BBC4BADFA4986326D34AE02CC6D95EBC")
    public void invokeOemRilRequestRaw(byte[] data, Message response) {
        addTaint(response.getTaint());
        addTaint(data[0]);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.119 -0400", hash_original_method = "5FCB7D9B46CBA85CB2A2479605C5EBE0", hash_generated_method = "67E4AC990919C70B583083C5518375AA")
    public void invokeOemRilRequestStrings(String[] strings, Message response) {
        addTaint(response.getTaint());
        addTaint(strings[0].getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.119 -0400", hash_original_method = "B390B8B053975D6E247D6ADF9DE7B6FC", hash_generated_method = "01F702E216A0427E1846C804D8DCE1FB")
    public void setBandMode(int bandMode, Message response) {
        addTaint(response.getTaint());
        addTaint(bandMode);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.119 -0400", hash_original_method = "CDBADCA8574456832760B996C8943606", hash_generated_method = "9E905752474D54F07494DE0266882C50")
    public void queryAvailableBandMode(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.120 -0400", hash_original_method = "1B08354C58BC7E4FA9F6A992437EB8EB", hash_generated_method = "F78C94E82B91129DA9B7F1C68E11D39D")
    public void sendTerminalResponse(String contents, Message response) {
        addTaint(response.getTaint());
        addTaint(contents.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.120 -0400", hash_original_method = "8510CB1FCB2D71445BC7D7948652F9FF", hash_generated_method = "1D4C12CA7F75E289A70D3ADEECA77EAA")
    public void sendEnvelope(String contents, Message response) {
        addTaint(response.getTaint());
        addTaint(contents.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.120 -0400", hash_original_method = "A584A8270CEEFF3893478A017045D938", hash_generated_method = "EAC7A971D5443642F2EF39534F510A3F")
    public void sendEnvelopeWithStatus(String contents, Message response) {
        addTaint(response.getTaint());
        addTaint(contents.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.120 -0400", hash_original_method = "7D7F347B6C7F161149D5C29633177CD2", hash_generated_method = "9BDFEC505FC0F5951851FB0DE793BF16")
    public void handleCallSetupRequestFromSim(
            boolean accept, Message response) {
        addTaint(response.getTaint());
        addTaint(accept);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.120 -0400", hash_original_method = "27AB8573439D5EB2F33C81C73E25E8F8", hash_generated_method = "0C15BA53C77F4454EB4ED2DEF60A8A03")
    public void setPreferredNetworkType(int networkType , Message response) {
        addTaint(response.getTaint());
        addTaint(networkType);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.120 -0400", hash_original_method = "C86073EB20CA48BDFFC81AAA868A3BB1", hash_generated_method = "1AE3884B7769F676D97B43ED8992EB06")
    public void getPreferredNetworkType(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.120 -0400", hash_original_method = "1E1F359D4473F2441E02E8FE890DEF1C", hash_generated_method = "803A54BA31E9F8CEE7211DF5B414A74F")
    public void getNeighboringCids(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.120 -0400", hash_original_method = "8F4AD1B328B83D997278B06A4EE5820C", hash_generated_method = "C92F892C73DBEB4A237BF25001034A4A")
    public void setLocationUpdates(boolean enable, Message response) {
        addTaint(response.getTaint());
        addTaint(enable);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.120 -0400", hash_original_method = "341ECD479C88F08657B8FDC222C9F79A", hash_generated_method = "E69DF1715AEE0C76AF6DD5DA6BDA2970")
    public void getSmscAddress(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.120 -0400", hash_original_method = "7097F8C49B12B71CDD20291B3AB7964A", hash_generated_method = "C04D994BED4DAD55D122515149B9786C")
    public void setSmscAddress(String address, Message result) {
        addTaint(result.getTaint());
        addTaint(address.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.120 -0400", hash_original_method = "BC0B755F5F01D800040615DED3BCDBA0", hash_generated_method = "33B369ADB97D43A930A882E1189E2528")
    public void reportSmsMemoryStatus(boolean available, Message result) {
        addTaint(result.getTaint());
        addTaint(available);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.120 -0400", hash_original_method = "F7AB9C173D1A57BFEBFB44A47237DF7D", hash_generated_method = "9B2A5E8BC9430E71FAC3D943F3EDA078")
    public void reportStkServiceIsRunning(Message result) {
        addTaint(result.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.120 -0400", hash_original_method = "9CF99F7F300A93DDBFE74502145A8475", hash_generated_method = "673B73A3BBF3B5793688DE676C55629D")
    @Override
    public void getCdmaSubscriptionSource(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.120 -0400", hash_original_method = "4329D3CD35E915BD99C5B818B449ACA1", hash_generated_method = "0F983DDFECA339A2571F58256E842EC7")
    public void getGsmBroadcastConfig(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.122 -0400", hash_original_method = "BEC32E28BD6A6EC85956F36B9D44924D", hash_generated_method = "0619A5C5F17D6280851BEC83A8B90F4D")
    public void setGsmBroadcastConfig(SmsBroadcastConfigInfo[] config, Message response) {
        addTaint(response.getTaint());
        addTaint(config[0].getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.122 -0400", hash_original_method = "2F3C945F2B405B443912668B2367D904", hash_generated_method = "747059A3275E74B5891060348A9C9F68")
    public void setGsmBroadcastActivation(boolean activate, Message response) {
        addTaint(response.getTaint());
        addTaint(activate);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.122 -0400", hash_original_method = "BB255671D9D9AE82C00FD12FF12E7590", hash_generated_method = "DB24117E6DE10F13EFAC1A8522F70166")
    public void getDeviceIdentity(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.122 -0400", hash_original_method = "A28D6B43032903DAFA850C3B9E02D39E", hash_generated_method = "F4357765C51371751C336814DDF5280D")
    public void getCDMASubscription(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.122 -0400", hash_original_method = "6A64EDF04D6CCF6DA11C17A9004CF963", hash_generated_method = "A6502C086B19911110474955EBB8B371")
    public void setPhoneType(int phoneType) {
        addTaint(phoneType);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.122 -0400", hash_original_method = "A9CEBF170D0F656D33BCE6259BBB358F", hash_generated_method = "23F0FDDC3F629DFEEBDB3B08BA87060C")
    public void queryCdmaRoamingPreference(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.122 -0400", hash_original_method = "A524FD7F96F7FB62BB4ABD4057A9354C", hash_generated_method = "B2BB58CE72BD7FB630F15AEDA40DFE3B")
    public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        addTaint(response.getTaint());
        addTaint(cdmaRoamingType);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.122 -0400", hash_original_method = "87C7978CD92754BB7623428AEFA60479", hash_generated_method = "B029C5FF9C9DAF75CF88A35E55725609")
    public void setCdmaSubscriptionSource(int cdmaSubscription , Message response) {
        addTaint(response.getTaint());
        addTaint(cdmaSubscription);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.124 -0400", hash_original_method = "DC6F83E2EE7B0408161F523478208FCE", hash_generated_method = "E756AE3736151DA11240B89608D0CA53")
    public void queryTTYMode(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.124 -0400", hash_original_method = "44348CEECDEE74EEC687675A834A99DA", hash_generated_method = "DBF8AE7CB9904711CE7A4C0925B8A84E")
    public void setTTYMode(int ttyMode, Message response) {
        addTaint(response.getTaint());
        addTaint(ttyMode);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.124 -0400", hash_original_method = "D826071ECAAC08358EF9CEAACAFF0A2A", hash_generated_method = "7104ABFB270F8CD991562761EF587AE7")
    public void sendCDMAFeatureCode(String FeatureCode, Message response) {
        addTaint(response.getTaint());
        addTaint(FeatureCode.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.124 -0400", hash_original_method = "DCBE6B932ED9844344E5753E79DB999C", hash_generated_method = "58AC89E2B35F1C53FBB37DBB95FBFBCF")
    public void getCdmaBroadcastConfig(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.124 -0400", hash_original_method = "86E74F47BAC216027EBD89BDEFC4A2E0", hash_generated_method = "7EAC490D1BBB238688203A239BDC8244")
    public void setCdmaBroadcastConfig(int[] configValuesArray, Message response) {
        addTaint(response.getTaint());
        addTaint(configValuesArray[0]);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.124 -0400", hash_original_method = "02EE3B357DCB6CF5847DAE1F69A62BD8", hash_generated_method = "46A4A3BE1C26A4A669602A6150A68AB3")
    public void setCdmaBroadcastActivation(boolean activate, Message response) {
        addTaint(response.getTaint());
        addTaint(activate);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.125 -0400", hash_original_method = "B73B7043BB86BD20367E2BA4C1F7579D", hash_generated_method = "F59E0E4F5F3C654DF2D57C3B4CF2BC39")
    public void exitEmergencyCallbackMode(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.126 -0400", hash_original_method = "A7B720D7AAE639C9AA81ACDD2FD07958", hash_generated_method = "C4020BC078E6D25BA42500F71884296A")
    @Override
    public void supplyIccPinForApp(String pin, String aid, Message response) {
        addTaint(response.getTaint());
        addTaint(aid.getTaint());
        addTaint(pin.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.126 -0400", hash_original_method = "85052B085E211221DC52D076F63CDE51", hash_generated_method = "018A92435E414829B302BD2758A26939")
    @Override
    public void supplyIccPukForApp(String puk, String newPin, String aid, Message response) {
        addTaint(response.getTaint());
        addTaint(aid.getTaint());
        addTaint(newPin.getTaint());
        addTaint(puk.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.127 -0400", hash_original_method = "4EA9B69CB4BB92F6CBD1A973DB39784D", hash_generated_method = "D585834EBA34D01A96B0482CCF4B70B0")
    @Override
    public void supplyIccPin2ForApp(String pin2, String aid, Message response) {
        addTaint(response.getTaint());
        addTaint(aid.getTaint());
        addTaint(pin2.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.127 -0400", hash_original_method = "FF125CC3CEA22589265ADC8CAED2B3CC", hash_generated_method = "8661977891F5FE6442F72D59E97E9FDE")
    @Override
    public void supplyIccPuk2ForApp(String puk2, String newPin2, String aid, Message response) {
        addTaint(response.getTaint());
        addTaint(aid.getTaint());
        addTaint(newPin2.getTaint());
        addTaint(puk2.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.127 -0400", hash_original_method = "A51A50ABC77958852F41695682CE2620", hash_generated_method = "AB43CBE2E9650DFAF4BBE898F35E2923")
    @Override
    public void changeIccPinForApp(String oldPin, String newPin, String aidPtr, Message response) {
        addTaint(response.getTaint());
        addTaint(aidPtr.getTaint());
        addTaint(newPin.getTaint());
        addTaint(oldPin.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.127 -0400", hash_original_method = "39AB2DAFFDF72A29B22CB665239943F5", hash_generated_method = "5030C6D55B05C52AB237988E716D3F31")
    @Override
    public void changeIccPin2ForApp(String oldPin2, String newPin2, String aidPtr,
            Message response) {
        addTaint(response.getTaint());
        addTaint(aidPtr.getTaint());
        addTaint(newPin2.getTaint());
        addTaint(oldPin2.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.129 -0400", hash_original_method = "417EB29332801A205E6BDDA18E3F8488", hash_generated_method = "0F6A29E5DEA46B79A65C936EA68B91A4")
    public void requestIsimAuthentication(String nonce, Message response) {
        addTaint(response.getTaint());
        addTaint(nonce.getTaint());
        
    }

    
}

