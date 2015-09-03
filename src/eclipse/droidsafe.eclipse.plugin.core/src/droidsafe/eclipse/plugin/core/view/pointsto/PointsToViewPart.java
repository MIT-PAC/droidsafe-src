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

package droidsafe.eclipse.plugin.core.view.pointsto;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.eclipse.plugin.core.view.MethodInfoOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementLabelProvider;
import droidsafe.speclang.model.MethodModel;

/**
 * View for displaying the points-to info on the receiver/arguments of a given method. 
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class PointsToViewPart extends MethodInfoOutlineViewPart {

    /** The ID of the view as specified by the extension. */
    public static final String VIEW_ID = "droidsafe.eclipse.plugin.core.view.PointsToView";

    @Override
    protected DroidsafeInfoTreeElementLabelProvider makeLabelProvider() {
        return new PointsToTreeElementLabelProvider();
    }

    @Override
    protected DroidsafeInfoTreeElementContentProvider makeContentProvider() {
        return new PointsToTreeElementContentProvider();
    }
    
    @Override
    protected String emptyPageText() {
        return EMPTY_PAGE_LABEL;
    }
    
    /**
     * Open the outline view for the given input element.
     */
    public static void openView(MethodModel inputElement) {
        IWorkbenchPage activePage = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
        PointsToViewPart view = (PointsToViewPart) activePage.findView(VIEW_ID);
        if (view == null) {
            // open the view
            try {
                view = (PointsToViewPart) activePage.showView(VIEW_ID);
            } catch (PartInitException e) {
                e.printStackTrace();
            }
        }
        view.setInputElement(inputElement);
        activePage.activate(view);
    }

    @Override
    protected MethodModel getMethod() {
        return (MethodModel) fInputElement;
    }
    
//    /**
//     * Auxiliary function to setup a selection listener that would reset the contents of the outline
//     * view once a different project is selected.
//     */
//    protected void setSelectionListener() {
//      this.fSelectionListener = new ISelectionListener() {
//        public void selectionChanged(IWorkbenchPart part, ISelection sel) {
//          if (!(sel instanceof IStructuredSelection)) return;
//          IStructuredSelection ss = (IStructuredSelection) sel;
//          Object selectedObject = ss.getFirstElement();
//          if (selectedObject instanceof IAdaptable) {
//            IResource res = (IResource) ((IAdaptable) selectedObject).getAdapter(IResource.class);
//            IProject project = (res != null) ? res.getProject() : null;
//            if (project != null && project != fSelectedProject) {
//                fSelectedProject = project;
//                fInputElement = null;
//                if (fTreeViewer != null)
//                    fTreeViewer.setInput(null);
//                showEmptyPage();
//            }
//          } else if (part instanceof SecuritySpecOutlineViewPart && selectedObject instanceof TreeElement<?,?>) {
//              TreeElement<?,?> treeElement = (TreeElement<?,?>) selectedObject;
//              Object data = treeElement.getData();
//              if (data instanceof MethodModel) {
//                  openView((MethodModel) data);
//              }
//          }
//        }
//      };
//      getSite().getPage().addSelectionListener(this.fSelectionListener);
//    }

}
