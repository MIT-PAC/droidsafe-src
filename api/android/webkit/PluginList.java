package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class PluginList {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.914 -0400", hash_original_field = "3BBFD44F77386E6A06EB986F62953E04", hash_generated_field = "2E9E45DF2A62E67ADA94EFB03194A6CB")

    private ArrayList<Plugin> mPlugins;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.914 -0400", hash_original_method = "AFA11BE3CB57F72948CE6AE6103E33EF", hash_generated_method = "C0A35AE6C5CE177275069814697F2449")
    @Deprecated
    public  PluginList() {
        mPlugins = new ArrayList<Plugin>();
        // ---------- Original Method ----------
        //mPlugins = new ArrayList<Plugin>();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.914 -0400", hash_original_method = "1801070113215AA650907EEB61F166CD", hash_generated_method = "C590C9210FFCD6381096622595377CFE")
    @Deprecated
    public synchronized List getList() {
List varCE31BA4CD4F7594C4294BA5D3443F606_959204321 =         mPlugins;
        varCE31BA4CD4F7594C4294BA5D3443F606_959204321.addTaint(taint);
        return varCE31BA4CD4F7594C4294BA5D3443F606_959204321;
        // ---------- Original Method ----------
        //return mPlugins;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.915 -0400", hash_original_method = "C7DCB9134CAFAAB6388686E1F6701327", hash_generated_method = "67A3D1222E8DE7CD64D71D2CA0545524")
    @Deprecated
    public synchronized void addPlugin(Plugin plugin) {
        addTaint(plugin.getTaint());
    if(!mPlugins.contains(plugin))        
        {
            mPlugins.add(plugin);
        } //End block
        // ---------- Original Method ----------
        //if (!mPlugins.contains(plugin)) {
            //mPlugins.add(plugin);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.915 -0400", hash_original_method = "980F1FA54E922541E9F37CE45E714F3E", hash_generated_method = "7F857B0E768C6CEEE483EBB6149AE6A1")
    @Deprecated
    public synchronized void removePlugin(Plugin plugin) {
        addTaint(plugin.getTaint());
        int location = mPlugins.indexOf(plugin);
    if(location != -1)        
        {
            mPlugins.remove(location);
        } //End block
        // ---------- Original Method ----------
        //int location = mPlugins.indexOf(plugin);
        //if (location != -1) {
            //mPlugins.remove(location);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.915 -0400", hash_original_method = "D08BA028CDC8B846863357DB1B876085", hash_generated_method = "DCFA1CD279657F7D3B02F4C9E52A23CF")
    @Deprecated
    public synchronized void clear() {
        mPlugins.clear();
        // ---------- Original Method ----------
        //mPlugins.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.916 -0400", hash_original_method = "FD99E1EA214C7B87A27E9195924486C8", hash_generated_method = "5AEDE06D92F59382E859C924A8FB4289")
    @Deprecated
    public synchronized void pluginClicked(Context context, int position) {
        addTaint(position);
        addTaint(context.getTaint());
        try 
        {
            Plugin plugin = mPlugins.get(position);
            plugin.dispatchClickEvent(context);
        } //End block
        catch (IndexOutOfBoundsException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //Plugin plugin = mPlugins.get(position);
            //plugin.dispatchClickEvent(context);
        //} catch (IndexOutOfBoundsException e) {
        //}
    }

    
}

