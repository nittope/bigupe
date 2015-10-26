/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bigupe.ui;

import br.com.bigupe.entidades.Aluno;
import br.com.bigupe.negocios.AlunoExistenteException;
import br.com.bigupe.negocios.FachadaServicos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Marcus Vinicius
 */
@Controller
@RequestMapping("/bigupe")
public class ControllerAluno {
    @Autowired
    private FachadaServicos fachada;
    @RequestMapping("/hello/{nome}")
    public String hello(@PathVariable String nome){ 
        return "teste";
    }
    @RequestMapping(value = "/alunos/listar", method = RequestMethod.POST)
    public @ResponseBody List<Aluno> listarTodos(){
        return fachada.listarTodos();
    }
    @RequestMapping("/alunos/add")
    public ResponseEntity<?> addUser (Aluno aluno){
        try{ 
            fachada.cadastrar(aluno);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        catch(AlunoExistenteException alunoexistente){
            return new ResponseEntity<AlunoExistenteException>(alunoexistente, HttpStatus.BAD_REQUEST); 
            
        }
        
    }
}
