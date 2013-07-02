package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class UUSInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.041 -0400", hash_original_field = "6C451461439D1D1511468C6A6A5AB661", hash_generated_field = "4CB8FCE222D78BC8CC8753B1C94AAAB8")

    private int uusType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.041 -0400", hash_original_field = "FB280BB54367BD3E895E9F6CFFC39695", hash_generated_field = "1C3D29BEA4B52640EBC9D188A35AAC03")

    private int uusDcs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.041 -0400", hash_original_field = "B320C3EA100DC45335CD66ADEBC42630", hash_generated_field = "035AD2D1ECBC3BDA97FC57645D05DB05")

    private byte[] uusData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.042 -0400", hash_original_method = "934109F2717BDFE423352F8C63ADD428", hash_generated_method = "70C59DBD978ED83225181802393CEE38")
    public  UUSInfo() {
        this.uusType = UUS_TYPE1_IMPLICIT;
        this.uusDcs = UUS_DCS_IA5c;
        this.uusData = null;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.042 -0400", hash_original_method = "67CE668A0F9BB2CD8D45CC92B1E7FAE2", hash_generated_method = "6E9C19627AE86F5A32AE3D25B0AB7B30")
    public  UUSInfo(int uusType, int uusDcs, byte[] uusData) {
        this.uusType = uusType;
        this.uusDcs = uusDcs;
        this.uusData = uusData;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.042 -0400", hash_original_method = "352357FC22D874D178D2C62527C60010", hash_generated_method = "D3EE846A0ADEEBADFCFF83905D35803D")
    public int getDcs() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1135269527 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1135269527;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.042 -0400", hash_original_method = "304C29E73AF67DC85E7B439D2558394F", hash_generated_method = "94E5F21EB525F1888281AA89A1F2FFDB")
    public void setDcs(int uusDcs) {
        this.uusDcs = uusDcs;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.042 -0400", hash_original_method = "C3F90AEC24B57BCB14BA37794741B56A", hash_generated_method = "403083E5D9E9FECC144F616D3F5E1285")
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1765114376 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1765114376;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.043 -0400", hash_original_method = "4FF18D0C69655C8ABC948EB5DB465A11", hash_generated_method = "3FE8B407493C90F081206001F0842ACB")
    public void setType(int uusType) {
        this.uusType = uusType;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.043 -0400", hash_original_method = "CBC9083E31E276860957A8B7835786FF", hash_generated_method = "6D3A5A8D799B03D322B7C93E68A090F2")
    public byte[] getUserData() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1374807648 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1374807648;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.043 -0400", hash_original_method = "E6220F4E83328DF111D0B2120F7A66C4", hash_generated_method = "E70042857A3CF2E987698B8992450A83")
    public void setUserData(byte[] uusData) {
        this.uusData = uusData;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.043 -0400", hash_original_field = "E71CB7CE2E92A6B05AE5022CC24B9EF9", hash_generated_field = "3983F864611CCB867386DB1839FE0B09")

    public static final int UUS_TYPE1_IMPLICIT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.043 -0400", hash_original_field = "A0BFBAC1212ADAB65F43D8F2CC5BADC0", hash_generated_field = "FAD508A9A7D31C17562DED8BFAB32088")

    public static final int UUS_TYPE1_REQUIRED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.043 -0400", hash_original_field = "CFB144A50B1567D20F5D285B6B9F2279", hash_generated_field = "CE2B184DA5D4B2CD7E834AA2A3E12C48")

    public static final int UUS_TYPE1_NOT_REQUIRED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.043 -0400", hash_original_field = "E9FA2B904B0CABA61A722CC6A6A50A45", hash_generated_field = "1DC149DDCA482066A8EC372987B67FDA")

    public static final int UUS_TYPE2_REQUIRED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.043 -0400", hash_original_field = "CA4832C746CAE2E3F010086A3CDC5AA8", hash_generated_field = "8C0FFFE0C7E7C3E466B809DB5318A767")

    public static final int UUS_TYPE2_NOT_REQUIRED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.043 -0400", hash_original_field = "7D46D9F5A69A72EB4FDFC3FE47FAF1AE", hash_generated_field = "E637DF924B499F0A5A9552D73DCC3BF8")

    public static final int UUS_TYPE3_REQUIRED = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.043 -0400", hash_original_field = "DCE776657AB7DC313AB6D3F3F55A2116", hash_generated_field = "300DC9F4DB53936D99CA1085B4439E0A")

    public static final int UUS_TYPE3_NOT_REQUIRED = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.043 -0400", hash_original_field = "E8C7A853103CCA21577E9306F3FC53F7", hash_generated_field = "1767A71831605B6531E9CA775C4CA828")

    public static final int UUS_DCS_USP = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.043 -0400", hash_original_field = "BB0F17F6D5D9A917BA4099D867E4511D", hash_generated_field = "6A303DADDDE9F897732FE7C01035A9A1")

    public static final int UUS_DCS_OSIHLP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.043 -0400", hash_original_field = "134283AE62DE269EAF2979333DD52E30", hash_generated_field = "354B85ACD6E6F7C0AE17D82F278E3846")

    public static final int UUS_DCS_X244 = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.043 -0400", hash_original_field = "79B9BD469CF076F911AF12EF4B6F8DB1", hash_generated_field = "FE0CE28FD511046EE4CB7B8DF822E41F")

    public static final int UUS_DCS_RMCF = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.043 -0400", hash_original_field = "FD449A3EF9B0485AED43800E1CB0968D", hash_generated_field = "0B1CFE733285C4CF5B33A020E8FDD6A1")

    public static final int UUS_DCS_IA5c = 4;
}

