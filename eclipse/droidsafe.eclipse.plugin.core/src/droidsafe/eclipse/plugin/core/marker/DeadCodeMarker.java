package droidsafe.eclipse.plugin.core.marker;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.Position;

public class DeadCodeMarker {

    //Marker ID
    public static final String TYPE = "droidsafe.deadcode.marker";
    
    //Annotation ID
    public static final String ANNOTATION = "droidsafe.deadcode";
    
    /*
     * Creates a dead code marker
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
