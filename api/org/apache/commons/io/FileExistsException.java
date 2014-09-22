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
import java.io.File;
import java.io.IOException;

/**
 * Indicates that a file already exists.
 * 
 * @version $Id: FileExistsException.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @since 2.0
 */
public class FileExistsException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.252 -0400", hash_original_field = "7D07EDF60BE7D52BF87500AC6D8FE154", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;

    /**
     * Default Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.252 -0400", hash_original_method = "F9315CC144268986DBB2C21411FC27E6", hash_generated_method = "1E0EC39D55C059C030446403D05D56D5")
    
public FileExistsException() {
        super();
    }

    /**
     * Construct an instance with the specified message.
     *
     * @param message The error message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.253 -0400", hash_original_method = "969BBB2B9A0EFD63C3504D154290DE98", hash_generated_method = "B0DD693CEE71361E54D3C5E57870D2CA")
    
public FileExistsException(String message) {
        super(message);
    }

    /**
     * Construct an instance with the specified file.
     *
     * @param file The file that exists
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.253 -0400", hash_original_method = "E6B23DB52F9D26F867FD6E13FC29AAA5", hash_generated_method = "B8A737592209B154EDA075816BFCF468")
    
public FileExistsException(File file) {
        super("File " + file + " exists");
    }

}
