package senac.com.br.Projeto.Integrador.useCases.clientes;

import org.springframework.stereotype.Service;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesRequestDom;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesResponseDom;

import java.util.List;

@Service
public interface ClientesService {
     List<ClientesResponseDom> carregarClientes();
     ClientesResponseDom criarCliente(ClientesRequestDom clientesRequestDom) throws Exception;
     ClientesResponseDom atualizarClientes(Long id, ClientesRequestDom clientesRequestDom) throws ProFutException;
     void deletarCliente(Long id);
     ClientesResponseDom carregarClienteById(Long id) throws ProFutException;

}
