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

package droidsafe.android.app.resources;

import java.util.*;
import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reads the resource definitions out of the compiled resource files.
 * These files are in the application subdirectory bin/classes/[appl]
 * The application must be built for these files to exist.  Dumps out
 * name value pairs for each resource id.
 *
 * Takes one argument - the name of the top level application directory
 */
public class DumpRes {
	private final static Logger logger = LoggerFactory.getLogger(DumpRes.class);	
	  
  static String blanks = "                                               ";

  public static void main (String[] args) throws Exception {


    if (args.length != 1) {
      logger.error ("One argument (application directory) is required\n" + 
    		  "usage: DumpRes <app-dir>\n" +
    		  "DumpRes dumps all of the resource ids for the app\n");
      droidsafe.main.Main.exit(1);
     
    }

    Resources app = new Resources (new File (args[0]));

    for (Integer res_val : app.resource_info.keySet()) {
    	logger.info ("{}  {}", String.format("%08X", res_val), 
                         app.resource_info.get (res_val));
    }
  }
}
