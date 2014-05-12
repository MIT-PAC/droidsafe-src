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
import android.graphics.Bitmap;

import java.nio.ByteBuffer;

/**
 * @hide
 */
public class VertexFrame extends Frame {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:06.046 -0400", hash_original_field = "75E5438C7D36DE31EB8E9AB82E55F7C1", hash_generated_field = "B779060CC790BBFAB35B20234BA4912C")

    private int vertexFrameId = -1;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:06.047 -0400", hash_original_method = "4BF02327C09A3348C0747F8AD7346FF9", hash_generated_method = "4BF02327C09A3348C0747F8AD7346FF9")
    
VertexFrame(FrameFormat format, FrameManager frameManager) {
        super(format, frameManager);
        if (getFormat().getSize() <= 0) {
            throw new IllegalArgumentException("Initializing vertex frame with zero size!");
        } else {
            if (!nativeAllocate(getFormat().getSize())) {
                throw new RuntimeException("Could not allocate vertex frame!");
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:06.049 -0400", hash_original_method = "BB3C674AA63775A7EA5B6106CBD97A8B", hash_generated_method = "92E25EEC77CAC11FA701DC7FE42B5D19")
    
@Override
    protected synchronized boolean hasNativeAllocation() {
        return vertexFrameId != -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:06.050 -0400", hash_original_method = "15F4EF4372B5553B9BDA87AB01F7E54E", hash_generated_method = "C99CB4AF825ADEF0AD6286ED9EEC1A0D")
    
@Override
    protected synchronized void releaseNativeAllocation() {
        nativeDeallocate();
        vertexFrameId = -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:06.052 -0400", hash_original_method = "F3809B4CD8675FAD1FB12FA10D7C92B9", hash_generated_method = "30994B74A7F615FDE7E50812B843473F")
    
@Override
    public Object getObjectValue() {
        throw new RuntimeException("Vertex frames do not support reading data!");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:06.054 -0400", hash_original_method = "79A3EDA63B438894E4F41678FA552745", hash_generated_method = "8DB0EFCFE598EEF8714DC9F1ED0DF439")
    
@Override
    public void setInts(int[] ints) {
        assertFrameMutable();
        if (!setNativeInts(ints)) {
            throw new RuntimeException("Could not set int values for vertex frame!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:06.056 -0400", hash_original_method = "F234A4734EFDBFCD8335DE9DABD69D91", hash_generated_method = "2A74503EFB81D00928B3E39B844A3E49")
    
@Override
    public int[] getInts() {
        throw new RuntimeException("Vertex frames do not support reading data!");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:06.058 -0400", hash_original_method = "4A59AE057741E0B3BA36F3F93A1BAB09", hash_generated_method = "5CD3456C3E1539506E0F8D67FC4403D0")
    
@Override
    public void setFloats(float[] floats) {
        assertFrameMutable();
        if (!setNativeFloats(floats)) {
            throw new RuntimeException("Could not set int values for vertex frame!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:06.059 -0400", hash_original_method = "22F0B7EC4D7FF3C86E2B20EA3093220D", hash_generated_method = "D5DBFEAFBE33D65381F0CEBC3012238C")
    
@Override
    public float[] getFloats() {
        throw new RuntimeException("Vertex frames do not support reading data!");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:06.061 -0400", hash_original_method = "9C0A62C814C7B0CC4AFA0B7DB28C168A", hash_generated_method = "C667FC7A12FD505BBF1EE595C873B9C5")
    
@Override
    public void setData(ByteBuffer buffer, int offset, int length) {
        assertFrameMutable();
        byte[] bytes = buffer.array();
        if (getFormat().getSize() != bytes.length) {
            throw new RuntimeException("Data size in setData does not match vertex frame size!");
        } else if (!setNativeData(bytes, offset, length)) {
            throw new RuntimeException("Could not set vertex frame data!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:06.063 -0400", hash_original_method = "5E804A75A349F5793BF14338DB37BA1B", hash_generated_method = "D2096632820AC4BAE00D490AC56E93B2")
    
@Override
    public ByteBuffer getData() {
        throw new RuntimeException("Vertex frames do not support reading data!");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:06.065 -0400", hash_original_method = "11B03E5A564CCCB1E44154C5ACDC6D75", hash_generated_method = "EB32CC27DC811610A75BD3B392A4A340")
    
@Override
    public void setBitmap(Bitmap bitmap) {
        throw new RuntimeException("Unsupported: Cannot set vertex frame bitmap value!");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:06.066 -0400", hash_original_method = "752F9BAEC382A5E2C9DF5E6C2F7D37B9", hash_generated_method = "4744DCC07D64BE0E4AF660ECF00BC728")
    
@Override
    public Bitmap getBitmap() {
        throw new RuntimeException("Vertex frames do not support reading data!");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:06.068 -0400", hash_original_method = "CFC5E558B2D4EBC0B66F33A7593B5684", hash_generated_method = "B41C1CE1DB3AF69327258807E119F61F")
    
@Override
    public void setDataFromFrame(Frame frame) {
        // TODO: Optimize
        super.setDataFromFrame(frame);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:06.069 -0400", hash_original_method = "A93B1E28AA88B05B676275755BE0437F", hash_generated_method = "B983CEB41ECBE8249B3E3A5C14C38449")
    
public int getVboId() {
        return getNativeVboId();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:06.071 -0400", hash_original_method = "B350639441A012A513BBC91904F9439C", hash_generated_method = "976E5EAE7675EA35670E15FAD0B511D4")
    
@Override
    public String toString() {
        return "VertexFrame (" + getFormat() + ") with VBO ID " + getVboId();
    }

    static {
        System.loadLibrary("filterfw");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.820 -0400", hash_original_method = "1BB170F7B1039ADD1BBC116741872BA5", hash_generated_method = "D04D9D02F7BD1351057D253CF2E9C7F3")
    
    private boolean nativeAllocate(int size){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += size;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:45.886 -0400", hash_original_method = "C5D13A7D2DE40061D17A5A19349F9B46", hash_generated_method = "B240A7932BE0CB51D42FA1BDE6059C94")
    
    private boolean nativeDeallocate(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.828 -0400", hash_original_method = "B008EA5EAE1D78CF60323223B23112C0", hash_generated_method = "DB9D3915DCF330A7854A0E564C5106A0")
    
    private boolean setNativeData(byte[] data, int offset, int length){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += data[0];
    	taintDouble += offset;
    	taintDouble += length;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.831 -0400", hash_original_method = "2047716A79A9E9406699C20C7A268A40", hash_generated_method = "431F2A0CB3A7814C0347AEEA4DA821C1")
    
    private boolean setNativeInts(int[] ints){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ints[0];
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.835 -0400", hash_original_method = "88CBED05920219A258C2F99CB4EDFE1D", hash_generated_method = "C0A8BCC26755F86A54824EBDD91E7B3C")
    
    private boolean setNativeFloats(float[] floats){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += floats[0];
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:45.898 -0400", hash_original_method = "F5E0A87A45A339E1E99CABC265EAF2A4", hash_generated_method = "20CEC4C717A81A984B6DB7224BFF3610")
    
    private int getNativeVboId(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

}
