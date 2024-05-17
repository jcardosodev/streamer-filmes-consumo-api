package br.org.serratec.streamer.model;

public enum Genero {
	ACAO("Action"),
	ROMANCE("Romance"),
	COMEDIA("Comedy"),
	DRAMA("Drama"),
	TERROR("Horror"),
	CRIME("Crime"),
	SUSPENSE("Thriler"),
	INDEFINIDO("Undefined");
	
	//criar um construtor para traduzir e transformar
	private String categoriaIngles;
	
	private Genero(String categoriaIngles) {
		this.categoriaIngles = categoriaIngles;
	}
	
	public static Genero toGenero(String textoIngles) {
		//faz percorrer todos os generos do json
		for (Genero genero : Genero.values()) {
			if (genero.categoriaIngles.equalsIgnoreCase(textoIngles)) {
				return genero;
			}
		}
		
		return Genero.INDEFINIDO;
	}
}
