package droidsafe.eclipse.plugin.core.marker;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.ui.texteditor.IMarkerUpdater;

/**
 * A marker updater for taint markers.
 * 
 * @author gilham
 *
 */
public class TaintMarkerUpdater implements IMarkerUpdater {

	@Override
	public String[] getAttribute() {
          return null;
    }

    @Override
    public String getMarkerType() {
          //returns the marker type that we are interested in updating
          return TaintMarker.TYPE;
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
