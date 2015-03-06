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

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

interface ZipConstants {

    public static final long LOCSIG = 0x4034b50, EXTSIG = 0x8074b50,
            CENSIG = 0x2014b50, ENDSIG = 0x6054b50;

    public static final int LOCHDR = 30, EXTHDR = 16, CENHDR = 46, ENDHDR = 22,
            LOCVER = 4, LOCFLG = 6, LOCHOW = 8, LOCTIM = 10, LOCCRC = 14,
            LOCSIZ = 18, LOCLEN = 22, LOCNAM = 26, LOCEXT = 28, EXTCRC = 4,
            EXTSIZ = 8, EXTLEN = 12, CENVEM = 4, CENVER = 6, CENFLG = 8,
            CENHOW = 10, CENTIM = 12, CENCRC = 16, CENSIZ = 20, CENLEN = 24,
            CENNAM = 28, CENEXT = 30, CENCOM = 32, CENDSK = 34, CENATT = 36,
            CENATX = 38, CENOFF = 42, ENDSUB = 8, ENDTOT = 10, ENDSIZ = 12,
            ENDOFF = 16, ENDCOM = 20;
}
