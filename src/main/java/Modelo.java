

public class Modelo {
	
	private String asunto;
	
	
	private String servidor;
	
	
	private String puerto;
	
	private String email1;
	
	
	private String email2;
	
	
	private String destino;
	
	
	private String mensaje;
	
	private boolean check;
	
	public boolean getCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getAsunto() {
		return asunto;
	}


	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}


	public String getServidor() {
		return servidor;
	}





	public String getPuerto() {
		return puerto;
	}





	public String getEmail1() {
		return email1;
	}


	public void setEmail1(String email1) {
		this.email1 = email1;
	}


	public String getEmail2() {
		return email2;
	}


	public void setEmail2(String email2) {
		this.email2 = email2;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public void setServidor(String text) {
		this.servidor=text;
		
	}


	public void setPuerto(String text) {
		this.puerto=text;
		
	}
	
	
	
	
	
}
