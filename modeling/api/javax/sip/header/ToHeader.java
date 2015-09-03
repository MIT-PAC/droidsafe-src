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


package javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

public interface ToHeader extends HeaderAddress, Header, Parameters {
    String NAME = "To";

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getTag();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setTag(String tag) throws ParseException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean hasTag();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void removeTag();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getDisplayName();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getUserAtHostPort();
}
