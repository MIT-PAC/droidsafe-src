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
public class FinalPort extends FieldPort {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.397 -0400", hash_original_method = "567FA3D5DF4E40C791FF7D6C35D9EC4F", hash_generated_method = "1D61FD1E7A6C7160FE64E8E5C7CB61DA")
    
public FinalPort(Filter filter, String name, Field field, boolean hasDefault) {
        super(filter, name, field, hasDefault);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.400 -0400", hash_original_method = "B4501B2B957C0E980CE4C60C3F36E06E", hash_generated_method = "395195003F7AE3F9B2C0D2547D333D62")
    
@Override
    protected synchronized void setFieldFrame(Frame frame, boolean isAssignment) {
        assertPortIsOpen();
        checkFrameType(frame, isAssignment);
        if (mFilter.getStatus() != Filter.STATUS_PREINIT) {
            throw new RuntimeException("Attempting to modify " + this + "!");
        } else {
            super.setFieldFrame(frame, isAssignment);
            super.transfer(null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.402 -0400", hash_original_method = "BD065C7A81FC907CB5959AE3DFBE0C0A", hash_generated_method = "02303035FB5835931524FD0E0B6D63B9")
    
@Override
    public String toString() {
        return "final " + super.toString();
    }

}
