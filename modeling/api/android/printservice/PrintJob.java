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
 * Copyright (C) 2013 The Android Open Source Project
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


package android.printservice;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.RemoteException;
import android.print.PrintJobId;
import android.print.PrintJobInfo;
import android.text.TextUtils;
import android.util.Log;

/**
 * This class represents a print job from the perspective of a print
 * service. It provides APIs for observing the print job state and
 * performing operations on the print job.
 * <p>
 * <strong>Note: </strong> All methods of this class must be invoked on
 * the main application thread.
 * </p>
 */
public final class PrintJob {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.506 -0400", hash_original_field = "5A4C70994AD2EBD0F20C6C2643EFEB80", hash_generated_field = "D12106B4BE189AEBA340A4E0D1BAAC64")

    private static final String LOG_TAG = "PrintJob";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.507 -0400", hash_original_field = "A52A98A1947BB78D504A417FBBA83B44", hash_generated_field = "909B435CFC9A1FF432407D21F910719A")

    private  IPrintServiceClient mPrintServiceClient;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.508 -0400", hash_original_field = "BDC75889B9B9181E985C3967DEB379EA", hash_generated_field = "23F05551BAF21978C310E0F95B3E949F")

    private  PrintDocument mDocument;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.509 -0400", hash_original_field = "9A7556BFCCDF66660C9DC5385D5C4CF5", hash_generated_field = "93917749A38A402C6FF2A16D50AACDAC")

    private PrintJobInfo mCachedInfo;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.510 -0400", hash_original_method = "ADA87C83AD6644870B7B7AC37B64F151", hash_generated_method = "ADA87C83AD6644870B7B7AC37B64F151")
    
PrintJob(PrintJobInfo jobInfo, IPrintServiceClient client) {
        mCachedInfo = jobInfo;
        mPrintServiceClient = client;
        mDocument = new PrintDocument(mCachedInfo.getId(), client,
                jobInfo.getDocumentInfo());
    }

    /**
     * Gets the unique print job id.
     *
     * @return The id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.511 -0400", hash_original_method = "D3DA3AB0E76F0C37B868BE01FEBDD94F", hash_generated_method = "5F999441AA19866395537566075C7F9B")
    
public PrintJobId getId() {
        PrintService.throwIfNotCalledOnMainThread();
        return mCachedInfo.getId();
    }

    /**
     * Gets the {@link PrintJobInfo} that describes this job.
     * <p>
     * <strong>Node:</strong>The returned info object is a snapshot of the
     * current print job state. Every call to this method returns a fresh
     * info object that reflects the current print job state.
     * </p>
     *
     * @return The print job info.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.512 -0400", hash_original_method = "6A43FFA6C55349BCD197C2C69FA6B033", hash_generated_method = "8ED062C5B29031CE0628B66765305A83")
    
public PrintJobInfo getInfo() {
        PrintService.throwIfNotCalledOnMainThread();
        if (isInImmutableState()) {
            return mCachedInfo;
        }
        PrintJobInfo info = null;
        try {
            info = mPrintServiceClient.getPrintJobInfo(mCachedInfo.getId());
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Couldn't get info for job: " + mCachedInfo.getId(), re);
        }
        if (info != null) {
            mCachedInfo = info;
        }
        return mCachedInfo;
    }

    /**
     * Gets the printed document.
     *
     * @return The document.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.513 -0400", hash_original_method = "E8AAF914EEAD515F228DD24817A9AB93", hash_generated_method = "9E42F49F1F7465FA2EA78FF119B1DD3D")
    
public PrintDocument getDocument() {
        PrintService.throwIfNotCalledOnMainThread();
        return mDocument;
    }

    /**
     * Gets whether this print job is queued. Such a print job is
     * ready to be printed and can be started or cancelled.
     *
     * @return Whether the print job is queued.
     *
     * @see #start()
     * @see #cancel()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.513 -0400", hash_original_method = "19AEE2BCACE3F3EB35661DA4ED623440", hash_generated_method = "8602F35AA82184B0E47D6BF62DCC2CD2")
    
public boolean isQueued() {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getState() == PrintJobInfo.STATE_QUEUED;
    }

    /**
     * Gets whether this print job is started. Such a print job is
     * being printed and can be completed or canceled or failed.
     *
     * @return Whether the print job is started.
     *
     * @see #complete()
     * @see #cancel()
     * @see #fail(CharSequence)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.514 -0400", hash_original_method = "DB21E175FA436FCA8A0E56DF8C83D0C2", hash_generated_method = "0D6F934A903FC33FE71C0EDF4AE0035D")
    
public boolean isStarted() {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getState() == PrintJobInfo.STATE_STARTED;
    }

    /**
     * Gets whether this print job is blocked. Such a print job is halted
     * due to an abnormal condition and can be started or canceled or failed.
     *
     * @return Whether the print job is blocked.
     *
     * @see #start()
     * @see #cancel()
     * @see #fail(CharSequence)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.515 -0400", hash_original_method = "C79872AE4872F7433275CC8E4AAFD964", hash_generated_method = "EADB879FAE6AC062DF2BDE52D9E46E12")
    
public boolean isBlocked() {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getState() == PrintJobInfo.STATE_BLOCKED;
    }

    /**
     * Gets whether this print job is completed. Such a print job
     * is successfully printed. This is a final state.
     *
     * @return Whether the print job is completed.
     *
     * @see #complete()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.516 -0400", hash_original_method = "93BB6DC6E391C02C5576AE7FF099F252", hash_generated_method = "61F7F31E3EA68FBB49C15F547333F2B9")
    
public boolean isCompleted() {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getState() == PrintJobInfo.STATE_COMPLETED;
    }

    /**
     * Gets whether this print job is failed. Such a print job is
     * not successfully printed due to an error. This is a final state.
     *
     * @return Whether the print job is failed.
     *
     * @see #fail(CharSequence)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.517 -0400", hash_original_method = "119B60645D483F809E3A96FC8309D1F9", hash_generated_method = "E6C38C6C759418E657BA31E557B3EE66")
    
public boolean isFailed() {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getState() == PrintJobInfo.STATE_FAILED;
    }

    /**
     * Gets whether this print job is cancelled. Such a print job was
     * cancelled as a result of a user request. This is a final state.
     *
     * @return Whether the print job is cancelled.
     *
     * @see #cancel()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.518 -0400", hash_original_method = "23D602EF1169EC1FFBB7BD36AD3498D5", hash_generated_method = "7F2BC7617B7D4C02F5D1C384289F87EA")
    
public boolean isCancelled() {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getState() == PrintJobInfo.STATE_CANCELED;
    }

    /**
     * Starts the print job. You should call this method if {@link
     * #isQueued()} or {@link #isBlocked()} returns true and you started
     * resumed printing.
     *
     * @return Whether the job was started.
     *
     * @see #isQueued()
     * @see #isBlocked()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.519 -0400", hash_original_method = "57DD5E96CE298C56035B08D427842463", hash_generated_method = "787898B7A8CD32AA0A0553F293D33EAD")
    
public boolean start() {
        PrintService.throwIfNotCalledOnMainThread();
        final int state = getInfo().getState();
        if (state == PrintJobInfo.STATE_QUEUED
                || state == PrintJobInfo.STATE_BLOCKED) {
            return setState(PrintJobInfo.STATE_STARTED, null);
        }
        return false;
    }

    /**
     * Blocks the print job. You should call this method if {@link
     * #isStarted()} or {@link #isBlocked()} returns true and you need
     * to block the print job. For example, the user has to add some
     * paper to continue printing. To resume the print job call {@link
     * #start()}.
     *
     * @return Whether the job was blocked.
     *
     * @see #isStarted()
     * @see #isBlocked()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.519 -0400", hash_original_method = "4165313654A0DDFE7CFD7284B8B8C87E", hash_generated_method = "84F3A6592B9924C14688CA11C7091998")
    
public boolean block(String reason) {
        PrintService.throwIfNotCalledOnMainThread();
        PrintJobInfo info = getInfo();
        final int state = info.getState();
        if (state == PrintJobInfo.STATE_STARTED
                || (state == PrintJobInfo.STATE_BLOCKED
                        && !TextUtils.equals(info.getStateReason(), reason))) {
            return setState(PrintJobInfo.STATE_BLOCKED, reason);
        }
        return false;
    }

    /**
     * Completes the print job. You should call this method if {@link
     * #isStarted()} returns true and you are done printing.
     *
     * @return Whether the job as completed.
     *
     * @see #isStarted()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.521 -0400", hash_original_method = "D3AB7FAF14D115719BBEE1FF72A077E7", hash_generated_method = "0A8D82A05677740A1D58DA9424CD71CC")
    
public boolean complete() {
        PrintService.throwIfNotCalledOnMainThread();
        if (isStarted()) {
            return setState(PrintJobInfo.STATE_COMPLETED, null);
        }
        return false;
    }

    /**
     * Fails the print job. You should call this method if {@link
     * #isQueued()} or {@link #isStarted()} or {@link #isBlocked()}
     * returns true you failed while printing.
     *
     * @param error The human readable, short, and translated reason
     * for the failure.
     * @return Whether the job was failed.
     *
     * @see #isQueued()
     * @see #isStarted()
     * @see #isBlocked()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.522 -0400", hash_original_method = "8E4576E6B7C49866F8FFF397A16C3BCF", hash_generated_method = "40D7CDF1C992E691F6A9037D8D21BC57")
    
public boolean fail(String error) {
        PrintService.throwIfNotCalledOnMainThread();
        if (!isInImmutableState()) {
            return setState(PrintJobInfo.STATE_FAILED, error);
        }
        return false;
    }

    /**
     * Cancels the print job. You should call this method if {@link
     * #isQueued()} or {@link #isStarted() or #isBlocked()} returns
     * true and you canceled the print job as a response to a call to
     * {@link PrintService#onRequestCancelPrintJob(PrintJob)}.
     *
     * @return Whether the job is canceled.
     *
     * @see #isStarted()
     * @see #isQueued()
     * @see #isBlocked()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.523 -0400", hash_original_method = "2C7C322E9DD43BED013F96D753BC99E7", hash_generated_method = "9159139215531EE37531CD3F6E2C0978")
    
public boolean cancel() {
        PrintService.throwIfNotCalledOnMainThread();
        if (!isInImmutableState()) {
            return setState(PrintJobInfo.STATE_CANCELED, null);
        }
        return false;
    }

    /**
     * Sets a tag that is valid in the context of a {@link PrintService}
     * and is not interpreted by the system. For example, a print service
     * may set as a tag the key of the print job returned by a remote
     * print server, if the printing is off handed to a cloud based service.
     *
     * @param tag The tag.
     * @return True if the tag was set, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.524 -0400", hash_original_method = "EF6904ADDCAEEB364F6F19141A030B8E", hash_generated_method = "D27ABB8E26224C3E46BADA24FDDC71CF")
    
public boolean setTag(String tag) {
        PrintService.throwIfNotCalledOnMainThread();
        if (isInImmutableState()) {
            return false;
        }
        try {
            return mPrintServiceClient.setPrintJobTag(mCachedInfo.getId(), tag);
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error setting tag for job: " + mCachedInfo.getId(), re);
        }
        return false;
    }

    /**
     * Gets the print job tag.
     *
     * @return The tag or null.
     *
     * @see #setTag(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.525 -0400", hash_original_method = "D2915B11388A6F92BBF9AFF1A65AD8DE", hash_generated_method = "2FB857BF889DCA0EB3E8A18E9A7611CA")
    
public String getTag() {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getTag();
    }

    /**
     * Gets the value of an advanced (printer specific) print option.
     *
     * @param key The option key.
     * @return The option value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.525 -0400", hash_original_method = "276D224DE71796D2DE3D683F463D13A6", hash_generated_method = "643735E42B3717FC02652CDAA0F40BC8")
    
public String getAdvancedStringOption(String key) {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getAdvancedStringOption(key);
    }

    /**
     * Gets whether this job has a given advanced (printer specific) print
     * option.
     *
     * @param key The option key.
     * @return Whether the option is present.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.526 -0400", hash_original_method = "C3B1B421E76AA8A22DF9F91B2B7F92A2", hash_generated_method = "4AA2C46378B89CF24C27908243756013")
    
public boolean hasAdvancedOption(String key) {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().hasAdvancedOption(key);
    }

    /**
     * Gets the value of an advanced (printer specific) print option.
     *
     * @param key The option key.
     * @return The option value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.527 -0400", hash_original_method = "2380435284BA58A41685758BD9D503E5", hash_generated_method = "45CF8AABA09714E77F02747E0FA53B24")
    
public int getAdvancedIntOption(String key) {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getAdvancedIntOption(key);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.529 -0400", hash_original_method = "0845B3CD81D06054DACA46550C94AE95", hash_generated_method = "D13A1D3F468ACB7601BD39C459E642EA")
    
@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PrintJob other = (PrintJob) obj;
        return (mCachedInfo.getId().equals(other.mCachedInfo.getId()));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.530 -0400", hash_original_method = "F8138E925779B447F857FF6B6AABBBC0", hash_generated_method = "14442763C7CFA1A1ACBBEE3A43387F6A")
    
@Override
    public int hashCode() {
        return mCachedInfo.getId().hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.531 -0400", hash_original_method = "A8B6E4BD0CFD60C57C240A9E8803B0B5", hash_generated_method = "029524A91FC278EB7D59CA35D6B42865")
    
private boolean isInImmutableState() {
        final int state = mCachedInfo.getState();
        return state == PrintJobInfo.STATE_COMPLETED
                || state == PrintJobInfo.STATE_CANCELED
                || state == PrintJobInfo.STATE_FAILED;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.532 -0400", hash_original_method = "ED7333B78C95582B74A90C4071BB4611", hash_generated_method = "1015456535BDBDE971E174C172E26223")
    
private boolean setState(int state, String error) {
        try {
            if (mPrintServiceClient.setPrintJobState(mCachedInfo.getId(), state, error)) {
                // Best effort - update the state of the cached info since
                // we may not be able to re-fetch it later if the job gets
                // removed from the spooler as a result of the state change.
                mCachedInfo.setState(state);
                mCachedInfo.setStateReason(error);
                return true;
            }
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error setting the state of job: " + mCachedInfo.getId(), re);
        }
        return false;
    }
}
