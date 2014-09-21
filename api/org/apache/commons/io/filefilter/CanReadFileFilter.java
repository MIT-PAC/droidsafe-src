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
 * This filter accepts <code>File</code>s that can be read.
 * <p>
 * Example, showing how to print out a list of the 
 * current directory's <i>readable</i> files:
 *
 * <pre>
 * File dir = new File(".");
 * String[] files = dir.list( CanReadFileFilter.CAN_READ );
 * for ( int i = 0; i &lt; files.length; i++ ) {
 *     System.out.println(files[i]);
 * }
 * </pre>
 *
 * <p>
 * Example, showing how to print out a list of the 
 * current directory's <i>un-readable</i> files:
 *
 * <pre>
 * File dir = new File(".");
 * String[] files = dir.list( CanReadFileFilter.CANNOT_READ );
 * for ( int i = 0; i &lt; files.length; i++ ) {
 *     System.out.println(files[i]);
 * }
 * </pre>
 *
 * <p>
 * Example, showing how to print out a list of the 
 * current directory's <i>read-only</i> files:
 *
 * <pre>
 * File dir = new File(".");
 * String[] files = dir.list( CanReadFileFilter.READ_ONLY );
 * for ( int i = 0; i &lt; files.length; i++ ) {
 *     System.out.println(files[i]);
 * }
 * </pre>
 *
 * @since 1.3
 * @version $Id: CanReadFileFilter.java 1307462 2012-03-30 15:13:11Z ggregory $
 */
public class CanReadFileFilter extends AbstractFileFilter implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.802 -0400", hash_original_field = "4933AB4C9A2FEA267ED824EB33C611D8", hash_generated_field = "20F7263960F4D59AE6AF2AE0B45193FC")

    public static final IOFileFilter CAN_READ = new CanReadFileFilter();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.803 -0400", hash_original_field = "533E123D512EB45F33F21FCDB5C2187C", hash_generated_field = "9778DFD6EB1664F640DCDC2A976B47BC")

    public static final IOFileFilter CANNOT_READ = new NotFileFilter(CAN_READ);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.803 -0400", hash_original_field = "60D22795025D897901B40AEAF36E85F3", hash_generated_field = "FE092675685C2757B28FB2C1916FBC5B")

    public static final IOFileFilter READ_ONLY = new AndFileFilter(CAN_READ,
                                                CanWriteFileFilter.CANNOT_WRITE);
    
    /**
     * Restrictive consructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.804 -0400", hash_original_method = "BDC602CCB29EA618773E287B406AEBFF", hash_generated_method = "9E9A911B8C6008DBD7F6E616825BD9D1")
    
protected CanReadFileFilter() {
    }
    
    /**
     * Checks to see if the file can be read.
     * 
     * @param file  the File to check.
     * @return {@code true} if the file can be
     *  read, otherwise {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.804 -0400", hash_original_method = "04EA67B3A82204BBE7F5B271F46DC797", hash_generated_method = "EEC7700D81C7AA480D18016D7AD00B66")
    
@Override
    public boolean accept(File file) {
        return file.canRead();
    }
    
}
