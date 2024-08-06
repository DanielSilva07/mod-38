package br.com.danielsilva.web2.service;

import br.com.danielsilva.web2.dao.IClienteDAO;
import br.com.danielsilva.web2.domain.Cliente;
import br.com.danielsilva.web2.exeptions.DAOException;
import br.com.danielsilva.web2.exeptions.MaisDeUmRegistroException;
import br.com.danielsilva.web2.exeptions.TableException;
import jakarta.inject.Inject;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    @Inject
    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) throws DAOException {
        try {
            return this.dao.consultar(cpf);
        } catch (MaisDeUmRegistroException | TableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
