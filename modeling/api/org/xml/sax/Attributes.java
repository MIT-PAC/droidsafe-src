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


package org.xml.sax;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Attributes
{
    
    public abstract @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    int getLength ();
    
    public abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getURI (int index);
    
    public abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getLocalName (int index);
    
    public abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getQName (int index);
    
    public abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getType (int index);
    
    public abstract @DSComment("Abstract Method")
    @DSSafe(DSCat.XML)
    @DSSource({DSSourceKind.XML})
    String getValue (int index);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getIndex (String uri, String localName);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getIndex (String qName);
    
    public abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getType (String uri, String localName);
    
    public abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getType (String qName);
    
    public abstract @DSComment("Abstract Method")
    @DSSafe(DSCat.XML)
    @DSSource({DSSourceKind.XML})
    String getValue (String uri, String localName);
    
    public abstract @DSComment("Abstract Method")
    @DSSafe(DSCat.XML)
    @DSSource({DSSourceKind.XML})
    String getValue (String qName);

}
