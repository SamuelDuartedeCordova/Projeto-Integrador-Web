package senac.com.br.Projeto.Integrador.useCases.pedidos;

import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.useCases.pedidos.domanis.PedidosRequestDom;
import senac.com.br.Projeto.Integrador.useCases.pedidos.domanis.PedidosResponseDom;

import java.util.List;

public interface PedidosService {
    List<PedidosResponseDom> carregarPedidos();
    PedidosResponseDom criarPedidos(PedidosRequestDom pedido) throws ProFutException;
    PedidosResponseDom atualizarPedidos(Long id, PedidosRequestDom pedido) throws ProFutException;
    void deletarPedido(Long id);
    PedidosResponseDom carregarPedidoById(Long id) throws ProFutException;
}
