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

public enum DSSourceKind {
    GUI,
    GUI_TEXT,
    ACCOUNT_INFORMATION,
    BLUETOOTH,
    BLUETOOTH_INFORMATION,
    BROWSER_INFORMATION,
    CALENDAR,
    CLIPBOARD,
    CONTENT,
    CONTACT_INFORMATION,
    DATABASE_INFORMATION,
    DATABASE,
    EMAIL,
    EXIF_INFO,
    FILE,
    FILE_INFORMATION,
    IMAGE,
    LOCATION,
    MEDIA,
    NETWORK,
    NFC,
    PREFERENCES,
    SHARED_PREFERENCES,
    RESOURCE,
    SCREEN,
    SENSITIVE_UNCATEGORIZED,
    SMS_MMS,
    SECURITY_INFO,
    SYNCHRONIZATION_DATA,
    SYSTEM_SETTINGS,
    SYSTEM_PROPERTY,
    UNIQUE_IDENTIFIER,
    UNSPECIFIED,
    UNMODELED,
    REFLECTION,
    RANDOM_NUMBER,
    SENSOR,
    SERIALIZATION,
    IPC,
    IO,
    AUDIO,
    USER_INPUT,
    OS_STATE,
    OS_PROCESS,
    XML,
    RESOURCES,
    ANY_MEMORY,
    REMOTE_APP,
    CAMERA,
    DATE_TIME,
    AD,
    GOOGLE_SERVICES, /*a bit too generic */
    GOOGLE_DRIVE,
    JSON,
    WEB,
    ENCODED
}
