package windstudy.com.androidgopro;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import windstudy.com.androidgopro.ListProduct.ListProductActivity;
import windstudy.com.androidgopro.Register.RegisterActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtUserName, edtPassword;
    Button btnLogin;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    void init(){
        edtUserName = findViewById(R.id.edt_user_name);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        tvRegister = findViewById(R.id.tv_register);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog dialog = ProgressDialog.show(MainActivity.this,"Đang đang nhập","vui lòng đợi");


                final String userName = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.12:3000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                retrofit.create(APIServices.class).login(userName, password).enqueue(new Callback<LoginResultRequest>() {
                    @Override
                    public void onResponse(Call<LoginResultRequest> call, Response<LoginResultRequest> response) {

                        dialog.dismiss();
                        if (response.isSuccessful()) {
                            LoginResultRequest loginResultRequest = response.body();
                            if (loginResultRequest.getStatus() == 1) {
                                Toast.makeText(MainActivity.this, loginResultRequest.getMessage(), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, ListProductActivity.class);
                                startActivity(intent);



                            } else {
                                Toast.makeText(MainActivity.this, loginResultRequest.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResultRequest> call, Throwable t) {
                        dialog.dismiss();
                        Log.d("user","message" +t.getMessage());

                    }
                });


            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);



            }
        });



    }
}
