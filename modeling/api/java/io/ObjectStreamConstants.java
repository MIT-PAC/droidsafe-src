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


package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract interface ObjectStreamConstants {

    
    public static final short STREAM_MAGIC = (short) 0xaced;

    
    public static final short STREAM_VERSION = 5;

    

    
    public static final byte TC_BASE = 0x70;

    
    public static final byte TC_NULL = (byte) 0x70;

    
    public static final byte TC_REFERENCE = (byte) 0x71;

    
    public static final byte TC_CLASSDESC = (byte) 0x72;

    
    public static final byte TC_OBJECT = (byte) 0x73;

    
    public static final byte TC_STRING = (byte) 0x74;

    
    public static final byte TC_ARRAY = (byte) 0x75;

    
    public static final byte TC_CLASS = (byte) 0x76;

    
    public static final byte TC_BLOCKDATA = (byte) 0x77;

    
    public static final byte TC_ENDBLOCKDATA = (byte) 0x78;

    
    public static final byte TC_RESET = (byte) 0x79;

    
    public static final byte TC_BLOCKDATALONG = (byte) 0x7A;

    
    public static final byte TC_EXCEPTION = (byte) 0x7B;

    
    public static final byte TC_LONGSTRING = (byte) 0x7C;

    
    public static final byte TC_PROXYCLASSDESC = (byte) 0x7D;

    
    public static final byte TC_MAX = 0x7E;

    
    public static final int baseWireHandle = 0x007e0000;

    
    public static final int PROTOCOL_VERSION_1 = 1;

    
    public static final int PROTOCOL_VERSION_2 = 2;

    
    public static final SerializablePermission SUBCLASS_IMPLEMENTATION_PERMISSION = new SerializablePermission(
            "enableSubclassImplementation");

    
    public static final SerializablePermission SUBSTITUTION_PERMISSION = new SerializablePermission(
            "enableSubstitution");

    
    
    
    public static final byte SC_WRITE_METHOD = 0x01; 

    
    public static final byte SC_SERIALIZABLE = 0x02;

    
    public static final byte SC_EXTERNALIZABLE = 0x04;

    
    public static final byte SC_BLOCK_DATA = 0x08; 

    
    public static final byte TC_ENUM = 0x7E;

    
    public static final byte SC_ENUM = 0x10;
}
