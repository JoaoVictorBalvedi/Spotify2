import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Criando músicas e adicionando a lista
        Metal musica1 = new Metal("Got the life", "Korn", "Brian Welch", "Ray Luzier", "Follow the Leader", "Metal");
        Metal musica2 = new Metal("sic", "Slipknot", "Mick Thomson", "Joey Jordison", "Slipknot", "Metal");
        Music musica3 = new Music("Nutshell", "Alice in Chains", "Jar of Flies", "Grunge");
        Music musica4 = new Music("The Man Who Sold the World", "Nirvana", "MTV Unplugged in New York", "Grunge");
        Rock musica5 = new Rock("Bohemian Rhapsody", "Queen", "A Night at the Opera", "Rock", "Freddie Mercury");

        ArrayList<Music> musicas = new ArrayList<>();
        musicas.add(musica1);
        musicas.add(musica2);
        musicas.add(musica3);
        musicas.add(musica4);
        musicas.add(musica5);

        ArrayList<User> users = new ArrayList<>();
        User usuario1 = new User("João", "123", "Premium");
        User usuario2 = new User("Isadora", "456", "Free");
        users.add(usuario1);
        users.add(usuario2);

        // Login ou criação de conta
        System.out.println("Olá, bem vindo ao Spotify!");
        System.out.println("Digite seu nome para criar uma conta ou fazer login: ");
        String nomeUsuario = sc.nextLine();
        fazerLogin(nomeUsuario, users, musicas);
    }

    public static void fazerLogin(String nomeUsuario, ArrayList<User> users, ArrayList<Music> musicas) {
        Scanner sc = new Scanner(System.in);

        // Procurar o usuário pelo nome na lista de usuários
        User usuarioEncontrado = null;
        for (User user : users) {
            if (user.getNome().equalsIgnoreCase(nomeUsuario)) {
                usuarioEncontrado = user;
                break;
            }
        }

        // Se o usuário não for encontrado, criar uma nova conta
        if (usuarioEncontrado == null) {
            System.out.println("Usuário não encontrado, vamos criar uma conta para você!");
            System.out.println("Digite sua senha: ");
            String senha = sc.nextLine();
            System.out.println("Escolha seu plano: (Free ou Premium)");
            String plano = sc.nextLine();
            User novoUsuario = new User(nomeUsuario, senha, plano);
            users.add(novoUsuario);
            System.out.println("Conta criada com sucesso!");
            usuarioEncontrado = novoUsuario; // Loga o novo usuário
        } else {
            // Usuário encontrado, agora verificar a senha
            System.out.println("Usuário encontrado!");
            System.out.println("Digite sua senha para entrar: ");
            String senha = sc.nextLine();

            // Verificar se a senha está correta
            if (!usuarioEncontrado.getSenha().equals(senha)) {
                System.out.println("Senha incorreta! Tente novamente.");
                return;
            } else {
                System.out.println("Login realizado com sucesso!");
            }
        }

        // Menu de opções após o login
        menuPrincipal(usuarioEncontrado, musicas);
    }

    public static void menuPrincipal(User usuario, ArrayList<Music> musicas) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Music> playlist = new ArrayList<>();

        while (true) {
            System.out.println("\nO que você gostaria de fazer?");
            System.out.println("1. Exibir todas as músicas");
            System.out.println("2. Tocar uma música");
            System.out.println("3. Adicionar música à playlist");
            System.out.println("4. Criar nova playlist");
            System.out.println("5. Exibir sua playlist");
            System.out.println("6. Sair");

            int opcao = sc.nextInt();
            sc.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    exibirMusicas(musicas);
                    break;
                case 2:
                    tocarMusica(musicas, sc);
                    break;
                case 3:
                    adicionarMusicaNaPlaylist(musicas, playlist, sc);
                    break;
                case 4:
                    playlist = criarPlaylist(musicas, sc);
                    break;
                case 5:
                    exibirPlaylist(playlist);
                    break;
                case 6:
                    System.out.println("Obrigado por usar o Spotify! Até logo.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public static void exibirMusicas(ArrayList<Music> musicas) {
        System.out.println("\nLista de músicas disponíveis:");
        for (Music musica : musicas) {
            System.out.println(musica.getNome() + " - " + musica.getArtista() + " (" + musica.getGenero() + ")");
        }
    }

    public static void tocarMusica(ArrayList<Music> musicas, Scanner sc) {
        System.out.println("\nEscolha o número da música para tocar:");
        for (int i = 0; i < musicas.size(); i++) {
            System.out.println((i + 1) + ". " + musicas.get(i).getNome() + " - " + musicas.get(i).getArtista());
        }
        int escolha = sc.nextInt();
        sc.nextLine(); // Consumir nova linha

        if (escolha > 0 && escolha <= musicas.size()) {
            Music musica = musicas.get(escolha - 1);
            System.out.println("Tocando agora: " + musica.getNome() + " - " + musica.getArtista() + " do álbum " + musica.getAlbum());
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    public static void adicionarMusicaNaPlaylist(ArrayList<Music> musicas, ArrayList<Music> playlist, Scanner sc) {
        System.out.println("\nEscolha o número da música para adicionar à playlist:");
        for (int i = 0; i < musicas.size(); i++) {
            System.out.println((i + 1) + ". " + musicas.get(i).getNome() + " - " + musicas.get(i).getArtista());
        }
        int escolha = sc.nextInt();
        sc.nextLine(); // Consumir nova linha

        if (escolha > 0 && escolha <= musicas.size()) {
            Music musica = musicas.get(escolha - 1);
            playlist.add(musica);
            System.out.println(musica.getNome() + " foi adicionada à sua playlist.");
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    public static ArrayList<Music> criarPlaylist(ArrayList<Music> musicas, Scanner sc) {
        ArrayList<Music> novaPlaylist = new ArrayList<>();
        System.out.println("\nCriando nova playlist...");

        while (true) {
            System.out.println("Escolha o número da música para adicionar ou 0 para finalizar:");
            for (int i = 0; i < musicas.size(); i++) {
                System.out.println((i + 1) + ". " + musicas.get(i).getNome() + " - " + musicas.get(i).getArtista());
            }
            int escolha = sc.nextInt();
            sc.nextLine(); // Consumir nova linha

            if (escolha == 0) {
                break;
            } else if (escolha > 0 && escolha <= musicas.size()) {
                Music musica = musicas.get(escolha - 1);
                novaPlaylist.add(musica);
                System.out.println(musica.getNome() + " foi adicionada à sua playlist.");
            } else {
                System.out.println("Escolha inválida.");
            }
        }

        System.out.println("Playlist criada com sucesso!");
        return novaPlaylist;
    }

    public static void exibirPlaylist(ArrayList<Music> playlist) {
        if (playlist.isEmpty()) {
            System.out.println("\nSua playlist está vazia.");
        } else {
            System.out.println("\nSua playlist:");
            for (Music musica : playlist) {
                System.out.println(musica.getNome() + " - " + musica.getArtista());
            }
        }
    }
}