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
public class ProgramPort extends FieldPort {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.763 -0400", hash_original_field = "60062C9CB6406B5ABE6C6187173918AE", hash_generated_field = "004BCA2F9FED49D784C4F66ABF1E6784")


    protected String mVarName;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.766 -0400", hash_original_method = "2DCCD6C445542D26BA6D5A4867D90982", hash_generated_method = "112BF88800A66A5B046FE973E934D43B")
    
public ProgramPort(Filter filter,
                       String name,
                       String varName,
                       Field field,
                       boolean hasDefault) {
        super(filter, name, field, hasDefault);
        mVarName = varName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.767 -0400", hash_original_method = "96FF3D039B0272BA58AE8606D9E0EAE5", hash_generated_method = "7A5A7DFE808598ECE92E9A22BEC67827")
    
@Override
    public String toString() {
        return "Program " + super.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.769 -0400", hash_original_method = "50AEE7B4078791FE686F06B713B42E34", hash_generated_method = "3FFED005E5331CBF2056E016A210617E")
    
@Override
    public synchronized void transfer(FilterContext context) {
        if (mValueWaiting) {
            try {
                Object fieldValue = mField.get(mFilter);
                if (fieldValue != null) {
                    Program program = (Program)fieldValue;
                    program.setHostValue(mVarName, mValue);
                    mValueWaiting = false;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(
                    "Access to program field '" + mField.getName() + "' was denied!");
            } catch (ClassCastException e) {
                throw new RuntimeException("Non Program field '" + mField.getName()
                    + "' annotated with ProgramParameter!");
            }
        }
    }
}
