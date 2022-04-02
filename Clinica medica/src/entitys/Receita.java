/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;
import Controles.ControleItemReceita;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author guest-nhdk5d
 */
public class Receita {
    
    private int idReceita;
    private int idConulta;
    private Date dataReceita;
    private Date dataValidade;
    private int idPaciente;
    private String crm;
    public List<ItemReceita> itens;
    private ItemReceita novoItem;
    
    public Receita(){
        novoItem = new ItemReceita();
        itens = new ArrayList<>();
        
    }
    
    public void AddMedicamento(String IdItem,int quantidade){
        ControleItemReceita cir = new ControleItemReceita();
        novoItem = cir.buscarItem(IdItem);
        novoItem.setQuantidade(quantidade);
        itens.add(novoItem);
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public int getIdConulta() {
        return idConulta;
    }

    public void setIdConulta(int idConulta) {
        this.idConulta = idConulta;
    }

    public Date getDataReceita() {
        return dataReceita;
    }

    public void setDataReceita(Date dataReceita) {
        this.dataReceita = dataReceita;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
    
    
}
