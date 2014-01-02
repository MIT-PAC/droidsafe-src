package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;





public class PluginList {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.116 -0500", hash_original_field = "6F1ADA12B2C2CA117AD1C9371F4F403A", hash_generated_field = "2E9E45DF2A62E67ADA94EFB03194A6CB")

    private ArrayList<Plugin> mPlugins;

   /**
    * Public constructor. Initializes the list of plugins.
    *
    * @hide
    * @deprecated This interface was intended to be used by Gears. Since Gears was
    * deprecated, so is this class.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.119 -0500", hash_original_method = "AFA11BE3CB57F72948CE6AE6103E33EF", hash_generated_method = "C450610E90B426B4B4E1C5DF32174271")
    
@Deprecated
    public PluginList() {
        mPlugins = new ArrayList<Plugin>();
    }

   /**
    * Returns the list of plugins as a java.util.List.
    *
    * @hide
    * @deprecated This interface was intended to be used by Gears. Since Gears was
    * deprecated, so is this class.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.121 -0500", hash_original_method = "1801070113215AA650907EEB61F166CD", hash_generated_method = "3BECEFBF0B6E4E8E898E2706F0B4BF10")
    
@Deprecated
    public synchronized List getList() {
        return mPlugins;
    }

   /**
    * Adds a plugin to the list.
    *
    * @hide
    * @deprecated This interface was intended to be used by Gears. Since Gears was
    * deprecated, so is this class.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.124 -0500", hash_original_method = "C7DCB9134CAFAAB6388686E1F6701327", hash_generated_method = "62831236AB3808260B941677BFCA6C2C")
    
@Deprecated
    public synchronized void addPlugin(Plugin plugin) {
        if (!mPlugins.contains(plugin)) {
            mPlugins.add(plugin);
        }
    }

   /**
    * Removes a plugin from the list.
    *
    * @hide
    * @deprecated This interface was intended to be used by Gears. Since Gears was
    * deprecated, so is this class.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.126 -0500", hash_original_method = "980F1FA54E922541E9F37CE45E714F3E", hash_generated_method = "FCDDB2333CBDCEDA0B80DCA021DCFF52")
    
@Deprecated
    public synchronized void removePlugin(Plugin plugin) {
        int location = mPlugins.indexOf(plugin);
        if (location != -1) {
            mPlugins.remove(location);
        }
    }

   /**
    * Clears the plugin list.
    *
    * @hide
    * @deprecated This interface was intended to be used by Gears. Since Gears was
    * deprecated, so is this class.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.129 -0500", hash_original_method = "D08BA028CDC8B846863357DB1B876085", hash_generated_method = "C93B72394AF8999743A4416F94F84797")
    
@Deprecated
    public synchronized void clear() {
        mPlugins.clear();
    }

   /**
    * Dispatches the click event to the appropriate plugin.
    *
    * @hide
    * @deprecated This interface was intended to be used by Gears. Since Gears was
    * deprecated, so is this class.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.131 -0500", hash_original_method = "FD99E1EA214C7B87A27E9195924486C8", hash_generated_method = "E01615E8723A0E425B6CB93EA2F40F69")
    
@Deprecated
    public synchronized void pluginClicked(Context context, int position) {
        try {
            Plugin plugin = mPlugins.get(position);
            plugin.dispatchClickEvent(context);
        } catch (IndexOutOfBoundsException e) {
            // This can happen if the list of plugins
            // gets changed while the pref menu is up.
        }
    }

    
}

