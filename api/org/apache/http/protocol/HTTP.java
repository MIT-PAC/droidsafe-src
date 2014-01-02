package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public final class HTTP {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.690 -0500", hash_original_method = "134212A674CF385E582642AFF649A905", hash_generated_method = "E308477FC9CABEB85C4755A08378A651")
    
public static boolean isWhitespace(char ch) {
        return ch == SP || ch == HT || ch == CR || ch == LF; 
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.610 -0500", hash_original_field = "827B2E55812199FEACACB1E9C37846C6", hash_generated_field = "4B48828FAC4FE3DBFFFAEBA8A8C921C4")


    public static final int CR = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.613 -0500", hash_original_field = "B49D7BCA303E83D5E6889B0D7C14B13F", hash_generated_field = "DBCCC25381D1593318771528439CD34E")

    public static final int LF = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.615 -0500", hash_original_field = "A28828A0B92B7CCEDA71A5B2AE8AE8F1", hash_generated_field = "8C31871A8309CB160AA82B7C23210018")

    public static final int SP = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.617 -0500", hash_original_field = "7C616B473E4C8E4367E2D7A3C253DDF4", hash_generated_field = "73DE634A37CDD97EAD750FBA8C4C9FBC")

    public static final int HT = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.620 -0500", hash_original_field = "683DFC7E7BA00A43D201F7E238E33F4B", hash_generated_field = "CD72CB4685B408B00CABB27031A6E67E")


    /** HTTP header definitions */ 
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.622 -0500", hash_original_field = "7EB3283A3DA44782F7C0F7D82F970F6F", hash_generated_field = "C873F93E350601E9BA4876A9082000C0")

    public static final String CONTENT_LEN  = "Content-Length";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.625 -0500", hash_original_field = "46364DAB064DC5AB4E14A25EF7C77722", hash_generated_field = "F0FB0CC8338BC684D174D37138E71AF4")

    public static final String CONTENT_TYPE = "Content-Type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.628 -0500", hash_original_field = "ED3F7B67193A1825AB248A53D9C4D42F", hash_generated_field = "D94FB51F80F2B147EA4680CE432C1F0C")

    public static final String CONTENT_ENCODING = "Content-Encoding";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.631 -0500", hash_original_field = "2A490AB509A41B7A8D98470AA5A84912", hash_generated_field = "E8579121D1EEE88EB5D1CF19E8603FAA")

    public static final String EXPECT_DIRECTIVE = "Expect";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.633 -0500", hash_original_field = "14410297368C2DE695CF4179DD04C85D", hash_generated_field = "0B8C287D2005A31833DE791D61201060")

    public static final String CONN_DIRECTIVE = "Connection";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.636 -0500", hash_original_field = "42E2857A87EE0D51532DFD1FDF4D62F6", hash_generated_field = "B1342B7FA4AD6A351ECF0FFB5F118EF2")

    public static final String TARGET_HOST = "Host";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.640 -0500", hash_original_field = "BC4203D8CE9B792041A4F855B1F6A4A3", hash_generated_field = "E2B32A00DC1ECEDFED5285C80EA77905")

    public static final String USER_AGENT = "User-Agent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.643 -0500", hash_original_field = "A60877960BCC71CABE0DB62C4C34A229", hash_generated_field = "DE28CCA6101D868C19F7866E0E4CF84A")

    public static final String DATE_HEADER = "Date";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.645 -0500", hash_original_field = "16F67FA43AF79A31A634AF7E701D5AF3", hash_generated_field = "888CA02569744C2DDF961A4D613EEEDE")

    public static final String SERVER_HEADER = "Server";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.648 -0500", hash_original_field = "597CF85895F35EB9121700CF37460088", hash_generated_field = "2F1A29638B2D0E29C2FE55A6F7179955")

    public static final String EXPECT_CONTINUE = "100-continue";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.650 -0500", hash_original_field = "1345F4EC2710CA29E98CA27CB2EFE96C", hash_generated_field = "6DC990621E1FEBEF4641A3A13BCCD60A")

    public static final String CONN_CLOSE = "Close";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.653 -0500", hash_original_field = "ED065862777B89FA1B2796CAAA22B81B", hash_generated_field = "CC47465F6C28D40E3A32A53EEC662014")

    public static final String CONN_KEEP_ALIVE = "Keep-Alive";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.656 -0500", hash_original_field = "4C7C4E92CA4CDF03CA684D4DFCA73F0F", hash_generated_field = "7698A1C415B04EFDB79A05219636C1E7")

    public static final String CHUNK_CODING = "chunked";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.658 -0500", hash_original_field = "B84614F1B6CA7A351CB142FF62477DE5", hash_generated_field = "72080EB6EE7DF12980F670A096811F52")

    public static final String IDENTITY_CODING = "identity";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.660 -0500", hash_original_field = "4C869B13BEF7E7EB87393F929DAAEF08", hash_generated_field = "059F3081BD79133B19DA92D71B903D4B")

    public static final String UTF_8 = "UTF-8";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.663 -0500", hash_original_field = "F937D08544423510C929202A06C5E40C", hash_generated_field = "37AEDC72537277B8C7D6E458F0C0A8AC")

    public static final String UTF_16 = "UTF-16";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.665 -0500", hash_original_field = "4BA4D73EFE3E4386F492E6E345E19D10", hash_generated_field = "6E4160004BBA062156F08F5FA5E24E91")

    public static final String US_ASCII = "US-ASCII";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.668 -0500", hash_original_field = "394EEB836B539DF1CB4EC3F596C7BAFE", hash_generated_field = "E3FF2ABE49D9B0E6D68B9CE78330A0E0")

    public static final String ASCII = "ASCII";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.672 -0500", hash_original_field = "9B4241CF8375027A3760457C90F1C043", hash_generated_field = "C54DD200E0A99AF152F5F6AA68726A31")

    public static final String ISO_8859_1 = "ISO-8859-1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.675 -0500", hash_original_field = "80F00EEAB510ACD218BBCD92ADFCF7C8", hash_generated_field = "0B189A530E87CE08F47FE84B87D301D4")

    public static final String DEFAULT_CONTENT_CHARSET = ISO_8859_1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.677 -0500", hash_original_field = "E5E4987AC6CB51C1736EE888F6D513E1", hash_generated_field = "4DAD949FEE540AB1667F5B541534AB37")

    public static final String DEFAULT_PROTOCOL_CHARSET = US_ASCII;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.680 -0500", hash_original_field = "072BC0913DC612375B064B1872E7FECA", hash_generated_field = "1CB198EE1ACA6C0EBAFB3A73F020BC6B")

    public final static String OCTET_STREAM_TYPE = "application/octet-stream";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.682 -0500", hash_original_field = "CF4F3F90E35325C80A7D4177EE02F8D3", hash_generated_field = "A701F6EF1312597F444CFD473F9B1D59")

    public final static String PLAIN_TEXT_TYPE = "text/plain";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.685 -0500", hash_original_field = "0D4F333C65C7E7E0D1EA7A2FBA11A129", hash_generated_field = "38C97344F99EEB0BB029FDDD6DDE4624")

    public final static String CHARSET_PARAM = "; charset=";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.687 -0500", hash_original_field = "6EBAFB707ABA4DCB92E2BD199F559B91", hash_generated_field = "D2FDB251E5ED6DA906DD06661166E627")

    public final static String DEFAULT_CONTENT_TYPE = OCTET_STREAM_TYPE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.693 -0500", hash_original_method = "3A6FCD823D5B25065B735A0BBABE71E6", hash_generated_method = "451E5D2DCE9FF602E8836599E91046BA")
    
private HTTP() {
    }
}

