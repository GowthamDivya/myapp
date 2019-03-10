package edr.bhanuinfosystems.com.Api;

import edr.bhanuinfosystems.com.model.DefaultResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("api/Doctor")
    Call<DefaultResponse> createDoc(
            @Field("dname") String dname,
            @Field("dgen") String dgen,
            @Field("dmob") String dmob,
            @Field("demail") String demail,
            @Field("dcity") String dcity,
            @Field("dspec") String dspec,
            @Field("dexp") String dexp,
            @Field("dregno") String dregno
    );
}
