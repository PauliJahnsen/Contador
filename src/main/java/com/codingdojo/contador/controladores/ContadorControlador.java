package com.codingdojo.contador.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ContadorControlador {
	//crear dos rutas usando @GetMapping; una para el inicio y la otra para mostrar la cantidad de visitas
	//HttpSession -> es para asignar variables a una sesion (se genera cada vez que uno ingresa al navegador)
	
	@GetMapping("/")
	public String index(HttpSession session) {
		Integer contador = (Integer) session.getAttribute("contadorVistas");

        if (contador == null) {
            contador = 0;
        }
        contador++;
        
        session.setAttribute("contadorVistas", contador);
		
		return "index.jsp";
	}
	
	@GetMapping("/contador")
	public String contador(HttpSession session) {
		return "contador.jsp";
	}

	
}
