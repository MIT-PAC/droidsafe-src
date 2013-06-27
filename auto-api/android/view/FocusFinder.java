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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.008 -0400", hash_original_field = "27595994279845FC545647F94FEFBC2A", hash_generated_field = "AA91269DE4CB12CC630B33741200666D")

    Rect mFocusedRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.008 -0400", hash_original_field = "7346218ADC4B97C5EED5BBCE304A9379", hash_generated_field = "A979E31795050A5EFD05BD971CC12AFB")

    Rect mOtherRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.009 -0400", hash_original_field = "A95262C4CAD591528E377657B34CEEF2", hash_generated_field = "73C7F1C53FFF4FE5714FB238D4A42A74")

    Rect mBestCandidateRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.009 -0400", hash_original_field = "92246F2C656C46A09BF795AE99B4A488", hash_generated_field = "401485DC01C0558BEA3A0859AF94C141")

    SequentialFocusComparator mSequentialFocusComparator = new SequentialFocusComparator();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.009 -0400", hash_original_method = "DC255E332B77A13B263C537BB61FEC63", hash_generated_method = "F16241C74771068F25916AC2FC4602F5")
    private  FocusFinder() {
        // ---------- Original Method ----------
    }

    
        public static FocusFinder getInstance() {
        return tlFocusFinder.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.010 -0400", hash_original_method = "948D7F222DFBCB81359D4FABF0EA65D3", hash_generated_method = "6EAD7188F61C6BD47EE2E653296E6EED")
    public final View findNextFocus(ViewGroup root, View focused, int direction) {
        View varB4EAC82CA7396A68D541C85D26508E83_1873085649 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_33268381 = null; //Variable for return #2
        {
            View userSetNextFocus;
            userSetNextFocus = focused.findUserSetNextFocus(root, direction);
            {
                boolean varE20A98AF4AC4B2C8BFD1E1D9542B7AAF_443565145 = (userSetNextFocus != null &&
                userSetNextFocus.isFocusable() &&
                (!userSetNextFocus.isInTouchMode() ||
                 userSetNextFocus.isFocusableInTouchMode()));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1873085649 = userSetNextFocus;
                } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_33268381 = findNextFocus(root, focused, mFocusedRect, direction);
        addTaint(root.getTaint());
        addTaint(focused.getTaint());
        addTaint(direction);
        View varA7E53CE21691AB073D9660D615818899_459053833; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_459053833 = varB4EAC82CA7396A68D541C85D26508E83_1873085649;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_459053833 = varB4EAC82CA7396A68D541C85D26508E83_33268381;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_459053833.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_459053833;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.014 -0400", hash_original_method = "56193535E50A3F40F9A982269CAB09AB", hash_generated_method = "82871B9ECDC8D2B0A0770169B6D20890")
    public View findNextFocusFromRect(ViewGroup root, Rect focusedRect, int direction) {
        View varB4EAC82CA7396A68D541C85D26508E83_1245559258 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1245559258 = findNextFocus(root, null, focusedRect, direction);
        addTaint(root.getTaint());
        addTaint(focusedRect.getTaint());
        addTaint(direction);
        varB4EAC82CA7396A68D541C85D26508E83_1245559258.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1245559258;
        // ---------- Original Method ----------
        //return findNextFocus(root, null, focusedRect, direction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.036 -0400", hash_original_method = "FE75104CAE6E392867319A5D2E1ED869", hash_generated_method = "DD1A3A2EECE4E73957D0E3B177B0FA4A")
    private View findNextFocus(ViewGroup root, View focused, Rect focusedRect, int direction) {
        View varB4EAC82CA7396A68D541C85D26508E83_936463967 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1417582781 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_183657922 = null; //Variable for return #3
        View varB4EAC82CA7396A68D541C85D26508E83_380166144 = null; //Variable for return #4
        View varB4EAC82CA7396A68D541C85D26508E83_1843885250 = null; //Variable for return #5
        View varB4EAC82CA7396A68D541C85D26508E83_57304893 = null; //Variable for return #6
        View varB4EAC82CA7396A68D541C85D26508E83_1204459830 = null; //Variable for return #7
        ArrayList<View> focusables;
        focusables = root.getFocusables(direction);
        {
            boolean varB483D2AE7959E3CA3199EAE571F220FD_148108424 = (focusables.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_936463967 = null;
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var558EF4A88084E812F35BB7A7E3F7A5F9_987682223 = (focused != null && !focusables.contains(focused));
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
                    varB4EAC82CA7396A68D541C85D26508E83_1417582781 = focusables.get(position + 1);
                } //End block
            } //End block
            //End case View.FOCUS_FORWARD 
            //Begin case View.FOCUS_FORWARD 
            varB4EAC82CA7396A68D541C85D26508E83_183657922 = focusables.get(0);
            //End case View.FOCUS_FORWARD 
            //Begin case View.FOCUS_BACKWARD 
            {
                int position;
                position = focusables.indexOf(focused);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_380166144 = focusables.get(position - 1);
                } //End block
            } //End block
            //End case View.FOCUS_BACKWARD 
            //Begin case View.FOCUS_BACKWARD 
            varB4EAC82CA7396A68D541C85D26508E83_1843885250 = focusables.get(count - 1);
            //End case View.FOCUS_BACKWARD 
            varB4EAC82CA7396A68D541C85D26508E83_57304893 = null;
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
                    boolean var205FF283201A318100F5F54A08D1A92C_1847750949 = (isBetterCandidate(direction, focusedRect, mOtherRect, mBestCandidateRect));
                    {
                        mBestCandidateRect.set(mOtherRect);
                        closest = focusable;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1204459830 = closest;
        addTaint(root.getTaint());
        addTaint(focused.getTaint());
        addTaint(focusedRect.getTaint());
        addTaint(direction);
        View varA7E53CE21691AB073D9660D615818899_1995262852; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1995262852 = varB4EAC82CA7396A68D541C85D26508E83_936463967;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1995262852 = varB4EAC82CA7396A68D541C85D26508E83_1417582781;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1995262852 = varB4EAC82CA7396A68D541C85D26508E83_183657922;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1995262852 = varB4EAC82CA7396A68D541C85D26508E83_380166144;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1995262852 = varB4EAC82CA7396A68D541C85D26508E83_1843885250;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1995262852 = varB4EAC82CA7396A68D541C85D26508E83_57304893;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1995262852 = varB4EAC82CA7396A68D541C85D26508E83_1204459830;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1995262852.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1995262852;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.037 -0400", hash_original_method = "1A554E4FCE47CCCA17DD555DAEE432BA", hash_generated_method = "DDD1713F56FCCAC29E572E0F28F759BE")
     boolean isBetterCandidate(int direction, Rect source, Rect rect1, Rect rect2) {
        {
            boolean varBC13043B37383B864D2C258B89B82F77_538840071 = (!isCandidate(source, rect1, direction));
        } //End collapsed parenthetic
        {
            boolean var6C5BBF309AB2B70AE83F611B0AEDA9F3_1946274268 = (!isCandidate(source, rect2, direction));
        } //End collapsed parenthetic
        {
            boolean varCD7E7A5218518DF12DCE06E579CC94DD_571409004 = (beamBeats(direction, source, rect1, rect2));
        } //End collapsed parenthetic
        {
            boolean var39045A9398BCFD1ECF208D85EAA8B884_1839242555 = (beamBeats(direction, source, rect2, rect1));
        } //End collapsed parenthetic
        boolean varF4867C501B8142DDF7F95D81DB43C565_393145640 = ((getWeightedDistanceFor(
                        majorAxisDistance(direction, source, rect1),
                        minorAxisDistance(direction, source, rect1))
                < getWeightedDistanceFor(
                        majorAxisDistance(direction, source, rect2),
                        minorAxisDistance(direction, source, rect2))));
        addTaint(direction);
        addTaint(source.getTaint());
        addTaint(rect1.getTaint());
        addTaint(rect2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_613513705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_613513705;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.039 -0400", hash_original_method = "F8F20EF16F95C5B1E0CE2264EC877518", hash_generated_method = "F1F47662BC50526DE41E9E0E8B5DFF51")
     boolean beamBeats(int direction, Rect source, Rect rect1, Rect rect2) {
        boolean rect1InSrcBeam;
        rect1InSrcBeam = beamsOverlap(direction, source, rect1);
        boolean rect2InSrcBeam;
        rect2InSrcBeam = beamsOverlap(direction, source, rect2);
        {
            boolean var4F9C113203295E38B72887EB6CD3C2AD_1620195667 = (!isToDirectionOf(direction, source, rect2));
        } //End collapsed parenthetic
        boolean varE1D0C65B59C100612AC55BAB0AC3D40F_1582972690 = ((majorAxisDistance(direction, source, rect1)
                < majorAxisDistanceToFarEdge(direction, source, rect2)));
        addTaint(direction);
        addTaint(source.getTaint());
        addTaint(rect1.getTaint());
        addTaint(rect2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1361356688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1361356688;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.039 -0400", hash_original_method = "1AC6C27686DF7285B59CAB56ADBB9696", hash_generated_method = "FD6530FEA09BF56C6FC630BEFC08F2AF")
     int getWeightedDistanceFor(int majorAxisDistance, int minorAxisDistance) {
        addTaint(majorAxisDistance);
        addTaint(minorAxisDistance);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1217358290 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1217358290;
        // ---------- Original Method ----------
        //return 13 * majorAxisDistance * majorAxisDistance
                //+ minorAxisDistance * minorAxisDistance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.040 -0400", hash_original_method = "10315B5B788523AD56571BFBE30F6A43", hash_generated_method = "369854F51C8045A0A5A179C41AB1B2E3")
     boolean isCandidate(Rect srcRect, Rect destRect, int direction) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        addTaint(srcRect.getTaint());
        addTaint(destRect.getTaint());
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1098725495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1098725495;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.041 -0400", hash_original_method = "CDB9DCB11C27A9CD8A1036801B813613", hash_generated_method = "AEA825D32DE0AF6FE1BA53C6E02F6BDA")
     boolean beamsOverlap(int direction, Rect rect1, Rect rect2) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        addTaint(direction);
        addTaint(rect1.getTaint());
        addTaint(rect2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2106010889 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2106010889;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.050 -0400", hash_original_method = "0F816E844CC5CD74396FEF014D25737B", hash_generated_method = "DB2425976C3DF4DC48AE75073FB6DC78")
     boolean isToDirectionOf(int direction, Rect src, Rect dest) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        addTaint(direction);
        addTaint(src.getTaint());
        addTaint(dest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_338669737 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_338669737;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.071 -0400", hash_original_method = "720FA5A94E3C004CE3F70B83E46D48C3", hash_generated_method = "934E38AD8A82054C8487F7BB196C6E43")
    public View findNearestTouchable(ViewGroup root, int x, int y, int direction, int[] deltas) {
        View varB4EAC82CA7396A68D541C85D26508E83_1638481098 = null; //Variable for return #1
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
                    boolean var466CDCB1A655259E8B3D77CB3104058B_148200544 = (!isTouchCandidate(x, y, touchableBounds, direction));
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
                        boolean varBBAD419F16A98306582B67970B1FD0F6_373568862 = (closest == null ||
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
        varB4EAC82CA7396A68D541C85D26508E83_1638481098 = closest;
        addTaint(root.getTaint());
        addTaint(x);
        addTaint(y);
        addTaint(direction);
        addTaint(deltas[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1638481098.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1638481098;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.072 -0400", hash_original_method = "4EDA0197C585E6B2A33216D89691E993", hash_generated_method = "6435442A8B37AC4A6183B8E53F1F13BE")
    private boolean isTouchCandidate(int x, int y, Rect destRect, int direction) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        addTaint(x);
        addTaint(y);
        addTaint(destRect.getTaint());
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2137181501 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2137181501;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.072 -0400", hash_original_field = "02B57A18BA14114FE302D898FDC7FDC1", hash_generated_field = "83B823D385E70F0970576ECA854E6DAC")

        private Rect mFirstRect = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.072 -0400", hash_original_field = "99F066DBAD9BE8BCFD5FCA4A92E9FE2F", hash_generated_field = "8143D6FB738825C6135BAF0375D0B6FC")

        private Rect mSecondRect = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.072 -0400", hash_original_field = "45682D04D23E9DFA9A87C72737AEDE4C", hash_generated_field = "ED9210798784460350FD46FC78F11ACF")

        private ViewGroup mRoot;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.072 -0400", hash_original_method = "0E280D788A863FD723521B8D9E30F8E5", hash_generated_method = "0E280D788A863FD723521B8D9E30F8E5")
        public SequentialFocusComparator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.083 -0400", hash_original_method = "AE2DFC878449B0C9A87D974F16153CE8", hash_generated_method = "A8E4B594B1FA8FD9961783DE571544DE")
        public void recycle() {
            mRoot = null;
            // ---------- Original Method ----------
            //mRoot = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.084 -0400", hash_original_method = "0BE2F634C0DBDBECCB40B3CDEBC39607", hash_generated_method = "A135B5CF92D766B2094EDE79DA316D07")
        public void setRoot(ViewGroup root) {
            mRoot = root;
            // ---------- Original Method ----------
            //mRoot = root;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.086 -0400", hash_original_method = "088E9436455361AF149A244BD433F4AF", hash_generated_method = "C693247AC802C6C21C79DC62F6C46FE8")
        public int compare(View first, View second) {
            getRect(first, mFirstRect);
            getRect(second, mSecondRect);
            addTaint(first.getTaint());
            addTaint(second.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326914620 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326914620;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.086 -0400", hash_original_method = "CE5638677B07104C355FE3EB975CEDE8", hash_generated_method = "0A5F88AAF42F883DBBECC5D4E35D8CA9")
        private void getRect(View view, Rect rect) {
            view.getDrawingRect(rect);
            mRoot.offsetDescendantRectToMyCoords(view, rect);
            addTaint(view.getTaint());
            addTaint(rect.getTaint());
            // ---------- Original Method ----------
            //view.getDrawingRect(rect);
            //mRoot.offsetDescendantRectToMyCoords(view, rect);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.087 -0400", hash_original_field = "7690E1068C76C497BCB909EC68C2FD34", hash_generated_field = "8FF340D724CCBB70587006F19EB023BB")

    private static ThreadLocal<FocusFinder> tlFocusFinder = new ThreadLocal<FocusFinder>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.087 -0400", hash_original_method = "C8E9892D3DD456F1910EE73E67D2112F", hash_generated_method = "51B758FBB0F08BF1CCB53E7FD319975B")
        protected FocusFinder initialValue() {
            FocusFinder varB4EAC82CA7396A68D541C85D26508E83_1913927987 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1913927987 = new FocusFinder();
            varB4EAC82CA7396A68D541C85D26508E83_1913927987.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1913927987;
            // ---------- Original Method ----------
            //return new FocusFinder();
        }

        
};
}

