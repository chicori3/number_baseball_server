package com.example.number_baseball_server.game.presentation;

import com.example.number_baseball_server.common.response.Response;
import com.example.number_baseball_server.game.application.GameFacade;
import com.example.number_baseball_server.game.application.command.GameAnswerCommand;
import com.example.number_baseball_server.game.presentation.request.GameAnswerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameFacade gameFacade;

    public GameController(GameFacade gameFacade) {
        this.gameFacade = gameFacade;
    }

    @PostMapping("/start")
    public ResponseEntity<Response> start() {
        var result = gameFacade.create();

        return new ResponseEntity<>(Response.success(result), HttpStatus.CREATED);
    }

    @PostMapping("/{roomId}/answer")
    public ResponseEntity<Response> progress(@PathVariable Long roomId, @RequestBody GameAnswerRequest request) {
        var result = gameFacade.guess(new GameAnswerCommand(roomId, request.answer()));

        return new ResponseEntity<>(Response.success(result), HttpStatus.OK);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<Response> result(@PathVariable Long roomId) {
        var result = gameFacade.result(roomId);

        return new ResponseEntity<>(Response.success(result), HttpStatus.OK);
    }
}
