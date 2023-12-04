package senac.com.br.Projeto.Integrador.useCases.clientes;

import senac.com.br.Projeto.Integrador.entitys.Clientes;
import senac.com.br.Projeto.Integrador.frameWork.annotions.Business;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesRequestDom;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesResponseDom;

import java.util.List;

public interface ClientesBusiness {
    List<ClientesResponseDom> carregarClientes();
    ClientesResponseDom criarCliente(ClientesRequestDom cliente) throws Exception;
    ClientesResponseDom atualizarClientes(Long id, ClientesRequestDom cliente) throws ProFutException;
    void deletarCliente(Long id);
    Clientes carregarClienteEntidade(Long id);
    ClientesResponseDom carregarClienteById(Long id) throws ProFutException;
}
