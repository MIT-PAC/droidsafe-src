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

package org.apache.harmony.javax.security.sasl;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;

public class SaslException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.511 -0400", hash_original_field = "30490F73DFADE6AEB53395131824CAA4", hash_generated_field = "B39ACC585E2CBEC7A1B0162484EE77F9")

    private static final long serialVersionUID = 4579784287983423626L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.512 -0400", hash_original_field = "52E1E584294508FDB71F615F0BEB3BE7", hash_generated_field = "97483D4C29D21110D083F26AC06184F0")

    private Throwable _exception;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.512 -0400", hash_original_method = "72F5233434897DF80B799B712732EDC5", hash_generated_method = "DA45182EF270003F749DC436FD2FFEA2")
    
public SaslException() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.513 -0400", hash_original_method = "9DA8AF0D003CBB52A819586A41C51C3F", hash_generated_method = "BA2BE1BA0C762A47A834B69445D0758D")
    
public SaslException(String detail) {
        super(detail);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.514 -0400", hash_original_method = "99F89FEEC781A0CBD72BDAAAEAFDABC1", hash_generated_method = "8394049B33335339754D74FB1D093FDA")
    
public SaslException(String detail, Throwable ex) {
        super(detail);
        if (ex != null) {
            super.initCause(ex);
            _exception = ex;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.514 -0400", hash_original_method = "8791F3A96B34116A71DD0AC47CE5537E", hash_generated_method = "2BA2E1F20BE93F1A2866C75EF8F8D4A9")
    
@Override
    public Throwable getCause() {
        return _exception;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.515 -0400", hash_original_method = "25ED5481D554C123C565A2DD8666653E", hash_generated_method = "79CA2BCC7DA7A4DDF09F87F8F3E1A2A0")
    
@Override
    public Throwable initCause(Throwable cause) {
        super.initCause(cause);
        _exception = cause;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.515 -0400", hash_original_method = "CB49F38B4FDB9C47BF93A3F24EBF7010", hash_generated_method = "AA81E03E736EE200A181E270839FCB84")
    
@Override
    public String toString() {
        if (_exception == null) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(", caused by: "); //$NON-NLS-1$
        sb.append(_exception.toString());
        return sb.toString();
    }
}
