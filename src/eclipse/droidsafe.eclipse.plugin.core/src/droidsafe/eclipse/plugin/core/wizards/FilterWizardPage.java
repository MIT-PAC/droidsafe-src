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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import droidsafe.eclipse.plugin.core.filters.BoolOp;
import droidsafe.eclipse.plugin.core.filters.CompareOp;
import droidsafe.eclipse.plugin.core.filters.Filter;
import droidsafe.eclipse.plugin.core.filters.FilterPred;
import droidsafe.eclipse.plugin.core.filters.FilterPredClause;
import droidsafe.eclipse.plugin.core.filters.FilterType;

/**
 * A base class for NewFilterWizardPage and EditFilterWizardPage.
 * 
 * @author gilham
 *
 */
abstract class FilterWizardPage extends WizardPage {

    /** Maximum number of predicate clauses. */
    static final int MAX_PRED_CLAUSES = 10;

    /** The array of fields which can be used for filtering the current indicator display. */
    protected String[] filterFields;
    
    /** The number of predicate clauses in the filter. */
    protected int numberOfPredClauses;
    
    /** An array of Combo widgets for editing the fields in the predicate clauses. */
    protected Combo[] fieldCombos = new Combo[MAX_PRED_CLAUSES];
    
    /** An array of Combo widgets for editing the comparison ops in the predicate clauses. */
    protected Combo[] compOpCombos = new Combo[MAX_PRED_CLAUSES];
    
    /** An array of Combo widgets for editing the values in the predicate clauses. */
    protected Text[] valueTexts = new Text[MAX_PRED_CLAUSES];
    
    /** An array of Button widgets for adding a new predicate clause to the filter. */
    protected Button[] addButtons = new Button[MAX_PRED_CLAUSES];
    
    /** An array of Button widgets for removing the selected predicate clause from the filter */
    protected Button[] removeButtons = new Button[MAX_PRED_CLAUSES];
    
    /** A container for the filter type buttons. */
    protected Composite filterTypeContainer;
    
    /** An array of Button widgets for editing the filter type. */
    protected Button[] filterTypeButtons;
    
    /** An array of Button widgets for editing the boolean operator. */
    protected Button[] boolOpButtons;
    
    /** An array of boolean values indicating whether each predicate clause is complete or not. */
    protected boolean[] clausesComplete = new boolean[MAX_PRED_CLAUSES];
    
    /** A Text widget for editing the name of the filter. */
    protected Text filterNameText;

    /**
     * Constructs a FilterWizardPage.
     * 
     * @param pageName - the name of the wizard page
     */
    public FilterWizardPage(String pageName) {
        super(pageName);
  }

    /**
     * Constructs a FilterWizardPage.
     * 
     * @param pageName - the name of the wizard page
     * @param filterFields - The fields which can be used for filtering the indicator display 
     */
    public FilterWizardPage(String pageName, String[] filterFields) {
        super(pageName);
        this.filterFields = filterFields;
    }

    /**
     * Creates contents of the wizard page.
     * 
     * @param parent - the parent composite
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

        filterTypeContainer = new Composite(container, SWT.NONE);
        gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        gridData.horizontalSpan = gridLayout.numColumns;
        filterTypeContainer.setLayoutData(gridData);
        RowLayout rowLayout = new RowLayout();
        filterTypeContainer.setLayout(rowLayout);
        
        String[] filterOpLabels = FilterType.labels;
        filterTypeButtons = new Button[filterOpLabels.length];
        for (int i = 0; i < filterOpLabels.length; i++) {
            filterTypeButtons[i] = new Button(filterTypeContainer, SWT.RADIO);
            filterTypeButtons[i].setText(filterOpLabels[i]);
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
            gridData.widthHint = 100;
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

    /**
     * Fills the wizard page with initial values.
     */
    abstract protected void fillData();
    
    /**
     * Sets the visibility of the i'th predicate clause to the boolean value
     * of 'visible'.
     */
    protected void setPredVisible(int i, boolean visible) {
        fieldCombos[i].setVisible(visible);
        compOpCombos[i].setVisible(visible);
        valueTexts[i].setVisible(visible);
        addButtons[i].setVisible(visible);
        removeButtons[i].setVisible(visible);
    }

    /**
     * Returns the currently selected filter type.
     */
    protected FilterType getFilterType() {
        for (int i = 0; i < filterTypeButtons.length; i++) {
            if (filterTypeButtons[i].getSelection())
                return FilterType.values()[i];
        }
        return null;
    }

    /**
     * Returns the currently selected boolean operator.
     */
    protected BoolOp getBooleanOp() {
        for (int i = 0; i < boolOpButtons.length; i++) {
            if (boolOpButtons[i].getSelection())
                return BoolOp.values()[i];
        }
        return null;
    }

    /**
     * Adds listeners to all the predicate clauses.
     */
    protected void addListeners() {
        for (int i = 0; i < MAX_PRED_CLAUSES; i++) {
            addListeners(i);
        }
    }
    
    /**
     * Adds listeners to the add button and the remove button on the i'th
     * predicate clause.
     */
    abstract protected void addListeners(final int i);  
    
    /**
     * Checks to see whether all the predicate clauses are complete.
     * Updates the page completeness accordingly.
     */
    protected void updatePageComplete() {
        boolean complete = true;
        for (int i = 0; i < numberOfPredClauses; i++) {
            complete = complete && clausesComplete[i];
            if (!complete)
                break;
        }
        setPageComplete(complete);
    }

    /**
     * Update the clause completeness of the ith clause.
     * Then checks to see whether all the predicate clauses are complete.
     * Updates the page completeness accordingly.
     */
    protected void updatePageComplete(int i) {
    	if (i < numberOfPredClauses) {
    		clausesComplete[i] = fieldCombos[i].getSelectionIndex() >= 0 && !valueTexts[i].getText().isEmpty();
    	}
    	updatePageComplete();
    }

    /**
     * Adds a new predicate clause after the i'th row.
     */
    protected void addClause(int i) {
        if (numberOfPredClauses < MAX_PRED_CLAUSES) {
            for (int j = numberOfPredClauses - 1; j > i; j--) {
                copyClause(j, j + 1);
            }
            initClause(i + 1);
            setPredVisible(numberOfPredClauses, true);
            numberOfPredClauses++;
        }
    }
    
    /**
     * Initializes the i'th predicate clause.
     */
    protected void initClause(int i) {
        fieldCombos[i].deselectAll();
        compOpCombos[i].select(0);
        valueTexts[i].setText("");
        setPageComplete(false);
    }

    /**
     * Removes the i'th predicate clause.
     */
    protected void removeClause(int i) {
        for (int j = i + 1; j < numberOfPredClauses; j ++) {
            copyClause(j, j - 1);
        }
        numberOfPredClauses--;
        setPredVisible(numberOfPredClauses, false);
    }
    
    /**
     * Copies the predicate clause from one row to another.
     * 
     * @param from - the index of the predicate clause to be copied from
     * @param to - the index of the predicate clause to be copied to
     */
    protected void copyClause(int from, int to) {
        fieldCombos[to].setText(fieldCombos[from].getText());
        compOpCombos[to].select(compOpCombos[from].getSelectionIndex());
        valueTexts[to].setText(valueTexts[from].getText());
    }
    
    /**
     * Returns the new filter constructed from the current widget values on the wizard page.
     */
    public Filter getFilter() {
        String name = filterNameText.getText();
        FilterType filterOp = getFilterType();
        BoolOp boolOp = getBooleanOp();
        List<FilterPredClause> clauses = new ArrayList<FilterPredClause>();
        for (int i = 0; i < numberOfPredClauses; i++) {
            FilterPredClause clause = getFilterPredClause(i);
            clauses.add(clause);
        }
        FilterPred filterPred = new FilterPred(boolOp, clauses);
        return new Filter(name, filterOp, filterPred);
    }

    /**
     * Returns the i'th predicate clause constructed from the corresponding widget values.
     */
    protected FilterPredClause getFilterPredClause(int i) {
        String field = fieldCombos[i].getText();
        CompareOp compOp = CompareOp.values()[compOpCombos[i].getSelectionIndex()];
        String value = valueTexts[i].getText();
        FilterPredClause clause = new FilterPredClause(field, compOp, value);
        return clause;
    }
    
}
