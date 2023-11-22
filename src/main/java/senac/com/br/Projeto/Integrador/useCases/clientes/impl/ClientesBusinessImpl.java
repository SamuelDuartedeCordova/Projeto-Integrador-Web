package senac.com.br.Projeto.Integrador.useCases.clientes.impl;

import org.springframework.beans.factory.annotation.Autowired;
import senac.com.br.Projeto.Integrador.frameWork.annotions.Business;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.frameWork.utils.StringUtil;
import senac.com.br.Projeto.Integrador.useCases.clientes.ClientesBusiness;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesRequestDom;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesResponseDom;
import senac.com.br.Projeto.Integrador.useCases.clientes.impl.repositorys.ClientesEnderecosRepository;
import senac.com.br.Projeto.Integrador.useCases.clientes.impl.repositorys.ClientesRepository;

import java.util.ArrayList;
import java.util.List;

@Business
public class ClientesBusinessImpl implements ClientesBusiness {

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private ClientesEnderecosRepository clientesEnderecosRepository;

    @Override
    public List<ClientesResponseDom> carregarClientes() {
        return null;
    }

    @Override
    public ClientesResponseDom criarCliente(ClientesRequestDom clientesRequestDom) throws Exception {
        return null;
    }

    @Override
    public ClientesResponseDom atualizarClientes(Long id, ClientesRequestDom clientesRequestDom) throws ProFutException {
        return null;
    }

    @Override
    public void deletarCliente(Long id) {

    }

    @Override
    public ClientesResponseDom carregarClienteById(Long id) throws ProFutException {
        return null;
    }
    private List<String> validacaoManutencaoCliente(ClientesRequestDom cliente) {
        List<String> messages = new ArrayList<>();

        if(StringUtil.validarString(cliente.getNome())){
            messages.add("Cliente informado não possui nome!");
        }

        if(StringUtil.validarString(cliente.getSobreNome())){
            messages.add("Cliente informado não possui sobrenome!");
        }

        if(StringUtil.validarString(cliente.getEmail())){
            messages.add("Cliente informado não possui email");
        }

        return messages;
    }
}
