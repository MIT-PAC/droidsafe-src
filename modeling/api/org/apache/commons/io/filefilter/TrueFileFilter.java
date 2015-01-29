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
 * A file filter that always returns true.
 *
 * @since 1.0
 * @version $Id: TrueFileFilter.java 1304058 2012-03-22 21:02:43Z sebb $
 * @see FileFilterUtils#trueFileFilter()
 */
public class TrueFileFilter implements IOFileFilter, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.491 -0400", hash_original_field = "0D6727C5EDAA9D415F6D4B499CE8D85C", hash_generated_field = "9ECCE779CFBBCF3D69F57CEC53256E69")

    public static final IOFileFilter TRUE = new TrueFileFilter();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.492 -0400", hash_original_field = "C667ABFBB217E562572BA14C25C08D28", hash_generated_field = "FAA97B620273D1C27003F3B6358EDC7A")

    public static final IOFileFilter INSTANCE = TRUE;

    /**
     * Restrictive consructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.492 -0400", hash_original_method = "623EDDCAAC7B1519CF46C5182C287E51", hash_generated_method = "C6929B16100C98552FBAD8C27E8C5561")
    
protected TrueFileFilter() {
    }

    /**
     * Returns true.
     *
     * @param file  the file to check (ignored)
     * @return true
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.493 -0400", hash_original_method = "E5F31B8C7E0E55836854007EF229F8F0", hash_generated_method = "103BFA0B31BCD8439A0361135A33060F")
    
public boolean accept(File file) {
        return true;
    }

    /**
     * Returns true.
     *
     * @param dir  the directory to check (ignored)
     * @param name  the filename (ignored)
     * @return true
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.493 -0400", hash_original_method = "DC2C6FD0F14A1434DB9ECFEAE61B09B4", hash_generated_method = "22B73DC538D97F34DC1D079961A2A003")
    
public boolean accept(File dir, String name) {
        return true;
    }

}
