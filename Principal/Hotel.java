package Principal;

import java.util.List;
import java.util.ArrayList;

import  funcoes.Quarto;
import funcoes.Leitura;

public class Hotel {

    private String nome;
    private List<Quarto> quartos;

    public Hotel(String nome) {
        this.nome = nome;
        this.quartos = new ArrayList<>();
    }

    public void cadastrarQuarto() {

        System.out.println("\n--- Cadastrar Quarto ---");
        int numero = Leitura.lerInteiro("Número do quarto: ", 1);
        int capacidade = Leitura.lerInteiro("Capacidade do quarto: ", 1);
        double valorDiaria = Leitura.lerDouble("Valor da diária: R$ ", 0.01);


        Quarto novoQuarto = new Quarto(numero, capacidade, valorDiaria);

        if (quartos.contains(novoQuarto)) {
            System.out.println("\nQuarto já cadastrado!");
            return;
        }

        quartos.add(novoQuarto);

        System.out.println("\nQuarto cadastrado com sucesso!");
        System.out.println(novoQuarto);
    }


    public void fazerReserva() {}
    public void cancelarReserva() {}
    public void listarQuartos() {}
    public void consultarQuarto() {}
}