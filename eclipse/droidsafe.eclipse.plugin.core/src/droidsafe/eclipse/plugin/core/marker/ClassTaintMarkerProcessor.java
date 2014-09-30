package droidsafe.eclipse.plugin.core.marker;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.internal.core.util.Util;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;

import droidsafe.analyses.value.VAUtils;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.infoflow.TaintSourcesViewPart;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.TaintInfo;
import droidsafe.utils.IntRange;

public class ClassTaintMarkerProcessor {

    private ProjectTaintMarkerProcessor fProjectProcessor;

    private Map<Position, Set<CallLocationModel>> fTaintSourcesMap;
    private Map<Position, SimpleMarkerAnnotation> fTaintAnnotationMap;
    private Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>> fTaintedDataMap;
    
    private IFile fFile;


    public ClassTaintMarkerProcessor(ProjectTaintMarkerProcessor projectProcessor, String className) {
        fProjectProcessor = projectProcessor;
        fFile = DroidsafePluginUtilities.getFile(projectProcessor.getProject(), className);
        fTaintedDataMap = projectProcessor.getTaintedDataMap(className);
        fTaintSourcesMap = new HashMap<Position, Set<CallLocationModel>>();
        fTaintAnnotationMap = new HashMap<Position, SimpleMarkerAnnotation>();
    }
    
    public List<String> getTaintKinds() {
        return fProjectProcessor.getTaintKinds();
    }
    
    public void annotateTaintedData(final IEditorPart openedEditor) {
        if (openedEditor instanceof ITextEditor) {
            final ITextEditor editor = (ITextEditor)openedEditor;
            computeTaintSourcesMap(editor);
            WorkspaceModifyOperation op = new WorkspaceModifyOperation() {

                @Override
                protected void execute(IProgressMonitor monitor) throws CoreException {
                    Map<Annotation, Position> annotationsToAdd = createTaintMarkers();
                    AnnotationModel annotationModel = getAnnotationModel(editor);
                    updateAnnotationModel(annotationModel, new Annotation[0], annotationsToAdd);
                }
            };

            try {
                op.run(null);
            } catch (InvocationTargetException ex) {
                DroidsafePluginUtilities.error("Error in annotating tainted data");
            } catch (InterruptedException e) {
                Assert.isTrue(false, "this operation can not be canceled");
            }
        }
    }

    private void computeTaintSourcesMap(ITextEditor editor) {
        IDocumentProvider documentProvider = editor.getDocumentProvider();
        IEditorInput input = editor.getEditorInput();
        IDocument document = documentProvider.getDocument(input);
        ITypeRoot typeRoot = JavaUI.getEditorInputTypeRoot(editor.getEditorInput());
        ICompilationUnit icu = (ICompilationUnit) typeRoot.getAdapter(ICompilationUnit.class);
        ASTParser parser = ASTParser.newParser(AST.JLS4);
        parser.setSource(icu);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        parser.setResolveBindings(true);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        TaintVisitor visitor = new TaintVisitor(document);
        cu.accept(visitor);
    }

    private Map<Annotation, Position> createTaintMarkers() {
        final Map<Annotation, Position> annotationsToAdd = new HashMap<Annotation, Position>();
        for (Position pos: fTaintSourcesMap.keySet()) {
            Set<CallLocationModel> sources = fTaintSourcesMap.get(pos);
            Set<CallLocationModel> filteredSources = fProjectProcessor.computeFilteredTaintSources(sources);
            if (!filteredSources.isEmpty()) {
                try {
                    IMarker marker = TaintMarker.createMarker(fFile, pos, sources, filteredSources);
                    SimpleMarkerAnnotation annotation = new SimpleMarkerAnnotation(TaintMarker.ANNOTATION, marker);
                    annotationsToAdd.put(annotation, pos);
                    fTaintAnnotationMap.put(pos, annotation);
                } catch (CoreException e) {
                    DroidsafePluginUtilities.error("Failed to create taint marker at " + pos);
                    e.printStackTrace();
                }
            }
        }
        return annotationsToAdd;
    }

    private AnnotationModel getAnnotationModel(ITextEditor editor) {
        IDocumentProvider documentProvider = editor.getDocumentProvider();
        IEditorInput input = editor.getEditorInput();
        AnnotationModel annotationModel = (AnnotationModel) documentProvider.getAnnotationModel(input);
        return annotationModel;
    }
    
    public Set<String> getFilteredTaintKinds() {
        return fProjectProcessor.getFilteredTaintKinds();
    }
    
    public IMarker findTaintMarker(int offset, int length) {
            SimpleMarkerAnnotation annotation = fTaintAnnotationMap.get(new Position(offset, length));
            if (annotation != null)
                return annotation.getMarker();
        return null;
    }
    
    class TaintVisitor extends ASTVisitor {
        
        IDocument document;
        
        //int depth = 0;
        
        Stack<Map<String, Set<CallLocationModel>>> dataMapStack = new Stack<Map<String, Set<CallLocationModel>>>();

        TaintVisitor(IDocument document) {
            this.document = document;
        }

        public boolean visit(MethodDeclaration node) {
            //depth++;
            boolean isConstr = node.isConstructor();
            String methodName = node.getName().getIdentifier();
            if (isConstr) {
                methodName = methodName + getParamsSig(node);
            }
            Map<IntRange, Map<String, Set<CallLocationModel>>> rangeMap = fTaintedDataMap.get(methodName);
            if (rangeMap != null) {
                int offset = node.getStartPosition();
                int length = node.getLength();
                int startLine;
                try {
                    startLine = document.getLineOfOffset(offset);
                    int endLine = document.getLineOfOffset(offset + length - 1) + 1;
                    for (IntRange range: rangeMap.keySet()) {
                        int min = range.min;
                        int max = range.max;
                        if ((min >= startLine && max <= endLine) || 
                                (isConstr && !(min > endLine || max < startLine))) {
                            Map<String, Set<CallLocationModel>> dataMap = rangeMap.get(range);
                            dataMapStack.push(dataMap);
                            return true;
                        }
                    }
                } catch (BadLocationException e) {
                    DroidsafePluginUtilities.showError("Error", "Error in visiting method declaration", e);
                    e.printStackTrace();
                }
            } 
            dataMapStack.push(Collections.EMPTY_MAP);
            // there might be nested method declarations (for anonymous class) containing taints
            return true;
        }

        public void endVisit(MethodDeclaration node) {
            dataMapStack.pop();
        }

        private String getParamsSig(MethodDeclaration node) {
            List params = node.parameters();
            int size = params.size();
            StringBuffer buffer = new StringBuffer();
            buffer.append("(");
            for (int i = 0; i < size; i++) {
                SingleVariableDeclaration parameter = (SingleVariableDeclaration) params.get(i);
                String typeSig = Util.getSignature(parameter.getType());
                int extraDimensions = parameter.getExtraDimensions();
                if (node.isVarargs() && i == size-1)
                  extraDimensions++;
                if (i > 0)
                    buffer.append(",");
                buffer.append(Signature.createArraySignature(typeSig, extraDimensions));
            }
            buffer.append(")");
            return buffer.toString().intern();
        }

        public boolean visit(SimpleName node) {
            collectTaint(node, true);
            return false;
        }
        
        public boolean visit(QualifiedName node) {
            collectTaint(node, false);
            return false;
        }
        
        public boolean visit(FieldAccess node) {
            collectTaint(node, false);
            return false;
        }
        
        private boolean collectTaint(ASTNode node, boolean isSimpleNode) {
            boolean foundTaint = false;
            if (!dataMapStack.empty()) {
                Map<String, Set<CallLocationModel>> dataMap = dataMapStack.peek();
                if (!dataMap.isEmpty()) {
                    String nodeString = node.toString();
                    foundTaint = collectTaint(node, nodeString, dataMap);
                    if (!foundTaint && isSimpleNode)
                        foundTaint = collectTaint(node, "this."+nodeString, dataMap);
                }
            }
            return foundTaint;
        }

        private boolean collectTaint(ASTNode node, String nodeString, Map<String, Set<CallLocationModel>> dataMap) {
            Set<CallLocationModel> sources = dataMap.get(nodeString);
            if (sources != null && !sources.isEmpty()) {
                int offset = node.getStartPosition();
                int length = node.getLength();
                Position pos = new Position(offset, length);
                fTaintSourcesMap.put(pos, sources);
                return true;
            }
            return false;
        }
    }

    void updateTaintMarkerAnnotations(ITextEditor editor) {
        final AnnotationModel annotationModel = getAnnotationModel(editor);
        final TaintSourcesViewPart sourceView = TaintSourcesViewPart.findView();
        WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
            @Override
            protected void execute(IProgressMonitor monitor) throws CoreException {
                IMarker sourceViewMarker = (sourceView == null) ? null : sourceView.getMarker();
                boolean sourceViewMarkerUpdated = false;
                boolean sourceViewMarkerRemoved = false;
                //iamf.connect(document);
                Set<Annotation> annotationsToRemove = new HashSet<Annotation>();
                Map<Annotation, Position> annotationsToAdd = new HashMap<Annotation, Position>();
                for (Position taintPosition: fTaintSourcesMap.keySet()) {
                    SimpleMarkerAnnotation annotation = fTaintAnnotationMap.get(taintPosition);
                    Set<CallLocationModel> sources = fTaintSourcesMap.get(taintPosition);
                    Set<CallLocationModel> newFilteredSources = fProjectProcessor.computeFilteredTaintSources(sources);
                    try {
                        if (annotation == null) {
                            if (!newFilteredSources.isEmpty()) {
                                IMarker marker = TaintMarker.createMarker(fFile, taintPosition, sources, newFilteredSources);
                                annotation = new SimpleMarkerAnnotation(TaintMarker.ANNOTATION, marker);
                                fTaintAnnotationMap.put(taintPosition, annotation);
                                annotationsToAdd.put(annotation, taintPosition);
                            }
                        } else {
                            IMarker marker = annotation.getMarker();
                            Set<CallLocationModel> oldFilteredSources = TaintMarker.getFilteredSources(marker);
                            if (!newFilteredSources.equals(oldFilteredSources)) {
                                if (newFilteredSources.isEmpty()) {
                                    if (marker == sourceViewMarker)
                                        sourceViewMarkerRemoved = true;
                                    fTaintAnnotationMap.remove(taintPosition);
                                    annotationsToRemove.add(annotation);
                                    marker.delete();
                                } else {
                                    marker.setAttribute(TaintMarker.FILTERED_SOURCES, newFilteredSources);
                                    if (marker == sourceViewMarker)
                                        sourceViewMarkerUpdated = true;
                                }
                            }
                        }
                    } catch (CoreException e) {
                        DroidsafePluginUtilities.showError("Error", "Error in updating taint marker annotions", e);
                        e.printStackTrace();
                    }
                }
                updateAnnotationModel(annotationModel, annotationsToRemove.toArray(new SimpleMarkerAnnotation[0]), annotationsToAdd);
                if (sourceViewMarkerRemoved) {
                    sourceView.reset();
                } else if (sourceViewMarkerUpdated) {
                    sourceView.updateView(true);
                }
            }
        };

        try {
            op.run(null);
        } catch (InvocationTargetException ex) {
            DroidsafePluginUtilities.error("Error in annotating tainted data");
        } catch (InterruptedException e) {
            Assert.isTrue(false, "this operation can not be canceled"); //$NON-NLS-1$
        }
    }
    
    private void updateAnnotationModel(AnnotationModel annotationModel, final Annotation[] annotationsToRemove, final Map<Annotation, Position> annotationsToAdd) {
        synchronized (annotationModel.getLockObject()) {
            annotationModel.replaceAnnotations(annotationsToRemove, annotationsToAdd);
        }
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
