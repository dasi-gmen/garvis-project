package icaro.aplicaciones.informacion.gestionGarvis;

public class NotificacionBiblioteca {
	public String identNotificador;
	public String mensajeNotificacion;
	public Object contexto;
	public String identObjectRefNotificacion;
	public String tipoNotificacion;
	public String NombreLibro;

	public NotificacionBiblioteca(Notificacion notif) {
		identNotificador = notif.getidentNotificador();
		setMensajeNotificacion(notif.getMensajeNotificacion());
		setcontexto(notif.getcontexto());
		setidentObjectRefNotificacion(notif.getidentObjectRefNotificacion());
		setTipoNotificacion(notif.getTipoNotificacion());
		//setLibro(notif.getLibro());
	}

	public void setLibro(String Libro) {
		this.NombreLibro = Libro;
	}

	public String getidentObjectRefNotificacion() {
		return identObjectRefNotificacion;
	}

	public void setidentObjectRefNotificacion(String identObjRef) {
		identObjectRefNotificacion = identObjRef;
	}

	public void setMensajeNotificacion(String notificacion) {
		mensajeNotificacion = notificacion;
	}

	public String getMensajeNotificacion() {
		return mensajeNotificacion;
	}

	public void setTipoNotificacion(String notifTipo) {
		tipoNotificacion = notifTipo;
	}

	public String getTipoNotificacion() {
		return tipoNotificacion;
	}

	public String getidentNotificador() {
		return identNotificador;
	}

	public void setcontexto(Object contContexto) {
		contexto = contContexto;
	}

	public Object getcontexto() {
		return contexto;
	}

	@Override
	public String toString() {
		if (contexto == null) {
			return "Ident Notificador :" + identNotificador
					+ " Tipo Notificacion :" + tipoNotificacion
					+ " MensajeNotificacion :+" + mensajeNotificacion
					+ "  Contexto: null " + "\n ";
		} else {
			return "Agente Emisor :" + identNotificador
					+ " MensajePropuesta :+" + mensajeNotificacion
					+ "  Justificacion: " + contexto.toString() + "\n ";
		}
	}

}
