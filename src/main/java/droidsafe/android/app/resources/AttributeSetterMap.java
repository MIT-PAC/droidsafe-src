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

package droidsafe.android.app.resources;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import soot.Hierarchy;
import soot.Scene;
import soot.SootMethod;
import soot.SootClass;



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
	
	/**
	* Inner class to hold properties of a setter
	*/
	private class SetterEntry {
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
	private List<SetterEntry> setterList = new LinkedList();

	private AttributeSetterMap() {
		
		// from View class
		addEntry(
			new SetterEntry("contentDescription", "android.view.View","void setContentDescription(java.lang.CharSequence)"));
		
		// from TextView class
		addEntry(
				new SetterEntry("text", "android.widget.TextView","void setText(java.lang.CharSequence)"));
		// addEntry(
		// 		new SetterEntry("textAllCaps", "android.widget.TextView","void setAllCaps(boolean)"));		
		addEntry(
				new SetterEntry("hint", "android.widget.TextView","void setHint(java.lang.CharSequence)"));	
		
		// from Switch class
		addEntry(
			new SetterEntry("textOff", "android.widget.Switch", "void setTextOff(java.lang.CharSequence)"));
		addEntry(
			new SetterEntry("textOn", "android.widget.Switch","void setTextOn(java.lang.CharSequence)"));
		
		// from ToggleButton class
		addEntry(
				new SetterEntry("textOff", "android.widget.ToggleButton", "void setTextOff(java.lang.CharSequence)"));
		addEntry(
				new SetterEntry("textOn", "android.widget.ToggleButton","void setTextOn(java.lang.CharSequence)"));
		
		//from AutoCompleteTextView
		addEntry(
				new SetterEntry("completionHint", "android.widget.AutoCompleteTextView","void setCompletionHint(java.lang.CharSequence)"));
		
		//android.widget.Spinner class
		addEntry(
				new SetterEntry("prompt", "android.widget.Spinner","void setPrompt(java.lang.CharSequence)"));
		
		//TextClock
		/*
		addEntry(
				new SetterEntry("format12Hour", "android.widget.TextClock","void setFormat12Hour(java.lang.CharSequence)"));		
		addEntry(
				new SetterEntry("format24Hour", "android.widget.TextClock","void setFormat24Hour(java.lang.CharSequence)"));		
		addEntry(
				new SetterEntry("setTimeZone", "android.widget.TextClock","void setTimeZone(String)"));
		*/
		
		//android.preference.Preference
		addEntry(
				new SetterEntry("summary", "android.preference.Preference","void setSummary(java.lang.CharSequence)"));
		addEntry(
				new SetterEntry("title", "android.preference.Preference","void setTitle(java.lang.CharSequence)"));
		
		//android.preference.DialogPreference
		addEntry(
				new SetterEntry("dialogTitle", "android.preference.DialogPreference","void setDialogTitle(java.lang.CharSequence)"));
		
		//android.preference.TwoStatePreference.
		addEntry(
				new SetterEntry("summaryOn", "android.preference.TwoStatePreference","void setSummaryOn(java.lang.CharSequence)"));
		addEntry(
				new SetterEntry("summaryOff", "android.preference.TwoStatePreference","void setSummaryOff(java.lang.CharSequence)"));
		
		//content.pm.PackageInfo
		//addEntry(
		//		new SetterEntry("versionName", "android.android.pm.PackageInfo","void setVersionName(java.lang.CharSequence)"));
	}
	
	
	private void addEntry(SetterEntry entry) {
		setterList.add(entry);
	}
	
	/**
	* resolveSetter: lookup appropriate setter method for a given attribute
	* that is associate with myClass
	*/
	public SootMethod resolveSetter(String attrName, SootClass myClass) {
		for (SetterEntry entry: setterList) {
			//attribute name does not match
			if (!entry.attr.equals(attrName)) {
				continue;
			}

			SootClass parentClass = Scene.v().getSootClass(entry.className);
			// not a subclass
			if (!Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(
											myClass, parentClass)) {
				continue;
			}
			SootMethod parentSetter = Scene.v().getMethod(entry.setterMethod);
			SootMethod setter = Scene.v().getActiveHierarchy().resolveConcreteDispatch(myClass, parentSetter);

			return setter;
		}
		return null;
	}	
}
