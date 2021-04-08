import okhttp3.*;

import java.io.IOException;

public class Weather {
    private static final String Api_Key = "306dae0d-65b1-4c0f-afaa-900e5f14ae80";

    public static void main(String[] args) throws IOException {
        String url="https://api.weather.yandex.ru/v2/forecast?lat=59.9386&lon=30.3141&limit=3";
        String key = "306dae0d-65b1-4c0f-afaa-900e5f14ae80";

        System.out.println(url);
        System.out.println(key);


        OkHttpClient okhttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("X-Yandex-API-Key", key)
                .build();

        System.out.println(request.url());
        Response response = okhttpClient.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(response.body().string());

    }

}

//    Request requestBooking = new Request.Builder()
//            .url("https://restful-booker.herokuapp.com/booking")
//            .addHeader("Content-Type", "application/json")
//            .addHeader("accept", "application/json")
//            .addHeader("Cookie", String.format("token=%s", token))
//            .post(requestBodyBooking)
//            .build();
//
//    Response responseBooking = okHttpClient.newCall(requestBooking).execute();
//        System.out.println(responseBooking.code());
//                System.out.println(responseBooking.headers());
//                System.out.println(responseBooking.body().string());