package senac.com.br.Projeto.Integrador.useCases.clientes.impl;

import org.springframework.beans.factory.annotation.Autowired;
import senac.com.br.Projeto.Integrador.entitys.Clientes;
import senac.com.br.Projeto.Integrador.frameWork.annotions.Business;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.frameWork.utils.StringUtil;
import senac.com.br.Projeto.Integrador.useCases.clientes.ClientesBusiness;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesRequestDom;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesResponseDom;
import senac.com.br.Projeto.Integrador.useCases.clientes.impl.mappers.ClientesMapper;
import senac.com.br.Projeto.Integrador.useCases.clientes.impl.repositorys.ClientesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Business
public class ClientesBusinessImpl implements ClientesBusiness {

    @Autowired
    private ClientesRepository clientesRepository;



    @Override
    public List<ClientesResponseDom> carregarClientes() {
        List<Clientes> clientesList = clientesRepository.findAll();

        List<ClientesResponseDom> out = clientesList
                .stream()
                .map(ClientesMapper::clientesToClientesResponseDom)
                .collect(Collectors.toList());

        return out;
    }

    @Override
    public ClientesResponseDom criarCliente(ClientesRequestDom clientesRequestDom) throws ProFutException {
        List<String> messages = this.validacaoManutencaoCliente(clientesRequestDom);

        if(!messages.isEmpty()){
            throw new ProFutException(messages);
        }

        Clientes clientes = ClientesMapper.clientesRequestDomToClientes(clientesRequestDom);

        Clientes resultClientes = clientesRepository.save(clientes);

        ClientesResponseDom out = ClientesMapper.clientesToClientesResponseDom(resultClientes);

        return out;
    }

    @Override
    public ClientesResponseDom atualizarClientes(Long id, ClientesRequestDom clientesRequestDom) throws ProFutException {
        List<String> messages = this.validacaoManutencaoCliente(clientesRequestDom);

        if(!messages.isEmpty()){
            throw new ProFutException(messages);
        }

        Optional<Clientes> clientes = clientesRepository.findById(id).map(record -> {
            record.setNome(clientesRequestDom.getNome());
            record.setSobrenome(clientesRequestDom.getSobreNome());
            record.setEmail(clientesRequestDom.getEmail());
            record.setSenha(clientesRequestDom.getSenha());

            return clientesRepository.save(record);
        });

        if(!clientes.isPresent()){
            throw new ProFutException("Cliente informado não existe!");
        }

        ClientesResponseDom out = ClientesMapper.clientesToClientesResponseDom(clientes.get());

        return out;
    }

    @Override
    public void deletarCliente(Long id) {
        clientesRepository.deleteById(id);
    }

    @Override
    public Clientes carregarClienteEntidade(Long id) {
        Clientes cliente = clientesRepository.findById(id).get();

        return cliente;
    }

    @Override
    public ClientesResponseDom carregarClienteById(Long id) throws ProFutException {
        Clientes cliente = clientesRepository.findById(id).get();

        ClientesResponseDom out = ClientesMapper.clientesToClientesResponseDom(cliente);

        return out;
    }

    private List<String> validacaoManutencaoCliente(ClientesRequestDom cliente) {
        List<String> messages = new ArrayList<>();

        if(StringUtil.validarString(cliente.getNome())){
            messages.add("Campo sobrenome está vazio ou invalido!");
        }

        if(StringUtil.validarString(cliente.getSobreNome())){
            messages.add("Campo sobrenome está vazio ou invalido!");
        }

        if(StringUtil.validarString(cliente.getEmail())){
            messages.add("Campo email está vazio ou invalido!");
        }

        return messages;
    }
}
