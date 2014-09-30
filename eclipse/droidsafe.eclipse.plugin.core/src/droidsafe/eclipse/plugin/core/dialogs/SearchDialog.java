package droidsafe.eclipse.plugin.core.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import droidsafe.eclipse.plugin.core.view.DroidsafeImages;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementLabelProvider;

public class SearchDialog extends Dialog {

    /**
     * The input value.
     */
    private String value = "";

    /**
     * Input text widget.
     */
    private Text searchText;

    private Button nextButton;

    private Button prevButton;

    private Button closeButton;

    private DroidsafeInfoOutlineViewPart viewPart;

    private String searchString;

    private int searchIndex;

    private List<Object> searchResult;

    private DroidsafeInfoTreeElementLabelProvider labelProvider;
    private DroidsafeInfoTreeElementContentProvider contentProvider;
    private TreeViewer treeViewer;

    private Text statusText;

    public SearchDialog(Shell parentShell, DroidsafeInfoOutlineViewPart viewPart) {
        super(parentShell);
        setShellStyle(SWT.APPLICATION_MODAL);
        this.viewPart = viewPart;
        this.labelProvider = viewPart.getLabelProvider();
        this.contentProvider = viewPart.getContentProvider();
        this.treeViewer = viewPart.getViewer();
   }

    protected void buttonPressed(int buttonId) {
        if (buttonId == IDialogConstants.OK_ID) {
            value = searchText.getText();
        } else {
            value = null;
        }
        super.buttonPressed(buttonId);
    }

    protected Point getInitialLocation(Point initialSize) {
        Point loc = viewPart.getScreenLocation();
        int x = loc.x;
        int y = loc.y - initialSize.y - 4;
        return new Point(x, y);
    }
    
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
    
    /*
     * (non-Javadoc) Method declared on Dialog.
     */
    protected Control createDialogArea(Composite parent) {
        searchText = new Text(parent, SWT.SINGLE | SWT.BORDER | SWT.ICON_SEARCH | SWT.SEARCH);
        GridData gridData = new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL);
        gridData.widthHint = 200;
        gridData.heightHint = 20;
        searchText.setLayoutData(gridData);
        if (value != null) {
            searchText.setText(value);
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
        statusText = new Text(parent, SWT.READ_ONLY | SWT.RIGHT);
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_END);
        gridData.widthHint = 72;
        statusText.setLayoutData(gridData);
        
        prevButton = new Button(parent, SWT.ARROW | SWT.UP);
        gridData = new GridData();
        gridData.widthHint = 20;
        gridData.heightHint = 20;
        prevButton.setLayoutData(gridData);
        prevButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                searchPrevious();
            }
        });

        nextButton = new Button(parent, SWT.ARROW | SWT.DOWN);
        nextButton.setLayoutData(gridData);
        nextButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                searchNext();
            }
        });

        // Use Label widget since Buttons always have border
        closeButton = new Button(parent, SWT.FLAT);
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

    protected void resetSearch() {
        if (searchString != null && searchResult != null) {
            labelProvider.setSearchString(null);
            labelProvider.setSearchElement(null);
            if (!searchResult.isEmpty())
                updateTreeViewer(searchResult);
        }
    }

    private void updateTreeViewer(List<Object> elements) {
        for (Object element: elements) {
            treeViewer.update(element, null);
        }
    }
    
    private void searchNext() {
        String newSearchString = searchText.getText();
        if (newSearchString.equals(searchString)) {
            if (searchResult.size() > 1) {
                Object element = searchResult.get(searchIndex++);
                if (searchIndex == searchResult.size())
                    searchIndex = 0;
                Object nextElement = searchResult.get(searchIndex);
                labelProvider.setSearchElement(nextElement);
                treeViewer.update(element, null);
                treeViewer.update(nextElement, null);
                treeViewer.reveal(nextElement);
            }
        } else {
            resetSearch();
            computeSearchResult(newSearchString);
            if (!searchResult.isEmpty()) {
                labelProvider.setSearchString(searchString);
                labelProvider.setSearchElement(searchResult.get(searchIndex));
                updateTreeViewer(searchResult);
                treeViewer.reveal(searchResult.get(0));
            }
         }
        updateStatusLabel();
    }

    private void updateStatusLabel() {
        String text = "";
        if (searchResult != null) {
            switch (searchResult.size()) {
                case 0: text = "(0 of 0)"; break;
                case 1: text = "(1 of 1)"; break;
                default: text = "(" + (searchIndex + 1) + " of " + searchResult.size() + ")";
            }
        }
        statusText.setText(text);
    }

    private void searchPrevious() {
        if (searchResult.size() > 1) {
            Object element = searchResult.get(searchIndex--);
            if (searchIndex < 0) searchIndex += searchResult.size();
            Object prevElement = searchResult.get(searchIndex);
            labelProvider.setSearchElement(prevElement);
            treeViewer.update(element, null);
            treeViewer.update(prevElement, null);
            treeViewer.reveal(prevElement);
            updateStatusLabel();
        }
    }

    private void computeSearchResult(String searchString) {
        this.searchString = searchString;
        this.searchResult = new ArrayList<Object>();
        this.searchIndex = 0;
        for (Object rootElement: contentProvider.getSortedRootElements()) {
            computeSearchResult(rootElement);
        }
    }

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

