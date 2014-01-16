package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.android.internal.telephony.BaseCommands;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.UUSInfo;
import com.android.internal.telephony.gsm.SmsBroadcastConfigInfo;

class SipCommandInterface extends BaseCommands implements CommandsInterface {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.504 -0500", hash_original_method = "A6511375FC27D28438216697969D84B8", hash_generated_method = "A6511375FC27D28438216697969D84B8")
    
SipCommandInterface(Context context) {
        super(context);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.506 -0500", hash_original_method = "7892594A38871B784C768CFB911D0AFF", hash_generated_method = "5A578BBF7A7D5E55DB8675EE63D6893A")
    
@Override public void setOnNITZTime(Handler h, int what, Object obj) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.509 -0500", hash_original_method = "4FF9B345C0ACD80EE0490BCC729EF93D", hash_generated_method = "76B9215D66EE12BF215EE5A62B460C47")
    
public void getIccCardStatus(Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.512 -0500", hash_original_method = "312175F43C21A9CB89FD25F385D47375", hash_generated_method = "0CC36062313BF0EB99287B24D20699D6")
    
public void supplyIccPin(String pin, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.514 -0500", hash_original_method = "8D2388C3F4BE09E9BCDF564DE7BCBB17", hash_generated_method = "05FDB5F71EE9C10B7F436222123C6160")
    
public void supplyIccPuk(String puk, String newPin, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.516 -0500", hash_original_method = "498621A7956DB667721B9B2B71D65CFE", hash_generated_method = "33FBB2EE6BF8A205BF79B5B9AB7E22B7")
    
public void supplyIccPin2(String pin, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.518 -0500", hash_original_method = "40AAC8CED8D5308D12D2E5CDAF9B6A47", hash_generated_method = "7537D54F9939C75D4CB77975EE3242C8")
    
public void supplyIccPuk2(String puk, String newPin2, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.520 -0500", hash_original_method = "B3FC9EBBB6773F816458111FF8F155DE", hash_generated_method = "41434C0D7EAFB4C29D76B51F8B723798")
    
public void changeIccPin(String oldPin, String newPin, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.523 -0500", hash_original_method = "8D51802625738E75E56F41DE488CEBFD", hash_generated_method = "C5289A06D4F545BC16CB91431CEA620F")
    
public void changeIccPin2(String oldPin2, String newPin2, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.525 -0500", hash_original_method = "FE49297D5F160C632D8EB8B38400EA83", hash_generated_method = "4120649DCDB8B88EA35A5753610371E2")
    
public void changeBarringPassword(String facility, String oldPwd,
            String newPwd, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.528 -0500", hash_original_method = "CEDA07561D4A2E174B41C09240087336", hash_generated_method = "952376CD6FC90F9A7BBC7B31395C85FB")
    
public void supplyNetworkDepersonalization(String netpin, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.530 -0500", hash_original_method = "0065DCF0A6FA35BBD3B5D6CD7BC5264B", hash_generated_method = "2541E6019B85EA74F2EE4175A2DD5BEB")
    
public void getCurrentCalls(Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.532 -0500", hash_original_method = "1C2C08D3245326421BB25469D878BC40", hash_generated_method = "51C54F69FCE8C97877947FE42615003D")
    
@Deprecated public void getPDPContextList(Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.534 -0500", hash_original_method = "327D3ACFB77EFA2CD859CBEFD5183E40", hash_generated_method = "C032B00F50B61CD48ACE7483C1CAE1F6")
    
public void getDataCallList(Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.537 -0500", hash_original_method = "DAA1A0C85E21F9D3405F2D9B646EE982", hash_generated_method = "D86502440D184E0C950D53E00BF0DBFA")
    
public void dial(String address, int clirMode, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.539 -0500", hash_original_method = "013CAFE12783E64D183D4781FFBCA18A", hash_generated_method = "7860C8B7FF0D93D6F8EA83440938E3CE")
    
public void dial(String address, int clirMode, UUSInfo uusInfo,
            Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.541 -0500", hash_original_method = "1348EC8F8E592B792A235EF8BDA1A728", hash_generated_method = "2C9D2B54C552FC93C53D0E71928C6700")
    
public void getIMSI(Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.543 -0500", hash_original_method = "9CFFA6883C5B8E59E96AC7EBA98411BF", hash_generated_method = "DCE270BE5A15685BE5AE62BE96FC962B")
    
public void getIMEI(Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.545 -0500", hash_original_method = "16825ADE4AEE806A281B5593AC7D63E8", hash_generated_method = "93840DE1625C177F9AEEE641FC9153AE")
    
public void getIMEISV(Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.547 -0500", hash_original_method = "367D9C3523440D236020890B46AD46EA", hash_generated_method = "59C0419BF5664B61247B5C6AD39930F8")
    
public void hangupConnection (int gsmIndex, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.549 -0500", hash_original_method = "24CF4908E9C6B567B8992DC13D635451", hash_generated_method = "9D06DD511404884EACCE08FE080194D8")
    
public void hangupWaitingOrBackground (Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.551 -0500", hash_original_method = "B6BFA6F3A6A105C9D4B6C1E698A66938", hash_generated_method = "FDF983B8313A79F6512119C1F507F2DA")
    
public void hangupForegroundResumeBackground (Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.553 -0500", hash_original_method = "E5CA3DEE020231D0A58CD27DCC9A3298", hash_generated_method = "C4F0F27606F26C0E295732F42E1BFC9A")
    
public void switchWaitingOrHoldingAndActive (Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.556 -0500", hash_original_method = "1DEC6D6ED7076F247D9C03337753D9B5", hash_generated_method = "1DA486F474CA9B368AC6F4FE7221B366")
    
public void conference (Message result) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.559 -0500", hash_original_method = "F8189B7D9A2D4B100A35E308752559C1", hash_generated_method = "A4310B7F921493C4C6CC636F7691937B")
    
public void setPreferredVoicePrivacy(boolean enable, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.561 -0500", hash_original_method = "7AC939257493C8EDA50728ACBE47AB6E", hash_generated_method = "DFC24014F1C443B1B12AC986D8473A48")
    
public void getPreferredVoicePrivacy(Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.563 -0500", hash_original_method = "0FFF3C40EB3863D408D749356210235C", hash_generated_method = "B2FF05DC74085DBD707DF91785529099")
    
public void separateConnection (int gsmIndex, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.566 -0500", hash_original_method = "5D47CDCEE79D220D19ED199AB41576BB", hash_generated_method = "3B045CEA0ADC1BF95EDEF8CB54C47D87")
    
public void acceptCall (Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.568 -0500", hash_original_method = "B0370CE1AC140C2D8FD8DDB138D51178", hash_generated_method = "06EA40C76B93C16D92193F1414F16D11")
    
public void rejectCall (Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.570 -0500", hash_original_method = "423F7E66395D67C4DDE50E0CD115AB32", hash_generated_method = "52B7A76324F60D0444567F23F51FCB7A")
    
public void explicitCallTransfer (Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.572 -0500", hash_original_method = "452E3A07FEEB48EC41C26B70B19470A7", hash_generated_method = "8AF10DCCBE0C98B6EAEFE811B1402356")
    
public void getLastCallFailCause (Message result) {
    }

    /** @deprecated */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.574 -0500", hash_original_method = "866637DA865C177743D4ACCECF2320D1", hash_generated_method = "20F317FA91A75BD80E48365B4F426719")
    
public void getLastPdpFailCause (Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.576 -0500", hash_original_method = "5E09CD605032BAD12B5071D1198B480C", hash_generated_method = "36DAEDAE43FF56DE1EA0A3F419AC788B")
    
public void getLastDataCallFailCause (Message result) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.579 -0500", hash_original_method = "47C0EC939F57E1591B76316E27B95AC6", hash_generated_method = "6D5ECDFE5AEEC870266D089926FB46AD")
    
public void setMute (boolean enableMute, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.581 -0500", hash_original_method = "18914EB1B73273C70F170F17B7ABD9F7", hash_generated_method = "DFB8537121E87F267CEED44CFDC78F88")
    
public void getMute (Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.583 -0500", hash_original_method = "2E5F50302D75BF22D071DDE735D84DDB", hash_generated_method = "A5D08C97EB76F1632822EEB8387E9841")
    
public void getSignalStrength (Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.585 -0500", hash_original_method = "E48AE2BAAEA38C3013B3567C40E7D695", hash_generated_method = "915B32BE6C0316BD73590860F1946CAA")
    
public void getVoiceRegistrationState (Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.587 -0500", hash_original_method = "3D40BE498077599AA87C5D11079E9906", hash_generated_method = "8D8A036BFBBB06393FD736A388F218C3")
    
public void getDataRegistrationState (Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.589 -0500", hash_original_method = "0ABE511CA2DC2D12C96958F57DAAD741", hash_generated_method = "491BEC73E4E683B1013C80762E71B8D9")
    
public void getOperator(Message result) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.592 -0500", hash_original_method = "AD70FA03EB7E7D9139EEB149F6091A1C", hash_generated_method = "6D4A047781FA4D6F1BC41C0EC0911550")
    
public void sendDtmf(char c, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.594 -0500", hash_original_method = "EE6742CCEC46FE0C371CDA35CEE96A7C", hash_generated_method = "A9FBE54EB8D7A7EC369DFAAEA165C103")
    
public void startDtmf(char c, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.596 -0500", hash_original_method = "CE80A91715BFB5541CB44AB81DDE6D0F", hash_generated_method = "138BC1FC450AF904E50ECACF52627642")
    
public void stopDtmf(Message result) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.598 -0500", hash_original_method = "9D33455A19E4CDFE7486EF4C6C2B8AAA", hash_generated_method = "4E0CEBEB5C71C187752508A94405477A")
    
public void sendBurstDtmf(String dtmfString, int on, int off,
            Message result) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.600 -0500", hash_original_method = "1A6264A9FF23649BF5DB6F7920F9A21A", hash_generated_method = "B5FF7CBA0BCE016F01249BDE86AF58D6")
    
public void sendSMS (String smscPDU, String pdu, Message result) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.603 -0500", hash_original_method = "6EB636270661AC6BE13856E5BA601B13", hash_generated_method = "0ADE81982E6685491470B265225037EE")
    
public void sendCdmaSms(byte[] pdu, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.605 -0500", hash_original_method = "D5DE63795C5344B7C78E8B6314329432", hash_generated_method = "1803AC257F862D098269F780BB0807F1")
    
public void deleteSmsOnSim(int index, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.607 -0500", hash_original_method = "03C10B95DDA41CA22B6255050F7053EA", hash_generated_method = "FBC8A4943AEF27E6DE964977D6D13137")
    
public void deleteSmsOnRuim(int index, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.609 -0500", hash_original_method = "E5ECA9ECE683BEAA97AF5287FA4FD73D", hash_generated_method = "DAA14ECB46F4954855FBA90844FD3191")
    
public void writeSmsToSim(int status, String smsc, String pdu, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.612 -0500", hash_original_method = "301EEEF677F35EBA7B87E2EF64620E88", hash_generated_method = "56C476670DC4CF62CAAAB7AC01666AC9")
    
public void writeSmsToRuim(int status, String pdu, Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.614 -0500", hash_original_method = "5419A5B08D65477966DC4B41045B2D43", hash_generated_method = "52CD6B0BEA3867E003C4C15BD05C1D26")
    
public void setupDataCall(String radioTechnology, String profile,
            String apn, String user, String password, String authType,
            String protocol, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.616 -0500", hash_original_method = "F4E5DEF79555248AC6400DB4F70FA346", hash_generated_method = "08F18A6BC4F66868F7A26E4B8DB60F58")
    
public void deactivateDataCall(int cid, int reason, Message result) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.618 -0500", hash_original_method = "658BFFD1699DF28E1FC33C876F64D0E2", hash_generated_method = "2C22752599418AA1C18236084A6E6268")
    
public void setRadioPower(boolean on, Message result) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.620 -0500", hash_original_method = "34A3D962E1CAE2FDD06754C7CD1F32F3", hash_generated_method = "50080C11500F8DDA673FCC18DE366C90")
    
public void setSuppServiceNotifications(boolean enable, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.623 -0500", hash_original_method = "04D2C2576FBA17CACB979DAC278A3D84", hash_generated_method = "0E731209962F09AD9ECDF8FA0AC16329")
    
public void acknowledgeLastIncomingGsmSms(boolean success, int cause,
            Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.625 -0500", hash_original_method = "BBFEF1AC264FC2EFFBA144FBBD11A68E", hash_generated_method = "B28E556D481EC2EF2445CD059FD2DC5F")
    
public void acknowledgeLastIncomingCdmaSms(boolean success, int cause,
            Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.627 -0500", hash_original_method = "281B95F00D12B8C721DC5976D4A537AE", hash_generated_method = "8D1D77776B10791A60EE4E34E821815D")
    
public void acknowledgeIncomingGsmSmsWithPdu(boolean success, String ackPdu,
            Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.629 -0500", hash_original_method = "D56D36D653FFB0D666CDD952E4E3B98E", hash_generated_method = "5B6D78F430479EB99EEA0990A60A26F1")
    
public void iccIO (int command, int fileid, String path, int p1, int p2,
            int p3, String data, String pin2, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.632 -0500", hash_original_method = "97A78B1A23DB91BDC82BEB1858BCD95E", hash_generated_method = "6FBDB743F1E63FF09FC1DC4D77078785")
    
public void getCLIR(Message result) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.634 -0500", hash_original_method = "B8D63B72DC65EE3608FC65F298DE2981", hash_generated_method = "487C3E24601F5BDEC62BFDE58F3ED640")
    
public void setCLIR(int clirMode, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.636 -0500", hash_original_method = "5B2012150FA92F57F4DA5FBC8874C419", hash_generated_method = "71284C0D43110D409605A6457E5E1F3A")
    
public void queryCallWaiting(int serviceClass, Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.638 -0500", hash_original_method = "5B610ADF58E8A4CB2911C741C5D1D851", hash_generated_method = "BEEB3B4BD9C9417A7D13A2A4AF2A3DED")
    
public void setCallWaiting(boolean enable, int serviceClass,
            Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.640 -0500", hash_original_method = "958A118B1D6DEAAC3F2CD7A0471E8E5A", hash_generated_method = "5C44E2DE0145E74BE24D559D7FB4F61E")
    
public void setNetworkSelectionModeAutomatic(Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.642 -0500", hash_original_method = "A699748593EA9CB79EF65A1D8087DE87", hash_generated_method = "C9B8FF5BD94FE479422CEB7457AEC539")
    
public void setNetworkSelectionModeManual(
            String operatorNumeric, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.645 -0500", hash_original_method = "37E66FF0A3AEDBEF007D30C9E2FF98CD", hash_generated_method = "750EC9D099AE8ED87C7F6016FA21C266")
    
public void getNetworkSelectionMode(Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.647 -0500", hash_original_method = "F3D2B6350F8E1C278AFA7ECA9187C8D7", hash_generated_method = "4FB3045AEB51BE4AE5BA1B2F97822222")
    
public void getAvailableNetworks(Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.649 -0500", hash_original_method = "DA232DDE50E73AC5D636EAD7EF5FC864", hash_generated_method = "78B4368EDB55C78685590968D2879D91")
    
public void setCallForward(int action, int cfReason, int serviceClass,
                String number, int timeSeconds, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.652 -0500", hash_original_method = "455A9434E862CC2E0C873DE31EB09A28", hash_generated_method = "1C7D1318CD4BD75FC2299D377F092A3E")
    
public void queryCallForwardStatus(int cfReason, int serviceClass,
            String number, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.654 -0500", hash_original_method = "1E5E60364AF2DDDA55FE9584B8EF0B2C", hash_generated_method = "91C0AE1325FEE356724D94620E928740")
    
public void queryCLIP(Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.656 -0500", hash_original_method = "EE7857BCB5A1D2385833186B6353BDF6", hash_generated_method = "48793710A2CD622658F3F8DE073389DA")
    
public void getBasebandVersion (Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.658 -0500", hash_original_method = "A56D965167C62C2F95036EFE39C4CA71", hash_generated_method = "59EB3D69CE2DA21EFAAB0026083C52B1")
    
@Override
    public void queryFacilityLock(String facility, String password,
            int serviceClass, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.660 -0500", hash_original_method = "230F3C7CDCF2BDF61799EBE662AE054E", hash_generated_method = "226B00A2CA72ADCD4C405CDAEC418736")
    
@Override
    public void queryFacilityLockForApp(String facility, String password,
            int serviceClass, String appId, Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.663 -0500", hash_original_method = "AD3FF097428D5AB19C8EE6C9813E3899", hash_generated_method = "C3764D7F8C6421AB96AD1C0ECD0D57AB")
    
@Override
    public void setFacilityLock(String facility, boolean lockState,
            String password, int serviceClass, Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.665 -0500", hash_original_method = "933F2123A615A9A39A40CBF915D35DBF", hash_generated_method = "ABB15714AFB35E99821079D4BDECED3B")
    
@Override
    public void setFacilityLockForApp(String facility, boolean lockState,
            String password, int serviceClass, String appId, Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.668 -0500", hash_original_method = "F9FFB06D76A77B7B92045DB70103041E", hash_generated_method = "95F3480671289286868A1C55EEF16322")
    
public void sendUSSD (String ussdString, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.670 -0500", hash_original_method = "087B5572C84FB61528C8D96F1C079352", hash_generated_method = "5EB9777F0820F1A5CD31EDE08CF095E0")
    
public void cancelPendingUssd (Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.672 -0500", hash_original_method = "B603C96410E7BFF356539653D85D8A4B", hash_generated_method = "1CB1FDC519CFA0AE932DC9847332BAF9")
    
public void resetRadio(Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.675 -0500", hash_original_method = "304D94F0A203021B29E8BE917AB2A88E", hash_generated_method = "825D0D14877074DE432AD2513DF0E4E5")
    
public void invokeOemRilRequestRaw(byte[] data, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.677 -0500", hash_original_method = "5FCB7D9B46CBA85CB2A2479605C5EBE0", hash_generated_method = "19F7C2D125CB12D05DFC7F76C65DAA1F")
    
public void invokeOemRilRequestStrings(String[] strings, Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.679 -0500", hash_original_method = "B390B8B053975D6E247D6ADF9DE7B6FC", hash_generated_method = "9B1E26C88804147F1044601E6FAFD0D1")
    
public void setBandMode (int bandMode, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.681 -0500", hash_original_method = "CDBADCA8574456832760B996C8943606", hash_generated_method = "F12FCA5CA1CBC2538E7C948B5FD9C704")
    
public void queryAvailableBandMode (Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.683 -0500", hash_original_method = "1B08354C58BC7E4FA9F6A992437EB8EB", hash_generated_method = "11B38D25E7337C9942626E677CC05CD5")
    
public void sendTerminalResponse(String contents, Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.685 -0500", hash_original_method = "8510CB1FCB2D71445BC7D7948652F9FF", hash_generated_method = "277D160E2BCED1813CBC38E24F18ED75")
    
public void sendEnvelope(String contents, Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.687 -0500", hash_original_method = "A584A8270CEEFF3893478A017045D938", hash_generated_method = "701A8A2326E4652731616B817B35A9DB")
    
public void sendEnvelopeWithStatus(String contents, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.689 -0500", hash_original_method = "7D7F347B6C7F161149D5C29633177CD2", hash_generated_method = "5E964BF2AEBFCE3356F29D6337E2A4CF")
    
public void handleCallSetupRequestFromSim(
            boolean accept, Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.692 -0500", hash_original_method = "27AB8573439D5EB2F33C81C73E25E8F8", hash_generated_method = "B70520F14CE098A6483B62DA41D8EE88")
    
public void setPreferredNetworkType(int networkType , Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.694 -0500", hash_original_method = "C86073EB20CA48BDFFC81AAA868A3BB1", hash_generated_method = "43D58558D25D3F982400172415A99BCC")
    
public void getPreferredNetworkType(Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.696 -0500", hash_original_method = "1E1F359D4473F2441E02E8FE890DEF1C", hash_generated_method = "EA4BBF728E1D00DE51E3F73E281A4213")
    
public void getNeighboringCids(Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.698 -0500", hash_original_method = "8F4AD1B328B83D997278B06A4EE5820C", hash_generated_method = "1AA99C3733ECBCE7289E95C8E86FB1EF")
    
public void setLocationUpdates(boolean enable, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.701 -0500", hash_original_method = "341ECD479C88F08657B8FDC222C9F79A", hash_generated_method = "DF20BC64AC2B0FF51EFF5B0E5559BCDA")
    
public void getSmscAddress(Message result) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.703 -0500", hash_original_method = "7097F8C49B12B71CDD20291B3AB7964A", hash_generated_method = "F1F2D79AF5A315939AAA30BD67428C6E")
    
public void setSmscAddress(String address, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.705 -0500", hash_original_method = "BC0B755F5F01D800040615DED3BCDBA0", hash_generated_method = "4B74BF21920DA77CCA3BE72141F7B0E5")
    
public void reportSmsMemoryStatus(boolean available, Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.708 -0500", hash_original_method = "F7AB9C173D1A57BFEBFB44A47237DF7D", hash_generated_method = "1DBB5783E8B25E1F683BAE19133B3E1D")
    
public void reportStkServiceIsRunning(Message result) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.710 -0500", hash_original_method = "9CF99F7F300A93DDBFE74502145A8475", hash_generated_method = "8486F5B190ADEBEDB556535E22F1CEAA")
    
@Override
    public void getCdmaSubscriptionSource(Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.712 -0500", hash_original_method = "4329D3CD35E915BD99C5B818B449ACA1", hash_generated_method = "964F72DD5DAA5C342B345044B48F1AFA")
    
public void getGsmBroadcastConfig(Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.715 -0500", hash_original_method = "BEC32E28BD6A6EC85956F36B9D44924D", hash_generated_method = "5978E03091F56949C348C5214327B1BF")
    
public void setGsmBroadcastConfig(SmsBroadcastConfigInfo[] config, Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.717 -0500", hash_original_method = "2F3C945F2B405B443912668B2367D904", hash_generated_method = "95BF91ECE4CDA58D19672556E37F549A")
    
public void setGsmBroadcastActivation(boolean activate, Message response) {
    }

    // ***** Methods for CDMA support
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.719 -0500", hash_original_method = "BB255671D9D9AE82C00FD12FF12E7590", hash_generated_method = "9FE4E4684D8427384C7C74A24B6FB758")
    
public void getDeviceIdentity(Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.721 -0500", hash_original_method = "A28D6B43032903DAFA850C3B9E02D39E", hash_generated_method = "AEA22E7FEE9003B3CF660E65DD2731D6")
    
public void getCDMASubscription(Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.723 -0500", hash_original_method = "6A64EDF04D6CCF6DA11C17A9004CF963", hash_generated_method = "CC059F0DCBF839ED9EA3313B96D3950A")
    
public void setPhoneType(int phoneType) { //Set by CDMAPhone and GSMPhone constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.725 -0500", hash_original_method = "A9CEBF170D0F656D33BCE6259BBB358F", hash_generated_method = "25F240ADA9BCA0BE982821D83BF0C438")
    
public void queryCdmaRoamingPreference(Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.727 -0500", hash_original_method = "A524FD7F96F7FB62BB4ABD4057A9354C", hash_generated_method = "9F7F20AD0C191DEC70DB60BF092B918F")
    
public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.729 -0500", hash_original_method = "87C7978CD92754BB7623428AEFA60479", hash_generated_method = "E78ACD72FB9CCFD3EF6DBC11CFB911A7")
    
public void setCdmaSubscriptionSource(int cdmaSubscription , Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.732 -0500", hash_original_method = "DC6F83E2EE7B0408161F523478208FCE", hash_generated_method = "A84D2E86A2F377B13815AF5175F355B9")
    
public void queryTTYMode(Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.734 -0500", hash_original_method = "44348CEECDEE74EEC687675A834A99DA", hash_generated_method = "BA3B94CAA5505B85E7DB6F18D3B4C2BD")
    
public void setTTYMode(int ttyMode, Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.736 -0500", hash_original_method = "D826071ECAAC08358EF9CEAACAFF0A2A", hash_generated_method = "9687F74FCA14235DC5A15670CE86E8DB")
    
public void sendCDMAFeatureCode(String FeatureCode, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.739 -0500", hash_original_method = "DCBE6B932ED9844344E5753E79DB999C", hash_generated_method = "3D9AE95DE3B350388D48EBEDAFD8D5EC")
    
public void getCdmaBroadcastConfig(Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.741 -0500", hash_original_method = "86E74F47BAC216027EBD89BDEFC4A2E0", hash_generated_method = "60402C15D180EC0A74591AD70A5EE162")
    
public void setCdmaBroadcastConfig(int[] configValuesArray, Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.743 -0500", hash_original_method = "02EE3B357DCB6CF5847DAE1F69A62BD8", hash_generated_method = "771D09A44B2159B3BA55D1C97F6FE92F")
    
public void setCdmaBroadcastActivation(boolean activate, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.746 -0500", hash_original_method = "B73B7043BB86BD20367E2BA4C1F7579D", hash_generated_method = "E4C0D0F538E047D7B49657740B090EC6")
    
public void exitEmergencyCallbackMode(Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.748 -0500", hash_original_method = "A7B720D7AAE639C9AA81ACDD2FD07958", hash_generated_method = "D4CA3FE5AE34BD9215D5177E4E76987B")
    
@Override
    public void supplyIccPinForApp(String pin, String aid, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.750 -0500", hash_original_method = "85052B085E211221DC52D076F63CDE51", hash_generated_method = "A691998C3AC6119AA241473E4D9015FE")
    
@Override
    public void supplyIccPukForApp(String puk, String newPin, String aid, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.753 -0500", hash_original_method = "4EA9B69CB4BB92F6CBD1A973DB39784D", hash_generated_method = "29C454BBACFACF4A061CA617A00D69CF")
    
@Override
    public void supplyIccPin2ForApp(String pin2, String aid, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.755 -0500", hash_original_method = "FF125CC3CEA22589265ADC8CAED2B3CC", hash_generated_method = "9AFB9349AEDE7E9B30D7C047A4073FC8")
    
@Override
    public void supplyIccPuk2ForApp(String puk2, String newPin2, String aid, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.757 -0500", hash_original_method = "A51A50ABC77958852F41695682CE2620", hash_generated_method = "B45995CBB85D5D14A0080579636A1699")
    
@Override
    public void changeIccPinForApp(String oldPin, String newPin, String aidPtr, Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.759 -0500", hash_original_method = "39AB2DAFFDF72A29B22CB665239943F5", hash_generated_method = "08DF8EB57819F08BC1C0811C3F4C8696")
    
@Override
    public void changeIccPin2ForApp(String oldPin2, String newPin2, String aidPtr,
            Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.761 -0500", hash_original_method = "417EB29332801A205E6BDDA18E3F8488", hash_generated_method = "54A7B51FC233852AC63508E8696C2C07")
    
public void requestIsimAuthentication(String nonce, Message response) {
    }
    
}

