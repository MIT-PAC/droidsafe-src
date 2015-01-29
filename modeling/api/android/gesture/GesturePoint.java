/*
 * Copyright (C) 2008-2009 The Android Open Source Project
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
import java.io.DataInputStream;
import java.io.IOException;

/**
 * A timed point of a gesture stroke. Multiple points form a stroke.
 */

public class GesturePoint {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.542 -0500", hash_original_method = "B0859FA5182F743DC6497D46B8C47566", hash_generated_method = "35D84864FEE27DAB7163DC6743C03BA0")
    
static GesturePoint deserialize(DataInputStream in) throws IOException {
        // Read X and Y
        final float x = in.readFloat();
        final float y = in.readFloat();
        // Read timestamp
        final long timeStamp = in.readLong();
        return new GesturePoint(x, y, timeStamp);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.520 -0500", hash_original_field = "EED2933541FCCE7155092AF77A402EA9", hash_generated_field = "0CC4A8770822EF2A4B3BD536BBF6C113")

    public  float x;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.525 -0500", hash_original_field = "531E5158163E3809C8650CC9FEEE1C8C", hash_generated_field = "E8D9A0915E4274087E59C025C4DCDA11")

    public  float y;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.530 -0500", hash_original_field = "145039C09D0281F07AE1DE322AF921C0", hash_generated_field = "37EA591B5E14A037995EF6FFB5E9C3F8")

    public  long timestamp;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.536 -0500", hash_original_method = "11FA5048BA965D40A3E66C4486655B18", hash_generated_method = "BA3696C6E37954E7FF16D0C556FDDF42")
    
public GesturePoint(float x, float y, long t) {
        this.x = x;
        this.y = y;
        timestamp = t;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.546 -0500", hash_original_method = "B49FDF337BD676F474A63E998ADA3000", hash_generated_method = "1B7EEF493D9696D54B0769B0136EF3B6")
    
@Override
    public Object clone() {
        return new GesturePoint(x, y, timestamp);
    }
}
