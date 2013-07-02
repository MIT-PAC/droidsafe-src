package org.apache.http.protocol;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public final class HTTP {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_method = "3A6FCD823D5B25065B735A0BBABE71E6", hash_generated_method = "A1337A31689D4A05956686C0F56DC7FB")
    private  HTTP() {
        
    }

    
    public static boolean isWhitespace(char ch) {
        return ch == SP || ch == HT || ch == CR || ch == LF;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_field = "D1DB1AAF41C8FB02A3D5931C721EDE94", hash_generated_field = "4B48828FAC4FE3DBFFFAEBA8A8C921C4")

    public static final int CR = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_field = "9943BD812FBA904ED604E00313173E53", hash_generated_field = "DBCCC25381D1593318771528439CD34E")

    public static final int LF = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_field = "82ED9A8F5FE791575647C16DB740CA70", hash_generated_field = "8C31871A8309CB160AA82B7C23210018")

    public static final int SP = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_field = "6CE8E23BABB6F0678D76660D582F8775", hash_generated_field = "73DE634A37CDD97EAD750FBA8C4C9FBC")

    public static final int HT = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_field = "51C06FE7252C8D8BA07D5D6FE8FF809F", hash_generated_field = "DCFD2D7A81DCE26624D261634049D282")

    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_field = "6200562464B464F7007C908633ED22C3", hash_generated_field = "C873F93E350601E9BA4876A9082000C0")

    public static final String CONTENT_LEN  = "Content-Length";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_field = "36D68E3EACB02EC128FAE7879CEFBC4E", hash_generated_field = "F0FB0CC8338BC684D174D37138E71AF4")

    public static final String CONTENT_TYPE = "Content-Type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_field = "C23A2270AD73BFF77CFB0FD56A98E770", hash_generated_field = "D94FB51F80F2B147EA4680CE432C1F0C")

    public static final String CONTENT_ENCODING = "Content-Encoding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_field = "86961B3387C781D8DB066AEFC3D84865", hash_generated_field = "E8579121D1EEE88EB5D1CF19E8603FAA")

    public static final String EXPECT_DIRECTIVE = "Expect";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_field = "BA569144AAAA6D21047EF5A7ED067500", hash_generated_field = "0B8C287D2005A31833DE791D61201060")

    public static final String CONN_DIRECTIVE = "Connection";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_field = "425948BD2CF4D72257841147871DB3D8", hash_generated_field = "B1342B7FA4AD6A351ECF0FFB5F118EF2")

    public static final String TARGET_HOST = "Host";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_field = "92197B5B51AB023E23AD914EBC00C58B", hash_generated_field = "E2B32A00DC1ECEDFED5285C80EA77905")

    public static final String USER_AGENT = "User-Agent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_field = "E10CC5B03780536C20A777EA76C9DC1B", hash_generated_field = "DE28CCA6101D868C19F7866E0E4CF84A")

    public static final String DATE_HEADER = "Date";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_field = "D6247E4B20214A0614EE12ABE573559F", hash_generated_field = "888CA02569744C2DDF961A4D613EEEDE")

    public static final String SERVER_HEADER = "Server";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_field = "E970A414295BA582317CBE7EECF8E96E", hash_generated_field = "2F1A29638B2D0E29C2FE55A6F7179955")

    public static final String EXPECT_CONTINUE = "100-continue";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.571 -0400", hash_original_field = "4DB823DF062B19060D17F559AACB5631", hash_generated_field = "6DC990621E1FEBEF4641A3A13BCCD60A")

    public static final String CONN_CLOSE = "Close";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.572 -0400", hash_original_field = "69A4875DED515B209B78BC5AD559CBB1", hash_generated_field = "CC47465F6C28D40E3A32A53EEC662014")

    public static final String CONN_KEEP_ALIVE = "Keep-Alive";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.572 -0400", hash_original_field = "2B90D62FD0F266BDB52A07B100498BFB", hash_generated_field = "7698A1C415B04EFDB79A05219636C1E7")

    public static final String CHUNK_CODING = "chunked";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.572 -0400", hash_original_field = "5B6BF08C26935E8FAA81C65FBB764178", hash_generated_field = "72080EB6EE7DF12980F670A096811F52")

    public static final String IDENTITY_CODING = "identity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.572 -0400", hash_original_field = "923519EE0F5F6D2A4432D632B72D3636", hash_generated_field = "059F3081BD79133B19DA92D71B903D4B")

    public static final String UTF_8 = "UTF-8";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.572 -0400", hash_original_field = "EE694B7D03608A3D6DED57D0864C1D7D", hash_generated_field = "37AEDC72537277B8C7D6E458F0C0A8AC")

    public static final String UTF_16 = "UTF-16";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.572 -0400", hash_original_field = "3366608D595FEC4D1002965F1D6B7A40", hash_generated_field = "6E4160004BBA062156F08F5FA5E24E91")

    public static final String US_ASCII = "US-ASCII";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.572 -0400", hash_original_field = "A3D1551D7DC0B3ACC4B68F302D46154C", hash_generated_field = "E3FF2ABE49D9B0E6D68B9CE78330A0E0")

    public static final String ASCII = "ASCII";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.572 -0400", hash_original_field = "A2E9B79C762E69B7D7709118574867B1", hash_generated_field = "C54DD200E0A99AF152F5F6AA68726A31")

    public static final String ISO_8859_1 = "ISO-8859-1";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.572 -0400", hash_original_field = "EEEE32E8B067BE040A30ABB0872D7DDB", hash_generated_field = "0B189A530E87CE08F47FE84B87D301D4")

    public static final String DEFAULT_CONTENT_CHARSET = ISO_8859_1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.572 -0400", hash_original_field = "58C8EB111F063ECEBCC9E8C85B46D63E", hash_generated_field = "4DAD949FEE540AB1667F5B541534AB37")

    public static final String DEFAULT_PROTOCOL_CHARSET = US_ASCII;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.572 -0400", hash_original_field = "C5817DA5FCBF95A1E373BF07B35FB947", hash_generated_field = "1CB198EE1ACA6C0EBAFB3A73F020BC6B")

    public final static String OCTET_STREAM_TYPE = "application/octet-stream";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.572 -0400", hash_original_field = "4C4DD93BE59145BDC8AF88CC49FE6ABD", hash_generated_field = "A701F6EF1312597F444CFD473F9B1D59")

    public final static String PLAIN_TEXT_TYPE = "text/plain";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.572 -0400", hash_original_field = "9C9446FE6E03E5C8A06F405979149ABE", hash_generated_field = "38C97344F99EEB0BB029FDDD6DDE4624")

    public final static String CHARSET_PARAM = "; charset=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.572 -0400", hash_original_field = "C0547CB3AF8EF22865C21DE9B8EDA436", hash_generated_field = "D2FDB251E5ED6DA906DD06661166E627")

    public final static String DEFAULT_CONTENT_TYPE = OCTET_STREAM_TYPE;
}

