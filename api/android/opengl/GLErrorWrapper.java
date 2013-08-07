package android.opengl;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL;




class GLErrorWrapper extends GLWrapperBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.327 -0400", hash_original_field = "0A62057C5CEDB9A6C64FF2E17CCC4D50", hash_generated_field = "8BAF20A7CA64C101926E06DD40CFBFBF")

    boolean mCheckError;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.328 -0400", hash_original_field = "A7C04DFFC7B966C14F5325ABF42EC85F", hash_generated_field = "D52119176934FABB8A61F86CFB04D0F4")

    boolean mCheckThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.328 -0400", hash_original_field = "FDB35AE69B759BF759AAF1CC01D1686F", hash_generated_field = "1D0FEE70ACCFA6043BF059ED5E9200E9")

    Thread mOurThread;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.328 -0400", hash_original_method = "C181619CCB40EB18FF121A09C05E4687", hash_generated_method = "9209FEC4718FFBB927B0ECA8D410C78F")
    public  GLErrorWrapper(GL gl, int configFlags) {
        super(gl);
        addTaint(gl.getTaint());
        mCheckError = (configFlags & GLDebugHelper.CONFIG_CHECK_GL_ERROR) != 0;
        mCheckThread = (configFlags & GLDebugHelper.CONFIG_CHECK_THREAD) != 0;
        // ---------- Original Method ----------
        //mCheckError = (configFlags & GLDebugHelper.CONFIG_CHECK_GL_ERROR) != 0;
        //mCheckThread = (configFlags & GLDebugHelper.CONFIG_CHECK_THREAD) != 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.329 -0400", hash_original_method = "8D2CFEB19FD30277708BE9D87CBF31F7", hash_generated_method = "FF072D9B1126D97D553592ECDD4164F2")
    private void checkThread() {
        if(mCheckThread)        
        {
            Thread currentThread = Thread.currentThread();
            if(mOurThread == null)            
            {
                mOurThread = currentThread;
            } //End block
            else
            {
                if(!mOurThread.equals(currentThread))                
                {
                    GLException var63A0325309B93193A5352FACF7325E6F_1605725563 = new GLException(GLDebugHelper.ERROR_WRONG_THREAD,
                            "OpenGL method called from wrong thread.");
                    var63A0325309B93193A5352FACF7325E6F_1605725563.addTaint(taint);
                    throw var63A0325309B93193A5352FACF7325E6F_1605725563;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mCheckThread) {
            //Thread currentThread = Thread.currentThread();
            //if (mOurThread == null) {
                //mOurThread = currentThread;
            //} else {
                //if (!mOurThread.equals(currentThread)) {
                    //throw new GLException(GLDebugHelper.ERROR_WRONG_THREAD,
                            //"OpenGL method called from wrong thread.");
                //}
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.329 -0400", hash_original_method = "DFE4358DBB87A194B0A1ECCFFB0EC18F", hash_generated_method = "EEF2C309706B5DF3227DD973A1581674")
    private void checkError() {
        if(mCheckError)        
        {
            int glError;
            if((glError = mgl.glGetError()) != 0)            
            {
                GLException varB9995BF60453CC7D0BAC95E9E101000A_1658992369 = new GLException(glError);
                varB9995BF60453CC7D0BAC95E9E101000A_1658992369.addTaint(taint);
                throw varB9995BF60453CC7D0BAC95E9E101000A_1658992369;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mCheckError) {
            //int glError;
            //if ((glError = mgl.glGetError()) != 0) {
                //throw new GLException(glError);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.330 -0400", hash_original_method = "DA5ED54245C57C6A9FD75DE260C03262", hash_generated_method = "B25FF1F67415B43E33D001B12D31F95F")
    public void glActiveTexture(int texture) {
        addTaint(texture);
        checkThread();
        mgl.glActiveTexture(texture);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glActiveTexture(texture);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.330 -0400", hash_original_method = "B3DDF475E5452B26AE190A327782F2A9", hash_generated_method = "B843777CF01C5CAACD4C61467ADF794F")
    public void glAlphaFunc(int func, float ref) {
        addTaint(ref);
        addTaint(func);
        checkThread();
        mgl.glAlphaFunc(func, ref);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glAlphaFunc(func, ref);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.331 -0400", hash_original_method = "0CA7CE5E6095EBD7BCF61FBB33E00E0D", hash_generated_method = "12ED89A022B9ABC7EB47C9CC94FEA3EF")
    public void glAlphaFuncx(int func, int ref) {
        addTaint(ref);
        addTaint(func);
        checkThread();
        mgl.glAlphaFuncx(func, ref);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glAlphaFuncx(func, ref);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.332 -0400", hash_original_method = "B4B709A779E5229A49D0CB8C56AE7C7C", hash_generated_method = "5483841D575A3C0793CF9A29F06845A5")
    public void glBindTexture(int target, int texture) {
        addTaint(texture);
        addTaint(target);
        checkThread();
        mgl.glBindTexture(target, texture);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glBindTexture(target, texture);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.332 -0400", hash_original_method = "896046A1246C7997FCC63F53EE6CC83B", hash_generated_method = "61F283368AFF3CBD355A921B10A65AD6")
    public void glBlendFunc(int sfactor, int dfactor) {
        addTaint(dfactor);
        addTaint(sfactor);
        checkThread();
        mgl.glBlendFunc(sfactor, dfactor);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glBlendFunc(sfactor, dfactor);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.332 -0400", hash_original_method = "327FCDF3B3408904218078A84E308554", hash_generated_method = "309C12EC002E7AD30BF9D338A3229C1B")
    public void glClear(int mask) {
        addTaint(mask);
        checkThread();
        mgl.glClear(mask);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glClear(mask);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.333 -0400", hash_original_method = "4364D8D5F51B3C6569C8F39D4E51EA04", hash_generated_method = "3126DE78A319B06BB6AA81E1C8853551")
    public void glClearColor(float red, float green, float blue, float alpha) {
        addTaint(alpha);
        addTaint(blue);
        addTaint(green);
        addTaint(red);
        checkThread();
        mgl.glClearColor(red, green, blue, alpha);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glClearColor(red, green, blue, alpha);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.333 -0400", hash_original_method = "D2DEDD116EFFEC5BB8EED9065CF8099B", hash_generated_method = "51F55E88C34FE087CF6720077BC57129")
    public void glClearColorx(int red, int green, int blue, int alpha) {
        addTaint(alpha);
        addTaint(blue);
        addTaint(green);
        addTaint(red);
        checkThread();
        mgl.glClearColorx(red, green, blue, alpha);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glClearColorx(red, green, blue, alpha);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.334 -0400", hash_original_method = "956F409EF1EADA73108A1C4B67FC1A5C", hash_generated_method = "4263199169E232E1840850A4A45791D5")
    public void glClearDepthf(float depth) {
        addTaint(depth);
        checkThread();
        mgl.glClearDepthf(depth);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glClearDepthf(depth);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.334 -0400", hash_original_method = "30F88F59ADB4553E77F9EA15BFD9F65A", hash_generated_method = "C3846FE88BE02981C925479F259E6EE9")
    public void glClearDepthx(int depth) {
        addTaint(depth);
        checkThread();
        mgl.glClearDepthx(depth);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glClearDepthx(depth);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.335 -0400", hash_original_method = "4612FA73BEC6F3626B61AFE904FC02AE", hash_generated_method = "9B40F25A3FF33F8AED5223643849FCEA")
    public void glClearStencil(int s) {
        addTaint(s);
        checkThread();
        mgl.glClearStencil(s);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glClearStencil(s);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.335 -0400", hash_original_method = "AF39E32CE4C21187FB9A7DA0902005E0", hash_generated_method = "D9D36C697EFAE8ED7F05565F2D008CF9")
    public void glClientActiveTexture(int texture) {
        addTaint(texture);
        checkThread();
        mgl.glClientActiveTexture(texture);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glClientActiveTexture(texture);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.335 -0400", hash_original_method = "AEE61C3A8BF8DD0FE99117CF74BE0950", hash_generated_method = "61FB4BD72602AC9F887D3ED7E52F018C")
    public void glColor4f(float red, float green, float blue, float alpha) {
        addTaint(alpha);
        addTaint(blue);
        addTaint(green);
        addTaint(red);
        checkThread();
        mgl.glColor4f(red, green, blue, alpha);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glColor4f(red, green, blue, alpha);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.336 -0400", hash_original_method = "5660D8ED2ACF7645F240C96D956B261D", hash_generated_method = "39005B2D77293794A75F6B0B88A8D832")
    public void glColor4x(int red, int green, int blue, int alpha) {
        addTaint(alpha);
        addTaint(blue);
        addTaint(green);
        addTaint(red);
        checkThread();
        mgl.glColor4x(red, green, blue, alpha);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glColor4x(red, green, blue, alpha);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.337 -0400", hash_original_method = "5F003DF67ED0B35D619420E804090959", hash_generated_method = "3CC5E6156DDE88C35CCFE382615A2F80")
    public void glColorMask(boolean red, boolean green, boolean blue,
            boolean alpha) {
        addTaint(alpha);
        addTaint(blue);
        addTaint(green);
        addTaint(red);
        checkThread();
        mgl.glColorMask(red, green, blue, alpha);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glColorMask(red, green, blue, alpha);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.337 -0400", hash_original_method = "9B7D7B53255EE6EA400EDE8FB2A325F8", hash_generated_method = "67ECDAD16E7A3740998E7955B56688BB")
    public void glColorPointer(int size, int type, int stride, Buffer pointer) {
        addTaint(pointer.getTaint());
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        checkThread();
        mgl.glColorPointer(size, type, stride, pointer);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glColorPointer(size, type, stride, pointer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.338 -0400", hash_original_method = "9B7E21B2A3F16833366D8F651FD6AF1F", hash_generated_method = "9C4104816FD23408975CB9EEAC8AB535")
    public void glCompressedTexImage2D(int target, int level,
            int internalformat, int width, int height, int border,
            int imageSize, Buffer data) {
        addTaint(data.getTaint());
        addTaint(imageSize);
        addTaint(border);
        addTaint(height);
        addTaint(width);
        addTaint(internalformat);
        addTaint(level);
        addTaint(target);
        checkThread();
        mgl.glCompressedTexImage2D(target, level, internalformat, width,
                height, border, imageSize, data);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glCompressedTexImage2D(target, level, internalformat, width,
                //height, border, imageSize, data);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.339 -0400", hash_original_method = "59973B7701044713D5586B4A2955DE14", hash_generated_method = "2F045AF80AD8D81273C18EC77ED06CBC")
    public void glCompressedTexSubImage2D(int target, int level, int xoffset,
            int yoffset, int width, int height, int format, int imageSize,
            Buffer data) {
        addTaint(data.getTaint());
        addTaint(imageSize);
        addTaint(format);
        addTaint(height);
        addTaint(width);
        addTaint(yoffset);
        addTaint(xoffset);
        addTaint(level);
        addTaint(target);
        checkThread();
        mgl.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width,
                height, format, imageSize, data);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width,
                //height, format, imageSize, data);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.340 -0400", hash_original_method = "A81BB722A408E948C2F0E212A22AC850", hash_generated_method = "59590343D285AB9B6AC9E7912B3E1AC3")
    public void glCopyTexImage2D(int target, int level, int internalformat,
            int x, int y, int width, int height, int border) {
        addTaint(border);
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        addTaint(internalformat);
        addTaint(level);
        addTaint(target);
        checkThread();
        mgl.glCopyTexImage2D(target, level, internalformat, x, y, width,
                height, border);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glCopyTexImage2D(target, level, internalformat, x, y, width,
                //height, border);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.342 -0400", hash_original_method = "3EBD1E326D13C4A12705C36D947C6820", hash_generated_method = "12A23354D77516ADBC2F3DF9BD5F99A6")
    public void glCopyTexSubImage2D(int target, int level, int xoffset,
            int yoffset, int x, int y, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        addTaint(yoffset);
        addTaint(xoffset);
        addTaint(level);
        addTaint(target);
        checkThread();
        mgl.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width,
                height);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width,
                //height);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.343 -0400", hash_original_method = "D0F2F1AD364FF58ABB67DE92552937CD", hash_generated_method = "C3B67C749AB7BC495708A7F0638F8A48")
    public void glCullFace(int mode) {
        addTaint(mode);
        checkThread();
        mgl.glCullFace(mode);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glCullFace(mode);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.344 -0400", hash_original_method = "82CBBA453A1F688EEF4D2AA7AC94B18B", hash_generated_method = "D11C04938DF2E0A8276F6770C158D643")
    public void glDeleteTextures(int n, int[] textures, int offset) {
        addTaint(offset);
        addTaint(textures[0]);
        addTaint(n);
        checkThread();
        mgl.glDeleteTextures(n, textures, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glDeleteTextures(n, textures, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.345 -0400", hash_original_method = "6D712CDCC2122B66F08314266A1377A0", hash_generated_method = "09BB8C8D8ACE31AA20694A67BE018441")
    public void glDeleteTextures(int n, IntBuffer textures) {
        addTaint(textures.getTaint());
        addTaint(n);
        checkThread();
        mgl.glDeleteTextures(n, textures);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glDeleteTextures(n, textures);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.345 -0400", hash_original_method = "D43EDBE37E8BC4A7FF2598EF2F6BD41B", hash_generated_method = "17B427F66568FB3A2131001474EB5D1E")
    public void glDepthFunc(int func) {
        addTaint(func);
        checkThread();
        mgl.glDepthFunc(func);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glDepthFunc(func);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.346 -0400", hash_original_method = "220CADA7AD9601E5E0364E7615CAE052", hash_generated_method = "4679608BA02C28C02480E01A0B486AFA")
    public void glDepthMask(boolean flag) {
        addTaint(flag);
        checkThread();
        mgl.glDepthMask(flag);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glDepthMask(flag);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.346 -0400", hash_original_method = "76EFE44EC58945F9E83CB96B27E2AF97", hash_generated_method = "9940795BA60E27100D1F9B62D6D3078E")
    public void glDepthRangef(float near, float far) {
        addTaint(far);
        addTaint(near);
        checkThread();
        mgl.glDepthRangef(near, far);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glDepthRangef(near, far);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.346 -0400", hash_original_method = "196671E819F02FAE0505F22C389CCC6B", hash_generated_method = "98B6377AF2EDE78DB731D1CBB33A689B")
    public void glDepthRangex(int near, int far) {
        addTaint(far);
        addTaint(near);
        checkThread();
        mgl.glDepthRangex(near, far);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glDepthRangex(near, far);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.347 -0400", hash_original_method = "D49564350639657A355C4B877826C52F", hash_generated_method = "691B31A683E16E6F28367940F80FC748")
    public void glDisable(int cap) {
        addTaint(cap);
        checkThread();
        mgl.glDisable(cap);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glDisable(cap);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.347 -0400", hash_original_method = "855E8B051ED8CBC1203FC822FD021828", hash_generated_method = "2C87E55CD9FA59E7F886425D5E5A4C52")
    public void glDisableClientState(int array) {
        addTaint(array);
        checkThread();
        mgl.glDisableClientState(array);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glDisableClientState(array);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.347 -0400", hash_original_method = "08C4B9045050CFE9D011F50AA9E1EF83", hash_generated_method = "0DB95D63FC49798225A905724CCEB243")
    public void glDrawArrays(int mode, int first, int count) {
        addTaint(count);
        addTaint(first);
        addTaint(mode);
        checkThread();
        mgl.glDrawArrays(mode, first, count);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glDrawArrays(mode, first, count);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.348 -0400", hash_original_method = "5219ACFB98EACED3BA7FB66380EED928", hash_generated_method = "24259BB38A17FA4EE1E8AE1F94DE3A7F")
    public void glDrawElements(int mode, int count, int type, Buffer indices) {
        addTaint(indices.getTaint());
        addTaint(type);
        addTaint(count);
        addTaint(mode);
        checkThread();
        mgl.glDrawElements(mode, count, type, indices);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glDrawElements(mode, count, type, indices);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.348 -0400", hash_original_method = "1B4244ECA61C83575D9A193B42375CB7", hash_generated_method = "1D449E8D503C79D9F55C7CB9600E427D")
    public void glEnable(int cap) {
        addTaint(cap);
        checkThread();
        mgl.glEnable(cap);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glEnable(cap);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.349 -0400", hash_original_method = "5109B9FEC88700C058123D36B6279F4D", hash_generated_method = "3C7ADA71447FDEED9C1A2ECE99B76C22")
    public void glEnableClientState(int array) {
        addTaint(array);
        checkThread();
        mgl.glEnableClientState(array);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glEnableClientState(array);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.350 -0400", hash_original_method = "A061BB401278C8963A507C0E701CC550", hash_generated_method = "1532C87B2830DEBFA4639E5F93624F36")
    public void glFinish() {
        checkThread();
        mgl.glFinish();
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glFinish();
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.350 -0400", hash_original_method = "C8D2F6CDE70543B0D8B1DCBD4C1D7B10", hash_generated_method = "1477D91202E68F1C0213C0D0973545D6")
    public void glFlush() {
        checkThread();
        mgl.glFlush();
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glFlush();
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.351 -0400", hash_original_method = "ACCDF5CD9B4D681BB58F33176C3F4369", hash_generated_method = "2168765FE4B7C6B82E802B85F9AA17F2")
    public void glFogf(int pname, float param) {
        addTaint(param);
        addTaint(pname);
        checkThread();
        mgl.glFogf(pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glFogf(pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.351 -0400", hash_original_method = "98DA50343C1CBEE71394C5EDCB0908FC", hash_generated_method = "D33F01C778AA91964E5E1A9E25E83988")
    public void glFogfv(int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        checkThread();
        mgl.glFogfv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glFogfv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.351 -0400", hash_original_method = "9840BE668F66603C4837A483A27E1A9C", hash_generated_method = "213A5B3248E984B099E5484970ECA824")
    public void glFogfv(int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        checkThread();
        mgl.glFogfv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glFogfv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.352 -0400", hash_original_method = "22D599C477FAA1471774C9850AB75BCE", hash_generated_method = "828AE835287AA5454F2056D45CE1586E")
    public void glFogx(int pname, int param) {
        addTaint(param);
        addTaint(pname);
        checkThread();
        mgl.glFogx(pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glFogx(pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.352 -0400", hash_original_method = "75CDAFA7022CCA98BA21509BBAFC2206", hash_generated_method = "9A5EA922C473BDFB9127A86CD2E861E9")
    public void glFogxv(int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        checkThread();
        mgl.glFogxv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glFogxv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.352 -0400", hash_original_method = "41A43CD5C745A4594DF059A6DD43BD68", hash_generated_method = "C76C1FC607DABBC5858B3575E7B3FF32")
    public void glFogxv(int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        checkThread();
        mgl.glFogxv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glFogxv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.353 -0400", hash_original_method = "DC820EC7C8249DB3ACF589F75D2A15E5", hash_generated_method = "69779A3EB10762DC33F17DD168ED7840")
    public void glFrontFace(int mode) {
        addTaint(mode);
        checkThread();
        mgl.glFrontFace(mode);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glFrontFace(mode);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.353 -0400", hash_original_method = "BCF359F592E3040EB9E1338B9A9400AB", hash_generated_method = "81AB724A4603916949067DE74D129824")
    public void glFrustumf(float left, float right, float bottom, float top,
            float near, float far) {
        addTaint(far);
        addTaint(near);
        addTaint(top);
        addTaint(bottom);
        addTaint(right);
        addTaint(left);
        checkThread();
        mgl.glFrustumf(left, right, bottom, top, near, far);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glFrustumf(left, right, bottom, top, near, far);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.353 -0400", hash_original_method = "C90AEA8B68F6C85748E36A5E9D26C94D", hash_generated_method = "1E40F9186EFE45DA4D4EAE682865CB0C")
    public void glFrustumx(int left, int right, int bottom, int top, int near,
            int far) {
        addTaint(far);
        addTaint(near);
        addTaint(top);
        addTaint(bottom);
        addTaint(right);
        addTaint(left);
        checkThread();
        mgl.glFrustumx(left, right, bottom, top, near, far);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glFrustumx(left, right, bottom, top, near, far);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.354 -0400", hash_original_method = "66114EE308B4749DC9F3DC1D1E171D07", hash_generated_method = "3626DCA98FBBB82E5A9EAEC0912A15AD")
    public void glGenTextures(int n, int[] textures, int offset) {
        addTaint(offset);
        addTaint(textures[0]);
        addTaint(n);
        checkThread();
        mgl.glGenTextures(n, textures, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glGenTextures(n, textures, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.354 -0400", hash_original_method = "E73ABC43E2AF0160149F4B09F9D0CE55", hash_generated_method = "0620F395ED7E0AE776B7A832249DA58E")
    public void glGenTextures(int n, IntBuffer textures) {
        addTaint(textures.getTaint());
        addTaint(n);
        checkThread();
        mgl.glGenTextures(n, textures);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glGenTextures(n, textures);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.355 -0400", hash_original_method = "0A40D9CB95C5DBFB792A8941813F3C4A", hash_generated_method = "13C6ECC04BC1D5F4B80D1EC31702EEB9")
    public int glGetError() {
        checkThread();
        int result = mgl.glGetError();
        int varB4A88417B3D0170D754C647C30B7216A_830622707 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851289931 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851289931;
        // ---------- Original Method ----------
        //checkThread();
        //int result = mgl.glGetError();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.355 -0400", hash_original_method = "91019D695D6F297BDCCFA315193AEAC0", hash_generated_method = "3FAEECE03F4B56E4494B3033EC12D2D5")
    public void glGetIntegerv(int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        checkThread();
        mgl.glGetIntegerv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glGetIntegerv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.356 -0400", hash_original_method = "FEDA3B13A1922AE75A6A5C7CBE52AB77", hash_generated_method = "C878C6392B9C228B74142C7F9992FC2C")
    public void glGetIntegerv(int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        checkThread();
        mgl.glGetIntegerv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glGetIntegerv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.356 -0400", hash_original_method = "3ED6913E5E7CF46B5A28C7A9761C377B", hash_generated_method = "903CC34A4B7BE2D7E448F2C0B4C99B85")
    public String glGetString(int name) {
        addTaint(name);
        checkThread();
        String result = mgl.glGetString(name);
        checkError();
String varDC838461EE2FA0CA4C9BBB70A15456B0_526589524 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_526589524.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_526589524;
        // ---------- Original Method ----------
        //checkThread();
        //String result = mgl.glGetString(name);
        //checkError();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.356 -0400", hash_original_method = "459DC163A76E76C40FCB18D7FC6BBF01", hash_generated_method = "F3F6ED1AB338A13CF6CFED8B2F01404C")
    public void glHint(int target, int mode) {
        addTaint(mode);
        addTaint(target);
        checkThread();
        mgl.glHint(target, mode);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glHint(target, mode);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.357 -0400", hash_original_method = "8F6EF3CA789F38CA6787860843FC3C48", hash_generated_method = "3A098FFD5BF4B60E79038828442D94FC")
    public void glLightModelf(int pname, float param) {
        addTaint(param);
        addTaint(pname);
        checkThread();
        mgl.glLightModelf(pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLightModelf(pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.357 -0400", hash_original_method = "F9185B0E5B985E183AB9D5AA59F81EFD", hash_generated_method = "D797690E2855275B20FCE1D6104ED4B7")
    public void glLightModelfv(int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        checkThread();
        mgl.glLightModelfv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLightModelfv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.357 -0400", hash_original_method = "12B724FBF238EAE2A84B461E9B4BDFC7", hash_generated_method = "C2EEE87A058BF07733CF11B81970E5F6")
    public void glLightModelfv(int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        checkThread();
        mgl.glLightModelfv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLightModelfv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.357 -0400", hash_original_method = "3418E97353E36988C53668EF2CA6B536", hash_generated_method = "1FE4909085F7294725EAA5E58E6CBEEE")
    public void glLightModelx(int pname, int param) {
        addTaint(param);
        addTaint(pname);
        checkThread();
        mgl.glLightModelx(pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLightModelx(pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.357 -0400", hash_original_method = "BA5ADB335DCD06723E483DE9A02D18C2", hash_generated_method = "1E29BE87697213364B9FF7A1D79D7D74")
    public void glLightModelxv(int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        checkThread();
        mgl.glLightModelxv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLightModelxv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.358 -0400", hash_original_method = "08C6BFFDFAE733F8276951C523CA7D63", hash_generated_method = "0A5C4452B7B43A05E7299F88E1C4C1D4")
    public void glLightModelxv(int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        checkThread();
        mgl.glLightModelxv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLightModelxv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.358 -0400", hash_original_method = "A0D7AC42B086A01EB107C95E6D441CEE", hash_generated_method = "BE8BF22F0BD1C0E37CF7A5FC2C5263F5")
    public void glLightf(int light, int pname, float param) {
        addTaint(param);
        addTaint(pname);
        addTaint(light);
        checkThread();
        mgl.glLightf(light, pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLightf(light, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.358 -0400", hash_original_method = "3CA7FC894380A8E6852C9D01BE83801E", hash_generated_method = "CD1A1D3BF8D46BE2356BD68EE177F80F")
    public void glLightfv(int light, int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(light);
        checkThread();
        mgl.glLightfv(light, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLightfv(light, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.358 -0400", hash_original_method = "0362D67F764F533B389F9E750A36D8C7", hash_generated_method = "118F66E7BBE9626A28C92FC136EE3C23")
    public void glLightfv(int light, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(light);
        checkThread();
        mgl.glLightfv(light, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLightfv(light, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.358 -0400", hash_original_method = "A7B23B278A2CECFA2FEF84A7C9AAE594", hash_generated_method = "2E01CE6F1D53AE5AA19B055BE1986C0B")
    public void glLightx(int light, int pname, int param) {
        addTaint(param);
        addTaint(pname);
        addTaint(light);
        checkThread();
        mgl.glLightx(light, pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLightx(light, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.359 -0400", hash_original_method = "61878AA93971931285D7FCB85C09790D", hash_generated_method = "FC0A887628E47CEDFE3A641B08904414")
    public void glLightxv(int light, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(light);
        checkThread();
        mgl.glLightxv(light, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLightxv(light, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.359 -0400", hash_original_method = "4464111BA9498302AB8C4F9B7F00E947", hash_generated_method = "C3A39DA1E86F2EE60658F49B89FBC1C3")
    public void glLightxv(int light, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(light);
        checkThread();
        mgl.glLightxv(light, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLightxv(light, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.359 -0400", hash_original_method = "0415DE8E2BD7CF7D6C9A927E286F315A", hash_generated_method = "918EBB59F477616FDC8A77CDC1C4119A")
    public void glLineWidth(float width) {
        addTaint(width);
        checkThread();
        mgl.glLineWidth(width);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLineWidth(width);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.359 -0400", hash_original_method = "0FB71A96C3DD6C51A7173D2776651E81", hash_generated_method = "B3A243E367B69E300E181A27F898E6FB")
    public void glLineWidthx(int width) {
        addTaint(width);
        checkThread();
        mgl.glLineWidthx(width);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLineWidthx(width);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.359 -0400", hash_original_method = "4C51AE53329187A41451C9AF961C3B5F", hash_generated_method = "6560246AA3B525F343EF1FF6DBE3BEC5")
    public void glLoadIdentity() {
        checkThread();
        mgl.glLoadIdentity();
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLoadIdentity();
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.359 -0400", hash_original_method = "C5BC8E879EE7BBEA9463E1CF17609084", hash_generated_method = "805AF84444B9CAA55A76E5CFFFA6735F")
    public void glLoadMatrixf(float[] m, int offset) {
        addTaint(offset);
        addTaint(m[0]);
        checkThread();
        mgl.glLoadMatrixf(m, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLoadMatrixf(m, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.360 -0400", hash_original_method = "E3E6640B45B2CEF936614C55631DF0F3", hash_generated_method = "7F576611BE439CDB0991128C30FF816B")
    public void glLoadMatrixf(FloatBuffer m) {
        addTaint(m.getTaint());
        checkThread();
        mgl.glLoadMatrixf(m);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLoadMatrixf(m);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.360 -0400", hash_original_method = "560B8044A41FF82EFFFC667DB60BDBBA", hash_generated_method = "D713BF32F13555305DF1E0BF0AE338B4")
    public void glLoadMatrixx(int[] m, int offset) {
        addTaint(offset);
        addTaint(m[0]);
        checkThread();
        mgl.glLoadMatrixx(m, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLoadMatrixx(m, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.360 -0400", hash_original_method = "D3E2D85B1AFF096D11D2574186387DC6", hash_generated_method = "1647E82636D4AA00E77DFA99D2D48346")
    public void glLoadMatrixx(IntBuffer m) {
        addTaint(m.getTaint());
        checkThread();
        mgl.glLoadMatrixx(m);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLoadMatrixx(m);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.360 -0400", hash_original_method = "FE1B5EE86F6C265568CEB5E2464AAEC3", hash_generated_method = "15B636133335BA9FB45E939F7463EE59")
    public void glLogicOp(int opcode) {
        addTaint(opcode);
        checkThread();
        mgl.glLogicOp(opcode);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glLogicOp(opcode);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.360 -0400", hash_original_method = "BFDCEE5D0F54A4143487C674320A768D", hash_generated_method = "E4EE5621ECC72C2C97C1DDBA8E960255")
    public void glMaterialf(int face, int pname, float param) {
        addTaint(param);
        addTaint(pname);
        addTaint(face);
        checkThread();
        mgl.glMaterialf(face, pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glMaterialf(face, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.360 -0400", hash_original_method = "80457EBF2EF68E50B90CD20164F1E18B", hash_generated_method = "37782BE56266032C0133178750E69E63")
    public void glMaterialfv(int face, int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(face);
        checkThread();
        mgl.glMaterialfv(face, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glMaterialfv(face, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.361 -0400", hash_original_method = "76C9AE6AAFCE4F309222FADEE1AFEEB9", hash_generated_method = "DCAEB4D70F78F1442B39015B6919CE29")
    public void glMaterialfv(int face, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(face);
        checkThread();
        mgl.glMaterialfv(face, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glMaterialfv(face, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.362 -0400", hash_original_method = "FB951B280084574B35BB18E908DE3AD6", hash_generated_method = "2767AD3702529B5E1E51D1FBAC340C08")
    public void glMaterialx(int face, int pname, int param) {
        addTaint(param);
        addTaint(pname);
        addTaint(face);
        checkThread();
        mgl.glMaterialx(face, pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glMaterialx(face, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.362 -0400", hash_original_method = "9E62203A5BCECD57FA7A7AFEC76F5522", hash_generated_method = "C029724DEA7D1313E3B7906D9357ADB9")
    public void glMaterialxv(int face, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(face);
        checkThread();
        mgl.glMaterialxv(face, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glMaterialxv(face, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.363 -0400", hash_original_method = "7C085F925F89C74D980535EEB48F9DEB", hash_generated_method = "71A8193E22A2368B3536D4541E22FF10")
    public void glMaterialxv(int face, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(face);
        checkThread();
        mgl.glMaterialxv(face, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glMaterialxv(face, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.363 -0400", hash_original_method = "1CF0B8C2254257C506F75CED4FDC3C00", hash_generated_method = "BB92B5522E16E64A863F401B7A93CE23")
    public void glMatrixMode(int mode) {
        addTaint(mode);
        checkThread();
        mgl.glMatrixMode(mode);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glMatrixMode(mode);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.363 -0400", hash_original_method = "172DB229F31BC17320BA572703A033BB", hash_generated_method = "3C21F08C5028A95D34092E14D91B754C")
    public void glMultMatrixf(float[] m, int offset) {
        addTaint(offset);
        addTaint(m[0]);
        checkThread();
        mgl.glMultMatrixf(m, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glMultMatrixf(m, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.363 -0400", hash_original_method = "667E2CDA3CFF04177423F3E794D46A55", hash_generated_method = "DB701FE39EA0193342FF080C60698F77")
    public void glMultMatrixf(FloatBuffer m) {
        addTaint(m.getTaint());
        checkThread();
        mgl.glMultMatrixf(m);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glMultMatrixf(m);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.363 -0400", hash_original_method = "653C3DE814DCA83836652E3EF13A17D2", hash_generated_method = "D446029FFC51517285BB83593F8BE260")
    public void glMultMatrixx(int[] m, int offset) {
        addTaint(offset);
        addTaint(m[0]);
        checkThread();
        mgl.glMultMatrixx(m, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glMultMatrixx(m, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.363 -0400", hash_original_method = "C8DC7C24D8426FBEEA0E4D3C9689FD10", hash_generated_method = "4BD39DC35354F98F77AC15B1FD926D59")
    public void glMultMatrixx(IntBuffer m) {
        addTaint(m.getTaint());
        checkThread();
        mgl.glMultMatrixx(m);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glMultMatrixx(m);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.363 -0400", hash_original_method = "65ED6BD2303A4AC65910897D16FA5D82", hash_generated_method = "C4090BAF91F85E9140939954891224B9")
    public void glMultiTexCoord4f(int target,
            float s, float t, float r, float q) {
        addTaint(q);
        addTaint(r);
        addTaint(t);
        addTaint(s);
        addTaint(target);
        checkThread();
        mgl.glMultiTexCoord4f(target, s, t, r, q);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glMultiTexCoord4f(target, s, t, r, q);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.364 -0400", hash_original_method = "6B82214F4B73B0751B81013CB7B64795", hash_generated_method = "FD3B0A3175C7B568954B1151F64B80AD")
    public void glMultiTexCoord4x(int target, int s, int t, int r, int q) {
        addTaint(q);
        addTaint(r);
        addTaint(t);
        addTaint(s);
        addTaint(target);
        checkThread();
        mgl.glMultiTexCoord4x(target, s, t, r, q);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glMultiTexCoord4x(target, s, t, r, q);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.364 -0400", hash_original_method = "2691C307B7AACD4079C532C68FFDA6EE", hash_generated_method = "12207768DF3485AA58B9ADD29D71D6F9")
    public void glNormal3f(float nx, float ny, float nz) {
        addTaint(nz);
        addTaint(ny);
        addTaint(nx);
        checkThread();
        mgl.glNormal3f(nx, ny, nz);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glNormal3f(nx, ny, nz);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.364 -0400", hash_original_method = "9402DEA540A7E5C5A050889651F613F3", hash_generated_method = "A9B2C464731FD1FF0DD08432DB2B97CA")
    public void glNormal3x(int nx, int ny, int nz) {
        addTaint(nz);
        addTaint(ny);
        addTaint(nx);
        checkThread();
        mgl.glNormal3x(nx, ny, nz);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glNormal3x(nx, ny, nz);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.364 -0400", hash_original_method = "4255D3578200E45CA368B3C100DE535B", hash_generated_method = "AFCD71E1597B9BFB1729A72D8AE26C18")
    public void glNormalPointer(int type, int stride, Buffer pointer) {
        addTaint(pointer.getTaint());
        addTaint(stride);
        addTaint(type);
        checkThread();
        mgl.glNormalPointer(type, stride, pointer);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glNormalPointer(type, stride, pointer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.365 -0400", hash_original_method = "1AEC1F4A67A827D0BD54929A0CEB82F7", hash_generated_method = "331DCF61A32246768297E369CA44D419")
    public void glOrthof(float left, float right, float bottom, float top,
            float near, float far) {
        addTaint(far);
        addTaint(near);
        addTaint(top);
        addTaint(bottom);
        addTaint(right);
        addTaint(left);
        checkThread();
        mgl.glOrthof(left, right, bottom, top, near, far);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glOrthof(left, right, bottom, top, near, far);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.365 -0400", hash_original_method = "2B2D363148083F563856E56A7B382998", hash_generated_method = "162BAC1D93CAE11884E186C6D9EB8B5B")
    public void glOrthox(int left, int right, int bottom, int top, int near,
            int far) {
        addTaint(far);
        addTaint(near);
        addTaint(top);
        addTaint(bottom);
        addTaint(right);
        addTaint(left);
        checkThread();
        mgl.glOrthox(left, right, bottom, top, near, far);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glOrthox(left, right, bottom, top, near, far);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.365 -0400", hash_original_method = "6C9FD642B1A08C12F939E9A5C284A009", hash_generated_method = "A358B1608BB5954A0587716E535C63EC")
    public void glPixelStorei(int pname, int param) {
        addTaint(param);
        addTaint(pname);
        checkThread();
        mgl.glPixelStorei(pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glPixelStorei(pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.365 -0400", hash_original_method = "FB7109A99E2ED070DF3E8334E8EE5817", hash_generated_method = "DEC0D1DC76B1EF2944A6968D67B2A693")
    public void glPointSize(float size) {
        addTaint(size);
        checkThread();
        mgl.glPointSize(size);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glPointSize(size);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.365 -0400", hash_original_method = "43DF378BBA8735107A1F55C83335C8A7", hash_generated_method = "6A378287FF82C4058B476E3C971BCF80")
    public void glPointSizex(int size) {
        addTaint(size);
        checkThread();
        mgl.glPointSizex(size);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glPointSizex(size);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.365 -0400", hash_original_method = "76AD8C2921630BF911BCF1CAD50761F2", hash_generated_method = "32FBE322D53E079111A58AD259A46C04")
    public void glPolygonOffset(float factor, float units) {
        addTaint(units);
        addTaint(factor);
        checkThread();
        mgl.glPolygonOffset(factor, units);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glPolygonOffset(factor, units);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.365 -0400", hash_original_method = "AC493D1D792D1FF91760FBCFA7B83CEC", hash_generated_method = "EB79D763EF6C9BFF9C6BD06DE325EAC1")
    public void glPolygonOffsetx(int factor, int units) {
        addTaint(units);
        addTaint(factor);
        checkThread();
        mgl.glPolygonOffsetx(factor, units);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glPolygonOffsetx(factor, units);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.366 -0400", hash_original_method = "7947021D8783B966C27FD23CEA1B71F6", hash_generated_method = "35AA585DBC7B91ACEF5226EF7BA802B0")
    public void glPopMatrix() {
        checkThread();
        mgl.glPopMatrix();
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glPopMatrix();
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.366 -0400", hash_original_method = "430A6A0AAD37F21F43C25D73DABFE5A3", hash_generated_method = "4B4E54E08B18A1B53DEC719D481245EB")
    public void glPushMatrix() {
        checkThread();
        mgl.glPushMatrix();
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glPushMatrix();
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.366 -0400", hash_original_method = "2C3B39FDC42943C0A39DC2602C72A3DF", hash_generated_method = "82CF6E74E6F101D1568A1D80D463C95F")
    public void glReadPixels(int x, int y, int width, int height, int format,
            int type, Buffer pixels) {
        addTaint(pixels.getTaint());
        addTaint(type);
        addTaint(format);
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        checkThread();
        mgl.glReadPixels(x, y, width, height, format, type, pixels);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glReadPixels(x, y, width, height, format, type, pixels);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.366 -0400", hash_original_method = "0DE4332635328A12C013DB27FF2CE04A", hash_generated_method = "0695A3E0A1FE7B143CF6F802ACA0CCC4")
    public void glRotatef(float angle, float x, float y, float z) {
        addTaint(z);
        addTaint(y);
        addTaint(x);
        addTaint(angle);
        checkThread();
        mgl.glRotatef(angle, x, y, z);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glRotatef(angle, x, y, z);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.366 -0400", hash_original_method = "DECB7FEF01CE445DAFBCA1297361E8B9", hash_generated_method = "938BDFE1F5AE47A72C394A0990EC7B34")
    public void glRotatex(int angle, int x, int y, int z) {
        addTaint(z);
        addTaint(y);
        addTaint(x);
        addTaint(angle);
        checkThread();
        mgl.glRotatex(angle, x, y, z);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glRotatex(angle, x, y, z);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.366 -0400", hash_original_method = "4A774BD6565FB6890E0F8B1981F5B7DC", hash_generated_method = "6BBD9872A05903173326332203799E04")
    public void glSampleCoverage(float value, boolean invert) {
        addTaint(invert);
        addTaint(value);
        checkThread();
        mgl.glSampleCoverage(value, invert);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glSampleCoverage(value, invert);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.366 -0400", hash_original_method = "246915596BE59E740E6336B99BCFF875", hash_generated_method = "37DE49B06B40FE48B6B20B377D57A7B5")
    public void glSampleCoveragex(int value, boolean invert) {
        addTaint(invert);
        addTaint(value);
        checkThread();
        mgl.glSampleCoveragex(value, invert);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glSampleCoveragex(value, invert);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.367 -0400", hash_original_method = "F71CEF3DEC5AC68CAFB885B631BEEB80", hash_generated_method = "233FB1073B0D7F2B76A8EDEA0313A373")
    public void glScalef(float x, float y, float z) {
        addTaint(z);
        addTaint(y);
        addTaint(x);
        checkThread();
        mgl.glScalef(x, y, z);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glScalef(x, y, z);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.367 -0400", hash_original_method = "44F0B10B66A5CB68CF2FF6190231BB59", hash_generated_method = "838019FA7CD5D2ABAF4B7ACB6507D424")
    public void glScalex(int x, int y, int z) {
        addTaint(z);
        addTaint(y);
        addTaint(x);
        checkThread();
        mgl.glScalex(x, y, z);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glScalex(x, y, z);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.367 -0400", hash_original_method = "502D816BF34ADC2D7800E04F424F3B4C", hash_generated_method = "5671A83429F641D1DE6EB048295172C1")
    public void glScissor(int x, int y, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        checkThread();
        mgl.glScissor(x, y, width, height);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glScissor(x, y, width, height);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.367 -0400", hash_original_method = "E292B70498533BCBAEEFF3AED828C0E0", hash_generated_method = "3E0598414024957ABDAA3E391F836670")
    public void glShadeModel(int mode) {
        addTaint(mode);
        checkThread();
        mgl.glShadeModel(mode);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glShadeModel(mode);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.367 -0400", hash_original_method = "DA21BDF8FE923215C052A957B82B4C49", hash_generated_method = "8D26CBC8C9DEFC1094C4EAD6F55CA04E")
    public void glStencilFunc(int func, int ref, int mask) {
        addTaint(mask);
        addTaint(ref);
        addTaint(func);
        checkThread();
        mgl.glStencilFunc(func, ref, mask);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glStencilFunc(func, ref, mask);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.367 -0400", hash_original_method = "201F43CC2E0F2358208533E939AE3BB7", hash_generated_method = "818031EA9DAFA2C1A47F840B30FFA4BD")
    public void glStencilMask(int mask) {
        addTaint(mask);
        checkThread();
        mgl.glStencilMask(mask);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glStencilMask(mask);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.367 -0400", hash_original_method = "6CB0996245972EF0DE06E8CD6E13A2E5", hash_generated_method = "1A0C671ACA0F9C4F27FB41D84EDF88C2")
    public void glStencilOp(int fail, int zfail, int zpass) {
        addTaint(zpass);
        addTaint(zfail);
        addTaint(fail);
        checkThread();
        mgl.glStencilOp(fail, zfail, zpass);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glStencilOp(fail, zfail, zpass);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.368 -0400", hash_original_method = "466390C739545456EFABACA14168346A", hash_generated_method = "8F9A3CAE5F3FC9E933D5EE7C3488649A")
    public void glTexCoordPointer(int size, int type,
            int stride, Buffer pointer) {
        addTaint(pointer.getTaint());
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        checkThread();
        mgl.glTexCoordPointer(size, type, stride, pointer);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glTexCoordPointer(size, type, stride, pointer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.368 -0400", hash_original_method = "85A5615814A4D36A16A6D7AFCDDCDD6B", hash_generated_method = "AB544842B84895E8FF913B00C3DE1346")
    public void glTexEnvf(int target, int pname, float param) {
        addTaint(param);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl.glTexEnvf(target, pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glTexEnvf(target, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.368 -0400", hash_original_method = "26EAA56F3A6D446A83B58D5406D2B31F", hash_generated_method = "3ADAC246334D40B816DD4490C46AE8A3")
    public void glTexEnvfv(int target, int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl.glTexEnvfv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glTexEnvfv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.368 -0400", hash_original_method = "83CF5E88B0AC5BA7DCC0935F6C00DC4B", hash_generated_method = "4053219F5471F2EAC5B803EF2680D91E")
    public void glTexEnvfv(int target, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl.glTexEnvfv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glTexEnvfv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.368 -0400", hash_original_method = "51E707441D7EBBDAB24B58399FC8FDE5", hash_generated_method = "4F08C40A19C5736CA9A2580F8586939E")
    public void glTexEnvx(int target, int pname, int param) {
        addTaint(param);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl.glTexEnvx(target, pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glTexEnvx(target, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.369 -0400", hash_original_method = "5FD058160DAD78F5FB12F311FAD4CB3B", hash_generated_method = "FEFE22EBF5F66BD20D667CE1403C7D27")
    public void glTexEnvxv(int target, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl.glTexEnvxv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glTexEnvxv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.369 -0400", hash_original_method = "822E68C4BE5661C6D22E44892B0C1419", hash_generated_method = "D7B4EE12D2CCAD6251EA3796F75D11E8")
    public void glTexEnvxv(int target, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl.glTexEnvxv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glTexEnvxv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.369 -0400", hash_original_method = "7D871FBA416A6667CD6F62C9D0FA5A27", hash_generated_method = "A77070B23FFD9ECD2C2428B1A169A3A9")
    public void glTexImage2D(int target, int level, int internalformat,
            int width, int height, int border, int format, int type,
            Buffer pixels) {
        addTaint(pixels.getTaint());
        addTaint(type);
        addTaint(format);
        addTaint(border);
        addTaint(height);
        addTaint(width);
        addTaint(internalformat);
        addTaint(level);
        addTaint(target);
        checkThread();
        mgl.glTexImage2D(target, level, internalformat, width, height, border,
                format, type, pixels);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glTexImage2D(target, level, internalformat, width, height, border,
                //format, type, pixels);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.369 -0400", hash_original_method = "72BEF0B5BA47065076DB8DB16269213F", hash_generated_method = "99041A5269B129968FC654AEC595B7AC")
    public void glTexParameterf(int target, int pname, float param) {
        addTaint(param);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl.glTexParameterf(target, pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glTexParameterf(target, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.369 -0400", hash_original_method = "19F7443230B95831EF68E715BF3E37B4", hash_generated_method = "890CB4D1DDB14ED9852364F5CB8BFE4E")
    public void glTexParameterx(int target, int pname, int param) {
        addTaint(param);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl.glTexParameterx(target, pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glTexParameterx(target, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.369 -0400", hash_original_method = "59D5A740E5B6ED728058DBF669141DA6", hash_generated_method = "BF9C27435333ADB0CD75E1B647E13056")
    public void glTexParameteriv(int target, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glTexParameteriv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glTexParameteriv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.369 -0400", hash_original_method = "218137A131A9C4185C80244BAFFDAB2B", hash_generated_method = "1DB9936F1BCFDEC2C04BFC5F727B7F40")
    public void glTexParameteriv(int target, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glTexParameteriv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glTexParameteriv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.370 -0400", hash_original_method = "D3705A7A4690058997D3E70B15B4B35A", hash_generated_method = "8103EC36952BE9E09364F63B261F25B3")
    public void glTexSubImage2D(int target, int level, int xoffset,
            int yoffset, int width, int height, int format, int type,
            Buffer pixels) {
        addTaint(pixels.getTaint());
        addTaint(type);
        addTaint(format);
        addTaint(height);
        addTaint(width);
        addTaint(yoffset);
        addTaint(xoffset);
        addTaint(level);
        addTaint(target);
        checkThread();
        mgl.glTexSubImage2D(target, level, xoffset, yoffset, width, height,
                format, type, pixels);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glTexSubImage2D(target, level, xoffset, yoffset, width, height,
                //format, type, pixels);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.370 -0400", hash_original_method = "CE115E1F6B75AADFF6E36000C2E380B4", hash_generated_method = "75DB77959406E6AC0C44D05229D64A7C")
    public void glTranslatef(float x, float y, float z) {
        addTaint(z);
        addTaint(y);
        addTaint(x);
        checkThread();
        mgl.glTranslatef(x, y, z);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glTranslatef(x, y, z);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.370 -0400", hash_original_method = "D192DE8E7154BF31DD7446833CC358B1", hash_generated_method = "137AFB88776FE1AFF801970694345E98")
    public void glTranslatex(int x, int y, int z) {
        addTaint(z);
        addTaint(y);
        addTaint(x);
        checkThread();
        mgl.glTranslatex(x, y, z);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glTranslatex(x, y, z);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.370 -0400", hash_original_method = "B863B365542A05B8E086855775B1B25D", hash_generated_method = "2EDAD4EFFCC02E31EBDEBF2CA13029E2")
    public void glVertexPointer(int size, int type,
            int stride, Buffer pointer) {
        addTaint(pointer.getTaint());
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        checkThread();
        mgl.glVertexPointer(size, type, stride, pointer);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glVertexPointer(size, type, stride, pointer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.370 -0400", hash_original_method = "9EC0F2F771D5D0C8A7E09F5D4B11D824", hash_generated_method = "A548E8C7B98818B6771BA39592D2C77D")
    public void glViewport(int x, int y, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        checkThread();
        mgl.glViewport(x, y, width, height);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl.glViewport(x, y, width, height);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.370 -0400", hash_original_method = "7047810A221DD3F1EDC6570DC2A1FDF5", hash_generated_method = "4D4502B5CCF643F55803AAA2FB44E187")
    public void glClipPlanef(int plane, float[] equation, int offset) {
        addTaint(offset);
        addTaint(equation[0]);
        addTaint(plane);
        checkThread();
        mgl11.glClipPlanef(plane, equation, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glClipPlanef(plane, equation, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.371 -0400", hash_original_method = "4524EF74C6AE5BF28D393D537A698406", hash_generated_method = "9349D00F6CD51BF207A18B08C179FBF7")
    public void glClipPlanef(int plane, FloatBuffer equation) {
        addTaint(equation.getTaint());
        addTaint(plane);
        checkThread();
        mgl11.glClipPlanef(plane, equation);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glClipPlanef(plane, equation);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.371 -0400", hash_original_method = "8D3ED414E4DAA8FB74906F3B8E9D3DFF", hash_generated_method = "DE1A80BE182FA29018A9089F2D0544BB")
    public void glClipPlanex(int plane, int[] equation, int offset) {
        addTaint(offset);
        addTaint(equation[0]);
        addTaint(plane);
        checkThread();
        mgl11.glClipPlanex(plane, equation, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glClipPlanex(plane, equation, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.371 -0400", hash_original_method = "5278C31B3053C5B981A839212DD10C5C", hash_generated_method = "E0A94D2A39440628356E84DDFFA90516")
    public void glClipPlanex(int plane, IntBuffer equation) {
        addTaint(equation.getTaint());
        addTaint(plane);
        checkThread();
        mgl11.glClipPlanex(plane, equation);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glClipPlanex(plane, equation);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.371 -0400", hash_original_method = "0FCEDC37EC1AEF7D65A007BA69038B27", hash_generated_method = "CB50E8CDA40EAB9D3D21C9CADC34F4BC")
    public void glDrawTexfOES(float x, float y, float z,
        float width, float height) {
        addTaint(height);
        addTaint(width);
        addTaint(z);
        addTaint(y);
        addTaint(x);
        checkThread();
        mgl11Ext.glDrawTexfOES(x, y, z, width, height);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glDrawTexfOES(x, y, z, width, height);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.371 -0400", hash_original_method = "88145A802188502D93AE08FA1BB52C46", hash_generated_method = "CCA7033EB87551DA710E3FE68F64BC56")
    public void glDrawTexfvOES(float[] coords, int offset) {
        addTaint(offset);
        addTaint(coords[0]);
        checkThread();
        mgl11Ext.glDrawTexfvOES(coords, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glDrawTexfvOES(coords, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.371 -0400", hash_original_method = "24FCA1E1034171BCC0A7E176807F466E", hash_generated_method = "3D414EDD739AC75C3D6B45941C5069D7")
    public void glDrawTexfvOES(FloatBuffer coords) {
        addTaint(coords.getTaint());
        checkThread();
        mgl11Ext.glDrawTexfvOES(coords);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glDrawTexfvOES(coords);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.371 -0400", hash_original_method = "5F94F2C6B5C87607C9A7CD37C21BA2F0", hash_generated_method = "72E7431967EF2B3A26557A26115A80CA")
    public void glDrawTexiOES(int x, int y, int z, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(z);
        addTaint(y);
        addTaint(x);
        checkThread();
        mgl11Ext.glDrawTexiOES(x, y, z, width, height);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glDrawTexiOES(x, y, z, width, height);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.372 -0400", hash_original_method = "8A10A1B96805BEEB05694AEBC33907E6", hash_generated_method = "28D483B4A9CB9B65F4A7E931E8AB5FF3")
    public void glDrawTexivOES(int[] coords, int offset) {
        addTaint(offset);
        addTaint(coords[0]);
        checkThread();
        mgl11Ext.glDrawTexivOES(coords, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glDrawTexivOES(coords, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.372 -0400", hash_original_method = "692A90360D55EB3411EA98CDB82C7BDE", hash_generated_method = "E34191CD921365261CC0BEA985DB1C5B")
    public void glDrawTexivOES(IntBuffer coords) {
        addTaint(coords.getTaint());
        checkThread();
        mgl11Ext.glDrawTexivOES(coords);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glDrawTexivOES(coords);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.372 -0400", hash_original_method = "81702D56D238A1680BD3BDF0524433B0", hash_generated_method = "2154F6A4B67D41031C356A541AFBAEDD")
    public void glDrawTexsOES(short x, short y, short z,
        short width, short height) {
        addTaint(height);
        addTaint(width);
        addTaint(z);
        addTaint(y);
        addTaint(x);
        checkThread();
        mgl11Ext.glDrawTexsOES(x, y, z, width, height);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glDrawTexsOES(x, y, z, width, height);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.372 -0400", hash_original_method = "6AB85DDA6CE0427AE2EDBBC2E24275B1", hash_generated_method = "D0E989697DB4E2275E927FBC92467619")
    public void glDrawTexsvOES(short[] coords, int offset) {
        addTaint(offset);
        addTaint(coords[0]);
        checkThread();
        mgl11Ext.glDrawTexsvOES(coords, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glDrawTexsvOES(coords, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.372 -0400", hash_original_method = "7AD520D568193A12267AC44FDFDD1097", hash_generated_method = "162A69B164C6438D042B2A7A10547B81")
    public void glDrawTexsvOES(ShortBuffer coords) {
        addTaint(coords.getTaint());
        checkThread();
        mgl11Ext.glDrawTexsvOES(coords);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glDrawTexsvOES(coords);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.372 -0400", hash_original_method = "63B91529A6A9796DA0A30CFFD7F06ED7", hash_generated_method = "15251E03A9B6A79918E3B38664030887")
    public void glDrawTexxOES(int x, int y, int z, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(z);
        addTaint(y);
        addTaint(x);
        checkThread();
        mgl11Ext.glDrawTexxOES(x, y, z, width, height);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glDrawTexxOES(x, y, z, width, height);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.373 -0400", hash_original_method = "4B648AB196C3FA25858B7D3BA7B5F10D", hash_generated_method = "6A10325FB05DCC2F51D4538A41B8F845")
    public void glDrawTexxvOES(int[] coords, int offset) {
        addTaint(offset);
        addTaint(coords[0]);
        checkThread();
        mgl11Ext.glDrawTexxvOES(coords, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glDrawTexxvOES(coords, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.373 -0400", hash_original_method = "6943490AF23DA91633DA0E4D5D703CCA", hash_generated_method = "268D36A269A1A01E34A6BF9EBB228D08")
    public void glDrawTexxvOES(IntBuffer coords) {
        addTaint(coords.getTaint());
        checkThread();
        mgl11Ext.glDrawTexxvOES(coords);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glDrawTexxvOES(coords);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.373 -0400", hash_original_method = "8AE1CE2B779B18C9E619BD00E9C57865", hash_generated_method = "8BBA30D243982AD24A35468782B11880")
    public int glQueryMatrixxOES(int[] mantissa, int mantissaOffset,
        int[] exponent, int exponentOffset) {
        addTaint(exponentOffset);
        addTaint(exponent[0]);
        addTaint(mantissaOffset);
        addTaint(mantissa[0]);
        checkThread();
        int valid = mgl10Ext.glQueryMatrixxOES(mantissa, mantissaOffset,
            exponent, exponentOffset);
        checkError();
        int var9F7D0EE82B6A6CA7DDEAE841F3253059_38782831 = (valid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814447480 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814447480;
        // ---------- Original Method ----------
        //checkThread();
        //int valid = mgl10Ext.glQueryMatrixxOES(mantissa, mantissaOffset,
            //exponent, exponentOffset);
        //checkError();
        //return valid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.373 -0400", hash_original_method = "4D5D369DF37A327F0B45E7706736984A", hash_generated_method = "F7F98E512D0719363A0A98B7EB57712A")
    public int glQueryMatrixxOES(IntBuffer mantissa, IntBuffer exponent) {
        addTaint(exponent.getTaint());
        addTaint(mantissa.getTaint());
        checkThread();
        int valid = mgl10Ext.glQueryMatrixxOES(mantissa, exponent);
        checkError();
        int var9F7D0EE82B6A6CA7DDEAE841F3253059_163393046 = (valid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706307948 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706307948;
        // ---------- Original Method ----------
        //checkThread();
        //int valid = mgl10Ext.glQueryMatrixxOES(mantissa, exponent);
        //checkError();
        //return valid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.373 -0400", hash_original_method = "655070119F623C1CB33E2355B4562236", hash_generated_method = "6C7A517FC8AC1D86EF98ACE9BEF0276D")
    public void glBindBuffer(int target, int buffer) {
        addTaint(buffer);
        addTaint(target);
        checkThread();
        mgl11.glBindBuffer(target, buffer);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glBindBuffer(target, buffer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.374 -0400", hash_original_method = "D36E8EE52297961B1E268F2D810FCBB7", hash_generated_method = "786C7474959F37D4CFEF19A265ED9299")
    public void glBufferData(int target, int size, Buffer data, int usage) {
        addTaint(usage);
        addTaint(data.getTaint());
        addTaint(size);
        addTaint(target);
        checkThread();
        mgl11.glBufferData(target, size, data, usage);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glBufferData(target, size, data, usage);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.374 -0400", hash_original_method = "58A3FBFC2B440B086D5A56642E743847", hash_generated_method = "C6D5B667BD4FAB46037E4BF7FEF0C40B")
    public void glBufferSubData(int target, int offset, int size, Buffer data) {
        addTaint(data.getTaint());
        addTaint(size);
        addTaint(offset);
        addTaint(target);
        checkThread();
        mgl11.glBufferSubData(target, offset, size, data);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glBufferSubData(target, offset, size, data);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.374 -0400", hash_original_method = "444437A0ACFCE50E5E28C65BA40F754E", hash_generated_method = "7C01EB212F5930FCA26CA9720B89936C")
    public void glColor4ub(byte red, byte green, byte blue, byte alpha) {
        addTaint(alpha);
        addTaint(blue);
        addTaint(green);
        addTaint(red);
        checkThread();
        mgl11.glColor4ub(red, green, blue, alpha);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glColor4ub(red, green, blue, alpha);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.374 -0400", hash_original_method = "CB6938F783FBA872024BD63657012E6E", hash_generated_method = "A687FA0ADA9F6A10671C49DA07F9C8F7")
    public void glColorPointer(int size, int type, int stride, int offset) {
        addTaint(offset);
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        checkThread();
        mgl11.glColorPointer(size, type, stride, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glColorPointer(size, type, stride, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.374 -0400", hash_original_method = "A81597F844D12564DAC88D479B6FC826", hash_generated_method = "E43393E87FACFEA3FB50366239176942")
    public void glDeleteBuffers(int n, int[] buffers, int offset) {
        addTaint(offset);
        addTaint(buffers[0]);
        addTaint(n);
        checkThread();
        mgl11.glDeleteBuffers(n, buffers, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glDeleteBuffers(n, buffers, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.375 -0400", hash_original_method = "5B6D4EA57BAFDD81C8853EA1ED7813DC", hash_generated_method = "8DB174E836FBE4F2F824B96298A55DFD")
    public void glDeleteBuffers(int n, IntBuffer buffers) {
        addTaint(buffers.getTaint());
        addTaint(n);
        checkThread();
        mgl11.glDeleteBuffers(n, buffers);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glDeleteBuffers(n, buffers);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.375 -0400", hash_original_method = "E6ACEB3407FC5A9C7E889C8CF725F0A3", hash_generated_method = "FA1348A13F156658E14E6A76F9E5949D")
    public void glDrawElements(int mode, int count, int type, int offset) {
        addTaint(offset);
        addTaint(type);
        addTaint(count);
        addTaint(mode);
        checkThread();
        mgl11.glDrawElements(mode, count, type, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glDrawElements(mode, count, type, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.375 -0400", hash_original_method = "CFA5150AABB1A42C94FC86D6C76B8BD5", hash_generated_method = "6664081EF8FE1B8F6EA3F1BBD19E2EB5")
    public void glGenBuffers(int n, int[] buffers, int offset) {
        addTaint(offset);
        addTaint(buffers[0]);
        addTaint(n);
        checkThread();
        mgl11.glGenBuffers(n, buffers, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGenBuffers(n, buffers, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.376 -0400", hash_original_method = "6391775B807A9608A5EE1CA6E7D21669", hash_generated_method = "C67E00A46C26058764C28B986FD24D3B")
    public void glGenBuffers(int n, IntBuffer buffers) {
        addTaint(buffers.getTaint());
        addTaint(n);
        checkThread();
        mgl11.glGenBuffers(n, buffers);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGenBuffers(n, buffers);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.376 -0400", hash_original_method = "F75450D7C7444C435F8741AAB8FA2103", hash_generated_method = "AB50CDDE275BE956DF3777B4297447AF")
    public void glGetBooleanv(int pname, boolean[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        checkThread();
        mgl11.glGetBooleanv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetBooleanv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.376 -0400", hash_original_method = "269C7585F15177DC6B6DBD7C8BA80391", hash_generated_method = "15C7602E2FB64B29114CC7D918729536")
    public void glGetBooleanv(int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        checkThread();
        mgl11.glGetBooleanv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetBooleanv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.376 -0400", hash_original_method = "910DEB37CA8500A9D8C280513FDB7343", hash_generated_method = "71663E443CD920F2E775BB35AEC8DE8E")
    public void glGetBufferParameteriv(int target, int pname, int[] params,
            int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glGetBufferParameteriv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetBufferParameteriv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.377 -0400", hash_original_method = "0413FB8D485131E48F4FCE9E1B338F85", hash_generated_method = "D4D2DB1B347615172E76D38AB28C13BB")
    public void glGetBufferParameteriv(int target, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glGetBufferParameteriv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetBufferParameteriv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.377 -0400", hash_original_method = "C094174C215471B93DD0CF5F6242F0A2", hash_generated_method = "4B95F5969B413650EFDEC809E711D8F1")
    public void glGetClipPlanef(int pname, float[] eqn, int offset) {
        addTaint(offset);
        addTaint(eqn[0]);
        addTaint(pname);
        checkThread();
        mgl11.glGetClipPlanef(pname, eqn, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetClipPlanef(pname, eqn, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.377 -0400", hash_original_method = "A30ACCDBD8937013825066210B40F476", hash_generated_method = "97DF8771BEBF452C7C969D4267639377")
    public void glGetClipPlanef(int pname, FloatBuffer eqn) {
        addTaint(eqn.getTaint());
        addTaint(pname);
        checkThread();
        mgl11.glGetClipPlanef(pname, eqn);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetClipPlanef(pname, eqn);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.377 -0400", hash_original_method = "961158B6D0A4CA86A20FEA7E67BE9733", hash_generated_method = "CD3D5292653F7581206016DF00AADDAF")
    public void glGetClipPlanex(int pname, int[] eqn, int offset) {
        addTaint(offset);
        addTaint(eqn[0]);
        addTaint(pname);
        checkThread();
        mgl11.glGetClipPlanex(pname, eqn, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetClipPlanex(pname, eqn, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.377 -0400", hash_original_method = "F062138EA2A7B6002FF45099E6DE7314", hash_generated_method = "74B263579124F30D14CF9457BE28CE92")
    public void glGetClipPlanex(int pname, IntBuffer eqn) {
        addTaint(eqn.getTaint());
        addTaint(pname);
        checkThread();
        mgl11.glGetClipPlanex(pname, eqn);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetClipPlanex(pname, eqn);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.378 -0400", hash_original_method = "5AAD7A7380F58498F1CE56AF8503572A", hash_generated_method = "6E85934DF94B46912DE99BB45FDFDB45")
    public void glGetFixedv(int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        checkThread();
        mgl11.glGetFixedv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetFixedv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.378 -0400", hash_original_method = "EAF527388692D1D3857E4D28DC60B040", hash_generated_method = "3C5D6A025BB6687F25E7E9123D4BF70A")
    public void glGetFixedv(int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        checkThread();
        mgl11.glGetFixedv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetFixedv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.378 -0400", hash_original_method = "E963084C6F824AF23632AAB944CC40E4", hash_generated_method = "7DFC9050F2A177A20459FD1EE6E710BA")
    public void glGetFloatv(int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        checkThread();
        mgl11.glGetFloatv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetFloatv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.378 -0400", hash_original_method = "A4E0C02BD0ADA35BE03B7090CFF2E117", hash_generated_method = "E8402ADBCFF5D6EFB86DD5A914991C47")
    public void glGetFloatv(int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        checkThread();
        mgl11.glGetFloatv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetFloatv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.378 -0400", hash_original_method = "E73442DF8AD59B26FE8FDF5B909DA2B0", hash_generated_method = "063157B2CCDF403E97B80A22DF8D6912")
    public void glGetLightfv(int light, int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(light);
        checkThread();
        mgl11.glGetLightfv(light, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetLightfv(light, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.378 -0400", hash_original_method = "B540E2EB59953E516E97ED929386FC6C", hash_generated_method = "458D8FBE0D2152ADF7E597EA353DCFBF")
    public void glGetLightfv(int light, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(light);
        checkThread();
        mgl11.glGetLightfv(light, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetLightfv(light, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.379 -0400", hash_original_method = "DEFD88ABBAB6979F4E14C39CC43D54FC", hash_generated_method = "E915F56F3F04986A3E4751083F8FCA56")
    public void glGetLightxv(int light, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(light);
        checkThread();
        mgl11.glGetLightxv(light, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetLightxv(light, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.379 -0400", hash_original_method = "2C612A2C9FF2B9D7139609339424A0E6", hash_generated_method = "B7E59A5407E96A256AC3BCA17528FCE2")
    public void glGetLightxv(int light, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(light);
        checkThread();
        mgl11.glGetLightxv(light, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetLightxv(light, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.379 -0400", hash_original_method = "09E308054ADE4570647C8752CB0B7DE3", hash_generated_method = "A290F67AA55CC2A8BA35EEB63BA8780D")
    public void glGetMaterialfv(int face, int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(face);
        checkThread();
        mgl11.glGetMaterialfv(face, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetMaterialfv(face, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.379 -0400", hash_original_method = "7D344DA7BB959DFC8D2CADAEFF2C24D5", hash_generated_method = "3409FE92DD66C38C9AAD39DBD3AF5734")
    public void glGetMaterialfv(int face, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(face);
        checkThread();
        mgl11.glGetMaterialfv(face, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetMaterialfv(face, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.380 -0400", hash_original_method = "38952810A3204DAE11E450311428E7CD", hash_generated_method = "F68E81223CE7E2F8881F787F94F26485")
    public void glGetMaterialxv(int face, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(face);
        checkThread();
        mgl11.glGetMaterialxv(face, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetMaterialxv(face, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.380 -0400", hash_original_method = "C85F75B97C1CAF1FC7167FD807234ACC", hash_generated_method = "45EA48A16CA6BB51B42F335B55D1EBC6")
    public void glGetMaterialxv(int face, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(face);
        checkThread();
        mgl11.glGetMaterialxv(face, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetMaterialxv(face, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.380 -0400", hash_original_method = "2C716D0962CE814311685802FF3D9113", hash_generated_method = "52931796CBB444AD4B0C9515362383D4")
    public void glGetPointerv(int pname, Buffer[] params) {
        addTaint(params[0].getTaint());
        addTaint(pname);
        checkThread();
        mgl11.glGetPointerv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetPointerv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.381 -0400", hash_original_method = "5C4DC6AE2C0AF0C9C2AAF2AE14A19245", hash_generated_method = "E16B47BEBCA543667EF9F64F1235B726")
    public void glGetTexEnviv(int env, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(env);
        checkThread();
        mgl11.glGetTexEnviv(env, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetTexEnviv(env, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.381 -0400", hash_original_method = "CE618952A7CD6015F90CBE0B3A3D5775", hash_generated_method = "6D7E2CB746984BA8BB94F5CC27D36CD5")
    public void glGetTexEnviv(int env, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(env);
        checkThread();
        mgl11.glGetTexEnviv(env, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetTexEnviv(env, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.381 -0400", hash_original_method = "5EB1D10495C07594E94D7155CB64711C", hash_generated_method = "5B7E963C8C6B9ED324E54B746CCD52E3")
    public void glGetTexEnvxv(int env, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(env);
        checkThread();
        mgl11.glGetTexEnvxv(env, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetTexEnvxv(env, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.381 -0400", hash_original_method = "2D1ECB0AA025367D67A05520FD32DE51", hash_generated_method = "EF48E98B4F299C82DFEA6B8F2E401BD8")
    public void glGetTexEnvxv(int env, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(env);
        checkThread();
        mgl11.glGetTexEnvxv(env, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetTexEnvxv(env, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.382 -0400", hash_original_method = "027C00959FDA9DB58C8D3C5BA07060CB", hash_generated_method = "B4A33F5D55721FD0D134E81979FBF4A5")
    public void glGetTexParameterfv(int target, int pname, float[] params,
            int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glGetTexParameterfv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetTexParameterfv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.382 -0400", hash_original_method = "73FFDCC5F1C4D8C1BED3A96EEAFAFB59", hash_generated_method = "5BE4BD522A43B91B3F656CED198679EC")
    public void glGetTexParameterfv(int target, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glGetTexParameterfv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetTexParameterfv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.382 -0400", hash_original_method = "7A9D7CFB854F29053AE4903A6E7333EC", hash_generated_method = "E4C489F8DD9574C54F4B1A0459CE0290")
    public void glGetTexParameteriv(int target, int pname, int[] params,
            int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glGetTexParameteriv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetTexParameteriv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.385 -0400", hash_original_method = "5F58354BF13AA74BA47342C6E757B985", hash_generated_method = "C9220CFA721322D74A32BDF223590584")
    public void glGetTexParameteriv(int target, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glGetTexParameteriv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetTexParameteriv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.385 -0400", hash_original_method = "CDD87A4F0770CA20A840C05B71F4728C", hash_generated_method = "4024BF48A14D16F0834B232CC29D1EA1")
    public void glGetTexParameterxv(int target, int pname, int[] params,
            int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glGetTexParameterxv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetTexParameterxv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.386 -0400", hash_original_method = "AEB326BB00CC7C450624FECAB4627E59", hash_generated_method = "1C77A8A4C75E8F201BF0BA1DEDD26B53")
    public void glGetTexParameterxv(int target, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glGetTexParameterxv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glGetTexParameterxv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.386 -0400", hash_original_method = "B897EB6A1DF48FCC02DEF57402E4DC57", hash_generated_method = "2E1BF5CB6D033F0976B916F2DABAA251")
    public boolean glIsBuffer(int buffer) {
        addTaint(buffer);
        checkThread();
        boolean valid = mgl11.glIsBuffer(buffer);
        checkError();
        boolean var9F7D0EE82B6A6CA7DDEAE841F3253059_107861691 = (valid);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1531291949 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1531291949;
        // ---------- Original Method ----------
        //checkThread();
        //boolean valid = mgl11.glIsBuffer(buffer);
        //checkError();
        //return valid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.386 -0400", hash_original_method = "717E55FCFC9E5B49869B76793AE6BE5B", hash_generated_method = "349FAA8712B158C26B3A24C23A3A4B06")
    public boolean glIsEnabled(int cap) {
        addTaint(cap);
        checkThread();
        boolean valid = mgl11.glIsEnabled(cap);
        checkError();
        boolean var9F7D0EE82B6A6CA7DDEAE841F3253059_1639607559 = (valid);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_339627830 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_339627830;
        // ---------- Original Method ----------
        //checkThread();
        //boolean valid = mgl11.glIsEnabled(cap);
        //checkError();
        //return valid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.387 -0400", hash_original_method = "8D9C6A2F92FBF209F9ABDD2C63C90623", hash_generated_method = "B9840DDD63AB6D5BA6E5DCE6CECACED0")
    public boolean glIsTexture(int texture) {
        addTaint(texture);
        checkThread();
        boolean valid = mgl11.glIsTexture(texture);
        checkError();
        boolean var9F7D0EE82B6A6CA7DDEAE841F3253059_29806056 = (valid);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1161865455 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1161865455;
        // ---------- Original Method ----------
        //checkThread();
        //boolean valid = mgl11.glIsTexture(texture);
        //checkError();
        //return valid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.387 -0400", hash_original_method = "AFA751EB12E4E9AA30C2773EF87587EF", hash_generated_method = "2B940CC4D85E3193FA98A86BEE614330")
    public void glNormalPointer(int type, int stride, int offset) {
        addTaint(offset);
        addTaint(stride);
        addTaint(type);
        checkThread();
        mgl11.glNormalPointer(type, stride, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glNormalPointer(type, stride, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.387 -0400", hash_original_method = "30B61B02BB542D0246C7639871EBCF8D", hash_generated_method = "F6094AA69BFAF75572EBEA7235065307")
    public void glPointParameterf(int pname, float param) {
        addTaint(param);
        addTaint(pname);
        checkThread();
        mgl11.glPointParameterf(pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glPointParameterf(pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.392 -0400", hash_original_method = "46F01779CDDEA5B40F098409E8EE25B1", hash_generated_method = "B5B3559025D561A63F7375DC1FE942AE")
    public void glPointParameterfv(int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        checkThread();
        mgl11.glPointParameterfv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glPointParameterfv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.392 -0400", hash_original_method = "E374C596C6B6AF7806CFCE55C4A9AD1D", hash_generated_method = "C77F51652D5570321E8AACC4D22BBE4E")
    public void glPointParameterfv(int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        checkThread();
        mgl11.glPointParameterfv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glPointParameterfv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.392 -0400", hash_original_method = "C503F4E840447B56F9AB279DF9CDE641", hash_generated_method = "FAFA8AC66B76016F7DD9ECAA29F3A295")
    public void glPointParameterx(int pname, int param) {
        addTaint(param);
        addTaint(pname);
        checkThread();
        mgl11.glPointParameterx(pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glPointParameterx(pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.392 -0400", hash_original_method = "D2F91263CE5DDFA5392566A03FA7D2B0", hash_generated_method = "47E3BE130807E4EE3CD22BBC99859F73")
    public void glPointParameterxv(int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        checkThread();
        mgl11.glPointParameterxv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glPointParameterxv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.393 -0400", hash_original_method = "5B0992AA9007415E9AC6D59FF588E4CB", hash_generated_method = "E489B1B1B7DA98BAAF4E23C6E57D02F1")
    public void glPointParameterxv(int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        checkThread();
        mgl11.glPointParameterxv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glPointParameterxv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.393 -0400", hash_original_method = "902E5A7C5C294084D5E3D8122C4AEEC8", hash_generated_method = "DD73AED7E27214B66109F9289F9AA9EF")
    public void glPointSizePointerOES(int type, int stride, Buffer pointer) {
        addTaint(pointer.getTaint());
        addTaint(stride);
        addTaint(type);
        checkThread();
        mgl11.glPointSizePointerOES(type, stride, pointer);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glPointSizePointerOES(type, stride, pointer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.401 -0400", hash_original_method = "604B2E9120D0E3EC03CBDFCF47B14ABC", hash_generated_method = "4ABA5F183CFC66679D5A4B489CF234E3")
    public void glTexCoordPointer(int size, int type, int stride, int offset) {
        addTaint(offset);
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        checkThread();
        mgl11.glTexCoordPointer(size, type, stride, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glTexCoordPointer(size, type, stride, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.401 -0400", hash_original_method = "A91D5E5F18F2244824FF05383824F9A5", hash_generated_method = "24449618859366661D1691645D626F68")
    public void glTexEnvi(int target, int pname, int param) {
        addTaint(param);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glTexEnvi(target, pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glTexEnvi(target, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.402 -0400", hash_original_method = "C37711363D7C727366CC86C0DD45CDDB", hash_generated_method = "E300D7B33CBECBF1BC400A9E8840F083")
    public void glTexEnviv(int target, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glTexEnviv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glTexEnviv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.402 -0400", hash_original_method = "E301C7591BA95AE0CEB4758A9F1FD0D1", hash_generated_method = "5EAB6612474B8AA1B93A338A55AA3138")
    public void glTexEnviv(int target, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glTexEnviv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glTexEnviv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.402 -0400", hash_original_method = "67E5BFE5167DFA5DACAF9CBF1882013B", hash_generated_method = "56443E8CBF05163D8073B1E7117C7075")
    public void glTexParameterfv(int target, int pname, float[] params,
            int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glTexParameterfv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glTexParameterfv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.402 -0400", hash_original_method = "EC2662F7DD5D640D328EC7537D420284", hash_generated_method = "68DD202C58B30B2897C57F41DE047145")
    public void glTexParameterfv(int target, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glTexParameterfv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glTexParameterfv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.402 -0400", hash_original_method = "D3C0A5F0BBC7AE9B1CCB8C74B1764F15", hash_generated_method = "76E67816388B58474274072327B61957")
    public void glTexParameteri(int target, int pname, int param) {
        addTaint(param);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glTexParameteri(target, pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glTexParameteri(target, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.403 -0400", hash_original_method = "EE4F0C55DF4DFD1C3861D9BC1ADDA63E", hash_generated_method = "E1BDD562A692F8AA155BEFCF48951D99")
    public void glTexParameterxv(int target, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glTexParameterxv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glTexParameterxv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.403 -0400", hash_original_method = "5B80AEAE46FF3D8CD31CD4B1071661B7", hash_generated_method = "241AD0737C897D93BF2C29282B0651BB")
    public void glTexParameterxv(int target, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11.glTexParameterxv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glTexParameterxv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.403 -0400", hash_original_method = "512C10702F6071A16B75D9CF2D1086A6", hash_generated_method = "2022A1BB4653010F27E8ED9B242B9BD0")
    public void glVertexPointer(int size, int type, int stride, int offset) {
        addTaint(offset);
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        checkThread();
        mgl11.glVertexPointer(size, type, stride, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11.glVertexPointer(size, type, stride, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.403 -0400", hash_original_method = "ECE8E03D9351084EB6DD58269537E15C", hash_generated_method = "0580743C6EF4F42AFF0EB7DF6BBB5A84")
    public void glCurrentPaletteMatrixOES(int matrixpaletteindex) {
        addTaint(matrixpaletteindex);
        checkThread();
        mgl11Ext.glCurrentPaletteMatrixOES(matrixpaletteindex);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glCurrentPaletteMatrixOES(matrixpaletteindex);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.403 -0400", hash_original_method = "5AD566EDA8530FFFD9489137646EB6A1", hash_generated_method = "1338EA7E28C75224934523FF95C65FF5")
    public void glLoadPaletteFromModelViewMatrixOES() {
        checkThread();
        mgl11Ext.glLoadPaletteFromModelViewMatrixOES();
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glLoadPaletteFromModelViewMatrixOES();
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.403 -0400", hash_original_method = "9086F58902230C979E6EBFA4BA74064C", hash_generated_method = "727560780E48D2D626A40E372C4F0F0C")
    public void glMatrixIndexPointerOES(int size, int type, int stride,
            Buffer pointer) {
        addTaint(pointer.getTaint());
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        checkThread();
        mgl11Ext.glMatrixIndexPointerOES(size, type, stride, pointer);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glMatrixIndexPointerOES(size, type, stride, pointer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.404 -0400", hash_original_method = "0984DC91B3016A56DD022967F452ACBA", hash_generated_method = "738FF2DD665C63BD198CB33A86166DB0")
    public void glMatrixIndexPointerOES(int size, int type, int stride,
            int offset) {
        addTaint(offset);
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        checkThread();
        mgl11Ext.glMatrixIndexPointerOES(size, type, stride, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glMatrixIndexPointerOES(size, type, stride, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.404 -0400", hash_original_method = "990474B3CC64B92B9B97EA6700AA2D0C", hash_generated_method = "65B63CD8CFC7AD649062D794B167C7D9")
    public void glWeightPointerOES(int size, int type, int stride,
            Buffer pointer) {
        addTaint(pointer.getTaint());
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        checkThread();
        mgl11Ext.glWeightPointerOES(size, type, stride, pointer);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glWeightPointerOES(size, type, stride, pointer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.404 -0400", hash_original_method = "05D33A5D8AC487A90293158490370D32", hash_generated_method = "4FF8650EA276A887394B331EE303D5DA")
    public void glWeightPointerOES(int size, int type, int stride, int offset) {
        addTaint(offset);
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        checkThread();
        mgl11Ext.glWeightPointerOES(size, type, stride, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11Ext.glWeightPointerOES(size, type, stride, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.404 -0400", hash_original_method = "D2F7C990667B56FDD1F6E8C479EF3E4E", hash_generated_method = "3FDA503163468C854E6758D1E5CE82FB")
    @Override
    public void glBindFramebufferOES(int target, int framebuffer) {
        addTaint(framebuffer);
        addTaint(target);
        checkThread();
        mgl11ExtensionPack.glBindFramebufferOES(target, framebuffer);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glBindFramebufferOES(target, framebuffer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.404 -0400", hash_original_method = "7EB73AC724C3D8EE1D3B48DB2F9132D2", hash_generated_method = "BB20429659B6A5972DEA4019177FAC88")
    @Override
    public void glBindRenderbufferOES(int target, int renderbuffer) {
        addTaint(renderbuffer);
        addTaint(target);
        checkThread();
        mgl11ExtensionPack.glBindRenderbufferOES(target, renderbuffer);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glBindRenderbufferOES(target, renderbuffer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.404 -0400", hash_original_method = "D19C6515B3BFC46C895E49F99DAEC2CE", hash_generated_method = "C69968C30613DB583AF4215989AB0293")
    @Override
    public void glBlendEquation(int mode) {
        addTaint(mode);
        checkThread();
        mgl11ExtensionPack.glBlendEquation(mode);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glBlendEquation(mode);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.404 -0400", hash_original_method = "F957D0CDD60A7381A725B04FB0D2DA70", hash_generated_method = "1FB4958D9C2993AFA1D78632D19411D1")
    @Override
    public void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
        addTaint(modeAlpha);
        addTaint(modeRGB);
        checkThread();
        mgl11ExtensionPack.glBlendEquationSeparate(modeRGB, modeAlpha);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glBlendEquationSeparate(modeRGB, modeAlpha);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.405 -0400", hash_original_method = "498C1CF1FE30AA03446C52CC21D33437", hash_generated_method = "C7AC74C3FA390BC16EA81642A2CE6824")
    @Override
    public void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha,
            int dstAlpha) {
        addTaint(dstAlpha);
        addTaint(srcAlpha);
        addTaint(dstRGB);
        addTaint(srcRGB);
        checkThread();
        mgl11ExtensionPack.glBlendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glBlendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.405 -0400", hash_original_method = "F84CD15747EF92B360235F98C0C8FE92", hash_generated_method = "0A50302AB23032D41257746F3D27711F")
    @Override
    public int glCheckFramebufferStatusOES(int target) {
        addTaint(target);
        checkThread();
        int result = mgl11ExtensionPack.glCheckFramebufferStatusOES(target);
        checkError();
        int varB4A88417B3D0170D754C647C30B7216A_1979068846 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716584071 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716584071;
        // ---------- Original Method ----------
        //checkThread();
        //int result = mgl11ExtensionPack.glCheckFramebufferStatusOES(target);
        //checkError();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.405 -0400", hash_original_method = "C83794D04134327ED293408C6EAFA3F1", hash_generated_method = "82BF8FCEDBDFD26F9E6842FFF4A1A9FF")
    @Override
    public void glDeleteFramebuffersOES(int n, int[] framebuffers, int offset) {
        addTaint(offset);
        addTaint(framebuffers[0]);
        addTaint(n);
        checkThread();
        mgl11ExtensionPack.glDeleteFramebuffersOES(n, framebuffers, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glDeleteFramebuffersOES(n, framebuffers, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.405 -0400", hash_original_method = "637818FA141CF6CB105E4E7D4B6E5E9F", hash_generated_method = "B4C8F6E0C2507064F9AE110A88288635")
    @Override
    public void glDeleteFramebuffersOES(int n, IntBuffer framebuffers) {
        addTaint(framebuffers.getTaint());
        addTaint(n);
        checkThread();
        mgl11ExtensionPack.glDeleteFramebuffersOES(n, framebuffers);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glDeleteFramebuffersOES(n, framebuffers);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.405 -0400", hash_original_method = "DFC95BCA265F134EDD9DF8501B456CC5", hash_generated_method = "65C80B660678641AE5737595CFB8D35B")
    @Override
    public void glDeleteRenderbuffersOES(int n, int[] renderbuffers, int offset) {
        addTaint(offset);
        addTaint(renderbuffers[0]);
        addTaint(n);
        checkThread();
        mgl11ExtensionPack.glDeleteRenderbuffersOES(n, renderbuffers, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glDeleteRenderbuffersOES(n, renderbuffers, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.406 -0400", hash_original_method = "E94D9C754DAC473C75BBE28B377B49F6", hash_generated_method = "85D399BD4E99B8511650532EA59C1784")
    @Override
    public void glDeleteRenderbuffersOES(int n, IntBuffer renderbuffers) {
        addTaint(renderbuffers.getTaint());
        addTaint(n);
        checkThread();
        mgl11ExtensionPack.glDeleteRenderbuffersOES(n, renderbuffers);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glDeleteRenderbuffersOES(n, renderbuffers);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.406 -0400", hash_original_method = "AA45795C829A618DCE01DCFC13E444AD", hash_generated_method = "526CBAC7437E20961744E2C29F895834")
    @Override
    public void glFramebufferRenderbufferOES(int target, int attachment,
            int renderbuffertarget, int renderbuffer) {
        addTaint(renderbuffer);
        addTaint(renderbuffertarget);
        addTaint(attachment);
        addTaint(target);
        checkThread();
        mgl11ExtensionPack.glFramebufferRenderbufferOES(target, attachment, renderbuffertarget, renderbuffer);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glFramebufferRenderbufferOES(target, attachment, renderbuffertarget, renderbuffer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.406 -0400", hash_original_method = "E8C69625776C23938AEC9F5A5D2ED0AD", hash_generated_method = "AF7E92F2C6B227EF916A05CDAF39D5A4")
    @Override
    public void glFramebufferTexture2DOES(int target, int attachment,
            int textarget, int texture, int level) {
        addTaint(level);
        addTaint(texture);
        addTaint(textarget);
        addTaint(attachment);
        addTaint(target);
        checkThread();
        mgl11ExtensionPack.glFramebufferTexture2DOES(target, attachment, textarget, texture, level);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glFramebufferTexture2DOES(target, attachment, textarget, texture, level);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.407 -0400", hash_original_method = "A2D1B5AEB61D99CDE4C449FF577D7526", hash_generated_method = "C580452B29873F979E38F58EEB68AB79")
    @Override
    public void glGenerateMipmapOES(int target) {
        addTaint(target);
        checkThread();
        mgl11ExtensionPack.glGenerateMipmapOES(target);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glGenerateMipmapOES(target);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.407 -0400", hash_original_method = "4C10D6C69F4D6D86BC597FA354D0E064", hash_generated_method = "11AEFC34EFD027754EEB0FD0C74A7485")
    @Override
    public void glGenFramebuffersOES(int n, int[] framebuffers, int offset) {
        addTaint(offset);
        addTaint(framebuffers[0]);
        addTaint(n);
        checkThread();
        mgl11ExtensionPack.glGenFramebuffersOES(n, framebuffers, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glGenFramebuffersOES(n, framebuffers, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.409 -0400", hash_original_method = "3367B19C8B35C9E70E007013ACA3FDCB", hash_generated_method = "3B7EB7DE666B1CA210943F4B08759845")
    @Override
    public void glGenFramebuffersOES(int n, IntBuffer framebuffers) {
        addTaint(framebuffers.getTaint());
        addTaint(n);
        checkThread();
        mgl11ExtensionPack.glGenFramebuffersOES(n, framebuffers);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glGenFramebuffersOES(n, framebuffers);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.409 -0400", hash_original_method = "CBB8CAE1C22A3D14C85E49EEFB97952B", hash_generated_method = "5098CD6A6BCE4F75F0338881A442B97C")
    @Override
    public void glGenRenderbuffersOES(int n, int[] renderbuffers, int offset) {
        addTaint(offset);
        addTaint(renderbuffers[0]);
        addTaint(n);
        checkThread();
        mgl11ExtensionPack.glGenRenderbuffersOES(n, renderbuffers, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glGenRenderbuffersOES(n, renderbuffers, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.409 -0400", hash_original_method = "503D16E0F87FB104483D3BC7B0BEEC61", hash_generated_method = "0B662A18F6FAC75CF38E556F52FA7ADF")
    @Override
    public void glGenRenderbuffersOES(int n, IntBuffer renderbuffers) {
        addTaint(renderbuffers.getTaint());
        addTaint(n);
        checkThread();
        mgl11ExtensionPack.glGenRenderbuffersOES(n, renderbuffers);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glGenRenderbuffersOES(n, renderbuffers);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.410 -0400", hash_original_method = "87D1033F5DA311CE50445AE95714BB98", hash_generated_method = "23C11A9299B1C825A80C180E5F9E8B01")
    @Override
    public void glGetFramebufferAttachmentParameterivOES(int target,
            int attachment, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(attachment);
        addTaint(target);
        checkThread();
        mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(target, attachment, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(target, attachment, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.411 -0400", hash_original_method = "23B2B17D963584AB5B41C0BADA7D30E2", hash_generated_method = "887A6F170F559CBD4381464138167B82")
    @Override
    public void glGetFramebufferAttachmentParameterivOES(int target,
            int attachment, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(attachment);
        addTaint(target);
        checkThread();
        mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(target, attachment, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(target, attachment, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.411 -0400", hash_original_method = "323B7FC14FA3CC8A8CAB2937FB85AF32", hash_generated_method = "DB19A29A4F2ED0F407FE22B424A4EC2B")
    @Override
    public void glGetRenderbufferParameterivOES(int target, int pname,
            int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11ExtensionPack.glGetRenderbufferParameterivOES(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glGetRenderbufferParameterivOES(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.412 -0400", hash_original_method = "7DB224D75C69362AC7C1B5BFA2C118E8", hash_generated_method = "AA0005D28ADAF7BA8FB10C6B9FBFEB41")
    @Override
    public void glGetRenderbufferParameterivOES(int target, int pname,
            IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        checkThread();
        mgl11ExtensionPack.glGetRenderbufferParameterivOES(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glGetRenderbufferParameterivOES(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.413 -0400", hash_original_method = "73C5B23679F5E7FD2A22CB0DDCB6E37E", hash_generated_method = "685D536598385998D2C644D7948EE84E")
    @Override
    public void glGetTexGenfv(int coord, int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(coord);
        checkThread();
        mgl11ExtensionPack.glGetTexGenfv(coord, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glGetTexGenfv(coord, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.414 -0400", hash_original_method = "B36FB07131DC4A84E371A2A7731CAC6D", hash_generated_method = "7E604A2B9D4E84A7EFB8114CDAFE62A1")
    @Override
    public void glGetTexGenfv(int coord, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(coord);
        checkThread();
        mgl11ExtensionPack.glGetTexGenfv(coord, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glGetTexGenfv(coord, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.414 -0400", hash_original_method = "B7FA1E60287A66F116F39D7CC7313D43", hash_generated_method = "C1A84CD6879B36711054907245A4FF84")
    @Override
    public void glGetTexGeniv(int coord, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(coord);
        checkThread();
        mgl11ExtensionPack.glGetTexGeniv(coord, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glGetTexGeniv(coord, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.414 -0400", hash_original_method = "E0F30C6998C067FD1FF731B16C9025B6", hash_generated_method = "2BA4363252C5F0594A0AEB9007E07B0A")
    @Override
    public void glGetTexGeniv(int coord, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(coord);
        checkThread();
        mgl11ExtensionPack.glGetTexGeniv(coord, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glGetTexGeniv(coord, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.414 -0400", hash_original_method = "5DB0F3E94FEB1D4B3503AAE5DF93A903", hash_generated_method = "026DE3CBACF2AE2C10C0DBC26CB56A81")
    @Override
    public void glGetTexGenxv(int coord, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(coord);
        checkThread();
        mgl11ExtensionPack.glGetTexGenxv(coord, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glGetTexGenxv(coord, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.414 -0400", hash_original_method = "AA14C0675EB4BF5F25A5A7A59A9BBFAE", hash_generated_method = "09D83D1B2610288A165224A9CFCEFB95")
    @Override
    public void glGetTexGenxv(int coord, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(coord);
        checkThread();
        mgl11ExtensionPack.glGetTexGenxv(coord, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glGetTexGenxv(coord, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.415 -0400", hash_original_method = "0E8C838174C4BB1B590990BB7945115F", hash_generated_method = "870D891B2BC73E072CCE748F013E2E57")
    @Override
    public boolean glIsFramebufferOES(int framebuffer) {
        addTaint(framebuffer);
        checkThread();
        boolean result = mgl11ExtensionPack.glIsFramebufferOES(framebuffer);
        checkError();
        boolean varB4A88417B3D0170D754C647C30B7216A_313696200 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_785707109 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_785707109;
        // ---------- Original Method ----------
        //checkThread();
        //boolean result = mgl11ExtensionPack.glIsFramebufferOES(framebuffer);
        //checkError();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.417 -0400", hash_original_method = "D031C45B6462249C22BD3E4499FFA099", hash_generated_method = "2C4CC91DE0C9B09DEA1E74A7C474936D")
    @Override
    public boolean glIsRenderbufferOES(int renderbuffer) {
        addTaint(renderbuffer);
        checkThread();
        mgl11ExtensionPack.glIsRenderbufferOES(renderbuffer);
        checkError();
        boolean var68934A3E9455FA72420237EB05902327_1014759191 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1523859644 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1523859644;
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glIsRenderbufferOES(renderbuffer);
        //checkError();
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.417 -0400", hash_original_method = "444A1D32ABDE121DF7D78030687A057E", hash_generated_method = "9AA9EEB5610E090BB3A1AACB9077723A")
    @Override
    public void glRenderbufferStorageOES(int target, int internalformat,
            int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(internalformat);
        addTaint(target);
        checkThread();
        mgl11ExtensionPack.glRenderbufferStorageOES(target, internalformat, width, height);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glRenderbufferStorageOES(target, internalformat, width, height);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.418 -0400", hash_original_method = "D8E84864F1630E48A87EA7635B30F5FF", hash_generated_method = "9123B7CA1E28B7798E003C42B3991139")
    @Override
    public void glTexGenf(int coord, int pname, float param) {
        addTaint(param);
        addTaint(pname);
        addTaint(coord);
        checkThread();
        mgl11ExtensionPack.glTexGenf(coord, pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glTexGenf(coord, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.418 -0400", hash_original_method = "89B89821CA5D1C02C21E159AEC9A16EE", hash_generated_method = "6947DF93BEB01591225EF1F5E0F96EF6")
    @Override
    public void glTexGenfv(int coord, int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(coord);
        checkThread();
        mgl11ExtensionPack.glTexGenfv(coord, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glTexGenfv(coord, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.418 -0400", hash_original_method = "346783C2FA9147EBFCC1D68CE89FCD8D", hash_generated_method = "614BCA8474EBEFE059A97F6128905D6B")
    @Override
    public void glTexGenfv(int coord, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(coord);
        checkThread();
        mgl11ExtensionPack.glTexGenfv(coord, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glTexGenfv(coord, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.418 -0400", hash_original_method = "49F0D12B261A60762A8FDD97C3F8F021", hash_generated_method = "34D554781E6FFE78881B6AA0202C1FE4")
    @Override
    public void glTexGeni(int coord, int pname, int param) {
        addTaint(param);
        addTaint(pname);
        addTaint(coord);
        checkThread();
        mgl11ExtensionPack.glTexGeni(coord, pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glTexGeni(coord, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.418 -0400", hash_original_method = "140B3D5E9BE0C9BFC78A8488F14D55A1", hash_generated_method = "4E5FF5FE777FEA6B8BF71BCA46D7A5DF")
    @Override
    public void glTexGeniv(int coord, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(coord);
        checkThread();
        mgl11ExtensionPack.glTexGeniv(coord, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glTexGeniv(coord, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.419 -0400", hash_original_method = "75FF264C9BAB17A9B23FB5DFFC4BFB1E", hash_generated_method = "E2884B8701BD948D75D39106B0A06961")
    @Override
    public void glTexGeniv(int coord, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(coord);
        checkThread();
        mgl11ExtensionPack.glTexGeniv(coord, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glTexGeniv(coord, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.419 -0400", hash_original_method = "E13CD1A4EE5E6531CF166304F3752DE9", hash_generated_method = "FC1C6590192CD8E02BE80012E4197026")
    @Override
    public void glTexGenx(int coord, int pname, int param) {
        addTaint(param);
        addTaint(pname);
        addTaint(coord);
        checkThread();
        mgl11ExtensionPack.glTexGenx(coord, pname, param);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glTexGenx(coord, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.420 -0400", hash_original_method = "1B032D1F840008F790F14DDB1C46FEBC", hash_generated_method = "0520BD08C22967EBA90D1A427D8A3BD7")
    @Override
    public void glTexGenxv(int coord, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(coord);
        checkThread();
        mgl11ExtensionPack.glTexGenxv(coord, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glTexGenxv(coord, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.420 -0400", hash_original_method = "D73C17BE641E9517FD70F561167E80EC", hash_generated_method = "FE99B8BD6E2899C6F2C7A3DCA8CA3B00")
    @Override
    public void glTexGenxv(int coord, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(coord);
        checkThread();
        mgl11ExtensionPack.glTexGenxv(coord, pname, params);
        checkError();
        // ---------- Original Method ----------
        //checkThread();
        //mgl11ExtensionPack.glTexGenxv(coord, pname, params);
        //checkError();
    }

    
}

