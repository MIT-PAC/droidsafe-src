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
