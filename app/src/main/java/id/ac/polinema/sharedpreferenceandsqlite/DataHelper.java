package id.ac.polinema.sharedpreferenceandsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DBkota";
    private static final int DATABASE_VERSION = 1;
    private static final String TB_NAME="kota_TB";
    // column tables
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "nama";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TB_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT" + ")";
        //Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
//        sql = "INSERT INTO kota (nama) VALUES ('Indramayu');";
//        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_NAME);
        onCreate(db);
    }

    public void addRecord(DataModel dataModel){
        SQLiteDatabase db  = getWritableDatabase();

//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, dataModel.getNama());
//
//        db.insert(TB_NAME, null, values);
        db.execSQL("insert into "+TB_NAME+" ("+KEY_NAME+") values ('"+dataModel.getNama()+"')");
        db.close();
    }

    // get All Record
    public ArrayList<DataModel> getAllRecord() {
        ArrayList<DataModel> dataList = new ArrayList<DataModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TB_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DataModel dataModel = new DataModel();
                dataModel.setId(Integer.parseInt(cursor.getString(0)));
                dataModel.setNama(cursor.getString(1));

                dataList.add(dataModel);
            } while (cursor.moveToNext());
        }

        // return contact list
        return dataList;
    }
}
