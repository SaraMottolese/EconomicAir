/**
 * Modello per la richiesta di login
 */
package it.epicode.economicair.security.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

	private String username;
	private String password;
}
