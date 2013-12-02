package data;

import java.sql.Date;
import java.sql.Time;


public class AnuncioDO {
  private int _idAnuncio;
  private int Trajeto_idTrajeto; // foreigner key!!!
  private String _charTipo; //char definida como String
  private String _strMensagem;
  private int _idDiaSemana;
  private Date _dateInicio;
  private Date _dateFim;
  private Time _timeHorarioPartida;
  private Time _timeHorarioChegada;
  
    @Override
    public String toString() {
	return "AnuncioDO [_idAnuncio=" + _idAnuncio + ", Trajeto_idTrajeto="
			+ Trajeto_idTrajeto + ", _charTipo=" + _charTipo
			+ ", _strMensagem=" + _strMensagem + ", _idDiaSemana="
			+ _idDiaSemana + ", _dateInicio=" + _dateInicio + ", _dateFim="
			+ _dateFim + ", _timeHorarioPartida=" + _timeHorarioPartida
			+ ", _timeHorarioChegada=" + _timeHorarioChegada + "]";
}
public int getAnuncio() {
	return _idAnuncio;
}
public void setAnuncio(int _idAnuncio) {
	this._idAnuncio = _idAnuncio;
}
public int getTrajetoidTrajeto() {
	return Trajeto_idTrajeto;
}
public void setTrajetoidTrajeto(int trajeto_idTrajeto) {
	Trajeto_idTrajeto = trajeto_idTrajeto;
}
public String getTipo() {
	return _charTipo;
}
public void setTipo(String _charTipo) {
	this._charTipo = _charTipo;
}
public String getMensagem() {
	return _strMensagem;
}
public void setMensagem(String _strAnuncio) {
    	this._strMensagem = _strAnuncio;
}
public int getDiaSemana() {
	return _idDiaSemana;
}
public void setDiaSemana(int _idDiaSemana) {
	this._idDiaSemana = _idDiaSemana;
}
public Date getInicio() {
	return _dateInicio;
}
public void setInicio(Date _dateInicio) {
	this._dateInicio = _dateInicio;
}
public Date getFim() {
	return _dateFim;
}
public void setFim(Date _dateFim) {
	this._dateFim = _dateFim;
}
public Time getHorarioPartida() {
	return _timeHorarioPartida;
}
public void setHorarioPartida(Time _timeHorarioPartida) {
	this._timeHorarioPartida = _timeHorarioPartida;
}
public Time getHorarioChegada() {
	return _timeHorarioChegada;
}
public void setHorarioChegada(Time _timeHorarioChegada) {
	this._timeHorarioChegada = _timeHorarioChegada;
}
  
}