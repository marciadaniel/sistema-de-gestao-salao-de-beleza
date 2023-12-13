
package model;

import java.sql.Time;
import java.sql.Date;









public class MarcacaoModel {

     private int numero;
    private String cliente;
    private String servico;
    private Date data_;
    private Time hora_;
    private int idCliente;
    private int codServico;
    
    
   
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    

    public Date getData_() {
        return data_;
    }

    public void setData_(Date data_) {
        this.data_ = data_;
    }

    public Time getHora_() {
        return hora_;
    }

    public void setHora_(Time hora_) {
        this.hora_ = hora_;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCodServico() {
        return codServico;
    }

    public void setCodServico(int codServico) {
        this.codServico = codServico;
    }

  












}