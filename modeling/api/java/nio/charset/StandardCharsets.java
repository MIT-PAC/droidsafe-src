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
 * Copyright (C) 2010 The Android Open Source Project
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


package java.nio.charset;

/**
 * Convenient access to the most important built-in charsets.
 * @since 1.7
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class StandardCharsets {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.181 -0400", hash_original_field = "A22CC05BE6CEEE92799923C2424B3CA8", hash_generated_field = "8EC60A36A46A03E488D22699D2DAA981")

  public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.182 -0400", hash_original_field = "714C63F2B80D1D2AC8056DCAAFF2BD5B", hash_generated_field = "3E3052A707DD298E1FBE7FC8381E1B07")

  public static final Charset US_ASCII = Charset.forName("US-ASCII");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.182 -0400", hash_original_field = "81A0A19FF2F5A038281B549B1D0CE3F5", hash_generated_field = "31164D91DD586A365881F2A00F655E8D")

  public static final Charset UTF_8 = Charset.forName("UTF-8");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.182 -0400", hash_original_field = "0E60CC9D940F4A7BBE48ED584C7FABDF", hash_generated_field = "626EA6A3B9EE55F06343FCE9005FB573")

  public static final Charset UTF_16 = Charset.forName("UTF-16");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.183 -0400", hash_original_field = "B2A29496649FC37D8AC382D9E1ADD2FD", hash_generated_field = "2E581518D8DE46969E014F48C2B46CE9")

  public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.183 -0400", hash_original_field = "1E784C699AAA1D2509B384FB2F10B837", hash_generated_field = "3BB0DD9828DA9BEC43999249AAF9452C")

  public static final Charset UTF_16LE = Charset.forName("UTF-16LE");
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.181 -0400", hash_original_method = "7FA3923DEE12712CE91FD882488DD46F", hash_generated_method = "311B6FE32ADD643AD1F7E7126C180594")
    
private StandardCharsets() {
  }
}
