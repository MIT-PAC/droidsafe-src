package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import android.content.res.Resources;
public class Program extends BaseObj {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:00.910 -0400", hash_original_field = "4EF68E720B018C5AA888A7926727C17E", hash_generated_field = "E747B09A0C364548DFA046F423E5DA3C")

    Element mInputs[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:00.913 -0400", hash_original_field = "D40078FF9DA5C6DC726CEA9E44829118", hash_generated_field = "C68FFFABB333621AA37308344C294A6F")

    Element mOutputs[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:00.915 -0400", hash_original_field = "2099423DE0A9AC126576D9A990DEE301", hash_generated_field = "37EED3BE6641897FFD0E08260BC7464B")

    Type mConstants[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:00.918 -0400", hash_original_field = "B64A89B1EF649B819BB28C59CDF785E8", hash_generated_field = "77B96B881C0A64CA6963432E756866F6")

    TextureType mTextures[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:00.921 -0400", hash_original_field = "0C23E1E8D4403B03F49BFB00EB8F652F", hash_generated_field = "34C3DD77742DDA2316EC6BDB36F8248C")

    int mTextureCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:00.931 -0400", hash_original_field = "A3C15874DE554606CB943AF3D68F568F", hash_generated_field = "54F2F4A2C4FE918D7E216DA83E4EE9FB")

    String mShader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:00.937 -0400", hash_original_method = "C5418AC42B4427585CE67C27729678D3", hash_generated_method = "812920356D4C4F29960E9F8163353A0E")
      Program(int id, RenderScript rs) {
        super(id, rs);
        addTaint(rs.getTaint());
        addTaint(id);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:00.957 -0400", hash_original_method = "002BA51785B71C2E50AE0C2AD1D7634D", hash_generated_method = "2B84468F327425A91F0801E161E592CE")
    public void bindConstants(Allocation a, int slot) {
        addTaint(slot);
        addTaint(a.getTaint());
        if(slot < 0 || slot >= mConstants.length)        
        {
            IllegalArgumentException varCF0C31C4DC1CB6D69D35BB5BA632DC52_1071228761 = new IllegalArgumentException("Slot ID out of range.");
            varCF0C31C4DC1CB6D69D35BB5BA632DC52_1071228761.addTaint(taint);
            throw varCF0C31C4DC1CB6D69D35BB5BA632DC52_1071228761;
        } //End block
        if(a != null &&
            a.getType().getID() != mConstants[slot].getID())        
        {
            IllegalArgumentException var1E863D50C2FF2D1CCE56BFF8A4474838_1327302006 = new IllegalArgumentException("Allocation type does not match slot type.");
            var1E863D50C2FF2D1CCE56BFF8A4474838_1327302006.addTaint(taint);
            throw var1E863D50C2FF2D1CCE56BFF8A4474838_1327302006;
        } //End block
        int id = a != null ? a.getID() : 0;
        mRS.nProgramBindConstants(getID(), slot, id);
        // ---------- Original Method ----------
        //if (slot < 0 || slot >= mConstants.length) {
            //throw new IllegalArgumentException("Slot ID out of range.");
        //}
        //if (a != null &&
            //a.getType().getID() != mConstants[slot].getID()) {
            //throw new IllegalArgumentException("Allocation type does not match slot type.");
        //}
        //int id = a != null ? a.getID() : 0;
        //mRS.nProgramBindConstants(getID(), slot, id);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:00.979 -0400", hash_original_method = "0F929F0C8DC1843BD8DBD2B052064009", hash_generated_method = "E860DA58F781518ABE0F972AE4BDF008")
    public void bindTexture(Allocation va, int slot) throws IllegalArgumentException {
        addTaint(slot);
        addTaint(va.getTaint());
        mRS.validate();
        if((slot < 0) || (slot >= mTextureCount))        
        {
            IllegalArgumentException varCF0C31C4DC1CB6D69D35BB5BA632DC52_1213302988 = new IllegalArgumentException("Slot ID out of range.");
            varCF0C31C4DC1CB6D69D35BB5BA632DC52_1213302988.addTaint(taint);
            throw varCF0C31C4DC1CB6D69D35BB5BA632DC52_1213302988;
        } //End block
        if(va != null && va.getType().hasFaces() &&
            mTextures[slot] != TextureType.TEXTURE_CUBE)        
        {
            IllegalArgumentException varDB76F2CF50D133F6504AA0EFE1269560_408260154 = new IllegalArgumentException("Cannot bind cubemap to 2d texture slot");
            varDB76F2CF50D133F6504AA0EFE1269560_408260154.addTaint(taint);
            throw varDB76F2CF50D133F6504AA0EFE1269560_408260154;
        } //End block
        int id = va != null ? va.getID() : 0;
        mRS.nProgramBindTexture(getID(), slot, id);
        // ---------- Original Method ----------
        //mRS.validate();
        //if ((slot < 0) || (slot >= mTextureCount)) {
            //throw new IllegalArgumentException("Slot ID out of range.");
        //}
        //if (va != null && va.getType().hasFaces() &&
            //mTextures[slot] != TextureType.TEXTURE_CUBE) {
            //throw new IllegalArgumentException("Cannot bind cubemap to 2d texture slot");
        //}
        //int id = va != null ? va.getID() : 0;
        //mRS.nProgramBindTexture(getID(), slot, id);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:00.995 -0400", hash_original_method = "B2C558B84E6818BCD922065D1FCE7093", hash_generated_method = "60C39C3BDFA8285CA38A7DD8692E479E")
    public void bindSampler(Sampler vs, int slot) throws IllegalArgumentException {
        addTaint(slot);
        addTaint(vs.getTaint());
        mRS.validate();
        if((slot < 0) || (slot >= mTextureCount))        
        {
            IllegalArgumentException varCF0C31C4DC1CB6D69D35BB5BA632DC52_1961381132 = new IllegalArgumentException("Slot ID out of range.");
            varCF0C31C4DC1CB6D69D35BB5BA632DC52_1961381132.addTaint(taint);
            throw varCF0C31C4DC1CB6D69D35BB5BA632DC52_1961381132;
        } //End block
        int id = vs != null ? vs.getID() : 0;
        mRS.nProgramBindSampler(getID(), slot, id);
        // ---------- Original Method ----------
        //mRS.validate();
        //if ((slot < 0) || (slot >= mTextureCount)) {
            //throw new IllegalArgumentException("Slot ID out of range.");
        //}
        //int id = vs != null ? vs.getID() : 0;
        //mRS.nProgramBindSampler(getID(), slot, id);
    }

    
    public enum TextureType {
        TEXTURE_2D (0),
        TEXTURE_CUBE (1);
        int mID;
        TextureType(int id) {
            mID = id;
        }
    }

    
    enum ProgramParam {
        INPUT (0),
        OUTPUT (1),
        CONSTANT (2),
        TEXTURE_TYPE (3);
        int mID;
        ProgramParam(int id) {
            mID = id;
        }
    }

    
    public static class BaseProgramBuilder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.001 -0400", hash_original_field = "15EADDEB24354180E81F0ADC804C4CED", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.004 -0400", hash_original_field = "4EF68E720B018C5AA888A7926727C17E", hash_generated_field = "E747B09A0C364548DFA046F423E5DA3C")

        Element mInputs[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.011 -0400", hash_original_field = "D40078FF9DA5C6DC726CEA9E44829118", hash_generated_field = "C68FFFABB333621AA37308344C294A6F")

        Element mOutputs[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.014 -0400", hash_original_field = "2099423DE0A9AC126576D9A990DEE301", hash_generated_field = "37EED3BE6641897FFD0E08260BC7464B")

        Type mConstants[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.016 -0400", hash_original_field = "B64A89B1EF649B819BB28C59CDF785E8", hash_generated_field = "03B6CCA017FDA47D95819C51EC7E434F")

        Type mTextures[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.018 -0400", hash_original_field = "8D8E15BD339AE5114A41174DAE87D8A6", hash_generated_field = "6DDD13AD449C9AB5EC98B04F13259E8A")

        TextureType mTextureTypes[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.020 -0400", hash_original_field = "BCA30B26E891827E09B56E48975392ED", hash_generated_field = "637B7FBB53BCC71D1AEEA3ADFA2F5D36")

        int mInputCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.024 -0400", hash_original_field = "83EF9A1241A53487BF0F34083065BE00", hash_generated_field = "08D031875A4A1E5D535EE01475E28A29")

        int mOutputCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.028 -0400", hash_original_field = "7C8024CAA99E13FE5E1FD87E2BA6DE96", hash_generated_field = "F3C84E5EC5C239A72B0227FC5CF96A0D")

        int mConstantCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.032 -0400", hash_original_field = "0C23E1E8D4403B03F49BFB00EB8F652F", hash_generated_field = "34C3DD77742DDA2316EC6BDB36F8248C")

        int mTextureCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.035 -0400", hash_original_field = "A3C15874DE554606CB943AF3D68F568F", hash_generated_field = "54F2F4A2C4FE918D7E216DA83E4EE9FB")

        String mShader;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.054 -0400", hash_original_method = "63AEAE3E9DFF86F82605C17C260A695A", hash_generated_method = "D5C54877EDF28F79F396D213705A84CB")
        protected  BaseProgramBuilder(RenderScript rs) {
            mRS = rs;
            mInputs = new Element[MAX_INPUT];
            mOutputs = new Element[MAX_OUTPUT];
            mConstants = new Type[MAX_CONSTANT];
            mInputCount = 0;
            mOutputCount = 0;
            mConstantCount = 0;
            mTextureCount = 0;
            mTextureTypes = new TextureType[MAX_TEXTURE];
            // ---------- Original Method ----------
            //mRS = rs;
            //mInputs = new Element[MAX_INPUT];
            //mOutputs = new Element[MAX_OUTPUT];
            //mConstants = new Type[MAX_CONSTANT];
            //mInputCount = 0;
            //mOutputCount = 0;
            //mConstantCount = 0;
            //mTextureCount = 0;
            //mTextureTypes = new TextureType[MAX_TEXTURE];
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.059 -0400", hash_original_method = "FF16C67F383C574036DFC60B250EEEF2", hash_generated_method = "CE83448BA3F081A75227157264814DFC")
        public BaseProgramBuilder setShader(String s) {
            mShader = s;
BaseProgramBuilder var72A74007B2BE62B849F475C7BDA4658B_1843760024 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1843760024.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1843760024;
            // ---------- Original Method ----------
            //mShader = s;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.082 -0400", hash_original_method = "ED2FDB206F34FEF52139E837C5AA755A", hash_generated_method = "A4297E06224ADFA3A391800A2DAE7E6C")
        public BaseProgramBuilder setShader(Resources resources, int resourceID) {
            addTaint(resourceID);
            addTaint(resources.getTaint());
            byte[] str;
            int strLength;
            InputStream is = resources.openRawResource(resourceID);
            try 
            {
                try 
                {
                    str = new byte[1024];
                    strLength = 0;
                    while
(true)                    
                    {
                        int bytesLeft = str.length - strLength;
                        if(bytesLeft == 0)                        
                        {
                            byte[] buf2 = new byte[str.length * 2];
                            System.arraycopy(str, 0, buf2, 0, str.length);
                            str = buf2;
                            bytesLeft = str.length - strLength;
                        } //End block
                        int bytesRead = is.read(str, strLength, bytesLeft);
                        if(bytesRead <= 0)                        
                        {
                            break;
                        } //End block
                        strLength += bytesRead;
                    } //End block
                } //End block
                finally 
                {
                    is.close();
                } //End block
            } //End block
            catch (IOException e)
            {
                Resources.NotFoundException var457DB541DC73F332DBA5456C3D16FD10_1590872233 = new Resources.NotFoundException();
                var457DB541DC73F332DBA5456C3D16FD10_1590872233.addTaint(taint);
                throw var457DB541DC73F332DBA5456C3D16FD10_1590872233;
            } //End block
            try 
            {
                mShader = new String(str, 0, strLength, "UTF-8");
            } //End block
            catch (UnsupportedEncodingException e)
            {
            } //End block
BaseProgramBuilder var72A74007B2BE62B849F475C7BDA4658B_2077137275 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2077137275.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2077137275;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.091 -0400", hash_original_method = "5F149B188E50B29E19B8539B65E14210", hash_generated_method = "F46F28211598F4B904F22AB86F299E50")
        public int getCurrentConstantIndex() {
            int var677F7AF84F1D13D06BD9C3C87AE36A8D_1462116947 = (mConstantCount - 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14863105 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14863105;
            // ---------- Original Method ----------
            //return mConstantCount - 1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.099 -0400", hash_original_method = "467C1DDFF09334AC57E34CD93B505419", hash_generated_method = "E2ACB436BF9D540FCCC2639FF8D11A06")
        public int getCurrentTextureIndex() {
            int var727FB2B8D8DDBF1CA78ED512140FD838_332326716 = (mTextureCount - 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564045938 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564045938;
            // ---------- Original Method ----------
            //return mTextureCount - 1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.112 -0400", hash_original_method = "4E1ECDF73B11EBBAA54149A8F56B9D61", hash_generated_method = "097A69393CB3638502315321EAF7EB82")
        public BaseProgramBuilder addConstant(Type t) throws IllegalStateException {
            if(mConstantCount >= MAX_CONSTANT)            
            {
                RSIllegalArgumentException var067A15C360F4654859D3EEA9E53BE0D7_1108854278 = new RSIllegalArgumentException("Max input count exceeded.");
                var067A15C360F4654859D3EEA9E53BE0D7_1108854278.addTaint(taint);
                throw var067A15C360F4654859D3EEA9E53BE0D7_1108854278;
            } //End block
            if(t.getElement().isComplex())            
            {
                RSIllegalArgumentException var799A0F017B985C5131347C34FEAE8D6C_1769050134 = new RSIllegalArgumentException("Complex elements not allowed.");
                var799A0F017B985C5131347C34FEAE8D6C_1769050134.addTaint(taint);
                throw var799A0F017B985C5131347C34FEAE8D6C_1769050134;
            } //End block
            mConstants[mConstantCount] = t;
            mConstantCount++;
BaseProgramBuilder var72A74007B2BE62B849F475C7BDA4658B_1096351958 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1096351958.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1096351958;
            // ---------- Original Method ----------
            //if(mConstantCount >= MAX_CONSTANT) {
                //throw new RSIllegalArgumentException("Max input count exceeded.");
            //}
            //if (t.getElement().isComplex()) {
                //throw new RSIllegalArgumentException("Complex elements not allowed.");
            //}
            //mConstants[mConstantCount] = t;
            //mConstantCount++;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.122 -0400", hash_original_method = "3AB5FDF932EF6EC77655D60EC646F9F8", hash_generated_method = "427EFDE021B4465635015F08A17D3B93")
        public BaseProgramBuilder addTexture(TextureType texType) throws IllegalArgumentException {
            if(mTextureCount >= MAX_TEXTURE)            
            {
                IllegalArgumentException var85C83840A7E7A76FB809B7E236CF3B6A_223518673 = new IllegalArgumentException("Max texture count exceeded.");
                var85C83840A7E7A76FB809B7E236CF3B6A_223518673.addTaint(taint);
                throw var85C83840A7E7A76FB809B7E236CF3B6A_223518673;
            } //End block
            mTextureTypes[mTextureCount ++] = texType;
BaseProgramBuilder var72A74007B2BE62B849F475C7BDA4658B_553740737 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_553740737.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_553740737;
            // ---------- Original Method ----------
            //if(mTextureCount >= MAX_TEXTURE) {
                //throw new IllegalArgumentException("Max texture count exceeded.");
            //}
            //mTextureTypes[mTextureCount ++] = texType;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.144 -0400", hash_original_method = "541331178AEB5C97A6D2E3E28F10ADFD", hash_generated_method = "04304DA164B1CD9ED5434DF0EF8B152C")
        protected void initProgram(Program p) {
            p.mInputs = new Element[mInputCount];
            System.arraycopy(mInputs, 0, p.mInputs, 0, mInputCount);
            p.mOutputs = new Element[mOutputCount];
            System.arraycopy(mOutputs, 0, p.mOutputs, 0, mOutputCount);
            p.mConstants = new Type[mConstantCount];
            System.arraycopy(mConstants, 0, p.mConstants, 0, mConstantCount);
            p.mTextureCount = mTextureCount;
            p.mTextures = new TextureType[mTextureCount];
            System.arraycopy(mTextureTypes, 0, p.mTextures, 0, mTextureCount);
            // ---------- Original Method ----------
            //p.mInputs = new Element[mInputCount];
            //System.arraycopy(mInputs, 0, p.mInputs, 0, mInputCount);
            //p.mOutputs = new Element[mOutputCount];
            //System.arraycopy(mOutputs, 0, p.mOutputs, 0, mOutputCount);
            //p.mConstants = new Type[mConstantCount];
            //System.arraycopy(mConstants, 0, p.mConstants, 0, mConstantCount);
            //p.mTextureCount = mTextureCount;
            //p.mTextures = new TextureType[mTextureCount];
            //System.arraycopy(mTextureTypes, 0, p.mTextures, 0, mTextureCount);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.147 -0400", hash_original_field = "3FF99FCFE5C790D895A67EB61859202B", hash_generated_field = "BC37F8BFB28840361B638806928F93D9")

    static final int MAX_INPUT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.150 -0400", hash_original_field = "E20B99ECB45E59EDFFB2A5124DB94E75", hash_generated_field = "8E0C67F248298E15E3367C933B053156")

    static final int MAX_OUTPUT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.152 -0400", hash_original_field = "86F89AEF1E3EDC67D9A3342557140544", hash_generated_field = "8FAD1175D6EC14B152C46D0C0C3BF1B0")

    static final int MAX_CONSTANT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:01.155 -0400", hash_original_field = "37D3D69DBC3F61BF67C0D80BF3F30DDC", hash_generated_field = "FCE0EB393220018BDF32BA3A6D4D1585")

    static final int MAX_TEXTURE = 8;
}

