/*
 * Copyright (C) 2011 The Android Open Source Project
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

package android.filterfw.core;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.FrameManager;
import android.filterfw.core.NativeFrame;
import android.filterfw.core.StopWatchMap;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.graphics.Rect;

import java.nio.ByteBuffer;

class GLFrameTimer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.994 -0400", hash_original_field = "9B00ED9622D774FE98BBA25FBA3C718F", hash_generated_field = "6A16B6B16EF0047C2C4069EFE9702905")

    private static StopWatchMap mTimer = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.997 -0400", hash_original_method = "6567BE238EC4188FC38378D4F1A3B8BB", hash_generated_method = "487CEB59E72DDB94A50534D730FD00A5")
    
public static StopWatchMap get() {
        if (mTimer == null) {
            mTimer = new StopWatchMap();
        }
        return mTimer;
    }

}

/**
 * @hide
 */
public class GLFrame extends Frame {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.002 -0400", hash_original_field = "C68C50C6FD39EAD5A7CBE09860C5A320", hash_generated_field = "1F3B472EA53191A04549F78D228C21F4")

    public final static int EXISTING_TEXTURE_BINDING = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.005 -0400", hash_original_field = "49B27781097E5F54A4A3D227AD84C684", hash_generated_field = "B1F2C0871073887E9ACC4F68DE245E29")

    public final static int EXISTING_FBO_BINDING     = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.008 -0400", hash_original_field = "C0BFCA9B24D543F647C8CDA138A1A583", hash_generated_field = "C007FF31BD735A069694C266670D2725")

    public final static int NEW_TEXTURE_BINDING      = 102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.012 -0400", hash_original_field = "B5FB8D19B6474CB6AD679D28F7A37F60", hash_generated_field = "141683CFED5FB87C462E58BF704CE3B4")

    public final static int NEW_FBO_BINDING          = 103;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.014 -0400", hash_original_field = "D525B84B789F9F22582F4F1A25535BB2", hash_generated_field = "564485EB0A8A99A3FCE5F8E85F27C470")

    public final static int EXTERNAL_TEXTURE         = 104;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.016 -0400", hash_original_field = "DBEFE5647E51520EA539EDBE2D59F406", hash_generated_field = "93CD8E3DA00B733348D50625EF8CC82E")

    private int glFrameId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.019 -0400", hash_original_field = "2496FF4BA626DB98EC8FB170AAC77D59", hash_generated_field = "68D84E2EBAD64E18EDCA6B050B95E0AD")

    private boolean mOwnsTexture = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.021 -0400", hash_original_field = "8BDB18895FCC3C3DE30D4A8182B759B0", hash_generated_field = "7F12F37111A28DB480E590BCA856DF01")

    private GLEnvironment mGLEnvironment;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.023 -0400", hash_original_method = "D30A707BB5328E35CFA9A58E29A6DB70", hash_generated_method = "D30A707BB5328E35CFA9A58E29A6DB70")
    
GLFrame(FrameFormat format, FrameManager frameManager) {
        super(format, frameManager);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.026 -0400", hash_original_method = "E51AB6E6B180FDD11DD45A1415ACF4D2", hash_generated_method = "E51AB6E6B180FDD11DD45A1415ACF4D2")
    
GLFrame(FrameFormat format, FrameManager frameManager, int bindingType, long bindingId) {
        super(format, frameManager, bindingType, bindingId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.029 -0400", hash_original_method = "BE423A787C4BBE302152B0D296FEDCDF", hash_generated_method = "0BEC42593E437B11CD97645195378089")
    
void init(GLEnvironment glEnv) {
        FrameFormat format = getFormat();
        mGLEnvironment = glEnv;

        // Check that we have a valid format
        if (format.getBytesPerSample() != 4) {
            throw new IllegalArgumentException("GL frames must have 4 bytes per sample!");
        } else if (format.getDimensionCount() != 2) {
            throw new IllegalArgumentException("GL frames must be 2-dimensional!");
        } else if (getFormat().getSize() < 0) {
            throw new IllegalArgumentException("Initializing GL frame with zero size!");
        }

        // Create correct frame
        int bindingType = getBindingType();
        boolean reusable = true;
        if (bindingType == Frame.NO_BINDING) {
            initNew(false);
        } else if (bindingType == EXTERNAL_TEXTURE) {
            initNew(true);
            reusable = false;
        } else if (bindingType == EXISTING_TEXTURE_BINDING) {
            initWithTexture((int)getBindingId());
        } else if (bindingType == EXISTING_FBO_BINDING) {
            initWithFbo((int)getBindingId());
        } else if (bindingType == NEW_TEXTURE_BINDING) {
            initWithTexture((int)getBindingId());
        } else if (bindingType == NEW_FBO_BINDING) {
            initWithFbo((int)getBindingId());
        } else {
            throw new RuntimeException("Attempting to create GL frame with unknown binding type "
                + bindingType + "!");
        }
        setReusable(reusable);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.032 -0400", hash_original_method = "39B4DD47002078708E03866AE6818105", hash_generated_method = "F431CB9917F30DE67FE2E5E18BDF44EE")
    
private void initNew(boolean isExternal) {
        if (isExternal) {
            if (!nativeAllocateExternal(mGLEnvironment)) {
                throw new RuntimeException("Could not allocate external GL frame!");
            }
        } else {
            if (!nativeAllocate(mGLEnvironment, getFormat().getWidth(), getFormat().getHeight())) {
                throw new RuntimeException("Could not allocate GL frame!");
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.034 -0400", hash_original_method = "69749A5CCE0DEC50F093FB724B17E2C5", hash_generated_method = "80884BFA095591543FB9ADD205047BEC")
    
private void initWithTexture(int texId) {
        int width = getFormat().getWidth();
        int height = getFormat().getHeight();
        if (!nativeAllocateWithTexture(mGLEnvironment, texId, width, height)) {
            throw new RuntimeException("Could not allocate texture backed GL frame!");
        }
        mOwnsTexture = false;
        markReadOnly();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.037 -0400", hash_original_method = "B6D0D1F6F83D10ECFB57B64E4DF282EE", hash_generated_method = "A2BBC60C770F8E975D8A7A4C6CA8E243")
    
private void initWithFbo(int fboId) {
        int width = getFormat().getWidth();
        int height = getFormat().getHeight();
        if (!nativeAllocateWithFbo(mGLEnvironment, fboId, width, height)) {
            throw new RuntimeException("Could not allocate FBO backed GL frame!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.039 -0400", hash_original_method = "96D3BDDA5149BA77D44DC1C210651205", hash_generated_method = "96D3BDDA5149BA77D44DC1C210651205")
    
void flushGPU(String message) {
        StopWatchMap timer = GLFrameTimer.get();
        if (timer.LOG_MFF_RUNNING_TIMES) {
          timer.start("glFinish " + message);
          GLES20.glFinish();
          timer.stop("glFinish " + message);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.040 -0400", hash_original_method = "3C836A9852FAE89EAFE1EC5C0D02C2A8", hash_generated_method = "BB79BCA7DE92970B4E35D7BE5D4F226A")
    
@Override
    protected synchronized boolean hasNativeAllocation() {
        return glFrameId != -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.042 -0400", hash_original_method = "F23A704EB79F2F51AB9CD6C250F40162", hash_generated_method = "4F4EEF6553A5AFDE87A8B973861A825F")
    
@Override
    protected synchronized void releaseNativeAllocation() {
        nativeDeallocate();
        glFrameId = -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.044 -0400", hash_original_method = "775B48885FEEEE864377B7024CEEE1C9", hash_generated_method = "D79682786AAE3AD98CE337A50C288E86")
    
public GLEnvironment getGLEnvironment() {
        return mGLEnvironment;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.046 -0400", hash_original_method = "3B00C385AE6FD83DD1D675F67D7FC59B", hash_generated_method = "69E39E4A216827B952E696614040CD5D")
    
@Override
    public Object getObjectValue() {
        assertGLEnvValid();
        return ByteBuffer.wrap(getNativeData());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.049 -0400", hash_original_method = "B01C3795A24CCBB311883FA8B5091443", hash_generated_method = "DAAFDDC03747B7AD5EAF4CBBEEDDCC13")
    
@Override
    public void setInts(int[] ints) {
        assertFrameMutable();
        assertGLEnvValid();
        if (!setNativeInts(ints)) {
            throw new RuntimeException("Could not set int values for GL frame!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.051 -0400", hash_original_method = "DBBD1B79D1640E979B15BFF342D484DD", hash_generated_method = "DA72DF74FC6D5808C44A3F5F28EE93B8")
    
@Override
    public int[] getInts() {
        assertGLEnvValid();
        flushGPU("getInts");
        return getNativeInts();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.053 -0400", hash_original_method = "B7C1FD3B80560A8661657DC9A8353D6C", hash_generated_method = "6AA541CC953A56426F1BC3A6C1430A80")
    
@Override
    public void setFloats(float[] floats) {
        assertFrameMutable();
        assertGLEnvValid();
        if (!setNativeFloats(floats)) {
            throw new RuntimeException("Could not set int values for GL frame!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.055 -0400", hash_original_method = "AF4601917EB71123AE9821B08A6FD8D5", hash_generated_method = "2008FF3858C34BE209376B3746DDC679")
    
@Override
    public float[] getFloats() {
        assertGLEnvValid();
        flushGPU("getFloats");
        return getNativeFloats();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.057 -0400", hash_original_method = "060052B4D59EF2FBECF2C475882DB906", hash_generated_method = "2E980399EF1CF19A19AA32FB572F09A3")
    
@Override
    public void setData(ByteBuffer buffer, int offset, int length) {
        assertFrameMutable();
        assertGLEnvValid();
        byte[] bytes = buffer.array();
        if (getFormat().getSize() != bytes.length) {
            throw new RuntimeException("Data size in setData does not match GL frame size!");
        } else if (!setNativeData(bytes, offset, length)) {
            throw new RuntimeException("Could not set GL frame data!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.059 -0400", hash_original_method = "F288AA58A34638AB5E46EE0B01059E00", hash_generated_method = "4BFBA2D109D1AE5EB7FDEB7E5256B73A")
    
@Override
    public ByteBuffer getData() {
        assertGLEnvValid();
        flushGPU("getData");
        return ByteBuffer.wrap(getNativeData());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.061 -0400", hash_original_method = "EE4E59725671D607CE7F605E787B26F9", hash_generated_method = "74BBE69C8C27AA3D28911E2C2AE5CF52")
    
@Override
    public void setBitmap(Bitmap bitmap) {
        assertFrameMutable();
        assertGLEnvValid();
        if (getFormat().getWidth()  != bitmap.getWidth() ||
            getFormat().getHeight() != bitmap.getHeight()) {
            throw new RuntimeException("Bitmap dimensions do not match GL frame dimensions!");
        } else {
            Bitmap rgbaBitmap = convertBitmapToRGBA(bitmap);
            if (!setNativeBitmap(rgbaBitmap, rgbaBitmap.getByteCount())) {
                throw new RuntimeException("Could not set GL frame bitmap data!");
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.063 -0400", hash_original_method = "79AA764312F8E3588A302E57567DC61F", hash_generated_method = "94786191659EADDB4C463D119C22A532")
    
@Override
    public Bitmap getBitmap() {
        assertGLEnvValid();
        flushGPU("getBitmap");
        Bitmap result = Bitmap.createBitmap(getFormat().getWidth(),
                                            getFormat().getHeight(),
                                            Bitmap.Config.ARGB_8888);
        if (!getNativeBitmap(result)) {
            throw new RuntimeException("Could not get bitmap data from GL frame!");
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.066 -0400", hash_original_method = "E132680A856BB7502FB8D29E2FEC6686", hash_generated_method = "75BC9105525E216EF69B70C175E051B6")
    
@Override
    public void setDataFromFrame(Frame frame) {
        assertGLEnvValid();

        // Make sure frame fits
        if (getFormat().getSize() < frame.getFormat().getSize()) {
            throw new RuntimeException(
                "Attempting to assign frame of size " + frame.getFormat().getSize() + " to " +
                "smaller GL frame of size " + getFormat().getSize() + "!");
        }

        // Invoke optimized implementations if possible
        if (frame instanceof NativeFrame) {
            nativeCopyFromNative((NativeFrame)frame);
        } else if (frame instanceof GLFrame) {
            nativeCopyFromGL((GLFrame)frame);
        } else if (frame instanceof SimpleFrame) {
            setObjectValue(frame.getObjectValue());
        } else {
            super.setDataFromFrame(frame);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.068 -0400", hash_original_method = "BB81A93CD4C2F54969AA4C877D02FA3C", hash_generated_method = "078A510FF288F4C12E189605B6D6E499")
    
public void setViewport(int x, int y, int width, int height) {
        assertFrameMutable();
        setNativeViewport(x, y, width, height);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.070 -0400", hash_original_method = "4DDE9F94692EE368F302F241520CB122", hash_generated_method = "E624752B6878138E17EBD2E47B57063C")
    
public void setViewport(Rect rect) {
        assertFrameMutable();
        setNativeViewport(rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.072 -0400", hash_original_method = "1FE98FB9E48910BC6E1F58A6C0037105", hash_generated_method = "792FEAC69E76B3FA58EEC09C69CE9B94")
    
public void generateMipMap() {
        assertFrameMutable();
        assertGLEnvValid();
        if (!generateNativeMipMap()) {
            throw new RuntimeException("Could not generate mip-map for GL frame!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.074 -0400", hash_original_method = "4FFB4F6C70349A6FB205146BA923A9D0", hash_generated_method = "7D1288606BBB710A40920F2C8C53FEB1")
    
public void setTextureParameter(int param, int value) {
        assertFrameMutable();
        assertGLEnvValid();
        if (!setNativeTextureParam(param, value)) {
            throw new RuntimeException("Could not set texture value " + param + " = " + value + " " +
                                       "for GLFrame!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.076 -0400", hash_original_method = "98052DF3CAA214FA2FDCCC13292CFF1A", hash_generated_method = "A640F38022DC31252B1C49783F236D2E")
    
public int getTextureId() {
        return getNativeTextureId();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.078 -0400", hash_original_method = "CEF63035EFAD689F2F0EC753B2611CCC", hash_generated_method = "6FD732D6E1205F23392F26D6A62E6D1A")
    
public int getFboId() {
        return getNativeFboId();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.080 -0400", hash_original_method = "0BC500EE23EE7B12AB66B345C5D3E55B", hash_generated_method = "5862EC448E5BE18964B358FD3D7C6D6F")
    
public void focus() {
        if (!nativeFocus()) {
            throw new RuntimeException("Could not focus on GLFrame for drawing!");
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.084 -0400", hash_original_method = "9F5567D34E7002A8051B2B7F3E0FF329", hash_generated_method = "948A4FE253E4C58D9F72DB5B08749BA5")
    
@Override
    public String toString() {
        return "GLFrame id: " + glFrameId + " (" + getFormat() + ") with texture ID "
            + getTextureId() + ", FBO ID " + getFboId();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.087 -0400", hash_original_method = "1502954F31434FD11917B4DF9E18C183", hash_generated_method = "13E4AAFA03B32A551247BD5844B51507")
    
@Override
    protected void reset(FrameFormat newFormat) {
        if (!nativeResetParams()) {
            throw new RuntimeException("Could not reset GLFrame texture parameters!");
        }
        super.reset(newFormat);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.095 -0400", hash_original_method = "8E0EDC7BDD20B48E33DEF03F2EF9B55D", hash_generated_method = "53300635F9F0A3B92D734A4D4C09FA0F")
    
@Override
    protected void onFrameStore() {
        if (!mOwnsTexture) {
            // Detach texture from FBO in case user manipulates it.
            nativeDetachTexFromFbo();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.099 -0400", hash_original_method = "FC1BEFA2119DBC54EE07F13A9E02C2EF", hash_generated_method = "CDCFE132F8434522EC95EFD003D73FA6")
    
@Override
    protected void onFrameFetch() {
        if (!mOwnsTexture) {
            // Reattach texture to FBO when using frame again. This may reallocate the texture
            // in case it has become invalid.
            nativeReattachTexToFbo();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.101 -0400", hash_original_method = "7B285396A4570E6126B59CE2A6040A2D", hash_generated_method = "FA38C269070AE209C827E66147A259D3")
    
private void assertGLEnvValid() {
        if (!mGLEnvironment.isContextActive()) {
            if (GLEnvironment.isAnyContextActive()) {
                throw new RuntimeException("Attempting to access " + this + " with foreign GL " +
                    "context active!");
            } else {
                throw new RuntimeException("Attempting to access " + this + " with no GL context " +
                    " active!");
            }
        }
    }

    static {
        System.loadLibrary("filterfw");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.564 -0400", hash_original_method = "8A0B7ED8080042E7ADB1BB118D792749", hash_generated_method = "F2394228F41CB04E1092ADCBCF5ECE51")
    
    private boolean nativeAllocate(GLEnvironment env, int width, int height){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += env.getTaintInt();
    	taintDouble += width;
    	taintDouble += height;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.568 -0400", hash_original_method = "03523908ED8B11673A5D48A76B44EE35", hash_generated_method = "8A7FB346EC4BBD84554B7470ECC8F640")
    
    private boolean nativeAllocateWithTexture(GLEnvironment env,
                                                   int textureId,
                                                   int width,
                                                   int height){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += env.getTaintInt();
    	taintDouble += textureId;
    	taintDouble += width;
    	taintDouble += height;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.573 -0400", hash_original_method = "DDB58720C6D6E3FE692A9195DAC245D6", hash_generated_method = "3FF7B7D096483F2D2E0A209D601D5875")
    
    private boolean nativeAllocateWithFbo(GLEnvironment env,
                                               int fboId,
                                               int width,
                                               int height){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += env.getTaintInt();
    	taintDouble += fboId;
    	taintDouble += width;
    	taintDouble += height;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.577 -0400", hash_original_method = "422CB52C10656D7E44FE121CA126BF91", hash_generated_method = "37C74810B084ABE902C6821785703C64")
    
    private boolean nativeAllocateExternal(GLEnvironment env){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += env.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.871 -0400", hash_original_method = "C5D13A7D2DE40061D17A5A19349F9B46", hash_generated_method = "B240A7932BE0CB51D42FA1BDE6059C94")
    
    private boolean nativeDeallocate(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.585 -0400", hash_original_method = "B008EA5EAE1D78CF60323223B23112C0", hash_generated_method = "DB9D3915DCF330A7854A0E564C5106A0")
    
    private boolean setNativeData(byte[] data, int offset, int length){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += data[0];
    	taintDouble += offset;
    	taintDouble += length;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.877 -0400", hash_original_method = "0CDA28160C9A5C0DC3D1C6484E3FA045", hash_generated_method = "FF35CD365978FED412AA095CD77FF2C6")
    
    private byte[] getNativeData(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.595 -0400", hash_original_method = "2047716A79A9E9406699C20C7A268A40", hash_generated_method = "431F2A0CB3A7814C0347AEEA4DA821C1")
    
    private boolean setNativeInts(int[] ints){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ints[0];
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.598 -0400", hash_original_method = "88CBED05920219A258C2F99CB4EDFE1D", hash_generated_method = "C0A8BCC26755F86A54824EBDD91E7B3C")
    
    private boolean setNativeFloats(float[] floats){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += floats[0];
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.887 -0400", hash_original_method = "81E9CE5D152943B1180D2B2B4410CA1A", hash_generated_method = "9E5EE35C97C22896A330041F1B091CC7")
    
    private int[] getNativeInts(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	int[] retObj = new int[1]; 
    	retObj[0] = (int)taintDouble;
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.891 -0400", hash_original_method = "7B9A4B17D75D852FBC4B73DC0B2841F8", hash_generated_method = "C87A6A90701A0F1419E4913F6FF445F1")
    
    private float[] getNativeFloats(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	float[] retObj = new float[1]; 
    	retObj[0] = (float)taintDouble;
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.611 -0400", hash_original_method = "BDFD1E5FE9C8C95CEEFF6D9A38A19A7D", hash_generated_method = "F321922C1EF145C479A65B6FBD4E48CA")
    
    private boolean setNativeBitmap(Bitmap bitmap, int size){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += bitmap.getTaintInt();
    	taintDouble += size;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.615 -0400", hash_original_method = "23143653D9213132827701339A03557C", hash_generated_method = "337D8AF9E5C736FE34D5923F2C28F107")
    
    private boolean getNativeBitmap(Bitmap bitmap){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += bitmap.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.619 -0400", hash_original_method = "2308E7A848EC5796D50EF11678C38562", hash_generated_method = "112AD0EE42A32EC3A01B67B636D3EE57")
    
    private boolean setNativeViewport(int x, int y, int width, int height){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += x;
    	taintDouble += y;
    	taintDouble += width;
    	taintDouble += height;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.903 -0400", hash_original_method = "2A0BEF4BD3FA66E8C8B202C5483364C5", hash_generated_method = "5E7F211D7D236C9AC7A5715D467ABF17")
    
    private int getNativeTextureId(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.906 -0400", hash_original_method = "F20CA513CA6E3A14E45EA6864A6BF5B3", hash_generated_method = "6E5EB2C6CEAB691D8944E44CF160736B")
    
    private int getNativeFboId(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.909 -0400", hash_original_method = "4813D7F0EE69DE38880B62FC08CBF522", hash_generated_method = "5C1271839898763E9ABC99F8AC65488E")
    
    private boolean generateNativeMipMap(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.636 -0400", hash_original_method = "F944BAAF7A5BA111DFDCD72BEF3E8177", hash_generated_method = "A46412658C5ABCCEB4727E1D1F242749")
    
    private boolean setNativeTextureParam(int param, int value){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += param;
    	taintDouble += value;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.916 -0400", hash_original_method = "23EE7EC8AA368D8B0BB5DA5C6C6AA176", hash_generated_method = "4EAC39F81B33D8D5B5D321EFB75BB78C")
    
    private boolean nativeResetParams(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.644 -0400", hash_original_method = "4AAA1963F74E551C88426B820B381324", hash_generated_method = "D98ADAE63A177915B45128E092AF964A")
    
    private boolean nativeCopyFromNative(NativeFrame frame){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += frame.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.648 -0400", hash_original_method = "8EE5FFA3E1866792DC021D861E52C38E", hash_generated_method = "E181817671F3569D40046BA60CE0103A")
    
    private boolean nativeCopyFromGL(GLFrame frame){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += frame.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.925 -0400", hash_original_method = "5C39D5AF38352115E9F43A31376CF046", hash_generated_method = "56FAD824DB8882D6110E189A7AEACB52")
    
    private boolean nativeFocus(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.928 -0400", hash_original_method = "D9767F3BE31C5055B0252F4C4496F40B", hash_generated_method = "E026546DD6FBE3A92DAF804101696635")
    
    private boolean nativeReattachTexToFbo(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.931 -0400", hash_original_method = "38053EE393261C8440AEFFCC66D98C87", hash_generated_method = "F1CE8C595B03878188E844E11AA72586")
    
    private boolean nativeDetachTexFromFbo(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

}
