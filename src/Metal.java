public class Metal extends Music {
    private String guitarrista;
    private String baterista;

    public Metal(String nome, String artista, String guitarrista, String baterista, String album, String genero) {
        super(nome, artista, album, genero);
        this.guitarrista = guitarrista;
        this.baterista = baterista;
    }

    public String getGuitarrista() {
        return guitarrista;
    }

    public String getBaterista() {
        return baterista;
    }
}
