package com.example.the_best_quiz_ever.controllers;import com.example.the_best_quiz_ever.model_DTOs.ChoiceDTO;import com.example.the_best_quiz_ever.models.Quiz;import com.example.the_best_quiz_ever.model_DTOs.Reply;import com.example.the_best_quiz_ever.services.QuizService;// import jakarta.xml.ws.http.HTTPBinding;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.HttpStatus;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.*;import java.util.List;import java.util.Optional;@RestController@RequestMapping(value = "quizzes")public class QuizController {    @Autowired    QuizService quizService;    //maybe will have to autowire more classes    //    display available quizzes - GET    @GetMapping    public ResponseEntity<List<Quiz>> displayAllQuizzes() {        return new ResponseEntity<>(quizService.getAllQuizzes(), HttpStatus.OK);    }//* select quiz using id- GET//    return reply- display question 1 with options    @GetMapping(value = "/{id}") //change to post?    public ResponseEntity<Reply> newQuiz(@PathVariable Long id) {        return new ResponseEntity<>(quizService.startQuiz(id), HttpStatus.OK);    }//* choose option- PATCH, (request body letter)//        return reply -  answered questions message    @PatchMapping(value = "/{id}")    public ResponseEntity<Optional<Reply>> handleAnswer(@RequestBody ChoiceDTO choiceDTO, @PathVariable Long id){        return new ResponseEntity(quizService.processAnswer(choiceDTO.getAnswerId(), choiceDTO.getqNumber(), id), HttpStatus.OK);    }//    display question 2 with options//* continue for all 10 Qs//* after 10th: return reply: Outcome}