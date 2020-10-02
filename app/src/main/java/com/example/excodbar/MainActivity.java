package com.example.excodbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button btTiraFoto, btLeitura;
ImageView imSuaImagem;
EditText txLeitura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //Toast.Makefsdhafsjklhfkjsa  Teste edição de arquivo pela página do GitHub
        retiraFoto();
        lerCodigos();
    }
    
    private void lerCodigos(){
        btLeitura=(Button)findViewById(R.id.btnLeitura);
        txLeitura=(EditText)findViewById(R.id.edtLeitura);
        btLeitura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                startActivityForResult(intent, 0);
            }
        });
    }

    private void retiraFoto(){
        btTiraFoto=(Button)findViewById(R.id.btnTiraFoto);
        imSuaImagem=(ImageView)findViewById(R.id.suaImagem);
        btTiraFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abreCamera= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(abreCamera, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==0){
            txLeitura.setText(data.getStringExtra("SCAN_RESULT"));
        }
        /*Bundle bundle = data.getExtras();
        if (data != null){
            Bitmap bitmap = (Bitmap)bundle.get("data");
            imSuaImagem.setImageBitmap(bitmap);
        }*/
    }
}
