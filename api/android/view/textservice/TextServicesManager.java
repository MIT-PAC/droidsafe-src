package android.view.textservice;

// Droidsafe Imports
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
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.056 -0400", hash_original_method = "378570C283DD42AD8C379B99FE38C5D3", hash_generated_method = "6D8E7E5AC37BE0D0EB3E290F31648406")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.059 -0400", hash_original_method = "ABA188D86B8DA63ED0FEF813BC6FEFB9", hash_generated_method = "8C463C87CC5E3AE4B7BB2B1210D414D6")
    public SpellCheckerSession newSpellCheckerSession(Bundle bundle, Locale locale,
            SpellCheckerSessionListener listener, boolean referToSpellCheckerLanguageSettings) {
        addTaint(referToSpellCheckerLanguageSettings);
        addTaint(listener.getTaint());
        addTaint(locale.getTaint());
        addTaint(bundle.getTaint());
        if(listener == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_292350791 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_292350791.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_292350791;
        } //End block
        if(!referToSpellCheckerLanguageSettings && locale == null)        
        {
            IllegalArgumentException var049408D924C2121FDC2D270D0D8FC1DD_1213028244 = new IllegalArgumentException("Locale should not be null if you don't refer"
                    + " settings.");
            var049408D924C2121FDC2D270D0D8FC1DD_1213028244.addTaint(taint);
            throw var049408D924C2121FDC2D270D0D8FC1DD_1213028244;
        } //End block
        if(referToSpellCheckerLanguageSettings && !isSpellCheckerEnabled())        
        {
SpellCheckerSession var540C13E9E156B687226421B24F2DF178_185297050 =             null;
            var540C13E9E156B687226421B24F2DF178_185297050.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_185297050;
        } //End block
        SpellCheckerInfo sci;
        try 
        {
            sci = sService.getCurrentSpellChecker(null);
        } //End block
        catch (RemoteException e)
        {
SpellCheckerSession var540C13E9E156B687226421B24F2DF178_1842391283 =             null;
            var540C13E9E156B687226421B24F2DF178_1842391283.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1842391283;
        } //End block
        if(sci == null)        
        {
SpellCheckerSession var540C13E9E156B687226421B24F2DF178_1515081657 =             null;
            var540C13E9E156B687226421B24F2DF178_1515081657.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1515081657;
        } //End block
        SpellCheckerSubtype subtypeInUse = null;
        if(referToSpellCheckerLanguageSettings)        
        {
            subtypeInUse = getCurrentSpellCheckerSubtype(true);
            if(subtypeInUse == null)            
            {
SpellCheckerSession var540C13E9E156B687226421B24F2DF178_755570733 =                 null;
                var540C13E9E156B687226421B24F2DF178_755570733.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_755570733;
            } //End block
            if(locale != null)            
            {
                final String subtypeLocale = subtypeInUse.getLocale();
                final String inputLocale = locale.toString();
                if(subtypeLocale.length() < 2 || inputLocale.length() < 2
                        || !subtypeLocale.substring(0, 2).equals(inputLocale.substring(0, 2)))                
                {
SpellCheckerSession var540C13E9E156B687226421B24F2DF178_964140559 =                     null;
                    var540C13E9E156B687226421B24F2DF178_964140559.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_964140559;
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
SpellCheckerSession var540C13E9E156B687226421B24F2DF178_1994027672 =             null;
            var540C13E9E156B687226421B24F2DF178_1994027672.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1994027672;
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
SpellCheckerSession var540C13E9E156B687226421B24F2DF178_1713609424 =             null;
            var540C13E9E156B687226421B24F2DF178_1713609424.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1713609424;
        } //End block
SpellCheckerSession varD555E544A66E0F97DA6BCDE940E3E79C_117142672 =         session;
        varD555E544A66E0F97DA6BCDE940E3E79C_117142672.addTaint(taint);
        return varD555E544A66E0F97DA6BCDE940E3E79C_117142672;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.061 -0400", hash_original_method = "996F778F72629C35F59A814BE7E587F6", hash_generated_method = "0EB0F489C390DD884772CFC9EE06C42F")
    public SpellCheckerInfo[] getEnabledSpellCheckers() {
        try 
        {
            final SpellCheckerInfo[] retval = sService.getEnabledSpellCheckers();
            if(DBG)            
            {
                Log.d(TAG, "getEnabledSpellCheckers: " + (retval != null ? retval.length : "null"));
            } //End block
SpellCheckerInfo[] varF9E19AD6135C970F387F77C6F3DE4477_540794592 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_540794592.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_540794592;
        } //End block
        catch (RemoteException e)
        {
SpellCheckerInfo[] var540C13E9E156B687226421B24F2DF178_300442277 =             null;
            var540C13E9E156B687226421B24F2DF178_300442277.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_300442277;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.061 -0400", hash_original_method = "A6F1D379519B22786C64C08B94869872", hash_generated_method = "E5066F5A42BD6DBCA53D4DDB0117E3F8")
    public SpellCheckerInfo getCurrentSpellChecker() {
        try 
        {
SpellCheckerInfo var93B4D1EE37EE09C8F6DDDDA2EED201C7_1771253842 =             sService.getCurrentSpellChecker(null);
            var93B4D1EE37EE09C8F6DDDDA2EED201C7_1771253842.addTaint(taint);
            return var93B4D1EE37EE09C8F6DDDDA2EED201C7_1771253842;
        } //End block
        catch (RemoteException e)
        {
SpellCheckerInfo var540C13E9E156B687226421B24F2DF178_1677938214 =             null;
            var540C13E9E156B687226421B24F2DF178_1677938214.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1677938214;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sService.getCurrentSpellChecker(null);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.062 -0400", hash_original_method = "4E93A8413D33E514F2933033BBA9E9C6", hash_generated_method = "970DB9487BC6138C866FE9091F891064")
    public void setCurrentSpellChecker(SpellCheckerInfo sci) {
        addTaint(sci.getTaint());
        try 
        {
            if(sci == null)            
            {
                NullPointerException varB03A091E07FFD936EAF226651CA4A244_1558253790 = new NullPointerException("SpellCheckerInfo is null.");
                varB03A091E07FFD936EAF226651CA4A244_1558253790.addTaint(taint);
                throw varB03A091E07FFD936EAF226651CA4A244_1558253790;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.062 -0400", hash_original_method = "A09B5B882B337AC1ACCDB12AE24B1D1D", hash_generated_method = "1B5062BF41ABAF859627860D66D0A240")
    public SpellCheckerSubtype getCurrentSpellCheckerSubtype(
            boolean allowImplicitlySelectedSubtype) {
        addTaint(allowImplicitlySelectedSubtype);
        try 
        {
SpellCheckerSubtype var7A3F944B0E30A3F8F4F1D67EE1CD7074_671097883 =             sService.getCurrentSpellCheckerSubtype(null, allowImplicitlySelectedSubtype);
            var7A3F944B0E30A3F8F4F1D67EE1CD7074_671097883.addTaint(taint);
            return var7A3F944B0E30A3F8F4F1D67EE1CD7074_671097883;
        } //End block
        catch (RemoteException e)
        {
SpellCheckerSubtype var540C13E9E156B687226421B24F2DF178_1308362668 =             null;
            var540C13E9E156B687226421B24F2DF178_1308362668.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1308362668;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sService.getCurrentSpellCheckerSubtype(null, allowImplicitlySelectedSubtype);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Error in getCurrentSpellCheckerSubtype: " + e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.063 -0400", hash_original_method = "CBCFCEE50800407BA5D76453EB5E1B5E", hash_generated_method = "F80836F3B5624BA7E6A4CB5D280EC08F")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.064 -0400", hash_original_method = "61F4D400D4BC8B241A007E9AEF488847", hash_generated_method = "EBC90A9FBC4A8A5F5D1EDF858B02229E")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.064 -0400", hash_original_method = "AE8BC5A0830A7B4F81FE6C44FCEBBBC8", hash_generated_method = "12F764FFC25AE61D56276085E4999F66")
    public boolean isSpellCheckerEnabled() {
        try 
        {
            boolean var7E195E4F1E9C259AB047738E613FAF8E_1791408148 = (sService.isSpellCheckerEnabled());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1881765226 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1881765226;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1838017621 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_335518687 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_335518687;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sService.isSpellCheckerEnabled();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Error in isSpellCheckerEnabled:" + e);
            //return false;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.064 -0400", hash_original_field = "B218BA2759A3CA676BC0CDFE35CD8348", hash_generated_field = "CA1CF66AA4296CAE6DA89B4A033D5D06")

    private static final String TAG = TextServicesManager.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.064 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.064 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "C8FA124301EED2431C4D22EB09223E94")

    private static TextServicesManager sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.064 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "BCB4F2C99AD5684E437C6C7FDD215756")

    private static ITextServicesManager sService;
}

