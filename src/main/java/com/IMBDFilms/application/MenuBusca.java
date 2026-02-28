package com.IMBDFilms.application;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.IMBDFilms.Controller.ImbdFilmsController;


@Component
public class MenuBusca {
    @Autowired
    private ImbdFilmsController imbdFilmsController;
    @Autowired
    private Scanner sc;

    public void exibeMenuBusca() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    \n*** IMBDFilms - Sistema de Busca ***
                    1 - Buscar filme por título
                    2 - Buscar por título e tipo (filme/série)
                    3 - Buscar por título, tipo e gênero (Ordenado por ano)
                    0 - Sair
                    """;

            System.out.println(menu);
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            System.out.println("______________________________________________________");
            switch (opcao) {
                case 1:
                    buscarPorTitulo();
                    break;
                case 2:
                    buscarPorTituloETipo();
                    break;
                case 3:
                    buscarCompleta();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            System.out.println("______________________________________________________");
        }
    }

    private void buscarPorTitulo() {
        System.out.print("Digite o título do filme: ");
        var title = sc.nextLine();
        imbdFilmsController.getMethodName(title);
    }

    private void buscarPorTituloETipo() {
        System.out.print("Digite o título: ");
        var title = sc.nextLine();
        System.out.print("Digite o tipo (movie/tvSeries): ");
        var type = sc.nextLine();
        imbdFilmsController.getMethodNameAndType(title, type);
    }

    private void buscarCompleta() {
        System.out.print("Digite o título: ");
        var title = sc.nextLine();
        System.out.print("Digite o tipo: ");
        var type = sc.nextLine();
        System.out.print("Digite o gênero: ");
        var genres = sc.nextLine();
        imbdFilmsController.getMethodNameAndTypeAndGenres(title, type, genres);
    }
    


 
}
