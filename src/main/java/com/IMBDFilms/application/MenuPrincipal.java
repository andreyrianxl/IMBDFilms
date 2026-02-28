package com.IMBDFilms.application;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.IMBDFilms.Controller.ImbdFilmsController;
import com.IMBDFilms.model.Film;

@Component
public class MenuPrincipal {

    private final ImbdFilmsController imbdFilmsController;

    @Autowired
    private MenuBusca menuBusca; // Injetamos o seu menu de busca aqui!

    @Autowired
    private Scanner sc;

    public MenuPrincipal(ImbdFilmsController imbdFilmsController) {
        this.imbdFilmsController = imbdFilmsController;
    }

    public void exibeMenuPrincipal() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    \n*** IMBDFilms - MENU GERAL ***
                    1 - Cadastrar novo filme
                    2 - Menu de Pesquisa (Buscar) ->
                    3 - Atualizar dados de um filme
                    4 - Deletar um filme
                    0 - Sair da Aplicação
                    """;

            System.out.println(menu);
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer do teclado

            switch (opcao) {
                case 1:
                    cadastrarFilme();
                    break;
                case 2:
                    // Aqui a gente transfere o controle para o seu MenuBusca
                    menuBusca.exibeMenuBusca(); 
                    break;
                case 3:
                    atualizarFilme();
                    break;
                case 4:
                    deletarFilme();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema IMBDFilms...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarFilme() {
        System.out.println("\n--- CADASTRO DE FILME ---");
        
        // Como seu ID não é auto-generated no banco ainda, vamos pedir (ou gerar UUID)
        System.out.print("Digite o ID (ex: tt9999): ");
        String id = sc.nextLine();

        System.out.print("Título: ");
        String title = sc.nextLine();

        System.out.print("Tipo (movie/tvSeries): ");
        String type = sc.nextLine();

        System.out.print("Gêneros (ex: Drama,Action): ");
        String genres = sc.nextLine();

        System.out.print("Ano de Estreia (número): ");
        Integer year = sc.nextInt();
        sc.nextLine(); // Limpa buffer

        Film novoFilme = new Film();
        novoFilme.setTitleId(id);
        novoFilme.setTitle(title);
        novoFilme.setType(type);
        novoFilme.setGenres(genres);
        novoFilme.setPremiered(year);

        // Chama o método do seu controller
        imbdFilmsController.postMethodName(novoFilme);
    }

    private void atualizarFilme() {
        System.out.println("\n--- ATUALIZAÇÃO DE FILME ---");
        System.out.print("Digite o ID do filme que deseja alterar: ");
        String id = sc.nextLine();

        // Para simplificar, vamos pedir os novos dados
        // (Num sistema real, buscaríamos os dados atuais primeiro para mostrar)
        System.out.print("Novo Título: ");
        String title = sc.nextLine();

        System.out.print("Novo Gênero: ");
        String genres = sc.nextLine();
        
        // Criamos o objeto com os dados novos
        Film dadosNovos = new Film();
        dadosNovos.setTitle(title);
        dadosNovos.setGenres(genres);
        
        // O método do seu controller já trata a lógica de buscar e salvar
        imbdFilmsController.putMethodName(id, dadosNovos);
    }

    private void deletarFilme() {
        System.out.println("\n--- REMOÇÃO DE FILME ---");
        System.out.print("Digite o ID do filme para deletar: ");
        String id = sc.nextLine();

        System.out.print("Tem certeza? (S/N): ");
        String confirmacao = sc.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) {
            imbdFilmsController.deleteMethodName(id);
        } else {
            System.out.println("Operação cancelada.");
        }
    }
}