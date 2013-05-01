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
    // store.setDefault(PreferenceConstants.P_BOOLEAN, true);
    // store.setDefault(PreferenceConstants.P_CHOICE, "choice2");
    // store.setDefault(PreferenceConstants.P_STRING, "Default value");

		store.setDefault(PreferenceConstants.P_TARGET_PASS, "specdump");
		store.setDefault(PreferenceConstants.P_NOSOURCE_INFO, false);
		store.setDefault(PreferenceConstants.P_INFOFLOW, false);
		store.setDefault(PreferenceConstants.P_JIMPLE, false);
		store.setDefault(PreferenceConstants.P_ANALYZEAPI, false);
		store.setDefault(PreferenceConstants.P_DEBUGLOG, false);
	}

}
