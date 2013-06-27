package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AlertProtocol {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.239 -0400", hash_original_field = "1F9BEE7140A219A96C922C99EEDE7B34", hash_generated_field = "492A949E326EEC664C5F22B4FFC3E8B1")

    private byte[] alert = new byte[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.239 -0400", hash_original_field = "398E3ACF063793A09BD262C5C522B1DE", hash_generated_field = "C5076A69D1F8496ADA0329E39C7F9A64")

    private SSLRecordProtocol recordProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.239 -0400", hash_original_field = "9CC3434A2AF2B484DEC21C96204A5F7F", hash_generated_field = "586593FC273B16FB55D0AB5F86D137A2")

    private Logger.Stream logger = Logger.getStream("alert");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.245 -0400", hash_original_method = "E092E2209250C02F09C22B7C95E9AB91", hash_generated_method = "89DDAFEDBDC6600ADF822412966FC90D")
    protected  AlertProtocol() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.251 -0400", hash_original_method = "4783F18A2AEFB1BF115D21F8D4F4E6FF", hash_generated_method = "A9742893573022675C3B4131750B59FD")
    protected void setRecordProtocol(SSLRecordProtocol recordProtocol) {
        this.recordProtocol = recordProtocol;
        // ---------- Original Method ----------
        //this.recordProtocol = recordProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.251 -0400", hash_original_method = "F413EBA539C7D7D57656EE1032BAAF7C", hash_generated_method = "AF86BF82B04F9EBA5ABF1162BBD1304F")
    protected void alert(byte level, byte description) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.252 -0400", hash_original_method = "5D3BF0EC0666EBF860C9DC61576F480B", hash_generated_method = "FBEB026676C22CE3A4B8314C16E37B6A")
    protected byte getDescriptionCode() {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_975624375 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_975624375;
        // ---------- Original Method ----------
        //return (alert[0] != 0) ? alert[1] : -100;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.252 -0400", hash_original_method = "87AB9C19E1A7EED4E3BFCF946809E0DA", hash_generated_method = "A0DF94AF8223CEFC3C62A1275D1D3B6C")
    protected void setProcessed() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.252 -0400", hash_original_method = "45A2D96003EBC85CF21133EEF592859F", hash_generated_method = "69E5081DAC8F9092738A4D55F494385A")
    protected boolean hasAlert() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_216053750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_216053750;
        // ---------- Original Method ----------
        //return (alert[0] != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.252 -0400", hash_original_method = "7F9DD2505076B3CAC6687DC8D86BE7DC", hash_generated_method = "F8853E4CD6897FAC122DBB869B4C4A2D")
    protected boolean isFatalAlert() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1434633646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1434633646;
        // ---------- Original Method ----------
        //return (alert[0] == 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.258 -0400", hash_original_method = "4ED335C5479EFEAB65BE48D985C7B953", hash_generated_method = "0781991B78F10B0C012FA411DFF55183")
    protected String getAlertDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_778832962 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_262004884 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_48833981 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_672498296 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1354021423 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_574402645 = null; //Variable for return #6
        String varB4EAC82CA7396A68D541C85D26508E83_562121293 = null; //Variable for return #7
        String varB4EAC82CA7396A68D541C85D26508E83_593154806 = null; //Variable for return #8
        String varB4EAC82CA7396A68D541C85D26508E83_246241172 = null; //Variable for return #9
        String varB4EAC82CA7396A68D541C85D26508E83_2017152810 = null; //Variable for return #10
        String varB4EAC82CA7396A68D541C85D26508E83_1700917250 = null; //Variable for return #11
        String varB4EAC82CA7396A68D541C85D26508E83_1483639534 = null; //Variable for return #12
        String varB4EAC82CA7396A68D541C85D26508E83_758787558 = null; //Variable for return #13
        String varB4EAC82CA7396A68D541C85D26508E83_1505847022 = null; //Variable for return #14
        String varB4EAC82CA7396A68D541C85D26508E83_77597508 = null; //Variable for return #15
        String varB4EAC82CA7396A68D541C85D26508E83_1815068427 = null; //Variable for return #16
        String varB4EAC82CA7396A68D541C85D26508E83_492980483 = null; //Variable for return #17
        String varB4EAC82CA7396A68D541C85D26508E83_1089192587 = null; //Variable for return #18
        String varB4EAC82CA7396A68D541C85D26508E83_410104895 = null; //Variable for return #19
        String varB4EAC82CA7396A68D541C85D26508E83_2069746513 = null; //Variable for return #20
        String varB4EAC82CA7396A68D541C85D26508E83_972934657 = null; //Variable for return #21
        String varB4EAC82CA7396A68D541C85D26508E83_1751486681 = null; //Variable for return #22
        String varB4EAC82CA7396A68D541C85D26508E83_153262694 = null; //Variable for return #23
        String varB4EAC82CA7396A68D541C85D26508E83_1026618435 = null; //Variable for return #24
        //Begin case CLOSE_NOTIFY 
        varB4EAC82CA7396A68D541C85D26508E83_778832962 = "close_notify";
        //End case CLOSE_NOTIFY 
        //Begin case UNEXPECTED_MESSAGE 
        varB4EAC82CA7396A68D541C85D26508E83_262004884 = "unexpected_message";
        //End case UNEXPECTED_MESSAGE 
        //Begin case BAD_RECORD_MAC 
        varB4EAC82CA7396A68D541C85D26508E83_48833981 = "bad_record_mac";
        //End case BAD_RECORD_MAC 
        //Begin case DECRYPTION_FAILED 
        varB4EAC82CA7396A68D541C85D26508E83_672498296 = "decryption_failed";
        //End case DECRYPTION_FAILED 
        //Begin case RECORD_OVERFLOW 
        varB4EAC82CA7396A68D541C85D26508E83_1354021423 = "record_overflow";
        //End case RECORD_OVERFLOW 
        //Begin case DECOMPRESSION_FAILURE 
        varB4EAC82CA7396A68D541C85D26508E83_574402645 = "decompression_failure";
        //End case DECOMPRESSION_FAILURE 
        //Begin case HANDSHAKE_FAILURE 
        varB4EAC82CA7396A68D541C85D26508E83_562121293 = "handshake_failure";
        //End case HANDSHAKE_FAILURE 
        //Begin case BAD_CERTIFICATE 
        varB4EAC82CA7396A68D541C85D26508E83_593154806 = "bad_certificate";
        //End case BAD_CERTIFICATE 
        //Begin case UNSUPPORTED_CERTIFICATE 
        varB4EAC82CA7396A68D541C85D26508E83_246241172 = "unsupported_certificate";
        //End case UNSUPPORTED_CERTIFICATE 
        //Begin case CERTIFICATE_REVOKED 
        varB4EAC82CA7396A68D541C85D26508E83_2017152810 = "certificate_revoked";
        //End case CERTIFICATE_REVOKED 
        //Begin case CERTIFICATE_EXPIRED 
        varB4EAC82CA7396A68D541C85D26508E83_1700917250 = "certificate_expired";
        //End case CERTIFICATE_EXPIRED 
        //Begin case CERTIFICATE_UNKNOWN 
        varB4EAC82CA7396A68D541C85D26508E83_1483639534 = "certificate_unknown";
        //End case CERTIFICATE_UNKNOWN 
        //Begin case ILLEGAL_PARAMETER 
        varB4EAC82CA7396A68D541C85D26508E83_758787558 = "illegal_parameter";
        //End case ILLEGAL_PARAMETER 
        //Begin case UNKNOWN_CA 
        varB4EAC82CA7396A68D541C85D26508E83_1505847022 = "unknown_ca";
        //End case UNKNOWN_CA 
        //Begin case ACCESS_DENIED 
        varB4EAC82CA7396A68D541C85D26508E83_77597508 = "access_denied";
        //End case ACCESS_DENIED 
        //Begin case DECODE_ERROR 
        varB4EAC82CA7396A68D541C85D26508E83_1815068427 = "decode_error";
        //End case DECODE_ERROR 
        //Begin case DECRYPT_ERROR 
        varB4EAC82CA7396A68D541C85D26508E83_492980483 = "decrypt_error";
        //End case DECRYPT_ERROR 
        //Begin case EXPORT_RESTRICTION 
        varB4EAC82CA7396A68D541C85D26508E83_1089192587 = "export_restriction";
        //End case EXPORT_RESTRICTION 
        //Begin case PROTOCOL_VERSION 
        varB4EAC82CA7396A68D541C85D26508E83_410104895 = "protocol_version";
        //End case PROTOCOL_VERSION 
        //Begin case INSUFFICIENT_SECURITY 
        varB4EAC82CA7396A68D541C85D26508E83_2069746513 = "insufficient_security";
        //End case INSUFFICIENT_SECURITY 
        //Begin case INTERNAL_ERROR 
        varB4EAC82CA7396A68D541C85D26508E83_972934657 = "internal_error";
        //End case INTERNAL_ERROR 
        //Begin case USER_CANCELED 
        varB4EAC82CA7396A68D541C85D26508E83_1751486681 = "user_canceled";
        //End case USER_CANCELED 
        //Begin case NO_RENEGOTIATION 
        varB4EAC82CA7396A68D541C85D26508E83_153262694 = "no_renegotiation";
        //End case NO_RENEGOTIATION 
        varB4EAC82CA7396A68D541C85D26508E83_1026618435 = null;
        String varA7E53CE21691AB073D9660D615818899_1882459040; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_778832962;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_262004884;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_48833981;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_672498296;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_1354021423;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_574402645;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_562121293;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_593154806;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_246241172;
                break;
            case 10: //Assign result for return ordinal #10
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_2017152810;
                break;
            case 11: //Assign result for return ordinal #11
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_1700917250;
                break;
            case 12: //Assign result for return ordinal #12
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_1483639534;
                break;
            case 13: //Assign result for return ordinal #13
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_758787558;
                break;
            case 14: //Assign result for return ordinal #14
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_1505847022;
                break;
            case 15: //Assign result for return ordinal #15
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_77597508;
                break;
            case 16: //Assign result for return ordinal #16
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_1815068427;
                break;
            case 17: //Assign result for return ordinal #17
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_492980483;
                break;
            case 18: //Assign result for return ordinal #18
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_1089192587;
                break;
            case 19: //Assign result for return ordinal #19
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_410104895;
                break;
            case 20: //Assign result for return ordinal #20
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_2069746513;
                break;
            case 21: //Assign result for return ordinal #21
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_972934657;
                break;
            case 22: //Assign result for return ordinal #22
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_1751486681;
                break;
            case 23: //Assign result for return ordinal #23
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_153262694;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1882459040 = varB4EAC82CA7396A68D541C85D26508E83_1026618435;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1882459040.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1882459040;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.262 -0400", hash_original_method = "124BFC00035B67AF657D6336BEA07CC5", hash_generated_method = "690DC5944AC32DE84BFFA49B736CFD36")
    protected byte[] wrap() {
        byte[] res;
        res = recordProtocol.wrap(ContentType.ALERT, alert, 0, 2);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1060618543 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1060618543;
        // ---------- Original Method ----------
        //byte[] res = recordProtocol.wrap(ContentType.ALERT, alert, 0, 2);
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.262 -0400", hash_original_method = "18F927F44CECC98A241CC5D3FE86DBCB", hash_generated_method = "F942F8E12961415D1B4D2C24C8077619")
    protected void shutdown() {
        alert[0] = 0;
        alert[1] = 0;
        recordProtocol = null;
        // ---------- Original Method ----------
        //alert[0] = 0;
        //alert[1] = 0;
        //recordProtocol = null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.262 -0400", hash_original_field = "3513D4E03C6A6F365A95813C38512575", hash_generated_field = "81C119BF503575725BEAFF30CA309C76")

    protected static byte WARNING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.262 -0400", hash_original_field = "AE5BDCB53B973F7868EFB1227008496F", hash_generated_field = "BD0C7C9E79E19E1116408629A8F55AD6")

    protected static byte FATAL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.262 -0400", hash_original_field = "842E1F845AC8E74DAB46BB3CC1A06700", hash_generated_field = "88A76D30E1B41BED25C0C679E685B628")

    protected static byte CLOSE_NOTIFY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.262 -0400", hash_original_field = "C8BE4822B3B64A38716A576C9BB18C84", hash_generated_field = "B31E22C11DC5723FC4D447DA6D9708AA")

    protected static byte UNEXPECTED_MESSAGE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.262 -0400", hash_original_field = "C03DF1D9203DAFD45E1A456A31F90FC1", hash_generated_field = "070F4B11C6C27428F67770D213677CED")

    protected static byte BAD_RECORD_MAC = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.262 -0400", hash_original_field = "4A878C88A96F8A14283B7DA15EE79AD0", hash_generated_field = "1AB06FF7861E10F53E3FC7D639D6A030")

    protected static byte DECRYPTION_FAILED = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.262 -0400", hash_original_field = "EDDADF43F571DA3B6EB3CCD21A6FDA72", hash_generated_field = "CA1B9A575DC6D29B1CAA1D76FC08944D")

    protected static byte RECORD_OVERFLOW = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.263 -0400", hash_original_field = "71DD7CDDEDACC6AFC45E7F9A8F66C500", hash_generated_field = "55FFD80F25E589CD6393BA35369E2078")

    protected static byte DECOMPRESSION_FAILURE = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.263 -0400", hash_original_field = "C369F4950AFB49F5D697D4B9B30DB4BF", hash_generated_field = "E86E6B0C53D6571FDE74033BAACA7418")

    protected static byte HANDSHAKE_FAILURE = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.263 -0400", hash_original_field = "F0D5BB76DF2546D0FC8401135827AE83", hash_generated_field = "4E324B5CE4E384B31C5FE153E6AF104D")

    protected static byte BAD_CERTIFICATE = 42;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.266 -0400", hash_original_field = "A45D663CB4A37AF64E4E7344D7B593CE", hash_generated_field = "00EED8E1F1627ACBD685B561459073AE")

    protected static byte UNSUPPORTED_CERTIFICATE = 43;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.266 -0400", hash_original_field = "A6DE4504FE04D2D4B10425BB654E98BB", hash_generated_field = "936D3532ACB9A2134380B3E37EB3AA85")

    protected static byte CERTIFICATE_REVOKED = 44;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.266 -0400", hash_original_field = "6C3751D47901C042D75920A6E6D33648", hash_generated_field = "B375ABA7BF82D6CBB651176A94D9E151")

    protected static byte CERTIFICATE_EXPIRED = 45;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.266 -0400", hash_original_field = "9F9E7F60BC332BC7BCF2102283694342", hash_generated_field = "7C77718D0ADDC7FAA1C8950F297A81B0")

    protected static byte CERTIFICATE_UNKNOWN = 46;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.266 -0400", hash_original_field = "D060CE9D95FB78025FBE155180F8B9CC", hash_generated_field = "06E3CFFE22FCAA96122144AA21CC7AF6")

    protected static byte ILLEGAL_PARAMETER = 47;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.270 -0400", hash_original_field = "6D49E6D0D9B0D3D2214C20979AB10CD4", hash_generated_field = "9C47E6D3FD204471EAEE83FF565FA119")

    protected static byte UNKNOWN_CA = 48;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.270 -0400", hash_original_field = "E8D88590B36299F3A6DFB4FDE14E43A1", hash_generated_field = "1F14A4E8882E0D1265400101A895F272")

    protected static byte ACCESS_DENIED = 49;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.270 -0400", hash_original_field = "633C2E932DF6700FEA1B153435B62BA8", hash_generated_field = "E0C4D79529A235A300C5EAA26A31C021")

    protected static byte DECODE_ERROR = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.270 -0400", hash_original_field = "128B693522050E91C2CA489B42460A58", hash_generated_field = "23D2CA2F2F6FA60FEFFC2E17587BD8D1")

    protected static byte DECRYPT_ERROR = 51;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.270 -0400", hash_original_field = "379C6B4C22105EC24C8A196F9C488992", hash_generated_field = "DB0568AFE6047D95698A8310137FB3A9")

    protected static byte EXPORT_RESTRICTION = 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.270 -0400", hash_original_field = "DB968936BE38DF25CF9AC8C73BDBF8F5", hash_generated_field = "B1C989B62C697D5F42625D3FF0CF4402")

    protected static byte PROTOCOL_VERSION = 70;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.270 -0400", hash_original_field = "80CD4E13741FEC2B7A934B53BF94F22A", hash_generated_field = "C1F2FD7E1B38A34AA5669BB5F9D633DD")

    protected static byte INSUFFICIENT_SECURITY = 71;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.270 -0400", hash_original_field = "03A579B0E2A074D2788EC8FCECF07118", hash_generated_field = "EC6689EE2B186ABB6BD4A94FD165E54A")

    protected static byte INTERNAL_ERROR = 80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.270 -0400", hash_original_field = "063CA0661A811C3AA3D44F933F61AECF", hash_generated_field = "B0DAE2A034F794A6C044820FC4B272B8")

    protected static byte USER_CANCELED = 90;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.270 -0400", hash_original_field = "5171F71CDB8FA8976AE743E8FC88C78C", hash_generated_field = "81DAE8B324A7C621F6C48EEB559D41C9")

    protected static byte NO_RENEGOTIATION = 100;
}

