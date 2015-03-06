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
 * Copyright (C) 2007-2008 The Android Open Source Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodSession;

public abstract class AbstractInputMethodService extends Service implements KeyEvent.Callback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.400 -0500", hash_original_field = "A587945B3D1BEB37BF61FF14794CE66B", hash_generated_field = "9355B5F89B0311B79EB4664ED09CF53D")

    private InputMethod mInputMethod;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.418 -0500", hash_original_field = "072D100A7BFFF1A5663A0C0EDC099F15", hash_generated_field = "98A76EB2F504968B591CF0A5D11D8253")
    
    final KeyEvent.DispatcherState mDispatcherState
            = new KeyEvent.DispatcherState();
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.078 -0400", hash_original_method = "BC18251CD7580FCA2AE30C6FE0852CCA", hash_generated_method = "BC18251CD7580FCA2AE30C6FE0852CCA")
    public AbstractInputMethodService ()
    {
        //Synthesized constructor
    }
    
    /**
     * Return the global {@link KeyEvent.DispatcherState KeyEvent.DispatcherState}
     * for used for processing events from the target application.
     * Normally you will not need to use this directly, but
     * just use the standard high-level event callbacks like {@link #onKeyDown}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.452 -0500", hash_original_method = "506AD561617E231B7466C0A7229483CE", hash_generated_method = "88E232FEDF387CBC9D73D871D0EB6C10")
    
public KeyEvent.DispatcherState getKeyDispatcherState() {
        return mDispatcherState;
    }
    
    /**
     * Called by the framework during initialization, when the InputMethod
     * interface for this service needs to be created.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.455 -0500", hash_original_method = "4BE4777A648557039F5DCFF01BFDCA14", hash_generated_method = "3CC782B1A55FD585AA386E5AF58B5945")
    
public abstract AbstractInputMethodImpl onCreateInputMethodInterface();
    
    /**
     * Called by the framework when a new InputMethodSession interface is
     * needed for a new client of the input method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.457 -0500", hash_original_method = "176F41CBAB830CDD89A7D794B52DF17B", hash_generated_method = "F25BC81094D4123421F1CEA42A680928")
    
public abstract AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface();
    
    /**
     * Implement this to handle {@link android.os.Binder#dump Binder.dump()}
     * calls on your input method.
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.459 -0500", hash_original_method = "8E1D6FEDF1AFEDBCDCF9E63EFF23CA00", hash_generated_method = "FED34E6D5793CA7ED70004622D90B9F6")
    
@Override
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.462 -0500", hash_original_method = "A37FBA98B4D1A366D99013E441DCBD11", hash_generated_method = "F7AD61F668C1960A695777149B1A3953")
    
@Override
    final public IBinder onBind(Intent intent) {
        if (mInputMethod == null) {
            mInputMethod = onCreateInputMethodInterface();
        }
        return new IInputMethodWrapper(this, mInputMethod);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.464 -0500", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "3CA4089EBE14436E733AD365EF1361B8")
    
public boolean onTrackballEvent(MotionEvent event) {
        return false;
    }
    
    public abstract class AbstractInputMethodImpl implements InputMethod {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.082 -0400", hash_original_method = "1FC06C592D7CEB663723BCE3B795B4B6", hash_generated_method = "1FC06C592D7CEB663723BCE3B795B4B6")
        public AbstractInputMethodImpl ()
        {
            //Synthesized constructor
        }
        /**
         * Instantiate a new client session for the input method, by calling
         * back to {@link AbstractInputMethodService#onCreateInputMethodSessionInterface()
         * AbstractInputMethodService.onCreateInputMethodSessionInterface()}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.422 -0500", hash_original_method = "084F24BCF671A12F38D7783BEA9F6E08", hash_generated_method = "DD369A981C0E962648D9702BD49720E4")
        
public void createSession(SessionCallback callback) {
            callback.sessionCreated(onCreateInputMethodSessionInterface());
        }
        
        /**
         * Take care of enabling or disabling an existing session by calling its
         * {@link AbstractInputMethodSessionImpl#revokeSelf()
         * AbstractInputMethodSessionImpl.setEnabled()} method.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.424 -0500", hash_original_method = "66C173BC408ADA3F5326213B71DD3797", hash_generated_method = "4F064CDBA32C8CDBC8255E95E41CB8B3")
        
public void setSessionEnabled(InputMethodSession session, boolean enabled) {
            ((AbstractInputMethodSessionImpl)session).setEnabled(enabled);
        }
        
        /**
         * Take care of killing an existing session by calling its
         * {@link AbstractInputMethodSessionImpl#revokeSelf()
         * AbstractInputMethodSessionImpl.revokeSelf()} method.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.426 -0500", hash_original_method = "79971C84DD1A2F851BEBA1D6EABE42F6", hash_generated_method = "81F8C17832864D7E04850D040E7C414A")
        
public void revokeSession(InputMethodSession session) {
            ((AbstractInputMethodSessionImpl)session).revokeSelf();
        }
        
    }
    
    public abstract class AbstractInputMethodSessionImpl implements InputMethodSession {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.432 -0500", hash_original_field = "35AD8B69CCAB99ED75EF706EA5E75D7E", hash_generated_field = "35AD8B69CCAB99ED75EF706EA5E75D7E")

        boolean mEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.434 -0500", hash_original_field = "5781D1C4F0DDC12DF2BB3E12406C7974", hash_generated_field = "5781D1C4F0DDC12DF2BB3E12406C7974")

        boolean mRevoked;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.084 -0400", hash_original_method = "732EE9B327CCA9D778A0A67756B490DA", hash_generated_method = "732EE9B327CCA9D778A0A67756B490DA")
        public AbstractInputMethodSessionImpl ()
        {
            //Synthesized constructor
        }
        
        /**
         * Check whether this session has been enabled by the system.  If not
         * enabled, you should not execute any calls on to it.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.436 -0500", hash_original_method = "B599CE9BD5CE6C0947F95A74F4693444", hash_generated_method = "FCD384DBC29E5B725DC0C96A27CA1EC9")
        
public boolean isEnabled() {
            return mEnabled;
        }
        
        /**
         * Check whether this session has been revoked by the system.  Revoked
         * session is also always disabled, so there is generally no need to
         * explicitly check for this.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.438 -0500", hash_original_method = "C0B4C5A0A5D7F00D5E6612F5DDAFF7B5", hash_generated_method = "CF66BB9EA392ED21D7A133ABCE9B221E")
        
public boolean isRevoked() {
            return mRevoked;
        }
        
        /**
         * Change the enabled state of the session.  This only works if the
         * session has not been revoked.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.441 -0500", hash_original_method = "BA8B8E3B4141C528807EA03970F3ED77", hash_generated_method = "939333BBC635D281310E883AA8388085")
        
public void setEnabled(boolean enabled) {
            if (!mRevoked) {
                mEnabled = enabled;
            }
        }
        
        /**
         * Revoke the session from the client.  This disabled the session, and
         * prevents it from ever being enabled again.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.443 -0500", hash_original_method = "6150597809F85496BEE526162ACEB60F", hash_generated_method = "C30AF228B79D846F04FA4DE4BA6AEFF6")
        
public void revokeSelf() {
            mRevoked = true;
            mEnabled = false;
        }
        
        /**
         * Take care of dispatching incoming key events to the appropriate
         * callbacks on the service, and tell the client when this is done.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.446 -0500", hash_original_method = "352A951CCD835CDBB0D749381932ADC2", hash_generated_method = "8C668FCBB5986C4E6297EF7B2988C0E7")
        
public void dispatchKeyEvent(int seq, KeyEvent event, EventCallback callback) {
            boolean handled = event.dispatch(AbstractInputMethodService.this,
                    mDispatcherState, this);
            if (callback != null) {
                callback.finishedEvent(seq, handled);
            }
        }

        /**
         * Take care of dispatching incoming trackball events to the appropriate
         * callbacks on the service, and tell the client when this is done.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.448 -0500", hash_original_method = "D1FB978C0FC3E262298A1F84CE672B17", hash_generated_method = "3970D298A5313EBCA6209AB6EBDEEBC6")
        
public void dispatchTrackballEvent(int seq, MotionEvent event, EventCallback callback) {
            boolean handled = onTrackballEvent(event);
            if (callback != null) {
                callback.finishedEvent(seq, handled);
            }
        }
        
    }
    
}

