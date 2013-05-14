package droidsafe.android.app.resources;

import java.util.HashMap;

/**
 * @author nnguyen
 * This class contains a singleton implementation of data structure that mapps an XML attribute
 * to its associated actions (setter methods) that will be used in the XML replacement task.
 * 
 * The code will only perform replacement task on methods/attributes defined in this class
 *
 */
public class AttributeSetterMap {
	
	// singleton object definition
	private static AttributeSetterMap singleton = new AttributeSetterMap();	
	public static AttributeSetterMap v() { return singleton; }
	
	public class SetterEntry {
		public String attr;
		public String className;
		public String setterMethod;
		
		public SetterEntry(String attr, String setterClass, String setterMethod) {
			this.attr = attr;
			this.className = setterClass;
			this.setterMethod = String.format("<%s: %s>", setterClass, setterMethod);
		}
		
	}
	
	// Member fields
	private HashMap<String, SetterEntry> map = new HashMap<>(); 
	private AttributeSetterMap() {
		
		// from View class
		addEntry(
			new SetterEntry("contentDescription", "android.view.View","void setContentDescription(CharSequence)"));
		
		// from TextView class
		addEntry(
				new SetterEntry("text", "android.widget.TextView","void setText(CharSequence)"));
		addEntry(
				new SetterEntry("textAllCaps", "android.widget.TextView","void setAllCaps(boolean)"));		
		addEntry(
				new SetterEntry("hint", "android.widget.TextView","void setHint(CharSequence)"));	
		
		// from Switch class
		addEntry(
			new SetterEntry("textOff", "android.widget.Switch", "void setTextOff(CharSequence)"));
		addEntry(
			new SetterEntry("textOn", "android.widget.Switch","void setTextOn(CharSequence)"));
		
		// from ToggleButton class
		addEntry(
				new SetterEntry("textOff", "android.widget.ToggleButton", "void setTextOff(CharSequence)"));
		addEntry(
				new SetterEntry("textOn", "android.widget.ToggleButton","void setTextOn(CharSequence)"));
		
		//from AutoCompleteTextView
		addEntry(
				new SetterEntry("completionHint", "android.widget.AutoCompleteTextView","void setCompletionHint(CharSequence)"));
		
		//android.widget.Spinner class
		addEntry(
				new SetterEntry("prompt", "android.widget.Spinner","void setPrompt(CharSequence)"));
		
		//TextClock
		/*
		addEntry(
				new SetterEntry("format12Hour", "android.widget.TextClock","void setFormat12Hour(CharSequence)"));		
		addEntry(
				new SetterEntry("format24Hour", "android.widget.TextClock","void setFormat24Hour(CharSequence)"));		
		addEntry(
				new SetterEntry("setTimeZone", "android.widget.TextClock","void setTimeZone(String)"));
		*/
		
		//android.preference.Preference
		addEntry(
				new SetterEntry("summary", "android.preference.Preference","void setSummary(CharSequence)"));
		addEntry(
				new SetterEntry("title", "android.preference.Preference","void setTitle(CharSequence)"));
		
		//android.preference.DialogPreference
		addEntry(
				new SetterEntry("dialogTitle", "android.preference.DialogPreference","void setDialogTitle(CharSequence)"));
		
		//android.preference.TwoStatePreference.
		addEntry(
				new SetterEntry("summaryOn", "android.preference.TwoStatePreference","void setSummaryOn(CharSequence)"));
		addEntry(
				new SetterEntry("summaryOff", "android.preference.TwoStatePreference","void setSummaryOff(CharSequence)"));
		
		//content.pm.PackageInfo
		//addEntry(
		//		new SetterEntry("versionName", "android.android.pm.PackageInfo","void setVersionName(CharSequence)"));
	}
	
	
	private void addEntry(SetterEntry entry) {
		map.put(entry.setterMethod, entry);
	}
	
	

}
