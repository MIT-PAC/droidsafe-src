package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class PluginList {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.115 -0400", hash_original_field = "3BBFD44F77386E6A06EB986F62953E04", hash_generated_field = "2E9E45DF2A62E67ADA94EFB03194A6CB")

    private ArrayList<Plugin> mPlugins;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.115 -0400", hash_original_method = "AFA11BE3CB57F72948CE6AE6103E33EF", hash_generated_method = "C0A35AE6C5CE177275069814697F2449")
    @Deprecated
    public  PluginList() {
        mPlugins = new ArrayList<Plugin>();
        // ---------- Original Method ----------
        //mPlugins = new ArrayList<Plugin>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.116 -0400", hash_original_method = "1801070113215AA650907EEB61F166CD", hash_generated_method = "BEBF6BA15A07898079CAE289DB681B5F")
    @Deprecated
    public synchronized List getList() {
        List varB4EAC82CA7396A68D541C85D26508E83_1854487857 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1854487857 = mPlugins;
        varB4EAC82CA7396A68D541C85D26508E83_1854487857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1854487857;
        // ---------- Original Method ----------
        //return mPlugins;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.116 -0400", hash_original_method = "C7DCB9134CAFAAB6388686E1F6701327", hash_generated_method = "3EC2F31A6ED0E7F3C1D89E3B3A705CD6")
    @Deprecated
    public synchronized void addPlugin(Plugin plugin) {
        {
            boolean varC0E6DCC2C7B71BDBD19F3C142F1FFA62_53197374 = (!mPlugins.contains(plugin));
            {
                mPlugins.add(plugin);
            } //End block
        } //End collapsed parenthetic
        addTaint(plugin.getTaint());
        // ---------- Original Method ----------
        //if (!mPlugins.contains(plugin)) {
            //mPlugins.add(plugin);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.117 -0400", hash_original_method = "980F1FA54E922541E9F37CE45E714F3E", hash_generated_method = "D0E1DD073F94775B8F192E68EF9C25E8")
    @Deprecated
    public synchronized void removePlugin(Plugin plugin) {
        int location;
        location = mPlugins.indexOf(plugin);
        {
            mPlugins.remove(location);
        } //End block
        addTaint(plugin.getTaint());
        // ---------- Original Method ----------
        //int location = mPlugins.indexOf(plugin);
        //if (location != -1) {
            //mPlugins.remove(location);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.118 -0400", hash_original_method = "D08BA028CDC8B846863357DB1B876085", hash_generated_method = "DCFA1CD279657F7D3B02F4C9E52A23CF")
    @Deprecated
    public synchronized void clear() {
        mPlugins.clear();
        // ---------- Original Method ----------
        //mPlugins.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.118 -0400", hash_original_method = "FD99E1EA214C7B87A27E9195924486C8", hash_generated_method = "F5978EC8F04E96722894AC5FA9BD193A")
    @Deprecated
    public synchronized void pluginClicked(Context context, int position) {
        try 
        {
            Plugin plugin;
            plugin = mPlugins.get(position);
            plugin.dispatchClickEvent(context);
        } //End block
        catch (IndexOutOfBoundsException e)
        { }
        addTaint(context.getTaint());
        addTaint(position);
        // ---------- Original Method ----------
        //try {
            //Plugin plugin = mPlugins.get(position);
            //plugin.dispatchClickEvent(context);
        //} catch (IndexOutOfBoundsException e) {
        //}
    }

    
}

