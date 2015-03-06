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
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2007 The Android Open Source Project
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.media;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.IContentProvider;
import android.database.Cursor;
import android.database.SQLException;
import android.drm.DrmManagerClient;
import android.graphics.BitmapFactory;
import android.mtp.MtpConstants;
import android.net.Uri;
import android.os.Environment;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.provider.MediaStore;
import android.provider.Settings;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video;
import android.provider.MediaStore.Audio.Playlists;
import android.sax.Element;
import android.sax.ElementListener;
import android.sax.RootElement;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Internal service helper that no-one should use directly.
 *
 * The way the scan currently works is:
 * - The Java MediaScannerService creates a MediaScanner (this class), and calls
 *   MediaScanner.scanDirectories on it.
 * - scanDirectories() calls the native processDirectory() for each of the specified directories.
 * - the processDirectory() JNI method wraps the provided mediascanner client in a native
 *   'MyMediaScannerClient' class, then calls processDirectory() on the native MediaScanner
 *   object (which got created when the Java MediaScanner was created).
 * - native MediaScanner.processDirectory() (currently part of opencore) calls
 *   doProcessDirectory(), which recurses over the folder, and calls
 *   native MyMediaScannerClient.scanFile() for every file whose extension matches.
 * - native MyMediaScannerClient.scanFile() calls back on Java MediaScannerClient.scanFile,
 *   which calls doScanFile, which after some setup calls back down to native code, calling
 *   MediaScanner.processFile().
 * - MediaScanner.processFile() calls one of several methods, depending on the type of the
 *   file: parseMP3, parseMP4, parseMidi, parseOgg or parseWMA.
 * - each of these methods gets metadata key/value pairs from the file, and repeatedly
 *   calls native MyMediaScannerClient.handleStringTag, which calls back up to its Java
 *   counterparts in this file.
 * - Java handleStringTag() gathers the key/value pairs that it's interested in.
 * - once processFile returns and we're back in Java code in doScanFile(), it calls
 *   Java MyMediaScannerClient.endFile(), which takes all the data that's been
 *   gathered and inserts an entry in to the database.
 *
 * In summary:
 * Java MediaScannerService calls
 * Java MediaScanner scanDirectories, which calls
 * Java MediaScanner processDirectory (native method), which calls
 * native MediaScanner processDirectory, which calls
 * native MyMediaScannerClient scanFile, which calls
 * Java MyMediaScannerClient scanFile, which calls
 * Java MediaScannerClient doScanFile, which calls
 * Java MediaScanner processFile (native method), which calls
 * native MediaScanner processFile, which calls
 * native parseMP3, parseMP4, parseMidi, parseOgg or parseWMA, which calls
 * native MyMediaScanner handleStringTag, which calls
 * Java MyMediaScanner handleStringTag.
 * Once MediaScanner processFile returns, an entry is inserted in to the database.
 *
 * The MediaScanner class is not thread-safe, so it should only be used in a single threaded manner.
 *
 * {@hide}
 */
public class MediaScanner
{
    static {
        System.loadLibrary("media_jni");
        native_init();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.061 -0400", hash_original_field = "1B9E4A5FDA1296CE78BC6D5BCD671FFB", hash_generated_field = "41F2F3240626996372C97234D04329BE")

    private final static String TAG = "MediaScanner";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.066 -0400", hash_original_field = "C9F430E557A44261A77736E225F1FC93", hash_generated_field = "16E50C22DC2C6C186FD44814B4CEF145")

    private static final String[] FILES_PRESCAN_PROJECTION = new String[] {
            Files.FileColumns._ID, // 0
            Files.FileColumns.DATA, // 1
            Files.FileColumns.FORMAT, // 2
            Files.FileColumns.DATE_MODIFIED, // 3
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.070 -0400", hash_original_field = "CC7F74A8BAFE59070A4347A2CFAB8C1D", hash_generated_field = "78FBBE18B07CAF8553C78B6BCA629584")

    private static final String[] ID_PROJECTION = new String[] {
            Files.FileColumns._ID,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.074 -0400", hash_original_field = "45F7F74610F610B98CBC88F17AB57072", hash_generated_field = "82451A6BB84821A9C7EF1F0A864782E4")

    private static final int FILES_PRESCAN_ID_COLUMN_INDEX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.080 -0400", hash_original_field = "4E95895AE9E42A5EB6863BE64EEC417F", hash_generated_field = "D682581866DC846DE437184F45B80996")

    private static final int FILES_PRESCAN_PATH_COLUMN_INDEX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.084 -0400", hash_original_field = "24EA8625D8DCAE11D7260E9179EF5F21", hash_generated_field = "1A0146B8531D561F2FC1CC6A2462B08C")

    private static final int FILES_PRESCAN_FORMAT_COLUMN_INDEX = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.089 -0400", hash_original_field = "CA3785D2FF069782AAA514CB730ACB13", hash_generated_field = "E8F890D02187D26B5A6990B2753E740B")

    private static final int FILES_PRESCAN_DATE_MODIFIED_COLUMN_INDEX = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.094 -0400", hash_original_field = "1095E43EECA56A2DE14A33CE91DF30D1", hash_generated_field = "4D539A26827BBFA1E60EC944A63C80BF")

    private static final String[] PLAYLIST_MEMBERS_PROJECTION = new String[] {
            Audio.Playlists.Members.PLAYLIST_ID, // 0
     };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.098 -0400", hash_original_field = "E55B2E5A73AE4F40AFA01F841D057FC5", hash_generated_field = "4584CDEAF8E2FA09FF95B58E6AB72471")

    private static final int ID_PLAYLISTS_COLUMN_INDEX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.103 -0400", hash_original_field = "FD8FC1D5FD2509A425AF74B614C75B6C", hash_generated_field = "C3D90E774AE79C7FCFF703D4E3EDE355")

    private static final int PATH_PLAYLISTS_COLUMN_INDEX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.107 -0400", hash_original_field = "4D56583C00E892CE44A77242D23875A2", hash_generated_field = "4531E92240ECD8CA2D53B2BB9C95F865")

    private static final int DATE_MODIFIED_PLAYLISTS_COLUMN_INDEX = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.112 -0400", hash_original_field = "1F077A85366C52F4C62F97ABDEAD7234", hash_generated_field = "1BBC141167C8F7AE98C790E58212DDB9")

    private static final String RINGTONES_DIR = "/ringtones/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.116 -0400", hash_original_field = "0934033B77C8B59249EE2AF74B2867EF", hash_generated_field = "E97B63AB03280D6012529E138AC4FBC0")

    private static final String NOTIFICATIONS_DIR = "/notifications/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.121 -0400", hash_original_field = "6B0CEE4ED2E011E630235B6E47CEA6F9", hash_generated_field = "DEB232C154840D02FAE164647CCCB0A3")

    private static final String ALARMS_DIR = "/alarms/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.125 -0400", hash_original_field = "4593A56B68730E8CC83BD41709489EC4", hash_generated_field = "BBE277ED6B5DA72CCE1215F1D019BA8C")

    private static final String MUSIC_DIR = "/music/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.130 -0400", hash_original_field = "7DD982193BAC5829AADEF2F7F6F36671", hash_generated_field = "0A3716EEA806ABE52837324DC01FEAD0")

    private static final String PODCAST_DIR = "/podcasts/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.140 -0400", hash_original_field = "8F316F1A0D59440137E88A0FC253D2B6", hash_generated_field = "2CD804A0BD4538BF01FCAD8C5F4CD5EC")

    private static final String[] ID3_GENRES = {
        // ID3v1 Genres
        "Blues",
        "Classic Rock",
        "Country",
        "Dance",
        "Disco",
        "Funk",
        "Grunge",
        "Hip-Hop",
        "Jazz",
        "Metal",
        "New Age",
        "Oldies",
        "Other",
        "Pop",
        "R&B",
        "Rap",
        "Reggae",
        "Rock",
        "Techno",
        "Industrial",
        "Alternative",
        "Ska",
        "Death Metal",
        "Pranks",
        "Soundtrack",
        "Euro-Techno",
        "Ambient",
        "Trip-Hop",
        "Vocal",
        "Jazz+Funk",
        "Fusion",
        "Trance",
        "Classical",
        "Instrumental",
        "Acid",
        "House",
        "Game",
        "Sound Clip",
        "Gospel",
        "Noise",
        "AlternRock",
        "Bass",
        "Soul",
        "Punk",
        "Space",
        "Meditative",
        "Instrumental Pop",
        "Instrumental Rock",
        "Ethnic",
        "Gothic",
        "Darkwave",
        "Techno-Industrial",
        "Electronic",
        "Pop-Folk",
        "Eurodance",
        "Dream",
        "Southern Rock",
        "Comedy",
        "Cult",
        "Gangsta",
        "Top 40",
        "Christian Rap",
        "Pop/Funk",
        "Jungle",
        "Native American",
        "Cabaret",
        "New Wave",
        "Psychadelic",
        "Rave",
        "Showtunes",
        "Trailer",
        "Lo-Fi",
        "Tribal",
        "Acid Punk",
        "Acid Jazz",
        "Polka",
        "Retro",
        "Musical",
        "Rock & Roll",
        "Hard Rock",
        // The following genres are Winamp extensions
        "Folk",
        "Folk-Rock",
        "National Folk",
        "Swing",
        "Fast Fusion",
        "Bebob",
        "Latin",
        "Revival",
        "Celtic",
        "Bluegrass",
        "Avantgarde",
        "Gothic Rock",
        "Progressive Rock",
        "Psychedelic Rock",
        "Symphonic Rock",
        "Slow Rock",
        "Big Band",
        "Chorus",
        "Easy Listening",
        "Acoustic",
        "Humour",
        "Speech",
        "Chanson",
        "Opera",
        "Chamber Music",
        "Sonata",
        "Symphony",
        "Booty Bass",
        "Primus",
        "Porn Groove",
        "Satire",
        "Slow Jam",
        "Club",
        "Tango",
        "Samba",
        "Folklore",
        "Ballad",
        "Power Ballad",
        "Rhythmic Soul",
        "Freestyle",
        "Duet",
        "Punk Rock",
        "Drum Solo",
        "A capella",
        "Euro-House",
        "Dance Hall",
        // The following ones seem to be fairly widely supported as well
        "Goa",
        "Drum & Bass",
        "Club-House",
        "Hardcore",
        "Terror",
        "Indie",
        "Britpop",
        "Negerpunk",
        "Polsk Punk",
        "Beat",
        "Christian Gangsta",
        "Heavy Metal",
        "Black Metal",
        "Crossover",
        "Contemporary Christian",
        "Christian Rock",
        "Merengue",
        "Salsa",
        "Thrash Metal",
        "Anime",
        "JPop",
        "Synthpop",
        // 148 and up don't seem to have been defined yet.
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.194 -0400", hash_original_field = "B75AC952C42302225DB9BDE29A37FD1D", hash_generated_field = "03FFBF60EB1C2530C47BF4F6CCE3E908")

    // but unfortunately it also introduced a number of bugs.  Many of those bugs were fixed,
    // but (at least) one problem is still outstanding:
    //
    // - Bulk inserts broke the code that sets the default ringtones, notifications, and alarms
    //   on first boot
    //
    // This problem might be solvable by moving the logic to the media provider or disabling bulk
    // inserts only for those cases. For now, we are disabling bulk inserts until we have a solid
    // fix for this problem.
    private static final boolean ENABLE_BULK_INSERTS = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.232 -0400", hash_original_field = "059AAD54C038CAEC2E07B5BE566B7C71", hash_generated_field = "60775A97C5ADD23CD45CAF4872479080")

    private static final String DEFAULT_RINGTONE_PROPERTY_PREFIX = "ro.config.";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.509 -0400", hash_original_method = "3F083D21B60C2E6DC35AA52C7523C6C3", hash_generated_method = "88DAF0E738D28168ACE5786256D98791")
    
private static boolean isNoMediaFile(String path) {
        File file = new File(path);
        if (file.isDirectory()) return false;

        // special case certain file names
        // I use regionMatches() instead of substring() below
        // to avoid memory allocation
        int lastSlash = path.lastIndexOf('/');
        if (lastSlash >= 0 && lastSlash + 2 < path.length()) {
            // ignore those ._* files created by MacOS
            if (path.regionMatches(lastSlash + 1, "._", 0, 2)) {
                return true;
            }

            // ignore album art files created by Windows Media Player:
            // Folder.jpg, AlbumArtSmall.jpg, AlbumArt_{...}_Large.jpg
            // and AlbumArt_{...}_Small.jpg
            if (path.regionMatches(true, path.length() - 4, ".jpg", 0, 4)) {
                if (path.regionMatches(true, lastSlash + 1, "AlbumArt_{", 0, 10) ||
                        path.regionMatches(true, lastSlash + 1, "AlbumArt.", 0, 9)) {
                    return true;
                }
                int length = path.length() - lastSlash - 1;
                if ((length == 17 && path.regionMatches(
                        true, lastSlash + 1, "AlbumArtSmall", 0, 13)) ||
                        (length == 10
                         && path.regionMatches(true, lastSlash + 1, "Folder", 0, 6))) {
                    return true;
                }
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.514 -0400", hash_original_method = "E038D45C431C03F63F11AE18A39E9EC0", hash_generated_method = "F20F8602EFC92B50F744EB7D0937039C")
    
public static boolean isNoMediaPath(String path) {
        if (path == null) return false;

        // return true if file or any parent directory has name starting with a dot
        if (path.indexOf("/.") >= 0) return true;

        // now check to see if any parent directories have a ".nomedia" file
        // start from 1 so we don't bother checking in the root directory
        int offset = 1;
        while (offset >= 0) {
            int slashIndex = path.indexOf('/', offset);
            if (slashIndex > offset) {
                slashIndex++; // move past slash
                File file = new File(path.substring(0, slashIndex) + ".nomedia");
                if (file.exists()) {
                    // we have a .nomedia in one of the parent directories
                    return true;
                }
            }
            offset = slashIndex;
        }
        return isNoMediaFile(path);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.615 -0400", hash_original_method = "9DACEB091913AFFD29EB0CE9882462AB", hash_generated_method = "0F83FA23DF600A99662CB2DCA62BFB26")
    
    private static final void native_init(){
    	//Formerly a native method
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.144 -0400", hash_original_field = "A4A4998D7B0D1DA56BE7F415CF4F3BBD", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.149 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.153 -0400", hash_original_field = "F9DB4B38F600632EE10B3816F27F7461", hash_generated_field = "C4EC300190CE5D52202461D7E0557B4F")

    private IContentProvider mMediaProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.157 -0400", hash_original_field = "E16616AFEA189D6FC142845628DE6BF1", hash_generated_field = "5D0121966930BDE8783F760AE0B00566")

    private Uri mAudioUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.160 -0400", hash_original_field = "FDC9B522E1F7FC8D282EC0EB10A3C7BA", hash_generated_field = "8CCFA9FE6A0325C43C58814EB2E1FC52")

    private Uri mVideoUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.165 -0400", hash_original_field = "2D2296BA97D62DE9DE0E04BD76EF30B0", hash_generated_field = "6CAD25B1BED09251AE948FF9BFE24996")

    private Uri mImagesUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.169 -0400", hash_original_field = "3EF271691A264D8453FFAD43CDE0156C", hash_generated_field = "133AA10395317274E2A35313AF972203")

    private Uri mThumbsUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.173 -0400", hash_original_field = "383EEA840E7AAD200D5433A5A4542FFD", hash_generated_field = "0DFC3E7B63FDDCBB1ECD2EE02EEFFE12")

    private Uri mPlaylistsUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.177 -0400", hash_original_field = "BB886AA6B09F205EFEB6C9F7694DE6F2", hash_generated_field = "8BFF136A3740BAD9C70DCE9E4D5855B6")

    private Uri mFilesUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.181 -0400", hash_original_field = "D541D226F5A5074250027CF4D0DFBA3A", hash_generated_field = "FB96EB3878ED3E58E754CFFC8DECF43D")

    private boolean mProcessPlaylists, mProcessGenres;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.185 -0400", hash_original_field = "4322480531E71D54536301D576155742", hash_generated_field = "EBB92F4B5B6D57E1A45191AC1F1FEAEF")

    private int mMtpObjectHandle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.189 -0400", hash_original_field = "4A3D217322886C784D8B4E866EBEC811", hash_generated_field = "C615DB6C87D4B0543F436F7F5621F2FB")

    private  String mExternalStoragePath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.198 -0400", hash_original_field = "11775391315C53786DA15113FAF9F21B", hash_generated_field = "7473FBBE81941F5936D591E99FC0A5CC")

    // old thumbnail files
    private int mOriginalCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.202 -0400", hash_original_field = "025EDDF9B76CAC009578C6E9DCDF0AF7", hash_generated_field = "4E65677DD413C6CDDA42E5A0CB4DFD5F")

    private boolean mWasEmptyPriorToScan = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.206 -0400", hash_original_field = "70AFDA5C0BE4C64C578108BFEE80B07E", hash_generated_field = "27CF7F5477791EE010E210598EF95F5C")

    private boolean mDefaultRingtoneSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.211 -0400", hash_original_field = "5FD0731B32B5E555F84E7ED33C8C8108", hash_generated_field = "FF81C8C25575C84D7CBE94AFD3BBE74E")

    private boolean mDefaultNotificationSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.214 -0400", hash_original_field = "C161F1DAAA9B13922947F7310A2715C4", hash_generated_field = "6720148783F1F60984F686889CC06335")

    private boolean mDefaultAlarmSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.218 -0400", hash_original_field = "E53B848005D0915F8B6C14DBAE18A5B5", hash_generated_field = "301C966C8F5131B85F1B2D92D81F9786")

    private String mDefaultRingtoneFilename;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.222 -0400", hash_original_field = "A5D774A041414123D3D7D19FE8E068A1", hash_generated_field = "542373C692D05147F718ACADBA8C35D2")

    private String mDefaultNotificationFilename;

    private static class FileCacheEntry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.244 -0400", hash_original_field = "F8D501B8343FEEFCFD2BF6C84868BE7E", hash_generated_field = "F8D501B8343FEEFCFD2BF6C84868BE7E")

        long mRowId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.248 -0400", hash_original_field = "1D4D0FAE668EECF10ED75DDC284FFC16", hash_generated_field = "1D4D0FAE668EECF10ED75DDC284FFC16")

        String mPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.252 -0400", hash_original_field = "63B08ECCBCC869FFE3D3680D7466F0DA", hash_generated_field = "63B08ECCBCC869FFE3D3680D7466F0DA")

        long mLastModified;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.255 -0400", hash_original_field = "F274D9A6D075EEEA711AF201B69FCAF4", hash_generated_field = "F274D9A6D075EEEA711AF201B69FCAF4")

        int mFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.258 -0400", hash_original_field = "3323C6B128F37A1835770ED1650FFAE2", hash_generated_field = "3323C6B128F37A1835770ED1650FFAE2")

        boolean mSeenInFileSystem;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.261 -0400", hash_original_field = "82190628336E082CCA66214C1E0CC427", hash_generated_field = "82190628336E082CCA66214C1E0CC427")

        boolean mLastModifiedChanged;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.265 -0400", hash_original_method = "80A6FF9A0F797304BBCC90F4D7F64FF0", hash_generated_method = "80A6FF9A0F797304BBCC90F4D7F64FF0")
        
FileCacheEntry(long rowId, String path, long lastModified, int format) {
            mRowId = rowId;
            mPath = path;
            mLastModified = lastModified;
            mFormat = format;
            mSeenInFileSystem = false;
            mLastModifiedChanged = false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.269 -0400", hash_original_method = "6F1E2B2A8817965D2BC4B732ECC67D6F", hash_generated_method = "AF1285E275D854179DAC6E7043C01D10")
        
@Override
        public String toString() {
            return mPath + " mRowId: " + mRowId;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.227 -0400", hash_original_field = "D4E9115FE616D939D40AC39D1C720A36", hash_generated_field = "6CAEB674268C640191FC9051AF8553E3")

    private String mDefaultAlarmAlertFilename;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.236 -0400", hash_original_field = "701CDE3B39BD5E0CE1BF891D499684FE", hash_generated_field = "068495AE7D3976C0CF10A54E4C1FBA9B")

    // this should be set when scanning files on a case insensitive file system.
    private boolean mCaseInsensitivePaths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.240 -0400", hash_original_field = "CB4D2A9A30166F32913FF91112AF5F85", hash_generated_field = "9073907CBE78776DB3D82963F09B99C1")

    private BitmapFactory.Options mBitmapOptions = new BitmapFactory.Options();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.277 -0400", hash_original_field = "B3990FEA9EC259A0AA8003D61A946AD2", hash_generated_field = "4BB0B8D1E3932D6A223C079298272F2F")

    private MediaInserter mMediaInserter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.281 -0400", hash_original_field = "1BF2BABAC35481DB877A28A83D563A93", hash_generated_field = "74F74F1775F8824013BBDD36FF4F1363")

    // path should be lower case if mCaseInsensitivePaths is true
    private HashMap<String, FileCacheEntry> mFileCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.285 -0400", hash_original_field = "0D39BE7E8F641B9A14ED3AB075901B0D", hash_generated_field = "B0505421625F2269DAC50D3C69B06B90")

    private ArrayList<FileCacheEntry> mPlayLists;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.289 -0400", hash_original_field = "817EEDDF333C63740955B06EA19E288C", hash_generated_field = "B3DBBD0746A148BC82FB9F737DB5EAB8")

    private DrmManagerClient mDrmManagerClient = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.300 -0400", hash_original_field = "B6BBB12242227A13233624FC93E5E4C8", hash_generated_field = "F121F1DB331E3A6884085D96377FE6DF")

    private MyMediaScannerClient mClient = new MyMediaScannerClient();

    private class MyMediaScannerClient implements MediaScannerClient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.308 -0400", hash_original_field = "22B225E9F231F796AF6C45AE0D8D3BA0", hash_generated_field = "D8849471015CBFFC396FFECCAE15E4AE")

        private String mArtist;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.311 -0400", hash_original_field = "4DBE31670429CE4E209F02BB919DC72E", hash_generated_field = "B2495105664AE90DCE7778D68765ACAE")

        private String mAlbumArtist;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.315 -0400", hash_original_field = "E2CE74CE836DA3B02A51987596B083E0", hash_generated_field = "7A05288FFB26AFE95D38CDD81AE491DC")

        private String mAlbum;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.319 -0400", hash_original_field = "16E0C5A3FE98D2D22AD69EC7A123442F", hash_generated_field = "F874AFA927FA7D19042AF93F53067D66")

        private String mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.323 -0400", hash_original_field = "4687C27E94DAB5B58B64C6D63E265ECB", hash_generated_field = "39CAE2B22C4D7C3CF540902351DBD56F")

        private String mComposer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.327 -0400", hash_original_field = "B1BEC3C462B9A311B9426F27BF567439", hash_generated_field = "DB1E93B2CBB8FA8D2F8854F22A97EA15")

        private String mGenre;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.331 -0400", hash_original_field = "B161F982909610C03B68BAACDD54E076", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

        private String mMimeType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.335 -0400", hash_original_field = "B8585C6C0D750119A5B3756D550C2547", hash_generated_field = "1B324C3CBEF520BC70FF18C7EEAF13BC")

        private int mFileType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.338 -0400", hash_original_field = "DE180C10A23828A28BE6816B920C7974", hash_generated_field = "7662A478843FF5AF2A2A192E6F9F8A2F")

        private int mTrack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.342 -0400", hash_original_field = "5823940FC0F93D8457936B751136F711", hash_generated_field = "0FB397B5159C15D66CFFB31661F31030")

        private int mYear;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.346 -0400", hash_original_field = "BC345057CF9CBE8611DA24E477E3EC27", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

        private int mDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.349 -0400", hash_original_field = "1D4D0FAE668EECF10ED75DDC284FFC16", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

        private String mPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.352 -0400", hash_original_field = "63B08ECCBCC869FFE3D3680D7466F0DA", hash_generated_field = "86357F1FB7D7E26145031DD2121F0A3B")

        private long mLastModified;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.356 -0400", hash_original_field = "35A68A6367191D97A256C26E4CA387EB", hash_generated_field = "933CBC105DD1B9E186D4C02B708C9E9D")

        private long mFileSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.360 -0400", hash_original_field = "C568062F8B869B32E2545D605F8E15CE", hash_generated_field = "E3D7C6FCBBBB21A8F6F324D195F78CDA")

        private String mWriter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.363 -0400", hash_original_field = "083CC35153CAA963A42B5A31861ADCA6", hash_generated_field = "051FA0BF1B538B2782187331BA0F8A86")

        private int mCompilation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.368 -0400", hash_original_field = "42D0A79E949E91491FF8B6985FC3BF9E", hash_generated_field = "6A17D38DFC9E75468A84FB5D3D5CBB50")

        private boolean mIsDrm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.371 -0400", hash_original_field = "BC95DA465F2A2B93AE26281A6F699CA6", hash_generated_field = "E05A81EF22C98743D3E5553AB84B4FF3")

        private boolean mNoMedia;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.375 -0400", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

        private int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.378 -0400", hash_original_field = "7DDAE255893B528E7BEBEC203BC2D9F3", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

        private int mHeight;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.384 -0400", hash_original_method = "CCF1B05F78D6FE6A9AE0657B5712183A", hash_generated_method = "B29CB41F3AF46414E7B101657BAE713F")
        
public FileCacheEntry beginFile(String path, String mimeType, long lastModified,
                long fileSize, boolean isDirectory, boolean noMedia) {
            mMimeType = mimeType;
            mFileType = 0;
            mFileSize = fileSize;

            if (!isDirectory) {
                if (!noMedia && isNoMediaFile(path)) {
                    noMedia = true;
                }
                mNoMedia = noMedia;

                // try mimeType first, if it is specified
                if (mimeType != null) {
                    mFileType = MediaFile.getFileTypeForMimeType(mimeType);
                }

                // if mimeType was not specified, compute file type based on file extension.
                if (mFileType == 0) {
                    MediaFile.MediaFileType mediaFileType = MediaFile.getFileType(path);
                    if (mediaFileType != null) {
                        mFileType = mediaFileType.fileType;
                        if (mMimeType == null) {
                            mMimeType = mediaFileType.mimeType;
                        }
                    }
                }

                if (isDrmEnabled() && MediaFile.isDrmFileType(mFileType)) {
                    mFileType = getFileTypeFromDrm(path);
                }
            }

            String key = path;
            if (mCaseInsensitivePaths) {
                key = path.toLowerCase();
            }
            FileCacheEntry entry = mFileCache.get(key);
            // add some slack to avoid a rounding error
            long delta = (entry != null) ? (lastModified - entry.mLastModified) : 0;
            boolean wasModified = delta > 1 || delta < -1;
            if (entry == null || wasModified) {
                if (wasModified) {
                    entry.mLastModified = lastModified;
                } else {
                    entry = new FileCacheEntry(0, path, lastModified,
                            (isDirectory ? MtpConstants.FORMAT_ASSOCIATION : 0));
                    mFileCache.put(key, entry);
                }
                entry.mLastModifiedChanged = true;
            }
            entry.mSeenInFileSystem = true;

            if (mProcessPlaylists && MediaFile.isPlayListFileType(mFileType)) {
                mPlayLists.add(entry);
                // we don't process playlists in the main scan, so return null
                return null;
            }

            // clear all the metadata
            mArtist = null;
            mAlbumArtist = null;
            mAlbum = null;
            mTitle = null;
            mComposer = null;
            mGenre = null;
            mTrack = 0;
            mYear = 0;
            mDuration = 0;
            mPath = path;
            mLastModified = lastModified;
            mWriter = null;
            mCompilation = 0;
            mIsDrm = false;
            mWidth = 0;
            mHeight = 0;

            return entry;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.388 -0400", hash_original_method = "7D7296BE7CB4FB1F544E0331D22109CF", hash_generated_method = "4929B36FA8E86E13DB4F7CC944FDD1F2")
        
@Override
        public void scanFile(String path, long lastModified, long fileSize,
                boolean isDirectory, boolean noMedia) {
            // This is the callback funtion from native codes.
            // Log.v(TAG, "scanFile: "+path);
            doScanFile(path, null, lastModified, fileSize, isDirectory, false, noMedia);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.393 -0400", hash_original_method = "6ED3B544E0E2EB618904B7068B794039", hash_generated_method = "23554D7355D6B789FA7971E24E274BB1")
        
public Uri doScanFile(String path, String mimeType, long lastModified,
                long fileSize, boolean isDirectory, boolean scanAlways, boolean noMedia) {
            Uri result = null;
//            long t1 = System.currentTimeMillis();
            try {
                FileCacheEntry entry = beginFile(path, mimeType, lastModified,
                        fileSize, isDirectory, noMedia);
                // rescan for metadata if file was modified since last scan
                if (entry != null && (entry.mLastModifiedChanged || scanAlways)) {
                    if (noMedia) {
                        result = endFile(entry, false, false, false, false, false);
                    } else {
                        String lowpath = path.toLowerCase();
                        boolean ringtones = (lowpath.indexOf(RINGTONES_DIR) > 0);
                        boolean notifications = (lowpath.indexOf(NOTIFICATIONS_DIR) > 0);
                        boolean alarms = (lowpath.indexOf(ALARMS_DIR) > 0);
                        boolean podcasts = (lowpath.indexOf(PODCAST_DIR) > 0);
                        boolean music = (lowpath.indexOf(MUSIC_DIR) > 0) ||
                            (!ringtones && !notifications && !alarms && !podcasts);

                        // we only extract metadata for audio and video files
                        if (MediaFile.isAudioFileType(mFileType)
                                || MediaFile.isVideoFileType(mFileType)) {
                            processFile(path, mimeType, this);
                        }

                        if (MediaFile.isImageFileType(mFileType)) {
                            processImageFile(path);
                        }

                        result = endFile(entry, ringtones, notifications, alarms, music, podcasts);
                    }
                }
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException in MediaScanner.scanFile()", e);
            }
//            long t2 = System.currentTimeMillis();
//            Log.v(TAG, "scanFile: " + path + " took " + (t2-t1));
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.398 -0400", hash_original_method = "F8DD50C2DE54A19DA270B430A3B82A0E", hash_generated_method = "7E419DEB70E01A5348A75413DB0486AD")
        
private int parseSubstring(String s, int start, int defaultValue) {
            int length = s.length();
            if (start == length) return defaultValue;

            char ch = s.charAt(start++);
            // return defaultValue if we have no integer at all
            if (ch < '0' || ch > '9') return defaultValue;

            int result = ch - '0';
            while (start < length) {
                ch = s.charAt(start++);
                if (ch < '0' || ch > '9') return result;
                result = result * 10 + (ch - '0');
            }

            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.405 -0400", hash_original_method = "DC1DE83A3BBAC9C06A3CD27082B0BD45", hash_generated_method = "39AE2298E7C8E2FEE8799479891F52DF")
        
public void handleStringTag(String name, String value) {
            if (name.equalsIgnoreCase("title") || name.startsWith("title;")) {
                // Don't trim() here, to preserve the special \001 character
                // used to force sorting. The media provider will trim() before
                // inserting the title in to the database.
                mTitle = value;
            } else if (name.equalsIgnoreCase("artist") || name.startsWith("artist;")) {
                mArtist = value.trim();
            } else if (name.equalsIgnoreCase("albumartist") || name.startsWith("albumartist;")
                    || name.equalsIgnoreCase("band") || name.startsWith("band;")) {
                mAlbumArtist = value.trim();
            } else if (name.equalsIgnoreCase("album") || name.startsWith("album;")) {
                mAlbum = value.trim();
            } else if (name.equalsIgnoreCase("composer") || name.startsWith("composer;")) {
                mComposer = value.trim();
            } else if (mProcessGenres &&
                    (name.equalsIgnoreCase("genre") || name.startsWith("genre;"))) {
                mGenre = getGenreName(value);
            } else if (name.equalsIgnoreCase("year") || name.startsWith("year;")) {
                mYear = parseSubstring(value, 0, 0);
            } else if (name.equalsIgnoreCase("tracknumber") || name.startsWith("tracknumber;")) {
                // track number might be of the form "2/12"
                // we just read the number before the slash
                int num = parseSubstring(value, 0, 0);
                mTrack = (mTrack / 1000) * 1000 + num;
            } else if (name.equalsIgnoreCase("discnumber") ||
                    name.equals("set") || name.startsWith("set;")) {
                // set number might be of the form "1/3"
                // we just read the number before the slash
                int num = parseSubstring(value, 0, 0);
                mTrack = (num * 1000) + (mTrack % 1000);
            } else if (name.equalsIgnoreCase("duration")) {
                mDuration = parseSubstring(value, 0, 0);
            } else if (name.equalsIgnoreCase("writer") || name.startsWith("writer;")) {
                mWriter = value.trim();
            } else if (name.equalsIgnoreCase("compilation")) {
                mCompilation = parseSubstring(value, 0, 0);
            } else if (name.equalsIgnoreCase("isdrm")) {
                mIsDrm = (parseSubstring(value, 0, 0) == 1);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.409 -0400", hash_original_method = "E5383835DD64A357474D7B305ECD7013", hash_generated_method = "8AC3448673FC39E90A33D80483DBA549")
        
public String getGenreName(String genreTagValue) {

            if (genreTagValue == null) {
                return null;
            }
            final int length = genreTagValue.length();

            if (length > 0 && genreTagValue.charAt(0) == '(') {
                StringBuffer number = new StringBuffer();
                int i = 1;
                for (; i < length - 1; ++i) {
                    char c = genreTagValue.charAt(i);
                    if (Character.isDigit(c)) {
                        number.append(c);
                    } else {
                        break;
                    }
                }
                if (genreTagValue.charAt(i) == ')') {
                    try {
                        short genreIndex = Short.parseShort(number.toString());
                        if (genreIndex >= 0) {
                            if (genreIndex < ID3_GENRES.length) {
                                return ID3_GENRES[genreIndex];
                            } else if (genreIndex == 0xFF) {
                                return null;
                            } else if (genreIndex < 0xFF && (i + 1) < length) {
                                // genre is valid but unknown,
                                // if there is a string after the value we take it
                                return genreTagValue.substring(i + 1);
                            } else {
                                // else return the number, without parentheses
                                return number.toString();
                            }
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }

            return genreTagValue;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.413 -0400", hash_original_method = "28659DFD792364B5F9CDBC846B696FD8", hash_generated_method = "E6A122F9E826ACC77B1D1961F09F1406")
        
private void processImageFile(String path) {
            try {
                mBitmapOptions.outWidth = 0;
                mBitmapOptions.outHeight = 0;
                BitmapFactory.decodeFile(path, mBitmapOptions);
                mWidth = mBitmapOptions.outWidth;
                mHeight = mBitmapOptions.outHeight;
            } catch (Throwable th) {
                // ignore;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.417 -0400", hash_original_method = "FBF71BCD717D66198D51638F82545D3C", hash_generated_method = "A68ED739C0A866F6F7F8F3D70FD7E000")
        
public void setMimeType(String mimeType) {
            if ("audio/mp4".equals(mMimeType) &&
                    mimeType.startsWith("video")) {
                // for feature parity with Donut, we force m4a files to keep the
                // audio/mp4 mimetype, even if they are really "enhanced podcasts"
                // with a video track
                return;
            }
            mMimeType = mimeType;
            mFileType = MediaFile.getFileTypeForMimeType(mimeType);
        }

        /**
         * Formats the data into a values array suitable for use with the Media
         * Content Provider.
         *
         * @return a map of values
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.423 -0400", hash_original_method = "193D8407C7F47AF7E61D4646969A2F9A", hash_generated_method = "DB552426ACF60CB19ED3AFB8ADA728F0")
        
private ContentValues toValues() {
            ContentValues map = new ContentValues();

            map.put(MediaStore.MediaColumns.DATA, mPath);
            map.put(MediaStore.MediaColumns.TITLE, mTitle);
            map.put(MediaStore.MediaColumns.DATE_MODIFIED, mLastModified);
            map.put(MediaStore.MediaColumns.SIZE, mFileSize);
            map.put(MediaStore.MediaColumns.MIME_TYPE, mMimeType);
            map.put(MediaStore.MediaColumns.IS_DRM, mIsDrm);

            if (mWidth > 0 && mHeight > 0) {
                map.put(MediaStore.MediaColumns.WIDTH, mWidth);
                map.put(MediaStore.MediaColumns.HEIGHT, mHeight);
            }

            if (!mNoMedia) {
                if (MediaFile.isVideoFileType(mFileType)) {
                    map.put(Video.Media.ARTIST, (mArtist != null && mArtist.length() > 0
                            ? mArtist : MediaStore.UNKNOWN_STRING));
                    map.put(Video.Media.ALBUM, (mAlbum != null && mAlbum.length() > 0
                            ? mAlbum : MediaStore.UNKNOWN_STRING));
                    map.put(Video.Media.DURATION, mDuration);
                    // FIXME - add RESOLUTION
                } else if (MediaFile.isImageFileType(mFileType)) {
                    // FIXME - add DESCRIPTION
                } else if (MediaFile.isAudioFileType(mFileType)) {
                    map.put(Audio.Media.ARTIST, (mArtist != null && mArtist.length() > 0) ?
                            mArtist : MediaStore.UNKNOWN_STRING);
                    map.put(Audio.Media.ALBUM_ARTIST, (mAlbumArtist != null &&
                            mAlbumArtist.length() > 0) ? mAlbumArtist : null);
                    map.put(Audio.Media.ALBUM, (mAlbum != null && mAlbum.length() > 0) ?
                            mAlbum : MediaStore.UNKNOWN_STRING);
                    map.put(Audio.Media.COMPOSER, mComposer);
                    map.put(Audio.Media.GENRE, mGenre);
                    if (mYear != 0) {
                        map.put(Audio.Media.YEAR, mYear);
                    }
                    map.put(Audio.Media.TRACK, mTrack);
                    map.put(Audio.Media.DURATION, mDuration);
                    map.put(Audio.Media.COMPILATION, mCompilation);
                }
            }
            return map;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.436 -0400", hash_original_method = "1F89D81ABBDF5001F73F42A157794875", hash_generated_method = "C4AF2897432534E5771532B57338D67E")
        
private Uri endFile(FileCacheEntry entry, boolean ringtones, boolean notifications,
                boolean alarms, boolean music, boolean podcasts)
                throws RemoteException {
            // update database

            // use album artist if artist is missing
            if (mArtist == null || mArtist.length() == 0) {
                mArtist = mAlbumArtist;
            }

            ContentValues values = toValues();
            String title = values.getAsString(MediaStore.MediaColumns.TITLE);
            if (title == null || TextUtils.isEmpty(title.trim())) {
                title = MediaFile.getFileTitle(values.getAsString(MediaStore.MediaColumns.DATA));
                values.put(MediaStore.MediaColumns.TITLE, title);
            }
            String album = values.getAsString(Audio.Media.ALBUM);
            if (MediaStore.UNKNOWN_STRING.equals(album)) {
                album = values.getAsString(MediaStore.MediaColumns.DATA);
                // extract last path segment before file name
                int lastSlash = album.lastIndexOf('/');
                if (lastSlash >= 0) {
                    int previousSlash = 0;
                    while (true) {
                        int idx = album.indexOf('/', previousSlash + 1);
                        if (idx < 0 || idx >= lastSlash) {
                            break;
                        }
                        previousSlash = idx;
                    }
                    if (previousSlash != 0) {
                        album = album.substring(previousSlash + 1, lastSlash);
                        values.put(Audio.Media.ALBUM, album);
                    }
                }
            }
            long rowId = entry.mRowId;
            if (MediaFile.isAudioFileType(mFileType) && (rowId == 0 || mMtpObjectHandle != 0)) {
                // Only set these for new entries. For existing entries, they
                // may have been modified later, and we want to keep the current
                // values so that custom ringtones still show up in the ringtone
                // picker.
                values.put(Audio.Media.IS_RINGTONE, ringtones);
                values.put(Audio.Media.IS_NOTIFICATION, notifications);
                values.put(Audio.Media.IS_ALARM, alarms);
                values.put(Audio.Media.IS_MUSIC, music);
                values.put(Audio.Media.IS_PODCAST, podcasts);
            } else if (mFileType == MediaFile.FILE_TYPE_JPEG && !mNoMedia) {
                ExifInterface exif = null;
                try {
                    exif = new ExifInterface(entry.mPath);
                } catch (IOException ex) {
                    // exif is null
                }
                if (exif != null) {
                    float[] latlng = new float[2];
                    if (exif.getLatLong(latlng)) {
                        values.put(Images.Media.LATITUDE, latlng[0]);
                        values.put(Images.Media.LONGITUDE, latlng[1]);
                    }

                    long time = exif.getGpsDateTime();
                    if (time != -1) {
                        values.put(Images.Media.DATE_TAKEN, time);
                    } else {
                        // If no time zone information is available, we should consider using
                        // EXIF local time as taken time if the difference between file time
                        // and EXIF local time is not less than 1 Day, otherwise MediaProvider
                        // will use file time as taken time.
                        time = exif.getDateTime();
                        if (Math.abs(mLastModified * 1000 - time) >= 86400000) {
                            values.put(Images.Media.DATE_TAKEN, time);
                        }
                    }

                    int orientation = exif.getAttributeInt(
                        ExifInterface.TAG_ORIENTATION, -1);
                    if (orientation != -1) {
                        // We only recognize a subset of orientation tag values.
                        int degree;
                        switch(orientation) {
                            case ExifInterface.ORIENTATION_ROTATE_90:
                                degree = 90;
                                break;
                            case ExifInterface.ORIENTATION_ROTATE_180:
                                degree = 180;
                                break;
                            case ExifInterface.ORIENTATION_ROTATE_270:
                                degree = 270;
                                break;
                            default:
                                degree = 0;
                                break;
                        }
                        values.put(Images.Media.ORIENTATION, degree);
                    }
                }
            }

            Uri tableUri = mFilesUri;
            MediaInserter inserter = mMediaInserter;
            if (!mNoMedia) {
                if (MediaFile.isVideoFileType(mFileType)) {
                    tableUri = mVideoUri;
                } else if (MediaFile.isImageFileType(mFileType)) {
                    tableUri = mImagesUri;
                } else if (MediaFile.isAudioFileType(mFileType)) {
                    tableUri = mAudioUri;
                }
            }
            Uri result = null;
            if (rowId == 0) {
                if (mMtpObjectHandle != 0) {
                    values.put(MediaStore.MediaColumns.MEDIA_SCANNER_NEW_OBJECT_ID, mMtpObjectHandle);
                }
                if (tableUri == mFilesUri) {
                    int format = entry.mFormat;
                    if (format == 0) {
                        format = MediaFile.getFormatCode(entry.mPath, mMimeType);
                    }
                    values.put(Files.FileColumns.FORMAT, format);
                }
                // new file, insert it
                // We insert directories immediately to ensure they are in the database
                // before the files they contain.
                // Otherwise we can get duplicate directory entries in the database
                // if one of the media FileInserters is flushed before the files table FileInserter
                if (inserter == null || entry.mFormat == MtpConstants.FORMAT_ASSOCIATION) {
                    result = mMediaProvider.insert(tableUri, values);
                } else {
                    inserter.insert(tableUri, values);
                }

                if (result != null) {
                    rowId = ContentUris.parseId(result);
                    entry.mRowId = rowId;
                }
            } else {
                // updated file
                result = ContentUris.withAppendedId(tableUri, rowId);
                // path should never change, and we want to avoid replacing mixed cased paths
                // with squashed lower case paths
                values.remove(MediaStore.MediaColumns.DATA);
                mMediaProvider.update(result, values, null, null);
            }

            if (notifications && mWasEmptyPriorToScan && !mDefaultNotificationSet) {
                if (TextUtils.isEmpty(mDefaultNotificationFilename) ||
                        doesPathHaveFilename(entry.mPath, mDefaultNotificationFilename)) {
                    setSettingIfNotSet(Settings.System.NOTIFICATION_SOUND, tableUri, rowId);
                    mDefaultNotificationSet = true;
                }
            } else if (ringtones && mWasEmptyPriorToScan && !mDefaultRingtoneSet) {
                if (TextUtils.isEmpty(mDefaultRingtoneFilename) ||
                        doesPathHaveFilename(entry.mPath, mDefaultRingtoneFilename)) {
                    setSettingIfNotSet(Settings.System.RINGTONE, tableUri, rowId);
                    mDefaultRingtoneSet = true;
                }
            } else if (alarms && mWasEmptyPriorToScan && !mDefaultAlarmSet) {
                if (TextUtils.isEmpty(mDefaultAlarmAlertFilename) ||
                        doesPathHaveFilename(entry.mPath, mDefaultAlarmAlertFilename)) {
                    setSettingIfNotSet(Settings.System.ALARM_ALERT, tableUri, rowId);
                    mDefaultAlarmSet = true;
                }
            }

            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.440 -0400", hash_original_method = "2A39FB38C8CEDFE73496018B10D8B84F", hash_generated_method = "A4BCC385ACE9DC4372B8B59241AE23EE")
        
private boolean doesPathHaveFilename(String path, String filename) {
            int pathFilenameStart = path.lastIndexOf(File.separatorChar) + 1;
            int filenameLength = filename.length();
            return path.regionMatches(pathFilenameStart, filename, 0, filenameLength) &&
                    pathFilenameStart + filenameLength == path.length();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.444 -0400", hash_original_method = "0AAB9247F6B57BAD13B6EDC8D9586CF4", hash_generated_method = "95F675F8EDA0F07ABBAEE3D5555C1A23")
        
private void setSettingIfNotSet(String settingName, Uri uri, long rowId) {

            String existingSettingValue = Settings.System.getString(mContext.getContentResolver(),
                    settingName);

            if (TextUtils.isEmpty(existingSettingValue)) {
                // Set the setting to the given URI
                Settings.System.putString(mContext.getContentResolver(), settingName,
                        ContentUris.withAppendedId(uri, rowId).toString());
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.448 -0400", hash_original_method = "15C5CC9BDDCBD92BAF33756965FEFBCC", hash_generated_method = "B52B0136C7A307F85078E1879A1B3797")
        
private int getFileTypeFromDrm(String path) {
            if (!isDrmEnabled()) {
                return 0;
            }

            int resultFileType = 0;

            if (mDrmManagerClient == null) {
                mDrmManagerClient = new DrmManagerClient(mContext);
            }

            if (mDrmManagerClient.canHandle(path, null)) {
                String drmMimetype = mDrmManagerClient.getOriginalMimeType(path);
                if (drmMimetype != null) {
                    mMimeType = drmMimetype;
                    resultFileType = MediaFile.getFileTypeForMimeType(drmMimetype);
                }
            }
            return resultFileType;
        }

    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.292 -0400", hash_original_method = "F63924A66867770C93541CB0F1B889AD", hash_generated_method = "1C0BCF3DB73D66C750407A002AB58D19")
    
public MediaScanner(Context c) {
        native_setup();
        mContext = c;
        mBitmapOptions.inSampleSize = 1;
        mBitmapOptions.inJustDecodeBounds = true;

        setDefaultRingtoneFileNames();

        mExternalStoragePath = Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.296 -0400", hash_original_method = "7A02CAB84651A5C3B33A0484376AAD27", hash_generated_method = "35C19F0DD30EAF69CABBE8FD51B4EF80")
    
private void setDefaultRingtoneFileNames() {
        mDefaultRingtoneFilename = SystemProperties.get(DEFAULT_RINGTONE_PROPERTY_PREFIX
                + Settings.System.RINGTONE);
        mDefaultNotificationFilename = SystemProperties.get(DEFAULT_RINGTONE_PROPERTY_PREFIX
                + Settings.System.NOTIFICATION_SOUND);
        mDefaultAlarmAlertFilename = SystemProperties.get(DEFAULT_RINGTONE_PROPERTY_PREFIX
                + Settings.System.ALARM_ALERT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.303 -0400", hash_original_method = "D9C1138E389F415E442B46769F48D19E", hash_generated_method = "3774E2621BFC2AFE6E710BDE19112DAD")
    
private boolean isDrmEnabled() {
        String prop = SystemProperties.get("drm.service.enabled");
        return prop != null && prop.equals("true");
    } // end of anonymous MediaScannerClient instance

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.476 -0400", hash_original_method = "C48B3E0565E0357AC753F780CEB287FA", hash_generated_method = "C8A545980D5D2BB69A77BB0A38966BE2")
    
private void prescan(String filePath, boolean prescanFiles) throws RemoteException {
        Cursor c = null;
        String where = null;
        String[] selectionArgs = null;

        if (mFileCache == null) {
            mFileCache = new HashMap<String, FileCacheEntry>();
        } else {
            mFileCache.clear();
        }
        if (mPlayLists == null) {
            mPlayLists = new ArrayList<FileCacheEntry>();
        } else {
            mPlayLists.clear();
        }

        if (filePath != null) {
            // query for only one file
            where = Files.FileColumns.DATA + "=?";
            selectionArgs = new String[] { filePath };
        }

        // Build the list of files from the content provider
        try {
            if (prescanFiles) {
                // First read existing files from the files table

                c = mMediaProvider.query(mFilesUri, FILES_PRESCAN_PROJECTION,
                        where, selectionArgs, null);

                if (c != null) {
                    mWasEmptyPriorToScan = c.getCount() == 0;
                    while (c.moveToNext()) {
                        long rowId = c.getLong(FILES_PRESCAN_ID_COLUMN_INDEX);
                        String path = c.getString(FILES_PRESCAN_PATH_COLUMN_INDEX);
                        int format = c.getInt(FILES_PRESCAN_FORMAT_COLUMN_INDEX);
                        long lastModified = c.getLong(FILES_PRESCAN_DATE_MODIFIED_COLUMN_INDEX);

                        // Only consider entries with absolute path names.
                        // This allows storing URIs in the database without the
                        // media scanner removing them.
                        if (path != null && path.startsWith("/")) {
                            String key = path;
                            if (mCaseInsensitivePaths) {
                                key = path.toLowerCase();
                            }

                            FileCacheEntry entry = new FileCacheEntry(rowId, path,
                                    lastModified, format);
                            mFileCache.put(key, entry);
                        }
                    }
                    c.close();
                    c = null;
                }
            }
        }
        finally {
            if (c != null) {
                c.close();
            }
        }

        // compute original size of images
        mOriginalCount = 0;
        c = mMediaProvider.query(mImagesUri, ID_PROJECTION, null, null, null);
        if (c != null) {
            mOriginalCount = c.getCount();
            c.close();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.480 -0400", hash_original_method = "9105DEF5286250B32ED3635CD740DB30", hash_generated_method = "9D268C219A0DE715394BB93F7D4BE24E")
    
private boolean inScanDirectory(String path, String[] directories) {
        for (int i = 0; i < directories.length; i++) {
            String directory = directories[i];
            if (path.startsWith(directory)) {
                return true;
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.485 -0400", hash_original_method = "6EC27B2D19C87A2201365229C6B8C025", hash_generated_method = "B0CFCD45CFE3D68BA68B2D08E366E145")
    
private void pruneDeadThumbnailFiles() {
        HashSet<String> existingFiles = new HashSet<String>();
        String directory = "/sdcard/DCIM/.thumbnails";
        String [] files = (new File(directory)).list();
        if (files == null)
            files = new String[0];

        for (int i = 0; i < files.length; i++) {
            String fullPathString = directory + "/" + files[i];
            existingFiles.add(fullPathString);
        }

        try {
            Cursor c = mMediaProvider.query(
                    mThumbsUri,
                    new String [] { "_data" },
                    null,
                    null,
                    null);
            Log.v(TAG, "pruneDeadThumbnailFiles... " + c);
            if (c != null && c.moveToFirst()) {
                do {
                    String fullPathString = c.getString(0);
                    existingFiles.remove(fullPathString);
                } while (c.moveToNext());
            }

            for (String fileToDelete : existingFiles) {
                if (false)
                    Log.v(TAG, "fileToDelete is " + fileToDelete);
                try {
                    (new File(fileToDelete)).delete();
                } catch (SecurityException ex) {
                }
            }

            Log.v(TAG, "/pruneDeadThumbnailFiles... " + c);
            if (c != null) {
                c.close();
            }
        } catch (RemoteException e) {
            // We will soon be killed...
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.491 -0400", hash_original_method = "CD0C2AE722B971409B73CA519F964B98", hash_generated_method = "BE7C022E4D4454DD9D5B5F7040131361")
    
private void postscan(String[] directories) throws RemoteException {
        Iterator<FileCacheEntry> iterator = mFileCache.values().iterator();

        while (iterator.hasNext()) {
            FileCacheEntry entry = iterator.next();
            String path = entry.mPath;

            // remove database entries for files that no longer exist.
            boolean fileMissing = false;

            if (!entry.mSeenInFileSystem && !MtpConstants.isAbstractObject(entry.mFormat)) {
                if (inScanDirectory(path, directories)) {
                    // we didn't see this file in the scan directory.
                    fileMissing = true;
                } else {
                    // the file actually a directory or other abstract object
                    // or is outside of our scan directory,
                    // so we need to check for file existence here.
                    File testFile = new File(path);
                    if (!testFile.exists()) {
                        fileMissing = true;
                    }
                }
            }

            if (fileMissing) {
                // Clear the file path to prevent the _DELETE_FILE database hook
                // in the media provider from deleting the file.
                // If the file is truly gone the delete is unnecessary, and we want to avoid
                // accidentally deleting files that are really there.
                ContentValues values = new ContentValues();
                values.put(Files.FileColumns.DATA, "");
                values.put(Files.FileColumns.DATE_MODIFIED, 0);
                mMediaProvider.update(ContentUris.withAppendedId(mFilesUri, entry.mRowId),
                        values, null, null);

                // do not delete missing playlists, since they may have been modified by the user.
                // the user can delete them in the media player instead.
                // instead, clear the path and lastModified fields in the row
                MediaFile.MediaFileType mediaFileType = MediaFile.getFileType(path);
                int fileType = (mediaFileType == null ? 0 : mediaFileType.fileType);

                if (!MediaFile.isPlayListFileType(fileType)) {
                    mMediaProvider.delete(ContentUris.withAppendedId(mFilesUri, entry.mRowId),
                            null, null);
                    iterator.remove();
                }
            }
        }

        // handle playlists last, after we know what media files are on the storage.
        if (mProcessPlaylists) {
            processPlayLists();
        }

        if (mOriginalCount == 0 && mImagesUri.equals(Images.Media.getContentUri("external")))
            pruneDeadThumbnailFiles();

        // allow GC to clean up
        mPlayLists = null;
        mFileCache = null;
        mMediaProvider = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.495 -0400", hash_original_method = "15E0D6BD0551A1844E53B265DAFE6443", hash_generated_method = "70BCF0AAAA65C4A651042F1FE5299490")
    
private void initialize(String volumeName) {
        mMediaProvider = mContext.getContentResolver().acquireProvider("media");

        mAudioUri = Audio.Media.getContentUri(volumeName);
        mVideoUri = Video.Media.getContentUri(volumeName);
        mImagesUri = Images.Media.getContentUri(volumeName);
        mThumbsUri = Images.Thumbnails.getContentUri(volumeName);
        mFilesUri = Files.getContentUri(volumeName);

        if (!volumeName.equals("internal")) {
            // we only support playlists on external media
            mProcessPlaylists = true;
            mProcessGenres = true;
            mPlaylistsUri = Playlists.getContentUri(volumeName);

            mCaseInsensitivePaths = true;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.500 -0400", hash_original_method = "01C8436BDC470EB1CA37F551644BDFAA", hash_generated_method = "E461CA154C8368CCE62D841576D41A98")
    
public void scanDirectories(String[] directories, String volumeName) {
        try {
            long start = System.currentTimeMillis();
            initialize(volumeName);
            prescan(null, true);
            long prescan = System.currentTimeMillis();

            if (ENABLE_BULK_INSERTS) {
                // create MediaInserter for bulk inserts
                mMediaInserter = new MediaInserter(mMediaProvider, 500);
            }

            for (int i = 0; i < directories.length; i++) {
                processDirectory(directories[i], mClient);
            }

            if (ENABLE_BULK_INSERTS) {
                // flush remaining inserts
                mMediaInserter.flushAll();
                mMediaInserter = null;
            }

            long scan = System.currentTimeMillis();
            postscan(directories);
            long end = System.currentTimeMillis();

            if (false) {
                Log.d(TAG, " prescan time: " + (prescan - start) + "ms\n");
                Log.d(TAG, "    scan time: " + (scan - prescan) + "ms\n");
                Log.d(TAG, "postscan time: " + (end - scan) + "ms\n");
                Log.d(TAG, "   total time: " + (end - start) + "ms\n");
            }
        } catch (SQLException e) {
            // this might happen if the SD card is removed while the media scanner is running
            Log.e(TAG, "SQLException in MediaScanner.scan()", e);
        } catch (UnsupportedOperationException e) {
            // this might happen if the SD card is removed while the media scanner is running
            Log.e(TAG, "UnsupportedOperationException in MediaScanner.scan()", e);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in MediaScanner.scan()", e);
        }
    }

    // this function is used to scan a single file
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.504 -0400", hash_original_method = "B418C4B32DFB03B220535E2811438217", hash_generated_method = "397C2F98EA4C72B2BAAC22CFAF7EBE01")
    
public Uri scanSingleFile(String path, String volumeName, String mimeType) {
        try {
            initialize(volumeName);
            prescan(path, true);

            File file = new File(path);

            // lastModified is in milliseconds on Files.
            long lastModifiedSeconds = file.lastModified() / 1000;

            // always scan the file, so we can return the content://media Uri for existing files
            return mClient.doScanFile(path, mimeType, lastModifiedSeconds, file.length(),
                    false, true, false);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in MediaScanner.scanFile()", e);
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.519 -0400", hash_original_method = "542CFB5410DDFD454E0D217285AA989C", hash_generated_method = "5901A942FD87A5E4D561AB942ADA8676")
    
public void scanMtpFile(String path, String volumeName, int objectHandle, int format) {
        initialize(volumeName);
        MediaFile.MediaFileType mediaFileType = MediaFile.getFileType(path);
        int fileType = (mediaFileType == null ? 0 : mediaFileType.fileType);
        File file = new File(path);
        long lastModifiedSeconds = file.lastModified() / 1000;

        if (!MediaFile.isAudioFileType(fileType) && !MediaFile.isVideoFileType(fileType) &&
            !MediaFile.isImageFileType(fileType) && !MediaFile.isPlayListFileType(fileType)) {

            // no need to use the media scanner, but we need to update last modified and file size
            ContentValues values = new ContentValues();
            values.put(Files.FileColumns.SIZE, file.length());
            values.put(Files.FileColumns.DATE_MODIFIED, lastModifiedSeconds);
            try {
                String[] whereArgs = new String[] {  Integer.toString(objectHandle) };
                mMediaProvider.update(Files.getMtpObjectsUri(volumeName), values, "_id=?",
                        whereArgs);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException in scanMtpFile", e);
            }
            return;
        }

        mMtpObjectHandle = objectHandle;
        try {
            if (MediaFile.isPlayListFileType(fileType)) {
                // build file cache so we can look up tracks in the playlist
                prescan(null, true);

                String key = path;
                if (mCaseInsensitivePaths) {
                    key = path.toLowerCase();
                }
                FileCacheEntry entry = mFileCache.get(key);
                if (entry != null) {
                    processPlayList(entry);
                }
            } else {
                // MTP will create a file entry for us so we don't want to do it in prescan
                prescan(path, false);

                // always scan the file, so we can return the content://media Uri for existing files
                mClient.doScanFile(path, mediaFileType.mimeType, lastModifiedSeconds, file.length(),
                    (format == MtpConstants.FORMAT_ASSOCIATION), true, isNoMediaPath(path));
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in MediaScanner.scanFile()", e);
        } finally {
            mMtpObjectHandle = 0;
        }
    }

    // returns the number of matching file/directory names, starting from the right
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.523 -0400", hash_original_method = "013D4DB6932ED78815979CA9529EC8C3", hash_generated_method = "3C0E0D2C3217F4FA512BF48067DC8B94")
    
private int matchPaths(String path1, String path2) {
        int result = 0;
        int end1 = path1.length();
        int end2 = path2.length();

        while (end1 > 0 && end2 > 0) {
            int slash1 = path1.lastIndexOf('/', end1 - 1);
            int slash2 = path2.lastIndexOf('/', end2 - 1);
            int backSlash1 = path1.lastIndexOf('\\', end1 - 1);
            int backSlash2 = path2.lastIndexOf('\\', end2 - 1);
            int start1 = (slash1 > backSlash1 ? slash1 : backSlash1);
            int start2 = (slash2 > backSlash2 ? slash2 : backSlash2);
            if (start1 < 0) start1 = 0; else start1++;
            if (start2 < 0) start2 = 0; else start2++;
            int length = end1 - start1;
            if (end2 - start2 != length) break;
            if (path1.regionMatches(true, start1, path2, start2, length)) {
                result++;
                end1 = start1 - 1;
                end2 = start2 - 1;
            } else break;
        }

        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.529 -0400", hash_original_method = "B51199D8E78A9AC0C645839EBE793573", hash_generated_method = "94C4C25644B9C97BB53474DA113DDFF8")
    
private boolean addPlayListEntry(String entry, String playListDirectory,
            Uri uri, ContentValues values, int index) {

        // watch for trailing whitespace
        int entryLength = entry.length();
        while (entryLength > 0 && Character.isWhitespace(entry.charAt(entryLength - 1))) entryLength--;
        // path should be longer than 3 characters.
        // avoid index out of bounds errors below by returning here.
        if (entryLength < 3) return false;
        if (entryLength < entry.length()) entry = entry.substring(0, entryLength);

        // does entry appear to be an absolute path?
        // look for Unix or DOS absolute paths
        char ch1 = entry.charAt(0);
        boolean fullPath = (ch1 == '/' ||
                (Character.isLetter(ch1) && entry.charAt(1) == ':' && entry.charAt(2) == '\\'));
        // if we have a relative path, combine entry with playListDirectory
        if (!fullPath)
            entry = playListDirectory + entry;

        //FIXME - should we look for "../" within the path?

        // best matching MediaFile for the play list entry
        FileCacheEntry bestMatch = null;

        // number of rightmost file/directory names for bestMatch
        int bestMatchLength = 0;

        Iterator<FileCacheEntry> iterator = mFileCache.values().iterator();
        while (iterator.hasNext()) {
            FileCacheEntry cacheEntry = iterator.next();
            String path = cacheEntry.mPath;

            if (path.equalsIgnoreCase(entry)) {
                bestMatch = cacheEntry;
                break;    // don't bother continuing search
            }

            int matchLength = matchPaths(path, entry);
            if (matchLength > bestMatchLength) {
                bestMatch = cacheEntry;
                bestMatchLength = matchLength;
            }
        }

        if (bestMatch == null) {
            return false;
        }

        try {
            // check rowid is set. Rowid may be missing if it is inserted by bulkInsert().
            if (bestMatch.mRowId == 0) {
                Cursor c = mMediaProvider.query(mAudioUri, ID_PROJECTION,
                        MediaStore.Files.FileColumns.DATA + "=?",
                        new String[] { bestMatch.mPath }, null);
                if (c != null) {
                    if (c.moveToNext()) {
                        bestMatch.mRowId = c.getLong(0);
                    }
                    c.close();
                }
                if (bestMatch.mRowId == 0) {
                    return false;
                }
            }
            // OK, now we are ready to add this to the database
            values.clear();
            values.put(MediaStore.Audio.Playlists.Members.PLAY_ORDER, Integer.valueOf(index));
            values.put(MediaStore.Audio.Playlists.Members.AUDIO_ID, Long.valueOf(bestMatch.mRowId));
            mMediaProvider.insert(uri, values);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in MediaScanner.addPlayListEntry()", e);
            return false;
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.533 -0400", hash_original_method = "D2BD0D151CC2302E7E072A138A709E76", hash_generated_method = "AF14D157CBB0CF02A24190B597B52882")
    
private void processM3uPlayList(String path, String playListDirectory, Uri uri, ContentValues values) {
        BufferedReader reader = null;
        try {
            File f = new File(path);
            if (f.exists()) {
                reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(f)), 8192);
                String line = reader.readLine();
                int index = 0;
                while (line != null) {
                    // ignore comment lines, which begin with '#'
                    if (line.length() > 0 && line.charAt(0) != '#') {
                        values.clear();
                        if (addPlayListEntry(line, playListDirectory, uri, values, index))
                            index++;
                    }
                    line = reader.readLine();
                }
            }
        } catch (IOException e) {
            Log.e(TAG, "IOException in MediaScanner.processM3uPlayList()", e);
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                Log.e(TAG, "IOException in MediaScanner.processM3uPlayList()", e);
            }
        }
    }

    class WplHandler implements ElementListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.542 -0400", hash_original_field = "72DFA99F316215C323A7733A2B6F975E", hash_generated_field = "72DFA99F316215C323A7733A2B6F975E")

         ContentHandler handler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.546 -0400", hash_original_field = "705961060831E9B3244774CA9AFB69D6", hash_generated_field = "705961060831E9B3244774CA9AFB69D6")

        String playListDirectory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.549 -0400", hash_original_field = "F30A3503738FDB118E2076C7F22FF172", hash_generated_field = "F30A3503738FDB118E2076C7F22FF172")

        Uri uri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.552 -0400", hash_original_field = "CA764D217CB44D3138B10ACBE58FB348", hash_generated_field = "CA764D217CB44D3138B10ACBE58FB348")

        ContentValues values = new ContentValues();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.555 -0400", hash_original_field = "47C32AAF84C84D33B0EA3C852250FE1D", hash_generated_field = "47C32AAF84C84D33B0EA3C852250FE1D")

        int index = 0;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.559 -0400", hash_original_method = "5EB5C3EF72366ACE1CC3769C45E52EC1", hash_generated_method = "423DF841975DCD65206E3CE7103F953A")
        
public WplHandler(String playListDirectory, Uri uri) {
            this.playListDirectory = playListDirectory;
            this.uri = uri;

            RootElement root = new RootElement("smil");
            Element body = root.getChild("body");
            Element seq = body.getChild("seq");
            Element media = seq.getChild("media");
            media.setElementListener(this);

            this.handler = root.getContentHandler();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.563 -0400", hash_original_method = "89BA57E042EAC9BB9893657343EF4EEB", hash_generated_method = "D895DE3C405337B8509D2DD41FF76A0E")
        
public void start(Attributes attributes) {
            String path = attributes.getValue("", "src");
            if (path != null) {
                values.clear();
                if (addPlayListEntry(path, playListDirectory, uri, values, index)) {
                    index++;
                }
            }
        }

       @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.566 -0400", hash_original_method = "4F105473DD7236D24F8992C8503B57B1", hash_generated_method = "FE6D8DF71959D6F4FDE5F0F03D32C242")
        
public void end() {
       }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.569 -0400", hash_original_method = "B22F9A6D2058A18AF9E71CE233CE908B", hash_generated_method = "B22F9A6D2058A18AF9E71CE233CE908B")
        
ContentHandler getContentHandler() {
            return handler;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.538 -0400", hash_original_method = "EF8BEB229BEFBA66ED07F955722C5040", hash_generated_method = "93981B52F66A9A98DF55843BA5515800")
    
private void processPlsPlayList(String path, String playListDirectory, Uri uri, ContentValues values) {
        BufferedReader reader = null;
        try {
            File f = new File(path);
            if (f.exists()) {
                reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(f)), 8192);
                String line = reader.readLine();
                int index = 0;
                while (line != null) {
                    // ignore comment lines, which begin with '#'
                    if (line.startsWith("File")) {
                        int equals = line.indexOf('=');
                        if (equals > 0) {
                            values.clear();
                            if (addPlayListEntry(line.substring(equals + 1), playListDirectory, uri, values, index))
                                index++;
                        }
                    }
                    line = reader.readLine();
                }
            }
        } catch (IOException e) {
            Log.e(TAG, "IOException in MediaScanner.processPlsPlayList()", e);
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                Log.e(TAG, "IOException in MediaScanner.processPlsPlayList()", e);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.575 -0400", hash_original_method = "3412C93BEA4BE34BBCF79B22D039CF8D", hash_generated_method = "709A759449647240BA1141CA5AA5E85A")
    
private void processWplPlayList(String path, String playListDirectory, Uri uri) {
        FileInputStream fis = null;
        try {
            File f = new File(path);
            if (f.exists()) {
                fis = new FileInputStream(f);

                Xml.parse(fis, Xml.findEncodingByName("UTF-8"), new WplHandler(playListDirectory, uri).getContentHandler());
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                Log.e(TAG, "IOException in MediaScanner.processWplPlayList()", e);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.580 -0400", hash_original_method = "9256A183300393BB49948A3060AE11B2", hash_generated_method = "B9F82C8F9288B2FB2DD8A42B85105ED0")
    
private void processPlayList(FileCacheEntry entry) throws RemoteException {
        String path = entry.mPath;
        ContentValues values = new ContentValues();
        int lastSlash = path.lastIndexOf('/');
        if (lastSlash < 0) throw new IllegalArgumentException("bad path " + path);
        Uri uri, membersUri;
        long rowId = entry.mRowId;

        // make sure we have a name
        String name = values.getAsString(MediaStore.Audio.Playlists.NAME);
        if (name == null) {
            name = values.getAsString(MediaStore.MediaColumns.TITLE);
            if (name == null) {
                // extract name from file name
                int lastDot = path.lastIndexOf('.');
                name = (lastDot < 0 ? path.substring(lastSlash + 1)
                        : path.substring(lastSlash + 1, lastDot));
            }
        }

        values.put(MediaStore.Audio.Playlists.NAME, name);
        values.put(MediaStore.Audio.Playlists.DATE_MODIFIED, entry.mLastModified);

        if (rowId == 0) {
            values.put(MediaStore.Audio.Playlists.DATA, path);
            uri = mMediaProvider.insert(mPlaylistsUri, values);
            rowId = ContentUris.parseId(uri);
            membersUri = Uri.withAppendedPath(uri, Playlists.Members.CONTENT_DIRECTORY);
        } else {
            uri = ContentUris.withAppendedId(mPlaylistsUri, rowId);
            mMediaProvider.update(uri, values, null, null);

            // delete members of existing playlist
            membersUri = Uri.withAppendedPath(uri, Playlists.Members.CONTENT_DIRECTORY);
            mMediaProvider.delete(membersUri, null, null);
        }

        String playListDirectory = path.substring(0, lastSlash + 1);
        MediaFile.MediaFileType mediaFileType = MediaFile.getFileType(path);
        int fileType = (mediaFileType == null ? 0 : mediaFileType.fileType);

        if (fileType == MediaFile.FILE_TYPE_M3U) {
            processM3uPlayList(path, playListDirectory, membersUri, values);
        } else if (fileType == MediaFile.FILE_TYPE_PLS) {
            processPlsPlayList(path, playListDirectory, membersUri, values);
        } else if (fileType == MediaFile.FILE_TYPE_WPL) {
            processWplPlayList(path, playListDirectory, membersUri);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.585 -0400", hash_original_method = "E457F3A8DFC5A7C54CAE6FC2441195ED", hash_generated_method = "C8B7E086AFD94463E7D1C14AF0FFC813")
    
private void processPlayLists() throws RemoteException {
        Iterator<FileCacheEntry> iterator = mPlayLists.iterator();
        while (iterator.hasNext()) {
            FileCacheEntry entry = iterator.next();
            // only process playlist files if they are new or have been modified since the last scan
            if (entry.mLastModifiedChanged) {
                processPlayList(entry);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.594 -0400", hash_original_method = "FB635C2419B335141D698CFB0AFE8BD3", hash_generated_method = "6E827FCEC61FFDA7BD635B648E5AF7DB")
    
    private void processDirectory(String path, MediaScannerClient client){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	taintDouble += client.getTaintInt();
    	addTaint(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.600 -0400", hash_original_method = "C899B847F2A5E3D446E237381FB91512", hash_generated_method = "B79BD5E015EA172363F83D612F64FB62")
    
    private void processFile(String path, String mimeType, MediaScannerClient client){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	taintDouble += mimeType.getTaintInt();
    	taintDouble += client.getTaintInt();
    	addTaint(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.604 -0400", hash_original_method = "14770B9914BD8F1A300B2311A4083869", hash_generated_method = "687E34FC4F41F92ED4B50586BCADD697")
    
    public void setLocale(String locale){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += locale.getTaintInt();
    	addTaint(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.609 -0400", hash_original_method = "427980118EC6FD0FE31E55D23F645BCC", hash_generated_method = "76CE00BB7E90B404C479DC90BD82C306")
    
    public byte[] extractAlbumArt(FileDescriptor fd){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += fd.getTaintInt();
    	addTaint(taintDouble);
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.620 -0400", hash_original_method = "B91E9A85D17B4C3984DC1E936380BF22", hash_generated_method = "40C1EAE506328FBBECFF0048FCF2E8D2")
    
    private final void native_setup(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.625 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "F4F0ABEE314221212592CD2BBD7D2805")
    
    private final void native_finalize(){
    	//Formerly a native method
    }

    /**
     * Releases resouces associated with this MediaScanner object.
     * It is considered good practice to call this method when
     * one is done using the MediaScanner object. After this method
     * is called, the MediaScanner object can no longer be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.628 -0400", hash_original_method = "A10A7F78FAFA9C62D1FB8ECA76AC4918", hash_generated_method = "72EF1B312308CD180765D68D965399FE")
    
public void release() {
        native_finalize();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:03.631 -0400", hash_original_method = "6FFFD5AC5802A001D88B918C6B5BBC7B", hash_generated_method = "28A780B9B2F0FCDFC6DC40A44F29707D")
    
@Override
    protected void finalize() {
        mContext.getContentResolver().releaseProvider(mMediaProvider);
        native_finalize();
    }
}
