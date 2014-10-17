package droidsafe.eclipse.plugin.core.marker;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.SecuritySpecModel;
import droidsafe.utils.IntRange;

public class ProjectMarkerProcessor {

    private static Map<IProject, ProjectMarkerProcessor> instanceMap = new HashMap<IProject, ProjectMarkerProcessor>();

    private Map<String, ClassMarkerProcessor> fClassProcessorMap;

    private IProject fProject;

    private SecuritySpecModel fSecuritySpec;
    
    private Map<String,Set<CallLocationModel>> fTaintSourcesMap;
    private Map<String,Set<CallLocationModel>> fFilteredTaintSourcesMap;
    private Map<String, Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>>> fTaintedDataMap;
    private Map<String, Map<String, Set<IntRange>>> fUnreachableSourceMethodMap;
    
    private Set<String> fProcessedClasses;

    private Set<String> fClassesNeedUpdate;

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
        ClassMarkerProcessor processor = fClassProcessorMap.get(className);
        if (processor == null) {
            processor = new ClassMarkerProcessor(this, className);
            fClassProcessorMap.put(className, processor);
        }
        return processor;
    }

    public String getClassName(IFile file) {
        return DroidsafePluginUtilities.getClassName(fProject, file);
    }

    public void init(SecuritySpecModel securitySpec) {
    	if (fSecuritySpec != null) {
    		for (String className: fProcessedClasses) {
    			ClassMarkerProcessor classProcessor = get(className);
    			classProcessor.removeAllDroidsafeTextMarkers();
    		}
    	}
    	fClassProcessorMap = new HashMap<String, ClassMarkerProcessor>();
    	fSecuritySpec = securitySpec;
        fTaintedDataMap = securitySpec.getTaintedDataMap();
        fUnreachableSourceMethodMap = securitySpec.getUnreachableSourceMethodMap();
        if (fTaintedDataMap != null && fUnreachableSourceMethodMap != null) {
        	if (!fTaintedDataMap.isEmpty() || !fUnreachableSourceMethodMap.isEmpty()) {
        		fTaintSourcesMap = securitySpec.getTaintSourcesMap();
        		fFilteredTaintSourcesMap = new TreeMap<String,Set<CallLocationModel>>(fTaintSourcesMap);
        		fProcessedClasses = new HashSet<String>();
        		fClassesNeedUpdate = new HashSet<String>();
        		IEditorPart editor = DroidsafePluginUtilities.getActiveEditor();
        		if (editor != null) {
        			showDroidsafeTextMarkers(editor);
         		}
        	}
        }
    }
    
    public void showDroidsafeTextMarkers(IEditorPart editor) {
    	IFile file = DroidsafePluginUtilities.getEditorInputFile(editor);
    	if (file != null) {
    		String className = getClassName(file);
    		if (className != null)
    			showDroidsafeTextMarkers(editor, className);
    	}
    }

    public void showDroidsafeTextMarkers(IEditorPart openedEditor, String className) {
    	if (openedEditor != null && openedEditor instanceof ITextEditor && fProcessedClasses != null) {
    		ITextEditor editor = (ITextEditor) openedEditor;
    		if (fProcessedClasses.contains(className)) {
    			if (fClassesNeedUpdate.contains(className)) {
    				ClassMarkerProcessor classProcessor = get(className);
    				classProcessor.updateTaintMarkers(editor);
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
    					classProcessor.showDroidsafeTextMarkers(editor);
    				}
    			}
    		}
    	}
    }

    public Map<String,Set<CallLocationModel>>  getTaintKinds() {
    	return fTaintSourcesMap;
    }

    public Map<String,Set<CallLocationModel>>  getFilteredTaintSourcesMap() {
    	return (fFilteredTaintSourcesMap.isEmpty()) ? Collections.EMPTY_MAP : fFilteredTaintSourcesMap;
    }

    private Map<String, Set<CallLocationModel>> computeFilteredTaintSourcesMap(IMarker marker) {
    	Set<CallLocationModel> sources = TaintMarker.getSources(marker);
    	return computeFilteredTaintSourcesMap(sources);
    }

    Map<String, Set<CallLocationModel>> computeFilteredTaintSourcesMap(Set<CallLocationModel> sources) {
    	if (!sources.isEmpty()) {
    		if (fFilteredTaintSourcesMap != null && !fFilteredTaintSourcesMap.isEmpty()) {
    			Map<String, Set<CallLocationModel>> result = new TreeMap<String, Set<CallLocationModel>>();
    			for (Entry<String, Set<CallLocationModel>> entry: fFilteredTaintSourcesMap.entrySet()) {
    				Set<CallLocationModel> filteredSources = new TreeSet<CallLocationModel>();
    				for (CallLocationModel source: entry.getValue()) {
    					if (sources.contains(source)) {
    						filteredSources.add(source);
    					}
    				}
    				if (!filteredSources.isEmpty()) {
    					String taintKind = entry.getKey();
    					result.put(taintKind, filteredSources);
    				}
    			}
        		return result;
    		}
    	}
    	return Collections.EMPTY_MAP;
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

    public void setFilteredTaintSources(ITextEditor editor, Map<String,Set<CallLocationModel>>  newFilteredTaintKinds) {
    	fFilteredTaintSourcesMap = newFilteredTaintKinds;
    	IFile file = DroidsafePluginUtilities.getEditorInputFile(editor);
    	String activeClassName = null;
    	if (file != null) {
    		String className = getClassName(file);
    		if (className != null) {
    			ClassMarkerProcessor processor = get(className);
    			processor.updateTaintMarkers(editor);
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
