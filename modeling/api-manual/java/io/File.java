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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class File implements Serializable, Comparable<File> {
	private static final long serialVersionUID = 301077366599181567L;
	public static final char separatorChar;
	public static final String separator;
	public static final char pathSeparatorChar;
	public static final String pathSeparator;
	
	static {
        separatorChar = System.getProperty("file.separator", "/").charAt(0);
        pathSeparatorChar = System.getProperty("path.separator", ":").charAt(0);
        separator = String.valueOf(separatorChar);
        pathSeparator = String.valueOf(pathSeparatorChar);
    }
	
	
	@DSModeled(DSC.SAFE)
	public File(String path) {
		addTaint(path.getTaint());
        //this.path = fixSlashes(path);
    }

	@DSModeled(DSC.SAFE)
	public File(File dir, String name) {
        this(dir == null ? null : dir.getPath(), name);
    }
	
	@DSModeled(DSC.SAFE)
	public File(String dirPath, String name) {
		addTaint(dirPath.getTaint());  
		addTaint(name.getTaint()); 
		/*
        if (name == null) {
            throw new NullPointerException();
        }
        if (dirPath == null || dirPath.isEmpty()) {
            this.path = fixSlashes(name);
        } else if (name.isEmpty()) {
            this.path = fixSlashes(dirPath);
        } else {
            this.path = fixSlashes(join(dirPath, name));
        }
        */
    }
	
	@Override
	public int compareTo(File arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@DSModeled(DSC.SAFE)
	public String getPath() {
            String str = new String();
            str.addTaint(getTaint());
            return str;
        //return path;
    }
	
	@DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        String str = new String();
        str.addTaint(getTaint());
        return str;
        //return path;
    }
}
