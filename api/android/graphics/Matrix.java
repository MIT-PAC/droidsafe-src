package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.PrintWriter;

public class Matrix {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.379 -0400", hash_original_field = "7E2E7BFEC42581BDE25254C4BB512478", hash_generated_field = "368FA2DC569BFE75826F8A8AC6BD5246")

    public int native_instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.379 -0400", hash_original_method = "48ECB7BFD8634672F9ACB2AF6643F504", hash_generated_method = "B74B17C57C92799FAD74B4A80984C415")
    public  Matrix() {
        native_instance = native_create(0);
        // ---------- Original Method ----------
        //native_instance = native_create(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.380 -0400", hash_original_method = "D46661DF78A0C4D4A11243C86DA400FE", hash_generated_method = "138AD9A2B29FF4BCFFBD9A8B05F17035")
    public  Matrix(Matrix src) {
        native_instance = native_create(src != null ? src.native_instance : 0);
        // ---------- Original Method ----------
        //native_instance = native_create(src != null ? src.native_instance : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.380 -0400", hash_original_method = "2841C18D225FF732B7B2ED26420E0D84", hash_generated_method = "48A77A7AD902BEBAF631C7CB83B99CA7")
    public boolean isIdentity() {
        boolean var4EE96B036FE973191E69A90717EECFBD_371671723 = (native_isIdentity(native_instance));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_144078264 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_144078264;
        // ---------- Original Method ----------
        //return native_isIdentity(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.380 -0400", hash_original_method = "79ACBDB454C166CD18416C9311332315", hash_generated_method = "18134CD03457D2A2A1BF113DA9C43EC4")
    public boolean rectStaysRect() {
        boolean var4CCFD8F49D54FFCBB9CF77D912926451_2140794907 = (native_rectStaysRect(native_instance));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1500099891 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1500099891;
        // ---------- Original Method ----------
        //return native_rectStaysRect(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.380 -0400", hash_original_method = "FFD47BD973F843026149EBC467C90A81", hash_generated_method = "37F6B59D51C8BAF0DEC168B419C2B2D8")
    public void set(Matrix src) {
        addTaint(src.getTaint());
    if(src == null)        
        {
            reset();
        } //End block
        else
        {
            native_set(native_instance, src.native_instance);
        } //End block
        // ---------- Original Method ----------
        //if (src == null) {
            //reset();
        //} else {
            //native_set(native_instance, src.native_instance);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.380 -0400", hash_original_method = "EBE703D7B768F6481174C59F67FA3100", hash_generated_method = "0112D091CC280A9FE1E66BE2C6DC0E25")
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        boolean var2EBFE31A01A491DD6C001F47A2B03FFB_273029078 = (obj != null &&
               obj instanceof Matrix &&
               native_equals(native_instance, ((Matrix)obj).native_instance));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1642088558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1642088558;
        // ---------- Original Method ----------
        //return obj != null &&
               //obj instanceof Matrix &&
               //native_equals(native_instance, ((Matrix)obj).native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.381 -0400", hash_original_method = "9189F6751C365D24C86F2BCF8029966A", hash_generated_method = "13B89CEA14A3F1070B2312BA6829A32E")
    public void reset() {
        native_reset(native_instance);
        // ---------- Original Method ----------
        //native_reset(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.381 -0400", hash_original_method = "4ABE67590F26D49A748F83E05B922D6E", hash_generated_method = "EB3DF6C908136674011222CB2B1CCF5E")
    public void setTranslate(float dx, float dy) {
        addTaint(dy);
        addTaint(dx);
        native_setTranslate(native_instance, dx, dy);
        // ---------- Original Method ----------
        //native_setTranslate(native_instance, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.381 -0400", hash_original_method = "82025887E943FB82D92D7647B1CDD6A4", hash_generated_method = "E74561CAABA574F7665E7807F388DCCE")
    public void setScale(float sx, float sy, float px, float py) {
        addTaint(py);
        addTaint(px);
        addTaint(sy);
        addTaint(sx);
        native_setScale(native_instance, sx, sy, px, py);
        // ---------- Original Method ----------
        //native_setScale(native_instance, sx, sy, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.382 -0400", hash_original_method = "405981B5032E505B7ADC1B41B7C8A53D", hash_generated_method = "984E47E55547A616808B810C820B8331")
    public void setScale(float sx, float sy) {
        addTaint(sy);
        addTaint(sx);
        native_setScale(native_instance, sx, sy);
        // ---------- Original Method ----------
        //native_setScale(native_instance, sx, sy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.382 -0400", hash_original_method = "D24D75386C6A7BC2522B54B98C5D5387", hash_generated_method = "B47DBF19DA1772CA3DABC65E5244F079")
    public void setRotate(float degrees, float px, float py) {
        addTaint(py);
        addTaint(px);
        addTaint(degrees);
        native_setRotate(native_instance, degrees, px, py);
        // ---------- Original Method ----------
        //native_setRotate(native_instance, degrees, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.382 -0400", hash_original_method = "43C7C737EFC6B994F84E937D3F6AAF6A", hash_generated_method = "5124A68F22B5621DEE6F599A43A04C55")
    public void setRotate(float degrees) {
        addTaint(degrees);
        native_setRotate(native_instance, degrees);
        // ---------- Original Method ----------
        //native_setRotate(native_instance, degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.382 -0400", hash_original_method = "D62ED30BDB09648860C12F4C33D5D2F5", hash_generated_method = "EE772C204E4A82740FF582E9C00998B7")
    public void setSinCos(float sinValue, float cosValue, float px, float py) {
        addTaint(py);
        addTaint(px);
        addTaint(cosValue);
        addTaint(sinValue);
        native_setSinCos(native_instance, sinValue, cosValue, px, py);
        // ---------- Original Method ----------
        //native_setSinCos(native_instance, sinValue, cosValue, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.382 -0400", hash_original_method = "BF18F19C125E14226E94998F97574605", hash_generated_method = "6FE55AA392A99B38CF12C191C1AF04AB")
    public void setSinCos(float sinValue, float cosValue) {
        addTaint(cosValue);
        addTaint(sinValue);
        native_setSinCos(native_instance, sinValue, cosValue);
        // ---------- Original Method ----------
        //native_setSinCos(native_instance, sinValue, cosValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.383 -0400", hash_original_method = "D80C969913C1752CC5799F53218DDBF4", hash_generated_method = "48D755E11553201B261F1BE9E4FF02F2")
    public void setSkew(float kx, float ky, float px, float py) {
        addTaint(py);
        addTaint(px);
        addTaint(ky);
        addTaint(kx);
        native_setSkew(native_instance, kx, ky, px, py);
        // ---------- Original Method ----------
        //native_setSkew(native_instance, kx, ky, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.383 -0400", hash_original_method = "C307AACAFF9D5B23D5D1BDAB3825341D", hash_generated_method = "24CBB5EE8A9E4B21F5C1487F27EBB0F6")
    public void setSkew(float kx, float ky) {
        addTaint(ky);
        addTaint(kx);
        native_setSkew(native_instance, kx, ky);
        // ---------- Original Method ----------
        //native_setSkew(native_instance, kx, ky);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.383 -0400", hash_original_method = "56B420A7A69DF5D45E01C2D78C2CB3D0", hash_generated_method = "7114827CF81882971AD2317E0200BC69")
    public boolean setConcat(Matrix a, Matrix b) {
        addTaint(b.getTaint());
        addTaint(a.getTaint());
        boolean varE6ED88D3A36B2C09814A975606C14C3B_1852046726 = (native_setConcat(native_instance, a.native_instance,
                                b.native_instance));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_282626028 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_282626028;
        // ---------- Original Method ----------
        //return native_setConcat(native_instance, a.native_instance,
                                //b.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.383 -0400", hash_original_method = "F46062CE4D887C63D2B52C9E41EB2542", hash_generated_method = "1C6738A7362FB7017CD919368A151923")
    public boolean preTranslate(float dx, float dy) {
        addTaint(dy);
        addTaint(dx);
        boolean var25753E562BF94488CF8EE54DDF3524D6_1872349403 = (native_preTranslate(native_instance, dx, dy));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_705045077 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_705045077;
        // ---------- Original Method ----------
        //return native_preTranslate(native_instance, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.385 -0400", hash_original_method = "F666E80378D32154F2306C1184D58E89", hash_generated_method = "B3E9315B5165F4ED22DD8D28AA61541B")
    public boolean preScale(float sx, float sy, float px, float py) {
        addTaint(py);
        addTaint(px);
        addTaint(sy);
        addTaint(sx);
        boolean var6D605072143712BDB7B0C51FCAEDDF98_616234724 = (native_preScale(native_instance, sx, sy, px, py));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_803050614 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_803050614;
        // ---------- Original Method ----------
        //return native_preScale(native_instance, sx, sy, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.385 -0400", hash_original_method = "527D02A9319A5AC738DC088F9CE2DF28", hash_generated_method = "0D6B60F2165C2E8F806854AA9E7E1B79")
    public boolean preScale(float sx, float sy) {
        addTaint(sy);
        addTaint(sx);
        boolean var00600150947C3B7A924EA70D9361A392_217733674 = (native_preScale(native_instance, sx, sy));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_989827299 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_989827299;
        // ---------- Original Method ----------
        //return native_preScale(native_instance, sx, sy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.386 -0400", hash_original_method = "957DD3FA3C951D0A3D8ED4D51FD4EA92", hash_generated_method = "60687BEE5DD4AA7D80901B1FC70CA20A")
    public boolean preRotate(float degrees, float px, float py) {
        addTaint(py);
        addTaint(px);
        addTaint(degrees);
        boolean var3F84B17A5206107C38D24150068AF558_141978683 = (native_preRotate(native_instance, degrees, px, py));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_273025284 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_273025284;
        // ---------- Original Method ----------
        //return native_preRotate(native_instance, degrees, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.386 -0400", hash_original_method = "07B5A36535E24ED5890CD9963836825B", hash_generated_method = "055B1E97DFE8C0456D9EBC624D11D41F")
    public boolean preRotate(float degrees) {
        addTaint(degrees);
        boolean var0C5767FFCB74139E1627A4F5FE659DA0_1762172589 = (native_preRotate(native_instance, degrees));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1863080036 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1863080036;
        // ---------- Original Method ----------
        //return native_preRotate(native_instance, degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.386 -0400", hash_original_method = "BCDAF6F2AF0C49197BF18278F335520E", hash_generated_method = "998858E202B3605765AAEF62B919EFB3")
    public boolean preSkew(float kx, float ky, float px, float py) {
        addTaint(py);
        addTaint(px);
        addTaint(ky);
        addTaint(kx);
        boolean varC209666419467117AC50C69600E79A38_252999682 = (native_preSkew(native_instance, kx, ky, px, py));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_44998931 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_44998931;
        // ---------- Original Method ----------
        //return native_preSkew(native_instance, kx, ky, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.386 -0400", hash_original_method = "421231502648E6DE11C6B4476FBB4CB5", hash_generated_method = "AD870EB45916348B7C5C1F0DA2EEF36F")
    public boolean preSkew(float kx, float ky) {
        addTaint(ky);
        addTaint(kx);
        boolean var1E152469BFF788920C27427DB0A4B9F7_1563823771 = (native_preSkew(native_instance, kx, ky));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1152301564 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1152301564;
        // ---------- Original Method ----------
        //return native_preSkew(native_instance, kx, ky);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.387 -0400", hash_original_method = "5465FF6869EFECF5658D42C575F011EC", hash_generated_method = "B29004D7E14F520B0BCB4699F1F23AF9")
    public boolean preConcat(Matrix other) {
        addTaint(other.getTaint());
        boolean varC6619FE4792034F1B16FC15DE9737284_1250727305 = (native_preConcat(native_instance, other.native_instance));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1373236409 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1373236409;
        // ---------- Original Method ----------
        //return native_preConcat(native_instance, other.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.387 -0400", hash_original_method = "C79C9E0E75F4298B5359E17C43CD6BA7", hash_generated_method = "185BDC56E7CC95CE9FB62566B0BFC471")
    public boolean postTranslate(float dx, float dy) {
        addTaint(dy);
        addTaint(dx);
        boolean varA4D4EF96C71845074B19D993A1FBA0DF_1796159681 = (native_postTranslate(native_instance, dx, dy));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_370601635 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_370601635;
        // ---------- Original Method ----------
        //return native_postTranslate(native_instance, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.387 -0400", hash_original_method = "158FF341C93FCD549341DC9F548B9A8C", hash_generated_method = "6B6D5CAFBC1F9C5EBA85268E329CAF3A")
    public boolean postScale(float sx, float sy, float px, float py) {
        addTaint(py);
        addTaint(px);
        addTaint(sy);
        addTaint(sx);
        boolean varA248B246E78C0CDAA5AB596246A7717F_1492876677 = (native_postScale(native_instance, sx, sy, px, py));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1650095896 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1650095896;
        // ---------- Original Method ----------
        //return native_postScale(native_instance, sx, sy, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.387 -0400", hash_original_method = "2747525819A92C185D4EAB6F550FCCE3", hash_generated_method = "73E3305ED36BC47802749B8D9BBF241F")
    public boolean postScale(float sx, float sy) {
        addTaint(sy);
        addTaint(sx);
        boolean var25CAC5E9F08722D359A17D4F59AB5AC0_1341316715 = (native_postScale(native_instance, sx, sy));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1927329492 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1927329492;
        // ---------- Original Method ----------
        //return native_postScale(native_instance, sx, sy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.387 -0400", hash_original_method = "C0257612FFE5AA7DE5163F0B0AB9F855", hash_generated_method = "3285E18E4A4044F129F9AE4FCB2846DC")
    public boolean postRotate(float degrees, float px, float py) {
        addTaint(py);
        addTaint(px);
        addTaint(degrees);
        boolean var8251BCFC670241A633DD9EFEDB5445C3_1587951214 = (native_postRotate(native_instance, degrees, px, py));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1180183999 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1180183999;
        // ---------- Original Method ----------
        //return native_postRotate(native_instance, degrees, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.388 -0400", hash_original_method = "DB293F0AFDDF18839C895B754EC55E8F", hash_generated_method = "128F723AB700DF626CB1D6EABD976676")
    public boolean postRotate(float degrees) {
        addTaint(degrees);
        boolean varBA81D77B1ED37D4C8BFC4FC3F520CAF7_1286611359 = (native_postRotate(native_instance, degrees));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_313598689 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_313598689;
        // ---------- Original Method ----------
        //return native_postRotate(native_instance, degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.388 -0400", hash_original_method = "57CA592FACEF6BD09A9AB3838326FC82", hash_generated_method = "9CF1A43760498BD78EDAA05B45E7739F")
    public boolean postSkew(float kx, float ky, float px, float py) {
        addTaint(py);
        addTaint(px);
        addTaint(ky);
        addTaint(kx);
        boolean var1CAA8248168091D747125EF90CC90805_919220641 = (native_postSkew(native_instance, kx, ky, px, py));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1240621693 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1240621693;
        // ---------- Original Method ----------
        //return native_postSkew(native_instance, kx, ky, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.388 -0400", hash_original_method = "0C899E968246F5B1F6489525332C2DAA", hash_generated_method = "CE6E5E56F6FBA6D77FCF31950334E058")
    public boolean postSkew(float kx, float ky) {
        addTaint(ky);
        addTaint(kx);
        boolean varFD47D3D3418812881ABB2D1C39F43A5D_1754210519 = (native_postSkew(native_instance, kx, ky));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2086965557 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2086965557;
        // ---------- Original Method ----------
        //return native_postSkew(native_instance, kx, ky);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.388 -0400", hash_original_method = "C3D775738E645A4A21D169FF31B7CB59", hash_generated_method = "299BFF09E775B7D729546800BC5B3677")
    public boolean postConcat(Matrix other) {
        addTaint(other.getTaint());
        boolean var787CF2D27047EAED5D9A59745FE44F32_1469463680 = (native_postConcat(native_instance, other.native_instance));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2048850081 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2048850081;
        // ---------- Original Method ----------
        //return native_postConcat(native_instance, other.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.388 -0400", hash_original_method = "AEF4FE63E4C98EDC4913C94ED23B0046", hash_generated_method = "5C44A65CD9DD94946DE01CB7B20F7CE5")
    public boolean setRectToRect(RectF src, RectF dst, ScaleToFit stf) {
        addTaint(stf.getTaint());
        addTaint(dst.getTaint());
        addTaint(src.getTaint());
    if(dst == null || src == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1680116090 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1680116090.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1680116090;
        } //End block
        boolean var1C02CF300DB1BDFBFE871D791C2B6E94_1717902002 = (native_setRectToRect(native_instance, src, dst, stf.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_416021372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_416021372;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.389 -0400", hash_original_method = "81F71DB7C56D04B1A3A5BEE1ABC9313F", hash_generated_method = "CB7312D3AE377CDA3191E32040A513AA")
    public boolean setPolyToPoly(float[] src, int srcIndex,
                                 float[] dst, int dstIndex,
                                 int pointCount) {
        addTaint(pointCount);
        addTaint(dstIndex);
        addTaint(dst[0]);
        addTaint(srcIndex);
        addTaint(src[0]);
    if(pointCount > 4)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_212949468 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_212949468.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_212949468;
        } //End block
        checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        boolean var33A60B82D2B7140C23AE4538B682880D_2039578172 = (native_setPolyToPoly(native_instance, src, srcIndex,
                                    dst, dstIndex, pointCount));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_617412067 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_617412067;
        // ---------- Original Method ----------
        //if (pointCount > 4) {
            //throw new IllegalArgumentException();
        //}
        //checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        //return native_setPolyToPoly(native_instance, src, srcIndex,
                                    //dst, dstIndex, pointCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.389 -0400", hash_original_method = "E353C96DCEC77FF20275C37C83D4D335", hash_generated_method = "8261203E262CDF03F9203BA0B67AF27B")
    public boolean invert(Matrix inverse) {
        addTaint(inverse.getTaint());
        boolean var96F41CF1B50CA3CA869B0881A35396E6_110506170 = (native_invert(native_instance, inverse.native_instance));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2045329122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2045329122;
        // ---------- Original Method ----------
        //return native_invert(native_instance, inverse.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.389 -0400", hash_original_method = "B69F96FB84D81823B3FB4BA4E2DA7623", hash_generated_method = "5DCDC1AA48579930959280DB496826AB")
    public void mapPoints(float[] dst, int dstIndex, float[] src, int srcIndex,
                          int pointCount) {
        addTaint(pointCount);
        addTaint(srcIndex);
        addTaint(src[0]);
        addTaint(dstIndex);
        addTaint(dst[0]);
        checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         pointCount, true);
        // ---------- Original Method ----------
        //checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        //native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         //pointCount, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.389 -0400", hash_original_method = "E01BB240D3A8AF79E8CA96ADF8A93B02", hash_generated_method = "9624EFCD46B6B6EAE7D20D464B6B3D04")
    public void mapVectors(float[] dst, int dstIndex, float[] src, int srcIndex,
                          int vectorCount) {
        addTaint(vectorCount);
        addTaint(srcIndex);
        addTaint(src[0]);
        addTaint(dstIndex);
        addTaint(dst[0]);
        checkPointArrays(src, srcIndex, dst, dstIndex, vectorCount);
        native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         vectorCount, false);
        // ---------- Original Method ----------
        //checkPointArrays(src, srcIndex, dst, dstIndex, vectorCount);
        //native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         //vectorCount, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.390 -0400", hash_original_method = "9EB430E2EA11CE20A0728D1BC77C5684", hash_generated_method = "FA6A670E46C273B18099D849B122E530")
    public void mapPoints(float[] dst, float[] src) {
        addTaint(src[0]);
        addTaint(dst[0]);
    if(dst.length != src.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_391803168 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_391803168.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_391803168;
        } //End block
        mapPoints(dst, 0, src, 0, dst.length >> 1);
        // ---------- Original Method ----------
        //if (dst.length != src.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //mapPoints(dst, 0, src, 0, dst.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.390 -0400", hash_original_method = "88563DD2DA99100452A3E727EF621773", hash_generated_method = "BE09142863C02B31B4C3048B11EB4F4A")
    public void mapVectors(float[] dst, float[] src) {
        addTaint(src[0]);
        addTaint(dst[0]);
    if(dst.length != src.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_998526935 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_998526935.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_998526935;
        } //End block
        mapVectors(dst, 0, src, 0, dst.length >> 1);
        // ---------- Original Method ----------
        //if (dst.length != src.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //mapVectors(dst, 0, src, 0, dst.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.390 -0400", hash_original_method = "B621EF9C19B6D800D2C8FEF0AEB101A2", hash_generated_method = "478E8C091C483D7923156D415D095C14")
    public void mapPoints(float[] pts) {
        addTaint(pts[0]);
        mapPoints(pts, 0, pts, 0, pts.length >> 1);
        // ---------- Original Method ----------
        //mapPoints(pts, 0, pts, 0, pts.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.390 -0400", hash_original_method = "35DF34CB8A8DD69940AA879A74BDB59C", hash_generated_method = "53E01C380D49B72A8D207E1E455316C2")
    public void mapVectors(float[] vecs) {
        addTaint(vecs[0]);
        mapVectors(vecs, 0, vecs, 0, vecs.length >> 1);
        // ---------- Original Method ----------
        //mapVectors(vecs, 0, vecs, 0, vecs.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.390 -0400", hash_original_method = "ED0A1CF18B9884BD196B57BA9AB3D4D4", hash_generated_method = "6B565BE78836ECCB942CA40451B63C7E")
    public boolean mapRect(RectF dst, RectF src) {
        addTaint(src.getTaint());
        addTaint(dst.getTaint());
    if(dst == null || src == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1676088195 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1676088195.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1676088195;
        } //End block
        boolean var5228F39EF75A4D98A20AD4A11557D128_1490570468 = (native_mapRect(native_instance, dst, src));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1660516028 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1660516028;
        // ---------- Original Method ----------
        //if (dst == null || src == null) {
            //throw new NullPointerException();
        //}
        //return native_mapRect(native_instance, dst, src);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.390 -0400", hash_original_method = "E67F1023A30815D48967A785552726F7", hash_generated_method = "25062756A61C61DB4EC5812EEEF82F64")
    public boolean mapRect(RectF rect) {
        addTaint(rect.getTaint());
        boolean var5BAD26C11059BE0A5A6FE9E70E588345_1359451525 = (mapRect(rect, rect));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1349724077 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1349724077;
        // ---------- Original Method ----------
        //return mapRect(rect, rect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.391 -0400", hash_original_method = "10B4872CA843B84CAABA7086757B6AA8", hash_generated_method = "803008998EBED3C154E85FD163DC175A")
    public float mapRadius(float radius) {
        addTaint(radius);
        float varDD1A239AECC57E6C58B8EB93F69C0956_413432381 = (native_mapRadius(native_instance, radius));
                float var546ADE640B6EDFBC8A086EF31347E768_1227749775 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1227749775;
        // ---------- Original Method ----------
        //return native_mapRadius(native_instance, radius);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.391 -0400", hash_original_method = "E9A30A056D591CF546BBF753077E713D", hash_generated_method = "0FF5E299F970F84D9C1F1AC541217646")
    public void getValues(float[] values) {
        addTaint(values[0]);
    if(values.length < 9)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_1915590669 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_1915590669.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_1915590669;
        } //End block
        native_getValues(native_instance, values);
        // ---------- Original Method ----------
        //if (values.length < 9) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_getValues(native_instance, values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.391 -0400", hash_original_method = "A66AD9F1BFFA0584B04714786DBE2DC1", hash_generated_method = "AD80F4DF5412694CE019F6457BCFD7C5")
    public void setValues(float[] values) {
        addTaint(values[0]);
    if(values.length < 9)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_545556738 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_545556738.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_545556738;
        } //End block
        native_setValues(native_instance, values);
        // ---------- Original Method ----------
        //if (values.length < 9) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_setValues(native_instance, values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.391 -0400", hash_original_method = "790F3515038F276DF7A46D3A4B29621A", hash_generated_method = "482B03FAF84D160BF40673977038070D")
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Matrix{");
        toShortString(sb);
        sb.append('}');
String var2460B846747F8B22185AD8BE722266A5_784276747 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_784276747.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_784276747;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //sb.append("Matrix{");
        //toShortString(sb);
        //sb.append('}');
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.391 -0400", hash_original_method = "9DDD7B6FB851EDEB6218261EF1A63117", hash_generated_method = "CAEE03E82141A95C758902ECA34E3B3E")
    public String toShortString() {
        StringBuilder sb = new StringBuilder(64);
        toShortString(sb);
String var2460B846747F8B22185AD8BE722266A5_1656700004 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1656700004.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1656700004;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //toShortString(sb);
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.392 -0400", hash_original_method = "F87637A67413F385021CCAE210B2BF25", hash_generated_method = "C93A56F5B4B25B9088C3CD55959CD473")
    public void toShortString(StringBuilder sb) {
        addTaint(sb.getTaint());
        float[] values = new float[9];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.392 -0400", hash_original_method = "8B9E48E860ED3F94388D797BB2BE65D6", hash_generated_method = "D8CC2CEED807133F12131FC90035468D")
    public void printShortString(PrintWriter pw) {
        addTaint(pw.getTaint());
        float[] values = new float[9];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.392 -0400", hash_original_method = "29B0241D689448242FFD9C9D7DE21563", hash_generated_method = "15CC57087C95B7D9B74DEAC06F3C409E")
    protected void finalize() throws Throwable {
        finalizer(native_instance);
        // ---------- Original Method ----------
        //finalizer(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.392 -0400", hash_original_method = "2C87051DCC7759A2331039EEC0434516", hash_generated_method = "502CA1FF9409C8C9492D2F99A2434E34")
    final int ni() {
        int var7E2E7BFEC42581BDE25254C4BB512478_1399692085 = (native_instance);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_327318735 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_327318735;
        // ---------- Original Method ----------
        //return native_instance;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_create(int native_src_or_zero) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_isIdentity(int native_object) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_rectStaysRect(int native_object) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_reset(int native_object) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_set(int native_object, int other) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setTranslate(int native_object,
                                                   float dx, float dy) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setScale(int native_object,
                                        float sx, float sy, float px, float py) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setScale(int native_object,
                                               float sx, float sy) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setRotate(int native_object,
                                            float degrees, float px, float py) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setRotate(int native_object,
                                                float degrees) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setSinCos(int native_object,
                            float sinValue, float cosValue, float px, float py) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setSinCos(int native_object,
                                                float sinValue, float cosValue) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setSkew(int native_object,
                                        float kx, float ky, float px, float py) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setSkew(int native_object,
                                              float kx, float ky) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_setConcat(int native_object,
                                                   int a, int b) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_preTranslate(int native_object,
                                                      float dx, float dy) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_preScale(int native_object,
                                        float sx, float sy, float px, float py) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_preScale(int native_object,
                                                  float sx, float sy) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_preRotate(int native_object,
                                            float degrees, float px, float py) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_preRotate(int native_object,
                                                   float degrees) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_preSkew(int native_object,
                                        float kx, float ky, float px, float py) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_preSkew(int native_object,
                                                 float kx, float ky) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_preConcat(int native_object,
                                                   int other_matrix) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_postTranslate(int native_object,
                                                       float dx, float dy) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_postScale(int native_object,
                                        float sx, float sy, float px, float py) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_postScale(int native_object,
                                                   float sx, float sy) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_postRotate(int native_object,
                                            float degrees, float px, float py) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_postRotate(int native_object,
                                                    float degrees) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_postSkew(int native_object,
                                        float kx, float ky, float px, float py) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_postSkew(int native_object,
                                                  float kx, float ky) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_postConcat(int native_object,
                                                    int other_matrix) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_setRectToRect(int native_object,
                                                RectF src, RectF dst, int stf) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_setPolyToPoly(int native_object,
        float[] src, int srcIndex, float[] dst, int dstIndex, int pointCount) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_invert(int native_object, int inverse) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_mapPoints(int native_object,
                        float[] dst, int dstIndex, float[] src, int srcIndex,
                        int ptCount, boolean isPts) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_mapRect(int native_object,
                                                 RectF dst, RectF src) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static float native_mapRadius(int native_object,
                                                 float radius) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_getValues(int native_object,
                                                float[] values) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setValues(int native_object,
                                                float[] values) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_equals(int native_a, int native_b) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.396 -0400", hash_original_field = "EC6958799BAE00A9193D727D7DC593A6", hash_generated_field = "EFA3DBAD301BED225815D2F749817006")

    public static final int MSCALE_X = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.396 -0400", hash_original_field = "5D32553FB2D960837C00EB34F73347C9", hash_generated_field = "67EAC113D4E4932D73D3A487643F0FD1")

    public static final int MSKEW_X  = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.397 -0400", hash_original_field = "826DCE5E2D680A3BE520E723DDCD9240", hash_generated_field = "07E5E1B67F0C9E5278715AAB25E91DAB")

    public static final int MTRANS_X = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.397 -0400", hash_original_field = "65A646BAFAEAFA33D503B9201F0AB6DD", hash_generated_field = "41EBD7259F41631F6876F58AE3C95D05")

    public static final int MSKEW_Y  = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.397 -0400", hash_original_field = "FF2A5146410D7DC50B02C00C0FEAD5A1", hash_generated_field = "27781A2223BB5718506AC48FB1837DB0")

    public static final int MSCALE_Y = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.397 -0400", hash_original_field = "6EC0976F499BC08E52F9997890E3B577", hash_generated_field = "43C2504D96C28B177ABC2A96E8E9F767")

    public static final int MTRANS_Y = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.397 -0400", hash_original_field = "550CA2E585318DCEA6E304890028A97E", hash_generated_field = "5A7F9B6FF116E340A9248A261942F12B")

    public static final int MPERSP_0 = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.397 -0400", hash_original_field = "62B3BC90B26797726BE0CE6088146C5C", hash_generated_field = "4F80C0BDF0D0A262209ADA0919682BD4")

    public static final int MPERSP_1 = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.397 -0400", hash_original_field = "17070704205CF9E0D12BD961DAD1C106", hash_generated_field = "1EF21E44267C42FB84A589D371DA23B3")

    public static final int MPERSP_2 = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.669 -0400", hash_original_field = "46A5CA0F2132054AB8D29490E16865FA", hash_generated_field = "94446BD212F9279E770A36FC64786407")

    public static Matrix IDENTITY_MATRIX = new Matrix() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.656 -0400", hash_original_method = "D86A271A87ADAB5FF76372ECECE2FE9E", hash_generated_method = "4201570C8F06C2B0ECEEAE002E7D4F0B")
         void oops() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Matrix can not be modified");
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.657 -0400", hash_original_method = "C410E535C65C1A60A6BB6D0124640DFB", hash_generated_method = "637E14C2200FD802184A323B5FBE7575")
        @Override
        public void set(Matrix src) {
            oops();
            addTaint(src.getTaint());
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.657 -0400", hash_original_method = "443FC1BF2CCB476E40EFBA39CED3C856", hash_generated_method = "7E2B188BDA8EA2E28D08CCB551CDF97E")
        @Override
        public void reset() {
            oops();
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.657 -0400", hash_original_method = "6A3715A1843CB69CD425569E9A9BF685", hash_generated_method = "A3498F8453C0826BB02C0ABB79720CF8")
        @Override
        public void setTranslate(float dx, float dy) {
            oops();
            addTaint(dx);
            addTaint(dy);
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.658 -0400", hash_original_method = "AC062ADEBF9F892A7634B382327DE471", hash_generated_method = "0815503BA6887AFB8D0B6C519D194E4C")
        @Override
        public void setScale(float sx, float sy, float px, float py) {
            oops();
            addTaint(sx);
            addTaint(sy);
            addTaint(px);
            addTaint(py);
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.658 -0400", hash_original_method = "AF405FD460DAE15CE8A800CAFF9D70A1", hash_generated_method = "4C9D62A4926698BF33092B372864B82E")
        @Override
        public void setScale(float sx, float sy) {
            oops();
            addTaint(sx);
            addTaint(sy);
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.658 -0400", hash_original_method = "3E711272F4AAA813A9DEF73D8BED4F52", hash_generated_method = "B803000E08E11D051FBABD81DE36BE99")
        @Override
        public void setRotate(float degrees, float px, float py) {
            oops();
            addTaint(degrees);
            addTaint(px);
            addTaint(py);
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.659 -0400", hash_original_method = "F01F93D85A48029B9DBAA6CF7686F3EA", hash_generated_method = "3CD8BE134FA39E80061EF4F9204AC60A")
        @Override
        public void setRotate(float degrees) {
            oops();
            addTaint(degrees);
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.659 -0400", hash_original_method = "5A520A50E60DD4F6E2005CD4CF7B0F44", hash_generated_method = "3EBC0509625D2BD0B5FAA2CFDEB12086")
        @Override
        public void setSinCos(float sinValue, float cosValue, float px, float py) {
            oops();
            addTaint(sinValue);
            addTaint(cosValue);
            addTaint(px);
            addTaint(py);
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.660 -0400", hash_original_method = "6CBCFE4FC0C45FD06C24211CDA6ABA51", hash_generated_method = "E1E746837D980871660D24F5CB18B7A8")
        @Override
        public void setSinCos(float sinValue, float cosValue) {
            oops();
            addTaint(sinValue);
            addTaint(cosValue);
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.660 -0400", hash_original_method = "B878EA27D37D77B41AE6B8B4C49D9BE3", hash_generated_method = "5EBD742B3FE209A545F60D4B925A5AEB")
        @Override
        public void setSkew(float kx, float ky, float px, float py) {
            oops();
            addTaint(kx);
            addTaint(ky);
            addTaint(px);
            addTaint(py);
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.660 -0400", hash_original_method = "441EC3AFBA9E76FA6888191DBAA13F89", hash_generated_method = "7529085A1C283408B9652386D61BD215")
        @Override
        public void setSkew(float kx, float ky) {
            oops();
            addTaint(kx);
            addTaint(ky);
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.661 -0400", hash_original_method = "50EA0A2B3500CD5FD1B4286CA064C541", hash_generated_method = "FAAF71B5544EA0437607E822E08DC79D")
        @Override
        public boolean setConcat(Matrix a, Matrix b) {
            oops();
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_359407419 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_359407419;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.661 -0400", hash_original_method = "8B761AD72B3BAD4BF641E1F91F039D8C", hash_generated_method = "50FB6D768BC85F1F5FD6A714F1204291")
        @Override
        public boolean preTranslate(float dx, float dy) {
            oops();
            addTaint(dx);
            addTaint(dy);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1044099383 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1044099383;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.661 -0400", hash_original_method = "473ADBEECE4018B92E8542D396E4DD17", hash_generated_method = "54F98E8142CC4B1BD893DCB4718C17A3")
        @Override
        public boolean preScale(float sx, float sy, float px, float py) {
            oops();
            addTaint(sx);
            addTaint(sy);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_498057005 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_498057005;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.662 -0400", hash_original_method = "37ED2D59309BF518A3CB72818CA587BF", hash_generated_method = "B8212E66F12D6DE8F2E7D3CCB84ED5D4")
        @Override
        public boolean preScale(float sx, float sy) {
            oops();
            addTaint(sx);
            addTaint(sy);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_437028120 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_437028120;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.662 -0400", hash_original_method = "7A653600E1581A75FED23AACF91B4370", hash_generated_method = "D99A474964F9A249C501991175D4BEB2")
        @Override
        public boolean preRotate(float degrees, float px, float py) {
            oops();
            addTaint(degrees);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1892217388 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1892217388;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.663 -0400", hash_original_method = "347A996F82D645DD0C11070D01283F26", hash_generated_method = "289FA476EF8CC93C74F886C038176938")
        @Override
        public boolean preRotate(float degrees) {
            oops();
            addTaint(degrees);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_864845968 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_864845968;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.664 -0400", hash_original_method = "86AA81B34A821E61BE2CE6C1DA88EBEE", hash_generated_method = "0B9EBD28424B9D39602326F10D0CED63")
        @Override
        public boolean preSkew(float kx, float ky, float px, float py) {
            oops();
            addTaint(kx);
            addTaint(ky);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_596247813 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_596247813;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.664 -0400", hash_original_method = "80A2F0F38B1A8CCCD5B8FA2F9D808882", hash_generated_method = "0A5EA936F6F765E1B48997327E2033C4")
        @Override
        public boolean preSkew(float kx, float ky) {
            oops();
            addTaint(kx);
            addTaint(ky);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1845385359 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1845385359;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.665 -0400", hash_original_method = "F05A155D64A4D5B863754CCB7582B708", hash_generated_method = "FBA4F0D94A8FCD2CE32B2BCEC292EC6F")
        @Override
        public boolean preConcat(Matrix other) {
            oops();
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_84259225 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_84259225;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.666 -0400", hash_original_method = "A5A8ACF8FB38AA4A1ACBCA05F5D53B7C", hash_generated_method = "F317CEE9C671619723957828615C464C")
        @Override
        public boolean postTranslate(float dx, float dy) {
            oops();
            addTaint(dx);
            addTaint(dy);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1779755897 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1779755897;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.666 -0400", hash_original_method = "5FFFE76567D7476BFB531E99C9813921", hash_generated_method = "C7360B0FAA5B279CA15A734E6473D6B7")
        @Override
        public boolean postScale(float sx, float sy, float px, float py) {
            oops();
            addTaint(sx);
            addTaint(sy);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_770490980 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_770490980;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.667 -0400", hash_original_method = "E4B7C4403CB589BACE12330A86A597BD", hash_generated_method = "D465E5A311909B3D18FE50BA6B1DDE8B")
        @Override
        public boolean postScale(float sx, float sy) {
            oops();
            addTaint(sx);
            addTaint(sy);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_856485734 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_856485734;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.667 -0400", hash_original_method = "F7844EE0997FB4C2B11CAE5A2CDFB352", hash_generated_method = "5E9E91C3FD19BE69842928F186F861B6")
        @Override
        public boolean postRotate(float degrees, float px, float py) {
            oops();
            addTaint(degrees);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1097067554 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1097067554;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.667 -0400", hash_original_method = "CB7CBDBE72FFE751D482DA02B5EB0AEA", hash_generated_method = "9293DD74ED7F0BC1AA2C689CF5A19EB1")
        @Override
        public boolean postRotate(float degrees) {
            oops();
            addTaint(degrees);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_392209909 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_392209909;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.668 -0400", hash_original_method = "52E3E853451ABC08EB5927D4E1CFA4A1", hash_generated_method = "84F1EE604E5A571E1E252BC340BE7571")
        @Override
        public boolean postSkew(float kx, float ky, float px, float py) {
            oops();
            addTaint(kx);
            addTaint(ky);
            addTaint(px);
            addTaint(py);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1054860577 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1054860577;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.668 -0400", hash_original_method = "1F83E70D046D2757A9534CC79FE46FF5", hash_generated_method = "8AB006F21F1B6DC9AE0FFE9552FCC688")
        @Override
        public boolean postSkew(float kx, float ky) {
            oops();
            addTaint(kx);
            addTaint(ky);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1383847973 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1383847973;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.668 -0400", hash_original_method = "CC467C10DA80073E550955225E80ADE5", hash_generated_method = "12FE715F5DE9A10C611D7A282CC638F0")
        @Override
        public boolean postConcat(Matrix other) {
            oops();
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1618816258 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1618816258;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.669 -0400", hash_original_method = "96979FDC6AFE468E4307B6E9353A9437", hash_generated_method = "37587A647AA58A98B9CE8E6262309FF3")
        @Override
        public boolean setRectToRect(RectF src, RectF dst, ScaleToFit stf) {
            oops();
            addTaint(src.getTaint());
            addTaint(dst.getTaint());
            addTaint(stf.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_662787144 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_662787144;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.669 -0400", hash_original_method = "C52B6EDFC6037C1D437910558C897B0A", hash_generated_method = "235DD477465F155B9AA2571A41EA6972")
        @Override
        public boolean setPolyToPoly(float[] src, int srcIndex, float[] dst, int dstIndex,
                int pointCount) {
            oops();
            addTaint(src[0]);
            addTaint(srcIndex);
            addTaint(dst[0]);
            addTaint(dstIndex);
            addTaint(pointCount);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_768306995 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_768306995;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.669 -0400", hash_original_method = "B27E8869ACD25E403A7BF1344B888DC2", hash_generated_method = "2F3063A0D704231356B94FA9CBE20FD6")
        @Override
        public void setValues(float[] values) {
            oops();
            addTaint(values[0]);
            
            
        }

        
};
}

