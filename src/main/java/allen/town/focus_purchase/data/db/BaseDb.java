package allen.town.focus_purchase.data.db;

import android.content.Context;
import android.database.Cursor;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import java.util.Date;

import allen.town.focus.reader.data.db.GooglePlayInAppPurchase;
import allen.town.focus.reader.data.db.GooglePlayPurchase;
import allen.town.focus.reader.data.db.GooglePlaySkuDetails;
import allen.town.focus_common.util.Timber;
import rx.schedulers.Schedulers;

public class BaseDb {
    private BriteDatabase db;
    private AlipayPurchase alipayPurchase;

    public GooglePlayPurchase getGooglePlayPurchase() {
        return googlePlayPurchase;
    }

    public GooglePlayInAppPurchase getGooglePlayInAppPurchase() {
        return googlePlayInAppPurchase;
    }

    private GooglePlayPurchase googlePlayPurchase;
    private GooglePlayInAppPurchase googlePlayInAppPurchase;
    private GooglePlaySkuDetails googlePlaySkuDetails;


    public BaseDb(Context context) {
        this.db = new SqlBrite.Builder().logger(Timber::d).build().wrapDatabaseHelper(new DbOpenHelper(context), Schedulers.io());
        this.db.setLoggingEnabled(false);
        this.alipayPurchase = new AlipayPurchase(this.db);
        this.googlePlayPurchase = new GooglePlayPurchase(this.db);
        this.googlePlayInAppPurchase = new GooglePlayInAppPurchase(this.db);
        googlePlaySkuDetails = new GooglePlaySkuDetails(this.db);
    }



    public AlipayPurchase alipayPurchase() {
        return this.alipayPurchase;
    }


    public BriteDatabase rawDb() {
        return this.db;
    }

    public static String getString(Cursor cursor, String str) {
        return cursor.getString(cursor.getColumnIndex(str));
    }

    public static String getString(Cursor cursor, String str, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        return columnIndex > -1 ? cursor.getString(columnIndex) : str2;
    }

    public static boolean getBoolean(Cursor cursor, String str) {
        return getInt(cursor, str, 0) == 1;
    }

    public static long getLong(Cursor cursor, String str) {
        return cursor.getLong(cursor.getColumnIndex(str));
    }

    public static long getLong(Cursor cursor, String str, long j) {
        int columnIndex = cursor.getColumnIndex(str);
        return columnIndex > -1 ? cursor.getLong(columnIndex) : j;
    }

    public static int getInt(Cursor cursor, String str) {
        return cursor.getInt(cursor.getColumnIndex(str));
    }

    public static int getInt(Cursor cursor, String str, int i) {
        int columnIndex = cursor.getColumnIndex(str);
        return columnIndex > -1 ? cursor.getInt(columnIndex) : i;
    }

    public static Date getDate(Cursor cursor, String str) {
        return new Date(cursor.getLong(cursor.getColumnIndex(str)));
    }



    public GooglePlaySkuDetails getGooglePlaySkuDetails() {
        return googlePlaySkuDetails;
    }
}
