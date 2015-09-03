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
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;

public final class Slog {

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.467 -0500", hash_original_method = "5A6FD02949046F86D19AC4E102A5FAA4", hash_generated_method = "757CED0CA2637A4979727648AD1810F8")
    
public static int v(String tag, String msg) {
        return Log.println_native(Log.LOG_ID_SYSTEM, Log.VERBOSE, tag, msg);
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.469 -0500", hash_original_method = "6EA869987B3D6D655099B5EC369C8F25", hash_generated_method = "F3E763C1EB0404C5875589E75B916808")
    
public static int v(String tag, String msg, Throwable tr) {
        return Log.println_native(Log.LOG_ID_SYSTEM, Log.VERBOSE, tag,
                msg + '\n' + Log.getStackTraceString(tr));
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.472 -0500", hash_original_method = "2D328040DC4A382FC4C5C75F400179CC", hash_generated_method = "E80F53A6C24D4C37F1A31D0BEB13C15C")
    
public static int d(String tag, String msg) {
        return Log.println_native(Log.LOG_ID_SYSTEM, Log.DEBUG, tag, msg);
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.474 -0500", hash_original_method = "E68803546B711C9F2623397DC5444E44", hash_generated_method = "ECD33A1B7552E92C9E75F929F3C65101")
    
public static int d(String tag, String msg, Throwable tr) {
        return Log.println_native(Log.LOG_ID_SYSTEM, Log.DEBUG, tag,
                msg + '\n' + Log.getStackTraceString(tr));
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.476 -0500", hash_original_method = "287EA2A549063E0F7E69CA4C642FFE02", hash_generated_method = "BD70A3344DD2F04C51E14138D1060274")
    
public static int i(String tag, String msg) {
        return Log.println_native(Log.LOG_ID_SYSTEM, Log.INFO, tag, msg);
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.479 -0500", hash_original_method = "AE9F4BDA72C4D4F6027080704333BE8C", hash_generated_method = "BB567FBE65AAFDF64E61939685CD237F")
    
public static int i(String tag, String msg, Throwable tr) {
        return Log.println_native(Log.LOG_ID_SYSTEM, Log.INFO, tag,
                msg + '\n' + Log.getStackTraceString(tr));
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.481 -0500", hash_original_method = "E753F3B99491D7566CF8B17287FEE9EF", hash_generated_method = "CBD0D250DBB5C1A34FD3080D17BD8D3C")
    
public static int w(String tag, String msg) {
        return Log.println_native(Log.LOG_ID_SYSTEM, Log.WARN, tag, msg);
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.483 -0500", hash_original_method = "CC3DCD8956023068C62B9CEEC3BF36BC", hash_generated_method = "BF6DA6179ECBD0AA616E9539FCA60964")
    
public static int w(String tag, String msg, Throwable tr) {
        return Log.println_native(Log.LOG_ID_SYSTEM, Log.WARN, tag,
                msg + '\n' + Log.getStackTraceString(tr));
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.485 -0500", hash_original_method = "04FC460CDCB165753C1A5E8135556557", hash_generated_method = "8F36BFB7796BF3CBFB574CBB943E8B75")
    
public static int w(String tag, Throwable tr) {
        return Log.println_native(Log.LOG_ID_SYSTEM, Log.WARN, tag, Log.getStackTraceString(tr));
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.488 -0500", hash_original_method = "9DA5A1F014B3F7C88D8FE790048E89FF", hash_generated_method = "88786C7E9C96C65A5593E6E64282B4D9")
    
public static int e(String tag, String msg) {
        return Log.println_native(Log.LOG_ID_SYSTEM, Log.ERROR, tag, msg);
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.491 -0500", hash_original_method = "4292F2B19DAC8B2FA7F30F6363D724BD", hash_generated_method = "E8406EB2C8AC2ECADA62D7D0BDE59245")
    
public static int e(String tag, String msg, Throwable tr) {
        return Log.println_native(Log.LOG_ID_SYSTEM, Log.ERROR, tag,
                msg + '\n' + Log.getStackTraceString(tr));
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.493 -0500", hash_original_method = "E3A662ECB94A7D36804BF22D0BD0E4A4", hash_generated_method = "5328AD429F107614F0C00155BFDEFD66")
    
public static int println(int priority, String tag, String msg) {
        return Log.println_native(Log.LOG_ID_SYSTEM, priority, tag, msg);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.464 -0500", hash_original_method = "0FAE0F80FD2D23A71DD156687BF7DB2B", hash_generated_method = "9F30BAEC09003EB6E11A7E255B01D933")
    
private Slog() {
    }
    
}

