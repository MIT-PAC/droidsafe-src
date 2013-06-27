package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.PrintWriter;

public class Matrix {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.178 -0400", hash_original_field = "7E2E7BFEC42581BDE25254C4BB512478", hash_generated_field = "368FA2DC569BFE75826F8A8AC6BD5246")

    public int native_instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.180 -0400", hash_original_method = "48ECB7BFD8634672F9ACB2AF6643F504", hash_generated_method = "B74B17C57C92799FAD74B4A80984C415")
    public  Matrix() {
        native_instance = native_create(0);
        // ---------- Original Method ----------
        //native_instance = native_create(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.191 -0400", hash_original_method = "D46661DF78A0C4D4A11243C86DA400FE", hash_generated_method = "138AD9A2B29FF4BCFFBD9A8B05F17035")
    public  Matrix(Matrix src) {
        native_instance = native_create(src != null ? src.native_instance : 0);
        // ---------- Original Method ----------
        //native_instance = native_create(src != null ? src.native_instance : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.197 -0400", hash_original_method = "2841C18D225FF732B7B2ED26420E0D84", hash_generated_method = "3AA34DDCC49F42CB078E75A538C7842F")
    public boolean isIdentity() {
        boolean var41D9600FE0AA6A328771E92D92F0949C_591969605 = (native_isIdentity(native_instance));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_362720831 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_362720831;
        // ---------- Original Method ----------
        //return native_isIdentity(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.198 -0400", hash_original_method = "79ACBDB454C166CD18416C9311332315", hash_generated_method = "08A650B05FD11AD93727F4FAD60100FB")
    public boolean rectStaysRect() {
        boolean var69C0BE3F50B3E19BAD90EEC6AC1AECE6_272741229 = (native_rectStaysRect(native_instance));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984976260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984976260;
        // ---------- Original Method ----------
        //return native_rectStaysRect(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.198 -0400", hash_original_method = "FFD47BD973F843026149EBC467C90A81", hash_generated_method = "0C60808E8133F63B47E800A29C66C78C")
    public void set(Matrix src) {
        {
            reset();
        } //End block
        {
            native_set(native_instance, src.native_instance);
        } //End block
        addTaint(src.getTaint());
        // ---------- Original Method ----------
        //if (src == null) {
            //reset();
        //} else {
            //native_set(native_instance, src.native_instance);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.199 -0400", hash_original_method = "EBE703D7B768F6481174C59F67FA3100", hash_generated_method = "4698FA266EA94137B4733DE674A7ED2F")
    public boolean equals(Object obj) {
        boolean varEF70408AB8E744DC202FEA719772EF59_1267155581 = (obj != null &&
               obj instanceof Matrix &&
               native_equals(native_instance, ((Matrix)obj).native_instance));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2136542541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2136542541;
        // ---------- Original Method ----------
        //return obj != null &&
               //obj instanceof Matrix &&
               //native_equals(native_instance, ((Matrix)obj).native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.199 -0400", hash_original_method = "9189F6751C365D24C86F2BCF8029966A", hash_generated_method = "13B89CEA14A3F1070B2312BA6829A32E")
    public void reset() {
        native_reset(native_instance);
        // ---------- Original Method ----------
        //native_reset(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.200 -0400", hash_original_method = "4ABE67590F26D49A748F83E05B922D6E", hash_generated_method = "E7D3CC1EDEF6EC0FF0ECCD849C0862EF")
    public void setTranslate(float dx, float dy) {
        native_setTranslate(native_instance, dx, dy);
        addTaint(dx);
        addTaint(dy);
        // ---------- Original Method ----------
        //native_setTranslate(native_instance, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.218 -0400", hash_original_method = "82025887E943FB82D92D7647B1CDD6A4", hash_generated_method = "D9353DD645B282EB963632AE04D6E90B")
    public void setScale(float sx, float sy, float px, float py) {
        native_setScale(native_instance, sx, sy, px, py);
        addTaint(sx);
        addTaint(sy);
        addTaint(px);
        addTaint(py);
        // ---------- Original Method ----------
        //native_setScale(native_instance, sx, sy, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.219 -0400", hash_original_method = "405981B5032E505B7ADC1B41B7C8A53D", hash_generated_method = "9745C77E1DA4FE0CBA94470E997348DE")
    public void setScale(float sx, float sy) {
        native_setScale(native_instance, sx, sy);
        addTaint(sx);
        addTaint(sy);
        // ---------- Original Method ----------
        //native_setScale(native_instance, sx, sy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.220 -0400", hash_original_method = "D24D75386C6A7BC2522B54B98C5D5387", hash_generated_method = "2246380E93157668B7BE2EE15E7F877B")
    public void setRotate(float degrees, float px, float py) {
        native_setRotate(native_instance, degrees, px, py);
        addTaint(degrees);
        addTaint(px);
        addTaint(py);
        // ---------- Original Method ----------
        //native_setRotate(native_instance, degrees, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.220 -0400", hash_original_method = "43C7C737EFC6B994F84E937D3F6AAF6A", hash_generated_method = "3E720003EF26262A95ECFB36DD57E4F7")
    public void setRotate(float degrees) {
        native_setRotate(native_instance, degrees);
        addTaint(degrees);
        // ---------- Original Method ----------
        //native_setRotate(native_instance, degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.242 -0400", hash_original_method = "D62ED30BDB09648860C12F4C33D5D2F5", hash_generated_method = "7E1AAE72449FFBB154A5ED055871ABB6")
    public void setSinCos(float sinValue, float cosValue, float px, float py) {
        native_setSinCos(native_instance, sinValue, cosValue, px, py);
        addTaint(sinValue);
        addTaint(cosValue);
        addTaint(px);
        addTaint(py);
        // ---------- Original Method ----------
        //native_setSinCos(native_instance, sinValue, cosValue, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.244 -0400", hash_original_method = "BF18F19C125E14226E94998F97574605", hash_generated_method = "F3FD43AA1B700B32CFACD6301731C138")
    public void setSinCos(float sinValue, float cosValue) {
        native_setSinCos(native_instance, sinValue, cosValue);
        addTaint(sinValue);
        addTaint(cosValue);
        // ---------- Original Method ----------
        //native_setSinCos(native_instance, sinValue, cosValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.244 -0400", hash_original_method = "D80C969913C1752CC5799F53218DDBF4", hash_generated_method = "DA3CA87C9412A53D8C62ECD04F935D10")
    public void setSkew(float kx, float ky, float px, float py) {
        native_setSkew(native_instance, kx, ky, px, py);
        addTaint(kx);
        addTaint(ky);
        addTaint(px);
        addTaint(py);
        // ---------- Original Method ----------
        //native_setSkew(native_instance, kx, ky, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.245 -0400", hash_original_method = "C307AACAFF9D5B23D5D1BDAB3825341D", hash_generated_method = "88CD9C14BA3BA6E845F55C1FC7F49146")
    public void setSkew(float kx, float ky) {
        native_setSkew(native_instance, kx, ky);
        addTaint(kx);
        addTaint(ky);
        // ---------- Original Method ----------
        //native_setSkew(native_instance, kx, ky);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.245 -0400", hash_original_method = "56B420A7A69DF5D45E01C2D78C2CB3D0", hash_generated_method = "4CBF621062E1791E052590F44C46DD6B")
    public boolean setConcat(Matrix a, Matrix b) {
        boolean var00AB055AF6CDC86BED53096651485E3F_2110920825 = (native_setConcat(native_instance, a.native_instance,
                                b.native_instance));
        addTaint(a.getTaint());
        addTaint(b.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1401758588 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1401758588;
        // ---------- Original Method ----------
        //return native_setConcat(native_instance, a.native_instance,
                                //b.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.246 -0400", hash_original_method = "F46062CE4D887C63D2B52C9E41EB2542", hash_generated_method = "D054A058A55A09882F2377D67E3D4E41")
    public boolean preTranslate(float dx, float dy) {
        boolean varFBA5412443E9C5939494329C2C3880AE_1375376021 = (native_preTranslate(native_instance, dx, dy));
        addTaint(dx);
        addTaint(dy);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_980255444 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_980255444;
        // ---------- Original Method ----------
        //return native_preTranslate(native_instance, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.261 -0400", hash_original_method = "F666E80378D32154F2306C1184D58E89", hash_generated_method = "E23B965382A512F634CC85634A3FAE22")
    public boolean preScale(float sx, float sy, float px, float py) {
        boolean var0587D6DD30F56D53FD1ECF7FD9BDB408_396608867 = (native_preScale(native_instance, sx, sy, px, py));
        addTaint(sx);
        addTaint(sy);
        addTaint(px);
        addTaint(py);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1218701435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1218701435;
        // ---------- Original Method ----------
        //return native_preScale(native_instance, sx, sy, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.262 -0400", hash_original_method = "527D02A9319A5AC738DC088F9CE2DF28", hash_generated_method = "830D5C54C3E236D61250020DC59668A5")
    public boolean preScale(float sx, float sy) {
        boolean varF995F72A92DA54AF3047937ACF3B2DE0_1717928892 = (native_preScale(native_instance, sx, sy));
        addTaint(sx);
        addTaint(sy);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1175080726 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1175080726;
        // ---------- Original Method ----------
        //return native_preScale(native_instance, sx, sy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.263 -0400", hash_original_method = "957DD3FA3C951D0A3D8ED4D51FD4EA92", hash_generated_method = "D65E0AAD68232CB64AA6559C0875257D")
    public boolean preRotate(float degrees, float px, float py) {
        boolean var43D78BDDC1A8498586B3652DCB202B3B_402756148 = (native_preRotate(native_instance, degrees, px, py));
        addTaint(degrees);
        addTaint(px);
        addTaint(py);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_554016458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_554016458;
        // ---------- Original Method ----------
        //return native_preRotate(native_instance, degrees, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.273 -0400", hash_original_method = "07B5A36535E24ED5890CD9963836825B", hash_generated_method = "E52210656EC89AC0BDB6D702C71C2854")
    public boolean preRotate(float degrees) {
        boolean varA671CF6014E0E838A67A0F6BFE5843CA_357299585 = (native_preRotate(native_instance, degrees));
        addTaint(degrees);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1137073309 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1137073309;
        // ---------- Original Method ----------
        //return native_preRotate(native_instance, degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.274 -0400", hash_original_method = "BCDAF6F2AF0C49197BF18278F335520E", hash_generated_method = "08D450124E75FDEE84EAD5E83628398B")
    public boolean preSkew(float kx, float ky, float px, float py) {
        boolean var9FA7183618403646DB30A7FED3243975_1530991811 = (native_preSkew(native_instance, kx, ky, px, py));
        addTaint(kx);
        addTaint(ky);
        addTaint(px);
        addTaint(py);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_674326974 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_674326974;
        // ---------- Original Method ----------
        //return native_preSkew(native_instance, kx, ky, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.274 -0400", hash_original_method = "421231502648E6DE11C6B4476FBB4CB5", hash_generated_method = "498D0F67BA3A491DF1324932CD006A8E")
    public boolean preSkew(float kx, float ky) {
        boolean var66725046478C0AC12E1AB350EA8BA008_45506154 = (native_preSkew(native_instance, kx, ky));
        addTaint(kx);
        addTaint(ky);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_159592008 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_159592008;
        // ---------- Original Method ----------
        //return native_preSkew(native_instance, kx, ky);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.275 -0400", hash_original_method = "5465FF6869EFECF5658D42C575F011EC", hash_generated_method = "FE08A3473D6514B05CF6F3ED913A29E3")
    public boolean preConcat(Matrix other) {
        boolean var9C6E024213CA5C2C78B882753FA15FB7_645137888 = (native_preConcat(native_instance, other.native_instance));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_726341366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_726341366;
        // ---------- Original Method ----------
        //return native_preConcat(native_instance, other.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.276 -0400", hash_original_method = "C79C9E0E75F4298B5359E17C43CD6BA7", hash_generated_method = "6120D838D6BF65C03035EDF72EA5997E")
    public boolean postTranslate(float dx, float dy) {
        boolean var3EB89776C0E9BC26B5B7A93497AA6338_1528722587 = (native_postTranslate(native_instance, dx, dy));
        addTaint(dx);
        addTaint(dy);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591876444 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591876444;
        // ---------- Original Method ----------
        //return native_postTranslate(native_instance, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.279 -0400", hash_original_method = "158FF341C93FCD549341DC9F548B9A8C", hash_generated_method = "AE563E8C8795C6B9210A9CC519F3D938")
    public boolean postScale(float sx, float sy, float px, float py) {
        boolean var811534EBBA0716ED15AB0EA06550D8C7_1360945539 = (native_postScale(native_instance, sx, sy, px, py));
        addTaint(sx);
        addTaint(sy);
        addTaint(px);
        addTaint(py);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1110568223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1110568223;
        // ---------- Original Method ----------
        //return native_postScale(native_instance, sx, sy, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.283 -0400", hash_original_method = "2747525819A92C185D4EAB6F550FCCE3", hash_generated_method = "1190D258A388D86632EDD435BB5C380E")
    public boolean postScale(float sx, float sy) {
        boolean varFEBE8AC1DB6F60F9C4B86E273DF2FC19_1638994229 = (native_postScale(native_instance, sx, sy));
        addTaint(sx);
        addTaint(sy);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1341484034 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1341484034;
        // ---------- Original Method ----------
        //return native_postScale(native_instance, sx, sy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.295 -0400", hash_original_method = "C0257612FFE5AA7DE5163F0B0AB9F855", hash_generated_method = "7D995574BEC5F4A7585750AB03A215C4")
    public boolean postRotate(float degrees, float px, float py) {
        boolean varD7589C641F418AFED36121BAC654FC16_848887056 = (native_postRotate(native_instance, degrees, px, py));
        addTaint(degrees);
        addTaint(px);
        addTaint(py);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1421998265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1421998265;
        // ---------- Original Method ----------
        //return native_postRotate(native_instance, degrees, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.297 -0400", hash_original_method = "DB293F0AFDDF18839C895B754EC55E8F", hash_generated_method = "05BA3921BE759A0950CAC4E0157B3704")
    public boolean postRotate(float degrees) {
        boolean varF737BE5E5361946D147FCBB83A14D353_1498747768 = (native_postRotate(native_instance, degrees));
        addTaint(degrees);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1858509456 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1858509456;
        // ---------- Original Method ----------
        //return native_postRotate(native_instance, degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.298 -0400", hash_original_method = "57CA592FACEF6BD09A9AB3838326FC82", hash_generated_method = "5EAB318E770A67E52DB3836BD053AD3B")
    public boolean postSkew(float kx, float ky, float px, float py) {
        boolean var9BA35FCF22EA355270F926957521F093_1340542270 = (native_postSkew(native_instance, kx, ky, px, py));
        addTaint(kx);
        addTaint(ky);
        addTaint(px);
        addTaint(py);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1685051087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1685051087;
        // ---------- Original Method ----------
        //return native_postSkew(native_instance, kx, ky, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.299 -0400", hash_original_method = "0C899E968246F5B1F6489525332C2DAA", hash_generated_method = "5A39B78D70C059E5D8F89C3A0D92A4B7")
    public boolean postSkew(float kx, float ky) {
        boolean varC50A6D02F903D8010B24126CAB1D485B_1333489848 = (native_postSkew(native_instance, kx, ky));
        addTaint(kx);
        addTaint(ky);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_14560967 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_14560967;
        // ---------- Original Method ----------
        //return native_postSkew(native_instance, kx, ky);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.300 -0400", hash_original_method = "C3D775738E645A4A21D169FF31B7CB59", hash_generated_method = "088C32F00B166CC35F1CC6912143BC7F")
    public boolean postConcat(Matrix other) {
        boolean var883846EFB3F1C6159603731AEA1A59F1_774905290 = (native_postConcat(native_instance, other.native_instance));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1037340123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1037340123;
        // ---------- Original Method ----------
        //return native_postConcat(native_instance, other.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.301 -0400", hash_original_method = "AEF4FE63E4C98EDC4913C94ED23B0046", hash_generated_method = "93D9721A54966B96D5A3746EFE5897E7")
    public boolean setRectToRect(RectF src, RectF dst, ScaleToFit stf) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        boolean varF7E361575251D13BE7FA91222DB37707_2044915505 = (native_setRectToRect(native_instance, src, dst, stf.nativeInt));
        addTaint(src.getTaint());
        addTaint(dst.getTaint());
        addTaint(stf.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_32805074 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_32805074;
        // ---------- Original Method ----------
        //if (dst == null || src == null) {
            //throw new NullPointerException();
        //}
        //return native_setRectToRect(native_instance, src, dst, stf.nativeInt);
    }

    
        private static void checkPointArrays(float[] src, int srcIndex,
                                         float[] dst, int dstIndex,
                                         int pointCount) {
        int srcStop = srcIndex + (pointCount << 1);
        int dstStop = dstIndex + (pointCount << 1);
        if ((pointCount | srcIndex | dstIndex | srcStop | dstStop) < 0 ||
                srcStop > src.length || dstStop > dst.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.315 -0400", hash_original_method = "81F71DB7C56D04B1A3A5BEE1ABC9313F", hash_generated_method = "B42A083EADAC50282909234F6F111816")
    public boolean setPolyToPoly(float[] src, int srcIndex,
                                 float[] dst, int dstIndex,
                                 int pointCount) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        boolean var1B38DC69F9C1AE3BEDB6B044F3F544DB_837538381 = (native_setPolyToPoly(native_instance, src, srcIndex,
                                    dst, dstIndex, pointCount));
        addTaint(src[0]);
        addTaint(srcIndex);
        addTaint(dst[0]);
        addTaint(dstIndex);
        addTaint(pointCount);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_174610483 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_174610483;
        // ---------- Original Method ----------
        //if (pointCount > 4) {
            //throw new IllegalArgumentException();
        //}
        //checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        //return native_setPolyToPoly(native_instance, src, srcIndex,
                                    //dst, dstIndex, pointCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.316 -0400", hash_original_method = "E353C96DCEC77FF20275C37C83D4D335", hash_generated_method = "D0EFF747BB6BC1F0A5DABFE7ACDC4995")
    public boolean invert(Matrix inverse) {
        boolean var264FAB0D1776C7EB10CAD495521DE5AA_687106467 = (native_invert(native_instance, inverse.native_instance));
        addTaint(inverse.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1464569855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1464569855;
        // ---------- Original Method ----------
        //return native_invert(native_instance, inverse.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.332 -0400", hash_original_method = "B69F96FB84D81823B3FB4BA4E2DA7623", hash_generated_method = "E39EB4C545A9B01D8045CE3CB5905680")
    public void mapPoints(float[] dst, int dstIndex, float[] src, int srcIndex,
                          int pointCount) {
        checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         pointCount, true);
        addTaint(dst[0]);
        addTaint(dstIndex);
        addTaint(src[0]);
        addTaint(srcIndex);
        addTaint(pointCount);
        // ---------- Original Method ----------
        //checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        //native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         //pointCount, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.333 -0400", hash_original_method = "E01BB240D3A8AF79E8CA96ADF8A93B02", hash_generated_method = "419771F80DC79539FDC981762451F1C9")
    public void mapVectors(float[] dst, int dstIndex, float[] src, int srcIndex,
                          int vectorCount) {
        checkPointArrays(src, srcIndex, dst, dstIndex, vectorCount);
        native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         vectorCount, false);
        addTaint(dst[0]);
        addTaint(dstIndex);
        addTaint(src[0]);
        addTaint(srcIndex);
        addTaint(vectorCount);
        // ---------- Original Method ----------
        //checkPointArrays(src, srcIndex, dst, dstIndex, vectorCount);
        //native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         //vectorCount, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.334 -0400", hash_original_method = "9EB430E2EA11CE20A0728D1BC77C5684", hash_generated_method = "45C42F6040FF8805A3F8887E4A996A83")
    public void mapPoints(float[] dst, float[] src) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        mapPoints(dst, 0, src, 0, dst.length >> 1);
        addTaint(dst[0]);
        addTaint(src[0]);
        // ---------- Original Method ----------
        //if (dst.length != src.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //mapPoints(dst, 0, src, 0, dst.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.335 -0400", hash_original_method = "88563DD2DA99100452A3E727EF621773", hash_generated_method = "D1B6CBC15E7B27ACB91E7098A9205AE7")
    public void mapVectors(float[] dst, float[] src) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        mapVectors(dst, 0, src, 0, dst.length >> 1);
        addTaint(dst[0]);
        addTaint(src[0]);
        // ---------- Original Method ----------
        //if (dst.length != src.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //mapVectors(dst, 0, src, 0, dst.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.336 -0400", hash_original_method = "B621EF9C19B6D800D2C8FEF0AEB101A2", hash_generated_method = "579F155B1F7351AF0430B9F4BE7A277A")
    public void mapPoints(float[] pts) {
        mapPoints(pts, 0, pts, 0, pts.length >> 1);
        addTaint(pts[0]);
        // ---------- Original Method ----------
        //mapPoints(pts, 0, pts, 0, pts.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.353 -0400", hash_original_method = "35DF34CB8A8DD69940AA879A74BDB59C", hash_generated_method = "E11FE779FC5D6865FC7FB33AE46E265C")
    public void mapVectors(float[] vecs) {
        mapVectors(vecs, 0, vecs, 0, vecs.length >> 1);
        addTaint(vecs[0]);
        // ---------- Original Method ----------
        //mapVectors(vecs, 0, vecs, 0, vecs.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.355 -0400", hash_original_method = "ED0A1CF18B9884BD196B57BA9AB3D4D4", hash_generated_method = "3F55B69BDF096EA06BC4943118CA9C67")
    public boolean mapRect(RectF dst, RectF src) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        boolean var0555BDA0682728737A8E84AE5B37B33A_2116159487 = (native_mapRect(native_instance, dst, src));
        addTaint(dst.getTaint());
        addTaint(src.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_648319160 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_648319160;
        // ---------- Original Method ----------
        //if (dst == null || src == null) {
            //throw new NullPointerException();
        //}
        //return native_mapRect(native_instance, dst, src);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.355 -0400", hash_original_method = "E67F1023A30815D48967A785552726F7", hash_generated_method = "E0C07D8B0C7EDEC663719DF9F1CB56B3")
    public boolean mapRect(RectF rect) {
        boolean var4F206D16D71EEBE65AA2A3210698955A_34596549 = (mapRect(rect, rect));
        addTaint(rect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1140631634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1140631634;
        // ---------- Original Method ----------
        //return mapRect(rect, rect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.362 -0400", hash_original_method = "10B4872CA843B84CAABA7086757B6AA8", hash_generated_method = "13DDCF4E13F45C5A5E1019186527AD87")
    public float mapRadius(float radius) {
        float varF364E7BDEF648809DE6AA5B35C7E7D24_73955587 = (native_mapRadius(native_instance, radius));
        addTaint(radius);
        float var546ADE640B6EDFBC8A086EF31347E768_1838626201 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1838626201;
        // ---------- Original Method ----------
        //return native_mapRadius(native_instance, radius);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.368 -0400", hash_original_method = "E9A30A056D591CF546BBF753077E713D", hash_generated_method = "08B1094BD49E3370D6CC0736E16585A3")
    public void getValues(float[] values) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        native_getValues(native_instance, values);
        addTaint(values[0]);
        // ---------- Original Method ----------
        //if (values.length < 9) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_getValues(native_instance, values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.369 -0400", hash_original_method = "A66AD9F1BFFA0584B04714786DBE2DC1", hash_generated_method = "631E72474FBA00DE62B4B3277497BF00")
    public void setValues(float[] values) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        native_setValues(native_instance, values);
        addTaint(values[0]);
        // ---------- Original Method ----------
        //if (values.length < 9) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_setValues(native_instance, values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.501 -0400", hash_original_method = "790F3515038F276DF7A46D3A4B29621A", hash_generated_method = "209CCDA07EE7AE150A1C54B9DA249BE4")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2128651953 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(64);
        sb.append("Matrix{");
        toShortString(sb);
        sb.append('}');
        varB4EAC82CA7396A68D541C85D26508E83_2128651953 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2128651953.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2128651953;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //sb.append("Matrix{");
        //toShortString(sb);
        //sb.append('}');
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.515 -0400", hash_original_method = "9DDD7B6FB851EDEB6218261EF1A63117", hash_generated_method = "4A03F486254203AD108CE21EE9C743A2")
    public String toShortString() {
        String varB4EAC82CA7396A68D541C85D26508E83_407475089 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(64);
        toShortString(sb);
        varB4EAC82CA7396A68D541C85D26508E83_407475089 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_407475089.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_407475089;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //toShortString(sb);
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.538 -0400", hash_original_method = "F87637A67413F385021CCAE210B2BF25", hash_generated_method = "61445B4EABF61F1E733FB91E43FDD899")
    public void toShortString(StringBuilder sb) {
        float[] values;
        values = new float[9];
        getValues(values);
        sb.append('[');
        sb.append(values[0]);
        sb.append(", ");
        sb.append(values[1]);
        sb.append(", ");
        sb.append(values[2]);
        sb.append("][");
        sb.append(values[3]);
        sb.append(", ");
        sb.append(values[4]);
        sb.append(", ");
        sb.append(values[5]);
        sb.append("][");
        sb.append(values[6]);
        sb.append(", ");
        sb.append(values[7]);
        sb.append(", ");
        sb.append(values[8]);
        sb.append(']');
        addTaint(sb.getTaint());
        // ---------- Original Method ----------
        //float[] values = new float[9];
        //getValues(values);
        //sb.append('[');
        //sb.append(values[0]);
        //sb.append(", ");
        //sb.append(values[1]);
        //sb.append(", ");
        //sb.append(values[2]);
        //sb.append("][");
        //sb.append(values[3]);
        //sb.append(", ");
        //sb.append(values[4]);
        //sb.append(", ");
        //sb.append(values[5]);
        //sb.append("][");
        //sb.append(values[6]);
        //sb.append(", ");
        //sb.append(values[7]);
        //sb.append(", ");
        //sb.append(values[8]);
        //sb.append(']');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.552 -0400", hash_original_method = "8B9E48E860ED3F94388D797BB2BE65D6", hash_generated_method = "EE727869DEBAF0FFD2E3BF6172A4B3A7")
    public void printShortString(PrintWriter pw) {
        float[] values;
        values = new float[9];
        getValues(values);
        pw.print('[');
        pw.print(values[0]);
        pw.print(", ");
        pw.print(values[1]);
        pw.print(", ");
        pw.print(values[2]);
        pw.print("][");
        pw.print(values[3]);
        pw.print(", ");
        pw.print(values[4]);
        pw.print(", ");
        pw.print(values[5]);
        pw.print("][");
        pw.print(values[6]);
        pw.print(", ");
        pw.print(values[7]);
        pw.print(", ");
        pw.print(values[8]);
        pw.print(']');
        addTaint(pw.getTaint());
        // ---------- Original Method ----------
        //float[] values = new float[9];
        //getValues(values);
        //pw.print('[');
        //pw.print(values[0]);
        //pw.print(", ");
        //pw.print(values[1]);
        //pw.print(", ");
        //pw.print(values[2]);
        //pw.print("][");
        //pw.print(values[3]);
        //pw.print(", ");
        //pw.print(values[4]);
        //pw.print(", ");
        //pw.print(values[5]);
        //pw.print("][");
        //pw.print(values[6]);
        //pw.print(", ");
        //pw.print(values[7]);
        //pw.print(", ");
        //pw.print(values[8]);
        //pw.print(']');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.561 -0400", hash_original_method = "29B0241D689448242FFD9C9D7DE21563", hash_generated_method = "15CC57087C95B7D9B74DEAC06F3C409E")
    protected void finalize() throws Throwable {
        finalizer(native_instance);
        // ---------- Original Method ----------
        //finalizer(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.568 -0400", hash_original_method = "2C87051DCC7759A2331039EEC0434516", hash_generated_method = "2CA56DB018F798FB93381C5D01095FD7")
    final int ni() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322404200 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322404200;
        // ---------- Original Method ----------
        //return native_instance;
    }

    
        private static int native_create(int native_src_or_zero) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static boolean native_isIdentity(int native_object) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_rectStaysRect(int native_object) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void native_reset(int native_object) {
    }

    
        private static void native_set(int native_object, int other) {
    }

    
        private static void native_setTranslate(int native_object,
                                                   float dx, float dy) {
    }

    
        private static void native_setScale(int native_object,
                                        float sx, float sy, float px, float py) {
    }

    
        private static void native_setScale(int native_object,
                                               float sx, float sy) {
    }

    
        private static void native_setRotate(int native_object,
                                            float degrees, float px, float py) {
    }

    
        private static void native_setRotate(int native_object,
                                                float degrees) {
    }

    
        private static void native_setSinCos(int native_object,
                            float sinValue, float cosValue, float px, float py) {
    }

    
        private static void native_setSinCos(int native_object,
                                                float sinValue, float cosValue) {
    }

    
        private static void native_setSkew(int native_object,
                                        float kx, float ky, float px, float py) {
    }

    
        private static void native_setSkew(int native_object,
                                              float kx, float ky) {
    }

    
        private static boolean native_setConcat(int native_object,
                                                   int a, int b) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_preTranslate(int native_object,
                                                      float dx, float dy) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_preScale(int native_object,
                                        float sx, float sy, float px, float py) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_preScale(int native_object,
                                                  float sx, float sy) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_preRotate(int native_object,
                                            float degrees, float px, float py) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_preRotate(int native_object,
                                                   float degrees) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_preSkew(int native_object,
                                        float kx, float ky, float px, float py) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_preSkew(int native_object,
                                                 float kx, float ky) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_preConcat(int native_object,
                                                   int other_matrix) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_postTranslate(int native_object,
                                                       float dx, float dy) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_postScale(int native_object,
                                        float sx, float sy, float px, float py) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_postScale(int native_object,
                                                   float sx, float sy) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_postRotate(int native_object,
                                            float degrees, float px, float py) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_postRotate(int native_object,
                                                    float degrees) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_postSkew(int native_object,
                                        float kx, float ky, float px, float py) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_postSkew(int native_object,
                                                  float kx, float ky) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_postConcat(int native_object,
                                                    int other_matrix) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_setRectToRect(int native_object,
                                                RectF src, RectF dst, int stf) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_setPolyToPoly(int native_object,
        float[] src, int srcIndex, float[] dst, int dstIndex, int pointCount) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_invert(int native_object, int inverse) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void native_mapPoints(int native_object,
                        float[] dst, int dstIndex, float[] src, int srcIndex,
                        int ptCount, boolean isPts) {
    }

    
        private static boolean native_mapRect(int native_object,
                                                 RectF dst, RectF src) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static float native_mapRadius(int native_object,
                                                 float radius) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
        private static void native_getValues(int native_object,
                                                float[] values) {
    }

    
        private static void native_setValues(int native_object,
                                                float[] values) {
    }

    
        private static boolean native_equals(int native_a, int native_b) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void finalizer(int native_instance) {
    }

    
    public enum ScaleToFit {
        FILL    (0),
        START   (1),
        CENTER  (2),
        END     (3);
        ScaleToFit(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        final int nativeInt;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.642 -0400", hash_original_field = "EC6958799BAE00A9193D727D7DC593A6", hash_generated_field = "EFA3DBAD301BED225815D2F749817006")

    public static final int MSCALE_X = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.643 -0400", hash_original_field = "5D32553FB2D960837C00EB34F73347C9", hash_generated_field = "67EAC113D4E4932D73D3A487643F0FD1")

    public static final int MSKEW_X  = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.643 -0400", hash_original_field = "826DCE5E2D680A3BE520E723DDCD9240", hash_generated_field = "07E5E1B67F0C9E5278715AAB25E91DAB")

    public static final int MTRANS_X = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.643 -0400", hash_original_field = "65A646BAFAEAFA33D503B9201F0AB6DD", hash_generated_field = "41EBD7259F41631F6876F58AE3C95D05")

    public static final int MSKEW_Y  = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.644 -0400", hash_original_field = "FF2A5146410D7DC50B02C00C0FEAD5A1", hash_generated_field = "27781A2223BB5718506AC48FB1837DB0")

    public static final int MSCALE_Y = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.644 -0400", hash_original_field = "6EC0976F499BC08E52F9997890E3B577", hash_generated_field = "43C2504D96C28B177ABC2A96E8E9F767")

    public static final int MTRANS_Y = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.644 -0400", hash_original_field = "550CA2E585318DCEA6E304890028A97E", hash_generated_field = "5A7F9B6FF116E340A9248A261942F12B")

    public static final int MPERSP_0 = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.644 -0400", hash_original_field = "62B3BC90B26797726BE0CE6088146C5C", hash_generated_field = "4F80C0BDF0D0A262209ADA0919682BD4")

    public static final int MPERSP_1 = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.644 -0400", hash_original_field = "17070704205CF9E0D12BD961DAD1C106", hash_generated_field = "1EF21E44267C42FB84A589D371DA23B3")

    public static final int MPERSP_2 = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.779 -0400", hash_original_field = "46A5CA0F2132054AB8D29490E16865FA", hash_generated_field = "22231464B36DC8AE27C4236CB05EA85A")

    public static Matrix IDENTITY_MATRIX = new Matrix() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.645 -0400", hash_original_method = "D86A271A87ADAB5FF76372ECECE2FE9E", hash_generated_method = "4201570C8F06C2B0ECEEAE002E7D4F0B")
         void oops() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Matrix can not be modified");
            // ---------- Original Method ----------
            //throw new IllegalStateException("Matrix can not be modified");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.667 -0400", hash_original_method = "C410E535C65C1A60A6BB6D0124640DFB", hash_generated_method = "637E14C2200FD802184A323B5FBE7575")
        @Override
        public void set(Matrix src) {
            oops();
            addTaint(src.getTaint());
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.668 -0400", hash_original_method = "443FC1BF2CCB476E40EFBA39CED3C856", hash_generated_method = "7E2B188BDA8EA2E28D08CCB551CDF97E")
        @Override
        public void reset() {
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.669 -0400", hash_original_method = "6A3715A1843CB69CD425569E9A9BF685", hash_generated_method = "A3498F8453C0826BB02C0ABB79720CF8")
        @Override
        public void setTranslate(float dx, float dy) {
            oops();
            addTaint(dx);
            addTaint(dy);
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.669 -0400", hash_original_method = "AC062ADEBF9F892A7634B382327DE471", hash_generated_method = "0815503BA6887AFB8D0B6C519D194E4C")
        @Override
        public void setScale(float sx, float sy, float px, float py) {
            oops();
            addTaint(sx);
            addTaint(sy);
            addTaint(px);
            addTaint(py);
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.680 -0400", hash_original_method = "AF405FD460DAE15CE8A800CAFF9D70A1", hash_generated_method = "4C9D62A4926698BF33092B372864B82E")
        @Override
        public void setScale(float sx, float sy) {
            oops();
            addTaint(sx);
            addTaint(sy);
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.682 -0400", hash_original_method = "3E711272F4AAA813A9DEF73D8BED4F52", hash_generated_method = "B803000E08E11D051FBABD81DE36BE99")
        @Override
        public void setRotate(float degrees, float px, float py) {
            oops();
            addTaint(degrees);
            addTaint(px);
            addTaint(py);
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.694 -0400", hash_original_method = "F01F93D85A48029B9DBAA6CF7686F3EA", hash_generated_method = "3CD8BE134FA39E80061EF4F9204AC60A")
        @Override
        public void setRotate(float degrees) {
            oops();
            addTaint(degrees);
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.695 -0400", hash_original_method = "5A520A50E60DD4F6E2005CD4CF7B0F44", hash_generated_method = "3EBC0509625D2BD0B5FAA2CFDEB12086")
        @Override
        public void setSinCos(float sinValue, float cosValue, float px, float py) {
            oops();
            addTaint(sinValue);
            addTaint(cosValue);
            addTaint(px);
            addTaint(py);
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.695 -0400", hash_original_method = "6CBCFE4FC0C45FD06C24211CDA6ABA51", hash_generated_method = "E1E746837D980871660D24F5CB18B7A8")
        @Override
        public void setSinCos(float sinValue, float cosValue) {
            oops();
            addTaint(sinValue);
            addTaint(cosValue);
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.696 -0400", hash_original_method = "B878EA27D37D77B41AE6B8B4C49D9BE3", hash_generated_method = "5EBD742B3FE209A545F60D4B925A5AEB")
        @Override
        public void setSkew(float kx, float ky, float px, float py) {
            oops();
            addTaint(kx);
            addTaint(ky);
            addTaint(px);
            addTaint(py);
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.709 -0400", hash_original_method = "441EC3AFBA9E76FA6888191DBAA13F89", hash_generated_method = "7529085A1C283408B9652386D61BD215")
        @Override
        public void setSkew(float kx, float ky) {
            oops();
            addTaint(kx);
            addTaint(ky);
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.710 -0400", hash_original_method = "50EA0A2B3500CD5FD1B4286CA064C541", hash_generated_method = "EA79F9EBB6FEA7B4632BC36790AAD2AA")
        @Override
        public boolean setConcat(Matrix a, Matrix b) {
            oops();
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_138348010 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_138348010;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.711 -0400", hash_original_method = "8B761AD72B3BAD4BF641E1F91F039D8C", hash_generated_method = "208844ECCA1956391E94DBB63E7917AC")
        @Override
        public boolean preTranslate(float dx, float dy) {
            oops();
            addTaint(dx);
            addTaint(dy);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1245377478 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1245377478;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.712 -0400", hash_original_method = "473ADBEECE4018B92E8542D396E4DD17", hash_generated_method = "E8B49B62F63297E4D443AE7F71E7B864")
        @Override
        public boolean preScale(float sx, float sy, float px, float py) {
            oops();
            addTaint(sx);
            addTaint(sy);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_255928043 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_255928043;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.712 -0400", hash_original_method = "37ED2D59309BF518A3CB72818CA587BF", hash_generated_method = "EC778A78A4177D3D83D17FACAA4016FA")
        @Override
        public boolean preScale(float sx, float sy) {
            oops();
            addTaint(sx);
            addTaint(sy);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_844204221 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_844204221;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.716 -0400", hash_original_method = "7A653600E1581A75FED23AACF91B4370", hash_generated_method = "09C5D9747DDB95BCDB6BE96489D8310A")
        @Override
        public boolean preRotate(float degrees, float px, float py) {
            oops();
            addTaint(degrees);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1124077657 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1124077657;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.717 -0400", hash_original_method = "347A996F82D645DD0C11070D01283F26", hash_generated_method = "5A95ECB68E59BBB3C8A2AA89743B4E86")
        @Override
        public boolean preRotate(float degrees) {
            oops();
            addTaint(degrees);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18760488 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_18760488;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.717 -0400", hash_original_method = "86AA81B34A821E61BE2CE6C1DA88EBEE", hash_generated_method = "7DEDCC60F03C62A4EB0A0D65DC4DADF1")
        @Override
        public boolean preSkew(float kx, float ky, float px, float py) {
            oops();
            addTaint(kx);
            addTaint(ky);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_983973681 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_983973681;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.727 -0400", hash_original_method = "80A2F0F38B1A8CCCD5B8FA2F9D808882", hash_generated_method = "02D5A96FB00019D5D29C6CCE4E4B1934")
        @Override
        public boolean preSkew(float kx, float ky) {
            oops();
            addTaint(kx);
            addTaint(ky);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_803474796 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_803474796;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.745 -0400", hash_original_method = "F05A155D64A4D5B863754CCB7582B708", hash_generated_method = "B929276ACDDBBF551B0D62A8BA450D88")
        @Override
        public boolean preConcat(Matrix other) {
            oops();
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_205032837 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_205032837;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.746 -0400", hash_original_method = "A5A8ACF8FB38AA4A1ACBCA05F5D53B7C", hash_generated_method = "B9E3CFDFBB5EE66392219C51A29BF5C4")
        @Override
        public boolean postTranslate(float dx, float dy) {
            oops();
            addTaint(dx);
            addTaint(dy);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1715713339 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1715713339;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.756 -0400", hash_original_method = "5FFFE76567D7476BFB531E99C9813921", hash_generated_method = "02EF1A6284608C3AF17C3C3D797AE8CA")
        @Override
        public boolean postScale(float sx, float sy, float px, float py) {
            oops();
            addTaint(sx);
            addTaint(sy);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1264302188 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1264302188;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.757 -0400", hash_original_method = "E4B7C4403CB589BACE12330A86A597BD", hash_generated_method = "EB088825FAE263B74656587D360BC715")
        @Override
        public boolean postScale(float sx, float sy) {
            oops();
            addTaint(sx);
            addTaint(sy);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1863996529 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1863996529;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.762 -0400", hash_original_method = "F7844EE0997FB4C2B11CAE5A2CDFB352", hash_generated_method = "68724A0F2ABD9AA95577133A57F85472")
        @Override
        public boolean postRotate(float degrees, float px, float py) {
            oops();
            addTaint(degrees);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_332123601 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_332123601;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.764 -0400", hash_original_method = "CB7CBDBE72FFE751D482DA02B5EB0AEA", hash_generated_method = "EEC37923FDF6EACF4B199FE1471466EB")
        @Override
        public boolean postRotate(float degrees) {
            oops();
            addTaint(degrees);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_753013851 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_753013851;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.765 -0400", hash_original_method = "52E3E853451ABC08EB5927D4E1CFA4A1", hash_generated_method = "BEE76A00CB0550D342E0D5CB6F499FE2")
        @Override
        public boolean postSkew(float kx, float ky, float px, float py) {
            oops();
            addTaint(kx);
            addTaint(ky);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1232822371 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1232822371;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.766 -0400", hash_original_method = "1F83E70D046D2757A9534CC79FE46FF5", hash_generated_method = "903820FD4A63CD638011861406DDFA9D")
        @Override
        public boolean postSkew(float kx, float ky) {
            oops();
            addTaint(kx);
            addTaint(ky);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1575096021 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1575096021;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.766 -0400", hash_original_method = "CC467C10DA80073E550955225E80ADE5", hash_generated_method = "AE8FAC5A737E711C9376BE06FD1DBDB4")
        @Override
        public boolean postConcat(Matrix other) {
            oops();
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1535578424 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1535578424;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.767 -0400", hash_original_method = "96979FDC6AFE468E4307B6E9353A9437", hash_generated_method = "E2406FCFC183CE5CE362FBAD2C96C731")
        @Override
        public boolean setRectToRect(RectF src, RectF dst, ScaleToFit stf) {
            oops();
            addTaint(src.getTaint());
            addTaint(dst.getTaint());
            addTaint(stf.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_179975267 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_179975267;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.777 -0400", hash_original_method = "C52B6EDFC6037C1D437910558C897B0A", hash_generated_method = "7E30D5DD2413EDFEDC6BA015C85DEB6D")
        @Override
        public boolean setPolyToPoly(float[] src, int srcIndex, float[] dst, int dstIndex,
                int pointCount) {
            oops();
            addTaint(src[0]);
            addTaint(srcIndex);
            addTaint(dst[0]);
            addTaint(dstIndex);
            addTaint(pointCount);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1182022368 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1182022368;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.778 -0400", hash_original_method = "B27E8869ACD25E403A7BF1344B888DC2", hash_generated_method = "2F3063A0D704231356B94FA9CBE20FD6")
        @Override
        public void setValues(float[] values) {
            oops();
            addTaint(values[0]);
            // ---------- Original Method ----------
            //oops();
        }

        
};
}

