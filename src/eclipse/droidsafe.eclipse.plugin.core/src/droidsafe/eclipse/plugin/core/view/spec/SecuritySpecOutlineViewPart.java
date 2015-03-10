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

package droidsafe.eclipse.plugin.core.view.spec;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.State;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.util.Util;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.texteditor.ITextEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.dialogs.SearchDialog;
import droidsafe.eclipse.plugin.core.marker.ProjectMarkerProcessor;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementLabelProvider;
import droidsafe.eclipse.plugin.core.view.SpecInfoOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;
import droidsafe.eclipse.plugin.core.view.infoflow.InfoFlowDetailsViewPart;
import droidsafe.eclipse.plugin.core.view.infoflow.InfoFlowSummaryViewPart;
import droidsafe.eclipse.plugin.core.view.pointsto.PointsToViewPart;
import droidsafe.eclipse.plugin.core.view.spec.SecuritySpecTreeElementContentProvider.TopLevelParentEntity;
import droidsafe.eclipse.plugin.core.view.value.ValueViewPart;
import droidsafe.speclang.model.CodeLocationModel;
import droidsafe.speclang.model.IModelChangeSupport;
import droidsafe.speclang.model.MethodModel;
import droidsafe.speclang.model.MethodsToHighlight;
import droidsafe.speclang.model.SecuritySpecModel;
import droidsafe.utils.SourceLocationTag;

/**
 * View for displaying the droidsafe security spec outline. The view looks for a selected project,
 * and checks if the selected project has a security spec either in serialized form, inside the
 * droidsafe directory or the app, or if a spec has just been computed by the droidsafe analysis. If
 * not project is selected, or no spec is found, a message is displayed to the user.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class SecuritySpecOutlineViewPart extends SpecInfoOutlineViewPart {
    private static final Logger logger = LoggerFactory.getLogger(SecuritySpecOutlineViewPart.class);

    /** The ID of the view as specified by the extension. */
    public static final String VIEW_ID = "droidsafe.eclipse.plugin.core.view.DroidsafeSpecView";
    
    public void refreshSpecAndOutlineView() {
    	refreshSpecAndOutlineView(false);
    }

    /**
     * Rereads the serialized spec from file and resets the tree input.
     * @param reInitialize always deserialize the spec from file
     */
    public void refreshSpecAndOutlineView(boolean reInitialize) {
    	IProject project = getProject();
        fInputElement = DroidsafePluginUtilities.getSecuritySpec(project, true, reInitialize);
        if (fInputElement == null) {
            showEmptyPage();
        } else {
            updateView();
            InfoFlowSummaryViewPart.openView(fInputElement);
            if (reInitialize) {
            	IndicatorViewPart indicatorView = IndicatorViewPart.openView();
            	if (indicatorView != null) {
            		indicatorView.forceReloadAll();
            		indicatorView.updateView();
            	}
            }
        }
    }

    @Override
    protected void updateView() {
        if (fInputElement != null && fParentComposite != null) {
            updateCurrentViewerSettings();
            showPage(PAGE_VIEWER);
            if (fTreeViewer.getSorter() == null)
                sortViewByMethodName();
            fTreeViewer.setInput(fInputElement);
        }
    }

    /**
     * Standard Eclipse method to create a view. Initializes the security spec if a project is
     * selected in the Explorer View, and creates the outline view using a TreeViewer. Set the content
     * and label providers for the viewer.
     */
    @Override
    public void createPartControl(Composite parent) {
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (window != null) {
        	window.getPartService().addPartListener(new EditorVisibleListener());
        }
        super.createPartControl(parent);
        fTreeViewer.getControl().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                int modifier = (Util.isMac()) ? SWT.COMMAND : SWT.CTRL;
                if ((e.stateMask & modifier) == modifier) {
                    if (e.keyCode == 'f') {
                        if (fContentProvider.getRootElements() != null) {
                            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                            SearchDialog dialog = new SearchDialog(window.getShell(), SecuritySpecOutlineViewPart.this);
                            dialog.open();
                        }
                    }
                }
            }
        });
        showOtherDroidsafeViews(VIEW_ID);
    }
    
    class EditorVisibleListener implements IPartListener2 {

    	@Override
		public void partActivated(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partBroughtToTop(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partClosed(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partDeactivated(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partOpened(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partHidden(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partVisible(IWorkbenchPartReference partRef) {
			IWorkbenchPart part = partRef.getPart(false);
			if (part instanceof IEditorPart) {
				IEditorPart editor = (IEditorPart) part;
	    		IProject project = DroidsafePluginUtilities.getProcessedDroidsafeProjectForEditor(editor);
				if (project != null) {
					ProjectMarkerProcessor projectMarkerProcessor = ProjectMarkerProcessor.get(project);
					projectMarkerProcessor.showDroidsafeTextMarkers(editor);
				}
			}
		}

		@Override
		public void partInputChanged(IWorkbenchPartReference partRef) {
		}
    	
    }
    
    private void updateCurrentViewerSettings() {
        ICommandService service =
                (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
        Command command =
                service.getCommand("droidsafe.eclipse.plugin.core.commands.SetTopLevelNodeForView");
        State state = command.getState("org.eclipse.ui.commands.radioState");
        if (state != null) {
            setTopLevelNodeForView(state.getValue().toString());
            // state.setValue(!(Boolean) state.getValue());
        }

        command = service.getCommand("droidsafe.eclipse.plugin.core.commands.SortOutlineView");
        state = command.getState("org.eclipse.ui.commands.radioState");
        if (state != null) {
            sortOutlineView(state.getValue().toString());
        }
        command =
                service.getCommand("droidsafe.eclipse.plugin.core.commands.SetLabelTypeForMethodNode");
        state = command.getState("org.eclipse.ui.commands.radioState");
        if (state != null) {
            setLabelTypeForMethodName(state.getValue().toString());
        }
    }

    protected int autoExpandLevel() {
        return 1;
      }

    protected void revealSelectionInEditor(ISelection selection, boolean activate) {
        // TreeViewer viewer = (TreeViewer) event.getViewer();
        if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
            Object selectedNode = ((IStructuredSelection) selection).getFirstElement();
            SourceLocationTag line = null;
            if (selectedNode instanceof TreeElement<?, ?>) {
                TreeElement<?, ?> treeElement = (TreeElement<?, ?>) selectedNode;
                Object data = treeElement.getData();
                if (data instanceof SourceLocationTag) {
                    line = (SourceLocationTag) data;
                } else if (data instanceof MethodModel) {
                    line = DroidsafePluginUtilities.getLine((MethodModel) data);
                } else if (treeElement.getParent().getData() instanceof SourceLocationTag) {
                    line = (SourceLocationTag) treeElement.getParent().getData();
                } else if (treeElement.hasChildren()
                        && treeElement.getChildren().get(0).getData() instanceof SourceLocationTag) {
                    line = (SourceLocationTag) treeElement.getChildren().get(0).getData();
                }
            }
            if (line != null) {
                DroidsafePluginUtilities.revealInEditor(getProject(), line, activate);
            }
        }
    }

    @Override
    public void setFocus() {
        //    if (viewer != null) {
        //      viewer.getControl().setFocus();
        //    } else if (textViewer != null) {
        //      textViewer.getControl().setFocus();
        //    }
    }

    public SecuritySpecModel getSecuritySpec() {
        return fInputElement;
    }
    
    /**
     * Method that executes the menu command SetTopLevelNodeForView from the outline view drop down
     * menu.
     * 
     * @param currentState The command parameter that tell us which node should be at the top level.
     */
    public void setTopLevelNodeForView(String currentState) {
        if (currentState.equals("input_method")) {
            setEntryPointsAsViewTopLevelParents();
        } else if (currentState.equals("output_method")) {
            setApiCallsAsViewTopLevelParents();
        } else if (currentState.equals("code_location")) {
            setCodeLocationAsViewTopLevelParents();
        }
    }

    public void setApiCallsAsViewTopLevelParents() {
        setContentProviderTopLevelParent(TopLevelParentEntity.API_AS_TOP_PARENT);
    }

    public void setEntryPointsAsViewTopLevelParents() {
        setContentProviderTopLevelParent(TopLevelParentEntity.ENTRY_POINT_AS_TOP_PARENT);
    }

    public void setCodeLocationAsViewTopLevelParents() {
        setContentProviderTopLevelParent(TopLevelParentEntity.CODE_LOCATION_AS_TOP_PARENT);
    }

    private void setContentProviderTopLevelParent(TopLevelParentEntity parentEntityType) {
        if (fContentProvider instanceof SecuritySpecTreeElementContentProvider) {
            SecuritySpecTreeElementContentProvider contProvider = (SecuritySpecTreeElementContentProvider) fContentProvider;
            if (contProvider.getContentProviderTopLevelParent() != parentEntityType) {
                contProvider.setContentProviderTopLevelParent(parentEntityType);
                if (fTreeViewer != null) {
                    ISelection savedSelections = getViewerSelection();
                    fTreeViewer.refresh();
                    selectObjects(savedSelections);
                }
            }
        }
    }

    /**
     * This method will re-select the nodes that were selected before the change in the outline
     * structure.
     * 
     * This method should be called by any method that changes the structure of the outline tree.
     * 
     * @param savedSelections The set of nodes selected before the change in the structure of the
     *        outline.
     */
    private void selectObjects(ISelection savedSelections) {
        List<Object> selectedElements = new ArrayList<Object>();
        if (savedSelections != null && savedSelections instanceof IStructuredSelection) {
            IStructuredSelection structuredSelection = ((IStructuredSelection) savedSelections);
            for (Object selection : structuredSelection.toList()) {
                if (selection instanceof TreeElement<?, ?>) {
                    TreeElement<?, ?> element = (TreeElement<?, ?>) selection;
                    if (element.getData() instanceof IModelChangeSupport) {
                        IModelChangeSupport modelObject = (IModelChangeSupport) element.getData();
                        TreeElement<?, ?> newTreeElement = findTreeElementForModelObject(modelObject);
                        if (newTreeElement != null) {
                            selectedElements.add(newTreeElement);
                        }
                    }
                }
            }
        }
        if (!selectedElements.isEmpty()) {
            fTreeViewer.setSelection(new StructuredSelection(selectedElements), true);
        }
    }

    public void setLabelTypeForMethodName(String currentState) {
        if (currentState.equals("short_label")) {
            setUseShortSignatureForMethods(true);
        } else if (currentState.equals("long_label")) {
            setUseShortSignatureForMethods(false);
        }
    }

    /**
     * Method to set the type of labels should be used for method nodes in the outline. It calls the
     * label provided method <code>setUseShortSignatureForMethods</code> and refreshes the view if
     * necessary.
     * 
     * @param useShortSignature A boolean that tells if the label for methods nodes should use the
     *        short signature (value TRUE) or if it shoul use the long signature (value FALSE).
     * 
     */
    public void setUseShortSignatureForMethods(boolean useShortSignature) {
        boolean oldValue =
                ((SecuritySpecTreeElementLabelProvider) fLabelProvider)
                .setUseShortSignatureForMethods(useShortSignature);
        if (fTreeViewer != null && oldValue != useShortSignature) {
            ISelection savedSelections = getViewerSelection();
            fTreeViewer.refresh();
            selectObjects(savedSelections);
        }
    }


    /**
     * Method that implements the command that sorts the nodes in the outline view.
     * 
     * @param currentState The command parameter that tell us what type of sorting should we use.
     *        Possible values for this parameter are "method", "class", or "status"
     */
    public void sortOutlineView(String currentState) {
        // perform task for current state
        if (currentState.equals("method")) {
            // sort entries by method name.
            sortViewByMethodName();
        } else if (currentState.equals("class")) {
            // sort entries by class name
            sortViewByClassName();
        } else if (currentState.equals("status")) {
            sortViewByStatusAndClassName();
        }else if (currentState.equals("priority")) {
            sortViewByPriorityAndClassName();
        }
    }

    private ISelection getViewerSelection() {
        if (fTreeViewer != null) {
            return fTreeViewer.getSelection();
        }
        return null;
    }

    public void sortViewByMethodName() {
        if (fTreeViewer != null) {
            ISelection savedSelections = getViewerSelection();

            fTreeViewer.setComparator(new ViewerComparator() {
                public int compare(Viewer view, Object o1, Object o2) {
                    int result = 0;
                    if (o1 instanceof TreeElement<?, ?> && o2 instanceof TreeElement<?, ?>) {
                        Object oo1 = ((TreeElement<?, ?>) o1).getData();
                        Object oo2 = ((TreeElement<?, ?>) o2).getData();
                        return compare(view, oo1, oo2);

                    } else if (o1 instanceof MethodModel && o2 instanceof MethodModel) {
                        MethodModel m1 = (MethodModel) o1;
                        MethodModel m2 = (MethodModel) o2;
                        result = m1.getMethodName().compareTo(m2.getMethodName());
                        if (result == 0) {
                            result = m1.getClassName().compareTo(m2.getClassName());
                        }
                        if (result == 0) {
                            result = m1.getReturnType().compareTo(m2.getReturnType());
                        }
                    } else if (o1 instanceof SourceLocationTag && o2 instanceof SourceLocationTag) {
                        SourceLocationTag l1 = (SourceLocationTag) o1;
                        SourceLocationTag l2 = (SourceLocationTag) o2;
                        result = l1.getClz().compareTo(l2.getClz());
                        if (result == 0) {
                            result = Integer.valueOf(l1.getLine()).compareTo(Integer.valueOf(l2.getLine()));
                        }
                    }
                    return result;
                }
            });
            selectObjects(savedSelections);
        }
    }

    public void sortViewByClassName() {
        if (fTreeViewer != null) {
            ISelection savedSelections = getViewerSelection();

            fTreeViewer.setComparator(new ViewerComparator() {
                public int compare(Viewer view, Object o1, Object o2) {
                    int result = 0;
                    if (o1 instanceof TreeElement<?, ?> && o2 instanceof TreeElement<?, ?>) {
                        Object oo1 = ((TreeElement<?, ?>) o1).getData();
                        Object oo2 = ((TreeElement<?, ?>) o2).getData();
                        // logger.debug("Elements tested o1 {} o2 {} result {}", new
                        // Object[] {
                        // ((TreeElement<?, ?>) o1).getName(), ((TreeElement<?, ?>)
                        // o2).getName()});
                        return compare(view, oo1, oo2);

                    } else if (o1 instanceof MethodModel && o2 instanceof MethodModel) {
                        MethodModel m1 = (MethodModel) o1;
                        MethodModel m2 = (MethodModel) o2;
                        result = m1.getClassName().compareTo(m2.getClassName());
                        // logger.debug("Class Names m1 {} m2 {} result {}",
                        // new Object[] {m1.getClassName(), m2.getClassName(),
                        // Integer.toString(result)});
                        if (result == 0) {
                            result = m1.getMethodName().compareTo(m2.getMethodName());
                        }
                        if (result == 0) {
                            result = m1.getReturnType().compareTo(m2.getReturnType());
                        }
                        if (result == 0) {
                            result = m1.getSignature().compareTo(m2.getSignature());
                        }
                        // logger.debug("Class Names m1 {} m2 {} result {}",
                        // new Object[] {m1.getClassName(), m2.getClassName(),
                        // Integer.toString(result)});
                    } else if (o1 instanceof SourceLocationTag && o2 instanceof SourceLocationTag) {
                        SourceLocationTag l1 = (SourceLocationTag) o1;
                        SourceLocationTag l2 = (SourceLocationTag) o2;
                        result = l1.getClz().compareTo(l2.getClz());
                        if (result == 0) {
                            result = Integer.valueOf(l1.getLine()).compareTo(Integer.valueOf(l2.getLine()));
                        }
                    }
                    return result;
                }
            });
            selectObjects(savedSelections);
        }
    }

    public void sortViewByStatusAndClassName() {
        if (fTreeViewer != null) {
            ISelection savedSelections = getViewerSelection();

            fTreeViewer.setComparator(new ViewerComparator() {
                public int compare(Viewer view, Object o1, Object o2) {
                    int result = 0;
                    if (o1 instanceof TreeElement<?, ?> && o2 instanceof TreeElement<?, ?>) {
                        Object oo1 = ((TreeElement<?, ?>) o1).getData();
                        Object oo2 = ((TreeElement<?, ?>) o2).getData();
                        // logger.debug("Elements tested o1 {} o2 {} result {}", new
                        // Object[] {
                        // ((TreeElement<?, ?>) o1).getName(), ((TreeElement<?, ?>)
                        // o2).getName()});
                        return compare(view, oo1, oo2);

                    } else if (o1 instanceof MethodModel && o2 instanceof MethodModel) {
                        MethodModel m1 = (MethodModel) o1;
                        MethodModel m2 = (MethodModel) o2;
                        result = m1.getStatus().compareTo(m2.getStatus());
                        if (result == 0) {
                            result = m1.getClassName().compareTo(m2.getClassName());
                        }
                        // logger.debug("Class Names m1 {} m2 {} result {}",
                        // new Object[] {m1.getClassName(), m2.getClassName(),
                        // Integer.toString(result)});
                        if (result == 0) {
                            result = m1.getMethodName().compareTo(m2.getMethodName());
                        }
                        if (result == 0) {
                            result = m1.getReturnType().compareTo(m2.getReturnType());
                        }
                        if (result == 0) {
                            result = m1.getSignature().compareTo(m2.getSignature());
                        }
                        // logger.debug("Class Names m1 {} m2 {} result {}",
                        // new Object[] {m1.getClassName(), m2.getClassName(),
                        // Integer.toString(result)});
                    } else if (o1 instanceof CodeLocationModel && o2 instanceof CodeLocationModel) {
                        CodeLocationModel l1 = (CodeLocationModel) o1;
                        CodeLocationModel l2 = (CodeLocationModel) o2;
                        result = l1.getStatus().compareTo(l2.getStatus());
                        if (result == 0) {
                            result = l1.getClz().compareTo(l2.getClz());
                        }
                        if (result == 0) {
                            result = Integer.valueOf(l1.getLine()).compareTo(Integer.valueOf(l2.getLine()));
                        }
                    }
                    return result;
                }
            });
            selectObjects(savedSelections);
        }
    }

    public void sortViewByPriorityAndClassName() {
        if (fTreeViewer != null) {
            ISelection savedSelections = getViewerSelection();

            fTreeViewer.setComparator(new ViewerComparator() {
                public int compare(Viewer view, Object o1, Object o2) {
                    int result = 0;
                    if (o1 instanceof TreeElement<?, ?> && o2 instanceof TreeElement<?, ?>) {
                        Object oo1 = ((TreeElement<?, ?>) o1).getData();
                        Object oo2 = ((TreeElement<?, ?>) o2).getData();
                        // logger.debug("Elements tested o1 {} o2 {} result {}", new
                        // Object[] {
                        // ((TreeElement<?, ?>) o1).getName(), ((TreeElement<?, ?>)
                        // o2).getName()});
                        return compare(view, oo1, oo2);

                    } else if (o1 instanceof MethodModel && o2 instanceof MethodModel) {
                        MethodModel m1 = (MethodModel) o1;
                        MethodModel m2 = (MethodModel) o2;
                        result = m1.getStatus().compareTo(m2.getStatus());

                        if (result == 0) {
                            result = Integer.compare(m2.getPermissions().size(), m1.getPermissions().size());
                        }
                        if (result == 0) {
                            result = Boolean.compare(m2.isNative(), m1.isNative());
                        }
                        if (result == 0) {
                            result =
                                    Boolean.compare(MethodsToHighlight.shouldHighlightMethd(m2),
                                        MethodsToHighlight.shouldHighlightMethd(m1));
                        }


                        if (result == 0) {
                            result = m1.getClassName().compareTo(m2.getClassName());
                        }
                        // logger.debug("Class Names m1 {} m2 {} result {}",
                        // new Object[] {m1.getClassName(), m2.getClassName(),
                        // Integer.toString(result)});
                        if (result == 0) {
                            result = m1.getMethodName().compareTo(m2.getMethodName());
                        }
                        if (result == 0) {
                            result = m1.getReturnType().compareTo(m2.getReturnType());
                        }
                        if (result == 0) {
                            result = m1.getSignature().compareTo(m2.getSignature());
                        }
                        // logger.debug("Class Names m1 {} m2 {} result {}",
                        // new Object[] {m1.getClassName(), m2.getClassName(),
                        // Integer.toString(result)});
                    } else if (o1 instanceof CodeLocationModel && o2 instanceof CodeLocationModel) {
                        CodeLocationModel l1 = (CodeLocationModel) o1;
                        CodeLocationModel l2 = (CodeLocationModel) o2;
                        result = l1.getStatus().compareTo(l2.getStatus());
                        if (result == 0) {
                            result = l1.getClz().compareTo(l2.getClz());
                        }
                        if (result == 0) {
                            result = Integer.valueOf(l1.getLine()).compareTo(Integer.valueOf(l2.getLine()));
                        }
                    }
                    return result;
                }
            });
            selectObjects(savedSelections);
        }
    }


    /**
     * Returns the tree element corresponding to the element model (method or code location).
     * 
     * @param modelObject The method or code location object represented in the outline view.
     * 
     * @return The tree node element wrapping the model object.
     * 
     */
    public TreeElement<?, ?> findTreeElementForModelObject(IModelChangeSupport modelObject) {
        return ((SecuritySpecTreeElementContentProvider) fContentProvider)
                .findTreeElementForModelObject(modelObject);
    }

    @Override
    public void selectionChanged(SelectionChangedEvent event) {
        if (event.getSelectionProvider() == fTreeViewer) {
            ISelection selection = event.getSelection();
            revealSelectionInEditor(selection, false);
            if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
                Object selectedNode = ((IStructuredSelection) selection).getFirstElement();
                if (selectedNode instanceof TreeElement<?, ?>) {
                    TreeElement<?, ?> treeElement = (TreeElement<?, ?>) selectedNode;
                    Object data = treeElement.getData();
                    if (data instanceof MethodModel) {
                        MethodModel method = (MethodModel) data;
                        PointsToViewPart.openView(method);
                        InfoFlowDetailsViewPart.openView(method);
                        ValueViewPart.openView(method);
                    }
                }
            }
            fTreeViewer.getControl().setFocus();
        }
    }

    @Override
    protected DroidsafeInfoTreeElementLabelProvider makeLabelProvider() {
        return new SecuritySpecTreeElementLabelProvider();
    }

    @Override
    protected DroidsafeInfoTreeElementContentProvider makeContentProvider() {
        return new SecuritySpecTreeElementContentProvider();
    }

    @Override
    protected void projectSelected() {
        refreshSpecAndOutlineView();
    }

}
