package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
public class ProgramRaster extends BaseObj {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:31.468 -0400", hash_original_field = "321685E8635454054D49E5C34C7B3BD2", hash_generated_field = "F5AC5A34ED9B3F99113F766A014FABE4")

    boolean mPointSprite;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:31.471 -0400", hash_original_field = "FC0F060774ED3ABA52CE08DBF84480D8", hash_generated_field = "9FA33B9FFF9AB6B073377EBA3FA57AC7")

    CullMode mCullMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:31.480 -0400", hash_original_method = "894C81580448C83340BD6FC91F1FBF06", hash_generated_method = "CA1857F815CC313325ACBD6B00E13579")
      ProgramRaster(int id, RenderScript rs) {
        super(id, rs);
        addTaint(rs.getTaint());
        addTaint(id);
        mPointSprite = false;
        mCullMode = CullMode.BACK;
        // ---------- Original Method ----------
        //mPointSprite = false;
        //mCullMode = CullMode.BACK;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:31.494 -0400", hash_original_method = "F919B6D858DA98A8D6F899FC9949AF17", hash_generated_method = "69AA81AB0EF1B9D5C3F9795015745EE3")
    public boolean getPointSpriteEnabled() {
        boolean var321685E8635454054D49E5C34C7B3BD2_1477994857 = (mPointSprite);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_207905395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_207905395;
        // ---------- Original Method ----------
        //return mPointSprite;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:31.505 -0400", hash_original_method = "9D9A5D91910AD22DEA2607A5096E0D2B", hash_generated_method = "A7A6D867287F7EEB69B5B097EA7815DF")
    public CullMode getCullMode() {
CullMode var152C0F26D3190115F1B1B5CD185268F6_1389726823 =         mCullMode;
        var152C0F26D3190115F1B1B5CD185268F6_1389726823.addTaint(taint);
        return var152C0F26D3190115F1B1B5CD185268F6_1389726823;
        // ---------- Original Method ----------
        //return mCullMode;
    }

    
        public static ProgramRaster CULL_BACK(RenderScript rs) {
        if(rs.mProgramRaster_CULL_BACK == null) {
            ProgramRaster.Builder builder = new ProgramRaster.Builder(rs);
            builder.setCullMode(CullMode.BACK);
            rs.mProgramRaster_CULL_BACK = builder.create();
        }
        return rs.mProgramRaster_CULL_BACK;
    }

    
        public static ProgramRaster CULL_FRONT(RenderScript rs) {
        if(rs.mProgramRaster_CULL_FRONT == null) {
            ProgramRaster.Builder builder = new ProgramRaster.Builder(rs);
            builder.setCullMode(CullMode.FRONT);
            rs.mProgramRaster_CULL_FRONT = builder.create();
        }
        return rs.mProgramRaster_CULL_FRONT;
    }

    
        public static ProgramRaster CULL_NONE(RenderScript rs) {
        if(rs.mProgramRaster_CULL_NONE == null) {
            ProgramRaster.Builder builder = new ProgramRaster.Builder(rs);
            builder.setCullMode(CullMode.NONE);
            rs.mProgramRaster_CULL_NONE = builder.create();
        }
        return rs.mProgramRaster_CULL_NONE;
    }

    
    public enum CullMode {
        BACK (0),
        FRONT (1),
        NONE (2);
        int mID;
        CullMode(int id) {
            mID = id;
        }
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:31.518 -0400", hash_original_field = "15EADDEB24354180E81F0ADC804C4CED", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:31.520 -0400", hash_original_field = "321685E8635454054D49E5C34C7B3BD2", hash_generated_field = "F5AC5A34ED9B3F99113F766A014FABE4")

        boolean mPointSprite;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:31.521 -0400", hash_original_field = "FC0F060774ED3ABA52CE08DBF84480D8", hash_generated_field = "9FA33B9FFF9AB6B073377EBA3FA57AC7")

        CullMode mCullMode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:31.536 -0400", hash_original_method = "1E8388B7448CFC4A6F961C903791989B", hash_generated_method = "973C1416ACC76B05766F7D935E8046AB")
        public  Builder(RenderScript rs) {
            mRS = rs;
            mPointSprite = false;
            mCullMode = CullMode.BACK;
            // ---------- Original Method ----------
            //mRS = rs;
            //mPointSprite = false;
            //mCullMode = CullMode.BACK;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:31.545 -0400", hash_original_method = "8E3B02261392357829242E8A2823D9BA", hash_generated_method = "C53C06F0555C6774F447CA44C75247C0")
        public Builder setPointSpriteEnabled(boolean enable) {
            mPointSprite = enable;
Builder var72A74007B2BE62B849F475C7BDA4658B_394590042 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_394590042.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_394590042;
            // ---------- Original Method ----------
            //mPointSprite = enable;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:31.551 -0400", hash_original_method = "5BEDACC205FE11487443D5D48E3468FF", hash_generated_method = "4C945800D30C9C4340E7124ACC3591FD")
        public Builder setCullMode(CullMode m) {
            mCullMode = m;
Builder var72A74007B2BE62B849F475C7BDA4658B_379297981 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_379297981.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_379297981;
            // ---------- Original Method ----------
            //mCullMode = m;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:31.560 -0400", hash_original_method = "1201121589D1F1D557C1BF9F7B00A57A", hash_generated_method = "D4D1F608CBC16FD84D42DB5532E219EC")
        public ProgramRaster create() {
            mRS.validate();
            int id = mRS.nProgramRasterCreate(mPointSprite, mCullMode.mID);
            ProgramRaster programRaster = new ProgramRaster(id, mRS);
            programRaster.mPointSprite = mPointSprite;
            programRaster.mCullMode = mCullMode;
ProgramRaster var759CF772BE8BA815CF66A98368843F2A_1760996734 =             programRaster;
            var759CF772BE8BA815CF66A98368843F2A_1760996734.addTaint(taint);
            return var759CF772BE8BA815CF66A98368843F2A_1760996734;
            // ---------- Original Method ----------
            //mRS.validate();
            //int id = mRS.nProgramRasterCreate(mPointSprite, mCullMode.mID);
            //ProgramRaster programRaster = new ProgramRaster(id, mRS);
            //programRaster.mPointSprite = mPointSprite;
            //programRaster.mCullMode = mCullMode;
            //return programRaster;
        }

        
    }


    
}

