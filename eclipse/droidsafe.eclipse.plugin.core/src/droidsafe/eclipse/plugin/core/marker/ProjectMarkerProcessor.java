package droidsafe.eclipse.plugin.core.marker;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.SecuritySpecModel;
import droidsafe.utils.IntRange;

public class ProjectMarkerProcessor {

    private static Map<IProject, ProjectMarkerProcessor> instanceMap = new HashMap<IProject, ProjectMarkerProcessor>();

    private Map<String, ClassMarkerProcessor> classProcessorMap = new HashMap<String, ClassMarkerProcessor>();

    private IProject fProject;

    private List<String> fTaintKinds;
    private Set<String> fFilteredTaintKinds;
    private Map<String, Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>>> fTaintedDataMap;
    private Map<String, Map<String, Set<IntRange>>> fUnreachableSourceMethodMap;
    
    private Set<String> fProcessedClasses;

    private Set<String> fClassesNeedUpdate;

	private static Set<IEditorPart> editorsListenedTo = new HashSet<IEditorPart>();

    public ProjectMarkerProcessor(IProject project) {
        fProject = project;
    }
    
    public static ProjectMarkerProcessor get(IProject project) {
        ProjectMarkerProcessor processor = instanceMap.get(project);
        if (processor == null) {
            processor = new ProjectMarkerProcessor(project);
            instanceMap.put(project, processor);
        }
        return processor;
    }

    public ClassMarkerProcessor get(String className) {
        ClassMarkerProcessor processor = classProcessorMap.get(className);
        if (processor == null) {
            processor = new ClassMarkerProcessor(this, className);
            classProcessorMap.put(className, processor);
        }
        return processor;
    }

    public String getClassName(IFile file) {
        if (file != null && fTaintedDataMap != null) {
            for (String className: fTaintedDataMap.keySet()) {
                if (file.equals(DroidsafePluginUtilities.getFile(fProject, className))) {
                    return className;
                };
            }
        }
        return null;
    }

    public void init(SecuritySpecModel securitySpec) {
        fTaintedDataMap = securitySpec.getTaintedDataMap();
        fUnreachableSourceMethodMap = securitySpec.getUnreachableSourceMethodMap();
        if (fTaintedDataMap != null && fUnreachableSourceMethodMap != null) {
        	if (!fTaintedDataMap.isEmpty() || !fUnreachableSourceMethodMap.isEmpty()) {
        		fTaintKinds = securitySpec.getTaintKinds();
        		fFilteredTaintKinds = new TreeSet<String>(fTaintKinds);
        		fProcessedClasses = new HashSet<String>();
        		fClassesNeedUpdate = new HashSet<String>();
        		IEditorPart editor = DroidsafePluginUtilities.getActiveEditor();
        		if (editor != null) {
        			if (!editorsListenedTo.contains(editor)) {
        				addInputChangedListenerToEditor(editor);
        				editorsListenedTo.add(editor);
        			}
        			showDroidsafeAnnotations(editor);
         		}
        	}
        }
    }
    
    private static void addInputChangedListenerToEditor(final IEditorPart editor) {
		editor.addPropertyListener(new IPropertyListener() {

			@Override
			public void propertyChanged(Object source, int propId) {
				if (propId == IEditorPart.PROP_INPUT) {
					IProject project = DroidsafePluginUtilities.getSelectedProject();
					if (project != null) {
						ProjectMarkerProcessor projectMarkerProcessor = get(project);
						projectMarkerProcessor.showDroidsafeAnnotations(editor);
					}
				}
			}});
		
		((EditorPart)editor).addPartPropertyListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {
				String prop = event.getProperty();
				
			}});
    	
    }

    public void showDroidsafeAnnotations(IEditorPart editor) {
    	IFile file = DroidsafePluginUtilities.getEditorInputFile(editor);
    	if (file != null) {
    		String className = getClassName(file);
    		if (className != null)
    			showDroidsafeAnnotations(editor, className);
    	}
    }

    public void showDroidsafeAnnotations(IEditorPart openedEditor, String className) {
    	if (openedEditor != null && openedEditor instanceof ITextEditor && fProcessedClasses != null) {
    		ITextEditor editor = (ITextEditor) openedEditor;
    		if (fProcessedClasses.contains(className)) {
    			if (fClassesNeedUpdate.contains(className)) {
    				ClassMarkerProcessor classProcessor = get(className);
    				classProcessor.updateTaintMarkerAnnotations(editor);
    				fClassesNeedUpdate.remove(className);
    			}
    		} else {
    			fProcessedClasses.add(className);
    			Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>> classTaintedDataMap = fTaintedDataMap.get(className);
    			Map<String, Set<IntRange>> classUnreachableMethodMap = fUnreachableSourceMethodMap.get(className);
    			if (classTaintedDataMap != null || classUnreachableMethodMap != null) {
    				IEditorInput input = editor.getEditorInput();
    				if (input instanceof FileEditorInput) {
    					ClassMarkerProcessor classProcessor = get(className);
    					classProcessor.addDroidsafeAnnotations(editor);
    				}
    			}
    		}
    	}
    }

    public List<String> getTaintKinds() {
    	return fTaintKinds;
    }

    public Set<String> getFilteredTaintKinds() {
    	return (fFilteredTaintKinds.isEmpty()) ? Collections.EMPTY_SET : fFilteredTaintKinds;
    }

    private Set<CallLocationModel> computeFilteredTaintSources(IMarker marker) {
    	Set<CallLocationModel> sources = TaintMarker.getSources(marker);
    	return computeFilteredTaintSources(sources);
    }

    Set<CallLocationModel> computeFilteredTaintSources(Set<CallLocationModel> sources) {
    	if (!sources.isEmpty()) {
    		if (fFilteredTaintKinds != null && !fFilteredTaintKinds.isEmpty()) {
    			Set<CallLocationModel> filteredSources = new TreeSet<CallLocationModel>();
    			for (CallLocationModel source: sources) {
    				for (String kind: source.getInfoKinds()) {
    					if (fFilteredTaintKinds.contains(kind)) {
    						filteredSources.add(source);
    						break;
    					}
    				}
    			}
    			return filteredSources;
    		}
    	}
    	return Collections.EMPTY_SET;
    }

    public IMarker findTaintMarker(IFile file, int offset, int length) {
    	String className = getClassName(file);
    	if (className != null) {
    		ClassMarkerProcessor processor = get(className);
    		if (processor != null)
    			return processor.findTaintMarker(offset, length);
    	}
    	return null;
    }

    public void setFilteredTaintSources(ITextEditor editor, Set<String> newFilteredTaintKinds) {
    	fFilteredTaintKinds = newFilteredTaintKinds;
    	IFile file = DroidsafePluginUtilities.getEditorInputFile(editor);
    	String activeClassName = null;
    	if (file != null) {
    		String className = getClassName(file);
    		if (className != null) {
    			ClassMarkerProcessor processor = get(className);
    			processor.updateTaintMarkerAnnotations(editor);
    			activeClassName = className;
    		}
    	}
    	for (String className: fProcessedClasses) {
    		if (!className.equals(activeClassName)) {
    			fClassesNeedUpdate .add(className);
    		}
    	}
    }

    public Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>> getTaintedDataMap(String className) {
    	return fTaintedDataMap.get(className);
    }

    public IProject getProject() {
    	return fProject;
    }

    public Map<String, Set<IntRange>> getUnreachableSourceMethodMap(
    		String className) {
    	return fUnreachableSourceMethodMap.get(className);
    }

}
