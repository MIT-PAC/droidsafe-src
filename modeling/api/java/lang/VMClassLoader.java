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


package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import droidsafe.helpers.DSUtils;

class VMClassLoader {

    /**
     * Get a resource from a file in the bootstrap class path.
     *
     * It would be simpler to just walk through the class path elements
     * ourselves, but that would require reopening Jar files.
     *
     * We assume that the bootclasspath can't change once the VM has
     * started.  This assumption seems to be supported by the spec.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.660 -0500", hash_original_method = "AF486A7D7E964EDE4DDBB83EBC604A43", hash_generated_method = "6271D690045E117ED2B73930093ED883")
    
static URL getResource(String name) {
        //droidsafe short-circuiting
        try {
            return new URL(name);
        } catch (Exception e) {
            
        }

        return null;

        /*
        int numEntries = getBootClassPathSize();
        for (int i = 0; i < numEntries; i++) {
            String urlStr = getBootClassPathResource(name, i);
            if (urlStr != null) {
                try {
                    return new URL(urlStr);
                } catch (MalformedURLException mue) {
                    mue.printStackTrace();
                    // unexpected; keep going
                }
            }
        }
        return null;
        */
    }

    /*
     * Get an enumeration with all matching resources.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.663 -0500", hash_original_method = "41BB43040C33BB8F9D26EFBD637FF5E0", hash_generated_method = "BA6F8EFE5770630EF076EF012F1DAE80")
    
static List<URL> getResources(String name) {
                //droidsafe short-circuiting
        URL url = null;
        try {
            url = new URL(name);
        } catch (Exception e) {
            
        }
        ArrayList<URL> list = new ArrayList<URL>();
        list.add(url);
        return list;

        /*
        ArrayList<URL> list = new ArrayList<URL>();
        int numEntries = getBootClassPathSize();
        for (int i = 0; i < numEntries; i++) {
            String urlStr = getBootClassPathResource(name, i);
            if (urlStr != null) {
                try {
                    list.add(new URL(urlStr));
                } catch (MalformedURLException mue) {
                    mue.printStackTrace();
                    // unexpected; keep going
                }
            }
        }
        return list;
        */
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
    	Class ret = (Class)new Object();
    	ret.addTaint(name.getTaint());
    	ret.addTaint(resolve);
    	return ret;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static Class getPrimitiveClass(char type) {
    	Class ret = (Class)new Object();
    	ret.addTaint(type);
    	return ret;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static Class defineClass(ClassLoader cl, String name, byte[] data, int offset, int len) throws ClassFormatError {
    	Class ret = (Class)new Object();
    	ret.addTaint(cl.getTaint());
    	ret.addTaint(data[0]);
    	ret.addTaint(offset);
    	ret.addTaint(len);
    	return ret;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static Class defineClass(ClassLoader cl, byte[] data, int offset, int len) throws ClassFormatError {
    	Class ret = (Class)new Object();
    	ret.addTaint(cl.getTaint());
    	ret.addTaint(data[0]);
    	ret.addTaint(offset);
    	ret.addTaint(len);
    	return ret;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static Class findLoadedClass(ClassLoader cl, String name) {
    	Class ret = (Class)new Object();
    	ret.addTaint(name.getTaint());
    	ret.addTaint(cl.getTaint());
    	return ret;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int getBootClassPathSize() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1375923467 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1375923467;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String getBootClassPathResource(String name, int index) {
    	String ret = new String();
    	ret.addTaint(name.getTaint());
    	ret.addTaint(index);
    	return ret;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.695 -0400", hash_original_method = "4AEDA864BABA59DB003EAC2DE676238C", hash_generated_method = "4AEDA864BABA59DB003EAC2DE676238C")
    public VMClassLoader ()
    {
        //Synthesized constructor
    }
    
}

