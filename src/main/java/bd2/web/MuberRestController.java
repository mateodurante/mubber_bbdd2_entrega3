package bd2.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.service.ServiceRegistry;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;

import bd2.Muber.dto.*;
import bd2.Muber.model.*;
import bd2.Muber.services.DriverService;
import bd2.Muber.services.PassengerService;
import bd2.Muber.services.QualificationService;
import bd2.Muber.services.ServiceLocator;
import bd2.Muber.services.TravelService;

@ControllerAdvice
@RequestMapping("/services")
@ResponseBody
@EnableWebMvc
public class MuberRestController {

	protected Muber getMuber(Session session){
		Criteria criteria = session
		    .createCriteria(Muber.class)
		    .setProjection(Projections.max("idMuber"));
		long maxIdMuber = (long) criteria.uniqueResult();
		Muber muber = (Muber) session.get(Muber.class, maxIdMuber);
		//session.close();
		return muber;
	}
	
	protected Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		//ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		//SessionFactory factory = cfg.buildSessionFactory(sr);
		Session session = factory.openSession();
		return session;
	}
	
	protected Map<String, Object> travelToMap(TravelDTO currentTravel){
		// Se devuelve los id, origen y destino del viaje.
		Map<String, Object> travelMap = new HashMap<String, Object>();
		travelMap.put("travelId", currentTravel.getIdTravel());
		travelMap.put("origin", currentTravel.getOrigin());
		travelMap.put("destination", currentTravel.getDestiny());
		return travelMap;
	}

	protected String generateJson(Object aSerializableObject){
		// Se devuelve los id, origen y destino del viaje.
		Map<String, Object> aMap= new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("resultingObjects", aSerializableObject);
		return new Gson().toJson(aMap);
	}
	
	protected Map<String, Object> getDriverToMap(Driver driver){
		Map<String, Object> driverMap = new HashMap<String, Object>();
		Map<Long, Object> travelsMap = new HashMap<Long, Object>();
		driverMap.put("userId", driver.getIdUser());
		driverMap.put("username", driver.getUsername());
		driverMap.put("addmissionDate", driver.getAdmissionDate());
		driverMap.put("averageScore", driver.getQualificationAverange());
		driverMap.put("licenceExpiration", driver.getLicenceExpiration());
		//List<TravelDTO> travels = driver.getTravels();
		//for (TravelDTO currentTravel: travels){
		//	travelsMap.put(currentTravel.getIdTravel(), this.travelToMap(currentTravel));
		//}
		//driverMap.put("travels", travelsMap);
		return driverMap;
	}
	
	protected Map<String, Object> getPassengerToMap(PassengerDTO currentPassenger){
		Map<String, Object> passengerMap = new HashMap<String, Object>();
		passengerMap.put("userId", currentPassenger.getIdUser());
		passengerMap.put("username", currentPassenger.getUsername());
		passengerMap.put("admissionDate", currentPassenger.getAdmissionDate());
		passengerMap.put("totalCredits", currentPassenger.getTotalCredit());
		return passengerMap;
	}
	
	protected ResponseEntity<?> response(HttpStatus code, String message){
		JSONObject json = new JSONObject();
		json.put("code", code.value());
		json.put("message", message);
		return ResponseEntity.status(code).body(json.toString());
	}
	
	protected ResponseEntity<?> response(HttpStatus code, Map message){
		JSONObject json = new JSONObject();
		json.put("code", code.value());
		json.put("message", message);
		return ResponseEntity.status(code).body(json.toString());
	}

	
	protected ResponseEntity<?> response(HttpStatus code, JSONObject message){
		JSONObject json = new JSONObject();
		json.put("code", code.value());
		json.put("message", message);
		return ResponseEntity.status(code).body(json.toString());
	}
	
	protected ResponseEntity<?> response(){
		JSONObject json = new JSONObject();
		json.put("code", HttpStatus.NO_CONTENT.value());
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(json.toString());
	}

	@RequestMapping(value = "/pasajeros", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> pasajeros() {
		Map<Long, Object> aMap = new HashMap<Long, Object>();
		PassengerService service = ServiceLocator.getPassengerService();
		List<PassengerDTO> passengerList = service.findAllPassengers();
		for ( PassengerDTO currentPassenger : passengerList ){
			aMap.put(currentPassenger.getIdUser(), this.getPassengerToMap(currentPassenger));
		}
		//session.close();
		return this.response(HttpStatus.OK, aMap);
	}

	@RequestMapping(value = "/conductores", method = RequestMethod.GET, produces = "application/json" )
	public ResponseEntity<?> conductores() {
		Map<Long, Object> aMap = new HashMap<Long, Object>();		
		DriverService service = ServiceLocator.getDriverService();
		List<DriverDTO> driversList = service.findAllDrivers();
		for (DriverDTO d : driversList){ 
			aMap.put(d.getIdUser(), d.getUsername());
		}
		return this.response(HttpStatus.OK, aMap);
	}
	
	@RequestMapping(value = "/viajes/abiertos", method = RequestMethod.GET, produces = "application/json" )
	public ResponseEntity<?> viajesAbiertos(){
		Map<Long, Object> aMap = new HashMap<Long, Object>();
		TravelService service = ServiceLocator.getTravelService();
		List<TravelDTO> travelList = service.findOpenedTravels();
		for ( TravelDTO currentTravel : travelList ){
			aMap.put(currentTravel.getIdTravel(), this.travelToMap(currentTravel));
		}
		return this.response(HttpStatus.OK, aMap);
	}

	
	/*
	 * {
		  "points": 2,
		  "comment": "Esto es un comentario re piola ;)",
		  "travel" : { "idTravel": 1 },
		  "passenger": { "idPassenger": 3 }
		}
		
		O
		curl -H "Content-Type: application/json" -X POST -d '{"points": 2, "comment": "Esto es un comentario re piola ;)", "travel" : { "idTravel": 1 }, "passenger": { "idPassenger": 3 }}' http://localhost:8080/MuberRESTful/rest/services/viajes/calificar
	*/
	@RequestMapping(value = "/viajes/calificar", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> calificarViaje(
			@RequestParam("viajeId") long viajeId, 
			@RequestParam("pasajeroId") long pasajeroId,
			@RequestParam("puntaje") int puntaje,
			@RequestParam("comentario") String comentario){
		
		QualificationService service = ServiceLocator.getQualificationService();

		if (service.saveQualification(viajeId, pasajeroId, puntaje, comentario)) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return this.response(HttpStatus.NOT_FOUND, "No se pudo calificar el viaje");
	}
	
	@RequestMapping(value = "/conductores/detalle/{conductorId}", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<?> infoConductor(@PathVariable("conductorId") long conductorId){
		Session session = this.getSession();
		Driver driver = (Driver) session.get(Driver.class, conductorId);
		if (driver != null){
			return this.response(HttpStatus.OK, this.getDriverToMap(driver));
		}
		// Ver cómo solucionar el problema de las relaciones circulares para no usar estas funciones creadas a mano.
		return this.response(HttpStatus.NOT_FOUND, "No existe el conductor");
	}

	/*
	 * {
		  "destiny": "La Plata",
		  "origin": "El Peligro",
		  "maxPassengers" : 6,
		  "totalCost" : 8000,
		  "driver": { "idDriver": 4 }
		}
	 */
	@RequestMapping(value = "/viajes/nuevo", method = RequestMethod.POST, produces = "application/json" )
	public ResponseEntity<?> crearViaje(
			@RequestParam("origen") String origin,
			@RequestParam("destino") String destiny,
			@RequestParam("conductorId") long idDriver,
			@RequestParam("costoTotal") float totalCost,
			@RequestParam("cantidadPasajeros") int maxPassengers
			){	
		TravelService service = ServiceLocator.getTravelService();			

		if (service.saveTravel(idDriver, origin, destiny, maxPassengers, totalCost)) {
			return this.response();
		}
		return this.response(HttpStatus.NOT_FOUND, "No se pudo agregar el viaje, tal vez no existe el conductor");
	}

	@RequestMapping(value = "/viajes/agregarPasajero", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<?> agregarPasajero(@RequestParam long viajeId, @RequestParam long pasajeroId){
		TravelService service = ServiceLocator.getTravelService();

		if(service.addPassengerToTravel(viajeId, pasajeroId)){
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return this.response(HttpStatus.BAD_REQUEST, "No se puede agregar el pasajero al viaje indicado.");
	}
	
	@RequestMapping(value = "/pasajeros/cargarCredito", method = RequestMethod.PUT, produces = "application/json" )
	public ResponseEntity<?> cargarCredito(@RequestParam("pasajeroId") long passengerId, @RequestParam("monto") long amount){
		PassengerService service = ServiceLocator.getPassengerService();
		PassengerDTO passengerDTO = service.updateTotalCredit(passengerId, amount);
		if (passengerDTO != null){
			return this.response(HttpStatus.OK, this.getPassengerToMap(passengerDTO));
		}
		return this.response(HttpStatus.NOT_FOUND, "No existe el passengerId");
	}

	@RequestMapping(value = "/viajes/finalizar", method = RequestMethod.PUT, produces = "application/json" )
	public ResponseEntity<?> finalizarViaje(@RequestParam("viajeId") long travelId){
		TravelService service = ServiceLocator.getTravelService();

		if(service.finalizeTravel(travelId)){
			return this.response();
		}
		return this.response(HttpStatus.BAD_REQUEST, "El viaje ya fue finalizado o no existe.");
	}

	@RequestMapping(value = "/conductores/top10", method = RequestMethod.GET, produces = "application/json" )
	public ResponseEntity<?> conductoresTop10(){
		Session session = this.getSession();
		List<Driver> top10 = this.getMuber(session).getTop10DriversWithoutOpenTravels();
		Map<Long, Object> aMap = new HashMap<Long, Object>();
		for (int i = 0; i < top10.size(); i++) {
			aMap.put((long) i, this.getDriverToMap(top10.get(i)));
		}
		session.close();
		return this.response(HttpStatus.OK, aMap);
	}

	@RequestMapping(value = "/cargarDatos", method = RequestMethod.GET, produces = "application/json" )
	public ResponseEntity<?> cargarDatos(){
		DriverService service = ServiceLocator.getDriverService();
		service.cargarDatos();
		return this.response();
	}
}
