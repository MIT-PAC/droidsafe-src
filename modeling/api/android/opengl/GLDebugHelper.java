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
 * Copyright (C) 2007 The Android Open Source Project
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


package android.opengl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Writer;

import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.opengles.GL;

public class GLDebugHelper {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.269 -0500", hash_original_method = "3FDF6703384D4E41EEF76E141F8C8728", hash_generated_method = "3D57EDEF1159FF57CAACEB711656CD59")
    
public static GL wrap(GL gl, int configFlags, Writer log) {
        if ( configFlags != 0 ) {
            gl = new GLErrorWrapper(gl, configFlags);
        }
        if ( log != null ) {
            boolean logArgumentNames =
                (CONFIG_LOG_ARGUMENT_NAMES & configFlags) != 0;
            gl = new GLLogWrapper(gl, log, logArgumentNames);
        }
        return gl;
    }

    /**
     * Wrap an existing EGL interface in a new EGL interface that adds
     * support for error checking and/or logging.
     * @param egl the existing GL interface. Must implement EGL and EGL10. May
     * optionally implement EGL11 as well.
     * @param configFlags A bitmask of error checking flags.
     * @param log - null to disable logging, non-null to enable logging.
     * @return the wrapped EGL interface.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.272 -0500", hash_original_method = "D2BFC1F98E74B177BF943E41A8084666", hash_generated_method = "C92E9FC3016310B3D6E79D111F411533")
    
public static EGL wrap(EGL egl, int configFlags, Writer log) {
        if (log != null) {
            egl = new EGLLogWrapper(egl, configFlags, log);
        }
        return egl;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.260 -0500", hash_original_field = "8634DC21B60A7745545626CDA1664051", hash_generated_field = "E70990D438E81EE44253E4CB5AF689BC")

    /**
     * Check glError() after every call.
     */
    public static final int CONFIG_CHECK_GL_ERROR = (1 << 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.262 -0500", hash_original_field = "644352C292F628EC2E877A7A4ADF5618", hash_generated_field = "EAA855F37701CDB86B5D8770295B9F3D")

    public static final int CONFIG_CHECK_THREAD = (1 << 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.265 -0500", hash_original_field = "6C641929EDD02D04D9DC523B089AC77B", hash_generated_field = "D09C1D12C10A5C76CA8C4E7F70BE1743")

    public static final int CONFIG_LOG_ARGUMENT_NAMES = (1 << 2);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.267 -0500", hash_original_field = "6C0CC966BC368FF8DACC1697EDF80353", hash_generated_field = "B10B5B91E743ADE3F0E13FBD502DB184")

    public static final int ERROR_WRONG_THREAD = 0x7000;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.927 -0400", hash_original_method = "E7190AE5B0A4A36A0341193EE8AF97D9", hash_generated_method = "E7190AE5B0A4A36A0341193EE8AF97D9")
    public GLDebugHelper ()
    {
        //Synthesized constructor
    }
}

