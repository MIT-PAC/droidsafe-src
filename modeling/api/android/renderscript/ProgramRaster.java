package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
public class ProgramRaster extends BaseObj {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.031 -0500", hash_original_method = "B45B30DADB58E52197690550898E7B6B", hash_generated_method = "DC6D9F4B1E12E7124E2C7AB9E9C400CF")
    
public static ProgramRaster CULL_BACK(RenderScript rs) {
        if(rs.mProgramRaster_CULL_BACK == null) {
            ProgramRaster.Builder builder = new ProgramRaster.Builder(rs);
            builder.setCullMode(CullMode.BACK);
            rs.mProgramRaster_CULL_BACK = builder.create();
        }
        return rs.mProgramRaster_CULL_BACK;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.033 -0500", hash_original_method = "C338563961D95E9CBF2C761B4110D328", hash_generated_method = "D14C4BE73A42E74941D93ADE67D21280")
    
public static ProgramRaster CULL_FRONT(RenderScript rs) {
        if(rs.mProgramRaster_CULL_FRONT == null) {
            ProgramRaster.Builder builder = new ProgramRaster.Builder(rs);
            builder.setCullMode(CullMode.FRONT);
            rs.mProgramRaster_CULL_FRONT = builder.create();
        }
        return rs.mProgramRaster_CULL_FRONT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.036 -0500", hash_original_method = "81F52F7F6091CFF0B01CA74F1515C776", hash_generated_method = "AC4A7B829F3EA27D56FC95CE181C2EAD")
    
public static ProgramRaster CULL_NONE(RenderScript rs) {
        if(rs.mProgramRaster_CULL_NONE == null) {
            ProgramRaster.Builder builder = new ProgramRaster.Builder(rs);
            builder.setCullMode(CullMode.NONE);
            rs.mProgramRaster_CULL_NONE = builder.create();
        }
        return rs.mProgramRaster_CULL_NONE;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.020 -0500", hash_original_field = "F5AC5A34ED9B3F99113F766A014FABE4", hash_generated_field = "F5AC5A34ED9B3F99113F766A014FABE4")

    boolean mPointSprite;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.022 -0500", hash_original_field = "9FA33B9FFF9AB6B073377EBA3FA57AC7", hash_generated_field = "9FA33B9FFF9AB6B073377EBA3FA57AC7")

    CullMode mCullMode;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.024 -0500", hash_original_method = "894C81580448C83340BD6FC91F1FBF06", hash_generated_method = "894C81580448C83340BD6FC91F1FBF06")
    
ProgramRaster(int id, RenderScript rs) {
        super(id, rs);

        mPointSprite = false;
        mCullMode = CullMode.BACK;
    }

    /**
     * @hide
     * @return whether point sprites are enabled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.026 -0500", hash_original_method = "F919B6D858DA98A8D6F899FC9949AF17", hash_generated_method = "BA55640A14340CF0312D25367BBBB758")
    
public boolean getPointSpriteEnabled() {
        return mPointSprite;
    }

    /**
     * @hide
     * @return cull mode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.029 -0500", hash_original_method = "9D9A5D91910AD22DEA2607A5096E0D2B", hash_generated_method = "FCB98D5A29CA48864B507BAEA061680A")
    
public CullMode getCullMode() {
        return mCullMode;
    }
    
    public enum CullMode {
        BACK (0),
        FRONT (1),
        NONE (2);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.013 -0500", hash_original_field = "0B53E374282B34FB268F3024A1E73BA5", hash_generated_field = "0B53E374282B34FB268F3024A1E73BA5")

        int mID;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.017 -0500", hash_original_method = "B61747BBEA86E5C9AEAB3224C03DAB64", hash_generated_method = "B61747BBEA86E5C9AEAB3224C03DAB64")
            
CullMode(int id) {
            mID = id;
        }
    }
    
    public static class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.038 -0500", hash_original_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.040 -0500", hash_original_field = "F5AC5A34ED9B3F99113F766A014FABE4", hash_generated_field = "F5AC5A34ED9B3F99113F766A014FABE4")

        boolean mPointSprite;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.042 -0500", hash_original_field = "9FA33B9FFF9AB6B073377EBA3FA57AC7", hash_generated_field = "9FA33B9FFF9AB6B073377EBA3FA57AC7")

        CullMode mCullMode;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.045 -0500", hash_original_method = "1E8388B7448CFC4A6F961C903791989B", hash_generated_method = "DD27137D7A1D3F7207EFD5ACD8A67760")
        
public Builder(RenderScript rs) {
            mRS = rs;
            mPointSprite = false;
            mCullMode = CullMode.BACK;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.047 -0500", hash_original_method = "8E3B02261392357829242E8A2823D9BA", hash_generated_method = "CAAD4EBFD49646413001F1EC18460DEA")
        
public Builder setPointSpriteEnabled(boolean enable) {
            mPointSprite = enable;
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.050 -0500", hash_original_method = "5BEDACC205FE11487443D5D48E3468FF", hash_generated_method = "E09EC2E93665B072D79A5132D45ABA21")
        
public Builder setCullMode(CullMode m) {
            mCullMode = m;
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.052 -0500", hash_original_method = "1201121589D1F1D557C1BF9F7B00A57A", hash_generated_method = "5799D3C0A8BB20E97D37C79B8F8D3758")
        
public ProgramRaster create() {
            mRS.validate();
            int id = mRS.nProgramRasterCreate(mPointSprite, mCullMode.mID);
            ProgramRaster programRaster = new ProgramRaster(id, mRS);
            programRaster.mPointSprite = mPointSprite;
            programRaster.mCullMode = mCullMode;
            return programRaster;
        }
        
    }
    
}

