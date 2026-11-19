package funcoes;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {

    @SuppressWarnings ("unused")
    private String nome;
    private List<Quarto> quartos;
    private List<Reserva> reservas;



    public Hotel(String nome) {
        this.nome = nome;
        this.quartos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }


    //                           Cadastro de Quarto
    // ===================================================================

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

    //                           Listar Quartos
    // ====================================================================

    public void listarQuartos() {

        System.out.println("\n----- Lista de Quartos -----");

        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto cadastrado.");
            return;
        }

        for (int i = 0; i < quartos.size(); i++) {
            System.out.println(quartos.get(i));
        }
    }

    // ====================================================================

    public void fazerReserva() {

    System.out.println("\n--- Fazer Reserva ---");

    int numero = Leitura.lerInteiro("Número do quarto: ", 1);

    Quarto quartoEncontrado = null;

    for (int i = 0; i < quartos.size(); i++) {

        if (quartos.get(i).getNumero() == numero) {
            quartoEncontrado = quartos.get(i);
            break;
        }
    }

    if (quartoEncontrado == null) {
        System.out.println("Quarto não encontrado!");
        return;
    }

    LocalDate entrada = Leitura.lerData("Data de entrada (dd/MM/yyyy): ");
    LocalDate saida = Leitura.lerData("Data de saída (dd/MM/yyyy): ");

    if (!entrada.isBefore(saida)) {
        System.out.println("A data de saída deve ser posterior à entrada!");
        return;
    }

    for (int i = 0; i < reservas.size(); i++) {

        Reserva reservaExistente = reservas.get(i);

        if (reservaExistente.getQuarto().equals(quartoEncontrado)) {
            boolean conflito =
                    entrada.isBefore(reservaExistente.getDataSaida())
                    && saida.isAfter(reservaExistente.getDataEntrada());

            if (conflito) {
                System.out.println("Quarto já reservado nesse período!");
                return;
            }
        }
    }
    Reserva novaReserva = new Reserva(quartoEncontrado, entrada, saida);

    reservas.add(novaReserva);

    System.out.println("Reserva realizada com sucesso!");
}







    public void consultarQuarto() {}
    public void cancelarReserva() {}

}