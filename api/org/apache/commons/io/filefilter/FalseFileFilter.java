/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.io.filefilter;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.io.Serializable;

/**
 * A file filter that always returns false.
 *
 * @since 1.0
 * @version $Id: FalseFileFilter.java 1304058 2012-03-22 21:02:43Z sebb $
 *
 * @see FileFilterUtils#falseFileFilter()
 */
public class FalseFileFilter implements IOFileFilter, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:54.005 -0400", hash_original_field = "EAB7B9B7996C5046CABF786CBAF28F32", hash_generated_field = "5B429CAA2ED34C884FCE3BCB14471E67")

    public static final IOFileFilter FALSE = new FalseFileFilter();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:54.005 -0400", hash_original_field = "4DB5B6DB0F1AEC1F7652F181FC9D672B", hash_generated_field = "BA754C3807B1DF45A15D05704684C2BC")

    public static final IOFileFilter INSTANCE = FALSE;

    /**
     * Restrictive consructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:54.006 -0400", hash_original_method = "FFD73B06BFF281953B16F54803697DC3", hash_generated_method = "9914BD0B75BD9C1F8FA2F0E0462B401B")
    
protected FalseFileFilter() {
    }

    /**
     * Returns false.
     *
     * @param file  the file to check (ignored)
     * @return false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:54.006 -0400", hash_original_method = "DB29F58DE9255B6C1BC35903D533B6E7", hash_generated_method = "29B98D81AE4ACA56229AA8FA1A31E381")
    
public boolean accept(File file) {
        return false;
    }

    /**
     * Returns false.
     *
     * @param dir  the directory to check (ignored)
     * @param name  the filename (ignored)
     * @return false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:54.007 -0400", hash_original_method = "7D8493348446C8D120E5A36A74BD3C3A", hash_generated_method = "E3DA08D883EA35EB225584DEC3AD75AC")
    
public boolean accept(File dir, String name) {
        return false;
    }

}
