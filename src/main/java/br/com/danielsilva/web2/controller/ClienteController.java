package br.com.danielsilva.web2.controller;


import br.com.danielsilva.web2.service.IClienteService;
import br.com.danielsilva.web2.domain.Cliente;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Collection;

@Named
@ViewScoped
public class ClienteController implements Serializable {


    private static final long serialVersionUID = 8030245985235567808L;

    private Cliente cliente;

    private Collection<Cliente> clientes;

    @Inject
    private IClienteService clienteService;

    private Boolean isUpdate;

    @PostConstruct
    public void init() {
        try {
            this.isUpdate = false;
            this.cliente = new Cliente();
            this.clientes = clienteService.buscarTodos();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os clientes"));
        }
    }

    public void cancel() {
        try {
            this.isUpdate = false;
            this.cliente = new Cliente();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
        }

    }

    public void edit(Cliente cliente) {
        try {
            this.isUpdate = true;
            this.cliente = cliente;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));
        }

    }

    public void delete(Cliente cliente) {
        try {
            clienteService.excluir(cliente);
            clientes.remove(cliente);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));
        }

    }

    public void add() {
        try {
            clienteService.cadastrar(cliente);
            this.clientes = clienteService.buscarTodos();
            this.cliente = new Cliente();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o cliente"));
        }


    }

    public void update() {
        try {
            clienteService.alterar(this.cliente);
            cancel();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Cliente Atualiado com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar o cliente"));
        }

    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Boolean isUpdate) {
        this.isUpdate = isUpdate;
    }




}
