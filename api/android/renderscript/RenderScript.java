package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;
import android.content.res.AssetManager;
import android.util.Log;
import android.content.pm.ApplicationInfo;
import android.content.Context;
import android.graphics.BitmapFactory;
import java.lang.reflect.Field;
import android.content.pm.PackageManager;
import android.view.Surface;
import android.os.Process;
import android.graphics.SurfaceTexture;
public class RenderScript {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.152 -0400", hash_original_field = "BCB208A03C79579955DC455811823AC0", hash_generated_field = "DE9CF0F0F7A6C85EF08872E26EEA1599")

    private Context mApplicationContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.155 -0400", hash_original_field = "889E50C125827C2C3F03BB3AA6BB3D5D", hash_generated_field = "97FCF96DBFF8B429633D3BD31F12497F")

    int mDev;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.157 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "19C61BA4139FB95CA67E235BE0DACFF3")

    int mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.161 -0400", hash_original_field = "9B825F3950CC9F67684FD73656036F9F", hash_generated_field = "670FB90F84721926B44B7A261023C823")

    @SuppressWarnings({"FieldCanBeLocal"}) MessageThread mMessageThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.162 -0400", hash_original_field = "DB9DE2C834795DE3EFBF59B8D6D22B15", hash_generated_field = "1A4C60ED310F59A326B64022242C4837")

    Element mElement_U8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.171 -0400", hash_original_field = "8FB8AAA2C363F5F69F4B348562F97F60", hash_generated_field = "A115100196267E2ED63739A879D23201")

    Element mElement_I8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.172 -0400", hash_original_field = "191EE67BC4B40F84FB12467DCE6A0EAB", hash_generated_field = "54F4B6F9FA7A350852680541D2024677")

    Element mElement_U16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.174 -0400", hash_original_field = "4B9D3DBF3D80F1A236F89AEB14F6752C", hash_generated_field = "833DA275352FDE1C1761DB58A51D53A9")

    Element mElement_I16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.176 -0400", hash_original_field = "207753BE6FA91A5E78F1B57CE4D81708", hash_generated_field = "F082C7FE58DD7A4E24B249D3740DAB52")

    Element mElement_U32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.178 -0400", hash_original_field = "F4E043E9415C3DC8A4171DD27F4FB7B9", hash_generated_field = "D7581DD3A8437870F797E24CEBA5B523")

    Element mElement_I32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.180 -0400", hash_original_field = "E12D067C8F33092819F5F512C1380381", hash_generated_field = "2D97FB4B0750BBC826190DCEDF30EEAB")

    Element mElement_U64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.181 -0400", hash_original_field = "F64982BB37CF1364F32F8ACFD6386E3F", hash_generated_field = "667B346E92EFBB850E5865402EDC965D")

    Element mElement_I64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.186 -0400", hash_original_field = "73ADA139E2BD7BCBAA64546BDCD427CA", hash_generated_field = "00EAEDB38503481A3C5759894D534826")

    Element mElement_F32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.189 -0400", hash_original_field = "3939DE08ABC194D3EDBA2A5FB474D78C", hash_generated_field = "4E5662510076A807040BA7A6A71AD8F7")

    Element mElement_F64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.190 -0400", hash_original_field = "1FCADB21519CD6795500FD53BD8FC90A", hash_generated_field = "88A701AFFD5E24586796CB7112653FF1")

    Element mElement_BOOLEAN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.192 -0400", hash_original_field = "789BB491837A96CE948872D8AF29EAFF", hash_generated_field = "4A6F1FCC3DDC191E0E48AD365A4759B5")

    Element mElement_ELEMENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.194 -0400", hash_original_field = "6DD1CBA28B2C02FAB78E1B2354098E05", hash_generated_field = "2EFBCAB65FE5BE2A90E2AE365AF5F9FA")

    Element mElement_TYPE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.195 -0400", hash_original_field = "EEDFA0EF429D37944B4CB52BBA3790F9", hash_generated_field = "29402BA7E67B0D7ECE953225521C2054")

    Element mElement_ALLOCATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.197 -0400", hash_original_field = "567A5EAFA5DDBC6B00A673F5B54B1915", hash_generated_field = "5855F4DB43046E4C289B8EFB6528F3AF")

    Element mElement_SAMPLER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.200 -0400", hash_original_field = "A0F45BAD07A6A5B72007739E251B2475", hash_generated_field = "8157A7A7CB259C4E913256A58B1FE057")

    Element mElement_SCRIPT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.204 -0400", hash_original_field = "1D7CE31157AC849F47CB6DFC266706C0", hash_generated_field = "7C46049D19E4B3EB82D18681880F1D81")

    Element mElement_MESH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.206 -0400", hash_original_field = "3FD595EB863839354E1E1F7D74404A49", hash_generated_field = "2CD22CDF9515BEF5617F58AF6C5DC3B4")

    Element mElement_PROGRAM_FRAGMENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.208 -0400", hash_original_field = "2B74B9CF438E38711A1E298049F96A47", hash_generated_field = "3435047FDB3BDECEB28D3FA533BF505C")

    Element mElement_PROGRAM_VERTEX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.211 -0400", hash_original_field = "192324163D7904779D035D78C6759A86", hash_generated_field = "FD5F17712A3D83716885C55D8EC54E23")

    Element mElement_PROGRAM_RASTER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.212 -0400", hash_original_field = "6CFC55916040284DC157ABE691478121", hash_generated_field = "7882A52B6011EC323E80870ED60C8EFC")

    Element mElement_PROGRAM_STORE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.213 -0400", hash_original_field = "73F2541B4CCB7491951080F1858B0B84", hash_generated_field = "583ED1725F29FCC08C5EE0A5DEBA905D")

    Element mElement_A_8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.214 -0400", hash_original_field = "26CCADF59FEBE03C8B2F1591C591AF92", hash_generated_field = "9B422CEE267AECD8C66DD08959B9C381")

    Element mElement_RGB_565;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.215 -0400", hash_original_field = "04E3141D7FBC4D9F05910033E6B2D754", hash_generated_field = "808A316EFD9D37B931028DC23AA817AA")

    Element mElement_RGB_888;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.216 -0400", hash_original_field = "3A0A18011F1550B0668E754A2AC07436", hash_generated_field = "07ACDE925FD9974BDB487EA5CFA1F57D")

    Element mElement_RGBA_5551;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.217 -0400", hash_original_field = "1A63DC4BD299413FE8837B133BB59DE5", hash_generated_field = "34960B2DAF137407207E425B7800CCDB")

    Element mElement_RGBA_4444;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.218 -0400", hash_original_field = "7D8D1547C081C78C4B6776C490642535", hash_generated_field = "BB437F659367C07335C8CCE53F70B51D")

    Element mElement_RGBA_8888;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.220 -0400", hash_original_field = "696818F003C2A7065255FCEAC9DFEBA5", hash_generated_field = "A26873EF625936EBEC474EA98B6EEF39")

    Element mElement_FLOAT_2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.222 -0400", hash_original_field = "34BBAFFA066EE3EA96C8A183E7EE883C", hash_generated_field = "FAB9909D949F377BC188359F721E520B")

    Element mElement_FLOAT_3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.223 -0400", hash_original_field = "29F118F61166C19F8C36A5C3F2901155", hash_generated_field = "E6B28BBDE41009797A89736A06E985C8")

    Element mElement_FLOAT_4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.224 -0400", hash_original_field = "134B024EA9C70732632AFC6BD90F4F37", hash_generated_field = "4314D1BE060B522FBE7C8840CCE67A5E")

    Element mElement_DOUBLE_2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.224 -0400", hash_original_field = "4CC4A705BF4E3A8838FE1753E346073B", hash_generated_field = "ED2783252668396374139138DDDB1E4E")

    Element mElement_DOUBLE_3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.226 -0400", hash_original_field = "8BCCCC14FBBCBFD488D2FFC6973506CB", hash_generated_field = "4A25CA35B7A8135791E3C74636B5651B")

    Element mElement_DOUBLE_4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.229 -0400", hash_original_field = "C467D266B89553000114EB4DFDE23E92", hash_generated_field = "42125330C40EE1E1970FF1D6DCD549F3")

    Element mElement_UCHAR_2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.231 -0400", hash_original_field = "63C30FD6DF64E5D117B649C4E8A36864", hash_generated_field = "41AFF93379CB91FFCC25823BDC157458")

    Element mElement_UCHAR_3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.233 -0400", hash_original_field = "54C4DC8963198A7A14CCB9F65C7D2DDF", hash_generated_field = "EEB9AB3F823B0187305AF49F6679F436")

    Element mElement_UCHAR_4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.235 -0400", hash_original_field = "2ECA65E2D9D480209B3F7F12CAA11083", hash_generated_field = "008D8C3DBF67E53688415D5742E26110")

    Element mElement_CHAR_2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.236 -0400", hash_original_field = "5F7D265CAFF710CF9FD3346C92773385", hash_generated_field = "7CF23E5A463E5C432FB997247B9CB6DA")

    Element mElement_CHAR_3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.239 -0400", hash_original_field = "B8085FC245C6E498D2F4903DAA6EB05B", hash_generated_field = "F497E4C68C277202DAD6DF3701BBDDFC")

    Element mElement_CHAR_4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.242 -0400", hash_original_field = "4255B1A16F2E19E46CFA738C4D72498A", hash_generated_field = "B24A765F13FF74DB88B856F97EBD7002")

    Element mElement_USHORT_2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.243 -0400", hash_original_field = "BFD4E4AA65B7F5AEA323750FDC2B9775", hash_generated_field = "E9199C46669A4076C44AB964830CB78F")

    Element mElement_USHORT_3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.245 -0400", hash_original_field = "F6BC048698D55F5DF65A677A543E7689", hash_generated_field = "4549F81D017948EC8D77E71B148EA883")

    Element mElement_USHORT_4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.247 -0400", hash_original_field = "844CD5B44DB9B49B8A076233F66ED445", hash_generated_field = "A61CA347123FBA9C5A18C41944A576B9")

    Element mElement_SHORT_2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.248 -0400", hash_original_field = "DC1C651864D7EBCA4EF746CF0C8CB464", hash_generated_field = "778CCB99542DA47A75CDDC434CD3DE3C")

    Element mElement_SHORT_3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.250 -0400", hash_original_field = "0A4D52F64EBCB42BB51B04D464CBCE80", hash_generated_field = "11A21B8338F825A497E945C7811706DD")

    Element mElement_SHORT_4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.254 -0400", hash_original_field = "09F3514A3E8D5ACC173503439FF68DCC", hash_generated_field = "D092CF7584BFB9A3ED918F84EB8982D6")

    Element mElement_UINT_2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.256 -0400", hash_original_field = "5AE22CC1CC5C6184CA6C0670E323D2DE", hash_generated_field = "952C8EAFBD3B3BEF43DCB09EC0D33116")

    Element mElement_UINT_3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.257 -0400", hash_original_field = "056E2C4F0FB68EE911C1CC67EB56654A", hash_generated_field = "76794C9A4596BDDC93202233B97F1E89")

    Element mElement_UINT_4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.259 -0400", hash_original_field = "2215EB204BB68B73AEDBC2553078C66D", hash_generated_field = "488D8A8C409807BEB5482E2A220560BF")

    Element mElement_INT_2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.260 -0400", hash_original_field = "B71E495065F21DF389A54F310F76F9E2", hash_generated_field = "FDC4C914E75BE5D0F5B418AF1F337161")

    Element mElement_INT_3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.261 -0400", hash_original_field = "DD74B74F807BA4F606EE0228AC2BDE84", hash_generated_field = "78E62D9B31DF379AB9A67DFFB6B0EC69")

    Element mElement_INT_4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.262 -0400", hash_original_field = "E146F0BFBD9E8D2E8B6E30532D629427", hash_generated_field = "BE546EE33636C876F5F08AA37EC93392")

    Element mElement_ULONG_2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.263 -0400", hash_original_field = "DCE69C9B1F08781EB9EFEEB878B071A6", hash_generated_field = "1426A1BE2C52948E38BB04ED85667A6D")

    Element mElement_ULONG_3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.264 -0400", hash_original_field = "EC0E6CA66BD44753EB7C1BB871D04D91", hash_generated_field = "5BF63F3AC33E2E6A15E3C809F9B43DBF")

    Element mElement_ULONG_4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.265 -0400", hash_original_field = "0B054F0011616C3FA5796B4857DDB402", hash_generated_field = "DD16F669DE47E721697407D09BA734B4")

    Element mElement_LONG_2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.267 -0400", hash_original_field = "15B594FC602EF5A80684D2AAC551C456", hash_generated_field = "02CBDB23048DD75EF16E592628D58E66")

    Element mElement_LONG_3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.268 -0400", hash_original_field = "1AE53D44956E2E4615170F6AA5FD9E60", hash_generated_field = "6DBFC270015CE28293BDE14B521136C7")

    Element mElement_LONG_4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.269 -0400", hash_original_field = "EC0DF13CB2E5FBCEB9807541BD5CBB55", hash_generated_field = "90467332F0960CFA80067B1FF2293940")

    Element mElement_MATRIX_4X4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.271 -0400", hash_original_field = "F7D89C6689B90E3B5DDF1FB11A1FC5E5", hash_generated_field = "37DC3D9F46428D68056BE5D0E1D2D69F")

    Element mElement_MATRIX_3X3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.273 -0400", hash_original_field = "39BFDB73FE5E1E9C26E77769487F1865", hash_generated_field = "802B656F6AAD04F4B5402556945248C7")

    Element mElement_MATRIX_2X2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.275 -0400", hash_original_field = "507B3A25DD4204BE51264AFFB93C9DFD", hash_generated_field = "FD7952939A930C2EAD82F191678A9A3D")

    Sampler mSampler_CLAMP_NEAREST;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.276 -0400", hash_original_field = "BCF819061685AE61DAC16C52B0192BE5", hash_generated_field = "37CE813925492EE7B0CDDBDA16ADC1DE")

    Sampler mSampler_CLAMP_LINEAR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.277 -0400", hash_original_field = "10981EAAD25700C5FC201F01484C60F9", hash_generated_field = "0FDABB6563A028AB8CF0EDA769250692")

    Sampler mSampler_CLAMP_LINEAR_MIP_LINEAR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.278 -0400", hash_original_field = "55B41B385891856C6F68775852355D4E", hash_generated_field = "FFEFA76AEB73310F96A6BAF05E454B00")

    Sampler mSampler_WRAP_NEAREST;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.280 -0400", hash_original_field = "713F2B1799980E4073A930ACC66DE425", hash_generated_field = "9CBA8162A49023307D1B6AE9BCE24A43")

    Sampler mSampler_WRAP_LINEAR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.281 -0400", hash_original_field = "4D23853E42DA3BF501CBB7B5DF984473", hash_generated_field = "5949BC6E2673836634371B9204E7260C")

    Sampler mSampler_WRAP_LINEAR_MIP_LINEAR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.283 -0400", hash_original_field = "1F0D0E279D79E4348C263DD69F13D738", hash_generated_field = "53A75F27A0885A24DE1E28A78D67D7E6")

    ProgramStore mProgramStore_BLEND_NONE_DEPTH_TEST;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.286 -0400", hash_original_field = "7F5DB7735BB3FF0A58A6855E3989CCD1", hash_generated_field = "8737AA793A56C1AE9073BD927DACE35E")

    ProgramStore mProgramStore_BLEND_NONE_DEPTH_NO_DEPTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.288 -0400", hash_original_field = "D657C82CFD5355828CDCEFD9A9873613", hash_generated_field = "13EE9E455AA610A00DE23BE175D9DE59")

    ProgramStore mProgramStore_BLEND_ALPHA_DEPTH_TEST;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.292 -0400", hash_original_field = "CF2A7C7C586337D7B7201D668DE298B1", hash_generated_field = "B6F8DF6C04DE4FD8A606B165DDFB07BD")

    ProgramStore mProgramStore_BLEND_ALPHA_DEPTH_NO_DEPTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.294 -0400", hash_original_field = "31073EA0B9D4D7D25B53FE486C2C1340", hash_generated_field = "E95BF77B0A9C09370D6FE36647ECAE0A")

    ProgramRaster mProgramRaster_CULL_BACK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.296 -0400", hash_original_field = "94DEB2910CA87F98FBC0E536C5F006BC", hash_generated_field = "0783E32B56B030665E55149BA001BA9E")

    ProgramRaster mProgramRaster_CULL_FRONT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.298 -0400", hash_original_field = "9B927E0E3BA1C6E72FEF9E934B3756B6", hash_generated_field = "EC2CC4869C0FE72E7B228CC00A26798A")

    ProgramRaster mProgramRaster_CULL_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.299 -0400", hash_original_field = "38B347CD2C1543BE253B6BF7068327E5", hash_generated_field = "858670CDC664CC19F703E9228545E7BA")

    RSMessageHandler mMessageCallback = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.302 -0400", hash_original_field = "B10858FD4D4977D3E09916B017198082", hash_generated_field = "088E452E7B88AD4160F095FA1A3F30DC")

    RSErrorHandler mErrorCallback = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.309 -0400", hash_original_method = "392EBD552CF287854C96DEE5F4403E62", hash_generated_method = "BBFE7671C92B1307777D77A42F0CAA66")
      RenderScript(Context ctx) {
        mApplicationContext = ctx.getApplicationContext();
        // ---------- Original Method ----------
        //mApplicationContext = ctx.getApplicationContext();
    }

    
        static void _nInit() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.316 -0400", hash_original_method = "E10A585499F012DC684BBF2A3A5E1690", hash_generated_method = "E414302513101BE5CDBAE30B583F911D")
     int nDeviceCreate() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1624462119 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1624462119;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.319 -0400", hash_original_method = "DF4D03BEDDDA74F1832404E66432B009", hash_generated_method = "72C67DC4265DCB8761EC06FAAB256F29")
     void nDeviceDestroy(int dev) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.323 -0400", hash_original_method = "7AC98A8B1F935BCE8C033A1730FD8D18", hash_generated_method = "5C26B71EFE61140A779E263DADC6958B")
     void nDeviceSetConfig(int dev, int param, int value) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.329 -0400", hash_original_method = "3523058A47E8BE15ED01358E8A9C1317", hash_generated_method = "3443034403B40760A4ABC0BA8D0D1573")
     int nContextGetUserMessage(int con, int[] data) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_72721460 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_72721460;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.333 -0400", hash_original_method = "A170821D17F63D9EDF5AAFFF93CB7028", hash_generated_method = "1C435B28B274730163B2755B3AC76CDA")
     String nContextGetErrorMessage(int con) {
    	taint.addTaint(con);
    	String retVal = new String();
    	retVal.addTaint(taint);
    	return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.337 -0400", hash_original_method = "AFD8787633EE4DCA6116C3EC8151B7E2", hash_generated_method = "245008F51BB640F4DA173EEA8AF79F64")
     int nContextPeekMessage(int con, int[] subID) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1313856986 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1313856986;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.340 -0400", hash_original_method = "D1395017DBF4D2973A1B42B1D2CDF2B0", hash_generated_method = "8E7576834FE24BFB478E8FEFF89034E0")
     void nContextInitToClient(int con) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.344 -0400", hash_original_method = "C373F63DD90F62E81D8094CE77A097E6", hash_generated_method = "0460C8007AAFDACE18C7208E99CB8080")
     void nContextDeinitToClient(int con) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.353 -0400", hash_original_method = "9C6265EC899BF914D2CC30605FF4CB19", hash_generated_method = "709D29E0840EE6B23BC64F85C9418778")
     int rsnContextCreateGL(int dev, int ver, int sdkVer,
                 int colorMin, int colorPref,
                 int alphaMin, int alphaPref,
                 int depthMin, int depthPref,
                 int stencilMin, int stencilPref,
                 int samplesMin, int samplesPref, float samplesQ, int dpi) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62427113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62427113;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.367 -0400", hash_original_method = "C173B3C3D5C34C342E9D2D41CD367CF5", hash_generated_method = "C7C2BB3D526672D77B7AD34E705229E8")
    synchronized int nContextCreateGL(int dev, int ver, int sdkVer,
                 int colorMin, int colorPref,
                 int alphaMin, int alphaPref,
                 int depthMin, int depthPref,
                 int stencilMin, int stencilPref,
                 int samplesMin, int samplesPref, float samplesQ, int dpi) {
        addTaint(dpi);
        addTaint(samplesQ);
        addTaint(samplesPref);
        addTaint(samplesMin);
        addTaint(stencilPref);
        addTaint(stencilMin);
        addTaint(depthPref);
        addTaint(depthMin);
        addTaint(alphaPref);
        addTaint(alphaMin);
        addTaint(colorPref);
        addTaint(colorMin);
        addTaint(sdkVer);
        addTaint(ver);
        addTaint(dev);
        int var77A0717B7C76813AE948194CD4EA2AEF_316407863 = (rsnContextCreateGL(dev, ver, sdkVer, colorMin, colorPref,
                                  alphaMin, alphaPref, depthMin, depthPref,
                                  stencilMin, stencilPref,
                                  samplesMin, samplesPref, samplesQ, dpi));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_209127633 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_209127633;
        // ---------- Original Method ----------
        //return rsnContextCreateGL(dev, ver, sdkVer, colorMin, colorPref,
                                  //alphaMin, alphaPref, depthMin, depthPref,
                                  //stencilMin, stencilPref,
                                  //samplesMin, samplesPref, samplesQ, dpi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.374 -0400", hash_original_method = "B041442AA5F481AFFB60920693334F36", hash_generated_method = "E55CDE8578F51C083D3FD4FBA3B2ABAD")
     int rsnContextCreate(int dev, int ver, int sdkVer) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1852878366 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1852878366;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.380 -0400", hash_original_method = "F258E8147FC7C8BED48B75E7E07A1B28", hash_generated_method = "036D1D0821005BC1281AC164578EA55C")
    synchronized int nContextCreate(int dev, int ver, int sdkVer) {
        addTaint(sdkVer);
        addTaint(ver);
        addTaint(dev);
        int varDEA4DF82C6AB2729720B69A50E0B0B57_2107159386 = (rsnContextCreate(dev, ver, sdkVer));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966228470 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966228470;
        // ---------- Original Method ----------
        //return rsnContextCreate(dev, ver, sdkVer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.384 -0400", hash_original_method = "4492F159A0AEE5AC63BD9CDD4614CBA0", hash_generated_method = "6FA29B8EA3A98AC027333ACBE8D9B456")
     void rsnContextDestroy(int con) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.388 -0400", hash_original_method = "C5E77EED8025038F271CF4684A92DF9D", hash_generated_method = "18B2E1E604DBAA7F78C062BEEAB596D2")
    synchronized void nContextDestroy() {
        validate();
        rsnContextDestroy(mContext);
        // ---------- Original Method ----------
        //validate();
        //rsnContextDestroy(mContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.393 -0400", hash_original_method = "EB21769075BE69C0C8886AAA59B58B10", hash_generated_method = "7D1A82C5F80B68B5BA7D6564FE808358")
     void rsnContextSetSurface(int con, int w, int h, Surface sur) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.397 -0400", hash_original_method = "A57FAAFB6E151E0BB6D4588D4B880844", hash_generated_method = "27358579A0EC4094DBA4367A9AD0919B")
    synchronized void nContextSetSurface(int w, int h, Surface sur) {
        addTaint(sur.getTaint());
        addTaint(h);
        addTaint(w);
        validate();
        rsnContextSetSurface(mContext, w, h, sur);
        // ---------- Original Method ----------
        //validate();
        //rsnContextSetSurface(mContext, w, h, sur);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.402 -0400", hash_original_method = "3D8D3CB35029BD7A3D839DEBFE214FCF", hash_generated_method = "C63619BF822EDB2486279FBA893306B0")
     void rsnContextSetSurfaceTexture(int con, int w, int h, SurfaceTexture sur) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.408 -0400", hash_original_method = "053D226D8DB22C1C63CE12AFDF45E46E", hash_generated_method = "D8E3452232C0797A6F3A4C574D5D65B5")
    synchronized void nContextSetSurfaceTexture(int w, int h, SurfaceTexture sur) {
        addTaint(sur.getTaint());
        addTaint(h);
        addTaint(w);
        validate();
        rsnContextSetSurfaceTexture(mContext, w, h, sur);
        // ---------- Original Method ----------
        //validate();
        //rsnContextSetSurfaceTexture(mContext, w, h, sur);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.412 -0400", hash_original_method = "2593188FF9A71C43FC5D80F3F60B911F", hash_generated_method = "B166E5768C65D7F90BDCFD6996E622E8")
     void rsnContextSetPriority(int con, int p) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.419 -0400", hash_original_method = "61DE383D49720578BAA35F595DEEA5F2", hash_generated_method = "41EF9FDBD436ED0C5567229CC07AF8A7")
    synchronized void nContextSetPriority(int p) {
        addTaint(p);
        validate();
        rsnContextSetPriority(mContext, p);
        // ---------- Original Method ----------
        //validate();
        //rsnContextSetPriority(mContext, p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.424 -0400", hash_original_method = "1A842DB75F6BBE9B50F7518F02BF2818", hash_generated_method = "66D84AA6B8E24EB39ADB3FB26BE624DD")
     void rsnContextDump(int con, int bits) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.428 -0400", hash_original_method = "248EC68B2A45083AEE3CDB91CF7C92F0", hash_generated_method = "95691DEFCD6E87391341B80336866B38")
    synchronized void nContextDump(int bits) {
        addTaint(bits);
        validate();
        rsnContextDump(mContext, bits);
        // ---------- Original Method ----------
        //validate();
        //rsnContextDump(mContext, bits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.431 -0400", hash_original_method = "0C7B45782D52A09147084311B49664D7", hash_generated_method = "07225225F690DBAF2FC2327CCA24CCD9")
     void rsnContextFinish(int con) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.437 -0400", hash_original_method = "88AFB5D6D20505102DAE97A58843F3DC", hash_generated_method = "F3B26661C8EB3F01746D1F989E6E31F4")
    synchronized void nContextFinish() {
        validate();
        rsnContextFinish(mContext);
        // ---------- Original Method ----------
        //validate();
        //rsnContextFinish(mContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.441 -0400", hash_original_method = "E4468512F11EFAA75CD65D530F3E6710", hash_generated_method = "3A30E8FD007F9CB7D1EC56E951F5C955")
     void rsnContextBindRootScript(int con, int script) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.446 -0400", hash_original_method = "D8E8F4DB394344A4FF3B7250256E824C", hash_generated_method = "6B527357088D9287B8DFF6A9830C8E7B")
    synchronized void nContextBindRootScript(int script) {
        addTaint(script);
        validate();
        rsnContextBindRootScript(mContext, script);
        // ---------- Original Method ----------
        //validate();
        //rsnContextBindRootScript(mContext, script);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.453 -0400", hash_original_method = "367487DF84DFA0BAA046FDED24CAE25E", hash_generated_method = "2807969D614CF47FCD69D6BC4435C610")
     void rsnContextBindSampler(int con, int sampler, int slot) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.458 -0400", hash_original_method = "AFD08607E4DD74B65DF9EFD1B93B519B", hash_generated_method = "9695A871DE60CFBA09104F1FD6F3C4EB")
    synchronized void nContextBindSampler(int sampler, int slot) {
        addTaint(slot);
        addTaint(sampler);
        validate();
        rsnContextBindSampler(mContext, sampler, slot);
        // ---------- Original Method ----------
        //validate();
        //rsnContextBindSampler(mContext, sampler, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.463 -0400", hash_original_method = "70F76B7F943E056527EFD106C36D72FC", hash_generated_method = "6D78F9CA32CD684AF00126B6DF0B7DF0")
     void rsnContextBindProgramStore(int con, int pfs) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.467 -0400", hash_original_method = "68D7363FCC4EC21EEF5F8D4BAC5EF452", hash_generated_method = "96478C314F8FA7A7428BA51B9A9CD94E")
    synchronized void nContextBindProgramStore(int pfs) {
        addTaint(pfs);
        validate();
        rsnContextBindProgramStore(mContext, pfs);
        // ---------- Original Method ----------
        //validate();
        //rsnContextBindProgramStore(mContext, pfs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.474 -0400", hash_original_method = "82A1278D65A372B03CD56DD87C8A9A84", hash_generated_method = "08354A3FE4987871B096E91FA95462F8")
     void rsnContextBindProgramFragment(int con, int pf) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.478 -0400", hash_original_method = "1F420C5E57E15F5EA59327C192955502", hash_generated_method = "43D6400CF7A10E74C61F7D21492BFEFF")
    synchronized void nContextBindProgramFragment(int pf) {
        addTaint(pf);
        validate();
        rsnContextBindProgramFragment(mContext, pf);
        // ---------- Original Method ----------
        //validate();
        //rsnContextBindProgramFragment(mContext, pf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.481 -0400", hash_original_method = "58875F1D5BE9B0875716EDD4783F8535", hash_generated_method = "BA2E7F96982446E84FB93021A14FD200")
     void rsnContextBindProgramVertex(int con, int pv) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.486 -0400", hash_original_method = "8C4B4B2A1CE620607E8C9F820ADF7411", hash_generated_method = "A8A8186D31B61C58725C8A58AE7DC85D")
    synchronized void nContextBindProgramVertex(int pv) {
        addTaint(pv);
        validate();
        rsnContextBindProgramVertex(mContext, pv);
        // ---------- Original Method ----------
        //validate();
        //rsnContextBindProgramVertex(mContext, pv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.490 -0400", hash_original_method = "5EE25D946D565696B054063A4BC4E7E5", hash_generated_method = "F3CE9FCFC20CDF1C4D79013723CC0006")
     void rsnContextBindProgramRaster(int con, int pr) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.494 -0400", hash_original_method = "A0B057C7956173D5D797DAE35AD47DB0", hash_generated_method = "8111F99C345A942FC942D74FA5109ED1")
    synchronized void nContextBindProgramRaster(int pr) {
        addTaint(pr);
        validate();
        rsnContextBindProgramRaster(mContext, pr);
        // ---------- Original Method ----------
        //validate();
        //rsnContextBindProgramRaster(mContext, pr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.498 -0400", hash_original_method = "A6B4F3AAB21598449C9A14AB5C5C63A0", hash_generated_method = "D61FFB4E2E476F56E08E218AFC3622AF")
     void rsnContextPause(int con) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.500 -0400", hash_original_method = "F73975B5904A87B19685943474817E3D", hash_generated_method = "041EB6C46A2D0C217AC54092CF3AD3AE")
    synchronized void nContextPause() {
        validate();
        rsnContextPause(mContext);
        // ---------- Original Method ----------
        //validate();
        //rsnContextPause(mContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.503 -0400", hash_original_method = "2A894A4DED0A4EFC7176BB282B87AC42", hash_generated_method = "D247180B97ACE95D2FEF5EF7E3D9D5D3")
     void rsnContextResume(int con) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.508 -0400", hash_original_method = "8F0FF9572DEFDEC900895347CEE974A8", hash_generated_method = "D5FE739E6DA251B3D1F6DA456F046287")
    synchronized void nContextResume() {
        validate();
        rsnContextResume(mContext);
        // ---------- Original Method ----------
        //validate();
        //rsnContextResume(mContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.513 -0400", hash_original_method = "06C95D837B75EADFCF0F9AFEF967EE0C", hash_generated_method = "F03BED375D2C490E08B1F033BB0D3C15")
     void rsnAssignName(int con, int obj, byte[] name) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.515 -0400", hash_original_method = "8AE682AE559386D264AE4EAC41105882", hash_generated_method = "D7136EB1E9159D99698ABBA203F82646")
    synchronized void nAssignName(int obj, byte[] name) {
        addTaint(name[0]);
        addTaint(obj);
        validate();
        rsnAssignName(mContext, obj, name);
        // ---------- Original Method ----------
        //validate();
        //rsnAssignName(mContext, obj, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.519 -0400", hash_original_method = "6CFEA087E7A290E3C39BE13FE6867185", hash_generated_method = "E4F6A8A0464E8FFDD20E28A294151A61")
     String rsnGetName(int con, int obj) {
    	addTaint(con);
    	addTaint(obj);
    	String retVal = new String();
    	retVal.addTaint(taint);
    	return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.522 -0400", hash_original_method = "1319AD6AF7285704CDBB77DE60110138", hash_generated_method = "B40CC58B5485CBAF391130F7E4EB5B7C")
    synchronized String nGetName(int obj) {
        addTaint(obj);
        validate();
String var9CDC149B46767D0165FA75FFC9A1A976_1451987286 =         rsnGetName(mContext, obj);
        var9CDC149B46767D0165FA75FFC9A1A976_1451987286.addTaint(taint);
        return var9CDC149B46767D0165FA75FFC9A1A976_1451987286;
        // ---------- Original Method ----------
        //validate();
        //return rsnGetName(mContext, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.525 -0400", hash_original_method = "B170AA080491DF0B3E272A4B1A2F6C89", hash_generated_method = "862F69F9B5D5FF9A176E95C265DEE57B")
     void rsnObjDestroy(int con, int id) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.529 -0400", hash_original_method = "3CD43707F03704504C516530F93524E9", hash_generated_method = "1494140782E6C49CC50653D4D3BF1D09")
    synchronized void nObjDestroy(int id) {
        addTaint(id);
        if(mContext != 0)        
        {
            rsnObjDestroy(mContext, id);
        } //End block
        // ---------- Original Method ----------
        //if (mContext != 0) {
            //rsnObjDestroy(mContext, id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.536 -0400", hash_original_method = "A23832C8C4F03477F79E249ABA3C5448", hash_generated_method = "0005BFCA388FD5F8D99835673BC32B8E")
     int rsnElementCreate(int con, int type, int kind, boolean norm, int vecSize) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2138618390 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2138618390;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.548 -0400", hash_original_method = "04F100AE25E26F680C6AFD4CDC98FC1F", hash_generated_method = "F181F10DE3C329D30821F61BB62BD14E")
    synchronized int nElementCreate(int type, int kind, boolean norm, int vecSize) {
        addTaint(vecSize);
        addTaint(norm);
        addTaint(kind);
        addTaint(type);
        validate();
        int varBE314AAB6292E91A511EE07F37A53143_49735489 = (rsnElementCreate(mContext, type, kind, norm, vecSize));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2096765944 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2096765944;
        // ---------- Original Method ----------
        //validate();
        //return rsnElementCreate(mContext, type, kind, norm, vecSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.554 -0400", hash_original_method = "006061C4AD57EAE572CDCF8F10BA8A13", hash_generated_method = "43243535275B446A4C672A61EA18B33A")
     int rsnElementCreate2(int con, int[] elements, String[] names, int[] arraySizes) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1887121491 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1887121491;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.558 -0400", hash_original_method = "0F9A5A9DC528909436C7DAB5B96B0A92", hash_generated_method = "8FB41A3B884E9A8222075AFC5ABBC7A9")
    synchronized int nElementCreate2(int[] elements, String[] names, int[] arraySizes) {
        addTaint(arraySizes[0]);
        addTaint(names[0].getTaint());
        addTaint(elements[0]);
        validate();
        int var0FE84976DD242C20327C91123D81D82E_1835056640 = (rsnElementCreate2(mContext, elements, names, arraySizes));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574657327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574657327;
        // ---------- Original Method ----------
        //validate();
        //return rsnElementCreate2(mContext, elements, names, arraySizes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.563 -0400", hash_original_method = "C49261353C664D6FA896CF226B67D498", hash_generated_method = "AE26D1E58CD22E1D7CE6A735FC991A81")
     void rsnElementGetNativeData(int con, int id, int[] elementData) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.566 -0400", hash_original_method = "ED92A0CF1AB71C2B4406A54EAA77DB9F", hash_generated_method = "ADBD43207BA4EF2F6F5DA9203F2E5087")
    synchronized void nElementGetNativeData(int id, int[] elementData) {
        addTaint(elementData[0]);
        addTaint(id);
        validate();
        rsnElementGetNativeData(mContext, id, elementData);
        // ---------- Original Method ----------
        //validate();
        //rsnElementGetNativeData(mContext, id, elementData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.571 -0400", hash_original_method = "33A6434B836B117A2B38B29F8831D0F0", hash_generated_method = "410355FE35675AC81B3EE136856CF261")
     void rsnElementGetSubElements(int con, int id,
                                         int[] IDs, String[] names, int[] arraySizes) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.576 -0400", hash_original_method = "EF8F1F438E62125221A12E7AB1122C9E", hash_generated_method = "42BD8825FD4F77BAEFB3BE3FAD4278D7")
    synchronized void nElementGetSubElements(int id, int[] IDs, String[] names, int[] arraySizes) {
        addTaint(arraySizes[0]);
        addTaint(names[0].getTaint());
        addTaint(IDs[0]);
        addTaint(id);
        validate();
        rsnElementGetSubElements(mContext, id, IDs, names, arraySizes);
        // ---------- Original Method ----------
        //validate();
        //rsnElementGetSubElements(mContext, id, IDs, names, arraySizes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.581 -0400", hash_original_method = "994B815F598F428E534810B5FF2CA01E", hash_generated_method = "6A4915ABF167209A2DDBB36666B6A38B")
     int rsnTypeCreate(int con, int eid, int x, int y, int z, boolean mips, boolean faces) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1634432232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1634432232;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.587 -0400", hash_original_method = "5BC12238B0743B47577319FCBD22C49B", hash_generated_method = "D62981E26D029F3CB24F9CA312B066BB")
    synchronized int nTypeCreate(int eid, int x, int y, int z, boolean mips, boolean faces) {
        addTaint(faces);
        addTaint(mips);
        addTaint(z);
        addTaint(y);
        addTaint(x);
        addTaint(eid);
        validate();
        int varDC160E9E97DDBE423098341048689578_1067311082 = (rsnTypeCreate(mContext, eid, x, y, z, mips, faces));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1690349978 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1690349978;
        // ---------- Original Method ----------
        //validate();
        //return rsnTypeCreate(mContext, eid, x, y, z, mips, faces);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.590 -0400", hash_original_method = "F312FE90A7285CB098BF912090C5FAB1", hash_generated_method = "FF275287A4FA3A5150337A8EA8275689")
     void rsnTypeGetNativeData(int con, int id, int[] typeData) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.595 -0400", hash_original_method = "14DE3B66A3D39638378078881D754C6E", hash_generated_method = "E589096FDACFBCDBCBD5344BDAFA353B")
    synchronized void nTypeGetNativeData(int id, int[] typeData) {
        addTaint(typeData[0]);
        addTaint(id);
        validate();
        rsnTypeGetNativeData(mContext, id, typeData);
        // ---------- Original Method ----------
        //validate();
        //rsnTypeGetNativeData(mContext, id, typeData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.600 -0400", hash_original_method = "1EF04876BAB02F926C35D0D430944B30", hash_generated_method = "A301521BBC730691F8A6EF1577CC2D5C")
     int rsnAllocationCreateTyped(int con, int type, int mip, int usage) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180106816 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180106816;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.607 -0400", hash_original_method = "14A63C0D1BE64E9A6BBEC637317D094F", hash_generated_method = "C6D4874FDB65BFAD9BFEE9A65747D516")
    synchronized int nAllocationCreateTyped(int type, int mip, int usage) {
        addTaint(usage);
        addTaint(mip);
        addTaint(type);
        validate();
        int var28F0A98EAA5F9BA5168F48E27C1F47E8_1764727106 = (rsnAllocationCreateTyped(mContext, type, mip, usage));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1438426961 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1438426961;
        // ---------- Original Method ----------
        //validate();
        //return rsnAllocationCreateTyped(mContext, type, mip, usage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.613 -0400", hash_original_method = "5E0A2F1801533641650164E2B5110D9B", hash_generated_method = "B6D727D623E4C92E01A809ADD8933C7F")
     int rsnAllocationCreateFromBitmap(int con, int type, int mip, Bitmap bmp, int usage) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117312959 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117312959;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.620 -0400", hash_original_method = "C38046DC6D50E5167A216243F556CC46", hash_generated_method = "B97A36CDD74FF5AC4C71CDCFA8300881")
    synchronized int nAllocationCreateFromBitmap(int type, int mip, Bitmap bmp, int usage) {
        addTaint(usage);
        addTaint(bmp.getTaint());
        addTaint(mip);
        addTaint(type);
        validate();
        int varC5E8C66C48E0470718685D0E3398FB6E_967110994 = (rsnAllocationCreateFromBitmap(mContext, type, mip, bmp, usage));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406784414 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406784414;
        // ---------- Original Method ----------
        //validate();
        //return rsnAllocationCreateFromBitmap(mContext, type, mip, bmp, usage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.625 -0400", hash_original_method = "78AC0674291BD672E8BF6DD1FCB58CB6", hash_generated_method = "B4E95E67BF6D31762060A2D40809D784")
     int rsnAllocationCubeCreateFromBitmap(int con, int type, int mip, Bitmap bmp, int usage) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913798079 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913798079;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.629 -0400", hash_original_method = "1C76695BCAC6B196308AF162882963A2", hash_generated_method = "52534C766C9D82B3C8A1047FA3DE83DF")
    synchronized int nAllocationCubeCreateFromBitmap(int type, int mip, Bitmap bmp, int usage) {
        addTaint(usage);
        addTaint(bmp.getTaint());
        addTaint(mip);
        addTaint(type);
        validate();
        int var8F9C0C6D1F31DEB079536511B04FD9F9_2066553826 = (rsnAllocationCubeCreateFromBitmap(mContext, type, mip, bmp, usage));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1349941898 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1349941898;
        // ---------- Original Method ----------
        //validate();
        //return rsnAllocationCubeCreateFromBitmap(mContext, type, mip, bmp, usage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.634 -0400", hash_original_method = "180A66856BA5C89E33ED9E70F522DAF8", hash_generated_method = "7BF45D927EB52F44B8FD7D41B94492C3")
     int rsnAllocationCreateBitmapRef(int con, int type, Bitmap bmp) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605271202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605271202;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.640 -0400", hash_original_method = "5BEDEEA6EE7AFE0E77451EBA243C265F", hash_generated_method = "53E221EA56CA205E8DF1D97F0910F233")
    synchronized int nAllocationCreateBitmapRef(int type, Bitmap bmp) {
        addTaint(bmp.getTaint());
        addTaint(type);
        validate();
        int var27C6B7C0E2D6DB05060094320E12A6D6_858679099 = (rsnAllocationCreateBitmapRef(mContext, type, bmp));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_67621632 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_67621632;
        // ---------- Original Method ----------
        //validate();
        //return rsnAllocationCreateBitmapRef(mContext, type, bmp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.645 -0400", hash_original_method = "659BC129345B51ED115EA0AF453E73DA", hash_generated_method = "0498DC5D3637DF4E96E6E33B5DB7ADE2")
     int rsnAllocationCreateFromAssetStream(int con, int mips, int assetStream, int usage) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110905798 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110905798;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.649 -0400", hash_original_method = "FCDA7166178C095DBC408E6F28FA0674", hash_generated_method = "3D3B3B2DBC9ECDD955091C12B7E24D81")
    synchronized int nAllocationCreateFromAssetStream(int mips, int assetStream, int usage) {
        addTaint(usage);
        addTaint(assetStream);
        addTaint(mips);
        validate();
        int var9E0DE8EB0E3A1F1281F4CF8632FD11C2_1006653693 = (rsnAllocationCreateFromAssetStream(mContext, mips, assetStream, usage));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_96478844 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_96478844;
        // ---------- Original Method ----------
        //validate();
        //return rsnAllocationCreateFromAssetStream(mContext, mips, assetStream, usage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.654 -0400", hash_original_method = "6B8384B4227CBF77C9DD330F22899701", hash_generated_method = "F052A2E035ED180304569E0C03F0F8A4")
     void rsnAllocationCopyToBitmap(int con, int alloc, Bitmap bmp) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.659 -0400", hash_original_method = "33A1DADE17FD02C344DA52C79E764A6E", hash_generated_method = "4F7DB349FE3228EF29331A3909C614C0")
    synchronized void nAllocationCopyToBitmap(int alloc, Bitmap bmp) {
        addTaint(bmp.getTaint());
        addTaint(alloc);
        validate();
        rsnAllocationCopyToBitmap(mContext, alloc, bmp);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationCopyToBitmap(mContext, alloc, bmp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.665 -0400", hash_original_method = "3121E732BD190EDE1807049E3BD6D7DA", hash_generated_method = "5B4C6EB0E25F43AF0E6A78FFB63F7D71")
     void rsnAllocationSyncAll(int con, int alloc, int src) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.670 -0400", hash_original_method = "00E19076EDF1F68A332E30E1DA83ABC3", hash_generated_method = "8C4C5B10E6422191D3F8B4B1F4C62875")
    synchronized void nAllocationSyncAll(int alloc, int src) {
        addTaint(src);
        addTaint(alloc);
        validate();
        rsnAllocationSyncAll(mContext, alloc, src);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationSyncAll(mContext, alloc, src);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.673 -0400", hash_original_method = "70B64AEBC9F2A08DD702D1F1083AF457", hash_generated_method = "69FE9F21F00A68FBF1E359FF0ED9CDEF")
     void rsnAllocationGenerateMipmaps(int con, int alloc) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.677 -0400", hash_original_method = "80A37887BF534CD573848EE87B5881CB", hash_generated_method = "070B5A7157786750F03F823BBD81DA59")
    synchronized void nAllocationGenerateMipmaps(int alloc) {
        addTaint(alloc);
        validate();
        rsnAllocationGenerateMipmaps(mContext, alloc);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationGenerateMipmaps(mContext, alloc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.681 -0400", hash_original_method = "90AF2E8BDCC3B2A5C7CEEAB496515689", hash_generated_method = "58CF2055C7C1CDC39C71211090E0ED0C")
     void rsnAllocationCopyFromBitmap(int con, int alloc, Bitmap bmp) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.687 -0400", hash_original_method = "DEDA373B30BBD5AB8E63FE00A208FC33", hash_generated_method = "BBD29444998B84F1C25ED6F332546D60")
    synchronized void nAllocationCopyFromBitmap(int alloc, Bitmap bmp) {
        addTaint(bmp.getTaint());
        addTaint(alloc);
        validate();
        rsnAllocationCopyFromBitmap(mContext, alloc, bmp);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationCopyFromBitmap(mContext, alloc, bmp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.692 -0400", hash_original_method = "1C01F509C8F49D01D10DE0EA5CB1F527", hash_generated_method = "E6299F1AC89FC3E6802E92648074614B")
     void rsnAllocationData1D(int con, int id, int off, int mip, int count, int[] d, int sizeBytes) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.697 -0400", hash_original_method = "5856F0672F738C4E210FC0F2E55D57A5", hash_generated_method = "8CC880BB5B09BDAB8E7CCB5F41F625F3")
    synchronized void nAllocationData1D(int id, int off, int mip, int count, int[] d, int sizeBytes) {
        addTaint(sizeBytes);
        addTaint(d[0]);
        addTaint(count);
        addTaint(mip);
        addTaint(off);
        addTaint(id);
        validate();
        rsnAllocationData1D(mContext, id, off, mip, count, d, sizeBytes);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationData1D(mContext, id, off, mip, count, d, sizeBytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.701 -0400", hash_original_method = "FDF60A90B9E11C1D899645930F7523E3", hash_generated_method = "1FEA8ADCACE45248F6E39136614BD02A")
     void rsnAllocationData1D(int con, int id, int off, int mip, int count, short[] d, int sizeBytes) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.707 -0400", hash_original_method = "E0E3C0B0ECD98F97C6BCBD38CE726044", hash_generated_method = "137A30707FB455E22DAA5D049718FEC7")
    synchronized void nAllocationData1D(int id, int off, int mip, int count, short[] d, int sizeBytes) {
        addTaint(sizeBytes);
        addTaint(d[0]);
        addTaint(count);
        addTaint(mip);
        addTaint(off);
        addTaint(id);
        validate();
        rsnAllocationData1D(mContext, id, off, mip, count, d, sizeBytes);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationData1D(mContext, id, off, mip, count, d, sizeBytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.714 -0400", hash_original_method = "B57CF17F316A444F47B4E2E8E4737041", hash_generated_method = "31B225F9693C853351786DFAB7480F10")
     void rsnAllocationData1D(int con, int id, int off, int mip, int count, byte[] d, int sizeBytes) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.719 -0400", hash_original_method = "1629FA43490A3E016402068846DD0F5F", hash_generated_method = "4008D43FBEB05AC7A299E6091CFBB5C5")
    synchronized void nAllocationData1D(int id, int off, int mip, int count, byte[] d, int sizeBytes) {
        addTaint(sizeBytes);
        addTaint(d[0]);
        addTaint(count);
        addTaint(mip);
        addTaint(off);
        addTaint(id);
        validate();
        rsnAllocationData1D(mContext, id, off, mip, count, d, sizeBytes);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationData1D(mContext, id, off, mip, count, d, sizeBytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.724 -0400", hash_original_method = "80FDFEBE6C2830B2A228AC81FC751501", hash_generated_method = "A2AC47DF36297B2A491D2ECBC6D18CE6")
     void rsnAllocationData1D(int con, int id, int off, int mip, int count, float[] d, int sizeBytes) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.730 -0400", hash_original_method = "722C4C8DF700A391C4018926795A6887", hash_generated_method = "E0DE510D206C12274D8E4A5575026E91")
    synchronized void nAllocationData1D(int id, int off, int mip, int count, float[] d, int sizeBytes) {
        addTaint(sizeBytes);
        addTaint(d[0]);
        addTaint(count);
        addTaint(mip);
        addTaint(off);
        addTaint(id);
        validate();
        rsnAllocationData1D(mContext, id, off, mip, count, d, sizeBytes);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationData1D(mContext, id, off, mip, count, d, sizeBytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.735 -0400", hash_original_method = "44CF80DA13785695234C9F6E63004FA6", hash_generated_method = "FCB65608C01157AC75BE5D681F526F0A")
     void rsnAllocationElementData1D(int con, int id, int xoff, int mip, int compIdx, byte[] d, int sizeBytes) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.740 -0400", hash_original_method = "DE600857C9D165E3FCB6D7CAA71BB9E8", hash_generated_method = "F6BA1A5041F9A740AF96F67B1B51255D")
    synchronized void nAllocationElementData1D(int id, int xoff, int mip, int compIdx, byte[] d, int sizeBytes) {
        addTaint(sizeBytes);
        addTaint(d[0]);
        addTaint(compIdx);
        addTaint(mip);
        addTaint(xoff);
        addTaint(id);
        validate();
        rsnAllocationElementData1D(mContext, id, xoff, mip, compIdx, d, sizeBytes);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationElementData1D(mContext, id, xoff, mip, compIdx, d, sizeBytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.746 -0400", hash_original_method = "682805A358DBA000E103929465DD3222", hash_generated_method = "50E741A8B6D8FA9143C0C91A8D179DEC")
     void rsnAllocationData2D(int con,
                                    int dstAlloc, int dstXoff, int dstYoff,
                                    int dstMip, int dstFace,
                                    int width, int height,
                                    int srcAlloc, int srcXoff, int srcYoff,
                                    int srcMip, int srcFace) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.752 -0400", hash_original_method = "466039336F12CBCD5A6796B706C69F57", hash_generated_method = "B6BF9441FFBC701579E7F6AB5EEC77AD")
    synchronized void nAllocationData2D(int dstAlloc, int dstXoff, int dstYoff,
                                        int dstMip, int dstFace,
                                        int width, int height,
                                        int srcAlloc, int srcXoff, int srcYoff,
                                        int srcMip, int srcFace) {
        addTaint(srcFace);
        addTaint(srcMip);
        addTaint(srcYoff);
        addTaint(srcXoff);
        addTaint(srcAlloc);
        addTaint(height);
        addTaint(width);
        addTaint(dstFace);
        addTaint(dstMip);
        addTaint(dstYoff);
        addTaint(dstXoff);
        addTaint(dstAlloc);
        validate();
        rsnAllocationData2D(mContext,
                            dstAlloc, dstXoff, dstYoff,
                            dstMip, dstFace,
                            width, height,
                            srcAlloc, srcXoff, srcYoff,
                            srcMip, srcFace);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationData2D(mContext,
                            //dstAlloc, dstXoff, dstYoff,
                            //dstMip, dstFace,
                            //width, height,
                            //srcAlloc, srcXoff, srcYoff,
                            //srcMip, srcFace);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.758 -0400", hash_original_method = "DA3DFEEFC474AD7115E2A7A23009F794", hash_generated_method = "1A74AB6F31871E6BF8D452A64623A051")
     void rsnAllocationData2D(int con, int id, int xoff, int yoff, int mip, int face, int w, int h, byte[] d, int sizeBytes) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.765 -0400", hash_original_method = "6BF9C83DF089B7D0B998D3C82F0B1FA0", hash_generated_method = "5DF5C0D8F416CEDE31DA5D1B152B1AE4")
    synchronized void nAllocationData2D(int id, int xoff, int yoff, int mip, int face, int w, int h, byte[] d, int sizeBytes) {
        addTaint(sizeBytes);
        addTaint(d[0]);
        addTaint(h);
        addTaint(w);
        addTaint(face);
        addTaint(mip);
        addTaint(yoff);
        addTaint(xoff);
        addTaint(id);
        validate();
        rsnAllocationData2D(mContext, id, xoff, yoff, mip, face, w, h, d, sizeBytes);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationData2D(mContext, id, xoff, yoff, mip, face, w, h, d, sizeBytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.771 -0400", hash_original_method = "7DEA1BB6C4AA745C8B1CC03EAA766803", hash_generated_method = "ACF3C7F2E5E2CD14C75A3A147058C099")
     void rsnAllocationData2D(int con, int id, int xoff, int yoff, int mip, int face, int w, int h, short[] d, int sizeBytes) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.776 -0400", hash_original_method = "9BA3D71C4DAE136A278E0FEE1F9ABC46", hash_generated_method = "80E0665E85A9B594077D5669E4BE79AC")
    synchronized void nAllocationData2D(int id, int xoff, int yoff, int mip, int face, int w, int h, short[] d, int sizeBytes) {
        addTaint(sizeBytes);
        addTaint(d[0]);
        addTaint(h);
        addTaint(w);
        addTaint(face);
        addTaint(mip);
        addTaint(yoff);
        addTaint(xoff);
        addTaint(id);
        validate();
        rsnAllocationData2D(mContext, id, xoff, yoff, mip, face, w, h, d, sizeBytes);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationData2D(mContext, id, xoff, yoff, mip, face, w, h, d, sizeBytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.781 -0400", hash_original_method = "6832BBFE570C1FD2D0DD153BF32FE8F4", hash_generated_method = "BFFBD4C784D061BB7433997C77BE5EF1")
     void rsnAllocationData2D(int con, int id, int xoff, int yoff, int mip, int face, int w, int h, int[] d, int sizeBytes) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.788 -0400", hash_original_method = "18C1C235A616F7FB4F95911B51D167D3", hash_generated_method = "DA9D16B682D100169C9E95B5E7A027C4")
    synchronized void nAllocationData2D(int id, int xoff, int yoff, int mip, int face, int w, int h, int[] d, int sizeBytes) {
        addTaint(sizeBytes);
        addTaint(d[0]);
        addTaint(h);
        addTaint(w);
        addTaint(face);
        addTaint(mip);
        addTaint(yoff);
        addTaint(xoff);
        addTaint(id);
        validate();
        rsnAllocationData2D(mContext, id, xoff, yoff, mip, face, w, h, d, sizeBytes);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationData2D(mContext, id, xoff, yoff, mip, face, w, h, d, sizeBytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.793 -0400", hash_original_method = "B6F49D413C56B3B78BC375C0469BE240", hash_generated_method = "626D79DC7489A2003AFA2920B952E91A")
     void rsnAllocationData2D(int con, int id, int xoff, int yoff, int mip, int face, int w, int h, float[] d, int sizeBytes) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.800 -0400", hash_original_method = "5B0B36C68109F844B2872F22AC2A0713", hash_generated_method = "2F436852D5CF6714E620B6E291EC4C00")
    synchronized void nAllocationData2D(int id, int xoff, int yoff, int mip, int face, int w, int h, float[] d, int sizeBytes) {
        addTaint(sizeBytes);
        addTaint(d[0]);
        addTaint(h);
        addTaint(w);
        addTaint(face);
        addTaint(mip);
        addTaint(yoff);
        addTaint(xoff);
        addTaint(id);
        validate();
        rsnAllocationData2D(mContext, id, xoff, yoff, mip, face, w, h, d, sizeBytes);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationData2D(mContext, id, xoff, yoff, mip, face, w, h, d, sizeBytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.805 -0400", hash_original_method = "2B5B77E0B08431C78EA306DA88269EFD", hash_generated_method = "40D46E0771E11A9DFCA3806F99E0FD4F")
     void rsnAllocationData2D(int con, int id, int xoff, int yoff, int mip, int face, Bitmap b) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.808 -0400", hash_original_method = "0BBBDAA03FF274914B36CF4135F1320F", hash_generated_method = "8ABD4F670C4F416EA7B330A96B601C61")
    synchronized void nAllocationData2D(int id, int xoff, int yoff, int mip, int face, Bitmap b) {
        addTaint(b.getTaint());
        addTaint(face);
        addTaint(mip);
        addTaint(yoff);
        addTaint(xoff);
        addTaint(id);
        validate();
        rsnAllocationData2D(mContext, id, xoff, yoff, mip, face, b);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationData2D(mContext, id, xoff, yoff, mip, face, b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.814 -0400", hash_original_method = "DA7A5765B134D4DAD6F68BC55FDD6A80", hash_generated_method = "8E9999E8A05A5C9A1483A41A5A45FBB2")
     void rsnAllocationRead(int con, int id, byte[] d) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.819 -0400", hash_original_method = "92862620C93746FDC18FD4C3B1FBC2C9", hash_generated_method = "0CB553AD90DDB383B0C5A3BE86845207")
    synchronized void nAllocationRead(int id, byte[] d) {
        addTaint(d[0]);
        addTaint(id);
        validate();
        rsnAllocationRead(mContext, id, d);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationRead(mContext, id, d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.823 -0400", hash_original_method = "706DAEC288FC23DD66E5C781F2902537", hash_generated_method = "AEE04148115BC00ED9F1BF5B3F4BECD1")
     void rsnAllocationRead(int con, int id, short[] d) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.826 -0400", hash_original_method = "70B197E638C9B33B94B98D696E0DF1EE", hash_generated_method = "E8F7D5A0904A940585E743BA3E5F0575")
    synchronized void nAllocationRead(int id, short[] d) {
        addTaint(d[0]);
        addTaint(id);
        validate();
        rsnAllocationRead(mContext, id, d);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationRead(mContext, id, d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.829 -0400", hash_original_method = "8434FE2EE1CBF9D4B92804EB617B1975", hash_generated_method = "4CEC088E06510D7C830F6CB77FA40909")
     void rsnAllocationRead(int con, int id, int[] d) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.833 -0400", hash_original_method = "AA67CDF12A47ACA55B6091E0DE4E490D", hash_generated_method = "94C0AF51B0310222F902AD50C94893E1")
    synchronized void nAllocationRead(int id, int[] d) {
        addTaint(d[0]);
        addTaint(id);
        validate();
        rsnAllocationRead(mContext, id, d);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationRead(mContext, id, d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.856 -0400", hash_original_method = "AD441DD55E321F20539A93188DA8B240", hash_generated_method = "A623BF58298BB7B1CCEFE7DAE9BC999A")
     void rsnAllocationRead(int con, int id, float[] d) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.862 -0400", hash_original_method = "7BE8098A69829EC69DAFD2BED79C8C96", hash_generated_method = "7FEDD9E63E8BE8D78734A845F2D54EB4")
    synchronized void nAllocationRead(int id, float[] d) {
        addTaint(d[0]);
        addTaint(id);
        validate();
        rsnAllocationRead(mContext, id, d);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationRead(mContext, id, d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.865 -0400", hash_original_method = "FFE36F4830D9AE1ABA8A675B46783EF2", hash_generated_method = "CD83E287A5145E5FB455BED62E34F975")
     int rsnAllocationGetType(int con, int id) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187902420 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187902420;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.868 -0400", hash_original_method = "5415B0DAEC36E4470E9C2C35420A77FB", hash_generated_method = "85A7E99306DD8A56509FEC0CA5B1177A")
    synchronized int nAllocationGetType(int id) {
        addTaint(id);
        validate();
        int var5D7BFB210F27DB463BA2A3E8EFBCCFC1_2058035049 = (rsnAllocationGetType(mContext, id));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_943339649 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_943339649;
        // ---------- Original Method ----------
        //validate();
        //return rsnAllocationGetType(mContext, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.872 -0400", hash_original_method = "CE0C1AECDCD62EDFBCEC1C9EA07AE47A", hash_generated_method = "B528259F731052A58C894A1E4E6D0D73")
     void rsnAllocationResize1D(int con, int id, int dimX) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.876 -0400", hash_original_method = "B9152F199D1418FFC1B1326F10D9C26D", hash_generated_method = "D973C2F27EE744221F9D96B71DC0D744")
    synchronized void nAllocationResize1D(int id, int dimX) {
        addTaint(dimX);
        addTaint(id);
        validate();
        rsnAllocationResize1D(mContext, id, dimX);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationResize1D(mContext, id, dimX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.879 -0400", hash_original_method = "51C3F0EDFD5849ABEAF14775297F3D8D", hash_generated_method = "4E462273DB3031695BF7BD4073BAA127")
     void rsnAllocationResize2D(int con, int id, int dimX, int dimY) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.882 -0400", hash_original_method = "F6A2096E5C08E8B7A947CEC18429B5C0", hash_generated_method = "07841DB7E1185561F9E1EE26C651B55B")
    synchronized void nAllocationResize2D(int id, int dimX, int dimY) {
        addTaint(dimY);
        addTaint(dimX);
        addTaint(id);
        validate();
        rsnAllocationResize2D(mContext, id, dimX, dimY);
        // ---------- Original Method ----------
        //validate();
        //rsnAllocationResize2D(mContext, id, dimX, dimY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.886 -0400", hash_original_method = "09190CE6465F8E50D726E7F537565F54", hash_generated_method = "1D1A0EADADA3E6AFEDB8996F4E8356EF")
     int rsnFileA3DCreateFromAssetStream(int con, int assetStream) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862036398 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862036398;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.889 -0400", hash_original_method = "CE06132BC9BE17513589F52D66BB7BA4", hash_generated_method = "3C5FA25EA26C5B6FFDDF21942C81577B")
    synchronized int nFileA3DCreateFromAssetStream(int assetStream) {
        addTaint(assetStream);
        validate();
        int var4036B770F458BFB7EC1B14E3A89044D5_2108995352 = (rsnFileA3DCreateFromAssetStream(mContext, assetStream));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_508359012 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_508359012;
        // ---------- Original Method ----------
        //validate();
        //return rsnFileA3DCreateFromAssetStream(mContext, assetStream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.894 -0400", hash_original_method = "F6838A6ADF02EA75BD13EEE3FAA1C39A", hash_generated_method = "42FD665D1637341F94C810B01425951D")
     int rsnFileA3DCreateFromFile(int con, String path) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439739179 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439739179;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.897 -0400", hash_original_method = "259584A6C4AF840D3FCDDCC9825B817A", hash_generated_method = "EF45E853F8CA0FB8FB2D52F38F071386")
    synchronized int nFileA3DCreateFromFile(String path) {
        addTaint(path.getTaint());
        validate();
        int varAA58A9766D06504C5823E517C6FD11F0_1771667083 = (rsnFileA3DCreateFromFile(mContext, path));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2024912326 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2024912326;
        // ---------- Original Method ----------
        //validate();
        //return rsnFileA3DCreateFromFile(mContext, path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.899 -0400", hash_original_method = "09CEFBD2C394F11A2473BA687A5CAD9C", hash_generated_method = "AF21BC3318B193D3DD0CACDAFCED5258")
     int rsnFileA3DCreateFromAsset(int con, AssetManager mgr, String path) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_581208765 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_581208765;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.903 -0400", hash_original_method = "78D008846307EDF4BB828507DB4375FC", hash_generated_method = "060E6E6F5658E992C95EEC790DBF9CD1")
    synchronized int nFileA3DCreateFromAsset(AssetManager mgr, String path) {
        addTaint(path.getTaint());
        addTaint(mgr.getTaint());
        validate();
        int var764EF3D48A480F4DAD694F10D5824A83_161883398 = (rsnFileA3DCreateFromAsset(mContext, mgr, path));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1837766095 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1837766095;
        // ---------- Original Method ----------
        //validate();
        //return rsnFileA3DCreateFromAsset(mContext, mgr, path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.907 -0400", hash_original_method = "E83515FA6039EB0E25B32B02E6CEB77F", hash_generated_method = "196C0C89B61C71044AFE39A17EF70318")
     int rsnFileA3DGetNumIndexEntries(int con, int fileA3D) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398168911 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398168911;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.911 -0400", hash_original_method = "99F99C35E73D8D693E61A61415FFF9EA", hash_generated_method = "132C572774CE12874515A3BE5F38614C")
    synchronized int nFileA3DGetNumIndexEntries(int fileA3D) {
        addTaint(fileA3D);
        validate();
        int var437A027F97796A0402E6792A571D38C5_1672089472 = (rsnFileA3DGetNumIndexEntries(mContext, fileA3D));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2107762895 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2107762895;
        // ---------- Original Method ----------
        //validate();
        //return rsnFileA3DGetNumIndexEntries(mContext, fileA3D);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.914 -0400", hash_original_method = "083FBBD551DC759D09A4D41AFC623D49", hash_generated_method = "53D32C18633FE8A1AF06F91D64D477A6")
     void rsnFileA3DGetIndexEntries(int con, int fileA3D, int numEntries, int[] IDs, String[] names) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.917 -0400", hash_original_method = "085782AB2C8843757607A11D98246CAF", hash_generated_method = "635B2E56DA56E26A1B7C3373C772C3D4")
    synchronized void nFileA3DGetIndexEntries(int fileA3D, int numEntries, int[] IDs, String[] names) {
        addTaint(names[0].getTaint());
        addTaint(IDs[0]);
        addTaint(numEntries);
        addTaint(fileA3D);
        validate();
        rsnFileA3DGetIndexEntries(mContext, fileA3D, numEntries, IDs, names);
        // ---------- Original Method ----------
        //validate();
        //rsnFileA3DGetIndexEntries(mContext, fileA3D, numEntries, IDs, names);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.920 -0400", hash_original_method = "EBA33CD24FD2CC163BED3CFC10DAEBB3", hash_generated_method = "2E1E0F1FE96F4E17C955443CEFE8D0C1")
     int rsnFileA3DGetEntryByIndex(int con, int fileA3D, int index) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_828131453 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_828131453;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.926 -0400", hash_original_method = "5B50168153C855E5E04AADE079858E18", hash_generated_method = "554D8AF0C7A03E023626B44B4046A8EF")
    synchronized int nFileA3DGetEntryByIndex(int fileA3D, int index) {
        addTaint(index);
        addTaint(fileA3D);
        validate();
        int var77353DF7D7C66AAF989B00E3CA4AD3FE_1889622088 = (rsnFileA3DGetEntryByIndex(mContext, fileA3D, index));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1022942546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1022942546;
        // ---------- Original Method ----------
        //validate();
        //return rsnFileA3DGetEntryByIndex(mContext, fileA3D, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.930 -0400", hash_original_method = "340F5632848FA5D2CDAEF006EFD2A561", hash_generated_method = "AA6F841BA8E636C5E91B2F20D0C77FA7")
     int rsnFontCreateFromFile(int con, String fileName, float size, int dpi) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1003537095 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1003537095;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.933 -0400", hash_original_method = "28A28895F76BBC9CFBC68FD7763EFF95", hash_generated_method = "AC0D894A74F328809BDB44A6F93FDC21")
    synchronized int nFontCreateFromFile(String fileName, float size, int dpi) {
        addTaint(dpi);
        addTaint(size);
        addTaint(fileName.getTaint());
        validate();
        int var1342F49441CCF11FC4B3942E36428185_746018320 = (rsnFontCreateFromFile(mContext, fileName, size, dpi));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1867593058 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1867593058;
        // ---------- Original Method ----------
        //validate();
        //return rsnFontCreateFromFile(mContext, fileName, size, dpi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.937 -0400", hash_original_method = "0990697360294393EF10841D258568F9", hash_generated_method = "B487B733E6238F5B4165B215F4E98918")
     int rsnFontCreateFromAssetStream(int con, String name, float size, int dpi, int assetStream) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1269521910 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1269521910;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.942 -0400", hash_original_method = "B968FFC0200F2C5E93F70FBA02BD6807", hash_generated_method = "B9F15B995D8DD9C8598ECAB27339B1CC")
    synchronized int nFontCreateFromAssetStream(String name, float size, int dpi, int assetStream) {
        addTaint(assetStream);
        addTaint(dpi);
        addTaint(size);
        addTaint(name.getTaint());
        validate();
        int var07AE22AFC12FE581D95BF96CD3CB7C1F_908801454 = (rsnFontCreateFromAssetStream(mContext, name, size, dpi, assetStream));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380490117 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380490117;
        // ---------- Original Method ----------
        //validate();
        //return rsnFontCreateFromAssetStream(mContext, name, size, dpi, assetStream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.945 -0400", hash_original_method = "EAA4C52AA1C955B5AD3DCC553FC28E9F", hash_generated_method = "C0F146CC679108554812A862DE0F15A2")
     int rsnFontCreateFromAsset(int con, AssetManager mgr, String path, float size, int dpi) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069434083 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069434083;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.951 -0400", hash_original_method = "C697253A4D3C38A6CFB3ACB5EE2CAD91", hash_generated_method = "7A94F4D994D9550E6B07CC5AF3623726")
    synchronized int nFontCreateFromAsset(AssetManager mgr, String path, float size, int dpi) {
        addTaint(dpi);
        addTaint(size);
        addTaint(path.getTaint());
        addTaint(mgr.getTaint());
        validate();
        int varE98ECF047D29B9AE69C9D6D87B432D32_1097964937 = (rsnFontCreateFromAsset(mContext, mgr, path, size, dpi));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1650335502 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1650335502;
        // ---------- Original Method ----------
        //validate();
        //return rsnFontCreateFromAsset(mContext, mgr, path, size, dpi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.953 -0400", hash_original_method = "18F6766928BD2496841B330F96A93DA7", hash_generated_method = "270866A52B9430F3C908C798298044E0")
     void rsnScriptBindAllocation(int con, int script, int alloc, int slot) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.956 -0400", hash_original_method = "57405F6B532BC58637377E58D58B1A1A", hash_generated_method = "0F8D1CCA28887C4110288CF9ED389D73")
    synchronized void nScriptBindAllocation(int script, int alloc, int slot) {
        addTaint(slot);
        addTaint(alloc);
        addTaint(script);
        validate();
        rsnScriptBindAllocation(mContext, script, alloc, slot);
        // ---------- Original Method ----------
        //validate();
        //rsnScriptBindAllocation(mContext, script, alloc, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.958 -0400", hash_original_method = "51D4DD6285C6385CEC2901AA7D96C3F9", hash_generated_method = "49DDA40C1AE275A493B8716E14C2FFED")
     void rsnScriptSetTimeZone(int con, int script, byte[] timeZone) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.961 -0400", hash_original_method = "48BAAAF24107E03AA3257E0376F915FC", hash_generated_method = "1D12463CB87D449F738A48E6F4D9C3E9")
    synchronized void nScriptSetTimeZone(int script, byte[] timeZone) {
        addTaint(timeZone[0]);
        addTaint(script);
        validate();
        rsnScriptSetTimeZone(mContext, script, timeZone);
        // ---------- Original Method ----------
        //validate();
        //rsnScriptSetTimeZone(mContext, script, timeZone);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.964 -0400", hash_original_method = "9B180EC295A326A05B733BD89539D750", hash_generated_method = "41DFD16E2D5D9FEDB52BB0D9E1A0D6C5")
     void rsnScriptInvoke(int con, int id, int slot) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.969 -0400", hash_original_method = "7C1247C571044789B0C33D555F9DF160", hash_generated_method = "9CD4626814F8A18990B3419A1FA5551F")
    synchronized void nScriptInvoke(int id, int slot) {
        addTaint(slot);
        addTaint(id);
        validate();
        rsnScriptInvoke(mContext, id, slot);
        // ---------- Original Method ----------
        //validate();
        //rsnScriptInvoke(mContext, id, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.972 -0400", hash_original_method = "A0E23D75C3244113330177A36D432FA8", hash_generated_method = "FDBD723D277C0FFE2793A4F6CB1A35DA")
     void rsnScriptForEach(int con, int id, int slot, int ain, int aout, byte[] params) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.976 -0400", hash_original_method = "1CFC7A94FCFBCD561583C7AF787A5FD7", hash_generated_method = "877281B08C681157240272233249C5B6")
     void rsnScriptForEach(int con, int id, int slot, int ain, int aout) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.983 -0400", hash_original_method = "27222BF8CF1E37CCF21B04401F1EE63C", hash_generated_method = "111DC2905134BD17057BBE2759C5D6F1")
    synchronized void nScriptForEach(int id, int slot, int ain, int aout, byte[] params) {
        addTaint(params[0]);
        addTaint(aout);
        addTaint(ain);
        addTaint(slot);
        addTaint(id);
        validate();
        if(params == null)        
        {
            rsnScriptForEach(mContext, id, slot, ain, aout);
        } //End block
        else
        {
            rsnScriptForEach(mContext, id, slot, ain, aout, params);
        } //End block
        // ---------- Original Method ----------
        //validate();
        //if (params == null) {
            //rsnScriptForEach(mContext, id, slot, ain, aout);
        //} else {
            //rsnScriptForEach(mContext, id, slot, ain, aout, params);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.986 -0400", hash_original_method = "B9E1FC1B908E2E406E4393D0EF11FE9F", hash_generated_method = "55B2FC310ACF5E37F3897DF2BD731031")
     void rsnScriptInvokeV(int con, int id, int slot, byte[] params) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.990 -0400", hash_original_method = "DB210F2CE225572540E11A267A7106B3", hash_generated_method = "356C7DC30901AE80D10FC1A130AD6ECF")
    synchronized void nScriptInvokeV(int id, int slot, byte[] params) {
        addTaint(params[0]);
        addTaint(slot);
        addTaint(id);
        validate();
        rsnScriptInvokeV(mContext, id, slot, params);
        // ---------- Original Method ----------
        //validate();
        //rsnScriptInvokeV(mContext, id, slot, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.994 -0400", hash_original_method = "D8F234C930BE7A20C1E10F900091CCED", hash_generated_method = "47CE5C8BDFE4B4B33210D8EB8CC02A28")
     void rsnScriptSetVarI(int con, int id, int slot, int val) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.998 -0400", hash_original_method = "63E8F5B280969990BEAC43D4E0EF38F8", hash_generated_method = "F0151F29455CCA11EE8EAF370A3AEF1D")
    synchronized void nScriptSetVarI(int id, int slot, int val) {
        addTaint(val);
        addTaint(slot);
        addTaint(id);
        validate();
        rsnScriptSetVarI(mContext, id, slot, val);
        // ---------- Original Method ----------
        //validate();
        //rsnScriptSetVarI(mContext, id, slot, val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.001 -0400", hash_original_method = "605BA9B2284E874E74ADEC41E3481958", hash_generated_method = "B57456459525654EBF96F76E3F06486E")
     void rsnScriptSetVarJ(int con, int id, int slot, long val) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.005 -0400", hash_original_method = "788902B5F4AD2D00B18EC7BEE76B5EBA", hash_generated_method = "727693B09DA6C17BF78267132F740363")
    synchronized void nScriptSetVarJ(int id, int slot, long val) {
        addTaint(val);
        addTaint(slot);
        addTaint(id);
        validate();
        rsnScriptSetVarJ(mContext, id, slot, val);
        // ---------- Original Method ----------
        //validate();
        //rsnScriptSetVarJ(mContext, id, slot, val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.009 -0400", hash_original_method = "8E64101E3D7FE45660F010F941CFFBB6", hash_generated_method = "E746224241817373A12B4078896C674D")
     void rsnScriptSetVarF(int con, int id, int slot, float val) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.012 -0400", hash_original_method = "4E52AADA144D88D743331B7E6EDCB84C", hash_generated_method = "1900CA9FC6CCC1810F953574860BCFD1")
    synchronized void nScriptSetVarF(int id, int slot, float val) {
        addTaint(val);
        addTaint(slot);
        addTaint(id);
        validate();
        rsnScriptSetVarF(mContext, id, slot, val);
        // ---------- Original Method ----------
        //validate();
        //rsnScriptSetVarF(mContext, id, slot, val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.016 -0400", hash_original_method = "7C1C9B19C26998848F0F919D02610E77", hash_generated_method = "1501CD284BCE55B9BB96CBE88CE6568B")
     void rsnScriptSetVarD(int con, int id, int slot, double val) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.019 -0400", hash_original_method = "904F50593DCA228E32CBF04970112136", hash_generated_method = "92886F5ABB862999AC3E4093079BF35C")
    synchronized void nScriptSetVarD(int id, int slot, double val) {
        addTaint(val);
        addTaint(slot);
        addTaint(id);
        validate();
        rsnScriptSetVarD(mContext, id, slot, val);
        // ---------- Original Method ----------
        //validate();
        //rsnScriptSetVarD(mContext, id, slot, val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.022 -0400", hash_original_method = "959BD0E98B18AB542E1E3BED6ACCBEEE", hash_generated_method = "83A95238C5D0554FEDAB840FA906CD57")
     void rsnScriptSetVarV(int con, int id, int slot, byte[] val) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.027 -0400", hash_original_method = "0CA6A1373CCCAA2B761A251055F680EE", hash_generated_method = "ADFD72498544DAAD23325E76D8B9AB74")
    synchronized void nScriptSetVarV(int id, int slot, byte[] val) {
        addTaint(val[0]);
        addTaint(slot);
        addTaint(id);
        validate();
        rsnScriptSetVarV(mContext, id, slot, val);
        // ---------- Original Method ----------
        //validate();
        //rsnScriptSetVarV(mContext, id, slot, val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.032 -0400", hash_original_method = "55EF4E7BB4035AB3427C26A3D9517DDB", hash_generated_method = "4ECF7317189FFCD342EB66E6E33D8C74")
     void rsnScriptSetVarObj(int con, int id, int slot, int val) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.036 -0400", hash_original_method = "3195DAD065CDA5BA3B31D2107834F385", hash_generated_method = "162C4CD5C29D84B9CA0C63484AF3F4B7")
    synchronized void nScriptSetVarObj(int id, int slot, int val) {
        addTaint(val);
        addTaint(slot);
        addTaint(id);
        validate();
        rsnScriptSetVarObj(mContext, id, slot, val);
        // ---------- Original Method ----------
        //validate();
        //rsnScriptSetVarObj(mContext, id, slot, val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.039 -0400", hash_original_method = "CC94824DFA1E842EFBE8DA43E5120411", hash_generated_method = "FE29B622B256D46E081173F5B9900C7D")
     int rsnScriptCCreate(int con, String resName, String cacheDir,
                                 byte[] script, int length) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_440216358 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_440216358;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.043 -0400", hash_original_method = "4F8B925AC1F308D7AD1224364C3D3B15", hash_generated_method = "03891B13D9406FEF524B217DD4798B71")
    synchronized int nScriptCCreate(String resName, String cacheDir, byte[] script, int length) {
        addTaint(length);
        addTaint(script[0]);
        addTaint(cacheDir.getTaint());
        addTaint(resName.getTaint());
        validate();
        int var3418C68DC460754D7D39C8574509A9C6_2009027586 = (rsnScriptCCreate(mContext, resName, cacheDir, script, length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_519829746 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_519829746;
        // ---------- Original Method ----------
        //validate();
        //return rsnScriptCCreate(mContext, resName, cacheDir, script, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.047 -0400", hash_original_method = "F50A4C7270733FDFCE920150AD78688F", hash_generated_method = "67D3884507855AF75174846DEAB1A097")
     int rsnSamplerCreate(int con, int magFilter, int minFilter,
                                 int wrapS, int wrapT, int wrapR, float aniso) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306173778 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306173778;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.055 -0400", hash_original_method = "E4C144D939996B89BE383276ED88146B", hash_generated_method = "A359528C98831F428D1EE17D948CD9C0")
    synchronized int nSamplerCreate(int magFilter, int minFilter,
                                 int wrapS, int wrapT, int wrapR, float aniso) {
        addTaint(aniso);
        addTaint(wrapR);
        addTaint(wrapT);
        addTaint(wrapS);
        addTaint(minFilter);
        addTaint(magFilter);
        validate();
        int var2F0A3481D28DC0D860B280A95413D43E_198372057 = (rsnSamplerCreate(mContext, magFilter, minFilter, wrapS, wrapT, wrapR, aniso));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_442902234 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_442902234;
        // ---------- Original Method ----------
        //validate();
        //return rsnSamplerCreate(mContext, magFilter, minFilter, wrapS, wrapT, wrapR, aniso);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.060 -0400", hash_original_method = "7C375D6EBBA6AC09A4FAB784E2CB08EF", hash_generated_method = "E781BBA5A9B3B10EBDDAA85021FE28E9")
     int rsnProgramStoreCreate(int con, boolean r, boolean g, boolean b, boolean a,
                                      boolean depthMask, boolean dither,
                                      int srcMode, int dstMode, int depthFunc) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_197966846 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_197966846;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.066 -0400", hash_original_method = "C24E51CD5756A917243C92AD71BD6904", hash_generated_method = "67622FA8F8E413F501714656F5EEB210")
    synchronized int nProgramStoreCreate(boolean r, boolean g, boolean b, boolean a,
                                         boolean depthMask, boolean dither,
                                         int srcMode, int dstMode, int depthFunc) {
        addTaint(depthFunc);
        addTaint(dstMode);
        addTaint(srcMode);
        addTaint(dither);
        addTaint(depthMask);
        addTaint(a);
        addTaint(b);
        addTaint(g);
        addTaint(r);
        validate();
        int var47A5F5C20090CD6333C79621FDAB526C_1637419098 = (rsnProgramStoreCreate(mContext, r, g, b, a, depthMask, dither, srcMode,
                                     dstMode, depthFunc));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732428513 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732428513;
        // ---------- Original Method ----------
        //validate();
        //return rsnProgramStoreCreate(mContext, r, g, b, a, depthMask, dither, srcMode,
                                     //dstMode, depthFunc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.069 -0400", hash_original_method = "6E71183393586682CEDAE8931FDAB9C9", hash_generated_method = "439F875D0B31C08A285E5FAE7DF19942")
     int rsnProgramRasterCreate(int con, boolean pointSprite, int cullMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178716333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178716333;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.072 -0400", hash_original_method = "3C269E28ADE0BF12F6ABB9A34C7CB59C", hash_generated_method = "688790F685BA13C98C626D7D1B5CA765")
    synchronized int nProgramRasterCreate(boolean pointSprite, int cullMode) {
        addTaint(cullMode);
        addTaint(pointSprite);
        validate();
        int var3ADCAC6F620CD5F3C670F89B4376DE6B_1594031563 = (rsnProgramRasterCreate(mContext, pointSprite, cullMode));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1615952540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1615952540;
        // ---------- Original Method ----------
        //validate();
        //return rsnProgramRasterCreate(mContext, pointSprite, cullMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.075 -0400", hash_original_method = "10B2B54F2C84586E08FD71E662CEAE79", hash_generated_method = "5C27EEBE87883E818503AEBE828A8D2F")
     void rsnProgramBindConstants(int con, int pv, int slot, int mID) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.078 -0400", hash_original_method = "C1808F235D84009997366993D8753D63", hash_generated_method = "467635EBAE80A8B3A8D8E3CDCE007140")
    synchronized void nProgramBindConstants(int pv, int slot, int mID) {
        addTaint(mID);
        addTaint(slot);
        addTaint(pv);
        validate();
        rsnProgramBindConstants(mContext, pv, slot, mID);
        // ---------- Original Method ----------
        //validate();
        //rsnProgramBindConstants(mContext, pv, slot, mID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.081 -0400", hash_original_method = "A5393DDF51FEEBEC84057EDB9AFE0F88", hash_generated_method = "538E68BC7A532C2698C5B1A56E3B6067")
     void rsnProgramBindTexture(int con, int vpf, int slot, int a) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.085 -0400", hash_original_method = "43DA2906E8F4DAEF3347BC1F4C1F4439", hash_generated_method = "864FF51E7264EE8E95D9EB6435328B28")
    synchronized void nProgramBindTexture(int vpf, int slot, int a) {
        addTaint(a);
        addTaint(slot);
        addTaint(vpf);
        validate();
        rsnProgramBindTexture(mContext, vpf, slot, a);
        // ---------- Original Method ----------
        //validate();
        //rsnProgramBindTexture(mContext, vpf, slot, a);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.089 -0400", hash_original_method = "249A5A80FED59E0B99180EEE5F2DCED2", hash_generated_method = "3D57D4B6777F4585BACCEAE975E4800D")
     void rsnProgramBindSampler(int con, int vpf, int slot, int s) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.092 -0400", hash_original_method = "C18BB9FFAA60EE0E582B77603B834F27", hash_generated_method = "DDA204456A7BA22A592E38EF4E8DE0CF")
    synchronized void nProgramBindSampler(int vpf, int slot, int s) {
        addTaint(s);
        addTaint(slot);
        addTaint(vpf);
        validate();
        rsnProgramBindSampler(mContext, vpf, slot, s);
        // ---------- Original Method ----------
        //validate();
        //rsnProgramBindSampler(mContext, vpf, slot, s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.096 -0400", hash_original_method = "088578627A7DFD7C5D51A6E257B34F2A", hash_generated_method = "E3332C1FCBF0227C745D5D13A070D401")
     int rsnProgramFragmentCreate(int con, String shader, int[] params) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072726553 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072726553;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.100 -0400", hash_original_method = "7F7692EDFB515ECAB003706ED08D9F8F", hash_generated_method = "359F793E9FB8436E74EE6A1C4B242766")
    synchronized int nProgramFragmentCreate(String shader, int[] params) {
        addTaint(params[0]);
        addTaint(shader.getTaint());
        validate();
        int varCF4FD59FE36A669541F8C8B928722C33_1423191777 = (rsnProgramFragmentCreate(mContext, shader, params));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_640917654 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_640917654;
        // ---------- Original Method ----------
        //validate();
        //return rsnProgramFragmentCreate(mContext, shader, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.102 -0400", hash_original_method = "136B9315A7C89A9C4AB12C26BB74BD37", hash_generated_method = "9784B9CB41A201C2FEB661C58B3406B3")
     int rsnProgramVertexCreate(int con, String shader, int[] params) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2048923278 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2048923278;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.105 -0400", hash_original_method = "B69763FC594958BE82AD97B79A28F61B", hash_generated_method = "627AB5F1CAE4DE2A476AE53ADDA81A4F")
    synchronized int nProgramVertexCreate(String shader, int[] params) {
        addTaint(params[0]);
        addTaint(shader.getTaint());
        validate();
        int var389B3E1D5317E76A076D9F5107C6A571_9943107 = (rsnProgramVertexCreate(mContext, shader, params));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1914634606 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1914634606;
        // ---------- Original Method ----------
        //validate();
        //return rsnProgramVertexCreate(mContext, shader, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.108 -0400", hash_original_method = "B5F7D13D6DA39EA7BF6A3CC82A4EA459", hash_generated_method = "50A4E4F424DBD158F74BB2C073C9C018")
     int rsnMeshCreate(int con, int[] vtx, int[] idx, int[] prim) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1092513600 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1092513600;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.112 -0400", hash_original_method = "929E2A8C64A9DBA6124E7BFD301DDFCC", hash_generated_method = "AA81F0174D10EAD74062C310746219B1")
    synchronized int nMeshCreate(int[] vtx, int[] idx, int[] prim) {
        addTaint(prim[0]);
        addTaint(idx[0]);
        addTaint(vtx[0]);
        validate();
        int varFE0272FFCBAD71A0BC59ED66A4DADFDC_1652479037 = (rsnMeshCreate(mContext, vtx, idx, prim));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_730742634 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_730742634;
        // ---------- Original Method ----------
        //validate();
        //return rsnMeshCreate(mContext, vtx, idx, prim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.115 -0400", hash_original_method = "DA943F62890EC753AE2864FCA2B9D0E4", hash_generated_method = "19B99802BAD9D78FE8E8A28304DAF834")
     int rsnMeshGetVertexBufferCount(int con, int id) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657932011 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657932011;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.120 -0400", hash_original_method = "875C46919B8ED204A3CE3A9CCDF94192", hash_generated_method = "C0C4349A50C0AC14F559F7C9FD528C8E")
    synchronized int nMeshGetVertexBufferCount(int id) {
        addTaint(id);
        validate();
        int var3C0F818387D564073C5567D1FD6C4028_1783349164 = (rsnMeshGetVertexBufferCount(mContext, id));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_42229389 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_42229389;
        // ---------- Original Method ----------
        //validate();
        //return rsnMeshGetVertexBufferCount(mContext, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.122 -0400", hash_original_method = "C3784AA70B12CEFE10C9208118EDB1A5", hash_generated_method = "63E9E65250DD25A3EF759915374E765E")
     int rsnMeshGetIndexCount(int con, int id) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474823479 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474823479;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.127 -0400", hash_original_method = "FE806BF77D2052883B37B5F96DE92297", hash_generated_method = "32EC12091F96D9BC11E8F3FEA91943B1")
    synchronized int nMeshGetIndexCount(int id) {
        addTaint(id);
        validate();
        int var969ACA225B8556839C7A269BB9C9D3FB_1795980577 = (rsnMeshGetIndexCount(mContext, id));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146391406 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146391406;
        // ---------- Original Method ----------
        //validate();
        //return rsnMeshGetIndexCount(mContext, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.129 -0400", hash_original_method = "B8A05BB7D00248249F3BB536B2C0E9CA", hash_generated_method = "212B7B25F7AB20839FC8E4FB92188300")
     void rsnMeshGetVertices(int con, int id, int[] vtxIds, int vtxIdCount) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.133 -0400", hash_original_method = "30F5280204C1F68BA9056A749144827E", hash_generated_method = "29E4EED772AA2543C910087B3D5844E8")
    synchronized void nMeshGetVertices(int id, int[] vtxIds, int vtxIdCount) {
        addTaint(vtxIdCount);
        addTaint(vtxIds[0]);
        addTaint(id);
        validate();
        rsnMeshGetVertices(mContext, id, vtxIds, vtxIdCount);
        // ---------- Original Method ----------
        //validate();
        //rsnMeshGetVertices(mContext, id, vtxIds, vtxIdCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.135 -0400", hash_original_method = "EFB63D5DCEA905B624B981431149BE02", hash_generated_method = "11B97848D22FA9D034C4661D404174EE")
     void rsnMeshGetIndices(int con, int id, int[] idxIds, int[] primitives, int vtxIdCount) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.139 -0400", hash_original_method = "59359FE3E4E256078C31F9090CB119B7", hash_generated_method = "EEDDA87043768562ADA0C7F8CE9FAB45")
    synchronized void nMeshGetIndices(int id, int[] idxIds, int[] primitives, int vtxIdCount) {
        addTaint(vtxIdCount);
        addTaint(primitives[0]);
        addTaint(idxIds[0]);
        addTaint(id);
        validate();
        rsnMeshGetIndices(mContext, id, idxIds, primitives, vtxIdCount);
        // ---------- Original Method ----------
        //validate();
        //rsnMeshGetIndices(mContext, id, idxIds, primitives, vtxIdCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.142 -0400", hash_original_method = "CF72E2BDE12484DABE239AEA560D3CB7", hash_generated_method = "96352817DC99DF34A4D0E9FC4C5E469F")
    public void setMessageHandler(RSMessageHandler msg) {
        mMessageCallback = msg;
        // ---------- Original Method ----------
        //mMessageCallback = msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.145 -0400", hash_original_method = "82D97F3970F404AFF823D5438797134A", hash_generated_method = "6DCF304D53D175E5CFED057D45132ADE")
    public RSMessageHandler getMessageHandler() {
RSMessageHandler var9B539E83F365A4F09C8E2B69C18CC438_2029753803 =         mMessageCallback;
        var9B539E83F365A4F09C8E2B69C18CC438_2029753803.addTaint(taint);
        return var9B539E83F365A4F09C8E2B69C18CC438_2029753803;
        // ---------- Original Method ----------
        //return mMessageCallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.149 -0400", hash_original_method = "4877C344E3780CDA73E2F7D1DEF2ACC3", hash_generated_method = "F8A2A0B8B025FA82FB15B97076336AA6")
    public void setErrorHandler(RSErrorHandler msg) {
        mErrorCallback = msg;
        // ---------- Original Method ----------
        //mErrorCallback = msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.152 -0400", hash_original_method = "ADE7ED7BE0087974A98B5046E26EDD87", hash_generated_method = "90444216DB86D5C677ADBFEEB972CBA3")
    public RSErrorHandler getErrorHandler() {
RSErrorHandler var1F5754A1B349282E71CA62D3147F81C9_1960579285 =         mErrorCallback;
        var1F5754A1B349282E71CA62D3147F81C9_1960579285.addTaint(taint);
        return var1F5754A1B349282E71CA62D3147F81C9_1960579285;
        // ---------- Original Method ----------
        //return mErrorCallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.155 -0400", hash_original_method = "B11FCBCEEF16462E5ED7B31A808EFF86", hash_generated_method = "CE016D29B619E3B2A656946AA27182A7")
     void validate() {
        if(mContext == 0)        
        {
            RSInvalidStateException var299D45BE636A710EA1AF939E5140A5FA_1496991111 = new RSInvalidStateException("Calling RS with no Context active.");
            var299D45BE636A710EA1AF939E5140A5FA_1496991111.addTaint(taint);
            throw var299D45BE636A710EA1AF939E5140A5FA_1496991111;
        } //End block
        // ---------- Original Method ----------
        //if (mContext == 0) {
            //throw new RSInvalidStateException("Calling RS with no Context active.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.158 -0400", hash_original_method = "825B7EB852BA71F680F1CE64DECBD5CC", hash_generated_method = "DD8F6D0DB118DC5950BF9F9C45A94DAE")
    public void setPriority(Priority p) {
        addTaint(p.getTaint());
        validate();
        nContextSetPriority(p.mID);
        // ---------- Original Method ----------
        //validate();
        //nContextSetPriority(p.mID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.161 -0400", hash_original_method = "212FB98379B009D6F1B7FAC8BEC777BD", hash_generated_method = "215231A8EF33407EEA148D289617080C")
    public final Context getApplicationContext() {
Context var6B4648A08B12DFB77FAB8FC464E2263F_2009422266 =         mApplicationContext;
        var6B4648A08B12DFB77FAB8FC464E2263F_2009422266.addTaint(taint);
        return var6B4648A08B12DFB77FAB8FC464E2263F_2009422266;
        // ---------- Original Method ----------
        //return mApplicationContext;
    }

    
        static int getTargetSdkVersion(Context ctx) {
        return ctx.getApplicationInfo().targetSdkVersion;
    }

    
        public static RenderScript create(Context ctx) {
        RenderScript rs = new RenderScript(ctx);
        int sdkVersion = getTargetSdkVersion(ctx);
        rs.mDev = rs.nDeviceCreate();
        rs.mContext = rs.nContextCreate(rs.mDev, 0, sdkVersion);
        if (rs.mContext == 0) {
            throw new RSDriverException("Failed to create RS context.");
        }
        rs.mMessageThread = new MessageThread(rs);
        rs.mMessageThread.start();
        return rs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.168 -0400", hash_original_method = "68D301E431D7353AD53EDFB6C8ED3163", hash_generated_method = "65C213747B6927F4FC5487031AB3DD1E")
    public void contextDump() {
        validate();
        nContextDump(0);
        // ---------- Original Method ----------
        //validate();
        //nContextDump(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.172 -0400", hash_original_method = "709C1002A236E5295587B41728563E8C", hash_generated_method = "6A0C4C8CB129B2947AE7F6B9A3AB3207")
    public void finish() {
        nContextFinish();
        // ---------- Original Method ----------
        //nContextFinish();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.177 -0400", hash_original_method = "BEA9760994E1CBB8BA9A3650C9143B69", hash_generated_method = "A8DD2B901F25CAB7F381291AC95719EC")
    public void destroy() {
        validate();
        nContextDeinitToClient(mContext);
        mMessageThread.mRun = false;
        try 
        {
            mMessageThread.join();
        } //End block
        catch (InterruptedException e)
        {
        } //End block
        nContextDestroy();
        mContext = 0;
        nDeviceDestroy(mDev);
        mDev = 0;
        // ---------- Original Method ----------
        //validate();
        //nContextDeinitToClient(mContext);
        //mMessageThread.mRun = false;
        //try {
            //mMessageThread.join();
        //} catch(InterruptedException e) {
        //}
        //nContextDestroy();
        //mContext = 0;
        //nDeviceDestroy(mDev);
        //mDev = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.180 -0400", hash_original_method = "A43F31159E3962997DEA8993C2ED3F03", hash_generated_method = "7CD864895F425E9EC322955EE2DECA71")
     boolean isAlive() {
        boolean var8879B8CF0C39447D29F535C6F77F6403_362832684 = (mContext != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_181835685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_181835685;
        // ---------- Original Method ----------
        //return mContext != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.184 -0400", hash_original_method = "19F54E8AE078DC0EBF3195D44C78E70B", hash_generated_method = "A8C8C205327199DC12D8F3D53157D0E1")
     int safeID(BaseObj o) {
        addTaint(o.getTaint());
        if(o != null)        
        {
            int var2D0EC3205C38FB639E00579DEA0E8134_616699175 = (o.getID());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1759676581 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1759676581;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_746227215 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1141346028 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1141346028;
        // ---------- Original Method ----------
        //if(o != null) {
            //return o.getID();
        //}
        //return 0;
    }

    
    public static class RSMessageHandler implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.186 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "E9ECB1965245BA1A0ABDDD292D63F295")

        protected int[] mData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.188 -0400", hash_original_field = "F967916F035DAD625F94606212B89077", hash_generated_field = "2A50865478D1F98704AC34AC9B0FBF18")

        protected int mID;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.189 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "F57106D036A8856F66EB17F31ABCDC86")

        protected int mLength;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.189 -0400", hash_original_method = "CBD1456EA4F7D781CE5FB9E407013326", hash_generated_method = "CBD1456EA4F7D781CE5FB9E407013326")
        public RSMessageHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.192 -0400", hash_original_method = "941C644B96F3E7EE75FAD0CC47E0EEC2", hash_generated_method = "A2E5AE58616EECC7176440E5139E1684")
        public void run() {
            // ---------- Original Method ----------
        }

        
    }


    
    public static class RSErrorHandler implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.193 -0400", hash_original_field = "DDF57A354F36667F5635F5344D9C8DEA", hash_generated_field = "352199EA493EBD40F2F3992629E09A61")

        protected String mErrorMessage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.194 -0400", hash_original_field = "2E63BA21E13BA58C62B28C0F8CDD4D92", hash_generated_field = "DFB4D229ED26A95BEE84A83A68B00F06")

        protected int mErrorNum;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.195 -0400", hash_original_method = "7C983344237EA19B56C37B25669FCB61", hash_generated_method = "7C983344237EA19B56C37B25669FCB61")
        public RSErrorHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.197 -0400", hash_original_method = "941C644B96F3E7EE75FAD0CC47E0EEC2", hash_generated_method = "A2E5AE58616EECC7176440E5139E1684")
        public void run() {
            // ---------- Original Method ----------
        }

        
    }


    
    public enum Priority {
        LOW (Process.THREAD_PRIORITY_BACKGROUND + (5 * Process.THREAD_PRIORITY_LESS_FAVORABLE)),
        NORMAL (Process.THREAD_PRIORITY_DISPLAY);
        int mID;
        Priority(int id) {
            mID = id;
        }
    }

    
    static class MessageThread extends Thread {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.199 -0400", hash_original_field = "15EADDEB24354180E81F0ADC804C4CED", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.201 -0400", hash_original_field = "1D9DFB7FD06CDC93EA1C14F3BF07EDC8", hash_generated_field = "258C4B9A031693F0B54C9E6477557D77")

        boolean mRun = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.202 -0400", hash_original_field = "07A90F6753A6CFF2838785CF7D3B078A", hash_generated_field = "2E1F0CCD8790D6452AC412CF141A403D")

        int[] mAuxData = new int[2];
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.204 -0400", hash_original_method = "79018AA2643FA8D0F3347744AA1B7202", hash_generated_method = "0A2DD55549386E0BEF1D448A6847B713")
          MessageThread(RenderScript rs) {
            super("RSMessageThread");
            mRS = rs;
            // ---------- Original Method ----------
            //mRS = rs;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.214 -0400", hash_original_method = "44BE69ACBAD20FBF8ED2712E597F95F7", hash_generated_method = "FC1695F22AFA3A7AB5EF9F3BF7BB17A2")
        public void run() {
            int[] rbuf = new int[16];
            mRS.nContextInitToClient(mRS.mContext);
            while
(mRun)            
            {
                rbuf[0] = 0;
                int msg = mRS.nContextPeekMessage(mRS.mContext, mAuxData);
                int size = mAuxData[1];
                int subID = mAuxData[0];
                if(msg == RS_MESSAGE_TO_CLIENT_USER)                
                {
                    if((size>>2) >= rbuf.length)                    
                    {
                        rbuf = new int[(size + 3) >> 2];
                    } //End block
                    if(mRS.nContextGetUserMessage(mRS.mContext, rbuf) !=
                        RS_MESSAGE_TO_CLIENT_USER)                    
                    {
                        RSDriverException var11455148CA4741C39D556959D4DA1E1B_2076596744 = new RSDriverException("Error processing message from Renderscript.");
                        var11455148CA4741C39D556959D4DA1E1B_2076596744.addTaint(taint);
                        throw var11455148CA4741C39D556959D4DA1E1B_2076596744;
                    } //End block
                    if(mRS.mMessageCallback != null)                    
                    {
                        mRS.mMessageCallback.mData = rbuf;
                        mRS.mMessageCallback.mID = subID;
                        mRS.mMessageCallback.mLength = size;
                        mRS.mMessageCallback.run();
                    } //End block
                    else
                    {
                        RSInvalidStateException var326386815777C8699947FB227ED131F6_1012432606 = new RSInvalidStateException("Received a message from the script with no message handler installed.");
                        var326386815777C8699947FB227ED131F6_1012432606.addTaint(taint);
                        throw var326386815777C8699947FB227ED131F6_1012432606;
                    } //End block
                    continue;
                } //End block
                if(msg == RS_MESSAGE_TO_CLIENT_ERROR)                
                {
                    String e = mRS.nContextGetErrorMessage(mRS.mContext);
                    if(subID >= RS_ERROR_FATAL_UNKNOWN)                    
                    {
                        RSRuntimeException var5C44C15E4491E864A4145CBD0629A349_561038655 = new RSRuntimeException("Fatal error " + subID + ", details: " + e);
                        var5C44C15E4491E864A4145CBD0629A349_561038655.addTaint(taint);
                        throw var5C44C15E4491E864A4145CBD0629A349_561038655;
                    } //End block
                    if(mRS.mErrorCallback != null)                    
                    {
                        mRS.mErrorCallback.mErrorMessage = e;
                        mRS.mErrorCallback.mErrorNum = subID;
                        mRS.mErrorCallback.run();
                    } //End block
                    else
                    {
                    } //End block
                    continue;
                } //End block
                try 
                {
                    sleep(1, 0);
                } //End block
                catch (InterruptedException e)
                {
                } //End block
            } //End block
            Log.d(LOG_TAG, "MessageThread exiting.");
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.217 -0400", hash_original_field = "F63ECB0D9935351859D3859C779EC9D5", hash_generated_field = "1ACD99CA7A0BCEB9AFEC2A87202D8B1A")

        static final int RS_MESSAGE_TO_CLIENT_NONE = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.219 -0400", hash_original_field = "5EC6DA9594B1B2C46CECCE32F00F0AE9", hash_generated_field = "37474FF1E9C5BA58EC19743C84A4A20C")

        static final int RS_MESSAGE_TO_CLIENT_EXCEPTION = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.220 -0400", hash_original_field = "B10A3BF4444EF0F3DA8993B7CF45B07A", hash_generated_field = "E1EE3354D855C38F579964D77AC2F7A0")

        static final int RS_MESSAGE_TO_CLIENT_RESIZE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.221 -0400", hash_original_field = "E9DA03EE59848E7BC7AE4D4C2ED1A98D", hash_generated_field = "8480D0BAFE797D1AF646D0B8B5EC714A")

        static final int RS_MESSAGE_TO_CLIENT_ERROR = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.223 -0400", hash_original_field = "4035B6CEDCF1B23EB10D6A8F4DE57A52", hash_generated_field = "1183FD09410C6C756B441249707ED179")

        static final int RS_MESSAGE_TO_CLIENT_USER = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.224 -0400", hash_original_field = "2322814F6CB12DE6F0E8E546F10F88E1", hash_generated_field = "32A9791D3BD5FFB06DEFC9345E1D363B")

        static final int RS_ERROR_FATAL_UNKNOWN = 0x1000;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.225 -0400", hash_original_field = "54705B97C3DFA9033F1E5CE04B265BFA", hash_generated_field = "5E0FBB6F07C6444DFC8DDEBC597AEF02")

    static final String LOG_TAG = "RenderScript_jni";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.227 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.228 -0400", hash_original_field = "2600CAE892D7C6A21DB7F1CB3CE2784F", hash_generated_field = "D402CBDA3E0C9E0D92B37254FFB205D1")

    @SuppressWarnings({"UnusedDeclaration", "deprecation"}) static final boolean LOG_ENABLED = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.229 -0400", hash_original_field = "663FF7399920A29F8C63F4FBCE07F521", hash_generated_field = "229FA7BCBAB0B41C01BF4D74392C9704")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) static boolean sInitialized;
    static {
        sInitialized = false;
        try {
            System.loadLibrary("rs_jni");
            _nInit();
            sInitialized = true;
        } catch (UnsatisfiedLinkError e) {
            Log.e(LOG_TAG, "Error loading RS jni library: " + e);
            throw new RSRuntimeException("Error loading RS jni library: " + e);
        }
    }
    
}

