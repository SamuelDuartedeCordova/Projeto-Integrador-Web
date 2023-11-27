package senac.com.br.Projeto.Integrador.useCases.pedidos.impl.mappers;

import senac.com.br.Projeto.Integrador.entitys.Clientes;
import senac.com.br.Projeto.Integrador.entitys.Pedidos;
import senac.com.br.Projeto.Integrador.useCases.pedidos.domanis.PedidosRequestDom;
import senac.com.br.Projeto.Integrador.useCases.pedidos.domanis.PedidosResponseDom;

import java.time.LocalDateTime;

public class PedidosMapper {

    public static PedidosResponseDom pedidosToPedidosResponseDom(Pedidos pedidos){
        PedidosResponseDom out = new PedidosResponseDom();
        out.setId(pedidos.getId());
        out.setDataCriacao(pedidos.getDataCriacao());
        out.setDataEntrega(pedidos.getDataEntrega());
        out.setValorDesconto(pedidos.getValorDesconto());
        out.setClienteId(pedidos.getCliente().getId());

        return out;
    }

    public static Pedidos pedidosRequestDomToPedidos(PedidosRequestDom pedidos, Clientes cliente) {
        Pedidos out = new Pedidos();
        out.setDataCriacao(LocalDateTime.now());
        out.setDataEntrega(pedidos.getDataEntrega());
        out.setValorDesconto(pedidos.getValorDesconto());
        out.setCliente(cliente);

        return out;
    }
}
