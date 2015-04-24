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

package droidsafe.eclipse.plugin.core.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import droidsafe.eclipse.plugin.core.Activator;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {


  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
   * initializeDefaultPreferences()
   */
  public void initializeDefaultPreferences() {
    IPreferenceStore store = Activator.getDefault().getPreferenceStore();

    store.setDefault(PreferenceConstants.P_TARGET_PASS, "specdump");
    store.setDefault(PreferenceConstants.P_NOSOURCE_INFO, false);
    store.setDefault(PreferenceConstants.P_INFOFLOW, false);
    store.setDefault(PreferenceConstants.P_JIMPLE, false);
    store.setDefault(PreferenceConstants.P_ANALYZEAPI, false);
    store.setDefault(PreferenceConstants.P_DEBUGLOG, false);
    store.setDefault(PreferenceConstants.P_DUMP_PTA, false);
    store.setDefault(PreferenceConstants.P_DUMP_CALL_GRAPH, false);
    store.setDefault(PreferenceConstants.P_RUN_STRING_ANALYSIS, true);
    store.setDefault(PreferenceConstants.P_UNFILTERED_STRING_ANALYSIS, false);
    // store.setDefault(PreferenceConstants.P_ADD_ALL_METHODS_TO_STRING_ANALYSIS, false);

    // prefs = ConfigurationScope.INSTANCE.getNode(Activator.PLUGIN_ID);
    // prefs.put(PreferenceConstants.P_TARGET_PASS, "specdump");
    // prefs.putBoolean(PreferenceConstants.P_NOSOURCE_INFO, true);
    // prefs.putBoolean(PreferenceConstants.P_INFOFLOW, true);
    // prefs.putBoolean(PreferenceConstants.P_JIMPLE, true);
    // prefs.putBoolean(PreferenceConstants.P_ANALYZEAPI, true);
    // prefs.putBoolean(PreferenceConstants.P_DEBUGLOG, true);
    // prefs.putBoolean(PreferenceConstants.P_DUMP_PTA, true);
    // prefs.putBoolean(PreferenceConstants.P_DUMP_CALL_GRAPH, true);
    //
    // try {
    // prefs.flush();
    // } catch (BackingStoreException e) {
    // e.printStackTrace();
    // }

  }

}
