package droidsafe.eclipse.plugin.core.wizards;

import java.util.List;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import droidsafe.eclipse.plugin.core.filters.BoolOp;
import droidsafe.eclipse.plugin.core.filters.CompareOp;
import droidsafe.eclipse.plugin.core.filters.Filter;
import droidsafe.eclipse.plugin.core.filters.FilterPred;
import droidsafe.eclipse.plugin.core.filters.FilterPredClause;
import droidsafe.eclipse.plugin.core.filters.FilterType;

/**
 * A wizard page for editing a filter for the current indicator display.
 * 
 * @author gilham
 *
 */
public class EditFilterWizardPage extends FilterWizardPage {

    /** The filter being edited. */
    private Filter filter;
    
    /**
     * Constructs a EditFilterWizardPage.
     * 
     * @param filter - the filter being edited
     * @param filterFields - The fields that can be used for filtering the indicator display 
     */
    public EditFilterWizardPage(Filter filter, String[] filterFields) {
        super("EditFilterWizardPage", filterFields);
        setTitle("Edit Filter");
        setDescription("Edit a display filter for the indicator outline view.");
        this.filter = filter;
    }

    /**
     * Fills the wizard page with original values from the filter being edited.
     */
    protected void fillData() {
        if (filter.name != null)
            filterNameText.setText(filter.name);;
        FilterType filterOp = filter.type;
        FilterPred filterPred = filter.pred;
        BoolOp boolOp = filterPred.getBoolOp();
        List<FilterPredClause> clauses = filterPred.getClauses();
        filterTypeButtons[filterOp.getValue()].setSelection(true);
        boolOpButtons[boolOp.getValue()].setSelection(true);
        numberOfPredClauses = clauses.size();
        for (int i = 0; i < MAX_PRED_CLAUSES; i++) {
            fieldCombos[i].setItems(filterFields);
            compOpCombos[i].setItems(CompareOp.strings);
            if (i < numberOfPredClauses) {
                FilterPredClause clause = clauses.get(i);
                String field = clause.field;
                CompareOp compOp = clause.compOp;
                String value = clause.value;
                fieldCombos[i].setText(field);
                compOpCombos[i].select(compOp.getValue());
                valueTexts[i].setText(value);
                clausesComplete[i] = true;
            } else {
                setPredVisible(i, false);
                clausesComplete[i] = false;
            } 
        }
        setPageComplete(true);
    }

    /**
     * Adds listeners to the add button and the remove button on the i'th
     * predicate clause.
     */
    protected void addListeners(final int i) {
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
    
}
