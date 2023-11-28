package senac.com.br.Projeto.Integrador.useCases.clientes;

import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesRequestDom;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesResponseDom;

import java.util.List;


public interface ClientesService {
     List<ClientesResponseDom> carregarClientes();
     ClientesResponseDom criarCliente(ClientesRequestDom cliente) throws Exception;
     ClientesResponseDom atualizarClientes(Long id, ClientesRequestDom cliente) throws ProFutException;
     void deletarCliente(Long id);
     ClientesResponseDom carregarClienteById(Long id) throws ProFutException;

}
