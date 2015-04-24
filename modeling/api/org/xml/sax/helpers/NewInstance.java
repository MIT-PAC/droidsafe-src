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
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class NewInstance {

    /**
     * Creates a new instance of the specified class name
     *
     * Package private so this code is not exposed at the API level.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.125 -0500", hash_original_method = "E369FF088FB91F5BEAD9EC65B9119630", hash_generated_method = "61BEE3B61F78F6F1FCC670D4CBF72211")
    
static Object newInstance (ClassLoader classLoader, String className)
        throws ClassNotFoundException, IllegalAccessException,
            InstantiationException
    {
        Class driverClass;
        if (classLoader == null) {
            driverClass = Class.forName(className);
        } else {
            driverClass = classLoader.loadClass(className);
        }
        return driverClass.newInstance();
    }

    /**
     * Figure out which ClassLoader to use.  For JDK 1.2 and later use
     * the context ClassLoader.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.128 -0500", hash_original_method = "2CFACACB756B4314AD1F2CA20DF63100", hash_generated_method = "11C0FACD4CD318CFF0EE0DC9788E26E7")
    
static ClassLoader getClassLoader ()
    {
        Method m = null;

        try {
            m = Thread.class.getMethod("getContextClassLoader");
        } catch (NoSuchMethodException e) {
            // Assume that we are running JDK 1.1, use the current ClassLoader
            return NewInstance.class.getClassLoader();
        }

        try {
            return (ClassLoader) m.invoke(Thread.currentThread());
        } catch (IllegalAccessException e) {
            // assert(false)
            throw new UnknownError(e.getMessage());
        } catch (InvocationTargetException e) {
            // assert(e.getTargetException() instanceof SecurityException)
            throw new UnknownError(e.getMessage());
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.415 -0400", hash_original_method = "3A1A52FA8F8F310ECE2DC8F1F45CC136", hash_generated_method = "3A1A52FA8F8F310ECE2DC8F1F45CC136")
    public NewInstance ()
    {
        //Synthesized constructor
    }
    
}

