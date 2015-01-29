/*
 * Copyright (C) 2010 The Android Open Source Project
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

package android.mtp;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.IContentProvider;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.MediaColumns;
import android.util.Log;

import java.util.ArrayList;

class MtpPropertyGroup {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.981 -0400", hash_original_field = "73CC6CBA830E87C1C04AFA6995F563F3", hash_generated_field = "1A3F054E945881C63A32DC200F7B4E15")


    private static final String TAG = "MtpPropertyGroup";

    private class Property {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.983 -0400", hash_original_field = "0AB25991A8A700F155BF903F62C1F5DA", hash_generated_field = "0AB25991A8A700F155BF903F62C1F5DA")

        int     code;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.984 -0400", hash_original_field = "961B4204667A4AE2FF8DD374E6728ADE", hash_generated_field = "961B4204667A4AE2FF8DD374E6728ADE")

        int     type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.985 -0400", hash_original_field = "90576625319AB666908247B08CE7D656", hash_generated_field = "90576625319AB666908247B08CE7D656")

        int     column;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.987 -0400", hash_original_method = "3EF013367F7F3ED72D62AA6C7FECD6F5", hash_generated_method = "3EF013367F7F3ED72D62AA6C7FECD6F5")
        
Property(int code, int type, int column) {
            this.code = code;
            this.type = type;
            this.column = column;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.000 -0400", hash_original_field = "999539F445E598BE2FBA28CB51D94D01", hash_generated_field = "B29C95CF1E3DD1E3D028195B00D41907")


    private static final String ID_WHERE = Files.FileColumns._ID + "=?";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.002 -0400", hash_original_field = "F5EA0E5392FF230014616202DECEC1CB", hash_generated_field = "91C40577BD562EC1EA38AC0210E2F7D8")

    private static final String FORMAT_WHERE = Files.FileColumns.FORMAT + "=?";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.004 -0400", hash_original_field = "724D249F76850EB14E2B02AD4249B67B", hash_generated_field = "C2ACFBD621F4EA67BDC40EBFE92E8BAA")

    private static final String ID_FORMAT_WHERE = ID_WHERE + " AND " + FORMAT_WHERE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.006 -0400", hash_original_field = "04DA05819C66AAB80A65C1EA9C075297", hash_generated_field = "0D6747A28CE1AED24141DCD0C8D1081C")

    private static final String PARENT_WHERE = Files.FileColumns.PARENT + "=?";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.008 -0400", hash_original_field = "0EC309C0E5B0BBF367BB8AFBC046D252", hash_generated_field = "5630A94E0DEAC9593AFDD2BFAD11D89B")

    private static final String PARENT_FORMAT_WHERE = PARENT_WHERE + " AND " + FORMAT_WHERE;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.024 -0400", hash_original_method = "3C870140DE8C782BB3722553C7C10E35", hash_generated_method = "6C51275756066079A40DB3060B45D3EF")
    
private static String nameFromPath(String path) {
        // extract name from full path
        int start = 0;
        int lastSlash = path.lastIndexOf('/');
        if (lastSlash >= 0) {
            start = lastSlash + 1;
        }
        int end = path.length();
        if (end - start > 255) {
            end = start + 255;
        }
        return path.substring(start, end);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.989 -0400", hash_original_field = "329C457A226E1094754BA6D26663771C", hash_generated_field = "06EC3FF86CA576C24401BF57793FCB4D")


    private  MtpDatabase mDatabase;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.991 -0400", hash_original_field = "4165A1FBAFFD21863CC0EAC1937582F7", hash_generated_field = "358248BDBAA0C39D138E82A554F14381")

    private  IContentProvider mProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.993 -0400", hash_original_field = "F488B59709DB2C8A92AEFD40ED5E30F9", hash_generated_field = "9D1FFAB509CBA702BE86D582470A09F0")

    private  String mVolumeName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.995 -0400", hash_original_field = "49226456B4CE4E55A779249DE3DC63D4", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

    private  Uri mUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.997 -0400", hash_original_field = "CF0C569F12CBCE9D74A21E4511E1C727", hash_generated_field = "3934D890903D83A955F7B9F612B48D83")

    private  Property[]    mProperties;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.998 -0400", hash_original_field = "05C6FA34740ED8752F22266873F75802", hash_generated_field = "53DC72E56AF72859CCB6315DB649FC3E")

    private String[]             mColumns;
    // constructs a property group for a list of properties
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.011 -0400", hash_original_method = "573EF47807397D84EAE941341E85AEEF", hash_generated_method = "8BB90ED6067164705C04A259D3D5778F")
    
public MtpPropertyGroup(MtpDatabase database, IContentProvider provider, String volume,
            int[] properties) {
        mDatabase = database;
        mProvider = provider;
        mVolumeName = volume;
        mUri = Files.getMtpObjectsUri(volume);

        int count = properties.length;
        ArrayList<String> columns = new ArrayList<String>(count);
        columns.add(Files.FileColumns._ID);

        mProperties = new Property[count];
        for (int i = 0; i < count; i++) {
            mProperties[i] = createProperty(properties[i], columns);
        }
        count = columns.size();
        mColumns = new String[count];
        for (int i = 0; i < count; i++) {
            mColumns[i] = columns.get(i);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.014 -0400", hash_original_method = "094A69B5BFD45F45ECE261E1D014A841", hash_generated_method = "10A4114EFD686C2DBC1DFCCFB5A75143")
    
private Property createProperty(int code, ArrayList<String> columns) {
        String column = null;
        int type;

         switch (code) {
            case MtpConstants.PROPERTY_STORAGE_ID:
                column = Files.FileColumns.STORAGE_ID;
                type = MtpConstants.TYPE_UINT32;
                break;
             case MtpConstants.PROPERTY_OBJECT_FORMAT:
                column = Files.FileColumns.FORMAT;
                type = MtpConstants.TYPE_UINT16;
                break;
            case MtpConstants.PROPERTY_PROTECTION_STATUS:
                // protection status is always 0
                type = MtpConstants.TYPE_UINT16;
                break;
            case MtpConstants.PROPERTY_OBJECT_SIZE:
                column = Files.FileColumns.SIZE;
                type = MtpConstants.TYPE_UINT64;
                break;
            case MtpConstants.PROPERTY_OBJECT_FILE_NAME:
                column = Files.FileColumns.DATA;
                type = MtpConstants.TYPE_STR;
                break;
            case MtpConstants.PROPERTY_NAME:
                column = MediaColumns.TITLE;
                type = MtpConstants.TYPE_STR;
                break;
            case MtpConstants.PROPERTY_DATE_MODIFIED:
                column = Files.FileColumns.DATE_MODIFIED;
                type = MtpConstants.TYPE_STR;
                break;
            case MtpConstants.PROPERTY_DATE_ADDED:
                column = Files.FileColumns.DATE_ADDED;
                type = MtpConstants.TYPE_STR;
                break;
            case MtpConstants.PROPERTY_ORIGINAL_RELEASE_DATE:
                column = Audio.AudioColumns.YEAR;
                type = MtpConstants.TYPE_STR;
                break;
            case MtpConstants.PROPERTY_PARENT_OBJECT:
                column = Files.FileColumns.PARENT;
                type = MtpConstants.TYPE_UINT32;
                break;
            case MtpConstants.PROPERTY_PERSISTENT_UID:
                // PUID is concatenation of storageID and object handle
                column = Files.FileColumns.STORAGE_ID;
                type = MtpConstants.TYPE_UINT128;
                break;
            case MtpConstants.PROPERTY_DURATION:
                column = Audio.AudioColumns.DURATION;
                type = MtpConstants.TYPE_UINT32;
                break;
            case MtpConstants.PROPERTY_TRACK:
                column = Audio.AudioColumns.TRACK;
                type = MtpConstants.TYPE_UINT16;
                break;
            case MtpConstants.PROPERTY_DISPLAY_NAME:
                column = MediaColumns.DISPLAY_NAME;
                type = MtpConstants.TYPE_STR;
                break;
            case MtpConstants.PROPERTY_ARTIST:
                type = MtpConstants.TYPE_STR;
                break;
            case MtpConstants.PROPERTY_ALBUM_NAME:
                type = MtpConstants.TYPE_STR;
                break;
            case MtpConstants.PROPERTY_ALBUM_ARTIST:
                column = Audio.AudioColumns.ALBUM_ARTIST;
                type = MtpConstants.TYPE_STR;
                break;
            case MtpConstants.PROPERTY_GENRE:
                // genre requires a special query
                type = MtpConstants.TYPE_STR;
                break;
            case MtpConstants.PROPERTY_COMPOSER:
                column = Audio.AudioColumns.COMPOSER;
                type = MtpConstants.TYPE_STR;
                break;
            case MtpConstants.PROPERTY_DESCRIPTION:
                column = Images.ImageColumns.DESCRIPTION;
                type = MtpConstants.TYPE_STR;
                break;
            default:
                type = MtpConstants.TYPE_UNDEFINED;
                Log.e(TAG, "unsupported property " + code);
                break;
        }

        if (column != null) {
            columns.add(column);
            return new Property(code, type, columns.size() - 1);
        } else {
            return new Property(code, type, -1);
        }
    }

   @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.016 -0400", hash_original_method = "CBB3B1C5796EE519FB7D5A0F0137EF62", hash_generated_method = "D166B3E4DF8AB431B5021C2D9CD62BBF")
    
private String queryString(int id, String column) {
        Cursor c = null;
        try {
            // for now we are only reading properties from the "objects" table
            c = mProvider.query(mUri,
                            new String [] { Files.FileColumns._ID, column },
                            ID_WHERE, new String[] { Integer.toString(id) }, null);
            if (c != null && c.moveToNext()) {
                return c.getString(1);
            } else {
                return "";
            }
        } catch (Exception e) {
            return null;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.018 -0400", hash_original_method = "207F7A33A95C466590DB9C293C8C1353", hash_generated_method = "3E77415E13564216486657E293550F18")
    
private String queryAudio(int id, String column) {
        Cursor c = null;
        try {
            c = mProvider.query(Audio.Media.getContentUri(mVolumeName),
                            new String [] { Files.FileColumns._ID, column },
                            ID_WHERE, new String[] { Integer.toString(id) }, null);
            if (c != null && c.moveToNext()) {
                return c.getString(1);
            } else {
                return "";
            }
        } catch (Exception e) {
            return null;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.020 -0400", hash_original_method = "413180D4C9AFB73BD4E4DCD1F3C1CAAB", hash_generated_method = "059DAF5F1F13578DEFC90320393A20BE")
    
private String queryGenre(int id) {
        Cursor c = null;
        try {
            Uri uri = Audio.Genres.getContentUriForAudioId(mVolumeName, id);
            c = mProvider.query(uri,
                            new String [] { Files.FileColumns._ID, Audio.GenresColumns.NAME },
                            null, null, null);
            if (c != null && c.moveToNext()) {
                return c.getString(1);
            } else {
                return "";
            }
        } catch (Exception e) {
            Log.e(TAG, "queryGenre exception", e);
            return null;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.022 -0400", hash_original_method = "F6173FDA53016A79298F983962DE255F", hash_generated_method = "389AE1242D3FE184E0CA2EABAFA1CC9E")
    
private Long queryLong(int id, String column) {
        Cursor c = null;
        try {
            // for now we are only reading properties from the "objects" table
            c = mProvider.query(mUri,
                            new String [] { Files.FileColumns._ID, column },
                            ID_WHERE, new String[] { Integer.toString(id) }, null);
            if (c != null && c.moveToNext()) {
                return new Long(c.getLong(1));
            }
        } catch (Exception e) {
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.029 -0400", hash_original_method = "80D18D9E92EC861F116A65BAF589253C", hash_generated_method = "FBD74ADD3EA1DA5EA60DA2B832BA9FC5")
    
MtpPropertyList getPropertyList(int handle, int format, int depth) {
        //Log.d(TAG, "getPropertyList handle: " + handle + " format: " + format + " depth: " + depth);
        if (depth > 1) {
            // we only support depth 0 and 1
            // depth 0: single object, depth 1: immediate children
            return new MtpPropertyList(0, MtpConstants.RESPONSE_SPECIFICATION_BY_DEPTH_UNSUPPORTED);
        }

        String where;
        String[] whereArgs;
        if (format == 0) {
            if (handle == 0xFFFFFFFF) {
                // select all objects
                where = null;
                whereArgs = null;
            } else {
                whereArgs = new String[] { Integer.toString(handle) };
                if (depth == 1) {
                    where = PARENT_WHERE;
                } else {
                    where = ID_WHERE;
                }
            }
        } else {
            if (handle == 0xFFFFFFFF) {
                // select all objects with given format
                where = FORMAT_WHERE;
                whereArgs = new String[] { Integer.toString(format) };
            } else {
                whereArgs = new String[] { Integer.toString(handle), Integer.toString(format) };
                if (depth == 1) {
                    where = PARENT_FORMAT_WHERE;
                } else {
                    where = ID_FORMAT_WHERE;
                }
            }
        }

        Cursor c = null;
        try {
            // don't query if not necessary
            if (depth > 0 || handle == 0xFFFFFFFF || mColumns.length > 1) {
                c = mProvider.query(mUri, mColumns, where, whereArgs, null);
                if (c == null) {
                    return new MtpPropertyList(0, MtpConstants.RESPONSE_INVALID_OBJECT_HANDLE);
                }
            }

            int count = (c == null ? 1 : c.getCount());
            MtpPropertyList result = new MtpPropertyList(count * mProperties.length,
                    MtpConstants.RESPONSE_OK);

            // iterate over all objects in the query
            for (int objectIndex = 0; objectIndex < count; objectIndex++) {
                if (c != null) {
                    c.moveToNext();
                    handle = (int)c.getLong(0);
                }

                // iterate over all properties in the query for the given object
                for (int propertyIndex = 0; propertyIndex < mProperties.length; propertyIndex++) {
                    Property property = mProperties[propertyIndex];
                    int propertyCode = property.code;
                    int column = property.column;

                    // handle some special cases
                    switch (propertyCode) {
                        case MtpConstants.PROPERTY_PROTECTION_STATUS:
                            // protection status is always 0
                            result.append(handle, propertyCode, MtpConstants.TYPE_UINT16, 0);
                            break;
                        case MtpConstants.PROPERTY_OBJECT_FILE_NAME:
                            // special case - need to extract file name from full path
                            String value = c.getString(column);
                            if (value != null) {
                                result.append(handle, propertyCode, nameFromPath(value));
                            } else {
                                result.setResult(MtpConstants.RESPONSE_INVALID_OBJECT_HANDLE);
                            }
                            break;
                        case MtpConstants.PROPERTY_NAME:
                            // first try title
                            String name = c.getString(column);
                            // then try name
                            if (name == null) {
                                name = queryString(handle, Audio.PlaylistsColumns.NAME);
                            }
                            // if title and name fail, extract name from full path
                            if (name == null) {
                                name = queryString(handle, Files.FileColumns.DATA);
                                if (name != null) {
                                    name = nameFromPath(name);
                                }
                            }
                            if (name != null) {
                                result.append(handle, propertyCode, name);
                            } else {
                                result.setResult(MtpConstants.RESPONSE_INVALID_OBJECT_HANDLE);
                            }
                            break;
                        case MtpConstants.PROPERTY_DATE_MODIFIED:
                        case MtpConstants.PROPERTY_DATE_ADDED:
                            // convert from seconds to DateTime
                            result.append(handle, propertyCode, format_date_time(c.getInt(column)));
                            break;
                        case MtpConstants.PROPERTY_ORIGINAL_RELEASE_DATE:
                            // release date is stored internally as just the year
                            int year = c.getInt(column);
                            String dateTime = Integer.toString(year) + "0101T000000";
                            result.append(handle, propertyCode, dateTime);
                            break;
                        case MtpConstants.PROPERTY_PERSISTENT_UID:
                            // PUID is concatenation of storageID and object handle
                            long puid = c.getLong(column);
                            puid <<= 32;
                            puid += handle;
                            result.append(handle, propertyCode, MtpConstants.TYPE_UINT128, puid);
                            break;
                        case MtpConstants.PROPERTY_TRACK:
                            result.append(handle, propertyCode, MtpConstants.TYPE_UINT16,
                                        c.getInt(column) % 1000);
                            break;
                        case MtpConstants.PROPERTY_ARTIST:
                            result.append(handle, propertyCode,
                                    queryAudio(handle, Audio.AudioColumns.ARTIST));
                            break;
                        case MtpConstants.PROPERTY_ALBUM_NAME:
                            result.append(handle, propertyCode,
                                    queryAudio(handle, Audio.AudioColumns.ALBUM));
                            break;
                        case MtpConstants.PROPERTY_GENRE:
                            String genre = queryGenre(handle);
                            if (genre != null) {
                                result.append(handle, propertyCode, genre);
                            } else {
                                result.setResult(MtpConstants.RESPONSE_INVALID_OBJECT_HANDLE);
                            }
                            break;
                        default:
                            if (property.type == MtpConstants.TYPE_STR) {
                                result.append(handle, propertyCode, c.getString(column));
                            } else if (property.type == MtpConstants.TYPE_UNDEFINED) {
                                result.append(handle, propertyCode, property.type, 0);
                            } else {
                                result.append(handle, propertyCode, property.type,
                                        c.getLong(column));
                            }
                            break;
                    }
                }
            }

            return result;
        } catch (RemoteException e) {
            return new MtpPropertyList(0, MtpConstants.RESPONSE_GENERAL_ERROR);
        } finally {
            if (c != null) {
                c.close();
            }
        }
        // impossible to get here, so no return statement
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:31.953 -0400", hash_original_method = "22C8CA66E2E15E33D9DC30B1B82BEC12", hash_generated_method = "FA86AFF25414917EF04864A6148E0D45")
    
    private String format_date_time(long seconds){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += seconds;
    	addTaint(taintDouble);
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }



}
