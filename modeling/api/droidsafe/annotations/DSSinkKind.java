/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.annotations;

public enum DSSinkKind {
    ACCOUNT_SETTINGS,
    AUDIO,
    BLUETOOTH,
    BROWSER_INFORMATION,
    CALENDAR,
    CONTACT_INFORMATION,
    CONTENT,  //content provider, resolver
    EMAIL,
    EXIF_INFO,
    FILE,
    LOCATION,
    LOG,
    NETWORK,
    NFC,
    OS_COMMAND,
    PHONE_CONNECTION,
    PHONE_STATE,
    PREFERENCES,
    SCREEN,
    SENSITIVE_UNCATEGORIZED,
    SERIALIZATION,
    SMS_MMS,
    SYNCHRONIZATION_DATA,
    SYSTEM_SETTINGS,
    SHARED_PREFERENCES,
    VOIP,
    UNSPECIFIED,
    USB,
    REFLECTION,
    IPC,
    DATABASE,
    RESOURCES,
    IO,
    PROCESS,
    CLIPBOARD,
    ANY_MEMORY,
    AD,
    GOOGLE_SERVICES,
    GOOGLE_DRIVE,
    GUI,
    EXEC
}
