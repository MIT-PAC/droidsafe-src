package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.TextUtils;

public interface AlignmentSpan extends ParagraphStyle {
    public Layout.Alignment getAlignment();

    public static class Standard
    implements AlignmentSpan, ParcelableSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.409 -0500", hash_original_field = "82F9218670DD3C15B235603CB46CF954", hash_generated_field = "393B2049F7F85DEAC6B2663317C7A5DC")

        private  Layout.Alignment mAlignment;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.393 -0500", hash_original_method = "B952BF260E0BA0823EBE3ADE0B3C50C3", hash_generated_method = "F51E15A9742B5F41FCB69AD7FE8E34F2")
        
public Standard(Layout.Alignment align) {
            mAlignment = align;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.396 -0500", hash_original_method = "C9FB613B57B8FF87A9A7F12F17479517", hash_generated_method = "91C0994D9A6E985BB9F8F4917A292990")
        
public Standard(Parcel src) {
            mAlignment = Layout.Alignment.valueOf(src.readString());
        }
        
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.399 -0500", hash_original_method = "2EF0C12246BCA507C6FF618C23AD3C6F", hash_generated_method = "B8C347D29B11B4668573B8FD35494FAE")
        
public int getSpanTypeId() {
            return TextUtils.ALIGNMENT_SPAN;
        }
        
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.401 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.404 -0500", hash_original_method = "A7A355BDB68671CCA4543E875164E432", hash_generated_method = "963E13521BC9AA727893C027FF42FA0A")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(mAlignment.name());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.407 -0500", hash_original_method = "967CC0DD792E514CE3A8F1AD48DBAD49", hash_generated_method = "89664577B1EE1B018885D724D1A78737")
        
public Layout.Alignment getAlignment() {
            return mAlignment;
        }
    }
}
