package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class IntRangeManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.591 -0500", hash_original_field = "424DA09941B427078B77E1C5B651D6D1", hash_generated_field = "755EBFB204022DB38615C127DE53EE61")

    private static final int INITIAL_CLIENTS_ARRAY_SIZE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.647 -0500", hash_original_field = "DA7F6BB46067E5940DD062695FF3745C", hash_generated_field = "E43FB0C78759432184E49407A51B5267")

    private ArrayList<IntRange> mRanges = new ArrayList<IntRange>();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.650 -0500", hash_original_method = "362FA502CCB486C4D0A9F66987CBC492", hash_generated_method = "B41342CA1903927E4B1C4E6DFD5B5AB9")
    
protected IntRangeManager() {}

    /**
     * Enable a range for the specified client and update ranges
     * if necessary. If {@link #finishUpdate} returns failure,
     * false is returned and the range is not added.
     *
     * @param startId the first id included in the range
     * @param endId the last id included in the range
     * @param client the client requesting the enabled range
     * @return true if successful, false otherwise
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.657 -0500", hash_original_method = "6ED59671D51F9C9BA7262BED5BB50C74", hash_generated_method = "D914C78F1D3000FFA3A5A9EC9CB7022D")
    
public synchronized boolean enableRange(int startId, int endId, String client) {
        int len = mRanges.size();

        // empty range list: add the initial IntRange
        if (len == 0) {
            if (tryAddSingleRange(startId, endId, true)) {
                mRanges.add(new IntRange(startId, endId, client));
                return true;
            } else {
                return false;   // failed to update radio
            }
        }

        for (int startIndex = 0; startIndex < len; startIndex++) {
            IntRange range = mRanges.get(startIndex);
            if (startId < range.startId) {
                // test if new range completely precedes this range
                // note that [1, 4] and [5, 6] coalesce to [1, 6]
                if ((endId + 1) < range.startId) {
                    // insert new int range before previous first range
                    if (tryAddSingleRange(startId, endId, true)) {
                        mRanges.add(startIndex, new IntRange(startId, endId, client));
                        return true;
                    } else {
                        return false;   // failed to update radio
                    }
                } else if (endId <= range.endId) {
                    // extend the start of this range
                    if (tryAddSingleRange(startId, range.startId - 1, true)) {
                        range.startId = startId;
                        range.clients.add(0, new ClientRange(startId, endId, client));
                        return true;
                    } else {
                        return false;   // failed to update radio
                    }
                } else {
                    // find last range that can coalesce into the new combined range
                    for (int endIndex = startIndex+1; endIndex < len; endIndex++) {
                        IntRange endRange = mRanges.get(endIndex);
                        if ((endId + 1) < endRange.startId) {
                            // try to add entire new range
                            if (tryAddSingleRange(startId, endId, true)) {
                                range.startId = startId;
                                range.endId = endId;
                                // insert new ClientRange before existing ranges
                                range.clients.add(0, new ClientRange(startId, endId, client));
                                // coalesce range with following ranges up to endIndex-1
                                // remove each range after adding its elements, so the index
                                // of the next range to join is always startIndex+1.
                                // i is the index if no elements were removed: we only care
                                // about the number of loop iterations, not the value of i.
                                int joinIndex = startIndex + 1;
                                for (int i = joinIndex; i < endIndex; i++) {
                                    IntRange joinRange = mRanges.get(joinIndex);
                                    range.clients.addAll(joinRange.clients);
                                    mRanges.remove(joinRange);
                                }
                                return true;
                            } else {
                                return false;   // failed to update radio
                            }
                        } else if (endId <= endRange.endId) {
                            // add range from start id to start of last overlapping range,
                            // values from endRange.startId to endId are already enabled
                            if (tryAddSingleRange(startId, endRange.startId - 1, true)) {
                                range.startId = startId;
                                range.endId = endRange.endId;
                                // insert new ClientRange before existing ranges
                                range.clients.add(0, new ClientRange(startId, endId, client));
                                // coalesce range with following ranges up to endIndex
                                // remove each range after adding its elements, so the index
                                // of the next range to join is always startIndex+1.
                                // i is the index if no elements were removed: we only care
                                // about the number of loop iterations, not the value of i.
                                int joinIndex = startIndex + 1;
                                for (int i = joinIndex; i <= endIndex; i++) {
                                    IntRange joinRange = mRanges.get(joinIndex);
                                    range.clients.addAll(joinRange.clients);
                                    mRanges.remove(joinRange);
                                }
                                return true;
                            } else {
                                return false;   // failed to update radio
                            }
                        }
                    }

                    // endId extends past all existing IntRanges: combine them all together
                    if (tryAddSingleRange(startId, endId, true)) {
                        range.startId = startId;
                        range.endId = endId;
                        // insert new ClientRange before existing ranges
                        range.clients.add(0, new ClientRange(startId, endId, client));
                        // coalesce range with following ranges up to len-1
                        // remove each range after adding its elements, so the index
                        // of the next range to join is always startIndex+1.
                        // i is the index if no elements were removed: we only care
                        // about the number of loop iterations, not the value of i.
                        int joinIndex = startIndex + 1;
                        for (int i = joinIndex; i < len; i++) {
                            IntRange joinRange = mRanges.get(joinIndex);
                            range.clients.addAll(joinRange.clients);
                            mRanges.remove(joinRange);
                        }
                        return true;
                    } else {
                        return false;   // failed to update radio
                    }
                }
            } else if ((startId + 1) <= range.endId) {
                if (endId <= range.endId) {
                    // completely contained in existing range; no radio changes
                    range.insert(new ClientRange(startId, endId, client));
                    return true;
                } else {
                    // find last range that can coalesce into the new combined range
                    int endIndex = startIndex;
                    for (int testIndex = startIndex+1; testIndex < len; testIndex++) {
                        IntRange testRange = mRanges.get(testIndex);
                        if ((endId + 1) < testRange.startId) {
                            break;
                        } else {
                            endIndex = testIndex;
                        }
                    }
                    // no adjacent IntRanges to combine
                    if (endIndex == startIndex) {
                        // add range from range.endId+1 to endId,
                        // values from startId to range.endId are already enabled
                        if (tryAddSingleRange(range.endId + 1, endId, true)) {
                            range.endId = endId;
                            range.insert(new ClientRange(startId, endId, client));
                            return true;
                        } else {
                            return false;   // failed to update radio
                        }
                    }
                    // get last range to coalesce into start range
                    IntRange endRange = mRanges.get(endIndex);
                    // Values from startId to range.endId have already been enabled.
                    // if endId > endRange.endId, then enable range from range.endId+1 to endId,
                    // else enable range from range.endId+1 to endRange.startId-1, because
                    // values from endRange.startId to endId have already been added.
                    int newRangeEndId = (endId <= endRange.endId) ? endRange.startId - 1 : endId;
                    if (tryAddSingleRange(range.endId + 1, newRangeEndId, true)) {
                        range.endId = endId;
                        // insert new ClientRange in place
                        range.insert(new ClientRange(startId, endId, client));
                        // coalesce range with following ranges up to endIndex-1
                        // remove each range after adding its elements, so the index
                        // of the next range to join is always startIndex+1 (joinIndex).
                        // i is the index if no elements had been removed: we only care
                        // about the number of loop iterations, not the value of i.
                        int joinIndex = startIndex + 1;
                        for (int i = joinIndex; i < endIndex; i++) {
                            IntRange joinRange = mRanges.get(joinIndex);
                            range.clients.addAll(joinRange.clients);
                            mRanges.remove(joinRange);
                        }
                        return true;
                    } else {
                        return false;   // failed to update radio
                    }
                }
            }
        }

        // append new range after existing IntRanges
        if (tryAddSingleRange(startId, endId, true)) {
            mRanges.add(new IntRange(startId, endId, client));
            return true;
        } else {
            return false;   // failed to update radio
        }
    }

    /**
     * Disable a range for the specified client and update ranges
     * if necessary. If {@link #finishUpdate} returns failure,
     * false is returned and the range is not removed.
     *
     * @param startId the first id included in the range
     * @param endId the last id included in the range
     * @param client the client requesting to disable the range
     * @return true if successful, false otherwise
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.663 -0500", hash_original_method = "3E9B5A2BDD46323741EF7C361F65FFEC", hash_generated_method = "1F60D8A5ED2F45A9A9BCDB5D9DDF2ECB")
    
public synchronized boolean disableRange(int startId, int endId, String client) {
        int len = mRanges.size();

        for (int i=0; i < len; i++) {
            IntRange range = mRanges.get(i);
            if (startId < range.startId) {
                return false;   // not found
            } else if (endId <= range.endId) {
                // found the IntRange that encloses the client range, if any
                // search for it in the clients list
                ArrayList<ClientRange> clients = range.clients;

                // handle common case of IntRange containing one ClientRange
                int crLength = clients.size();
                if (crLength == 1) {
                    ClientRange cr = clients.get(0);
                    if (cr.startId == startId && cr.endId == endId && cr.client.equals(client)) {
                        // disable range in radio then remove the entire IntRange
                        if (tryAddSingleRange(startId, endId, false)) {
                            mRanges.remove(i);
                            return true;
                        } else {
                            return false;   // failed to update radio
                        }
                    } else {
                        return false;   // not found
                    }
                }

                // several ClientRanges: remove one, potentially splitting into many IntRanges.
                // Save the original start and end id for the original IntRange
                // in case the radio update fails and we have to revert it. If the
                // update succeeds, we remove the client range and insert the new IntRanges.
                int largestEndId = Integer.MIN_VALUE;  // largest end identifier found
                boolean updateStarted = false;

                for (int crIndex=0; crIndex < crLength; crIndex++) {
                    ClientRange cr = clients.get(crIndex);
                    if (cr.startId == startId && cr.endId == endId && cr.client.equals(client)) {
                        // found the ClientRange to remove, check if it's the last in the list
                        if (crIndex == crLength - 1) {
                            if (range.endId == largestEndId) {
                                // no channels to remove from radio; return success
                                clients.remove(crIndex);
                                return true;
                            } else {
                                // disable the channels at the end and lower the end id
                                if (tryAddSingleRange(largestEndId + 1, range.endId, false)) {
                                    clients.remove(crIndex);
                                    range.endId = largestEndId;
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                        }

                        // copy the IntRange so that we can remove elements and modify the
                        // start and end id's in the copy, leaving the original unmodified
                        // until after the radio update succeeds
                        IntRange rangeCopy = new IntRange(range, crIndex);

                        if (crIndex == 0) {
                            // removing the first ClientRange, so we may need to increase
                            // the start id of the IntRange.
                            // We know there are at least two ClientRanges in the list,
                            // so clients.get(1) should always succeed.
                            int nextStartId = clients.get(1).startId;
                            if (nextStartId != range.startId) {
                                startUpdate();
                                updateStarted = true;
                                addRange(range.startId, nextStartId - 1, false);
                                rangeCopy.startId = nextStartId;
                            }
                            // init largestEndId
                            largestEndId = clients.get(1).endId;
                        }

                        // go through remaining ClientRanges, creating new IntRanges when
                        // there is a gap in the sequence. After radio update succeeds,
                        // remove the original IntRange and append newRanges to mRanges.
                        // Otherwise, leave the original IntRange in mRanges and return false.
                        ArrayList<IntRange> newRanges = new ArrayList<IntRange>();

                        IntRange currentRange = rangeCopy;
                        for (int nextIndex = crIndex + 1; nextIndex < crLength; nextIndex++) {
                            ClientRange nextCr = clients.get(nextIndex);
                            if (nextCr.startId > largestEndId + 1) {
                                if (!updateStarted) {
                                    startUpdate();
                                    updateStarted = true;
                                }
                                addRange(largestEndId + 1, nextCr.startId - 1, false);
                                currentRange.endId = largestEndId;
                                newRanges.add(currentRange);
                                currentRange = new IntRange(nextCr);
                            } else {
                                currentRange.clients.add(nextCr);
                            }
                            if (nextCr.endId > largestEndId) {
                                largestEndId = nextCr.endId;
                            }
                        }

                        // remove any channels between largestEndId and endId
                        if (largestEndId < endId) {
                            if (!updateStarted) {
                                startUpdate();
                                updateStarted = true;
                            }
                            addRange(largestEndId + 1, endId, false);
                            currentRange.endId = largestEndId;
                        }
                        newRanges.add(currentRange);

                        if (updateStarted && !finishUpdate()) {
                            return false;   // failed to update radio
                        }

                        // replace the original IntRange with newRanges
                        mRanges.remove(i);
                        mRanges.addAll(i, newRanges);
                        return true;
                    } else {
                        // not the ClientRange to remove; save highest end ID seen so far
                        if (cr.endId > largestEndId) {
                            largestEndId = cr.endId;
                        }
                    }
                }
            }
        }

        return false;   // not found
    }

    /**
     * Perform a complete update operation (enable all ranges). Useful
     * after a radio reset. Calls {@link #startUpdate}, followed by zero or
     * more calls to {@link #addRange}, followed by {@link #finishUpdate}.
     * @return true if successful, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.672 -0500", hash_original_method = "6D2ABBA8943E817B6A7F4354584C0478", hash_generated_method = "25B01AFFB5A09D9A62F42C50C23FB56F")
    
public boolean updateRanges() {
        startUpdate();
        Iterator<IntRange> iterator = mRanges.iterator();
        if (iterator.hasNext()) {
            IntRange range = iterator.next();
            int start = range.startId;
            int end = range.endId;
            // accumulate ranges of [startId, endId]
            while (iterator.hasNext()) {
                IntRange nextNode = iterator.next();
                // [startIdA, endIdA], [endIdA + 1, endIdB] -> [startIdA, endIdB]
                if (nextNode.startId <= (end + 1)) {
                    if (nextNode.endId > end) {
                        end = nextNode.endId;
                    }
                } else {
                    addRange(start, end, true);
                    start = nextNode.startId;
                    end = nextNode.endId;
                }
            }
            // add final range
            addRange(start, end, true);
        }
        return finishUpdate();
    }

    /**
     * Enable or disable a single range of message identifiers.
     * @param startId the first id included in the range
     * @param endId the last id included in the range
     * @param selected true to enable range, false to disable range
     * @return true if successful, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.675 -0500", hash_original_method = "66D9B78BD0A6572F2D23304F41F243DE", hash_generated_method = "F458D0A984C1D2137808AB1EA3DDEA68")
    
private boolean tryAddSingleRange(int startId, int endId, boolean selected) {
        startUpdate();
        addRange(startId, endId, selected);
        return finishUpdate();
    }

    /**
     * Returns whether the list of ranges is completely empty.
     * @return true if there are no enabled ranges
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.677 -0500", hash_original_method = "3535E42AC2A5B7497897BAD158CB88AF", hash_generated_method = "B948E6FAB4BE4D2FE2FB2AB8D0C9B61A")
    
public boolean isEmpty() {
        return mRanges.isEmpty();
    }

    /**
     * Called when the list of enabled ranges has changed. This will be
     * followed by zero or more calls to {@link #addRange} followed by
     * a call to {@link #finishUpdate}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.681 -0500", hash_original_method = "FCF51CD311107A31FE3B2EFC0793E843", hash_generated_method = "0C123BC9261889849152F9859E89C9E9")
    
protected abstract void startUpdate();

    /**
     * Called after {@link #startUpdate} to indicate a range of enabled
     * or disabled values.
     *
     * @param startId the first id included in the range
     * @param endId the last id included in the range
     * @param selected true to enable range, false to disable range
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.683 -0500", hash_original_method = "F3A93B80CF184574F1C80995545F3790", hash_generated_method = "0ED64598EA827C0BEDDFD4FA8733DA59")
    
protected abstract void addRange(int startId, int endId, boolean selected);
    
    private class IntRange {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.594 -0500", hash_original_field = "B575BF041CFA248D715BE93778A966DC", hash_generated_field = "B575BF041CFA248D715BE93778A966DC")

        int startId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.597 -0500", hash_original_field = "D469E1326C7C274FD4D56F815E4A1D73", hash_generated_field = "D469E1326C7C274FD4D56F815E4A1D73")

        int endId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.601 -0500", hash_original_field = "DD30F90F1DFDA1050591F66AD1E9CE7F", hash_generated_field = "DD30F90F1DFDA1050591F66AD1E9CE7F")

         ArrayList<ClientRange> clients;

        /**
         * Create a new IntRange with a single client.
         * @param startId the first id included in the range
         * @param endId the last id included in the range
         * @param client the client requesting the enabled range
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.604 -0500", hash_original_method = "F07B82A28B52231FBB76629ABCB97069", hash_generated_method = "F07B82A28B52231FBB76629ABCB97069")
        
IntRange(int startId, int endId, String client) {
            this.startId = startId;
            this.endId = endId;
            clients = new ArrayList<ClientRange>(INITIAL_CLIENTS_ARRAY_SIZE);
            clients.add(new ClientRange(startId, endId, client));
        }

        /**
         * Create a new IntRange for an existing ClientRange.
         * @param clientRange the initial ClientRange to add
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.607 -0500", hash_original_method = "BA7832996744AA8092A9A5E21086E160", hash_generated_method = "BA7832996744AA8092A9A5E21086E160")
        
IntRange(ClientRange clientRange) {
            startId = clientRange.startId;
            endId = clientRange.endId;
            clients = new ArrayList<ClientRange>(INITIAL_CLIENTS_ARRAY_SIZE);
            clients.add(clientRange);
        }

        /**
         * Create a new IntRange from an existing IntRange. This is used for
         * removing a ClientRange, because new IntRanges may need to be created
         * for any gaps that open up after the ClientRange is removed. A copy
         * is made of the elements of the original IntRange preceding the element
         * that is being removed. The following elements will be added to this
         * IntRange or to a new IntRange when a gap is found.
         * @param intRange the original IntRange to copy elements from
         * @param numElements the number of elements to copy from the original
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.609 -0500", hash_original_method = "A2EC39EA4DD73652B403D173FB1236C3", hash_generated_method = "A2EC39EA4DD73652B403D173FB1236C3")
        
IntRange(IntRange intRange, int numElements) {
            this.startId = intRange.startId;
            this.endId = intRange.endId;
            this.clients = new ArrayList<ClientRange>(intRange.clients.size());
            for (int i=0; i < numElements; i++) {
                this.clients.add(intRange.clients.get(i));
            }
        }

        /**
         * Insert new ClientRange in order by start id.
         * <p>If the new ClientRange is known to be sorted before or after the
         * existing ClientRanges, or at a particular index, it can be added
         * to the clients array list directly, instead of via this method.
         * <p>Note that this can be changed from linear to binary search if the
         * number of clients grows large enough that it would make a difference.
         * @param range the new ClientRange to insert
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.612 -0500", hash_original_method = "5E2FBB55D30010C4D5AE540EBBAC773C", hash_generated_method = "05663A8D6F45CCD39EBF87C099356AE4")
        
void insert(ClientRange range) {
            int len = clients.size();
            for (int i=0; i < len; i++) {
                ClientRange nextRange = clients.get(i);
                if (range.startId <= nextRange.startId) {
                    // ignore duplicate ranges from the same client
                    if (!range.equals(nextRange)) {
                        clients.add(i, range);
                    }
                    return;
                }
            }
            clients.add(range);    // append to end of list
        }
        
    }
    
    private class ClientRange {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.625 -0500", hash_original_field = "B575BF041CFA248D715BE93778A966DC", hash_generated_field = "B575BF041CFA248D715BE93778A966DC")

         int startId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.628 -0500", hash_original_field = "D469E1326C7C274FD4D56F815E4A1D73", hash_generated_field = "D469E1326C7C274FD4D56F815E4A1D73")

         int endId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.631 -0500", hash_original_field = "B53CFB15BD6573E83D2588E535C40087", hash_generated_field = "B53CFB15BD6573E83D2588E535C40087")

         String client;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.635 -0500", hash_original_method = "0233CEEC110E7548B64806A81A8747BD", hash_generated_method = "0233CEEC110E7548B64806A81A8747BD")
        
ClientRange(int startId, int endId, String client) {
            this.startId = startId;
            this.endId = endId;
            this.client = client;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.639 -0500", hash_original_method = "1032526D9DAEE515FA8C17531DBF15E9", hash_generated_method = "16202EE818EC4DDF9F149B854F56C5E2")
        
@Override
        public boolean equals(Object o) {
            if (o != null && o instanceof ClientRange) {
                ClientRange other = (ClientRange) o;
                return startId == other.startId &&
                        endId == other.endId &&
                        client.equals(other.client);
            } else {
                return false;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.642 -0500", hash_original_method = "0C827ECC35335C49789EB5A12C0D3470", hash_generated_method = "06036D7E4EDE321F05B46CD2CA11EBC2")
        
@Override
        public int hashCode() {
            return (startId * 31 + endId) * 31 + client.hashCode();
        }
        
    }

    /**
     * Called to indicate the end of a range update started by the
     * previous call to {@link #startUpdate}.
     * @return true if successful, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.686 -0500", hash_original_method = "6F392A19DED1FB567010348872D79562", hash_generated_method = "8FEEA1381A8EBB4860023AB8FE45AAC7")
    
protected abstract boolean finishUpdate();
}

