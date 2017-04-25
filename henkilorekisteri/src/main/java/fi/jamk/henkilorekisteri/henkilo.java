package fi.jamk.henkilorekisteri;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="henkilot")
public class henkilo implements Serializable {

	private String etunimi, sukunimi, puhelinnumero, henkilotunnus, tilinumero, tyosuhdealkanut, veronumero, sahkoposti;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}
	
	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getPuhelinnumero() {
		return puhelinnumero;
	}

	public void setPuhelinnumero(String puhelinnumero) {
		this.puhelinnumero = puhelinnumero;
	}

	public String getHenkilotunnus() {
		return henkilotunnus;
	}

	public void setHenkilotunnus(String henkilotunnus) {
		this.henkilotunnus = henkilotunnus;
	}

	public String getTilinumero() {
		return tilinumero;
	}

	public void setTilinumero(String tilinumero) {
		this.tilinumero = tilinumero;
	}

	public String getTyosuhdealkanut() {
		return tyosuhdealkanut;
	}

	public void setTyosuhdealkanut(String tyosuhdealkanut) {
		this.tyosuhdealkanut = tyosuhdealkanut;
	}

	public String getVeronumero() {
		return veronumero;
	}

	public void setVeronumero(String veronumero) {
		this.veronumero = veronumero;
	}

	public String getSahkoposti() {
		return sahkoposti;
	}

	public void setSahkoposti(String sahkoposti) {
		this.sahkoposti = sahkoposti;
	}
	
	
}
