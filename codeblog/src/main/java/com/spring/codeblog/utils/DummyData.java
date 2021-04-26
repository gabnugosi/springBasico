package com.spring.codeblog.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;

@Component 
public class DummyData {
	@Autowired
	CodeblogRepository codeblogRepository;
	//Ao ativar a linha do PostConstruct a aplicação vai inserir os campos abaixo no banco
	//@PostConstruct
	public void savePosts() {
		List<Post> postList = new ArrayList<>();
		Post post1 = new Post();
		post1.setAutor("Carlinhos Brown");
		post1.setData(LocalDate.now());
		post1.setTitulo("DOCKER");
		post1.setTexto("Muita informação aqui!!!!!");
			
		Post post2 = new Post();
		post2.setAutor("Marcos Paiva");
		post2.setData(LocalDate.now());
		post2.setTitulo("API REST");
		post2.setTexto("Mais dados relevantes aqui fique atento");
		
		postList.add(post1);
		postList.add(post2);
		
		for (Post post : postList) {
			Post postSaved = codeblogRepository.save(post);
			System.out.println(postSaved.getId());
		}
	}
}
