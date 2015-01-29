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

package org.apache.harmony.javax.security.auth.callback;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.Serializable;
import java.util.Locale;

public class LanguageCallback implements Callback, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.780 -0400", hash_original_field = "2D99583BDFC5CF3BBDDE85AB54FE66F7", hash_generated_field = "ABC3F6F752163D84BDC5CBB15BD2F610")


    private static final long serialVersionUID = 2019050433478903213L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.780 -0400", hash_original_field = "A25411C3C357716626A9185E220A5EAA", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")


    private Locale locale;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.781 -0400", hash_original_method = "A2DCA2A86BF971EA0FE52D0C769E0311", hash_generated_method = "53CEA4B115B2F2B5882ACAAD6CF19171")
    
public LanguageCallback() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.781 -0400", hash_original_method = "4C873AD5A0D4D89DBA836C1C6CEC9B8D", hash_generated_method = "424B5570E26DE121275BC9C58AD53C4D")
    
public Locale getLocale() {
        return locale;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.782 -0400", hash_original_method = "B4C0A2B69538F3C9760ADE4F445366A0", hash_generated_method = "90F07FDB60BDABB06D6153413AA709DD")
    
public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
