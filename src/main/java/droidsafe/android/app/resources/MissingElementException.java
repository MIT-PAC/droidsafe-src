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

import java.lang.reflect.*;

import soot.SootClass;
import soot.SootMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;

/**
 * Error that is thrown when an element (class, method, etc) does not
 * exist.  This is not necessarily indicative of a code error.  For example,
 * a manifest may refer to an activity that does not exist.
 */
public class MissingElementException extends Exception {
	private final static Logger logger = LoggerFactory.getLogger(MissingElementException.class);	

  public MissingElementException (SootClass cn, SootMethod m,
                                  String msg) {

    super (String.format ("{} in {}.{} at line {}", msg, cn.getName(), m.getName(),
                          SootUtils.getMethodLocation(m).getLine()));
  }

  public MissingElementException (String msg) {
    super (msg);
  }
}
