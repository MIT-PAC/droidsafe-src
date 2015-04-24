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

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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
import droidsafe.eclipse.plugin.core.filters.FilterType;
import droidsafe.eclipse.plugin.core.filters.FilterPred;
import droidsafe.eclipse.plugin.core.filters.FilterPredClause;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.indicator.Utils;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;

public class NewFilterWizardPage extends FilterWizardPage {

    /** The selected JsonObject in the underlying indicator outline view. */
    private JsonObject jsonObject;
    
    /**
     * Constructs a NewFilterWizardPage.
     * 
     * @param selection - a selection in the underlying indicator outline view
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
     * Fills the wizard page with default values derived from the selected Json object.
     */
    protected void fillData() {
        filterTypeButtons[0].setSelection(true);
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

    /**
     * Adds listeners to the field, the add button and the remove button on the i'th
     * predicate clause.
     */
    protected void addListeners(final int i) {
        fieldCombos[i].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setFieldValue(i);
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
    
    /**
     * Sets the field value for the i'th predicate clause to the field value
     * of the selected Json object.
     */
    private void setFieldValue(int i) {
        String field = fieldCombos[i].getText();
        String value = Utils.getFieldValueAsString(jsonObject, field);
        if (value != null)
            valueTexts[i].setText(value);
    }
    
}
