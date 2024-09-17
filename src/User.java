class User {
    private String nome;
    private String senha;
    private String plano;

    public User(String nome, String senha, String plano) {
        this.nome = nome;
        this.senha = senha;
        this.plano = plano;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getPlano() {
        return plano;
    }
}