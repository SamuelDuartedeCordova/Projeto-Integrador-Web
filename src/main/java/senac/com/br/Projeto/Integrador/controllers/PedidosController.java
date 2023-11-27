package senac.com.br.Projeto.Integrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import senac.com.br.Projeto.Integrador.frameWork.annotions.LogRest;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.frameWork.utils.ResponseUtil;
import senac.com.br.Projeto.Integrador.useCases.pedidos.domanis.PedidosRequestDom;
import senac.com.br.Projeto.Integrador.useCases.pedidos.domanis.PedidosResponseDom;
import senac.com.br.Projeto.Integrador.useCases.pedidos.impl.PedidosServiceImpl;
import senac.com.br.Projeto.Integrador.useCases.pedidos.impl.repositorys.PedidosRepository;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    PedidosRepository pedidosRepository;

    @Autowired
    private PedidosServiceImpl pedidosService;

    @GetMapping("/carregar")
    @LogRest
    public ResponseEntity<List<PedidosResponseDom>> carregarPedidos(){
        List<PedidosResponseDom> out = pedidosService.carregarPedidos();

        return ResponseEntity.ok(out);
    }

    @PostMapping("/criar")
    @LogRest
    public ResponseEntity<?> criarPedidos(@RequestBody PedidosRequestDom pedido){

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(pedidosService.criarPedidos(pedido));
        } catch (ProFutException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMapper(e.getMessages()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMapper("Erro não mapeado:" + e.getMessage()));
        }
    }

    @PutMapping("/atualizar/{id}")
    @LogRest
    public ResponseEntity<?> atualizarEndereco (@PathVariable Long id, @RequestBody PedidosRequestDom pedido){
        try {
            return ResponseEntity.ok(pedidosService.atualizarPedidos(id, pedido));
        } catch (ProFutException senac) {
            senac.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMapper(senac.getMessages()));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMapper("Erro não mapeado:" +e.getMessage()));
        }
    }

    @DeleteMapping("/deletar/{id}")
    @LogRest
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id){
        pedidosService.deletarPedido(id);

        return ResponseEntity.ok(null);
    }
}
