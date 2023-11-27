package senac.com.br.Projeto.Integrador.useCases.pedidos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.useCases.pedidos.PedidosService;
import senac.com.br.Projeto.Integrador.useCases.pedidos.domanis.PedidosRequestDom;
import senac.com.br.Projeto.Integrador.useCases.pedidos.domanis.PedidosResponseDom;

import java.util.List;


@Service
public class PedidosServiceImpl implements PedidosService {

    @Autowired
    private PedidosBusinessImpl pedidosBusiness;


    @Override
    public List<PedidosResponseDom> carregarPedidos() {
        return pedidosBusiness.carregarPedidos();
    }

    @Override
    public PedidosResponseDom criarPedidos(PedidosRequestDom pedido) throws ProFutException{
        return pedidosBusiness.criarPedidos(pedido);
    }

    @Override
    public PedidosResponseDom atualizarPedidos(Long id, PedidosRequestDom pedido) throws ProFutException {
        return pedidosBusiness.atualizarPedidos(id, pedido);
    }

    @Override
    public void deletarPedido(Long id) {
        pedidosBusiness.deletarPedido(id);
    }
}
