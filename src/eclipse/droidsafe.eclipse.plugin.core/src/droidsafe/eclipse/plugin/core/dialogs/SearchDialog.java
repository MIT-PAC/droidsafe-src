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

package droidsafe.eclipse.plugin.core.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.DroidsafeImages;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementLabelProvider;

/**
 * A dialog for the user to search text in a droidsafe outline window and to navigate 
 * the search results.
 * 
 * @author gilham
 *
 */
public class SearchDialog extends Dialog {

    /**
     * The Droidsafe outline view in which the text search is being performed.
     */
    private DroidsafeInfoOutlineViewPart viewPart;

    /**
     * The label provider for the Droidsafe outline view in which the text search is being performed.
     */
    private DroidsafeInfoTreeElementLabelProvider labelProvider;
    
    /**
     * The content provider for the Droidsafe outline view in which the text search is being performed.
     */
    private DroidsafeInfoTreeElementContentProvider contentProvider;

    /**
     * The tree viewer for the Droidsafe outline view in which the text search is being performed.
     */
    private TreeViewer treeViewer;

    /**
     * The text widget for the input search string.
     */
    private Text searchText;

    /**
     * The input search string
     */
    private String searchString;

    /**
     * The list of outline elements that contain the search string.
     */
    private List<Object> searchResult;

    /**
     * The current index of the search result. The corresponding outline element is visible
     * and highlighted in red.
     */
    private int searchResultIndex;

    /**
     * The label widget displaying the current index and the total count of the search result. 
     */
    private Label statusText;

    /**
     * Create a search dialog given a parent shell and Droidsafe outline view.
     * 
     * @param parentShell - the parent shell
     * @param viewPart - the Droidsafe outline view in which the text search is being performed
     */
    public SearchDialog(Shell parentShell, DroidsafeInfoOutlineViewPart viewPart) {
        super(parentShell);
        setShellStyle(SWT.MODELESS); // SWT.APPLICATION_MODAL
        this.viewPart = viewPart;
        this.labelProvider = viewPart.getLabelProvider();
        this.contentProvider = viewPart.getContentProvider();
        this.treeViewer = viewPart.getViewer();
   }

    @Override
    protected Point getInitialLocation(Point initialSize) {
        Point loc = viewPart.getScreenLocation();
        int x = loc.x;
        int y = loc.y - initialSize.y - 4;
        return new Point(x, y);
    }
    
    @Override
    protected Control createContents(Composite parent) {
        // create the top level composite for the dialog
        Composite composite = new Composite(parent, 0);
        GridLayout layout = new GridLayout(5, false);
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        layout.horizontalSpacing = 0;
        layout.verticalSpacing = 0;
        composite.setLayout(layout);
        composite.setLayoutData(new GridData(GridData.FILL_BOTH));
        // initialize the dialog units
        initializeDialogUnits(composite);
        // create the dialog area
        dialogArea = createDialogArea(composite);
        return composite;
    }
    
    @Override
    protected Control createDialogArea(Composite parent) {
        searchText = new Text(parent, SWT.SINGLE | SWT.BORDER | SWT.ICON_SEARCH | SWT.SEARCH);
        GridData gridData = new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL);
        gridData.widthHint = 200;
        gridData.heightHint = 20;
        searchText.setLayoutData(gridData);
        if (searchString != null) {
            searchText.setText(searchString);
            searchText.selectAll();
        }
        searchText.addListener(SWT.Traverse, new Listener() {
            @Override
            public void handleEvent(Event event) {
                if (event.detail == SWT.TRAVERSE_RETURN &&
                        !searchText.getText().isEmpty()) {
                    searchNext();
                }
            }
        });
        statusText = new Label(parent, SWT.READ_ONLY | SWT.RIGHT);
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_END);
        gridData.widthHint = 72;
        statusText.setLayoutData(gridData);
        
        Button prevButton = new Button(parent, SWT.CENTER | SWT.FLAT);
        prevButton.setImage(DroidsafeImages.PREV_IMAGE);
        gridData = new GridData();
        if (System.getProperty("os.name").equals("Mac OS X")) {
            gridData.widthHint = 20;
            gridData.heightHint = 20;
        }
        prevButton.setLayoutData(gridData);
        prevButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                searchPrevious();
            }
        });

        Button nextButton = new Button(parent, SWT.CENTER | SWT.FLAT);
        nextButton.setImage(DroidsafeImages.NEXT_IMAGE);
        nextButton.setLayoutData(gridData);
        nextButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                searchNext();
            }
        });

        // Use Label widget since Buttons always have border
        Button closeButton = new Button(parent, SWT.CENTER | SWT.FLAT);
        closeButton.setImage(DroidsafeImages.CLOSE_IMAGE);
        closeButton.setLayoutData(gridData);
        closeButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                resetSearch();
                close();
            }
        });
        
        searchText.setFocus();

        return parent;
    }

    /**
     * Resets the search string and the search result.
     */
    protected void resetSearch() {
    	if (searchString != null && searchResult != null) {
    		labelProvider.setSearchString(null);
    		labelProvider.setSearchResultElement(null);
    		if (!searchResult.isEmpty())
    			updateTreeViewer(searchResult);
    	}
   }

    /**
     * Updates the display of the given tree outline elements.
     * 
     * @param elements - the tree outline elements
     */
    private void updateTreeViewer(List<Object> elements) {
        for (Object element: elements) {
        	// expanding parent before calling treeViewer.reveal(element) seems to avoid a problem
        	// with the reveal call
        	TreeElement<?, ?> parent = ((TreeElement<?,?>)element).getParent();
        	if (parent != null)
        		treeViewer.setExpandedState(parent, true);
        	treeViewer.update(element, null);
        }
    }
    
    /**
     * When a new search string is entered, computes and highlights the search result and 
     * reveals the first element in the search result with red highlight.  Otherwise reveals 
     * the next element in the search result with red highlight. 
     */ 
    private void searchNext() {
        String newSearchString = searchText.getText();
        if (newSearchString.equals(searchString)) {
            if (searchResult.size() > 1) {
                Object element = searchResult.get(searchResultIndex++);
                if (searchResultIndex == searchResult.size())
                    searchResultIndex = 0;
                Object nextElement = searchResult.get(searchResultIndex);
                labelProvider.setSearchResultElement(nextElement);
                treeViewer.update(element, null);
                treeViewer.update(nextElement, null);
                treeViewer.reveal(nextElement);
            }
        } else {
            resetSearch();
            computeSearchResult(newSearchString);
            if (!searchResult.isEmpty()) {
                final Object element = searchResult.get(searchResultIndex);
                labelProvider.setSearchString(searchString);
                labelProvider.setSearchResultElement(element);
                updateTreeViewer(searchResult);
                // calling reveal in a background thread seems to avoid a problem
                // with the element not revealed when scrolling is required
                final Runnable reveal = new Runnable() {
                    public void run() {
                      treeViewer.reveal(element);
                    }
                  };
                  Display.getDefault().asyncExec(reveal);
            }
         }
        updateStatusLabel();
    }

    /**
     * Updates the status label to display the current index and the total count of the search 
     * result.
     */
    private void updateStatusLabel() {
        String text = "";
        if (searchResult != null) {
            switch (searchResult.size()) {
                case 0: text = "(0 of 0)"; break;
                case 1: text = "(1 of 1)"; break;
                default: text = "(" + (searchResultIndex + 1) + " of " + searchResult.size() + ")";
            }
        }
        statusText.setText(text);
    }

    /**
     * Reveals the next element in the search result with red highlight. 
     */ 
    private void searchPrevious() {
        if (searchResult.size() > 1) {
            Object element = searchResult.get(searchResultIndex--);
            if (searchResultIndex < 0) searchResultIndex += searchResult.size();
            Object prevElement = searchResult.get(searchResultIndex);
            labelProvider.setSearchResultElement(prevElement);
            treeViewer.update(element, null);
            treeViewer.update(prevElement, null);
            treeViewer.reveal(prevElement);
            updateStatusLabel();
        }
    }

    /**
     * Given a search string, searches for the string in the current Droidsafe outline view and
     * updates the search result related fields.
     * 
     * @param searchString - the search string
     */
    private void computeSearchResult(String searchString) {
        this.searchString = searchString;
        this.searchResult = new ArrayList<Object>();
        this.searchResultIndex = 0;
        for (Object rootElement: contentProvider.getSortedRootElements()) {
            computeSearchResult(rootElement);
        }
    }

    /**
     * Performs text search in the entire tree rooted at the given element and adds the outline
     * elements containing the search string to the search result field.
     * 
     * @param element - the root outline element
     */
    private void computeSearchResult(Object element) {
        String label = labelProvider.getText(element);
        if (StringUtils.containsIgnoreCase(label, searchString)) {
            this.searchResult.add(element);
        }
        for (Object child: contentProvider.getSortedChildren(element)) {
            computeSearchResult(child);
        }
    }

}

