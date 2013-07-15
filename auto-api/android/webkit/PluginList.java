package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class PluginList {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.372 -0400", hash_original_field = "3BBFD44F77386E6A06EB986F62953E04", hash_generated_field = "2E9E45DF2A62E67ADA94EFB03194A6CB")

    private ArrayList<Plugin> mPlugins;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.373 -0400", hash_original_method = "AFA11BE3CB57F72948CE6AE6103E33EF", hash_generated_method = "C0A35AE6C5CE177275069814697F2449")
    @Deprecated
    public  PluginList() {
        mPlugins = new ArrayList<Plugin>();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.373 -0400", hash_original_method = "1801070113215AA650907EEB61F166CD", hash_generated_method = "FBC44DE60F04FD4D0A25B8A8027B7053")
    @Deprecated
    public synchronized List getList() {
        List varB4EAC82CA7396A68D541C85D26508E83_1272236828 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1272236828 = mPlugins;
        varB4EAC82CA7396A68D541C85D26508E83_1272236828.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1272236828;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.374 -0400", hash_original_method = "C7DCB9134CAFAAB6388686E1F6701327", hash_generated_method = "1681F3343C41A62D7F6C152F1CFBEFBE")
    @Deprecated
    public synchronized void addPlugin(Plugin plugin) {
        {
            boolean varC0E6DCC2C7B71BDBD19F3C142F1FFA62_2019771050 = (!mPlugins.contains(plugin));
            {
                mPlugins.add(plugin);
            } 
        } 
        addTaint(plugin.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.374 -0400", hash_original_method = "980F1FA54E922541E9F37CE45E714F3E", hash_generated_method = "093FB327AB38CC257AA2E3FE018C2F47")
    @Deprecated
    public synchronized void removePlugin(Plugin plugin) {
        int location = mPlugins.indexOf(plugin);
        {
            mPlugins.remove(location);
        } 
        addTaint(plugin.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.374 -0400", hash_original_method = "D08BA028CDC8B846863357DB1B876085", hash_generated_method = "DCFA1CD279657F7D3B02F4C9E52A23CF")
    @Deprecated
    public synchronized void clear() {
        mPlugins.clear();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.374 -0400", hash_original_method = "FD99E1EA214C7B87A27E9195924486C8", hash_generated_method = "A9F53015B638744701802047DE3454EA")
    @Deprecated
    public synchronized void pluginClicked(Context context, int position) {
        try 
        {
            Plugin plugin = mPlugins.get(position);
            plugin.dispatchClickEvent(context);
        } 
        catch (IndexOutOfBoundsException e)
        { }
        addTaint(context.getTaint());
        addTaint(position);
        
        
            
            
        
        
    }

    
}

