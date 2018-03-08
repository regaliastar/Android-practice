package com.example.secondmodule;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
    private TextView textView;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textView);
        String str = getIntent().getStringExtra("name");

        userBean ub = (userBean) getIntent().getSerializableExtra("userBean");
        textView.setText(ub.toString());
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

        //从第二个界面向第一个界面传值
        Intent intent = new Intent();
        intent.putExtra("data","这是第二个界面传过来的值");
        setResult(2,intent);

        initlv();
    }

    private void initlv() {

    }
}
