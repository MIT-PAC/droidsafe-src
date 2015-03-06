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

package droidsafe.eclipse.plugin.core.wizards;

import java.util.List;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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
    	fieldCombos[i].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                updatePageComplete(i);
            }
        });
    	valueTexts[i].addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e){
                updatePageComplete(i);
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
    
}
