package windstudy.com.androidgopro.ListProduct;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIListProduct {
    @GET("/users/products")
    Call<ListProductResultRequest> callProductList();

}

