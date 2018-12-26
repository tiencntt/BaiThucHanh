package windstudy.com.androidgopro.DetalProduct;

import retrofit2.Call;
import retrofit2.http.GET;
import windstudy.com.androidgopro.ListProduct.ListProductResultRequest;

public interface APIDetal {
    @GET("/users/detailProduct")
    Call<ListProductResultRequest> callProduct();
}
