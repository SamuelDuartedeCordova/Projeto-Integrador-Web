package senac.com.br.Projeto.Integrador.useCases.pedidosItens;

import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.domanis.PedidosItensRequestDom;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.domanis.PedidosItensResponseDom;

import java.util.List;

public interface PedidosItensBusiness {
    List<PedidosItensResponseDom> carregarPedidosItens();
    PedidosItensResponseDom criarPedidosItens(PedidosItensRequestDom pedidoItens) throws ProFutException;
    PedidosItensResponseDom atualizarPedidosItens(Long id, PedidosItensRequestDom pedidosItens) throws ProFutException;
    void deletarPedidoItens(Long id);
}
