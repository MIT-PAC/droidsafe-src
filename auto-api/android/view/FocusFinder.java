package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FocusFinder {
    Rect mFocusedRect = new Rect();
    Rect mOtherRect = new Rect();
    Rect mBestCandidateRect = new Rect();
    SequentialFocusComparator mSequentialFocusComparator = new SequentialFocusComparator();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.555 -0400", hash_original_method = "DC255E332B77A13B263C537BB61FEC63", hash_generated_method = "F16241C74771068F25916AC2FC4602F5")
    @DSModeled(DSC.SAFE)
    private FocusFinder() {
        // ---------- Original Method ----------
    }

    
        public static FocusFinder getInstance() {
        return tlFocusFinder.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.556 -0400", hash_original_method = "948D7F222DFBCB81359D4FABF0EA65D3", hash_generated_method = "A38FCEFF0FF491FE249B74DA8DCBC4DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final View findNextFocus(ViewGroup root, View focused, int direction) {
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focused.dsTaint);
        {
            View userSetNextFocus;
            userSetNextFocus = focused.findUserSetNextFocus(root, direction);
            {
                boolean varE20A98AF4AC4B2C8BFD1E1D9542B7AAF_1383717258 = (userSetNextFocus != null &&
                userSetNextFocus.isFocusable() &&
                (!userSetNextFocus.isInTouchMode() ||
                 userSetNextFocus.isFocusableInTouchMode()));
            } //End collapsed parenthetic
            focused.getFocusedRect(mFocusedRect);
            root.offsetDescendantRectToMyCoords(focused, mFocusedRect);
        } //End block
        {
            //Begin case View.FOCUS_RIGHT View.FOCUS_DOWN View.FOCUS_FORWARD 
            int rootTop;
            rootTop = root.getScrollY();
            //End case View.FOCUS_RIGHT View.FOCUS_DOWN View.FOCUS_FORWARD 
            //Begin case View.FOCUS_RIGHT View.FOCUS_DOWN View.FOCUS_FORWARD 
            int rootLeft;
            rootLeft = root.getScrollX();
            //End case View.FOCUS_RIGHT View.FOCUS_DOWN View.FOCUS_FORWARD 
            //Begin case View.FOCUS_RIGHT View.FOCUS_DOWN View.FOCUS_FORWARD 
            mFocusedRect.set(rootLeft, rootTop, rootLeft, rootTop);
            //End case View.FOCUS_RIGHT View.FOCUS_DOWN View.FOCUS_FORWARD 
            //Begin case View.FOCUS_LEFT View.FOCUS_UP View.FOCUS_BACKWARD 
            int rootBottom;
            rootBottom = root.getScrollY() + root.getHeight();
            //End case View.FOCUS_LEFT View.FOCUS_UP View.FOCUS_BACKWARD 
            //Begin case View.FOCUS_LEFT View.FOCUS_UP View.FOCUS_BACKWARD 
            int rootRight;
            rootRight = root.getScrollX() + root.getWidth();
            //End case View.FOCUS_LEFT View.FOCUS_UP View.FOCUS_BACKWARD 
            //Begin case View.FOCUS_LEFT View.FOCUS_UP View.FOCUS_BACKWARD 
            mFocusedRect.set(rootRight, rootBottom,
                            rootRight, rootBottom);
            //End case View.FOCUS_LEFT View.FOCUS_UP View.FOCUS_BACKWARD 
        } //End block
        View varBACACF6AFC990ECD012B207985529686_2124006721 = (findNextFocus(root, focused, mFocusedRect, direction));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.556 -0400", hash_original_method = "56193535E50A3F40F9A982269CAB09AB", hash_generated_method = "BA16D4FC491F9EA60E33759CF00E30B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View findNextFocusFromRect(ViewGroup root, Rect focusedRect, int direction) {
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focusedRect.dsTaint);
        View varAF36D7DA71224075E9E655A13EA5D462_943115108 = (findNextFocus(root, null, focusedRect, direction));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return findNextFocus(root, null, focusedRect, direction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.557 -0400", hash_original_method = "FE75104CAE6E392867319A5D2E1ED869", hash_generated_method = "6B9D99B79B56FC4692E3211805C7D3F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View findNextFocus(ViewGroup root, View focused, Rect focusedRect, int direction) {
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focusedRect.dsTaint);
        dsTaint.addTaint(focused.dsTaint);
        ArrayList<View> focusables;
        focusables = root.getFocusables(direction);
        {
            boolean varB483D2AE7959E3CA3199EAE571F220FD_1247543491 = (focusables.isEmpty());
        } //End collapsed parenthetic
        {
            {
                boolean var558EF4A88084E812F35BB7A7E3F7A5F9_265866924 = (focused != null && !focusables.contains(focused));
                {
                    focusables.add(focused);
                } //End block
            } //End collapsed parenthetic
            try 
            {
                mSequentialFocusComparator.setRoot(root);
                Collections.sort(focusables, mSequentialFocusComparator);
            } //End block
            finally 
            {
                mSequentialFocusComparator.recycle();
            } //End block
            int count;
            count = focusables.size();
            //Begin case View.FOCUS_FORWARD 
            {
                int position;
                position = focusables.lastIndexOf(focused);
                {
                    View var2F8F466CD00AFE9DBE31FB6B7DE290CB_1760067245 = (focusables.get(position + 1));
                } //End block
            } //End block
            //End case View.FOCUS_FORWARD 
            //Begin case View.FOCUS_FORWARD 
            View var8A35AAD5E4ED5DBF6675A167E4332A1C_1940674577 = (focusables.get(0));
            //End case View.FOCUS_FORWARD 
            //Begin case View.FOCUS_BACKWARD 
            {
                int position;
                position = focusables.indexOf(focused);
                {
                    View var9BCC31F20F73C0366DBA7BABB0DCC0DE_1876641391 = (focusables.get(position - 1));
                } //End block
            } //End block
            //End case View.FOCUS_BACKWARD 
            //Begin case View.FOCUS_BACKWARD 
            View var581EB42128E926AFFE3C0A1B3A2B0E6A_876727855 = (focusables.get(count - 1));
            //End case View.FOCUS_BACKWARD 
        } //End block
        mBestCandidateRect.set(focusedRect);
        //Begin case View.FOCUS_LEFT 
        mBestCandidateRect.offset(focusedRect.width() + 1, 0);
        //End case View.FOCUS_LEFT 
        //Begin case View.FOCUS_RIGHT 
        mBestCandidateRect.offset(-(focusedRect.width() + 1), 0);
        //End case View.FOCUS_RIGHT 
        //Begin case View.FOCUS_UP 
        mBestCandidateRect.offset(0, focusedRect.height() + 1);
        //End case View.FOCUS_UP 
        //Begin case View.FOCUS_DOWN 
        mBestCandidateRect.offset(0, -(focusedRect.height() + 1));
        //End case View.FOCUS_DOWN 
        View closest;
        closest = null;
        int numFocusables;
        numFocusables = focusables.size();
        {
            int i;
            i = 0;
            {
                View focusable;
                focusable = focusables.get(i);
                focusable.getDrawingRect(mOtherRect);
                root.offsetDescendantRectToMyCoords(focusable, mOtherRect);
                {
                    boolean var205FF283201A318100F5F54A08D1A92C_862231264 = (isBetterCandidate(direction, focusedRect, mOtherRect, mBestCandidateRect));
                    {
                        mBestCandidateRect.set(mOtherRect);
                        closest = focusable;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.557 -0400", hash_original_method = "1A554E4FCE47CCCA17DD555DAEE432BA", hash_generated_method = "7C0C08435EEE4E176ED41C14A8D274A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isBetterCandidate(int direction, Rect source, Rect rect1, Rect rect2) {
        dsTaint.addTaint(rect1.dsTaint);
        dsTaint.addTaint(rect2.dsTaint);
        dsTaint.addTaint(source.dsTaint);
        dsTaint.addTaint(direction);
        {
            boolean varBC13043B37383B864D2C258B89B82F77_330732064 = (!isCandidate(source, rect1, direction));
        } //End collapsed parenthetic
        {
            boolean var6C5BBF309AB2B70AE83F611B0AEDA9F3_404788782 = (!isCandidate(source, rect2, direction));
        } //End collapsed parenthetic
        {
            boolean varCD7E7A5218518DF12DCE06E579CC94DD_849374968 = (beamBeats(direction, source, rect1, rect2));
        } //End collapsed parenthetic
        {
            boolean var39045A9398BCFD1ECF208D85EAA8B884_1416182679 = (beamBeats(direction, source, rect2, rect1));
        } //End collapsed parenthetic
        boolean varF4867C501B8142DDF7F95D81DB43C565_1764526199 = ((getWeightedDistanceFor(
                        majorAxisDistance(direction, source, rect1),
                        minorAxisDistance(direction, source, rect1))
                < getWeightedDistanceFor(
                        majorAxisDistance(direction, source, rect2),
                        minorAxisDistance(direction, source, rect2))));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!isCandidate(source, rect1, direction)) {
            //return false;
        //}
        //if (!isCandidate(source, rect2, direction)) {
            //return true;
        //}
        //if (beamBeats(direction, source, rect1, rect2)) {
            //return true;
        //}
        //if (beamBeats(direction, source, rect2, rect1)) {
            //return false;
        //}
        //return (getWeightedDistanceFor(
                        //majorAxisDistance(direction, source, rect1),
                        //minorAxisDistance(direction, source, rect1))
                //< getWeightedDistanceFor(
                        //majorAxisDistance(direction, source, rect2),
                        //minorAxisDistance(direction, source, rect2)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.558 -0400", hash_original_method = "F8F20EF16F95C5B1E0CE2264EC877518", hash_generated_method = "09CAD324AC3E749E8396297F6CA9F9DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean beamBeats(int direction, Rect source, Rect rect1, Rect rect2) {
        dsTaint.addTaint(rect1.dsTaint);
        dsTaint.addTaint(rect2.dsTaint);
        dsTaint.addTaint(source.dsTaint);
        dsTaint.addTaint(direction);
        boolean rect1InSrcBeam;
        rect1InSrcBeam = beamsOverlap(direction, source, rect1);
        boolean rect2InSrcBeam;
        rect2InSrcBeam = beamsOverlap(direction, source, rect2);
        {
            boolean var4F9C113203295E38B72887EB6CD3C2AD_635230895 = (!isToDirectionOf(direction, source, rect2));
        } //End collapsed parenthetic
        boolean varE1D0C65B59C100612AC55BAB0AC3D40F_605255268 = ((majorAxisDistance(direction, source, rect1)
                < majorAxisDistanceToFarEdge(direction, source, rect2)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final boolean rect1InSrcBeam = beamsOverlap(direction, source, rect1);
        //final boolean rect2InSrcBeam = beamsOverlap(direction, source, rect2);
        //if (rect2InSrcBeam || !rect1InSrcBeam) {
            //return false;
        //}
        //if (!isToDirectionOf(direction, source, rect2)) {
            //return true;
        //}
        //if ((direction == View.FOCUS_LEFT || direction == View.FOCUS_RIGHT)) {
            //return true;
        //}
        //return (majorAxisDistance(direction, source, rect1)
                //< majorAxisDistanceToFarEdge(direction, source, rect2));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.558 -0400", hash_original_method = "1AC6C27686DF7285B59CAB56ADBB9696", hash_generated_method = "A20351921DBB32F73B41A794CC2ED0D1")
    @DSModeled(DSC.SAFE)
     int getWeightedDistanceFor(int majorAxisDistance, int minorAxisDistance) {
        dsTaint.addTaint(majorAxisDistance);
        dsTaint.addTaint(minorAxisDistance);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 13 * majorAxisDistance * majorAxisDistance
                //+ minorAxisDistance * minorAxisDistance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.559 -0400", hash_original_method = "10315B5B788523AD56571BFBE30F6A43", hash_generated_method = "14DD047AE76328503B35BC8DC5A913D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isCandidate(Rect srcRect, Rect destRect, int direction) {
        dsTaint.addTaint(destRect.dsTaint);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(srcRect.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.562 -0400", hash_original_method = "CDB9DCB11C27A9CD8A1036801B813613", hash_generated_method = "3E1C6BA3D59F5369FA422E96B9047C2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean beamsOverlap(int direction, Rect rect1, Rect rect2) {
        dsTaint.addTaint(rect1.dsTaint);
        dsTaint.addTaint(rect2.dsTaint);
        dsTaint.addTaint(direction);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //switch (direction) {
            //case View.FOCUS_LEFT:
            //case View.FOCUS_RIGHT:
                //return (rect2.bottom >= rect1.top) && (rect2.top <= rect1.bottom);
            //case View.FOCUS_UP:
            //case View.FOCUS_DOWN:
                //return (rect2.right >= rect1.left) && (rect2.left <= rect1.right);
        //}
        //throw new IllegalArgumentException("direction must be one of "
                //+ "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.563 -0400", hash_original_method = "0F816E844CC5CD74396FEF014D25737B", hash_generated_method = "F2D31CDC149A6F2A3C454B17D7A785E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isToDirectionOf(int direction, Rect src, Rect dest) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(src.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //switch (direction) {
            //case View.FOCUS_LEFT:
                //return src.left >= dest.right;
            //case View.FOCUS_RIGHT:
                //return src.right <= dest.left;
            //case View.FOCUS_UP:
                //return src.top >= dest.bottom;
            //case View.FOCUS_DOWN:
                //return src.bottom <= dest.top;
        //}
        //throw new IllegalArgumentException("direction must be one of "
                //+ "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    
        static int majorAxisDistance(int direction, Rect source, Rect dest) {
        return Math.max(0, majorAxisDistanceRaw(direction, source, dest));
    }

    
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

    
        static int majorAxisDistanceToFarEdge(int direction, Rect source, Rect dest) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(direction, source, dest));
    }

    
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

    
        static int minorAxisDistance(int direction, Rect source, Rect dest) {
        switch (direction) {
            case View.FOCUS_LEFT:
            case View.FOCUS_RIGHT:
                return Math.abs(
                        ((source.top + source.height() / 2) -
                        ((dest.top + dest.height() / 2))));
            case View.FOCUS_UP:
            case View.FOCUS_DOWN:
                return Math.abs(
                        ((source.left + source.width() / 2) -
                        ((dest.left + dest.width() / 2))));
        }
        throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.564 -0400", hash_original_method = "720FA5A94E3C004CE3F70B83E46D48C3", hash_generated_method = "98172D0F379CAC998185608E1282A97A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View findNearestTouchable(ViewGroup root, int x, int y, int direction, int[] deltas) {
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(deltas[0]);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        ArrayList<View> touchables;
        touchables = root.getTouchables();
        int minDistance;
        minDistance = Integer.MAX_VALUE;
        View closest;
        closest = null;
        int numTouchables;
        numTouchables = touchables.size();
        int edgeSlop;
        edgeSlop = ViewConfiguration.get(root.mContext).getScaledEdgeSlop();
        Rect closestBounds;
        closestBounds = new Rect();
        Rect touchableBounds;
        touchableBounds = mOtherRect;
        {
            int i;
            i = 0;
            {
                View touchable;
                touchable = touchables.get(i);
                touchable.getDrawingRect(touchableBounds);
                root.offsetRectBetweenParentAndChild(touchable, touchableBounds, true, true);
                {
                    boolean var466CDCB1A655259E8B3D77CB3104058B_479950508 = (!isTouchCandidate(x, y, touchableBounds, direction));
                } //End collapsed parenthetic
                int distance;
                distance = Integer.MAX_VALUE;
                //Begin case View.FOCUS_LEFT 
                distance = x - touchableBounds.right + 1;
                //End case View.FOCUS_LEFT 
                //Begin case View.FOCUS_RIGHT 
                distance = touchableBounds.left;
                //End case View.FOCUS_RIGHT 
                //Begin case View.FOCUS_UP 
                distance = y - touchableBounds.bottom + 1;
                //End case View.FOCUS_UP 
                //Begin case View.FOCUS_DOWN 
                distance = touchableBounds.top;
                //End case View.FOCUS_DOWN 
                {
                    {
                        boolean varBBAD419F16A98306582B67970B1FD0F6_588314553 = (closest == null ||
                        closestBounds.contains(touchableBounds) ||
                        (!touchableBounds.contains(closestBounds) && distance < minDistance));
                        {
                            minDistance = distance;
                            closest = touchable;
                            closestBounds.set(touchableBounds);
                            //Begin case View.FOCUS_LEFT 
                            deltas[0] = -distance;
                            //End case View.FOCUS_LEFT 
                            //Begin case View.FOCUS_RIGHT 
                            deltas[0] = distance;
                            //End case View.FOCUS_RIGHT 
                            //Begin case View.FOCUS_UP 
                            deltas[1] = -distance;
                            //End case View.FOCUS_UP 
                            //Begin case View.FOCUS_DOWN 
                            deltas[1] = distance;
                            //End case View.FOCUS_DOWN 
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.565 -0400", hash_original_method = "4EDA0197C585E6B2A33216D89691E993", hash_generated_method = "7142C4A292A89F01FEC2294875FC206F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isTouchCandidate(int x, int y, Rect destRect, int direction) {
        dsTaint.addTaint(destRect.dsTaint);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //switch (direction) {
            //case View.FOCUS_LEFT:
                //return destRect.left <= x && destRect.top <= y && y <= destRect.bottom;
            //case View.FOCUS_RIGHT:
                //return destRect.left >= x && destRect.top <= y && y <= destRect.bottom;
            //case View.FOCUS_UP:
                //return destRect.top <= y && destRect.left <= x && x <= destRect.right;
            //case View.FOCUS_DOWN:
                //return destRect.top >= y && destRect.left <= x && x <= destRect.right;
        //}
        //throw new IllegalArgumentException("direction must be one of "
                //+ "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    
    private static final class SequentialFocusComparator implements Comparator<View> {
        private Rect mFirstRect = new Rect();
        private Rect mSecondRect = new Rect();
        private ViewGroup mRoot;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.565 -0400", hash_original_method = "E7A5EE629E587E0FC389F3960BE24D94", hash_generated_method = "E7A5EE629E587E0FC389F3960BE24D94")
                public SequentialFocusComparator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.565 -0400", hash_original_method = "AE2DFC878449B0C9A87D974F16153CE8", hash_generated_method = "A8E4B594B1FA8FD9961783DE571544DE")
        @DSModeled(DSC.SAFE)
        public void recycle() {
            mRoot = null;
            // ---------- Original Method ----------
            //mRoot = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.567 -0400", hash_original_method = "0BE2F634C0DBDBECCB40B3CDEBC39607", hash_generated_method = "C23321B26E2797842B3DF819DE4D94FC")
        @DSModeled(DSC.SAFE)
        public void setRoot(ViewGroup root) {
            dsTaint.addTaint(root.dsTaint);
            // ---------- Original Method ----------
            //mRoot = root;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.567 -0400", hash_original_method = "088E9436455361AF149A244BD433F4AF", hash_generated_method = "3D2E0BB72BF61A2C162264F80A159940")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int compare(View first, View second) {
            dsTaint.addTaint(second.dsTaint);
            dsTaint.addTaint(first.dsTaint);
            getRect(first, mFirstRect);
            getRect(second, mSecondRect);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.567 -0400", hash_original_method = "CE5638677B07104C355FE3EB975CEDE8", hash_generated_method = "47BA388644732635366976239F46F6EE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void getRect(View view, Rect rect) {
            dsTaint.addTaint(view.dsTaint);
            dsTaint.addTaint(rect.dsTaint);
            view.getDrawingRect(rect);
            mRoot.offsetDescendantRectToMyCoords(view, rect);
            // ---------- Original Method ----------
            //view.getDrawingRect(rect);
            //mRoot.offsetDescendantRectToMyCoords(view, rect);
        }

        
    }


    
    private static ThreadLocal<FocusFinder> tlFocusFinder = new ThreadLocal<FocusFinder>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.567 -0400", hash_original_method = "C8E9892D3DD456F1910EE73E67D2112F", hash_generated_method = "CA036BA4F26C3DDE7BA3B337831420D6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected FocusFinder initialValue() {
            FocusFinder var3B0AAE04F237F9820BE509A46DDB6906_1746573530 = (new FocusFinder());
            return (FocusFinder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new FocusFinder();
        }

        
}; //Transformed anonymous class
}

