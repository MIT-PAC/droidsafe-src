package android.view.textservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.textservice.ITextServicesManager;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener;
import java.util.Locale;

public final class TextServicesManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.845 -0400", hash_original_method = "378570C283DD42AD8C379B99FE38C5D3", hash_generated_method = "121BF9762B4796B8F9B7A602579D43F4")
    private  TextServicesManager() {
        {
            IBinder b;
            b = ServiceManager.getService(Context.TEXT_SERVICES_MANAGER_SERVICE);
            sService = ITextServicesManager.Stub.asInterface(b);
        } //End block
        // ---------- Original Method ----------
        //if (sService == null) {
            //IBinder b = ServiceManager.getService(Context.TEXT_SERVICES_MANAGER_SERVICE);
            //sService = ITextServicesManager.Stub.asInterface(b);
        //}
    }

    
        public static TextServicesManager getInstance() {
        synchronized (TextServicesManager.class) {
            if (sInstance != null) {
                return sInstance;
            }
            sInstance = new TextServicesManager();
        }
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.856 -0400", hash_original_method = "ABA188D86B8DA63ED0FEF813BC6FEFB9", hash_generated_method = "12CE856CA4D2E81F9FCAD2E993CD820D")
    public SpellCheckerSession newSpellCheckerSession(Bundle bundle, Locale locale,
            SpellCheckerSessionListener listener, boolean referToSpellCheckerLanguageSettings) {
        SpellCheckerSession varB4EAC82CA7396A68D541C85D26508E83_865040219 = null; //Variable for return #1
        SpellCheckerSession varB4EAC82CA7396A68D541C85D26508E83_580960089 = null; //Variable for return #2
        SpellCheckerSession varB4EAC82CA7396A68D541C85D26508E83_1812996001 = null; //Variable for return #3
        SpellCheckerSession varB4EAC82CA7396A68D541C85D26508E83_409977611 = null; //Variable for return #4
        SpellCheckerSession varB4EAC82CA7396A68D541C85D26508E83_807851797 = null; //Variable for return #5
        SpellCheckerSession varB4EAC82CA7396A68D541C85D26508E83_1050404870 = null; //Variable for return #6
        SpellCheckerSession varB4EAC82CA7396A68D541C85D26508E83_2089742794 = null; //Variable for return #7
        SpellCheckerSession varB4EAC82CA7396A68D541C85D26508E83_1270774207 = null; //Variable for return #8
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Locale should not be null if you don't refer"
                    + " settings.");
        } //End block
        {
            boolean varAE153CACF515DD15F9D7ED949C537F7C_617772870 = (referToSpellCheckerLanguageSettings && !isSpellCheckerEnabled());
            {
                varB4EAC82CA7396A68D541C85D26508E83_865040219 = null;
            } //End block
        } //End collapsed parenthetic
        SpellCheckerInfo sci;
        try 
        {
            sci = sService.getCurrentSpellChecker(null);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_580960089 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1812996001 = null;
        } //End block
        SpellCheckerSubtype subtypeInUse;
        subtypeInUse = null;
        {
            subtypeInUse = getCurrentSpellCheckerSubtype(true);
            {
                varB4EAC82CA7396A68D541C85D26508E83_409977611 = null;
            } //End block
            {
                String subtypeLocale;
                subtypeLocale = subtypeInUse.getLocale();
                String inputLocale;
                inputLocale = locale.toString();
                {
                    boolean varFB2C55CC871F0D4A3B2B6CBA52C85BE9_970061098 = (subtypeLocale.length() < 2 || inputLocale.length() < 2
                        || !subtypeLocale.substring(0, 2).equals(inputLocale.substring(0, 2)));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_807851797 = null;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            String localeStr;
            localeStr = locale.toString();
            {
                int i;
                i = 0;
                boolean var91A668829756F27FA362090332180714_1947463015 = (i < sci.getSubtypeCount());
                {
                    SpellCheckerSubtype subtype;
                    subtype = sci.getSubtypeAt(i);
                    String tempSubtypeLocale;
                    tempSubtypeLocale = subtype.getLocale();
                    {
                        boolean varDD5E0DC9FE11944EDC9A2A70C01AFDC9_1199143886 = (tempSubtypeLocale.equals(localeStr));
                        {
                            subtypeInUse = subtype;
                        } //End block
                        {
                            boolean varF1E002C431217CB35F3C73615F9E1D01_2089467375 = (localeStr.length() >= 2 && tempSubtypeLocale.length() >= 2
                        && localeStr.startsWith(tempSubtypeLocale));
                            {
                                subtypeInUse = subtype;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1050404870 = null;
        } //End block
        SpellCheckerSession session;
        session = new SpellCheckerSession(sci, sService, listener);
        try 
        {
            sService.getSpellCheckerService(sci.getId(), subtypeInUse.getLocale(),
                    session.getTextServicesSessionListener(),
                    session.getSpellCheckerSessionListener(), bundle);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2089742794 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1270774207 = session;
        addTaint(bundle.getTaint());
        addTaint(locale.getTaint());
        addTaint(listener.getTaint());
        addTaint(referToSpellCheckerLanguageSettings);
        SpellCheckerSession varA7E53CE21691AB073D9660D615818899_1181171635; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1181171635 = varB4EAC82CA7396A68D541C85D26508E83_865040219;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1181171635 = varB4EAC82CA7396A68D541C85D26508E83_580960089;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1181171635 = varB4EAC82CA7396A68D541C85D26508E83_1812996001;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1181171635 = varB4EAC82CA7396A68D541C85D26508E83_409977611;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1181171635 = varB4EAC82CA7396A68D541C85D26508E83_807851797;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1181171635 = varB4EAC82CA7396A68D541C85D26508E83_1050404870;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1181171635 = varB4EAC82CA7396A68D541C85D26508E83_2089742794;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1181171635 = varB4EAC82CA7396A68D541C85D26508E83_1270774207;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1181171635.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1181171635;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.861 -0400", hash_original_method = "996F778F72629C35F59A814BE7E587F6", hash_generated_method = "36137FF8D2F645617B9CA094ECC0B7DD")
    public SpellCheckerInfo[] getEnabledSpellCheckers() {
        SpellCheckerInfo[] varB4EAC82CA7396A68D541C85D26508E83_707365361 = null; //Variable for return #1
        SpellCheckerInfo[] varB4EAC82CA7396A68D541C85D26508E83_1022517753 = null; //Variable for return #2
        try 
        {
            SpellCheckerInfo[] retval;
            retval = sService.getEnabledSpellCheckers();
            {
                Log.d(TAG, "getEnabledSpellCheckers: " + (retval != null ? retval.length : "null"));
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_707365361 = retval;
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1022517753 = null;
        } //End block
        SpellCheckerInfo[] varA7E53CE21691AB073D9660D615818899_167099651; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_167099651 = varB4EAC82CA7396A68D541C85D26508E83_707365361;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_167099651 = varB4EAC82CA7396A68D541C85D26508E83_1022517753;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_167099651.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_167099651;
        // ---------- Original Method ----------
        //try {
            //final SpellCheckerInfo[] retval = sService.getEnabledSpellCheckers();
            //if (DBG) {
                //Log.d(TAG, "getEnabledSpellCheckers: " + (retval != null ? retval.length : "null"));
            //}
            //return retval;
        //} catch (RemoteException e) {
            //Log.e(TAG, "Error in getEnabledSpellCheckers: " + e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.861 -0400", hash_original_method = "A6F1D379519B22786C64C08B94869872", hash_generated_method = "60B26AA40AE25CC0B7F8212A39E3C38A")
    public SpellCheckerInfo getCurrentSpellChecker() {
        SpellCheckerInfo varB4EAC82CA7396A68D541C85D26508E83_2097495744 = null; //Variable for return #1
        SpellCheckerInfo varB4EAC82CA7396A68D541C85D26508E83_1800788552 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2097495744 = sService.getCurrentSpellChecker(null);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1800788552 = null;
        } //End block
        SpellCheckerInfo varA7E53CE21691AB073D9660D615818899_455623751; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_455623751 = varB4EAC82CA7396A68D541C85D26508E83_2097495744;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_455623751 = varB4EAC82CA7396A68D541C85D26508E83_1800788552;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_455623751.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_455623751;
        // ---------- Original Method ----------
        //try {
            //return sService.getCurrentSpellChecker(null);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.975 -0400", hash_original_method = "4E93A8413D33E514F2933033BBA9E9C6", hash_generated_method = "986FFB51D96D50CC0E01A022776DC757")
    public void setCurrentSpellChecker(SpellCheckerInfo sci) {
        try 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("SpellCheckerInfo is null.");
            } //End block
            sService.setCurrentSpellChecker(null, sci.getId());
        } //End block
        catch (RemoteException e)
        { }
        addTaint(sci.getTaint());
        // ---------- Original Method ----------
        //try {
            //if (sci == null) {
                //throw new NullPointerException("SpellCheckerInfo is null.");
            //}
            //sService.setCurrentSpellChecker(null, sci.getId());
        //} catch (RemoteException e) {
            //Log.e(TAG, "Error in setCurrentSpellChecker: " + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.976 -0400", hash_original_method = "A09B5B882B337AC1ACCDB12AE24B1D1D", hash_generated_method = "0E2DC7C8DA6A3C9706B4B20D9C8AD948")
    public SpellCheckerSubtype getCurrentSpellCheckerSubtype(
            boolean allowImplicitlySelectedSubtype) {
        SpellCheckerSubtype varB4EAC82CA7396A68D541C85D26508E83_1236372204 = null; //Variable for return #1
        SpellCheckerSubtype varB4EAC82CA7396A68D541C85D26508E83_1281632986 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1236372204 = sService.getCurrentSpellCheckerSubtype(null, allowImplicitlySelectedSubtype);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1281632986 = null;
        } //End block
        addTaint(allowImplicitlySelectedSubtype);
        SpellCheckerSubtype varA7E53CE21691AB073D9660D615818899_1323870871; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1323870871 = varB4EAC82CA7396A68D541C85D26508E83_1236372204;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1323870871 = varB4EAC82CA7396A68D541C85D26508E83_1281632986;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1323870871.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1323870871;
        // ---------- Original Method ----------
        //try {
            //return sService.getCurrentSpellCheckerSubtype(null, allowImplicitlySelectedSubtype);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Error in getCurrentSpellCheckerSubtype: " + e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.976 -0400", hash_original_method = "CBCFCEE50800407BA5D76453EB5E1B5E", hash_generated_method = "77FB090C343039795BD9190AB6132997")
    public void setSpellCheckerSubtype(SpellCheckerSubtype subtype) {
        try 
        {
            int hashCode;
            {
                hashCode = 0;
            } //End block
            {
                hashCode = subtype.hashCode();
            } //End block
            sService.setCurrentSpellCheckerSubtype(null, hashCode);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(subtype.getTaint());
        // ---------- Original Method ----------
        //try {
            //final int hashCode;
            //if (subtype == null) {
                //hashCode = 0;
            //} else {
                //hashCode = subtype.hashCode();
            //}
            //sService.setCurrentSpellCheckerSubtype(null, hashCode);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Error in setSpellCheckerSubtype:" + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.984 -0400", hash_original_method = "61F4D400D4BC8B241A007E9AEF488847", hash_generated_method = "606078ACBF5065AF19B20AC59DE8573A")
    public void setSpellCheckerEnabled(boolean enabled) {
        try 
        {
            sService.setSpellCheckerEnabled(enabled);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(enabled);
        // ---------- Original Method ----------
        //try {
            //sService.setSpellCheckerEnabled(enabled);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Error in setSpellCheckerEnabled:" + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.984 -0400", hash_original_method = "AE8BC5A0830A7B4F81FE6C44FCEBBBC8", hash_generated_method = "D3F374A90BC16BA97799B48A46F2AA7A")
    public boolean isSpellCheckerEnabled() {
        try 
        {
            boolean var98DAB68A19D2280AF6FE404001D9BF3B_1865160261 = (sService.isSpellCheckerEnabled());
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1734883633 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1734883633;
        // ---------- Original Method ----------
        //try {
            //return sService.isSpellCheckerEnabled();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Error in isSpellCheckerEnabled:" + e);
            //return false;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.985 -0400", hash_original_field = "B218BA2759A3CA676BC0CDFE35CD8348", hash_generated_field = "0A94B0A660F73DED2B43C2CC3855C913")

    private static String TAG = TextServicesManager.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.985 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "B7C4E93D97D072890A37A56076D870F8")

    private static boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.985 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "C8FA124301EED2431C4D22EB09223E94")

    private static TextServicesManager sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.985 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "BCB4F2C99AD5684E437C6C7FDD215756")

    private static ITextServicesManager sService;
}

