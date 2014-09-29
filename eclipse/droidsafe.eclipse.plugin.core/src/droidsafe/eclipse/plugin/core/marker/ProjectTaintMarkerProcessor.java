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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.SecuritySpecModel;
import droidsafe.speclang.model.TaintInfo;
import droidsafe.utils.IntRange;

public class ProjectTaintMarkerProcessor {

    private static Map<IProject, ProjectTaintMarkerProcessor> instanceMap = new HashMap<IProject, ProjectTaintMarkerProcessor>();

    private Map<String, ClassTaintMarkerProcessor> fileProcessorMap = new HashMap<String, ClassTaintMarkerProcessor>();

    private IProject fProject;

    private List<String> fTaintKinds;
    private Set<String> fFilteredTaintKinds;
    private Map<String, Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>>> fTaintedDataMap;
    
    private Set<String> fProcessedClasses;

    private Set<String> fClassesNeedUpdate;

    public ProjectTaintMarkerProcessor(IProject project) {
        fProject = project;
    }
    
    public static ProjectTaintMarkerProcessor get(IProject project) {
        ProjectTaintMarkerProcessor processor = instanceMap.get(project);
        if (processor == null) {
            processor = new ProjectTaintMarkerProcessor(project);
            instanceMap.put(project, processor);
        }
        return processor;
    }

    public ClassTaintMarkerProcessor get(String className) {
        ClassTaintMarkerProcessor processor = fileProcessorMap.get(className);
        if (processor == null) {
            processor = new ClassTaintMarkerProcessor(this, className);
            fileProcessorMap.put(className, processor);
        }
        return processor;
    }

    public String getClassName(IFile file) {
        if (file != null) {
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
        if (fTaintedDataMap != null && !fTaintedDataMap.isEmpty()) {
            fTaintKinds = securitySpec.getTaintKinds();
            fFilteredTaintKinds = new TreeSet<String>(fTaintKinds);
            fProcessedClasses = new HashSet<String>();
            fClassesNeedUpdate = new HashSet<String>();
            IEditorPart editor = DroidsafePluginUtilities.getActiveEditor();
            if (editor != null) {
                IFile file = DroidsafePluginUtilities.getEditorInputFile(editor);
                if (file != null) {
                    String className = getClassName(file);
                    if (className != null)
                        showTaintedData(editor, className);
                }
            }
        }
    }

    public void showTaintedData(IEditorPart openedEditor, String className) {
        if (openedEditor != null && openedEditor instanceof ITextEditor) {
            ITextEditor editor = (ITextEditor) openedEditor;
            if (fProcessedClasses.contains(className)) {
                if (fClassesNeedUpdate.contains(className)) {
                    ClassTaintMarkerProcessor fileProcessor = get(className);
                    fileProcessor.updateTaintMarkerAnnotations(editor);
                    fClassesNeedUpdate.remove(className);
                }
            } else {
                fProcessedClasses.add(className);
                Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>> classTaintedDataMap = fTaintedDataMap.get(className);
                if (classTaintedDataMap != null) {
                    IEditorInput input = editor.getEditorInput();
                    if (input instanceof FileEditorInput) {
                        ClassTaintMarkerProcessor fileProcessor = get(className);
                        fileProcessor.annotateTaintedData(editor);
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
            ClassTaintMarkerProcessor processor = get(className);
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
                ClassTaintMarkerProcessor processor = get(className);
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

}
