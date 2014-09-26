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

/**
 * An abstract class which implements the Java FileFilter and FilenameFilter 
 * interfaces via the IOFileFilter interface.
 * <p>
 * Note that a subclass <b>must</b> override one of the accept methods,
 * otherwise your class will infinitely loop.
 *
 * @since 1.0
 * @version $Id: AbstractFileFilter.java 1304052 2012-03-22 20:55:29Z ggregory $
 */
public abstract class AbstractFileFilter implements IOFileFilter {

    /**
     * Checks to see if the File should be accepted by this filter.
     * 
     * @param file  the File to check
     * @return true if this file matches the test
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.789 -0400", hash_original_method = "D5DE3D5D9AF246B7B9A0720792C74103", hash_generated_method = "59B0806481D8C8BA3E3B25E052B9470F")
    
public boolean accept(File file) {
        return accept(file.getParentFile(), file.getName());
    }

    /**
     * Checks to see if the File should be accepted by this filter.
     * 
     * @param dir  the directory File to check
     * @param name  the filename within the directory to check
     * @return true if this file matches the test
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.790 -0400", hash_original_method = "0C86CF264F403F294009DA2383C206BD", hash_generated_method = "9A0D2328B6F82E9E4A31E48E09F45068")
    
public boolean accept(File dir, String name) {
        return accept(new File(dir, name));
    }

    /**
     * Provide a String representaion of this file filter.
     *
     * @return a String representaion
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.791 -0400", hash_original_method = "CC6A2D61A01777F134B61F210B4582B4", hash_generated_method = "DC4F53437482264D89559E059DC0E69A")
    
@Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
