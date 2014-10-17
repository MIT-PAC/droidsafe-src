package droidsafe.eclipse.plugin.core.marker;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
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

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.infoflow.TaintSourcesViewPart;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.utils.IntRange;

public class ClassMarkerProcessor {

    private ProjectMarkerProcessor fProjectProcessor;

    private IFile fFile;

    private Map<String, Set<IntRange>> fUnreachableSourceMethodMap;
    private Set<Position> fDeadCodePositions = new HashSet<Position>();

    private Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>> fTaintedDataMap;
    private Map<Position, Set<CallLocationModel>> fTaintSourcesMap = new HashMap<Position, Set<CallLocationModel>>();
    private Map<Position, SimpleMarkerAnnotation> fTaintAnnotationMap = new HashMap<Position, SimpleMarkerAnnotation>();
    private Set<SimpleMarkerAnnotation> fDeadCodeAnnotations = new HashSet<SimpleMarkerAnnotation>();

	private ITextEditor fEditor;

    public ClassMarkerProcessor(ProjectMarkerProcessor projectProcessor, String className) {
        fProjectProcessor = projectProcessor;
        fFile = DroidsafePluginUtilities.getFile(projectProcessor.getProject(), className);
        fTaintedDataMap = projectProcessor.getTaintedDataMap(className);
        fUnreachableSourceMethodMap = projectProcessor.getUnreachableSourceMethodMap(className);
    }
    
    public Map<String, Set<CallLocationModel>> getTaintKinds() {
        return fProjectProcessor.getTaintKinds();
    }
    
    public void showDroidsafeTextMarkers(final IEditorPart openedEditor) {
        if (openedEditor instanceof ITextEditor) {
        	fEditor = (ITextEditor)openedEditor;
            computeDroidsafeTextMarkerInfo(fEditor);
            WorkspaceModifyOperation op = new WorkspaceModifyOperation() {

                @Override
                protected void execute(IProgressMonitor monitor) throws CoreException {
                    Map<Annotation, Position> annotationsToAdd = createDroidsafeTextMarkers();
                    AnnotationModel annotationModel = getAnnotationModel(fEditor);
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

    private void computeDroidsafeTextMarkerInfo(ITextEditor editor) {
        IDocumentProvider documentProvider = editor.getDocumentProvider();
        IEditorInput input = editor.getEditorInput();
        IDocument document = documentProvider.getDocument(input);
        ITypeRoot typeRoot = JavaUI.getEditorInputTypeRoot(input);
        ICompilationUnit icu = (ICompilationUnit) typeRoot.getAdapter(ICompilationUnit.class);
        ASTParser parser = ASTParser.newParser(AST.JLS4);
        parser.setSource(icu);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        parser.setResolveBindings(true);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        DroidsafeTextMarkerVisitor visitor = new DroidsafeTextMarkerVisitor(document);
        cu.accept(visitor);
    }

    private Map<Annotation, Position> createDroidsafeTextMarkers() {
        final Map<Annotation, Position> annotationsToAdd = new HashMap<Annotation, Position>();
        for (Position pos: fTaintSourcesMap.keySet()) {
            Set<CallLocationModel> sources = fTaintSourcesMap.get(pos);
            Map<String, Set<CallLocationModel>> filteredSourcesMap = fProjectProcessor.computeFilteredTaintSourcesMap(sources);
            if (!filteredSourcesMap.isEmpty()) {
                try {
                    IMarker marker = TaintMarker.createMarker(fFile, pos, sources, filteredSourcesMap);
                    SimpleMarkerAnnotation annotation = new SimpleMarkerAnnotation(TaintMarker.ANNOTATION, marker);
                    annotationsToAdd.put(annotation, pos);
                    fTaintAnnotationMap.put(pos, annotation);
                } catch (CoreException e) {
                    DroidsafePluginUtilities.error("Failed to create taint marker at " + pos);
                    e.printStackTrace();
                }
            }
        }
        for (Position pos: fDeadCodePositions) {
        	try {
        		IMarker marker = DeadCodeMarker.createMarker(fFile, pos);
        		SimpleMarkerAnnotation annotation = new SimpleMarkerAnnotation(DeadCodeMarker.ANNOTATION, marker);
        		annotationsToAdd.put(annotation, pos);
        	} catch (CoreException e) {
        		DroidsafePluginUtilities.error("Failed to create dead code marker at " + pos);
        		e.printStackTrace();
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
    
    public Map<String, Set<CallLocationModel>> getFilteredTaintSourcesMap() {
        return fProjectProcessor.getFilteredTaintSourcesMap();
    }
    
    public IMarker findTaintMarker(int offset, int length) {
            SimpleMarkerAnnotation annotation = fTaintAnnotationMap.get(new Position(offset, length));
            if (annotation != null)
                return annotation.getMarker();
        return null;
    }
    
    class DroidsafeTextMarkerVisitor extends ASTVisitor {
        
        IDocument document;
        
        //int depth = 0;
        
        Stack<Map<String, Set<CallLocationModel>>> dataMapStack = new Stack<Map<String, Set<CallLocationModel>>>();

        DroidsafeTextMarkerVisitor(IDocument document) {
            this.document = document;
        }

        public boolean visit(MethodDeclaration node) {
            //depth++;
        	boolean isConstr = node.isConstructor();
        	String methodName = node.getName().getIdentifier();
        	if (isConstr) {
        		methodName = methodName + getParamsSig(node);
        	}
        	int offset = node.getStartPosition();
        	int length = node.getLength();
        	int startLine;
        	try {
        		startLine = document.getLineOfOffset(offset);
        		int endLine = document.getLineOfOffset(offset + length - 1) + 1;
        		if (fUnreachableSourceMethodMap != null) {
        			Set<IntRange> ranges = fUnreachableSourceMethodMap.get(methodName);
        			if (ranges != null) {
        				for (IntRange range: ranges) {
        					if (methodRangeMatches(startLine, endLine, isConstr, range)) {
        						Position pos = new Position(offset, length);
        						fDeadCodePositions.add(pos);
        						return false;
        					}
        				}
        			}
        		}
        		if (fTaintedDataMap != null) {
        			Map<IntRange, Map<String, Set<CallLocationModel>>> rangeMap = fTaintedDataMap.get(methodName);
        			if (rangeMap != null) {
        				for (IntRange range: rangeMap.keySet()) {
        					if (methodRangeMatches(startLine, endLine, isConstr, range)) {
        						Map<String, Set<CallLocationModel>> dataMap = rangeMap.get(range);
        						dataMapStack.push(dataMap);
        						return true;
        					}
        				}
        			} 
        			dataMapStack.push(Collections.EMPTY_MAP);
        		}
        	} catch (BadLocationException e) {
        		DroidsafePluginUtilities.showError("Error", "Error in visiting method declaration", e);
        		e.printStackTrace();
        	}

        	// there might be nested method declarations (for anonymous class) containing taints
        	return true;
        }
        
        private boolean methodRangeMatches(int startLine, int endLine, boolean isConstr, IntRange range) {
			int min = range.min;
			int max = range.max;
			return ((min >= startLine && max <= endLine) || 
					(isConstr && !(min > endLine || max < startLine)));
        }

        public void endVisit(MethodDeclaration node) {
        	if (!dataMapStack.isEmpty())
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

    void updateTaintMarkers(final ITextEditor editor) {
        WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
            @Override
            protected void execute(IProgressMonitor monitor) throws CoreException {
                AnnotationModel annotationModel = getAnnotationModel(editor);
                TaintSourcesViewPart sourceView = TaintSourcesViewPart.findView();
                        IMarker sourceViewMarker = (sourceView == null) ? null : sourceView.getMarker();
                boolean sourceViewMarkerUpdated = false;
                boolean sourceViewMarkerRemoved = false;
                //iamf.connect(document);
                Set<Annotation> annotationsToRemove = new HashSet<Annotation>();
                Map<Annotation, Position> annotationsToAdd = new HashMap<Annotation, Position>();
                for (Position taintPosition: fTaintSourcesMap.keySet()) {
                    SimpleMarkerAnnotation annotation = fTaintAnnotationMap.get(taintPosition);
                    Set<CallLocationModel> sources = fTaintSourcesMap.get(taintPosition);
                    Map<String, Set<CallLocationModel>> newFilteredSourcesMap = fProjectProcessor.computeFilteredTaintSourcesMap(sources);
                    try {
                        if (annotation == null) {
                            if (!newFilteredSourcesMap.isEmpty()) {
                                IMarker marker = TaintMarker.createMarker(fFile, taintPosition, sources, newFilteredSourcesMap);
                                annotation = new SimpleMarkerAnnotation(TaintMarker.ANNOTATION, marker);
                                fTaintAnnotationMap.put(taintPosition, annotation);
                                annotationsToAdd.put(annotation, taintPosition);
                            }
                        } else {
                            IMarker marker = annotation.getMarker();
                            Map<String, Set<CallLocationModel>> oldFilteredSources = TaintMarker.getFilteredTaintSourcesMap(marker);
                            if (!newFilteredSourcesMap.equals(oldFilteredSources)) {
                                if (newFilteredSourcesMap.isEmpty()) {
                                    if (marker == sourceViewMarker)
                                        sourceViewMarkerRemoved = true;
                                    fTaintAnnotationMap.remove(taintPosition);
                                    annotationsToRemove.add(annotation);
                                    marker.delete();
                                } else {
                                    marker.setAttribute(TaintMarker.FILTERED_SOURCES, newFilteredSourcesMap);
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
    
	public void removeAllDroidsafeTextMarkers() {
        WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
            @Override
            protected void execute(IProgressMonitor monitor) throws CoreException {
            	int depth = IResource.DEPTH_INFINITE;
            	fFile.deleteMarkers(TaintMarker.TYPE, true, depth);
            	fFile.deleteMarkers(DeadCodeMarker.TYPE, true, depth);
                AnnotationModel annotationModel = getAnnotationModel(fEditor);
                List<SimpleMarkerAnnotation> annotationsToRemove = new ArrayList<SimpleMarkerAnnotation>(fTaintAnnotationMap.values());
                annotationsToRemove.addAll(fDeadCodeAnnotations);
                updateAnnotationModel(annotationModel, annotationsToRemove.toArray(new Annotation[0]), Collections.EMPTY_MAP);
            }
        };
		
        try {
        	op.run(null);
        } catch (InvocationTargetException ex) {
        	DroidsafePluginUtilities.error("Error in removing droidsafe text markers from file " + fFile);
        } catch (InterruptedException e) {
        	Assert.isTrue(false, "this operation can not be canceled"); //$NON-NLS-1$
        }
	}

}
