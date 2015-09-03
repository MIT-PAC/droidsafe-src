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

package droidsafe.eclipse.plugin.core.marker;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.Position;

/**
 * A text marker that indicates unreachable methods (dead code) in a Java source file.
 * 
 * @author gilham
 *
 */
public class DeadCodeMarker {

    /**
     * The type ID of DeadCodeMarker.
     */
    public static final String TYPE = "droidsafe.deadcode.marker";
    
    /**
     * The annotation ID of DeadCodeMarker.
     */
    public static final String ANNOTATION = "droidsafe.deadcode";
    
    /*
     * Creates a dead code marker
     */
    /**
     * Creates a dead code marker for the given file at the given position.
     * 
     * @param file - the Java source file in which the dead code resides
     * @param deadcodePosition - the position where the dead code is located
     * @return the dead code marker created
     * @throws CoreException
     */
    public static IMarker createMarker(IFile file, Position deadcodePosition) throws CoreException {
        IMarker marker = file.createMarker(TYPE);
        int offset = deadcodePosition.getOffset();
        int length = deadcodePosition.getLength();
        marker.setAttributes(
            new String[] {IMarker.CHAR_START, IMarker.CHAR_END, IMarker.MESSAGE},
            new Object[] {new Integer(offset), new Integer(offset + length), "deadcode"});
        return marker;
    }

    
}
