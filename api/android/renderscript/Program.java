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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.868 -0500", hash_original_field = "B3099B1BB425951D50FEA8BC75322BCD", hash_generated_field = "BC37F8BFB28840361B638806928F93D9")

    static final int MAX_INPUT = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.870 -0500", hash_original_field = "D30C0E89D0E37904D91613D002EC0888", hash_generated_field = "8E0C67F248298E15E3367C933B053156")

    static final int MAX_OUTPUT = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.872 -0500", hash_original_field = "9F58463AD1D8AC9470F9B975375CD5E1", hash_generated_field = "8FAD1175D6EC14B152C46D0C0C3BF1B0")

    static final int MAX_CONSTANT = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.874 -0500", hash_original_field = "3AE092B08DF7A0D345BC05A58B04F336", hash_generated_field = "FCE0EB393220018BDF32BA3A6D4D1585")

    static final int MAX_TEXTURE = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.889 -0500", hash_original_field = "E747B09A0C364548DFA046F423E5DA3C", hash_generated_field = "E747B09A0C364548DFA046F423E5DA3C")

    Element mInputs[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.891 -0500", hash_original_field = "C68FFFABB333621AA37308344C294A6F", hash_generated_field = "C68FFFABB333621AA37308344C294A6F")

    Element mOutputs[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.893 -0500", hash_original_field = "37EED3BE6641897FFD0E08260BC7464B", hash_generated_field = "37EED3BE6641897FFD0E08260BC7464B")

    Type mConstants[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.896 -0500", hash_original_field = "77B96B881C0A64CA6963432E756866F6", hash_generated_field = "77B96B881C0A64CA6963432E756866F6")

    TextureType mTextures[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.898 -0500", hash_original_field = "34C3DD77742DDA2316EC6BDB36F8248C", hash_generated_field = "34C3DD77742DDA2316EC6BDB36F8248C")

    int mTextureCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.900 -0500", hash_original_field = "54F2F4A2C4FE918D7E216DA83E4EE9FB", hash_generated_field = "54F2F4A2C4FE918D7E216DA83E4EE9FB")

    String mShader;
    
    public enum TextureType {
        TEXTURE_2D (0),
        TEXTURE_CUBE (1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.877 -0500", hash_original_field = "0B53E374282B34FB268F3024A1E73BA5", hash_generated_field = "0B53E374282B34FB268F3024A1E73BA5")

        int mID;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.880 -0500", hash_original_method = "890D2138B254D2C54059916FB254C211", hash_generated_method = "890D2138B254D2C54059916FB254C211")
            
TextureType(int id) {
            mID = id;
        }
    }
    
    enum ProgramParam {
        INPUT (0),
        OUTPUT (1),
        CONSTANT (2),
        TEXTURE_TYPE (3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.883 -0500", hash_original_field = "0B53E374282B34FB268F3024A1E73BA5", hash_generated_field = "0B53E374282B34FB268F3024A1E73BA5")

        int mID;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.886 -0500", hash_original_method = "60C931298359B2F9C68AA0F85FB7A779", hash_generated_method = "60C931298359B2F9C68AA0F85FB7A779")
            
ProgramParam(int id) {
            mID = id;
        }
    }
    
    public static class BaseProgramBuilder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.913 -0500", hash_original_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.915 -0500", hash_original_field = "E747B09A0C364548DFA046F423E5DA3C", hash_generated_field = "E747B09A0C364548DFA046F423E5DA3C")

        Element mInputs[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.917 -0500", hash_original_field = "C68FFFABB333621AA37308344C294A6F", hash_generated_field = "C68FFFABB333621AA37308344C294A6F")

        Element mOutputs[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.919 -0500", hash_original_field = "37EED3BE6641897FFD0E08260BC7464B", hash_generated_field = "37EED3BE6641897FFD0E08260BC7464B")

        Type mConstants[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.921 -0500", hash_original_field = "03B6CCA017FDA47D95819C51EC7E434F", hash_generated_field = "03B6CCA017FDA47D95819C51EC7E434F")

        Type mTextures[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.923 -0500", hash_original_field = "6DDD13AD449C9AB5EC98B04F13259E8A", hash_generated_field = "6DDD13AD449C9AB5EC98B04F13259E8A")

        TextureType mTextureTypes[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.925 -0500", hash_original_field = "637B7FBB53BCC71D1AEEA3ADFA2F5D36", hash_generated_field = "637B7FBB53BCC71D1AEEA3ADFA2F5D36")

        int mInputCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.928 -0500", hash_original_field = "08D031875A4A1E5D535EE01475E28A29", hash_generated_field = "08D031875A4A1E5D535EE01475E28A29")

        int mOutputCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.930 -0500", hash_original_field = "F3C84E5EC5C239A72B0227FC5CF96A0D", hash_generated_field = "F3C84E5EC5C239A72B0227FC5CF96A0D")

        int mConstantCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.932 -0500", hash_original_field = "34C3DD77742DDA2316EC6BDB36F8248C", hash_generated_field = "34C3DD77742DDA2316EC6BDB36F8248C")

        int mTextureCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.934 -0500", hash_original_field = "54F2F4A2C4FE918D7E216DA83E4EE9FB", hash_generated_field = "54F2F4A2C4FE918D7E216DA83E4EE9FB")

        String mShader;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.937 -0500", hash_original_method = "63AEAE3E9DFF86F82605C17C260A695A", hash_generated_method = "D5498AB755DACDC66346A1F33AFE7A20")
        
protected BaseProgramBuilder(RenderScript rs) {
            mRS = rs;
            mInputs = new Element[MAX_INPUT];
            mOutputs = new Element[MAX_OUTPUT];
            mConstants = new Type[MAX_CONSTANT];
            mInputCount = 0;
            mOutputCount = 0;
            mConstantCount = 0;
            mTextureCount = 0;
            mTextureTypes = new TextureType[MAX_TEXTURE];
        }

        /**
         * Sets the GLSL shader code to be used in the program
         *
         * @param s GLSL shader string
         * @return  self
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.939 -0500", hash_original_method = "FF16C67F383C574036DFC60B250EEEF2", hash_generated_method = "D39AF2951C7400E18E127E8543A85226")
        
public BaseProgramBuilder setShader(String s) {
            mShader = s;
            return this;
        }

        /**
         * Sets the GLSL shader code to be used in the program
         *
         * @param resources application resources
         * @param resourceID id of the file containing GLSL shader code
         *
         * @return  self
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.943 -0500", hash_original_method = "ED2FDB206F34FEF52139E837C5AA755A", hash_generated_method = "C56F875B76CFBDC444CF1BBE2DD9B507")
        
public BaseProgramBuilder setShader(Resources resources, int resourceID) {
            byte[] str;
            int strLength;
            InputStream is = resources.openRawResource(resourceID);
            try {
                try {
                    str = new byte[1024];
                    strLength = 0;
                    while(true) {
                        int bytesLeft = str.length - strLength;
                        if (bytesLeft == 0) {
                            byte[] buf2 = new byte[str.length * 2];
                            System.arraycopy(str, 0, buf2, 0, str.length);
                            str = buf2;
                            bytesLeft = str.length - strLength;
                        }
                        int bytesRead = is.read(str, strLength, bytesLeft);
                        if (bytesRead <= 0) {
                            break;
                        }
                        strLength += bytesRead;
                    }
                } finally {
                    is.close();
                }
            } catch(IOException e) {
                throw new Resources.NotFoundException();
            }

            try {
                mShader = new String(str, 0, strLength, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                Log.e("Renderscript shader creation", "Could not decode shader string");
            }

            return this;
        }

        /**
         * Queries the index of the last added constant buffer type
         *
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.945 -0500", hash_original_method = "5F149B188E50B29E19B8539B65E14210", hash_generated_method = "528B82FBA1B420426E56DB2610D1E8A1")
        
public int getCurrentConstantIndex() {
            return mConstantCount - 1;
        }

        /**
         * Queries the index of the last added texture type
         *
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.948 -0500", hash_original_method = "467C1DDFF09334AC57E34CD93B505419", hash_generated_method = "3ADD1F5602B19029B44DD6C0FFB64BB9")
        
public int getCurrentTextureIndex() {
            return mTextureCount - 1;
        }

        /**
         * Adds constant (uniform) inputs to the program
         *
         * @param t Type that describes the layout of the Allocation
         *          object to be used as constant inputs to the Program
         * @return  self
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.950 -0500", hash_original_method = "4E1ECDF73B11EBBAA54149A8F56B9D61", hash_generated_method = "C99EE7D454A05C28B25257694EA3AB00")
        
public BaseProgramBuilder addConstant(Type t) throws IllegalStateException {
            // Should check for consistant and non-conflicting names...
            if(mConstantCount >= MAX_CONSTANT) {
                throw new RSIllegalArgumentException("Max input count exceeded.");
            }
            if (t.getElement().isComplex()) {
                throw new RSIllegalArgumentException("Complex elements not allowed.");
            }
            mConstants[mConstantCount] = t;
            mConstantCount++;
            return this;
        }

        /**
         * Adds a texture input to the Program
         *
         * @param texType describes that the texture to append it (2D,
         *                Cubemap, etc.)
         * @return  self
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.953 -0500", hash_original_method = "3AB5FDF932EF6EC77655D60EC646F9F8", hash_generated_method = "1135714EB7DD65A9AB187E8EAB4B87C7")
        
public BaseProgramBuilder addTexture(TextureType texType) throws IllegalArgumentException {
            if(mTextureCount >= MAX_TEXTURE) {
                throw new IllegalArgumentException("Max texture count exceeded.");
            }
            mTextureTypes[mTextureCount ++] = texType;
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.955 -0500", hash_original_method = "541331178AEB5C97A6D2E3E28F10ADFD", hash_generated_method = "AEF7AED8F66D8B3B201949D0703AB9B5")
        
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
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.903 -0500", hash_original_method = "C5418AC42B4427585CE67C27729678D3", hash_generated_method = "C5418AC42B4427585CE67C27729678D3")
    
Program(int id, RenderScript rs) {
        super(id, rs);
    }

    /**
     * Binds a constant buffer to be used as uniform inputs to the
     * program
     *
     * @param a allocation containing uniform data
     * @param slot index within the program's list of constant
     *             buffer allocations
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.905 -0500", hash_original_method = "002BA51785B71C2E50AE0C2AD1D7634D", hash_generated_method = "1924CC4E06D7BD970F950DF1C2A728FF")
    
public void bindConstants(Allocation a, int slot) {
        if (slot < 0 || slot >= mConstants.length) {
            throw new IllegalArgumentException("Slot ID out of range.");
        }
        if (a != null &&
            a.getType().getID() != mConstants[slot].getID()) {
            throw new IllegalArgumentException("Allocation type does not match slot type.");
        }
        int id = a != null ? a.getID() : 0;
        mRS.nProgramBindConstants(getID(), slot, id);
    }

    /**
     * Binds a texture to be used in the program
     *
     * @param va allocation containing texture data
     * @param slot index within the program's list of textures
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.907 -0500", hash_original_method = "0F929F0C8DC1843BD8DBD2B052064009", hash_generated_method = "D00F7801AB8827B06750667ED03BD306")
    
public void bindTexture(Allocation va, int slot)
        throws IllegalArgumentException {
        mRS.validate();
        if ((slot < 0) || (slot >= mTextureCount)) {
            throw new IllegalArgumentException("Slot ID out of range.");
        }
        if (va != null && va.getType().hasFaces() &&
            mTextures[slot] != TextureType.TEXTURE_CUBE) {
            throw new IllegalArgumentException("Cannot bind cubemap to 2d texture slot");
        }

        int id = va != null ? va.getID() : 0;
        mRS.nProgramBindTexture(getID(), slot, id);
    }

    /**
     * Binds an object that describes how a texture at the
     * corresponding location is sampled
     *
     * @param vs sampler for a corresponding texture
     * @param slot index within the program's list of textures to
     *             use the sampler on
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:03.910 -0500", hash_original_method = "B2C558B84E6818BCD922065D1FCE7093", hash_generated_method = "4C04A183D7C55A05B3A2973CB3A01FEE")
    
public void bindSampler(Sampler vs, int slot)
        throws IllegalArgumentException {
        mRS.validate();
        if ((slot < 0) || (slot >= mTextureCount)) {
            throw new IllegalArgumentException("Slot ID out of range.");
        }

        int id = vs != null ? vs.getID() : 0;
        mRS.nProgramBindSampler(getID(), slot, id);
    }
}

