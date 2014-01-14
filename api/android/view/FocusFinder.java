package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.graphics.Rect;

public class FocusFinder {

    /**
     * Get the focus finder for this thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.077 -0500", hash_original_method = "0A266F2F30A26FB4FFDB8BE1FD52ABAB", hash_generated_method = "794ADD475B07C31945BF5DC360FCCB11")
    
public static FocusFinder getInstance() {
        return tlFocusFinder.get();
    }

    /**
     * @return The distance from the edge furthest in the given direction
     *   of source to the edge nearest in the given direction of dest.  If the
     *   dest is not in the direction from source, return 0.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.116 -0500", hash_original_method = "FEC197AB260A70050BA79E019D41C702", hash_generated_method = "C41FBCF71DE6926C60C36D0FCE75C3DA")
    
static int majorAxisDistance(int direction, Rect source, Rect dest) {
        return Math.max(0, majorAxisDistanceRaw(direction, source, dest));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.119 -0500", hash_original_method = "ABB1C6898E503A151891B7A9ABFAD773", hash_generated_method = "9A2D243C90DD6E103172E274629951BB")
    
static int majorAxisDistanceRaw(int direction, Rect source, Rect dest) {
        switch (direction) {
            case View.FOCUS_LEFT:
                return source.left - dest.right;
            case View.FOCUS_RIGHT:
                return dest.left - source.right;
            case View.FOCUS_UP:
                return source.top - dest.bottom;
            case View.FOCUS_DOWN:
                return dest.top - source.bottom;
        }
        throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    /**
     * @return The distance along the major axis w.r.t the direction from the
     *   edge of source to the far edge of dest. If the
     *   dest is not in the direction from source, return 1 (to break ties with
     *   {@link #majorAxisDistance}).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.122 -0500", hash_original_method = "CA98CAB2ECA74F2E2804BE867DBDF9E9", hash_generated_method = "394269CEE78DD20496BCFEA85A6D86B4")
    
static int majorAxisDistanceToFarEdge(int direction, Rect source, Rect dest) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(direction, source, dest));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.124 -0500", hash_original_method = "AC771A545341D8B57AB42CBFAC5A4EC8", hash_generated_method = "18B58AC0903F0B603C49979735EDB163")
    
static int majorAxisDistanceToFarEdgeRaw(int direction, Rect source, Rect dest) {
        switch (direction) {
            case View.FOCUS_LEFT:
                return source.left - dest.left;
            case View.FOCUS_RIGHT:
                return dest.right - source.right;
            case View.FOCUS_UP:
                return source.top - dest.top;
            case View.FOCUS_DOWN:
                return dest.bottom - source.bottom;
        }
        throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    /**
     * Find the distance on the minor axis w.r.t the direction to the nearest
     * edge of the destination rectange.
     * @param direction the direction (up, down, left, right)
     * @param source The source rect.
     * @param dest The destination rect.
     * @return The distance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.127 -0500", hash_original_method = "05A50C3C0DAB95FFDE6EA8B241A55A35", hash_generated_method = "520632667D7E86F01831D49C034CAE08")
    
static int minorAxisDistance(int direction, Rect source, Rect dest) {
        switch (direction) {
            case View.FOCUS_LEFT:
            case View.FOCUS_RIGHT:
                // the distance between the center verticals
                return Math.abs(
                        ((source.top + source.height() / 2) -
                        ((dest.top + dest.height() / 2))));
            case View.FOCUS_UP:
            case View.FOCUS_DOWN:
                // the distance between the center horizontals
                return Math.abs(
                        ((source.left + source.width() / 2) -
                        ((dest.left + dest.width() / 2))));
        }
        throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.091 -0400", hash_original_field = "7690E1068C76C497BCB909EC68C2FD34", hash_generated_field = "8109D1296FDD65456C25811CCC70C8C4")

    private static ThreadLocal<FocusFinder> tlFocusFinder = new ThreadLocal<FocusFinder>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.091 -0400", hash_original_method = "C8E9892D3DD456F1910EE73E67D2112F", hash_generated_method = "A8EFA4FC1CD5A204A479F53C58732CCF")
        protected FocusFinder initialValue() {
            FocusFinder varB4EAC82CA7396A68D541C85D26508E83_2045323693 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2045323693 = new FocusFinder();
            varB4EAC82CA7396A68D541C85D26508E83_2045323693.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2045323693;
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.079 -0500", hash_original_field = "AA91269DE4CB12CC630B33741200666D", hash_generated_field = "AA91269DE4CB12CC630B33741200666D")

    Rect mFocusedRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.081 -0500", hash_original_field = "A979E31795050A5EFD05BD971CC12AFB", hash_generated_field = "A979E31795050A5EFD05BD971CC12AFB")

    Rect mOtherRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.084 -0500", hash_original_field = "73C7F1C53FFF4FE5714FB238D4A42A74", hash_generated_field = "73C7F1C53FFF4FE5714FB238D4A42A74")

    Rect mBestCandidateRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.086 -0500", hash_original_field = "401485DC01C0558BEA3A0859AF94C141", hash_generated_field = "401485DC01C0558BEA3A0859AF94C141")

    SequentialFocusComparator mSequentialFocusComparator = new SequentialFocusComparator();

    // enforce thread local access
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.089 -0500", hash_original_method = "DC255E332B77A13B263C537BB61FEC63", hash_generated_method = "FC6BD4E28BCC84AAF77BDCFB9C14804F")
    
private FocusFinder() {}

    /**
     * Find the next view to take focus in root's descendants, starting from the view
     * that currently is focused.
     * @param root Contains focused
     * @param focused Has focus now.
     * @param direction Direction to look.
     * @return The next focusable view, or null if none exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.092 -0500", hash_original_method = "948D7F222DFBCB81359D4FABF0EA65D3", hash_generated_method = "1C053AFF23B801FEADA0180380E9AC2B")
    
public final View findNextFocus(ViewGroup root, View focused, int direction) {

        if (focused != null) {
            // check for user specified next focus
            View userSetNextFocus = focused.findUserSetNextFocus(root, direction);
            if (userSetNextFocus != null &&
                userSetNextFocus.isFocusable() &&
                (!userSetNextFocus.isInTouchMode() ||
                 userSetNextFocus.isFocusableInTouchMode())) {
                return userSetNextFocus;
            }

            // fill in interesting rect from focused
            focused.getFocusedRect(mFocusedRect);
            root.offsetDescendantRectToMyCoords(focused, mFocusedRect);
        } else {
            // make up a rect at top left or bottom right of root
            switch (direction) {
                case View.FOCUS_RIGHT:
                case View.FOCUS_DOWN:
                case View.FOCUS_FORWARD:
                    final int rootTop = root.getScrollY();
                    final int rootLeft = root.getScrollX();
                    mFocusedRect.set(rootLeft, rootTop, rootLeft, rootTop);
                    break;

                case View.FOCUS_LEFT:
                case View.FOCUS_UP:
                case View.FOCUS_BACKWARD:
                    final int rootBottom = root.getScrollY() + root.getHeight();
                    final int rootRight = root.getScrollX() + root.getWidth();
                    mFocusedRect.set(rootRight, rootBottom,
                            rootRight, rootBottom);
                    break;
            }
        }
        return findNextFocus(root, focused, mFocusedRect, direction);
    }

    /**
     * Find the next view to take focus in root's descendants, searching from
     * a particular rectangle in root's coordinates.
     * @param root Contains focusedRect.
     * @param focusedRect The starting point of the search.
     * @param direction Direction to look.
     * @return The next focusable view, or null if none exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.094 -0500", hash_original_method = "56193535E50A3F40F9A982269CAB09AB", hash_generated_method = "C1C767320A8926BE0D8A6C4125075685")
    
public View findNextFocusFromRect(ViewGroup root, Rect focusedRect, int direction) {
        return findNextFocus(root, null, focusedRect, direction);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.098 -0500", hash_original_method = "FE75104CAE6E392867319A5D2E1ED869", hash_generated_method = "5BDBEC81898759143FCA102B1921FA63")
    
private View findNextFocus(ViewGroup root, View focused, Rect focusedRect, int direction) {
        ArrayList<View> focusables = root.getFocusables(direction);
        if (focusables.isEmpty()) {
            // The focus cannot change.
            return null;
        }

        if (direction == View.FOCUS_FORWARD || direction == View.FOCUS_BACKWARD) {
            if (focused != null && !focusables.contains(focused)) {
                // Add the currently focused view to the list to have it sorted
                // along with the other views.
                focusables.add(focused);
            }

            try {
                // Note: This sort is stable.
                mSequentialFocusComparator.setRoot(root);
                Collections.sort(focusables, mSequentialFocusComparator);
            } finally {
                mSequentialFocusComparator.recycle();
            }

            final int count = focusables.size();
            switch (direction) {
                case View.FOCUS_FORWARD:
                    if (focused != null) {
                        int position = focusables.lastIndexOf(focused);
                        if (position >= 0 && position + 1 < count) {
                            return focusables.get(position + 1);
                        }
                    }
                    return focusables.get(0);

                case View.FOCUS_BACKWARD:
                    if (focused != null) {
                        int position = focusables.indexOf(focused);
                        if (position > 0) {
                            return focusables.get(position - 1);
                        }
                    }
                    return focusables.get(count - 1);
            }
            return null;
        }

        // initialize the best candidate to something impossible
        // (so the first plausible view will become the best choice)
        mBestCandidateRect.set(focusedRect);
        switch(direction) {
            case View.FOCUS_LEFT:
                mBestCandidateRect.offset(focusedRect.width() + 1, 0);
                break;
            case View.FOCUS_RIGHT:
                mBestCandidateRect.offset(-(focusedRect.width() + 1), 0);
                break;
            case View.FOCUS_UP:
                mBestCandidateRect.offset(0, focusedRect.height() + 1);
                break;
            case View.FOCUS_DOWN:
                mBestCandidateRect.offset(0, -(focusedRect.height() + 1));
        }

        View closest = null;

        int numFocusables = focusables.size();
        for (int i = 0; i < numFocusables; i++) {
            View focusable = focusables.get(i);

            // only interested in other non-root views
            if (focusable == focused || focusable == root) continue;

            // get visible bounds of other view in same coordinate system
            focusable.getDrawingRect(mOtherRect);
            root.offsetDescendantRectToMyCoords(focusable, mOtherRect);

            if (isBetterCandidate(direction, focusedRect, mOtherRect, mBestCandidateRect)) {
                mBestCandidateRect.set(mOtherRect);
                closest = focusable;
            }
        }
        return closest;
    }

    /**
     * Is rect1 a better candidate than rect2 for a focus search in a particular
     * direction from a source rect?  This is the core routine that determines
     * the order of focus searching.
     * @param direction the direction (up, down, left, right)
     * @param source The source we are searching from
     * @param rect1 The candidate rectangle
     * @param rect2 The current best candidate.
     * @return Whether the candidate is the new best.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.101 -0500", hash_original_method = "1A554E4FCE47CCCA17DD555DAEE432BA", hash_generated_method = "3BC6E3E02B5FDA6E0E22C4C7D76E833D")
    
boolean isBetterCandidate(int direction, Rect source, Rect rect1, Rect rect2) {

        // to be a better candidate, need to at least be a candidate in the first
        // place :)
        if (!isCandidate(source, rect1, direction)) {
            return false;
        }

        // we know that rect1 is a candidate.. if rect2 is not a candidate,
        // rect1 is better
        if (!isCandidate(source, rect2, direction)) {
            return true;
        }

        // if rect1 is better by beam, it wins
        if (beamBeats(direction, source, rect1, rect2)) {
            return true;
        }

        // if rect2 is better, then rect1 cant' be :)
        if (beamBeats(direction, source, rect2, rect1)) {
            return false;
        }

        // otherwise, do fudge-tastic comparison of the major and minor axis
        return (getWeightedDistanceFor(
                        majorAxisDistance(direction, source, rect1),
                        minorAxisDistance(direction, source, rect1))
                < getWeightedDistanceFor(
                        majorAxisDistance(direction, source, rect2),
                        minorAxisDistance(direction, source, rect2)));
    }

    /**
     * One rectangle may be another candidate than another by virtue of being
     * exclusively in the beam of the source rect.
     * @return Whether rect1 is a better candidate than rect2 by virtue of it being in src's
     *      beam
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.104 -0500", hash_original_method = "F8F20EF16F95C5B1E0CE2264EC877518", hash_generated_method = "A69A351A96146DBA41FCC8B3649180A7")
    
boolean beamBeats(int direction, Rect source, Rect rect1, Rect rect2) {
        final boolean rect1InSrcBeam = beamsOverlap(direction, source, rect1);
        final boolean rect2InSrcBeam = beamsOverlap(direction, source, rect2);

        // if rect1 isn't exclusively in the src beam, it doesn't win
        if (rect2InSrcBeam || !rect1InSrcBeam) {
            return false;
        }

        // we know rect1 is in the beam, and rect2 is not

        // if rect1 is to the direction of, and rect2 is not, rect1 wins.
        // for example, for direction left, if rect1 is to the left of the source
        // and rect2 is below, then we always prefer the in beam rect1, since rect2
        // could be reached by going down.
        if (!isToDirectionOf(direction, source, rect2)) {
            return true;
        }

        // for horizontal directions, being exclusively in beam always wins
        if ((direction == View.FOCUS_LEFT || direction == View.FOCUS_RIGHT)) {
            return true;
        }

        // for vertical directions, beams only beat up to a point:
        // now, as long as rect2 isn't completely closer, rect1 wins
        // e.g for direction down, completely closer means for rect2's top
        // edge to be closer to the source's top edge than rect1's bottom edge.
        return (majorAxisDistance(direction, source, rect1)
                < majorAxisDistanceToFarEdge(direction, source, rect2));
    }

    /**
     * Fudge-factor opportunity: how to calculate distance given major and minor
     * axis distances.  Warning: this fudge factor is finely tuned, be sure to
     * run all focus tests if you dare tweak it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.107 -0500", hash_original_method = "1AC6C27686DF7285B59CAB56ADBB9696", hash_generated_method = "1AC6C27686DF7285B59CAB56ADBB9696")
    
int getWeightedDistanceFor(int majorAxisDistance, int minorAxisDistance) {
        return 13 * majorAxisDistance * majorAxisDistance
                + minorAxisDistance * minorAxisDistance;
    }

    /**
     * Is destRect a candidate for the next focus given the direction?  This
     * checks whether the dest is at least partially to the direction of (e.g left of)
     * from source.
     *
     * Includes an edge case for an empty rect (which is used in some cases when
     * searching from a point on the screen).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.109 -0500", hash_original_method = "10315B5B788523AD56571BFBE30F6A43", hash_generated_method = "10315B5B788523AD56571BFBE30F6A43")
    
boolean isCandidate(Rect srcRect, Rect destRect, int direction) {
        switch (direction) {
            case View.FOCUS_LEFT:
                return (srcRect.right > destRect.right || srcRect.left >= destRect.right) 
                        && srcRect.left > destRect.left;
            case View.FOCUS_RIGHT:
                return (srcRect.left < destRect.left || srcRect.right <= destRect.left)
                        && srcRect.right < destRect.right;
            case View.FOCUS_UP:
                return (srcRect.bottom > destRect.bottom || srcRect.top >= destRect.bottom)
                        && srcRect.top > destRect.top;
            case View.FOCUS_DOWN:
                return (srcRect.top < destRect.top || srcRect.bottom <= destRect.top)
                        && srcRect.bottom < destRect.bottom;
        }
        throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    /**
     * Do the "beams" w.r.t the given direcition's axis of rect1 and rect2 overlap?
     * @param direction the direction (up, down, left, right)
     * @param rect1 The first rectangle
     * @param rect2 The second rectangle
     * @return whether the beams overlap
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.112 -0500", hash_original_method = "CDB9DCB11C27A9CD8A1036801B813613", hash_generated_method = "CDB9DCB11C27A9CD8A1036801B813613")
    
boolean beamsOverlap(int direction, Rect rect1, Rect rect2) {
        switch (direction) {
            case View.FOCUS_LEFT:
            case View.FOCUS_RIGHT:
                return (rect2.bottom >= rect1.top) && (rect2.top <= rect1.bottom);
            case View.FOCUS_UP:
            case View.FOCUS_DOWN:
                return (rect2.right >= rect1.left) && (rect2.left <= rect1.right);
        }
        throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    /**
     * e.g for left, is 'to left of'
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.114 -0500", hash_original_method = "0F816E844CC5CD74396FEF014D25737B", hash_generated_method = "0F816E844CC5CD74396FEF014D25737B")
    
boolean isToDirectionOf(int direction, Rect src, Rect dest) {
        switch (direction) {
            case View.FOCUS_LEFT:
                return src.left >= dest.right;
            case View.FOCUS_RIGHT:
                return src.right <= dest.left;
            case View.FOCUS_UP:
                return src.top >= dest.bottom;
            case View.FOCUS_DOWN:
                return src.bottom <= dest.top;
        }
        throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    /**
     * Find the nearest touchable view to the specified view.
     * 
     * @param root The root of the tree in which to search
     * @param x X coordinate from which to start the search
     * @param y Y coordinate from which to start the search
     * @param direction Direction to look
     * @param deltas Offset from the <x, y> to the edge of the nearest view. Note that this array
     *        may already be populated with values.
     * @return The nearest touchable view, or null if none exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.130 -0500", hash_original_method = "720FA5A94E3C004CE3F70B83E46D48C3", hash_generated_method = "2FEE2CEB69723C8302E4C3B639633353")
    
public View findNearestTouchable(ViewGroup root, int x, int y, int direction, int[] deltas) {
        ArrayList<View> touchables = root.getTouchables();
        int minDistance = Integer.MAX_VALUE;
        View closest = null;

        int numTouchables = touchables.size();
        
        int edgeSlop = ViewConfiguration.get(root.mContext).getScaledEdgeSlop();
        
        Rect closestBounds = new Rect();
        Rect touchableBounds = mOtherRect;
        
        for (int i = 0; i < numTouchables; i++) {
            View touchable = touchables.get(i);

            // get visible bounds of other view in same coordinate system
            touchable.getDrawingRect(touchableBounds);
            
            root.offsetRectBetweenParentAndChild(touchable, touchableBounds, true, true);

            if (!isTouchCandidate(x, y, touchableBounds, direction)) {
                continue;
            }

            int distance = Integer.MAX_VALUE;

            switch (direction) {
            case View.FOCUS_LEFT:
                distance = x - touchableBounds.right + 1;
                break;
            case View.FOCUS_RIGHT:
                distance = touchableBounds.left;
                break;
            case View.FOCUS_UP:
                distance = y - touchableBounds.bottom + 1;
                break;
            case View.FOCUS_DOWN:
                distance = touchableBounds.top;
                break;
            }

            if (distance < edgeSlop) {
                // Give preference to innermost views
                if (closest == null ||
                        closestBounds.contains(touchableBounds) ||
                        (!touchableBounds.contains(closestBounds) && distance < minDistance)) {
                    minDistance = distance;
                    closest = touchable;
                    closestBounds.set(touchableBounds);
                    switch (direction) {
                    case View.FOCUS_LEFT:
                        deltas[0] = -distance;
                        break;
                    case View.FOCUS_RIGHT:
                        deltas[0] = distance;
                        break;
                    case View.FOCUS_UP:
                        deltas[1] = -distance;
                        break;
                    case View.FOCUS_DOWN:
                        deltas[1] = distance;
                        break;
                    }
                }
            }
        }
        return closest;
    }
    
    private static final class SequentialFocusComparator implements Comparator<View> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.136 -0500", hash_original_field = "3B9A53D9A8D875334A2863D2219637ED", hash_generated_field = "9FC57DB4EBB3F9FD7BA1F2105DC0E4CE")

        private final Rect mFirstRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.138 -0500", hash_original_field = "7A0DF4E7697A3B9A2C73B4065F24CFD3", hash_generated_field = "6D37B6E76C0CCCF04F4EB2D92ECC6756")

        private final Rect mSecondRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.140 -0500", hash_original_field = "6708D892AB5394234BF4CBCDF78F311F", hash_generated_field = "ED9210798784460350FD46FC78F11ACF")

        private ViewGroup mRoot;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.985 -0400", hash_original_method = "0E280D788A863FD723521B8D9E30F8E5", hash_generated_method = "0E280D788A863FD723521B8D9E30F8E5")
        public SequentialFocusComparator ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.143 -0500", hash_original_method = "AE2DFC878449B0C9A87D974F16153CE8", hash_generated_method = "CCB3F2B10DB6785DAFEE246FED12BD4F")
        
public void recycle() {
            mRoot = null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.146 -0500", hash_original_method = "0BE2F634C0DBDBECCB40B3CDEBC39607", hash_generated_method = "9CCB6E319465EF38936FF10F40DDC9BC")
        
public void setRoot(ViewGroup root) {
            mRoot = root;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.149 -0500", hash_original_method = "088E9436455361AF149A244BD433F4AF", hash_generated_method = "A15C8F6DF0D5DDF654E998AFAE0BA3A9")
        
public int compare(View first, View second) {
            if (first == second) {
                return 0;
            }

            getRect(first, mFirstRect);
            getRect(second, mSecondRect);

            if (mFirstRect.top < mSecondRect.top) {
                return -1;
            } else if (mFirstRect.top > mSecondRect.top) {
                return 1;
            } else if (mFirstRect.left < mSecondRect.left) {
                return -1;
            } else if (mFirstRect.left > mSecondRect.left) {
                return 1;
            } else if (mFirstRect.bottom < mSecondRect.bottom) {
                return -1;
            } else if (mFirstRect.bottom > mSecondRect.bottom) {
                return 1;
            } else if (mFirstRect.right < mSecondRect.right) {
                return -1;
            } else if (mFirstRect.right > mSecondRect.right) {
                return 1;
            } else {
                // The view are distinct but completely coincident so we consider
                // them equal for our purposes.  Since the sort is stable, this
                // means that the views will retain their layout order relative to one another.
                return 0;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.151 -0500", hash_original_method = "CE5638677B07104C355FE3EB975CEDE8", hash_generated_method = "A75C51D7CEE240C36DDD927E32FC3BA0")
        
private void getRect(View view, Rect rect) {
            view.getDrawingRect(rect);
            mRoot.offsetDescendantRectToMyCoords(view, rect);
        }
        
    }

    /**
     * Is destRect a candidate for the next touch given the direction?
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.133 -0500", hash_original_method = "4EDA0197C585E6B2A33216D89691E993", hash_generated_method = "47998B70C2658DBDED4D069DD5945833")
    
private boolean isTouchCandidate(int x, int y, Rect destRect, int direction) {
        switch (direction) {
            case View.FOCUS_LEFT:
                return destRect.left <= x && destRect.top <= y && y <= destRect.bottom;
            case View.FOCUS_RIGHT:
                return destRect.left >= x && destRect.top <= y && y <= destRect.bottom;
            case View.FOCUS_UP:
                return destRect.top <= y && destRect.left <= x && x <= destRect.right;
            case View.FOCUS_DOWN:
                return destRect.top >= y && destRect.left <= x && x <= destRect.right;
        }
        throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }
}

