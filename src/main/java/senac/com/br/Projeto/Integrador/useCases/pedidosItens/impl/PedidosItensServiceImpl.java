package senac.com.br.Projeto.Integrador.useCases.pedidosItens.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.PedidosItensService;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.domanis.PedidosItensRequestDom;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.domanis.PedidosItensResponseDom;

import java.util.List;

@Service
public class PedidosItensServiceImpl implements PedidosItensService {

    @Autowired
    private PedidosItensBusinessImpl pedidosItensBusiness;


    @Override
    public List<PedidosItensResponseDom> carregarPedidosItens() {
        return pedidosItensBusiness.carregarPedidosItens();
    }

    @Override
    public PedidosItensResponseDom criarPedidosItens(PedidosItensRequestDom pedidoItens) throws ProFutException {
        return pedidosItensBusiness.criarPedidosItens(pedidoItens);
    }

    @Override
    public PedidosItensResponseDom atualizarPedidosItens(Long id, PedidosItensRequestDom pedidosItens) throws ProFutException {
        return pedidosItensBusiness.atualizarPedidosItens(id, pedidosItens);
    }

    @Override
    public void deletarPedidoItens(Long id) {
        pedidosItensBusiness.deletarPedidoItens(id);
    }
}
