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
 * Copyright (C) 2007 The Android Open Source Project
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


package android.opengl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL10Ext;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11Ext;
import javax.microedition.khronos.opengles.GL11ExtensionPack;




abstract class GLWrapperBase implements GL, GL10, GL10Ext, GL11, GL11Ext, GL11ExtensionPack {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:10.290 -0500", hash_original_field = "C120FEFA1028301888C6B36B6FCBCABD", hash_generated_field = "E6EDB2FCF74C86CBA0CF1495E76DD1BA")


    protected GL10 mgl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:10.292 -0500", hash_original_field = "E25B46B320368B19BB3CF3E5E724D4A0", hash_generated_field = "D0E3CCA149E553447A379FFD4CF9E9C8")

    protected GL10Ext mgl10Ext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:10.295 -0500", hash_original_field = "F03B5AE45658752F0B5EEAA197BF38DA", hash_generated_field = "3E7CA8CF12DD10E2B0A2E24932346826")

    protected GL11 mgl11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:10.297 -0500", hash_original_field = "5B6B5E3C17E31C7981821DCAB50569FB", hash_generated_field = "B4A363E482954361704E7CED2894B2E0")

    protected GL11Ext mgl11Ext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:10.299 -0500", hash_original_field = "E33AAB8352A2BC0D94A35ED959CF7E25", hash_generated_field = "68BFC218C5F71A28138E3BE916161F71")

    protected GL11ExtensionPack mgl11ExtensionPack;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:10.288 -0500", hash_original_method = "B36031ED922ABC4425023B0E6A7BD8D3", hash_generated_method = "40EB1BD7AB5E6850F9CEA9C50D74B360")
    
public GLWrapperBase(GL gl) {
        mgl = (GL10) gl;
        if (gl instanceof GL10Ext) {
            mgl10Ext = (GL10Ext) gl;
        }
        if (gl instanceof GL11) {
            mgl11 = (GL11) gl;
        }
        if (gl instanceof GL11Ext) {
            mgl11Ext = (GL11Ext) gl;
        }
        if (gl instanceof GL11ExtensionPack) {
            mgl11ExtensionPack = (GL11ExtensionPack) gl;
        }
    }

    
}

