package com.example.echo;
import java.util.ArrayList;
import com.google.api.server.spi.auth.EspAuthenticator;
import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiIssuer;
import com.google.api.server.spi.config.ApiIssuerAudience;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.UnauthorizedException;
//[START echo_api_annotation]
@Api(
    name = "proxy",
    version = "v1",
    namespace =
    @ApiNamespace(
        ownerDomain = "echo.example.com",
        ownerName = "echo.example.com",
        packagePath = ""
    )
)

//[END echo_api_annotation]
public class Proxy implements IProxy {
	/**
	 * Create an instance of the Facade unique object
	 */
	private Facade facade = Facade.remplazarConstructora();
	/**
	 * This methods create an unique instance of the Proxy
	 */
	private static Proxy unicaInstancia = null;
	
	public Proxy() {
	}
	
	public static Proxy reemplazarConstructura() {
		if(unicaInstancia == null) {
			unicaInstancia =  new Proxy();
		}
		return unicaInstancia;
	}
	
	/**
	 * this method grants access to the facade instance, 
	 * @return an identity of the user in the server instance
	 */

	@ApiMethod(name = "ingresarAplicacion")
	@Override
	public Sesion ingresarAplicacion(@Named("usuario")String user, @Named("contrasena")String contrasena){
			IUsuario usuario = facade.autentica(user, contrasena);
			if (usuario != null) {
				Sesion s = new Sesion();
				s.nuevasesion();
				facade.addIdentidad(s.getSesion());
				return s;
			}
			return null;
	}
}