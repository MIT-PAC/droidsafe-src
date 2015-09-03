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


package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.TimerTask;

public abstract class SIPStackTimerTask extends TimerTask {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:41.996 -0400", hash_original_method = "CF93C0792FF2A4713A916D013DB0C142", hash_generated_method = "CF93C0792FF2A4713A916D013DB0C142")
    public SIPStackTimerTask ()
    {
        //Synthesized constructor
    }
    // / Implements code to be run when the SIPStackTimerTask is executed.
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.636 -0500", hash_original_method = "CB5870151CD6DF3DC7632725FAC776A4", hash_generated_method = "4CAC313E67DDA91D5DC1289C58A06F81")
    
protected abstract void runTask();

    // / The run() method is final to ensure that all subclasses inherit the
    // exception handling.
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.639 -0500", hash_original_method = "83C0265BCA7923E7BED6DC913E28AE42", hash_generated_method = "375D4E0374AEC4D1F88E5FBFD6B7396D")
    
public final void run() {
        try {
            runTask();
        } catch (Throwable e) {
            System.out.println("SIP stack timer task failed due to exception:");
            e.printStackTrace();
        }
    }
    
}

