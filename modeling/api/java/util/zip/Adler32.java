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
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util.zip;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Arrays;

/**
 * The Adler-32 class is used to compute the {@code Adler32} checksum from a set
 * of data. Compared to {@link CRC32} it trades reliability for speed.
 * Refer to RFC 1950 for the specification.
 */
public class Adler32 implements Checksum {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.761 -0400", hash_original_field = "64BED7BE8B3F40D64C8A966B22B7A16E", hash_generated_field = "340637C3F9F3E2C0581BDB7710DDE74A")

    private long adler = 1;

    /**
     * Returns the {@code Adler32} checksum for all input received.
     *
     * @return The checksum for this instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.761 -0400", hash_original_method = "7548992455680731B7C95F9AA9AA74C4", hash_generated_method = "38539E9CA9BE676F300F39CE51E836C1")
    
public long getValue() {
        return adler;
    }

    /**
     * Reset this instance to its initial checksum.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.761 -0400", hash_original_method = "1433914DD19ED8527D865BA07D38D783", hash_generated_method = "F8FD011E80F5AB65A2E076510F3CC003")
    
public void reset() {
        adler = 1;
    }

    /**
     * Update this {@code Adler32} checksum with the single byte provided as
     * argument.
     *
     * @param i
     *            the byte to update checksum with.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.762 -0400", hash_original_method = "031B66345AD9B4CB1EA8EFF22DB8DC3B", hash_generated_method = "278E9EAA73CD0042DDB2C4FC4CFB79A8")
    
public void update(int i) {
        adler = updateByteImpl(i, adler);
    }

    /**
     * Update this {@code Adler32} checksum using the contents of {@code buf}.
     *
     * @param buf
     *            bytes to update checksum with.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.762 -0400", hash_original_method = "CE6B29801A6FECCB312673EE525F73B5", hash_generated_method = "C7A3A99D53983972F56F1121073E3E00")
    
public void update(byte[] buf) {
        update(buf, 0, buf.length);
    }

    /**
     * Update this {@code Adler32} checksum with the contents of {@code buf},
     * starting from {@code offset} and reading {@code byteCount} bytes of data.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.763 -0400", hash_original_method = "33C110C69CF248DAE45848AD232AAEEC", hash_generated_method = "78829C3641D774D94C8DBA7566AB3E27")
    
public void update(byte[] buf, int offset, int byteCount) {
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        adler = updateImpl(buf, offset, byteCount, adler);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.763 -0400", hash_original_method = "26D22C50972EAA3B6C38F09F454AF8CC", hash_generated_method = "593BF8CB04D03E6EAD65B95E2769FED2")
    
    private long updateImpl(byte[] buf, int offset, int byteCount, long adler1){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += buf[0];
    	taintDouble += offset;
    	taintDouble += byteCount;
    	taintDouble += adler1;
    	addTaint(taintDouble);
    
    	return (long)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.765 -0400", hash_original_method = "259D32F9E4CE523F9078FA0D9CF43194", hash_generated_method = "46042B55694A968DB3C8E05404756EA7")
    
    private long updateByteImpl(int val, long adler1){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += val;
    	taintDouble += adler1;
    	addTaint(taintDouble);
    
    	return (long)taintDouble;
    }

}
