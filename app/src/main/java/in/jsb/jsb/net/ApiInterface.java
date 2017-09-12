package in.jsb.jsb.net;

import com.google.gson.JsonObject;



import org.json.JSONArray;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface ApiInterface {
    @POST
    Call<JsonObject> sendLeavesData(@Url String subURL, @Body JsonObject jsonObject, @Header("authorization") String auth);

    @POST
    Call<JsonObject> postGoogleSignINData(@Url String subURL, @Body JsonObject jsonObject);

    @GET
    Call<JsonObject> getApplicationBotData(@Url String subURL, @Header("authorization") String auth, @Query("botId") String botId);


    @PUT
    Call<JsonObject> sendApprovalData(@Url String subURL, @Body JsonObject jsonObject, @Header("authorization") String auth);

    @HTTP(method = "DELETE", hasBody = true)
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<JsonObject> deleteMemberFromGroup(@Url String subURL, @Body JsonObject jsonObject, @Header("authorization") String auth);


    @Multipart
    @POST
    Call<JsonObject> createGroupForChat(@Url String subURL, @Part MultipartBody.Part image, @PartMap() Map<String, RequestBody> requestBody, @Header("authorization") String auth);

}
