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


package android.support.v4.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

class ScrollerCompatGingerbread {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:09.341 -0400", hash_original_method = "01C7CBBFE2C9F43514EB60B6837061BF", hash_generated_method = "A6E467F869FA59843226E26BE9C98626")
    
public static Object createScroller(Context context, Interpolator interpolator) {
        return interpolator != null ?
                new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:09.345 -0400", hash_original_method = "1B98A5C063C21BE417FCA0DAC872798C", hash_generated_method = "27AA095C2B17D5EAC5B798D327E57016")
    
public static boolean isFinished(Object scroller) {
        return ((OverScroller) scroller).isFinished();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:09.349 -0400", hash_original_method = "E92568B0832F86A08C4CD3030490870E", hash_generated_method = "AFC0BA7A95ECAFCA0075A697D05C97F2")
    
public static int getCurrX(Object scroller) {
        return ((OverScroller) scroller).getCurrX();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:09.352 -0400", hash_original_method = "0A396A36DD59933EB66639BCF42E3F57", hash_generated_method = "ADC5955BB39DB3FAF85CC77242D15108")
    
public static int getCurrY(Object scroller) {
        return ((OverScroller) scroller).getCurrY();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:09.355 -0400", hash_original_method = "3DC3EF6BC02EF7FFFE5F04BA35E64A71", hash_generated_method = "0ED1FA6F531053247EA37F0328B9C386")
    
public static boolean computeScrollOffset(Object scroller) {
        return ((OverScroller) scroller).computeScrollOffset();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:09.360 -0400", hash_original_method = "1C4AAE8F33F0EB2398179E1F1023CEB8", hash_generated_method = "17C0A00EC13C77BE61987BCECD6B8B54")
    
public static void startScroll(Object scroller, int startX, int startY, int dx, int dy) {
        ((OverScroller) scroller).startScroll(startX, startY, dx, dy);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:09.365 -0400", hash_original_method = "F45AEE43ED2BC949E73EC1704A111BF4", hash_generated_method = "46E5ACB876221187AEBD37518C92A0BF")
    
public static void startScroll(Object scroller, int startX, int startY, int dx, int dy,
            int duration) {
        ((OverScroller) scroller).startScroll(startX, startY, dx, dy, duration);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:09.370 -0400", hash_original_method = "FD3D229780E5B099F816374C035F002F", hash_generated_method = "371B0705AA72B20823A013C7724C76D5")
    
public static void fling(Object scroller, int startX, int startY, int velX, int velY,
            int minX, int maxX, int minY, int maxY) {
        ((OverScroller) scroller).fling(startX, startY, velX, velY, minX, maxX, minY, maxY);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:09.375 -0400", hash_original_method = "15B8EA28E2460ECA8B4A49FCD05A950D", hash_generated_method = "F84CE3887AC3B715E75DE17DEA27F61E")
    
public static void fling(Object scroller, int startX, int startY, int velX, int velY,
            int minX, int maxX, int minY, int maxY, int overX, int overY) {
        ((OverScroller) scroller).fling(startX, startY, velX, velY,
                minX, maxX, minY, maxY, overX, overY);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:09.379 -0400", hash_original_method = "CBCF95B886F5E4DCA35B3541E1F41970", hash_generated_method = "472B98EC1FB4307C6607811EEF14BF59")
    
public static void abortAnimation(Object scroller) {
        ((OverScroller) scroller).abortAnimation();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:09.383 -0400", hash_original_method = "66FAA0B03FA7700BB44C9B7567AEFC0F", hash_generated_method = "286DF4A40C9878AE846BA2057C64CE27")
    
public static void notifyHorizontalEdgeReached(Object scroller, int startX, int finalX,
            int overX) {
        ((OverScroller) scroller).notifyHorizontalEdgeReached(startX, finalX, overX);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:09.387 -0400", hash_original_method = "5DC01C450C29D4948F0FD03828F4F61B", hash_generated_method = "40E79BC2B2757C300023032F81FD7C36")
    
public static void notifyVerticalEdgeReached(Object scroller, int startY, int finalY, int overY) {
        ((OverScroller) scroller).notifyVerticalEdgeReached(startY, finalY, overY);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:09.391 -0400", hash_original_method = "CF08539BDBF18154C06583F8989D7E90", hash_generated_method = "C611C49E820C8E126CE8EA11E573A93E")
    
public static boolean isOverScrolled(Object scroller) {
        return ((OverScroller) scroller).isOverScrolled();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:09.395 -0400", hash_original_method = "9D30580E0CB53DD872D1D7BAD87098B7", hash_generated_method = "F45A4A9AFD2353FFC2C0914ADB9FECA8")
    
public static int getFinalX(Object scroller) {
        return ((OverScroller) scroller).getFinalX();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:09.398 -0400", hash_original_method = "B6750FE324B053C4E8A830A13003C2FB", hash_generated_method = "5A51AC724B898ED3968F1BF13261CF58")
    
public static int getFinalY(Object scroller) {
        return ((OverScroller) scroller).getFinalY();
    }
}
