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
 * Copyright (C) 2010 The Android Open Source Project
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


package android.nfc.tech;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;

import android.nfc.ErrorCodes;
import android.nfc.FormatException;
import android.nfc.INfcTag;
import android.nfc.NdefMessage;
import android.nfc.Tag;
import android.os.RemoteException;

public final class NdefFormatable extends BasicTagTechnology {

    /**
     * Get an instance of {@link NdefFormatable} for the given tag.
     * <p>Does not cause any RF activity and does not block.
     * <p>Returns null if {@link NdefFormatable} was not enumerated in {@link Tag#getTechList}.
     * This indicates the tag is not NDEF formatable by this Android device.
     *
     * @param tag an NDEF formatable tag
     * @return NDEF formatable object
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.188 -0500", hash_original_method = "EF1F12BA68C994020F7EF7C36B8754C4", hash_generated_method = "B8F9B487131DCE7A6B920461F97E95FD")
    
public static NdefFormatable get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NDEF_FORMATABLE)) return null;
        try {
            return new NdefFormatable(tag);
        } catch (RemoteException e) {
            return null;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.186 -0500", hash_original_field = "76B42502A850F1BA8F9A78C316486025", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";

    /**
     * Internal constructor, to be used by NfcAdapter
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.191 -0500", hash_original_method = "074BAD8FDA859E71D091A9807C3BD3AB", hash_generated_method = "6FF42EDF47B5C8EF91C9A35FB4EBFD46")
    
public NdefFormatable(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NDEF_FORMATABLE);
    }

    /**
     * Format a tag as NDEF, and write a {@link NdefMessage}.
     *
     * <p>This is a multi-step process, an IOException is thrown
     * if any one step fails.
     * <p>The card is left in a read-write state after this operation.
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param firstMessage the NDEF message to write after formatting, can be null
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or the operation is canceled
     * @throws FormatException if the NDEF Message to write is malformed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.193 -0500", hash_original_method = "6CDCACAEC64FFB65AEDACBA4B44913A4", hash_generated_method = "AD2D9E37F64FA5FAD595176604ED2654")
    
public void format(NdefMessage firstMessage) throws IOException, FormatException {
        format(firstMessage, false);
    }

    /**
     * Formats a tag as NDEF, write a {@link NdefMessage}, and make read-only.
     *
     * <p>This is a multi-step process, an IOException is thrown
     * if any one step fails.
     * <p>The card is left in a read-only state if this method returns successfully.
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param firstMessage the NDEF message to write after formatting
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or the operation is canceled
     * @throws FormatException if the NDEF Message to write is malformed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.195 -0500", hash_original_method = "2D5D7133932920FB3E992CFF7D090021", hash_generated_method = "4F02B7CE5D76CCCB9D004D18F5973DE9")
    
public void formatReadOnly(NdefMessage firstMessage) throws IOException, FormatException {
        format(firstMessage, true);
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.198 -0500", hash_original_method = "E299B2177763F767A596EAE082378EB1", hash_generated_method = "D2414BB445035CA6912CCB5166D49870")
    
void format(NdefMessage firstMessage, boolean makeReadOnly) throws IOException,
            FormatException {
        checkConnected();

        try {
            int serviceHandle = mTag.getServiceHandle();
            INfcTag tagService = mTag.getTagService();
            int errorCode = tagService.formatNdef(serviceHandle, MifareClassic.KEY_DEFAULT);
            switch (errorCode) {
                case ErrorCodes.SUCCESS:
                    break;
                case ErrorCodes.ERROR_IO:
                    throw new IOException();
                case ErrorCodes.ERROR_INVALID_PARAM:
                    throw new FormatException();
                default:
                    // Should not happen
                    throw new IOException();
            }
            // Now check and see if the format worked
            if (tagService.isNdef(serviceHandle)) {
                errorCode = tagService.ndefWrite(serviceHandle, firstMessage);
                switch (errorCode) {
                    case ErrorCodes.SUCCESS:
                        break;
                    case ErrorCodes.ERROR_IO:
                        throw new IOException();
                    case ErrorCodes.ERROR_INVALID_PARAM:
                        throw new FormatException();
                    default:
                        // Should not happen
                        throw new IOException();
                }
            } else {
                throw new IOException();
            }
            // optionally make read-only
            if (makeReadOnly) {
                errorCode = tagService.ndefMakeReadOnly(serviceHandle);
                switch (errorCode) {
                    case ErrorCodes.SUCCESS:
                        break;
                    case ErrorCodes.ERROR_IO:
                        throw new IOException();
                    case ErrorCodes.ERROR_INVALID_PARAM:
                        throw new IOException();
                    default:
                        // Should not happen
                        throw new IOException();
                }
            }
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
        }
    }
}

