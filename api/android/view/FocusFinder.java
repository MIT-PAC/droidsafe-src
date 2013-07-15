package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FocusFinder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.771 -0400", hash_original_field = "27595994279845FC545647F94FEFBC2A", hash_generated_field = "AA91269DE4CB12CC630B33741200666D")

    Rect mFocusedRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.771 -0400", hash_original_field = "7346218ADC4B97C5EED5BBCE304A9379", hash_generated_field = "A979E31795050A5EFD05BD971CC12AFB")

    Rect mOtherRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.771 -0400", hash_original_field = "A95262C4CAD591528E377657B34CEEF2", hash_generated_field = "73C7F1C53FFF4FE5714FB238D4A42A74")

    Rect mBestCandidateRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.771 -0400", hash_original_field = "92246F2C656C46A09BF795AE99B4A488", hash_generated_field = "401485DC01C0558BEA3A0859AF94C141")

    SequentialFocusComparator mSequentialFocusComparator = new SequentialFocusComparator();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.771 -0400", hash_original_method = "DC255E332B77A13B263C537BB61FEC63", hash_generated_method = "F16241C74771068F25916AC2FC4602F5")
    private  FocusFinder() {
        // ---------- Original Method ----------
    }

    
        public static FocusFinder getInstance() {
        return tlFocusFinder.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.772 -0400", hash_original_method = "948D7F222DFBCB81359D4FABF0EA65D3", hash_generated_method = "31B5BD5FC23CF3965CD77A4D6196B2C2")
    public final View findNextFocus(ViewGroup root, View focused, int direction) {
        addTaint(direction);
        addTaint(focused.getTaint());
        addTaint(root.getTaint());
    if(focused != null)        
        {
            View userSetNextFocus = focused.findUserSetNextFocus(root, direction);
    if(userSetNextFocus != null &&
                userSetNextFocus.isFocusable() &&
                (!userSetNextFocus.isInTouchMode() ||
                 userSetNextFocus.isFocusableInTouchMode()))            
            {
View var39E747E57A07EC9D6124995BE2F3D86F_933591278 =                 userSetNextFocus;
                var39E747E57A07EC9D6124995BE2F3D86F_933591278.addTaint(taint);
                return var39E747E57A07EC9D6124995BE2F3D86F_933591278;
            } //End block
            focused.getFocusedRect(mFocusedRect);
            root.offsetDescendantRectToMyCoords(focused, mFocusedRect);
        } //End block
        else
        {
switch(direction){
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
        } //End block
View var06DBF2B8AE78C3361DC3744F6164AB4A_1741862042 =         findNextFocus(root, focused, mFocusedRect, direction);
        var06DBF2B8AE78C3361DC3744F6164AB4A_1741862042.addTaint(taint);
        return var06DBF2B8AE78C3361DC3744F6164AB4A_1741862042;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.773 -0400", hash_original_method = "56193535E50A3F40F9A982269CAB09AB", hash_generated_method = "D7AE6E5E4E4A2416B46744C9BAEEEF8A")
    public View findNextFocusFromRect(ViewGroup root, Rect focusedRect, int direction) {
        addTaint(direction);
        addTaint(focusedRect.getTaint());
        addTaint(root.getTaint());
View varA971D394BC5F19CBC9FFD1F74ED9A7F7_21161625 =         findNextFocus(root, null, focusedRect, direction);
        varA971D394BC5F19CBC9FFD1F74ED9A7F7_21161625.addTaint(taint);
        return varA971D394BC5F19CBC9FFD1F74ED9A7F7_21161625;
        // ---------- Original Method ----------
        //return findNextFocus(root, null, focusedRect, direction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.775 -0400", hash_original_method = "FE75104CAE6E392867319A5D2E1ED869", hash_generated_method = "4F2EBDA2054CC0DFFD459492F3BE3626")
    private View findNextFocus(ViewGroup root, View focused, Rect focusedRect, int direction) {
        addTaint(direction);
        addTaint(focusedRect.getTaint());
        addTaint(focused.getTaint());
        addTaint(root.getTaint());
        ArrayList<View> focusables = root.getFocusables(direction);
    if(focusables.isEmpty())        
        {
View var540C13E9E156B687226421B24F2DF178_495571507 =             null;
            var540C13E9E156B687226421B24F2DF178_495571507.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_495571507;
        } //End block
    if(direction == View.FOCUS_FORWARD || direction == View.FOCUS_BACKWARD)        
        {
    if(focused != null && !focusables.contains(focused))            
            {
                focusables.add(focused);
            } //End block
            try 
            {
                mSequentialFocusComparator.setRoot(root);
                Collections.sort(focusables, mSequentialFocusComparator);
            } //End block
            finally 
            {
                mSequentialFocusComparator.recycle();
            } //End block
            final int count = focusables.size();
switch(direction){
            case View.FOCUS_FORWARD:
    if(focused != null)            
            {
                int position = focusables.lastIndexOf(focused);
    if(position >= 0 && position + 1 < count)                
                {
View var3E7C83F10EA86CD61058EB13C3C1E614_13604783 =                     focusables.get(position + 1);
                    var3E7C83F10EA86CD61058EB13C3C1E614_13604783.addTaint(taint);
                    return var3E7C83F10EA86CD61058EB13C3C1E614_13604783;
                } //End block
            } //End block
View var09A623C4F0759197B7F0A0D0CC5AE5E0_602578884 =             focusables.get(0);
            var09A623C4F0759197B7F0A0D0CC5AE5E0_602578884.addTaint(taint);
            return var09A623C4F0759197B7F0A0D0CC5AE5E0_602578884;
            case View.FOCUS_BACKWARD:
    if(focused != null)            
            {
                int position = focusables.indexOf(focused);
    if(position > 0)                
                {
View var429063D739A5BDE099949F1147A699B4_139694128 =                     focusables.get(position - 1);
                    var429063D739A5BDE099949F1147A699B4_139694128.addTaint(taint);
                    return var429063D739A5BDE099949F1147A699B4_139694128;
                } //End block
            } //End block
View var0DBC784709316F8F2DDFA2F746427950_404574604 =             focusables.get(count - 1);
            var0DBC784709316F8F2DDFA2F746427950_404574604.addTaint(taint);
            return var0DBC784709316F8F2DDFA2F746427950_404574604;
}View var540C13E9E156B687226421B24F2DF178_373846995 =             null;
            var540C13E9E156B687226421B24F2DF178_373846995.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_373846995;
        } //End block
        mBestCandidateRect.set(focusedRect);
switch(direction){
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
}        View closest = null;
        int numFocusables = focusables.size();
for(int i = 0;i < numFocusables;i++)
        {
            View focusable = focusables.get(i);
    if(focusable == focused || focusable == root)            
            continue;
            focusable.getDrawingRect(mOtherRect);
            root.offsetDescendantRectToMyCoords(focusable, mOtherRect);
    if(isBetterCandidate(direction, focusedRect, mOtherRect, mBestCandidateRect))            
            {
                mBestCandidateRect.set(mOtherRect);
                closest = focusable;
            } //End block
        } //End block
View var65F842BF8DD12196C017063DB033EAE1_1541344409 =         closest;
        var65F842BF8DD12196C017063DB033EAE1_1541344409.addTaint(taint);
        return var65F842BF8DD12196C017063DB033EAE1_1541344409;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.778 -0400", hash_original_method = "1A554E4FCE47CCCA17DD555DAEE432BA", hash_generated_method = "DC77251EEA12E6130C1C8C59EBE912F6")
     boolean isBetterCandidate(int direction, Rect source, Rect rect1, Rect rect2) {
        addTaint(rect2.getTaint());
        addTaint(rect1.getTaint());
        addTaint(source.getTaint());
        addTaint(direction);
    if(!isCandidate(source, rect1, direction))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1815054083 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_397284244 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_397284244;
        } //End block
    if(!isCandidate(source, rect2, direction))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1327571528 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_638732357 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_638732357;
        } //End block
    if(beamBeats(direction, source, rect1, rect2))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_19080690 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1151079657 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1151079657;
        } //End block
    if(beamBeats(direction, source, rect2, rect1))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2119896032 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1170920179 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1170920179;
        } //End block
        boolean varD1997C9AE1733AF494AE1F50856AA1BF_1271751859 = ((getWeightedDistanceFor(
                        majorAxisDistance(direction, source, rect1),
                        minorAxisDistance(direction, source, rect1))
                < getWeightedDistanceFor(
                        majorAxisDistance(direction, source, rect2),
                        minorAxisDistance(direction, source, rect2))));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_430194802 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_430194802;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.779 -0400", hash_original_method = "F8F20EF16F95C5B1E0CE2264EC877518", hash_generated_method = "D6E9733D1715F3BD6D5EC7C389D2C15F")
     boolean beamBeats(int direction, Rect source, Rect rect1, Rect rect2) {
        addTaint(rect2.getTaint());
        addTaint(rect1.getTaint());
        addTaint(source.getTaint());
        addTaint(direction);
        final boolean rect1InSrcBeam = beamsOverlap(direction, source, rect1);
        final boolean rect2InSrcBeam = beamsOverlap(direction, source, rect2);
    if(rect2InSrcBeam || !rect1InSrcBeam)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1773968673 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_349740142 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_349740142;
        } //End block
    if(!isToDirectionOf(direction, source, rect2))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_739096048 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_225974530 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_225974530;
        } //End block
    if((direction == View.FOCUS_LEFT || direction == View.FOCUS_RIGHT))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_209311404 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2067069975 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2067069975;
        } //End block
        boolean var6C64953B2A7F3C559925717D155B6779_1289662308 = ((majorAxisDistance(direction, source, rect1)
                < majorAxisDistanceToFarEdge(direction, source, rect2)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_212800641 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_212800641;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.779 -0400", hash_original_method = "1AC6C27686DF7285B59CAB56ADBB9696", hash_generated_method = "8A8D9C1D689F6A2FF9A2320A60A73B03")
     int getWeightedDistanceFor(int majorAxisDistance, int minorAxisDistance) {
        addTaint(minorAxisDistance);
        addTaint(majorAxisDistance);
        int varB8BD0E66C1853E5EBAD666558FF9B092_1735526287 = (13 * majorAxisDistance * majorAxisDistance
                + minorAxisDistance * minorAxisDistance);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_532491775 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_532491775;
        // ---------- Original Method ----------
        //return 13 * majorAxisDistance * majorAxisDistance
                //+ minorAxisDistance * minorAxisDistance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.780 -0400", hash_original_method = "10315B5B788523AD56571BFBE30F6A43", hash_generated_method = "CFC6354F6921CA6EC099B18B42EF5C7F")
     boolean isCandidate(Rect srcRect, Rect destRect, int direction) {
        addTaint(direction);
        addTaint(destRect.getTaint());
        addTaint(srcRect.getTaint());
switch(direction){
        case View.FOCUS_LEFT:
        boolean var7E4B0C77B943256BCBEDC6870F2A7C58_144729321 = ((srcRect.right > destRect.right || srcRect.left >= destRect.right) 
                        && srcRect.left > destRect.left);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1052345316 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1052345316;
        case View.FOCUS_RIGHT:
        boolean varBDE74F366D03B98BD758E1CDF7383ECB_1278921836 = ((srcRect.left < destRect.left || srcRect.right <= destRect.left)
                        && srcRect.right < destRect.right);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_128420197 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_128420197;
        case View.FOCUS_UP:
        boolean varD1048D4D7C51FBE364C979D559F43480_1310120315 = ((srcRect.bottom > destRect.bottom || srcRect.top >= destRect.bottom)
                        && srcRect.top > destRect.top);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1409615521 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1409615521;
        case View.FOCUS_DOWN:
        boolean var848003BB68CBF1499411E84EFE9FC97B_1727532830 = ((srcRect.top < destRect.top || srcRect.bottom <= destRect.top)
                        && srcRect.bottom < destRect.bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1731664764 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1731664764;
}        IllegalArgumentException var772CBA4A53A69BC7091EF474F4AECFF3_442597516 = new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        var772CBA4A53A69BC7091EF474F4AECFF3_442597516.addTaint(taint);
        throw var772CBA4A53A69BC7091EF474F4AECFF3_442597516;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.780 -0400", hash_original_method = "CDB9DCB11C27A9CD8A1036801B813613", hash_generated_method = "6F73D9E0D04603CC085FC8C1C10C3A05")
     boolean beamsOverlap(int direction, Rect rect1, Rect rect2) {
        addTaint(rect2.getTaint());
        addTaint(rect1.getTaint());
        addTaint(direction);
switch(direction){
        case View.FOCUS_LEFT:
        case View.FOCUS_RIGHT:
        boolean var01CE155444241ECAE4EA73C80570BA1E_1001481426 = ((rect2.bottom >= rect1.top) && (rect2.top <= rect1.bottom));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1290333028 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1290333028;
        case View.FOCUS_UP:
        case View.FOCUS_DOWN:
        boolean var95F5AA65BB2C85AFBF11B18AA1869416_641226128 = ((rect2.right >= rect1.left) && (rect2.left <= rect1.right));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1499591465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1499591465;
}        IllegalArgumentException var772CBA4A53A69BC7091EF474F4AECFF3_7321994 = new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        var772CBA4A53A69BC7091EF474F4AECFF3_7321994.addTaint(taint);
        throw var772CBA4A53A69BC7091EF474F4AECFF3_7321994;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.793 -0400", hash_original_method = "0F816E844CC5CD74396FEF014D25737B", hash_generated_method = "842371A13C806FE20D5EF57926342822")
     boolean isToDirectionOf(int direction, Rect src, Rect dest) {
        addTaint(dest.getTaint());
        addTaint(src.getTaint());
        addTaint(direction);
switch(direction){
        case View.FOCUS_LEFT:
        boolean varC96A91072E0E2EE15339C68492468A5B_1387343817 = (src.left >= dest.right);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_261593941 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_261593941;
        case View.FOCUS_RIGHT:
        boolean var34F4492E0796517AAB8BA6496C1B2C9C_1751100393 = (src.right <= dest.left);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1166752180 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1166752180;
        case View.FOCUS_UP:
        boolean varB1937AF2F9AF6AD22F89B34DAA556094_782201296 = (src.top >= dest.bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_858013613 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_858013613;
        case View.FOCUS_DOWN:
        boolean var0E8F9FD382517E77F6FF0124272FFE5C_1512048663 = (src.bottom <= dest.top);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_888944044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_888944044;
}        IllegalArgumentException var772CBA4A53A69BC7091EF474F4AECFF3_685578362 = new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        var772CBA4A53A69BC7091EF474F4AECFF3_685578362.addTaint(taint);
        throw var772CBA4A53A69BC7091EF474F4AECFF3_685578362;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.796 -0400", hash_original_method = "720FA5A94E3C004CE3F70B83E46D48C3", hash_generated_method = "4C1CE0CDD8B975D85D6EA420F80A75ED")
    public View findNearestTouchable(ViewGroup root, int x, int y, int direction, int[] deltas) {
        addTaint(deltas[0]);
        addTaint(direction);
        addTaint(y);
        addTaint(x);
        addTaint(root.getTaint());
        ArrayList<View> touchables = root.getTouchables();
        int minDistance = Integer.MAX_VALUE;
        View closest = null;
        int numTouchables = touchables.size();
        int edgeSlop = ViewConfiguration.get(root.mContext).getScaledEdgeSlop();
        Rect closestBounds = new Rect();
        Rect touchableBounds = mOtherRect;
for(int i = 0;i < numTouchables;i++)
        {
            View touchable = touchables.get(i);
            touchable.getDrawingRect(touchableBounds);
            root.offsetRectBetweenParentAndChild(touchable, touchableBounds, true, true);
    if(!isTouchCandidate(x, y, touchableBounds, direction))            
            {
                continue;
            } //End block
            int distance = Integer.MAX_VALUE;
switch(direction){
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
}    if(distance < edgeSlop)            
            {
    if(closest == null ||
                        closestBounds.contains(touchableBounds) ||
                        (!touchableBounds.contains(closestBounds) && distance < minDistance))                
                {
                    minDistance = distance;
                    closest = touchable;
                    closestBounds.set(touchableBounds);
switch(direction){
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
                } //End block
            } //End block
        } //End block
View var65F842BF8DD12196C017063DB033EAE1_657936151 =         closest;
        var65F842BF8DD12196C017063DB033EAE1_657936151.addTaint(taint);
        return var65F842BF8DD12196C017063DB033EAE1_657936151;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.797 -0400", hash_original_method = "4EDA0197C585E6B2A33216D89691E993", hash_generated_method = "460DFE716D77C97FFD63A5A4480A27A6")
    private boolean isTouchCandidate(int x, int y, Rect destRect, int direction) {
        addTaint(direction);
        addTaint(destRect.getTaint());
        addTaint(y);
        addTaint(x);
switch(direction){
        case View.FOCUS_LEFT:
        boolean varC3BF8E95285EEFA81E976B7F20A773F6_1412300241 = (destRect.left <= x && destRect.top <= y && y <= destRect.bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2095253542 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2095253542;
        case View.FOCUS_RIGHT:
        boolean var54E5EE62FA0BFF1304AC8A9F4061FFB3_1405867773 = (destRect.left >= x && destRect.top <= y && y <= destRect.bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2126940715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2126940715;
        case View.FOCUS_UP:
        boolean varE36F01B4ABD519B5FE5ED048E3A7E954_1378493038 = (destRect.top <= y && destRect.left <= x && x <= destRect.right);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_784790740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_784790740;
        case View.FOCUS_DOWN:
        boolean var1C1870E472C8A59786E474E69E078C28_1506001970 = (destRect.top >= y && destRect.left <= x && x <= destRect.right);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1870650000 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1870650000;
}        IllegalArgumentException var772CBA4A53A69BC7091EF474F4AECFF3_1484324497 = new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        var772CBA4A53A69BC7091EF474F4AECFF3_1484324497.addTaint(taint);
        throw var772CBA4A53A69BC7091EF474F4AECFF3_1484324497;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.801 -0400", hash_original_field = "02B57A18BA14114FE302D898FDC7FDC1", hash_generated_field = "9FC57DB4EBB3F9FD7BA1F2105DC0E4CE")

        private final Rect mFirstRect = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.801 -0400", hash_original_field = "99F066DBAD9BE8BCFD5FCA4A92E9FE2F", hash_generated_field = "6D37B6E76C0CCCF04F4EB2D92ECC6756")

        private final Rect mSecondRect = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.801 -0400", hash_original_field = "45682D04D23E9DFA9A87C72737AEDE4C", hash_generated_field = "ED9210798784460350FD46FC78F11ACF")

        private ViewGroup mRoot;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.802 -0400", hash_original_method = "0E280D788A863FD723521B8D9E30F8E5", hash_generated_method = "0E280D788A863FD723521B8D9E30F8E5")
        public SequentialFocusComparator ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.802 -0400", hash_original_method = "AE2DFC878449B0C9A87D974F16153CE8", hash_generated_method = "A8E4B594B1FA8FD9961783DE571544DE")
        public void recycle() {
            mRoot = null;
            // ---------- Original Method ----------
            //mRoot = null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.803 -0400", hash_original_method = "0BE2F634C0DBDBECCB40B3CDEBC39607", hash_generated_method = "A135B5CF92D766B2094EDE79DA316D07")
        public void setRoot(ViewGroup root) {
            mRoot = root;
            // ---------- Original Method ----------
            //mRoot = root;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.804 -0400", hash_original_method = "088E9436455361AF149A244BD433F4AF", hash_generated_method = "1CBA4E689C042E05D33E7B19180EDA44")
        public int compare(View first, View second) {
            addTaint(second.getTaint());
            addTaint(first.getTaint());
    if(first == second)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_298623608 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_917477128 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_917477128;
            } //End block
            getRect(first, mFirstRect);
            getRect(second, mSecondRect);
    if(mFirstRect.top < mSecondRect.top)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_729063016 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1061310841 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1061310841;
            } //End block
            else
    if(mFirstRect.top > mSecondRect.top)            
            {
                int varC4CA4238A0B923820DCC509A6F75849B_150738772 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881016520 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881016520;
            } //End block
            else
    if(mFirstRect.left < mSecondRect.left)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_363903575 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2101433924 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2101433924;
            } //End block
            else
    if(mFirstRect.left > mSecondRect.left)            
            {
                int varC4CA4238A0B923820DCC509A6F75849B_299457754 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_58194629 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_58194629;
            } //End block
            else
    if(mFirstRect.bottom < mSecondRect.bottom)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1869449025 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_629869936 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_629869936;
            } //End block
            else
    if(mFirstRect.bottom > mSecondRect.bottom)            
            {
                int varC4CA4238A0B923820DCC509A6F75849B_1881872955 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_493633496 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_493633496;
            } //End block
            else
    if(mFirstRect.right < mSecondRect.right)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_2141478343 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480075435 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480075435;
            } //End block
            else
    if(mFirstRect.right > mSecondRect.right)            
            {
                int varC4CA4238A0B923820DCC509A6F75849B_1699302816 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2047351341 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2047351341;
            } //End block
            else
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_990085299 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1626081426 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1626081426;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.805 -0400", hash_original_method = "CE5638677B07104C355FE3EB975CEDE8", hash_generated_method = "4D156730D84C1DA4646602251AB36489")
        private void getRect(View view, Rect rect) {
            addTaint(rect.getTaint());
            addTaint(view.getTaint());
            view.getDrawingRect(rect);
            mRoot.offsetDescendantRectToMyCoords(view, rect);
            // ---------- Original Method ----------
            //view.getDrawingRect(rect);
            //mRoot.offsetDescendantRectToMyCoords(view, rect);
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

