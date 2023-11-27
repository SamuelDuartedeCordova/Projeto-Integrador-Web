package senac.com.br.Projeto.Integrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import senac.com.br.Projeto.Integrador.frameWork.annotions.LogRest;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.frameWork.utils.ResponseUtil;
import senac.com.br.Projeto.Integrador.useCases.produtos.domanis.ProdutosRequestDom;
import senac.com.br.Projeto.Integrador.useCases.produtos.domanis.ProdutosResponseDom;
import senac.com.br.Projeto.Integrador.useCases.produtos.impl.ProdutosServiceImpl;
import senac.com.br.Projeto.Integrador.useCases.produtos.impl.repositorys.ProdutosRepository;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosRepository produtosRepository;

    @Autowired
    private ProdutosServiceImpl produtosService;


    @GetMapping("/carregar")
    @LogRest
    public ResponseEntity<List<ProdutosResponseDom>> carregarProdutos() {
        List<ProdutosResponseDom> out = produtosService.carregarProdutos();

        return ResponseEntity.ok(out);
    }

    @PostMapping("/criar")
    @LogRest
    public ResponseEntity<?> criarProdutos(@RequestBody ProdutosRequestDom produtos) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(produtosService.criarProdutos(produtos));
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
    public ResponseEntity<?> atualizarProdutos(@PathVariable Long id, @RequestBody ProdutosRequestDom produtos) {

        try {
            return ResponseEntity.ok(produtosService.atualizarProdutos(id, produtos));
        } catch (ProFutException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMapper(e.getMessages()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMapper("Erro não mapeado:" + e.getMessage()));
        }
    }

    @DeleteMapping("/deletar/{id}")
    @LogRest
    public ResponseEntity<?> deletarProdutos(@PathVariable Long id) {
        produtosService.deletarProdutos(id);

        return ResponseEntity.ok(null);
    }

}
