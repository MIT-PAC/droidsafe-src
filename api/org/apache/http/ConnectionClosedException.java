/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/ConnectionClosedException.java $
 * $Revision: 618017 $
 * $Date: 2008-02-03 08:42:22 -0800 (Sun, 03 Feb 2008) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.http;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;

/**
 * Indicates that a connection has been closed.
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 *
 * @version $Revision: 618017 $
 * 
 * @since 4.0
 */
public class ConnectionClosedException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:35.656 -0400", hash_original_field = "5087C535B80AB26B63F3DC3C291D16F8", hash_generated_field = "8349FE5ACD9A1B8A5E300934E0E7E666")


    private static final long serialVersionUID = 617550366255636674L;
    
    /**
     * Creates a new ConnectionClosedException with the specified detail message.
     * 
     * @param message The exception detail message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:35.657 -0400", hash_original_method = "FBCE5EA5B6E84A8028EDCE669B205421", hash_generated_method = "D8A3E0320ED2EF9A87E80228539B8CEE")
    
public ConnectionClosedException(final String message) {
        super(message);
    }

}
