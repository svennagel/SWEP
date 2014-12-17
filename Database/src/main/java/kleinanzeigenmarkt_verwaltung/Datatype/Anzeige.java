package kleinanzeigenmarkt_verwaltung.Datatype;

public class Anzeige {
	
	private int id;
	private String bezeichnung;
	private int menge;
	private float preis;
	private String kontakt;
	
	public Anzeige(int _id, String _bezeichnung, int _menge, float _preis, String _kontakt){
		
		this.id = _id;
		this.bezeichnung = _bezeichnung;
		this.menge = _menge;
		this.preis = _preis;
		this.kontakt = _kontakt;
		
	}

}
