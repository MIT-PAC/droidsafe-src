package droidsafe.eclipse.plugin.core.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.filters.BoolOp;
import droidsafe.eclipse.plugin.core.filters.Filter;
import droidsafe.eclipse.plugin.core.filters.CompareOp;
import droidsafe.eclipse.plugin.core.filters.FilterOp;
import droidsafe.eclipse.plugin.core.filters.FilterPred;
import droidsafe.eclipse.plugin.core.filters.FilterPredClause;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.indicator.Utils;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;

public class NewFilterWizardPage extends WizardPage {

    private static final int MAX_PRED_CLAUSES = 10;
    private JsonObject jsonObject;
    private int numberOfPredClauses;
    private Combo[] fieldCombos = new Combo[MAX_PRED_CLAUSES];
    private Combo[] compOpCombos = new Combo[MAX_PRED_CLAUSES];
    private Text[] valueTexts = new Text[MAX_PRED_CLAUSES];
    private Button[] addButtons = new Button[MAX_PRED_CLAUSES];
    private Button[] removeButtons = new Button[MAX_PRED_CLAUSES];
    private String[] filterFields;
    private Composite filterOpContainer;
    private Button[] filterOpButtons;
    private Button[] boolOpButtons;
    private boolean[] clausesComplete = new boolean[MAX_PRED_CLAUSES];
    private Text filterNameText;

    /**
     * Create the wizard.
     * @param selection 
     * @param view 
     */
    public NewFilterWizardPage(IStructuredSelection selection) {
        super("NewFilterWizardPage");
        setTitle("New Filter");
        setDescription("Create a new display filter for the indicator outline view.");
        Object element = selection.getFirstElement();
        if (element instanceof TreeElement<?,?>) {
            Object data = ((TreeElement<?,?>)element).getData();
            if (data instanceof JsonElement && ((JsonElement)data).isJsonObject()) {
                this.jsonObject = (JsonObject) data;
                this.filterFields = Utils.getFilterFields(jsonObject).toArray(new String[0]);
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
        gridLayout.numColumns = 2;
        container.setLayout(gridLayout);
        
        Label filterNameLabel = new Label (container, SWT.NONE);
        filterNameLabel.setText("Filter name:");             
        GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
        filterNameLabel.setLayoutData(gridData);
        filterNameText = new Text(container, SWT.BORDER);
        gridData = new GridData(GridData.FILL_HORIZONTAL);
        filterNameText.setLayoutData(gridData);

        filterOpContainer = new Composite(container, SWT.NONE);
        gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        gridData.horizontalSpan = gridLayout.numColumns;
        filterOpContainer.setLayoutData(gridData);
        RowLayout rowLayout = new RowLayout();
        filterOpContainer.setLayout(rowLayout);
        
        String[] filterOpLabels = FilterOp.labels;
        filterOpButtons = new Button[filterOpLabels.length];
        for (int i = 0; i < filterOpLabels.length; i++) {
            filterOpButtons[i] = new Button(filterOpContainer, SWT.RADIO);
            filterOpButtons[i].setText(filterOpLabels[i]);
        }
        
        Composite predContainer = new Composite(container, SWT.BORDER);
        gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        gridData.horizontalSpan = gridLayout.numColumns;
        predContainer.setLayoutData(gridData);
        gridLayout = new GridLayout();
        gridLayout.numColumns = 1;
        predContainer.setLayout(gridLayout);
        
        Composite boolOpContainer = new Composite(predContainer, SWT.NONE);
        gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
        boolOpContainer.setLayoutData(gridData);
        rowLayout = new RowLayout();
        boolOpContainer.setLayout(rowLayout);

        BoolOp[] booleanOps = BoolOp.values();
        boolOpButtons = new Button[booleanOps.length];
        for (int i = 0; i < booleanOps.length; i++) {
            boolOpButtons[i] = new Button(boolOpContainer, SWT.RADIO);
            boolOpButtons[i].setText(booleanOps[i].toString());
        }
               
        Composite predsContainer = new Composite(predContainer, SWT.BORDER);
        gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        predsContainer.setLayoutData(gridData);
        gridLayout = new GridLayout();
        gridLayout.numColumns = 5;
        predsContainer.setLayout(gridLayout);

        for (int i = 0; i < MAX_PRED_CLAUSES; i++) {
            fieldCombos[i] = new Combo(predsContainer, SWT.BORDER | SWT.READ_ONLY);
            gridData = new GridData(SWT.LEFT, SWT.TOP, false, false);
            fieldCombos[i].setLayoutData(gridData);

            compOpCombos[i] = new Combo(predsContainer, SWT.BORDER | SWT.READ_ONLY);
            gridData = new GridData(SWT.LEFT, SWT.TOP, false, false);
            compOpCombos[i].setLayoutData(gridData);

            valueTexts[i] = new Text(predsContainer, SWT.BORDER);
            gridData = new GridData(SWT.FILL, SWT.TOP, true, true);
            gridData.widthHint = 300;
            valueTexts[i].setLayoutData(gridData);

            addButtons[i] = new Button(predsContainer, SWT.BORDER);
            addButtons[i].setText("+");
            gridData = new GridData(SWT.LEFT, SWT.TOP, false, false);
            addButtons[i].setLayoutData(gridData);

            removeButtons[i] = new Button(predsContainer, SWT.BORDER);
            removeButtons[i].setText("-");
            gridData = new GridData(SWT.LEFT, SWT.TOP, false, false);
            removeButtons[i].setLayoutData(gridData);
        }
        
        fillData();
        addListeners();
    }

    private void fillData() {
        filterOpButtons[0].setSelection(true);
        boolOpButtons[0].setSelection(true);
        numberOfPredClauses = 1;
        int typeFieldIndex = -1;
        for (int i = 0; i < filterFields.length; i++) {
            if (filterFields[i].equals("type")) {
                typeFieldIndex = i;
                numberOfPredClauses = 2;
                break;
            }
        }
        for (int i = 0; i < MAX_PRED_CLAUSES; i++) {
            fieldCombos[i].setItems(filterFields);
            compOpCombos[i].setItems(CompareOp.strings);
            compOpCombos[i].select(0);
            if (i >= numberOfPredClauses) {
                setPredVisible(i, false);
                clausesComplete[i] = false;
            } else {
                int index = i;
                if (typeFieldIndex >= 0) {
                    index = (i == 0) ? typeFieldIndex : (typeFieldIndex == 0) ? 1 : 0;
                }
                fieldCombos[i].select(index);
                setFieldValue(i);
                clausesComplete[i] = true;
            }
        }
        setPageComplete(true);
    }

    private void setPredVisible(int i, boolean visible) {
        fieldCombos[i].setVisible(visible);
        compOpCombos[i].setVisible(visible);
        valueTexts[i].setVisible(visible);
        addButtons[i].setVisible(visible);
        removeButtons[i].setVisible(visible);
    }

    private FilterOp getFilterOp() {
        for (int i = 0; i < filterOpButtons.length; i++) {
            if (filterOpButtons[i].getSelection())
                return FilterOp.values()[i];
        }
        return null;
    }

    private BoolOp getBooleanOp() {
        for (int i = 0; i < boolOpButtons.length; i++) {
            if (boolOpButtons[i].getSelection())
                return BoolOp.values()[i];
        }
        return null;
    }

    private void addListeners() {
        for (int i = 0; i < MAX_PRED_CLAUSES; i++) {
            addListeners(i);
        }
    }
    
    private void addListeners(final int i) {
        fieldCombos[i].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setFieldValue(i);
                updatePageComplete();
            }
        });
        addButtons[i].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                addClause(i);
                updatePageComplete();
            }

        });
        removeButtons[i].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                removeClause(i);
                updatePageComplete();
            }

        });
    }
    
    protected void updatePageComplete() {
        boolean complete = true;
        for (int i = 0; i < numberOfPredClauses; i++) {
            complete = complete && clausesComplete[i];
            if (!complete)
                break;
        }
        setPageComplete(complete);
    }

    private void addClause(int i) {
        if (numberOfPredClauses < MAX_PRED_CLAUSES) {
            for (int j = numberOfPredClauses - 1; j > i; j--) {
                copyClause(j, j + 1);
            }
            initClause(i + 1);
            setPredVisible(numberOfPredClauses, true);
            numberOfPredClauses++;
        }
    }
    
    private void initClause(int i) {
        fieldCombos[i].deselectAll();
        compOpCombos[i].select(0);
        valueTexts[i].setText("");
        setPageComplete(false);
    }

    private void removeClause(int i) {
        for (int j = i + 1; j < numberOfPredClauses; j ++) {
            copyClause(j, j - 1);
        }
        numberOfPredClauses--;
        setPredVisible(numberOfPredClauses, false);
    }
    
    private void copyClause(int from, int to) {
        fieldCombos[to].select(fieldCombos[from].getSelectionIndex());
        compOpCombos[to].select(compOpCombos[from].getSelectionIndex());
        valueTexts[to].setText(valueTexts[from].getText());
        clausesComplete[to] = clausesComplete[from];
    }

    private void setFieldValue(int i) {
        String field = fieldCombos[i].getText();
        String value = Utils.getFieldValueAsString(jsonObject, field);
        if (value != null)
            valueTexts[i].setText(value);
    }
    
    public Filter getFilter() {
        String name = filterNameText.getText();
        FilterOp filterOp = getFilterOp();
        BoolOp boolOp = getBooleanOp();
        List<FilterPredClause> clauses = new ArrayList<FilterPredClause>();
        for (int i = 0; i < numberOfPredClauses; i++) {
            FilterPredClause clause = getFilterPredClause(i);
            clauses.add(clause);
        }
        FilterPred filterPred = new FilterPred(boolOp, clauses);
        return new Filter(name, filterOp, filterPred);
    }

    private FilterPredClause getFilterPredClause(int i) {
        String field = filterFields[fieldCombos[i].getSelectionIndex()];
        CompareOp compOp = CompareOp.values()[compOpCombos[i].getSelectionIndex()];
        String value = valueTexts[i].getText();
        FilterPredClause clause = new FilterPredClause(field, compOp, value);
        return clause;
    }
    
}
