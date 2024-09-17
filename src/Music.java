public class Music {
    public String nome;
    public String artista;
    public String album;
    public String genero;

    public Music(String nome, String artista, String album, String genero) {
        this.nome = nome;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    public String getAlbum() {
        return album;
    }

    public String getGenero() {
        return genero;
    }
}