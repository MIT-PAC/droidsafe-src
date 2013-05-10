package droidsafe.eclipse.plugin.core.view;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.texteditor.ITextEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.RCFGToSSL;
import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.specmodel.DroidsafeMethodModel;
import droidsafe.eclipse.plugin.core.specmodel.DroidsafeSecuritySpecModel;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.TreeElementContentProvider.TopLevelParentEntity;
import droidsafe.main.Config;
import droidsafe.speclang.SecuritySpecification;
import droidsafe.utils.SourceLocationTag;

public class SecuritySpecOutlineViewPart extends ViewPart {
  private static final Logger logger = LoggerFactory.getLogger(SecuritySpecOutlineViewPart.class);
  /**
   * The ID of the view as specified by the extension.
   */
  public static final String VIEW_ID = "droidsafe.eclipse.plugin.core.view.DroidsafeSpecView";

  private IProject selectedProject;
  private DroidsafeSecuritySpecModel securitySpecModel;
  private TreeViewer viewer;
  private TextViewer textViewer;
  private ITreeContentProvider contentProvider;
  private LabelProvider labelProvider;


  public SecuritySpecOutlineViewPart() {
    // TODO Auto-generated constructor stub
  }


  private void initializeSecuritySpec(Composite parent) {
    this.selectedProject = getSelectedProject();
    if (this.selectedProject == null) {
      this.textViewer = new TextViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
      IDocument document = new Document();
      document
          .set("No Android Project selected. "
              + "\nSelect an Android project in the Project Explorer."
              + "\nYou may also need to run the Droidsafe spec generation command from the project context menu.");
      this.textViewer.setDocument(document);
    } else {
      String projectRootPath = this.selectedProject.getLocation().toOSString();
      String securitySpecAndroidAppRootPath = Config.v().APP_ROOT_DIR;
      if (projectRootPath.equals(securitySpecAndroidAppRootPath)) {
        SecuritySpecification spec = (RCFGToSSL.v() == null) ? null : RCFGToSSL.v().getSpec();
        if (spec != null) {
          this.securitySpecModel = new DroidsafeSecuritySpecModel(spec);
          DroidsafeSecuritySpecModel.serializeSpecToFile(this.securitySpecModel, projectRootPath);
        }
      }
      if (this.securitySpecModel == null) {
        // Droidsafe may not have been run yet. Let's check if there is already a serialized version
        // of the spec in the droidsafe directory at the root of the android app project.
        this.securitySpecModel =
            DroidsafeSecuritySpecModel.deserializeSpecFromFile(projectRootPath);
      }

      if (this.securitySpecModel == null) {
        this.textViewer = new TextViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        IDocument document = new Document();
        document.set("Droidsafe spec for selected project has not been computed yet. "
            + "\nSelect the project on the Project Explorer "
            + "\nand run the Droidsafe spec generation command from the project context menu.");
        this.textViewer.setDocument(document);

      }
    }
  }

  @Override
  public void createPartControl(Composite parent) {
    initializeSecuritySpec(parent);
    if (this.securitySpecModel != null) {

      this.viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
      // this.contentProvider = new SecuritySpecViewContentProvider();
      // this.labelProvider = new SecuritySpecLabelProvider();
      // Expand the tree

      // viewer.setContentProvider(this.contentProvider);
      // viewer.setLabelProvider(this.labelProvider);
      // Get the content for the viewer, setInput will call getElements in the contentProvider
      // viewer.setInput(spec);

      // viewer.setContentProvider(new DroidsafeSecSpecViewContentProvider());
      // viewer.setLabelProvider(new DroidsafeSecSpecLabelProvider());

      // Test with new Content Providers
      this.contentProvider = new TreeElementContentProvider();
      this.labelProvider = new TreeElementLabelProvider();

      viewer.setContentProvider(this.contentProvider);
      viewer.setLabelProvider(this.labelProvider);
      viewer.setAutoExpandLevel(1);
      viewer.setInput(securitySpecModel);

      MenuManager menuManager = new MenuManager();
      Menu menu = menuManager.createContextMenu(viewer.getTree());
      // Set the MenuManager
      viewer.getTree().setMenu(menu);
      getSite().registerContextMenu(menuManager, viewer);

      // Make the selection available to other views
      getSite().setSelectionProvider(viewer);

      // Add a doubleclicklistener
      viewer.addDoubleClickListener(new IDoubleClickListener() {

        @Override
        public void doubleClick(DoubleClickEvent event) {
          TreeViewer viewer = (TreeViewer) event.getViewer();
          IStructuredSelection thisSelection = (IStructuredSelection) event.getSelection();
          Object selectedNode = thisSelection.getFirstElement();
          viewer.setExpandedState(selectedNode, !viewer.getExpandedState(selectedNode));
          SourceLocationTag line = null;

          // if (selectedNode instanceof Method) {
          // Method method = (Method) selectedNode;
          // if (method.getLines().isEmpty()) {
          // line = method.getDeclSourceLocation();
          // }
          // } else if (selectedNode instanceof DroidsafeMethodModel) {
          // DroidsafeMethodModel method = (DroidsafeMethodModel) selectedNode;
          // if (method.getLines().isEmpty()) {
          // line = method.getDeclSourceLocation();
          // } else {
          // line = method.getLines().get(0);
          // }
          // } else if (selectedNode instanceof SourceLocationTag) {
          // line = (SourceLocationTag) selectedNode;
          // } else

          if (selectedNode instanceof TreeElement<?, ?>) {
            TreeElement<?, ?> treeElement = (TreeElement<?, ?>) selectedNode;
            Object data = treeElement.getData();
            if (data instanceof SourceLocationTag) {
              line = (SourceLocationTag) data;
            } else if (data instanceof DroidsafeMethodModel
                && ((DroidsafeMethodModel) data).getLines().isEmpty()) {
              line = ((DroidsafeMethodModel) data).getDeclSourceLocation();
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
                // IEditorPart openEditor = IDE.openEditor(page, file);
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


  @Override
  public void setFocus() {
    if (viewer != null) {
      viewer.getControl().setFocus();
    } else if (textViewer != null) {
      textViewer.getControl().setFocus();
    }
  }

  public TreeViewer getViewer() {
    return this.viewer;
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
      // this.viewer.setInput(this.securitySpecModel);
      this.viewer.refresh();
    }
  }


  protected IProject getSelectedProject() {
    ISelectionService ss =
        Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getSelectionService();
    String projExpID = "org.eclipse.ui.navigator.ProjectExplorer";
    ISelection sel = ss.getSelection(projExpID);
    Object selectedObject = sel;
    if (sel instanceof IStructuredSelection) {
      selectedObject = ((IStructuredSelection) sel).getFirstElement();
    }
    if (selectedObject instanceof IAdaptable) {
      IResource res = (IResource) ((IAdaptable) selectedObject).getAdapter(IResource.class);
      IProject project = res.getProject();
      if (project != null) {
        logger.debug("Project found: " + project.getName());
        return project;
      }
    }
    return null;
  }

}
