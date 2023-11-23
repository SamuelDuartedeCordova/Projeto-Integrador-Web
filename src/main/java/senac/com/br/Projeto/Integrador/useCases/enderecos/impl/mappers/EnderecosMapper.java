package senac.com.br.Projeto.Integrador.useCases.enderecos.impl.mappers;

import senac.com.br.Projeto.Integrador.entitys.Clientes;
import senac.com.br.Projeto.Integrador.entitys.Enderecos;
import senac.com.br.Projeto.Integrador.useCases.enderecos.domanis.EnderecosRequestDom;
import senac.com.br.Projeto.Integrador.useCases.enderecos.domanis.EnderecosResponseDom;

public class EnderecosMapper {

    public static EnderecosResponseDom enderecosToEnderecosResponseDom(Enderecos endereco){
        EnderecosResponseDom out = new EnderecosResponseDom();
        out.setId(endereco.getId());
        out.setBairro(endereco.getBairro());
        out.setCidade(endereco.getCidade());
        out.setRua(endereco.getRua());
        out.setEstado(endereco.getEstado());
        out.setComplemento(endereco.getComplemento());
        out.setNumero(endereco.getNumero());
        out.setClienteId(endereco.getCliente().getId());

        return out;
    }

    public static Enderecos enderecosResquestDomToEnderecos(EnderecosRequestDom enderecos, Clientes cliente){
        Enderecos out = new Enderecos();
        out.setBairro(enderecos.getBairro());
        out.setRua(enderecos.getRua());
        out.setCidade(enderecos.getCidade());
        out.setEstado(enderecos.getEstado());
        out.setComplemento(enderecos.getComplemento());
        out.setNumero(enderecos.getNumero());
        out.setCliente(cliente);

        return out;
    }
}
