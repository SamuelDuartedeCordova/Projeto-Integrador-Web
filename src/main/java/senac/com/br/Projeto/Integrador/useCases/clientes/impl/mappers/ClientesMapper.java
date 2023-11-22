package senac.com.br.Projeto.Integrador.useCases.clientes.impl.mappers;

import senac.com.br.Projeto.Integrador.entitys.Clientes;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesRequestDom;
import senac.com.br.Projeto.Integrador.useCases.clientes.domanis.ClientesResponseDom;

public class ClientesMapper {

    public static ClientesResponseDom clientesToClientesResponseDom(Clientes clientes){
        ClientesResponseDom out = new ClientesResponseDom();
        out.setId(clientes.getId());
        out.setNome(clientes.getNome());
        out.setSobreNome(clientes.getSobrenome());
        out.setEmail(clientes.getEmail());
        out.setSenha(clientes.getSenha());

        return out;
    }

    public static Clientes clientesRequestDomToClientes(ClientesRequestDom clientesRequestDom) {
        Clientes out = new Clientes();
        out.setNome(clientesRequestDom.getNome());
        out.setSobrenome(clientesRequestDom.getSobreNome());
        out.setEmail(clientesRequestDom.getEmail());
        out.setSenha(clientesRequestDom.getSenha());

        return out;
    }
}
