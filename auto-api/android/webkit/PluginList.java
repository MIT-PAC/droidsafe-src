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
    private ArrayList<Plugin> mPlugins;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.632 -0400", hash_original_method = "AFA11BE3CB57F72948CE6AE6103E33EF", hash_generated_method = "C0A35AE6C5CE177275069814697F2449")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public PluginList() {
        mPlugins = new ArrayList<Plugin>();
        // ---------- Original Method ----------
        //mPlugins = new ArrayList<Plugin>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.632 -0400", hash_original_method = "1801070113215AA650907EEB61F166CD", hash_generated_method = "8681C06236A26B7186E9EE6149B0A4BD")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public synchronized List getList() {
        return (List)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPlugins;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.632 -0400", hash_original_method = "C7DCB9134CAFAAB6388686E1F6701327", hash_generated_method = "6BF15A86F44EE749C3AB715965814B00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public synchronized void addPlugin(Plugin plugin) {
        dsTaint.addTaint(plugin.dsTaint);
        {
            boolean varC0E6DCC2C7B71BDBD19F3C142F1FFA62_1791903517 = (!mPlugins.contains(plugin));
            {
                mPlugins.add(plugin);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!mPlugins.contains(plugin)) {
            //mPlugins.add(plugin);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.633 -0400", hash_original_method = "980F1FA54E922541E9F37CE45E714F3E", hash_generated_method = "A20DA53C1099EF38F51DEA6E8E95563B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public synchronized void removePlugin(Plugin plugin) {
        dsTaint.addTaint(plugin.dsTaint);
        int location;
        location = mPlugins.indexOf(plugin);
        {
            mPlugins.remove(location);
        } //End block
        // ---------- Original Method ----------
        //int location = mPlugins.indexOf(plugin);
        //if (location != -1) {
            //mPlugins.remove(location);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.633 -0400", hash_original_method = "D08BA028CDC8B846863357DB1B876085", hash_generated_method = "DCFA1CD279657F7D3B02F4C9E52A23CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public synchronized void clear() {
        mPlugins.clear();
        // ---------- Original Method ----------
        //mPlugins.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.633 -0400", hash_original_method = "FD99E1EA214C7B87A27E9195924486C8", hash_generated_method = "ED48E75DB26FE8BB7693F14764CCB0E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public synchronized void pluginClicked(Context context, int position) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(context.dsTaint);
        try 
        {
            Plugin plugin;
            plugin = mPlugins.get(position);
            plugin.dispatchClickEvent(context);
        } //End block
        catch (IndexOutOfBoundsException e)
        { }
        // ---------- Original Method ----------
        //try {
            //Plugin plugin = mPlugins.get(position);
            //plugin.dispatchClickEvent(context);
        //} catch (IndexOutOfBoundsException e) {
        //}
    }

    
}

