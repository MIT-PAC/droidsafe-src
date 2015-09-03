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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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

/**
 * A marker processor that stores information on tainted data and dead code in
 * a Java class and displays the annotations for the corresponding taint markers and 
 * dead code markers.
 * 
 * @author gilham
 *
 */
public class ClassMarkerProcessor {

    /**
     * The ProjectMarkerProcessor instance for the project that contains the underlying Java class.
     */
    private ProjectMarkerProcessor fProjectProcessor;

    /**
     * The Java source file for the underlying Java class
     */
    private IFile fFile;

    /**
     * A map from method ids to the corresponding sets of source line ranges of
     * unreachable methods in the underlying Java class.
     */
    private Map<String, Set<IntRange>> fUnreachableSourceMethodMap;
    
    /**
     * The set of positions where the unreachable methods are located in the Java source file.
     */
    private Set<Position> fDeadCodePositions = new HashSet<Position>();

    /**
     * A map from method ids, method line ranges, and tainted variables/fields to the 
     * corresponding sets of info sources that flow through the tainted variables/fields.
     */
    private Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>> fTaintedDataMap;
    
    /**
     * A map from positions of the tainted data in Java source file
     * to the corresponding sets of info sources.
     */
    private Map<Position, Set<CallLocationModel>> fTaintSourcesMap = new HashMap<Position, Set<CallLocationModel>>();
    
    /**
     * A map from positions of the tainted data in Java source file
     * to the corresponding taint marker annotations.
     */
    private Map<Position, SimpleMarkerAnnotation> fTaintAnnotationMap = new HashMap<Position, SimpleMarkerAnnotation>();
    
    /**
     * A set of marker annotations for the dead code markers associated with the underlying Java class.
     */
    private Set<SimpleMarkerAnnotation> fDeadCodeAnnotations = new HashSet<SimpleMarkerAnnotation>();

	/**
	 * The Java editor in which the java source for the underlying class is being viewed.
	 */
	private ITextEditor fEditor;

    /**
     * Constructs a ClassMarkerProcessor given a ProjectMarkerProcessor for the current project
     * and the name for the underlying Java class.
     * 
     * @param projectProcessor - the project marker processor for the current project
     * @param className - the name for the underlying Java class
     */
    public ClassMarkerProcessor(ProjectMarkerProcessor projectProcessor, String className) {
        fProjectProcessor = projectProcessor;
        fFile = DroidsafePluginUtilities.getFile(projectProcessor.getProject(), className);
        fTaintedDataMap = projectProcessor.getTaintedDataMap(className);
        fUnreachableSourceMethodMap = projectProcessor.getUnreachableSourceMethodMap(className);
    }
    
    /**
     * Returns the map from info source kinds in the security spec model
     * to the corresponding sets of info sources.
     */
    public Map<String, Set<CallLocationModel>> getTaintSourcesMap() {
        return fProjectProcessor.getTaintSourcesMap();
    }
    
    /**
     * Creates taint markers, dead code markers, and the corresponding marker annotations.
     * Show the annotations in the given Java editor.
     * 
     * @param openedEditor the opened Java editor
     */
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

    /**
     * Given a Java editor, visits the AST representation of the associated Java source file
     * to compute info on the taint markers and dead code markers for the file. The results
     * are stored in the fields fTaintSourcesMap (map from tainted data positions to sets of 
     * taint sources) and fDeadCodePositions (set of dead code positions)
     * 
     * @param editor - the Java editor in which the Java source for the underlying class is 
     * being viewed
     */
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

    /**
     * Creates taint markers, dead code markers, and their annotations from the field values
     * of fTaintSourcesMap (map from tainted data positions to sets of taint sources) and 
     * fDeadCodePositions (set of dead code positions).  Returns a map from the created 
     * annotations to their positions in the Java source.
     * 
     * @return a map from the droidsafe text marker annotations to their positions
     */
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

    /**
     * Returns the annotation model associated with the given Java editor.
     * 
     * @param editor - a Java editor
     * @return the annotation model associated with the editor
     */
    private AnnotationModel getAnnotationModel(ITextEditor editor) {
        IDocumentProvider documentProvider = editor.getDocumentProvider();
        IEditorInput input = editor.getEditorInput();
        AnnotationModel annotationModel = (AnnotationModel) documentProvider.getAnnotationModel(input);
        return annotationModel;
    }
    
    /**
     * Returns the map from filtered info source kinds in the project
     * to the corresponding sets of filtered info sources.
     * 
     * @return the filtered taint sources map
     */
    public Map<String, Set<CallLocationModel>> getFilteredTaintSourcesMap() {
        return fProjectProcessor.getFilteredTaintSourcesMap();
    }
    
    /**
     * Returns the taint marker at the given offset and with the given length. Returns null if no
     * such taint marker is found.
     * 
     * @param offset - character offset for the taint marker
     * @param length - character length for the taint marker
     * @return the taint marker at the offset with the length
     */
    public IMarker findTaintMarker(int offset, int length) {
            SimpleMarkerAnnotation annotation = fTaintAnnotationMap.get(new Position(offset, length));
            if (annotation != null)
                return annotation.getMarker();
        return null;
    }
    
    /**
     * An AST visitor that visits the AST representation of the Java source, uses the values of 
     * fTaintedDataMap and fUnreachableSourceMethodMap to locate tainted data and dead code, and
     * updates the value of fTaintSourcesMap (map from tainted data positions to sets of taint 
     * sources) and fDeadCodePositions (set of dead code positions) accordingly.
     * 
     * @author gilham
     *
     */
    class DroidsafeTextMarkerVisitor extends ASTVisitor {
        
        /**
         * The document representing the text of the Java source.
         */
        IDocument document;
        
        /**
         * A stack of maps from tainted variable/field names to the corresponding sets of info sources.
         * Each map represents the tainted data info for a method. The top tainted data map of the stack 
         * represents the tainted data info for the method currently being visited.
         */
        Stack<Map<String, Set<CallLocationModel>>> taintedDataMapStack = new Stack<Map<String, Set<CallLocationModel>>>();

        /**
         * Constructs a DroidsafeTextMarkerVisitor for the given document.
         * 
         * @param document - an IDocument representing the text for a Java source file
         */
        DroidsafeTextMarkerVisitor(IDocument document) {
            this.document = document;
        }

        /**
         * Visits a method declaration node. Computes the method id and the line range of this method. Using these
         * to
         * 
         *   1) check against the unreachable source method map, and add the method position to fDeadCodePositions
         *      if this method is unreachable
         * 
         *   2) check against the tainted data map for an entry for this method, and push the corresponding data map
         *      to the tainted data map stack if found, otherwise push the empty map to the data map stack
         *      
         * @param node - a method declaration node 
         */
        public boolean visit(MethodDeclaration node) {
        	boolean isConstr = node.isConstructor();
        	String methodId = node.getName().getIdentifier();
        	if (isConstr) {
        		methodId = methodId + getParamsSig(node);
        	}
        	int offset = node.getStartPosition();
        	int length = node.getLength();
        	int startLine;
        	try {
        		startLine = document.getLineOfOffset(offset);
        		int endLine = document.getLineOfOffset(offset + length - 1) + 1;
        		if (fUnreachableSourceMethodMap != null) {
        			Set<IntRange> ranges = fUnreachableSourceMethodMap.get(methodId);
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
        			Map<IntRange, Map<String, Set<CallLocationModel>>> rangeMap = fTaintedDataMap.get(methodId);
        			if (rangeMap != null) {
        				for (IntRange range: rangeMap.keySet()) {
        					if (methodRangeMatches(startLine, endLine, isConstr, range)) {
        						Map<String, Set<CallLocationModel>> dataMap = rangeMap.get(range);
        						taintedDataMapStack.push(dataMap);
        						return true;
        					}
        				}
        			} 
        			taintedDataMapStack.push(Collections.EMPTY_MAP);
        		}
        	} catch (BadLocationException e) {
        		DroidsafePluginUtilities.showError("Error", "Error in visiting method declaration", e);
        		e.printStackTrace();
        	}

        	// there might be nested method declarations (for anonymous class) containing taints
        	return true;
        }
        
        /**
         * Given the start line number and end line number of a method node, and a boolean flag 
         * indicating whether the method is a constructor, checks to see whether this method contains 
         * the given source line range.
         * 
         * @param startLine - the start line number of the method node
         * @param endLine - the end line number of the method node
         * @param isConstr - true if and only if the method node represents a constructor
         * @param range - a line range
         * @return true if a match is found
         */
        private boolean methodRangeMatches(int startLine, int endLine, boolean isConstr, IntRange range) {
			int min = range.min;
			int max = range.max;
			return ((min >= startLine && max <= endLine) || 
					(isConstr && !(min > endLine || max < startLine)));
        }

        /**
         * Pops the top tainted data map for the method from the tainted data map stack after visiting
         * the given method node.
         *      
         * @param node - a method declaration node 
         */
        public void endVisit(MethodDeclaration node) {
        	if (!taintedDataMapStack.isEmpty())
        		taintedDataMapStack.pop();
        }

        /**
         * Computes and returns the parameter signature for the given method declaration node.
         * 
         * @param node - a method declaration node
         * @return the parameter signature for the method declaration node
         */
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

        /**
         * Visits a simple name node. Collect taint info if the node is a tainted variable or
         * field reference.
         * 
         * @param node - a simple name node
         * @return false
         */
        public boolean visit(SimpleName node) {
            collectTaint(node, true);
            return false;
        }
        
        /**
         * Visits a qualified name node. Collect taint info if the node is a tainted 
         * field reference.
         * 
         * @param node - a qualified name node
         * @return false
         */
        public boolean visit(QualifiedName node) {
            collectTaint(node, false);
            return false;
        }
        
        /**
         * Visits a field access node. Collect taint info if the node is a tainted 
         * field access.
         * 
         * @param node - a field access node
         * @return false
         */
           public boolean visit(FieldAccess node) {
            collectTaint(node, false);
            return false;
        }
        
        /**
         * If the given AST node is tainted, adds an entry to fTaintSourcesMap
         * and returns true.
         * 
         * @param node - an AST node
         * @param isSimpleName - whether the node is a simple name node
         * @return true if the given node is tainted
         */
        private boolean collectTaint(ASTNode node, boolean isSimpleName) {
            boolean foundTaint = false;
            if (!taintedDataMapStack.empty()) {
                Map<String, Set<CallLocationModel>> dataMap = taintedDataMapStack.peek();
                if (!dataMap.isEmpty()) {
                    String nodeString = node.toString();
                    foundTaint = collectTaint(node, nodeString, dataMap);
                    if (!foundTaint && isSimpleName)
                        foundTaint = collectTaint(node, "this."+nodeString, dataMap);
                }
            }
            return foundTaint;
        }

        /**
         * If the given AST node is tainted (the given dataMap contains the given key nodeString), updates
         * fTaintSourcesMap and returns true.
         * 
         * @param node - an AST node
         * @param nodeString - string representation of the node
         * @param dataMap - tainted data map for the current method
         * @return true if the AST node is tainted
         */
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

    /**
     * Given an editor, updates the taint markers and their annotations for the associated Java source 
     * according to the new filtered sources map.
     * 
     * @param editor - a Java editor
     */
    void updateTaintMarkers(final ITextEditor editor) {
        WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
            @Override
            protected void execute(IProgressMonitor monitor) throws CoreException {
                AnnotationModel annotationModel = getAnnotationModel(editor);
                TaintSourcesViewPart sourceView = TaintSourcesViewPart.findView();
                        IMarker sourceViewMarker = (sourceView == null) ? null : sourceView.getTaintMarker();
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
    
    /**
     * Updates the given annotation model by removing the annotations in annotationsToRemove
     * and adding the annotations in annotationsToAdd.
     * 
     * @param annotationModel - the annotation model to update
     * @param annotationsToRemove - the annotations to remove
     * @param annotationsToAdd - a map from annotations to add to their positions in the Java source file
     */
    private void updateAnnotationModel(AnnotationModel annotationModel, final Annotation[] annotationsToRemove, final Map<Annotation, Position> annotationsToAdd) {
        synchronized (annotationModel.getLockObject()) {
            annotationModel.replaceAnnotations(annotationsToRemove, annotationsToAdd);
        }
    }
    
	/**
	 * Removes all taint markers and dead code markers associated with the Java source file.
	 */
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
