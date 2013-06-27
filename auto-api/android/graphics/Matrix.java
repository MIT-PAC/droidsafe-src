package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.PrintWriter;

public class Matrix {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.837 -0400", hash_original_field = "7E2E7BFEC42581BDE25254C4BB512478", hash_generated_field = "368FA2DC569BFE75826F8A8AC6BD5246")

    public int native_instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.839 -0400", hash_original_method = "48ECB7BFD8634672F9ACB2AF6643F504", hash_generated_method = "B74B17C57C92799FAD74B4A80984C415")
    public  Matrix() {
        native_instance = native_create(0);
        // ---------- Original Method ----------
        //native_instance = native_create(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.848 -0400", hash_original_method = "D46661DF78A0C4D4A11243C86DA400FE", hash_generated_method = "138AD9A2B29FF4BCFFBD9A8B05F17035")
    public  Matrix(Matrix src) {
        native_instance = native_create(src != null ? src.native_instance : 0);
        // ---------- Original Method ----------
        //native_instance = native_create(src != null ? src.native_instance : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.849 -0400", hash_original_method = "2841C18D225FF732B7B2ED26420E0D84", hash_generated_method = "1AC1954323C5AA41899B8C3C03F0F2B0")
    public boolean isIdentity() {
        boolean var41D9600FE0AA6A328771E92D92F0949C_1123284034 = (native_isIdentity(native_instance));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1688054885 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1688054885;
        // ---------- Original Method ----------
        //return native_isIdentity(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.850 -0400", hash_original_method = "79ACBDB454C166CD18416C9311332315", hash_generated_method = "941CDCB3FD6A420FE78848A8028CD1ED")
    public boolean rectStaysRect() {
        boolean var69C0BE3F50B3E19BAD90EEC6AC1AECE6_119141990 = (native_rectStaysRect(native_instance));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1801305943 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1801305943;
        // ---------- Original Method ----------
        //return native_rectStaysRect(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.851 -0400", hash_original_method = "FFD47BD973F843026149EBC467C90A81", hash_generated_method = "0C60808E8133F63B47E800A29C66C78C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.851 -0400", hash_original_method = "EBE703D7B768F6481174C59F67FA3100", hash_generated_method = "A723738E0C8BB8AA36A2B530442D6C3B")
    public boolean equals(Object obj) {
        boolean varEF70408AB8E744DC202FEA719772EF59_405713771 = (obj != null &&
               obj instanceof Matrix &&
               native_equals(native_instance, ((Matrix)obj).native_instance));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_432601026 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_432601026;
        // ---------- Original Method ----------
        //return obj != null &&
               //obj instanceof Matrix &&
               //native_equals(native_instance, ((Matrix)obj).native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.852 -0400", hash_original_method = "9189F6751C365D24C86F2BCF8029966A", hash_generated_method = "13B89CEA14A3F1070B2312BA6829A32E")
    public void reset() {
        native_reset(native_instance);
        // ---------- Original Method ----------
        //native_reset(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.856 -0400", hash_original_method = "4ABE67590F26D49A748F83E05B922D6E", hash_generated_method = "E7D3CC1EDEF6EC0FF0ECCD849C0862EF")
    public void setTranslate(float dx, float dy) {
        native_setTranslate(native_instance, dx, dy);
        addTaint(dx);
        addTaint(dy);
        // ---------- Original Method ----------
        //native_setTranslate(native_instance, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.869 -0400", hash_original_method = "82025887E943FB82D92D7647B1CDD6A4", hash_generated_method = "D9353DD645B282EB963632AE04D6E90B")
    public void setScale(float sx, float sy, float px, float py) {
        native_setScale(native_instance, sx, sy, px, py);
        addTaint(sx);
        addTaint(sy);
        addTaint(px);
        addTaint(py);
        // ---------- Original Method ----------
        //native_setScale(native_instance, sx, sy, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.869 -0400", hash_original_method = "405981B5032E505B7ADC1B41B7C8A53D", hash_generated_method = "9745C77E1DA4FE0CBA94470E997348DE")
    public void setScale(float sx, float sy) {
        native_setScale(native_instance, sx, sy);
        addTaint(sx);
        addTaint(sy);
        // ---------- Original Method ----------
        //native_setScale(native_instance, sx, sy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.871 -0400", hash_original_method = "D24D75386C6A7BC2522B54B98C5D5387", hash_generated_method = "2246380E93157668B7BE2EE15E7F877B")
    public void setRotate(float degrees, float px, float py) {
        native_setRotate(native_instance, degrees, px, py);
        addTaint(degrees);
        addTaint(px);
        addTaint(py);
        // ---------- Original Method ----------
        //native_setRotate(native_instance, degrees, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.871 -0400", hash_original_method = "43C7C737EFC6B994F84E937D3F6AAF6A", hash_generated_method = "3E720003EF26262A95ECFB36DD57E4F7")
    public void setRotate(float degrees) {
        native_setRotate(native_instance, degrees);
        addTaint(degrees);
        // ---------- Original Method ----------
        //native_setRotate(native_instance, degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.876 -0400", hash_original_method = "D62ED30BDB09648860C12F4C33D5D2F5", hash_generated_method = "7E1AAE72449FFBB154A5ED055871ABB6")
    public void setSinCos(float sinValue, float cosValue, float px, float py) {
        native_setSinCos(native_instance, sinValue, cosValue, px, py);
        addTaint(sinValue);
        addTaint(cosValue);
        addTaint(px);
        addTaint(py);
        // ---------- Original Method ----------
        //native_setSinCos(native_instance, sinValue, cosValue, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.876 -0400", hash_original_method = "BF18F19C125E14226E94998F97574605", hash_generated_method = "F3FD43AA1B700B32CFACD6301731C138")
    public void setSinCos(float sinValue, float cosValue) {
        native_setSinCos(native_instance, sinValue, cosValue);
        addTaint(sinValue);
        addTaint(cosValue);
        // ---------- Original Method ----------
        //native_setSinCos(native_instance, sinValue, cosValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.886 -0400", hash_original_method = "D80C969913C1752CC5799F53218DDBF4", hash_generated_method = "DA3CA87C9412A53D8C62ECD04F935D10")
    public void setSkew(float kx, float ky, float px, float py) {
        native_setSkew(native_instance, kx, ky, px, py);
        addTaint(kx);
        addTaint(ky);
        addTaint(px);
        addTaint(py);
        // ---------- Original Method ----------
        //native_setSkew(native_instance, kx, ky, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.887 -0400", hash_original_method = "C307AACAFF9D5B23D5D1BDAB3825341D", hash_generated_method = "88CD9C14BA3BA6E845F55C1FC7F49146")
    public void setSkew(float kx, float ky) {
        native_setSkew(native_instance, kx, ky);
        addTaint(kx);
        addTaint(ky);
        // ---------- Original Method ----------
        //native_setSkew(native_instance, kx, ky);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.887 -0400", hash_original_method = "56B420A7A69DF5D45E01C2D78C2CB3D0", hash_generated_method = "AD8F365F2600372A7294938AE12DD2D0")
    public boolean setConcat(Matrix a, Matrix b) {
        boolean var00AB055AF6CDC86BED53096651485E3F_1387514052 = (native_setConcat(native_instance, a.native_instance,
                                b.native_instance));
        addTaint(a.getTaint());
        addTaint(b.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1208757494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1208757494;
        // ---------- Original Method ----------
        //return native_setConcat(native_instance, a.native_instance,
                                //b.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.888 -0400", hash_original_method = "F46062CE4D887C63D2B52C9E41EB2542", hash_generated_method = "DCBB2820801FE86867B2F3D0C2A9C5A8")
    public boolean preTranslate(float dx, float dy) {
        boolean varFBA5412443E9C5939494329C2C3880AE_32480360 = (native_preTranslate(native_instance, dx, dy));
        addTaint(dx);
        addTaint(dy);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1577713394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1577713394;
        // ---------- Original Method ----------
        //return native_preTranslate(native_instance, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.888 -0400", hash_original_method = "F666E80378D32154F2306C1184D58E89", hash_generated_method = "1FCCB029A09D6E60559A1A7101DCB8F8")
    public boolean preScale(float sx, float sy, float px, float py) {
        boolean var0587D6DD30F56D53FD1ECF7FD9BDB408_968011048 = (native_preScale(native_instance, sx, sy, px, py));
        addTaint(sx);
        addTaint(sy);
        addTaint(px);
        addTaint(py);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92446894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_92446894;
        // ---------- Original Method ----------
        //return native_preScale(native_instance, sx, sy, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.889 -0400", hash_original_method = "527D02A9319A5AC738DC088F9CE2DF28", hash_generated_method = "D6B60D1934A440C9793EFAE3B6BA7AD2")
    public boolean preScale(float sx, float sy) {
        boolean varF995F72A92DA54AF3047937ACF3B2DE0_1973477040 = (native_preScale(native_instance, sx, sy));
        addTaint(sx);
        addTaint(sy);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_279547460 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_279547460;
        // ---------- Original Method ----------
        //return native_preScale(native_instance, sx, sy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.893 -0400", hash_original_method = "957DD3FA3C951D0A3D8ED4D51FD4EA92", hash_generated_method = "237B8D873AB185C80BBB9C1B39327B70")
    public boolean preRotate(float degrees, float px, float py) {
        boolean var43D78BDDC1A8498586B3652DCB202B3B_20045880 = (native_preRotate(native_instance, degrees, px, py));
        addTaint(degrees);
        addTaint(px);
        addTaint(py);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2046257236 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2046257236;
        // ---------- Original Method ----------
        //return native_preRotate(native_instance, degrees, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.894 -0400", hash_original_method = "07B5A36535E24ED5890CD9963836825B", hash_generated_method = "AB608AB04C20AB8C81D56475AAEE91CE")
    public boolean preRotate(float degrees) {
        boolean varA671CF6014E0E838A67A0F6BFE5843CA_579088080 = (native_preRotate(native_instance, degrees));
        addTaint(degrees);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2007380594 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2007380594;
        // ---------- Original Method ----------
        //return native_preRotate(native_instance, degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.894 -0400", hash_original_method = "BCDAF6F2AF0C49197BF18278F335520E", hash_generated_method = "B13A86E0151E6F8497CC6CBA2489999F")
    public boolean preSkew(float kx, float ky, float px, float py) {
        boolean var9FA7183618403646DB30A7FED3243975_1046393314 = (native_preSkew(native_instance, kx, ky, px, py));
        addTaint(kx);
        addTaint(ky);
        addTaint(px);
        addTaint(py);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_614466360 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_614466360;
        // ---------- Original Method ----------
        //return native_preSkew(native_instance, kx, ky, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.910 -0400", hash_original_method = "421231502648E6DE11C6B4476FBB4CB5", hash_generated_method = "35FC8D05DF741FEF665F2A7050808D8D")
    public boolean preSkew(float kx, float ky) {
        boolean var66725046478C0AC12E1AB350EA8BA008_2144539408 = (native_preSkew(native_instance, kx, ky));
        addTaint(kx);
        addTaint(ky);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2109520656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2109520656;
        // ---------- Original Method ----------
        //return native_preSkew(native_instance, kx, ky);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.911 -0400", hash_original_method = "5465FF6869EFECF5658D42C575F011EC", hash_generated_method = "0B0F3D6F475A4DD6924239F4E0279547")
    public boolean preConcat(Matrix other) {
        boolean var9C6E024213CA5C2C78B882753FA15FB7_448226956 = (native_preConcat(native_instance, other.native_instance));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1534943494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1534943494;
        // ---------- Original Method ----------
        //return native_preConcat(native_instance, other.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.911 -0400", hash_original_method = "C79C9E0E75F4298B5359E17C43CD6BA7", hash_generated_method = "4D6731A0D02192DCB625259758BFB5BC")
    public boolean postTranslate(float dx, float dy) {
        boolean var3EB89776C0E9BC26B5B7A93497AA6338_236277894 = (native_postTranslate(native_instance, dx, dy));
        addTaint(dx);
        addTaint(dy);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2043008774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2043008774;
        // ---------- Original Method ----------
        //return native_postTranslate(native_instance, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.912 -0400", hash_original_method = "158FF341C93FCD549341DC9F548B9A8C", hash_generated_method = "9524E1116495D3FE80C1996A1565B491")
    public boolean postScale(float sx, float sy, float px, float py) {
        boolean var811534EBBA0716ED15AB0EA06550D8C7_6702635 = (native_postScale(native_instance, sx, sy, px, py));
        addTaint(sx);
        addTaint(sy);
        addTaint(px);
        addTaint(py);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_830022031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_830022031;
        // ---------- Original Method ----------
        //return native_postScale(native_instance, sx, sy, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.913 -0400", hash_original_method = "2747525819A92C185D4EAB6F550FCCE3", hash_generated_method = "1AB3DEEECC4193A43823D3CD7D184DC2")
    public boolean postScale(float sx, float sy) {
        boolean varFEBE8AC1DB6F60F9C4B86E273DF2FC19_118468196 = (native_postScale(native_instance, sx, sy));
        addTaint(sx);
        addTaint(sy);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_789660530 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_789660530;
        // ---------- Original Method ----------
        //return native_postScale(native_instance, sx, sy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.914 -0400", hash_original_method = "C0257612FFE5AA7DE5163F0B0AB9F855", hash_generated_method = "A24BACB18796B6E743AB2E8451D94E07")
    public boolean postRotate(float degrees, float px, float py) {
        boolean varD7589C641F418AFED36121BAC654FC16_419257079 = (native_postRotate(native_instance, degrees, px, py));
        addTaint(degrees);
        addTaint(px);
        addTaint(py);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340287525 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_340287525;
        // ---------- Original Method ----------
        //return native_postRotate(native_instance, degrees, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.933 -0400", hash_original_method = "DB293F0AFDDF18839C895B754EC55E8F", hash_generated_method = "40180CC549CD30560AF7E0F167830A8F")
    public boolean postRotate(float degrees) {
        boolean varF737BE5E5361946D147FCBB83A14D353_707921192 = (native_postRotate(native_instance, degrees));
        addTaint(degrees);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_602673173 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_602673173;
        // ---------- Original Method ----------
        //return native_postRotate(native_instance, degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.933 -0400", hash_original_method = "57CA592FACEF6BD09A9AB3838326FC82", hash_generated_method = "44BB046C21EA35D31BA68DB722869C89")
    public boolean postSkew(float kx, float ky, float px, float py) {
        boolean var9BA35FCF22EA355270F926957521F093_1260498915 = (native_postSkew(native_instance, kx, ky, px, py));
        addTaint(kx);
        addTaint(ky);
        addTaint(px);
        addTaint(py);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_899607046 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_899607046;
        // ---------- Original Method ----------
        //return native_postSkew(native_instance, kx, ky, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.934 -0400", hash_original_method = "0C899E968246F5B1F6489525332C2DAA", hash_generated_method = "86093E2E01B415C200B4A877BD84FF84")
    public boolean postSkew(float kx, float ky) {
        boolean varC50A6D02F903D8010B24126CAB1D485B_35897805 = (native_postSkew(native_instance, kx, ky));
        addTaint(kx);
        addTaint(ky);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1284250074 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1284250074;
        // ---------- Original Method ----------
        //return native_postSkew(native_instance, kx, ky);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.935 -0400", hash_original_method = "C3D775738E645A4A21D169FF31B7CB59", hash_generated_method = "82E3DC7DF37A467D5C7478DCFCD6CFC6")
    public boolean postConcat(Matrix other) {
        boolean var883846EFB3F1C6159603731AEA1A59F1_2006276859 = (native_postConcat(native_instance, other.native_instance));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_493559422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_493559422;
        // ---------- Original Method ----------
        //return native_postConcat(native_instance, other.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.935 -0400", hash_original_method = "AEF4FE63E4C98EDC4913C94ED23B0046", hash_generated_method = "6C67AC23D2BED442F9B8BB0C28852A7B")
    public boolean setRectToRect(RectF src, RectF dst, ScaleToFit stf) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        boolean varF7E361575251D13BE7FA91222DB37707_596290730 = (native_setRectToRect(native_instance, src, dst, stf.nativeInt));
        addTaint(src.getTaint());
        addTaint(dst.getTaint());
        addTaint(stf.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1968385184 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1968385184;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.952 -0400", hash_original_method = "81F71DB7C56D04B1A3A5BEE1ABC9313F", hash_generated_method = "BC9E2E7D42A076118ED64433E16AAA21")
    public boolean setPolyToPoly(float[] src, int srcIndex,
                                 float[] dst, int dstIndex,
                                 int pointCount) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        boolean var1B38DC69F9C1AE3BEDB6B044F3F544DB_1875066203 = (native_setPolyToPoly(native_instance, src, srcIndex,
                                    dst, dstIndex, pointCount));
        addTaint(src[0]);
        addTaint(srcIndex);
        addTaint(dst[0]);
        addTaint(dstIndex);
        addTaint(pointCount);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_133709076 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_133709076;
        // ---------- Original Method ----------
        //if (pointCount > 4) {
            //throw new IllegalArgumentException();
        //}
        //checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        //return native_setPolyToPoly(native_instance, src, srcIndex,
                                    //dst, dstIndex, pointCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.952 -0400", hash_original_method = "E353C96DCEC77FF20275C37C83D4D335", hash_generated_method = "9D090DD4BDBFD6496681AEBA9C8AEF78")
    public boolean invert(Matrix inverse) {
        boolean var264FAB0D1776C7EB10CAD495521DE5AA_310477570 = (native_invert(native_instance, inverse.native_instance));
        addTaint(inverse.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_856779678 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_856779678;
        // ---------- Original Method ----------
        //return native_invert(native_instance, inverse.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.953 -0400", hash_original_method = "B69F96FB84D81823B3FB4BA4E2DA7623", hash_generated_method = "E39EB4C545A9B01D8045CE3CB5905680")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.955 -0400", hash_original_method = "E01BB240D3A8AF79E8CA96ADF8A93B02", hash_generated_method = "419771F80DC79539FDC981762451F1C9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.965 -0400", hash_original_method = "9EB430E2EA11CE20A0728D1BC77C5684", hash_generated_method = "45C42F6040FF8805A3F8887E4A996A83")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.965 -0400", hash_original_method = "88563DD2DA99100452A3E727EF621773", hash_generated_method = "D1B6CBC15E7B27ACB91E7098A9205AE7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.966 -0400", hash_original_method = "B621EF9C19B6D800D2C8FEF0AEB101A2", hash_generated_method = "579F155B1F7351AF0430B9F4BE7A277A")
    public void mapPoints(float[] pts) {
        mapPoints(pts, 0, pts, 0, pts.length >> 1);
        addTaint(pts[0]);
        // ---------- Original Method ----------
        //mapPoints(pts, 0, pts, 0, pts.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.967 -0400", hash_original_method = "35DF34CB8A8DD69940AA879A74BDB59C", hash_generated_method = "E11FE779FC5D6865FC7FB33AE46E265C")
    public void mapVectors(float[] vecs) {
        mapVectors(vecs, 0, vecs, 0, vecs.length >> 1);
        addTaint(vecs[0]);
        // ---------- Original Method ----------
        //mapVectors(vecs, 0, vecs, 0, vecs.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.968 -0400", hash_original_method = "ED0A1CF18B9884BD196B57BA9AB3D4D4", hash_generated_method = "8D7E0F182E9C19714F4878D30EC9729C")
    public boolean mapRect(RectF dst, RectF src) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        boolean var0555BDA0682728737A8E84AE5B37B33A_563225260 = (native_mapRect(native_instance, dst, src));
        addTaint(dst.getTaint());
        addTaint(src.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1292797909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1292797909;
        // ---------- Original Method ----------
        //if (dst == null || src == null) {
            //throw new NullPointerException();
        //}
        //return native_mapRect(native_instance, dst, src);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.968 -0400", hash_original_method = "E67F1023A30815D48967A785552726F7", hash_generated_method = "0FE6C7A67C1142E80563AD81A64B288D")
    public boolean mapRect(RectF rect) {
        boolean var4F206D16D71EEBE65AA2A3210698955A_1509445597 = (mapRect(rect, rect));
        addTaint(rect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_706252391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_706252391;
        // ---------- Original Method ----------
        //return mapRect(rect, rect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.974 -0400", hash_original_method = "10B4872CA843B84CAABA7086757B6AA8", hash_generated_method = "FC23B826B17A75BCA68741C54B30038A")
    public float mapRadius(float radius) {
        float varF364E7BDEF648809DE6AA5B35C7E7D24_820626071 = (native_mapRadius(native_instance, radius));
        addTaint(radius);
        float var546ADE640B6EDFBC8A086EF31347E768_1089031838 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1089031838;
        // ---------- Original Method ----------
        //return native_mapRadius(native_instance, radius);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.985 -0400", hash_original_method = "E9A30A056D591CF546BBF753077E713D", hash_generated_method = "08B1094BD49E3370D6CC0736E16585A3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.987 -0400", hash_original_method = "A66AD9F1BFFA0584B04714786DBE2DC1", hash_generated_method = "631E72474FBA00DE62B4B3277497BF00")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.001 -0400", hash_original_method = "790F3515038F276DF7A46D3A4B29621A", hash_generated_method = "6813E9B4C455DC44574316C9C1773229")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_951431621 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(64);
        sb.append("Matrix{");
        toShortString(sb);
        sb.append('}');
        varB4EAC82CA7396A68D541C85D26508E83_951431621 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_951431621.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_951431621;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //sb.append("Matrix{");
        //toShortString(sb);
        //sb.append('}');
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.003 -0400", hash_original_method = "9DDD7B6FB851EDEB6218261EF1A63117", hash_generated_method = "371659EDF87A6F215351A91EAF3134F2")
    public String toShortString() {
        String varB4EAC82CA7396A68D541C85D26508E83_447644101 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(64);
        toShortString(sb);
        varB4EAC82CA7396A68D541C85D26508E83_447644101 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_447644101.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_447644101;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //toShortString(sb);
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.006 -0400", hash_original_method = "F87637A67413F385021CCAE210B2BF25", hash_generated_method = "61445B4EABF61F1E733FB91E43FDD899")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.026 -0400", hash_original_method = "8B9E48E860ED3F94388D797BB2BE65D6", hash_generated_method = "EE727869DEBAF0FFD2E3BF6172A4B3A7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.039 -0400", hash_original_method = "29B0241D689448242FFD9C9D7DE21563", hash_generated_method = "15CC57087C95B7D9B74DEAC06F3C409E")
    protected void finalize() throws Throwable {
        finalizer(native_instance);
        // ---------- Original Method ----------
        //finalizer(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.040 -0400", hash_original_method = "2C87051DCC7759A2331039EEC0434516", hash_generated_method = "2D4C655DC8EA8236F7E1A37965581C46")
    final int ni() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1038386752 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1038386752;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.126 -0400", hash_original_field = "EC6958799BAE00A9193D727D7DC593A6", hash_generated_field = "EFA3DBAD301BED225815D2F749817006")

    public static final int MSCALE_X = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.126 -0400", hash_original_field = "5D32553FB2D960837C00EB34F73347C9", hash_generated_field = "67EAC113D4E4932D73D3A487643F0FD1")

    public static final int MSKEW_X  = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.126 -0400", hash_original_field = "826DCE5E2D680A3BE520E723DDCD9240", hash_generated_field = "07E5E1B67F0C9E5278715AAB25E91DAB")

    public static final int MTRANS_X = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.126 -0400", hash_original_field = "65A646BAFAEAFA33D503B9201F0AB6DD", hash_generated_field = "41EBD7259F41631F6876F58AE3C95D05")

    public static final int MSKEW_Y  = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.126 -0400", hash_original_field = "FF2A5146410D7DC50B02C00C0FEAD5A1", hash_generated_field = "27781A2223BB5718506AC48FB1837DB0")

    public static final int MSCALE_Y = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.127 -0400", hash_original_field = "6EC0976F499BC08E52F9997890E3B577", hash_generated_field = "43C2504D96C28B177ABC2A96E8E9F767")

    public static final int MTRANS_Y = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.127 -0400", hash_original_field = "550CA2E585318DCEA6E304890028A97E", hash_generated_field = "5A7F9B6FF116E340A9248A261942F12B")

    public static final int MPERSP_0 = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.127 -0400", hash_original_field = "62B3BC90B26797726BE0CE6088146C5C", hash_generated_field = "4F80C0BDF0D0A262209ADA0919682BD4")

    public static final int MPERSP_1 = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.127 -0400", hash_original_field = "17070704205CF9E0D12BD961DAD1C106", hash_generated_field = "1EF21E44267C42FB84A589D371DA23B3")

    public static final int MPERSP_2 = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.221 -0400", hash_original_field = "46A5CA0F2132054AB8D29490E16865FA", hash_generated_field = "4ED1C6513CB3E6B3E957792B8FFCDB54")

    public static Matrix IDENTITY_MATRIX = new Matrix() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.128 -0400", hash_original_method = "D86A271A87ADAB5FF76372ECECE2FE9E", hash_generated_method = "4201570C8F06C2B0ECEEAE002E7D4F0B")
         void oops() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Matrix can not be modified");
            // ---------- Original Method ----------
            //throw new IllegalStateException("Matrix can not be modified");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.128 -0400", hash_original_method = "C410E535C65C1A60A6BB6D0124640DFB", hash_generated_method = "637E14C2200FD802184A323B5FBE7575")
        @Override
        public void set(Matrix src) {
            oops();
            addTaint(src.getTaint());
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.135 -0400", hash_original_method = "443FC1BF2CCB476E40EFBA39CED3C856", hash_generated_method = "7E2B188BDA8EA2E28D08CCB551CDF97E")
        @Override
        public void reset() {
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.136 -0400", hash_original_method = "6A3715A1843CB69CD425569E9A9BF685", hash_generated_method = "A3498F8453C0826BB02C0ABB79720CF8")
        @Override
        public void setTranslate(float dx, float dy) {
            oops();
            addTaint(dx);
            addTaint(dy);
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.151 -0400", hash_original_method = "AC062ADEBF9F892A7634B382327DE471", hash_generated_method = "0815503BA6887AFB8D0B6C519D194E4C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.151 -0400", hash_original_method = "AF405FD460DAE15CE8A800CAFF9D70A1", hash_generated_method = "4C9D62A4926698BF33092B372864B82E")
        @Override
        public void setScale(float sx, float sy) {
            oops();
            addTaint(sx);
            addTaint(sy);
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.152 -0400", hash_original_method = "3E711272F4AAA813A9DEF73D8BED4F52", hash_generated_method = "B803000E08E11D051FBABD81DE36BE99")
        @Override
        public void setRotate(float degrees, float px, float py) {
            oops();
            addTaint(degrees);
            addTaint(px);
            addTaint(py);
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.152 -0400", hash_original_method = "F01F93D85A48029B9DBAA6CF7686F3EA", hash_generated_method = "3CD8BE134FA39E80061EF4F9204AC60A")
        @Override
        public void setRotate(float degrees) {
            oops();
            addTaint(degrees);
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.153 -0400", hash_original_method = "5A520A50E60DD4F6E2005CD4CF7B0F44", hash_generated_method = "3EBC0509625D2BD0B5FAA2CFDEB12086")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.153 -0400", hash_original_method = "6CBCFE4FC0C45FD06C24211CDA6ABA51", hash_generated_method = "E1E746837D980871660D24F5CB18B7A8")
        @Override
        public void setSinCos(float sinValue, float cosValue) {
            oops();
            addTaint(sinValue);
            addTaint(cosValue);
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.154 -0400", hash_original_method = "B878EA27D37D77B41AE6B8B4C49D9BE3", hash_generated_method = "5EBD742B3FE209A545F60D4B925A5AEB")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.154 -0400", hash_original_method = "441EC3AFBA9E76FA6888191DBAA13F89", hash_generated_method = "7529085A1C283408B9652386D61BD215")
        @Override
        public void setSkew(float kx, float ky) {
            oops();
            addTaint(kx);
            addTaint(ky);
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.173 -0400", hash_original_method = "50EA0A2B3500CD5FD1B4286CA064C541", hash_generated_method = "15E28DF3FB98A4143CCFF0F51DBA3771")
        @Override
        public boolean setConcat(Matrix a, Matrix b) {
            oops();
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1850971123 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1850971123;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.173 -0400", hash_original_method = "8B761AD72B3BAD4BF641E1F91F039D8C", hash_generated_method = "3FBA82B8F7CEC54CA01B9181A8051A56")
        @Override
        public boolean preTranslate(float dx, float dy) {
            oops();
            addTaint(dx);
            addTaint(dy);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_898626298 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_898626298;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.174 -0400", hash_original_method = "473ADBEECE4018B92E8542D396E4DD17", hash_generated_method = "A676B639408607314A2B8928B2083C8F")
        @Override
        public boolean preScale(float sx, float sy, float px, float py) {
            oops();
            addTaint(sx);
            addTaint(sy);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1527507017 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1527507017;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.174 -0400", hash_original_method = "37ED2D59309BF518A3CB72818CA587BF", hash_generated_method = "FA3D8000ED47B5813CF1C1960F7EDC57")
        @Override
        public boolean preScale(float sx, float sy) {
            oops();
            addTaint(sx);
            addTaint(sy);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1264614581 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1264614581;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.175 -0400", hash_original_method = "7A653600E1581A75FED23AACF91B4370", hash_generated_method = "0E214FC8BC27C864823B482A4F96A7C9")
        @Override
        public boolean preRotate(float degrees, float px, float py) {
            oops();
            addTaint(degrees);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_479277470 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_479277470;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.175 -0400", hash_original_method = "347A996F82D645DD0C11070D01283F26", hash_generated_method = "3F8AE07ABE9E1F0A938D8A3C19074734")
        @Override
        public boolean preRotate(float degrees) {
            oops();
            addTaint(degrees);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1408840038 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1408840038;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.199 -0400", hash_original_method = "86AA81B34A821E61BE2CE6C1DA88EBEE", hash_generated_method = "E9DEE98D9E95AEF092EA6A45859382D8")
        @Override
        public boolean preSkew(float kx, float ky, float px, float py) {
            oops();
            addTaint(kx);
            addTaint(ky);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1633269126 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1633269126;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.200 -0400", hash_original_method = "80A2F0F38B1A8CCCD5B8FA2F9D808882", hash_generated_method = "E16F934895992C6BDCB1EB79283B35FB")
        @Override
        public boolean preSkew(float kx, float ky) {
            oops();
            addTaint(kx);
            addTaint(ky);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979181048 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979181048;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.201 -0400", hash_original_method = "F05A155D64A4D5B863754CCB7582B708", hash_generated_method = "D11C45CFC25C378C3813A34F137DC27E")
        @Override
        public boolean preConcat(Matrix other) {
            oops();
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_884287121 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_884287121;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.201 -0400", hash_original_method = "A5A8ACF8FB38AA4A1ACBCA05F5D53B7C", hash_generated_method = "6246264AD35F985215040E2C85B08536")
        @Override
        public boolean postTranslate(float dx, float dy) {
            oops();
            addTaint(dx);
            addTaint(dy);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_655115692 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_655115692;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.202 -0400", hash_original_method = "5FFFE76567D7476BFB531E99C9813921", hash_generated_method = "D6173BCA66F9683B10AB98211FA6BB6A")
        @Override
        public boolean postScale(float sx, float sy, float px, float py) {
            oops();
            addTaint(sx);
            addTaint(sy);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1113395285 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1113395285;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.202 -0400", hash_original_method = "E4B7C4403CB589BACE12330A86A597BD", hash_generated_method = "2ED23F4ADB4FB376E121907ED153356F")
        @Override
        public boolean postScale(float sx, float sy) {
            oops();
            addTaint(sx);
            addTaint(sy);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_738817080 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_738817080;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.203 -0400", hash_original_method = "F7844EE0997FB4C2B11CAE5A2CDFB352", hash_generated_method = "AF92CDA642F52B8B06E4775D0F67CA0D")
        @Override
        public boolean postRotate(float degrees, float px, float py) {
            oops();
            addTaint(degrees);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1402632098 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1402632098;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.203 -0400", hash_original_method = "CB7CBDBE72FFE751D482DA02B5EB0AEA", hash_generated_method = "F3BD396546E5FC027AD97BD4F9E733F9")
        @Override
        public boolean postRotate(float degrees) {
            oops();
            addTaint(degrees);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_369859799 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_369859799;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.206 -0400", hash_original_method = "52E3E853451ABC08EB5927D4E1CFA4A1", hash_generated_method = "5B3FC9D27927E2E443A49455A78FCB64")
        @Override
        public boolean postSkew(float kx, float ky, float px, float py) {
            oops();
            addTaint(kx);
            addTaint(ky);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_362607376 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_362607376;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.207 -0400", hash_original_method = "1F83E70D046D2757A9534CC79FE46FF5", hash_generated_method = "48CBBCBC35E003194C6C5DD807C87398")
        @Override
        public boolean postSkew(float kx, float ky) {
            oops();
            addTaint(kx);
            addTaint(ky);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1690095730 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1690095730;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.219 -0400", hash_original_method = "CC467C10DA80073E550955225E80ADE5", hash_generated_method = "C6BE76AF2EB054128062DEE7437DE4B1")
        @Override
        public boolean postConcat(Matrix other) {
            oops();
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_721474519 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_721474519;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.220 -0400", hash_original_method = "96979FDC6AFE468E4307B6E9353A9437", hash_generated_method = "EF6D52BE7723DA3FC271A983C9D85AB0")
        @Override
        public boolean setRectToRect(RectF src, RectF dst, ScaleToFit stf) {
            oops();
            addTaint(src.getTaint());
            addTaint(dst.getTaint());
            addTaint(stf.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_15744890 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_15744890;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.221 -0400", hash_original_method = "C52B6EDFC6037C1D437910558C897B0A", hash_generated_method = "4F6B31AA0C9829D98DC7F1B9E60B0E78")
        @Override
        public boolean setPolyToPoly(float[] src, int srcIndex, float[] dst, int dstIndex,
                int pointCount) {
            oops();
            addTaint(src[0]);
            addTaint(srcIndex);
            addTaint(dst[0]);
            addTaint(dstIndex);
            addTaint(pointCount);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1707069275 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1707069275;
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.221 -0400", hash_original_method = "B27E8869ACD25E403A7BF1344B888DC2", hash_generated_method = "2F3063A0D704231356B94FA9CBE20FD6")
        @Override
        public void setValues(float[] values) {
            oops();
            addTaint(values[0]);
            // ---------- Original Method ----------
            //oops();
        }

        
};
}

