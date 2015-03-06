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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.ui.texteditor.IMarkerUpdater;

/**
 * A marker updater for dead code markers.
 * 
 * @author gilham
 *
 */
public class DeadCodeMarkerUpdater implements IMarkerUpdater {

	@Override
	public String[] getAttribute() {
          return null;
    }

    @Override
    public String getMarkerType() {
          //returns the marker type that we are interested in updating
          return DeadCodeMarker.TYPE;
    }

    @Override
    public boolean updateMarker(IMarker marker, IDocument doc, Position position) {
          try {
                int start = position.getOffset();
                int end = position.getOffset() + position.getLength();
                marker.setAttribute(IMarker.CHAR_START, start);
                marker.setAttribute(IMarker.CHAR_END, end);
                return true;
          } catch (CoreException e) {
                return false;
          }
    }

}
