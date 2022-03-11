import org.json.JSONException;
import org.json.JSONObject;
import parser.CSVParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {

    private static final double EARTH_RADIUS = 6371.;

    public static void main(String[] args) throws IOException, JSONException {

        CSVParser parser = new CSVParser();
        parser.parseCSVIntoData("src/main/resources/source.csv");
        parser.printData();

        final String baseUrl = "http://maps.googleapis.com/maps/api/geocode/json";// путь к Geocoding API по HTTP
        final Map<String, String> params = new HashMap<>();
        params.put("sensor", "false");// исходит ли запрос на геокодирование от устройства с датчиком местоположения
        params.put("address", "Россия, Москва, улица Поклонная, 12");// адрес, который нужно геокодировать
        final String url = baseUrl + '?' + JsonReader.encodeParams(params);// генерируем путь с параметрами
        System.out.println(url);// Путь, что бы можно было посмотреть в браузере ответ службы
        final JSONObject response = JsonReader.read(url);// делаем запрос к вебсервису и получаем от него ответ
        // как правило наиболее подходящий ответ первый и данные о координатах можно получить по пути
        // //results[0]/geometry/location/lng и //results[0]/geometry/location/lat
        JSONObject location = response.getJSONArray("results").getJSONObject(0);
        location = location.getJSONObject("geometry");
        location = location.getJSONObject("location");
        final double lng = location.getDouble("lng");// долгота
        final double lat = location.getDouble("lat");// широта
        System.out.println(String.format("%f,%f", lat, lng));// итоговая широта и долгота

    }

}
