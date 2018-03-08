package com.example.secondmodule;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;

import java.io.Serializable;

public class MainActivity extends Activity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private TextView textView;

    private EditText et_name,et_password;
    private CheckBox cb;
    private Button btn4;

    private Button btn5;

    private Button btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.name);
        et_password = findViewById(R.id.password);
        cb = findViewById(R.id.cb);

        btn1 = (Button) findViewById(R.id.toSecondActivity);
        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name","mememe");
                userBean ub = new userBean();
                ub.setName("regalaistar");
                ub.setPassword("123456");
                intent.putExtra("userBean", ub);
                startActivity(intent);
            }
        });

        //第二个界面回传过来的信息
        btn2 = findViewById(R.id.toSecondActivityWithResult);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name","mememe");
                userBean ub = new userBean();
                ub.setName("regalaistar");
                ub.setPassword("123456");
                intent.putExtra("userBean", ub);

                startActivityForResult(intent, 1);
            }
        });

        //JSON解析
        btn3 = findViewById(R.id.JSONformat);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView = findViewById(R.id.textView);
                String json = "{\"sites\": [{ \"name\":\"菜鸟教程\" , \"url\":\"www.runoob.com\" }, {\"name\":\"google\" , \"url\":\"www.google.com\" }, { \"name\":\"微博\" , \"url\":\"www.weibo.com\" }]}";
                //需要导入Gson包  open module settings -> dependencies -> library dependency
                Gson gson = new Gson();
                JsonBean jb = gson.fromJson(json,JsonBean.class);

                StringBuffer sb = new StringBuffer();

                //jb.sites.get(0).name  -->菜鸟教程
                //jb.sites.get(1).name  -->google
                for(int i = 0; i < jb.sites.size() ; i++){
                    sb.append("名字是:" + jb.sites.get(i).name+"\n");
                }

                textView.setText(sb.toString());
            }
        });

        btn4 = findViewById(R.id.login);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = et_name.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                //如果勾住CheckBox
                if (cb.isChecked()){
                    /*
                    //原生功能
                    SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("name",name);
                    editor.putString("password",password);
                    editor.commit();
                    */
                    //使用第三方库完成功能
                    SPUtils.getInstance().put("name",name);
                    SPUtils.getInstance().put("password",password);

                    Toast.makeText(MainActivity.this, "已提交", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "checkbox未选中", Toast.LENGTH_SHORT).show();
                }

            }
        });
        /*
        //使用原生工具
        SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
        String name =  sp.getString("name","no name value");
        String password = sp.getString("password","no password value");
        */
        //使用第三方工具
        String name = SPUtils.getInstance().getString("name");
        String password = SPUtils.getInstance().getString("password");
        et_name.setText(name);
        et_password.setText(password);

        //RecyclerView用法
        btn5 = findViewById(R.id.rv);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        btn6 = findViewById(R.id.brvah);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BrvahActivity.class);
                startActivity(intent);
            }
        });

    }

    //第二个界面回传过来的信息
    //对应 btn2 按钮
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if (resultCode == 2){
                String str = data.getStringExtra("data");
                Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
