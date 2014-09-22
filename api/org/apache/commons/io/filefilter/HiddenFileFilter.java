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
 * This filter accepts <code>File</code>s that are hidden.
 * <p>
 * Example, showing how to print out a list of the
 * current directory's <i>hidden</i> files:
 *
 * <pre>
 * File dir = new File(".");
 * String[] files = dir.list( HiddenFileFilter.HIDDEN );
 * for ( int i = 0; i &lt; files.length; i++ ) {
 *     System.out.println(files[i]);
 * }
 * </pre>
 *
 * <p>
 * Example, showing how to print out a list of the
 * current directory's <i>visible</i> (i.e. not hidden) files:
 *
 * <pre>
 * File dir = new File(".");
 * String[] files = dir.list( HiddenFileFilter.VISIBLE );
 * for ( int i = 0; i &lt; files.length; i++ ) {
 *     System.out.println(files[i]);
 * }
 * </pre>
 *
 * @since 1.3
 * @version $Id: HiddenFileFilter.java 1307462 2012-03-30 15:13:11Z ggregory $
 */
public class HiddenFileFilter extends AbstractFileFilter implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.474 -0400", hash_original_field = "51CA3A2113E23179BF89DBFEC3FBA7BE", hash_generated_field = "FE73352A357F740BB4C5E6EAE324D092")

    public static final IOFileFilter HIDDEN  = new HiddenFileFilter();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.475 -0400", hash_original_field = "01C15AFCDD18F0B4C8F2ED55102C2B3A", hash_generated_field = "B1C20113B87CE45E1D42C35241C448E2")

    public static final IOFileFilter VISIBLE = new NotFileFilter(HIDDEN);
    
    /**
     * Restrictive consructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.475 -0400", hash_original_method = "27CCA45322132EC040C5AEC325BA1F4E", hash_generated_method = "07261FA6DABCAB4D36015D5D831B194B")
    
protected HiddenFileFilter() {
    }
    
    /**
     * Checks to see if the file is hidden.
     * 
     * @param file  the File to check
     * @return {@code true} if the file is
     *  <i>hidden</i>, otherwise {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.476 -0400", hash_original_method = "423B72A848C918F2592E84C74B14F648", hash_generated_method = "F90A3FFCCBFE0EFFBA55263D9E24990E")
    
@Override
    public boolean accept(File file) {
        return file.isHidden();
    }
    
}
