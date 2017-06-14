package bd2.Muber;

import java.util.Iterator;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class App {

    public static void main(String[] args) {
	entrega3();
    }

    public static void entrega3() {
	String uri = "http://localhost:8080/MuberRESTful/rest/services";
	String url;
	RestTemplate restTemplate = new RestTemplate();

	/********************** Carga de Datos *********************/
	System.out.println("Cargando datos...");
	url = uri + "/cargarDatos";
	HttpHeaders headers = new HttpHeaders();
	HttpEntity<String> entity = new HttpEntity<String>("", headers);
	ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

	/********************** Inicializacion *********************/
	System.out.println("Recuperando informacion...");
	// Obtengo pasajeros para utilizar luego
	url = uri + "/pasajeros";
	// Configuro los headers.
	headers = new HttpHeaders();
	// Ejecuto el POST y obtengo el resultado. response contiene los datos
	// obtenidos.
	entity = new HttpEntity<String>("", headers);
	response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
	JSONObject jsonResponse = new JSONObject(response.getBody());
	JSONObject pasajeros = jsonResponse.getJSONObject("message");
	System.out.println(response);

	// Obtengo conductores para utilizar luego
	url = uri + "/conductores";
	// Configuro los headers.
	headers = new HttpHeaders();
	// Ejecuto el POST y obtengo el resultado. response contiene los datos
	// obtenidos.
	entity = new HttpEntity<String>("", headers);
	response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
	jsonResponse = new JSONObject(response.getBody());
	JSONObject conductores = jsonResponse.getJSONObject("message");
	System.out.println(response);

	/************************ Inciso A ***********************/
	System.out.println("Inciso A...");
	Long idRoberto = searchUserId(conductores, "roberto");
	// Creo que el JSON que envaré por POST.
	String input = String.format(
		"destino=Mar+del+Plata&origen=Cordoba&cantidadPasajeros=4&costoTotal=3500&conductorId=%1$d", idRoberto);

	url = uri + "/viajes/nuevo";
	// Configuro los headers.
	headers = new HttpHeaders();
	headers.set("content-type", "application/x-www-form-urlencoded");
	// Ejecuto el POST y obtengo el resultado. response contiene los datos
	// obtenidos.
	entity = new HttpEntity<String>(input, headers);
	response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
	jsonResponse = new JSONObject(response.getBody());
	JSONObject viaje = jsonResponse.getJSONObject("message");
	System.out.println(response);

	/************************ Inciso B ***********************/
	System.out.println("Inciso B...");
	// Margarita carga saldo a su cuenta:
	url = uri + "/pasajeros/cargarCredito";
	Long idMargarita = searchUserId(pasajeros, "margarita");
	input = String.format("pasajeroId=%1$d&monto=4000", idMargarita);
	headers = new HttpHeaders();
	headers.set("content-type", "application/x-www-form-urlencoded");
	entity = new HttpEntity<String>(input, headers);
	response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
	System.out.println(response);

	// Margarita se suma al viaje:
	url = uri + "/viajes/agregarPasajero";
	input = String.format("viajeId=%1$d&pasajeroId=%2$d", viaje.get("travelId"), idMargarita);
	headers = new HttpHeaders();
	headers.set("content-type", "application/x-www-form-urlencoded");
	entity = new HttpEntity<String>(input, headers);
	response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
	System.out.println(response);

	// Hugo se suma al viaje:
	Long idHugo = searchUserId(pasajeros, "hugo");
	url = uri + "/viajes/agregarPasajero";
	input = String.format("viajeId=%1$d&pasajeroId=%2$d", viaje.get("travelId"), idHugo);
	headers = new HttpHeaders();
	headers.set("content-type", "application/x-www-form-urlencoded");
	entity = new HttpEntity<String>(input, headers);
	response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
	System.out.println(response);

	/************************ Inciso C ***********************/
	System.out.println("Inciso C...");
	// Margarita califica el viaje:
	url = uri + "/viajes/calificar";
	input = String.format("puntaje=4&comentario=Me+gusto+viajar+con+Hugo&viajeId=%1$d&pasajeroId=%2$d",
		viaje.get("travelId"), idMargarita);
	headers = new HttpHeaders();
	headers.set("content-type", "application/x-www-form-urlencoded");
	entity = new HttpEntity<String>(input, headers);
	response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
	System.out.println(response);

	// Hugo califica el viaje:
	url = uri + "/viajes/calificar";
	input = String.format("puntaje=5&comentario=Creo+que+Margarita+me+tiro+onda&viajeId=%1$d &pasajeroId=%2$d",
		viaje.get("travelId"), idHugo);
	headers = new HttpHeaders();
	headers.set("content-type", "application/x-www-form-urlencoded");
	entity = new HttpEntity<String>(input, headers);
	response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
	System.out.println(response);

	/************************ Inciso D ***********************/
	System.out.println("Inciso D...");
	// Se finaliza el viaje:
	url = uri + "/viajes/finalizar";
	input = String.format("viajeId=%1$d", viaje.get("travelId"));
	headers = new HttpHeaders();
	headers.set("content-type", "application/x-www-form-urlencoded");
	entity = new HttpEntity<String>(input, headers);
	response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
	System.out.println(response);
    }

    private static Long searchUserId(JSONObject users, String username) {
	Iterator<?> keys = users.keys();
	while (keys.hasNext()) {
	    String key = (String) keys.next();
	    if (users.getJSONObject(key).getString("username").equals(username)) {
		return users.getJSONObject(key).getLong("userId");
	    }
	}
	return null;
    }

}
