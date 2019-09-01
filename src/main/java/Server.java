import com.google.gson.Gson;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.model.Delay;
import org.mockserver.model.Header;
import java.util.concurrent.TimeUnit;

import static org.mockserver.model.HttpResponse.response;

import static org.mockserver.model.HttpRequest.request;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;


public class Server {

    static MockServerClient mock = startClientAndServer(8082);

    public static void query(String method, String path, int statusCode, String content, String body, long delay) {

        mock.when(
                request()
                        .withMethod(method)
                        .withPath(path)

        ).respond(
                response()
                        .withStatusCode(statusCode)
                        .withHeader(new Header("Content-Type", content))
                        .withBody(body)
                        .withDelay(new Delay(TimeUnit.MILLISECONDS, delay))
        );

    }


    public static void main(String[] args) {


        String sites = "{\"id\":\"MLA\",\"name\":\"Argentina\",\"country_id\":\"AR\",\"sale_fees_mode\":\"not_free\",\"mercadopago_version\":3,\"default_currency_id\":\"ARS\",\"immediate_payment\":\"optional\",\"payment_method_ids\":[\"MLAMP\",\"MLAWC\",\"MLAAM\",\"MLABC\",\"MLACD\",\"MLAOT\",\"MLADC\",\"MLAMO\",\"MLAWT\",\"MLAMC\",\"MLAMS\",\"MLAVS\",\"MLATB\",\"MLAVE\"],\"settings\":{\"identification_types\":[\"DNI\",\"Otro\"],\"taxpayer_types\":[\"IVA Exento\",\"IVA Responsable Inscripto\",\"Monotributo\",\"Consumidor Final\"],\"identification_types_rules\":[{\"identification_type\":\"DNI\",\"rules\":[{\"enabled_taxpayer_types\":[\"Consumidor Final\"],\"begins_with\":\"\",\"type\":\"number\",\"min_length\":8,\"max_length\":8}]},{\"identification_type\":\"Otro\",\"rules\":[{\"enabled_taxpayer_types\":[\"IVA Exento\",\"IVA Responsable Inscripto\",\"Monotributo\"],\"begins_with\":\"\",\"type\":\"number\",\"min_length\":11,\"max_length\":11}]}]},\"currencies\":[{\"id\":\"USD\",\"symbol\":\"U$S\"},{\"id\":\"ARS\",\"symbol\":\"$\"}],\"categories\":[{\"id\":\"MLA5725\",\"name\":\"Accesorios para Veh\u00edculos\"},{\"id\":\"MLA1403\",\"name\":\"Alimentos y Bebidas\"},{\"id\":\"MLA1071\",\"name\":\"Animales y Mascotas\"},{\"id\":\"MLA1367\",\"name\":\"Antig\u00fcedades y Colecciones\"},{\"id\":\"MLA1368\",\"name\":\"Arte, Librer\u00eda y Mercer\u00eda\"},{\"id\":\"MLA1743\",\"name\":\"Autos, Motos y Otros\"},{\"id\":\"MLA1384\",\"name\":\"Beb\u00e9s\"},{\"id\":\"MLA1246\",\"name\":\"Belleza y Cuidado Personal\"},{\"id\":\"MLA1039\",\"name\":\"C\u00e1maras y Accesorios\"},{\"id\":\"MLA1051\",\"name\":\"Celulares y Tel\u00e9fonos\"},{\"id\":\"MLA1648\",\"name\":\"Computaci\u00f3n\"},{\"id\":\"MLA1144\",\"name\":\"Consolas y Videojuegos\"},{\"id\":\"MLA1276\",\"name\":\"Deportes y Fitness\"},{\"id\":\"MLA5726\",\"name\":\"Electrodom\u00e9sticos y Aires Ac.\"},{\"id\":\"MLA1000\",\"name\":\"Electr\u00f3nica, Audio y Video\"},{\"id\":\"MLA2547\",\"name\":\"Entradas para Eventos\"},{\"id\":\"MLA407134\",\"name\":\"Herramientas y Construcci\u00f3n\"},{\"id\":\"MLA1574\",\"name\":\"Hogar, Muebles y Jard\u00edn\"},{\"id\":\"MLA1499\",\"name\":\"Industrias y Oficinas\"},{\"id\":\"MLA1459\",\"name\":\"Inmuebles\"},{\"id\":\"MLA1182\",\"name\":\"Instrumentos Musicales\"},{\"id\":\"MLA3937\",\"name\":\"Joyas y Relojes\"},{\"id\":\"MLA1132\",\"name\":\"Juegos y Juguetes\"},{\"id\":\"MLA3025\",\"name\":\"Libros, Revistas y Comics\"},{\"id\":\"MLA1168\",\"name\":\"M\u00fasica, Pel\u00edculas y Series\"},{\"id\":\"MLA1430\",\"name\":\"Ropa y Accesorios\"},{\"id\":\"MLA409431\",\"name\":\"Salud y Equipamiento M\u00e9dico\"},{\"id\":\"MLA1540\",\"name\":\"Servicios\"},{\"id\":\"MLA9304\",\"name\":\"Souvenirs, Cotill\u00f3n y Fiestas\"},{\"id\":\"MLA1953\",\"name\":\"Otras categor\u00edas\"}]}";
        String countries = "{\"id\":\"AR\",\"name\":\"Argentina\",\"locale\":\"es_AR\",\"currency_id\":\"ARS\",\"decimal_separator\":\",\",\"thousands_separator\":\".\",\"time_zone\":\"GMT-03:00\",\"geo_information\":{\"location\":{\"latitude\":-38.416096,\"longitude\":-63.616673}},\"states\":[{\"id\":\"AR-B\",\"name\":\"Buenos Aires\"},{\"id\":\"AR-C\",\"name\":\"Capital Federal\"},{\"id\":\"AR-K\",\"name\":\"Catamarca\"},{\"id\":\"AR-H\",\"name\":\"Chaco\"},{\"id\":\"AR-U\",\"name\":\"Chubut\"},{\"id\":\"AR-W\",\"name\":\"Corrientes\"},{\"id\":\"AR-X\",\"name\":\"C\u00f3rdoba\"},{\"id\":\"AR-E\",\"name\":\"Entre R\u00edos\"},{\"id\":\"AR-P\",\"name\":\"Formosa\"},{\"id\":\"AR-Y\",\"name\":\"Jujuy\"},{\"id\":\"AR-L\",\"name\":\"La Pampa\"},{\"id\":\"AR-F\",\"name\":\"La Rioja\"},{\"id\":\"AR-M\",\"name\":\"Mendoza\"},{\"id\":\"AR-N\",\"name\":\"Misiones\"},{\"id\":\"AR-Q\",\"name\":\"Neuqu\u00e9n\"},{\"id\":\"AR-R\",\"name\":\"R\u00edo Negro\"},{\"id\":\"AR-A\",\"name\":\"Salta\"},{\"id\":\"AR-J\",\"name\":\"San Juan\"},{\"id\":\"AR-D\",\"name\":\"San Luis\"},{\"id\":\"AR-Z\",\"name\":\"Santa Cruz\"},{\"id\":\"AR-S\",\"name\":\"Santa Fe\"},{\"id\":\"AR-G\",\"name\":\"Santiago del Estero\"},{\"id\":\"AR-V\",\"name\":\"Tierra del Fuego\"},{\"id\":\"AR-T\",\"name\":\"Tucum\u00e1n\"}]}";
        String users= "{\"id\":123456,\"nickname\":\"RADIUS\",\"registration_date\":\"1999-12-21T00:00:00.000-04:00\",\"country_id\":\"BR\",\"address\":{\"city\":\"Bauru\",\"state\":\"BR-SP\"},\"user_type\":\"normal\",\"tags\":[\"normal\"],\"logo\":null,\"points\":0,\"site_id\":\"MLB\",\"permalink\":\"http:mercadolibrebrasil/RADIUS\",\"seller_reputation\":{\"level_id\":null,\"power_seller_status\":null,\"transactions\":{\"canceled\":0,\"completed\":0,\"period\":\"historic\",\"ratings\":{\"negative\":0,\"neutral\":0,\"positive\":0},\"total\":0}},\"buyer_reputation\":{\"tags\":[]},\"status\":{\"site_status\":\"active\"}}";
        String site = "{}";

        query("GET", "/sites/.*", 200, "application/json", sites, 800);

        query("GET", "/countries/.*", 200, "application/json", countries, 900);
        //query("GET", "/countries/.*", 500, "application/json", "", 500);

        query("GET", "/users/.*", 200, "application/json", users, 800);
        query("GET", "/ping", 200, "application/json", "pong", 2000);



    }


}