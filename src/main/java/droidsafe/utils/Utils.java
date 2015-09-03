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

package droidsafe.utils;

import java.io.File;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.slf4j.Logger;

/**
 * Class to store general utility methods.
 * 
 * @author mgordon
 *
 */
public class Utils {
	
	/**
	 * Given a file name with separators, convert them in to . so it is a legal class
	 * name.
	 */
	public static String fromFileToClass(String name) {
		return name.substring(0, name.length() - 6).replace(File.separatorChar, '.');
	}
	
	 /**
     * Given a jarFile, return a list of the classes contained in the jarfile
     * with . replacing /.
     */
    public static List<String> getClassesFromJar(JarFile jarFile) {
    	LinkedList<String> classes = new LinkedList<String>();
    	Enumeration<JarEntry> allEntries = jarFile.entries();
    	
        while (allEntries.hasMoreElements()) {
            JarEntry entry = (JarEntry) allEntries.nextElement();
            String   name  = entry.getName();
            if (!name.endsWith(".class")) {
                continue;
            }

            String clsName = name.substring(0, name.length() - 6).replace('/', '.');
            classes.add(clsName);
        }
        
        return classes;
    }   
    
    /**
     * Return the terminal classname from a fully specified classname
     * 
     */
    public static String extractClassname(String fullname) {
      return fullname.replaceFirst("^.*[.]", "");
    }
}
