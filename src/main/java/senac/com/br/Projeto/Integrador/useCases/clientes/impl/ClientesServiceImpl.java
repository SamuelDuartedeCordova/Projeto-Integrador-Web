package senac.com.br.Projeto.Integrador.useCases.clientes.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.useCases.clientes.ClientesBusiness;
import senac.com.br.Projeto.Integrador.useCases.clientes.ClientesService;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesRequestDom;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesResponseDom;

import java.util.List;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private ClientesBusinessImpl clientesBusiness;

    @Override
    public List<ClientesResponseDom> carregarClientes() {
        return clientesBusiness.carregarClientes();
    }

    @Override
    public ClientesResponseDom criarCliente(ClientesRequestDom clientesRequestDom) throws ProFutException {
        return clientesBusiness.criarCliente(clientesRequestDom);
    }

    @Override
    public ClientesResponseDom atualizarClientes(Long id, ClientesRequestDom cliente) throws ProFutException {
        return clientesBusiness.atualizarClientes(id, cliente);
    }

    @Override
    public void deletarCliente(Long id) {
        clientesBusiness.deletarCliente(id);
    }

    @Override
    public ClientesResponseDom carregarClienteById(Long id) throws ProFutException {
        return clientesBusiness.carregarClienteById(id);
    }
}
