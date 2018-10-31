package id.ac.polinema.sharedpreferenceandsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertDataActivity extends AppCompatActivity {
    DataHelper dbHelper;
    DataModel dm;
    Button btnSave, btnCek;
    EditText edtInputKota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        dbHelper = new DataHelper(this);
        edtInputKota = (EditText) findViewById(R.id.editTextInputNama);

        btnSave= (Button) findViewById(R.id.btnSimpanInputData);
        btnCek = (Button) findViewById(R.id.btnCekListData);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dm = new DataModel(edtInputKota.getText().toString());
                dbHelper.addRecord(dm);
                //SQLiteDatabase db = dbHelper.getWritableDatabase();
                //db.execSQL("insert into kota(nama) values('" +
                        //edtInputKota.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                //ListDataActivity.la.RefreshList();
                //finish();
            }
        });

        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), ListDataActivity.class);
                startActivity(mIntent);
            }
        });
    }
}
