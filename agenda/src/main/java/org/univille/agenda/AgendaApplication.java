package org.univille.agenda;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.univille.agenda.model.Agenda;
import org.univille.agenda.model.Curso;
import org.univille.agenda.model.Professor;
import org.univille.agenda.model.Turma;
import org.univille.agenda.repository.AgendaRepository;
import org.univille.agenda.repository.CursoRepository;
import org.univille.agenda.repository.ProfessorRepository;
import org.univille.agenda.repository.TurmaRepository;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class AgendaApplication {

	@Autowired
	private AgendaRepository agendaRepository;
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private ProfessorRepository professorRepository;
	@Autowired
	private TurmaRepository turmaRepository;

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(AgendaApplication.class, args);

		AgendaApplication agendaApplication = context.getBean(AgendaApplication.class);
		agendaApplication.insertData();
		agendaApplication.visualizar();
	}

	@Transactional
	public void insertData() {
		Agenda agenda1 = new Agenda();
		agenda1.setDia("05/05/2024");
		agenda1.setMateria("BDA-1");
		agenda1.setSala("A112");

		Professor professor1 = new Professor();
		professor1.setNome("Dornel");

		Turma turma1 = new Turma();
		turma1.setCodigo("355-4");
		turma1.setSemestre("5");

		Curso curso1 = new Curso();
		curso1.setNome("Sistemas");
		curso1.setAgenda(agenda1);
		curso1.setTurma(turma1);
		curso1.setProfessor(professor1);

		agendaRepository.save(agenda1);
		professorRepository.save(professor1);
		turmaRepository.save(turma1);
		cursoRepository.save(curso1);

		Agenda agenda2 = new Agenda();
		agenda2.setDia("07/05/2024");
		agenda2.setMateria("SO-2");
		agenda2.setSala("A110");

		Professor professor2 = new Professor();
		professor2.setNome("Marcelo P");

		Turma turma2 = new Turma();
		turma2.setCodigo("355-5");
		turma2.setSemestre("8");

		Curso curso2 = new Curso();
		curso2.setNome("Engenharia de Software");
		curso2.setAgenda(agenda2);
		curso2.setTurma(turma2);
		curso2.setProfessor(professor2);

		agendaRepository.save(agenda2);
		professorRepository.save(professor2);
		turmaRepository.save(turma2);
		cursoRepository.save(curso2);
	}
	@Transactional
	public List<Curso> visualizar(){
		return cursoRepository.findAll();
	}

}
