package windstudy.com.androidgopro.DetalProduct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import windstudy.com.androidgopro.R;

public class DetalActivity extends AppCompatActivity {
    TextView tvPrice, tvName, tvRemain, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detal);
        tvPrice = findViewById(R.id.tv_price);
        tvName = findViewById(R.id.tv_name);
        tvRemain = findViewById(R.id.tv_remain);
        tvDescription = findViewById(R.id.tv_description);

    }
}
