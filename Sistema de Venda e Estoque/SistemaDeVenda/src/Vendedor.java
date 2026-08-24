public class Vendedor {

    private float vendas;

    private float salarioBase;

    private String nome;

    private int faltas;

    public Vendedor(float vendas, float salarioBase, String nome, int faltas) {

        this.vendas = vendas;

        this.salarioBase = salarioBase;

        this.nome = nome;

        this.faltas = faltas;

    }

    public float getVendas() {

        return vendas;

    }

    public void setVendas(float vendas) {

        this.vendas = vendas;

    }

    public float getSalarioBase() {

        return salarioBase;

    }

    public void setSalarioBase(float salarioBase) {

        this.salarioBase = salarioBase;

    }

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public int getFaltas() {

        return faltas;

    }

    public void setFaltas(int faltas) {

        this.faltas = faltas;

    }

    public float calcularComissao() {

        if (vendas >= 1000 && vendas < 2000) {

            return vendas * 0.10f;

        } else if (vendas >= 2000) {

            return vendas * 0.15f;

        }

        return 0;

    }

    public float descontoFalta() {

        return (salarioBase / 30) * faltas;

    }

    public float calcularSalario() {

        return salarioBase + calcularComissao() - descontoFalta();

    }

    public String toString() {

        return "Nome: " + nome +

                "\nSalário Base: " + salarioBase +

                "\nVendas: " + vendas +

                "\nFaltas: " + faltas +

                "\nComissão: " + calcularComissao() +

                "\nSalário Final: " + calcularSalario() +

                "\n---------------------------";

    }

}
