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

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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

/**
 * A marker processor that stores project-wide info on tainted data and dead code. For each 
 * Java source file, it designates a ClassMarkerProcessor to show the the taint markers and 
 * dead code markers in the Java class.
 * 
 * @author gilham
 *
 */
public class ProjectMarkerProcessor {

    /**
     * A map from projects to the corresponding ProjectMarkerProcessor instances.
     */
    private static Map<IProject, ProjectMarkerProcessor> instanceMap = new HashMap<IProject, ProjectMarkerProcessor>();

    /**
     * The underlying project whose taint markers and dead code markers are
     * being processed by this ProjectMarkerProcessor.
     */
    private IProject fProject;

    /**
     * A map from class names in the underlying project to the corresponding
     * ClassMarkerProcessor instances.
     */
    private Map<String, ClassMarkerProcessor> fClassProcessorMap;

    /**
     * The security spec model for the underlying project.
     */
    private SecuritySpecModel fSecuritySpec;
    
    /**
     * A map from info source kinds in the security spec model
     * to the corresponding sets of info sources.
     */
    private Map<String,Set<CallLocationModel>> fTaintSourcesMap;
    
    /**
     * A map from filtered info source kinds in the security spec model
     * to the corresponding sets of filtered info sources.
     */
    private Map<String,Set<CallLocationModel>> fFilteredTaintSourcesMap;

    /**
     * A map from class names, method ids, method line ranges, and tainted variables/fields to the 
     * corresponding sets of info sources that flow through the tainted variables/fields.
     */
    private Map<String, Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>>> fTaintedDataMap;
    
    /**
     * A map from class names and method ids to the corresponding sets of source line ranges 
     * of unreachable methods.
     */
    private Map<String, Map<String, Set<IntRange>>> fUnreachableSourceMethodMap;
    
    /**
     * The names of the classes whose droidsafe text markers have been processed.
     */
    private Set<String> fProcessedClasses;

    /**
     * The names of the classes whose droidsafe text markers need to be updated.
     */
    private Set<String> fClassesNeedUpdate;

    /**
     * Constructs a ProjectMarkerProcessor for the given project.
     * 
     * @param project - the underlying project
     */
    public ProjectMarkerProcessor(IProject project) {
        fProject = project;
    }
    
    /**
     * Returns the ProjectMarkerProcessor instance associated with the given project.
     * Creates a new instance if one does not yet exist.
     * 
     * @param project - a project
     * @return
     */
    public static ProjectMarkerProcessor get(IProject project) {
        ProjectMarkerProcessor processor = instanceMap.get(project);
        if (processor == null) {
            processor = new ProjectMarkerProcessor(project);
            instanceMap.put(project, processor);
        }
        return processor;
    }

    /**
     * Returns the ClassMarkerProcessor instance associated with the given class name.
     * Create a new ClassMarkerProcessor instance if one does not yet exist.
     * 
     * @param className - the name of a class
     * @return
     */
    public ClassMarkerProcessor get(String className) {
        ClassMarkerProcessor processor = fClassProcessorMap.get(className);
        if (processor == null) {
            processor = new ClassMarkerProcessor(this, className);
            fClassProcessorMap.put(className, processor);
        }
        return processor;
    }

    /**
     * Returns the Java class name for the given Java source file.
     * 
     * @param file - a Java source file
     * @return
     */
    public String getClassName(IFile file) {
        return DroidsafePluginUtilities.getClassName(fProject, file);
    }

    /**
     * Initializes the fields using the information stored in the given security
     * spec model.  Displays the droidsafe text markers for the currently viewed
     * Java source in the editor if the Java class belongs to the underlying project.
     * 
     * @param securitySpec
     */
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
    
    /**
     * Displays the annotations of the droidsafe text markers for the currently viewed Java source
     * in the given Java editor.
     * 
     * @param editor - a Java editor
     */
    public void showDroidsafeTextMarkers(IEditorPart editor) {
    	IFile file = DroidsafePluginUtilities.getEditorInputFile(editor);
    	if (file != null) {
    		String className = getClassName(file);
    		if (className != null)
    			showDroidsafeTextMarkers(editor, className);
    	}
    }

    /**
     * Displays the annotations of the droidsafe text markers for the given class name
     * in the given Java editor.
     * 
     * @param openedEditor - the opened Java editor
     * @param className - the name of a Java class whose source is being viewed in the Java editor
     */
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

    /**
     * Returns the map from info source kinds in the security spec model
     * to the corresponding sets of info sources.
     */
    public Map<String,Set<CallLocationModel>>  getTaintSourcesMap() {
    	return fTaintSourcesMap;
    }

    /**
     * Returns the map from filtered info source kinds in the security spec model
     * to the corresponding sets of filtered info sources.
     * 
     * @return the filtered taint sources map
     */
    public Map<String,Set<CallLocationModel>>  getFilteredTaintSourcesMap() {
    	return (fFilteredTaintSourcesMap.isEmpty()) ? Collections.EMPTY_MAP : fFilteredTaintSourcesMap;
    }

    /**
     * Computes the map from filtered info source kinds in the security spec model
     * to the corresponding sets of filtered info sources.  Returns the resulting map.
     * 
     * @return the filtered taint sources map
     */
    private Map<String, Set<CallLocationModel>> computeFilteredTaintSourcesMap(IMarker marker) {
    	Set<CallLocationModel> sources = TaintMarker.getSources(marker);
    	return computeFilteredTaintSourcesMap(sources);
    }

    /**
     * Given a set of info sources, computes the set of filtered info sources using the filtering info
     * stored in the field fFilteredTaintSourcesMap.  Returns the resulting set of filtered info sources.
     * 
     * @param sources - a set of info sources
     * @return resulting set of filtered info sources
     */
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

    /**
     * Locates the taint marker at the given offset with the given length in the given Java source file.
     * Returns the taint marker if found, otherwise returns null.
     *  
     * @param file - a Java source file
     * @param offset - a character offset in the source file
     * @param length - the character length of the taint marker
     * @return the taint marker or null if not found
     */
    public IMarker findTaintMarker(IFile file, int offset, int length) {
    	String className = getClassName(file);
    	if (className != null) {
    		ClassMarkerProcessor processor = get(className);
    		if (processor != null)
    			return processor.findTaintMarker(offset, length);
    	}
    	return null;
    }

    /**
     * Sets the filtered taint sources map to the new value 'newFilteredTaintSourcesMap'.
     * Updates the taint markers in the currently viewed class in given editor according to the new 
     * filtered sources map.  Adds other not currently viewed classes to the field 'fClassesNeedUpdate'
     * so their taint markers can be updated when they become active.
     * 
     * @param editor - a Java source editor
     * @param newFilteredTaintSourcesMap - new value for the filtered taint source map
     */
    public void setFilteredTaintSources(ITextEditor editor, Map<String,Set<CallLocationModel>>  newFilteredTaintSourcesMap) {
    	fFilteredTaintSourcesMap = newFilteredTaintSourcesMap;
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

    /**
     * Returns the map from class names, method ids, method line ranges, and tainted variables/fields to the 
     * corresponding sets of info sources that flow through the tainted variables/fields.
     */
    public Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>> getTaintedDataMap(String className) {
    	return fTaintedDataMap.get(className);
    }

    /**
     * Returns the underlying project for this ProjectMarkerProcessor.
     * 
     * @return the underlying project
     */
    public IProject getProject() {
    	return fProject;
    }

    /**
     * Returns the map from class names and method ids to the corresponding sets of source line ranges 
     * of unreachable methods.
     */
    public Map<String, Set<IntRange>> getUnreachableSourceMethodMap(
    		String className) {
    	return fUnreachableSourceMethodMap.get(className);
    }

}
