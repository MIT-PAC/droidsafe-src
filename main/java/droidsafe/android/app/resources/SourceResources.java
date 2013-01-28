package droidsafe.android.app.resources;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import droidblaze.project.Messages;
import droidblaze.project.analyses.AnalysisTarget;

public class SourceResources extends AnalysisTarget {
	private boolean resolved = false;
	private Application manifest;
	
	public void setManifest(Application am) {
		resolved = true;
		this.manifest = am;
	}
	
	/**
	 * Given the integer id of a view or layout in the resource class,
	 * return the String identifier from the source xml file.
	 * 
	 * @param i Integer constant used in compiled resource class
	 * @return String ID from source xml
	 */
	public String findLayoutName(Integer i) {
		if (resolved) {
			String ret = manifest.resource_info.get(i); 
			return (ret == null ? "" : ret);
		}
		else 
			return "";
	}
	
	/**
	 * Find the ID of a layout.
	 * 
	 * @param l The layout object
	 * @return The ID
	 */
	public Integer findViewID(String l) {
		if (resolved) {
			return manifest.resource_info.inverse().get(l);
		} else
			return null;
	}
	
	public boolean isResolved() {
		return resolved;
	}
	
	/**
	 * Given the id of a layout called by setContentView(int), return 
	 * the handlers in a map of button (view) -> methog signature.
	 * 
	 * @param i The view ID that is the arg to setContentView
	 */
	public Map<Layout.View, String> getOnClickHandlers(Integer i) {
		if (resolved) {
			//find the layout
			String fullname = findLayoutName(i);
			
			//in the resource_info of application, entries are stored by component.name
			//we just want the name when searching for a layout
			String[] name_ext = fullname.split ("[.]", 2);
		    String name = name_ext[1];
		    
			if (name == null || name.equals("")) {
				Messages.print("Warning: name of layout null when analyzing setContentView()");
				return null;
			}
				
			Layout layout = manifest.find_layout_by_name(name);
			if (layout == null) {
				Messages.print("Warning: cannot find layout when analyzing setContentView()");
				return null;
			}
			
			HashMap<Layout.View, String> handlers = manifest.handlers.get(layout);
			if (handlers == null) 
				return new HashMap<Layout.View, String>();
			return handlers;
			
		} else  {
			//Messages.print("Unresolved!");
			return null;
		}
	}
	
	public void setResolved(boolean res) {
		resolved = res;
	}
	
    @Override
    public boolean printXML(PrintWriter out) {
        return true;
    }
}
