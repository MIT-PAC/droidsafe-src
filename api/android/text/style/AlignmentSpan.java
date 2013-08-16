package android.text.style;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.TextUtils;

public interface AlignmentSpan extends ParagraphStyle {
    public Layout.Alignment getAlignment();

    public static class Standard
    implements AlignmentSpan, ParcelableSpan {
        @DSModeled(DSC.SAFE)
        public Standard(Layout.Alignment align) {
            mAlignment = align;
        }

        public Standard(Parcel src) {
            mAlignment = Layout.Alignment.valueOf(src.readString());
        }
        
        @DSModeled(DSC.SAFE)
        public int getSpanTypeId() {
            return TextUtils.ALIGNMENT_SPAN;
        }
        
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(mAlignment.name());
        }

        @DSModeled(DSC.SAFE)
        public Layout.Alignment getAlignment() {
            return mAlignment;
        }

        private final Layout.Alignment mAlignment;
    }
}
