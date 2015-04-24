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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.utils.SootUtils;

import java.lang.reflect.*;

import soot.SootClass;
import soot.SootMethod;

/**
 * Error that is thrown when the code does not follow our required
 * Idioms
 */
public class UnsupportedIdiomException extends Exception {
	private final static Logger logger = LoggerFactory.getLogger(UnsupportedIdiomException.class);	
	
  public UnsupportedIdiomException (SootClass cn, SootMethod m,
                                    String msg) {

    super (String.format ("%s in %s.%s at line %d", msg, cn.getName(), m.getName(),
                          SootUtils.getMethodLocation(m).getLine()));
  }

  public UnsupportedIdiomException (String msg) {
    super (msg);
  }
}
