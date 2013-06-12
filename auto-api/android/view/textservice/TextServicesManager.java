package android.view.textservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String TAG = TextServicesManager.class.getSimpleName();
    private static final boolean DBG = false;
    private static TextServicesManager sInstance;
    private static ITextServicesManager sService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.562 -0400", hash_original_method = "378570C283DD42AD8C379B99FE38C5D3", hash_generated_method = "D2DC8059F268FCBC60729FCF3217E97B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private TextServicesManager() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.562 -0400", hash_original_method = "818A9F7557AFA3E51F48AB4545B2EDDB", hash_generated_method = "7A23ECBE53D73EDFB2A1F08003C262F0")
    public static TextServicesManager getInstance() {
        synchronized (TextServicesManager.class) {
            if (sInstance != null) {
                return sInstance;
            }
            sInstance = new TextServicesManager();
        }
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.562 -0400", hash_original_method = "ABA188D86B8DA63ED0FEF813BC6FEFB9", hash_generated_method = "F7D78B7B9662CE792D91C68BA388400D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpellCheckerSession newSpellCheckerSession(Bundle bundle, Locale locale,
            SpellCheckerSessionListener listener, boolean referToSpellCheckerLanguageSettings) {
        dsTaint.addTaint(referToSpellCheckerLanguageSettings);
        dsTaint.addTaint(locale.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(bundle.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        {
            throw new IllegalArgumentException("Locale should not be null if you don't refer"
                    + " settings.");
        } //End block
        {
            boolean varAE153CACF515DD15F9D7ED949C537F7C_1472645330 = (referToSpellCheckerLanguageSettings && !isSpellCheckerEnabled());
        } //End collapsed parenthetic
        final SpellCheckerInfo sci;
        try 
        {
            sci = sService.getCurrentSpellChecker(null);
        } //End block
        catch (RemoteException e)
        { }
        SpellCheckerSubtype subtypeInUse;
        subtypeInUse = null;
        {
            subtypeInUse = getCurrentSpellCheckerSubtype(true);
            {
                final String subtypeLocale;
                subtypeLocale = subtypeInUse.getLocale();
                final String inputLocale;
                inputLocale = locale.toString();
                {
                    boolean varFB2C55CC871F0D4A3B2B6CBA52C85BE9_646922503 = (subtypeLocale.length() < 2 || inputLocale.length() < 2
                        || !subtypeLocale.substring(0, 2).equals(inputLocale.substring(0, 2)));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            final String localeStr;
            localeStr = locale.toString();
            {
                int i;
                i = 0;
                boolean var91A668829756F27FA362090332180714_1357554332 = (i < sci.getSubtypeCount());
                {
                    final SpellCheckerSubtype subtype;
                    subtype = sci.getSubtypeAt(i);
                    final String tempSubtypeLocale;
                    tempSubtypeLocale = subtype.getLocale();
                    {
                        boolean varDD5E0DC9FE11944EDC9A2A70C01AFDC9_1812259042 = (tempSubtypeLocale.equals(localeStr));
                        {
                            subtypeInUse = subtype;
                        } //End block
                        {
                            boolean varF1E002C431217CB35F3C73615F9E1D01_1578546405 = (localeStr.length() >= 2 && tempSubtypeLocale.length() >= 2
                        && localeStr.startsWith(tempSubtypeLocale));
                            {
                                subtypeInUse = subtype;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        final SpellCheckerSession session;
        session = new SpellCheckerSession(sci, sService, listener);
        try 
        {
            sService.getSpellCheckerService(sci.getId(), subtypeInUse.getLocale(),
                    session.getTextServicesSessionListener(),
                    session.getSpellCheckerSessionListener(), bundle);
        } //End block
        catch (RemoteException e)
        { }
        return (SpellCheckerSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.562 -0400", hash_original_method = "996F778F72629C35F59A814BE7E587F6", hash_generated_method = "132C55D1F4EE9BCC2B9A232CF67F638C")
    @DSModeled(DSC.SAFE)
    public SpellCheckerInfo[] getEnabledSpellCheckers() {
        try 
        {
            final SpellCheckerInfo[] retval;
            retval = sService.getEnabledSpellCheckers();
            {
                Log.d(TAG, "getEnabledSpellCheckers: " + (retval != null ? retval.length : "null"));
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        return (SpellCheckerInfo[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.563 -0400", hash_original_method = "A6F1D379519B22786C64C08B94869872", hash_generated_method = "2AF7675494205520C2D4707CF9C5AF7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpellCheckerInfo getCurrentSpellChecker() {
        try 
        {
            SpellCheckerInfo var4113E7BD9384E4EF394D5E82650190E0_1452611612 = (sService.getCurrentSpellChecker(null));
        } //End block
        catch (RemoteException e)
        { }
        return (SpellCheckerInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return sService.getCurrentSpellChecker(null);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.563 -0400", hash_original_method = "4E93A8413D33E514F2933033BBA9E9C6", hash_generated_method = "65860F7634699C3D9244F182CEC9CCD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCurrentSpellChecker(SpellCheckerInfo sci) {
        dsTaint.addTaint(sci.dsTaint);
        try 
        {
            {
                throw new NullPointerException("SpellCheckerInfo is null.");
            } //End block
            sService.setCurrentSpellChecker(null, sci.getId());
        } //End block
        catch (RemoteException e)
        { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.563 -0400", hash_original_method = "A09B5B882B337AC1ACCDB12AE24B1D1D", hash_generated_method = "C2A6B6C012145731A858BFE078036B14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpellCheckerSubtype getCurrentSpellCheckerSubtype(
            boolean allowImplicitlySelectedSubtype) {
        dsTaint.addTaint(allowImplicitlySelectedSubtype);
        try 
        {
            SpellCheckerSubtype varC15F4BC81E0EED97BD95CE2A178D3719_1200996092 = (sService.getCurrentSpellCheckerSubtype(null, allowImplicitlySelectedSubtype));
        } //End block
        catch (RemoteException e)
        { }
        return (SpellCheckerSubtype)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return sService.getCurrentSpellCheckerSubtype(null, allowImplicitlySelectedSubtype);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Error in getCurrentSpellCheckerSubtype: " + e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.563 -0400", hash_original_method = "CBCFCEE50800407BA5D76453EB5E1B5E", hash_generated_method = "5100C6CD8BF2AE3EF201BCD61532B5D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSpellCheckerSubtype(SpellCheckerSubtype subtype) {
        dsTaint.addTaint(subtype.dsTaint);
        try 
        {
            final int hashCode;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.563 -0400", hash_original_method = "61F4D400D4BC8B241A007E9AEF488847", hash_generated_method = "20359094C0AC263D10DE6C0CC3728836")
    @DSModeled(DSC.SAFE)
    public void setSpellCheckerEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        try 
        {
            sService.setSpellCheckerEnabled(enabled);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //sService.setSpellCheckerEnabled(enabled);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Error in setSpellCheckerEnabled:" + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.563 -0400", hash_original_method = "AE8BC5A0830A7B4F81FE6C44FCEBBBC8", hash_generated_method = "1717816B04681877A6B672F8ED2D14E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSpellCheckerEnabled() {
        try 
        {
            boolean var98DAB68A19D2280AF6FE404001D9BF3B_451703711 = (sService.isSpellCheckerEnabled());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.isSpellCheckerEnabled();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Error in isSpellCheckerEnabled:" + e);
            //return false;
        //}
    }

    
}


