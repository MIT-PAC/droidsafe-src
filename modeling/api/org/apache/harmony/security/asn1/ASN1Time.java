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

/**
* @author Stepan M. Mishura
* @version $Revision$
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public abstract class ASN1Time extends ASN1StringType {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.544 -0500", hash_original_method = "82E49EA5DBBF8DF43E60D041D8EADCBA", hash_generated_method = "CAF48723FCBF29B116EFEA04AB7A8424")
    
public ASN1Time(int tagNumber) {
        super(tagNumber);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.546 -0500", hash_original_method = "A8543817917479A67ACF72269E42F301", hash_generated_method = "57D628B029E551897A68C605BC923CD0")
    
@Override public Object getDecodedObject(BerInputStream in) throws IOException {
        GregorianCalendar c = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        c.set(Calendar.YEAR, in.times[0]);
        c.set(Calendar.MONTH, in.times[1]-1);
        c.set(Calendar.DAY_OF_MONTH, in.times[2]);
        c.set(Calendar.HOUR_OF_DAY, in.times[3]);
        c.set(Calendar.MINUTE, in.times[4]);
        c.set(Calendar.SECOND, in.times[5]);
        c.set(Calendar.MILLISECOND, in.times[6]);
        return c.getTime();
    }
    
}

