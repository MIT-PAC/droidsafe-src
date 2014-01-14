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
        
    static void _nInit() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.752 -0500", hash_original_method = "8B49681A68145339D354B38CC2F5CD82", hash_generated_method = "60C597E4E4BEEA6406937D60C0EE3619")
    
static int getTargetSdkVersion(Context ctx) {
        return ctx.getApplicationInfo().targetSdkVersion;
    }

    /**
     * Create a basic RenderScript context.
     *
     * @param ctx The context.
     * @return RenderScript
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.754 -0500", hash_original_method = "367BB2C71096BB3ED82A8E67F24F8287", hash_generated_method = "6490A68CD298D02C6E158AABC49A54BE")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.984 -0500", hash_original_field = "DABF8B5E7CCEDBBF76D9FF404621F74F", hash_generated_field = "5E0FBB6F07C6444DFC8DDEBC597AEF02")

    static final String LOG_TAG = "RenderScript_jni";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.987 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG  = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.989 -0500", hash_original_field = "F06F6BE52D1AF076D79F1A84048E39C0", hash_generated_field = "D402CBDA3E0C9E0D92B37254FFB205D1")

    @SuppressWarnings({"UnusedDeclaration", "deprecation"})
    static final boolean LOG_ENABLED = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.993 -0500", hash_original_field = "D692DCD499E02653F7D40EBB5CF95A8C", hash_generated_field = "229FA7BCBAB0B41C01BF4D74392C9704")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"})
    static boolean sInitialized;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.991 -0500", hash_original_field = "84B225E4BC68B4F650B6DB7632FCB17C", hash_generated_field = "DE9CF0F0F7A6C85EF08872E26EEA1599")

    private Context mApplicationContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.524 -0500", hash_original_field = "97FCF96DBFF8B429633D3BD31F12497F", hash_generated_field = "97FCF96DBFF8B429633D3BD31F12497F")

    int     mDev;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.526 -0500", hash_original_field = "19C61BA4139FB95CA67E235BE0DACFF3", hash_generated_field = "19C61BA4139FB95CA67E235BE0DACFF3")

    int     mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.528 -0500", hash_original_field = "8608164B37359346ACAFED022EDC4556", hash_generated_field = "670FB90F84721926B44B7A261023C823")

    @SuppressWarnings({"FieldCanBeLocal"})
    MessageThread mMessageThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.530 -0500", hash_original_field = "1A4C60ED310F59A326B64022242C4837", hash_generated_field = "1A4C60ED310F59A326B64022242C4837")

    Element mElement_U8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.532 -0500", hash_original_field = "A115100196267E2ED63739A879D23201", hash_generated_field = "A115100196267E2ED63739A879D23201")

    Element mElement_I8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.534 -0500", hash_original_field = "54F4B6F9FA7A350852680541D2024677", hash_generated_field = "54F4B6F9FA7A350852680541D2024677")

    Element mElement_U16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.536 -0500", hash_original_field = "833DA275352FDE1C1761DB58A51D53A9", hash_generated_field = "833DA275352FDE1C1761DB58A51D53A9")

    Element mElement_I16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.538 -0500", hash_original_field = "F082C7FE58DD7A4E24B249D3740DAB52", hash_generated_field = "F082C7FE58DD7A4E24B249D3740DAB52")

    Element mElement_U32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.541 -0500", hash_original_field = "D7581DD3A8437870F797E24CEBA5B523", hash_generated_field = "D7581DD3A8437870F797E24CEBA5B523")

    Element mElement_I32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.542 -0500", hash_original_field = "2D97FB4B0750BBC826190DCEDF30EEAB", hash_generated_field = "2D97FB4B0750BBC826190DCEDF30EEAB")

    Element mElement_U64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.544 -0500", hash_original_field = "667B346E92EFBB850E5865402EDC965D", hash_generated_field = "667B346E92EFBB850E5865402EDC965D")

    Element mElement_I64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.546 -0500", hash_original_field = "00EAEDB38503481A3C5759894D534826", hash_generated_field = "00EAEDB38503481A3C5759894D534826")

    Element mElement_F32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.548 -0500", hash_original_field = "4E5662510076A807040BA7A6A71AD8F7", hash_generated_field = "4E5662510076A807040BA7A6A71AD8F7")

    Element mElement_F64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.550 -0500", hash_original_field = "88A701AFFD5E24586796CB7112653FF1", hash_generated_field = "88A701AFFD5E24586796CB7112653FF1")

    Element mElement_BOOLEAN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.551 -0500", hash_original_field = "4A6F1FCC3DDC191E0E48AD365A4759B5", hash_generated_field = "4A6F1FCC3DDC191E0E48AD365A4759B5")

    Element mElement_ELEMENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.553 -0500", hash_original_field = "2EFBCAB65FE5BE2A90E2AE365AF5F9FA", hash_generated_field = "2EFBCAB65FE5BE2A90E2AE365AF5F9FA")

    Element mElement_TYPE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.556 -0500", hash_original_field = "29402BA7E67B0D7ECE953225521C2054", hash_generated_field = "29402BA7E67B0D7ECE953225521C2054")

    Element mElement_ALLOCATION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.558 -0500", hash_original_field = "5855F4DB43046E4C289B8EFB6528F3AF", hash_generated_field = "5855F4DB43046E4C289B8EFB6528F3AF")

    Element mElement_SAMPLER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.560 -0500", hash_original_field = "8157A7A7CB259C4E913256A58B1FE057", hash_generated_field = "8157A7A7CB259C4E913256A58B1FE057")

    Element mElement_SCRIPT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.562 -0500", hash_original_field = "7C46049D19E4B3EB82D18681880F1D81", hash_generated_field = "7C46049D19E4B3EB82D18681880F1D81")

    Element mElement_MESH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.564 -0500", hash_original_field = "2CD22CDF9515BEF5617F58AF6C5DC3B4", hash_generated_field = "2CD22CDF9515BEF5617F58AF6C5DC3B4")

    Element mElement_PROGRAM_FRAGMENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.566 -0500", hash_original_field = "3435047FDB3BDECEB28D3FA533BF505C", hash_generated_field = "3435047FDB3BDECEB28D3FA533BF505C")

    Element mElement_PROGRAM_VERTEX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.568 -0500", hash_original_field = "FD5F17712A3D83716885C55D8EC54E23", hash_generated_field = "FD5F17712A3D83716885C55D8EC54E23")

    Element mElement_PROGRAM_RASTER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.570 -0500", hash_original_field = "7882A52B6011EC323E80870ED60C8EFC", hash_generated_field = "7882A52B6011EC323E80870ED60C8EFC")

    Element mElement_PROGRAM_STORE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.572 -0500", hash_original_field = "583ED1725F29FCC08C5EE0A5DEBA905D", hash_generated_field = "583ED1725F29FCC08C5EE0A5DEBA905D")

    Element mElement_A_8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.574 -0500", hash_original_field = "9B422CEE267AECD8C66DD08959B9C381", hash_generated_field = "9B422CEE267AECD8C66DD08959B9C381")

    Element mElement_RGB_565;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.576 -0500", hash_original_field = "808A316EFD9D37B931028DC23AA817AA", hash_generated_field = "808A316EFD9D37B931028DC23AA817AA")

    Element mElement_RGB_888;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.578 -0500", hash_original_field = "07ACDE925FD9974BDB487EA5CFA1F57D", hash_generated_field = "07ACDE925FD9974BDB487EA5CFA1F57D")

    Element mElement_RGBA_5551;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.579 -0500", hash_original_field = "34960B2DAF137407207E425B7800CCDB", hash_generated_field = "34960B2DAF137407207E425B7800CCDB")

    Element mElement_RGBA_4444;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.581 -0500", hash_original_field = "BB437F659367C07335C8CCE53F70B51D", hash_generated_field = "BB437F659367C07335C8CCE53F70B51D")

    Element mElement_RGBA_8888;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.583 -0500", hash_original_field = "A26873EF625936EBEC474EA98B6EEF39", hash_generated_field = "A26873EF625936EBEC474EA98B6EEF39")

    Element mElement_FLOAT_2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.586 -0500", hash_original_field = "FAB9909D949F377BC188359F721E520B", hash_generated_field = "FAB9909D949F377BC188359F721E520B")

    Element mElement_FLOAT_3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.587 -0500", hash_original_field = "E6B28BBDE41009797A89736A06E985C8", hash_generated_field = "E6B28BBDE41009797A89736A06E985C8")

    Element mElement_FLOAT_4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.589 -0500", hash_original_field = "4314D1BE060B522FBE7C8840CCE67A5E", hash_generated_field = "4314D1BE060B522FBE7C8840CCE67A5E")

    Element mElement_DOUBLE_2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.591 -0500", hash_original_field = "ED2783252668396374139138DDDB1E4E", hash_generated_field = "ED2783252668396374139138DDDB1E4E")

    Element mElement_DOUBLE_3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.593 -0500", hash_original_field = "4A25CA35B7A8135791E3C74636B5651B", hash_generated_field = "4A25CA35B7A8135791E3C74636B5651B")

    Element mElement_DOUBLE_4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.595 -0500", hash_original_field = "42125330C40EE1E1970FF1D6DCD549F3", hash_generated_field = "42125330C40EE1E1970FF1D6DCD549F3")

    Element mElement_UCHAR_2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.597 -0500", hash_original_field = "41AFF93379CB91FFCC25823BDC157458", hash_generated_field = "41AFF93379CB91FFCC25823BDC157458")

    Element mElement_UCHAR_3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.599 -0500", hash_original_field = "EEB9AB3F823B0187305AF49F6679F436", hash_generated_field = "EEB9AB3F823B0187305AF49F6679F436")

    Element mElement_UCHAR_4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.602 -0500", hash_original_field = "008D8C3DBF67E53688415D5742E26110", hash_generated_field = "008D8C3DBF67E53688415D5742E26110")

    Element mElement_CHAR_2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.604 -0500", hash_original_field = "7CF23E5A463E5C432FB997247B9CB6DA", hash_generated_field = "7CF23E5A463E5C432FB997247B9CB6DA")

    Element mElement_CHAR_3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.606 -0500", hash_original_field = "F497E4C68C277202DAD6DF3701BBDDFC", hash_generated_field = "F497E4C68C277202DAD6DF3701BBDDFC")

    Element mElement_CHAR_4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.608 -0500", hash_original_field = "B24A765F13FF74DB88B856F97EBD7002", hash_generated_field = "B24A765F13FF74DB88B856F97EBD7002")

    Element mElement_USHORT_2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.610 -0500", hash_original_field = "E9199C46669A4076C44AB964830CB78F", hash_generated_field = "E9199C46669A4076C44AB964830CB78F")

    Element mElement_USHORT_3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.612 -0500", hash_original_field = "4549F81D017948EC8D77E71B148EA883", hash_generated_field = "4549F81D017948EC8D77E71B148EA883")

    Element mElement_USHORT_4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.614 -0500", hash_original_field = "A61CA347123FBA9C5A18C41944A576B9", hash_generated_field = "A61CA347123FBA9C5A18C41944A576B9")

    Element mElement_SHORT_2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.615 -0500", hash_original_field = "778CCB99542DA47A75CDDC434CD3DE3C", hash_generated_field = "778CCB99542DA47A75CDDC434CD3DE3C")

    Element mElement_SHORT_3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.617 -0500", hash_original_field = "11A21B8338F825A497E945C7811706DD", hash_generated_field = "11A21B8338F825A497E945C7811706DD")

    Element mElement_SHORT_4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.619 -0500", hash_original_field = "D092CF7584BFB9A3ED918F84EB8982D6", hash_generated_field = "D092CF7584BFB9A3ED918F84EB8982D6")

    Element mElement_UINT_2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.621 -0500", hash_original_field = "952C8EAFBD3B3BEF43DCB09EC0D33116", hash_generated_field = "952C8EAFBD3B3BEF43DCB09EC0D33116")

    Element mElement_UINT_3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.623 -0500", hash_original_field = "76794C9A4596BDDC93202233B97F1E89", hash_generated_field = "76794C9A4596BDDC93202233B97F1E89")

    Element mElement_UINT_4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.625 -0500", hash_original_field = "488D8A8C409807BEB5482E2A220560BF", hash_generated_field = "488D8A8C409807BEB5482E2A220560BF")

    Element mElement_INT_2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.627 -0500", hash_original_field = "FDC4C914E75BE5D0F5B418AF1F337161", hash_generated_field = "FDC4C914E75BE5D0F5B418AF1F337161")

    Element mElement_INT_3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.629 -0500", hash_original_field = "78E62D9B31DF379AB9A67DFFB6B0EC69", hash_generated_field = "78E62D9B31DF379AB9A67DFFB6B0EC69")

    Element mElement_INT_4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.631 -0500", hash_original_field = "BE546EE33636C876F5F08AA37EC93392", hash_generated_field = "BE546EE33636C876F5F08AA37EC93392")

    Element mElement_ULONG_2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.633 -0500", hash_original_field = "1426A1BE2C52948E38BB04ED85667A6D", hash_generated_field = "1426A1BE2C52948E38BB04ED85667A6D")

    Element mElement_ULONG_3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.635 -0500", hash_original_field = "5BF63F3AC33E2E6A15E3C809F9B43DBF", hash_generated_field = "5BF63F3AC33E2E6A15E3C809F9B43DBF")

    Element mElement_ULONG_4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.637 -0500", hash_original_field = "DD16F669DE47E721697407D09BA734B4", hash_generated_field = "DD16F669DE47E721697407D09BA734B4")

    Element mElement_LONG_2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.639 -0500", hash_original_field = "02CBDB23048DD75EF16E592628D58E66", hash_generated_field = "02CBDB23048DD75EF16E592628D58E66")

    Element mElement_LONG_3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.640 -0500", hash_original_field = "6DBFC270015CE28293BDE14B521136C7", hash_generated_field = "6DBFC270015CE28293BDE14B521136C7")

    Element mElement_LONG_4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.642 -0500", hash_original_field = "90467332F0960CFA80067B1FF2293940", hash_generated_field = "90467332F0960CFA80067B1FF2293940")

    Element mElement_MATRIX_4X4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.644 -0500", hash_original_field = "37DC3D9F46428D68056BE5D0E1D2D69F", hash_generated_field = "37DC3D9F46428D68056BE5D0E1D2D69F")

    Element mElement_MATRIX_3X3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.647 -0500", hash_original_field = "802B656F6AAD04F4B5402556945248C7", hash_generated_field = "802B656F6AAD04F4B5402556945248C7")

    Element mElement_MATRIX_2X2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.649 -0500", hash_original_field = "FD7952939A930C2EAD82F191678A9A3D", hash_generated_field = "FD7952939A930C2EAD82F191678A9A3D")

    Sampler mSampler_CLAMP_NEAREST;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.651 -0500", hash_original_field = "37CE813925492EE7B0CDDBDA16ADC1DE", hash_generated_field = "37CE813925492EE7B0CDDBDA16ADC1DE")

    Sampler mSampler_CLAMP_LINEAR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.653 -0500", hash_original_field = "0FDABB6563A028AB8CF0EDA769250692", hash_generated_field = "0FDABB6563A028AB8CF0EDA769250692")

    Sampler mSampler_CLAMP_LINEAR_MIP_LINEAR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.655 -0500", hash_original_field = "FFEFA76AEB73310F96A6BAF05E454B00", hash_generated_field = "FFEFA76AEB73310F96A6BAF05E454B00")

    Sampler mSampler_WRAP_NEAREST;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.656 -0500", hash_original_field = "9CBA8162A49023307D1B6AE9BCE24A43", hash_generated_field = "9CBA8162A49023307D1B6AE9BCE24A43")

    Sampler mSampler_WRAP_LINEAR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.659 -0500", hash_original_field = "5949BC6E2673836634371B9204E7260C", hash_generated_field = "5949BC6E2673836634371B9204E7260C")

    Sampler mSampler_WRAP_LINEAR_MIP_LINEAR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.661 -0500", hash_original_field = "53A75F27A0885A24DE1E28A78D67D7E6", hash_generated_field = "53A75F27A0885A24DE1E28A78D67D7E6")

    ProgramStore mProgramStore_BLEND_NONE_DEPTH_TEST;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.663 -0500", hash_original_field = "8737AA793A56C1AE9073BD927DACE35E", hash_generated_field = "8737AA793A56C1AE9073BD927DACE35E")

    ProgramStore mProgramStore_BLEND_NONE_DEPTH_NO_DEPTH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.665 -0500", hash_original_field = "13EE9E455AA610A00DE23BE175D9DE59", hash_generated_field = "13EE9E455AA610A00DE23BE175D9DE59")

    ProgramStore mProgramStore_BLEND_ALPHA_DEPTH_TEST;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.667 -0500", hash_original_field = "B6F8DF6C04DE4FD8A606B165DDFB07BD", hash_generated_field = "B6F8DF6C04DE4FD8A606B165DDFB07BD")

    ProgramStore mProgramStore_BLEND_ALPHA_DEPTH_NO_DEPTH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.669 -0500", hash_original_field = "E95BF77B0A9C09370D6FE36647ECAE0A", hash_generated_field = "E95BF77B0A9C09370D6FE36647ECAE0A")

    ProgramRaster mProgramRaster_CULL_BACK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.671 -0500", hash_original_field = "0783E32B56B030665E55149BA001BA9E", hash_generated_field = "0783E32B56B030665E55149BA001BA9E")

    ProgramRaster mProgramRaster_CULL_FRONT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.673 -0500", hash_original_field = "EC2CC4869C0FE72E7B228CC00A26798A", hash_generated_field = "EC2CC4869C0FE72E7B228CC00A26798A")

    ProgramRaster mProgramRaster_CULL_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.685 -0500", hash_original_field = "858670CDC664CC19F703E9228545E7BA", hash_generated_field = "858670CDC664CC19F703E9228545E7BA")

    RSMessageHandler mMessageCallback = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.701 -0500", hash_original_field = "088E452E7B88AD4160F095FA1A3F30DC", hash_generated_field = "088E452E7B88AD4160F095FA1A3F30DC")

    RSErrorHandler mErrorCallback = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.748 -0500", hash_original_method = "392EBD552CF287854C96DEE5F4403E62", hash_generated_method = "392EBD552CF287854C96DEE5F4403E62")
    
RenderScript(Context ctx) {
        mApplicationContext = ctx.getApplicationContext();
    }

    // Non-threadsafe functions.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.001 -0500", hash_original_method = "E10A585499F012DC684BBF2A3A5E1690", hash_generated_method = "50E4C93B7F67E1B573191A93D2B4B002")
    
    int  nDeviceCreate(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.004 -0500", hash_original_method = "DF4D03BEDDDA74F1832404E66432B009", hash_generated_method = "D89E8F270D21B8645E324F72BF0CFD1C")
    
    void nDeviceDestroy(int dev){
    	//Formerly a native method
    	addTaint(dev);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.008 -0500", hash_original_method = "7AC98A8B1F935BCE8C033A1730FD8D18", hash_generated_method = "08B5C5672F59A9395D9FDED40C9A186A")
    
    void nDeviceSetConfig(int dev, int param, int value){
    	//Formerly a native method
    	addTaint(dev);
    	addTaint(param);
    	addTaint(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.011 -0500", hash_original_method = "3523058A47E8BE15ED01358E8A9C1317", hash_generated_method = "0B194DCB4A0BF361559E14E104D4996B")
    
    int nContextGetUserMessage(int con, int[] data){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(data[0]);
    	return getTaintInt();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.333 -0400", hash_original_method = "A170821D17F63D9EDF5AAFFF93CB7028", hash_generated_method = "1C435B28B274730163B2755B3AC76CDA")
     String nContextGetErrorMessage(int con) {
    	taint.addTaint(con);
    	String retVal = new String();
    	retVal.addTaint(taint);
    	return retVal;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.018 -0500", hash_original_method = "AFD8787633EE4DCA6116C3EC8151B7E2", hash_generated_method = "F95A929DAC064B6A2789A6D9515BD8D5")
    
    int  nContextPeekMessage(int con, int[] subID){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(subID[0]);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.022 -0500", hash_original_method = "D1395017DBF4D2973A1B42B1D2CDF2B0", hash_generated_method = "87E6DD36A06186BF681D5C39A0BAF48A")
    
    void nContextInitToClient(int con){
    	//Formerly a native method
    	addTaint(con);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.026 -0500", hash_original_method = "C373F63DD90F62E81D8094CE77A097E6", hash_generated_method = "227CB53789A4299E3DEFE5543222448D")
    
    void nContextDeinitToClient(int con){
    	//Formerly a native method
    	addTaint(con);
    }

    // Methods below are wrapped to protect the non-threadsafe
    // lockless fifo.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.029 -0500", hash_original_method = "9C6265EC899BF914D2CC30605FF4CB19", hash_generated_method = "2D1E9561C07FE9712B03F554D43DB80B")
    
    int  rsnContextCreateGL(int dev, int ver, int sdkVer,
                     int colorMin, int colorPref,
                     int alphaMin, int alphaPref,
                     int depthMin, int depthPref,
                     int stencilMin, int stencilPref,
                     int samplesMin, int samplesPref, float samplesQ, int dpi){
    	//Formerly a native method
    	addTaint(dev);
    	addTaint(ver);
    	addTaint(sdkVer);
    	addTaint(colorMin);
    	addTaint(colorPref);
    	addTaint(alphaMin);
    	addTaint(alphaPref);
    	addTaint(depthMin);
    	addTaint(depthPref);
    	addTaint(stencilMin);
    	addTaint(stencilPref);
    	addTaint(samplesMin);
    	addTaint(samplesPref);
    	addTaint(samplesQ);
    	addTaint(dpi);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.032 -0500", hash_original_method = "C173B3C3D5C34C342E9D2D41CD367CF5", hash_generated_method = "E38CFDAED7A422281053C19FAA1DC9E7")
    
synchronized int nContextCreateGL(int dev, int ver, int sdkVer,
                 int colorMin, int colorPref,
                 int alphaMin, int alphaPref,
                 int depthMin, int depthPref,
                 int stencilMin, int stencilPref,
                 int samplesMin, int samplesPref, float samplesQ, int dpi) {
        return rsnContextCreateGL(dev, ver, sdkVer, colorMin, colorPref,
                                  alphaMin, alphaPref, depthMin, depthPref,
                                  stencilMin, stencilPref,
                                  samplesMin, samplesPref, samplesQ, dpi);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.036 -0500", hash_original_method = "B041442AA5F481AFFB60920693334F36", hash_generated_method = "3D4B3BBBA8BE8854DD3CFEC2332C9A79")
    
    int  rsnContextCreate(int dev, int ver, int sdkVer){
    	//Formerly a native method
    	addTaint(dev);
    	addTaint(ver);
    	addTaint(sdkVer);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.038 -0500", hash_original_method = "F258E8147FC7C8BED48B75E7E07A1B28", hash_generated_method = "42227EACF1324A946860701306372CAC")
    
synchronized int nContextCreate(int dev, int ver, int sdkVer) {
        return rsnContextCreate(dev, ver, sdkVer);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.041 -0500", hash_original_method = "4492F159A0AEE5AC63BD9CDD4614CBA0", hash_generated_method = "5915751E03B32B2E7C836093931929F2")
    
    void rsnContextDestroy(int con){
    	//Formerly a native method
    	addTaint(con);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.043 -0500", hash_original_method = "C5E77EED8025038F271CF4684A92DF9D", hash_generated_method = "A8C087922FE26B8A96E15570AE851774")
    
synchronized void nContextDestroy() {
        validate();
        rsnContextDestroy(mContext);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.047 -0500", hash_original_method = "EB21769075BE69C0C8886AAA59B58B10", hash_generated_method = "5DA52B1319013737BF20DF9C748A69EC")
    
    void rsnContextSetSurface(int con, int w, int h, Surface sur){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(w);
    	addTaint(h);
    	addTaint(sur.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.049 -0500", hash_original_method = "A57FAAFB6E151E0BB6D4588D4B880844", hash_generated_method = "533A3A3CAFE992D0FCFB467039387DD7")
    
synchronized void nContextSetSurface(int w, int h, Surface sur) {
        validate();
        rsnContextSetSurface(mContext, w, h, sur);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.052 -0500", hash_original_method = "3D8D3CB35029BD7A3D839DEBFE214FCF", hash_generated_method = "F708DD6A450B4507F99E0CB6EA7C2125")
    
    void rsnContextSetSurfaceTexture(int con, int w, int h, SurfaceTexture sur){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(w);
    	addTaint(h);
    	addTaint(sur.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.054 -0500", hash_original_method = "053D226D8DB22C1C63CE12AFDF45E46E", hash_generated_method = "F329EEF6DD056F704B58B2EDFA6C7FAE")
    
synchronized void nContextSetSurfaceTexture(int w, int h, SurfaceTexture sur) {
        validate();
        rsnContextSetSurfaceTexture(mContext, w, h, sur);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.058 -0500", hash_original_method = "2593188FF9A71C43FC5D80F3F60B911F", hash_generated_method = "BBC424C7DF485C63ED4A26BB37FB9D33")
    
    void rsnContextSetPriority(int con, int p){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(p);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.060 -0500", hash_original_method = "61DE383D49720578BAA35F595DEEA5F2", hash_generated_method = "6ECD0C504CF26D78720757D1DAC90C77")
    
synchronized void nContextSetPriority(int p) {
        validate();
        rsnContextSetPriority(mContext, p);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.064 -0500", hash_original_method = "1A842DB75F6BBE9B50F7518F02BF2818", hash_generated_method = "22D7C48CBFE4763D115453497717A6AA")
    
    void rsnContextDump(int con, int bits){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(bits);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.066 -0500", hash_original_method = "248EC68B2A45083AEE3CDB91CF7C92F0", hash_generated_method = "D56E8E08473968A6F778F2830BC069E5")
    
synchronized void nContextDump(int bits) {
        validate();
        rsnContextDump(mContext, bits);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.069 -0500", hash_original_method = "0C7B45782D52A09147084311B49664D7", hash_generated_method = "F25818875533FB160262EBE00CCBB229")
    
    void rsnContextFinish(int con){
    	//Formerly a native method
    	addTaint(con);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.071 -0500", hash_original_method = "88AFB5D6D20505102DAE97A58843F3DC", hash_generated_method = "74ED700E17C3B3F23189BF27D2F1362C")
    
synchronized void nContextFinish() {
        validate();
        rsnContextFinish(mContext);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.074 -0500", hash_original_method = "E4468512F11EFAA75CD65D530F3E6710", hash_generated_method = "CD249A8AA8C564FCA6594F1743BAF3C3")
    
    void rsnContextBindRootScript(int con, int script){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(script);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.077 -0500", hash_original_method = "D8E8F4DB394344A4FF3B7250256E824C", hash_generated_method = "D93CDD939269BEF1973788A61109232D")
    
synchronized void nContextBindRootScript(int script) {
        validate();
        rsnContextBindRootScript(mContext, script);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.081 -0500", hash_original_method = "367487DF84DFA0BAA046FDED24CAE25E", hash_generated_method = "54EE6A19AF77EF091EE450A3697F3259")
    
    void rsnContextBindSampler(int con, int sampler, int slot){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(sampler);
    	addTaint(slot);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.083 -0500", hash_original_method = "AFD08607E4DD74B65DF9EFD1B93B519B", hash_generated_method = "7E962EF4668028D72E7F1A5079A725D5")
    
synchronized void nContextBindSampler(int sampler, int slot) {
        validate();
        rsnContextBindSampler(mContext, sampler, slot);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.087 -0500", hash_original_method = "70F76B7F943E056527EFD106C36D72FC", hash_generated_method = "385A91AF78B7398A383C086C31094466")
    
    void rsnContextBindProgramStore(int con, int pfs){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(pfs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.089 -0500", hash_original_method = "68D7363FCC4EC21EEF5F8D4BAC5EF452", hash_generated_method = "2B5C09212348F3FA0E463950A12B08F8")
    
synchronized void nContextBindProgramStore(int pfs) {
        validate();
        rsnContextBindProgramStore(mContext, pfs);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.092 -0500", hash_original_method = "82A1278D65A372B03CD56DD87C8A9A84", hash_generated_method = "3984B11E588B593CB993DAE3C1C9C031")
    
    void rsnContextBindProgramFragment(int con, int pf){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(pf);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.094 -0500", hash_original_method = "1F420C5E57E15F5EA59327C192955502", hash_generated_method = "3EE68933880BB7A1AAE3CAD2EEAE7A0F")
    
synchronized void nContextBindProgramFragment(int pf) {
        validate();
        rsnContextBindProgramFragment(mContext, pf);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.097 -0500", hash_original_method = "58875F1D5BE9B0875716EDD4783F8535", hash_generated_method = "2B45FD705A1AF37E7D72E8C6A1F4EF85")
    
    void rsnContextBindProgramVertex(int con, int pv){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(pv);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.099 -0500", hash_original_method = "8C4B4B2A1CE620607E8C9F820ADF7411", hash_generated_method = "BA001A7B48E0D5B39E49E1B95DDCC1A4")
    
synchronized void nContextBindProgramVertex(int pv) {
        validate();
        rsnContextBindProgramVertex(mContext, pv);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.103 -0500", hash_original_method = "5EE25D946D565696B054063A4BC4E7E5", hash_generated_method = "5413DB98278931D9AB78DEB7219A79FB")
    
    void rsnContextBindProgramRaster(int con, int pr){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(pr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.105 -0500", hash_original_method = "A0B057C7956173D5D797DAE35AD47DB0", hash_generated_method = "183FD2BD42610E458FE16A2E1D0AA4A8")
    
synchronized void nContextBindProgramRaster(int pr) {
        validate();
        rsnContextBindProgramRaster(mContext, pr);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.109 -0500", hash_original_method = "A6B4F3AAB21598449C9A14AB5C5C63A0", hash_generated_method = "7DEA1BB30FD3C366C7D6CD7A2FE3056E")
    
    void rsnContextPause(int con){
    	//Formerly a native method
    	addTaint(con);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.111 -0500", hash_original_method = "F73975B5904A87B19685943474817E3D", hash_generated_method = "E0406DAB2B63F90F6D35D29C29A3F12B")
    
synchronized void nContextPause() {
        validate();
        rsnContextPause(mContext);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.114 -0500", hash_original_method = "2A894A4DED0A4EFC7176BB282B87AC42", hash_generated_method = "0C77332E87A7F7D9242AF31F541A7FE0")
    
    void rsnContextResume(int con){
    	//Formerly a native method
    	addTaint(con);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.116 -0500", hash_original_method = "8F0FF9572DEFDEC900895347CEE974A8", hash_generated_method = "EFD639CB9AD174CCCA5C2F8927B25CC4")
    
synchronized void nContextResume() {
        validate();
        rsnContextResume(mContext);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.119 -0500", hash_original_method = "06C95D837B75EADFCF0F9AFEF967EE0C", hash_generated_method = "CDED44C8C3CFA79B59CE79C094D0CB36")
    
    void rsnAssignName(int con, int obj, byte[] name){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(obj);
    	addTaint(name[0]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.122 -0500", hash_original_method = "8AE682AE559386D264AE4EAC41105882", hash_generated_method = "89B05A4F92905DF69056E7640BB327DB")
    
synchronized void nAssignName(int obj, byte[] name) {
        validate();
        rsnAssignName(mContext, obj, name);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:56.519 -0400", hash_original_method = "6CFEA087E7A290E3C39BE13FE6867185", hash_generated_method = "E4F6A8A0464E8FFDD20E28A294151A61")
     String rsnGetName(int con, int obj) {
    	addTaint(con);
    	addTaint(obj);
    	String retVal = new String();
    	retVal.addTaint(taint);
    	return retVal;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.127 -0500", hash_original_method = "1319AD6AF7285704CDBB77DE60110138", hash_generated_method = "CE76B97EBBDC2C79CD4A760938CB8009")
    
synchronized String nGetName(int obj) {
        validate();
        return rsnGetName(mContext, obj);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.132 -0500", hash_original_method = "B170AA080491DF0B3E272A4B1A2F6C89", hash_generated_method = "D763C11F8BAD58970A14BE4B1A0A1934")
    
    void rsnObjDestroy(int con, int id){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.134 -0500", hash_original_method = "3CD43707F03704504C516530F93524E9", hash_generated_method = "0BA84DAA0BBFB74BEC62588C9677C974")
    
synchronized void nObjDestroy(int id) {
        // There is a race condition here.  The calling code may be run
        // by the gc while teardown is occuring.  This protects againts
        // deleting dead objects.
        if (mContext != 0) {
            rsnObjDestroy(mContext, id);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.137 -0500", hash_original_method = "A23832C8C4F03477F79E249ABA3C5448", hash_generated_method = "9C40637015634DD393DE51269BA9F118")
    
    int  rsnElementCreate(int con, int type, int kind, boolean norm, int vecSize){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(type);
    	addTaint(kind);
    	addTaint(norm);
    	addTaint(vecSize);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.139 -0500", hash_original_method = "04F100AE25E26F680C6AFD4CDC98FC1F", hash_generated_method = "2F7D6244BBDD5E0D239F7798E7B4FCC8")
    
synchronized int nElementCreate(int type, int kind, boolean norm, int vecSize) {
        validate();
        return rsnElementCreate(mContext, type, kind, norm, vecSize);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.143 -0500", hash_original_method = "006061C4AD57EAE572CDCF8F10BA8A13", hash_generated_method = "D0B4491A8177F20A96B6A6B882B38FCB")
    
    int  rsnElementCreate2(int con, int[] elements, String[] names, int[] arraySizes){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(elements[0]);
    	addTaint(names[0].getTaint());
    	addTaint(arraySizes[0]);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.145 -0500", hash_original_method = "0F9A5A9DC528909436C7DAB5B96B0A92", hash_generated_method = "E76E1D27C1232F3B19BED2CC12AD1394")
    
synchronized int nElementCreate2(int[] elements, String[] names, int[] arraySizes) {
        validate();
        return rsnElementCreate2(mContext, elements, names, arraySizes);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.149 -0500", hash_original_method = "C49261353C664D6FA896CF226B67D498", hash_generated_method = "3FD82EC099F8643B76BE9AB80A9060AB")
    
    void rsnElementGetNativeData(int con, int id, int[] elementData){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(elementData[0]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.151 -0500", hash_original_method = "ED92A0CF1AB71C2B4406A54EAA77DB9F", hash_generated_method = "D471AC66861D6286D667F40A10FD3B19")
    
synchronized void nElementGetNativeData(int id, int[] elementData) {
        validate();
        rsnElementGetNativeData(mContext, id, elementData);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.154 -0500", hash_original_method = "33A6434B836B117A2B38B29F8831D0F0", hash_generated_method = "0AE18C4C0F8B965E9E8138B8EE9AF00F")
    
    void rsnElementGetSubElements(int con, int id,
                                             int[] IDs, String[] names, int[] arraySizes){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(IDs[0]);
    	addTaint(names[0].getTaint());
    	addTaint(arraySizes[0]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.156 -0500", hash_original_method = "EF8F1F438E62125221A12E7AB1122C9E", hash_generated_method = "DDEC5CB218E1B21415709013D8A7E18D")
    
synchronized void nElementGetSubElements(int id, int[] IDs, String[] names, int[] arraySizes) {
        validate();
        rsnElementGetSubElements(mContext, id, IDs, names, arraySizes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.159 -0500", hash_original_method = "994B815F598F428E534810B5FF2CA01E", hash_generated_method = "064483BE14F17823257A1C8F6CC5C528")
    
    int rsnTypeCreate(int con, int eid, int x, int y, int z, boolean mips, boolean faces){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(eid);
    	addTaint(x);
    	addTaint(y);
    	addTaint(z);
    	addTaint(mips);
    	addTaint(faces);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.161 -0500", hash_original_method = "5BC12238B0743B47577319FCBD22C49B", hash_generated_method = "E188F7B0858A754A9CBF148EE989999E")
    
synchronized int nTypeCreate(int eid, int x, int y, int z, boolean mips, boolean faces) {
        validate();
        return rsnTypeCreate(mContext, eid, x, y, z, mips, faces);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.165 -0500", hash_original_method = "F312FE90A7285CB098BF912090C5FAB1", hash_generated_method = "28F3ACF0AFF2F865ED15E0FB7AFA2058")
    
    void rsnTypeGetNativeData(int con, int id, int[] typeData){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(typeData[0]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.168 -0500", hash_original_method = "14DE3B66A3D39638378078881D754C6E", hash_generated_method = "D67CD466B45DC9682C4D008548B64C62")
    
synchronized void nTypeGetNativeData(int id, int[] typeData) {
        validate();
        rsnTypeGetNativeData(mContext, id, typeData);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.171 -0500", hash_original_method = "1EF04876BAB02F926C35D0D430944B30", hash_generated_method = "32C7A06C995A0525FE7034241904AE6F")
    
    int  rsnAllocationCreateTyped(int con, int type, int mip, int usage){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(type);
    	addTaint(mip);
    	addTaint(usage);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.173 -0500", hash_original_method = "14A63C0D1BE64E9A6BBEC637317D094F", hash_generated_method = "6AE1763F3E59C59A8AE2E2F508194E7F")
    
synchronized int nAllocationCreateTyped(int type, int mip, int usage) {
        validate();
        return rsnAllocationCreateTyped(mContext, type, mip, usage);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.178 -0500", hash_original_method = "5E0A2F1801533641650164E2B5110D9B", hash_generated_method = "5B86F80E60C8A18932C4DCB54C8B68E4")
    
    int  rsnAllocationCreateFromBitmap(int con, int type, int mip, Bitmap bmp, int usage){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(type);
    	addTaint(mip);
    	addTaint(bmp.getTaint());
    	addTaint(usage);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.180 -0500", hash_original_method = "C38046DC6D50E5167A216243F556CC46", hash_generated_method = "34E7B2816882070F567DB048B7A34273")
    
synchronized int nAllocationCreateFromBitmap(int type, int mip, Bitmap bmp, int usage) {
        validate();
        return rsnAllocationCreateFromBitmap(mContext, type, mip, bmp, usage);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.183 -0500", hash_original_method = "78AC0674291BD672E8BF6DD1FCB58CB6", hash_generated_method = "CC5A8CD834A1C0C4D5D92D3DE16CEAB9")
    
    int  rsnAllocationCubeCreateFromBitmap(int con, int type, int mip, Bitmap bmp, int usage){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(type);
    	addTaint(mip);
    	addTaint(bmp.getTaint());
    	addTaint(usage);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.185 -0500", hash_original_method = "1C76695BCAC6B196308AF162882963A2", hash_generated_method = "D0CDC864EB9096E47185BE808788E59A")
    
synchronized int nAllocationCubeCreateFromBitmap(int type, int mip, Bitmap bmp, int usage) {
        validate();
        return rsnAllocationCubeCreateFromBitmap(mContext, type, mip, bmp, usage);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.189 -0500", hash_original_method = "180A66856BA5C89E33ED9E70F522DAF8", hash_generated_method = "7FD108E1FE80798E7EA3CAEC0AF5DAF5")
    
    int  rsnAllocationCreateBitmapRef(int con, int type, Bitmap bmp){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(type);
    	addTaint(bmp.getTaint());
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.191 -0500", hash_original_method = "5BEDEEA6EE7AFE0E77451EBA243C265F", hash_generated_method = "6CB15DBCB38E74B13C03860AC76A152E")
    
synchronized int nAllocationCreateBitmapRef(int type, Bitmap bmp) {
        validate();
        return rsnAllocationCreateBitmapRef(mContext, type, bmp);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.194 -0500", hash_original_method = "659BC129345B51ED115EA0AF453E73DA", hash_generated_method = "AFAFC1CAE4EEA00C1F87457F19BA7BF5")
    
    int  rsnAllocationCreateFromAssetStream(int con, int mips, int assetStream, int usage){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(mips);
    	addTaint(assetStream);
    	addTaint(usage);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.197 -0500", hash_original_method = "FCDA7166178C095DBC408E6F28FA0674", hash_generated_method = "8A4324F825770A9D768DF25478BE654D")
    
synchronized int nAllocationCreateFromAssetStream(int mips, int assetStream, int usage) {
        validate();
        return rsnAllocationCreateFromAssetStream(mContext, mips, assetStream, usage);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.200 -0500", hash_original_method = "6B8384B4227CBF77C9DD330F22899701", hash_generated_method = "86812F41EF313CF276D0148408C6F24B")
    
    void  rsnAllocationCopyToBitmap(int con, int alloc, Bitmap bmp){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(alloc);
    	addTaint(bmp.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.202 -0500", hash_original_method = "33A1DADE17FD02C344DA52C79E764A6E", hash_generated_method = "E6A3761937F5156D63892895E971F5B0")
    
synchronized void nAllocationCopyToBitmap(int alloc, Bitmap bmp) {
        validate();
        rsnAllocationCopyToBitmap(mContext, alloc, bmp);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.205 -0500", hash_original_method = "3121E732BD190EDE1807049E3BD6D7DA", hash_generated_method = "8AACE35A9B6261CF189726904DFD4F6D")
    
    void rsnAllocationSyncAll(int con, int alloc, int src){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(alloc);
    	addTaint(src);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.207 -0500", hash_original_method = "00E19076EDF1F68A332E30E1DA83ABC3", hash_generated_method = "1F34F297DEC45B84FB697FF7B1708C41")
    
synchronized void nAllocationSyncAll(int alloc, int src) {
        validate();
        rsnAllocationSyncAll(mContext, alloc, src);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.212 -0500", hash_original_method = "70B64AEBC9F2A08DD702D1F1083AF457", hash_generated_method = "D5CAF9431521BB0312E8D00063EB4061")
    
    void rsnAllocationGenerateMipmaps(int con, int alloc){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(alloc);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.214 -0500", hash_original_method = "80A37887BF534CD573848EE87B5881CB", hash_generated_method = "43B49750CF9E4FF38617172DB664303E")
    
synchronized void nAllocationGenerateMipmaps(int alloc) {
        validate();
        rsnAllocationGenerateMipmaps(mContext, alloc);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.218 -0500", hash_original_method = "90AF2E8BDCC3B2A5C7CEEAB496515689", hash_generated_method = "6CEE79F876877731459C3E7263FB0E02")
    
    void  rsnAllocationCopyFromBitmap(int con, int alloc, Bitmap bmp){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(alloc);
    	addTaint(bmp.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.220 -0500", hash_original_method = "DEDA373B30BBD5AB8E63FE00A208FC33", hash_generated_method = "A4577FF08CCB3B783C07C72CD3989E47")
    
synchronized void nAllocationCopyFromBitmap(int alloc, Bitmap bmp) {
        validate();
        rsnAllocationCopyFromBitmap(mContext, alloc, bmp);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.224 -0500", hash_original_method = "1C01F509C8F49D01D10DE0EA5CB1F527", hash_generated_method = "1170DD0CB3456D6CC1413B70C5C3A20E")
    
    void rsnAllocationData1D(int con, int id, int off, int mip, int count, int[] d, int sizeBytes){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(off);
    	addTaint(mip);
    	addTaint(count);
    	addTaint(d[0]);
    	addTaint(sizeBytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.226 -0500", hash_original_method = "5856F0672F738C4E210FC0F2E55D57A5", hash_generated_method = "1D9EC92BBD818FFE8A37641F78BE6DC7")
    
synchronized void nAllocationData1D(int id, int off, int mip, int count, int[] d, int sizeBytes) {
        validate();
        rsnAllocationData1D(mContext, id, off, mip, count, d, sizeBytes);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.229 -0500", hash_original_method = "FDF60A90B9E11C1D899645930F7523E3", hash_generated_method = "719C478EFB6726FF52D9F90557F3E18A")
    
    void rsnAllocationData1D(int con, int id, int off, int mip, int count, short[] d, int sizeBytes){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(off);
    	addTaint(mip);
    	addTaint(count);
    	addTaint(d[0]);
    	addTaint(sizeBytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.231 -0500", hash_original_method = "E0E3C0B0ECD98F97C6BCBD38CE726044", hash_generated_method = "E92630E47BA4E6B464B913632411F3DE")
    
synchronized void nAllocationData1D(int id, int off, int mip, int count, short[] d, int sizeBytes) {
        validate();
        rsnAllocationData1D(mContext, id, off, mip, count, d, sizeBytes);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.235 -0500", hash_original_method = "B57CF17F316A444F47B4E2E8E4737041", hash_generated_method = "720DDFF6B1E488804665B31BF47112D1")
    
    void rsnAllocationData1D(int con, int id, int off, int mip, int count, byte[] d, int sizeBytes){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(off);
    	addTaint(mip);
    	addTaint(count);
    	addTaint(d[0]);
    	addTaint(sizeBytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.237 -0500", hash_original_method = "1629FA43490A3E016402068846DD0F5F", hash_generated_method = "D2B994F47220FB0BBE88327E88DA7715")
    
synchronized void nAllocationData1D(int id, int off, int mip, int count, byte[] d, int sizeBytes) {
        validate();
        rsnAllocationData1D(mContext, id, off, mip, count, d, sizeBytes);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.241 -0500", hash_original_method = "80FDFEBE6C2830B2A228AC81FC751501", hash_generated_method = "87B2CCBAD964D3BD363F15627E9B5A23")
    
    void rsnAllocationData1D(int con, int id, int off, int mip, int count, float[] d, int sizeBytes){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(off);
    	addTaint(mip);
    	addTaint(count);
    	addTaint(d[0]);
    	addTaint(sizeBytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.243 -0500", hash_original_method = "722C4C8DF700A391C4018926795A6887", hash_generated_method = "E2190BD1E26B8C11B20B1833AECA12EB")
    
synchronized void nAllocationData1D(int id, int off, int mip, int count, float[] d, int sizeBytes) {
        validate();
        rsnAllocationData1D(mContext, id, off, mip, count, d, sizeBytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.246 -0500", hash_original_method = "44CF80DA13785695234C9F6E63004FA6", hash_generated_method = "06A65D97D23C4E2DCB9F4324C68E7E2D")
    
    void rsnAllocationElementData1D(int con, int id, int xoff, int mip, int compIdx, byte[] d, int sizeBytes){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(xoff);
    	addTaint(mip);
    	addTaint(compIdx);
    	addTaint(d[0]);
    	addTaint(sizeBytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.248 -0500", hash_original_method = "DE600857C9D165E3FCB6D7CAA71BB9E8", hash_generated_method = "DF242772B6B894F1A5974891513A21B5")
    
synchronized void nAllocationElementData1D(int id, int xoff, int mip, int compIdx, byte[] d, int sizeBytes) {
        validate();
        rsnAllocationElementData1D(mContext, id, xoff, mip, compIdx, d, sizeBytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.252 -0500", hash_original_method = "682805A358DBA000E103929465DD3222", hash_generated_method = "04B4D8E4A2460787615CEFEF3EC2CB58")
    
    void rsnAllocationData2D(int con,
                                        int dstAlloc, int dstXoff, int dstYoff,
                                        int dstMip, int dstFace,
                                        int width, int height,
                                        int srcAlloc, int srcXoff, int srcYoff,
                                        int srcMip, int srcFace){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(dstAlloc);
    	addTaint(dstXoff);
    	addTaint(dstYoff);
    	addTaint(dstMip);
    	addTaint(dstFace);
    	addTaint(width);
    	addTaint(height);
    	addTaint(srcAlloc);
    	addTaint(srcXoff);
    	addTaint(srcYoff);
    	addTaint(srcMip);
    	addTaint(srcFace);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.254 -0500", hash_original_method = "466039336F12CBCD5A6796B706C69F57", hash_generated_method = "AA8EE20657FC8A83F35D08CBCD40AADA")
    
synchronized void nAllocationData2D(int dstAlloc, int dstXoff, int dstYoff,
                                        int dstMip, int dstFace,
                                        int width, int height,
                                        int srcAlloc, int srcXoff, int srcYoff,
                                        int srcMip, int srcFace) {
        validate();
        rsnAllocationData2D(mContext,
                            dstAlloc, dstXoff, dstYoff,
                            dstMip, dstFace,
                            width, height,
                            srcAlloc, srcXoff, srcYoff,
                            srcMip, srcFace);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.259 -0500", hash_original_method = "DA3DFEEFC474AD7115E2A7A23009F794", hash_generated_method = "7202CDA69062CA045BC58E978529B550")
    
    void rsnAllocationData2D(int con, int id, int xoff, int yoff, int mip, int face, int w, int h, byte[] d, int sizeBytes){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(xoff);
    	addTaint(yoff);
    	addTaint(mip);
    	addTaint(face);
    	addTaint(w);
    	addTaint(h);
    	addTaint(d[0]);
    	addTaint(sizeBytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.261 -0500", hash_original_method = "6BF9C83DF089B7D0B998D3C82F0B1FA0", hash_generated_method = "38875542CF7257FAE960CFA1B40C1268")
    
synchronized void nAllocationData2D(int id, int xoff, int yoff, int mip, int face, int w, int h, byte[] d, int sizeBytes) {
        validate();
        rsnAllocationData2D(mContext, id, xoff, yoff, mip, face, w, h, d, sizeBytes);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.265 -0500", hash_original_method = "7DEA1BB6C4AA745C8B1CC03EAA766803", hash_generated_method = "3E77931D12F0FB1BCF1B8F59FAAE3B45")
    
    void rsnAllocationData2D(int con, int id, int xoff, int yoff, int mip, int face, int w, int h, short[] d, int sizeBytes){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(xoff);
    	addTaint(yoff);
    	addTaint(mip);
    	addTaint(face);
    	addTaint(w);
    	addTaint(h);
    	addTaint(d[0]);
    	addTaint(sizeBytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.267 -0500", hash_original_method = "9BA3D71C4DAE136A278E0FEE1F9ABC46", hash_generated_method = "DF95D0BDF343ED8DF21514E02D3C2FDE")
    
synchronized void nAllocationData2D(int id, int xoff, int yoff, int mip, int face, int w, int h, short[] d, int sizeBytes) {
        validate();
        rsnAllocationData2D(mContext, id, xoff, yoff, mip, face, w, h, d, sizeBytes);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.271 -0500", hash_original_method = "6832BBFE570C1FD2D0DD153BF32FE8F4", hash_generated_method = "5341F2294F7CE73D5103FB5BC38DD3A5")
    
    void rsnAllocationData2D(int con, int id, int xoff, int yoff, int mip, int face, int w, int h, int[] d, int sizeBytes){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(xoff);
    	addTaint(yoff);
    	addTaint(mip);
    	addTaint(face);
    	addTaint(w);
    	addTaint(h);
    	addTaint(d[0]);
    	addTaint(sizeBytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.273 -0500", hash_original_method = "18C1C235A616F7FB4F95911B51D167D3", hash_generated_method = "002568830B5129E412B48CB130C6744C")
    
synchronized void nAllocationData2D(int id, int xoff, int yoff, int mip, int face, int w, int h, int[] d, int sizeBytes) {
        validate();
        rsnAllocationData2D(mContext, id, xoff, yoff, mip, face, w, h, d, sizeBytes);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.276 -0500", hash_original_method = "B6F49D413C56B3B78BC375C0469BE240", hash_generated_method = "09AA14F4EF108B259A11E09C903EBF6B")
    
    void rsnAllocationData2D(int con, int id, int xoff, int yoff, int mip, int face, int w, int h, float[] d, int sizeBytes){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(xoff);
    	addTaint(yoff);
    	addTaint(mip);
    	addTaint(face);
    	addTaint(w);
    	addTaint(h);
    	addTaint(d[0]);
    	addTaint(sizeBytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.279 -0500", hash_original_method = "5B0B36C68109F844B2872F22AC2A0713", hash_generated_method = "A15206C065A6823FF20318F5777819FC")
    
synchronized void nAllocationData2D(int id, int xoff, int yoff, int mip, int face, int w, int h, float[] d, int sizeBytes) {
        validate();
        rsnAllocationData2D(mContext, id, xoff, yoff, mip, face, w, h, d, sizeBytes);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.282 -0500", hash_original_method = "2B5B77E0B08431C78EA306DA88269EFD", hash_generated_method = "624E778BE84BEF77B2DBCFC33138C04F")
    
    void rsnAllocationData2D(int con, int id, int xoff, int yoff, int mip, int face, Bitmap b){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(xoff);
    	addTaint(yoff);
    	addTaint(mip);
    	addTaint(face);
    	addTaint(b.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.284 -0500", hash_original_method = "0BBBDAA03FF274914B36CF4135F1320F", hash_generated_method = "79609EB94ED1027466E78C682503B69C")
    
synchronized void nAllocationData2D(int id, int xoff, int yoff, int mip, int face, Bitmap b) {
        validate();
        rsnAllocationData2D(mContext, id, xoff, yoff, mip, face, b);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.288 -0500", hash_original_method = "DA7A5765B134D4DAD6F68BC55FDD6A80", hash_generated_method = "EDECFDAFB8BC7A5C6B6CC8048BA2B576")
    
    void rsnAllocationRead(int con, int id, byte[] d){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(d[0]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.291 -0500", hash_original_method = "92862620C93746FDC18FD4C3B1FBC2C9", hash_generated_method = "881454FB8347D1F9D2586496F017B582")
    
synchronized void nAllocationRead(int id, byte[] d) {
        validate();
        rsnAllocationRead(mContext, id, d);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.294 -0500", hash_original_method = "706DAEC288FC23DD66E5C781F2902537", hash_generated_method = "A4913BF838C42E44A9ACB5A26365909C")
    
    void rsnAllocationRead(int con, int id, short[] d){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(d[0]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.296 -0500", hash_original_method = "70B197E638C9B33B94B98D696E0DF1EE", hash_generated_method = "2046C70132722C7F99F73F65A5847F9F")
    
synchronized void nAllocationRead(int id, short[] d) {
        validate();
        rsnAllocationRead(mContext, id, d);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.299 -0500", hash_original_method = "8434FE2EE1CBF9D4B92804EB617B1975", hash_generated_method = "69FF1080373CB692C5168BAD32D00CF8")
    
    void rsnAllocationRead(int con, int id, int[] d){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(d[0]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.302 -0500", hash_original_method = "AA67CDF12A47ACA55B6091E0DE4E490D", hash_generated_method = "D06B2574AC1C67500C4A14772A6C0352")
    
synchronized void nAllocationRead(int id, int[] d) {
        validate();
        rsnAllocationRead(mContext, id, d);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.305 -0500", hash_original_method = "AD441DD55E321F20539A93188DA8B240", hash_generated_method = "1274364FBEBBB77CFEE42F18C44FE6E1")
    
    void rsnAllocationRead(int con, int id, float[] d){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(d[0]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.308 -0500", hash_original_method = "7BE8098A69829EC69DAFD2BED79C8C96", hash_generated_method = "94280FE3619DE3CF49187233F3F905DE")
    
synchronized void nAllocationRead(int id, float[] d) {
        validate();
        rsnAllocationRead(mContext, id, d);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.311 -0500", hash_original_method = "FFE36F4830D9AE1ABA8A675B46783EF2", hash_generated_method = "E4AB65929BAB5E11A4B849EC172E2E04")
    
    int  rsnAllocationGetType(int con, int id){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.313 -0500", hash_original_method = "5415B0DAEC36E4470E9C2C35420A77FB", hash_generated_method = "B6C243B832A4A315B5681CA22D4E7228")
    
synchronized int nAllocationGetType(int id) {
        validate();
        return rsnAllocationGetType(mContext, id);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.316 -0500", hash_original_method = "CE0C1AECDCD62EDFBCEC1C9EA07AE47A", hash_generated_method = "F535BA58F3C1F857CCC23DA8F6E4F78F")
    
    void rsnAllocationResize1D(int con, int id, int dimX){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(dimX);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.319 -0500", hash_original_method = "B9152F199D1418FFC1B1326F10D9C26D", hash_generated_method = "827506ED00D91DF53D0D68D450C8A9A6")
    
synchronized void nAllocationResize1D(int id, int dimX) {
        validate();
        rsnAllocationResize1D(mContext, id, dimX);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.322 -0500", hash_original_method = "51C3F0EDFD5849ABEAF14775297F3D8D", hash_generated_method = "0E4E4F69D4997E2547A7C4CC3D7D7E47")
    
    void rsnAllocationResize2D(int con, int id, int dimX, int dimY){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(dimX);
    	addTaint(dimY);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.324 -0500", hash_original_method = "F6A2096E5C08E8B7A947CEC18429B5C0", hash_generated_method = "8FC6FED72BE233FCCA733E1C7D588AC9")
    
synchronized void nAllocationResize2D(int id, int dimX, int dimY) {
        validate();
        rsnAllocationResize2D(mContext, id, dimX, dimY);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.328 -0500", hash_original_method = "09190CE6465F8E50D726E7F537565F54", hash_generated_method = "D51D2B76244B2929B649B0191A5A05DF")
    
    int  rsnFileA3DCreateFromAssetStream(int con, int assetStream){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(assetStream);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.330 -0500", hash_original_method = "CE06132BC9BE17513589F52D66BB7BA4", hash_generated_method = "AF668A453D41711E79C1F9E25BB797E4")
    
synchronized int nFileA3DCreateFromAssetStream(int assetStream) {
        validate();
        return rsnFileA3DCreateFromAssetStream(mContext, assetStream);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.334 -0500", hash_original_method = "F6838A6ADF02EA75BD13EEE3FAA1C39A", hash_generated_method = "B0B0F61E379B0A0F4A55A8F1DC56A15B")
    
    int  rsnFileA3DCreateFromFile(int con, String path){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(path.getTaint());
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.336 -0500", hash_original_method = "259584A6C4AF840D3FCDDCC9825B817A", hash_generated_method = "4C8CE14305AFCB731F935F6293C26404")
    
synchronized int nFileA3DCreateFromFile(String path) {
        validate();
        return rsnFileA3DCreateFromFile(mContext, path);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.339 -0500", hash_original_method = "09CEFBD2C394F11A2473BA687A5CAD9C", hash_generated_method = "A4F308CE68B0206874C2931DCD82CB3B")
    
    int  rsnFileA3DCreateFromAsset(int con, AssetManager mgr, String path){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(mgr.getTaint());
    	addTaint(path.getTaint());
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.341 -0500", hash_original_method = "78D008846307EDF4BB828507DB4375FC", hash_generated_method = "D18D01EC06D3A553F5C0CF1F77F64CB3")
    
synchronized int nFileA3DCreateFromAsset(AssetManager mgr, String path) {
        validate();
        return rsnFileA3DCreateFromAsset(mContext, mgr, path);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.344 -0500", hash_original_method = "E83515FA6039EB0E25B32B02E6CEB77F", hash_generated_method = "2C29D5DC7509F2AA9949D270DD8AADF1")
    
    int  rsnFileA3DGetNumIndexEntries(int con, int fileA3D){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(fileA3D);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.347 -0500", hash_original_method = "99F99C35E73D8D693E61A61415FFF9EA", hash_generated_method = "1400C7EC71BD59D0D11B3074BBFAAD5C")
    
synchronized int nFileA3DGetNumIndexEntries(int fileA3D) {
        validate();
        return rsnFileA3DGetNumIndexEntries(mContext, fileA3D);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.351 -0500", hash_original_method = "083FBBD551DC759D09A4D41AFC623D49", hash_generated_method = "4B5CD73502A6127644F6B05FC0B41B34")
    
    void rsnFileA3DGetIndexEntries(int con, int fileA3D, int numEntries, int[] IDs, String[] names){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(fileA3D);
    	addTaint(numEntries);
    	addTaint(IDs[0]);
    	addTaint(names[0].getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.353 -0500", hash_original_method = "085782AB2C8843757607A11D98246CAF", hash_generated_method = "7FC3A91ADE9A8534D602CBC08F881C93")
    
synchronized void nFileA3DGetIndexEntries(int fileA3D, int numEntries, int[] IDs, String[] names) {
        validate();
        rsnFileA3DGetIndexEntries(mContext, fileA3D, numEntries, IDs, names);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.356 -0500", hash_original_method = "EBA33CD24FD2CC163BED3CFC10DAEBB3", hash_generated_method = "D6F8A5E701C7B9783103FEF8410300C3")
    
    int  rsnFileA3DGetEntryByIndex(int con, int fileA3D, int index){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(fileA3D);
    	addTaint(index);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.358 -0500", hash_original_method = "5B50168153C855E5E04AADE079858E18", hash_generated_method = "BA2AC1625CE022CAF70C0F4506487D86")
    
synchronized int nFileA3DGetEntryByIndex(int fileA3D, int index) {
        validate();
        return rsnFileA3DGetEntryByIndex(mContext, fileA3D, index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.362 -0500", hash_original_method = "340F5632848FA5D2CDAEF006EFD2A561", hash_generated_method = "CC92EEF9EA893E8847EC0B93872D5E00")
    
    int  rsnFontCreateFromFile(int con, String fileName, float size, int dpi){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(fileName.getTaint());
    	addTaint(size);
    	addTaint(dpi);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.364 -0500", hash_original_method = "28A28895F76BBC9CFBC68FD7763EFF95", hash_generated_method = "95B68D5B2C458BA67FB763E8B6AAED78")
    
synchronized int nFontCreateFromFile(String fileName, float size, int dpi) {
        validate();
        return rsnFontCreateFromFile(mContext, fileName, size, dpi);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.368 -0500", hash_original_method = "0990697360294393EF10841D258568F9", hash_generated_method = "DA5FE9B9CFCE7DEBDF2E263B03D20D4F")
    
    int  rsnFontCreateFromAssetStream(int con, String name, float size, int dpi, int assetStream){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(name.getTaint());
    	addTaint(size);
    	addTaint(dpi);
    	addTaint(assetStream);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.370 -0500", hash_original_method = "B968FFC0200F2C5E93F70FBA02BD6807", hash_generated_method = "C39D5F8286EEEF8BEEFEFBBC7265C361")
    
synchronized int nFontCreateFromAssetStream(String name, float size, int dpi, int assetStream) {
        validate();
        return rsnFontCreateFromAssetStream(mContext, name, size, dpi, assetStream);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.373 -0500", hash_original_method = "EAA4C52AA1C955B5AD3DCC553FC28E9F", hash_generated_method = "0567BDE317F1405931B370CF475A8708")
    
    int  rsnFontCreateFromAsset(int con, AssetManager mgr, String path, float size, int dpi){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(mgr.getTaint());
    	addTaint(path.getTaint());
    	addTaint(size);
    	addTaint(dpi);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.376 -0500", hash_original_method = "C697253A4D3C38A6CFB3ACB5EE2CAD91", hash_generated_method = "8CE558B0115189AC4F694AD1646334BF")
    
synchronized int nFontCreateFromAsset(AssetManager mgr, String path, float size, int dpi) {
        validate();
        return rsnFontCreateFromAsset(mContext, mgr, path, size, dpi);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.379 -0500", hash_original_method = "18F6766928BD2496841B330F96A93DA7", hash_generated_method = "483A525E3744F22BA77B07D553F5C6C8")
    
    void rsnScriptBindAllocation(int con, int script, int alloc, int slot){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(script);
    	addTaint(alloc);
    	addTaint(slot);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.381 -0500", hash_original_method = "57405F6B532BC58637377E58D58B1A1A", hash_generated_method = "27AB7CE6955F6D0617770158A6404EA4")
    
synchronized void nScriptBindAllocation(int script, int alloc, int slot) {
        validate();
        rsnScriptBindAllocation(mContext, script, alloc, slot);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.384 -0500", hash_original_method = "51D4DD6285C6385CEC2901AA7D96C3F9", hash_generated_method = "BECA4A944B8D718B4F264F51500B10B0")
    
    void rsnScriptSetTimeZone(int con, int script, byte[] timeZone){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(script);
    	addTaint(timeZone[0]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.386 -0500", hash_original_method = "48BAAAF24107E03AA3257E0376F915FC", hash_generated_method = "ED30A7A3E0533B36CA7CD44480FEDE95")
    
synchronized void nScriptSetTimeZone(int script, byte[] timeZone) {
        validate();
        rsnScriptSetTimeZone(mContext, script, timeZone);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.391 -0500", hash_original_method = "9B180EC295A326A05B733BD89539D750", hash_generated_method = "684B985CD934695EF044F6A2C6DD3551")
    
    void rsnScriptInvoke(int con, int id, int slot){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(slot);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.393 -0500", hash_original_method = "7C1247C571044789B0C33D555F9DF160", hash_generated_method = "BF4AE3F6D38CB12C168D2CDDF930885A")
    
synchronized void nScriptInvoke(int id, int slot) {
        validate();
        rsnScriptInvoke(mContext, id, slot);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.397 -0500", hash_original_method = "A0E23D75C3244113330177A36D432FA8", hash_generated_method = "3CBC6EAA91C0BE56957C360C81B7FD51")
    
    void rsnScriptForEach(int con, int id, int slot, int ain, int aout, byte[] params){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(slot);
    	addTaint(ain);
    	addTaint(aout);
    	addTaint(params[0]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.400 -0500", hash_original_method = "1CFC7A94FCFBCD561583C7AF787A5FD7", hash_generated_method = "C9382CA5F1CD6DDC7C7CB82084802EC6")
    
    void rsnScriptForEach(int con, int id, int slot, int ain, int aout){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(slot);
    	addTaint(ain);
    	addTaint(aout);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.402 -0500", hash_original_method = "27222BF8CF1E37CCF21B04401F1EE63C", hash_generated_method = "D3E9950F759C5F69B0EEBE7C77FAD2AF")
    
synchronized void nScriptForEach(int id, int slot, int ain, int aout, byte[] params) {
        validate();
        if (params == null) {
            rsnScriptForEach(mContext, id, slot, ain, aout);
        } else {
            rsnScriptForEach(mContext, id, slot, ain, aout, params);
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.406 -0500", hash_original_method = "B9E1FC1B908E2E406E4393D0EF11FE9F", hash_generated_method = "452E16A41BEF1E405AD2D2FB10F0B405")
    
    void rsnScriptInvokeV(int con, int id, int slot, byte[] params){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(slot);
    	addTaint(params[0]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.408 -0500", hash_original_method = "DB210F2CE225572540E11A267A7106B3", hash_generated_method = "82A4A4FEDB53B8D03B1A9CE40E79E685")
    
synchronized void nScriptInvokeV(int id, int slot, byte[] params) {
        validate();
        rsnScriptInvokeV(mContext, id, slot, params);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.412 -0500", hash_original_method = "D8F234C930BE7A20C1E10F900091CCED", hash_generated_method = "4102130190AFD8856CB1FDB53B4985F2")
    
    void rsnScriptSetVarI(int con, int id, int slot, int val){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(slot);
    	addTaint(val);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.414 -0500", hash_original_method = "63E8F5B280969990BEAC43D4E0EF38F8", hash_generated_method = "F3BEFDBAAC244EC958929AA6217B0C95")
    
synchronized void nScriptSetVarI(int id, int slot, int val) {
        validate();
        rsnScriptSetVarI(mContext, id, slot, val);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.417 -0500", hash_original_method = "605BA9B2284E874E74ADEC41E3481958", hash_generated_method = "86669E970D5AB50BE9C54D17BCE5B4FE")
    
    void rsnScriptSetVarJ(int con, int id, int slot, long val){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(slot);
    	addTaint(val);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.420 -0500", hash_original_method = "788902B5F4AD2D00B18EC7BEE76B5EBA", hash_generated_method = "5FA8D664945AA540B97A43706EA9D832")
    
synchronized void nScriptSetVarJ(int id, int slot, long val) {
        validate();
        rsnScriptSetVarJ(mContext, id, slot, val);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.423 -0500", hash_original_method = "8E64101E3D7FE45660F010F941CFFBB6", hash_generated_method = "BFEF468BE4C5D0A2ACA0FC0406790D1D")
    
    void rsnScriptSetVarF(int con, int id, int slot, float val){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(slot);
    	addTaint(val);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.425 -0500", hash_original_method = "4E52AADA144D88D743331B7E6EDCB84C", hash_generated_method = "DE838EBD9828151D5ACEC228CC276203")
    
synchronized void nScriptSetVarF(int id, int slot, float val) {
        validate();
        rsnScriptSetVarF(mContext, id, slot, val);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.428 -0500", hash_original_method = "7C1C9B19C26998848F0F919D02610E77", hash_generated_method = "B3CDE7D24D80D88B2A31963E59DE26AF")
    
    void rsnScriptSetVarD(int con, int id, int slot, double val){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(slot);
    	addTaint(val);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.431 -0500", hash_original_method = "904F50593DCA228E32CBF04970112136", hash_generated_method = "01BA379E1BF7CDFD45C0517296F6E130")
    
synchronized void nScriptSetVarD(int id, int slot, double val) {
        validate();
        rsnScriptSetVarD(mContext, id, slot, val);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.434 -0500", hash_original_method = "959BD0E98B18AB542E1E3BED6ACCBEEE", hash_generated_method = "AECA103F05406658B322AAF1D49E108E")
    
    void rsnScriptSetVarV(int con, int id, int slot, byte[] val){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(slot);
    	addTaint(val[0]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.437 -0500", hash_original_method = "0CA6A1373CCCAA2B761A251055F680EE", hash_generated_method = "53A088A846D58FBCA27953D8549D69AE")
    
synchronized void nScriptSetVarV(int id, int slot, byte[] val) {
        validate();
        rsnScriptSetVarV(mContext, id, slot, val);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.440 -0500", hash_original_method = "55EF4E7BB4035AB3427C26A3D9517DDB", hash_generated_method = "8BC5B9E72A0135791889D965A665A25C")
    
    void rsnScriptSetVarObj(int con, int id, int slot, int val){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(slot);
    	addTaint(val);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.442 -0500", hash_original_method = "3195DAD065CDA5BA3B31D2107834F385", hash_generated_method = "AD1B6D93E54D896DF69A9CFC18D84ECD")
    
synchronized void nScriptSetVarObj(int id, int slot, int val) {
        validate();
        rsnScriptSetVarObj(mContext, id, slot, val);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.446 -0500", hash_original_method = "CC94824DFA1E842EFBE8DA43E5120411", hash_generated_method = "3428DF7C63B68FFC4549D2B0A96DA17D")
    
    int  rsnScriptCCreate(int con, String resName, String cacheDir,
                                     byte[] script, int length){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(resName.getTaint());
    	addTaint(cacheDir.getTaint());
    	addTaint(script[0]);
    	addTaint(length);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.448 -0500", hash_original_method = "4F8B925AC1F308D7AD1224364C3D3B15", hash_generated_method = "BB9D44B3FCDE7C0A048AE3BFFC34E60A")
    
synchronized int nScriptCCreate(String resName, String cacheDir, byte[] script, int length) {
        validate();
        return rsnScriptCCreate(mContext, resName, cacheDir, script, length);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.452 -0500", hash_original_method = "F50A4C7270733FDFCE920150AD78688F", hash_generated_method = "52AE65FD4B6BA7612C6376080023C502")
    
    int  rsnSamplerCreate(int con, int magFilter, int minFilter,
                                     int wrapS, int wrapT, int wrapR, float aniso){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(magFilter);
    	addTaint(minFilter);
    	addTaint(wrapS);
    	addTaint(wrapT);
    	addTaint(wrapR);
    	addTaint(aniso);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.454 -0500", hash_original_method = "E4C144D939996B89BE383276ED88146B", hash_generated_method = "C42B2882ADA4E6B5F58FE00D5651C51F")
    
synchronized int nSamplerCreate(int magFilter, int minFilter,
                                 int wrapS, int wrapT, int wrapR, float aniso) {
        validate();
        return rsnSamplerCreate(mContext, magFilter, minFilter, wrapS, wrapT, wrapR, aniso);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.457 -0500", hash_original_method = "7C375D6EBBA6AC09A4FAB784E2CB08EF", hash_generated_method = "93D0A0DEE751BBC1D82DBE93009A9EEB")
    
    int  rsnProgramStoreCreate(int con, boolean r, boolean g, boolean b, boolean a,
                                          boolean depthMask, boolean dither,
                                          int srcMode, int dstMode, int depthFunc){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(r);
    	addTaint(g);
    	addTaint(b);
    	addTaint(a);
    	addTaint(depthMask);
    	addTaint(dither);
    	addTaint(srcMode);
    	addTaint(dstMode);
    	addTaint(depthFunc);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.460 -0500", hash_original_method = "C24E51CD5756A917243C92AD71BD6904", hash_generated_method = "C0744125A9D40F4FCBA4A4BA20887755")
    
synchronized int nProgramStoreCreate(boolean r, boolean g, boolean b, boolean a,
                                         boolean depthMask, boolean dither,
                                         int srcMode, int dstMode, int depthFunc) {
        validate();
        return rsnProgramStoreCreate(mContext, r, g, b, a, depthMask, dither, srcMode,
                                     dstMode, depthFunc);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.463 -0500", hash_original_method = "6E71183393586682CEDAE8931FDAB9C9", hash_generated_method = "2F0CFC555C0D00A0971BFA206FDCAE1A")
    
    int  rsnProgramRasterCreate(int con, boolean pointSprite, int cullMode){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(pointSprite);
    	addTaint(cullMode);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.465 -0500", hash_original_method = "3C269E28ADE0BF12F6ABB9A34C7CB59C", hash_generated_method = "071286589E7C66E24CB2F15A9009DA91")
    
synchronized int nProgramRasterCreate(boolean pointSprite, int cullMode) {
        validate();
        return rsnProgramRasterCreate(mContext, pointSprite, cullMode);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.469 -0500", hash_original_method = "10B2B54F2C84586E08FD71E662CEAE79", hash_generated_method = "CF19841A6DE94294B4F7A00286A9208B")
    
    void rsnProgramBindConstants(int con, int pv, int slot, int mID){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(pv);
    	addTaint(slot);
    	addTaint(mID);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.471 -0500", hash_original_method = "C1808F235D84009997366993D8753D63", hash_generated_method = "B7342A3776ED7997771D1A20BD7F913C")
    
synchronized void nProgramBindConstants(int pv, int slot, int mID) {
        validate();
        rsnProgramBindConstants(mContext, pv, slot, mID);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.475 -0500", hash_original_method = "A5393DDF51FEEBEC84057EDB9AFE0F88", hash_generated_method = "3F897522712B503C46D665E4E8FA1DBB")
    
    void rsnProgramBindTexture(int con, int vpf, int slot, int a){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(vpf);
    	addTaint(slot);
    	addTaint(a);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.476 -0500", hash_original_method = "43DA2906E8F4DAEF3347BC1F4C1F4439", hash_generated_method = "2B05A9EECBC46368EFCAFE79847C9FEC")
    
synchronized void nProgramBindTexture(int vpf, int slot, int a) {
        validate();
        rsnProgramBindTexture(mContext, vpf, slot, a);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.480 -0500", hash_original_method = "249A5A80FED59E0B99180EEE5F2DCED2", hash_generated_method = "9CE81F5322355C604DFD8718D6B75EFC")
    
    void rsnProgramBindSampler(int con, int vpf, int slot, int s){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(vpf);
    	addTaint(slot);
    	addTaint(s);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.482 -0500", hash_original_method = "C18BB9FFAA60EE0E582B77603B834F27", hash_generated_method = "64792C183D6E6841539C65EA8625A35A")
    
synchronized void nProgramBindSampler(int vpf, int slot, int s) {
        validate();
        rsnProgramBindSampler(mContext, vpf, slot, s);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.486 -0500", hash_original_method = "088578627A7DFD7C5D51A6E257B34F2A", hash_generated_method = "CBB80CAC1409DBD3CEDDB39AF657988F")
    
    int  rsnProgramFragmentCreate(int con, String shader, int[] params){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(shader.getTaint());
    	addTaint(params[0]);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.488 -0500", hash_original_method = "7F7692EDFB515ECAB003706ED08D9F8F", hash_generated_method = "FEA56227B0E494D928D16CC92A138F57")
    
synchronized int nProgramFragmentCreate(String shader, int[] params) {
        validate();
        return rsnProgramFragmentCreate(mContext, shader, params);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.491 -0500", hash_original_method = "136B9315A7C89A9C4AB12C26BB74BD37", hash_generated_method = "D1532394AD012661B85ECAEAF9723CAF")
    
    int  rsnProgramVertexCreate(int con, String shader, int[] params){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(shader.getTaint());
    	addTaint(params[0]);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.494 -0500", hash_original_method = "B69763FC594958BE82AD97B79A28F61B", hash_generated_method = "E61C856F0BF5DBB51111E2A348B72D86")
    
synchronized int nProgramVertexCreate(String shader, int[] params) {
        validate();
        return rsnProgramVertexCreate(mContext, shader, params);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.497 -0500", hash_original_method = "B5F7D13D6DA39EA7BF6A3CC82A4EA459", hash_generated_method = "0E62B9F7E45156B151A2E702BEB58351")
    
    int  rsnMeshCreate(int con, int[] vtx, int[] idx, int[] prim){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(vtx[0]);
    	addTaint(idx[0]);
    	addTaint(prim[0]);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.499 -0500", hash_original_method = "929E2A8C64A9DBA6124E7BFD301DDFCC", hash_generated_method = "86E6CCEA21134D1A692108BD6FE6FA35")
    
synchronized int nMeshCreate(int[] vtx, int[] idx, int[] prim) {
        validate();
        return rsnMeshCreate(mContext, vtx, idx, prim);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.502 -0500", hash_original_method = "DA943F62890EC753AE2864FCA2B9D0E4", hash_generated_method = "8240E77FDFB6A5194AB8C1614D507997")
    
    int  rsnMeshGetVertexBufferCount(int con, int id){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.504 -0500", hash_original_method = "875C46919B8ED204A3CE3A9CCDF94192", hash_generated_method = "71EE0E466AB0BE4335BB121BB445A0F2")
    
synchronized int nMeshGetVertexBufferCount(int id) {
        validate();
        return rsnMeshGetVertexBufferCount(mContext, id);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.508 -0500", hash_original_method = "C3784AA70B12CEFE10C9208118EDB1A5", hash_generated_method = "CF30B4EE2B8AC9A0B28DE8FFDA010047")
    
    int  rsnMeshGetIndexCount(int con, int id){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.510 -0500", hash_original_method = "FE806BF77D2052883B37B5F96DE92297", hash_generated_method = "BC448993FE0028E95E5F47AF497D49FE")
    
synchronized int nMeshGetIndexCount(int id) {
        validate();
        return rsnMeshGetIndexCount(mContext, id);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.515 -0500", hash_original_method = "B8A05BB7D00248249F3BB536B2C0E9CA", hash_generated_method = "08963ED3E685324BBD88251C292941D1")
    
    void rsnMeshGetVertices(int con, int id, int[] vtxIds, int vtxIdCount){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(vtxIds[0]);
    	addTaint(vtxIdCount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.517 -0500", hash_original_method = "30F5280204C1F68BA9056A749144827E", hash_generated_method = "CFA6535E3AB8C3CFDC6DABFE71387A11")
    
synchronized void nMeshGetVertices(int id, int[] vtxIds, int vtxIdCount) {
        validate();
        rsnMeshGetVertices(mContext, id, vtxIds, vtxIdCount);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.520 -0500", hash_original_method = "EFB63D5DCEA905B624B981431149BE02", hash_generated_method = "B6646099645885E9B6D2E95060006913")
    
    void rsnMeshGetIndices(int con, int id, int[] idxIds, int[] primitives, int vtxIdCount){
    	//Formerly a native method
    	addTaint(con);
    	addTaint(id);
    	addTaint(idxIds[0]);
    	addTaint(primitives[0]);
    	addTaint(vtxIdCount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.522 -0500", hash_original_method = "59359FE3E4E256078C31F9090CB119B7", hash_generated_method = "F06FC9387B6DF4A10B5BE78720A169F4")
    
synchronized void nMeshGetIndices(int id, int[] idxIds, int[] primitives, int vtxIdCount) {
        validate();
        rsnMeshGetIndices(mContext, id, idxIds, primitives, vtxIdCount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.687 -0500", hash_original_method = "CF72E2BDE12484DABE239AEA560D3CB7", hash_generated_method = "B058D13F9799F5A70AFDAAA27ACA5C8D")
    
public void setMessageHandler(RSMessageHandler msg) {
        mMessageCallback = msg;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.689 -0500", hash_original_method = "82D97F3970F404AFF823D5438797134A", hash_generated_method = "2635149939FC4B73826BA5E791EAD40E")
    
public RSMessageHandler getMessageHandler() {
        return mMessageCallback;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.703 -0500", hash_original_method = "4877C344E3780CDA73E2F7D1DEF2ACC3", hash_generated_method = "2E1CA44DD3648E9DC698F78CBA0618EE")
    
public void setErrorHandler(RSErrorHandler msg) {
        mErrorCallback = msg;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.705 -0500", hash_original_method = "ADE7ED7BE0087974A98B5046E26EDD87", hash_generated_method = "84BED8D028EB16FF32D71D8D7875C2B5")
    
public RSErrorHandler getErrorHandler() {
        return mErrorCallback;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.714 -0500", hash_original_method = "B11FCBCEEF16462E5ED7B31A808EFF86", hash_generated_method = "B11FCBCEEF16462E5ED7B31A808EFF86")
    
void validate() {
        if (mContext == 0) {
            throw new RSInvalidStateException("Calling RS with no Context active.");
        }
    }

    /**
     * Change the priority of the worker threads for this context.
     *
     * @param p New priority to be set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.716 -0500", hash_original_method = "825B7EB852BA71F680F1CE64DECBD5CC", hash_generated_method = "E5AD748DAB7C63B07CDE72514ED7457B")
    
public void setPriority(Priority p) {
        validate();
        nContextSetPriority(p.mID);
    }

    /**
     * Gets the application context associated with the RenderScript context.
     *
     * @return The application context.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.750 -0500", hash_original_method = "212FB98379B009D6F1B7FAC8BEC777BD", hash_generated_method = "0A29D3217A584B8E36429BDFA749F13D")
    
public final Context getApplicationContext() {
        return mApplicationContext;
    }

    /**
     * Print the currently available debugging information about the state of
     * the RS context to the log.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.756 -0500", hash_original_method = "68D301E431D7353AD53EDFB6C8ED3163", hash_generated_method = "AF72884F65C02B3183785566EAE60CF1")
    
public void contextDump() {
        validate();
        nContextDump(0);
    }
    
    public static class RSMessageHandler implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.676 -0500", hash_original_field = "8C2374D33A80477A0B3E51CE7EB85544", hash_generated_field = "E9ECB1965245BA1A0ABDDD292D63F295")

        protected int[] mData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.678 -0500", hash_original_field = "0B53E374282B34FB268F3024A1E73BA5", hash_generated_field = "2A50865478D1F98704AC34AC9B0FBF18")

        protected int mID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.680 -0500", hash_original_field = "FC3D477E7B6A4ACE9A379E6E41129BD1", hash_generated_field = "F57106D036A8856F66EB17F31ABCDC86")

        protected int mLength;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.189 -0400", hash_original_method = "CBD1456EA4F7D781CE5FB9E407013326", hash_generated_method = "CBD1456EA4F7D781CE5FB9E407013326")
        public RSMessageHandler ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.682 -0500", hash_original_method = "941C644B96F3E7EE75FAD0CC47E0EEC2", hash_generated_method = "90F21E94AFD861A0B7D82CACD0D3E70A")
        
public void run() {
        }
        
    }
    
    public static class RSErrorHandler implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.692 -0500", hash_original_field = "2134AAACFB6EDFBE79ABBE45636CB43E", hash_generated_field = "352199EA493EBD40F2F3992629E09A61")

        protected String mErrorMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.695 -0500", hash_original_field = "938291564435588ABCAB3266EDA500D9", hash_generated_field = "DFB4D229ED26A95BEE84A83A68B00F06")

        protected int mErrorNum;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:57.195 -0400", hash_original_method = "7C983344237EA19B56C37B25669FCB61", hash_generated_method = "7C983344237EA19B56C37B25669FCB61")
        public RSErrorHandler ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.697 -0500", hash_original_method = "941C644B96F3E7EE75FAD0CC47E0EEC2", hash_generated_method = "90F21E94AFD861A0B7D82CACD0D3E70A")
        
public void run() {
        }
        
    }
    
    public enum Priority {
        LOW (Process.THREAD_PRIORITY_BACKGROUND + (5 * Process.THREAD_PRIORITY_LESS_FAVORABLE)),
        NORMAL (Process.THREAD_PRIORITY_DISPLAY);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.707 -0500", hash_original_field = "0B53E374282B34FB268F3024A1E73BA5", hash_generated_field = "0B53E374282B34FB268F3024A1E73BA5")

        int mID;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.710 -0500", hash_original_method = "B283EA7C2224661A52011ECB2DAEDC6F", hash_generated_method = "B283EA7C2224661A52011ECB2DAEDC6F")
            
Priority(int id) {
            mID = id;
        }
    }
    
    static class MessageThread extends Thread {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.725 -0500", hash_original_field = "4AF33BC5E4FFE08204A33E6CE99577F4", hash_generated_field = "1ACD99CA7A0BCEB9AFEC2A87202D8B1A")

        static final int RS_MESSAGE_TO_CLIENT_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.728 -0500", hash_original_field = "9B60CB222C52BB773526F4B350AFC9EF", hash_generated_field = "37474FF1E9C5BA58EC19743C84A4A20C")

        static final int RS_MESSAGE_TO_CLIENT_EXCEPTION = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.730 -0500", hash_original_field = "2BFFDB515ED2E6E6EA79D84B96BA3083", hash_generated_field = "E1EE3354D855C38F579964D77AC2F7A0")

        static final int RS_MESSAGE_TO_CLIENT_RESIZE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.732 -0500", hash_original_field = "AC992C894ACC487BEE1FD1B51C746CDF", hash_generated_field = "8480D0BAFE797D1AF646D0B8B5EC714A")

        static final int RS_MESSAGE_TO_CLIENT_ERROR = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.734 -0500", hash_original_field = "985058E03D5F2380DD22713B09A51E8C", hash_generated_field = "1183FD09410C6C756B441249707ED179")

        static final int RS_MESSAGE_TO_CLIENT_USER = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.737 -0500", hash_original_field = "424C65E096E3CCE0015AAEA0D9932DCD", hash_generated_field = "32A9791D3BD5FFB06DEFC9345E1D363B")

        static final int RS_ERROR_FATAL_UNKNOWN = 0x1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.719 -0500", hash_original_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.721 -0500", hash_original_field = "258C4B9A031693F0B54C9E6477557D77", hash_generated_field = "258C4B9A031693F0B54C9E6477557D77")

        boolean mRun = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.723 -0500", hash_original_field = "2E1F0CCD8790D6452AC412CF141A403D", hash_generated_field = "2E1F0CCD8790D6452AC412CF141A403D")

        int[] mAuxData = new int[2];

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.740 -0500", hash_original_method = "79018AA2643FA8D0F3347744AA1B7202", hash_generated_method = "79018AA2643FA8D0F3347744AA1B7202")
        
MessageThread(RenderScript rs) {
            super("RSMessageThread");
            mRS = rs;

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.743 -0500", hash_original_method = "44BE69ACBAD20FBF8ED2712E597F95F7", hash_generated_method = "D1030E413833AC6EA089B2FA95F6EEC0")
        
public void run() {
            // This function is a temporary solution.  The final solution will
            // used typed allocations where the message id is the type indicator.
            int[] rbuf = new int[16];
            mRS.nContextInitToClient(mRS.mContext);
            while(mRun) {
                rbuf[0] = 0;
                int msg = mRS.nContextPeekMessage(mRS.mContext, mAuxData);
                int size = mAuxData[1];
                int subID = mAuxData[0];

                if (msg == RS_MESSAGE_TO_CLIENT_USER) {
                    if ((size>>2) >= rbuf.length) {
                        rbuf = new int[(size + 3) >> 2];
                    }
                    if (mRS.nContextGetUserMessage(mRS.mContext, rbuf) !=
                        RS_MESSAGE_TO_CLIENT_USER) {
                        throw new RSDriverException("Error processing message from Renderscript.");
                    }

                    if(mRS.mMessageCallback != null) {
                        mRS.mMessageCallback.mData = rbuf;
                        mRS.mMessageCallback.mID = subID;
                        mRS.mMessageCallback.mLength = size;
                        mRS.mMessageCallback.run();
                    } else {
                        throw new RSInvalidStateException("Received a message from the script with no message handler installed.");
                    }
                    continue;
                }

                if (msg == RS_MESSAGE_TO_CLIENT_ERROR) {
                    String e = mRS.nContextGetErrorMessage(mRS.mContext);

                    if (subID >= RS_ERROR_FATAL_UNKNOWN) {
                        throw new RSRuntimeException("Fatal error " + subID + ", details: " + e);
                    }

                    if(mRS.mErrorCallback != null) {
                        mRS.mErrorCallback.mErrorMessage = e;
                        mRS.mErrorCallback.mErrorNum = subID;
                        mRS.mErrorCallback.run();
                    } else {
                        //throw new RSRuntimeException("Received error num " + subID + ", details: " + e);
                    }
                    continue;
                }

                // 2: teardown.
                // But we want to avoid starving other threads during
                // teardown by yielding until the next line in the destructor
                // can execute to set mRun = false
                try {
                    sleep(1, 0);
                } catch(InterruptedException e) {
                }
            }
            Log.d(LOG_TAG, "MessageThread exiting.");
        }
    }

    /**
     * Wait for any commands in the fifo between the java bindings and native to
     * be processed.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.759 -0500", hash_original_method = "709C1002A236E5295587B41728563E8C", hash_generated_method = "F4CFC8C1619D6C16694F6E6BC8D04107")
    
public void finish() {
        nContextFinish();
    }

    /**
     * Destroy this renderscript context.  Once this function is called its no
     * longer legal to use this or any objects created by this context.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.761 -0500", hash_original_method = "BEA9760994E1CBB8BA9A3650C9143B69", hash_generated_method = "35959061F4918BB8BDB2025FA21CEE0F")
    
public void destroy() {
        validate();
        nContextDeinitToClient(mContext);
        mMessageThread.mRun = false;
        try {
            mMessageThread.join();
        } catch(InterruptedException e) {
        }

        nContextDestroy();
        mContext = 0;

        nDeviceDestroy(mDev);
        mDev = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.763 -0500", hash_original_method = "A43F31159E3962997DEA8993C2ED3F03", hash_generated_method = "A43F31159E3962997DEA8993C2ED3F03")
    
boolean isAlive() {
        return mContext != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:05.765 -0500", hash_original_method = "19F54E8AE078DC0EBF3195D44C78E70B", hash_generated_method = "19F54E8AE078DC0EBF3195D44C78E70B")
    
int safeID(BaseObj o) {
        if(o != null) {
            return o.getID();
        }
        return 0;
    }
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

