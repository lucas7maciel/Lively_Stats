package com.example.springboot.request;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot.graph.Graph;
import com.example.springboot.graph.GraphService;
import com.example.springboot.user.User;
import com.example.springboot.user.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RequestService {
    // Ver autowired
    private final RequestRepo requestRepo;

    private final GraphService graphService;
    private final UserService userService;

    public List<Request> getAll() {
        log.info("Rodando getAll");
        log.info("{}", requestRepo.findAll());

        return requestRepo.findAll();
    }

    public Request getByInfo(String username, String animation) {
        return requestRepo.getByInfo(username, animation);
    }

    private Request createRequest(String animation, String username) {
        Request req = requestRepo.getByInfo(username, animation);

        if (req != null) {
            log.info("Achou");
            req.setCount(req.getCount() + 1);
            requestRepo.save(req);

            return req;
        }

        log.info("N achou");
        Graph graph = graphService.getByAnimation(animation);

        if (graph == null) {
            log.info("Falha ao achar gráfico");
            return null;
        }

        User user = userService.getByName(username);

        if (user == null) {
            log.info("Criando user pq n achou");
            user = userService.create(username);
        }

        req = new Request(graph, user);

        return requestRepo.save(req);
    }

    public Request makeRequest(String animation, String username) {
        Request req = getByInfo(username, animation);

        // Consertar isso
        if (req == null) {
            req = createRequest(animation, username);
        }

        if (req == null) {
            log.info("Erro ao fazer request");
            return null;
        }

        req.setCount(req.getCount() + 1);

        return requestRepo.save(req);
    }
}
