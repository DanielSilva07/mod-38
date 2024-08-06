package br.com.danielsilva.web2.service;

import br.com.danielsilva.web2.domain.Cliente;
import br.com.danielsilva.web2.exeptions.DAOException;

public interface IClienteService extends IGenericService<Cliente, Long> {

    Cliente buscarPorCPF(Long cpf) throws DAOException;
}
