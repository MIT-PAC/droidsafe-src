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

import org.eclipse.jface.wizard.Wizard;

import droidsafe.eclipse.plugin.core.filters.Filter;

/**
 * A wizard for editing a filter for the current indicator display.
 * 
 * @author gilham
 *
 */
public class EditFilterWizard extends Wizard {

    /** The edit filter wizard page. */
    private EditFilterWizardPage page;

    /** The list of filters for the current indicator display. */
    private List<Filter> filters;

    /** The filter being edited. */
    private Filter filter;

    /** The array of fields can be used for filtering the current indicator display. */
    private String[] filterFields;

    /**
     * Constructs an EditFilterWizard.
     */
    public EditFilterWizard() {
        setWindowTitle("Edit Filter");
    }

    /**
     * Adds one EditFilterWizardPage.
     */
    @Override
    public void addPages() {
        super.addPages();
        page = new EditFilterWizardPage(filter, filterFields);
        addPage(page);
    }

    /**
     * Updates the filters for the current indicator display by replacing
     * the edited entry with the new value.
     */
    @Override
    public boolean performFinish() {
        Filter newFilter = page.getFilter();
        if (newFilter != null) {
            int index = filters.indexOf(filter);
            filters.set(index, newFilter);
            return true;
        }
        return false;
    }

    /**
     * Initializes the wizard with the given field values.
     * 
     * @param filters - the list of filters for the indicator display
     * @param filter - the filter being edited
     * @param filterFields - the fields can be used for filtering the indicator display
     */
    public void init(List<Filter> filters, Filter filter, String[] filterFields) {
        this.filters = filters;
        this.filter = filter;
        this.filterFields = filterFields;
    }

}
