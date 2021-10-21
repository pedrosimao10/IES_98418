package com.mycompany.weather;

import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.lang.StringBuilder;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {
    private static int city_id  = 1010500;
    //private static final int CITY_ID_AVEIRO = 1010500;
    /*
    loggers provide a better alternative to System.out.println
    https://rules.sonarsource.com/java/tag/bad-practice/RSPEC-106
     */
    private static final Logger logger = Logger.getLogger(WeatherStarter.class.getName());

    public static void  main(String[] args ) {

        if (args.length > 0){
            try {
                city_id  = Integer.parseInt(args[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        IpmaApiClient apiClient = new IpmaApiClient(city_id);
        IpmaCityForecast cityForecast = apiClient.connection();

        if (cityForecast != null) {
            StringBuilder sb = new StringBuilder();
            String log = sb.append("max temp for today: ")
                            .append(cityForecast.getData().listIterator().next().getTMax())
                            .append('\n')
                            .append("min temp for today: ")
                            .append(cityForecast.getData().listIterator().next().getTMin())
                            .toString();
            logger.info(log);
        } else {
            logger.info( "No results!");
        }

    }
}