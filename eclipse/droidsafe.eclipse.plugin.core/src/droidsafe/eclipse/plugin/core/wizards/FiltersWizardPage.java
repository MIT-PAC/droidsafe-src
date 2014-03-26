package droidsafe.eclipse.plugin.core.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import droidsafe.eclipse.plugin.core.view.DroidsafeImages;
import droidsafe.eclipse.plugin.core.view.json.Filter;

public class FiltersWizardPage extends WizardPage {
    private TableViewer viewer;
    private ArrayList<Filter> newFilters;

    /**
     * Create the wizard.
     * @param filters 
     */
    public FiltersWizardPage(List<Filter> filters) {
        super("wizardPage");
        setTitle("View Filters");
        setDescription("List of filters for the outline view.");
        this.newFilters = new ArrayList<Filter>();
        for (Filter filter: filters) {
            newFilters.add(new Filter(filter));
        }
    }

    public List<Filter> getNewFilters() {
        return newFilters;
    }
    
    /**
     * Create contents of the wizard.
     * @param parent
     */
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new GridLayout(2, false));
        
        viewer = new TableViewer(container, SWT.MULTI | SWT.H_SCROLL
            | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);

        final Table table = viewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(false);
        
        createColumns(container);

        viewer.setContentProvider(ArrayContentProvider.getInstance());
        viewer.setInput(newFilters);
        
        GridData gridData = new GridData();
        gridData.verticalAlignment = GridData.FILL;
        gridData.horizontalSpan = 1;
        gridData.grabExcessHorizontalSpace = true;
        gridData.grabExcessVerticalSpace = true;
        gridData.horizontalAlignment = GridData.BEGINNING;
        viewer.getControl().setLayoutData(gridData);

        Button deleteButton = new Button(container, SWT.NONE);
        deleteButton.setText("Delete");
    }

    private void createColumns(Composite parent) {
        TableViewerColumn col1 = createTableViewerColumn("Filter", 500, 0);
        col1.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                Filter filter = (Filter) element;
                return filter.toString();
            }
        });

        TableViewerColumn col2 = createTableViewerColumn("Enabled", 50, 1);
        col2.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                return "";
            }

            @Override
            public Image getImage(Object element) {
                if (((Filter) element).isEnabled()) {
                    return DroidsafeImages.CHECKED;
                }
                return DroidsafeImages.UNCHECKED;
            }
        });
        col2.setEditingSupport(new EnabledEditingSupport(viewer));
    }

    private TableViewerColumn createTableViewerColumn(String title, int bound,
                                                      final int colNumber) {
        final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
            SWT.NONE);
        final TableColumn column = viewerColumn.getColumn();
        column.setText(title);
        column.setWidth(bound);
        column.setResizable(true);
        column.setMoveable(true);
        return viewerColumn;
    }

    public class EnabledEditingSupport extends EditingSupport {

        private final TableViewer viewer;

        public EnabledEditingSupport(TableViewer viewer) {
            super(viewer);
            this.viewer = viewer;
        }

        @Override
        protected CellEditor getCellEditor(Object element) {
            return new CheckboxCellEditor(null, SWT.CHECK | SWT.READ_ONLY);

        }

        @Override
        protected boolean canEdit(Object element) {
            return true;
        }

        @Override
        protected Object getValue(Object element) {
            Filter filter = (Filter) element;
            return filter.isEnabled();

        }

        @Override
        protected void setValue(Object element, Object value) {
            Filter filter = (Filter) element;
            filter.setEnabled((Boolean) value);
            viewer.update(element, null);
        }
    }
    
}
