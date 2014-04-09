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
import android.filterfw.core.NativeBuffer;
import android.filterfw.format.ObjectFormat;
import android.graphics.Bitmap;

import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;

/**
 * @hide
 */
public class SimpleFrame extends Frame {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.491 -0400", hash_original_method = "006613291F06341479269D0E30ECC2BE", hash_generated_method = "C3C2A6D1783CD9A561F25316CD5EC8F8")
    
static SimpleFrame wrapObject(Object object, FrameManager frameManager) {
        FrameFormat format = ObjectFormat.fromObject(object, FrameFormat.TARGET_SIMPLE);
        SimpleFrame result = new SimpleFrame(format, frameManager);
        result.setObjectValue(object);
        return result;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.488 -0400", hash_original_field = "63EB2904DE14485FE87749A3C0F578EC", hash_generated_field = "6BF312E710A9A51FE4A328DC181764B4")


    private Object mObject;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.490 -0400", hash_original_method = "80D1862913EDC7FF5878DF46C6F9E84F", hash_generated_method = "80D1862913EDC7FF5878DF46C6F9E84F")
    
SimpleFrame(FrameFormat format, FrameManager frameManager) {
        super(format, frameManager);
        initWithFormat(format);
        setReusable(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.494 -0400", hash_original_method = "772528AFF285A5D45BCB58C068C200C2", hash_generated_method = "9BD1DAC0E77EB5EA5DF1C632D3DA062D")
    
private void initWithFormat(FrameFormat format) {
        final int count = format.getLength();
        final int baseType = format.getBaseType();
        switch (baseType) {
            case FrameFormat.TYPE_BYTE:
                mObject = new byte[count];
                break;
            case FrameFormat.TYPE_INT16:
                mObject = new short[count];
                break;
            case FrameFormat.TYPE_INT32:
                mObject = new int[count];
                break;
            case FrameFormat.TYPE_FLOAT:
                mObject = new float[count];
                break;
            case FrameFormat.TYPE_DOUBLE:
                mObject = new double[count];
                break;
            default:
                mObject = null;
                break;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.496 -0400", hash_original_method = "AA7A1CEF8770EBF16ED3B257C02CD048", hash_generated_method = "15775F577B03ABFE7632C4FD44B0F914")
    
@Override
    protected boolean hasNativeAllocation() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.498 -0400", hash_original_method = "361DF9CA8C404301F3386F490617DC7A", hash_generated_method = "AEB54743AF9F99FB6487E555E20EC2D7")
    
@Override
    protected void releaseNativeAllocation() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.500 -0400", hash_original_method = "FE1D870979CB1C8E8DCC85533A4A95B1", hash_generated_method = "757A7E6A7C5E75CEE8DD6B50A86F9B87")
    
@Override
    public Object getObjectValue() {
        return mObject;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.502 -0400", hash_original_method = "1F2AF9E07BC3BA64312F66200D59CD9E", hash_generated_method = "768DF23BF6845F4140AEAF240A8E6D20")
    
@Override
    public void setInts(int[] ints) {
        assertFrameMutable();
        setGenericObjectValue(ints);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.504 -0400", hash_original_method = "D0C5A2A54A237F4A1FA24CA2A348D1F0", hash_generated_method = "AA8A61EB0BE03343169F8F288AB1AE11")
    
@Override
    public int[] getInts() {
        return (mObject instanceof int[]) ? (int[])mObject : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.505 -0400", hash_original_method = "46C81782963E806F2C8A233C3AC78CD1", hash_generated_method = "E4E31813BF303A8569E6D7CF82F8853F")
    
@Override
    public void setFloats(float[] floats) {
        assertFrameMutable();
        setGenericObjectValue(floats);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.507 -0400", hash_original_method = "8788D4A2B1053CA4CF2B1BE05175DBCA", hash_generated_method = "B04F18288DEF05EEFDDDBC77B953D2AC")
    
@Override
    public float[] getFloats() {
        return (mObject instanceof float[]) ? (float[])mObject : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.509 -0400", hash_original_method = "B863A6081E495D53D637CFA45EBD78C1", hash_generated_method = "D41929442C55531288E26A5238F1CAEA")
    
@Override
    public void setData(ByteBuffer buffer, int offset, int length) {
        assertFrameMutable();
        setGenericObjectValue(ByteBuffer.wrap(buffer.array(), offset, length));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.511 -0400", hash_original_method = "3396E542143727772099EFE3F5CF4B4A", hash_generated_method = "664CBD3565CA57728C64CED4475188DB")
    
@Override
    public ByteBuffer getData() {
        return (mObject instanceof ByteBuffer) ? (ByteBuffer)mObject : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.512 -0400", hash_original_method = "66809907C47AFB4BE41D32952A3C92BA", hash_generated_method = "E165E6AC71EFC7BF3F4180B4C0A4C362")
    
@Override
    public void setBitmap(Bitmap bitmap) {
        assertFrameMutable();
        setGenericObjectValue(bitmap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.515 -0400", hash_original_method = "9D5C2943721487B12CA036BCCFCA8AE0", hash_generated_method = "2915525A7803E88FA6D8E6B79E1439E8")
    
@Override
    public Bitmap getBitmap() {
        return (mObject instanceof Bitmap) ? (Bitmap)mObject : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.517 -0400", hash_original_method = "898113924986319201997B7F65076876", hash_generated_method = "DC8861831F68CBE0EE42DD8580A01013")
    
private void setFormatObjectClass(Class objectClass) {
        MutableFrameFormat format = getFormat().mutableCopy();
        format.setObjectClass(objectClass);
        setFormat(format);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.519 -0400", hash_original_method = "31853D8B87790660CC3A3D348F67BADA", hash_generated_method = "D0859AF76437E455C0E83A1C3707CF54")
    
@Override
    protected void setGenericObjectValue(Object object) {
        // Update the FrameFormat class
        // TODO: Take this out! FrameFormats should not be modified and convenience formats used
        // instead!
        FrameFormat format = getFormat();
        if (format.getObjectClass() == null) {
            setFormatObjectClass(object.getClass());
        } else if (!format.getObjectClass().isAssignableFrom(object.getClass())) {
            throw new RuntimeException(
                "Attempting to set object value of type '" + object.getClass() + "' on " +
                "SimpleFrame of type '" + format.getObjectClass() + "'!");
        }

        // Set the object value
        mObject = object;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.520 -0400", hash_original_method = "7AAB1E65A963EEB236959BFD051EB330", hash_generated_method = "BB2AD127E04AF74D13CA1105B7611FDD")
    
@Override
    public String toString() {
        return "SimpleFrame (" + getFormat() + ")";
    }
}
