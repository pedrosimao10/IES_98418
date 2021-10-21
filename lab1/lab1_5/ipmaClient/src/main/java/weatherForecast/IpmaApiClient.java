package main.java.weatherForecast;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IpmaApiClient {

    private int city_id;

    public IpmaApiClient(int city_id){
        this.city_id = city_id;
    }

    public IpmaCityForecast connection(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IpmaService service = retrofit.create(IpmaService.class);
        Call<IpmaCityForecast> callSync = service.getForecastForACity(city_id);
        IpmaCityForecast forecast = null;

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            forecast = apiResponse.body();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return forecast;
    }
    
}