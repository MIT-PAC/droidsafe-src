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

package droidsafe.concrete;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Process;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.lang.InterruptedException;

public class DroidSafeProcess extends Process {
    
    @DSSafe(DSCat.SAFE_LIST)

    public DroidSafeProcess ()
    {
        //Synthesized constructor
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    public void destroy() {
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.OS_PROCESS})
    public int exitValue() {
        return getTaintInt();
    }
    
    @DSSpec(DSCat.IO) 
    public  InputStream getErrorStream() {
        return new PipedInputStream();
    }
    
    @DSSource({DSSourceKind.OS_PROCESS})
    @DSSpec(DSCat.IO) 
    public  InputStream getInputStream() {        
        return new PipedInputStream();
    }
    
   @DSSpec(DSCat.IO) 
    public  OutputStream getOutputStream() {
        return new PipedOutputStream();
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    public  int waitFor() throws InterruptedException {
        if (getTaintBoolean())
            throw new InterruptedException();
        return getTaintInt();
    }
    
}

