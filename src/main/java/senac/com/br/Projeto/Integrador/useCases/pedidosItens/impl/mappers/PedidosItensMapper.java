package senac.com.br.Projeto.Integrador.useCases.pedidosItens.impl.mappers;

import senac.com.br.Projeto.Integrador.entitys.Pedidos;
import senac.com.br.Projeto.Integrador.entitys.PedidosItens;
import senac.com.br.Projeto.Integrador.entitys.Produtos;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.domanis.PedidosItensRequestDom;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.domanis.PedidosItensResponseDom;

public class PedidosItensMapper {

    public static PedidosItensResponseDom pedidosItensToPedidosItensResponseDom(PedidosItens pedidosItens) {
        PedidosItensResponseDom out = new PedidosItensResponseDom();
        out.setId(pedidosItens.getId());
        out.setQuantidade(pedidosItens.getQuantidade());
        out.setValorUnitario(pedidosItens.getValorUnitario());
        out.setPedidoId(pedidosItens.getPedidoId().getId());

        return out;
    }

    public static PedidosItens pedidosItensRequestDomToPedidosItens(PedidosItensRequestDom pedidosItens, Pedidos pedido, Produtos produto){
        PedidosItens out = new PedidosItens();
        out.setQuantidade(pedidosItens.getQuantidade());
        out.setValorUnitario(pedidosItens.getValorUnitario());
        out.setPedidoId(pedido);
        out.setProdutoId(produto);

        return out;
    }
}
