package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FocusFinder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.075 -0400", hash_original_field = "27595994279845FC545647F94FEFBC2A", hash_generated_field = "AA91269DE4CB12CC630B33741200666D")

    Rect mFocusedRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.075 -0400", hash_original_field = "7346218ADC4B97C5EED5BBCE304A9379", hash_generated_field = "A979E31795050A5EFD05BD971CC12AFB")

    Rect mOtherRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.075 -0400", hash_original_field = "A95262C4CAD591528E377657B34CEEF2", hash_generated_field = "73C7F1C53FFF4FE5714FB238D4A42A74")

    Rect mBestCandidateRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.075 -0400", hash_original_field = "92246F2C656C46A09BF795AE99B4A488", hash_generated_field = "401485DC01C0558BEA3A0859AF94C141")

    SequentialFocusComparator mSequentialFocusComparator = new SequentialFocusComparator();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.075 -0400", hash_original_method = "DC255E332B77A13B263C537BB61FEC63", hash_generated_method = "F16241C74771068F25916AC2FC4602F5")
    private  FocusFinder() {
        
    }

    
    @DSModeled(DSC.SAFE)
    public static FocusFinder getInstance() {
        return tlFocusFinder.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.077 -0400", hash_original_method = "948D7F222DFBCB81359D4FABF0EA65D3", hash_generated_method = "89086685DDFB940E6CFC75F652B18657")
    public final View findNextFocus(ViewGroup root, View focused, int direction) {
        View varB4EAC82CA7396A68D541C85D26508E83_804268819 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_735095919 = null; 
        {
            View userSetNextFocus = focused.findUserSetNextFocus(root, direction);
            {
                boolean varE20A98AF4AC4B2C8BFD1E1D9542B7AAF_1332122007 = (userSetNextFocus != null &&
                userSetNextFocus.isFocusable() &&
                (!userSetNextFocus.isInTouchMode() ||
                 userSetNextFocus.isFocusableInTouchMode()));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_804268819 = userSetNextFocus;
                } 
            } 
            focused.getFocusedRect(mFocusedRect);
            root.offsetDescendantRectToMyCoords(focused, mFocusedRect);
        } 
        {
            
            final int rootTop = root.getScrollY();
            
            
            final int rootLeft = root.getScrollX();
            
            
            mFocusedRect.set(rootLeft, rootTop, rootLeft, rootTop);
            
            
            final int rootBottom = root.getScrollY() + root.getHeight();
            
            
            final int rootRight = root.getScrollX() + root.getWidth();
            
            
            mFocusedRect.set(rootRight, rootBottom,
                            rootRight, rootBottom);
            
        } 
        varB4EAC82CA7396A68D541C85D26508E83_735095919 = findNextFocus(root, focused, mFocusedRect, direction);
        addTaint(root.getTaint());
        addTaint(focused.getTaint());
        addTaint(direction);
        View varA7E53CE21691AB073D9660D615818899_1606484948; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1606484948 = varB4EAC82CA7396A68D541C85D26508E83_804268819;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1606484948 = varB4EAC82CA7396A68D541C85D26508E83_735095919;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1606484948.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1606484948;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.078 -0400", hash_original_method = "56193535E50A3F40F9A982269CAB09AB", hash_generated_method = "CF57D09DFF0DE5F983A75983236EA329")
    public View findNextFocusFromRect(ViewGroup root, Rect focusedRect, int direction) {
        View varB4EAC82CA7396A68D541C85D26508E83_1329911692 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1329911692 = findNextFocus(root, null, focusedRect, direction);
        addTaint(root.getTaint());
        addTaint(focusedRect.getTaint());
        addTaint(direction);
        varB4EAC82CA7396A68D541C85D26508E83_1329911692.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1329911692;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.081 -0400", hash_original_method = "FE75104CAE6E392867319A5D2E1ED869", hash_generated_method = "BFEEE8B1F4EB3B3AA0C02DED32F42EEF")
    private View findNextFocus(ViewGroup root, View focused, Rect focusedRect, int direction) {
        View varB4EAC82CA7396A68D541C85D26508E83_339273065 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1349505898 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1762910399 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_422096814 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1602141690 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1595295465 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1820998310 = null; 
        ArrayList<View> focusables = root.getFocusables(direction);
        {
            boolean varB483D2AE7959E3CA3199EAE571F220FD_1348712978 = (focusables.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_339273065 = null;
            } 
        } 
        {
            {
                boolean var558EF4A88084E812F35BB7A7E3F7A5F9_1023009967 = (focused != null && !focusables.contains(focused));
                {
                    focusables.add(focused);
                } 
            } 
            try 
            {
                mSequentialFocusComparator.setRoot(root);
                Collections.sort(focusables, mSequentialFocusComparator);
            } 
            finally 
            {
                mSequentialFocusComparator.recycle();
            } 
            final int count = focusables.size();
            
            {
                int position = focusables.lastIndexOf(focused);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1349505898 = focusables.get(position + 1);
                } 
            } 
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1762910399 = focusables.get(0);
            
            
            {
                int position = focusables.indexOf(focused);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_422096814 = focusables.get(position - 1);
                } 
            } 
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1602141690 = focusables.get(count - 1);
            
            varB4EAC82CA7396A68D541C85D26508E83_1595295465 = null;
        } 
        mBestCandidateRect.set(focusedRect);
        
        mBestCandidateRect.offset(focusedRect.width() + 1, 0);
        
        
        mBestCandidateRect.offset(-(focusedRect.width() + 1), 0);
        
        
        mBestCandidateRect.offset(0, focusedRect.height() + 1);
        
        
        mBestCandidateRect.offset(0, -(focusedRect.height() + 1));
        
        View closest = null;
        int numFocusables = focusables.size();
        {
            int i = 0;
            {
                View focusable = focusables.get(i);
                focusable.getDrawingRect(mOtherRect);
                root.offsetDescendantRectToMyCoords(focusable, mOtherRect);
                {
                    boolean var205FF283201A318100F5F54A08D1A92C_1247040057 = (isBetterCandidate(direction, focusedRect, mOtherRect, mBestCandidateRect));
                    {
                        mBestCandidateRect.set(mOtherRect);
                        closest = focusable;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1820998310 = closest;
        addTaint(root.getTaint());
        addTaint(focused.getTaint());
        addTaint(focusedRect.getTaint());
        addTaint(direction);
        View varA7E53CE21691AB073D9660D615818899_1613946353; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1613946353 = varB4EAC82CA7396A68D541C85D26508E83_339273065;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1613946353 = varB4EAC82CA7396A68D541C85D26508E83_1349505898;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1613946353 = varB4EAC82CA7396A68D541C85D26508E83_1762910399;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1613946353 = varB4EAC82CA7396A68D541C85D26508E83_422096814;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1613946353 = varB4EAC82CA7396A68D541C85D26508E83_1602141690;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1613946353 = varB4EAC82CA7396A68D541C85D26508E83_1595295465;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1613946353 = varB4EAC82CA7396A68D541C85D26508E83_1820998310;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1613946353.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1613946353;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.082 -0400", hash_original_method = "1A554E4FCE47CCCA17DD555DAEE432BA", hash_generated_method = "FD50E92E1A289A3CD11D8B9819E704CD")
     boolean isBetterCandidate(int direction, Rect source, Rect rect1, Rect rect2) {
        {
            boolean varBC13043B37383B864D2C258B89B82F77_409872835 = (!isCandidate(source, rect1, direction));
        } 
        {
            boolean var6C5BBF309AB2B70AE83F611B0AEDA9F3_489657936 = (!isCandidate(source, rect2, direction));
        } 
        {
            boolean varCD7E7A5218518DF12DCE06E579CC94DD_1480449932 = (beamBeats(direction, source, rect1, rect2));
        } 
        {
            boolean var39045A9398BCFD1ECF208D85EAA8B884_405452307 = (beamBeats(direction, source, rect2, rect1));
        } 
        boolean varF4867C501B8142DDF7F95D81DB43C565_1773835531 = ((getWeightedDistanceFor(
                        majorAxisDistance(direction, source, rect1),
                        minorAxisDistance(direction, source, rect1))
                < getWeightedDistanceFor(
                        majorAxisDistance(direction, source, rect2),
                        minorAxisDistance(direction, source, rect2))));
        addTaint(direction);
        addTaint(source.getTaint());
        addTaint(rect1.getTaint());
        addTaint(rect2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_527508123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_527508123;
        
        
            
        
        
            
        
        
            
        
        
            
        
        
                        
                        
                
                        
                        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.082 -0400", hash_original_method = "F8F20EF16F95C5B1E0CE2264EC877518", hash_generated_method = "2E4B50763BC74CED5AA56833839DB353")
     boolean beamBeats(int direction, Rect source, Rect rect1, Rect rect2) {
        final boolean rect1InSrcBeam = beamsOverlap(direction, source, rect1);
        final boolean rect2InSrcBeam = beamsOverlap(direction, source, rect2);
        {
            boolean var4F9C113203295E38B72887EB6CD3C2AD_1172090609 = (!isToDirectionOf(direction, source, rect2));
        } 
        boolean varE1D0C65B59C100612AC55BAB0AC3D40F_681073216 = ((majorAxisDistance(direction, source, rect1)
                < majorAxisDistanceToFarEdge(direction, source, rect2)));
        addTaint(direction);
        addTaint(source.getTaint());
        addTaint(rect1.getTaint());
        addTaint(rect2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1985668222 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1985668222;
        
        
        
        
            
        
        
            
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.083 -0400", hash_original_method = "1AC6C27686DF7285B59CAB56ADBB9696", hash_generated_method = "E1AF52958E1CB9BBE7A5CB1E756B83F1")
     int getWeightedDistanceFor(int majorAxisDistance, int minorAxisDistance) {
        addTaint(majorAxisDistance);
        addTaint(minorAxisDistance);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_338871803 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_338871803;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.083 -0400", hash_original_method = "10315B5B788523AD56571BFBE30F6A43", hash_generated_method = "561764DD523382D14383D898A9442202")
     boolean isCandidate(Rect srcRect, Rect destRect, int direction) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        addTaint(srcRect.getTaint());
        addTaint(destRect.getTaint());
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_509844098 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_509844098;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.084 -0400", hash_original_method = "CDB9DCB11C27A9CD8A1036801B813613", hash_generated_method = "6B770C2AB5806DF4C9E2BD5094878587")
     boolean beamsOverlap(int direction, Rect rect1, Rect rect2) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        addTaint(direction);
        addTaint(rect1.getTaint());
        addTaint(rect2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_471065167 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_471065167;
        
        
            
            
                
            
            
                
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.084 -0400", hash_original_method = "0F816E844CC5CD74396FEF014D25737B", hash_generated_method = "5730552ECCDC95018CDE0A6FC1ED21DC")
     boolean isToDirectionOf(int direction, Rect src, Rect dest) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        addTaint(direction);
        addTaint(src.getTaint());
        addTaint(dest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_918204477 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_918204477;
        
        
            
                
            
                
            
                
            
                
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    static int majorAxisDistance(int direction, Rect source, Rect dest) {
        return Math.max(0, majorAxisDistanceRaw(direction, source, dest));
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    static int majorAxisDistanceToFarEdge(int direction, Rect source, Rect dest) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(direction, source, dest));
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.086 -0400", hash_original_method = "720FA5A94E3C004CE3F70B83E46D48C3", hash_generated_method = "40757B9FEB39CCDBA586154E46176A44")
    public View findNearestTouchable(ViewGroup root, int x, int y, int direction, int[] deltas) {
        View varB4EAC82CA7396A68D541C85D26508E83_229476775 = null; 
        ArrayList<View> touchables = root.getTouchables();
        int minDistance = Integer.MAX_VALUE;
        View closest = null;
        int numTouchables = touchables.size();
        int edgeSlop = ViewConfiguration.get(root.mContext).getScaledEdgeSlop();
        Rect closestBounds = new Rect();
        Rect touchableBounds = mOtherRect;
        {
            int i = 0;
            {
                View touchable = touchables.get(i);
                touchable.getDrawingRect(touchableBounds);
                root.offsetRectBetweenParentAndChild(touchable, touchableBounds, true, true);
                {
                    boolean var466CDCB1A655259E8B3D77CB3104058B_1565727036 = (!isTouchCandidate(x, y, touchableBounds, direction));
                } 
                int distance = Integer.MAX_VALUE;
                
                distance = x - touchableBounds.right + 1;
                
                
                distance = touchableBounds.left;
                
                
                distance = y - touchableBounds.bottom + 1;
                
                
                distance = touchableBounds.top;
                
                {
                    {
                        boolean varBBAD419F16A98306582B67970B1FD0F6_1673850849 = (closest == null ||
                        closestBounds.contains(touchableBounds) ||
                        (!touchableBounds.contains(closestBounds) && distance < minDistance));
                        {
                            minDistance = distance;
                            closest = touchable;
                            closestBounds.set(touchableBounds);
                            
                            deltas[0] = -distance;
                            
                            
                            deltas[0] = distance;
                            
                            
                            deltas[1] = -distance;
                            
                            
                            deltas[1] = distance;
                            
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_229476775 = closest;
        addTaint(root.getTaint());
        addTaint(x);
        addTaint(y);
        addTaint(direction);
        addTaint(deltas[0]);
        varB4EAC82CA7396A68D541C85D26508E83_229476775.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_229476775;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.087 -0400", hash_original_method = "4EDA0197C585E6B2A33216D89691E993", hash_generated_method = "C3F90562BB47836C8CA361B2412F309C")
    private boolean isTouchCandidate(int x, int y, Rect destRect, int direction) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        addTaint(x);
        addTaint(y);
        addTaint(destRect.getTaint());
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1992669016 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1992669016;
        
        
            
                
            
                
            
                
            
                
        
        
                
    }

    
    private static final class SequentialFocusComparator implements Comparator<View> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.087 -0400", hash_original_field = "02B57A18BA14114FE302D898FDC7FDC1", hash_generated_field = "9FC57DB4EBB3F9FD7BA1F2105DC0E4CE")

        private final Rect mFirstRect = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.087 -0400", hash_original_field = "99F066DBAD9BE8BCFD5FCA4A92E9FE2F", hash_generated_field = "6D37B6E76C0CCCF04F4EB2D92ECC6756")

        private final Rect mSecondRect = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.087 -0400", hash_original_field = "45682D04D23E9DFA9A87C72737AEDE4C", hash_generated_field = "ED9210798784460350FD46FC78F11ACF")

        private ViewGroup mRoot;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.087 -0400", hash_original_method = "0E280D788A863FD723521B8D9E30F8E5", hash_generated_method = "0E280D788A863FD723521B8D9E30F8E5")
        public SequentialFocusComparator ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.088 -0400", hash_original_method = "AE2DFC878449B0C9A87D974F16153CE8", hash_generated_method = "A8E4B594B1FA8FD9961783DE571544DE")
        public void recycle() {
            mRoot = null;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.088 -0400", hash_original_method = "0BE2F634C0DBDBECCB40B3CDEBC39607", hash_generated_method = "A135B5CF92D766B2094EDE79DA316D07")
        public void setRoot(ViewGroup root) {
            mRoot = root;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.089 -0400", hash_original_method = "088E9436455361AF149A244BD433F4AF", hash_generated_method = "19CBEFDC3F9F92C021A7F2235E16A9CB")
        public int compare(View first, View second) {
            getRect(first, mFirstRect);
            getRect(second, mSecondRect);
            addTaint(first.getTaint());
            addTaint(second.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1785989173 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1785989173;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.090 -0400", hash_original_method = "CE5638677B07104C355FE3EB975CEDE8", hash_generated_method = "0A5F88AAF42F883DBBECC5D4E35D8CA9")
        private void getRect(View view, Rect rect) {
            view.getDrawingRect(rect);
            mRoot.offsetDescendantRectToMyCoords(view, rect);
            addTaint(view.getTaint());
            addTaint(rect.getTaint());
            
            
            
        }

        
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
}

