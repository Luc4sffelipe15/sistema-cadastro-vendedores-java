import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class App {

    private Vendedor[] listaVendedor = new Vendedor[10];

    private int totalCadastrado = 0;

    public static void main(String[] args) {

        new App();

    }

    public App() {

        executarMenu();

    }

    public void executarMenu() {

        int opcao;

        do {

            String[] opcoes = {
                    "Cadastrar vendedor",
                    "Listar vendedores",
                    "Sair"
            };

            opcao = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção:",
                    "Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

            switch (opcao) {

                case 0:

                    cadastrarVendedor();

                    break;

                case 1:

                    listarVendedores();

                    break;

                case 2:

                    JOptionPane.showMessageDialog(
                            null,
                            "Saindo...");

                    break;

                case -1:

                    // Usuário fechou a janela pelo X
                    opcao = 2;

                    break;

                default:

                    JOptionPane.showMessageDialog(
                            null,
                            "Opção inválida!");

            }

        } while (opcao != 2);

    }

    public void cadastrarVendedor() {

        if (totalCadastrado >= listaVendedor.length) {

            JOptionPane.showMessageDialog(
                    null,
                    "Limite de vendedores atingido!");

            return;
        }

        String nome = JOptionPane.showInputDialog(
                "Nome:");

        float vendas = Float.parseFloat(
                JOptionPane.showInputDialog(
                        "Total vendido:"));

        float salario = Float.parseFloat(
                JOptionPane.showInputDialog(
                        "Salário base:"));

        int faltas = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Número de faltas:"));

        listaVendedor[totalCadastrado] = new Vendedor(
                vendas,
                salario,
                nome,
                faltas);

        totalCadastrado++;

        JOptionPane.showMessageDialog(
                null,
                "Vendedor cadastrado!");

    }

    public void listarVendedores() {

        // Verifica se existem vendedores
        if (totalCadastrado == 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "Nenhum vendedor cadastrado!");

            return;
        }

        // Ordena os vendedores por nome
        for (int i = 0; i < totalCadastrado - 1; i++) {

            for (int j = i + 1; j < totalCadastrado; j++) {

                if (listaVendedor[i].getNome()
                        .compareToIgnoreCase(
                                listaVendedor[j].getNome()) > 0) {

                    Vendedor temp = listaVendedor[i];

                    listaVendedor[i] = listaVendedor[j];

                    listaVendedor[j] = temp;
                }
            }
        }

        // Define as colunas da tabela
        String[] colunas = {
                "Nome",
                "Salário",
                "Vendas",
                "Faltas",
                "Comissão"
        };

        // Cria os dados da tabela
        Object[][] dados = new Object[totalCadastrado][5];

        for (int i = 0; i < totalCadastrado; i++) {

            dados[i][0] = listaVendedor[i].getNome();

            dados[i][1] = listaVendedor[i].getSalarioBase();

            dados[i][2] = listaVendedor[i].getVendas();

            dados[i][3] = listaVendedor[i].getFaltas();

            dados[i][4] = listaVendedor[i].calcularComissao();
        }

        // Cria a tabela
        JTable tabela = new JTable(dados, colunas);

        // Adiciona rolagem
        JScrollPane scroll = new JScrollPane(tabela);

        // Exibe a tabela
        JOptionPane.showMessageDialog(
                null,
                scroll,
                "Lista de Vendedores",
                JOptionPane.INFORMATION_MESSAGE);

    }

}