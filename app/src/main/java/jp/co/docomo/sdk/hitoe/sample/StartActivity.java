package jp.co.docomo.sdk.hitoe.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import jp.co.docomo.sdk.hitoe.sample.Retrofit.RetrofitClient;

public class StartActivity extends AppCompatActivity {
    private String BASE_URL= "http://192.168.1.24:8000";
    private String IP = "";
    private String PORT = "";
    private String NAME = "";
    Random r = new Random();
//    Intent intent;

    RetrofitClient client = new RetrofitClient(BASE_URL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        // set Button
        Button getIPBt = findViewById(R.id.setIP_button);
        Button PostBt = findViewById(R.id.post_button);
        Button NextBt = findViewById(R.id.next_button);
        // setEditor
        final EditText ip_text = findViewById(R.id.ip_editor);
        final EditText port_text = findViewById(R.id.port_editor);
        final EditText name_text = findViewById(R.id.name_editor);

        // Set Listener
        getIPBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IP = ip_text.getText().toString();
                PORT = port_text.getText().toString();
                BASE_URL="http://"+IP+":"+PORT+"/";
                NAME = name_text.getText().toString();
                Toast.makeText(StartActivity.this, "Interface Recreate ! New URL is "+BASE_URL, Toast.LENGTH_SHORT).show();
                client.setIp(BASE_URL);
            }
        });

        PostBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StartActivity.this, "TestPost", Toast.LENGTH_SHORT).show();
                // 今はRRIとしてテキトーな乱数を
                client.post(NAME,r.nextInt(400)+700);
//                client.post(NAME,2000);
            }
        });

        NextBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // インテントへのインスタンス生成
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                //　インテントに値をセット
                intent.putExtra("URL", BASE_URL);
                intent.putExtra("NAME", NAME);
                // サブ画面の呼び出し
                startActivity(intent);
            }
        });


    }
}
