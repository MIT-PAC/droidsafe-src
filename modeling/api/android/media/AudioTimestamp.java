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

package android.media;

/**
 * Structure that groups a position in frame units relative to an assumed audio stream,
 * together with the estimated time when that frame was presented or is committed to be
 * presented.
 * In the case of audio output, "present" means that audio produced on device
 * is detectable by an external observer off device.
 * The time is based on the implementation's best effort, using whatever knowledge
 * is available to the system, but cannot account for any delay unknown to the implementation.
 *
 * @see AudioTrack#getTimestamp
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class AudioTimestamp
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:45:03.973 -0400", hash_original_field = "BCEF1C93672FEA18A8733EBAC1D7332C", hash_generated_field = "C34330FE0B6845483BF7D2A451EA5ECE")

    public long framePosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:45:03.985 -0400", hash_original_field = "DE621C80DE57A85A0ED3931A12A7894E", hash_generated_field = "9ACC4BE690609987603B244C52EE9FB5")

    public long nanoTime;
}
