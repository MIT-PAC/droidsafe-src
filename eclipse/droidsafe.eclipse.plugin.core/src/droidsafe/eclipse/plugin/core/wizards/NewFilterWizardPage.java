package droidsafe.eclipse.plugin.core.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.json.Filter;
import droidsafe.eclipse.plugin.core.view.json.Filter.CompareOp;
import droidsafe.eclipse.plugin.core.view.json.Filter.FilterOp;
import droidsafe.eclipse.plugin.core.view.json.Utils;

public class NewFilterWizardPage extends WizardPage {

    private JsonObject jsonObject;
    private Combo filterTypeCombo;
    private Text typeText;
    private Combo fieldCombo;
    private Text valueText;
    private Combo compOpCombo;
    private String[] fields;
    private String[] showFields;

    /**
     * Create the wizard.
     * @param selection 
     * @param view 
     */
    public NewFilterWizardPage(IStructuredSelection selection) {
        super("NewFilterWizardPage");
        setTitle("New Filter");
        setDescription("Create a new display filter");
        Object element = selection.getFirstElement();
        if (element instanceof TreeElement<?,?>) {
            Object data = ((TreeElement<?,?>)element).getData();
            if (data instanceof JsonElement && ((JsonElement)data).isJsonObject()) {
                this.jsonObject = (JsonObject) data;
                this.fields = Utils.getFields(jsonObject);
                this.showFields = new String[fields.length + 1];
                showFields[0] = "type";
                for (int i = 0; i < fields.length; i++) {
                    showFields[i + 1] = fields[i];
                }
            }
        }
    }

    /**
     * Create contents of the wizard.
     * @param parent
     */
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);

        setControl(container);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 5;
        container.setLayout(gridLayout);
        
        filterTypeCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
        GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
        filterTypeCombo.setLayoutData(gridData);
        
        typeText = new Text(container, SWT.BORDER);
        gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
        typeText.setLayoutData(gridData);
        
        fieldCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
        gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
        fieldCombo.setLayoutData(gridData);
        
        compOpCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
        gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
        compOpCombo.setLayoutData(gridData);
        
        valueText = new Text(container, SWT.BORDER);
        gridData = new GridData(SWT.FILL, SWT.CENTER, true, true);
        gridData.minimumWidth = 500;
        valueText.setLayoutData(gridData);
        new Label(container, SWT.NONE);
        fillData();
        addListeners();
    }

    private void fillData() {
        filterTypeCombo.setItems(FilterOp.strings);
        filterTypeCombo.select(0);
        JsonElement type = jsonObject.get("type");
        if (type != null)
            typeText.setText(type.getAsString()+".");
        fieldCombo.setItems(fields);
        fieldCombo.select(0);
        compOpCombo.setItems(CompareOp.strings);
        compOpCombo.select(0);
        setFieldValue();
    }

    private void addListeners() {
        filterTypeCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                FilterOp filterOp = FilterOp.values()[filterTypeCombo.getSelectionIndex()];
                if (filterOp == FilterOp.SHOW) {
                    typeText.setText("");
                    fieldCombo.setItems(showFields);
                    fieldCombo.select(0);
                }
            }
        });
        fieldCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setFieldValue();
            }
        });
    }
    
    private void setFieldValue() {
        String field = fieldCombo.getText();
        String value = Utils.getFieldValueAsString(jsonObject, field);
        if (value != null)
            valueText.setText(value);
    }
    
    public Filter getFilter() {
        String value = valueText.getText();
        if (value != null && !value.isEmpty()) {
            FilterOp filterOp = FilterOp.values()[filterTypeCombo.getSelectionIndex()];
            String type = typeText.getText();
            if (type.isEmpty()) {
                type = null;
            } else if (type.endsWith(".")){
                type = type.substring(0,  type.length() - 1);
            }
            String field = fields[fieldCombo.getSelectionIndex()];
            CompareOp compOp = CompareOp.values()[compOpCombo.getSelectionIndex()];
            Filter filter = new Filter(filterOp, type, field, compOp, value);
            return filter;
        }
        return null;
    }

}
