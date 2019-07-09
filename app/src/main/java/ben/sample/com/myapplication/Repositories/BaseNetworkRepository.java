package ben.sample.com.myapplication.Repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Modifier;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ben on 14/10/2017.
 */

public class BaseNetworkRepository {


    public Object ServiceConstructor(Class ServiceToCon)
    {
       // HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

// set your desired log level
       /// logging.setLevel(HttpLoggingInterceptor.Level.BODY);
       // OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …
// add logging as last interceptor

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create(getGsonConverter()))
                //.client(httpClient.build())
                .build();

        return retrofit.create(ServiceToCon);

    }

    public Gson getGsonConverter() {
        GsonBuilder b = new GsonBuilder();
        Gson gson = b.excludeFieldsWithModifiers(Modifier.PROTECTED).create();
        return gson;
    }

}
