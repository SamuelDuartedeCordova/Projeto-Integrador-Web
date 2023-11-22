package senac.com.br.Projeto.Integrador.useCases.clientes;

import senac.com.br.Projeto.Integrador.frameWork.annotions.Business;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesRequestDom;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesResponseDom;

import java.util.List;

@Business
public interface ClientesBusiness {
    List<ClientesResponseDom> carregarClientes();
    ClientesResponseDom criarCliente(ClientesRequestDom clientesRequestDom) throws Exception;
    ClientesResponseDom atualizarClientes(Long id, ClientesRequestDom clientesRequestDom) throws ProFutException;
    void deletarCliente(Long id);
    ClientesResponseDom carregarClienteById(Long id) throws ProFutException;
}
