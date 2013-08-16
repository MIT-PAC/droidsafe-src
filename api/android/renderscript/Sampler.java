package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import android.graphics.Bitmap;
import android.util.Log;
import android.graphics.BitmapFactory;
import java.io.IOException;
import android.os.Bundle;
import android.content.res.Resources;
public class Sampler extends BaseObj {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.881 -0400", hash_original_field = "5226ADEF3F3B32783B4143237DC7F62E", hash_generated_field = "78D865F0F8FE6DB954DFD52729EF4192")

    Value mMin;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.883 -0400", hash_original_field = "210F9BBF5408C37014270E8DF48F9E17", hash_generated_field = "F56E0D8DE09D3E0C2674A9D00D532766")

    Value mMag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.885 -0400", hash_original_field = "5BA8ABA2342564D629E12B6A64A7F17F", hash_generated_field = "90F3A7E00ED85B2D7BA8F6C92BD170FC")

    Value mWrapS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.886 -0400", hash_original_field = "5A732EDCDFB06DC237F07B906261E783", hash_generated_field = "498111A7138D0C815612F8AAEF8D34F6")

    Value mWrapT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.888 -0400", hash_original_field = "3010B31BB60398F10CC966198DDF430A", hash_generated_field = "B4553276C00EFD86FCB9FC4901287DB9")

    Value mWrapR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.896 -0400", hash_original_field = "483621F6DC8C41E8F480E4713E953C9C", hash_generated_field = "F34163C1972E48C6E60A65002E2CF0FF")

    float mAniso;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.903 -0400", hash_original_method = "F269E274655B2D076A18F19151EF2AC2", hash_generated_method = "784618DCEBFEC31EA6FCF3626F644C2E")
      Sampler(int id, RenderScript rs) {
        super(id, rs);
        addTaint(rs.getTaint());
        addTaint(id);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.908 -0400", hash_original_method = "D317EF4B4114590296947059ADFB19C8", hash_generated_method = "A1D05334DCB708D329C634803B1E16E3")
    public Value getMinification() {
Value varFF498CE7DB7B276D58AE6690DD82E33E_973097555 =         mMin;
        varFF498CE7DB7B276D58AE6690DD82E33E_973097555.addTaint(taint);
        return varFF498CE7DB7B276D58AE6690DD82E33E_973097555;
        // ---------- Original Method ----------
        //return mMin;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.914 -0400", hash_original_method = "A7082274978B491E47306F0E360F75DB", hash_generated_method = "27F8053ED5DB58BA6527B177A872DD7C")
    public Value getMagnification() {
Value varAFB30445E4361E4E22E5CD3ABF37224B_1309446871 =         mMag;
        varAFB30445E4361E4E22E5CD3ABF37224B_1309446871.addTaint(taint);
        return varAFB30445E4361E4E22E5CD3ABF37224B_1309446871;
        // ---------- Original Method ----------
        //return mMag;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.922 -0400", hash_original_method = "E48146B3F5D0EC1AF0EEEDA8DCF8E9C5", hash_generated_method = "2E3D65BE34F5EE6A7A23BC5D01075796")
    public Value getWrapS() {
Value varA9560538D1FF66AD771BC97DC7B4576C_134584045 =         mWrapS;
        varA9560538D1FF66AD771BC97DC7B4576C_134584045.addTaint(taint);
        return varA9560538D1FF66AD771BC97DC7B4576C_134584045;
        // ---------- Original Method ----------
        //return mWrapS;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.927 -0400", hash_original_method = "BF16B6A54AB7A7E067EFC876E596B184", hash_generated_method = "8E8B0D6CD8A6647EB13BD29D2CC2BE32")
    public Value getWrapT() {
Value varDC4A95D5695DF800C9E328EE00707FF9_612453423 =         mWrapT;
        varDC4A95D5695DF800C9E328EE00707FF9_612453423.addTaint(taint);
        return varDC4A95D5695DF800C9E328EE00707FF9_612453423;
        // ---------- Original Method ----------
        //return mWrapT;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.931 -0400", hash_original_method = "93EB2299B93AC8C5EEC3466170C1832C", hash_generated_method = "230A5E9075498480E3105DD95BF644DF")
    public float getAnisotropy() {
        float var483621F6DC8C41E8F480E4713E953C9C_1417420389 = (mAniso);
                float var546ADE640B6EDFBC8A086EF31347E768_1130983963 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1130983963;
        // ---------- Original Method ----------
        //return mAniso;
    }

    
        @DSModeled(DSC.SAFE)
    public static Sampler CLAMP_NEAREST(RenderScript rs) {
        if(rs.mSampler_CLAMP_NEAREST == null) {
            Builder b = new Builder(rs);
            b.setMinification(Value.NEAREST);
            b.setMagnification(Value.NEAREST);
            b.setWrapS(Value.CLAMP);
            b.setWrapT(Value.CLAMP);
            rs.mSampler_CLAMP_NEAREST = b.create();
        }
        return rs.mSampler_CLAMP_NEAREST;
    }

    
        public static Sampler CLAMP_LINEAR(RenderScript rs) {
        if(rs.mSampler_CLAMP_LINEAR == null) {
            Builder b = new Builder(rs);
            b.setMinification(Value.LINEAR);
            b.setMagnification(Value.LINEAR);
            b.setWrapS(Value.CLAMP);
            b.setWrapT(Value.CLAMP);
            rs.mSampler_CLAMP_LINEAR = b.create();
        }
        return rs.mSampler_CLAMP_LINEAR;
    }

    
        public static Sampler CLAMP_LINEAR_MIP_LINEAR(RenderScript rs) {
        if(rs.mSampler_CLAMP_LINEAR_MIP_LINEAR == null) {
            Builder b = new Builder(rs);
            b.setMinification(Value.LINEAR_MIP_LINEAR);
            b.setMagnification(Value.LINEAR);
            b.setWrapS(Value.CLAMP);
            b.setWrapT(Value.CLAMP);
            rs.mSampler_CLAMP_LINEAR_MIP_LINEAR = b.create();
        }
        return rs.mSampler_CLAMP_LINEAR_MIP_LINEAR;
    }

    
        @DSModeled(DSC.SAFE)
    public static Sampler WRAP_NEAREST(RenderScript rs) {
        if(rs.mSampler_WRAP_NEAREST == null) {
            Builder b = new Builder(rs);
            b.setMinification(Value.NEAREST);
            b.setMagnification(Value.NEAREST);
            b.setWrapS(Value.WRAP);
            b.setWrapT(Value.WRAP);
            rs.mSampler_WRAP_NEAREST = b.create();
        }
        return rs.mSampler_WRAP_NEAREST;
    }

    
        public static Sampler WRAP_LINEAR(RenderScript rs) {
        if(rs.mSampler_WRAP_LINEAR == null) {
            Builder b = new Builder(rs);
            b.setMinification(Value.LINEAR);
            b.setMagnification(Value.LINEAR);
            b.setWrapS(Value.WRAP);
            b.setWrapT(Value.WRAP);
            rs.mSampler_WRAP_LINEAR = b.create();
        }
        return rs.mSampler_WRAP_LINEAR;
    }

    
        public static Sampler WRAP_LINEAR_MIP_LINEAR(RenderScript rs) {
        if(rs.mSampler_WRAP_LINEAR_MIP_LINEAR == null) {
            Builder b = new Builder(rs);
            b.setMinification(Value.LINEAR_MIP_LINEAR);
            b.setMagnification(Value.LINEAR);
            b.setWrapS(Value.WRAP);
            b.setWrapT(Value.WRAP);
            rs.mSampler_WRAP_LINEAR_MIP_LINEAR = b.create();
        }
        return rs.mSampler_WRAP_LINEAR_MIP_LINEAR;
    }

    
    public enum Value {
        NEAREST (0),
        LINEAR (1),
        LINEAR_MIP_LINEAR (2),
        LINEAR_MIP_NEAREST (5),
        WRAP (3),
        CLAMP (4);
        int mID;
        @DSModeled(DSC.BAN)
        Value(int id) {
            mID = id;
        }
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.958 -0400", hash_original_field = "15EADDEB24354180E81F0ADC804C4CED", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.959 -0400", hash_original_field = "5226ADEF3F3B32783B4143237DC7F62E", hash_generated_field = "78D865F0F8FE6DB954DFD52729EF4192")

        Value mMin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.961 -0400", hash_original_field = "210F9BBF5408C37014270E8DF48F9E17", hash_generated_field = "F56E0D8DE09D3E0C2674A9D00D532766")

        Value mMag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.962 -0400", hash_original_field = "5BA8ABA2342564D629E12B6A64A7F17F", hash_generated_field = "90F3A7E00ED85B2D7BA8F6C92BD170FC")

        Value mWrapS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.964 -0400", hash_original_field = "5A732EDCDFB06DC237F07B906261E783", hash_generated_field = "498111A7138D0C815612F8AAEF8D34F6")

        Value mWrapT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.965 -0400", hash_original_field = "3010B31BB60398F10CC966198DDF430A", hash_generated_field = "B4553276C00EFD86FCB9FC4901287DB9")

        Value mWrapR;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.969 -0400", hash_original_field = "483621F6DC8C41E8F480E4713E953C9C", hash_generated_field = "F34163C1972E48C6E60A65002E2CF0FF")

        float mAniso;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.982 -0400", hash_original_method = "8BA530FE069759F6E1F3228F8706F91B", hash_generated_method = "B5ED360C392A371B9D60BB58F49A31FC")
        public  Builder(RenderScript rs) {
            mRS = rs;
            mMin = Value.NEAREST;
            mMag = Value.NEAREST;
            mWrapS = Value.WRAP;
            mWrapT = Value.WRAP;
            mWrapR = Value.WRAP;
            mAniso = 1.0f;
            // ---------- Original Method ----------
            //mRS = rs;
            //mMin = Value.NEAREST;
            //mMag = Value.NEAREST;
            //mWrapS = Value.WRAP;
            //mWrapT = Value.WRAP;
            //mWrapR = Value.WRAP;
            //mAniso = 1.0f;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:13.993 -0400", hash_original_method = "E6EEB5BC9FE9E0F7EDF9E87ACAA2AA20", hash_generated_method = "CE2F461EC1CBEB81474F7EE74BE3864A")
        public void setMinification(Value v) {
            if(v == Value.NEAREST ||
                v == Value.LINEAR ||
                v == Value.LINEAR_MIP_LINEAR ||
                v == Value.LINEAR_MIP_NEAREST)            
            {
                mMin = v;
            } //End block
            else
            {
                IllegalArgumentException varDCE3009E74EF7CB3FA988AA230E54A6C_1886485410 = new IllegalArgumentException("Invalid value");
                varDCE3009E74EF7CB3FA988AA230E54A6C_1886485410.addTaint(taint);
                throw varDCE3009E74EF7CB3FA988AA230E54A6C_1886485410;
            } //End block
            // ---------- Original Method ----------
            //if (v == Value.NEAREST ||
                //v == Value.LINEAR ||
                //v == Value.LINEAR_MIP_LINEAR ||
                //v == Value.LINEAR_MIP_NEAREST) {
                //mMin = v;
            //} else {
                //throw new IllegalArgumentException("Invalid value");
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:14.003 -0400", hash_original_method = "774B9CE0D926CB6E3A04802F250BB893", hash_generated_method = "939E6F812D10B14C27137B43C9895B57")
        public void setMagnification(Value v) {
            if(v == Value.NEAREST || v == Value.LINEAR)            
            {
                mMag = v;
            } //End block
            else
            {
                IllegalArgumentException varDCE3009E74EF7CB3FA988AA230E54A6C_1499428341 = new IllegalArgumentException("Invalid value");
                varDCE3009E74EF7CB3FA988AA230E54A6C_1499428341.addTaint(taint);
                throw varDCE3009E74EF7CB3FA988AA230E54A6C_1499428341;
            } //End block
            // ---------- Original Method ----------
            //if (v == Value.NEAREST || v == Value.LINEAR) {
                //mMag = v;
            //} else {
                //throw new IllegalArgumentException("Invalid value");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:14.008 -0400", hash_original_method = "4FC89E5F96ED39EA76E7D1E07F2197E0", hash_generated_method = "CDDCF253725179AEE602C379BADA4336")
        public void setWrapS(Value v) {
            if(v == Value.WRAP || v == Value.CLAMP)            
            {
                mWrapS = v;
            } //End block
            else
            {
                IllegalArgumentException varDCE3009E74EF7CB3FA988AA230E54A6C_871041811 = new IllegalArgumentException("Invalid value");
                varDCE3009E74EF7CB3FA988AA230E54A6C_871041811.addTaint(taint);
                throw varDCE3009E74EF7CB3FA988AA230E54A6C_871041811;
            } //End block
            // ---------- Original Method ----------
            //if (v == Value.WRAP || v == Value.CLAMP) {
                //mWrapS = v;
            //} else {
                //throw new IllegalArgumentException("Invalid value");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:14.016 -0400", hash_original_method = "7B3108DA158EAC18DF94BBDEDE7C0E3C", hash_generated_method = "D179A30C4078EF0BECAD30D612969BE7")
        public void setWrapT(Value v) {
            if(v == Value.WRAP || v == Value.CLAMP)            
            {
                mWrapT = v;
            } //End block
            else
            {
                IllegalArgumentException varDCE3009E74EF7CB3FA988AA230E54A6C_2055565412 = new IllegalArgumentException("Invalid value");
                varDCE3009E74EF7CB3FA988AA230E54A6C_2055565412.addTaint(taint);
                throw varDCE3009E74EF7CB3FA988AA230E54A6C_2055565412;
            } //End block
            // ---------- Original Method ----------
            //if (v == Value.WRAP || v == Value.CLAMP) {
                //mWrapT = v;
            //} else {
                //throw new IllegalArgumentException("Invalid value");
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:14.025 -0400", hash_original_method = "73597F570366B374FBC9D389A92F8786", hash_generated_method = "D5F960071708BD2640344B4882397F43")
        public void setAnisotropy(float v) {
            if(v >= 0.0f)            
            {
                mAniso = v;
            } //End block
            else
            {
                IllegalArgumentException varDCE3009E74EF7CB3FA988AA230E54A6C_1222898414 = new IllegalArgumentException("Invalid value");
                varDCE3009E74EF7CB3FA988AA230E54A6C_1222898414.addTaint(taint);
                throw varDCE3009E74EF7CB3FA988AA230E54A6C_1222898414;
            } //End block
            // ---------- Original Method ----------
            //if(v >= 0.0f) {
                //mAniso = v;
            //} else {
                //throw new IllegalArgumentException("Invalid value");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:07:14.039 -0400", hash_original_method = "937B9F9B0444A5D4D5880C1D9F742F25", hash_generated_method = "D3A230A384EF685A1814C2C460A0F0B3")
        public Sampler create() {
            mRS.validate();
            int id = mRS.nSamplerCreate(mMag.mID, mMin.mID, 
                                        mWrapS.mID, mWrapT.mID, mWrapR.mID, mAniso);
            Sampler sampler = new Sampler(id, mRS);
            sampler.mMin = mMin;
            sampler.mMag = mMag;
            sampler.mWrapS = mWrapS;
            sampler.mWrapT = mWrapT;
            sampler.mWrapR = mWrapR;
            sampler.mAniso = mAniso;
Sampler varB936E14BFEC697AFCDD993C7D4967DB8_439385558 =             sampler;
            varB936E14BFEC697AFCDD993C7D4967DB8_439385558.addTaint(taint);
            return varB936E14BFEC697AFCDD993C7D4967DB8_439385558;
            // ---------- Original Method ----------
            //mRS.validate();
            //int id = mRS.nSamplerCreate(mMag.mID, mMin.mID, 
                                        //mWrapS.mID, mWrapT.mID, mWrapR.mID, mAniso);
            //Sampler sampler = new Sampler(id, mRS);
            //sampler.mMin = mMin;
            //sampler.mMag = mMag;
            //sampler.mWrapS = mWrapS;
            //sampler.mWrapT = mWrapT;
            //sampler.mWrapR = mWrapR;
            //sampler.mAniso = mAniso;
            //return sampler;
        }

        
    }


    
}

