/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.opengl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ShortBuffer;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL;
class GLErrorWrapper extends GLWrapperBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.030 -0500", hash_original_field = "8BAF20A7CA64C101926E06DD40CFBFBF", hash_generated_field = "8BAF20A7CA64C101926E06DD40CFBFBF")

    boolean mCheckError;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.032 -0500", hash_original_field = "D52119176934FABB8A61F86CFB04D0F4", hash_generated_field = "D52119176934FABB8A61F86CFB04D0F4")

    boolean mCheckThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.035 -0500", hash_original_field = "1D0FEE70ACCFA6043BF059ED5E9200E9", hash_generated_field = "1D0FEE70ACCFA6043BF059ED5E9200E9")

    Thread mOurThread;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.037 -0500", hash_original_method = "C181619CCB40EB18FF121A09C05E4687", hash_generated_method = "4069910E66B023D79321E531031C7A1A")
    
public GLErrorWrapper(GL gl, int configFlags) {
        super(gl);
        mCheckError = (configFlags & GLDebugHelper.CONFIG_CHECK_GL_ERROR) != 0;
        mCheckThread = (configFlags & GLDebugHelper.CONFIG_CHECK_THREAD) != 0;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.040 -0500", hash_original_method = "8D2CFEB19FD30277708BE9D87CBF31F7", hash_generated_method = "5C09C8BF96086249C950AC3A3EAF0E1C")
    
private void checkThread() {
        if (mCheckThread) {
            Thread currentThread = Thread.currentThread();
            if (mOurThread == null) {
                mOurThread = currentThread;
            } else {
                if (!mOurThread.equals(currentThread)) {
                    throw new GLException(GLDebugHelper.ERROR_WRONG_THREAD,
                            "OpenGL method called from wrong thread.");
                }
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.043 -0500", hash_original_method = "DFE4358DBB87A194B0A1ECCFFB0EC18F", hash_generated_method = "727496F96C868886F32D9F5336963127")
    
private void checkError() {
        if (mCheckError) {
            int glError;
            if ((glError = mgl.glGetError()) != 0) {
                throw new GLException(glError);
            }
        }
    }

    // ---------------------------------------------------------------------
    // GL10 methods:

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.045 -0500", hash_original_method = "DA5ED54245C57C6A9FD75DE260C03262", hash_generated_method = "B45537DCE95F44C58401839B8D00F325")
    
public void glActiveTexture(int texture) {
        checkThread();
        mgl.glActiveTexture(texture);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.047 -0500", hash_original_method = "B3DDF475E5452B26AE190A327782F2A9", hash_generated_method = "5BBA628ADE8C318E27CE308FB0B2E6BE")
    
public void glAlphaFunc(int func, float ref) {
        checkThread();
        mgl.glAlphaFunc(func, ref);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.049 -0500", hash_original_method = "0CA7CE5E6095EBD7BCF61FBB33E00E0D", hash_generated_method = "11AD746D6007C0E500326DD233FE238A")
    
public void glAlphaFuncx(int func, int ref) {
        checkThread();
        mgl.glAlphaFuncx(func, ref);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.052 -0500", hash_original_method = "B4B709A779E5229A49D0CB8C56AE7C7C", hash_generated_method = "5140E197698943BE006F85689FAA771A")
    
public void glBindTexture(int target, int texture) {
        checkThread();
        mgl.glBindTexture(target, texture);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.054 -0500", hash_original_method = "896046A1246C7997FCC63F53EE6CC83B", hash_generated_method = "C9EBF36D4EEB5F9669B4DDFA3F493941")
    
public void glBlendFunc(int sfactor, int dfactor) {
        checkThread();
        mgl.glBlendFunc(sfactor, dfactor);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.057 -0500", hash_original_method = "327FCDF3B3408904218078A84E308554", hash_generated_method = "0E2A3D2D3DDB4AC4E8E6080E4BC2ABDC")
    
public void glClear(int mask) {
        checkThread();
        mgl.glClear(mask);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.060 -0500", hash_original_method = "4364D8D5F51B3C6569C8F39D4E51EA04", hash_generated_method = "3A59509EA0633EB8B355324B2B19CE1E")
    
public void glClearColor(float red, float green, float blue, float alpha) {
        checkThread();
        mgl.glClearColor(red, green, blue, alpha);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.062 -0500", hash_original_method = "D2DEDD116EFFEC5BB8EED9065CF8099B", hash_generated_method = "7A4647756F0D6712CE3B7C1AAF5D0FD2")
    
public void glClearColorx(int red, int green, int blue, int alpha) {
        checkThread();
        mgl.glClearColorx(red, green, blue, alpha);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.065 -0500", hash_original_method = "956F409EF1EADA73108A1C4B67FC1A5C", hash_generated_method = "A0B6B05FCD4E5E0E1B7FCF2346AB5768")
    
public void glClearDepthf(float depth) {
        checkThread();
        mgl.glClearDepthf(depth);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.067 -0500", hash_original_method = "30F88F59ADB4553E77F9EA15BFD9F65A", hash_generated_method = "BF4BA0DF192B27AD991238A9F43F66D3")
    
public void glClearDepthx(int depth) {
        checkThread();
        mgl.glClearDepthx(depth);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.069 -0500", hash_original_method = "4612FA73BEC6F3626B61AFE904FC02AE", hash_generated_method = "450459F968A2DAE4FBE96699BF85B1B7")
    
public void glClearStencil(int s) {
        checkThread();
        mgl.glClearStencil(s);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.072 -0500", hash_original_method = "AF39E32CE4C21187FB9A7DA0902005E0", hash_generated_method = "C2844C0668EDD929FE991BE341F79443")
    
public void glClientActiveTexture(int texture) {
        checkThread();
        mgl.glClientActiveTexture(texture);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.074 -0500", hash_original_method = "AEE61C3A8BF8DD0FE99117CF74BE0950", hash_generated_method = "70E2F4D5AE78FB1732C88A325810818D")
    
public void glColor4f(float red, float green, float blue, float alpha) {
        checkThread();
        mgl.glColor4f(red, green, blue, alpha);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.077 -0500", hash_original_method = "5660D8ED2ACF7645F240C96D956B261D", hash_generated_method = "FD1ECF129D176133233F87BB64EE3B12")
    
public void glColor4x(int red, int green, int blue, int alpha) {
        checkThread();
        mgl.glColor4x(red, green, blue, alpha);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.079 -0500", hash_original_method = "5F003DF67ED0B35D619420E804090959", hash_generated_method = "9F91088F87D32DB3A74465CC9526F841")
    
public void glColorMask(boolean red, boolean green, boolean blue,
            boolean alpha) {
        checkThread();
        mgl.glColorMask(red, green, blue, alpha);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.081 -0500", hash_original_method = "9B7D7B53255EE6EA400EDE8FB2A325F8", hash_generated_method = "33A7ED409615A6916AB0E1E83B20DCCA")
    
public void glColorPointer(int size, int type, int stride, Buffer pointer) {
        checkThread();
        mgl.glColorPointer(size, type, stride, pointer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.084 -0500", hash_original_method = "9B7E21B2A3F16833366D8F651FD6AF1F", hash_generated_method = "4009717344B426C0019B4409DB3B5D7E")
    
public void glCompressedTexImage2D(int target, int level,
            int internalformat, int width, int height, int border,
            int imageSize, Buffer data) {
        checkThread();
        mgl.glCompressedTexImage2D(target, level, internalformat, width,
                height, border, imageSize, data);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.087 -0500", hash_original_method = "59973B7701044713D5586B4A2955DE14", hash_generated_method = "41F9D267F45A7ED00C30B167209DD719")
    
public void glCompressedTexSubImage2D(int target, int level, int xoffset,
            int yoffset, int width, int height, int format, int imageSize,
            Buffer data) {
        checkThread();
        mgl.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width,
                height, format, imageSize, data);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.089 -0500", hash_original_method = "A81BB722A408E948C2F0E212A22AC850", hash_generated_method = "D9BA6B0FBECC1583C9E5CE36A72E7CB2")
    
public void glCopyTexImage2D(int target, int level, int internalformat,
            int x, int y, int width, int height, int border) {
        checkThread();
        mgl.glCopyTexImage2D(target, level, internalformat, x, y, width,
                height, border);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.091 -0500", hash_original_method = "3EBD1E326D13C4A12705C36D947C6820", hash_generated_method = "4E1A20CDDA612627490B208C68352361")
    
public void glCopyTexSubImage2D(int target, int level, int xoffset,
            int yoffset, int x, int y, int width, int height) {
        checkThread();
        mgl.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width,
                height);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.094 -0500", hash_original_method = "D0F2F1AD364FF58ABB67DE92552937CD", hash_generated_method = "4D2711027908A9D9F5D71909A92670DD")
    
public void glCullFace(int mode) {
        checkThread();
        mgl.glCullFace(mode);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.096 -0500", hash_original_method = "82CBBA453A1F688EEF4D2AA7AC94B18B", hash_generated_method = "4E9F3CF0E3C5A73576DD1DE7C2E2C95F")
    
public void glDeleteTextures(int n, int[] textures, int offset) {
        checkThread();
        mgl.glDeleteTextures(n, textures, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.098 -0500", hash_original_method = "6D712CDCC2122B66F08314266A1377A0", hash_generated_method = "463D5C9CF0F5D33F10B346CC62E07031")
    
public void glDeleteTextures(int n, IntBuffer textures) {
        checkThread();
        mgl.glDeleteTextures(n, textures);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.101 -0500", hash_original_method = "D43EDBE37E8BC4A7FF2598EF2F6BD41B", hash_generated_method = "074E8FA76B1C6B06E3882D771BF4E28A")
    
public void glDepthFunc(int func) {
        checkThread();
        mgl.glDepthFunc(func);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.103 -0500", hash_original_method = "220CADA7AD9601E5E0364E7615CAE052", hash_generated_method = "E7DD0F6982B6EFB291A3E4429889F626")
    
public void glDepthMask(boolean flag) {
        checkThread();
        mgl.glDepthMask(flag);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.106 -0500", hash_original_method = "76EFE44EC58945F9E83CB96B27E2AF97", hash_generated_method = "985F39B72C71884B8D4AD2F847D39623")
    
public void glDepthRangef(float near, float far) {
        checkThread();
        mgl.glDepthRangef(near, far);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.108 -0500", hash_original_method = "196671E819F02FAE0505F22C389CCC6B", hash_generated_method = "D594E6DDFBD1FB38D3AB1769B40541CF")
    
public void glDepthRangex(int near, int far) {
        checkThread();
        mgl.glDepthRangex(near, far);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.110 -0500", hash_original_method = "D49564350639657A355C4B877826C52F", hash_generated_method = "652544F172D34F174AC83EAC55535B18")
    
public void glDisable(int cap) {
        checkThread();
        mgl.glDisable(cap);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.113 -0500", hash_original_method = "855E8B051ED8CBC1203FC822FD021828", hash_generated_method = "33C2F445457E96D4D7999D9E17049F60")
    
public void glDisableClientState(int array) {
        checkThread();
        mgl.glDisableClientState(array);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.115 -0500", hash_original_method = "08C4B9045050CFE9D011F50AA9E1EF83", hash_generated_method = "8BA8F0C4759985415B3B539AF9F317C0")
    
public void glDrawArrays(int mode, int first, int count) {
        checkThread();
        mgl.glDrawArrays(mode, first, count);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.118 -0500", hash_original_method = "5219ACFB98EACED3BA7FB66380EED928", hash_generated_method = "A5766006446E6A3FF20804E5E314F51F")
    
public void glDrawElements(int mode, int count, int type, Buffer indices) {
        checkThread();
        mgl.glDrawElements(mode, count, type, indices);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.120 -0500", hash_original_method = "1B4244ECA61C83575D9A193B42375CB7", hash_generated_method = "F8B3CC95E8C47811A1A6E250CDC52D15")
    
public void glEnable(int cap) {
        checkThread();
        mgl.glEnable(cap);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.123 -0500", hash_original_method = "5109B9FEC88700C058123D36B6279F4D", hash_generated_method = "B3ADFDA48F2B3756E00EC1EDFD7377BC")
    
public void glEnableClientState(int array) {
        checkThread();
        mgl.glEnableClientState(array);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.125 -0500", hash_original_method = "A061BB401278C8963A507C0E701CC550", hash_generated_method = "2A77548FA9290F61D51F7CF8E97D525A")
    
public void glFinish() {
        checkThread();
        mgl.glFinish();
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.127 -0500", hash_original_method = "C8D2F6CDE70543B0D8B1DCBD4C1D7B10", hash_generated_method = "3E98D3A5D6DECF3D9ED8BA85423FEF81")
    
public void glFlush() {
        checkThread();
        mgl.glFlush();
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.130 -0500", hash_original_method = "ACCDF5CD9B4D681BB58F33176C3F4369", hash_generated_method = "4BABF5C5E1722EAAB846E0CB75BEE91F")
    
public void glFogf(int pname, float param) {
        checkThread();
        mgl.glFogf(pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.132 -0500", hash_original_method = "98DA50343C1CBEE71394C5EDCB0908FC", hash_generated_method = "55205175C884F82C6729E24D4F1D3D7F")
    
public void glFogfv(int pname, float[] params, int offset) {
        checkThread();
        mgl.glFogfv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.135 -0500", hash_original_method = "9840BE668F66603C4837A483A27E1A9C", hash_generated_method = "BD036BC6CF05F09148116F8A061064E1")
    
public void glFogfv(int pname, FloatBuffer params) {
        checkThread();
        mgl.glFogfv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.137 -0500", hash_original_method = "22D599C477FAA1471774C9850AB75BCE", hash_generated_method = "72306CFDCE383CFC88710CFF54E493F9")
    
public void glFogx(int pname, int param) {
        checkThread();
        mgl.glFogx(pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.139 -0500", hash_original_method = "75CDAFA7022CCA98BA21509BBAFC2206", hash_generated_method = "46FE7E9E66E6EDEDDA2F03DE1A3717EA")
    
public void glFogxv(int pname, int[] params, int offset) {
        checkThread();
        mgl.glFogxv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.141 -0500", hash_original_method = "41A43CD5C745A4594DF059A6DD43BD68", hash_generated_method = "BA99E84305E904F689FBFD2892B84622")
    
public void glFogxv(int pname, IntBuffer params) {
        checkThread();
        mgl.glFogxv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.143 -0500", hash_original_method = "DC820EC7C8249DB3ACF589F75D2A15E5", hash_generated_method = "5AA918038E0153A4C58921AD1887C1A0")
    
public void glFrontFace(int mode) {
        checkThread();
        mgl.glFrontFace(mode);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.146 -0500", hash_original_method = "BCF359F592E3040EB9E1338B9A9400AB", hash_generated_method = "5281979D5DB3D23DA2CB143B5C375FB2")
    
public void glFrustumf(float left, float right, float bottom, float top,
            float near, float far) {
        checkThread();
        mgl.glFrustumf(left, right, bottom, top, near, far);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.149 -0500", hash_original_method = "C90AEA8B68F6C85748E36A5E9D26C94D", hash_generated_method = "DDC15C5C457B53869F9D0A7E0C7E2A55")
    
public void glFrustumx(int left, int right, int bottom, int top, int near,
            int far) {
        checkThread();
        mgl.glFrustumx(left, right, bottom, top, near, far);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.151 -0500", hash_original_method = "66114EE308B4749DC9F3DC1D1E171D07", hash_generated_method = "DBBBEEA34CA9B3E79984515DDAD9B1EF")
    
public void glGenTextures(int n, int[] textures, int offset) {
        checkThread();
        mgl.glGenTextures(n, textures, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.154 -0500", hash_original_method = "E73ABC43E2AF0160149F4B09F9D0CE55", hash_generated_method = "04B32347281BF5A3F197167F8FDC76ED")
    
public void glGenTextures(int n, IntBuffer textures) {
        checkThread();
        mgl.glGenTextures(n, textures);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.156 -0500", hash_original_method = "0A40D9CB95C5DBFB792A8941813F3C4A", hash_generated_method = "57CE6C785A22B943268ECCD7C44F4F90")
    
public int glGetError() {
        checkThread();
        int result = mgl.glGetError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.158 -0500", hash_original_method = "91019D695D6F297BDCCFA315193AEAC0", hash_generated_method = "A084C719CA514A964C3381C0B5F93A15")
    
public void glGetIntegerv(int pname, int[] params, int offset) {
        checkThread();
        mgl.glGetIntegerv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.161 -0500", hash_original_method = "FEDA3B13A1922AE75A6A5C7CBE52AB77", hash_generated_method = "D186A218E69DE9D813055D0621B0F626")
    
public void glGetIntegerv(int pname, IntBuffer params) {
        checkThread();
        mgl.glGetIntegerv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.163 -0500", hash_original_method = "3ED6913E5E7CF46B5A28C7A9761C377B", hash_generated_method = "AF69D94CDFFCDEC66FB52F3680232D54")
    
public String glGetString(int name) {
        checkThread();
        String result = mgl.glGetString(name);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.166 -0500", hash_original_method = "459DC163A76E76C40FCB18D7FC6BBF01", hash_generated_method = "E70B4CAAC9C60FB4FDFCFD0369D61E4D")
    
public void glHint(int target, int mode) {
        checkThread();
        mgl.glHint(target, mode);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.169 -0500", hash_original_method = "8F6EF3CA789F38CA6787860843FC3C48", hash_generated_method = "2721DDE02A7797F24BBAC535A9F2017C")
    
public void glLightModelf(int pname, float param) {
        checkThread();
        mgl.glLightModelf(pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.172 -0500", hash_original_method = "F9185B0E5B985E183AB9D5AA59F81EFD", hash_generated_method = "32B647994D49062AF7F48214726F4F88")
    
public void glLightModelfv(int pname, float[] params, int offset) {
        checkThread();
        mgl.glLightModelfv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.174 -0500", hash_original_method = "12B724FBF238EAE2A84B461E9B4BDFC7", hash_generated_method = "E0CE105B7F666E8AE389BB9E9F6AA735")
    
public void glLightModelfv(int pname, FloatBuffer params) {
        checkThread();
        mgl.glLightModelfv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.177 -0500", hash_original_method = "3418E97353E36988C53668EF2CA6B536", hash_generated_method = "8785D7BF36AD943A42F88024385F458A")
    
public void glLightModelx(int pname, int param) {
        checkThread();
        mgl.glLightModelx(pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.179 -0500", hash_original_method = "BA5ADB335DCD06723E483DE9A02D18C2", hash_generated_method = "2477BD6F4C8087AB6355CE405F67B1CA")
    
public void glLightModelxv(int pname, int[] params, int offset) {
        checkThread();
        mgl.glLightModelxv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.181 -0500", hash_original_method = "08C6BFFDFAE733F8276951C523CA7D63", hash_generated_method = "125FBAE7321B80DBB749318336E397F4")
    
public void glLightModelxv(int pname, IntBuffer params) {
        checkThread();
        mgl.glLightModelxv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.183 -0500", hash_original_method = "A0D7AC42B086A01EB107C95E6D441CEE", hash_generated_method = "4B7962FA06B5858ADF7841796C6C245A")
    
public void glLightf(int light, int pname, float param) {
        checkThread();
        mgl.glLightf(light, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.186 -0500", hash_original_method = "3CA7FC894380A8E6852C9D01BE83801E", hash_generated_method = "BBFB3A57B4285611C1842460FCA6FC2A")
    
public void glLightfv(int light, int pname, float[] params, int offset) {
        checkThread();
        mgl.glLightfv(light, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.188 -0500", hash_original_method = "0362D67F764F533B389F9E750A36D8C7", hash_generated_method = "29A26F262FD37B0381502739839C7EE7")
    
public void glLightfv(int light, int pname, FloatBuffer params) {
        checkThread();
        mgl.glLightfv(light, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.191 -0500", hash_original_method = "A7B23B278A2CECFA2FEF84A7C9AAE594", hash_generated_method = "32056798749055D79BC6735F7D1EF83C")
    
public void glLightx(int light, int pname, int param) {
        checkThread();
        mgl.glLightx(light, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.193 -0500", hash_original_method = "61878AA93971931285D7FCB85C09790D", hash_generated_method = "4BCE58735A86BE63301EBD06BEB6A0D9")
    
public void glLightxv(int light, int pname, int[] params, int offset) {
        checkThread();
        mgl.glLightxv(light, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.195 -0500", hash_original_method = "4464111BA9498302AB8C4F9B7F00E947", hash_generated_method = "4AB857CD564CA4EE25E125532AC1BFE1")
    
public void glLightxv(int light, int pname, IntBuffer params) {
        checkThread();
        mgl.glLightxv(light, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.198 -0500", hash_original_method = "0415DE8E2BD7CF7D6C9A927E286F315A", hash_generated_method = "64AF3DE739EA1E299714BE22B50DF95A")
    
public void glLineWidth(float width) {
        checkThread();
        mgl.glLineWidth(width);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.200 -0500", hash_original_method = "0FB71A96C3DD6C51A7173D2776651E81", hash_generated_method = "70DA0F929707D529292BEE0702C91C86")
    
public void glLineWidthx(int width) {
        checkThread();
        mgl.glLineWidthx(width);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.203 -0500", hash_original_method = "4C51AE53329187A41451C9AF961C3B5F", hash_generated_method = "055B2C80AD41891487E9B25CD187FB16")
    
public void glLoadIdentity() {
        checkThread();
        mgl.glLoadIdentity();
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.205 -0500", hash_original_method = "C5BC8E879EE7BBEA9463E1CF17609084", hash_generated_method = "206773DA0D850C7D035D73FAA2C51EB7")
    
public void glLoadMatrixf(float[] m, int offset) {
        checkThread();
        mgl.glLoadMatrixf(m, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.208 -0500", hash_original_method = "E3E6640B45B2CEF936614C55631DF0F3", hash_generated_method = "069685B829CE0BE044112740D5216E73")
    
public void glLoadMatrixf(FloatBuffer m) {
        checkThread();
        mgl.glLoadMatrixf(m);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.210 -0500", hash_original_method = "560B8044A41FF82EFFFC667DB60BDBBA", hash_generated_method = "1D41F65420B94F99DB13D69C50704277")
    
public void glLoadMatrixx(int[] m, int offset) {
        checkThread();
        mgl.glLoadMatrixx(m, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.213 -0500", hash_original_method = "D3E2D85B1AFF096D11D2574186387DC6", hash_generated_method = "06F096F72113F4A3ECC7639C148BB43F")
    
public void glLoadMatrixx(IntBuffer m) {
        checkThread();
        mgl.glLoadMatrixx(m);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.215 -0500", hash_original_method = "FE1B5EE86F6C265568CEB5E2464AAEC3", hash_generated_method = "9AE2E255C5F28CE0DB9F12CBD14043B1")
    
public void glLogicOp(int opcode) {
        checkThread();
        mgl.glLogicOp(opcode);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.217 -0500", hash_original_method = "BFDCEE5D0F54A4143487C674320A768D", hash_generated_method = "3DAE263890AD3837DA411F1650FA8F46")
    
public void glMaterialf(int face, int pname, float param) {
        checkThread();
        mgl.glMaterialf(face, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.220 -0500", hash_original_method = "80457EBF2EF68E50B90CD20164F1E18B", hash_generated_method = "4C1EA33CC5FE6482305EAFCD696D4E5F")
    
public void glMaterialfv(int face, int pname, float[] params, int offset) {
        checkThread();
        mgl.glMaterialfv(face, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.222 -0500", hash_original_method = "76C9AE6AAFCE4F309222FADEE1AFEEB9", hash_generated_method = "C05E5C9A55DCB4172C9E85967C619A79")
    
public void glMaterialfv(int face, int pname, FloatBuffer params) {
        checkThread();
        mgl.glMaterialfv(face, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.225 -0500", hash_original_method = "FB951B280084574B35BB18E908DE3AD6", hash_generated_method = "515CCB6CA1FD2F1ADB89B6F82D03F1DC")
    
public void glMaterialx(int face, int pname, int param) {
        checkThread();
        mgl.glMaterialx(face, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.227 -0500", hash_original_method = "9E62203A5BCECD57FA7A7AFEC76F5522", hash_generated_method = "354B695D8A463E6E3A1554D07D0598AF")
    
public void glMaterialxv(int face, int pname, int[] params, int offset) {
        checkThread();
        mgl.glMaterialxv(face, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.229 -0500", hash_original_method = "7C085F925F89C74D980535EEB48F9DEB", hash_generated_method = "33B5AD3204B4641A2FEB9DA7767096DC")
    
public void glMaterialxv(int face, int pname, IntBuffer params) {
        checkThread();
        mgl.glMaterialxv(face, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.231 -0500", hash_original_method = "1CF0B8C2254257C506F75CED4FDC3C00", hash_generated_method = "61241E2043E683CDEFBDDA7B0F35A221")
    
public void glMatrixMode(int mode) {
        checkThread();
        mgl.glMatrixMode(mode);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.233 -0500", hash_original_method = "172DB229F31BC17320BA572703A033BB", hash_generated_method = "C580237D8FC4557A6927D17EF2C831B5")
    
public void glMultMatrixf(float[] m, int offset) {
        checkThread();
        mgl.glMultMatrixf(m, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.236 -0500", hash_original_method = "667E2CDA3CFF04177423F3E794D46A55", hash_generated_method = "3B3167E0C5FCA0506CBF57AAC11C7440")
    
public void glMultMatrixf(FloatBuffer m) {
        checkThread();
        mgl.glMultMatrixf(m);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.239 -0500", hash_original_method = "653C3DE814DCA83836652E3EF13A17D2", hash_generated_method = "35BE0A45FD166FAF4785A1AA7297F829")
    
public void glMultMatrixx(int[] m, int offset) {
        checkThread();
        mgl.glMultMatrixx(m, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.241 -0500", hash_original_method = "C8DC7C24D8426FBEEA0E4D3C9689FD10", hash_generated_method = "2CE4BEC3CF4C36FB9FB1D77EFC0EF350")
    
public void glMultMatrixx(IntBuffer m) {
        checkThread();
        mgl.glMultMatrixx(m);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.243 -0500", hash_original_method = "65ED6BD2303A4AC65910897D16FA5D82", hash_generated_method = "0960274E450CCD5EE8C83705F1091885")
    
public void glMultiTexCoord4f(int target,
            float s, float t, float r, float q) {
        checkThread();
        mgl.glMultiTexCoord4f(target, s, t, r, q);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.246 -0500", hash_original_method = "6B82214F4B73B0751B81013CB7B64795", hash_generated_method = "B76CF8977B28FFC622B7BA6251C7D7C6")
    
public void glMultiTexCoord4x(int target, int s, int t, int r, int q) {
        checkThread();
        mgl.glMultiTexCoord4x(target, s, t, r, q);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.248 -0500", hash_original_method = "2691C307B7AACD4079C532C68FFDA6EE", hash_generated_method = "D58300F78841AFAEA50002ECFE47C815")
    
public void glNormal3f(float nx, float ny, float nz) {
        checkThread();
        mgl.glNormal3f(nx, ny, nz);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.252 -0500", hash_original_method = "9402DEA540A7E5C5A050889651F613F3", hash_generated_method = "33BB9141421EE9469B0C6635093893AA")
    
public void glNormal3x(int nx, int ny, int nz) {
        checkThread();
        mgl.glNormal3x(nx, ny, nz);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.254 -0500", hash_original_method = "4255D3578200E45CA368B3C100DE535B", hash_generated_method = "2B619A8DBA617D141F3615E211DFE602")
    
public void glNormalPointer(int type, int stride, Buffer pointer) {
        checkThread();
        mgl.glNormalPointer(type, stride, pointer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.256 -0500", hash_original_method = "1AEC1F4A67A827D0BD54929A0CEB82F7", hash_generated_method = "99A8E11190758EDD1890F5BD5FDFE307")
    
public void glOrthof(float left, float right, float bottom, float top,
            float near, float far) {
        checkThread();
        mgl.glOrthof(left, right, bottom, top, near, far);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.259 -0500", hash_original_method = "2B2D363148083F563856E56A7B382998", hash_generated_method = "49B67918682B07BDC656997554ECC745")
    
public void glOrthox(int left, int right, int bottom, int top, int near,
            int far) {
        checkThread();
        mgl.glOrthox(left, right, bottom, top, near, far);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.261 -0500", hash_original_method = "6C9FD642B1A08C12F939E9A5C284A009", hash_generated_method = "93685A1A7BD58478545ACC2EC7FCEA37")
    
public void glPixelStorei(int pname, int param) {
        checkThread();
        mgl.glPixelStorei(pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.264 -0500", hash_original_method = "FB7109A99E2ED070DF3E8334E8EE5817", hash_generated_method = "C35EE63E5DECFEEE761D36277F556856")
    
public void glPointSize(float size) {
        checkThread();
        mgl.glPointSize(size);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.266 -0500", hash_original_method = "43DF378BBA8735107A1F55C83335C8A7", hash_generated_method = "93DF127CA6416860196505C99F0F7460")
    
public void glPointSizex(int size) {
        checkThread();
        mgl.glPointSizex(size);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.269 -0500", hash_original_method = "76AD8C2921630BF911BCF1CAD50761F2", hash_generated_method = "668BBBE0FA93003DDA18A29A06321AC7")
    
public void glPolygonOffset(float factor, float units) {
        checkThread();
        mgl.glPolygonOffset(factor, units);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.272 -0500", hash_original_method = "AC493D1D792D1FF91760FBCFA7B83CEC", hash_generated_method = "E48DD99F5EF7F36E842626D63C8D149F")
    
public void glPolygonOffsetx(int factor, int units) {
        checkThread();
        mgl.glPolygonOffsetx(factor, units);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.276 -0500", hash_original_method = "7947021D8783B966C27FD23CEA1B71F6", hash_generated_method = "5243E7CAB9CFA84DB86DAF5F0E25BF0B")
    
public void glPopMatrix() {
        checkThread();
        mgl.glPopMatrix();
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.279 -0500", hash_original_method = "430A6A0AAD37F21F43C25D73DABFE5A3", hash_generated_method = "E69970B9166EED32302D88C7BE7FBF0D")
    
public void glPushMatrix() {
        checkThread();
        mgl.glPushMatrix();
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.284 -0500", hash_original_method = "2C3B39FDC42943C0A39DC2602C72A3DF", hash_generated_method = "BEB6D93D2E5B944D30900E0E50815191")
    
public void glReadPixels(int x, int y, int width, int height, int format,
            int type, Buffer pixels) {
        checkThread();
        mgl.glReadPixels(x, y, width, height, format, type, pixels);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.287 -0500", hash_original_method = "0DE4332635328A12C013DB27FF2CE04A", hash_generated_method = "7018572398EDB30C1B55EDCDFC685EAF")
    
public void glRotatef(float angle, float x, float y, float z) {
        checkThread();
        mgl.glRotatef(angle, x, y, z);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.291 -0500", hash_original_method = "DECB7FEF01CE445DAFBCA1297361E8B9", hash_generated_method = "8B9BC832DCDB87AA448BC2BE53FD0A5A")
    
public void glRotatex(int angle, int x, int y, int z) {
        checkThread();
        mgl.glRotatex(angle, x, y, z);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.296 -0500", hash_original_method = "4A774BD6565FB6890E0F8B1981F5B7DC", hash_generated_method = "888EEBB46ADD6006D9138161DFB9E287")
    
public void glSampleCoverage(float value, boolean invert) {
        checkThread();
        mgl.glSampleCoverage(value, invert);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.299 -0500", hash_original_method = "246915596BE59E740E6336B99BCFF875", hash_generated_method = "835F9B801BC504BE11A988685AC41E2C")
    
public void glSampleCoveragex(int value, boolean invert) {
        checkThread();
        mgl.glSampleCoveragex(value, invert);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.301 -0500", hash_original_method = "F71CEF3DEC5AC68CAFB885B631BEEB80", hash_generated_method = "64E715F830330075C07A7A1697CD2202")
    
public void glScalef(float x, float y, float z) {
        checkThread();
        mgl.glScalef(x, y, z);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.303 -0500", hash_original_method = "44F0B10B66A5CB68CF2FF6190231BB59", hash_generated_method = "619B582CF5C3D8D8468DB258E5F68A11")
    
public void glScalex(int x, int y, int z) {
        checkThread();
        mgl.glScalex(x, y, z);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.306 -0500", hash_original_method = "502D816BF34ADC2D7800E04F424F3B4C", hash_generated_method = "372AC02DFCB9D54BF6AF4C85CA649571")
    
public void glScissor(int x, int y, int width, int height) {
        checkThread();
        mgl.glScissor(x, y, width, height);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.308 -0500", hash_original_method = "E292B70498533BCBAEEFF3AED828C0E0", hash_generated_method = "06A9CF40DAFA4C21E4941C59334AB0A2")
    
public void glShadeModel(int mode) {
        checkThread();
        mgl.glShadeModel(mode);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.311 -0500", hash_original_method = "DA21BDF8FE923215C052A957B82B4C49", hash_generated_method = "6B90B9500C928F7837372F60D84033BA")
    
public void glStencilFunc(int func, int ref, int mask) {
        checkThread();
        mgl.glStencilFunc(func, ref, mask);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.314 -0500", hash_original_method = "201F43CC2E0F2358208533E939AE3BB7", hash_generated_method = "61CB1EE316F4404574D7CBC5059457CC")
    
public void glStencilMask(int mask) {
        checkThread();
        mgl.glStencilMask(mask);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.316 -0500", hash_original_method = "6CB0996245972EF0DE06E8CD6E13A2E5", hash_generated_method = "EEB2583D14B4847C9B534883BBE7DF8A")
    
public void glStencilOp(int fail, int zfail, int zpass) {
        checkThread();
        mgl.glStencilOp(fail, zfail, zpass);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.320 -0500", hash_original_method = "466390C739545456EFABACA14168346A", hash_generated_method = "BF3C343D4A230A3B0716117D16CEA319")
    
public void glTexCoordPointer(int size, int type,
            int stride, Buffer pointer) {
        checkThread();
        mgl.glTexCoordPointer(size, type, stride, pointer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.324 -0500", hash_original_method = "85A5615814A4D36A16A6D7AFCDDCDD6B", hash_generated_method = "2D2B39D3B7E3C1793C30A3218970C152")
    
public void glTexEnvf(int target, int pname, float param) {
        checkThread();
        mgl.glTexEnvf(target, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.328 -0500", hash_original_method = "26EAA56F3A6D446A83B58D5406D2B31F", hash_generated_method = "61AA0397CE15811F37B7F1D822043CF4")
    
public void glTexEnvfv(int target, int pname, float[] params, int offset) {
        checkThread();
        mgl.glTexEnvfv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.334 -0500", hash_original_method = "83CF5E88B0AC5BA7DCC0935F6C00DC4B", hash_generated_method = "A096A9270AC6FFBC52EBAC4FBADB639F")
    
public void glTexEnvfv(int target, int pname, FloatBuffer params) {
        checkThread();
        mgl.glTexEnvfv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.336 -0500", hash_original_method = "51E707441D7EBBDAB24B58399FC8FDE5", hash_generated_method = "419A0737C413BA8458F3B98D25E93764")
    
public void glTexEnvx(int target, int pname, int param) {
        checkThread();
        mgl.glTexEnvx(target, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.338 -0500", hash_original_method = "5FD058160DAD78F5FB12F311FAD4CB3B", hash_generated_method = "BD66C28454770ACF0FA3D3B2F990EC22")
    
public void glTexEnvxv(int target, int pname, int[] params, int offset) {
        checkThread();
        mgl.glTexEnvxv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.341 -0500", hash_original_method = "822E68C4BE5661C6D22E44892B0C1419", hash_generated_method = "6E8FBDFC5639561DEDC99D1A19FFE4A9")
    
public void glTexEnvxv(int target, int pname, IntBuffer params) {
        checkThread();
        mgl.glTexEnvxv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.345 -0500", hash_original_method = "7D871FBA416A6667CD6F62C9D0FA5A27", hash_generated_method = "0C1B1F25A8CCBC6A65F7AFE4158AB748")
    
public void glTexImage2D(int target, int level, int internalformat,
            int width, int height, int border, int format, int type,
            Buffer pixels) {
        checkThread();
        mgl.glTexImage2D(target, level, internalformat, width, height, border,
                format, type, pixels);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.350 -0500", hash_original_method = "72BEF0B5BA47065076DB8DB16269213F", hash_generated_method = "26FDD08075547220538CE9006E6DA210")
    
public void glTexParameterf(int target, int pname, float param) {
        checkThread();
        mgl.glTexParameterf(target, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.353 -0500", hash_original_method = "19F7443230B95831EF68E715BF3E37B4", hash_generated_method = "C9EB1743875828E1CB4A2D5797F25C28")
    
public void glTexParameterx(int target, int pname, int param) {
        checkThread();
        mgl.glTexParameterx(target, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.356 -0500", hash_original_method = "59D5A740E5B6ED728058DBF669141DA6", hash_generated_method = "3A3743CA43F14A04A8CCC5599A88B14B")
    
public void glTexParameteriv(int target, int pname, int[] params, int offset) {
        checkThread();
        mgl11.glTexParameteriv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.359 -0500", hash_original_method = "218137A131A9C4185C80244BAFFDAB2B", hash_generated_method = "933E446E2CF19B6A8979B3F929114A03")
    
public void glTexParameteriv(int target, int pname, IntBuffer params) {
        checkThread();
        mgl11.glTexParameteriv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.363 -0500", hash_original_method = "D3705A7A4690058997D3E70B15B4B35A", hash_generated_method = "09B9865E29B52FF8BC74A171A39A339B")
    
public void glTexSubImage2D(int target, int level, int xoffset,
            int yoffset, int width, int height, int format, int type,
            Buffer pixels) {
        checkThread();
        mgl.glTexSubImage2D(target, level, xoffset, yoffset, width, height,
                format, type, pixels);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.366 -0500", hash_original_method = "CE115E1F6B75AADFF6E36000C2E380B4", hash_generated_method = "3BEF4E6C394FD03BE2A387576EE86DE6")
    
public void glTranslatef(float x, float y, float z) {
        checkThread();
        mgl.glTranslatef(x, y, z);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.368 -0500", hash_original_method = "D192DE8E7154BF31DD7446833CC358B1", hash_generated_method = "743389F62A9347D83692AB5AB5A35F65")
    
public void glTranslatex(int x, int y, int z) {
        checkThread();
        mgl.glTranslatex(x, y, z);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.371 -0500", hash_original_method = "B863B365542A05B8E086855775B1B25D", hash_generated_method = "6EB2974534B942692B03C0714DC8463C")
    
public void glVertexPointer(int size, int type,
            int stride, Buffer pointer) {
        checkThread();
        mgl.glVertexPointer(size, type, stride, pointer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.373 -0500", hash_original_method = "9EC0F2F771D5D0C8A7E09F5D4B11D824", hash_generated_method = "DE3E1D7B9B93413A725198DC42861FEE")
    
public void glViewport(int x, int y, int width, int height) {
        checkThread();
        mgl.glViewport(x, y, width, height);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.376 -0500", hash_original_method = "7047810A221DD3F1EDC6570DC2A1FDF5", hash_generated_method = "C1A7ED30FACCD86826EFB7E0A8706213")
    
public void glClipPlanef(int plane, float[] equation, int offset) {
        checkThread();
        mgl11.glClipPlanef(plane, equation, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.379 -0500", hash_original_method = "4524EF74C6AE5BF28D393D537A698406", hash_generated_method = "7DFD0F03686E288841779EA72519044F")
    
public void glClipPlanef(int plane, FloatBuffer equation) {
        checkThread();
        mgl11.glClipPlanef(plane, equation);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.382 -0500", hash_original_method = "8D3ED414E4DAA8FB74906F3B8E9D3DFF", hash_generated_method = "8A22034D1AAE64BF186C008B2C3A5479")
    
public void glClipPlanex(int plane, int[] equation, int offset) {
        checkThread();
        mgl11.glClipPlanex(plane, equation, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.385 -0500", hash_original_method = "5278C31B3053C5B981A839212DD10C5C", hash_generated_method = "BCB0555AB26D7E89E8712EA059D7F2E7")
    
public void glClipPlanex(int plane, IntBuffer equation) {
        checkThread();
        mgl11.glClipPlanex(plane, equation);
        checkError();
    }

    // Draw Texture Extension

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.388 -0500", hash_original_method = "0FCEDC37EC1AEF7D65A007BA69038B27", hash_generated_method = "9F80B23BBA18E2557AC3A2E92C6CF706")
    
public void glDrawTexfOES(float x, float y, float z,
        float width, float height) {
        checkThread();
        mgl11Ext.glDrawTexfOES(x, y, z, width, height);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.390 -0500", hash_original_method = "88145A802188502D93AE08FA1BB52C46", hash_generated_method = "261FB0ACC90DBDDAEB6A1C3FBCC8BB62")
    
public void glDrawTexfvOES(float[] coords, int offset) {
        checkThread();
        mgl11Ext.glDrawTexfvOES(coords, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.397 -0500", hash_original_method = "24FCA1E1034171BCC0A7E176807F466E", hash_generated_method = "1B43A490E98747AA10E5DDF52F1E11E1")
    
public void glDrawTexfvOES(FloatBuffer coords) {
        checkThread();
        mgl11Ext.glDrawTexfvOES(coords);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.400 -0500", hash_original_method = "5F94F2C6B5C87607C9A7CD37C21BA2F0", hash_generated_method = "9150D7FF534745904B60E69E68F898DE")
    
public void glDrawTexiOES(int x, int y, int z, int width, int height) {
        checkThread();
        mgl11Ext.glDrawTexiOES(x, y, z, width, height);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.405 -0500", hash_original_method = "8A10A1B96805BEEB05694AEBC33907E6", hash_generated_method = "CAF16CD8A1450DBBB4DC1133B4C1649C")
    
public void glDrawTexivOES(int[] coords, int offset) {
        checkThread();
        mgl11Ext.glDrawTexivOES(coords, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.408 -0500", hash_original_method = "692A90360D55EB3411EA98CDB82C7BDE", hash_generated_method = "F41A273A828A5BA4CBD6DC7066022A42")
    
public void glDrawTexivOES(IntBuffer coords) {
        checkThread();
        mgl11Ext.glDrawTexivOES(coords);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.410 -0500", hash_original_method = "81702D56D238A1680BD3BDF0524433B0", hash_generated_method = "AEE5668870CFD83B9A6E4677496E90F9")
    
public void glDrawTexsOES(short x, short y, short z,
        short width, short height) {
        checkThread();
        mgl11Ext.glDrawTexsOES(x, y, z, width, height);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.413 -0500", hash_original_method = "6AB85DDA6CE0427AE2EDBBC2E24275B1", hash_generated_method = "D3294BF0F5E690F645E27B68CB4CFFF6")
    
public void glDrawTexsvOES(short[] coords, int offset) {
        checkThread();
        mgl11Ext.glDrawTexsvOES(coords, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.416 -0500", hash_original_method = "7AD520D568193A12267AC44FDFDD1097", hash_generated_method = "BCA4B6D9CE1466C4E0B93D40963BAC5A")
    
public void glDrawTexsvOES(ShortBuffer coords) {
        checkThread();
        mgl11Ext.glDrawTexsvOES(coords);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.419 -0500", hash_original_method = "63B91529A6A9796DA0A30CFFD7F06ED7", hash_generated_method = "61B4B1AE365DA3522AE94A306572CE74")
    
public void glDrawTexxOES(int x, int y, int z, int width, int height) {
        checkThread();
        mgl11Ext.glDrawTexxOES(x, y, z, width, height);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.422 -0500", hash_original_method = "4B648AB196C3FA25858B7D3BA7B5F10D", hash_generated_method = "93DD502A8A9633A42C464FEEF1C37643")
    
public void glDrawTexxvOES(int[] coords, int offset) {
        checkThread();
        mgl11Ext.glDrawTexxvOES(coords, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.424 -0500", hash_original_method = "6943490AF23DA91633DA0E4D5D703CCA", hash_generated_method = "762584391376FEB0BD5F63764BA56321")
    
public void glDrawTexxvOES(IntBuffer coords) {
        checkThread();
        mgl11Ext.glDrawTexxvOES(coords);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.427 -0500", hash_original_method = "8AE1CE2B779B18C9E619BD00E9C57865", hash_generated_method = "210327B0F3DF633D2FD11E9AB44873FC")
    
public int glQueryMatrixxOES(int[] mantissa, int mantissaOffset,
        int[] exponent, int exponentOffset) {
        checkThread();
        int valid = mgl10Ext.glQueryMatrixxOES(mantissa, mantissaOffset,
            exponent, exponentOffset);
        checkError();
        return valid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.429 -0500", hash_original_method = "4D5D369DF37A327F0B45E7706736984A", hash_generated_method = "A064741F704F05DBC5B60013437ECDAF")
    
public int glQueryMatrixxOES(IntBuffer mantissa, IntBuffer exponent) {
        checkThread();
        int valid = mgl10Ext.glQueryMatrixxOES(mantissa, exponent);
        checkError();
        return valid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.432 -0500", hash_original_method = "655070119F623C1CB33E2355B4562236", hash_generated_method = "91B9CD28DBE06D966F90258531B34CC4")
    
public void glBindBuffer(int target, int buffer) {
        checkThread();
        mgl11.glBindBuffer(target, buffer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.435 -0500", hash_original_method = "D36E8EE52297961B1E268F2D810FCBB7", hash_generated_method = "37EF99EEDE9613502301EB050EDCCFF5")
    
public void glBufferData(int target, int size, Buffer data, int usage) {
        checkThread();
        mgl11.glBufferData(target, size, data, usage);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.437 -0500", hash_original_method = "58A3FBFC2B440B086D5A56642E743847", hash_generated_method = "B63A4E0C8ABFD8CD26D43B07B7411C97")
    
public void glBufferSubData(int target, int offset, int size, Buffer data) {
        checkThread();
        mgl11.glBufferSubData(target, offset, size, data);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.439 -0500", hash_original_method = "444437A0ACFCE50E5E28C65BA40F754E", hash_generated_method = "48E3F56DF4E603DCB6C0359E4DF7ECDF")
    
public void glColor4ub(byte red, byte green, byte blue, byte alpha) {
        checkThread();
        mgl11.glColor4ub(red, green, blue, alpha);
        checkError();    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.443 -0500", hash_original_method = "CB6938F783FBA872024BD63657012E6E", hash_generated_method = "BE17F4BD0805D54FEA72E5DCCF38A1F5")
    
public void glColorPointer(int size, int type, int stride, int offset) {
        checkThread();
        mgl11.glColorPointer(size, type, stride, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.447 -0500", hash_original_method = "A81597F844D12564DAC88D479B6FC826", hash_generated_method = "34882501110F97F6CEBD2DD211498C3E")
    
public void glDeleteBuffers(int n, int[] buffers, int offset) {
        checkThread();
        mgl11.glDeleteBuffers(n, buffers, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.449 -0500", hash_original_method = "5B6D4EA57BAFDD81C8853EA1ED7813DC", hash_generated_method = "7B6C0BDC8AB83B5485EBD3885F89E844")
    
public void glDeleteBuffers(int n, IntBuffer buffers) {
        checkThread();
        mgl11.glDeleteBuffers(n, buffers);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.452 -0500", hash_original_method = "E6ACEB3407FC5A9C7E889C8CF725F0A3", hash_generated_method = "4A985AC20265AC85F42C9E29707DF175")
    
public void glDrawElements(int mode, int count, int type, int offset) {
        checkThread();
        mgl11.glDrawElements(mode, count, type, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.456 -0500", hash_original_method = "CFA5150AABB1A42C94FC86D6C76B8BD5", hash_generated_method = "09D4CC2E5C7AEFA88E8152659C8B7418")
    
public void glGenBuffers(int n, int[] buffers, int offset) {
        checkThread();
        mgl11.glGenBuffers(n, buffers, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.461 -0500", hash_original_method = "6391775B807A9608A5EE1CA6E7D21669", hash_generated_method = "0E1D004AFC9EE81CC940A10E67C18971")
    
public void glGenBuffers(int n, IntBuffer buffers) {
        checkThread();
        mgl11.glGenBuffers(n, buffers);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.464 -0500", hash_original_method = "F75450D7C7444C435F8741AAB8FA2103", hash_generated_method = "C5DBE6BAA37E4E0F4B46E786399771CD")
    
public void glGetBooleanv(int pname, boolean[] params, int offset) {
        checkThread();
        mgl11.glGetBooleanv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.466 -0500", hash_original_method = "269C7585F15177DC6B6DBD7C8BA80391", hash_generated_method = "7AF1A6226B4BF50FC3B15640EF27563E")
    
public void glGetBooleanv(int pname, IntBuffer params) {
        checkThread();
        mgl11.glGetBooleanv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.469 -0500", hash_original_method = "910DEB37CA8500A9D8C280513FDB7343", hash_generated_method = "F1F40B9CC3A1A8A7E938519B6BBA6CBA")
    
public void glGetBufferParameteriv(int target, int pname, int[] params,
            int offset) {
        checkThread();
        mgl11.glGetBufferParameteriv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.471 -0500", hash_original_method = "0413FB8D485131E48F4FCE9E1B338F85", hash_generated_method = "BE5218F4555B25E01957455BC981B47E")
    
public void glGetBufferParameteriv(int target, int pname, IntBuffer params) {
        checkThread();
        mgl11.glGetBufferParameteriv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.474 -0500", hash_original_method = "C094174C215471B93DD0CF5F6242F0A2", hash_generated_method = "EC96B9BC4607371D7DCF34ACDAF8EAA1")
    
public void glGetClipPlanef(int pname, float[] eqn, int offset) {
        checkThread();
        mgl11.glGetClipPlanef(pname, eqn, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.477 -0500", hash_original_method = "A30ACCDBD8937013825066210B40F476", hash_generated_method = "BB5E62D2D69F8D7168EC2896AD86E5C8")
    
public void glGetClipPlanef(int pname, FloatBuffer eqn) {
        checkThread();
        mgl11.glGetClipPlanef(pname, eqn);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.480 -0500", hash_original_method = "961158B6D0A4CA86A20FEA7E67BE9733", hash_generated_method = "D03E4230419B35D15721B6B40423FC0F")
    
public void glGetClipPlanex(int pname, int[] eqn, int offset) {
        checkThread();
        mgl11.glGetClipPlanex(pname, eqn, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.484 -0500", hash_original_method = "F062138EA2A7B6002FF45099E6DE7314", hash_generated_method = "4336CDD694865836F95E780D0B1C2382")
    
public void glGetClipPlanex(int pname, IntBuffer eqn) {
        checkThread();
        mgl11.glGetClipPlanex(pname, eqn);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.487 -0500", hash_original_method = "5AAD7A7380F58498F1CE56AF8503572A", hash_generated_method = "E7AEDC092A84FB73E7D06F34E2F5EA90")
    
public void glGetFixedv(int pname, int[] params, int offset) {
        checkThread();
        mgl11.glGetFixedv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.497 -0500", hash_original_method = "EAF527388692D1D3857E4D28DC60B040", hash_generated_method = "63ABD547D8536D27DBAED22B4E32DBF4")
    
public void glGetFixedv(int pname, IntBuffer params) {
        checkThread();
        mgl11.glGetFixedv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.499 -0500", hash_original_method = "E963084C6F824AF23632AAB944CC40E4", hash_generated_method = "DD07E779E6A79635D67C7E928B3BFA7E")
    
public void glGetFloatv(int pname, float[] params, int offset) {
        checkThread();
        mgl11.glGetFloatv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.502 -0500", hash_original_method = "A4E0C02BD0ADA35BE03B7090CFF2E117", hash_generated_method = "9D27700DBC5EB531BEEFCC5CAE956AC9")
    
public void glGetFloatv(int pname, FloatBuffer params) {
        checkThread();
        mgl11.glGetFloatv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.505 -0500", hash_original_method = "E73442DF8AD59B26FE8FDF5B909DA2B0", hash_generated_method = "4F268196AB19C076F16729D9AF58C68F")
    
public void glGetLightfv(int light, int pname, float[] params, int offset) {
        checkThread();
        mgl11.glGetLightfv(light, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.507 -0500", hash_original_method = "B540E2EB59953E516E97ED929386FC6C", hash_generated_method = "801303DE2BCFBD4442FECC664FA18825")
    
public void glGetLightfv(int light, int pname, FloatBuffer params) {
        checkThread();
        mgl11.glGetLightfv(light, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.510 -0500", hash_original_method = "DEFD88ABBAB6979F4E14C39CC43D54FC", hash_generated_method = "2CD9B24836FB8110D2B9BA75438D81B3")
    
public void glGetLightxv(int light, int pname, int[] params, int offset) {
        checkThread();
        mgl11.glGetLightxv(light, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.512 -0500", hash_original_method = "2C612A2C9FF2B9D7139609339424A0E6", hash_generated_method = "0A873B236BB823CC32A49864205EDCC6")
    
public void glGetLightxv(int light, int pname, IntBuffer params) {
        checkThread();
        mgl11.glGetLightxv(light, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.515 -0500", hash_original_method = "09E308054ADE4570647C8752CB0B7DE3", hash_generated_method = "F4F31D7A4FC12F9DA9512C322E7344C0")
    
public void glGetMaterialfv(int face, int pname, float[] params, int offset) {
        checkThread();
        mgl11.glGetMaterialfv(face, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.517 -0500", hash_original_method = "7D344DA7BB959DFC8D2CADAEFF2C24D5", hash_generated_method = "26B8DCA6D50197EC7058ED05F2AE1C1D")
    
public void glGetMaterialfv(int face, int pname, FloatBuffer params) {
        checkThread();
        mgl11.glGetMaterialfv(face, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.520 -0500", hash_original_method = "38952810A3204DAE11E450311428E7CD", hash_generated_method = "D2E72563D099B494DFEC445FECF6CE9D")
    
public void glGetMaterialxv(int face, int pname, int[] params, int offset) {
        checkThread();
        mgl11.glGetMaterialxv(face, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.522 -0500", hash_original_method = "C85F75B97C1CAF1FC7167FD807234ACC", hash_generated_method = "D4CBA4B236AB12BCD19004E02DA1CC60")
    
public void glGetMaterialxv(int face, int pname, IntBuffer params) {
        checkThread();
        mgl11.glGetMaterialxv(face, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.524 -0500", hash_original_method = "2C716D0962CE814311685802FF3D9113", hash_generated_method = "B50307F5D1397EE18F6BA6EC2F16A215")
    
public void glGetPointerv(int pname, Buffer[] params) {
        checkThread();
        mgl11.glGetPointerv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.527 -0500", hash_original_method = "5C4DC6AE2C0AF0C9C2AAF2AE14A19245", hash_generated_method = "45011D3523A44FD32F54CDEC9C32E68B")
    
public void glGetTexEnviv(int env, int pname, int[] params, int offset) {
        checkThread();
        mgl11.glGetTexEnviv(env, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.529 -0500", hash_original_method = "CE618952A7CD6015F90CBE0B3A3D5775", hash_generated_method = "B00AB4EEAA529A330408C551DCC625FC")
    
public void glGetTexEnviv(int env, int pname, IntBuffer params) {
        checkThread();
        mgl11.glGetTexEnviv(env, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.532 -0500", hash_original_method = "5EB1D10495C07594E94D7155CB64711C", hash_generated_method = "49A4D9B46B87B5EA0FE301FAB3738D85")
    
public void glGetTexEnvxv(int env, int pname, int[] params, int offset) {
        checkThread();
        mgl11.glGetTexEnvxv(env, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.534 -0500", hash_original_method = "2D1ECB0AA025367D67A05520FD32DE51", hash_generated_method = "9B3EC07D9A825B91543F1F045D77420C")
    
public void glGetTexEnvxv(int env, int pname, IntBuffer params) {
        checkThread();
        mgl11.glGetTexEnvxv(env, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.537 -0500", hash_original_method = "027C00959FDA9DB58C8D3C5BA07060CB", hash_generated_method = "B3EF833D3F20C3ACAB98A9E0635E7007")
    
public void glGetTexParameterfv(int target, int pname, float[] params,
            int offset) {
        checkThread();
        mgl11.glGetTexParameterfv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.539 -0500", hash_original_method = "73FFDCC5F1C4D8C1BED3A96EEAFAFB59", hash_generated_method = "181DD3EBD5FE641D9033FB946AC736D6")
    
public void glGetTexParameterfv(int target, int pname, FloatBuffer params) {
        checkThread();
        mgl11.glGetTexParameterfv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.542 -0500", hash_original_method = "7A9D7CFB854F29053AE4903A6E7333EC", hash_generated_method = "B429FC5AD7B70BA82BA65442B16B4F1A")
    
public void glGetTexParameteriv(int target, int pname, int[] params,
            int offset) {
        checkThread();
        mgl11.glGetTexParameteriv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.544 -0500", hash_original_method = "5F58354BF13AA74BA47342C6E757B985", hash_generated_method = "FF4ADB0CA6CA6216A3FA64E2BE254794")
    
public void glGetTexParameteriv(int target, int pname, IntBuffer params) {
        checkThread();
        mgl11.glGetTexParameteriv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.546 -0500", hash_original_method = "CDD87A4F0770CA20A840C05B71F4728C", hash_generated_method = "A8463B2B862873AD445C407B8A9AB4F4")
    
public void glGetTexParameterxv(int target, int pname, int[] params,
            int offset) {
        checkThread();
        mgl11.glGetTexParameterxv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.549 -0500", hash_original_method = "AEB326BB00CC7C450624FECAB4627E59", hash_generated_method = "FDE18F08D1035FB2C7B5181FA7B5A5E3")
    
public void glGetTexParameterxv(int target, int pname, IntBuffer params) {
        checkThread();
        mgl11.glGetTexParameterxv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.551 -0500", hash_original_method = "B897EB6A1DF48FCC02DEF57402E4DC57", hash_generated_method = "BE15C723C4F27B164F2D53A0E3D62351")
    
public boolean glIsBuffer(int buffer) {
        checkThread();
        boolean valid = mgl11.glIsBuffer(buffer);
        checkError();
        return valid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.553 -0500", hash_original_method = "717E55FCFC9E5B49869B76793AE6BE5B", hash_generated_method = "7AA8E1B4FB45EA1325D7675517D1C6A3")
    
public boolean glIsEnabled(int cap) {
        checkThread();
        boolean valid = mgl11.glIsEnabled(cap);
        checkError();
        return valid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.556 -0500", hash_original_method = "8D9C6A2F92FBF209F9ABDD2C63C90623", hash_generated_method = "18A5534D3A5414475F010CD74A4E76B7")
    
public boolean glIsTexture(int texture) {
        checkThread();
        boolean valid = mgl11.glIsTexture(texture);
        checkError();
        return valid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.558 -0500", hash_original_method = "AFA751EB12E4E9AA30C2773EF87587EF", hash_generated_method = "67E3AAE363D575BFF79A27E0A3172BDA")
    
public void glNormalPointer(int type, int stride, int offset) {
        checkThread();
        mgl11.glNormalPointer(type, stride, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.561 -0500", hash_original_method = "30B61B02BB542D0246C7639871EBCF8D", hash_generated_method = "A3CAA3FAD7BCC7CF78655CB0AD3A8CD4")
    
public void glPointParameterf(int pname, float param) {
        checkThread();
        mgl11.glPointParameterf(pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.563 -0500", hash_original_method = "46F01779CDDEA5B40F098409E8EE25B1", hash_generated_method = "8ECB5E5830A4D85DDFA54A81156549C4")
    
public void glPointParameterfv(int pname, float[] params, int offset) {
        checkThread();
        mgl11.glPointParameterfv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.566 -0500", hash_original_method = "E374C596C6B6AF7806CFCE55C4A9AD1D", hash_generated_method = "59A1BE47B337AA4955CF1B5A28457626")
    
public void glPointParameterfv(int pname, FloatBuffer params) {
        checkThread();
        mgl11.glPointParameterfv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.568 -0500", hash_original_method = "C503F4E840447B56F9AB279DF9CDE641", hash_generated_method = "BB976E81B5CCB8E92728D83DE0F965EC")
    
public void glPointParameterx(int pname, int param) {
        checkThread();
        mgl11.glPointParameterx(pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.570 -0500", hash_original_method = "D2F91263CE5DDFA5392566A03FA7D2B0", hash_generated_method = "204A302C3F1B1379E02A3E7229F8DA59")
    
public void glPointParameterxv(int pname, int[] params, int offset) {
        checkThread();
        mgl11.glPointParameterxv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.572 -0500", hash_original_method = "5B0992AA9007415E9AC6D59FF588E4CB", hash_generated_method = "AFB6D3ABD42BD76C0D9B86B9F3875317")
    
public void glPointParameterxv(int pname, IntBuffer params) {
        checkThread();
        mgl11.glPointParameterxv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.575 -0500", hash_original_method = "902E5A7C5C294084D5E3D8122C4AEEC8", hash_generated_method = "255DE448E821140C2D605A38D65C72CC")
    
public void glPointSizePointerOES(int type, int stride, Buffer pointer) {
        checkThread();
        mgl11.glPointSizePointerOES(type, stride, pointer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.577 -0500", hash_original_method = "604B2E9120D0E3EC03CBDFCF47B14ABC", hash_generated_method = "05CB10F26830F3B77678534A30C11A51")
    
public void glTexCoordPointer(int size, int type, int stride, int offset) {
        checkThread();
        mgl11.glTexCoordPointer(size, type, stride, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.580 -0500", hash_original_method = "A91D5E5F18F2244824FF05383824F9A5", hash_generated_method = "BC5D6A519014D0291294B678781F9CCC")
    
public void glTexEnvi(int target, int pname, int param) {
        checkThread();
        mgl11.glTexEnvi(target, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.583 -0500", hash_original_method = "C37711363D7C727366CC86C0DD45CDDB", hash_generated_method = "727E145DBC78A967BC7F0628EBC46114")
    
public void glTexEnviv(int target, int pname, int[] params, int offset) {
        checkThread();
        mgl11.glTexEnviv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.586 -0500", hash_original_method = "E301C7591BA95AE0CEB4758A9F1FD0D1", hash_generated_method = "D3043C4B60E4FD1D00E3D921CED5F8D1")
    
public void glTexEnviv(int target, int pname, IntBuffer params) {
        checkThread();
        mgl11.glTexEnviv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.588 -0500", hash_original_method = "67E5BFE5167DFA5DACAF9CBF1882013B", hash_generated_method = "0AD0EDF3D9240B3DDAFE542BCB631959")
    
public void glTexParameterfv(int target, int pname, float[] params,
            int offset) {
        checkThread();
        mgl11.glTexParameterfv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.590 -0500", hash_original_method = "EC2662F7DD5D640D328EC7537D420284", hash_generated_method = "2684421D63DB78810B4061AA8D9DFB0C")
    
public void glTexParameterfv(int target, int pname, FloatBuffer params) {
        checkThread();
        mgl11.glTexParameterfv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.593 -0500", hash_original_method = "D3C0A5F0BBC7AE9B1CCB8C74B1764F15", hash_generated_method = "E5816EA1B3F5923C2D289DC0ADD53D2D")
    
public void glTexParameteri(int target, int pname, int param) {
        checkThread();
        mgl11.glTexParameteri(target, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.595 -0500", hash_original_method = "EE4F0C55DF4DFD1C3861D9BC1ADDA63E", hash_generated_method = "85A4B08FC51568BF36B3F7794C876036")
    
public void glTexParameterxv(int target, int pname, int[] params, int offset) {
        checkThread();
        mgl11.glTexParameterxv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.597 -0500", hash_original_method = "5B80AEAE46FF3D8CD31CD4B1071661B7", hash_generated_method = "7514018EE6F27F37B3A99518075C8D8C")
    
public void glTexParameterxv(int target, int pname, IntBuffer params) {
        checkThread();
        mgl11.glTexParameterxv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.600 -0500", hash_original_method = "512C10702F6071A16B75D9CF2D1086A6", hash_generated_method = "51EDDFA610C16B48DC78EC5CD1D2C8B0")
    
public void glVertexPointer(int size, int type, int stride, int offset) {
        checkThread();
        mgl11.glVertexPointer(size, type, stride, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.602 -0500", hash_original_method = "ECE8E03D9351084EB6DD58269537E15C", hash_generated_method = "5597304CDCD7ED9FC3579F6154E575BA")
    
public void glCurrentPaletteMatrixOES(int matrixpaletteindex) {
        checkThread();
        mgl11Ext.glCurrentPaletteMatrixOES(matrixpaletteindex);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.604 -0500", hash_original_method = "5AD566EDA8530FFFD9489137646EB6A1", hash_generated_method = "9525CAC8495FDE58036F273B60447C6E")
    
public void glLoadPaletteFromModelViewMatrixOES() {
        checkThread();
        mgl11Ext.glLoadPaletteFromModelViewMatrixOES();
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.607 -0500", hash_original_method = "9086F58902230C979E6EBFA4BA74064C", hash_generated_method = "0065258C9E2EB83FAA672A045CA22E99")
    
public void glMatrixIndexPointerOES(int size, int type, int stride,
            Buffer pointer) {
        checkThread();
        mgl11Ext.glMatrixIndexPointerOES(size, type, stride, pointer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.609 -0500", hash_original_method = "0984DC91B3016A56DD022967F452ACBA", hash_generated_method = "96D9FEFAE6300362A5180055F0221E35")
    
public void glMatrixIndexPointerOES(int size, int type, int stride,
            int offset) {
        checkThread();
        mgl11Ext.glMatrixIndexPointerOES(size, type, stride, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.612 -0500", hash_original_method = "990474B3CC64B92B9B97EA6700AA2D0C", hash_generated_method = "BEF4DED509B67CE3400C52D55060A8EC")
    
public void glWeightPointerOES(int size, int type, int stride,
            Buffer pointer) {
        checkThread();
        mgl11Ext.glWeightPointerOES(size, type, stride, pointer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.615 -0500", hash_original_method = "05D33A5D8AC487A90293158490370D32", hash_generated_method = "5EC5C99DB9C3F5A59C7C8FA3B405DDD9")
    
public void glWeightPointerOES(int size, int type, int stride, int offset) {
        checkThread();
        mgl11Ext.glWeightPointerOES(size, type, stride, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.617 -0500", hash_original_method = "D2F7C990667B56FDD1F6E8C479EF3E4E", hash_generated_method = "0B60107880436392D837F01C062BA6C3")
    
@Override
    public void glBindFramebufferOES(int target, int framebuffer) {
        checkThread();
        mgl11ExtensionPack.glBindFramebufferOES(target, framebuffer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.620 -0500", hash_original_method = "7EB73AC724C3D8EE1D3B48DB2F9132D2", hash_generated_method = "5304EA88F4DF7032D1086C7B21BC9DDF")
    
@Override
    public void glBindRenderbufferOES(int target, int renderbuffer) {
        checkThread();
        mgl11ExtensionPack.glBindRenderbufferOES(target, renderbuffer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.622 -0500", hash_original_method = "D19C6515B3BFC46C895E49F99DAEC2CE", hash_generated_method = "2EF499477A6FF2691EB7BB6506346A01")
    
@Override
    public void glBlendEquation(int mode) {
        checkThread();
        mgl11ExtensionPack.glBlendEquation(mode);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.624 -0500", hash_original_method = "F957D0CDD60A7381A725B04FB0D2DA70", hash_generated_method = "B9B16308E09406A3FC5E60821D495BE4")
    
@Override
    public void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
        checkThread();
        mgl11ExtensionPack.glBlendEquationSeparate(modeRGB, modeAlpha);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.628 -0500", hash_original_method = "498C1CF1FE30AA03446C52CC21D33437", hash_generated_method = "1F7A96988DB6617268F47A727B9E59E2")
    
@Override
    public void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha,
            int dstAlpha) {
        checkThread();
        mgl11ExtensionPack.glBlendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.630 -0500", hash_original_method = "F84CD15747EF92B360235F98C0C8FE92", hash_generated_method = "6886E69BC177167C28E29A32D4B2A0D9")
    
@Override
    public int glCheckFramebufferStatusOES(int target) {
        checkThread();
        int result = mgl11ExtensionPack.glCheckFramebufferStatusOES(target);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.633 -0500", hash_original_method = "C83794D04134327ED293408C6EAFA3F1", hash_generated_method = "725672968F0A5A6C6C3DD25BF3B5684B")
    
@Override
    public void glDeleteFramebuffersOES(int n, int[] framebuffers, int offset) {
        checkThread();
        mgl11ExtensionPack.glDeleteFramebuffersOES(n, framebuffers, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.635 -0500", hash_original_method = "637818FA141CF6CB105E4E7D4B6E5E9F", hash_generated_method = "145CF00480142FBE5A2C10FC48FE56C0")
    
@Override
    public void glDeleteFramebuffersOES(int n, IntBuffer framebuffers) {
        checkThread();
        mgl11ExtensionPack.glDeleteFramebuffersOES(n, framebuffers);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.638 -0500", hash_original_method = "DFC95BCA265F134EDD9DF8501B456CC5", hash_generated_method = "E27BF14C5812E3702CBF98A225BAFF7E")
    
@Override
    public void glDeleteRenderbuffersOES(int n, int[] renderbuffers, int offset) {
        checkThread();
        mgl11ExtensionPack.glDeleteRenderbuffersOES(n, renderbuffers, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.640 -0500", hash_original_method = "E94D9C754DAC473C75BBE28B377B49F6", hash_generated_method = "C6BCE7B97CD385B7B3C50ACD329871FF")
    
@Override
    public void glDeleteRenderbuffersOES(int n, IntBuffer renderbuffers) {
        checkThread();
        mgl11ExtensionPack.glDeleteRenderbuffersOES(n, renderbuffers);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.643 -0500", hash_original_method = "AA45795C829A618DCE01DCFC13E444AD", hash_generated_method = "299297FE8D370F99A9B70CA35A228A66")
    
@Override
    public void glFramebufferRenderbufferOES(int target, int attachment,
            int renderbuffertarget, int renderbuffer) {
        checkThread();
        mgl11ExtensionPack.glFramebufferRenderbufferOES(target, attachment, renderbuffertarget, renderbuffer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.645 -0500", hash_original_method = "E8C69625776C23938AEC9F5A5D2ED0AD", hash_generated_method = "17B007E613F8B138790D08D82EA8DB49")
    
@Override
    public void glFramebufferTexture2DOES(int target, int attachment,
            int textarget, int texture, int level) {
        checkThread();
        mgl11ExtensionPack.glFramebufferTexture2DOES(target, attachment, textarget, texture, level);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.648 -0500", hash_original_method = "A2D1B5AEB61D99CDE4C449FF577D7526", hash_generated_method = "DA29241A7E754440ED5C27B6A32D84E2")
    
@Override
    public void glGenerateMipmapOES(int target) {
        checkThread();
        mgl11ExtensionPack.glGenerateMipmapOES(target);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.651 -0500", hash_original_method = "4C10D6C69F4D6D86BC597FA354D0E064", hash_generated_method = "6C462CAD96E37A0EC45C53A6516C5880")
    
@Override
    public void glGenFramebuffersOES(int n, int[] framebuffers, int offset) {
        checkThread();
        mgl11ExtensionPack.glGenFramebuffersOES(n, framebuffers, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.653 -0500", hash_original_method = "3367B19C8B35C9E70E007013ACA3FDCB", hash_generated_method = "8455316BE199FD70C3B98F6C986539DD")
    
@Override
    public void glGenFramebuffersOES(int n, IntBuffer framebuffers) {
        checkThread();
        mgl11ExtensionPack.glGenFramebuffersOES(n, framebuffers);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.656 -0500", hash_original_method = "CBB8CAE1C22A3D14C85E49EEFB97952B", hash_generated_method = "6950F0D7B833766C3C16EC40B6CC6636")
    
@Override
    public void glGenRenderbuffersOES(int n, int[] renderbuffers, int offset) {
        checkThread();
        mgl11ExtensionPack.glGenRenderbuffersOES(n, renderbuffers, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.659 -0500", hash_original_method = "503D16E0F87FB104483D3BC7B0BEEC61", hash_generated_method = "47BE366D9F703FAB70A97DAFAA58DA83")
    
@Override
    public void glGenRenderbuffersOES(int n, IntBuffer renderbuffers) {
        checkThread();
        mgl11ExtensionPack.glGenRenderbuffersOES(n, renderbuffers);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.661 -0500", hash_original_method = "87D1033F5DA311CE50445AE95714BB98", hash_generated_method = "E2ABDE5A1BF5E029C0EDD17CBEA4FA2F")
    
@Override
    public void glGetFramebufferAttachmentParameterivOES(int target,
            int attachment, int pname, int[] params, int offset) {
        checkThread();
        mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(target, attachment, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.663 -0500", hash_original_method = "23B2B17D963584AB5B41C0BADA7D30E2", hash_generated_method = "9FF9E386ABC1CF15E28C258ED160DC95")
    
@Override
    public void glGetFramebufferAttachmentParameterivOES(int target,
            int attachment, int pname, IntBuffer params) {
        checkThread();
        mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(target, attachment, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.666 -0500", hash_original_method = "323B7FC14FA3CC8A8CAB2937FB85AF32", hash_generated_method = "DEAF769F989EEC1AEBE95F91623817B8")
    
@Override
    public void glGetRenderbufferParameterivOES(int target, int pname,
            int[] params, int offset) {
        checkThread();
        mgl11ExtensionPack.glGetRenderbufferParameterivOES(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.668 -0500", hash_original_method = "7DB224D75C69362AC7C1B5BFA2C118E8", hash_generated_method = "B5632DFF4A76AABC0A392A28F35A3802")
    
@Override
    public void glGetRenderbufferParameterivOES(int target, int pname,
            IntBuffer params) {
        checkThread();
        mgl11ExtensionPack.glGetRenderbufferParameterivOES(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.671 -0500", hash_original_method = "73C5B23679F5E7FD2A22CB0DDCB6E37E", hash_generated_method = "867AEA4129A5CB84280D4861CC509955")
    
@Override
    public void glGetTexGenfv(int coord, int pname, float[] params, int offset) {
        checkThread();
        mgl11ExtensionPack.glGetTexGenfv(coord, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.674 -0500", hash_original_method = "B36FB07131DC4A84E371A2A7731CAC6D", hash_generated_method = "83B8FB3161D908EB502C206AD804F991")
    
@Override
    public void glGetTexGenfv(int coord, int pname, FloatBuffer params) {
        checkThread();
        mgl11ExtensionPack.glGetTexGenfv(coord, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.676 -0500", hash_original_method = "B7FA1E60287A66F116F39D7CC7313D43", hash_generated_method = "0903BE5C36DF72A9935D533340AF7670")
    
@Override
    public void glGetTexGeniv(int coord, int pname, int[] params, int offset) {
        checkThread();
        mgl11ExtensionPack.glGetTexGeniv(coord, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.679 -0500", hash_original_method = "E0F30C6998C067FD1FF731B16C9025B6", hash_generated_method = "720F4A5879433D21AA0F074B09F10CAC")
    
@Override
    public void glGetTexGeniv(int coord, int pname, IntBuffer params) {
        checkThread();
        mgl11ExtensionPack.glGetTexGeniv(coord, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.681 -0500", hash_original_method = "5DB0F3E94FEB1D4B3503AAE5DF93A903", hash_generated_method = "D558D3C087BE2455292AAE2021E9D3BC")
    
@Override
    public void glGetTexGenxv(int coord, int pname, int[] params, int offset) {
        checkThread();
        mgl11ExtensionPack.glGetTexGenxv(coord, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.684 -0500", hash_original_method = "AA14C0675EB4BF5F25A5A7A59A9BBFAE", hash_generated_method = "F5388DB315756A0CAC85F660CB279A83")
    
@Override
    public void glGetTexGenxv(int coord, int pname, IntBuffer params) {
        checkThread();
        mgl11ExtensionPack.glGetTexGenxv(coord, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.687 -0500", hash_original_method = "0E8C838174C4BB1B590990BB7945115F", hash_generated_method = "7DC1AB4A49DFD4973EA7CC03463F3488")
    
@Override
    public boolean glIsFramebufferOES(int framebuffer) {
        checkThread();
        boolean result = mgl11ExtensionPack.glIsFramebufferOES(framebuffer);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.689 -0500", hash_original_method = "D031C45B6462249C22BD3E4499FFA099", hash_generated_method = "9BEE9BF9A0E69C051E7FE06164D1EADD")
    
@Override
    public boolean glIsRenderbufferOES(int renderbuffer) {
        checkThread();
        mgl11ExtensionPack.glIsRenderbufferOES(renderbuffer);
        checkError();
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.691 -0500", hash_original_method = "444A1D32ABDE121DF7D78030687A057E", hash_generated_method = "4267C1FB90361B52FF21A26772917A20")
    
@Override
    public void glRenderbufferStorageOES(int target, int internalformat,
            int width, int height) {
        checkThread();
        mgl11ExtensionPack.glRenderbufferStorageOES(target, internalformat, width, height);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.694 -0500", hash_original_method = "D8E84864F1630E48A87EA7635B30F5FF", hash_generated_method = "39580ADB9E4539F836E507D9D4A8EBBB")
    
@Override
    public void glTexGenf(int coord, int pname, float param) {
        checkThread();
        mgl11ExtensionPack.glTexGenf(coord, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.696 -0500", hash_original_method = "89B89821CA5D1C02C21E159AEC9A16EE", hash_generated_method = "E74534C31F7F793E54C92AE7626F3495")
    
@Override
    public void glTexGenfv(int coord, int pname, float[] params, int offset) {
        checkThread();
        mgl11ExtensionPack.glTexGenfv(coord, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.699 -0500", hash_original_method = "346783C2FA9147EBFCC1D68CE89FCD8D", hash_generated_method = "91AA960AFEBA0BF305894033358E5707")
    
@Override
    public void glTexGenfv(int coord, int pname, FloatBuffer params) {
        checkThread();
        mgl11ExtensionPack.glTexGenfv(coord, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.702 -0500", hash_original_method = "49F0D12B261A60762A8FDD97C3F8F021", hash_generated_method = "595223F8982B679A3BE1C4729F2011AC")
    
@Override
    public void glTexGeni(int coord, int pname, int param) {
        checkThread();
        mgl11ExtensionPack.glTexGeni(coord, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.704 -0500", hash_original_method = "140B3D5E9BE0C9BFC78A8488F14D55A1", hash_generated_method = "99102EC990D8ABECC8992474D9F1F541")
    
@Override
    public void glTexGeniv(int coord, int pname, int[] params, int offset) {
        checkThread();
        mgl11ExtensionPack.glTexGeniv(coord, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.706 -0500", hash_original_method = "75FF264C9BAB17A9B23FB5DFFC4BFB1E", hash_generated_method = "25F5022D3FFF6299C6DE96DCEA29A770")
    
@Override
    public void glTexGeniv(int coord, int pname, IntBuffer params) {
        checkThread();
        mgl11ExtensionPack.glTexGeniv(coord, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.708 -0500", hash_original_method = "E13CD1A4EE5E6531CF166304F3752DE9", hash_generated_method = "87254CA84CDC664E63AB0D33CB7A15A6")
    
@Override
    public void glTexGenx(int coord, int pname, int param) {
        checkThread();
        mgl11ExtensionPack.glTexGenx(coord, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.711 -0500", hash_original_method = "1B032D1F840008F790F14DDB1C46FEBC", hash_generated_method = "9C1DAE09B41869B5EEECFF000C058139")
    
@Override
    public void glTexGenxv(int coord, int pname, int[] params, int offset) {
        checkThread();
        mgl11ExtensionPack.glTexGenxv(coord, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:04.713 -0500", hash_original_method = "D73C17BE641E9517FD70F561167E80EC", hash_generated_method = "787798F91A25E8502FA525BE4F8B6766")
    
@Override
    public void glTexGenxv(int coord, int pname, IntBuffer params) {
        checkThread();
        mgl11ExtensionPack.glTexGenxv(coord, pname, params);
        checkError();
    }
    
}

