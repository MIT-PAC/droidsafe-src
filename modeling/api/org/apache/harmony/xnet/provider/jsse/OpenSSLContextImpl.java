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
 * Copyright (C) 2010 The Android Open Source Project
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


package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class OpenSSLContextImpl extends SSLContextImpl {

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.954 -0500", hash_original_method = "AC85303C5261AE8C561C9D0D813887D0", hash_generated_method = "2DAB3756C0B77899A95338CABCD4E299")
    
public OpenSSLContextImpl() {}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.957 -0500", hash_original_method = "F07877C7A70CCB9546F67CAFD785B8D1", hash_generated_method = "FFC388A9EE327C4A86000F47BAEA3558")
    
protected OpenSSLContextImpl(DefaultSSLContextImpl dummy)
            throws GeneralSecurityException, IOException {
        super(dummy);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.959 -0500", hash_original_method = "A469C9A4B5A6A159DDADCF53650EE287", hash_generated_method = "80609713FA2B818B0785F30705C820E9")
    
@Override
    public SSLSocketFactory engineGetSocketFactory() {
        if (sslParameters == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        return new OpenSSLSocketFactoryImpl(sslParameters);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.962 -0500", hash_original_method = "7F20F3D24E73FCFDF0CE368826678110", hash_generated_method = "14EA10676502CCA11F3314CBF461CB4A")
    
@Override
    public SSLServerSocketFactory engineGetServerSocketFactory() {
        if (sslParameters == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        return new OpenSSLServerSocketFactoryImpl(sslParameters);
    }
    
}

