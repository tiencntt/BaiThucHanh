package windstudy.com.androidgopro.ListProduct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import windstudy.com.androidgopro.R;

public class ListProductActivity extends AppCompatActivity  {
    ArrayList<ListProduct> arrayData = new ArrayList<>();
    RecyclerView rvProduct;
    ListProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
        init();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false);
        adapter = new ListProductAdapter();
        adapter.arrData = arrayData;
        adapter.context = ListProductActivity.this;
        rvProduct.setAdapter(adapter);
        rvProduct.setLayoutManager(gridLayoutManager);
        



    }

    public void init() {
        rvProduct = findViewById(R.id.rv_list_product);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.12:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(APIListProduct.class).callProductList().enqueue(new Callback<ListProductResultRequest>() {
            @Override
            public void onResponse(Call<ListProductResultRequest> call, Response<ListProductResultRequest> response) {
                if (response.isSuccessful()) {
                    ListProductResultRequest productResultRequest = response.body();
                    if (productResultRequest.getStatus() == 1) {
                        for (int i = 0; i < productResultRequest.getData().size(); i++) {
                            ListProduct data = new ListProduct();
                            data.setProductId(Integer.parseInt(productResultRequest.getData().get(i).getProductId().toString()));
                            data.setId(Integer.parseInt(productResultRequest.getData().get(i).getId().toString()));
                            data.setPrice(Integer.parseInt(productResultRequest.getData().get(i).getPrice().toString()));
                            data.setImages(productResultRequest.getData().get(i).getImages());
                            data.setName(productResultRequest.getData().get(i).getName());
                            arrayData.add(data);






                        }
                        adapter.notifyDataSetChanged();



                    }
                    else {
                        Toast.makeText(ListProductActivity.this, "error", Toast.LENGTH_SHORT).show();

                    }
                }

            }

            @Override
            public void onFailure(Call<ListProductResultRequest> call, Throwable t) {

            }
        });


    }

}
