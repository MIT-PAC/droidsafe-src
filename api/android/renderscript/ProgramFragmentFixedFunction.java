package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
public class ProgramFragmentFixedFunction extends ProgramFragment {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.355 -0400", hash_original_method = "2A0FFECD56CD5C732668EEC76534036D", hash_generated_method = "6977A84B551D4C253F8144B17CE99B8C")
      ProgramFragmentFixedFunction(int id, RenderScript rs) {
        super(id, rs);
        addTaint(rs.getTaint());
        addTaint(id);
        // ---------- Original Method ----------
    }

    
    static class InternalBuilder extends BaseProgramBuilder {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.360 -0400", hash_original_method = "3D66AE7CFC6D0E068FD8C5ABF2875F8E", hash_generated_method = "8FDC28213DEF85E281EAD276B6125E74")
        public  InternalBuilder(RenderScript rs) {
            super(rs);
            addTaint(rs.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.409 -0400", hash_original_method = "7DD57EC723991E6F8C51D4D9D2500308", hash_generated_method = "807BC7FF745F82BAFB4C56C443D2E84C")
        public ProgramFragmentFixedFunction create() {
            mRS.validate();
            int[] tmp = new int[(mInputCount + mOutputCount + mConstantCount + mTextureCount) * 2];
            int idx = 0;
for(int i=0;i < mInputCount;i++)
            {
                tmp[idx++] = ProgramParam.INPUT.mID;
                tmp[idx++] = mInputs[i].getID();
            } //End block
for(int i=0;i < mOutputCount;i++)
            {
                tmp[idx++] = ProgramParam.OUTPUT.mID;
                tmp[idx++] = mOutputs[i].getID();
            } //End block
for(int i=0;i < mConstantCount;i++)
            {
                tmp[idx++] = ProgramParam.CONSTANT.mID;
                tmp[idx++] = mConstants[i].getID();
            } //End block
for(int i=0;i < mTextureCount;i++)
            {
                tmp[idx++] = ProgramParam.TEXTURE_TYPE.mID;
                tmp[idx++] = mTextureTypes[i].mID;
            } //End block
            int id = mRS.nProgramFragmentCreate(mShader, tmp);
            ProgramFragmentFixedFunction pf = new ProgramFragmentFixedFunction(id, mRS);
            initProgram(pf);
ProgramFragmentFixedFunction var26DF16C60843D72D87227D9A8F098EF0_481464558 =             pf;
            var26DF16C60843D72D87227D9A8F098EF0_481464558.addTaint(taint);
            return var26DF16C60843D72D87227D9A8F098EF0_481464558;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.421 -0400", hash_original_field = "6CC26905CEA3A66AA39751A1F3640753", hash_generated_field = "5EBE2D4E6525687A45933CC3EF6AE134")

        int mNumTextures;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.422 -0400", hash_original_field = "418BF2ED1AB818E4CC8D11FCF46AAD68", hash_generated_field = "F7B5253FBC182C9C461FE015FFB50788")

        boolean mPointSpriteEnable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.432 -0400", hash_original_field = "7D1DCB772F77330CDD30A37A19597101", hash_generated_field = "B9BA2C47AA10798901FCB3AD89A619C3")

        boolean mVaryingColorEnable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.434 -0400", hash_original_field = "A3C15874DE554606CB943AF3D68F568F", hash_generated_field = "54F2F4A2C4FE918D7E216DA83E4EE9FB")

        String mShader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.435 -0400", hash_original_field = "15EADDEB24354180E81F0ADC804C4CED", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.437 -0400", hash_original_field = "A8104D9970F89F82B51523D6732BC037", hash_generated_field = "B67103FC01CD4B885D5571B0ADD4D716")

        Slot[] mSlots;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.445 -0400", hash_original_method = "30E90F3B75611917E8432C24A0A6175A", hash_generated_method = "27BA158650FFB0D1A4944526B371AC14")
        public  Builder(RenderScript rs) {
            mRS = rs;
            mSlots = new Slot[MAX_TEXTURE];
            mPointSpriteEnable = false;
            // ---------- Original Method ----------
            //mRS = rs;
            //mSlots = new Slot[MAX_TEXTURE];
            //mPointSpriteEnable = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.488 -0400", hash_original_method = "8FF20388D45EF89CDFE0381040C33F22", hash_generated_method = "214C3ED2C9A4262AAE1EC937A841B7E6")
        private void buildShaderString() {
            mShader  = "//rs_shader_internal\n";
            mShader += "varying lowp vec4 varColor;\n";
            mShader += "varying vec2 varTex0;\n";
            mShader += "void main() {\n";
            if(mVaryingColorEnable)            
            {
                mShader += "  lowp vec4 col = varColor;\n";
            } //End block
            else
            {
                mShader += "  lowp vec4 col = UNI_Color;\n";
            } //End block
            if(mNumTextures != 0)            
            {
                if(mPointSpriteEnable)                
                {
                    mShader += "  vec2 t0 = gl_PointCoord;\n";
                } //End block
                else
                {
                    mShader += "  vec2 t0 = varTex0.xy;\n";
                } //End block
            } //End block
for(int i = 0;i < mNumTextures;i ++)
            {
switch(mSlots[i].env){
                case REPLACE:
switch(mSlots[i].format){
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
}                break;
                case MODULATE:
switch(mSlots[i].format){
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
}                break;
                case DECAL:
                mShader += "  col = texture2D(UNI_Tex0, t0);\n";
                break;
}
            } //End block
            mShader += "  gl_FragColor = col;\n";
            mShader += "}\n";
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.504 -0400", hash_original_method = "F52C9ED64BC7C6FC8999E2931805AE1F", hash_generated_method = "5DC044FF92D575D21B417086AAA772C6")
        public Builder setTexture(EnvMode env, Format fmt, int slot) throws IllegalArgumentException {
            if((slot < 0) || (slot >= MAX_TEXTURE))            
            {
                IllegalArgumentException varA01147F71C698AEE845CB08F6F532B16_1840656022 = new IllegalArgumentException("MAX_TEXTURE exceeded.");
                varA01147F71C698AEE845CB08F6F532B16_1840656022.addTaint(taint);
                throw varA01147F71C698AEE845CB08F6F532B16_1840656022;
            } //End block
            mSlots[slot] = new Slot(env, fmt);
Builder var72A74007B2BE62B849F475C7BDA4658B_839090836 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_839090836.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_839090836;
            // ---------- Original Method ----------
            //if((slot < 0) || (slot >= MAX_TEXTURE)) {
                //throw new IllegalArgumentException("MAX_TEXTURE exceeded.");
            //}
            //mSlots[slot] = new Slot(env, fmt);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.511 -0400", hash_original_method = "3DF94441BBEEF2DAAF6E4E2BA3DC7FCD", hash_generated_method = "703527BF5B39789C5DF168B594707A0D")
        public Builder setPointSpriteTexCoordinateReplacement(boolean enable) {
            mPointSpriteEnable = enable;
Builder var72A74007B2BE62B849F475C7BDA4658B_1334805477 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1334805477.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1334805477;
            // ---------- Original Method ----------
            //mPointSpriteEnable = enable;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.518 -0400", hash_original_method = "D1AB2679757C6095D46ED85B9CF52D59", hash_generated_method = "7BC4E946F7628DB581805055FE5C7E9E")
        public Builder setVaryingColor(boolean enable) {
            mVaryingColorEnable = enable;
Builder var72A74007B2BE62B849F475C7BDA4658B_2053950081 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2053950081.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2053950081;
            // ---------- Original Method ----------
            //mVaryingColorEnable = enable;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.538 -0400", hash_original_method = "3191286FB0D548047357A5725F784799", hash_generated_method = "FE74E8924159C7BD0A6249142527F340")
        public ProgramFragmentFixedFunction create() {
            InternalBuilder sb = new InternalBuilder(mRS);
            mNumTextures = 0;
for(int i = 0;i < MAX_TEXTURE;i ++)
            {
                if(mSlots[i] != null)                
                {
                    mNumTextures ++;
                } //End block
            } //End block
            buildShaderString();
            sb.setShader(mShader);
            Type constType = null;
            if(!mVaryingColorEnable)            
            {
                Element.Builder b = new Element.Builder(mRS);
                b.add(Element.F32_4(mRS), "Color");
                Type.Builder typeBuilder = new Type.Builder(mRS, b.create());
                typeBuilder.setX(1);
                constType = typeBuilder.create();
                sb.addConstant(constType);
            } //End block
for(int i = 0;i < mNumTextures;i ++)
            {
                sb.addTexture(TextureType.TEXTURE_2D);
            } //End block
            ProgramFragmentFixedFunction pf = sb.create();
            pf.mTextureCount = MAX_TEXTURE;
            if(!mVaryingColorEnable)            
            {
                Allocation constantData = Allocation.createTyped(mRS,constType);
                FieldPacker fp = new FieldPacker(16);
                Float4 f4 = new Float4(1.f, 1.f, 1.f, 1.f);
                fp.addF32(f4);
                constantData.setFromFieldPacker(0, fp);
                pf.bindConstants(constantData, 0);
            } //End block
ProgramFragmentFixedFunction var26DF16C60843D72D87227D9A8F098EF0_556291857 =             pf;
            var26DF16C60843D72D87227D9A8F098EF0_556291857.addTaint(taint);
            return var26DF16C60843D72D87227D9A8F098EF0_556291857;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        public enum EnvMode {
            REPLACE (1),
            MODULATE (2),
            DECAL (3);
            int mID;
            EnvMode(int id) {
                mID = id;
            }
        }

        
        public enum Format {
            ALPHA (1),
            LUMINANCE_ALPHA (2),
            RGB (3),
            RGBA (4);
            int mID;
            Format(int id) {
                mID = id;
            }
        }

        
        private class Slot {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.546 -0400", hash_original_field = "FF035A1DD7655DA15295FA5FA89362A7", hash_generated_field = "9F74C5A2DE54F696FBAF5E851601C0E8")

            EnvMode env;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.548 -0400", hash_original_field = "1DDCB92ADE31C8FBD370001F9B29A7D9", hash_generated_field = "381386A1132E12A7CB58DF05EF5AB5BB")

            Format format;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.557 -0400", hash_original_method = "6603C262DCA775BA18F529F86363B60E", hash_generated_method = "E362A1A06642E4A6E909633EC905A412")
              Slot(EnvMode _env, Format _fmt) {
                env = _env;
                format = _fmt;
                // ---------- Original Method ----------
                //env = _env;
                //format = _fmt;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:03:16.559 -0400", hash_original_field = "EA9CE5E9D2F6D2EAB3D483701C70A04D", hash_generated_field = "D118099FAF0CA6FBAD03B4A799F8496F")

        public static final int MAX_TEXTURE = 2;
    }


    
}

