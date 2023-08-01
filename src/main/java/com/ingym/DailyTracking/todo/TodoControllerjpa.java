package com.ingym.DailyTracking.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerjpa {
	//private TodoService todoService;
	
public TodoControllerjpa(TodoRepositary todoRepository) {
		super();
		
		this.todoRepository= todoRepository;
	}


private TodoRepositary todoRepository;

@RequestMapping("List-todos")
public String listAllTodos(ModelMap model) {
	String username=getLoggedInUsername(model);
	
	
	List<Todo> todos=todoRepository.findByUsername(username);
	model.addAttribute("todos",todos);
	return "listTodos";
	
}


@RequestMapping(value="add-todo", method = RequestMethod.GET)
public String showTodoPage(ModelMap model) {
	String username=getLoggedInUsername(model);
	Todo todo =new Todo(0,username,"",LocalDate.now().plusYears(1),false);
	model.put("todo",todo);
	return "todo";
	
}
@RequestMapping(value="add-todo", method = RequestMethod.POST)
public String addnewTod(ModelMap model,@Valid Todo todo, BindingResult result) {
	if(result.hasErrors()) {
		return "todo";
	}
	String username=getLoggedInUsername(model);
	todo.setUsername(username);
	todoRepository.save(todo);
	//todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
	return "redirect:List-todos";
	
}
@RequestMapping("delete-todo")
public String deleteTodo(@RequestParam int id) {
	todoRepository.deleteById(id);
	return "redirect:List-todos";
	
}
@RequestMapping(value="update-todo",method=RequestMethod.GET)
public String ShowUpdateTodoPage(@RequestParam int id,ModelMap model) {
	Todo todo=todoRepository.findById(id).get();
	model.addAttribute("todo",todo);
	return "todo";
	
}
@RequestMapping(value="update-todo", method = RequestMethod.POST)
public String UpdateTod(ModelMap model,@Valid Todo todo, BindingResult result) {
	if(result.hasErrors()) {
		return "todo";
	}
	String username=getLoggedInUsername(model);
	todo.setUsername(username);
	todoRepository.save(todo);
//	todoService.updateTodo(todo);
	return "redirect:List-todos";
	
}


private String  getLoggedInUsername(ModelMap map) {
	 Authentication authentication =
	 SecurityContextHolder.getContext().getAuthentication();
    return authentication.getName();
}
}

