package robotium.nisum.com.robotiumapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn_saludo;
    private TextView textoEj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoEj = (TextView) findViewById(R.id.textoEj);
        btn_saludo = (Button) findViewById(R.id.btn_saludo);

        btn_saludo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                textoEj.setText("Thanks!");
            }
        });
    }
}
