
package model;


public class EstoqueModel {
    private int codigo;
    private String itemdeestoque;
    private int quantidade;
    private int preco;
    private int fornecedor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getItemdeestoque() {
        return itemdeestoque;
    }

    public void setItemdeestoque(String itemdeestoque) {
        this.itemdeestoque = itemdeestoque;
    }
}
