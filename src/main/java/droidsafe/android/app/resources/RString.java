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


import droidsafe.android.app.resources.BaseElement;
import droidsafe.android.app.resources.XmlFile;

import java.util.InvalidPropertiesFormatException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.w3c.dom.Node;


public class RString extends BaseElement {
	
  private final static Logger logger = LoggerFactory.getLogger(RString.class);	
 
  @Attribute public String name;

  // source XML file this string was read from
  public XmlFile  source;
  public String value;

  public RString(Node n, XmlFile source, String value) throws InvalidPropertiesFormatException {
    super(n, null);
    get_attributes(this);
    
    this.source = source;
    this.value = value;
  }
  
  public RString(String value) {
	  this.value = value;
  }
}
