package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class AlertProtocol {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.625 -0400", hash_original_field = "1F9BEE7140A219A96C922C99EEDE7B34", hash_generated_field = "123A71D4C41C48510467491232841B9E")

    private final byte[] alert = new byte[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.625 -0400", hash_original_field = "398E3ACF063793A09BD262C5C522B1DE", hash_generated_field = "C5076A69D1F8496ADA0329E39C7F9A64")

    private SSLRecordProtocol recordProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.625 -0400", hash_original_field = "9CC3434A2AF2B484DEC21C96204A5F7F", hash_generated_field = "586593FC273B16FB55D0AB5F86D137A2")

    private Logger.Stream logger = Logger.getStream("alert");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.626 -0400", hash_original_method = "E092E2209250C02F09C22B7C95E9AB91", hash_generated_method = "89DDAFEDBDC6600ADF822412966FC90D")
    protected  AlertProtocol() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.627 -0400", hash_original_method = "4783F18A2AEFB1BF115D21F8D4F4E6FF", hash_generated_method = "A9742893573022675C3B4131750B59FD")
    protected void setRecordProtocol(SSLRecordProtocol recordProtocol) {
        this.recordProtocol = recordProtocol;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.628 -0400", hash_original_method = "F413EBA539C7D7D57656EE1032BAAF7C", hash_generated_method = "AF86BF82B04F9EBA5ABF1162BBD1304F")
    protected void alert(byte level, byte description) {
        {
            logger.println("Alert.alert: "+level+" "+description);
        } 
        this.alert[0] = level;
        this.alert[1] = description;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.628 -0400", hash_original_method = "5D3BF0EC0666EBF860C9DC61576F480B", hash_generated_method = "E829819F802C7B8617C2ADCD8E752CBE")
    protected byte getDescriptionCode() {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1022690214 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1022690214;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.629 -0400", hash_original_method = "87AB9C19E1A7EED4E3BFCF946809E0DA", hash_generated_method = "A0DF94AF8223CEFC3C62A1275D1D3B6C")
    protected void setProcessed() {
        {
            logger.println("Alert.setProcessed");
        } 
        this.alert[0] = 0;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.629 -0400", hash_original_method = "45A2D96003EBC85CF21133EEF592859F", hash_generated_method = "63015832395A39DFF7E1E79947DB0488")
    protected boolean hasAlert() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2089065041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2089065041;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.630 -0400", hash_original_method = "7F9DD2505076B3CAC6687DC8D86BE7DC", hash_generated_method = "875C64833AD1DED646F8B2A188C52997")
    protected boolean isFatalAlert() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1816096502 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1816096502;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.632 -0400", hash_original_method = "4ED335C5479EFEAB65BE48D985C7B953", hash_generated_method = "EC54FD78E82494EB794701B3DA7F554D")
    protected String getAlertDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_1372583317 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1836148855 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1409167189 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2136720334 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1090216305 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1313320746 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_785631557 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_93684257 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_70688518 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_536984244 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_928650816 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1798799991 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1076326734 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2135163238 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_90693329 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_8834226 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_599925693 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1074463955 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1690547571 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_151821064 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1750467704 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1450960508 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_848539561 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_634452103 = null; 
        
        varB4EAC82CA7396A68D541C85D26508E83_1372583317 = "close_notify";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1836148855 = "unexpected_message";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1409167189 = "bad_record_mac";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_2136720334 = "decryption_failed";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1090216305 = "record_overflow";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1313320746 = "decompression_failure";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_785631557 = "handshake_failure";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_93684257 = "bad_certificate";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_70688518 = "unsupported_certificate";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_536984244 = "certificate_revoked";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_928650816 = "certificate_expired";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1798799991 = "certificate_unknown";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1076326734 = "illegal_parameter";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_2135163238 = "unknown_ca";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_90693329 = "access_denied";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_8834226 = "decode_error";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_599925693 = "decrypt_error";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1074463955 = "export_restriction";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1690547571 = "protocol_version";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_151821064 = "insufficient_security";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1750467704 = "internal_error";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1450960508 = "user_canceled";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_848539561 = "no_renegotiation";
        
        varB4EAC82CA7396A68D541C85D26508E83_634452103 = null;
        String varA7E53CE21691AB073D9660D615818899_1099401379; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_1372583317;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_1836148855;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_1409167189;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_2136720334;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_1090216305;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_1313320746;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_785631557;
                break;
            case 8: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_93684257;
                break;
            case 9: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_70688518;
                break;
            case 10: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_536984244;
                break;
            case 11: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_928650816;
                break;
            case 12: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_1798799991;
                break;
            case 13: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_1076326734;
                break;
            case 14: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_2135163238;
                break;
            case 15: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_90693329;
                break;
            case 16: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_8834226;
                break;
            case 17: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_599925693;
                break;
            case 18: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_1074463955;
                break;
            case 19: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_1690547571;
                break;
            case 20: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_151821064;
                break;
            case 21: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_1750467704;
                break;
            case 22: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_1450960508;
                break;
            case 23: 
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_848539561;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1099401379 = varB4EAC82CA7396A68D541C85D26508E83_634452103;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1099401379.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1099401379;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.633 -0400", hash_original_method = "124BFC00035B67AF657D6336BEA07CC5", hash_generated_method = "D104026F02BFEEF761B165A910654EBD")
    protected byte[] wrap() {
        byte[] res = recordProtocol.wrap(ContentType.ALERT, alert, 0, 2);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1284234434 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1284234434;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.633 -0400", hash_original_method = "18F927F44CECC98A241CC5D3FE86DBCB", hash_generated_method = "F942F8E12961415D1B4D2C24C8077619")
    protected void shutdown() {
        alert[0] = 0;
        alert[1] = 0;
        recordProtocol = null;
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "3513D4E03C6A6F365A95813C38512575", hash_generated_field = "88CC5DEC91CF996FED438742736B69BB")

    protected static final byte WARNING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "AE5BDCB53B973F7868EFB1227008496F", hash_generated_field = "CCEA5AC62091E6116B18F3EA59AE853E")

    protected static final byte FATAL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "842E1F845AC8E74DAB46BB3CC1A06700", hash_generated_field = "4D382A79825E0CDC4E96B65BE265EA10")

    protected static final byte CLOSE_NOTIFY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "C8BE4822B3B64A38716A576C9BB18C84", hash_generated_field = "92373E3FE4B88ED6789D47F654449FC3")

    protected static final byte UNEXPECTED_MESSAGE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "C03DF1D9203DAFD45E1A456A31F90FC1", hash_generated_field = "8702A0A5CEAE06C380E312A5C79C01C4")

    protected static final byte BAD_RECORD_MAC = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "4A878C88A96F8A14283B7DA15EE79AD0", hash_generated_field = "65B9EDB1AF576FF07570398647CD2A9E")

    protected static final byte DECRYPTION_FAILED = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "EDDADF43F571DA3B6EB3CCD21A6FDA72", hash_generated_field = "9A7641B58F745E8923D0B4233FA92AF1")

    protected static final byte RECORD_OVERFLOW = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "71DD7CDDEDACC6AFC45E7F9A8F66C500", hash_generated_field = "092EE3D7EA73AEC1B4700C761C4B0353")

    protected static final byte DECOMPRESSION_FAILURE = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "C369F4950AFB49F5D697D4B9B30DB4BF", hash_generated_field = "2C628E03556DD2F5D16D91506A726D0C")

    protected static final byte HANDSHAKE_FAILURE = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "F0D5BB76DF2546D0FC8401135827AE83", hash_generated_field = "36BCBDFC2068CF580E2412D611602F1F")

    protected static final byte BAD_CERTIFICATE = 42;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "A45D663CB4A37AF64E4E7344D7B593CE", hash_generated_field = "09700AE0664736B5D2BABFEBAC521A94")

    protected static final byte UNSUPPORTED_CERTIFICATE = 43;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "A6DE4504FE04D2D4B10425BB654E98BB", hash_generated_field = "E19C5A51459B9774D9F51AF8C4E04E36")

    protected static final byte CERTIFICATE_REVOKED = 44;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "6C3751D47901C042D75920A6E6D33648", hash_generated_field = "704126822B1D40C68AB7E26FF4EAEE14")

    protected static final byte CERTIFICATE_EXPIRED = 45;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "9F9E7F60BC332BC7BCF2102283694342", hash_generated_field = "0A65A1AA69D5EA0CAC2714E644700970")

    protected static final byte CERTIFICATE_UNKNOWN = 46;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "D060CE9D95FB78025FBE155180F8B9CC", hash_generated_field = "0D9DAAE25899244AE24E2FDBC5F46F99")

    protected static final byte ILLEGAL_PARAMETER = 47;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "6D49E6D0D9B0D3D2214C20979AB10CD4", hash_generated_field = "5AE84A65E5F8B680690791B6AB551A34")

    protected static final byte UNKNOWN_CA = 48;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "E8D88590B36299F3A6DFB4FDE14E43A1", hash_generated_field = "2C64F9F1B77B75D7B601E263C9080DD1")

    protected static final byte ACCESS_DENIED = 49;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "633C2E932DF6700FEA1B153435B62BA8", hash_generated_field = "DA4B5892D3EB01FD2F89AEF938A8B5F2")

    protected static final byte DECODE_ERROR = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "128B693522050E91C2CA489B42460A58", hash_generated_field = "80900BCF720CCA813B84F65D17BD2FD0")

    protected static final byte DECRYPT_ERROR = 51;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "379C6B4C22105EC24C8A196F9C488992", hash_generated_field = "B38F8CCDFDE852E963780190F8B1E1C5")

    protected static final byte EXPORT_RESTRICTION = 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "DB968936BE38DF25CF9AC8C73BDBF8F5", hash_generated_field = "7E09044202CF3235342DA0C5C259D835")

    protected static final byte PROTOCOL_VERSION = 70;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "80CD4E13741FEC2B7A934B53BF94F22A", hash_generated_field = "78A173AAC24D902C801E280C9759592F")

    protected static final byte INSUFFICIENT_SECURITY = 71;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "03A579B0E2A074D2788EC8FCECF07118", hash_generated_field = "3F17FA7CA8CD6D0E5BBB1A6F4C9DAAA9")

    protected static final byte INTERNAL_ERROR = 80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "063CA0661A811C3AA3D44F933F61AECF", hash_generated_field = "7C1FC5845E884F2715B0A31C8DFF4F31")

    protected static final byte USER_CANCELED = 90;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.634 -0400", hash_original_field = "5171F71CDB8FA8976AE743E8FC88C78C", hash_generated_field = "47D9DE2507A92C29BDE55BF608AC91F8")

    protected static final byte NO_RENEGOTIATION = 100;
}

