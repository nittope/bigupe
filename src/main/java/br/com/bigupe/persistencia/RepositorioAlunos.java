/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bigupe.persistencia;

import br.com.bigupe.entidades.Aluno;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Marcus Vinicius
 */
public interface RepositorioAlunos extends CrudRepository<Aluno, Long> {
    
    public Aluno findByEmail (String email);
    public List<Aluno> findByDestino (String destino);
    public Aluno findByEmailAndSenha (String email, String senha);
    @Query("select Aluno a join a.viagens v where v.professor.nome = :nomeProfessor")
    public List<Aluno> buscarTuya (String nomeProfessor);
    
    
}
