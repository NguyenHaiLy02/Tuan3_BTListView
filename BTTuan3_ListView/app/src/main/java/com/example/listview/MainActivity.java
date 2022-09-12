package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView lvMonHoc;
    Button btnThem;
    Button btnCapNhat;
    Button btnXoa;
    EditText edtMonHoc;
    ArrayList<String> arrayCourse;

    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonHoc = (ListView)  findViewById(R.id.ListViewMonHoc);
        btnThem =(Button) findViewById(R.id.ButtonThem);
        edtMonHoc = (EditText) findViewById(R.id.EditTextMonHoc);
        btnCapNhat = (Button) findViewById(R.id.ButtonCapNhat);
        btnXoa =(Button) findViewById(R.id.ButtonXoa);
        arrayCourse = new ArrayList<>();

        arrayCourse.add("CSDL");
        arrayCourse.add("Android");
        arrayCourse.add("Cấu trúc dữ liệu giai thuật");
        arrayCourse.add("Đồ họa ứng dụng");
        arrayCourse.add("C#");
        arrayCourse.add("IOS");

        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayCourse
        );

        lvMonHoc.setAdapter(adapter) ;

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc = edtMonHoc.getText().toString();
                arrayCourse.add(monhoc);
                Toast.makeText(MainActivity.this, "ĐÃ THÊM THÀNH CÔNG!", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();

            }
        });

        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtMonHoc.setText(arrayCourse.get(i));
                vitri = i;
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(vitri,edtMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "ĐÃ XÓA THÀNH CÔNG!", Toast.LENGTH_SHORT).show();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.remove(vitri);
                adapter.notifyDataSetChanged();
            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str=lvMonHoc.getAdapter().getItem(i).toString();
                Intent intent=new Intent(getApplicationContext(),Activity_2.class);
                intent.putExtra("name",str);
                startActivity(intent);
                lvMonHoc.setSelector(R.color.mediumturquoise);
                return false;
            }
        });


    }
}
