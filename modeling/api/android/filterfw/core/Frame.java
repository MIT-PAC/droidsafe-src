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
import android.filterfw.core.FrameFormat;
import android.filterfw.core.FrameManager;
import android.graphics.Bitmap;
import android.util.Log;

import java.nio.ByteBuffer;

/**
 * @hide
 */
public abstract class Frame {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.476 -0400", hash_original_field = "0CE577A62E890921084E03319F5AD3E0", hash_generated_field = "2414B071581985C3BD5863F64C14FD8D")


    public final static int NO_BINDING = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.479 -0400", hash_original_field = "ACEC48F0141B9005C8DA47D4F7B55C0E", hash_generated_field = "3441EE0E7350588B4600B43CCFBF7890")


    public final static long TIMESTAMP_NOT_SET = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.481 -0400", hash_original_field = "B58E4BFDB4092ADF2FA66FA50265D960", hash_generated_field = "1ED8F922ED7BBED1D0A0CD8EDA08636E")

    public final static long TIMESTAMP_UNKNOWN = -1;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.565 -0400", hash_original_method = "16B0FC17435C6802FBF124720EE3D2FB", hash_generated_method = "F00FD6029DD3497ACF5256A0223DFFC4")
    
protected static Bitmap convertBitmapToRGBA(Bitmap bitmap) {
        if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            return bitmap;
        } else {
            Bitmap result = bitmap.copy(Bitmap.Config.ARGB_8888, false);
            if (result == null) {
                throw new RuntimeException("Error converting bitmap to RGBA!");
            } else if (result.getRowBytes() != result.getWidth() * 4) {
                throw new RuntimeException("Unsupported row byte count in bitmap!");
            }
            return result;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.483 -0400", hash_original_field = "47613899F4726DA2692D997866DE4B3B", hash_generated_field = "122336F45266DAA89766930859DCF601")


    private FrameFormat mFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.485 -0400", hash_original_field = "B8CC72B24B18473F023C29A9BDF429C7", hash_generated_field = "C503D857955730749FB93FDC628FD774")

    private FrameManager mFrameManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.487 -0400", hash_original_field = "ABCCC63D012081F7B7593E7250A64458", hash_generated_field = "F3BFD03C4448FEEBB395F93A91DEFDEF")

    private boolean mReadOnly = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.490 -0400", hash_original_field = "27A9AD0F0721AEFDE775DBF67BE60FB0", hash_generated_field = "61C64A9F431E846E40E19FE1B24FD7FA")

    private boolean mReusable = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.492 -0400", hash_original_field = "5E75406CC6A7CE5E4451339FE88A3205", hash_generated_field = "C766A1E7B558DC67EE2FA8C43E3C2E49")

    private int mRefCount = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.494 -0400", hash_original_field = "35A613F6D9E6912B3EA3CB2F22DDE514", hash_generated_field = "8152C34B811720DF3EC37CF0F396D5EB")

    private int mBindingType = NO_BINDING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.496 -0400", hash_original_field = "E15AFC3ABA2E9BA5364EDEB28B3C9FE2", hash_generated_field = "97E8917987071B66245D56821CFC25C0")

    private long mBindingId = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.498 -0400", hash_original_field = "B56BF1B8655B4D9F489E724BEF79F9AE", hash_generated_field = "0004ED5D83DB813D55BEEC9197FABDDD")

    private long mTimestamp = TIMESTAMP_NOT_SET;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.500 -0400", hash_original_method = "0F0167FDC611058DAAC724C24C31D7E3", hash_generated_method = "0F0167FDC611058DAAC724C24C31D7E3")
    
Frame(FrameFormat format, FrameManager frameManager) {
        mFormat = format.mutableCopy();
        mFrameManager = frameManager;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.502 -0400", hash_original_method = "FBD84BB0C928A79C8F93DCAE453182DB", hash_generated_method = "FBD84BB0C928A79C8F93DCAE453182DB")
    
Frame(FrameFormat format, FrameManager frameManager, int bindingType, long bindingId) {
        mFormat = format.mutableCopy();
        mFrameManager = frameManager;
        mBindingType = bindingType;
        mBindingId = bindingId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.504 -0400", hash_original_method = "BA3891086B2787CE76466EADCCE3FE15", hash_generated_method = "D8475F840CA237576564BB3A9AE00AA6")
    
public FrameFormat getFormat() {
        return mFormat;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.507 -0400", hash_original_method = "4EC882CF8B439451D4DA99E69ED6B476", hash_generated_method = "D3FE312EFFE96A894DF7024271A9A72D")
    
public int getCapacity() {
        return getFormat().getSize();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.509 -0400", hash_original_method = "254859347FBAF57B711D22D43B8EB686", hash_generated_method = "D8E43A1F3C8B978BD3FBD15661C5CA5A")
    
public boolean isReadOnly() {
        return mReadOnly;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.510 -0400", hash_original_method = "50917170DE74728E16AA015A171EA968", hash_generated_method = "9E5DBF4582F094A3052D955B9847EE4E")
    
public int getBindingType() {
        return mBindingType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.512 -0400", hash_original_method = "98B51ADDA2FA670858F01B46B0EEC414", hash_generated_method = "950AD9DFC1CE0E5A8E2C1C34F438F744")
    
public long getBindingId() {
        return mBindingId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.515 -0400", hash_original_method = "A7925AB700381A7C710E1E1025A80D9B", hash_generated_method = "01B6532A29EC757FA83F65D6E49AE1F5")
    
public void setObjectValue(Object object) {
        assertFrameMutable();

        // Attempt to set the value using a specific setter (which may be more optimized), and
        // fall back to the setGenericObjectValue(...) in case of no match.
        if (object instanceof int[]) {
            setInts((int[])object);
        } else if (object instanceof float[]) {
            setFloats((float[])object);
        } else if (object instanceof ByteBuffer) {
            setData((ByteBuffer)object);
        } else if (object instanceof Bitmap) {
            setBitmap((Bitmap)object);
        } else {
            setGenericObjectValue(object);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.517 -0400", hash_original_method = "A6C2DC0F141C7F63213F5193D043109F", hash_generated_method = "7BA852FE030CFE7F235900FF3D2714F7")
    
public abstract Object getObjectValue();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.519 -0400", hash_original_method = "7E6A0E75F480036EED7A5C4525F0C5B6", hash_generated_method = "A4C8A0A199F7EBAF238F3765DF3A839F")
    
public abstract void setInts(int[] ints);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.521 -0400", hash_original_method = "79512FDE211A35AE659A0845166F3617", hash_generated_method = "29D68DB14BC125B508B9D7D51262BE94")
    
public abstract int[] getInts();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.523 -0400", hash_original_method = "BB543FC7380F4C62A3EBEC856D72B280", hash_generated_method = "8581128B47D7577AA6249A52A7AD6606")
    
public abstract void setFloats(float[] floats);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.526 -0400", hash_original_method = "80BC85A4D4081A3EB491398F5712092E", hash_generated_method = "8D4368CBB88D26FEADF1F30E67360C7A")
    
public abstract float[] getFloats();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.528 -0400", hash_original_method = "3DE1918A53B9CF8B1485BAA9CDC3BD82", hash_generated_method = "E68A531B1235837AFF1D6BD4D65B5577")
    
public abstract void setData(ByteBuffer buffer, int offset, int length);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.530 -0400", hash_original_method = "3BD2FBDBADDA4E8764E9F36FC40732B1", hash_generated_method = "18468462572E291A8F6088CE0FB4CB64")
    
public void setData(ByteBuffer buffer) {
        setData(buffer, 0, buffer.limit());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.532 -0400", hash_original_method = "B5B8FDE4C9F75757B8C54CAC4D797F74", hash_generated_method = "1ECC3E028D8D8D180022F5C8F1888B8F")
    
public void setData(byte[] bytes, int offset, int length) {
        setData(ByteBuffer.wrap(bytes, offset, length));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.534 -0400", hash_original_method = "420170F50ECC9FDAADCA644C233F1C45", hash_generated_method = "294CFD12B41298D9C8B82C71444423CD")
    
public abstract ByteBuffer getData();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.537 -0400", hash_original_method = "9E03326A3A0B15947D6AF3DC38EEE389", hash_generated_method = "11A86CC23B3AA1FA10AD7A68D3EE1932")
    
public abstract void setBitmap(Bitmap bitmap);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.539 -0400", hash_original_method = "D026D0F9A7F45FD50F112D5710CB3A3A", hash_generated_method = "48B6B074C458A514AC07D76D81FEF149")
    
public abstract Bitmap getBitmap();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.541 -0400", hash_original_method = "A9A428F6B036809115B0F9E566E40DC5", hash_generated_method = "C2D16CB91898BAEA08C8212D9E3E639F")
    
public void setTimestamp(long timestamp) {
        mTimestamp = timestamp;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.542 -0400", hash_original_method = "11082DE613964068E41309D739E63A42", hash_generated_method = "64E1BA0FD4A55656D36D40A620E67AC6")
    
public long getTimestamp() {
        return mTimestamp;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.544 -0400", hash_original_method = "A7BBE821D24D3DC0F9A5F8B9AE751D18", hash_generated_method = "691823ED70D232DDBB5E5B4DD245506B")
    
public void setDataFromFrame(Frame frame) {
        setData(frame.getData());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.547 -0400", hash_original_method = "914804ABEE5C3400F9C0352FC9B9C96B", hash_generated_method = "78B200ABD02F7E9E6EE3A587088A3B54")
    
protected boolean requestResize(int[] newDimensions) {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.549 -0400", hash_original_method = "9A86C6A9475093CFFBF09A1BCA6091B5", hash_generated_method = "8F8FC8D03FDAD9D8C5AE6DB5253718BE")
    
public int getRefCount() {
        return mRefCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.551 -0400", hash_original_method = "30E6CE4F10245D7DF54E3E66BCA82B90", hash_generated_method = "49C0B18DE54DC76E96EBE7AFC7948A3B")
    
public Frame release() {
        if (mFrameManager != null) {
            return mFrameManager.releaseFrame(this);
        } else {
            return this;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.553 -0400", hash_original_method = "7C0486A431D97AE8FCF3E324A0587807", hash_generated_method = "9646F6F87A195F71A1E99459A3F36530")
    
public Frame retain() {
        if (mFrameManager != null) {
            return mFrameManager.retainFrame(this);
        } else {
            return this;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.555 -0400", hash_original_method = "024F6C42080009D872E56D16574B421D", hash_generated_method = "4951949AE77EC31CC5D9DF7211264CCC")
    
public FrameManager getFrameManager() {
        return mFrameManager;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.557 -0400", hash_original_method = "3268DB234D38FDAD25BBE8EA085EF2A3", hash_generated_method = "7624263335F8C17342598A55DCB6D518")
    
protected void assertFrameMutable() {
        if (isReadOnly()) {
            throw new RuntimeException("Attempting to modify read-only frame!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.559 -0400", hash_original_method = "5960986B3315BB5EB1BAB49C48DC6116", hash_generated_method = "6861912A0E6C10070B0BAE66CD92EF95")
    
protected void setReusable(boolean reusable) {
        mReusable = reusable;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.561 -0400", hash_original_method = "764B46A472996B127187DEB2333C3102", hash_generated_method = "98D548B2AF13C5E5F7542C09E661E752")
    
protected void setFormat(FrameFormat format) {
        mFormat = format.mutableCopy();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.563 -0400", hash_original_method = "BF0300BAB96045762CFEAF270CEB4729", hash_generated_method = "0C41B6E9DA935850EDBCCF3A1944F3B0")
    
protected void setGenericObjectValue(Object value) {
        throw new RuntimeException(
            "Cannot set object value of unsupported type: " + value.getClass());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.567 -0400", hash_original_method = "11E87EB8AB6097BC6D12633C59B4DE74", hash_generated_method = "B4DB740F56B4EDEEE1467F54498AE42F")
    
protected void reset(FrameFormat newFormat) {
        mFormat = newFormat.mutableCopy();
        mReadOnly = false;
        mRefCount = 1;
    }

    /**
     * Called just before a frame is stored, such as when storing to a cache or context.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.570 -0400", hash_original_method = "61C700BCA0060F16D4763315240A3D71", hash_generated_method = "F003EAA33D9BC9AA190A6EBA39288594")
    
protected void onFrameStore() {
    }

    /**
     * Called when a frame is fetched from an internal store such as a cache.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.573 -0400", hash_original_method = "E8DBEAA06A7DAB709AECC6A34E3FE6ED", hash_generated_method = "E6FFFFE578157B6C7D0647FEAA3512FA")
    
protected void onFrameFetch() {
    }

    // Core internal methods ///////////////////////////////////////////////////////////////////////
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.575 -0400", hash_original_method = "7487F55F461659B34ABB53AF9753A3D7", hash_generated_method = "19C1F3FC54885C78CF1E4F569A121DC7")
    
protected abstract boolean hasNativeAllocation();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.577 -0400", hash_original_method = "19BE86AF0AB5C38A68E04FDBA9EDE638", hash_generated_method = "2956EDA71ED6BD859B4C4CE47FCD28F3")
    
protected abstract void releaseNativeAllocation();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.579 -0400", hash_original_method = "48B0902223A575ABA3719719EF40B7A9", hash_generated_method = "7C7AD0B4FFC0522D46F21E30B0732155")
    
final int incRefCount() {
        ++mRefCount;
        return mRefCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.581 -0400", hash_original_method = "5C01403A5A5FD23F9C3A660D113681F0", hash_generated_method = "EC05B53AF99A915BC55948E6C447B928")
    
final int decRefCount() {
        --mRefCount;
        return mRefCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.583 -0400", hash_original_method = "8725B3A639D63C24BA380C8D973D732C", hash_generated_method = "2DE89B54DF40E2D2D86F2C716F90CB88")
    
final boolean isReusable() {
        return mReusable;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.585 -0400", hash_original_method = "99C356404FEEC56B867B16042E10CFFB", hash_generated_method = "186E3DF526018CA2BAB0B2DE71B05137")
    
final void markReadOnly() {
        mReadOnly = true;
    }

}
