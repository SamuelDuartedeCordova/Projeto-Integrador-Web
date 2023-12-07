package senac.com.br.Projeto.Integrador.useCases.clientes.impl.mappers;

import senac.com.br.Projeto.Integrador.entitys.Clientes;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesRequestDom;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesResponseDom;


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


    public static Clientes clientesRequestDomToClientes(ClientesRequestDom cliente) {
        Clientes out = new Clientes();
        out.setNome(cliente.getNome());
        out.setSobrenome(cliente.getSobreNome());
        out.setEmail(cliente.getEmail());
        out.setSenha(cliente.getSenha());

        return out;
    }

}
