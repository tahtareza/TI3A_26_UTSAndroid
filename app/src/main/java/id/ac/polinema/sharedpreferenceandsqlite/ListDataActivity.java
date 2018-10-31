package id.ac.polinema.sharedpreferenceandsqlite;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class ListDataActivity extends AppCompatActivity {
    RecyclerView rv;
    DataHelper dbcenter;
    RecyclerView.LayoutManager lm;
    Button btnBack;
    DataAdapter ar;
    ArrayList<DataModel> dataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

            rv=findViewById(R.id.rv);
            lm=new LinearLayoutManager(this);
            rv.setLayoutManager(lm);
            dbcenter = new DataHelper(this);
            dataset = dbcenter.getAllRecord();
//            dataset.add(new DataModel("MALANG",1));
            ar = new DataAdapter(dataset);
            rv.setAdapter(ar);

            btnBack = (Button)findViewById(R.id.buttonBack);
            btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), InsertDataActivity.class);
                startActivity(mIntent);
                }
            });
    }

}
