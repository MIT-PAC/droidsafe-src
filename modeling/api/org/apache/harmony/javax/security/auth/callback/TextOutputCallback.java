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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.javax.security.auth.callback;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.Serializable;



public class TextOutputCallback implements Callback, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.959 -0400", hash_original_field = "CF10018D1A9D0509009AD0C7A26CA677", hash_generated_field = "DD8C75992676EC94817A7E46ABC9998C")


    private static final long serialVersionUID = 1689502495511663102L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.960 -0400", hash_original_field = "840675B2F8A9BE4EBEF5B5F9F9D9C018", hash_generated_field = "76E60C65F3078DE399A0BD7029E8A318")


    public static final int INFORMATION = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.960 -0400", hash_original_field = "90B00A13356ACCF5BD2780C16BA63349", hash_generated_field = "B8C559E7F173AA822B2B792E52FCD9B2")


    public static final int WARNING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.961 -0400", hash_original_field = "6B79DA8E084E22F65CCDD07B979B9949", hash_generated_field = "FBFCEE2B35A82DB052F105819D247209")


    public static final int ERROR = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.962 -0400", hash_original_field = "C9795C94D34B39950C581203743BD4FC", hash_generated_field = "B2821CE5540C52B19670BB2C4012F012")


    private String message;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.962 -0400", hash_original_field = "B3E0C00F8616825E1647BC1E6CD823E2", hash_generated_field = "57552E8D54B3896B51E574B541E7B7DE")


    private int messageType;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.963 -0400", hash_original_method = "A20A461541AE5017627CFC4C851126A8", hash_generated_method = "A9A8D22C1A81056E8D478ED54048F1DC")
    
public TextOutputCallback(int messageType, String message) {
        if (messageType > ERROR || messageType < INFORMATION) {
            throw new IllegalArgumentException("auth.16"); //$NON-NLS-1$
        }
        if (message == null || message.length() == 0) {
            throw new IllegalArgumentException("auth.1F"); //$NON-NLS-1$
        }
        this.messageType = messageType;
        this.message = message;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.963 -0400", hash_original_method = "AF20B727F6E1F2FE1F73E3107355CAA7", hash_generated_method = "90D22C2CF9BCEC06A37161C90B3C0462")
    
public String getMessage() {
        return message;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.964 -0400", hash_original_method = "2C4FC08D25B03FD0EFCA578F58E578D2", hash_generated_method = "FAA258CC0C63CB0D776A6C84B6E75963")
    
public int getMessageType() {
        return messageType;
    }
}
