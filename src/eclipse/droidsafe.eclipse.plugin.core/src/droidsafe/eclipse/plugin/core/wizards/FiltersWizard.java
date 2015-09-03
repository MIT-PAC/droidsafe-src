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

import org.eclipse.jface.wizard.Wizard;

import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;

/**
 * A wizard for editing the set of filters for the current indicator display.
 * 
 * @author gilham
 *
 */
public class FiltersWizard extends Wizard {

    /** The filters wizard page. */
    private FiltersWizardPage page;
    
    /** The underlying indicator outline view. */
    private IndicatorViewPart view;

    /**
     * Constructs a FiltersWizard.
     */
    public FiltersWizard() {
        setWindowTitle("Filters");
    }

    /**
     * Adds one FiltersWizardPage.
     */
    @Override
    public void addPages() {
        super.addPages();
        page = new FiltersWizardPage(view.getFilters(), view.getFilterFields());
        addPage(page);
    }

    /**
     * Updates the set of filters for the current indicator display to the 
     * edit results.
     */
    @Override
    public boolean performFinish() {
        view.setFilters(page.getNewFilters());
        return true;
    }

    /**
     * Initializes the filters wizard with the given indicator outline view.
     */
    public void init(IndicatorViewPart view) {
        this.view = view;
    }

}
