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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.filterfw.core;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.FrameManager;
import android.filterfw.core.NativeBuffer;
import android.filterfw.format.ObjectFormat;
import android.graphics.Bitmap;

import java.io.InputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;

/**
 * A frame that serializes any assigned values. Such a frame is used when passing data objects
 * between threads.
 *
 * @hide
 */
public class SerializedFrame extends Frame {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.983 -0400", hash_original_field = "8EC97808E48B9F8E052891FA5FA09306", hash_generated_field = "60E59657B0EEC878CE1BE39BDE515A74")

    private final static int INITIAL_CAPACITY = 64;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.036 -0400", hash_original_method = "5C1C3B66ED41371C627891388E502BB9", hash_generated_method = "4427A1D2FFB9AFA32EF0121E2C0F5706")
    
static SerializedFrame wrapObject(Object object, FrameManager frameManager) {
        FrameFormat format = ObjectFormat.fromObject(object, FrameFormat.TARGET_SIMPLE);
        SerializedFrame result = new SerializedFrame(format, frameManager);
        result.setObjectValue(object);
        return result;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.984 -0400", hash_original_field = "D0573A2589016E0372BE002539575F5F", hash_generated_field = "822287850642BC65EB8758EDB4F6A911")

    private DirectByteOutputStream mByteOutputStream;

    /**
     * An unsynchronized output stream that writes data to an accessible byte array. Callers are
     * responsible for synchronization. This is more efficient than a ByteArrayOutputStream, as
     * there are no array copies or synchronization involved to read back written data.
     */
    private class DirectByteOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.989 -0400", hash_original_field = "DEE8E18A45C3C4B8FE2443C5C8AA1387", hash_generated_field = "88C64132CBBD67723A6270A7D8C4F17D")

        private byte[] mBuffer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.991 -0400", hash_original_field = "9903C734D96A80C6871FB08938C010EE", hash_generated_field = "435D9FD8F79260F74ED3D88EC0019701")

        private int mOffset = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.993 -0400", hash_original_field = "07D4E7B7E0E63376258D096CE4050A08", hash_generated_field = "B533118801D51047439FAE1166440063")

        private int mDataOffset = 0;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.995 -0400", hash_original_method = "1715A4BBD84E1640B55F154B8AC4E99F", hash_generated_method = "FF7BF4D152EB22231D615DFAD28B9856")
        
public DirectByteOutputStream(int size) {
            mBuffer = new byte[size];
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.998 -0400", hash_original_method = "5E1E3C493B1061D93C5713EE2428743A", hash_generated_method = "9365ABE6D9DB98D8D931A9C0EFA1B1DE")
        
private final void ensureFit(int bytesToWrite) {
            if (mOffset + bytesToWrite > mBuffer.length) {
                byte[] oldBuffer = mBuffer;
                mBuffer = new byte[Math.max(mOffset + bytesToWrite, mBuffer.length * 2)];
                System.arraycopy(oldBuffer, 0, mBuffer, 0, mOffset);
                oldBuffer = null;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.000 -0400", hash_original_method = "96075BB7E2051B1FA53AC8656FFDE8BB", hash_generated_method = "28A7F0137FE087012A18ABB6A8110149")
        
public final void markHeaderEnd() {
            mDataOffset = mOffset;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.002 -0400", hash_original_method = "0E056856D77251C83BB83A542DE9CBF6", hash_generated_method = "68D64AB3F806946E7799757013C217DE")
        
public final int getSize() {
            return mOffset;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.003 -0400", hash_original_method = "9E1E047142C0B7E59EF2577A0EA067EB", hash_generated_method = "D823E60C270A858B156DA6E1869BE052")
        
public byte[] getByteArray() {
            return mBuffer;
        }

        @DSSink({DSSinkKind.IO})
        @DSSpec(DSCat.IO)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.005 -0400", hash_original_method = "B228956CEBE6E6F7872DECB70885785F", hash_generated_method = "AF5984771EADB9195837870C94498325")
        
@Override
        public final void write(byte b[]) {
            write(b, 0, b.length);
        }

        @DSSink({DSSinkKind.IO})
        @DSSpec(DSCat.IO)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.007 -0400", hash_original_method = "1970A77777E486F92FE8F5191DC5F71E", hash_generated_method = "62E11B54C40056E20ABCDEE3FA88733F")
        
@Override
        public final void write(byte b[], int off, int len) {
            ensureFit(len);
            System.arraycopy(b, off, mBuffer, mOffset, len);
            mOffset += len;
        }

        @DSSink({DSSinkKind.IO})
        @DSSpec(DSCat.IO)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.009 -0400", hash_original_method = "E8BCE52F682A74DB971811628682A338", hash_generated_method = "2112BD4FB2BB736357E81C1901E22034")
        
@Override
        public final void write(int b) {
            ensureFit(1);
            mBuffer[mOffset++] = (byte)b;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.011 -0400", hash_original_method = "3FFA2CCD721E9EA9073CC80CB0D0CB04", hash_generated_method = "35D0DF15B52B8A75BD66D23D034B3AFC")
        
public final void reset() {
            mOffset = mDataOffset;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.013 -0400", hash_original_method = "427B12BEF7F3C4C4B069FEAFA67E6D6D", hash_generated_method = "E3B646844C4ABC670C3033C2B797B79A")
        
public final DirectByteInputStream getInputStream() {
            return new DirectByteInputStream(mBuffer, mOffset);
        }
    }

    /**
     * An unsynchronized input stream that reads data directly from a provided byte array. Callers
     * are responsible for synchronization and ensuring that the byte buffer is valid.
     */
    private class DirectByteInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.017 -0400", hash_original_field = "2CD4551D9C8A0105C8859C776CE5F7D1", hash_generated_field = "7E4499A9327E01BE29FA9A3BC04544AA")

        private byte[] mBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.019 -0400", hash_original_field = "332F7E50CDB1E660983C39BBE7FE470C", hash_generated_field = "ACEA92DCB8EDA7B954270B3D7BE26A3F")

        private int mPos = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.020 -0400", hash_original_field = "205262C28D2B190751535A4911B3B259", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

        private int mSize;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.022 -0400", hash_original_method = "7EB1074DF302D28F484AA000E89594E6", hash_generated_method = "394926471177FFA4987A23D89DC4A1E8")
        
public DirectByteInputStream(byte[] buffer, int size) {
            mBuffer = buffer;
            mSize = size;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.024 -0400", hash_original_method = "C9249F8BCD99085B4D3C5E6C4F37C94B", hash_generated_method = "AF93293A660BBE7E73917919D896EF7A")
        
@Override
        public final int available() {
            return mSize - mPos;
        }

        @DSSource({DSSourceKind.IO})
        @DSSpec(DSCat.IO)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.026 -0400", hash_original_method = "85AFEDD2D5FA019C7D10275E66B7A151", hash_generated_method = "6F4DA5ED0B942B92D8836C28D2E3B2C6")
        
@Override
        public final int read() {
            return (mPos < mSize) ? (mBuffer[mPos++] & 0xFF) : -1;
        }

        @DSSpec(DSCat.IO)
        @DSSource({DSSourceKind.IO})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.028 -0400", hash_original_method = "FBF6731E0A4F6CEDD1A0D34FF5D96061", hash_generated_method = "038E22C5EF7FC4D41B6E7E80D911CA5B")
        
@Override
        public final int read(byte[] b, int off, int len) {
            if (mPos >= mSize) {
                return -1;
            }
            if ((mPos + len) > mSize) {
                len = mSize - mPos;
            }
            System.arraycopy(mBuffer, mPos, b, off, len);
            mPos += len;
            return len;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.030 -0400", hash_original_method = "D623F3DF6ACE30929C5079D9FAB6E06D", hash_generated_method = "48FF210CB9BA14CAB7D6A206A24D8EA8")
        
@Override
        public final long skip(long n) {
            if ((mPos + n) > mSize) {
                n = mSize - mPos;
            }
            if (n < 0) {
                return 0;
            }
            mPos += n;
            return n;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.986 -0400", hash_original_field = "64D2B7ECF42C3961308E26C0FE83FD53", hash_generated_field = "7699D4CE9FCB5C2FED8F93A3C48B436F")

    private ObjectOutputStream mObjectOut;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.033 -0400", hash_original_method = "8F238402255EF85CDE844ACF86F48073", hash_generated_method = "139374037723A88ADAF83C88BDFC13D8")
    
SerializedFrame(FrameFormat format, FrameManager frameManager) {
        super(format, frameManager);
        setReusable(false);

        // Setup streams
        try {
            mByteOutputStream = new DirectByteOutputStream(INITIAL_CAPACITY);
            mObjectOut = new ObjectOutputStream(mByteOutputStream);
            mByteOutputStream.markHeaderEnd();
        } catch (IOException e) {
            throw new RuntimeException("Could not create serialization streams for "
                + "SerializedFrame!", e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.037 -0400", hash_original_method = "AA7A1CEF8770EBF16ED3B257C02CD048", hash_generated_method = "15775F577B03ABFE7632C4FD44B0F914")
    
@Override
    protected boolean hasNativeAllocation() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.039 -0400", hash_original_method = "361DF9CA8C404301F3386F490617DC7A", hash_generated_method = "AEB54743AF9F99FB6487E555E20EC2D7")
    
@Override
    protected void releaseNativeAllocation() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.041 -0400", hash_original_method = "4270C542CCC99C72CFEE9F086A305BD3", hash_generated_method = "6E1EC3D414C47EEECA61562E36E8492A")
    
@Override
    public Object getObjectValue() {
        return deserializeObjectValue();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.043 -0400", hash_original_method = "1F2AF9E07BC3BA64312F66200D59CD9E", hash_generated_method = "768DF23BF6845F4140AEAF240A8E6D20")
    
@Override
    public void setInts(int[] ints) {
        assertFrameMutable();
        setGenericObjectValue(ints);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.045 -0400", hash_original_method = "6298B193884F5430CE5013515553A879", hash_generated_method = "B8A566E4A12FA369AAEF9CC5FDFF5AC4")
    
@Override
    public int[] getInts() {
        Object result = deserializeObjectValue();
        return (result instanceof int[]) ? (int[])result : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.047 -0400", hash_original_method = "46C81782963E806F2C8A233C3AC78CD1", hash_generated_method = "E4E31813BF303A8569E6D7CF82F8853F")
    
@Override
    public void setFloats(float[] floats) {
        assertFrameMutable();
        setGenericObjectValue(floats);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.048 -0400", hash_original_method = "621EE4738BAED41D239CF9E490EF97F2", hash_generated_method = "49AE461348789F26392BE838C7D50410")
    
@Override
    public float[] getFloats() {
        Object result = deserializeObjectValue();
        return (result instanceof float[]) ? (float[])result : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.050 -0400", hash_original_method = "B863A6081E495D53D637CFA45EBD78C1", hash_generated_method = "D41929442C55531288E26A5238F1CAEA")
    
@Override
    public void setData(ByteBuffer buffer, int offset, int length) {
        assertFrameMutable();
        setGenericObjectValue(ByteBuffer.wrap(buffer.array(), offset, length));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.052 -0400", hash_original_method = "C089EBA1D9FC16B5BEE04A93B4579559", hash_generated_method = "21C653194D981FAD905A1129826C65AB")
    
@Override
    public ByteBuffer getData() {
        Object result = deserializeObjectValue();
        return (result instanceof ByteBuffer) ? (ByteBuffer)result : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.054 -0400", hash_original_method = "66809907C47AFB4BE41D32952A3C92BA", hash_generated_method = "E165E6AC71EFC7BF3F4180B4C0A4C362")
    
@Override
    public void setBitmap(Bitmap bitmap) {
        assertFrameMutable();
        setGenericObjectValue(bitmap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.056 -0400", hash_original_method = "11837FD71470AAB083A5C7DECBF8858B", hash_generated_method = "7E43D9A045DAB8266B618EF4F17A3472")
    
@Override
    public Bitmap getBitmap() {
        Object result = deserializeObjectValue();
        return (result instanceof Bitmap) ? (Bitmap)result : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.058 -0400", hash_original_method = "DF934ECF47982AE2398622B61233DC3D", hash_generated_method = "7C78B518882F6D93FED01B1E2F83FC8D")
    
@Override
    protected void setGenericObjectValue(Object object) {
        serializeObjectValue(object);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.060 -0400", hash_original_method = "5F2B9FEA48E4531096F71EE31DAB1EA9", hash_generated_method = "28407AFFBA71A9AA2DC537F9280134C2")
    
private final void serializeObjectValue(Object object) {
        try {
            mByteOutputStream.reset();
            mObjectOut.writeObject(object);
            mObjectOut.flush();
            mObjectOut.close();
        } catch (IOException e) {
            throw new RuntimeException("Could not serialize object " + object + " in "
                + this + "!", e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.063 -0400", hash_original_method = "AA5396B0A418FE38115FE678EA4127A5", hash_generated_method = "C2EE25D13163A873132148F23F83BE4C")
    
private final Object deserializeObjectValue() {
        try {
            InputStream inputStream = mByteOutputStream.getInputStream();
            ObjectInputStream objectStream = new ObjectInputStream(inputStream);
            return objectStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException("Could not deserialize object in " + this + "!", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to deserialize object of unknown class in "
                + this + "!", e);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.065 -0400", hash_original_method = "AD26C151572176ABEC94AF55A0489FC8", hash_generated_method = "0B146BFD345A2D6F82E00D5AF945E82D")
    
@Override
    public String toString() {
        return "SerializedFrame (" + getFormat() + ")";
    }
}
