package senac.com.br.Projeto.Integrador.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import senac.com.br.Projeto.Integrador.frameWork.annotions.LogRest;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.frameWork.utils.ResponseUtil;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.domanis.PedidosItensRequestDom;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.domanis.PedidosItensResponseDom;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.impl.PedidosItensServiceImpl;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.impl.repositorys.PedidosItensRepository;

import java.util.List;

@Controller
@RequestMapping("/pedidos_itens")
public class PedidosItensController {

    @Autowired
    PedidosItensRepository pedidosItensRepository;

    @Autowired
    private PedidosItensServiceImpl pedidosItensService;

    @GetMapping("/carregar")
    @LogRest
    public ResponseEntity<List<PedidosItensResponseDom>> carregarPedidosItens() {
        List<PedidosItensResponseDom> out = pedidosItensService.carregarPedidosItens();

        return ResponseEntity.ok(out);
    }

    @PostMapping("/criar")
    @LogRest
    public ResponseEntity<?> criarPedidosItens(@RequestBody PedidosItensRequestDom pedidosItens) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(pedidosItensService.criarPedidosItens(pedidosItens));
        } catch (ProFutException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMapper(e.getMessages()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMapper("Erro não mapeado:" + e.getMessage()));
        }
    }

    @PutMapping("/atualizar/{id}")
    @LogRest
    public ResponseEntity<?> atualizarPedidosItens(@PathVariable Long id, @RequestBody PedidosItensRequestDom pedidosItens) {

        try {
            return ResponseEntity.ok(pedidosItensService.atualizarPedidosItens(id, pedidosItens));
        } catch (ProFutException senac) {
            senac.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMapper(senac.getMessages()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMapper("Erro não mapeado:" + e.getMessage()));
        }
    }

    @DeleteMapping("/deletar/{id}")
    @LogRest
    public ResponseEntity<?> deletarPedidoItens(@PathVariable Long id) {
        pedidosItensService.deletarPedidoItens(id);

        return ResponseEntity.ok(null);
    }
}
