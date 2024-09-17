public class Rock extends Music {
    private String vocalista;

    public Rock(String nome, String artista, String album, String genero, String vocalista) {
        super(nome, artista, album, genero);
        this.vocalista = vocalista;
    }

    public String getVocalista() {
        return vocalista;
    }
}

