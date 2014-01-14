package android.view.textservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener;

import com.android.internal.textservice.ITextServicesManager;

public final class TextServicesManager {

    /**
     * Retrieve the global TextServicesManager instance, creating it if it doesn't already exist.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.512 -0500", hash_original_method = "818A9F7557AFA3E51F48AB4545B2EDDB", hash_generated_method = "7A23ECBE53D73EDFB2A1F08003C262F0")
    
public static TextServicesManager getInstance() {
        synchronized (TextServicesManager.class) {
            if (sInstance != null) {
                return sInstance;
            }
            sInstance = new TextServicesManager();
        }
        return sInstance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.499 -0500", hash_original_field = "950CB17C61FD4EA41D1C78B02596638A", hash_generated_field = "CA1CF66AA4296CAE6DA89B4A033D5D06")

    private static final String TAG = TextServicesManager.class.getSimpleName();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.501 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.504 -0500", hash_original_field = "A82911E658B2C72E4F8802885050882D", hash_generated_field = "C8FA124301EED2431C4D22EB09223E94")

    private static TextServicesManager sInstance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.506 -0500", hash_original_field = "95CDD9B4B410618635F97CABFD44149C", hash_generated_field = "BCB4F2C99AD5684E437C6C7FDD215756")

    private static ITextServicesManager sService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.056 -0400", hash_original_method = "378570C283DD42AD8C379B99FE38C5D3", hash_generated_method = "6D8E7E5AC37BE0D0EB3E290F31648406")
    private  TextServicesManager() {
        /*
        if(sService == null)        
        {
            IBinder b = ServiceManager.getService(Context.TEXT_SERVICES_MANAGER_SERVICE);
            sService = ITextServicesManager.Stub.asInterface(b);
        } //End block
        */
        // ---------- Original Method ----------
        //if (sService == null) {
            //IBinder b = ServiceManager.getService(Context.TEXT_SERVICES_MANAGER_SERVICE);
            //sService = ITextServicesManager.Stub.asInterface(b);
        //}
    }

    /**
     * Get a spell checker session for the specified spell checker
     * @param locale the locale for the spell checker. If {@param locale} is null and
     * referToSpellCheckerLanguageSettings is true, the locale specified in Settings will be
     * returned. If {@param locale} is not null and referToSpellCheckerLanguageSettings is true,
     * the locale specified in Settings will be returned only when it is same as {@param locale}.
     * Exceptionally, when referToSpellCheckerLanguageSettings is true and {@param locale} is
     * only language (e.g. "en"), the specified locale in Settings (e.g. "en_US") will be
     * selected.
     * @param listener a spell checker session lister for getting results from a spell checker.
     * @param referToSpellCheckerLanguageSettings if true, the session for one of enabled
     * languages in settings will be returned.
     * @return the spell checker session of the spell checker
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.516 -0500", hash_original_method = "ABA188D86B8DA63ED0FEF813BC6FEFB9", hash_generated_method = "33D92E01EC6B9451C8CC684770178036")
    
public SpellCheckerSession newSpellCheckerSession(Bundle bundle, Locale locale,
            SpellCheckerSessionListener listener, boolean referToSpellCheckerLanguageSettings) {
        if (listener == null) {
            throw new NullPointerException();
        }
        if (!referToSpellCheckerLanguageSettings && locale == null) {
            throw new IllegalArgumentException("Locale should not be null if you don't refer"
                    + " settings.");
        }

        if (referToSpellCheckerLanguageSettings && !isSpellCheckerEnabled()) {
            return null;
        }

        final SpellCheckerInfo sci;
        try {
            sci = sService.getCurrentSpellChecker(null);
        } catch (RemoteException e) {
            return null;
        }
        if (sci == null) {
            return null;
        }
        SpellCheckerSubtype subtypeInUse = null;
        if (referToSpellCheckerLanguageSettings) {
            subtypeInUse = getCurrentSpellCheckerSubtype(true);
            if (subtypeInUse == null) {
                return null;
            }
            if (locale != null) {
                final String subtypeLocale = subtypeInUse.getLocale();
                final String inputLocale = locale.toString();
                if (subtypeLocale.length() < 2 || inputLocale.length() < 2
                        || !subtypeLocale.substring(0, 2).equals(inputLocale.substring(0, 2))) {
                    return null;
                }
            }
        } else {
            final String localeStr = locale.toString();
            for (int i = 0; i < sci.getSubtypeCount(); ++i) {
                final SpellCheckerSubtype subtype = sci.getSubtypeAt(i);
                final String tempSubtypeLocale = subtype.getLocale();
                if (tempSubtypeLocale.equals(localeStr)) {
                    subtypeInUse = subtype;
                    break;
                } else if (localeStr.length() >= 2 && tempSubtypeLocale.length() >= 2
                        && localeStr.startsWith(tempSubtypeLocale)) {
                    subtypeInUse = subtype;
                }
            }
        }
        if (subtypeInUse == null) {
            return null;
        }
        final SpellCheckerSession session = new SpellCheckerSession(sci, sService, listener);
        try {
            sService.getSpellCheckerService(sci.getId(), subtypeInUse.getLocale(),
                    session.getTextServicesSessionListener(),
                    session.getSpellCheckerSessionListener(), bundle);
        } catch (RemoteException e) {
            return null;
        }
        return session;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.518 -0500", hash_original_method = "996F778F72629C35F59A814BE7E587F6", hash_generated_method = "E251415AB5E626FBDF7980F548B14732")
    
public SpellCheckerInfo[] getEnabledSpellCheckers() {
        try {
            final SpellCheckerInfo[] retval = sService.getEnabledSpellCheckers();
            if (DBG) {
                Log.d(TAG, "getEnabledSpellCheckers: " + (retval != null ? retval.length : "null"));
            }
            return retval;
        } catch (RemoteException e) {
            Log.e(TAG, "Error in getEnabledSpellCheckers: " + e);
            return null;
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.521 -0500", hash_original_method = "A6F1D379519B22786C64C08B94869872", hash_generated_method = "67E1A73C9BB08CF84E611330E81B471E")
    
public SpellCheckerInfo getCurrentSpellChecker() {
        try {
            // Passing null as a locale for ICS
            return sService.getCurrentSpellChecker(null);
        } catch (RemoteException e) {
            return null;
        }
    }

    /**
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.523 -0500", hash_original_method = "4E93A8413D33E514F2933033BBA9E9C6", hash_generated_method = "C22F703830145D2CEBC318C7C98D180F")
    
public void setCurrentSpellChecker(SpellCheckerInfo sci) {
        try {
            if (sci == null) {
                throw new NullPointerException("SpellCheckerInfo is null.");
            }
            sService.setCurrentSpellChecker(null, sci.getId());
        } catch (RemoteException e) {
            Log.e(TAG, "Error in setCurrentSpellChecker: " + e);
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.526 -0500", hash_original_method = "A09B5B882B337AC1ACCDB12AE24B1D1D", hash_generated_method = "36DE492E4C2B12A218D9F69B818CB76C")
    
public SpellCheckerSubtype getCurrentSpellCheckerSubtype(
            boolean allowImplicitlySelectedSubtype) {
        try {
            // Passing null as a locale for ICS
            return sService.getCurrentSpellCheckerSubtype(null, allowImplicitlySelectedSubtype);
        } catch (RemoteException e) {
            Log.e(TAG, "Error in getCurrentSpellCheckerSubtype: " + e);
            return null;
        }
    }

    /**
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.528 -0500", hash_original_method = "CBCFCEE50800407BA5D76453EB5E1B5E", hash_generated_method = "0FCAD81A9A40E76F63E30EB4A07EA36C")
    
public void setSpellCheckerSubtype(SpellCheckerSubtype subtype) {
        try {
            final int hashCode;
            if (subtype == null) {
                hashCode = 0;
            } else {
                hashCode = subtype.hashCode();
            }
            sService.setCurrentSpellCheckerSubtype(null, hashCode);
        } catch (RemoteException e) {
            Log.e(TAG, "Error in setSpellCheckerSubtype:" + e);
        }
    }

    /**
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.531 -0500", hash_original_method = "61F4D400D4BC8B241A007E9AEF488847", hash_generated_method = "3E27938A1621CB00828E5E8511D5EE35")
    
public void setSpellCheckerEnabled(boolean enabled) {
        try {
            sService.setSpellCheckerEnabled(enabled);
        } catch (RemoteException e) {
            Log.e(TAG, "Error in setSpellCheckerEnabled:" + e);
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.533 -0500", hash_original_method = "AE8BC5A0830A7B4F81FE6C44FCEBBBC8", hash_generated_method = "01438B1F64BCE7B936E4ED745978FBB6")
    
public boolean isSpellCheckerEnabled() {
        try {
            return sService.isSpellCheckerEnabled();
        } catch (RemoteException e) {
            Log.e(TAG, "Error in isSpellCheckerEnabled:" + e);
            return false;
        }
    }
}

