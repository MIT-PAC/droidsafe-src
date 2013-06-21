package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.PrintWriter;

public class Matrix {
    public int native_instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.280 -0400", hash_original_method = "48ECB7BFD8634672F9ACB2AF6643F504", hash_generated_method = "B74B17C57C92799FAD74B4A80984C415")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Matrix() {
        native_instance = native_create(0);
        // ---------- Original Method ----------
        //native_instance = native_create(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.280 -0400", hash_original_method = "D46661DF78A0C4D4A11243C86DA400FE", hash_generated_method = "1E26DFBD7619A2866855982A95A8187B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Matrix(Matrix src) {
        dsTaint.addTaint(src.dsTaint);
        native_instance = native_create(src != null ? src.native_instance : 0);
        // ---------- Original Method ----------
        //native_instance = native_create(src != null ? src.native_instance : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.280 -0400", hash_original_method = "2841C18D225FF732B7B2ED26420E0D84", hash_generated_method = "0FCE83B3EAE3350B04781380F2F43C82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isIdentity() {
        boolean var41D9600FE0AA6A328771E92D92F0949C_1467026871 = (native_isIdentity(native_instance));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_isIdentity(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.280 -0400", hash_original_method = "79ACBDB454C166CD18416C9311332315", hash_generated_method = "A8A053706260C83A2E5EAD071102A975")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean rectStaysRect() {
        boolean var69C0BE3F50B3E19BAD90EEC6AC1AECE6_1797197108 = (native_rectStaysRect(native_instance));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_rectStaysRect(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.281 -0400", hash_original_method = "FFD47BD973F843026149EBC467C90A81", hash_generated_method = "5B6C626A0277054BE5BAA453E67DC922")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(Matrix src) {
        dsTaint.addTaint(src.dsTaint);
        {
            reset();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.281 -0400", hash_original_method = "EBE703D7B768F6481174C59F67FA3100", hash_generated_method = "D68D35EAA662516BDA6EBC2FE84C044A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        boolean varEF70408AB8E744DC202FEA719772EF59_1809988120 = (obj != null &&
               obj instanceof Matrix &&
               native_equals(native_instance, ((Matrix)obj).native_instance));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return obj != null &&
               //obj instanceof Matrix &&
               //native_equals(native_instance, ((Matrix)obj).native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.281 -0400", hash_original_method = "9189F6751C365D24C86F2BCF8029966A", hash_generated_method = "13B89CEA14A3F1070B2312BA6829A32E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reset() {
        native_reset(native_instance);
        // ---------- Original Method ----------
        //native_reset(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.281 -0400", hash_original_method = "4ABE67590F26D49A748F83E05B922D6E", hash_generated_method = "06EE9CE1ED4C480C5ABC20B0D13C4702")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTranslate(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        native_setTranslate(native_instance, dx, dy);
        // ---------- Original Method ----------
        //native_setTranslate(native_instance, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.282 -0400", hash_original_method = "82025887E943FB82D92D7647B1CDD6A4", hash_generated_method = "C67EFD065D2354CD8BD9D2EFD52148D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setScale(float sx, float sy, float px, float py) {
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
        native_setScale(native_instance, sx, sy, px, py);
        // ---------- Original Method ----------
        //native_setScale(native_instance, sx, sy, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.282 -0400", hash_original_method = "405981B5032E505B7ADC1B41B7C8A53D", hash_generated_method = "5B4ECE66AB5C467C25976801EA54A5ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setScale(float sx, float sy) {
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
        native_setScale(native_instance, sx, sy);
        // ---------- Original Method ----------
        //native_setScale(native_instance, sx, sy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.282 -0400", hash_original_method = "D24D75386C6A7BC2522B54B98C5D5387", hash_generated_method = "AFD236F427DA11EE86EA73EDC06FFF80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRotate(float degrees, float px, float py) {
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        dsTaint.addTaint(degrees);
        native_setRotate(native_instance, degrees, px, py);
        // ---------- Original Method ----------
        //native_setRotate(native_instance, degrees, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.283 -0400", hash_original_method = "43C7C737EFC6B994F84E937D3F6AAF6A", hash_generated_method = "E6239B6CAC5FF06CE92FC5BE1C0A5AB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRotate(float degrees) {
        dsTaint.addTaint(degrees);
        native_setRotate(native_instance, degrees);
        // ---------- Original Method ----------
        //native_setRotate(native_instance, degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.283 -0400", hash_original_method = "D62ED30BDB09648860C12F4C33D5D2F5", hash_generated_method = "34C3B9575805E341CE82194DE85F2EA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSinCos(float sinValue, float cosValue, float px, float py) {
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        dsTaint.addTaint(sinValue);
        dsTaint.addTaint(cosValue);
        native_setSinCos(native_instance, sinValue, cosValue, px, py);
        // ---------- Original Method ----------
        //native_setSinCos(native_instance, sinValue, cosValue, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.283 -0400", hash_original_method = "BF18F19C125E14226E94998F97574605", hash_generated_method = "B231B9252A91B875716EBBF5642762FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSinCos(float sinValue, float cosValue) {
        dsTaint.addTaint(sinValue);
        dsTaint.addTaint(cosValue);
        native_setSinCos(native_instance, sinValue, cosValue);
        // ---------- Original Method ----------
        //native_setSinCos(native_instance, sinValue, cosValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.283 -0400", hash_original_method = "D80C969913C1752CC5799F53218DDBF4", hash_generated_method = "3C73DC0EBADF3AAFDEEE9EEE443ABB7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSkew(float kx, float ky, float px, float py) {
        dsTaint.addTaint(kx);
        dsTaint.addTaint(ky);
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        native_setSkew(native_instance, kx, ky, px, py);
        // ---------- Original Method ----------
        //native_setSkew(native_instance, kx, ky, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.284 -0400", hash_original_method = "C307AACAFF9D5B23D5D1BDAB3825341D", hash_generated_method = "1A3179AF09A355CFE5DED45EB80E96E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSkew(float kx, float ky) {
        dsTaint.addTaint(kx);
        dsTaint.addTaint(ky);
        native_setSkew(native_instance, kx, ky);
        // ---------- Original Method ----------
        //native_setSkew(native_instance, kx, ky);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.284 -0400", hash_original_method = "56B420A7A69DF5D45E01C2D78C2CB3D0", hash_generated_method = "EC6351C42ACE2F42F9F8D477D6CB9870")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setConcat(Matrix a, Matrix b) {
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(a.dsTaint);
        boolean var00AB055AF6CDC86BED53096651485E3F_1968168411 = (native_setConcat(native_instance, a.native_instance,
                                b.native_instance));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_setConcat(native_instance, a.native_instance,
                                //b.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.286 -0400", hash_original_method = "F46062CE4D887C63D2B52C9E41EB2542", hash_generated_method = "599B7F0F36DDE2717E98D7B40CA08FE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean preTranslate(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        boolean varFBA5412443E9C5939494329C2C3880AE_2077529032 = (native_preTranslate(native_instance, dx, dy));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_preTranslate(native_instance, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.288 -0400", hash_original_method = "F666E80378D32154F2306C1184D58E89", hash_generated_method = "92FD3B1B329EE08617A34005BD1D5495")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean preScale(float sx, float sy, float px, float py) {
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
        boolean var0587D6DD30F56D53FD1ECF7FD9BDB408_1804961136 = (native_preScale(native_instance, sx, sy, px, py));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_preScale(native_instance, sx, sy, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.290 -0400", hash_original_method = "527D02A9319A5AC738DC088F9CE2DF28", hash_generated_method = "042DA6106E3A0EA81B3754341F1E69E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean preScale(float sx, float sy) {
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
        boolean varF995F72A92DA54AF3047937ACF3B2DE0_2081867955 = (native_preScale(native_instance, sx, sy));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_preScale(native_instance, sx, sy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.291 -0400", hash_original_method = "957DD3FA3C951D0A3D8ED4D51FD4EA92", hash_generated_method = "88F3E984D6EF3E1118FAC2C6B44C9056")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean preRotate(float degrees, float px, float py) {
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        dsTaint.addTaint(degrees);
        boolean var43D78BDDC1A8498586B3652DCB202B3B_595053910 = (native_preRotate(native_instance, degrees, px, py));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_preRotate(native_instance, degrees, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.291 -0400", hash_original_method = "07B5A36535E24ED5890CD9963836825B", hash_generated_method = "B0CD0F5449A09FF8A40283662FAB5C96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean preRotate(float degrees) {
        dsTaint.addTaint(degrees);
        boolean varA671CF6014E0E838A67A0F6BFE5843CA_990076987 = (native_preRotate(native_instance, degrees));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_preRotate(native_instance, degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.291 -0400", hash_original_method = "BCDAF6F2AF0C49197BF18278F335520E", hash_generated_method = "4331958ED5512C3BC9AAAC2F483CEEB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean preSkew(float kx, float ky, float px, float py) {
        dsTaint.addTaint(kx);
        dsTaint.addTaint(ky);
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        boolean var9FA7183618403646DB30A7FED3243975_2126213877 = (native_preSkew(native_instance, kx, ky, px, py));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_preSkew(native_instance, kx, ky, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.292 -0400", hash_original_method = "421231502648E6DE11C6B4476FBB4CB5", hash_generated_method = "1B65E713F2815FD5A715FE98E66FF807")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean preSkew(float kx, float ky) {
        dsTaint.addTaint(kx);
        dsTaint.addTaint(ky);
        boolean var66725046478C0AC12E1AB350EA8BA008_350325503 = (native_preSkew(native_instance, kx, ky));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_preSkew(native_instance, kx, ky);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.292 -0400", hash_original_method = "5465FF6869EFECF5658D42C575F011EC", hash_generated_method = "D5C87361C70CE9AF2989BD0B61E489F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean preConcat(Matrix other) {
        dsTaint.addTaint(other.dsTaint);
        boolean var9C6E024213CA5C2C78B882753FA15FB7_1561632568 = (native_preConcat(native_instance, other.native_instance));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_preConcat(native_instance, other.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.292 -0400", hash_original_method = "C79C9E0E75F4298B5359E17C43CD6BA7", hash_generated_method = "CC027FD4276EDE690F4CDB637426B528")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postTranslate(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        boolean var3EB89776C0E9BC26B5B7A93497AA6338_1077244111 = (native_postTranslate(native_instance, dx, dy));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_postTranslate(native_instance, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.292 -0400", hash_original_method = "158FF341C93FCD549341DC9F548B9A8C", hash_generated_method = "C6F3196A5053EE9B5BEE994D2AEDE56B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postScale(float sx, float sy, float px, float py) {
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
        boolean var811534EBBA0716ED15AB0EA06550D8C7_1628712456 = (native_postScale(native_instance, sx, sy, px, py));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_postScale(native_instance, sx, sy, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.293 -0400", hash_original_method = "2747525819A92C185D4EAB6F550FCCE3", hash_generated_method = "B3C9F4640A8FB1F305C1EF243AFA789A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postScale(float sx, float sy) {
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
        boolean varFEBE8AC1DB6F60F9C4B86E273DF2FC19_216869571 = (native_postScale(native_instance, sx, sy));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_postScale(native_instance, sx, sy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.293 -0400", hash_original_method = "C0257612FFE5AA7DE5163F0B0AB9F855", hash_generated_method = "C375BB6123F7C8D80A4371E2818E83E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postRotate(float degrees, float px, float py) {
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        dsTaint.addTaint(degrees);
        boolean varD7589C641F418AFED36121BAC654FC16_310286666 = (native_postRotate(native_instance, degrees, px, py));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_postRotate(native_instance, degrees, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.293 -0400", hash_original_method = "DB293F0AFDDF18839C895B754EC55E8F", hash_generated_method = "174133384C409F20BEED6B89DE030E85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postRotate(float degrees) {
        dsTaint.addTaint(degrees);
        boolean varF737BE5E5361946D147FCBB83A14D353_638663965 = (native_postRotate(native_instance, degrees));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_postRotate(native_instance, degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.293 -0400", hash_original_method = "57CA592FACEF6BD09A9AB3838326FC82", hash_generated_method = "4DE5A968955F5411312A58172622B304")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postSkew(float kx, float ky, float px, float py) {
        dsTaint.addTaint(kx);
        dsTaint.addTaint(ky);
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        boolean var9BA35FCF22EA355270F926957521F093_1443357180 = (native_postSkew(native_instance, kx, ky, px, py));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_postSkew(native_instance, kx, ky, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.294 -0400", hash_original_method = "0C899E968246F5B1F6489525332C2DAA", hash_generated_method = "11A666AC33F2EC43A1AD4C7655F68FC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postSkew(float kx, float ky) {
        dsTaint.addTaint(kx);
        dsTaint.addTaint(ky);
        boolean varC50A6D02F903D8010B24126CAB1D485B_1722050933 = (native_postSkew(native_instance, kx, ky));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_postSkew(native_instance, kx, ky);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.294 -0400", hash_original_method = "C3D775738E645A4A21D169FF31B7CB59", hash_generated_method = "CCB695C79BAFEADAC84F3222E0042F3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postConcat(Matrix other) {
        dsTaint.addTaint(other.dsTaint);
        boolean var883846EFB3F1C6159603731AEA1A59F1_419342143 = (native_postConcat(native_instance, other.native_instance));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_postConcat(native_instance, other.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.294 -0400", hash_original_method = "AEF4FE63E4C98EDC4913C94ED23B0046", hash_generated_method = "6DEC425F4AD0A717B020C2DAF86B69CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setRectToRect(RectF src, RectF dst, ScaleToFit stf) {
        dsTaint.addTaint(stf.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        boolean varF7E361575251D13BE7FA91222DB37707_1168566007 = (native_setRectToRect(native_instance, src, dst, stf.nativeInt));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.295 -0400", hash_original_method = "81F71DB7C56D04B1A3A5BEE1ABC9313F", hash_generated_method = "F9F0F1CC9D60DFEE81FEC5B1FE84BEF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setPolyToPoly(float[] src, int srcIndex,
                                 float[] dst, int dstIndex,
                                 int pointCount) {
        dsTaint.addTaint(dstIndex);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(srcIndex);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(pointCount);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        boolean var1B38DC69F9C1AE3BEDB6B044F3F544DB_58499957 = (native_setPolyToPoly(native_instance, src, srcIndex,
                                    dst, dstIndex, pointCount));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (pointCount > 4) {
            //throw new IllegalArgumentException();
        //}
        //checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        //return native_setPolyToPoly(native_instance, src, srcIndex,
                                    //dst, dstIndex, pointCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.295 -0400", hash_original_method = "E353C96DCEC77FF20275C37C83D4D335", hash_generated_method = "55A107C4E589AEB405DAF2F2F0D9E8DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean invert(Matrix inverse) {
        dsTaint.addTaint(inverse.dsTaint);
        boolean var264FAB0D1776C7EB10CAD495521DE5AA_839854937 = (native_invert(native_instance, inverse.native_instance));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_invert(native_instance, inverse.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.296 -0400", hash_original_method = "B69F96FB84D81823B3FB4BA4E2DA7623", hash_generated_method = "BD70975437B849EC7C7E4282418F69EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void mapPoints(float[] dst, int dstIndex, float[] src, int srcIndex,
                          int pointCount) {
        dsTaint.addTaint(dstIndex);
        dsTaint.addTaint(srcIndex);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(pointCount);
        checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         pointCount, true);
        // ---------- Original Method ----------
        //checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        //native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         //pointCount, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.296 -0400", hash_original_method = "E01BB240D3A8AF79E8CA96ADF8A93B02", hash_generated_method = "546A25158EF096521DD9D4637DAF3D00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void mapVectors(float[] dst, int dstIndex, float[] src, int srcIndex,
                          int vectorCount) {
        dsTaint.addTaint(dstIndex);
        dsTaint.addTaint(vectorCount);
        dsTaint.addTaint(srcIndex);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(dst[0]);
        checkPointArrays(src, srcIndex, dst, dstIndex, vectorCount);
        native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         vectorCount, false);
        // ---------- Original Method ----------
        //checkPointArrays(src, srcIndex, dst, dstIndex, vectorCount);
        //native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         //vectorCount, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.296 -0400", hash_original_method = "9EB430E2EA11CE20A0728D1BC77C5684", hash_generated_method = "49D07842AD989E59C4E7B30756D0D8FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void mapPoints(float[] dst, float[] src) {
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(dst[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        mapPoints(dst, 0, src, 0, dst.length >> 1);
        // ---------- Original Method ----------
        //if (dst.length != src.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //mapPoints(dst, 0, src, 0, dst.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.297 -0400", hash_original_method = "88563DD2DA99100452A3E727EF621773", hash_generated_method = "9F25DD73B7D64D846897DC9D83A58917")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void mapVectors(float[] dst, float[] src) {
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(dst[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        mapVectors(dst, 0, src, 0, dst.length >> 1);
        // ---------- Original Method ----------
        //if (dst.length != src.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //mapVectors(dst, 0, src, 0, dst.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.297 -0400", hash_original_method = "B621EF9C19B6D800D2C8FEF0AEB101A2", hash_generated_method = "58BFA2B5A15F24A53759FA284B080F81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void mapPoints(float[] pts) {
        dsTaint.addTaint(pts[0]);
        mapPoints(pts, 0, pts, 0, pts.length >> 1);
        // ---------- Original Method ----------
        //mapPoints(pts, 0, pts, 0, pts.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.297 -0400", hash_original_method = "35DF34CB8A8DD69940AA879A74BDB59C", hash_generated_method = "6CBF8D5514D022B3FDAEDB8EDF11EC14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void mapVectors(float[] vecs) {
        dsTaint.addTaint(vecs[0]);
        mapVectors(vecs, 0, vecs, 0, vecs.length >> 1);
        // ---------- Original Method ----------
        //mapVectors(vecs, 0, vecs, 0, vecs.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.297 -0400", hash_original_method = "ED0A1CF18B9884BD196B57BA9AB3D4D4", hash_generated_method = "3C3369EE4F24539BFF31353D6359610E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean mapRect(RectF dst, RectF src) {
        dsTaint.addTaint(src.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        boolean var0555BDA0682728737A8E84AE5B37B33A_132962475 = (native_mapRect(native_instance, dst, src));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (dst == null || src == null) {
            //throw new NullPointerException();
        //}
        //return native_mapRect(native_instance, dst, src);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.306 -0400", hash_original_method = "E67F1023A30815D48967A785552726F7", hash_generated_method = "164FDA1E5502E253FCBAEF0CF021FE1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean mapRect(RectF rect) {
        dsTaint.addTaint(rect.dsTaint);
        boolean var4F206D16D71EEBE65AA2A3210698955A_884358950 = (mapRect(rect, rect));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mapRect(rect, rect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.306 -0400", hash_original_method = "10B4872CA843B84CAABA7086757B6AA8", hash_generated_method = "D668A9CEA4423ECFE95144D608CB0C5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float mapRadius(float radius) {
        dsTaint.addTaint(radius);
        float varF364E7BDEF648809DE6AA5B35C7E7D24_758529581 = (native_mapRadius(native_instance, radius));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return native_mapRadius(native_instance, radius);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.307 -0400", hash_original_method = "E9A30A056D591CF546BBF753077E713D", hash_generated_method = "73FDC8CC549DBA212C1D2737DDF5B8C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getValues(float[] values) {
        dsTaint.addTaint(values[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        native_getValues(native_instance, values);
        // ---------- Original Method ----------
        //if (values.length < 9) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_getValues(native_instance, values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.307 -0400", hash_original_method = "A66AD9F1BFFA0584B04714786DBE2DC1", hash_generated_method = "E5A903153D37E9D693551ABF73DD2F8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValues(float[] values) {
        dsTaint.addTaint(values[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        native_setValues(native_instance, values);
        // ---------- Original Method ----------
        //if (values.length < 9) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_setValues(native_instance, values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.307 -0400", hash_original_method = "790F3515038F276DF7A46D3A4B29621A", hash_generated_method = "A4E7758FA74CA899F94B3DCF73AD2B17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(64);
        sb.append("Matrix{");
        toShortString(sb);
        sb.append('}');
        String var806458D832AB974D230FEE4CBBDBD390_1800831816 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //sb.append("Matrix{");
        //toShortString(sb);
        //sb.append('}');
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.308 -0400", hash_original_method = "9DDD7B6FB851EDEB6218261EF1A63117", hash_generated_method = "C48289A44980C55D8DC6FA7F2C97CC66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toShortString() {
        StringBuilder sb;
        sb = new StringBuilder(64);
        toShortString(sb);
        String var806458D832AB974D230FEE4CBBDBD390_2119271756 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //toShortString(sb);
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.308 -0400", hash_original_method = "F87637A67413F385021CCAE210B2BF25", hash_generated_method = "9020DEAF29AE47DF7B1336FF1223AA42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void toShortString(StringBuilder sb) {
        dsTaint.addTaint(sb.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.309 -0400", hash_original_method = "8B9E48E860ED3F94388D797BB2BE65D6", hash_generated_method = "DBE182F0251C35BC1B6D916195143CA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void printShortString(PrintWriter pw) {
        dsTaint.addTaint(pw.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.311 -0400", hash_original_method = "29B0241D689448242FFD9C9D7DE21563", hash_generated_method = "15CC57087C95B7D9B74DEAC06F3C409E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() throws Throwable {
        finalizer(native_instance);
        // ---------- Original Method ----------
        //finalizer(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.312 -0400", hash_original_method = "2C87051DCC7759A2331039EEC0434516", hash_generated_method = "5EA7A8DCE7B85A9EE51B5E01BCF0378D")
    @DSModeled(DSC.SAFE)
    final int ni() {
        return dsTaint.getTaintInt();
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

    
    public static final int MSCALE_X = 0;
    public static final int MSKEW_X  = 1;
    public static final int MTRANS_X = 2;
    public static final int MSKEW_Y  = 3;
    public static final int MSCALE_Y = 4;
    public static final int MTRANS_Y = 5;
    public static final int MPERSP_0 = 6;
    public static final int MPERSP_1 = 7;
    public static final int MPERSP_2 = 8;
    public static Matrix IDENTITY_MATRIX = new Matrix() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.324 -0400", hash_original_method = "D86A271A87ADAB5FF76372ECECE2FE9E", hash_generated_method = "4201570C8F06C2B0ECEEAE002E7D4F0B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void oops() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Matrix can not be modified");
            // ---------- Original Method ----------
            //throw new IllegalStateException("Matrix can not be modified");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.324 -0400", hash_original_method = "C410E535C65C1A60A6BB6D0124640DFB", hash_generated_method = "012E0A50BBB7D62714F5DBCF3CBE5E71")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void set(Matrix src) {
            dsTaint.addTaint(src.dsTaint);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.324 -0400", hash_original_method = "443FC1BF2CCB476E40EFBA39CED3C856", hash_generated_method = "7E2B188BDA8EA2E28D08CCB551CDF97E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void reset() {
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.325 -0400", hash_original_method = "6A3715A1843CB69CD425569E9A9BF685", hash_generated_method = "B29467B0DB17DD18654EE699AFCA3E8F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setTranslate(float dx, float dy) {
            dsTaint.addTaint(dx);
            dsTaint.addTaint(dy);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.325 -0400", hash_original_method = "AC062ADEBF9F892A7634B382327DE471", hash_generated_method = "BE945985A2DD23094D550212BD32A07E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setScale(float sx, float sy, float px, float py) {
            dsTaint.addTaint(px);
            dsTaint.addTaint(py);
            dsTaint.addTaint(sy);
            dsTaint.addTaint(sx);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.325 -0400", hash_original_method = "AF405FD460DAE15CE8A800CAFF9D70A1", hash_generated_method = "8AD0FD557C17C0388FDB1A3605BB9500")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setScale(float sx, float sy) {
            dsTaint.addTaint(sy);
            dsTaint.addTaint(sx);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.325 -0400", hash_original_method = "3E711272F4AAA813A9DEF73D8BED4F52", hash_generated_method = "4FC897243A1B2AB2EAAD5BA429A4D497")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setRotate(float degrees, float px, float py) {
            dsTaint.addTaint(px);
            dsTaint.addTaint(py);
            dsTaint.addTaint(degrees);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.326 -0400", hash_original_method = "F01F93D85A48029B9DBAA6CF7686F3EA", hash_generated_method = "89816DCCD8219E149159151B0C344B21")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setRotate(float degrees) {
            dsTaint.addTaint(degrees);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.326 -0400", hash_original_method = "5A520A50E60DD4F6E2005CD4CF7B0F44", hash_generated_method = "7C771C672D47F3D8968E9DFB77326824")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setSinCos(float sinValue, float cosValue, float px, float py) {
            dsTaint.addTaint(px);
            dsTaint.addTaint(py);
            dsTaint.addTaint(sinValue);
            dsTaint.addTaint(cosValue);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.326 -0400", hash_original_method = "6CBCFE4FC0C45FD06C24211CDA6ABA51", hash_generated_method = "22B9F5A85190970DB6898998F23DF388")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setSinCos(float sinValue, float cosValue) {
            dsTaint.addTaint(sinValue);
            dsTaint.addTaint(cosValue);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.327 -0400", hash_original_method = "B878EA27D37D77B41AE6B8B4C49D9BE3", hash_generated_method = "6ACCC793D10F3EA7F40D6F1F8F359636")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setSkew(float kx, float ky, float px, float py) {
            dsTaint.addTaint(kx);
            dsTaint.addTaint(ky);
            dsTaint.addTaint(px);
            dsTaint.addTaint(py);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.327 -0400", hash_original_method = "441EC3AFBA9E76FA6888191DBAA13F89", hash_generated_method = "14C2637AC847E06788B9B5FF3E13C49A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setSkew(float kx, float ky) {
            dsTaint.addTaint(kx);
            dsTaint.addTaint(ky);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.327 -0400", hash_original_method = "50EA0A2B3500CD5FD1B4286CA064C541", hash_generated_method = "88A0096A1E8D5201EA05A89D2FE77440")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean setConcat(Matrix a, Matrix b) {
            dsTaint.addTaint(b.dsTaint);
            dsTaint.addTaint(a.dsTaint);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.327 -0400", hash_original_method = "8B761AD72B3BAD4BF641E1F91F039D8C", hash_generated_method = "BF7DEC4A5D20A7F2CD37E33AC9EE06F7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean preTranslate(float dx, float dy) {
            dsTaint.addTaint(dx);
            dsTaint.addTaint(dy);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.327 -0400", hash_original_method = "473ADBEECE4018B92E8542D396E4DD17", hash_generated_method = "CC3622942A2EF0CB770C47FE7ECF700B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean preScale(float sx, float sy, float px, float py) {
            dsTaint.addTaint(px);
            dsTaint.addTaint(py);
            dsTaint.addTaint(sy);
            dsTaint.addTaint(sx);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.328 -0400", hash_original_method = "37ED2D59309BF518A3CB72818CA587BF", hash_generated_method = "96796C46BB956464E2B98CBF3C78E443")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean preScale(float sx, float sy) {
            dsTaint.addTaint(sy);
            dsTaint.addTaint(sx);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.328 -0400", hash_original_method = "7A653600E1581A75FED23AACF91B4370", hash_generated_method = "B57D4B7545780F8E9AD86F91AB5C37AC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean preRotate(float degrees, float px, float py) {
            dsTaint.addTaint(px);
            dsTaint.addTaint(py);
            dsTaint.addTaint(degrees);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.337 -0400", hash_original_method = "347A996F82D645DD0C11070D01283F26", hash_generated_method = "2E887B898218C96DA813C1F4BAEF5E20")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean preRotate(float degrees) {
            dsTaint.addTaint(degrees);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.337 -0400", hash_original_method = "86AA81B34A821E61BE2CE6C1DA88EBEE", hash_generated_method = "79A9A92329E597B27C838972BB2FE3D1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean preSkew(float kx, float ky, float px, float py) {
            dsTaint.addTaint(kx);
            dsTaint.addTaint(ky);
            dsTaint.addTaint(px);
            dsTaint.addTaint(py);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.338 -0400", hash_original_method = "80A2F0F38B1A8CCCD5B8FA2F9D808882", hash_generated_method = "F4883B3FFA0982CF8F14FFEF1EF97634")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean preSkew(float kx, float ky) {
            dsTaint.addTaint(kx);
            dsTaint.addTaint(ky);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.339 -0400", hash_original_method = "F05A155D64A4D5B863754CCB7582B708", hash_generated_method = "68896B95E76667BC88F15E8B1FC5D423")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean preConcat(Matrix other) {
            dsTaint.addTaint(other.dsTaint);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.340 -0400", hash_original_method = "A5A8ACF8FB38AA4A1ACBCA05F5D53B7C", hash_generated_method = "AB699DA228CD4E1FA0B3210287828800")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean postTranslate(float dx, float dy) {
            dsTaint.addTaint(dx);
            dsTaint.addTaint(dy);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.340 -0400", hash_original_method = "5FFFE76567D7476BFB531E99C9813921", hash_generated_method = "47E4A92FCFEC1EAFECDD3496B9073259")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean postScale(float sx, float sy, float px, float py) {
            dsTaint.addTaint(px);
            dsTaint.addTaint(py);
            dsTaint.addTaint(sy);
            dsTaint.addTaint(sx);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.340 -0400", hash_original_method = "E4B7C4403CB589BACE12330A86A597BD", hash_generated_method = "81550AADF5867D9E637F7358FA086064")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean postScale(float sx, float sy) {
            dsTaint.addTaint(sy);
            dsTaint.addTaint(sx);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.340 -0400", hash_original_method = "F7844EE0997FB4C2B11CAE5A2CDFB352", hash_generated_method = "C37C213C33BC41A3E59F573EAC1EBB12")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean postRotate(float degrees, float px, float py) {
            dsTaint.addTaint(px);
            dsTaint.addTaint(py);
            dsTaint.addTaint(degrees);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.341 -0400", hash_original_method = "CB7CBDBE72FFE751D482DA02B5EB0AEA", hash_generated_method = "EE20B9F4459B84C03A3804303D3547DF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean postRotate(float degrees) {
            dsTaint.addTaint(degrees);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.341 -0400", hash_original_method = "52E3E853451ABC08EB5927D4E1CFA4A1", hash_generated_method = "1E7E3FD0C0FDBBF04936F9A7304F5F66")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean postSkew(float kx, float ky, float px, float py) {
            dsTaint.addTaint(kx);
            dsTaint.addTaint(ky);
            dsTaint.addTaint(px);
            dsTaint.addTaint(py);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.342 -0400", hash_original_method = "1F83E70D046D2757A9534CC79FE46FF5", hash_generated_method = "A1B0EA6C6A9DBECF32D419499F00DCDF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean postSkew(float kx, float ky) {
            dsTaint.addTaint(kx);
            dsTaint.addTaint(ky);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.342 -0400", hash_original_method = "CC467C10DA80073E550955225E80ADE5", hash_generated_method = "AEE3EAE64E91C25363D7363882EBB3E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean postConcat(Matrix other) {
            dsTaint.addTaint(other.dsTaint);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.343 -0400", hash_original_method = "96979FDC6AFE468E4307B6E9353A9437", hash_generated_method = "E1BFA954FED6D3A9C421A5BE2327DEB4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean setRectToRect(RectF src, RectF dst, ScaleToFit stf) {
            dsTaint.addTaint(stf.dsTaint);
            dsTaint.addTaint(dst.dsTaint);
            dsTaint.addTaint(src.dsTaint);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.344 -0400", hash_original_method = "C52B6EDFC6037C1D437910558C897B0A", hash_generated_method = "A259905594A1CBFACEEB7C3B611606B2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean setPolyToPoly(float[] src, int srcIndex, float[] dst, int dstIndex,
                int pointCount) {
            dsTaint.addTaint(dstIndex);
            dsTaint.addTaint(dst[0]);
            dsTaint.addTaint(srcIndex);
            dsTaint.addTaint(src[0]);
            dsTaint.addTaint(pointCount);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.344 -0400", hash_original_method = "B27E8869ACD25E403A7BF1344B888DC2", hash_generated_method = "5B3DC92C5384E34924521BEA4F17912F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setValues(float[] values) {
            dsTaint.addTaint(values[0]);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
}; //Transformed anonymous class
}

