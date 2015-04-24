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
* @author Vladimir N. Molotkov
* @version $Revision$
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ASN1Constants {
    
    int CLASS_UNIVERSAL = 0;
    int CLASS_APPLICATION = 64;
    int CLASS_CONTEXTSPECIFIC = 128;
    int CLASS_PRIVATE = 192;

    
    int PC_PRIMITIVE = 0;
    int PC_CONSTRUCTED = 32;

    
    int TAG_BOOLEAN = 1;
    int TAG_INTEGER = 2;
    int TAG_BITSTRING = 3;
    int TAG_OCTETSTRING = 4;
    int TAG_NULL = 5;
    int TAG_OID = 6;
    int TAG_OBJDESCRIPTOR = 7;
    int TAG_EXTERNAL = 8;
    int TAG_INSTANCEOF = TAG_EXTERNAL;
    int TAG_REAL = 9;
    int TAG_ENUM = 10;
    int TAG_EMBEDDEDPDV = 11;
    int TAG_UTF8STRING = 12;
    int TAG_RELATIVEOID = 13;
    int TAG_SEQUENCE = 16;
    int TAG_SEQUENCEOF = TAG_SEQUENCE;
    int TAG_SET = 17;
    int TAG_SETOF = TAG_SET;
    int TAG_NUMERICSTRING = 18;
    int TAG_PRINTABLESTRING = 19;
    int TAG_TELETEXSTRING = 20;
    int TAG_T61STRING = TAG_TELETEXSTRING;
    int TAG_VIDEOTEXSTRING = 21;
    int TAG_IA5STRING = 22;
    int TAG_UTCTIME = 23;
    int TAG_GENERALIZEDTIME = 24;
    int TAG_GRAPHICSTRING = 25;
    int TAG_VISIBLESTRING = 26;
    int TAG_ISO646STRING = TAG_VISIBLESTRING;
    int TAG_GENERALSTRING = 27;
    int TAG_UNIVERSALSTRING = 28;
    int TAG_BMPSTRING = 30;

    int TAG_C_BITSTRING = TAG_BITSTRING | PC_CONSTRUCTED;
    int TAG_C_OCTETSTRING = TAG_OCTETSTRING | PC_CONSTRUCTED;
    int TAG_C_UTF8STRING = TAG_UTF8STRING | PC_CONSTRUCTED;
    int TAG_C_SEQUENCE = TAG_SEQUENCE | PC_CONSTRUCTED;
    int TAG_C_SEQUENCEOF = TAG_SEQUENCEOF | PC_CONSTRUCTED;
    int TAG_C_SET = TAG_SET | PC_CONSTRUCTED;
    int TAG_C_SETOF = TAG_SETOF | PC_CONSTRUCTED;
    int TAG_C_UTCTIME = TAG_UTCTIME | PC_CONSTRUCTED;
    int TAG_C_GENERALIZEDTIME = TAG_GENERALIZEDTIME | PC_CONSTRUCTED;

    
    int TAG_ANY = 0;
    int TAG_CHOICE = TAG_ANY;
}
