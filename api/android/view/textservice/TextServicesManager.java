package android.view.textservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.758 -0400", hash_original_method = "378570C283DD42AD8C379B99FE38C5D3", hash_generated_method = "6D8E7E5AC37BE0D0EB3E290F31648406")
    private  TextServicesManager() {
    if(sService == null)        
        {
            IBinder b = ServiceManager.getService(Context.TEXT_SERVICES_MANAGER_SERVICE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.761 -0400", hash_original_method = "ABA188D86B8DA63ED0FEF813BC6FEFB9", hash_generated_method = "52CD7FAF17E001E1EF8EE1B9C2C4BA4B")
    public SpellCheckerSession newSpellCheckerSession(Bundle bundle, Locale locale,
            SpellCheckerSessionListener listener, boolean referToSpellCheckerLanguageSettings) {
        addTaint(referToSpellCheckerLanguageSettings);
        addTaint(listener.getTaint());
        addTaint(locale.getTaint());
        addTaint(bundle.getTaint());
    if(listener == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1746712030 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1746712030.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1746712030;
        } //End block
    if(!referToSpellCheckerLanguageSettings && locale == null)        
        {
            IllegalArgumentException var049408D924C2121FDC2D270D0D8FC1DD_382479747 = new IllegalArgumentException("Locale should not be null if you don't refer"
                    + " settings.");
            var049408D924C2121FDC2D270D0D8FC1DD_382479747.addTaint(taint);
            throw var049408D924C2121FDC2D270D0D8FC1DD_382479747;
        } //End block
    if(referToSpellCheckerLanguageSettings && !isSpellCheckerEnabled())        
        {
SpellCheckerSession var540C13E9E156B687226421B24F2DF178_2146800898 =             null;
            var540C13E9E156B687226421B24F2DF178_2146800898.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2146800898;
        } //End block
        SpellCheckerInfo sci;
        try 
        {
            sci = sService.getCurrentSpellChecker(null);
        } //End block
        catch (RemoteException e)
        {
SpellCheckerSession var540C13E9E156B687226421B24F2DF178_298570864 =             null;
            var540C13E9E156B687226421B24F2DF178_298570864.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_298570864;
        } //End block
    if(sci == null)        
        {
SpellCheckerSession var540C13E9E156B687226421B24F2DF178_10262072 =             null;
            var540C13E9E156B687226421B24F2DF178_10262072.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_10262072;
        } //End block
        SpellCheckerSubtype subtypeInUse = null;
    if(referToSpellCheckerLanguageSettings)        
        {
            subtypeInUse = getCurrentSpellCheckerSubtype(true);
    if(subtypeInUse == null)            
            {
SpellCheckerSession var540C13E9E156B687226421B24F2DF178_1440010278 =                 null;
                var540C13E9E156B687226421B24F2DF178_1440010278.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1440010278;
            } //End block
    if(locale != null)            
            {
                final String subtypeLocale = subtypeInUse.getLocale();
                final String inputLocale = locale.toString();
    if(subtypeLocale.length() < 2 || inputLocale.length() < 2
                        || !subtypeLocale.substring(0, 2).equals(inputLocale.substring(0, 2)))                
                {
SpellCheckerSession var540C13E9E156B687226421B24F2DF178_1090626192 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1090626192.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1090626192;
                } //End block
            } //End block
        } //End block
        else
        {
            final String localeStr = locale.toString();
for(int i = 0;i < sci.getSubtypeCount();++i)
            {
                final SpellCheckerSubtype subtype = sci.getSubtypeAt(i);
                final String tempSubtypeLocale = subtype.getLocale();
    if(tempSubtypeLocale.equals(localeStr))                
                {
                    subtypeInUse = subtype;
                    break;
                } //End block
                else
    if(localeStr.length() >= 2 && tempSubtypeLocale.length() >= 2
                        && localeStr.startsWith(tempSubtypeLocale))                
                {
                    subtypeInUse = subtype;
                } //End block
            } //End block
        } //End block
    if(subtypeInUse == null)        
        {
SpellCheckerSession var540C13E9E156B687226421B24F2DF178_1239524019 =             null;
            var540C13E9E156B687226421B24F2DF178_1239524019.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1239524019;
        } //End block
        final SpellCheckerSession session = new SpellCheckerSession(sci, sService, listener);
        try 
        {
            sService.getSpellCheckerService(sci.getId(), subtypeInUse.getLocale(),
                    session.getTextServicesSessionListener(),
                    session.getSpellCheckerSessionListener(), bundle);
        } //End block
        catch (RemoteException e)
        {
SpellCheckerSession var540C13E9E156B687226421B24F2DF178_1921362866 =             null;
            var540C13E9E156B687226421B24F2DF178_1921362866.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1921362866;
        } //End block
SpellCheckerSession varD555E544A66E0F97DA6BCDE940E3E79C_960480253 =         session;
        varD555E544A66E0F97DA6BCDE940E3E79C_960480253.addTaint(taint);
        return varD555E544A66E0F97DA6BCDE940E3E79C_960480253;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.764 -0400", hash_original_method = "996F778F72629C35F59A814BE7E587F6", hash_generated_method = "F6638ACB9B8B5A5E621740D8365C5864")
    public SpellCheckerInfo[] getEnabledSpellCheckers() {
        try 
        {
            final SpellCheckerInfo[] retval = sService.getEnabledSpellCheckers();
    if(DBG)            
            {
                Log.d(TAG, "getEnabledSpellCheckers: " + (retval != null ? retval.length : "null"));
            } //End block
SpellCheckerInfo[] varF9E19AD6135C970F387F77C6F3DE4477_2026757765 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_2026757765.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_2026757765;
        } //End block
        catch (RemoteException e)
        {
SpellCheckerInfo[] var540C13E9E156B687226421B24F2DF178_951997802 =             null;
            var540C13E9E156B687226421B24F2DF178_951997802.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_951997802;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.765 -0400", hash_original_method = "A6F1D379519B22786C64C08B94869872", hash_generated_method = "761DF8093F591A9AABC87D47600F3158")
    public SpellCheckerInfo getCurrentSpellChecker() {
        try 
        {
SpellCheckerInfo var93B4D1EE37EE09C8F6DDDDA2EED201C7_2046001171 =             sService.getCurrentSpellChecker(null);
            var93B4D1EE37EE09C8F6DDDDA2EED201C7_2046001171.addTaint(taint);
            return var93B4D1EE37EE09C8F6DDDDA2EED201C7_2046001171;
        } //End block
        catch (RemoteException e)
        {
SpellCheckerInfo var540C13E9E156B687226421B24F2DF178_1919653598 =             null;
            var540C13E9E156B687226421B24F2DF178_1919653598.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1919653598;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sService.getCurrentSpellChecker(null);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.766 -0400", hash_original_method = "4E93A8413D33E514F2933033BBA9E9C6", hash_generated_method = "7D3902F7FA4C48FD8D129A8242CC75AC")
    public void setCurrentSpellChecker(SpellCheckerInfo sci) {
        addTaint(sci.getTaint());
        try 
        {
    if(sci == null)            
            {
                NullPointerException varB03A091E07FFD936EAF226651CA4A244_1230094480 = new NullPointerException("SpellCheckerInfo is null.");
                varB03A091E07FFD936EAF226651CA4A244_1230094480.addTaint(taint);
                throw varB03A091E07FFD936EAF226651CA4A244_1230094480;
            } //End block
            sService.setCurrentSpellChecker(null, sci.getId());
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.766 -0400", hash_original_method = "A09B5B882B337AC1ACCDB12AE24B1D1D", hash_generated_method = "8E1B25CB5D53F0941F77444BE3CB2810")
    public SpellCheckerSubtype getCurrentSpellCheckerSubtype(
            boolean allowImplicitlySelectedSubtype) {
        addTaint(allowImplicitlySelectedSubtype);
        try 
        {
SpellCheckerSubtype var7A3F944B0E30A3F8F4F1D67EE1CD7074_489229437 =             sService.getCurrentSpellCheckerSubtype(null, allowImplicitlySelectedSubtype);
            var7A3F944B0E30A3F8F4F1D67EE1CD7074_489229437.addTaint(taint);
            return var7A3F944B0E30A3F8F4F1D67EE1CD7074_489229437;
        } //End block
        catch (RemoteException e)
        {
SpellCheckerSubtype var540C13E9E156B687226421B24F2DF178_1839462041 =             null;
            var540C13E9E156B687226421B24F2DF178_1839462041.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1839462041;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sService.getCurrentSpellCheckerSubtype(null, allowImplicitlySelectedSubtype);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Error in getCurrentSpellCheckerSubtype: " + e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.767 -0400", hash_original_method = "CBCFCEE50800407BA5D76453EB5E1B5E", hash_generated_method = "F80836F3B5624BA7E6A4CB5D280EC08F")
    public void setSpellCheckerSubtype(SpellCheckerSubtype subtype) {
        addTaint(subtype.getTaint());
        try 
        {
            int hashCode;
    if(subtype == null)            
            {
                hashCode = 0;
            } //End block
            else
            {
                hashCode = subtype.hashCode();
            } //End block
            sService.setCurrentSpellCheckerSubtype(null, hashCode);
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.768 -0400", hash_original_method = "61F4D400D4BC8B241A007E9AEF488847", hash_generated_method = "EBC90A9FBC4A8A5F5D1EDF858B02229E")
    public void setSpellCheckerEnabled(boolean enabled) {
        addTaint(enabled);
        try 
        {
            sService.setSpellCheckerEnabled(enabled);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //sService.setSpellCheckerEnabled(enabled);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Error in setSpellCheckerEnabled:" + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.768 -0400", hash_original_method = "AE8BC5A0830A7B4F81FE6C44FCEBBBC8", hash_generated_method = "41BC9E842162A8103955E0AB1462D90C")
    public boolean isSpellCheckerEnabled() {
        try 
        {
            boolean var7E195E4F1E9C259AB047738E613FAF8E_452760130 = (sService.isSpellCheckerEnabled());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2096394595 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2096394595;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1373425416 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1411233404 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1411233404;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sService.isSpellCheckerEnabled();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Error in isSpellCheckerEnabled:" + e);
            //return false;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.768 -0400", hash_original_field = "B218BA2759A3CA676BC0CDFE35CD8348", hash_generated_field = "CA1CF66AA4296CAE6DA89B4A033D5D06")

    private static final String TAG = TextServicesManager.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.768 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.768 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "C8FA124301EED2431C4D22EB09223E94")

    private static TextServicesManager sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.768 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "BCB4F2C99AD5684E437C6C7FDD215756")

    private static ITextServicesManager sService;
}

