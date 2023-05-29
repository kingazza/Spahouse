package com.example.spahouse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

class cal extends AppCompatActivity {
    EditText name, contact, dob;
    Button insert, update, delete, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculater);

        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.dob);


        insert =(Button) findViewById(R.id.btnInsert);
        update =(Button) findViewById(R.id.btnUpdate);
        delete =(Button) findViewById(R.id.btnDelete);
        view =(Button) findViewById(R.id.btnView);
        DB = new DBHelper(this);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTEXT = name.getText().toString();
                String contactTEXT = contact.getText().toString();
                String dobTEXT = dob.getText().toString();


                Boolean checkinsertdata = DB.insertuserdata(nameTEXT, contactTEXT, dobTEXT);
                if (checkinsertdata==true)
                    Toast.makeText(cal.this, "new entry inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(cal.this, "new entry not inserted", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTEXT = name.getText().toString();
                String contactTEXT = contact.getText().toString();
                String dobTEXT = dob.getText().toString();


                Boolean checkupdatedata = DB.updateuserdata(nameTEXT, contactTEXT, dobTEXT);
                if (checkupdatedata==true)
                    Toast.makeText(cal.this, "entry updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(cal.this, "entry not updated", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTEXT = name.getText().toString();
                Boolean checkdeletedata = DB.deletedata(nameTEXT);
                if (checkdeletedata==true)
                    Toast.makeText(cal.this, "entry deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(cal.this, "entry not deleted", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res =DB.getdata();
                if (res.getCount()==0){
                    Toast.makeText(cal.this, "no entry exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer =  new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Name :"+ res.getString(0 )+"\n");
                    buffer.append("Contact :"+ res.getString(0)+"\n");
                    buffer.append("Data of birth :"+ res.getString(2)+"\n\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(cal.this);
                builder.setCancelable(true);
                builder.setTitle("User entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}