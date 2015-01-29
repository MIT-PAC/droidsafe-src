/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package java.lang;

/**
 * Thrown when the depth of the stack of the running program exceeds some
 * platform or VM specific limit. Typically, this will occur only
 * when a program becomes infinitely recursive, but it can also occur in
 * correctly written (but deeply recursive) programs.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class StackOverflowError extends VirtualMachineError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.924 -0400", hash_original_field = "C338C3690B687FCA8402EDF6A2238F4C", hash_generated_field = "639288CE0B696B9447350C59A0AAADEE")


    private static final long serialVersionUID = 8609175038441759607L;

    /**
     * Constructs a new {@code StackOverflowError} that includes the current
     * stack trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.925 -0400", hash_original_method = "E724144FCC97A8088927BBA0FADCA6CF", hash_generated_method = "3B422272FC7C9F2EE3472AEF3F50FD9B")
    
public StackOverflowError() {
    }

    /**
     * Constructs a new {@code StackOverflowError} with the current stack trace
     * and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.927 -0400", hash_original_method = "325AEC0325FCC23FC8B7E8F3D4E67D3F", hash_generated_method = "DECE900DCF78AEC80D8F3D5C239F7B39")
    
public StackOverflowError(String detailMessage) {
        super(detailMessage);
    }
}
