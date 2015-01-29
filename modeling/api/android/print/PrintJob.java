/*
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

package android.print;

/**
 * This class represents a print job from the perspective of an
 * application. It contains behavior methods for performing operations
 * on it as well as methods for querying its state. A snapshot of the
 * print job state is represented by the {@link PrintJobInfo} class.
 * The state of a print job may change over time. An application receives
 * instances of this class when creating a print job or querying for
 * its print jobs.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class PrintJob {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.279 -0400", hash_original_field = "31A7E416091F89E0B947D542B8488C99", hash_generated_field = "AF77FF1C642F25A9EECECBEC67704F14")

    private  PrintManager mPrintManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.280 -0400", hash_original_field = "9A7556BFCCDF66660C9DC5385D5C4CF5", hash_generated_field = "93917749A38A402C6FF2A16D50AACDAC")

    private PrintJobInfo mCachedInfo;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.281 -0400", hash_original_method = "C427704225CF3C6E53209169C058B471", hash_generated_method = "C427704225CF3C6E53209169C058B471")
    
PrintJob(PrintJobInfo info, PrintManager printManager) {
        mCachedInfo = info;
        mPrintManager = printManager;
    }

    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public PrintJob(DSOnlyType dontcare, PrintJobInfo info) {
		// TODO Auto-generated constructor stub
        mCachedInfo = info;
	}

	/**
     * Gets the unique print job id.
     *
     * @return The id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.282 -0400", hash_original_method = "2053F7A68C82ABE32C2AF1BAEC4B5064", hash_generated_method = "ADA06475869C2F7BC91A27631CA3BF7E")
    
public PrintJobId getId() {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.283 -0400", hash_original_method = "2E2631B898877273A9E931BA14C4B690", hash_generated_method = "0C7085D40A7C9B0FD2E5823B9DB730D1")
    
public PrintJobInfo getInfo() {
        if (isInImmutableState()) {
            return mCachedInfo;
        }
        PrintJobInfo info = mPrintManager.getPrintJobInfo(mCachedInfo.getId());
        if (info != null) {
            mCachedInfo = info;
        }
        return mCachedInfo;
    }

    /**
     * Cancels this print job. You can request cancellation of a
     * queued, started, blocked, or failed print job.
     *
     * @see #isQueued()
     * @see #isStarted()
     * @see #isBlocked()
     * @see #isFailed()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.284 -0400", hash_original_method = "7522AD53308CD10F1544E38D1EB762CF", hash_generated_method = "CE79928AEF3A763B2BF787801BBC2702")
    
public void cancel() {
        final int state = getInfo().getState();
        if (state == PrintJobInfo.STATE_QUEUED
                || state == PrintJobInfo.STATE_STARTED
                || state == PrintJobInfo.STATE_BLOCKED
                || state == PrintJobInfo.STATE_FAILED) {
            mPrintManager.cancelPrintJob(mCachedInfo.getId());
        }
    }

    /**
     * Restarts this print job. You can request restart of a failed
     * print job.
     *
     * @see #isFailed()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.285 -0400", hash_original_method = "BB75EF8F6E0673F65CCB71D9E93FEF94", hash_generated_method = "BD5AE59555BC5F38C24F9EF27A079410")
    
public void restart() {
        if (isFailed()) {
            mPrintManager.restartPrintJob(mCachedInfo.getId());
        }
    }

    /**
     * Gets whether this print job is queued. Such a print job is
     * ready to be printed. You can request a cancellation via
     * {@link #cancel()}.
     *
     * @return Whether the print job is queued.
     *
     * @see #cancel()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.286 -0400", hash_original_method = "B79B76BCD27E07078DB75F2C17EDA9C0", hash_generated_method = "1104080C61A1DDD36CC81BA6B7C26412")
    
public boolean isQueued() {
        return getInfo().getState() == PrintJobInfo.STATE_QUEUED;
    }

    /**
     * Gets whether this print job is started. Such a print job is
     * being printed. You can request a cancellation via
     * {@link #cancel()}.
     *
     * @return Whether the print job is started.
     *
     * @see #cancel()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.286 -0400", hash_original_method = "6C724E8733910B934C7F634D041AC3E9", hash_generated_method = "47818C149FE39D8B957039E3B2F404C7")
    
public boolean isStarted() {
        return getInfo().getState() == PrintJobInfo.STATE_STARTED;
    }

    /**
     * Gets whether this print job is blocked. Such a print job is halted
     * due to an abnormal condition. You can request a cancellation via
     * {@link #cancel()}.
     *
     * @return Whether the print job is blocked.
     *
     * @see #cancel()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.287 -0400", hash_original_method = "F202131FEECD2FC3EB7FCFE9D85969B5", hash_generated_method = "84F05A0ABEBD1B7694AC221A58963F5F")
    
public boolean isBlocked() {
        return getInfo().getState() == PrintJobInfo.STATE_BLOCKED;
    }

    /**
     * Gets whether this print job is completed. Such a print job
     * is successfully printed. You can neither cancel nor restart
     * such a print job.
     *
     * @return Whether the print job is completed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.288 -0400", hash_original_method = "41AED877D51F56AB121F4235E96580E7", hash_generated_method = "FAE5E8273CFAE7048C4C302C5D04574C")
    
public boolean isCompleted() {
        return getInfo().getState() == PrintJobInfo.STATE_COMPLETED;
    }

    /**
     * Gets whether this print job is failed. Such a print job is
     * not successfully printed due to an error. You can request
     * a restart via {@link #restart()} or cancel via {@link #cancel()}.
     *
     * @return Whether the print job is failed.
     *
     * @see #restart()
     * @see #cancel()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.289 -0400", hash_original_method = "22C233E770D670C358404B3FDEA9E1B4", hash_generated_method = "2EDE931280D11FEACDA82D045B8C46CC")
    
public boolean isFailed() {
        return getInfo().getState() == PrintJobInfo.STATE_FAILED;
    }

    /**
     * Gets whether this print job is cancelled. Such a print job was
     * cancelled as a result of a user request. This is a final state.
     * You cannot restart such a print job.
     *
     * @return Whether the print job is cancelled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.290 -0400", hash_original_method = "5EC14A17195390EB5D2C4083E78D410E", hash_generated_method = "A5CD27BC92246F30166293B30E841E57")
    
public boolean isCancelled() {
        return getInfo().getState() == PrintJobInfo.STATE_CANCELED;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.291 -0400", hash_original_method = "1FE1E09ED3C5F90E88CFB560FF7EF507", hash_generated_method = "FEEF49AB87EC4B24B8AB2E2F68666C42")
    
private boolean isInImmutableState() {
        final int state = mCachedInfo.getState();
        return state == PrintJobInfo.STATE_COMPLETED
                || state == PrintJobInfo.STATE_CANCELED;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.292 -0400", hash_original_method = "4FD448F86513CA3C34D2143F0A2AEA39", hash_generated_method = "04E358BEA4F7AA74E51E47B23D86AB8D")
    
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
        return mCachedInfo.getId().equals(other.mCachedInfo.getId());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.293 -0400", hash_original_method = "F8138E925779B447F857FF6B6AABBBC0", hash_generated_method = "14442763C7CFA1A1ACBBEE3A43387F6A")
    
@Override
    public int hashCode() {
        return mCachedInfo.getId().hashCode();
    }
}
