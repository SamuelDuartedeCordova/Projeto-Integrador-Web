package senac.com.br.Projeto.Integrador.useCases.clientes.impl.mappers;

import senac.com.br.Projeto.Integrador.entitys.Clientes;
import senac.com.br.Projeto.Integrador.entitys.Enderecos;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesEnderecosResponseDom;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesRequestDom;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesResponseDom;

import java.util.List;
import java.util.stream.Collectors;

public class ClientesMapper {

    public static ClientesResponseDom clientesToClientesResponseDom(Clientes cliente){
        ClientesResponseDom out = new ClientesResponseDom();
        out.setId(cliente.getId());
        out.setNome(cliente.getNome());
        out.setSobreNome(cliente.getSobrenome());
        out.setEmail(cliente.getEmail());
        out.setSenha(cliente.getSenha());

        return out;
    }
    public static ClientesResponseDom clientesToClientesResponseDom(Clientes clientes, List<Enderecos> enderecos){
        ClientesResponseDom out = ClientesMapper.clientesToClientesResponseDom(clientes);
        List<ClientesEnderecosResponseDom> enderecosResponseDomList = enderecos.stream()
                .map(ClientesMapper::enderecosToClientesEnderecosResponseDom)
                .collect(Collectors.toList());

        out.setEnderecos(enderecosResponseDomList);

        return out;
    }

    public static Clientes clientesRequestDomToClientes(ClientesRequestDom cliente) {
        Clientes out = new Clientes();
        out.setNome(cliente.getNome());
        out.setSobrenome(cliente.getSobreNome());
        out.setEmail(cliente.getEmail());
        out.setSenha(cliente.getSenha());

        return out;
    }

    public static ClientesEnderecosResponseDom enderecosToClientesEnderecosResponseDom(Enderecos endereco){
        ClientesEnderecosResponseDom out = new ClientesEnderecosResponseDom();
        out.setId(endereco.getId());
        out.setRua(endereco.getRua());
        out.setBairro(endereco.getBairro());
        out.setCidade(endereco.getCidade());
        out.setEstado(endereco.getEstado());
        out.setComplemento(endereco.getComplemento());
        out.setNumero(endereco.getNumero());

        return out;
    }
}
