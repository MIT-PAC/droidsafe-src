package droidsafe.eclipse.plugin.core.marker;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.Position;

import droidsafe.speclang.model.CallLocationModel;

public class TaintMarker {

    //Marker ID
    public static final String TYPE = "droidsafe.taintmarker";
    
    //Annotation ID
    public static final String ANNOTATION = "droidsafe.taint";
    
    public static final String SOURCES = "sources";
    
    public static final String FILTERED_SOURCES = "filteredSources";
    
    /*
     * Creates a Taint Marker
     */
    public static IMarker createMarker(IFile file, Position taintPosition, Set<CallLocationModel> sources, 
                                       Set<CallLocationModel> filteredSources)
                                               throws CoreException {
        IMarker marker = file.createMarker(TYPE);
        int offset = taintPosition.getOffset();
        int length = taintPosition.getLength();
        marker.setAttributes(
            new String[] {IMarker.CHAR_START, IMarker.CHAR_END, IMarker.MESSAGE, SOURCES, FILTERED_SOURCES},
            new Object[] {new Integer(offset), new Integer(offset + length), "Taint", sources, filteredSources});
        return marker;
    }

    public static Set<CallLocationModel> getSources(IMarker marker) {
        try {
            Set<CallLocationModel> sources = (Set<CallLocationModel>) marker.getAttribute(SOURCES);
            return sources;
        } catch (CoreException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_SET;
    }
    
    public static Set<CallLocationModel> getFilteredSources(IMarker marker) {
        try {
            Set<CallLocationModel> sources = (Set<CallLocationModel>) marker.getAttribute(FILTERED_SOURCES);
            return sources;
        } catch (CoreException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_SET;
    }
    
    public static Set<String> getFilteredTaintKinds(IMarker marker) {
        Set<String> kinds = new TreeSet<String>();
        for (CallLocationModel source: TaintMarker.getFilteredSources(marker)) {
            Set<String> sourceKinds = source.getInfoKinds();
            if (sourceKinds != null)
                kinds.addAll(sourceKinds);
        }
        return kinds;
    }

}
