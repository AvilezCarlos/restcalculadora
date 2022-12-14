/**
 * Avilez Pérez Carlos
 */

package ceap.proyectos.restcalculadora.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import ceap.proyectos.restcalculadora.business.Business;
import ceap.proyectos.restcalculadora.dto.Response;



@RestController
public class CalculadoraRest {
    
    @Autowired
    private Business business;

    /**
     * Servicio rest para simular una calculadora usando JSON Path.
     * @param json Json a recibir.
     * @return Resultado de la operación.
     */
    @GetMapping("/suma")
    public ResponseEntity<Response> suma(
            @RequestBody String json) {
		DocumentContext readContext = JsonPath.parse(json);
        //Almacena en un entero el valor de cada posición del ARRAY en el Json utilizando JSON Path
		int numero1 = readContext.read("$.request.numeros[0]");
		int numero2 = readContext.read("$.request.numeros[1]");
        //Operación a realizar que se almacena en el la respuesta
        Response response = 
                business.suma(numero1, numero2);
        //Se retorna la respuesta
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @GetMapping("/multiplicar")
    public ResponseEntity<Response> multiplicar(
            @RequestBody String json) {
		DocumentContext readContext = JsonPath.parse(json);
        //Almacena en un entero el valor de cada posición del ARRAY en el Json utilizando JSON Path
		int numero1 = readContext.read("$.request.numeros[0]");
		int numero2 = readContext.read("$.request.numeros[1]");
        //Operación a realizar que se almacena en el la respuesta
        Response response = 
                business.multiplacion(numero1, numero2);
        //Se retorna la respuesta
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @GetMapping("/restar")
    public ResponseEntity<Response> restar(
            @RequestBody String json) {
		DocumentContext readContext = JsonPath.parse(json);
        //Almacena en un entero el valor de cada posición del ARRAY en el Json utilizando JSON Path
		int numero1 = readContext.read("$.request.numeros[0]");
		int numero2 = readContext.read("$.request.numeros[1]");
        //Operación a realizar que se almacena en el la respuesta
        Response response = 
                business.resta(numero1, numero2);
        //Se retorna la respuesta
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @GetMapping("/dividir")
    public ResponseEntity<Response> dividir(
            @RequestBody String json) {
		DocumentContext readContext = JsonPath.parse(json);
        //Almacena en un entero el valor de cada posición del ARRAY en el Json utilizando JSON Path
		int numero1 = readContext.read("$.request.numeros[0]");
		int numero2 = readContext.read("$.request.numeros[1]");
        //Operación a realizar que se almacena en el la respuesta
        Response response = 
                business.division(numero1, numero2);
        //Se retorna la respuesta
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
}
