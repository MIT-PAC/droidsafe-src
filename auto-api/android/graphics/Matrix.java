package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.PrintWriter;

public class Matrix {
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.205 -0400", hash_original_method = "D86A271A87ADAB5FF76372ECECE2FE9E", hash_generated_method = "8342849EDF58A7A4E0585052A17EC1D5")
        @DSModeled(DSC.SAFE)
         void oops() {
            throw new IllegalStateException("Matrix can not be modified");
            // ---------- Original Method ----------
            //throw new IllegalStateException("Matrix can not be modified");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.205 -0400", hash_original_method = "C410E535C65C1A60A6BB6D0124640DFB", hash_generated_method = "6CCFE0453E78B9276F9788ECB85CA0EE")
        @DSModeled(DSC.SAFE)
        @Override
        public void set(Matrix src) {
            dsTaint.addTaint(src.dsTaint);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.205 -0400", hash_original_method = "443FC1BF2CCB476E40EFBA39CED3C856", hash_generated_method = "23A4CABA8B42D7C2C430B08DC3792E01")
        @DSModeled(DSC.SAFE)
        @Override
        public void reset() {
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.205 -0400", hash_original_method = "6A3715A1843CB69CD425569E9A9BF685", hash_generated_method = "58C20A8631DE997DBA5504BC32703B35")
        @DSModeled(DSC.SAFE)
        @Override
        public void setTranslate(float dx, float dy) {
            dsTaint.addTaint(dx);
            dsTaint.addTaint(dy);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.205 -0400", hash_original_method = "AC062ADEBF9F892A7634B382327DE471", hash_generated_method = "39B5C61150459E8E327EE987AD4F1E23")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.205 -0400", hash_original_method = "AF405FD460DAE15CE8A800CAFF9D70A1", hash_generated_method = "F98F961C8A1AB63DA8D4C4B4F8E60CF1")
        @DSModeled(DSC.SAFE)
        @Override
        public void setScale(float sx, float sy) {
            dsTaint.addTaint(sy);
            dsTaint.addTaint(sx);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.205 -0400", hash_original_method = "3E711272F4AAA813A9DEF73D8BED4F52", hash_generated_method = "38D439C4AD73AA62508575948166CD1A")
        @DSModeled(DSC.SAFE)
        @Override
        public void setRotate(float degrees, float px, float py) {
            dsTaint.addTaint(px);
            dsTaint.addTaint(py);
            dsTaint.addTaint(degrees);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.206 -0400", hash_original_method = "F01F93D85A48029B9DBAA6CF7686F3EA", hash_generated_method = "51BFF367FC2E8E5E61C404CF35BA51AB")
        @DSModeled(DSC.SAFE)
        @Override
        public void setRotate(float degrees) {
            dsTaint.addTaint(degrees);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.206 -0400", hash_original_method = "5A520A50E60DD4F6E2005CD4CF7B0F44", hash_generated_method = "2965ADADBAB6C250876EA2AA7F627C99")
        @DSModeled(DSC.SAFE)
        @Override
        public void setSinCos(float sinValue, float cosValue, float px, float py) {
            dsTaint.addTaint(px);
            dsTaint.addTaint(sinValue);
            dsTaint.addTaint(py);
            dsTaint.addTaint(cosValue);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.206 -0400", hash_original_method = "6CBCFE4FC0C45FD06C24211CDA6ABA51", hash_generated_method = "A926FD74EF6327CF0C0B61E2E9A01F67")
        @DSModeled(DSC.SAFE)
        @Override
        public void setSinCos(float sinValue, float cosValue) {
            dsTaint.addTaint(sinValue);
            dsTaint.addTaint(cosValue);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.206 -0400", hash_original_method = "B878EA27D37D77B41AE6B8B4C49D9BE3", hash_generated_method = "84A84F41947A9790B06A8DA0BCBCD1AB")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.206 -0400", hash_original_method = "441EC3AFBA9E76FA6888191DBAA13F89", hash_generated_method = "EEB7A30EA7D12DD819CC1F57E4DE660F")
        @DSModeled(DSC.SAFE)
        @Override
        public void setSkew(float kx, float ky) {
            dsTaint.addTaint(kx);
            dsTaint.addTaint(ky);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.206 -0400", hash_original_method = "50EA0A2B3500CD5FD1B4286CA064C541", hash_generated_method = "BDAAD0328696F5589082BFA11898BE86")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.206 -0400", hash_original_method = "8B761AD72B3BAD4BF641E1F91F039D8C", hash_generated_method = "4FAF73D8520AF17A54065C1826643DC0")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.206 -0400", hash_original_method = "473ADBEECE4018B92E8542D396E4DD17", hash_generated_method = "9F6A16C4C40E1E739EE0DB96FDA8015F")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.206 -0400", hash_original_method = "37ED2D59309BF518A3CB72818CA587BF", hash_generated_method = "007AA1ACFF81C97861C888E4850233BD")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.207 -0400", hash_original_method = "7A653600E1581A75FED23AACF91B4370", hash_generated_method = "134FED2AF1908D2578E3FD2BA71B6C35")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.207 -0400", hash_original_method = "347A996F82D645DD0C11070D01283F26", hash_generated_method = "17C4FE581E6AFEF36D5F3DB78A8E96B5")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean preRotate(float degrees) {
            dsTaint.addTaint(degrees);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.207 -0400", hash_original_method = "86AA81B34A821E61BE2CE6C1DA88EBEE", hash_generated_method = "CF0E434B67983AC5139CEA8CDD2A341C")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.207 -0400", hash_original_method = "80A2F0F38B1A8CCCD5B8FA2F9D808882", hash_generated_method = "7656FE683CA7701179C9A841EE20C268")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.207 -0400", hash_original_method = "F05A155D64A4D5B863754CCB7582B708", hash_generated_method = "7F1843EA044299F0B87E9DE73FF0ABA9")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean preConcat(Matrix other) {
            dsTaint.addTaint(other.dsTaint);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.207 -0400", hash_original_method = "A5A8ACF8FB38AA4A1ACBCA05F5D53B7C", hash_generated_method = "4718F24B7B06B23121AF4FDC5E799885")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.207 -0400", hash_original_method = "5FFFE76567D7476BFB531E99C9813921", hash_generated_method = "0AB4630AC1ECD8CCD3139C45D159295E")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.207 -0400", hash_original_method = "E4B7C4403CB589BACE12330A86A597BD", hash_generated_method = "3C32ACB1E96AA0839970A949393EB95F")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.208 -0400", hash_original_method = "F7844EE0997FB4C2B11CAE5A2CDFB352", hash_generated_method = "7372F2785A9FBAD4323D7F7CFEAF8570")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.208 -0400", hash_original_method = "CB7CBDBE72FFE751D482DA02B5EB0AEA", hash_generated_method = "3251108869567ACD6243CA402D37DB42")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean postRotate(float degrees) {
            dsTaint.addTaint(degrees);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.208 -0400", hash_original_method = "52E3E853451ABC08EB5927D4E1CFA4A1", hash_generated_method = "2662D8CD7BFA22EAC0C9D7F64620F2BE")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.208 -0400", hash_original_method = "1F83E70D046D2757A9534CC79FE46FF5", hash_generated_method = "48BAEBA49537FAB0AA72D63BDB548A5D")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.208 -0400", hash_original_method = "CC467C10DA80073E550955225E80ADE5", hash_generated_method = "60F9C295D041EA8E5A964304D6277F30")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean postConcat(Matrix other) {
            dsTaint.addTaint(other.dsTaint);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.208 -0400", hash_original_method = "96979FDC6AFE468E4307B6E9353A9437", hash_generated_method = "06452FEC539D18EEB78F44D5CA15B7C0")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean setRectToRect(RectF src, RectF dst, ScaleToFit stf) {
            dsTaint.addTaint(stf.dsTaint);
            dsTaint.addTaint(src.dsTaint);
            dsTaint.addTaint(dst.dsTaint);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.208 -0400", hash_original_method = "C52B6EDFC6037C1D437910558C897B0A", hash_generated_method = "891FFF8D0352D95F3F3542946ACF379B")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean setPolyToPoly(float[] src, int srcIndex, float[] dst, int dstIndex,
                int pointCount) {
            dsTaint.addTaint(dstIndex);
            dsTaint.addTaint(src);
            dsTaint.addTaint(srcIndex);
            dsTaint.addTaint(dst);
            dsTaint.addTaint(pointCount);
            oops();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //oops();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.208 -0400", hash_original_method = "B27E8869ACD25E403A7BF1344B888DC2", hash_generated_method = "5A8E7EA7D1A5BC0E145B96692CD88951")
        @DSModeled(DSC.SAFE)
        @Override
        public void setValues(float[] values) {
            dsTaint.addTaint(values);
            oops();
            // ---------- Original Method ----------
            //oops();
        }

        
}; //Transformed anonymous class
    public int native_instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.208 -0400", hash_original_method = "48ECB7BFD8634672F9ACB2AF6643F504", hash_generated_method = "53EAF6B82DEF36597560B0B803505DD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Matrix() {
        native_instance = native_create(0);
        // ---------- Original Method ----------
        //native_instance = native_create(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.209 -0400", hash_original_method = "D46661DF78A0C4D4A11243C86DA400FE", hash_generated_method = "B6B3363B8D0E0BDBFE270765537DD598")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Matrix(Matrix src) {
        dsTaint.addTaint(src.dsTaint);
        native_instance = native_create(src != null ? src.native_instance : 0);
        // ---------- Original Method ----------
        //native_instance = native_create(src != null ? src.native_instance : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.209 -0400", hash_original_method = "2841C18D225FF732B7B2ED26420E0D84", hash_generated_method = "D03528202E301FF00EACCCC988E7A9B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isIdentity() {
        boolean var41D9600FE0AA6A328771E92D92F0949C_2118261900 = (native_isIdentity(native_instance));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_isIdentity(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.209 -0400", hash_original_method = "79ACBDB454C166CD18416C9311332315", hash_generated_method = "BFA5DF71B85EC488EB6917B2D6978AF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean rectStaysRect() {
        boolean var69C0BE3F50B3E19BAD90EEC6AC1AECE6_66190966 = (native_rectStaysRect(native_instance));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_rectStaysRect(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.209 -0400", hash_original_method = "FFD47BD973F843026149EBC467C90A81", hash_generated_method = "985DC43161F728A8CD604E19B079C265")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.209 -0400", hash_original_method = "EBE703D7B768F6481174C59F67FA3100", hash_generated_method = "FC2BD63E4C3F5A5703D46E68AD8C7AFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        boolean varEF70408AB8E744DC202FEA719772EF59_775197125 = (obj != null &&
               obj instanceof Matrix &&
               native_equals(native_instance, ((Matrix)obj).native_instance));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return obj != null &&
               //obj instanceof Matrix &&
               //native_equals(native_instance, ((Matrix)obj).native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.209 -0400", hash_original_method = "9189F6751C365D24C86F2BCF8029966A", hash_generated_method = "26AE88C7FCAA92AD79DE089E1C75073A")
    @DSModeled(DSC.SAFE)
    public void reset() {
        native_reset(native_instance);
        // ---------- Original Method ----------
        //native_reset(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.209 -0400", hash_original_method = "4ABE67590F26D49A748F83E05B922D6E", hash_generated_method = "0CC425C230AFB6D23B96358C0FAB83FE")
    @DSModeled(DSC.SAFE)
    public void setTranslate(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        native_setTranslate(native_instance, dx, dy);
        // ---------- Original Method ----------
        //native_setTranslate(native_instance, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.209 -0400", hash_original_method = "82025887E943FB82D92D7647B1CDD6A4", hash_generated_method = "F50E860C2BEBCC8E98CCCCB63DA78E77")
    @DSModeled(DSC.SAFE)
    public void setScale(float sx, float sy, float px, float py) {
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
        native_setScale(native_instance, sx, sy, px, py);
        // ---------- Original Method ----------
        //native_setScale(native_instance, sx, sy, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.210 -0400", hash_original_method = "405981B5032E505B7ADC1B41B7C8A53D", hash_generated_method = "98D357323BF0DDD6C2BE27BC9DB28610")
    @DSModeled(DSC.SAFE)
    public void setScale(float sx, float sy) {
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
        native_setScale(native_instance, sx, sy);
        // ---------- Original Method ----------
        //native_setScale(native_instance, sx, sy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.210 -0400", hash_original_method = "D24D75386C6A7BC2522B54B98C5D5387", hash_generated_method = "A8ACCF24AE956153A9F355B5A700CD3B")
    @DSModeled(DSC.SAFE)
    public void setRotate(float degrees, float px, float py) {
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        dsTaint.addTaint(degrees);
        native_setRotate(native_instance, degrees, px, py);
        // ---------- Original Method ----------
        //native_setRotate(native_instance, degrees, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.210 -0400", hash_original_method = "43C7C737EFC6B994F84E937D3F6AAF6A", hash_generated_method = "2D82A29D4BB92B01DFBF6F28BD9402F8")
    @DSModeled(DSC.SAFE)
    public void setRotate(float degrees) {
        dsTaint.addTaint(degrees);
        native_setRotate(native_instance, degrees);
        // ---------- Original Method ----------
        //native_setRotate(native_instance, degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.210 -0400", hash_original_method = "D62ED30BDB09648860C12F4C33D5D2F5", hash_generated_method = "E55B1E0E73AD1A7C5A15F3074F52BF1F")
    @DSModeled(DSC.SAFE)
    public void setSinCos(float sinValue, float cosValue, float px, float py) {
        dsTaint.addTaint(px);
        dsTaint.addTaint(sinValue);
        dsTaint.addTaint(py);
        dsTaint.addTaint(cosValue);
        native_setSinCos(native_instance, sinValue, cosValue, px, py);
        // ---------- Original Method ----------
        //native_setSinCos(native_instance, sinValue, cosValue, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.210 -0400", hash_original_method = "BF18F19C125E14226E94998F97574605", hash_generated_method = "F3A5211EED1D557FBD7980C39D24DC2A")
    @DSModeled(DSC.SAFE)
    public void setSinCos(float sinValue, float cosValue) {
        dsTaint.addTaint(sinValue);
        dsTaint.addTaint(cosValue);
        native_setSinCos(native_instance, sinValue, cosValue);
        // ---------- Original Method ----------
        //native_setSinCos(native_instance, sinValue, cosValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.210 -0400", hash_original_method = "D80C969913C1752CC5799F53218DDBF4", hash_generated_method = "03EE7466C153B6BA58D1D14A430BB8DB")
    @DSModeled(DSC.SAFE)
    public void setSkew(float kx, float ky, float px, float py) {
        dsTaint.addTaint(kx);
        dsTaint.addTaint(ky);
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        native_setSkew(native_instance, kx, ky, px, py);
        // ---------- Original Method ----------
        //native_setSkew(native_instance, kx, ky, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.210 -0400", hash_original_method = "C307AACAFF9D5B23D5D1BDAB3825341D", hash_generated_method = "F090785BEF4B9470F2E257DDFA5FDD50")
    @DSModeled(DSC.SAFE)
    public void setSkew(float kx, float ky) {
        dsTaint.addTaint(kx);
        dsTaint.addTaint(ky);
        native_setSkew(native_instance, kx, ky);
        // ---------- Original Method ----------
        //native_setSkew(native_instance, kx, ky);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.210 -0400", hash_original_method = "56B420A7A69DF5D45E01C2D78C2CB3D0", hash_generated_method = "786DBA2815481CE873639DAE0469B29E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setConcat(Matrix a, Matrix b) {
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(a.dsTaint);
        boolean var00AB055AF6CDC86BED53096651485E3F_1929858268 = (native_setConcat(native_instance, a.native_instance,
                                b.native_instance));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_setConcat(native_instance, a.native_instance,
                                //b.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.210 -0400", hash_original_method = "F46062CE4D887C63D2B52C9E41EB2542", hash_generated_method = "E575D808440C5F787A86635C757E357E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean preTranslate(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        boolean varFBA5412443E9C5939494329C2C3880AE_534985761 = (native_preTranslate(native_instance, dx, dy));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_preTranslate(native_instance, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.211 -0400", hash_original_method = "F666E80378D32154F2306C1184D58E89", hash_generated_method = "4C79DA89754799530B1F5039DFC33B60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean preScale(float sx, float sy, float px, float py) {
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
        boolean var0587D6DD30F56D53FD1ECF7FD9BDB408_1937393510 = (native_preScale(native_instance, sx, sy, px, py));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_preScale(native_instance, sx, sy, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.211 -0400", hash_original_method = "527D02A9319A5AC738DC088F9CE2DF28", hash_generated_method = "912A096244413F68D803E9268355EABB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean preScale(float sx, float sy) {
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
        boolean varF995F72A92DA54AF3047937ACF3B2DE0_470824766 = (native_preScale(native_instance, sx, sy));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_preScale(native_instance, sx, sy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.211 -0400", hash_original_method = "957DD3FA3C951D0A3D8ED4D51FD4EA92", hash_generated_method = "692CAA9C497F1EBD835372C7C9081DA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean preRotate(float degrees, float px, float py) {
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        dsTaint.addTaint(degrees);
        boolean var43D78BDDC1A8498586B3652DCB202B3B_1897563682 = (native_preRotate(native_instance, degrees, px, py));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_preRotate(native_instance, degrees, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.211 -0400", hash_original_method = "07B5A36535E24ED5890CD9963836825B", hash_generated_method = "51D9852F4736908B620D81E9E0F6A4DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean preRotate(float degrees) {
        dsTaint.addTaint(degrees);
        boolean varA671CF6014E0E838A67A0F6BFE5843CA_490521737 = (native_preRotate(native_instance, degrees));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_preRotate(native_instance, degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.211 -0400", hash_original_method = "BCDAF6F2AF0C49197BF18278F335520E", hash_generated_method = "43E09673C1B57586FE6CD2357217F43A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean preSkew(float kx, float ky, float px, float py) {
        dsTaint.addTaint(kx);
        dsTaint.addTaint(ky);
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        boolean var9FA7183618403646DB30A7FED3243975_1796751470 = (native_preSkew(native_instance, kx, ky, px, py));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_preSkew(native_instance, kx, ky, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.211 -0400", hash_original_method = "421231502648E6DE11C6B4476FBB4CB5", hash_generated_method = "75AB4B2C09000A9095AF212D7740D3B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean preSkew(float kx, float ky) {
        dsTaint.addTaint(kx);
        dsTaint.addTaint(ky);
        boolean var66725046478C0AC12E1AB350EA8BA008_89721930 = (native_preSkew(native_instance, kx, ky));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_preSkew(native_instance, kx, ky);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.211 -0400", hash_original_method = "5465FF6869EFECF5658D42C575F011EC", hash_generated_method = "421E2A73E48ABB73AF37438D01CD67A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean preConcat(Matrix other) {
        dsTaint.addTaint(other.dsTaint);
        boolean var9C6E024213CA5C2C78B882753FA15FB7_1583865862 = (native_preConcat(native_instance, other.native_instance));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_preConcat(native_instance, other.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.212 -0400", hash_original_method = "C79C9E0E75F4298B5359E17C43CD6BA7", hash_generated_method = "D7B22DC5E21E6291D548F54D61C255CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postTranslate(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        boolean var3EB89776C0E9BC26B5B7A93497AA6338_2015098878 = (native_postTranslate(native_instance, dx, dy));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_postTranslate(native_instance, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.212 -0400", hash_original_method = "158FF341C93FCD549341DC9F548B9A8C", hash_generated_method = "D631549FF5F27BD8A4271ED9C2394908")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postScale(float sx, float sy, float px, float py) {
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
        boolean var811534EBBA0716ED15AB0EA06550D8C7_770622543 = (native_postScale(native_instance, sx, sy, px, py));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_postScale(native_instance, sx, sy, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.212 -0400", hash_original_method = "2747525819A92C185D4EAB6F550FCCE3", hash_generated_method = "1EADE2E3B940D2477C3AFDE7094E7912")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postScale(float sx, float sy) {
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
        boolean varFEBE8AC1DB6F60F9C4B86E273DF2FC19_518286642 = (native_postScale(native_instance, sx, sy));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_postScale(native_instance, sx, sy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.212 -0400", hash_original_method = "C0257612FFE5AA7DE5163F0B0AB9F855", hash_generated_method = "222CC9D54219156ABB7701659D224835")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postRotate(float degrees, float px, float py) {
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        dsTaint.addTaint(degrees);
        boolean varD7589C641F418AFED36121BAC654FC16_1103636376 = (native_postRotate(native_instance, degrees, px, py));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_postRotate(native_instance, degrees, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.212 -0400", hash_original_method = "DB293F0AFDDF18839C895B754EC55E8F", hash_generated_method = "F2BDE59A11C3C88A6E02709C6D215597")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postRotate(float degrees) {
        dsTaint.addTaint(degrees);
        boolean varF737BE5E5361946D147FCBB83A14D353_559666470 = (native_postRotate(native_instance, degrees));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_postRotate(native_instance, degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.212 -0400", hash_original_method = "57CA592FACEF6BD09A9AB3838326FC82", hash_generated_method = "A8CB7520D2875BF17F5F2559BF49C282")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postSkew(float kx, float ky, float px, float py) {
        dsTaint.addTaint(kx);
        dsTaint.addTaint(ky);
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        boolean var9BA35FCF22EA355270F926957521F093_1381279023 = (native_postSkew(native_instance, kx, ky, px, py));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_postSkew(native_instance, kx, ky, px, py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.212 -0400", hash_original_method = "0C899E968246F5B1F6489525332C2DAA", hash_generated_method = "11D7C337FD05CD3ACE2E0B382193DC6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postSkew(float kx, float ky) {
        dsTaint.addTaint(kx);
        dsTaint.addTaint(ky);
        boolean varC50A6D02F903D8010B24126CAB1D485B_380586269 = (native_postSkew(native_instance, kx, ky));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_postSkew(native_instance, kx, ky);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.212 -0400", hash_original_method = "C3D775738E645A4A21D169FF31B7CB59", hash_generated_method = "A00E78F9A294F6F469BFBD8EA0E05D54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postConcat(Matrix other) {
        dsTaint.addTaint(other.dsTaint);
        boolean var883846EFB3F1C6159603731AEA1A59F1_874061398 = (native_postConcat(native_instance, other.native_instance));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_postConcat(native_instance, other.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.213 -0400", hash_original_method = "AEF4FE63E4C98EDC4913C94ED23B0046", hash_generated_method = "4CE2E5954146C3F0CB4C1F5D4C8156C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setRectToRect(RectF src, RectF dst, ScaleToFit stf) {
        dsTaint.addTaint(stf.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        boolean varF7E361575251D13BE7FA91222DB37707_1109730590 = (native_setRectToRect(native_instance, src, dst, stf.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (dst == null || src == null) {
            //throw new NullPointerException();
        //}
        //return native_setRectToRect(native_instance, src, dst, stf.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.213 -0400", hash_original_method = "C3F7BC5FC61957EF4281B8FE8F2C4D53", hash_generated_method = "960DD2D616DDD8744AD6B93FEEB61B25")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.213 -0400", hash_original_method = "81F71DB7C56D04B1A3A5BEE1ABC9313F", hash_generated_method = "2E7534877E22329F8B0B93D5D937F5F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setPolyToPoly(float[] src, int srcIndex,
                                 float[] dst, int dstIndex,
                                 int pointCount) {
        dsTaint.addTaint(dstIndex);
        dsTaint.addTaint(src);
        dsTaint.addTaint(srcIndex);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(pointCount);
        {
            throw new IllegalArgumentException();
        } //End block
        checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        boolean var1B38DC69F9C1AE3BEDB6B044F3F544DB_815418176 = (native_setPolyToPoly(native_instance, src, srcIndex,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.213 -0400", hash_original_method = "E353C96DCEC77FF20275C37C83D4D335", hash_generated_method = "EDEA8C0FA556BD6BD6CD43E51416D394")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean invert(Matrix inverse) {
        dsTaint.addTaint(inverse.dsTaint);
        boolean var264FAB0D1776C7EB10CAD495521DE5AA_273095520 = (native_invert(native_instance, inverse.native_instance));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_invert(native_instance, inverse.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.213 -0400", hash_original_method = "B69F96FB84D81823B3FB4BA4E2DA7623", hash_generated_method = "A7161B49C45822A19A2FFF58BCD00066")
    @DSModeled(DSC.SAFE)
    public void mapPoints(float[] dst, int dstIndex, float[] src, int srcIndex,
                          int pointCount) {
        dsTaint.addTaint(dstIndex);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(src);
        dsTaint.addTaint(srcIndex);
        dsTaint.addTaint(pointCount);
        checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         pointCount, true);
        // ---------- Original Method ----------
        //checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        //native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         //pointCount, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.213 -0400", hash_original_method = "E01BB240D3A8AF79E8CA96ADF8A93B02", hash_generated_method = "A78E972ECD5D3538EC1C2168A0D31A8C")
    @DSModeled(DSC.SAFE)
    public void mapVectors(float[] dst, int dstIndex, float[] src, int srcIndex,
                          int vectorCount) {
        dsTaint.addTaint(dstIndex);
        dsTaint.addTaint(vectorCount);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(src);
        dsTaint.addTaint(srcIndex);
        checkPointArrays(src, srcIndex, dst, dstIndex, vectorCount);
        native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         vectorCount, false);
        // ---------- Original Method ----------
        //checkPointArrays(src, srcIndex, dst, dstIndex, vectorCount);
        //native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         //vectorCount, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.213 -0400", hash_original_method = "9EB430E2EA11CE20A0728D1BC77C5684", hash_generated_method = "8EEA3D43E00B1F74E7EC1922AC86B031")
    @DSModeled(DSC.SAFE)
    public void mapPoints(float[] dst, float[] src) {
        dsTaint.addTaint(dst);
        dsTaint.addTaint(src);
        {
            throw new ArrayIndexOutOfBoundsException();
        } //End block
        mapPoints(dst, 0, src, 0, dst.length >> 1);
        // ---------- Original Method ----------
        //if (dst.length != src.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //mapPoints(dst, 0, src, 0, dst.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.214 -0400", hash_original_method = "88563DD2DA99100452A3E727EF621773", hash_generated_method = "9D3919634C12B4A70DF5E848EFFC3C02")
    @DSModeled(DSC.SAFE)
    public void mapVectors(float[] dst, float[] src) {
        dsTaint.addTaint(dst);
        dsTaint.addTaint(src);
        {
            throw new ArrayIndexOutOfBoundsException();
        } //End block
        mapVectors(dst, 0, src, 0, dst.length >> 1);
        // ---------- Original Method ----------
        //if (dst.length != src.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //mapVectors(dst, 0, src, 0, dst.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.214 -0400", hash_original_method = "B621EF9C19B6D800D2C8FEF0AEB101A2", hash_generated_method = "1196399B8EBE799FCC82AB6CC3316E5D")
    @DSModeled(DSC.SAFE)
    public void mapPoints(float[] pts) {
        dsTaint.addTaint(pts);
        mapPoints(pts, 0, pts, 0, pts.length >> 1);
        // ---------- Original Method ----------
        //mapPoints(pts, 0, pts, 0, pts.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.214 -0400", hash_original_method = "35DF34CB8A8DD69940AA879A74BDB59C", hash_generated_method = "C721F446EBD663E267B962F7223CD872")
    @DSModeled(DSC.SAFE)
    public void mapVectors(float[] vecs) {
        dsTaint.addTaint(vecs);
        mapVectors(vecs, 0, vecs, 0, vecs.length >> 1);
        // ---------- Original Method ----------
        //mapVectors(vecs, 0, vecs, 0, vecs.length >> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.214 -0400", hash_original_method = "ED0A1CF18B9884BD196B57BA9AB3D4D4", hash_generated_method = "FF17F7FEAC2C395A0C2FE6331D76F374")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean mapRect(RectF dst, RectF src) {
        dsTaint.addTaint(dst.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        boolean var0555BDA0682728737A8E84AE5B37B33A_1559003335 = (native_mapRect(native_instance, dst, src));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (dst == null || src == null) {
            //throw new NullPointerException();
        //}
        //return native_mapRect(native_instance, dst, src);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.214 -0400", hash_original_method = "E67F1023A30815D48967A785552726F7", hash_generated_method = "5411F3B05A512918DD3D058F9FB06A88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean mapRect(RectF rect) {
        dsTaint.addTaint(rect.dsTaint);
        boolean var4F206D16D71EEBE65AA2A3210698955A_365716679 = (mapRect(rect, rect));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mapRect(rect, rect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.214 -0400", hash_original_method = "10B4872CA843B84CAABA7086757B6AA8", hash_generated_method = "E14E59D57441C64470F58D2EE295A8F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float mapRadius(float radius) {
        dsTaint.addTaint(radius);
        float varF364E7BDEF648809DE6AA5B35C7E7D24_42958183 = (native_mapRadius(native_instance, radius));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return native_mapRadius(native_instance, radius);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.214 -0400", hash_original_method = "E9A30A056D591CF546BBF753077E713D", hash_generated_method = "66CCB4D27783FB8CE496E329314E66B6")
    @DSModeled(DSC.SAFE)
    public void getValues(float[] values) {
        dsTaint.addTaint(values);
        {
            throw new ArrayIndexOutOfBoundsException();
        } //End block
        native_getValues(native_instance, values);
        // ---------- Original Method ----------
        //if (values.length < 9) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_getValues(native_instance, values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.214 -0400", hash_original_method = "A66AD9F1BFFA0584B04714786DBE2DC1", hash_generated_method = "239BB7DAB94AC5677CE82501C98EEF5A")
    @DSModeled(DSC.SAFE)
    public void setValues(float[] values) {
        dsTaint.addTaint(values);
        {
            throw new ArrayIndexOutOfBoundsException();
        } //End block
        native_setValues(native_instance, values);
        // ---------- Original Method ----------
        //if (values.length < 9) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_setValues(native_instance, values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.215 -0400", hash_original_method = "790F3515038F276DF7A46D3A4B29621A", hash_generated_method = "B5FA77024B201120D5013DC8F6EE1B84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(64);
        sb.append("Matrix{");
        toShortString(sb);
        sb.append('}');
        String var806458D832AB974D230FEE4CBBDBD390_1528431277 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //sb.append("Matrix{");
        //toShortString(sb);
        //sb.append('}');
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.215 -0400", hash_original_method = "9DDD7B6FB851EDEB6218261EF1A63117", hash_generated_method = "8220485575D14A85A4628355969C3531")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toShortString() {
        StringBuilder sb;
        sb = new StringBuilder(64);
        toShortString(sb);
        String var806458D832AB974D230FEE4CBBDBD390_644158961 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //toShortString(sb);
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.215 -0400", hash_original_method = "F87637A67413F385021CCAE210B2BF25", hash_generated_method = "B6516548879184FD16D1CCBB6B2165FE")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.215 -0400", hash_original_method = "8B9E48E860ED3F94388D797BB2BE65D6", hash_generated_method = "1054AB66557FD84D45A2303B197CC9D3")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.215 -0400", hash_original_method = "29B0241D689448242FFD9C9D7DE21563", hash_generated_method = "962AD33E6C7FB4B9806DBD61D1F94060")
    @DSModeled(DSC.SAFE)
    protected void finalize() throws Throwable {
        finalizer(native_instance);
        // ---------- Original Method ----------
        //finalizer(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.215 -0400", hash_original_method = "2C87051DCC7759A2331039EEC0434516", hash_generated_method = "CE8786785995B3AD2A39702F0929A1D7")
    @DSModeled(DSC.SAFE)
    final int ni() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return native_instance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.216 -0400", hash_original_method = "2E569DF6212FFB96C566D938F0C6BA9E", hash_generated_method = "D97FB6FDF8B0ACA506544CDAF687B4CF")
    private static int native_create(int native_src_or_zero) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.216 -0400", hash_original_method = "638CDF32930D5E21B4A69E02B1C867F7", hash_generated_method = "05E4481827599B476FA67207D85489F4")
    private static boolean native_isIdentity(int native_object) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.216 -0400", hash_original_method = "15C048D7828FD8ED0507A5C7188CFD3F", hash_generated_method = "38004EC8D7BD65FBC80F633322952A6E")
    private static boolean native_rectStaysRect(int native_object) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.216 -0400", hash_original_method = "548CCA10F3D2A7665E05666D064EBB52", hash_generated_method = "7EDB534CCC42C323E3EFF1F89E411801")
    private static void native_reset(int native_object) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.216 -0400", hash_original_method = "84C387F0490DFC4EAABFB80776BA2BD2", hash_generated_method = "A061D2F83FE60F79E08BDD31A4CE24C5")
    private static void native_set(int native_object, int other) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.216 -0400", hash_original_method = "77B961D47C85CFB4D1042B1C8EF1ACE9", hash_generated_method = "3766158C63797B632CA733A493CB897D")
    private static void native_setTranslate(int native_object,
                                                   float dx, float dy) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.216 -0400", hash_original_method = "1B93E1B1F926FF809F8131A7FD3BB4A2", hash_generated_method = "30572938955B56C92D4BE1697AAB86FE")
    private static void native_setScale(int native_object,
                                        float sx, float sy, float px, float py) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.216 -0400", hash_original_method = "7F19894A25F65B73FBC5CE9D718DED16", hash_generated_method = "23E34E990D8ADABFB956CE28A8D18877")
    private static void native_setScale(int native_object,
                                               float sx, float sy) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.216 -0400", hash_original_method = "33E7C1CBC9BCCE5EA45EC3BFC1FF7A83", hash_generated_method = "9AF7FB34FC9FD785A9E6EB6163D2A515")
    private static void native_setRotate(int native_object,
                                            float degrees, float px, float py) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.216 -0400", hash_original_method = "6CF9713A77534838EC901921A88E81B4", hash_generated_method = "DC17315AB66DE4D8AEAA83B8D3A6A541")
    private static void native_setRotate(int native_object,
                                                float degrees) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.216 -0400", hash_original_method = "766CCAF6495A07AE3DAD6FFBF8D2C007", hash_generated_method = "86C1E8AAC21741673370831B85970488")
    private static void native_setSinCos(int native_object,
                            float sinValue, float cosValue, float px, float py) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.216 -0400", hash_original_method = "745B4ADD99207C68A839BA8A29FB8BD1", hash_generated_method = "5444568406780980A769FBC1427DB6A6")
    private static void native_setSinCos(int native_object,
                                                float sinValue, float cosValue) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.217 -0400", hash_original_method = "2F3F222837DCFB258AA638165004883C", hash_generated_method = "DDB37FAE3127C5E1DBC67E2593BD7087")
    private static void native_setSkew(int native_object,
                                        float kx, float ky, float px, float py) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.217 -0400", hash_original_method = "FA98C1D462FFEEE78434086CABDFA080", hash_generated_method = "4DAF3A7877471BB89CB3028588B3A963")
    private static void native_setSkew(int native_object,
                                              float kx, float ky) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.217 -0400", hash_original_method = "59753537F113267A29C730B7F294C5AC", hash_generated_method = "36F7975B19D24EA6FCF17B7B43415465")
    private static boolean native_setConcat(int native_object,
                                                   int a, int b) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.217 -0400", hash_original_method = "A2DC31C39EB105AF0C37051991F9641B", hash_generated_method = "D3A988350DBEFD87E5E6497D8A282500")
    private static boolean native_preTranslate(int native_object,
                                                      float dx, float dy) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.217 -0400", hash_original_method = "B072627AF5334E6164E7100669BD01DC", hash_generated_method = "FDCF1F77D58CB2768043F45DF8CB4103")
    private static boolean native_preScale(int native_object,
                                        float sx, float sy, float px, float py) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.217 -0400", hash_original_method = "346E002D68517C85997D96159E0D8DF0", hash_generated_method = "7800E3A2B8BDE1F9A76F552B3453345A")
    private static boolean native_preScale(int native_object,
                                                  float sx, float sy) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.217 -0400", hash_original_method = "E8395384F02B1B1A51A1C8404E4BD825", hash_generated_method = "14CB40AE7EDA1F3A7214D0055C37FC83")
    private static boolean native_preRotate(int native_object,
                                            float degrees, float px, float py) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.217 -0400", hash_original_method = "8D5B156168BF70DD9CFF0BA75EA5CF01", hash_generated_method = "F04707A877317E15BE0F34D8ED8813F0")
    private static boolean native_preRotate(int native_object,
                                                   float degrees) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.220 -0400", hash_original_method = "EF5C6675036AA0F01B3CE96889FF4EB9", hash_generated_method = "08FD54214747C5A7A7D515EA242BE614")
    private static boolean native_preSkew(int native_object,
                                        float kx, float ky, float px, float py) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.220 -0400", hash_original_method = "8F5CA6A6F5F1E818D913627B1BC58905", hash_generated_method = "CF935931FB6278190AF498120E2399B5")
    private static boolean native_preSkew(int native_object,
                                                 float kx, float ky) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.220 -0400", hash_original_method = "BBDCE10B95B1C03721C7EA688D3AC4EF", hash_generated_method = "39ED8229452251D13569DBE57A156B38")
    private static boolean native_preConcat(int native_object,
                                                   int other_matrix) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.220 -0400", hash_original_method = "A36B2BD181828874B555ED87B01CC5CD", hash_generated_method = "A7516F9D6490BBB3C78176D6B9E58E35")
    private static boolean native_postTranslate(int native_object,
                                                       float dx, float dy) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.220 -0400", hash_original_method = "1C29CED6D9D0B83D79C84911859C7C5D", hash_generated_method = "6C788699A1A6F56309E5737282809D9C")
    private static boolean native_postScale(int native_object,
                                        float sx, float sy, float px, float py) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.220 -0400", hash_original_method = "6AA0F6CC1BDC33D8A53FC691CE5BEEF6", hash_generated_method = "8B12CAFF3195725A863D74FC60AD9307")
    private static boolean native_postScale(int native_object,
                                                   float sx, float sy) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.220 -0400", hash_original_method = "1BADEE2EEC198A1CD24195BD453F5940", hash_generated_method = "4B7E2F6EBAF767B714D0CBA9424E0533")
    private static boolean native_postRotate(int native_object,
                                            float degrees, float px, float py) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.220 -0400", hash_original_method = "8A93D24AD8C8E10A211C4CD634DB8A8C", hash_generated_method = "D5FDC60A0A9A4D4F8A56373218CF6A22")
    private static boolean native_postRotate(int native_object,
                                                    float degrees) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.221 -0400", hash_original_method = "A3077167E092256E078410C9D7431BEE", hash_generated_method = "95F8CEE0D678171EC3267BC4377DFADB")
    private static boolean native_postSkew(int native_object,
                                        float kx, float ky, float px, float py) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.221 -0400", hash_original_method = "5DB345158601C8F9A292AC9567577F74", hash_generated_method = "6381FB8C5F1D86983C880FA7325BC769")
    private static boolean native_postSkew(int native_object,
                                                  float kx, float ky) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.221 -0400", hash_original_method = "A7F971010B85694F54D25E6810AF9F6C", hash_generated_method = "F6694E3A04542E3779EE07A9E5FCC77C")
    private static boolean native_postConcat(int native_object,
                                                    int other_matrix) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.221 -0400", hash_original_method = "997F0D86746DF60B46CF1C3F2CE0674F", hash_generated_method = "FDF0E1C25D4590427FC495E3AF347207")
    private static boolean native_setRectToRect(int native_object,
                                                RectF src, RectF dst, int stf) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.221 -0400", hash_original_method = "E0F20C593DF79C9CCCA4DB55E891FB64", hash_generated_method = "634B7F103128E589D4DBC64E2DC73646")
    private static boolean native_setPolyToPoly(int native_object,
        float[] src, int srcIndex, float[] dst, int dstIndex, int pointCount) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.221 -0400", hash_original_method = "EE6005D3A8076E9D9E9B83CE8ACC5965", hash_generated_method = "DDB0E3F2BE660059575107F7F3A41B1A")
    private static boolean native_invert(int native_object, int inverse) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.221 -0400", hash_original_method = "5FDD68430EBC4BD2EB2AD22AD554472C", hash_generated_method = "4215AFF21516F48916690B93C22BB9B8")
    private static void native_mapPoints(int native_object,
                        float[] dst, int dstIndex, float[] src, int srcIndex,
                        int ptCount, boolean isPts) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.221 -0400", hash_original_method = "110B62B2717E6E6A45CDBC1ABD7D582B", hash_generated_method = "10E7599D3666529E63D20929EB239318")
    private static boolean native_mapRect(int native_object,
                                                 RectF dst, RectF src) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.221 -0400", hash_original_method = "25D448CFE343232FBEAD62FB0DE1949E", hash_generated_method = "1020258727C9165B4C7AC6673EDE8854")
    private static float native_mapRadius(int native_object,
                                                 float radius) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.221 -0400", hash_original_method = "6D9A980453C770560C440D42192FF14E", hash_generated_method = "B1E23D0A380CA60271A0EE1BD9B14079")
    private static void native_getValues(int native_object,
                                                float[] values) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.221 -0400", hash_original_method = "AAA085A6D40304BE48BD5E89D081C552", hash_generated_method = "401EAE8C8D802EDB4D99B6A0EB5A0410")
    private static void native_setValues(int native_object,
                                                float[] values) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.221 -0400", hash_original_method = "061EC29489F0C7FEEFE2A3D6DC5F1B84", hash_generated_method = "26CBFA57E0EC3F00AB3334E8C03CDA92")
    private static boolean native_equals(int native_a, int native_b) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.222 -0400", hash_original_method = "3EB71327F1F1A6E32641122E7B4DA111", hash_generated_method = "A31B20E2CB1844494F28FD492786E830")
    private static void finalizer(int native_instance) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
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

    
}


