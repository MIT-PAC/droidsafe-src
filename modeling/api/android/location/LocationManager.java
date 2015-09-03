/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.location;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

import com.android.internal.location.DummyLocationProvider;

public class LocationManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.834 -0500", hash_original_field = "DF26FEF8A383C1946787FF952CFEED9D", hash_generated_field = "28DF91E101BF22ECD70A2547DFBB55A7")

    private static final String TAG = "LocationManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.847 -0500", hash_original_field = "E9E3E6509F690611BAB04C2B48C2BF3F", hash_generated_field = "6A1159950B5F0D81FE05A0592F2DB1B2")

    public static final String NETWORK_PROVIDER = "network";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.849 -0500", hash_original_field = "830810AA155AA08077531E27198650B7", hash_generated_field = "4C2280586138D33EB30E26156BDCB654")

    public static final String GPS_PROVIDER = "gps";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.852 -0500", hash_original_field = "CFFB699955B0E289BB904C512B98987E", hash_generated_field = "F221EEFFFB6FF66793F94043F74CBC0B")

    public static final String PASSIVE_PROVIDER = "passive";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.854 -0500", hash_original_field = "7D3E2184FD242B7AD0EBDA37E3E79752", hash_generated_field = "F9B4EC13158580C5DB06971A10A5663C")

    public static final String KEY_PROXIMITY_ENTERING = "entering";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.857 -0500", hash_original_field = "534AA1FE13DF143F59AA622E8957D8F9", hash_generated_field = "F215A34B782985F96320EA9F9AC24ECE")

    public static final String KEY_STATUS_CHANGED = "status";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.859 -0500", hash_original_field = "978BB6811AD76266F67017921B81EBD7", hash_generated_field = "E53B94E70159BE067785CDCFE51933F1")

    public static final String KEY_PROVIDER_ENABLED = "providerEnabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.867 -0500", hash_original_field = "5C6A7181EBCD64FFAEE6E14FCCA510A5", hash_generated_field = "B9A8BCBF7A8975A62A8159DDE6821E45")

    public static final String KEY_LOCATION_CHANGED = "location";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.877 -0500", hash_original_field = "BDFADDE76865400ADE642BA085E816D0", hash_generated_field = "4011D28AFA5049A3F8B84DAE600CE7B1")

    public static final String GPS_ENABLED_CHANGE_ACTION =
        "android.location.GPS_ENABLED_CHANGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.884 -0500", hash_original_field = "99DF12024B13B3B90D8318A4F7E7F3B5", hash_generated_field = "F1DA53484EFF7310FA2C5CCD96A5903D")

    public static final String PROVIDERS_CHANGED_ACTION =
        "android.location.PROVIDERS_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.888 -0500", hash_original_field = "0997827961C5D4AF8BB6A0DD37F3E9CD", hash_generated_field = "0ED670DE81E8FA835AC8A157321FBD93")

    public static final String GPS_FIX_CHANGE_ACTION =
        "android.location.GPS_FIX_CHANGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.004 -0500", hash_original_field = "D5C34EED892D00BBA8240ECA664A9AD5", hash_generated_field = "AAD29DA0DDBC5FD40952BC68A7746945")

    public static final String EXTRA_GPS_ENABLED = "enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.836 -0500", hash_original_field = "50ECBA7D5C5287025A532B86729D1152", hash_generated_field = "172E00EA90AE9807366F5CA34B42799B")

    private ILocationManager mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.839 -0500", hash_original_field = "2CA7B9E7B8F53306689F03BB8BF51558", hash_generated_field = "267657B565621B0ADE15AB65C02CB118")

    private final HashMap<GpsStatus.Listener, GpsStatusListenerTransport> mGpsStatusListeners =
            new HashMap<GpsStatus.Listener, GpsStatusListenerTransport>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.841 -0500", hash_original_field = "6A0C5C94A01F7CF446A047DBDCC551FD", hash_generated_field = "02F0F8A71DAB2C0D57E5F8A9755AD81D")

    private final HashMap<GpsStatus.NmeaListener, GpsStatusListenerTransport> mNmeaListeners =
            new HashMap<GpsStatus.NmeaListener, GpsStatusListenerTransport>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.844 -0500", hash_original_field = "44C7242EC18557732789C14ED8F52049", hash_generated_field = "67298A043ECF767C436304F77EB3BADE")

    private final GpsStatus mGpsStatus = new GpsStatus();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.007 -0500", hash_original_field = "7DFA59D955EC93DD9798DF126F843635", hash_generated_field = "806CFA905E48C4B7D75890759825B149")

    private HashMap<LocationListener,ListenerTransport> mListeners =
        new HashMap<LocationListener,ListenerTransport>();
    
	public LocationManager(ILocationManager service) {
        mService = service;
        addTaint(service.getTaint());
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    public LocationManager() {
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.056 -0500", hash_original_method = "F4540EAD4F3CF2106C64C62C1DCA569C", hash_generated_method = "AF63B91403D9DAD953364C5524516F0D")
    
private LocationProvider createProvider(String name, Bundle info) {
        DummyLocationProvider provider =
            new DummyLocationProvider(name, mService);
        provider.setRequiresNetwork(info.getBoolean("network"));
        provider.setRequiresSatellite(info.getBoolean("satellite"));
        provider.setRequiresCell(info.getBoolean("cell"));
        provider.setHasMonetaryCost(info.getBoolean("cost"));
        provider.setSupportsAltitude(info.getBoolean("altitude"));
        provider.setSupportsSpeed(info.getBoolean("speed"));
        provider.setSupportsBearing(info.getBoolean("bearing"));
        provider.setPowerRequirement(info.getInt("power"));
        provider.setAccuracy(info.getInt("accuracy"));
        return provider;
    }

    /**
     * Returns a list of the names of all known location providers.  All
     * providers are returned, including ones that are not permitted to be
     * accessed by the calling activity or are currently disabled.
     *
     * @return list of Strings containing names of the providers
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.LOCATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.058 -0500", hash_original_method = "4EC410201344BFF6367B3FC4DEB2ECDD", hash_generated_method = "743109C465594858F9765AFB2A2594A5")
    
public List<String> getAllProviders() {
        if (false) {
            Log.d(TAG, "getAllProviders");
        }
        try {
            return mService.getAllProviders();
        } catch (RemoteException ex) {
            Log.e(TAG, "getAllProviders: RemoteException", ex);
        }
        return null;
    }

    /**
     * Returns a list of the names of location providers.  Only providers that
     * are permitted to be accessed by the calling activity will be returned.
     *
     * @param enabledOnly if true then only the providers which are currently
     * enabled are returned.
     * @return list of Strings containing names of the providers
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.060 -0500", hash_original_method = "229C505A2DE7B350090013A910A6BB48", hash_generated_method = "6058E4EB9E5B3F4B8E8A47C61C812AB9")
    
public List<String> getProviders(boolean enabledOnly) {
        try {
            return mService.getProviders(null, enabledOnly);
        } catch (RemoteException ex) {
            Log.e(TAG, "getProviders: RemoteException", ex);
        }
        return null;
    }

    /**
     * Returns the information associated with the location provider of the
     * given name, or null if no provider exists by that name.
     *
     * @param name the provider name
     * @return a LocationProvider, or null
     *
     * @throws IllegalArgumentException if name is null
     * @throws SecurityException if the caller is not permitted to access the
     * given provider.
     */
    @DSSource({DSSourceKind.LOCATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.063 -0500", hash_original_method = "14AFABFCECA2A03E46C22CB46D5D2D56", hash_generated_method = "41A2E1B2987ECA2E0DAA7270E6282C9B")
    
public LocationProvider getProvider(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name==null");
        }
        try {
            Bundle info = mService.getProviderInfo(name);
            if (info == null) {
                return null;
            }
            return createProvider(name, info);
        } catch (RemoteException ex) {
            Log.e(TAG, "getProvider: RemoteException", ex);
        }
        return null;
    }

    /**
     * Returns a list of the names of LocationProviders that satisfy the given
     * criteria, or null if none do.  Only providers that are permitted to be
     * accessed by the calling activity will be returned.
     *
     * @param criteria the criteria that the returned providers must match
     * @param enabledOnly if true then only the providers which are currently
     * enabled are returned.
     * @return list of Strings containing names of the providers
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.065 -0500", hash_original_method = "03CC9524D6FEF78A1BD79E07965ADEF5", hash_generated_method = "DFE1C66868BC9C2BD5DC8900BED2442F")
    
public List<String> getProviders(Criteria criteria, boolean enabledOnly) {
        if (criteria == null) {
            throw new IllegalArgumentException("criteria==null");
        }
        try {
            return mService.getProviders(criteria, enabledOnly);
        } catch (RemoteException ex) {
            Log.e(TAG, "getProviders: RemoteException", ex);
        }
        return null;
    }

    /**
     * Returns the name of the provider that best meets the given criteria. Only providers
     * that are permitted to be accessed by the calling activity will be
     * returned.  If several providers meet the criteria, the one with the best
     * accuracy is returned.  If no provider meets the criteria,
     * the criteria are loosened in the following sequence:
     *
     * <ul>
     * <li> power requirement
     * <li> accuracy
     * <li> bearing
     * <li> speed
     * <li> altitude
     * </ul>
     *
     * <p> Note that the requirement on monetary cost is not removed
     * in this process.
     *
     * @param criteria the criteria that need to be matched
     * @param enabledOnly if true then only a provider that is currently enabled is returned
     * @return name of the provider that best matches the requirements
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.LOCATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.067 -0500", hash_original_method = "E63BBD2716EE0B4343F6D6F30C802349", hash_generated_method = "530A21AD4FE12EA44349E10E88F47DC1")
    
public String getBestProvider(Criteria criteria, boolean enabledOnly) {
        if (criteria == null) {
            throw new IllegalArgumentException("criteria==null");
        }
        try {
            return mService.getBestProvider(criteria, enabledOnly);
        } catch (RemoteException ex) {
            Log.e(TAG, "getBestProvider: RemoteException", ex);
        }
        return null;
    }

    /**
     * Registers the current activity to be notified periodically by
     * the named provider.  Periodically, the supplied LocationListener will
     * be called with the current Location or with status updates.
     *
     * <p> It may take a while to receive the most recent location. If
     * an immediate location is required, applications may use the
     * {@link #getLastKnownLocation(String)} method.
     *
     * <p> In case the provider is disabled by the user, updates will stop,
     * and the {@link LocationListener#onProviderDisabled(String)}
     * method will be called. As soon as the provider is enabled again,
     * the {@link LocationListener#onProviderEnabled(String)} method will
     * be called and location updates will start again.
     *
     * <p> The frequency of notification may be controlled using the
     * minTime and minDistance parameters. If minTime is greater than 0,
     * the LocationManager could potentially rest for minTime milliseconds
     * between location updates to conserve power. If minDistance is greater than 0,
     * a location will only be broadcasted if the device moves by minDistance meters.
     * To obtain notifications as frequently as possible, set both parameters to 0.
     *
     * <p> Background services should be careful about setting a sufficiently high
     * minTime so that the device doesn't consume too much power by keeping the
     * GPS or wireless radios on all the time. In particular, values under 60000ms
     * are not recommended.
     *
     * <p> The calling thread must be a {@link android.os.Looper} thread such as
     * the main thread of the calling Activity.
     *
     * @param provider the name of the provider with which to register
     * @param minTime the minimum time interval for notifications, in
     * milliseconds. This field is only used as a hint to conserve power, and actual
     * time between location updates may be greater or lesser than this value.
     * @param minDistance the minimum distance interval for notifications,
     * in meters
     * @param listener a {#link LocationListener} whose
     * {@link LocationListener#onLocationChanged} method will be called for
     * each location update
     *
     * @throws IllegalArgumentException if provider or listener is null
     * @throws RuntimeException if the calling thread has no Looper
     * @throws SecurityException if no suitable permission is present for the provider.
     */
    @DSVerified
    @DSSpec(DSCat.LOCATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.070 -0500", hash_original_method = "79B0FCFC5B63DF5D944678DA62AFE363", hash_generated_method = "3B5D5B85B1DA5C9AC21655D8FDFF0796")
public void requestLocationUpdates(String provider,
        long minTime, float minDistance, LocationListener listener) {
        if (provider == null) {
            throw new IllegalArgumentException("provider==null");
        }
        if (listener == null) {
            throw new IllegalArgumentException("listener==null");
        }
        _requestLocationUpdates(provider, null, minTime, minDistance, false, listener, null);
    }

    /**
     * Registers the current activity to be notified periodically by
     * the named provider.  Periodically, the supplied LocationListener will
     * be called with the current Location or with status updates.
     *
     * <p> It may take a while to receive the most recent location. If
     * an immediate location is required, applications may use the
     * {@link #getLastKnownLocation(String)} method.
     *
     * <p> In case the provider is disabled by the user, updates will stop,
     * and the {@link LocationListener#onProviderDisabled(String)}
     * method will be called. As soon as the provider is enabled again,
     * the {@link LocationListener#onProviderEnabled(String)} method will
     * be called and location updates will start again.
     *
     * <p> The frequency of notification may be controlled using the
     * minTime and minDistance parameters. If minTime is greater than 0,
     * the LocationManager could potentially rest for minTime milliseconds
     * between location updates to conserve power. If minDistance is greater than 0,
     * a location will only be broadcasted if the device moves by minDistance meters.
     * To obtain notifications as frequently as possible, set both parameters to 0.
     *
     * <p> Background services should be careful about setting a sufficiently high
     * minTime so that the device doesn't consume too much power by keeping the
     * GPS or wireless radios on all the time. In particular, values under 60000ms
     * are not recommended.
     *
     * <p> The supplied Looper is used to implement the callback mechanism.
     *
     * @param provider the name of the provider with which to register
     * @param minTime the minimum time interval for notifications, in
     * milliseconds. This field is only used as a hint to conserve power, and actual
     * time between location updates may be greater or lesser than this value.
     * @param minDistance the minimum distance interval for notifications,
     * in meters
     * @param listener a {#link LocationListener} whose
     * {@link LocationListener#onLocationChanged} method will be called for
     * each location update
     * @param looper a Looper object whose message queue will be used to
     * implement the callback mechanism.
     * If looper is null then the callbacks will be called on the main thread.
     *
     * @throws IllegalArgumentException if provider is null or doesn't exist
     * @throws IllegalArgumentException if listener is null
     * @throws SecurityException if no suitable permission is present for the provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.073 -0500", hash_original_method = "FA80C6D3E17A94A62F4AA64272188CF2", hash_generated_method = "12D34FA1BBDE41B64F00C5F19CC29CCA")
    @DSVerified
    @DSSpec(DSCat.LOCATION) 
public void requestLocationUpdates(String provider,
        long minTime, float minDistance, LocationListener listener,
        Looper looper) {
        if (provider == null) {
            throw new IllegalArgumentException("provider==null");
        }
        if (listener == null) {
            throw new IllegalArgumentException("listener==null");
        }
        _requestLocationUpdates(provider, null, minTime, minDistance, false, listener, looper);
    }

    /**
     * Registers the current activity to be notified periodically based on
     * the specified criteria.  Periodically, the supplied LocationListener will
     * be called with the current Location or with status updates.
     *
     * <p> It may take a while to receive the most recent location. If
     * an immediate location is required, applications may use the
     * {@link #getLastKnownLocation(String)} method.
     *
     * <p> In case the provider is disabled by the user, updates will stop,
     * and the {@link LocationListener#onProviderDisabled(String)}
     * method will be called. As soon as the provider is enabled again,
     * the {@link LocationListener#onProviderEnabled(String)} method will
     * be called and location updates will start again.
     *
     * <p> The frequency of notification may be controlled using the
     * minTime and minDistance parameters. If minTime is greater than 0,
     * the LocationManager could potentially rest for minTime milliseconds
     * between location updates to conserve power. If minDistance is greater than 0,
     * a location will only be broadcasted if the device moves by minDistance meters.
     * To obtain notifications as frequently as possible, set both parameters to 0.
     *
     * <p> Background services should be careful about setting a sufficiently high
     * minTime so that the device doesn't consume too much power by keeping the
     * GPS or wireless radios on all the time. In particular, values under 60000ms
     * are not recommended.
     *
     * <p> The supplied Looper is used to implement the callback mechanism.
     *
     * @param minTime the minimum time interval for notifications, in
     * milliseconds. This field is only used as a hint to conserve power, and actual
     * time between location updates may be greater or lesser than this value.
     * @param minDistance the minimum distance interval for notifications,
     * in meters
     * @param criteria contains parameters for the location manager to choose the
     * appropriate provider and parameters to compute the location
     * @param listener a {#link LocationListener} whose
     * {@link LocationListener#onLocationChanged} method will be called for
     * each location update
     * @param looper a Looper object whose message queue will be used to
     * implement the callback mechanism.
     * If looper is null then the callbacks will be called on the main thread.
     *
     * @throws IllegalArgumentException if criteria is null
     * @throws IllegalArgumentException if listener is null
     * @throws SecurityException if no suitable permission is present to access
     * the location services.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.076 -0500", hash_original_method = "2A4D2871A80639591D176F262A5FC273", hash_generated_method = "58EE3CFBEF2B1652895394E2CF341A32")
    @DSVerified
    @DSSpec(DSCat.LOCATION)
public void requestLocationUpdates(long minTime, float minDistance,
            Criteria criteria, LocationListener listener, Looper looper) {
        if (criteria == null) {
            throw new IllegalArgumentException("criteria==null");
        }
        if (listener == null) {
            throw new IllegalArgumentException("listener==null");
        }
        _requestLocationUpdates(null, criteria, minTime, minDistance, false, listener, looper);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSVerified
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.987 -0400", hash_original_method = "7527D3AF7E08617A40988967AFB4FC4D", hash_generated_method = "324B2DB34138E35B89555069BC343BA8")
    private void _requestLocationUpdates(String provider, Criteria criteria, long minTime,
            float minDistance, boolean singleShot, LocationListener listener, Looper looper) {
        addTaint(looper.getTaint());
        addTaint(listener.getTaint());
        addTaint(singleShot);
        addTaint(minDistance);
        addTaint(minTime);
        addTaint(criteria.getTaint());
        addTaint(provider.getTaint());
        
        //call listeners directory for DroidSafe
        listener.onLocationChanged(new Location(provider));
        Bundle bundle = new Bundle();
        listener.onStatusChanged(provider, 0, bundle);
        listener.onProviderEnabled(provider);
        listener.onProviderDisabled(provider);
        listener.onStatusChanged(provider, DSUtils.FAKE_INT, bundle);
        
        if(minTime < 0L)        
        {
            minTime = 0L;
        } //End block
        if(minDistance < 0.0f)        
        {
            minDistance = 0.0f;
        } //End block
        try 
        {
            synchronized
(mListeners)            {
                ListenerTransport transport = mListeners.get(listener);
                if(transport == null)                
                {
                    transport = new ListenerTransport(listener, looper);
                } //End block
                mListeners.put(listener, transport);
                mService.requestLocationUpdates(provider, criteria, minTime, minDistance, singleShot, transport);
            } //End block
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //if (minTime < 0L) {
            //minTime = 0L;
        //}
        //if (minDistance < 0.0f) {
            //minDistance = 0.0f;
        //}
        //try {
            //synchronized (mListeners) {
                //ListenerTransport transport = mListeners.get(listener);
                //if (transport == null) {
                    //transport = new ListenerTransport(listener, looper);
                //}
                //mListeners.put(listener, transport);
                //mService.requestLocationUpdates(provider, criteria, minTime, minDistance, singleShot, transport);
            //}
        //} catch (RemoteException ex) {
            //Log.e(TAG, "requestLocationUpdates: DeadObjectException", ex);
        //}
    }

    /**
     * Registers the current activity to be notified periodically by
     * the named provider.  Periodically, the supplied PendingIntent will
     * be broadcast with the current Location or with status updates.
     *
     * <p> Location updates are sent with a key of KEY_LOCATION_CHANGED and a Location value.
     *
     * <p> It may take a while to receive the most recent location. If
     * an immediate location is required, applications may use the
     * {@link #getLastKnownLocation(String)} method.
     *
     * <p> The frequency of notification or new locations may be controlled using the
     * minTime and minDistance parameters. If minTime is greater than 0,
     * the LocationManager could potentially rest for minTime milliseconds
     * between location updates to conserve power. If minDistance is greater than 0,
     * a location will only be broadcast if the device moves by minDistance meters.
     * To obtain notifications as frequently as possible, set both parameters to 0.
     *
     * <p> Background services should be careful about setting a sufficiently high
     * minTime so that the device doesn't consume too much power by keeping the
     * GPS or wireless radios on all the time. In particular, values under 60000ms
     * are not recommended.
     *
     * <p> In case the provider is disabled by the user, updates will stop,
     * and an intent will be sent with an extra with key KEY_PROVIDER_ENABLED and a boolean value
     * of false.  If the provider is re-enabled, an intent will be sent with an
     * extra with key KEY_PROVIDER_ENABLED and a boolean value of true and location updates will
     * start again.
     *
     * <p> If the provider's status changes, an intent will be sent with an extra with key
     * KEY_STATUS_CHANGED and an integer value indicating the new status.  Any extras associated
     * with the status update will be sent as well.
     *
     * @param provider the name of the provider with which to register
     * @param minTime the minimum time interval for notifications, in
     * milliseconds. This field is only used as a hint to conserve power, and actual
     * time between location updates may be greater or lesser than this value.
     * @param minDistance the minimum distance interval for notifications,
     * in meters
     * @param intent a {#link PendingIntent} to be sent for each location update
     *
     * @throws IllegalArgumentException if provider is null or doesn't exist
     * @throws IllegalArgumentException if intent is null
     * @throws SecurityException if no suitable permission is present for the provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.082 -0500", hash_original_method = "C7C08F02B5B72D29F482122DD6AFB995", hash_generated_method = "D34B2C0838AED3DA24476E75E96D0446")
    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
  
public void requestLocationUpdates(String provider,
            long minTime, float minDistance, PendingIntent intent) {
        if (provider == null) {
            throw new IllegalArgumentException("provider==null");
        }
        if (intent == null) {
            throw new IllegalArgumentException("intent==null");
        }
        _requestLocationUpdates(provider, null, minTime, minDistance, false, intent);
    }

    /**
     * Registers the current activity to be notified periodically based on
     * the specified criteria.  Periodically, the supplied PendingIntent will
     * be broadcast with the current Location or with status updates.
     *
     * <p> Location updates are sent with a key of KEY_LOCATION_CHANGED and a Location value.
     *
     * <p> It may take a while to receive the most recent location. If
     * an immediate location is required, applications may use the
     * {@link #getLastKnownLocation(String)} method.
     *
     * <p> The frequency of notification or new locations may be controlled using the
     * minTime and minDistance parameters. If minTime is greater than 0,
     * the LocationManager could potentially rest for minTime milliseconds
     * between location updates to conserve power. If minDistance is greater than 0,
     * a location will only be broadcast if the device moves by minDistance meters.
     * To obtain notifications as frequently as possible, set both parameters to 0.
     *
     * <p> Background services should be careful about setting a sufficiently high
     * minTime so that the device doesn't consume too much power by keeping the
     * GPS or wireless radios on all the time. In particular, values under 60000ms
     * are not recommended.
     *
     * <p> In case the provider is disabled by the user, updates will stop,
     * and an intent will be sent with an extra with key KEY_PROVIDER_ENABLED and a boolean value
     * of false.  If the provider is re-enabled, an intent will be sent with an
     * extra with key KEY_PROVIDER_ENABLED and a boolean value of true and location updates will
     * start again.
     *
     * <p> If the provider's status changes, an intent will be sent with an extra with key
     * KEY_STATUS_CHANGED and an integer value indicating the new status.  Any extras associated
     * with the status update will be sent as well.
     *
     * @param minTime the minimum time interval for notifications, in
     * milliseconds. This field is only used as a hint to conserve power, and actual
     * time between location updates may be greater or lesser than this value.
     * @param minDistance the minimum distance interval for notifications,
     * in meters
     * @param criteria contains parameters for the location manager to choose the
     * appropriate provider and parameters to compute the location
     * @param intent a {#link PendingIntent} to be sent for each location update
     *
     * @throws IllegalArgumentException if provider is null or doesn't exist
     * @throws IllegalArgumentException if intent is null
     * @throws SecurityException if no suitable permission is present for the provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.084 -0500", hash_original_method = "2F287C6E75A45C2A01B3C0BCBDE67B57", hash_generated_method = "F50E6C6FB45DB283BED88871736379AA")
    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)

public void requestLocationUpdates(long minTime, float minDistance, Criteria criteria, PendingIntent intent) {
        if (criteria == null) {
            throw new IllegalArgumentException("criteria==null");
        }
        if (intent == null) {
            throw new IllegalArgumentException("intent==null");
        }
        _requestLocationUpdates(null, criteria, minTime, minDistance, false, intent);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.087 -0500", hash_original_method = "21FA37E7FC7084DE02389BC0809F92F8", hash_generated_method = "82C90F76864A3A3F2CD1CB8F0F42A0CB")
    @DSVerified

private void _requestLocationUpdates(String provider, Criteria criteria,
            long minTime, float minDistance, boolean singleShot, PendingIntent intent) {
        if (minTime < 0L) {
            minTime = 0L;
        }
        if (minDistance < 0.0f) {
            minDistance = 0.0f;
        }

        try {
            mService.requestLocationUpdatesPI(provider, criteria, minTime, minDistance, singleShot, intent);
        } catch (RemoteException ex) {
            Log.e(TAG, "requestLocationUpdates: RemoteException", ex);
        }
    }

    /**
     * Requests a single location update from the named provider.
     *
     * <p> It may take a while to receive the most recent location. If
     * an immediate location is required, applications may use the
     * {@link #getLastKnownLocation(String)} method.
     *
     * <p> In case the provider is disabled by the user, the update will not be received,
     * and the {@link LocationListener#onProviderDisabled(String)}
     * method will be called. As soon as the provider is enabled again,
     * the {@link LocationListener#onProviderEnabled(String)} method will
     * be called and location updates will start again.
     *
     * <p> The supplied Looper is used to implement the callback mechanism.
     *
     * @param provider the name of the provider with which to register
     * @param listener a {#link LocationListener} whose
     * {@link LocationListener#onLocationChanged} method will be called when
     * the location update is available
     * @param looper a Looper object whose message queue will be used to
     * implement the callback mechanism.
     * If looper is null then the callbacks will be called on the main thread.
     *
     * @throws IllegalArgumentException if provider is null or doesn't exist
     * @throws IllegalArgumentException if listener is null
     * @throws SecurityException if no suitable permission is present for the provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.089 -0500", hash_original_method = "E82A66C4B675428C8689D564FEFE46C0", hash_generated_method = "46845E4FCC97AC801B52F850B754D27D")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)
public void requestSingleUpdate(String provider, LocationListener listener, Looper looper) {
        if (provider == null) {
            throw new IllegalArgumentException("provider==null");
        }
        if (listener == null) {
            throw new IllegalArgumentException("listener==null");
        }
        _requestLocationUpdates(provider, null, 0L, 0.0f, true, listener, looper);
    }

    /**
     * Requests a single location update based on the specified criteria.
     *
     * <p> It may take a while to receive the most recent location. If
     * an immediate location is required, applications may use the
     * {@link #getLastKnownLocation(String)} method.
     *
     * <p> In case the provider is disabled by the user, the update will not be received,
     * and the {@link LocationListener#onProviderDisabled(String)}
     * method will be called. As soon as the provider is enabled again,
     * the {@link LocationListener#onProviderEnabled(String)} method will
     * be called and location updates will start again.
     *
     * <p> The supplied Looper is used to implement the callback mechanism.
     *
     * @param criteria contains parameters for the location manager to choose the
     * appropriate provider and parameters to compute the location
     * @param listener a {#link LocationListener} whose
     * {@link LocationListener#onLocationChanged} method will be called when
     * the location update is available
     * @param looper a Looper object whose message queue will be used to
     * implement the callback mechanism.
     * If looper is null then the callbacks will be called on the current thread.
     *
     * @throws IllegalArgumentException if criteria is null
     * @throws IllegalArgumentException if listener is null
     * @throws SecurityException if no suitable permission is present to access
     * the location services.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.091 -0500", hash_original_method = "A942F553EBD5189FF7258B50664EDDE9", hash_generated_method = "69FAFB98917A14410C1D1293E7AE145D")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void requestSingleUpdate(Criteria criteria, LocationListener listener, Looper looper) {
        if (criteria == null) {
            throw new IllegalArgumentException("criteria==null");
        }
        if (listener == null) {
            throw new IllegalArgumentException("listener==null");
        }
        _requestLocationUpdates(null, criteria, 0L, 0.0f, true, listener, looper);
    }

    /**
     * Requests a single location update from the named provider.
     *
     * <p> It may take a while to receive the most recent location. If
     * an immediate location is required, applications may use the
     * {@link #getLastKnownLocation(String)} method.
     *
     * <p> Location updates are sent with a key of KEY_LOCATION_CHANGED and a Location value.
     *
     * <p> In case the provider is disabled by the user, the update will not be received,
     * and the {@link LocationListener#onProviderDisabled(String)}
     * method will be called. As soon as the provider is enabled again,
     * the {@link LocationListener#onProviderEnabled(String)} method will
     * be called and location updates will start again.
     *
     * @param provider the name of the provider with which to register
     * @param intent a {#link PendingIntent} to be sent for the location update
     *
     * @throws IllegalArgumentException if provider is null or doesn't exist
     * @throws IllegalArgumentException if intent is null
     * @throws SecurityException if no suitable permission is present for the provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.094 -0500", hash_original_method = "71C843DE562F708F58659EAA42FBA5B9", hash_generated_method = "2C25A6C1BEA7153C6815F252406EEAB5")
    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
public void requestSingleUpdate(String provider, PendingIntent intent) {
        if (provider == null) {
            throw new IllegalArgumentException("provider==null");
        }
        if (intent == null) {
            throw new IllegalArgumentException("intent==null");
        }
        _requestLocationUpdates(provider, null, 0L, 0.0f, true, intent);
    }

    /**
     * Requests a single location update based on the specified criteria.
     *
     * <p> It may take a while to receive the most recent location. If
     * an immediate location is required, applications may use the
     * {@link #getLastKnownLocation(String)} method.
     *
     * <p> Location updates are sent with a key of KEY_LOCATION_CHANGED and a Location value.
     *
     * <p> In case the provider is disabled by the user, the update will not be received,
     * and the {@link LocationListener#onProviderDisabled(String)}
     * method will be called. As soon as the provider is enabled again,
     * the {@link LocationListener#onProviderEnabled(String)} method will
     * be called and location updates will start again.
     *
     * @param criteria contains parameters for the location manager to choose the
     * appropriate provider and parameters to compute the location
     * @param intent a {#link PendingIntent} to be sent for the location update
     *
     * @throws IllegalArgumentException if provider is null or doesn't exist
     * @throws IllegalArgumentException if intent is null
     * @throws SecurityException if no suitable permission is present for the provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.096 -0500", hash_original_method = "6685F769C73037425B092AE6FD387007", hash_generated_method = "74C27A4C34550DD6DA1B1E79292C7573")
    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
public void requestSingleUpdate(Criteria criteria, PendingIntent intent) {
        if (criteria == null) {
            throw new IllegalArgumentException("criteria==null");
        }
        if (intent == null) {
            throw new IllegalArgumentException("intent==null");
        }
        _requestLocationUpdates(null, criteria, 0L, 0.0f, true, intent);
    }

    /**
     * Removes any current registration for location updates of the current activity
     * with the given LocationListener.  Following this call, updates will no longer
     * occur for this listener.
     *
     * @param listener {#link LocationListener} object that no longer needs location updates
     * @throws IllegalArgumentException if listener is null
     */
    @DSComment("no action when removing callback")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.099 -0500", hash_original_method = "C6393138E31F9EAAF3B1058E5B49E67E", hash_generated_method = "5CC997F28F688299E6A370A6AB8EBED4")
    
public void removeUpdates(LocationListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener==null");
        }
        if (false) {
            Log.d(TAG, "removeUpdates: listener = " + listener);
        }
        try {
            ListenerTransport transport = mListeners.remove(listener);
            if (transport != null) {
                mService.removeUpdates(transport);
            }
        } catch (RemoteException ex) {
            Log.e(TAG, "removeUpdates: DeadObjectException", ex);
        }
    }

    /**
     * Removes any current registration for location updates of the current activity
     * with the given PendingIntent.  Following this call, updates will no longer
     * occur for this intent.
     *
     * @param intent {#link PendingIntent} object that no longer needs location updates
     * @throws IllegalArgumentException if intent is null
     */
    @DSComment("Location manager")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.101 -0500", hash_original_method = "53855AAE83CDCFDE219D3895B886D007", hash_generated_method = "11D02D5FFF7DF18BC5C2C49EC31ACDE3")
    
public void removeUpdates(PendingIntent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("intent==null");
        }
        if (false) {
            Log.d(TAG, "removeUpdates: intent = " + intent);
        }
        try {
            mService.removeUpdatesPI(intent);
        } catch (RemoteException ex) {
            Log.e(TAG, "removeUpdates: RemoteException", ex);
        }
    }

    /**
     * Sets a proximity alert for the location given by the position
     * (latitude, longitude) and the given radius.  When the device
     * detects that it has entered or exited the area surrounding the
     * location, the given PendingIntent will be used to create an Intent
     * to be fired.
     *
     * <p> The fired Intent will have a boolean extra added with key
     * {@link #KEY_PROXIMITY_ENTERING}. If the value is true, the device is
     * entering the proximity region; if false, it is exiting.
     *
     * <p> Due to the approximate nature of position estimation, if the
     * device passes through the given area briefly, it is possible
     * that no Intent will be fired.  Similarly, an Intent could be
     * fired if the device passes very close to the given area but
     * does not actually enter it.
     *
     * <p> After the number of milliseconds given by the expiration
     * parameter, the location manager will delete this proximity
     * alert and no longer monitor it.  A value of -1 indicates that
     * there should be no expiration time.
     *
     * <p> In case the screen goes to sleep, checks for proximity alerts
     * happen only once every 4 minutes. This conserves battery life by
     * ensuring that the device isn't perpetually awake.
     *
     * <p> Internally, this method uses both {@link #NETWORK_PROVIDER}
     * and {@link #GPS_PROVIDER}.
     *
     * @param latitude the latitude of the central point of the
     * alert region
     * @param longitude the longitude of the central point of the
     * alert region
     * @param radius the radius of the central point of the
     * alert region, in meters
     * @param expiration time for this proximity alert, in milliseconds,
     * or -1 to indicate no expiration
     * @param intent a PendingIntent that will be used to generate an Intent to
     * fire when entry to or exit from the alert region is detected
     *
     * @throws SecurityException if no permission exists for the required
     * providers.
     */
    @DSComment("Location manager")
    @DSSpec(DSCat.LOCATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.104 -0500", hash_original_method = "8F5138780FDD6FE26D92FDF1DF02DE4E", hash_generated_method = "4AB5041FA070929F9F6E7D36DF839ECA")
    
public void addProximityAlert(double latitude, double longitude,
        float radius, long expiration, PendingIntent intent) {
        if (false) {
            Log.d(TAG, "addProximityAlert: latitude = " + latitude +
                ", longitude = " + longitude + ", radius = " + radius +
                ", expiration = " + expiration +
                ", intent = " + intent);
        }
        try {
            mService.addProximityAlert(latitude, longitude, radius,
                                       expiration, intent);
        } catch (RemoteException ex) {
            Log.e(TAG, "addProximityAlert: RemoteException", ex);
        }
    }

    /**
     * Removes the proximity alert with the given PendingIntent.
     *
     * @param intent the PendingIntent that no longer needs to be notified of
     * proximity alerts
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.106 -0500", hash_original_method = "4A48D6353D1407BC4C3112124D5D3B7A", hash_generated_method = "1DC0478D6B785A0F039D6351F5291594")
    
public void removeProximityAlert(PendingIntent intent) {
        if (false) {
            Log.d(TAG, "removeProximityAlert: intent = " + intent);
        }
        try {
            mService.removeProximityAlert(intent);
        } catch (RemoteException ex) {
            Log.e(TAG, "removeProximityAlert: RemoteException", ex);
        }
    }

    /**
     * Returns the current enabled/disabled status of the given provider. If the
     * user has enabled this provider in the Settings menu, true is returned
     * otherwise false is returned
     *
     * @param provider the name of the provider
     * @return true if the provider is enabled
     *
     * @throws SecurityException if no suitable permission is present for the provider.
     * @throws IllegalArgumentException if provider is null
     */
    @DSComment("Location manager")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.108 -0500", hash_original_method = "A73A17F882D5C0CB78BFCF12E6BF5D56", hash_generated_method = "661252561785095187961056FE5269CA")
    
public boolean isProviderEnabled(String provider) {
        if (provider == null) {
            throw new IllegalArgumentException("provider==null");
        }
        try {
            return mService.isProviderEnabled(provider);
        } catch (RemoteException ex) {
            Log.e(TAG, "isProviderEnabled: RemoteException", ex);
            return false;
        }
    }
    
    @DSComment("Location/GPS access")
    @DSSpec(DSCat.LOCATION)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.993 -0400", hash_original_method = "C11453A15D8C96574C829BE27A4B0DFD", hash_generated_method = "7B70CBDE081B95E75A69268514229255")
    
    public Location getLastKnownLocation(String provider) {
        addTaint(provider.getTaint());
        if(provider == null)        
        {
            IllegalArgumentException var3740E938BA9AB726EFDC662393650C35_408376459 = new IllegalArgumentException("provider==null");
            var3740E938BA9AB726EFDC662393650C35_408376459.addTaint(getTaint());
            throw var3740E938BA9AB726EFDC662393650C35_408376459;
        } //End block
        try 
        {
Location var94D744E5CB62D5F61288405519195D94_1241647484 =             mService.getLastKnownLocation(provider);
            var94D744E5CB62D5F61288405519195D94_1241647484.addTaint(getTaint());
            
        } //End block
        catch (RemoteException ex)
        {
Location var540C13E9E156B687226421B24F2DF178_1859180586 =             null;
            var540C13E9E156B687226421B24F2DF178_1859180586.addTaint(getTaint());
          
        } //End block
        // ---------- Original Method ----------
        //if (provider == null) {
            //throw new IllegalArgumentException("provider==null");
        //}
        //try {
            //return mService.getLastKnownLocation(provider);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getLastKnowLocation: RemoteException", ex);
            //return null;
        //}
        return new Location("GPS");
    }

    // Mock provider support

    /**
     * Creates a mock location provider and adds it to the set of active providers.
     *
     * @param name the provider name
     * @param requiresNetwork
     * @param requiresSatellite
     * @param requiresCell
     * @param hasMonetaryCost
     * @param supportsAltitude
     * @param supportsSpeed
     * @param supportsBearing
     * @param powerRequirement
     * @param accuracy
     *
     * @throws SecurityException if the ACCESS_MOCK_LOCATION permission is not present
     * or the {@link android.provider.Settings.Secure#ALLOW_MOCK_LOCATION
     * Settings.Secure.ALLOW_MOCK_LOCATION} system setting is not enabled
     * @throws IllegalArgumentException if a provider with the given name already exists
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.113 -0500", hash_original_method = "03E8D8A5CD41A64BA401E8781419DF72", hash_generated_method = "6CC128497949A8153554189397035F64")
    
public void addTestProvider(String name, boolean requiresNetwork, boolean requiresSatellite,
        boolean requiresCell, boolean hasMonetaryCost, boolean supportsAltitude,
        boolean supportsSpeed, boolean supportsBearing, int powerRequirement, int accuracy) {
        try {
            mService.addTestProvider(name, requiresNetwork, requiresSatellite, requiresCell,
                hasMonetaryCost, supportsAltitude, supportsSpeed, supportsBearing, powerRequirement,
                accuracy);
        } catch (RemoteException ex) {
            Log.e(TAG, "addTestProvider: RemoteException", ex);
        }
    }

    /**
     * Removes the mock location provider with the given name.
     *
     * @param provider the provider name
     *
     * @throws SecurityException if the ACCESS_MOCK_LOCATION permission is not present
     * or the {@link android.provider.Settings.Secure#ALLOW_MOCK_LOCATION
     * Settings.Secure.ALLOW_MOCK_LOCATION}} system setting is not enabled
     * @throws IllegalArgumentException if no provider with the given name exists
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.115 -0500", hash_original_method = "498EE4F1DD4EF06996FBFECAF808CC3B", hash_generated_method = "260CE70CD7D8F6A1B616079D1F1D9679")
    
public void removeTestProvider(String provider) {
        try {
            mService.removeTestProvider(provider);
        } catch (RemoteException ex) {
            Log.e(TAG, "removeTestProvider: RemoteException", ex);
        }
    }

    /**
     * Sets a mock location for the given provider.  This location will be used in place
     * of any actual location from the provider.
     *
     * @param provider the provider name
     * @param loc the mock location
     *
     * @throws SecurityException if the ACCESS_MOCK_LOCATION permission is not present
     * or the {@link android.provider.Settings.Secure#ALLOW_MOCK_LOCATION
     * Settings.Secure.ALLOW_MOCK_LOCATION}} system setting is not enabled
     * @throws IllegalArgumentException if no provider with the given name exists
     */
    @DSSink({DSSinkKind.LOCATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.118 -0500", hash_original_method = "68207A112A1E7BBE4826B19769FC12DA", hash_generated_method = "8B9988E8B7E36011874EE986E1CAF008")
    
public void setTestProviderLocation(String provider, Location loc) {
        try {
            mService.setTestProviderLocation(provider, loc);
        } catch (RemoteException ex) {
            Log.e(TAG, "setTestProviderLocation: RemoteException", ex);
        }
    }
    
    private class ListenerTransport extends ILocationListener.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.010 -0500", hash_original_field = "B9954826DAE6059EFB21B76D230B305A", hash_generated_field = "A0CA98E69FE18B704F4EDD23AF7F79E8")

        private static final int TYPE_LOCATION_CHANGED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.014 -0500", hash_original_field = "D3BA48011EDF418081BC3A63B82D9F54", hash_generated_field = "8D044298B4BF37557EF84C728C50DFD4")

        private static final int TYPE_STATUS_CHANGED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.016 -0500", hash_original_field = "5A0B5994BABAC6ABE5ADD67E09CF46E6", hash_generated_field = "5E93656B2A797E677A4A922D41C08F3D")

        private static final int TYPE_PROVIDER_ENABLED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.019 -0500", hash_original_field = "3D2E83B23F4F13CB8A61824CA7528EB3", hash_generated_field = "8BABDDB91091B99E5C494EDC7D408D8A")

        private static final int TYPE_PROVIDER_DISABLED = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.021 -0500", hash_original_field = "91E7866574DA78512A2B735B0BDCAD22", hash_generated_field = "88C676C20BB164A41FD7C10E7FA78223")

        private LocationListener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.024 -0500", hash_original_field = "D0A3D82F2B280A159C01C94C498A5E27", hash_generated_field = "4100173B517AAB1135352B9F9C7AE096")

        private  Handler mListenerHandler;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.034 -0500", hash_original_method = "5AF1CAA1D5EED50BE6CA5764BFEB7286", hash_generated_method = "5AF1CAA1D5EED50BE6CA5764BFEB7286")
        
ListenerTransport(LocationListener listener, Looper looper) {
            mListener = listener;

            if (looper == null) {
                mListenerHandler = new Handler() {
                    @DSSafe(DSCat.SAFE_LIST)
            @Override
                    public void handleMessage(Message msg) {
                        _handleMessage(msg);
                    }
                };
            } else {
                mListenerHandler = new Handler(looper) {
                    @DSSafe(DSCat.SAFE_LIST)
            @Override
                    public void handleMessage(Message msg) {
                        _handleMessage(msg);
                    }
                };
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.036 -0500", hash_original_method = "A17E439126795FFA0E8C33868ED647C4", hash_generated_method = "6E31EDA428C9062FC919A90A6B049F63")
        
public void onLocationChanged(Location location) {
            Message msg = Message.obtain();
            msg.what = TYPE_LOCATION_CHANGED;
            msg.obj = location;
            mListenerHandler.sendMessage(msg);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.039 -0500", hash_original_method = "BF8F7C90ADE4983F5319C798EB4A7E9F", hash_generated_method = "614CF865311C07C4A42AF3688A761A20")
        
public void onStatusChanged(String provider, int status, Bundle extras) {
            Message msg = Message.obtain();
            msg.what = TYPE_STATUS_CHANGED;
            Bundle b = new Bundle();
            b.putString("provider", provider);
            b.putInt("status", status);
            if (extras != null) {
                b.putBundle("extras", extras);
            }
            msg.obj = b;
            mListenerHandler.sendMessage(msg);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.041 -0500", hash_original_method = "812D643BCDC2A4502FF3E1F391BA3BAF", hash_generated_method = "93DFCD33C5E3369B356251FEA7B4727E")
        
public void onProviderEnabled(String provider) {
            Message msg = Message.obtain();
            msg.what = TYPE_PROVIDER_ENABLED;
            msg.obj = provider;
            mListenerHandler.sendMessage(msg);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.045 -0500", hash_original_method = "E15FA24A6514F29CC56145BCCEFEF320", hash_generated_method = "7A7443D7D6FA6AF0E9AE3EBCA823B090")
        
public void onProviderDisabled(String provider) {
            Message msg = Message.obtain();
            msg.what = TYPE_PROVIDER_DISABLED;
            msg.obj = provider;
            mListenerHandler.sendMessage(msg);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.048 -0500", hash_original_method = "B4AFFA03A7F956D43DB0E44DEB20B60F", hash_generated_method = "72A9A909ED136A7F8F527EB71608569F")
        
private void _handleMessage(Message msg) {
            switch (msg.what) {
                case TYPE_LOCATION_CHANGED:
                    Location location = new Location((Location) msg.obj);
                    mListener.onLocationChanged(location);
                    break;
                case TYPE_STATUS_CHANGED:
                    Bundle b = (Bundle) msg.obj;
                    String provider = b.getString("provider");
                    int status = b.getInt("status");
                    Bundle extras = b.getBundle("extras");
                    mListener.onStatusChanged(provider, status, extras);
                    break;
                case TYPE_PROVIDER_ENABLED:
                    mListener.onProviderEnabled((String) msg.obj);
                    break;
                case TYPE_PROVIDER_DISABLED:
                    mListener.onProviderDisabled((String) msg.obj);
                    break;
            }
            try {
                mService.locationCallbackFinished(this);
            } catch (RemoteException e) {
                Log.e(TAG, "locationCallbackFinished: RemoteException", e);
            }
        }
    }
    
    private class GpsStatusListenerTransport extends IGpsStatusListener.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.138 -0500", hash_original_field = "A3B1A044CA6CCFE73DBB96810430D552", hash_generated_field = "6899010D64F70B3018C0CDC68B38D232")

        private static final int NMEA_RECEIVED = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.132 -0500", hash_original_field = "6D144131A306DBBEB8202BC5B53FDEFD", hash_generated_field = "3564D5BECCC467DBB563E9174E6839FA")

        private  GpsStatus.Listener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.135 -0500", hash_original_field = "FA43A6D3AD762D701A9F1A786F3C517D", hash_generated_field = "C56AA1FA4293F00EF5AC3280F7CE1BCE")

        private  GpsStatus.NmeaListener mNmeaListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.150 -0500", hash_original_field = "7535BC11B57D8EFA41A472F83BC8E29D", hash_generated_field = "BDE0A966016D1F7F3E0759437CA71854")

        private ArrayList<Nmea> mNmeaBuffer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.008 -0400", hash_original_field = "1388D92E53A0B03AA5E995A7DC696BD0", hash_generated_field = "4720EC15678BF4030E408554AC619E18")

        private final Handler mGpsHandler = new Handler() {
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.173 -0500", hash_original_method = "3A4C26C18C998E8AD28D793D2B4D73AC", hash_generated_method = "F70616BE6ED23F0BAD01968F7A779F16")
            
@Override
            public void handleMessage(Message msg) {
                if (msg.what == NMEA_RECEIVED) {
                    synchronized (mNmeaBuffer) {
                        int length = mNmeaBuffer.size();
                        for (int i = 0; i < length; i++) {
                            Nmea nmea = mNmeaBuffer.get(i);
                            mNmeaListener.onNmeaReceived(nmea.mTimestamp, nmea.mNmea);
                        }
                        mNmeaBuffer.clear();
                    }
                } else {
                    // synchronize on mGpsStatus to ensure the data is copied atomically.
                    synchronized(mGpsStatus) {
                        mListener.onGpsStatusChanged(msg.what);
                    }
                }
            }
            
};

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.153 -0500", hash_original_method = "F4C48E1C52D52EE2A00BB4471F3F104F", hash_generated_method = "F4C48E1C52D52EE2A00BB4471F3F104F")
        
GpsStatusListenerTransport(GpsStatus.Listener listener) {
            mListener = listener;
            mNmeaListener = null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.156 -0500", hash_original_method = "2F84EC7497CDA44BC0A09FBB4C2AE91B", hash_generated_method = "2F84EC7497CDA44BC0A09FBB4C2AE91B")
        
GpsStatusListenerTransport(GpsStatus.NmeaListener listener) {
            mNmeaListener = listener;
            mListener = null;
            mNmeaBuffer = new ArrayList<Nmea>();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.158 -0500", hash_original_method = "03DD372B4F74F556A5CFC2950F002742", hash_generated_method = "CA929F2866E29D44D20EB17636581E17")
        
public void onGpsStarted() {
            if (mListener != null) {
                Message msg = Message.obtain();
                msg.what = GpsStatus.GPS_EVENT_STARTED;
                mGpsHandler.sendMessage(msg);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.161 -0500", hash_original_method = "30C4A680AA9F7AF81E647400DEBA508E", hash_generated_method = "88095158EC23E727F9C186D284383691")
        
public void onGpsStopped() {
            if (mListener != null) {
                Message msg = Message.obtain();
                msg.what = GpsStatus.GPS_EVENT_STOPPED;
                mGpsHandler.sendMessage(msg);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.164 -0500", hash_original_method = "E5DFF9ED39044E57371BE0E746E84457", hash_generated_method = "8CA7CA2F5651F39EC418D3838F092834")
        
public void onFirstFix(int ttff) {
            if (mListener != null) {
                mGpsStatus.setTimeToFirstFix(ttff);
                Message msg = Message.obtain();
                msg.what = GpsStatus.GPS_EVENT_FIRST_FIX;
                mGpsHandler.sendMessage(msg);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.166 -0500", hash_original_method = "6F6B969ADA567E96DFAB5A585780E70F", hash_generated_method = "30FBEF3E7C5E42D917347F05A7B1ED92")
        
public void onSvStatusChanged(int svCount, int[] prns, float[] snrs,
                float[] elevations, float[] azimuths, int ephemerisMask,
                int almanacMask, int usedInFixMask) {
            if (mListener != null) {
                mGpsStatus.setStatus(svCount, prns, snrs, elevations, azimuths,
                        ephemerisMask, almanacMask, usedInFixMask);

                Message msg = Message.obtain();
                msg.what = GpsStatus.GPS_EVENT_SATELLITE_STATUS;
                // remove any SV status messages already in the queue
                mGpsHandler.removeMessages(GpsStatus.GPS_EVENT_SATELLITE_STATUS);
                mGpsHandler.sendMessage(msg);
            }
        }
        
        private class Nmea {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.141 -0500", hash_original_field = "1D358F2CB412AAF1346451355CB8F3E3", hash_generated_field = "1D358F2CB412AAF1346451355CB8F3E3")

            long mTimestamp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.144 -0500", hash_original_field = "24AFD15E5AD8DD2E9530B1A85650CD93", hash_generated_field = "24AFD15E5AD8DD2E9530B1A85650CD93")

            String mNmea;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.147 -0500", hash_original_method = "7FAFEC38F5688F1D1ACFE15C845DEFCA", hash_generated_method = "7FAFEC38F5688F1D1ACFE15C845DEFCA")
            
Nmea(long timestamp, String nmea) {
                mTimestamp = timestamp;
                mNmea = nmea;
            }
            
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.169 -0500", hash_original_method = "D97F778C22B6B561834B5A8A67FE2F57", hash_generated_method = "161FD6F7E5FE9F4B6A10D1E929D55386")
        
public void onNmeaReceived(long timestamp, String nmea) {
            if (mNmeaListener != null) {
                synchronized (mNmeaBuffer) {
                    mNmeaBuffer.add(new Nmea(timestamp, nmea));
                }
                Message msg = Message.obtain();
                msg.what = NMEA_RECEIVED;
                // remove any NMEA_RECEIVED messages already in the queue
                mGpsHandler.removeMessages(NMEA_RECEIVED);
                mGpsHandler.sendMessage(msg);
            }
        }
    }

    /**
     * Removes any mock location associated with the given provider.
     *
     * @param provider the provider name
     *
     * @throws SecurityException if the ACCESS_MOCK_LOCATION permission is not present
     * or the {@link android.provider.Settings.Secure#ALLOW_MOCK_LOCATION
     * Settings.Secure.ALLOW_MOCK_LOCATION}} system setting is not enabled
     * @throws IllegalArgumentException if no provider with the given name exists
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.120 -0500", hash_original_method = "7CA7069D9943855589356239516DA9AF", hash_generated_method = "C42DF4093C8224D281CFC7E1BDDB3B7E")
    
public void clearTestProviderLocation(String provider) {
        try {
            mService.clearTestProviderLocation(provider);
        } catch (RemoteException ex) {
            Log.e(TAG, "clearTestProviderLocation: RemoteException", ex);
        }
    }

    /**
     * Sets a mock enabled value for the given provider.  This value will be used in place
     * of any actual value from the provider.
     *
     * @param provider the provider name
     * @param enabled the mock enabled value
     *
     * @throws SecurityException if the ACCESS_MOCK_LOCATION permission is not present
     * or the {@link android.provider.Settings.Secure#ALLOW_MOCK_LOCATION
     * Settings.Secure.ALLOW_MOCK_LOCATION}} system setting is not enabled
     * @throws IllegalArgumentException if no provider with the given name exists
     */
    @DSSink({DSSinkKind.LOCATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.122 -0500", hash_original_method = "48C675867948B21786DBAE4C1AE4920C", hash_generated_method = "F5D18F237734E111A8E172A140A4EE91")
    
public void setTestProviderEnabled(String provider, boolean enabled) {
        try {
            mService.setTestProviderEnabled(provider, enabled);
        } catch (RemoteException ex) {
            Log.e(TAG, "setTestProviderEnabled: RemoteException", ex);
        }
    }

    /**
     * Removes any mock enabled value associated with the given provider.
     *
     * @param provider the provider name
     *
     * @throws SecurityException if the ACCESS_MOCK_LOCATION permission is not present
     * or the {@link android.provider.Settings.Secure#ALLOW_MOCK_LOCATION
     * Settings.Secure.ALLOW_MOCK_LOCATION}} system setting is not enabled
     * @throws IllegalArgumentException if no provider with the given name exists
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.125 -0500", hash_original_method = "A7FE0DFAA40049E1860E732454FD3827", hash_generated_method = "15D1FF33625977AED0227A30DCFD7BC4")
    
public void clearTestProviderEnabled(String provider) {
        try {
            mService.clearTestProviderEnabled(provider);
        } catch (RemoteException ex) {
            Log.e(TAG, "clearTestProviderEnabled: RemoteException", ex);
        }

    }

    /**
     * Sets mock status values for the given provider.  These values will be used in place
     * of any actual values from the provider.
     *
     * @param provider the provider name
     * @param status the mock status
     * @param extras a Bundle containing mock extras
     * @param updateTime the mock update time
     *
     * @throws SecurityException if the ACCESS_MOCK_LOCATION permission is not present
     * or the {@link android.provider.Settings.Secure#ALLOW_MOCK_LOCATION
     * Settings.Secure.ALLOW_MOCK_LOCATION}} system setting is not enabled
     * @throws IllegalArgumentException if no provider with the given name exists
     */
    @DSSink({DSSinkKind.LOCATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.127 -0500", hash_original_method = "03886DE73D19ECB6C62373F8D9D58CA9", hash_generated_method = "A00A94A7CECAB50C33C43BB2D669A834")
    
public void setTestProviderStatus(String provider, int status, Bundle extras, long updateTime) {
        try {
            mService.setTestProviderStatus(provider, status, extras, updateTime);
        } catch (RemoteException ex) {
            Log.e(TAG, "setTestProviderStatus: RemoteException", ex);
        }
    }

    /**
     * Removes any mock status values associated with the given provider.
     *
     * @param provider the provider name
     *
     * @throws SecurityException if the ACCESS_MOCK_LOCATION permission is not present
     * or the {@link android.provider.Settings.Secure#ALLOW_MOCK_LOCATION
     * Settings.Secure.ALLOW_MOCK_LOCATION}} system setting is not enabled
     * @throws IllegalArgumentException if no provider with the given name exists
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.129 -0500", hash_original_method = "013DF8509B89AA0EABD8A254078FCC60", hash_generated_method = "608257C18AFEB7152BC97B09FB556558")
    
public void clearTestProviderStatus(String provider) {
        try {
            mService.clearTestProviderStatus(provider);
        } catch (RemoteException ex) {
            Log.e(TAG, "clearTestProviderStatus: RemoteException", ex);
        }
    }

    /**
     * Adds a GPS status listener.
     *
     * @param listener GPS status listener object to register
     *
     * @return true if the listener was successfully added
     *
     * @throws SecurityException if the ACCESS_FINE_LOCATION permission is not present
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.182 -0500", hash_original_method = "735E28281E7A2112C9B0A11E7D511734", hash_generated_method = "39B25F2BBFB141F92751C86A74C99C21")
    
public boolean addGpsStatusListener(GpsStatus.Listener listener) {
        boolean result;

        if (mGpsStatusListeners.get(listener) != null) {
            // listener is already registered
            return true;
        }
        try {
            GpsStatusListenerTransport transport = new GpsStatusListenerTransport(listener);
            result = mService.addGpsStatusListener(transport);
            if (result) {
                mGpsStatusListeners.put(listener, transport);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in registerGpsStatusListener: ", e);
            result = false;
        }

        return result;
    }

    /**
     * Removes a GPS status listener.
     *
     * @param listener GPS status listener object to remove
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.185 -0500", hash_original_method = "BE93B3D03F00A664B96E561F38428949", hash_generated_method = "3C77521596384CF49A716E87F62A934D")
    
public void removeGpsStatusListener(GpsStatus.Listener listener) {
        try {
            GpsStatusListenerTransport transport = mGpsStatusListeners.remove(listener);
            if (transport != null) {
                mService.removeGpsStatusListener(transport);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in unregisterGpsStatusListener: ", e);
        }
    }

    /**
     * Adds an NMEA listener.
     *
     * @param listener a {#link GpsStatus.NmeaListener} object to register
     *
     * @return true if the listener was successfully added
     *
     * @throws SecurityException if the ACCESS_FINE_LOCATION permission is not present
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.187 -0500", hash_original_method = "69F227E2B854C20A513354DE72686880", hash_generated_method = "934A6A1E92ED5BBA2594D085C9DBCA6F")
    
public boolean addNmeaListener(GpsStatus.NmeaListener listener) {
        boolean result;

        if (mNmeaListeners.get(listener) != null) {
            // listener is already registered
            return true;
        }
        try {
            GpsStatusListenerTransport transport = new GpsStatusListenerTransport(listener);
            result = mService.addGpsStatusListener(transport);
            if (result) {
                mNmeaListeners.put(listener, transport);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in registerGpsStatusListener: ", e);
            result = false;
        }

        return result;
    }

    /**
     * Removes an NMEA listener.
     *
     * @param listener a {#link GpsStatus.NmeaListener} object to remove
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.190 -0500", hash_original_method = "B4F97B229D6634102324704B9EDD8365", hash_generated_method = "4787AD74B822C866DA500AC5E0C375E7")
    
public void removeNmeaListener(GpsStatus.NmeaListener listener) {
        try {
            GpsStatusListenerTransport transport = mNmeaListeners.remove(listener);
            if (transport != null) {
                mService.removeGpsStatusListener(transport);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in unregisterGpsStatusListener: ", e);
        }
    }

     /**
     * Retrieves information about the current status of the GPS engine.
     * This should only be called from the {@link GpsStatus.Listener#onGpsStatusChanged}
     * callback to ensure that the data is copied atomically.
     *
     * The caller may either pass in a {@link GpsStatus} object to set with the latest
     * status information, or pass null to create a new {@link GpsStatus} object.
     *
     * @param status object containing GPS status details, or null.
     * @return status object containing updated GPS status.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.LOCATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.193 -0500", hash_original_method = "58632EF952FC4DB3D625E7340D0B4D49", hash_generated_method = "946F1B5F569EDD5FFF9500D0E41B562A")
    
public GpsStatus getGpsStatus(GpsStatus status) {
        if (status == null) {
            status = new GpsStatus();
       }
       status.setStatus(mGpsStatus);
       return status;
    }

    /**
     * Sends additional commands to a location provider.
     * Can be used to support provider specific extensions to the Location Manager API
     *
     * @param provider name of the location provider.
     * @param command name of the command to send to the provider.
     * @param extras optional arguments for the command (or null).
     * The provider may optionally fill the extras Bundle with results from the command.
     *
     * @return true if the command succeeds.
     */
    @DSSink({DSSinkKind.LOCATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.195 -0500", hash_original_method = "A7B31AF326321489C7AFBE2F446F3E30", hash_generated_method = "B7C00E37E606958AED57A98D7B947491")
    
public boolean sendExtraCommand(String provider, String command, Bundle extras) {
        try {
            return mService.sendExtraCommand(provider, command, extras);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in sendExtraCommand: ", e);
            return false;
        }
    }

    /**
     * Used by NetInitiatedActivity to report user response
     * for network initiated GPS fix requests.
     *
     * {@hide}
     */
    @DSSink({DSSinkKind.LOCATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.197 -0500", hash_original_method = "486A02DD90A0BB213EFD64094D84B261", hash_generated_method = "40A3234209117E05B4CC7A1B82C3BC36")
    
public boolean sendNiResponse(int notifId, int userResponse) {
    	try {
            return mService.sendNiResponse(notifId, userResponse);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in sendNiResponse: ", e);
            return false;
        }
    }
}

