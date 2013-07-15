package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class AlertProtocol {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.796 -0400", hash_original_field = "1F9BEE7140A219A96C922C99EEDE7B34", hash_generated_field = "123A71D4C41C48510467491232841B9E")

    private final byte[] alert = new byte[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.796 -0400", hash_original_field = "398E3ACF063793A09BD262C5C522B1DE", hash_generated_field = "C5076A69D1F8496ADA0329E39C7F9A64")

    private SSLRecordProtocol recordProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.796 -0400", hash_original_field = "9CC3434A2AF2B484DEC21C96204A5F7F", hash_generated_field = "586593FC273B16FB55D0AB5F86D137A2")

    private Logger.Stream logger = Logger.getStream("alert");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.796 -0400", hash_original_method = "E092E2209250C02F09C22B7C95E9AB91", hash_generated_method = "89DDAFEDBDC6600ADF822412966FC90D")
    protected  AlertProtocol() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.797 -0400", hash_original_method = "4783F18A2AEFB1BF115D21F8D4F4E6FF", hash_generated_method = "A9742893573022675C3B4131750B59FD")
    protected void setRecordProtocol(SSLRecordProtocol recordProtocol) {
        this.recordProtocol = recordProtocol;
        // ---------- Original Method ----------
        //this.recordProtocol = recordProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.797 -0400", hash_original_method = "F413EBA539C7D7D57656EE1032BAAF7C", hash_generated_method = "BEC679A15E3E9A3F261846F2A84D713B")
    protected void alert(byte level, byte description) {
    if(logger != null)        
        {
            logger.println("Alert.alert: "+level+" "+description);
        } //End block
        this.alert[0] = level;
        this.alert[1] = description;
        // ---------- Original Method ----------
        //if (logger != null) {
            //logger.println("Alert.alert: "+level+" "+description);
        //}
        //this.alert[0] = level;
        //this.alert[1] = description;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.798 -0400", hash_original_method = "5D3BF0EC0666EBF860C9DC61576F480B", hash_generated_method = "E593376A677B1AC088A7D399F18E755E")
    protected byte getDescriptionCode() {
        byte var620A6AC45EE78D7706DC40FF04546662_372648948 = ((alert[0] != 0) ? alert[1] : -100);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_647334895 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_647334895;
        // ---------- Original Method ----------
        //return (alert[0] != 0) ? alert[1] : -100;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.798 -0400", hash_original_method = "87AB9C19E1A7EED4E3BFCF946809E0DA", hash_generated_method = "BCD73438B012A1E39572CDD89594E061")
    protected void setProcessed() {
    if(logger != null)        
        {
            logger.println("Alert.setProcessed");
        } //End block
        this.alert[0] = 0;
        // ---------- Original Method ----------
        //if (logger != null) {
            //logger.println("Alert.setProcessed");
        //}
        //this.alert[0] = 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.799 -0400", hash_original_method = "45A2D96003EBC85CF21133EEF592859F", hash_generated_method = "F2121E639CDA58002A9E98F6562C5C00")
    protected boolean hasAlert() {
        boolean var68AFB5175E9F0A0516B6810C0EF77DEA_228581885 = ((alert[0] != 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1033163274 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1033163274;
        // ---------- Original Method ----------
        //return (alert[0] != 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.799 -0400", hash_original_method = "7F9DD2505076B3CAC6687DC8D86BE7DC", hash_generated_method = "63742973F426DD285A7B2280F61D6E45")
    protected boolean isFatalAlert() {
        boolean varDD20D07BB5078E6B573E185AE98D6430_904636299 = ((alert[0] == 2));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_155248262 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_155248262;
        // ---------- Original Method ----------
        //return (alert[0] == 2);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.800 -0400", hash_original_method = "4ED335C5479EFEAB65BE48D985C7B953", hash_generated_method = "A21C5E2F377146D632506D33A54CA8EF")
    protected String getAlertDescription() {
switch(alert[1]){
        case CLOSE_NOTIFY:
String var747FD2A0F055504E982853DB7B433CDF_284855070 =         "close_notify";
        var747FD2A0F055504E982853DB7B433CDF_284855070.addTaint(taint);
        return var747FD2A0F055504E982853DB7B433CDF_284855070;
        case UNEXPECTED_MESSAGE:
String var2B6041A211ADD09BC3C3F3F99062A031_1624567087 =         "unexpected_message";
        var2B6041A211ADD09BC3C3F3F99062A031_1624567087.addTaint(taint);
        return var2B6041A211ADD09BC3C3F3F99062A031_1624567087;
        case BAD_RECORD_MAC:
String varF46B7E450D978A04206E1FEEDDAAA5DF_121768961 =         "bad_record_mac";
        varF46B7E450D978A04206E1FEEDDAAA5DF_121768961.addTaint(taint);
        return varF46B7E450D978A04206E1FEEDDAAA5DF_121768961;
        case DECRYPTION_FAILED:
String var3357238B66685A8516E81D226E5D08F4_1440980702 =         "decryption_failed";
        var3357238B66685A8516E81D226E5D08F4_1440980702.addTaint(taint);
        return var3357238B66685A8516E81D226E5D08F4_1440980702;
        case RECORD_OVERFLOW:
String var1A44C2E642000F96BDD0FB8E9989D9C1_355509563 =         "record_overflow";
        var1A44C2E642000F96BDD0FB8E9989D9C1_355509563.addTaint(taint);
        return var1A44C2E642000F96BDD0FB8E9989D9C1_355509563;
        case DECOMPRESSION_FAILURE:
String var9712EDB8859C8EB8042746B1C01966A3_176592556 =         "decompression_failure";
        var9712EDB8859C8EB8042746B1C01966A3_176592556.addTaint(taint);
        return var9712EDB8859C8EB8042746B1C01966A3_176592556;
        case HANDSHAKE_FAILURE:
String varAF971F96E7C03B74E2EB09806B0A9F51_1669335238 =         "handshake_failure";
        varAF971F96E7C03B74E2EB09806B0A9F51_1669335238.addTaint(taint);
        return varAF971F96E7C03B74E2EB09806B0A9F51_1669335238;
        case BAD_CERTIFICATE:
String var760EABDC7B1ACDD1FA7F3E5026B7EF2A_673611048 =         "bad_certificate";
        var760EABDC7B1ACDD1FA7F3E5026B7EF2A_673611048.addTaint(taint);
        return var760EABDC7B1ACDD1FA7F3E5026B7EF2A_673611048;
        case UNSUPPORTED_CERTIFICATE:
String varD9819EC8B102FC4AF17B91AB339168A0_1301123635 =         "unsupported_certificate";
        varD9819EC8B102FC4AF17B91AB339168A0_1301123635.addTaint(taint);
        return varD9819EC8B102FC4AF17B91AB339168A0_1301123635;
        case CERTIFICATE_REVOKED:
String varEF150CAC2D75E3629BD88A061E7CA734_347284153 =         "certificate_revoked";
        varEF150CAC2D75E3629BD88A061E7CA734_347284153.addTaint(taint);
        return varEF150CAC2D75E3629BD88A061E7CA734_347284153;
        case CERTIFICATE_EXPIRED:
String var02DED1AD731BDC7389435F9A25E8F427_259382658 =         "certificate_expired";
        var02DED1AD731BDC7389435F9A25E8F427_259382658.addTaint(taint);
        return var02DED1AD731BDC7389435F9A25E8F427_259382658;
        case CERTIFICATE_UNKNOWN:
String var0514E0ECA38F479878B7B510D4C20E1D_217012953 =         "certificate_unknown";
        var0514E0ECA38F479878B7B510D4C20E1D_217012953.addTaint(taint);
        return var0514E0ECA38F479878B7B510D4C20E1D_217012953;
        case ILLEGAL_PARAMETER:
String var5C376539CC3DD936FD690BE20DF81E57_1317384014 =         "illegal_parameter";
        var5C376539CC3DD936FD690BE20DF81E57_1317384014.addTaint(taint);
        return var5C376539CC3DD936FD690BE20DF81E57_1317384014;
        case UNKNOWN_CA:
String var5B97A9C9D995332FB46C6723E0D785B0_78582746 =         "unknown_ca";
        var5B97A9C9D995332FB46C6723E0D785B0_78582746.addTaint(taint);
        return var5B97A9C9D995332FB46C6723E0D785B0_78582746;
        case ACCESS_DENIED:
String var7BBF33906D5DF1410FA8E9E6F7EE12E2_1678747818 =         "access_denied";
        var7BBF33906D5DF1410FA8E9E6F7EE12E2_1678747818.addTaint(taint);
        return var7BBF33906D5DF1410FA8E9E6F7EE12E2_1678747818;
        case DECODE_ERROR:
String var1EDB48D07C4C13DB77A72FECDC5AF1D6_1013010660 =         "decode_error";
        var1EDB48D07C4C13DB77A72FECDC5AF1D6_1013010660.addTaint(taint);
        return var1EDB48D07C4C13DB77A72FECDC5AF1D6_1013010660;
        case DECRYPT_ERROR:
String var5A0C358D2C0329910EAE67553B3D4AF0_35884680 =         "decrypt_error";
        var5A0C358D2C0329910EAE67553B3D4AF0_35884680.addTaint(taint);
        return var5A0C358D2C0329910EAE67553B3D4AF0_35884680;
        case EXPORT_RESTRICTION:
String var1C9721597687DC4F8B43B6B9FBF4F686_441983427 =         "export_restriction";
        var1C9721597687DC4F8B43B6B9FBF4F686_441983427.addTaint(taint);
        return var1C9721597687DC4F8B43B6B9FBF4F686_441983427;
        case PROTOCOL_VERSION:
String var2233FC8D14DBBA4E9092C7DD891837CA_889321990 =         "protocol_version";
        var2233FC8D14DBBA4E9092C7DD891837CA_889321990.addTaint(taint);
        return var2233FC8D14DBBA4E9092C7DD891837CA_889321990;
        case INSUFFICIENT_SECURITY:
String var533C0031CA49F089A0C5CE62C728C00F_1962557711 =         "insufficient_security";
        var533C0031CA49F089A0C5CE62C728C00F_1962557711.addTaint(taint);
        return var533C0031CA49F089A0C5CE62C728C00F_1962557711;
        case INTERNAL_ERROR:
String var03C0E14A6CDEB1F9AD961953D72D23F6_65649454 =         "internal_error";
        var03C0E14A6CDEB1F9AD961953D72D23F6_65649454.addTaint(taint);
        return var03C0E14A6CDEB1F9AD961953D72D23F6_65649454;
        case USER_CANCELED:
String var5A6941C3EE1EB3C229AEB710A2D3598B_1080265278 =         "user_canceled";
        var5A6941C3EE1EB3C229AEB710A2D3598B_1080265278.addTaint(taint);
        return var5A6941C3EE1EB3C229AEB710A2D3598B_1080265278;
        case NO_RENEGOTIATION:
String varEE238629FB375A59BD9F5B21CE2E346D_1653020383 =         "no_renegotiation";
        varEE238629FB375A59BD9F5B21CE2E346D_1653020383.addTaint(taint);
        return varEE238629FB375A59BD9F5B21CE2E346D_1653020383;
}String var540C13E9E156B687226421B24F2DF178_654815929 =         null;
        var540C13E9E156B687226421B24F2DF178_654815929.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_654815929;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.800 -0400", hash_original_method = "124BFC00035B67AF657D6336BEA07CC5", hash_generated_method = "F66A5570E365E06855770DF4106250BB")
    protected byte[] wrap() {
        byte[] res = recordProtocol.wrap(ContentType.ALERT, alert, 0, 2);
        byte[] var9B207167E5381C47682C6B4F58A623FB_781554493 = (res);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_283162872 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_283162872;
        // ---------- Original Method ----------
        //byte[] res = recordProtocol.wrap(ContentType.ALERT, alert, 0, 2);
        //return res;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.801 -0400", hash_original_method = "18F927F44CECC98A241CC5D3FE86DBCB", hash_generated_method = "F942F8E12961415D1B4D2C24C8077619")
    protected void shutdown() {
        alert[0] = 0;
        alert[1] = 0;
        recordProtocol = null;
        // ---------- Original Method ----------
        //alert[0] = 0;
        //alert[1] = 0;
        //recordProtocol = null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.802 -0400", hash_original_field = "3513D4E03C6A6F365A95813C38512575", hash_generated_field = "88CC5DEC91CF996FED438742736B69BB")

    protected static final byte WARNING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.802 -0400", hash_original_field = "AE5BDCB53B973F7868EFB1227008496F", hash_generated_field = "CCEA5AC62091E6116B18F3EA59AE853E")

    protected static final byte FATAL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.802 -0400", hash_original_field = "842E1F845AC8E74DAB46BB3CC1A06700", hash_generated_field = "4D382A79825E0CDC4E96B65BE265EA10")

    protected static final byte CLOSE_NOTIFY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.802 -0400", hash_original_field = "C8BE4822B3B64A38716A576C9BB18C84", hash_generated_field = "92373E3FE4B88ED6789D47F654449FC3")

    protected static final byte UNEXPECTED_MESSAGE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.802 -0400", hash_original_field = "C03DF1D9203DAFD45E1A456A31F90FC1", hash_generated_field = "8702A0A5CEAE06C380E312A5C79C01C4")

    protected static final byte BAD_RECORD_MAC = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.803 -0400", hash_original_field = "4A878C88A96F8A14283B7DA15EE79AD0", hash_generated_field = "65B9EDB1AF576FF07570398647CD2A9E")

    protected static final byte DECRYPTION_FAILED = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.803 -0400", hash_original_field = "EDDADF43F571DA3B6EB3CCD21A6FDA72", hash_generated_field = "9A7641B58F745E8923D0B4233FA92AF1")

    protected static final byte RECORD_OVERFLOW = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.803 -0400", hash_original_field = "71DD7CDDEDACC6AFC45E7F9A8F66C500", hash_generated_field = "092EE3D7EA73AEC1B4700C761C4B0353")

    protected static final byte DECOMPRESSION_FAILURE = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.803 -0400", hash_original_field = "C369F4950AFB49F5D697D4B9B30DB4BF", hash_generated_field = "2C628E03556DD2F5D16D91506A726D0C")

    protected static final byte HANDSHAKE_FAILURE = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.803 -0400", hash_original_field = "F0D5BB76DF2546D0FC8401135827AE83", hash_generated_field = "36BCBDFC2068CF580E2412D611602F1F")

    protected static final byte BAD_CERTIFICATE = 42;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.803 -0400", hash_original_field = "A45D663CB4A37AF64E4E7344D7B593CE", hash_generated_field = "09700AE0664736B5D2BABFEBAC521A94")

    protected static final byte UNSUPPORTED_CERTIFICATE = 43;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.803 -0400", hash_original_field = "A6DE4504FE04D2D4B10425BB654E98BB", hash_generated_field = "E19C5A51459B9774D9F51AF8C4E04E36")

    protected static final byte CERTIFICATE_REVOKED = 44;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.803 -0400", hash_original_field = "6C3751D47901C042D75920A6E6D33648", hash_generated_field = "704126822B1D40C68AB7E26FF4EAEE14")

    protected static final byte CERTIFICATE_EXPIRED = 45;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.803 -0400", hash_original_field = "9F9E7F60BC332BC7BCF2102283694342", hash_generated_field = "0A65A1AA69D5EA0CAC2714E644700970")

    protected static final byte CERTIFICATE_UNKNOWN = 46;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.803 -0400", hash_original_field = "D060CE9D95FB78025FBE155180F8B9CC", hash_generated_field = "0D9DAAE25899244AE24E2FDBC5F46F99")

    protected static final byte ILLEGAL_PARAMETER = 47;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.803 -0400", hash_original_field = "6D49E6D0D9B0D3D2214C20979AB10CD4", hash_generated_field = "5AE84A65E5F8B680690791B6AB551A34")

    protected static final byte UNKNOWN_CA = 48;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.804 -0400", hash_original_field = "E8D88590B36299F3A6DFB4FDE14E43A1", hash_generated_field = "2C64F9F1B77B75D7B601E263C9080DD1")

    protected static final byte ACCESS_DENIED = 49;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.804 -0400", hash_original_field = "633C2E932DF6700FEA1B153435B62BA8", hash_generated_field = "DA4B5892D3EB01FD2F89AEF938A8B5F2")

    protected static final byte DECODE_ERROR = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.804 -0400", hash_original_field = "128B693522050E91C2CA489B42460A58", hash_generated_field = "80900BCF720CCA813B84F65D17BD2FD0")

    protected static final byte DECRYPT_ERROR = 51;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.804 -0400", hash_original_field = "379C6B4C22105EC24C8A196F9C488992", hash_generated_field = "B38F8CCDFDE852E963780190F8B1E1C5")

    protected static final byte EXPORT_RESTRICTION = 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.804 -0400", hash_original_field = "DB968936BE38DF25CF9AC8C73BDBF8F5", hash_generated_field = "7E09044202CF3235342DA0C5C259D835")

    protected static final byte PROTOCOL_VERSION = 70;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.804 -0400", hash_original_field = "80CD4E13741FEC2B7A934B53BF94F22A", hash_generated_field = "78A173AAC24D902C801E280C9759592F")

    protected static final byte INSUFFICIENT_SECURITY = 71;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.804 -0400", hash_original_field = "03A579B0E2A074D2788EC8FCECF07118", hash_generated_field = "3F17FA7CA8CD6D0E5BBB1A6F4C9DAAA9")

    protected static final byte INTERNAL_ERROR = 80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.804 -0400", hash_original_field = "063CA0661A811C3AA3D44F933F61AECF", hash_generated_field = "7C1FC5845E884F2715B0A31C8DFF4F31")

    protected static final byte USER_CANCELED = 90;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.804 -0400", hash_original_field = "5171F71CDB8FA8976AE743E8FC88C78C", hash_generated_field = "47D9DE2507A92C29BDE55BF608AC91F8")

    protected static final byte NO_RENEGOTIATION = 100;
}

