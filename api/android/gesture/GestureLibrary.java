/*
 * Copyright (C) 2009 The Android Open Source Project
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

package android.gesture;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Set;
import java.util.ArrayList;

public abstract class GestureLibrary {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.477 -0500", hash_original_field = "8CD7DD7210A37A69B5821F6C293A7DF3", hash_generated_field = "32CADCDB8F24C64645ABC1E401565D84")

    protected  GestureStore mStore;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.482 -0500", hash_original_method = "311DE826347EAA4CD94EF3C48A5F8D66", hash_generated_method = "8019A0A1CC8C35C00F8F81ACC5929E7E")
    
protected GestureLibrary() {
        mStore = new GestureStore();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.487 -0500", hash_original_method = "7C551A827FB2453EFF5E269C39B93097", hash_generated_method = "67012C7CEF1365B9F5220F909DB099F2")
    
public abstract boolean save();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.492 -0500", hash_original_method = "7CBDBE19D2EB2109490F734B622F8585", hash_generated_method = "D407F91A8B34F31FCFE8287408C02D31")

    @DSSafe(DSCat.SAFE_OTHERS)
public abstract boolean load();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.496 -0500", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "0198B3E008A084D33A7779761A0527C9")
    
public boolean isReadOnly() {
        return false;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.503 -0500", hash_original_method = "0C28087B99BDEBC86EC8ADD60CC4E970", hash_generated_method = "FB99FBA708F322ABDD094EC85A1D4DC4")
    
public Learner getLearner() {
        return mStore.getLearner();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.508 -0500", hash_original_method = "EE31B6F866D40C310FA81F11AD9B4CA9", hash_generated_method = "8FBC044DAA0BA1AB9923472C9282AEAF")
    
public void setOrientationStyle(int style) {
        mStore.setOrientationStyle(style);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.512 -0500", hash_original_method = "D17A1633BA68FB791A5349F63BB2BCC8", hash_generated_method = "49A4D1F7C0FC1233F9603E28F9CCD642")
    
public int getOrientationStyle() {
        return mStore.getOrientationStyle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.516 -0500", hash_original_method = "E882F17D4E5FFEC7EF15CE6CF2D9F479", hash_generated_method = "0A70BA82DF833D140868A06548CA8293")
    
public void setSequenceType(int type) {
        mStore.setSequenceType(type);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.522 -0500", hash_original_method = "F0972C7FC1FD90D27C8FBECF4C886106", hash_generated_method = "7EE43036258BA8FFA2D3EDDDC3F02E49")
    
public int getSequenceType() {
        return mStore.getSequenceType();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.526 -0500", hash_original_method = "DBD17E97F3BF46FA3FCD4E0D25313012", hash_generated_method = "80974CC90F2B6712CE536E55BF31099C")
    
public Set<String> getGestureEntries() {
        return mStore.getGestureEntries();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.531 -0500", hash_original_method = "22DFF022721FE37F92934675090D5D53", hash_generated_method = "700DD06F60DB51F79391010463901992")
    @DSSafe(DSCat.SAFE_OTHERS)

public ArrayList<Prediction> recognize(Gesture gesture) {
        return mStore.recognize(gesture);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.535 -0500", hash_original_method = "A1645A82DB2E6D81C8E8184ACB64A726", hash_generated_method = "44FB42D69A33B2B7AD7D0D112A393273")
    
public void addGesture(String entryName, Gesture gesture) {
        mStore.addGesture(entryName, gesture);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.540 -0500", hash_original_method = "27CA644D0CD19AF1090F6D954DFEE068", hash_generated_method = "13424248B847A3654A1F63954C186E50")
    
public void removeGesture(String entryName, Gesture gesture) {
        mStore.removeGesture(entryName, gesture);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.544 -0500", hash_original_method = "32E7903EC7FECBC9165638C70EA29104", hash_generated_method = "CB7F38DB475FA5ADB07AFB35AA12B613")
    
public void removeEntry(String entryName) {
        mStore.removeEntry(entryName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.548 -0500", hash_original_method = "DA2499711C65387106594ECC85D9245D", hash_generated_method = "6E53950AD617A5493617C49F5B4528E4")
    
public ArrayList<Gesture> getGestures(String entryName) {
        return mStore.getGestures(entryName);
    }
}
