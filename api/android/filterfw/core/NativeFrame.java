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
import android.filterfw.core.GLFrame;
import android.filterfw.core.NativeBuffer;
import android.graphics.Bitmap;

import android.util.Log;

import java.nio.ByteBuffer;

/**
 * @hide
 */
public class NativeFrame extends Frame {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:43.878 -0400", hash_original_method = "95BC9A805D54B1882DCE54CDCD85DDBA", hash_generated_method = "4672356E5C7D04CC1369AE8A47387F9C")
    
    private static int nativeIntSize(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:43.881 -0400", hash_original_method = "919C4984F9510C7C48E5DF2B39FB2669", hash_generated_method = "C505B07EF90B1EF2E3B2B6FD7D4550B8")
    
    private static int nativeFloatSize(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.096 -0400", hash_original_field = "AE5C7359BA8A9D40680DB131D41D087B", hash_generated_field = "2F9F20C4BE03A0465EFAFD737A55BC10")

    private int nativeFrameId = -1;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.098 -0400", hash_original_method = "0C9B8A8A189FCA5F20DE89D4E93CD0C7", hash_generated_method = "0C9B8A8A189FCA5F20DE89D4E93CD0C7")
    
NativeFrame(FrameFormat format, FrameManager frameManager) {
        super(format, frameManager);
        int capacity = format.getSize();
        nativeAllocate(capacity);
        setReusable(capacity != 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.100 -0400", hash_original_method = "D8A4CE68BF25C561503F70E98C60861C", hash_generated_method = "8AB03B9966D5E85E45C017CDC9A1CF07")
    
@Override
    protected synchronized void releaseNativeAllocation() {
        nativeDeallocate();
        nativeFrameId = -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.102 -0400", hash_original_method = "9B49D0FE4C009491A4636D0091EACA61", hash_generated_method = "184D2884F2F20D73E35865B3E4CC71E2")
    
@Override
    protected synchronized boolean hasNativeAllocation() {
        return nativeFrameId != -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.104 -0400", hash_original_method = "8EEE3DFE58819FA12EF510065DB36665", hash_generated_method = "99D16B05AEE615EAD7D5FABF01D18447")
    
@Override
    public int getCapacity() {
        return getNativeCapacity();
    }

    /**
     * Returns the native frame's Object value.
     *
     * If the frame's base-type is not TYPE_OBJECT, this returns a data buffer containing the native
     * data (this is equivalent to calling getData().
     * If the frame is based on an object type, this type is expected to be a subclass of
     * NativeBuffer. The NativeBuffer returned is only valid for as long as the frame is alive. If
     * you need to hold on to the returned value, you must retain it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.108 -0400", hash_original_method = "C431D8474798E764ED1C4432CF816013", hash_generated_method = "2B38C9942CC742962298BF7205A154A8")
    
@Override
    public Object getObjectValue() {
        // If this is not a structured frame, return our data
        if (getFormat().getBaseType() != FrameFormat.TYPE_OBJECT) {
            return getData();
        }

        // Get the structure class
        Class structClass = getFormat().getObjectClass();
        if (structClass == null) {
            throw new RuntimeException("Attempting to get object data from frame that does " +
                                       "not specify a structure object class!");
        }

        // Make sure it is a NativeBuffer subclass
        if (!NativeBuffer.class.isAssignableFrom(structClass)) {
            throw new RuntimeException("NativeFrame object class must be a subclass of " +
                                       "NativeBuffer!");
        }

        // Instantiate a new empty instance of this class
        NativeBuffer structData = null;
        try {
          structData = (NativeBuffer)structClass.newInstance();
        } catch (Exception e) {
          throw new RuntimeException("Could not instantiate new structure instance of type '" +
                                     structClass + "'!");
        }

        // Wrap it around our data
        if (!getNativeBuffer(structData)) {
            throw new RuntimeException("Could not get the native structured data for frame!");
        }

        // Attach this frame to it
        structData.attachToFrame(this);

        return structData;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.110 -0400", hash_original_method = "FD341E12C01C8D4911697E10E42A3E86", hash_generated_method = "B99BF619C865C95ACC0D93018935E86B")
    
@Override
    public void setInts(int[] ints) {
        assertFrameMutable();
        if (ints.length * nativeIntSize() > getFormat().getSize()) {
            throw new RuntimeException(
                "NativeFrame cannot hold " + ints.length + " integers. (Can only hold " +
                (getFormat().getSize() / nativeIntSize()) + " integers).");
        } else if (!setNativeInts(ints)) {
            throw new RuntimeException("Could not set int values for native frame!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.112 -0400", hash_original_method = "9BF0AA42C6B10A61FAA7DC8FE8E53054", hash_generated_method = "99F3BAA44BA162F84876CBFEF6E7A60E")
    
@Override
    public int[] getInts() {
        return getNativeInts(getFormat().getSize());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.114 -0400", hash_original_method = "776E0FFDC7F010B3B8E96427C035D1D9", hash_generated_method = "EC4D854C2D0B264BBCAC3B952ACA3EF1")
    
@Override
    public void setFloats(float[] floats) {
        assertFrameMutable();
        if (floats.length * nativeFloatSize() > getFormat().getSize()) {
            throw new RuntimeException(
                "NativeFrame cannot hold " + floats.length + " floats. (Can only hold " +
                (getFormat().getSize() / nativeFloatSize()) + " floats).");
        } else if (!setNativeFloats(floats)) {
            throw new RuntimeException("Could not set int values for native frame!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.116 -0400", hash_original_method = "F38445E68345BDD4134E3B6940927EF8", hash_generated_method = "278036F2684E5865201B43C1A8424302")
    
@Override
    public float[] getFloats() {
        return getNativeFloats(getFormat().getSize());
    }

    // TODO: This function may be a bit confusing: Is the offset the target or source offset? Maybe
    // we should allow specifying both? (May be difficult for other frame types).
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.118 -0400", hash_original_method = "42CD1F45A1DE9B2F6E9A67E0ED677A7D", hash_generated_method = "F6EC3DA3C8669861B74C3C519B0DAD0A")
    
@Override
    public void setData(ByteBuffer buffer, int offset, int length) {
        assertFrameMutable();
        byte[] bytes = buffer.array();
        if ((length + offset) > buffer.limit()) {
            throw new RuntimeException("Offset and length exceed buffer size in native setData: " +
                                       (length + offset) + " bytes given, but only " + buffer.limit() +
                                       " bytes available!");
        } else if (getFormat().getSize() != length) {
            throw new RuntimeException("Data size in setData does not match native frame size: " +
                                       "Frame size is " + getFormat().getSize() + " bytes, but " +
                                       length + " bytes given!");
        } else if (!setNativeData(bytes, offset, length)) {
            throw new RuntimeException("Could not set native frame data!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.120 -0400", hash_original_method = "2414C66C4462F069E63625E82BFE928C", hash_generated_method = "C0DBB3FAC4D130AC7B68FE03A6A3509A")
    
@Override
    public ByteBuffer getData() {
        byte[] data = getNativeData(getFormat().getSize());
        return data == null ? null : ByteBuffer.wrap(data);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.123 -0400", hash_original_method = "44672EC5847C30C960BD69754C720945", hash_generated_method = "B6A856B09AF28DD601E2C7FE5640FD67")
    
@Override
    public void setBitmap(Bitmap bitmap) {
        assertFrameMutable();
        if (getFormat().getNumberOfDimensions() != 2) {
            throw new RuntimeException("Attempting to set Bitmap for non 2-dimensional native frame!");
        } else if (getFormat().getWidth()  != bitmap.getWidth() ||
                   getFormat().getHeight() != bitmap.getHeight()) {
            throw new RuntimeException("Bitmap dimensions do not match native frame dimensions!");
        } else {
            Bitmap rgbaBitmap = convertBitmapToRGBA(bitmap);
            int byteCount = rgbaBitmap.getByteCount();
            int bps = getFormat().getBytesPerSample();
            if (!setNativeBitmap(rgbaBitmap, byteCount, bps)) {
                throw new RuntimeException("Could not set native frame bitmap data!");
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.125 -0400", hash_original_method = "6612E7AA4A405C34245965DBAA979924", hash_generated_method = "C8EF3CE7FC3A7B3B7DEE3B9C9AEDF86A")
    
@Override
    public Bitmap getBitmap() {
        if (getFormat().getNumberOfDimensions() != 2) {
            throw new RuntimeException("Attempting to get Bitmap for non 2-dimensional native frame!");
        }
        Bitmap result = Bitmap.createBitmap(getFormat().getWidth(),
                                            getFormat().getHeight(),
                                            Bitmap.Config.ARGB_8888);
        int byteCount = result.getByteCount();
        int bps = getFormat().getBytesPerSample();
        if (!getNativeBitmap(result, byteCount, bps)) {
            throw new RuntimeException("Could not get bitmap data from native frame!");
        }
        return result;
    }

    static {
        System.loadLibrary("filterfw");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.127 -0400", hash_original_method = "8147036A7D3025CFA1B98BFF0675D9D5", hash_generated_method = "0E80344340B63CFB418776A43E99FA9B")
    
@Override
    public void setDataFromFrame(Frame frame) {
        // Make sure frame fits
        if (getFormat().getSize() < frame.getFormat().getSize()) {
            throw new RuntimeException(
                "Attempting to assign frame of size " + frame.getFormat().getSize() + " to " +
                "smaller native frame of size " + getFormat().getSize() + "!");
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.129 -0400", hash_original_method = "7D259F6ED311AC277649D1831CCCEE81", hash_generated_method = "BF26D0FA97BCC202F01F4485A4626E55")
    
@Override
    public String toString() {
        return "NativeFrame id: " + nativeFrameId + " (" + getFormat() + ") of size "
            + getCapacity();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:21.772 -0400", hash_original_method = "AA73B859EB1DD0BA58B4749B54F4BF0B", hash_generated_method = "4B6951FBE4F3A2C3A209B4285461611C")
    
    private boolean nativeAllocate(int capacity){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += capacity;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:43.873 -0400", hash_original_method = "C5D13A7D2DE40061D17A5A19349F9B46", hash_generated_method = "B240A7932BE0CB51D42FA1BDE6059C94")
    
    private boolean nativeDeallocate(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:43.875 -0400", hash_original_method = "6E986F427644A4A64ED0D6D91162CD0A", hash_generated_method = "B7282686DF017C5D81B8D25AAFBB9DEA")
    
    private int getNativeCapacity(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:21.792 -0400", hash_original_method = "B008EA5EAE1D78CF60323223B23112C0", hash_generated_method = "DB9D3915DCF330A7854A0E564C5106A0")
    
    private boolean setNativeData(byte[] data, int offset, int length){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += data[0];
    	taintDouble += offset;
    	taintDouble += length;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:21.797 -0400", hash_original_method = "03500FE5AEE71C3399A63C4DE8259AEF", hash_generated_method = "60B3C2D31D78E3E59BB43C3DF26365DA")
    
    private byte[] getNativeData(int byteCount){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += byteCount;
    	addTaint(taintDouble);
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:21.801 -0400", hash_original_method = "F3F264889FDB16D180CEE0E15F75E036", hash_generated_method = "4F865C42B7B55FCB7A3208A21FFDDAB5")
    
    private boolean getNativeBuffer(NativeBuffer buffer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += buffer.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:21.805 -0400", hash_original_method = "2047716A79A9E9406699C20C7A268A40", hash_generated_method = "431F2A0CB3A7814C0347AEEA4DA821C1")
    
    private boolean setNativeInts(int[] ints){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ints[0];
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:21.809 -0400", hash_original_method = "88CBED05920219A258C2F99CB4EDFE1D", hash_generated_method = "C0A8BCC26755F86A54824EBDD91E7B3C")
    
    private boolean setNativeFloats(float[] floats){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += floats[0];
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:21.813 -0400", hash_original_method = "E7AA6156590D219429B51E7417E59CD9", hash_generated_method = "1CECC7BC57C6878D9A1AAB162A5740FB")
    
    private int[] getNativeInts(int byteCount){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += byteCount;
    	addTaint(taintDouble);
    
    	int[] retObj = new int[1]; 
    	retObj[0] = (int)taintDouble;
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:21.817 -0400", hash_original_method = "BC6503BE10B833615811B8340147E64B", hash_generated_method = "EC76D10E8DA40049D76250D7F7151BED")
    
    private float[] getNativeFloats(int byteCount){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += byteCount;
    	addTaint(taintDouble);
    
    	float[] retObj = new float[1]; 
    	retObj[0] = (float)taintDouble;
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:21.820 -0400", hash_original_method = "444D41F62ECA10E849BCBA44CA008654", hash_generated_method = "B814095AF6B226513FFDB877C213A061")
    
    private boolean setNativeBitmap(Bitmap bitmap, int size, int bytesPerSample){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += bitmap.getTaintInt();
    	taintDouble += size;
    	taintDouble += bytesPerSample;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:21.825 -0400", hash_original_method = "5A3058CD0FF689DA5F7D1CD0293664C5", hash_generated_method = "F215E199D97DA856D1A9E142C6830199")
    
    private boolean getNativeBitmap(Bitmap bitmap, int size, int bytesPerSample){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += bitmap.getTaintInt();
    	taintDouble += size;
    	taintDouble += bytesPerSample;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:21.829 -0400", hash_original_method = "4AAA1963F74E551C88426B820B381324", hash_generated_method = "D98ADAE63A177915B45128E092AF964A")
    
    private boolean nativeCopyFromNative(NativeFrame frame){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += frame.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:21.833 -0400", hash_original_method = "8EE5FFA3E1866792DC021D861E52C38E", hash_generated_method = "E181817671F3569D40046BA60CE0103A")
    
    private boolean nativeCopyFromGL(GLFrame frame){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += frame.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

}
