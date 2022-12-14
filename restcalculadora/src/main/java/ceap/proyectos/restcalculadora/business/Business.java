/**
 * Avilez Pérez Carlos
 */

package ceap.proyectos.restcalculadora.business;

import org.springframework.stereotype.Component;

import ceap.proyectos.restcalculadora.dto.Response;


@Component
public class Business {
	
	public Response suma(int num1, int num2) {
		Response response = new Response();
		response.setResultado(num1 + num2);
		return response;
	}

	public Response multiplacion(int num1, int num2) {
		Response response = new Response();
		response.setResultado(num1 * num2);
		return response;
	}

	public Response resta(int num1, int num2) {
		Response response = new Response();
		response.setResultado(num1 - num2);
		return response;
	}

	public Response division(int num1, int num2) {
		Response response = new Response();
		if(num1 == 0 || num2 == 0){
			response.setResultado(0);
		}
		else{
			response.setResultado(num1/num2);
		}
		return response;
	}
}