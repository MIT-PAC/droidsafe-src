package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;

import org.apache.http.HeaderElement;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

public final class Headers {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.310 -0500", hash_original_field = "7E068549854EC7B659EE876AD356FB52", hash_generated_field = "26F6F5D2EF35FA86B8698978CE2FD0C9")

    private static final String LOGTAG = "Http";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.313 -0500", hash_original_field = "86386496D2D591C474296C537ADBFF33", hash_generated_field = "55F69EE709F5ABE00C006F3D126FA457")

    /**
     * indicate HTTP 1.0 connection close after the response
     */
    public final static int CONN_CLOSE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.315 -0500", hash_original_field = "4534E0146828170F73138FD321D91E6D", hash_generated_field = "759A5671D76D24A450C80BB03C36839E")

    public final static int CONN_KEEP_ALIVE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.318 -0500", hash_original_field = "88D761AB21641C8B8D54438CD8DDD308", hash_generated_field = "C649382C9AB58722060DB5AB1682F97D")

    public final static int NO_CONN_TYPE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.320 -0500", hash_original_field = "C701E1EDB764BB1C3EAB54F4AB7AA70A", hash_generated_field = "2FEECAE3BB793FDC0977A48B3934C1D7")

    public final static long NO_TRANSFER_ENCODING = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.323 -0500", hash_original_field = "57BD8D3CD8A8B829FEEF12F98DEAF583", hash_generated_field = "72BAC6DB337B3CBFE2C5510E69BA9F9E")

    public final static long NO_CONTENT_LENGTH = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.325 -0500", hash_original_field = "DB21D41A077D07AEA7B7BB325E5CED44", hash_generated_field = "81C0E7C8A5CDB2B0264004F8265CD667")

    public final static String TRANSFER_ENCODING = "transfer-encoding";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.327 -0500", hash_original_field = "51230DEA7AA93A65A1B59AFCAFDEA0C4", hash_generated_field = "BBF93059A8ED698C0E55DF623F564D01")

    public final static String CONTENT_LEN = "content-length";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.329 -0500", hash_original_field = "8CC4B91D16E4C3BAC489D34D5D74C806", hash_generated_field = "2216C6197D13B1CBCAB1FA436EA38B66")

    public final static String CONTENT_TYPE = "content-type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.331 -0500", hash_original_field = "BE91F4548A9B99850083CFABD59B9AA8", hash_generated_field = "AC7AEC23F2048D9EE3693A58E4F60F88")

    public final static String CONTENT_ENCODING = "content-encoding";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.333 -0500", hash_original_field = "8D3F1FD2B1BC9B5A95624A4F82628006", hash_generated_field = "6192728184263C4E2E5B9E3FD278B74C")

    public final static String CONN_DIRECTIVE = "connection";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.336 -0500", hash_original_field = "5CF73D40BF32B2DD7F4903DF8917A38F", hash_generated_field = "077B87B3238F3F1EF051B3253D47554A")

    public final static String LOCATION = "location";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.339 -0500", hash_original_field = "8AA67EABCD4EFECA6ECF12B31EC540B8", hash_generated_field = "6B767E1F6F824B91FB0417CE6C9A3AF6")

    public final static String PROXY_CONNECTION = "proxy-connection";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.341 -0500", hash_original_field = "E971B76EA22E18CADE6CA7C98C1F84B6", hash_generated_field = "2D2256243B60098BAF60048C051D5E97")

    public final static String WWW_AUTHENTICATE = "www-authenticate";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.343 -0500", hash_original_field = "E57F70186B482867149986B7708BFED4", hash_generated_field = "8E642334C5E492A104D3B96159F6D444")

    public final static String PROXY_AUTHENTICATE = "proxy-authenticate";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.345 -0500", hash_original_field = "1738BF20981DA72AAAC5F73A10CCAE95", hash_generated_field = "77979705F62BBE313F3A54727E5E587F")

    public final static String CONTENT_DISPOSITION = "content-disposition";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.348 -0500", hash_original_field = "CAC3933C0593454F7DEEA1E8914977A8", hash_generated_field = "4F1D8FC17C7B449521008CC2D5D5ED06")

    public final static String ACCEPT_RANGES = "accept-ranges";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.350 -0500", hash_original_field = "002E36B52DB598DD795E59C99EE81CCD", hash_generated_field = "801AFDC8DD450D337B40F6B07B2264AB")

    public final static String EXPIRES = "expires";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.352 -0500", hash_original_field = "D5398E5C8FA772F15E2F7E8CCCE4B6AD", hash_generated_field = "450B3E04B5010DB41F35CA8B949FED30")

    public final static String CACHE_CONTROL = "cache-control";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.355 -0500", hash_original_field = "F8FF525456A9DD223B10E1C4E8FCF41B", hash_generated_field = "F6800EEE3C9C1A70EB3C6720414DA669")

    public final static String LAST_MODIFIED = "last-modified";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.357 -0500", hash_original_field = "E2A5094EF3D3E2A8C65530EDE23B486A", hash_generated_field = "88106202FCB92FEEAF5138D6C6806089")

    public final static String ETAG = "etag";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.359 -0500", hash_original_field = "D4BC6594ABDFCACAEA46F3E87A271A7F", hash_generated_field = "A7FDB9E1F185D0CC04AEFA5AC7F01D3F")

    public final static String SET_COOKIE = "set-cookie";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.361 -0500", hash_original_field = "A08EEFAB771CD012F0A5360F0E467C61", hash_generated_field = "D6513DD9C72F81B9F9DC8D34DCFDB1E7")

    public final static String PRAGMA = "pragma";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.364 -0500", hash_original_field = "C5F6B69F898DC40C9B267E47AE5B911F", hash_generated_field = "3265C52EE1FA28461C3C83C045036136")

    public final static String REFRESH = "refresh";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.367 -0500", hash_original_field = "B7FDB867573510581E7A9CF8C436ED29", hash_generated_field = "589DB52C07CE6D4B43E09172999F3F5B")

    public final static String X_PERMITTED_CROSS_DOMAIN_POLICIES = "x-permitted-cross-domain-policies";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.369 -0500", hash_original_field = "94167B8C9F9B3B804F6DA3D4399640FA", hash_generated_field = "E51E16F4FF72FD9B60ABEA316B8E6844")

    private final static int HASH_TRANSFER_ENCODING = 1274458357;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.371 -0500", hash_original_field = "8D8C97996DD1BCFF9D76C9F02D8833A0", hash_generated_field = "F5FC2613E3682B4D30CB8F24594897C4")

    private final static int HASH_CONTENT_LEN = -1132779846;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.373 -0500", hash_original_field = "6E36C4D9E5EB39D68E98383994BEA892", hash_generated_field = "2EB57F7DCB54A1F1F5E38F0E0B773D84")

    private final static int HASH_CONTENT_TYPE = 785670158;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.375 -0500", hash_original_field = "0BF537F24FB54DD52E89378332454C7A", hash_generated_field = "10EE589BA2B105C140483634F384D4F1")

    private final static int HASH_CONTENT_ENCODING = 2095084583;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.377 -0500", hash_original_field = "1AEE0D552CA4FE810F5134A1E2E3522C", hash_generated_field = "5F7325D24DBA2A1B8D67785D7C472600")

    private final static int HASH_CONN_DIRECTIVE = -775651618;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.380 -0500", hash_original_field = "3F8AF34F340BC6F548F843E376426F71", hash_generated_field = "E76AC333D9C173505D096F550CDC6F3F")

    private final static int HASH_LOCATION = 1901043637;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.383 -0500", hash_original_field = "B12F96B39E97B38E8FBB52BD2A0291E8", hash_generated_field = "A32A3662A238F5A1AEFE7F75FA20BF09")

    private final static int HASH_PROXY_CONNECTION = 285929373;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.385 -0500", hash_original_field = "B49E41BBB9318B7C7B7013E60EEFF480", hash_generated_field = "3C987A8C74D00860013829B971A62ADE")

    private final static int HASH_WWW_AUTHENTICATE = -243037365;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.387 -0500", hash_original_field = "561B3F76B4B7F7EA905BB528C62284EF", hash_generated_field = "39B9CF5AFF4E85B3FB6C5386F84E577C")

    private final static int HASH_PROXY_AUTHENTICATE = -301767724;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.390 -0500", hash_original_field = "ED83054A4BF65CD8E9E603CBA59D6185", hash_generated_field = "60255A27DD37AF204BCBD75849E718A0")

    private final static int HASH_CONTENT_DISPOSITION = -1267267485;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.392 -0500", hash_original_field = "59FA7CB97784B53B9D6B1F1005301778", hash_generated_field = "8A32E37D07F6A32183177C86830D94FA")

    private final static int HASH_ACCEPT_RANGES = 1397189435;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.394 -0500", hash_original_field = "A693468065386EFE09902C81F253648A", hash_generated_field = "31BDF9B854D8ABD34017DFF737725819")

    private final static int HASH_EXPIRES = -1309235404;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.396 -0500", hash_original_field = "6D8F1BF07FB989282E71DD919B317420", hash_generated_field = "A85CE708DEA5EFD2FB8BB109D6D0F3A4")

    private final static int HASH_CACHE_CONTROL = -208775662;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.400 -0500", hash_original_field = "266F989448789574EDE36240AF3635AF", hash_generated_field = "2CD1F0F8BA900D39E844CE159B9E6448")

    private final static int HASH_LAST_MODIFIED = 150043680;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.402 -0500", hash_original_field = "43388F7475D2D5163B433E1F3B431203", hash_generated_field = "D0C9F7793ED99283D48E66BC52020A9E")

    private final static int HASH_ETAG = 3123477;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.405 -0500", hash_original_field = "1D7D340F4D6D9A8A0E91F413EE9EA3DD", hash_generated_field = "B917EBF6C3762CC1FE11961B1D17BA92")

    private final static int HASH_SET_COOKIE = 1237214767;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.407 -0500", hash_original_field = "4B1A15347F027A263FA8409D3F494D03", hash_generated_field = "98D663F2063865F4E92610AB48B9DCB2")

    private final static int HASH_PRAGMA = -980228804;
    
    public interface HeaderCallback {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void header(String name, String value);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.409 -0500", hash_original_field = "D8035A61A6E22909C254BB44A1138814", hash_generated_field = "8613521BF28512C3BE1153253E6BB597")

    private final static int HASH_REFRESH = 1085444827;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.412 -0500", hash_original_field = "95957595FC46C8A6544A3C0714233F1C", hash_generated_field = "9B9326E4B74B05E67C82C6AC78AE288D")

    private final static int HASH_X_PERMITTED_CROSS_DOMAIN_POLICIES = -1345594014;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.414 -0500", hash_original_field = "9CE8167787B4107619A221105462E505", hash_generated_field = "57B4AA544C19E06A53852FAA1F2EF213")

    // string array
    private final static int IDX_TRANSFER_ENCODING = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.416 -0500", hash_original_field = "CE0A5772970460098C1AB7A8A9ABE599", hash_generated_field = "E6C21E4C7442EABC526E43342529ECBA")

    private final static int IDX_CONTENT_LEN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.418 -0500", hash_original_field = "99F86B848D9F3F53516D35347A22F947", hash_generated_field = "F17D959A03C864A3D9E9C85EBE639D3A")

    private final static int IDX_CONTENT_TYPE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.420 -0500", hash_original_field = "FE8EDF7984FC414E44BD3D06EA5EE69C", hash_generated_field = "81924568DEED109B60E51488E4E4D2D4")

    private final static int IDX_CONTENT_ENCODING = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.423 -0500", hash_original_field = "0FF9CEC9B3B08550FF4D4FC72CC82646", hash_generated_field = "45CEAC5BEA88F3D103A34151707BCB5A")

    private final static int IDX_CONN_DIRECTIVE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.425 -0500", hash_original_field = "B8E87F2B5DC94AA1AECBC8C1D046BD9E", hash_generated_field = "DAC5FEF48DD7C7DEFDB2EC3117246238")

    private final static int IDX_LOCATION = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.428 -0500", hash_original_field = "889BD3E95EE10AC0A404C8ED89DD6F66", hash_generated_field = "DA0E1FF2661CBA411A805657AD8983AD")

    private final static int IDX_PROXY_CONNECTION = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.430 -0500", hash_original_field = "16B34DAAB115898AB5A59963999C6B08", hash_generated_field = "BC104A1300C317C8DAE09161D68B7C76")

    private final static int IDX_WWW_AUTHENTICATE = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.432 -0500", hash_original_field = "026793106048C7C29ABC38C476C4CAE6", hash_generated_field = "83E881AD61875794DE6BD1EFA4BBE2DA")

    private final static int IDX_PROXY_AUTHENTICATE = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.435 -0500", hash_original_field = "F810992AED263F42A7247DE046E75250", hash_generated_field = "70C052905F33EAB389A11D557D076555")

    private final static int IDX_CONTENT_DISPOSITION = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.437 -0500", hash_original_field = "263C3448069F22FBC68216AB7F661736", hash_generated_field = "27766383D0D77C40D8B42F938D2C0C9F")

    private final static int IDX_ACCEPT_RANGES = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.439 -0500", hash_original_field = "0FF7E49F0B2A4935633EDDBFDD8458C8", hash_generated_field = "D77A6684E8819F46E09969079559D5B7")

    private final static int IDX_EXPIRES = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.442 -0500", hash_original_field = "535CD196008E7D24756C7A87A451263E", hash_generated_field = "208E75CAF22A97D5A5E0232968B5F2E4")

    private final static int IDX_CACHE_CONTROL = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.444 -0500", hash_original_field = "A98FBA7C6639115DE207F3FC27EDADC4", hash_generated_field = "762CA1BA4BAD411E079325B2EDAC957D")

    private final static int IDX_LAST_MODIFIED = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.446 -0500", hash_original_field = "52D199584E62F5A46A45D9C52B4F2C19", hash_generated_field = "68DABB6487881B218EDDBC8C79608FC1")

    private final static int IDX_ETAG = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.448 -0500", hash_original_field = "FB361084C96C778E372EEDB0EBB06AA8", hash_generated_field = "B35684FB62BE0B535A372DBEE609ABE3")

    private final static int IDX_SET_COOKIE = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.451 -0500", hash_original_field = "DC4BDB21ECFE3172176D2BBEDD6A3E5C", hash_generated_field = "46633A8E677F58AEFC32AB0BBD6EB035")

    private final static int IDX_PRAGMA = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.453 -0500", hash_original_field = "C3A86DA1D717C1D220981A857C067D5D", hash_generated_field = "BEF97DDEA89012BFE6995EE975B0F93B")

    private final static int IDX_REFRESH = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.456 -0500", hash_original_field = "3130285ACCA093DE2A94D89C82A833C7", hash_generated_field = "95DE7AD1FEC1D3A3BFBE6B5D8ECCDCB1")

    private final static int IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.458 -0500", hash_original_field = "A973753BA7A414D988DEC5AA299E9A32", hash_generated_field = "0B2442CA0B92E2CCC52F7846B6D391D9")

    private final static int HEADER_COUNT = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.471 -0500", hash_original_field = "F77ABAADA0FD9A287C7811D5502740AA", hash_generated_field = "22ED680D75DAA14488B618AAD5F441A4")

    private final static String[] sHeaderNames = {
        TRANSFER_ENCODING,
        CONTENT_LEN,
        CONTENT_TYPE,
        CONTENT_ENCODING,
        CONN_DIRECTIVE,
        LOCATION,
        PROXY_CONNECTION,
        WWW_AUTHENTICATE,
        PROXY_AUTHENTICATE,
        CONTENT_DISPOSITION,
        ACCEPT_RANGES,
        EXPIRES,
        CACHE_CONTROL,
        LAST_MODIFIED,
        ETAG,
        SET_COOKIE,
        PRAGMA,
        REFRESH,
        X_PERMITTED_CROSS_DOMAIN_POLICIES
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.460 -0500", hash_original_field = "8663C7395FA747EC8FEBB05FB2B0C31B", hash_generated_field = "F2168064076810E0CC499B9D7EF97699")

    private long transferEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.462 -0500", hash_original_field = "1E697977C6954C6B938DDD0BFFFD6A14", hash_generated_field = "0235B86EE2D19DB7BC14B5867FCABFC4")

    private long contentLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.464 -0500", hash_original_field = "11BE46E635AB7D30E2E993D1BEE16F58", hash_generated_field = "DA79CCF89C0444B28B1A4FCF4B709AC2")

    private int connectionType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.466 -0500", hash_original_field = "137AC14E6401B3F107E0C9EB73FC1681", hash_generated_field = "059D703F12F9B58BFA7B38580D912F7A")

    private ArrayList<String> cookies = new ArrayList<String>(2);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.468 -0500", hash_original_field = "5263776470621A9A3153D44FA35A9491", hash_generated_field = "86073EAB5791FF38D937FACC8B8B5D5A")

    private String[] mHeaders = new String[HEADER_COUNT];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.473 -0500", hash_original_field = "36FE7539A94C9D18E955FB4F29AB7FC0", hash_generated_field = "591B6F2110CB6CDD1C1A9CAA5287338F")

    private ArrayList<String> mExtraHeaderNames = new ArrayList<String>(4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.475 -0500", hash_original_field = "963FF9DA09B5477456D1781E82D03D9A", hash_generated_field = "41D0A1235C58997B9BD356936A71763B")

    private ArrayList<String> mExtraHeaderValues = new ArrayList<String>(4);

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.478 -0500", hash_original_method = "4806F09499B83A0F8F6BA6D2EDAE6CDA", hash_generated_method = "CB40F30DFBA49920D9EBB0495998DDE2")
    
public Headers() {
        transferEncoding = NO_TRANSFER_ENCODING;
        contentLength = NO_CONTENT_LENGTH;
        connectionType = NO_CONN_TYPE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.482 -0500", hash_original_method = "2601C4AB5843D67812F736A8664254C1", hash_generated_method = "6A28FB7A5296B79A3E532DCA1A745633")
    
public void parseHeader(CharArrayBuffer buffer) {
        int pos = CharArrayBuffers.setLowercaseIndexOf(buffer, ':');
        if (pos == -1) {
            return;
        }
        String name = buffer.substringTrimmed(0, pos);
        if (name.length() == 0) {
            return;
        }
        pos++;

        String val = buffer.substringTrimmed(pos, buffer.length());
        if (HttpLog.LOGV) {
            HttpLog.v("hdr " + buffer.length() + " " + buffer);
        }

        switch (name.hashCode()) {
        case HASH_TRANSFER_ENCODING:
            if (name.equals(TRANSFER_ENCODING)) {
                mHeaders[IDX_TRANSFER_ENCODING] = val;
                HeaderElement[] encodings = BasicHeaderValueParser.DEFAULT
                        .parseElements(buffer, new ParserCursor(pos,
                                buffer.length()));
                // The chunked encoding must be the last one applied RFC2616,
                // 14.41
                int len = encodings.length;
                if (HTTP.IDENTITY_CODING.equalsIgnoreCase(val)) {
                    transferEncoding = ContentLengthStrategy.IDENTITY;
                } else if ((len > 0)
                        && (HTTP.CHUNK_CODING
                                .equalsIgnoreCase(encodings[len - 1].getName()))) {
                    transferEncoding = ContentLengthStrategy.CHUNKED;
                } else {
                    transferEncoding = ContentLengthStrategy.IDENTITY;
                }
            }
            break;
        case HASH_CONTENT_LEN:
            if (name.equals(CONTENT_LEN)) {
                mHeaders[IDX_CONTENT_LEN] = val;
                try {
                    contentLength = Long.parseLong(val);
                } catch (NumberFormatException e) {
                    if (false) {
                        Log.v(LOGTAG, "Headers.headers(): error parsing"
                                + " content length: " + buffer.toString());
                    }
                }
            }
            break;
        case HASH_CONTENT_TYPE:
            if (name.equals(CONTENT_TYPE)) {
                mHeaders[IDX_CONTENT_TYPE] = val;
            }
            break;
        case HASH_CONTENT_ENCODING:
            if (name.equals(CONTENT_ENCODING)) {
                mHeaders[IDX_CONTENT_ENCODING] = val;
            }
            break;
        case HASH_CONN_DIRECTIVE:
            if (name.equals(CONN_DIRECTIVE)) {
                mHeaders[IDX_CONN_DIRECTIVE] = val;
                setConnectionType(buffer, pos);
            }
            break;
        case HASH_LOCATION:
            if (name.equals(LOCATION)) {
                mHeaders[IDX_LOCATION] = val;
            }
            break;
        case HASH_PROXY_CONNECTION:
            if (name.equals(PROXY_CONNECTION)) {
                mHeaders[IDX_PROXY_CONNECTION] = val;
                setConnectionType(buffer, pos);
            }
            break;
        case HASH_WWW_AUTHENTICATE:
            if (name.equals(WWW_AUTHENTICATE)) {
                mHeaders[IDX_WWW_AUTHENTICATE] = val;
            }
            break;
        case HASH_PROXY_AUTHENTICATE:
            if (name.equals(PROXY_AUTHENTICATE)) {
                mHeaders[IDX_PROXY_AUTHENTICATE] = val;
            }
            break;
        case HASH_CONTENT_DISPOSITION:
            if (name.equals(CONTENT_DISPOSITION)) {
                mHeaders[IDX_CONTENT_DISPOSITION] = val;
            }
            break;
        case HASH_ACCEPT_RANGES:
            if (name.equals(ACCEPT_RANGES)) {
                mHeaders[IDX_ACCEPT_RANGES] = val;
            }
            break;
        case HASH_EXPIRES:
            if (name.equals(EXPIRES)) {
                mHeaders[IDX_EXPIRES] = val;
            }
            break;
        case HASH_CACHE_CONTROL:
            if (name.equals(CACHE_CONTROL)) {
                // In case where we receive more than one header, create a ',' separated list.
                // This should be ok, according to RFC 2616 chapter 4.2
                if (mHeaders[IDX_CACHE_CONTROL] != null &&
                    mHeaders[IDX_CACHE_CONTROL].length() > 0) {
                    mHeaders[IDX_CACHE_CONTROL] += (',' + val);
                } else {
                    mHeaders[IDX_CACHE_CONTROL] = val;
                }
            }
            break;
        case HASH_LAST_MODIFIED:
            if (name.equals(LAST_MODIFIED)) {
                mHeaders[IDX_LAST_MODIFIED] = val;
            }
            break;
        case HASH_ETAG:
            if (name.equals(ETAG)) {
                mHeaders[IDX_ETAG] = val;
            }
            break;
        case HASH_SET_COOKIE:
            if (name.equals(SET_COOKIE)) {
                mHeaders[IDX_SET_COOKIE] = val;
                cookies.add(val);
            }
            break;
        case HASH_PRAGMA:
            if (name.equals(PRAGMA)) {
                mHeaders[IDX_PRAGMA] = val;
            }
            break;
        case HASH_REFRESH:
            if (name.equals(REFRESH)) {
                mHeaders[IDX_REFRESH] = val;
            }
            break;
        case HASH_X_PERMITTED_CROSS_DOMAIN_POLICIES:
            if (name.equals(X_PERMITTED_CROSS_DOMAIN_POLICIES)) {
                mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES] = val;
            }
            break;
        default:
            mExtraHeaderNames.add(name);
            mExtraHeaderValues.add(val);
        }
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.485 -0500", hash_original_method = "839965513DF286AFAE2E56076E19ADBF", hash_generated_method = "10D0713054B009C9560591953B0DC3A0")
    
public long getTransferEncoding() {
        return transferEncoding;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.487 -0500", hash_original_method = "043A311B0C55CC2C0E7ED635C15C25FD", hash_generated_method = "64E0C789E764D7FD18A4925FDDA762C8")
    
public long getContentLength() {
        return contentLength;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.489 -0500", hash_original_method = "16A8DC2EF1F4EBF751AEB83B8F69222E", hash_generated_method = "9D4EC4E428DADAF3D1AA6A9C9413C6A5")
    
public int getConnectionType() {
        return connectionType;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.491 -0500", hash_original_method = "0358D0D4AEFF84195277AB782B3FFDE2", hash_generated_method = "B41EA4DFDB24D74504B98FDA3AC90952")
    
public String getContentType() {
        return mHeaders[IDX_CONTENT_TYPE];
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.493 -0500", hash_original_method = "DC3B5CC0DA80597E20563D04CDFF5783", hash_generated_method = "6FC7F8A976DC02A369D31E2FD74A3D76")
    
public String getContentEncoding() {
        return mHeaders[IDX_CONTENT_ENCODING];
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.495 -0500", hash_original_method = "3BEB5C295081F99F7A9897994B243966", hash_generated_method = "D9B277F1A1B22E3A221A4F4D47E66AE4")
    
public String getLocation() {
        return mHeaders[IDX_LOCATION];
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.496 -0500", hash_original_method = "2ABA1BEE8C50AB0C1324E3514B439A3C", hash_generated_method = "CD9B5117E79ACBD56746F133BD6EF904")
    
public String getWwwAuthenticate() {
        return mHeaders[IDX_WWW_AUTHENTICATE];
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.498 -0500", hash_original_method = "2251D004613BB9CDF5BB072ECCA1B196", hash_generated_method = "C00CA8B0E39A26AF0677AFBA3C71CB6A")
    
public String getProxyAuthenticate() {
        return mHeaders[IDX_PROXY_AUTHENTICATE];
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.501 -0500", hash_original_method = "B3734B1B2E8291E968F6C56DD5A68AFD", hash_generated_method = "222968148F1F6D3AF21A6EC47455054B")
    
public String getContentDisposition() {
        return mHeaders[IDX_CONTENT_DISPOSITION];
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.504 -0500", hash_original_method = "56F3083ED56642A8109311F7B75978CE", hash_generated_method = "4D2B60C4467F5961F16944E2EC8F1F9B")
    
public String getAcceptRanges() {
        return mHeaders[IDX_ACCEPT_RANGES];
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.506 -0500", hash_original_method = "AD48730753A27EE5F83CD5FBE4AD4C5B", hash_generated_method = "27732696F849CC450F482F2BC43392CD")
    
public String getExpires() {
        return mHeaders[IDX_EXPIRES];
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.508 -0500", hash_original_method = "FAE5B14F1D1AF7F7C5B34799287CB96B", hash_generated_method = "B5BCE87079F3C4E9972DED4CC3C9A3BB")
    
public String getCacheControl() {
        return mHeaders[IDX_CACHE_CONTROL];
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.511 -0500", hash_original_method = "5FC9B5DD06D10DB2F99A11CF11E84611", hash_generated_method = "C2E78F939B996DD9D0D6EC9BCA1E6130")
    
public String getLastModified() {
        return mHeaders[IDX_LAST_MODIFIED];
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.514 -0500", hash_original_method = "2356D85AA5974933778FA07340E360AB", hash_generated_method = "BDD7EA7B76E842C1EA7E4D0136A9577F")
    
public String getEtag() {
        return mHeaders[IDX_ETAG];
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.516 -0500", hash_original_method = "30BF89B95A4B495DCD1A87F8054AFEC5", hash_generated_method = "78347F50E160B424874C3D13E94C82B9")
    
public ArrayList<String> getSetCookie() {
        return this.cookies;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.518 -0500", hash_original_method = "A30AE7605FF81FB95FDA5AAF057C022D", hash_generated_method = "90747065C2D96D117D33212CC2A8FECA")
    
public String getPragma() {
        return mHeaders[IDX_PRAGMA];
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.520 -0500", hash_original_method = "847E30EC42ECB16F3B862D5A0C1778F0", hash_generated_method = "D793C626E73A782DB92CA5A13C89A8F2")
    
public String getRefresh() {
        return mHeaders[IDX_REFRESH];
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.522 -0500", hash_original_method = "120DF6C7E530068F21D41A0CCD884530", hash_generated_method = "242402B2488782EE98670C4387AC9ECE")
    
public String getXPermittedCrossDomainPolicies() {
        return mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.524 -0500", hash_original_method = "655405705FFA26A24CEE799E196F64CA", hash_generated_method = "13B858F90BC8CB7A6E88E2F2BADB2796")
    
public void setContentLength(long value) {
        this.contentLength = value;
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.526 -0500", hash_original_method = "DBD4B3393EC7C86D318F09AACB690C16", hash_generated_method = "7A5F9F5524B9D7BC165F7F9758A1E827")
    
public void setContentType(String value) {
        mHeaders[IDX_CONTENT_TYPE] = value;
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.528 -0500", hash_original_method = "795639D1D1B96C335181D978646FFEAC", hash_generated_method = "6455CE3025EAD8ECAEA0D19667A69247")
    
public void setContentEncoding(String value) {
        mHeaders[IDX_CONTENT_ENCODING] = value;
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.530 -0500", hash_original_method = "91ACBD0DA1F8B6B752177E887C1E560A", hash_generated_method = "BDD0853C19DF96DDD1C2702D943E3BFC")
    
public void setLocation(String value) {
        mHeaders[IDX_LOCATION] = value;
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.533 -0500", hash_original_method = "78E4D283A358D7F9AC830EDA5944CEC1", hash_generated_method = "D60F7797AFACDE0B11476E4C02D11106")
    
public void setWwwAuthenticate(String value) {
        mHeaders[IDX_WWW_AUTHENTICATE] = value;
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.535 -0500", hash_original_method = "EB3C03E25C95805816417AB68A1F4E73", hash_generated_method = "A95FCD0E463EDB434D1E42C4BEDDA381")
    
public void setProxyAuthenticate(String value) {
        mHeaders[IDX_PROXY_AUTHENTICATE] = value;
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.537 -0500", hash_original_method = "CAF824941A606D9472E6B7F4D5AE8EAB", hash_generated_method = "F7C09C467DDA74C767F9B12B4142946C")
    
public void setContentDisposition(String value) {
        mHeaders[IDX_CONTENT_DISPOSITION] = value;
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.539 -0500", hash_original_method = "42F6F595EF9293A515A4DDDF580E03E6", hash_generated_method = "EA9CDC29D7E5B17469315BCEED67081F")
    
public void setAcceptRanges(String value) {
        mHeaders[IDX_ACCEPT_RANGES] = value;
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.541 -0500", hash_original_method = "7D2DC3B419C5BDAB21BBD8535AC32115", hash_generated_method = "8A4BDD894CF8B3516F42B8C0BFE596BE")
    
public void setExpires(String value) {
        mHeaders[IDX_EXPIRES] = value;
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.543 -0500", hash_original_method = "461838AAEBDAFBB838DA60C8789FC643", hash_generated_method = "CCBBCC91B14A6FC57C8A07AF0C52EFC5")
    
public void setCacheControl(String value) {
        mHeaders[IDX_CACHE_CONTROL] = value;
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.545 -0500", hash_original_method = "E44516D40CA535A9E78D483DC766FE77", hash_generated_method = "FF6D5B01944DFD8CF78698C1B4FB6282")
    
public void setLastModified(String value) {
        mHeaders[IDX_LAST_MODIFIED] = value;
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.548 -0500", hash_original_method = "7E96E0634D296A60D862609FEA944EA2", hash_generated_method = "3DFB7C9312CBCBAE4682B2749186F050")
    
public void setEtag(String value) {
        mHeaders[IDX_ETAG] = value;
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.550 -0500", hash_original_method = "860A5481555AE910297114E1D7478814", hash_generated_method = "5B54FC2C5A23F45B4EA4E2B131C5514F")
    
public void setXPermittedCrossDomainPolicies(String value) {
        mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES] = value;
    }

    /**
     * Reports all non-null headers to the callback
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.554 -0500", hash_original_method = "C9CAD2CB40E843B6A6F48005E0DE2B60", hash_generated_method = "B6CB77D8882472C320021C2A80165E8A")
    
public void getHeaders(HeaderCallback hcb) {
        for (int i = 0; i < HEADER_COUNT; i++) {
            String h = mHeaders[i];
            if (h != null) {
                hcb.header(sHeaderNames[i], h);
            }
        }
        int extraLen = mExtraHeaderNames.size();
        for (int i = 0; i < extraLen; i++) {
            if (false) {
                HttpLog.v("Headers.getHeaders() extra: " + i + " " +
                          mExtraHeaderNames.get(i) + " " + mExtraHeaderValues.get(i));
            }
            hcb.header(mExtraHeaderNames.get(i),
                       mExtraHeaderValues.get(i));
        }

    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:15.557 -0500", hash_original_method = "D8DC07475CD7B5300779AA7E8CC52DE7", hash_generated_method = "FA47D96067419C5CCDC2FCF8C111EE8B")
    
private void setConnectionType(CharArrayBuffer buffer, int pos) {
        if (CharArrayBuffers.containsIgnoreCaseTrimmed(
                buffer, pos, HTTP.CONN_CLOSE)) {
            connectionType = CONN_CLOSE;
        } else if (CharArrayBuffers.containsIgnoreCaseTrimmed(
                buffer, pos, HTTP.CONN_KEEP_ALIVE)) {
            connectionType = CONN_KEEP_ALIVE;
        }
    }
}

