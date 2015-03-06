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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/protocol/HttpDateGenerator.java $
 * $Revision: 548066 $
 * $Date: 2007-06-17 09:51:55 -0700 (Sun, 17 Jun 2007) $
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.protocol;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


/**
 * Generates a date in the format required by the HTTP protocol.
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 *
 * @version $Revision: 548066 $
 * 
 * @since 4.0
 */
public class HttpDateGenerator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.311 -0400", hash_original_field = "C98385C9500782E8D6C619F2F4D4E34D", hash_generated_field = "4C394D5CADCD628D7373F95DB7006036")

    public static final
        String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.311 -0400", hash_original_field = "1805E39C3A2BD113B25018C5FFF99805", hash_generated_field = "3A278BEAEB75318EBD87EA7DAAF24AD0")

    public static final TimeZone GMT = TimeZone.getTimeZone("GMT");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.312 -0400", hash_original_field = "D385E3385B622804A051ECEFA5D31CE5", hash_generated_field = "814EC6458E7E293F9B58E3B34E61209A")



    private  DateFormat dateformat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.312 -0400", hash_original_field = "2E30DE6887BE749611E24195D077D1A9", hash_generated_field = "FC33F1F3255A74503C81EBDEDE97443A")

    
    private long dateAsLong = 0L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.313 -0400", hash_original_field = "E142A0CF74AD776CD1073D26E6367824", hash_generated_field = "FA5CBB13276E9C996BE8B0702F7A5E60")

    private String dateAsText = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.313 -0400", hash_original_method = "E43873E83BEDA84DD21E7AEAED2F9C0A", hash_generated_method = "BA4DD1D4B6CE5FADFF32BC23DB2181F7")
    
public HttpDateGenerator() {
        super();
        this.dateformat = new SimpleDateFormat(PATTERN_RFC1123, Locale.US);
        this.dateformat.setTimeZone(GMT);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.315 -0400", hash_original_method = "1A7596BD9BD6ACC95BB8E1DF4B65C927", hash_generated_method = "86237A8B9376110CD6AEB604A958C5DC")
    
public synchronized String getCurrentDate() {
        long now = System.currentTimeMillis();
        if (now - this.dateAsLong > 1000) {
            // Generate new date string
            this.dateAsText = this.dateformat.format(new Date(now));
            this.dateAsLong = now;
        }
        return this.dateAsText;
    }
    
}
