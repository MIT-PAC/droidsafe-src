package droidsafe.eclipse.plugin.core.view;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.texteditor.ITextEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.specmodel.CodeLocationModel;
import droidsafe.eclipse.plugin.core.specmodel.MethodModel;
import droidsafe.eclipse.plugin.core.specmodel.SecuritySpecModel;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.TreeElementContentProvider.TopLevelParentEntity;
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
public class SecuritySpecOutlineViewPart extends ViewPart {
  private static final Logger logger = LoggerFactory.getLogger(SecuritySpecOutlineViewPart.class);

  /** The ID of the view as specified by the extension. */
  public static final String VIEW_ID = "droidsafe.eclipse.plugin.core.view.DroidsafeSpecView";

  /** The project selected on the Project Explorer View. */
  private IProject selectedProject;

  /* The model for the security spec we are displaying on the outline view. */
  private SecuritySpecModel securitySpecModel;

  /** The main tree viewer used to display the outline of the security spec */
  private TreeViewer viewer;

  /** A Text viewer we use to display a message to the user if no project is selected. */
  private TextViewer textViewer;

  /** Standard Eclipse content provider to populate the tree viewer. */
  private ITreeContentProvider contentProvider;

  /** Standard Eclipse label provider to provide images and labels to the different tree nodes. */
  private IBaseLabelProvider labelProvider;

  /** A listener to keep track if the current selected project in the Explorer View */
  private ISelectionListener selectionListener;

  /** The container for the text or tree view used in the class. */
  private Composite parentComposite;

  /**
   * Tries to find a security spec model for the currently selected project. If there is no selected
   * project, it creates a text viewer telling the user to select a project in the Project Explorer.
   * If there is a selected project in the Explorer View, the method looks for a serialized version
   * of the spec in the droidsafe directory in the root folder of the application project. If a spec
   * is available, the class field securitySpecModel is set. If a spec cannot be found, because
   * droidsafe has not yet been executed for this application, then a message is displayed to the
   * user instructing how to run the droidsafe analysis.
   * 
   * @param parent The composite container for the viewer. Used to create a text viewer in case a
   *        security spec for the currently selected project cannot be found.
   */
  private void initializeSecuritySpec(Composite parent) {

    this.selectedProject = getSelectedProject();
    if (this.selectedProject == null) {
      disposeTreeViewer();
      disposeTextViewer();
      this.textViewer = new TextViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
      IDocument document = new Document();
      document.set("No Android Project selected. "
          + "\nSelect an Android project in the Project Explorer."
          + "\nYou may also need to run the Droidsafe spec generation "
          + "command from the project context menu.");
      this.textViewer.setDocument(document);
    } else {
      String projectRootPath = this.selectedProject.getLocation().toOSString();
      this.securitySpecModel = SecuritySpecModel.deserializeSpecFromFile(projectRootPath);

      if (this.securitySpecModel == null) {
        disposeTreeViewer();
        disposeTextViewer();
        this.textViewer = new TextViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        IDocument document = new Document();
        document.set("Droidsafe spec for selected project has not been computed yet. "
            + "\nSelect the project on the Project Explorer "
            + "\nand run the Droidsafe spec generation command from the project context menu.");
        this.textViewer.setDocument(document);

      }
    }
  }


  /**
   * Auxiliary function to setup a selection listener that would replace the contents of the outline
   * view once a different project is selected.
   * 
   * Every time the user changes the selected project in the Project Explorer, the contents of the
   * Droidsafe outline view are updated with the spec of the selected project, if a spec for that
   * app is already available.
   */
  private void setSelectionListener() {
    this.selectionListener = new ISelectionListener() {
      public void selectionChanged(IWorkbenchPart part, ISelection sel) {
        if (!(sel instanceof IStructuredSelection)) return;
        IStructuredSelection ss = (IStructuredSelection) sel;
        Object selectedObject = ss.getFirstElement();
        if (selectedObject instanceof IAdaptable) {
          IResource res = (IResource) ((IAdaptable) selectedObject).getAdapter(IResource.class);
          IProject project = (res != null) ? res.getProject() : null;
          if (project != null && project != SecuritySpecOutlineViewPart.this.selectedProject) {
            SecuritySpecOutlineViewPart.this.securitySpecModel = null;
            initializeSecuritySpec(SecuritySpecOutlineViewPart.this.parentComposite);
            if (SecuritySpecOutlineViewPart.this.securitySpecModel != null) {
              if (getViewer() == null) {
                initializeTreeViewer();
              } else {
                getViewer().setInput(securitySpecModel);
              }
            }
          }
        }
      }
    };
    getSite().getPage().addSelectionListener(this.selectionListener);
  }

  /**
   * Rereads the serialized spec from file and resets the tree input.
   */
  public void refreshSpecAndOutlineView() {
    this.securitySpecModel = null;
    initializeSecuritySpec(this.parentComposite);
    if (this.securitySpecModel != null) {
      if (getViewer() == null) {
        initializeTreeViewer();
      } else {
        getViewer().setInput(securitySpecModel);
      }
    }
  }

  /**
   * Standard Eclipse method to create a view. Initializes the security spec if a project is
   * selected in the Explorer View, and creates the outline view using a TreeViewer. Set the content
   * and label providers for the viewer.
   */
  @Override
  public void createPartControl(Composite parent) {
    this.parentComposite = parent;
    setSelectionListener();
    this.contentProvider = new TreeElementContentProvider();
    this.labelProvider = new TreeElementLabelProvider();
    initializeSecuritySpec(parent);
    if (this.securitySpecModel != null) {
      initializeTreeViewer();
    }
  }

  /**
   * Initialize the tree viewer with content provider, label provider, and inuput model.
   */
  private void initializeTreeViewer() {
    if (this.securitySpecModel != null && this.parentComposite != null) {
      disposeTextViewer();
      disposeTreeViewer();
      this.viewer = new TreeViewer(parentComposite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
      viewer.setContentProvider(this.contentProvider);
      viewer.setLabelProvider(this.labelProvider);
      viewer.setAutoExpandLevel(1);
      viewer.setUseHashlookup(true);
      ColumnViewerToolTipSupport.enableFor(viewer);
      sortViewByMethodName();

      // Make sure there is no text viewer in the container otherwise we get a split screen.

      viewer.setInput(securitySpecModel);

      MenuManager menuManager = new MenuManager();
      Menu menu = menuManager.createContextMenu(viewer.getTree());
      // Set the MenuManager
      viewer.getTree().setMenu(menu);
      getSite().registerContextMenu(menuManager, viewer);

      // Make the selection available to other views
      getSite().setSelectionProvider(viewer);
      addDoubleClickListener();
    }
  }



  /**
   * Add a double click listener to the TreeViewr. Double clicking on a tree node will expand the
   * node and open a text editor and position the caret on the line of code corresponding to the
   * line of the method.
   * 
   */
  private void addDoubleClickListener() {
    if (this.viewer != null) {
      // Add a doubleclicklistener
      this.viewer.addDoubleClickListener(new IDoubleClickListener() {

        @Override
        public void doubleClick(DoubleClickEvent event) {
          // TreeViewer viewer = (TreeViewer) event.getViewer();
          IStructuredSelection thisSelection = (IStructuredSelection) event.getSelection();
          Object selectedNode = thisSelection.getFirstElement();
          // viewer.setExpandedState(selectedNode, !viewer.getExpandedState(selectedNode));
          SourceLocationTag line = null;
          if (selectedNode instanceof TreeElement<?, ?>) {
            TreeElement<?, ?> treeElement = (TreeElement<?, ?>) selectedNode;
            Object data = treeElement.getData();
            if (data instanceof SourceLocationTag) {
              line = (SourceLocationTag) data;
            } else if (data instanceof MethodModel) {
              if (((MethodModel) data).getLines().isEmpty()) {
                line = ((MethodModel) data).getDeclSourceLocation();
              } else {
                line = ((MethodModel) data).getLines().get(0);
              }
            } else if (treeElement.getParent().getData() instanceof SourceLocationTag) {
              line = (SourceLocationTag) treeElement.getParent().getData();
            } else if (treeElement.hasChildren()
                && treeElement.getChildren().get(0).getData() instanceof SourceLocationTag) {
              line = (SourceLocationTag) treeElement.getChildren().get(0).getData();
            }
          }
          if (line != null) {
            int lineNumber = line.getLine();
            String className = line.getClz();
            String classPath = DroidsafePluginUtilities.classNamePath(className);
            IFile file = getSelectedProject().getFile(classPath);
            if (file != null) {
              try {
                IWorkbenchPage page =
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                IEditorDescriptor desc =
                    PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
                IEditorPart openEditor = page.openEditor(new FileEditorInput(file), desc.getId());

                if (openEditor instanceof ITextEditor) {
                  ITextEditor textEditor = (ITextEditor) openEditor;
                  IDocument document =
                      textEditor.getDocumentProvider().getDocument(textEditor.getEditorInput());
                  textEditor.selectAndReveal(document.getLineOffset(lineNumber - 1),
                      document.getLineLength(lineNumber - 1));
                }
              } catch (Exception ex) {
                logger.debug("Exception while creating editor for line {}", line);
                ex.printStackTrace();
              }
            }
          }
        }
      });
    }
  }


  /**
   * Removes any text viewer from the outline panel
   * 
   */
  private void disposeTextViewer() {
    if (this.textViewer != null) {
      textViewer.getTextWidget().dispose();
      textViewer = null;
    }
  }

  /**
   * Removes any tree viewer from the outline panel
   * 
   */
  private void disposeTreeViewer() {
    if (this.viewer != null) {
      viewer.getTree().dispose();
      viewer = null;
    }
  }

  @Override
  public void setFocus() {
    if (viewer != null) {
      viewer.getControl().setFocus();
    } else if (textViewer != null) {
      textViewer.getControl().setFocus();
    }
  }

  /**
   * 
   * @return the current TreeViewer.
   */
  public TreeViewer getViewer() {
    return this.viewer;
  }

  public SecuritySpecModel getSecuritySpec() {
    return this.securitySpecModel;
  }

  public void dispose() {
    getSite().getPage().removeSelectionListener(selectionListener);
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
    if (this.contentProvider instanceof TreeElementContentProvider
        && ((TreeElementContentProvider) this.contentProvider).getContentProviderTopLevelParent() != parentEntityType) {
      ((TreeElementContentProvider) this.contentProvider)
          .setContentProviderTopLevelParent(parentEntityType);
      this.viewer.refresh();
    }
  }


  /**
   * Looks for a selected project in the Eclipse Project Explorer that may have a security spec.
   * 
   * @return the selected project or project enclosing a selected resource.
   */
  protected IProject getSelectedProject() {
    ISelectionService ss =
        Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getSelectionService();
    String projExpID = "org.eclipse.ui.navigator.ProjectExplorer";
    ISelection sel = ss.getSelection(projExpID);
    if (sel == null) {
      projExpID = "org.eclipse.jdt.ui.PackageExplorer";
      sel = ss.getSelection(projExpID);
    }

    Object selectedObject = sel;
    if (sel instanceof IStructuredSelection) {
      selectedObject = ((IStructuredSelection) sel).getFirstElement();
    }
    if (selectedObject instanceof IAdaptable) {
      IResource res = (IResource) ((IAdaptable) selectedObject).getAdapter(IResource.class);
      if (res != null) {
        IProject project = res.getProject();
        if (project != null) {
          // logger.debug("Project found: " + project.getName());
          return project;
        }
      }
    }
    return null;
  }

  /**
   * Sets the value of the selectedProject field if it is null and returns the value of the
   * selectedProject field.
   * 
   * @return The android app Eclipse project corresponding to the security spec in the outline view.
   */
  public IProject getProject() {
    if (this.selectedProject == null) {
      this.selectedProject = getSelectedProject();
    }
    return this.selectedProject;
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
        ((TreeElementLabelProvider) this.labelProvider)
            .setUseShortSignatureForMethods(useShortSignature);
    if (oldValue != useShortSignature) {
      this.viewer.refresh();
    }
  }


  public void sortViewByMethodName() {
    this.viewer.setSorter(new ViewerSorter() {

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
  }


  public void sortViewByClassName() {
    this.viewer.setSorter(new ViewerSorter() {
      public int compare(Viewer view, Object o1, Object o2) {
        int result = 0;
        if (o1 instanceof TreeElement<?, ?> && o2 instanceof TreeElement<?, ?>) {
          Object oo1 = ((TreeElement<?, ?>) o1).getData();
          Object oo2 = ((TreeElement<?, ?>) o2).getData();
          // logger.debug("Elements tested o1 {} o2 {} result {}", new Object[] {
          // ((TreeElement<?, ?>) o1).getName(), ((TreeElement<?, ?>) o2).getName()});
          return compare(view, oo1, oo2);

        } else if (o1 instanceof MethodModel && o2 instanceof MethodModel) {
          MethodModel m1 = (MethodModel) o1;
          MethodModel m2 = (MethodModel) o2;
          result = m1.getClassName().compareTo(m2.getClassName());
          // logger.debug("Class Names m1 {} m2 {} result {}",
          // new Object[] {m1.getClassName(), m2.getClassName(), Integer.toString(result)});
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
          // new Object[] {m1.getClassName(), m2.getClassName(), Integer.toString(result)});
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
  }


  public void sortViewByStatusAndClassName() {
    this.viewer.setSorter(new ViewerSorter() {
      public int compare(Viewer view, Object o1, Object o2) {
        int result = 0;
        if (o1 instanceof TreeElement<?, ?> && o2 instanceof TreeElement<?, ?>) {
          Object oo1 = ((TreeElement<?, ?>) o1).getData();
          Object oo2 = ((TreeElement<?, ?>) o2).getData();
          // logger.debug("Elements tested o1 {} o2 {} result {}", new Object[] {
          // ((TreeElement<?, ?>) o1).getName(), ((TreeElement<?, ?>) o2).getName()});
          return compare(view, oo1, oo2);

        } else if (o1 instanceof MethodModel && o2 instanceof MethodModel) {
          MethodModel m1 = (MethodModel) o1;
          MethodModel m2 = (MethodModel) o2;
          result = m1.getStatus().compareTo(m2.getStatus());
          if (result == 0) {
            result = m1.getClassName().compareTo(m2.getClassName());
          }
          // logger.debug("Class Names m1 {} m2 {} result {}",
          // new Object[] {m1.getClassName(), m2.getClassName(), Integer.toString(result)});
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
          // new Object[] {m1.getClassName(), m2.getClassName(), Integer.toString(result)});
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
  }

}
