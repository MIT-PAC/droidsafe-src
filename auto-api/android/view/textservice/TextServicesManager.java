package android.view.textservice;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.502 -0400", hash_original_method = "378570C283DD42AD8C379B99FE38C5D3", hash_generated_method = "5FEE2FA58987361BA56AFAA955B5914C")
    private  TextServicesManager() {
        {
            IBinder b = ServiceManager.getService(Context.TEXT_SERVICES_MANAGER_SERVICE);
            sService = ITextServicesManager.Stub.asInterface(b);
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    public static TextServicesManager getInstance() {
        synchronized (TextServicesManager.class) {
            if (sInstance != null) {
                return sInstance;
            }
            sInstance = new TextServicesManager();
        }
        return sInstance;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.505 -0400", hash_original_method = "ABA188D86B8DA63ED0FEF813BC6FEFB9", hash_generated_method = "0658AEC22350FC91A4864AE220FB78B5")
    public SpellCheckerSession newSpellCheckerSession(Bundle bundle, Locale locale,
            SpellCheckerSessionListener listener, boolean referToSpellCheckerLanguageSettings) {
        SpellCheckerSession varB4EAC82CA7396A68D541C85D26508E83_2069200724 = null; 
        SpellCheckerSession varB4EAC82CA7396A68D541C85D26508E83_1097731435 = null; 
        SpellCheckerSession varB4EAC82CA7396A68D541C85D26508E83_345426112 = null; 
        SpellCheckerSession varB4EAC82CA7396A68D541C85D26508E83_163778755 = null; 
        SpellCheckerSession varB4EAC82CA7396A68D541C85D26508E83_1666222217 = null; 
        SpellCheckerSession varB4EAC82CA7396A68D541C85D26508E83_521519694 = null; 
        SpellCheckerSession varB4EAC82CA7396A68D541C85D26508E83_1524268255 = null; 
        SpellCheckerSession varB4EAC82CA7396A68D541C85D26508E83_384967038 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Locale should not be null if you don't refer"
                    + " settings.");
        } 
        {
            boolean varAE153CACF515DD15F9D7ED949C537F7C_2134057676 = (referToSpellCheckerLanguageSettings && !isSpellCheckerEnabled());
            {
                varB4EAC82CA7396A68D541C85D26508E83_2069200724 = null;
            } 
        } 
        SpellCheckerInfo sci;
        try 
        {
            sci = sService.getCurrentSpellChecker(null);
        } 
        catch (RemoteException e)
        {
        	return null;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_345426112 = null;
        } 
        SpellCheckerSubtype subtypeInUse = null;
        {
            subtypeInUse = getCurrentSpellCheckerSubtype(true);
            {
                varB4EAC82CA7396A68D541C85D26508E83_163778755 = null;
            } 
            {
                final String subtypeLocale = subtypeInUse.getLocale();
                final String inputLocale = locale.toString();
                {
                    boolean varFB2C55CC871F0D4A3B2B6CBA52C85BE9_1484237482 = (subtypeLocale.length() < 2 || inputLocale.length() < 2
                        || !subtypeLocale.substring(0, 2).equals(inputLocale.substring(0, 2)));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1666222217 = null;
                    } 
                } 
            } 
        } 
        {
            final String localeStr = locale.toString();
            {
                int i = 0;
                boolean var91A668829756F27FA362090332180714_2098794344 = (i < sci.getSubtypeCount());
                {
                    final SpellCheckerSubtype subtype = sci.getSubtypeAt(i);
                    final String tempSubtypeLocale = subtype.getLocale();
                    {
                        boolean varDD5E0DC9FE11944EDC9A2A70C01AFDC9_1722942325 = (tempSubtypeLocale.equals(localeStr));
                        {
                            subtypeInUse = subtype;
                        } 
                        {
                            boolean varF1E002C431217CB35F3C73615F9E1D01_321351752 = (localeStr.length() >= 2 && tempSubtypeLocale.length() >= 2
                        && localeStr.startsWith(tempSubtypeLocale));
                            {
                                subtypeInUse = subtype;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_521519694 = null;
        } 
        final SpellCheckerSession session = new SpellCheckerSession(sci, sService, listener);
        try 
        {
            sService.getSpellCheckerService(sci.getId(), subtypeInUse.getLocale(),
                    session.getTextServicesSessionListener(),
                    session.getSpellCheckerSessionListener(), bundle);
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1524268255 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_384967038 = session;
        addTaint(bundle.getTaint());
        addTaint(locale.getTaint());
        addTaint(listener.getTaint());
        addTaint(referToSpellCheckerLanguageSettings);
        SpellCheckerSession varA7E53CE21691AB073D9660D615818899_111457720; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_111457720 = varB4EAC82CA7396A68D541C85D26508E83_2069200724;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_111457720 = varB4EAC82CA7396A68D541C85D26508E83_1097731435;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_111457720 = varB4EAC82CA7396A68D541C85D26508E83_345426112;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_111457720 = varB4EAC82CA7396A68D541C85D26508E83_163778755;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_111457720 = varB4EAC82CA7396A68D541C85D26508E83_1666222217;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_111457720 = varB4EAC82CA7396A68D541C85D26508E83_521519694;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_111457720 = varB4EAC82CA7396A68D541C85D26508E83_1524268255;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_111457720 = varB4EAC82CA7396A68D541C85D26508E83_384967038;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_111457720.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_111457720;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.506 -0400", hash_original_method = "996F778F72629C35F59A814BE7E587F6", hash_generated_method = "6C893187918CDD16061A8BD855C7928B")
    public SpellCheckerInfo[] getEnabledSpellCheckers() {
        SpellCheckerInfo[] varB4EAC82CA7396A68D541C85D26508E83_1694354446 = null; 
        SpellCheckerInfo[] varB4EAC82CA7396A68D541C85D26508E83_1690393242 = null; 
        try 
        {
            final SpellCheckerInfo[] retval = sService.getEnabledSpellCheckers();
            {
                Log.d(TAG, "getEnabledSpellCheckers: " + (retval != null ? retval.length : "null"));
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1694354446 = retval;
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1690393242 = null;
        } 
        SpellCheckerInfo[] varA7E53CE21691AB073D9660D615818899_695882757; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_695882757 = varB4EAC82CA7396A68D541C85D26508E83_1694354446;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_695882757 = varB4EAC82CA7396A68D541C85D26508E83_1690393242;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_695882757.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_695882757;
        
        
            
            
                
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.507 -0400", hash_original_method = "A6F1D379519B22786C64C08B94869872", hash_generated_method = "0842C7A7FC748FAE9B221786F2961700")
    public SpellCheckerInfo getCurrentSpellChecker() {
        SpellCheckerInfo varB4EAC82CA7396A68D541C85D26508E83_325961814 = null; 
        SpellCheckerInfo varB4EAC82CA7396A68D541C85D26508E83_1391310420 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_325961814 = sService.getCurrentSpellChecker(null);
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1391310420 = null;
        } 
        SpellCheckerInfo varA7E53CE21691AB073D9660D615818899_1757257532; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1757257532 = varB4EAC82CA7396A68D541C85D26508E83_325961814;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1757257532 = varB4EAC82CA7396A68D541C85D26508E83_1391310420;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1757257532.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1757257532;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.507 -0400", hash_original_method = "4E93A8413D33E514F2933033BBA9E9C6", hash_generated_method = "986FFB51D96D50CC0E01A022776DC757")
    public void setCurrentSpellChecker(SpellCheckerInfo sci) {
        try 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("SpellCheckerInfo is null.");
            } 
            sService.setCurrentSpellChecker(null, sci.getId());
        } 
        catch (RemoteException e)
        { }
        addTaint(sci.getTaint());
        
        
            
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.508 -0400", hash_original_method = "A09B5B882B337AC1ACCDB12AE24B1D1D", hash_generated_method = "0910064C907CF46CB3583484A53B9573")
    public SpellCheckerSubtype getCurrentSpellCheckerSubtype(
            boolean allowImplicitlySelectedSubtype) {
        SpellCheckerSubtype varB4EAC82CA7396A68D541C85D26508E83_1389643439 = null; 
        SpellCheckerSubtype varB4EAC82CA7396A68D541C85D26508E83_137554721 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1389643439 = sService.getCurrentSpellCheckerSubtype(null, allowImplicitlySelectedSubtype);
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_137554721 = null;
        } 
        addTaint(allowImplicitlySelectedSubtype);
        SpellCheckerSubtype varA7E53CE21691AB073D9660D615818899_1460794201; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1460794201 = varB4EAC82CA7396A68D541C85D26508E83_1389643439;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1460794201 = varB4EAC82CA7396A68D541C85D26508E83_137554721;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1460794201.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1460794201;
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.509 -0400", hash_original_method = "CBCFCEE50800407BA5D76453EB5E1B5E", hash_generated_method = "77FB090C343039795BD9190AB6132997")
    public void setSpellCheckerSubtype(SpellCheckerSubtype subtype) {
        try 
        {
            int hashCode;
            {
                hashCode = 0;
            } 
            {
                hashCode = subtype.hashCode();
            } 
            sService.setCurrentSpellCheckerSubtype(null, hashCode);
        } 
        catch (RemoteException e)
        { }
        addTaint(subtype.getTaint());
        
        
            
            
                
            
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.509 -0400", hash_original_method = "61F4D400D4BC8B241A007E9AEF488847", hash_generated_method = "606078ACBF5065AF19B20AC59DE8573A")
    public void setSpellCheckerEnabled(boolean enabled) {
        try 
        {
            sService.setSpellCheckerEnabled(enabled);
        } 
        catch (RemoteException e)
        { }
        addTaint(enabled);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.509 -0400", hash_original_method = "AE8BC5A0830A7B4F81FE6C44FCEBBBC8", hash_generated_method = "6590518C5EF72183665C0119382B218B")
    public boolean isSpellCheckerEnabled() {
        try 
        {
            boolean var98DAB68A19D2280AF6FE404001D9BF3B_1953026039 = (sService.isSpellCheckerEnabled());
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2135209472 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2135209472;
        
        
            
        
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.509 -0400", hash_original_field = "B218BA2759A3CA676BC0CDFE35CD8348", hash_generated_field = "CA1CF66AA4296CAE6DA89B4A033D5D06")

    private static final String TAG = TextServicesManager.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.510 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.510 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "C8FA124301EED2431C4D22EB09223E94")

    private static TextServicesManager sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.510 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "BCB4F2C99AD5684E437C6C7FDD215756")

    private static ITextServicesManager sService;
}

