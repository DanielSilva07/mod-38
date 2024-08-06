package br.com.danielsilva.web2.dao;

import br.com.danielsilva.web2.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    public ClienteDAO() {
        super(Cliente.class);
    }
}
