package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
public class ProgramFragmentFixedFunction extends ProgramFragment {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.374 -0500", hash_original_method = "2A0FFECD56CD5C732668EEC76534036D", hash_generated_method = "2A0FFECD56CD5C732668EEC76534036D")
    ProgramFragmentFixedFunction(int id, RenderScript rs) {
        super(id, rs);
    }

    
    static class InternalBuilder extends BaseProgramBuilder {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.375 -0500", hash_original_method = "3D66AE7CFC6D0E068FD8C5ABF2875F8E", hash_generated_method = "90FB3BFBB3978AD101B037A64F848DBB")
        public InternalBuilder(RenderScript rs) {
            super(rs);
        }

        /**
         * Creates ProgramFragmentFixedFunction from the current state
         * of the builder
         *
         * @return  ProgramFragmentFixedFunction
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.376 -0500", hash_original_method = "7DD57EC723991E6F8C51D4D9D2500308", hash_generated_method = "6F25A8B5DECEABA945AC7BA918121214")
        public ProgramFragmentFixedFunction create() {
            mRS.validate();
            int[] tmp = new int[(mInputCount + mOutputCount + mConstantCount + mTextureCount) * 2];
            int idx = 0;

            for (int i=0; i < mInputCount; i++) {
                tmp[idx++] = ProgramParam.INPUT.mID;
                tmp[idx++] = mInputs[i].getID();
            }
            for (int i=0; i < mOutputCount; i++) {
                tmp[idx++] = ProgramParam.OUTPUT.mID;
                tmp[idx++] = mOutputs[i].getID();
            }
            for (int i=0; i < mConstantCount; i++) {
                tmp[idx++] = ProgramParam.CONSTANT.mID;
                tmp[idx++] = mConstants[i].getID();
            }
            for (int i=0; i < mTextureCount; i++) {
                tmp[idx++] = ProgramParam.TEXTURE_TYPE.mID;
                tmp[idx++] = mTextureTypes[i].mID;
            }

            int id = mRS.nProgramFragmentCreate(mShader, tmp);
            ProgramFragmentFixedFunction pf = new ProgramFragmentFixedFunction(id, mRS);
            initProgram(pf);
            return pf;
        }

        
    }


    
    public static class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.378 -0500", hash_original_field = "1F002A5FFE4CD3118A7F221649B77A0A", hash_generated_field = "D118099FAF0CA6FBAD03B4A799F8496F")

        public static final int MAX_TEXTURE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.379 -0500", hash_original_field = "5EBE2D4E6525687A45933CC3EF6AE134", hash_generated_field = "5EBE2D4E6525687A45933CC3EF6AE134")

        int mNumTextures;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.380 -0500", hash_original_field = "F7B5253FBC182C9C461FE015FFB50788", hash_generated_field = "F7B5253FBC182C9C461FE015FFB50788")

        boolean mPointSpriteEnable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.380 -0500", hash_original_field = "B9BA2C47AA10798901FCB3AD89A619C3", hash_generated_field = "B9BA2C47AA10798901FCB3AD89A619C3")

        boolean mVaryingColorEnable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.381 -0500", hash_original_field = "54F2F4A2C4FE918D7E216DA83E4EE9FB", hash_generated_field = "54F2F4A2C4FE918D7E216DA83E4EE9FB")

        String mShader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.382 -0500", hash_original_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.394 -0500", hash_original_field = "B67103FC01CD4B885D5571B0ADD4D716", hash_generated_field = "B67103FC01CD4B885D5571B0ADD4D716")

        Slot[] mSlots;

        /**
         * Creates a builder for fixed function fragment program
         *
         * @param rs Context to which the program will belong.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.396 -0500", hash_original_method = "30E90F3B75611917E8432C24A0A6175A", hash_generated_method = "7D407CF6AA77E71DBBA3D6EC3B90ECC0")
        public Builder(RenderScript rs) {
            mRS = rs;
            mSlots = new Slot[MAX_TEXTURE];
            mPointSpriteEnable = false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.395 -0500", hash_original_method = "3F6F70CDA9BD5D62D40FB2B1189D5392", hash_generated_method = "80D2C71AE69E1846D25FDCBFD9EFA22A")
        private void buildShaderString() {
            mShader  = "//rs_shader_internal\n";
            mShader += "varying lowp vec4 varColor;\n";
            mShader += "varying vec2 varTex0;\n";

            mShader += "void main() {\n";
            if (mVaryingColorEnable) {
                mShader += "  lowp vec4 col = varColor;\n";
            } else {
                mShader += "  lowp vec4 col = UNI_Color;\n";
            }

            if (mNumTextures != 0) {
                if (mPointSpriteEnable) {
                    mShader += "  vec2 t0 = gl_PointCoord;\n";
                } else {
                    mShader += "  vec2 t0 = varTex0.xy;\n";
                }
            }

            for(int i = 0; i < mNumTextures; i ++) {
                switch(mSlots[i].env) {
                case REPLACE:
                    switch (mSlots[i].format) {
                    case ALPHA:
                        mShader += "  col.a = texture2D(UNI_Tex0, t0).a;\n";
                        break;
                    case LUMINANCE_ALPHA:
                        mShader += "  col.rgba = texture2D(UNI_Tex0, t0).rgba;\n";
                        break;
                    case RGB:
                        mShader += "  col.rgb = texture2D(UNI_Tex0, t0).rgb;\n";
                        break;
                    case RGBA:
                        mShader += "  col.rgba = texture2D(UNI_Tex0, t0).rgba;\n";
                        break;
                    }
                    break;
                case MODULATE:
                    switch (mSlots[i].format) {
                    case ALPHA:
                        mShader += "  col.a *= texture2D(UNI_Tex0, t0).a;\n";
                        break;
                    case LUMINANCE_ALPHA:
                        mShader += "  col.rgba *= texture2D(UNI_Tex0, t0).rgba;\n";
                        break;
                    case RGB:
                        mShader += "  col.rgb *= texture2D(UNI_Tex0, t0).rgb;\n";
                        break;
                    case RGBA:
                        mShader += "  col.rgba *= texture2D(UNI_Tex0, t0).rgba;\n";
                        break;
                    }
                    break;
                case DECAL:
                    mShader += "  col = texture2D(UNI_Tex0, t0);\n";
                    break;
                }
            }

            mShader += "  gl_FragColor = col;\n";
            mShader += "}\n";
        }

        /**
         * Adds a texture to be fetched as part of the fixed function
         * fragment program
         *
         * @param env specifies how the texture is combined with the
         *            current color
         * @param fmt specifies the format of the texture and how its
         *            components will be used to combine with the
         *            current color
         * @param slot index of the texture to apply the operations on
         *
         * @return this
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.397 -0500", hash_original_method = "F52C9ED64BC7C6FC8999E2931805AE1F", hash_generated_method = "371AFD039C12D4D0D8AE6DE233BA53B0")
        public Builder setTexture(EnvMode env, Format fmt, int slot)
            throws IllegalArgumentException {
            if((slot < 0) || (slot >= MAX_TEXTURE)) {
                throw new IllegalArgumentException("MAX_TEXTURE exceeded.");
            }
            mSlots[slot] = new Slot(env, fmt);
            return this;
        }

        /**
         * Specifies whether the texture coordinate passed from the
         * vertex program is replaced with an openGL internal point
         * sprite texture coordinate
         *
         **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.398 -0500", hash_original_method = "3DF94441BBEEF2DAAF6E4E2BA3DC7FCD", hash_generated_method = "7BEE0FD664772D9FF1AD074072BC6077")
        public Builder setPointSpriteTexCoordinateReplacement(boolean enable) {
            mPointSpriteEnable = enable;
            return this;
        }

        /**
         * Specifies whether the varying color passed from the vertex
         * program or the constant color set on the fragment program is
         * used in the final color calculation in the fixed function
         * fragment shader
         *
         **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.399 -0500", hash_original_method = "D1AB2679757C6095D46ED85B9CF52D59", hash_generated_method = "7AE46836E8824E08AD1DBCBFED407F2F")
        public Builder setVaryingColor(boolean enable) {
            mVaryingColorEnable = enable;
            return this;
        }

        
        public enum EnvMode {
            REPLACE (1),
            MODULATE (2),
            DECAL (3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.383 -0500", hash_original_field = "0B53E374282B34FB268F3024A1E73BA5", hash_generated_field = "0B53E374282B34FB268F3024A1E73BA5")


            int mID;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.384 -0500", hash_original_method = "BC2794D90A010B5BEE2BCC9613647072", hash_generated_method = "BC2794D90A010B5BEE2BCC9613647072")
                EnvMode(int id) {
                mID = id;
            }
        }

        
        public enum Format {
            ALPHA (1),
            LUMINANCE_ALPHA (2),
            RGB (3),
            RGBA (4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.388 -0500", hash_original_field = "0B53E374282B34FB268F3024A1E73BA5", hash_generated_field = "0B53E374282B34FB268F3024A1E73BA5")


            int mID;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.389 -0500", hash_original_method = "2B69801ED3396BD5684C671CD8CCE22F", hash_generated_method = "2B69801ED3396BD5684C671CD8CCE22F")
                Format(int id) {
                mID = id;
            }
        }

        
        private class Slot {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.391 -0500", hash_original_field = "9F74C5A2DE54F696FBAF5E851601C0E8", hash_generated_field = "9F74C5A2DE54F696FBAF5E851601C0E8")

            EnvMode env;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.392 -0500", hash_original_field = "381386A1132E12A7CB58DF05EF5AB5BB", hash_generated_field = "381386A1132E12A7CB58DF05EF5AB5BB")

            Format format;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.393 -0500", hash_original_method = "6603C262DCA775BA18F529F86363B60E", hash_generated_method = "6603C262DCA775BA18F529F86363B60E")
            Slot(EnvMode _env, Format _fmt) {
                env = _env;
                format = _fmt;
            }

            
        }

        /**
        * Creates the fixed function fragment program from the current
        * state of the builder.
        *
        */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:48.400 -0500", hash_original_method = "3191286FB0D548047357A5725F784799", hash_generated_method = "04B816B88698BF566D662C4705F90071")
        public ProgramFragmentFixedFunction create() {
            InternalBuilder sb = new InternalBuilder(mRS);
            mNumTextures = 0;
            for(int i = 0; i < MAX_TEXTURE; i ++) {
                if(mSlots[i] != null) {
                    mNumTextures ++;
                }
            }
            buildShaderString();
            sb.setShader(mShader);

            Type constType = null;
            if (!mVaryingColorEnable) {
                Element.Builder b = new Element.Builder(mRS);
                b.add(Element.F32_4(mRS), "Color");
                Type.Builder typeBuilder = new Type.Builder(mRS, b.create());
                typeBuilder.setX(1);
                constType = typeBuilder.create();
                sb.addConstant(constType);
            }
            for (int i = 0; i < mNumTextures; i ++) {
                sb.addTexture(TextureType.TEXTURE_2D);
            }

            ProgramFragmentFixedFunction pf = sb.create();
            pf.mTextureCount = MAX_TEXTURE;
            if (!mVaryingColorEnable) {
                Allocation constantData = Allocation.createTyped(mRS,constType);
                FieldPacker fp = new FieldPacker(16);
                Float4 f4 = new Float4(1.f, 1.f, 1.f, 1.f);
                fp.addF32(f4);
                constantData.setFromFieldPacker(0, fp);
                pf.bindConstants(constantData, 0);
            }
            return pf;
        }
    }


    
}

