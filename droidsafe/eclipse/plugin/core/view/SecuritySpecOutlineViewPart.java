package droidsafe.eclipse.plugin.core.view;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
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
import org.eclipse.swt.events.SelectionListener;
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
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.speclang.Method;
import droidsafe.speclang.SecuritySpecification;
import droidsafe.utils.SourceLocationTag;

public class SecuritySpecOutlineViewPart extends ViewPart {
  private static final Logger logger = LoggerFactory.getLogger(SecuritySpecOutlineViewPart.class);
  /**
   * The ID of the view as specified by the extension.
   */
  public static final String VIEW_ID = "droidsafe.eclipse.plugin.core.view.DroidsafeSpecView";

  private IProject selectedProject;
  private TreeViewer viewer;
  private TextViewer textViewer;
  private ITreeContentProvider contentProvider;
  private LabelProvider labelProvider;
  private SelectionListener selectionProvider;

  public SecuritySpecOutlineViewPart() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void createPartControl(Composite parent) {
    this.selectedProject = getSelectedProject();
    SecuritySpecification spec = (RCFGToSSL.v() == null) ? null : RCFGToSSL.v().getSpec();

    if (this.selectedProject == null || spec == null) {
      this.textViewer = new TextViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
      IDocument document = new Document();
      document
          .set("No Android Project selected or "
              + "Droidsafe security spec has not yet been genenerated for selected project "
              + "\nSelect an Android project, and run the Droidsafe spec generation command from project context menu.");
      this.textViewer.setDocument(document);

    } else {

      this.viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
      this.contentProvider = new SecuritySpecViewContentProvider();
      this.labelProvider = new SecuritySpecLabelProvider();
      // Expand the tree
      viewer.setAutoExpandLevel(1);
      // viewer.setContentProvider(this.contentProvider);
      // viewer.setLabelProvider(this.labelProvider);
      // Get the content for the viewer, setInput will call getElements in the contentProvider
      // viewer.setInput(spec);


      DroidsafeSecuritySpecModel secSpecModel = new DroidsafeSecuritySpecModel(spec);
      DroidsafeSecuritySpecModel.serializeSpecToFile(secSpecModel);
      DroidsafeSecuritySpecModel newSecSpecModel =
          DroidsafeSecuritySpecModel.deserializeSpecFromFile();


      viewer.setContentProvider(new DroidsafeSecSpecViewContentProvider());
      viewer.setLabelProvider(new DroidsafeSecSpecLabelProvider());
      viewer.setInput(secSpecModel);


      
      MenuManager menuManager = new MenuManager();
      Menu menu = menuManager.createContextMenu(viewer.getTree());
      // Set the MenuManager
      viewer.getTree().setMenu(menu);
      getSite().registerContextMenu(menuManager, viewer);
      
      
      // viewer.setInput(computeInputForViewer());

      // Make the selection available to other views
      getSite().setSelectionProvider(viewer);
      // Set the sorter for the table

      // Add a doubleclicklistener
      viewer.addDoubleClickListener(new IDoubleClickListener() {

        @Override
        public void doubleClick(DoubleClickEvent event) {
          TreeViewer viewer = (TreeViewer) event.getViewer();
          IStructuredSelection thisSelection = (IStructuredSelection) event.getSelection();
          Object selectedNode = thisSelection.getFirstElement();
          viewer.setExpandedState(selectedNode, !viewer.getExpandedState(selectedNode));
          SourceLocationTag line = null;

          if (selectedNode instanceof Method) {
            Method method = (Method) selectedNode;
            if (method.getLines().isEmpty()) {
              line = method.getDeclSourceLocation();
            }
          } else if (selectedNode instanceof DroidsafeMethodModel) {
            DroidsafeMethodModel method = (DroidsafeMethodModel) selectedNode;
            if (method.getLines().isEmpty()) {
              line = method.getDeclSourceLocation();
            } else {
              line = method.getLines().get(0);
              // viewer.setSelection(new StructuredSelection(line));
            }
          } else if (selectedNode instanceof SourceLocationTag) {
            line = (SourceLocationTag) selectedNode;
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

  private List<IMarker> computeInputForViewer() {
    List<IMarker> result = new ArrayList<IMarker>();
    IProject project = getSelectedProject();
    if (project != null) {
      String markerId = Activator.PLUGIN_ID + ".droidsafemarker";
      IMarker markers[];
      try {
        markers = project.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
        for (IMarker marker : markers) {
          result.add(marker);
        }
      } catch (CoreException ex) {
        ex.printStackTrace();
      }
    }
    return result;
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
