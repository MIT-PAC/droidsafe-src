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

    /**
     * Retrieve a sampler with min and mag set to nearest and wrap modes set to
     * clamp.
     *
     * @param rs Context to which the sampler will belong.
     *
     * @return Sampler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.328 -0500", hash_original_method = "D53B73924CE25BA79BE5C682EDA80315", hash_generated_method = "76103A06C46A7D3BD84888DC632CF17F")
    
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

    /**
     * Retrieve a sampler with min and mag set to linear and wrap modes set to
     * clamp.
     *
     * @param rs Context to which the sampler will belong.
     *
     * @return Sampler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.331 -0500", hash_original_method = "C819E485025B8F435117CF721B89C30B", hash_generated_method = "98BEB9A19A26BBF97D7E138E50A9E89E")
    
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

    /**
     * Retrieve a sampler with ag set to linear, min linear mipmap linear, and
     * to and wrap modes set to clamp.
     *
     * @param rs Context to which the sampler will belong.
     *
     * @return Sampler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.334 -0500", hash_original_method = "1C5F08F4E69D3052E8B04C996B666B5E", hash_generated_method = "C1C798952A0B97CFA2CC1D52833092D6")
    
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

    /**
     * Retrieve a sampler with min and mag set to nearest and wrap modes set to
     * wrap.
     *
     * @param rs Context to which the sampler will belong.
     *
     * @return Sampler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.336 -0500", hash_original_method = "60B916CF0A3D5B965BF0342DD7963DCA", hash_generated_method = "FE2C555887A498F2F13E19B35C08CDC4")
    
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

    /**
     * Retrieve a sampler with min and mag set to nearest and wrap modes set to
     * wrap.
     *
     * @param rs Context to which the sampler will belong.
     *
     * @return Sampler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.339 -0500", hash_original_method = "ACD81E1C335918B4D3E2AA9EB254701A", hash_generated_method = "67ECC52E4669912A58872E8365B7F8B6")
    
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

    /**
     * Retrieve a sampler with ag set to linear, min linear mipmap linear, and
     * to and wrap modes set to wrap.
     *
     * @param rs Context to which the sampler will belong.
     *
     * @return Sampler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.341 -0500", hash_original_method = "F0F69185D92A35C507C6F9D582B32E71", hash_generated_method = "09BDFB2D812B6667ABA6764C2FE121E8")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.303 -0500", hash_original_field = "78D865F0F8FE6DB954DFD52729EF4192", hash_generated_field = "78D865F0F8FE6DB954DFD52729EF4192")

    Value mMin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.305 -0500", hash_original_field = "F56E0D8DE09D3E0C2674A9D00D532766", hash_generated_field = "F56E0D8DE09D3E0C2674A9D00D532766")

    Value mMag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.307 -0500", hash_original_field = "90F3A7E00ED85B2D7BA8F6C92BD170FC", hash_generated_field = "90F3A7E00ED85B2D7BA8F6C92BD170FC")

    Value mWrapS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.309 -0500", hash_original_field = "498111A7138D0C815612F8AAEF8D34F6", hash_generated_field = "498111A7138D0C815612F8AAEF8D34F6")

    Value mWrapT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.311 -0500", hash_original_field = "B4553276C00EFD86FCB9FC4901287DB9", hash_generated_field = "B4553276C00EFD86FCB9FC4901287DB9")

    Value mWrapR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.313 -0500", hash_original_field = "F34163C1972E48C6E60A65002E2CF0FF", hash_generated_field = "F34163C1972E48C6E60A65002E2CF0FF")

    float mAniso;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.315 -0500", hash_original_method = "F269E274655B2D076A18F19151EF2AC2", hash_generated_method = "F269E274655B2D076A18F19151EF2AC2")
    
Sampler(int id, RenderScript rs) {
        super(id, rs);
    }

    /**
     * @hide
     * @return minification setting for the sampler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.317 -0500", hash_original_method = "D317EF4B4114590296947059ADFB19C8", hash_generated_method = "95467702F443275602CE6D40B8E84E80")
    
public Value getMinification() {
        return mMin;
    }

    /**
     * @hide
     * @return magnification setting for the sampler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.319 -0500", hash_original_method = "A7082274978B491E47306F0E360F75DB", hash_generated_method = "CF86DA7376D60B3ABB20FA13488132B3")
    
public Value getMagnification() {
        return mMag;
    }

    /**
     * @hide
     * @return S wrapping mode for the sampler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.321 -0500", hash_original_method = "E48146B3F5D0EC1AF0EEEDA8DCF8E9C5", hash_generated_method = "33CA2460636D71C2FC02AC84D197168B")
    
public Value getWrapS() {
        return mWrapS;
    }

    /**
     * @hide
     * @return T wrapping mode for the sampler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.323 -0500", hash_original_method = "BF16B6A54AB7A7E067EFC876E596B184", hash_generated_method = "23AFA45FA8AD5C86B2087339E6E3FF10")
    
public Value getWrapT() {
        return mWrapT;
    }

    /**
     * @hide
     * @return anisotropy setting for the sampler
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.326 -0500", hash_original_method = "93EB2299B93AC8C5EEC3466170C1832C", hash_generated_method = "BB82B63AF00CC0AB82F2B014F71CD9D8")
    
public float getAnisotropy() {
        return mAniso;
    }
    
    public enum Value {
        NEAREST (0),
        LINEAR (1),
        LINEAR_MIP_LINEAR (2),
        LINEAR_MIP_NEAREST (5),
        WRAP (3),
        CLAMP (4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.297 -0500", hash_original_field = "0B53E374282B34FB268F3024A1E73BA5", hash_generated_field = "0B53E374282B34FB268F3024A1E73BA5")

        int mID;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.299 -0500", hash_original_method = "D95229092961F4EF9A4C0D9F3629FAB8", hash_generated_method = "D95229092961F4EF9A4C0D9F3629FAB8")
            
Value(int id) {
            mID = id;
        }
    }
    
    public static class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.344 -0500", hash_original_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.346 -0500", hash_original_field = "78D865F0F8FE6DB954DFD52729EF4192", hash_generated_field = "78D865F0F8FE6DB954DFD52729EF4192")

        Value mMin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.348 -0500", hash_original_field = "F56E0D8DE09D3E0C2674A9D00D532766", hash_generated_field = "F56E0D8DE09D3E0C2674A9D00D532766")

        Value mMag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.350 -0500", hash_original_field = "90F3A7E00ED85B2D7BA8F6C92BD170FC", hash_generated_field = "90F3A7E00ED85B2D7BA8F6C92BD170FC")

        Value mWrapS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.352 -0500", hash_original_field = "498111A7138D0C815612F8AAEF8D34F6", hash_generated_field = "498111A7138D0C815612F8AAEF8D34F6")

        Value mWrapT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.354 -0500", hash_original_field = "B4553276C00EFD86FCB9FC4901287DB9", hash_generated_field = "B4553276C00EFD86FCB9FC4901287DB9")

        Value mWrapR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.357 -0500", hash_original_field = "F34163C1972E48C6E60A65002E2CF0FF", hash_generated_field = "F34163C1972E48C6E60A65002E2CF0FF")

        float mAniso;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.359 -0500", hash_original_method = "8BA530FE069759F6E1F3228F8706F91B", hash_generated_method = "916B444238250B8356F90E549102C517")
        
public Builder(RenderScript rs) {
            mRS = rs;
            mMin = Value.NEAREST;
            mMag = Value.NEAREST;
            mWrapS = Value.WRAP;
            mWrapT = Value.WRAP;
            mWrapR = Value.WRAP;
            mAniso = 1.0f;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.361 -0500", hash_original_method = "E6EEB5BC9FE9E0F7EDF9E87ACAA2AA20", hash_generated_method = "6E1407F8854E787DC1E4E500B172C4AB")
        
public void setMinification(Value v) {
            if (v == Value.NEAREST ||
                v == Value.LINEAR ||
                v == Value.LINEAR_MIP_LINEAR ||
                v == Value.LINEAR_MIP_NEAREST) {
                mMin = v;
            } else {
                throw new IllegalArgumentException("Invalid value");
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.364 -0500", hash_original_method = "774B9CE0D926CB6E3A04802F250BB893", hash_generated_method = "D668E8629556C2A518FA10F196052308")
        
public void setMagnification(Value v) {
            if (v == Value.NEAREST || v == Value.LINEAR) {
                mMag = v;
            } else {
                throw new IllegalArgumentException("Invalid value");
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.366 -0500", hash_original_method = "4FC89E5F96ED39EA76E7D1E07F2197E0", hash_generated_method = "730B63FF9CA0F6F5863111E0B8F32275")
        
public void setWrapS(Value v) {
            if (v == Value.WRAP || v == Value.CLAMP) {
                mWrapS = v;
            } else {
                throw new IllegalArgumentException("Invalid value");
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.368 -0500", hash_original_method = "7B3108DA158EAC18DF94BBDEDE7C0E3C", hash_generated_method = "499D18527CC4447C8EECCA9EF0ADEC00")
        
public void setWrapT(Value v) {
            if (v == Value.WRAP || v == Value.CLAMP) {
                mWrapT = v;
            } else {
                throw new IllegalArgumentException("Invalid value");
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.371 -0500", hash_original_method = "73597F570366B374FBC9D389A92F8786", hash_generated_method = "EE68B381EE52BDB37C6ED9482ED81ABA")
        
public void setAnisotropy(float v) {
            if(v >= 0.0f) {
                mAniso = v;
            } else {
                throw new IllegalArgumentException("Invalid value");
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.374 -0500", hash_original_method = "937B9F9B0444A5D4D5880C1D9F742F25", hash_generated_method = "011D288F6905ADFE5465CF39531B9AD3")
        
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
            return sampler;
        }
        
    }
    
}

