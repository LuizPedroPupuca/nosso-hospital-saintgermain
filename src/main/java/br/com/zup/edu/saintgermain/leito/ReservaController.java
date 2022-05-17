package br.com.zup.edu.saintgermain.leito;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/reserva-hospital")
public class ReservaController {

    @Autowired
    private LeitoRepository leitoRepository;

    @PostMapping
    public ResponseEntity cadastraReserva(@RequestBody @Valid ReservaLeitoRequest reservaLeitoRequest){
        Leito leito = reservaLeitoRequest.toModel();
        if(leito.getStatus().equals(StatusOcupacao.OCUPADO)){
            return ResponseEntity.unprocessableEntity().build();
        }
        leito.atualizaReservaParaOcupado();
        leitoRepository.save(leito);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/leito/{id}")
    public ResponseEntity atualizaReserva(@PathVariable Long id){
        Leito leito = leitoRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Leito não encontrado"));
        leito.atualizaReservaParaLivre();
        return ResponseEntity.ok().body(leitoRepository.save(leito));
    }
}