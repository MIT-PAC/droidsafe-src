package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class UUSInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.954 -0500", hash_original_field = "CCDF853A32176C9104DB4EBAC8F1E74F", hash_generated_field = "3983F864611CCB867386DB1839FE0B09")

    public static final int UUS_TYPE1_IMPLICIT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.957 -0500", hash_original_field = "9C2FDDC1C69CB4910874C8D8326F2D69", hash_generated_field = "FAD508A9A7D31C17562DED8BFAB32088")

    public static final int UUS_TYPE1_REQUIRED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.959 -0500", hash_original_field = "06E22F0DDD60687FBE4E9814F081876B", hash_generated_field = "CE2B184DA5D4B2CD7E834AA2A3E12C48")

    public static final int UUS_TYPE1_NOT_REQUIRED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.962 -0500", hash_original_field = "98C953C05DD81B257FEC46D78080AF4B", hash_generated_field = "1DC149DDCA482066A8EC372987B67FDA")

    public static final int UUS_TYPE2_REQUIRED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.965 -0500", hash_original_field = "DAF2FCE248B3B853DC50EBBF953E8A98", hash_generated_field = "8C0FFFE0C7E7C3E466B809DB5318A767")

    public static final int UUS_TYPE2_NOT_REQUIRED = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.967 -0500", hash_original_field = "A1D5E723B5FB838EB9B7EB6E9755ED02", hash_generated_field = "E637DF924B499F0A5A9552D73DCC3BF8")

    public static final int UUS_TYPE3_REQUIRED = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.969 -0500", hash_original_field = "8E1C8A66BC1294A973641F205578C90A", hash_generated_field = "300DC9F4DB53936D99CA1085B4439E0A")

    public static final int UUS_TYPE3_NOT_REQUIRED = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.972 -0500", hash_original_field = "CD9CF2937D7255EB6EA2DA1603B3CC6D", hash_generated_field = "1767A71831605B6531E9CA775C4CA828")

    public static final int UUS_DCS_USP = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.974 -0500", hash_original_field = "825B936A00D62B8FBD70BFA0138A781C", hash_generated_field = "6A303DADDDE9F897732FE7C01035A9A1")

    public static final int UUS_DCS_OSIHLP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.977 -0500", hash_original_field = "E40163B300159485714E759DDDB279BB", hash_generated_field = "354B85ACD6E6F7C0AE17D82F278E3846")

    public static final int UUS_DCS_X244 = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.979 -0500", hash_original_field = "3F062921E88628F04CEDB47ADABC7BFF", hash_generated_field = "FE0CE28FD511046EE4CB7B8DF822E41F")

    public static final int UUS_DCS_RMCF = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.981 -0500", hash_original_field = "460FB0A43D62187A58CE827F1FBD122D", hash_generated_field = "0B1CFE733285C4CF5B33A020E8FDD6A1")

    public static final int UUS_DCS_IA5c = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.984 -0500", hash_original_field = "BC78B4F55DBB575FA5D646387B293F4A", hash_generated_field = "4CB8FCE222D78BC8CC8753B1C94AAAB8")

    private int uusType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.986 -0500", hash_original_field = "12EA916AF0C88152EE4DB1701186F5B1", hash_generated_field = "1C3D29BEA4B52640EBC9D188A35AAC03")

    private int uusDcs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.988 -0500", hash_original_field = "ACF5F039B0F33198C666A929FF3ED4DC", hash_generated_field = "035AD2D1ECBC3BDA97FC57645D05DB05")

    private byte[] uusData;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.992 -0500", hash_original_method = "934109F2717BDFE423352F8C63ADD428", hash_generated_method = "0814DDBBAB7C462BF82DB0C74725D5EF")
    
public UUSInfo() {
        this.uusType = UUS_TYPE1_IMPLICIT;
        this.uusDcs = UUS_DCS_IA5c;
        this.uusData = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.995 -0500", hash_original_method = "67CE668A0F9BB2CD8D45CC92B1E7FAE2", hash_generated_method = "B7209EB71A1F41C9903EB96099DE5061")
    
public UUSInfo(int uusType, int uusDcs, byte[] uusData) {
        this.uusType = uusType;
        this.uusDcs = uusDcs;
        this.uusData = uusData;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.998 -0500", hash_original_method = "352357FC22D874D178D2C62527C60010", hash_generated_method = "D8A68906E0A1B676D09C265ADB1341BD")
    
public int getDcs() {
        return uusDcs;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.000 -0500", hash_original_method = "304C29E73AF67DC85E7B439D2558394F", hash_generated_method = "2E4B6E49C4DECA1DBFE44A039162B067")
    
public void setDcs(int uusDcs) {
        this.uusDcs = uusDcs;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.002 -0500", hash_original_method = "C3F90AEC24B57BCB14BA37794741B56A", hash_generated_method = "3DC43089F580225612164102460EA340")
    
public int getType() {
        return uusType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.005 -0500", hash_original_method = "4FF18D0C69655C8ABC948EB5DB465A11", hash_generated_method = "6CCC2AB891B0484EDAB9085E4F1EA448")
    
public void setType(int uusType) {
        this.uusType = uusType;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.007 -0500", hash_original_method = "CBC9083E31E276860957A8B7835786FF", hash_generated_method = "92D8CDF2DC5F5446A34943FEE234D686")
    
public byte[] getUserData() {
        return uusData;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.009 -0500", hash_original_method = "E6220F4E83328DF111D0B2120F7A66C4", hash_generated_method = "7C556D060B735CB5AF307B62EED7AB3B")
    
public void setUserData(byte[] uusData) {
        this.uusData = uusData;
    }
}

