package droidsafe.eclipse.plugin.core.marker;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;

public class DroidsafeFileMarker {
	private List<IMarker> markers = new ArrayList<IMarker>();  
	
	
	public DroidsafeFileMarker() { 
		
	}
	
	
	public void deleteMarkers() { 
		for (IMarker marker : this.markers){
			try { 
			marker.delete();
			} catch (CoreException ex){
				ex.printStackTrace();
			}
		}		
	}
	
	public void addMarker(IMarker marker){
		markers.add(marker);
	}
}
