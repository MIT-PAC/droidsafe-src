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
package org.apache.commons.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

/**
 * Extends {@link Selector} with no-ops for testing.
 *  
 * @version $Id: SelectorAdapter.java 1302382 2012-03-19 11:50:35Z sebb $
 */
public class SelectorAdapter extends Selector {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.261 -0400", hash_original_method = "6C817FC3BAF747F375AA67744160FCE7", hash_generated_method = "CAD457DA3F1A6F3420F3B78679B53434")
    
@Override
    public boolean isOpen() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.261 -0400", hash_original_method = "E5B2BBE6E5D0054B37212039CFA7A936", hash_generated_method = "91CF23219A94535742091F8D333D6EC6")
    
@Override
    public SelectorProvider provider() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.262 -0400", hash_original_method = "1E9983C42AA112784285B6E49416EA55", hash_generated_method = "7859BE6E1D4C5435361B1F7D2D7F6B57")
    
@Override
    public Set<SelectionKey> keys() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.262 -0400", hash_original_method = "2FE5914C62444F5534539D55434F7904", hash_generated_method = "9BFF9DE36F1BB0801556979E9046691D")
    
@Override
    public Set<SelectionKey> selectedKeys() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.263 -0400", hash_original_method = "43213C532846F18B5179BE18C808B75D", hash_generated_method = "EB4CCE094181A5282252A8361FA42C02")
    
@Override
    public int selectNow() throws IOException {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.263 -0400", hash_original_method = "38DC30CDF866E22F2FBB173A84AB2027", hash_generated_method = "2668848C3A2DC514D1D8FF54326E966C")
    
@Override
    public int select(long timeout) throws IOException {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.264 -0400", hash_original_method = "DC824D21A3405E7C0A67E8892448DD45", hash_generated_method = "E15F2B3299B09BE06053A756D444E0F0")
    
@Override
    public int select() throws IOException {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.264 -0400", hash_original_method = "4CF76017A7C577177A29029723A7F064", hash_generated_method = "743B5B13CEE28560D4FE51653446DF0D")
    
@Override
    public Selector wakeup() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.264 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "A02E08A88CC8B9595BC3CD08A1523FE3")
    
@Override
    public void close() throws IOException {
    }

}
