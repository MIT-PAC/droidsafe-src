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
import java.lang.reflect.Field;

/**
 * @hide
 */
public class FieldPort extends InputPort {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.067 -0400", hash_original_field = "A36D1E69B2CF857FFEEB155335429AF7", hash_generated_field = "AB76CA4462ACCCB5B08E9DB087EA72D6")

    protected Field mField;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.070 -0400", hash_original_field = "DEF5D0FF79CE4A5A5264A7B73002A160", hash_generated_field = "7E0A00013DFCAB0285D79669049D27A5")

    protected boolean mHasFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.072 -0400", hash_original_field = "664036C77860218167DD8F9DF9EAF4E8", hash_generated_field = "CD31049108CD19D69B92DFBDD08E3C5D")

    protected boolean mValueWaiting = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.074 -0400", hash_original_field = "10C88B3F201F56410DE7B0BF9A3CF880", hash_generated_field = "17F8A55255DD1C4622B9A3D943E866FC")

    protected Object mValue;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.076 -0400", hash_original_method = "B9805B74BAF13C5590E629F16218042A", hash_generated_method = "1DFFC88AECC13823044420F2D4EF9195")
    
public FieldPort(Filter filter, String name, Field field, boolean hasDefault) {
        super(filter, name);
        mField = field;
        mHasFrame = hasDefault;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.079 -0400", hash_original_method = "CAFED8DEE3108243325B67F5797719ED", hash_generated_method = "7A99199C1ABE0F81A913135616B05EDA")
    
@Override
    public void clear() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.082 -0400", hash_original_method = "4358889C83551D7F89E28E8A5CE957D9", hash_generated_method = "A3A1DCC5A068A7698A3CAB50781A2D60")
    
@Override
    public void pushFrame(Frame frame) {
        setFieldFrame(frame, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.084 -0400", hash_original_method = "55C7452238BE5D386DD91B1A803B08CB", hash_generated_method = "D3EB5BAB93CABE1BFDA9F28BC64D9F02")
    
@Override
    public void setFrame(Frame frame) {
        setFieldFrame(frame, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.087 -0400", hash_original_method = "42BC554E2CC4922DEE7BEB9285A7E4D3", hash_generated_method = "2D9D324B574EB037884BF2CF8CD2A1EE")
    
@Override
    public Object getTarget() {
        try {
            return mField.get(mFilter);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.090 -0400", hash_original_method = "367AA9F46D0A61A3822BD1D9948663F2", hash_generated_method = "37CEEDB23250A22C7E5F30E916FAD637")
    
@Override
    public synchronized void transfer(FilterContext context) {
        if (mValueWaiting) {
            try {
                mField.set(mFilter, mValue);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(
                    "Access to field '" + mField.getName() + "' was denied!");
            }
            mValueWaiting = false;
            if (context != null) {
                mFilter.notifyFieldPortValueUpdated(mName, context);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.092 -0400", hash_original_method = "90C46603BC756C952F501C76E45FA81A", hash_generated_method = "1D052B00C292B1F9541C78ED94724AD4")
    
@Override
    public synchronized Frame pullFrame() {
        throw new RuntimeException("Cannot pull frame on " + this + "!");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.095 -0400", hash_original_method = "6A40DB23000F690AA5FDD65723CD2EFD", hash_generated_method = "C104160EEF62A810491A24AF7E891CDB")
    
@Override
    public synchronized boolean hasFrame() {
        return mHasFrame;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.097 -0400", hash_original_method = "627C360B54C067AB686033BDB46E0114", hash_generated_method = "9ECF77F0F8B1430BDAEA4B34E6B64B43")
    
@Override
    public synchronized boolean acceptsFrame() {
        return !mValueWaiting;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.099 -0400", hash_original_method = "8F5AB1DB6E193ADA622F024DB92EA254", hash_generated_method = "C1494A4CC838EDAB8DCD66A27890C08C")
    
@Override
    public String toString() {
        return "field " + super.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.102 -0400", hash_original_method = "2590F86D4A3C6E6B809E2383C9F1BFFF", hash_generated_method = "133DD75B6350F4E32BAF98EABD02181F")
    
protected synchronized void setFieldFrame(Frame frame, boolean isAssignment) {
        assertPortIsOpen();
        checkFrameType(frame, isAssignment);

        // Store the object value
        Object value = frame.getObjectValue();
        if ((value == null && mValue != null) || !value.equals(mValue)) {
            mValue = value;
            mValueWaiting = true;
        }

        // Since a frame was set, mark this port as having a frame to pull
        mHasFrame = true;
    }
}
