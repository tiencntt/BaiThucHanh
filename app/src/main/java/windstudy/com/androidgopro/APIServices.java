package windstudy.com.androidgopro;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIServices {
    // Khai báo tất cả các api sử dụng


    // - kiểu request
    // - đường dẫn api
    // - Kiểu dữ liệu trả về
    // - Tên api (class khác gọi)
    // - dữ liệu truyền vào
    @GET("/users/login")
    Call<LoginResultRequest> login(@Query("user_name") String username, @Query("password") String password);

}
