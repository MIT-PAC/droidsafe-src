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
 */

package com.google.android.gms.common.api;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.TimeUnit;

public class GoogleApiClientImpl implements GoogleApiClient {

    public android.os.Looper getLooper() {
        return null;
    }

    @DSSink({DSSinkKind.GOOGLE_SERVICES})
    @DSSpec(DSCat.SPEC_OTHERS)
    public void connect() {
    }

    public ConnectionResult blockingConnect() {
        return null;
    }

    public ConnectionResult blockingConnect(long  l0, java.util.concurrent.TimeUnit  r1) {
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    public void disconnect(){}

    public void reconnect(){}

    public void stopAutoManage(){}

    @DSSafe(DSCat.SAFE_LIST)
    public boolean isConnected(){
        return true;
    }

    public boolean isConnecting() {
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    public void registerConnectionCallbacks(ConnectionCallbacks  r0){}

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks  r0){
        return true;
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks  r0){}

    @DSSafe(DSCat.SAFE_LIST)
    public void registerConnectionFailedListener(OnConnectionFailedListener  r0){}

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener  r0){
        return true;
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener  r0){}
}
