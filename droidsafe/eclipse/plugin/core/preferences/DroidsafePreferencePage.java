package droidsafe.eclipse.plugin.core.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import droidsafe.eclipse.plugin.core.Activator;

/**
 * This class represents a preference page that is contributed to the Preferences dialog. By
 * subclassing <samp>FieldEditorPreferencePage</samp>, we can use the field support built into JFace
 * that allows us to create a page that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the preference store that
 * belongs to the main plug-in class. That way, preferences can be accessed directly via the
 * preference store.
 */

public class DroidsafePreferencePage extends FieldEditorPreferencePage
    implements
      IWorkbenchPreferencePage {

  public DroidsafePreferencePage() {
    super(GRID);
    setPreferenceStore(Activator.getDefault().getPreferenceStore());
    setDescription("Droidsafe preferences");
  }

  /**
   * Creates the field editors. Field editors are abstractions of the common GUI blocks needed to
   * manipulate various types of preferences. Each field editor knows how to save and restore
   * itself.
   */
  public void createFieldEditors() {

    addField(new RadioGroupFieldEditor(PreferenceConstants.P_TARGET_PASS, "Target Pass", 1,
        new String[][] { {"Generate &Spec", "specdump"}, {"Conformance Check", "confcheck"}},
        getFieldEditorParent()));

    addField(new BooleanFieldEditor(PreferenceConstants.P_NOSOURCE_INFO,
        "Print &source information in spec", getFieldEditorParent()));

    addField(new BooleanFieldEditor(PreferenceConstants.P_JIMPLE,
        "Dump readable &jimple files for all app classes in /droidsafe", getFieldEditorParent()));

    addField(new BooleanFieldEditor(PreferenceConstants.P_ANALYZEAPI,
        "Fully analyze &API classes from android.jar", getFieldEditorParent()));

    addField(new BooleanFieldEditor(PreferenceConstants.P_INFOFLOW, "Analyze information &flows",
        getFieldEditorParent()));

    addField(new BooleanFieldEditor(PreferenceConstants.P_DEBUGLOG,
        "Print &debug log to current ./droidsafe/droidsafe.log", getFieldEditorParent()));

    addField(new BooleanFieldEditor(PreferenceConstants.P_DUMP_PTA,
        "Dump PTA Analysis Results to File", getFieldEditorParent()));

    addField(new BooleanFieldEditor(PreferenceConstants.P_DUMP_CALL_GRAPH,
        "Create dot file for call graph", getFieldEditorParent()));
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
   */
  public void init(IWorkbench workbench) {}

}
